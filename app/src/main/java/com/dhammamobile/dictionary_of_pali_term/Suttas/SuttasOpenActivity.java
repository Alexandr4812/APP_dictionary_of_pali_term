package com.dhammamobile.dictionary_of_pali_term.Suttas;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.ColorStateList;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;
import android.graphics.Color;
import android.net.Uri;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.JavascriptInterface;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;
import android.widget.Toast;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

import org.json.JSONArray;
import org.json.JSONObject;

import java.io.File;
import java.io.FileOutputStream;
import java.io.IOException;
import java.io.InputStream;
import java.io.OutputStream;
import java.nio.charset.StandardCharsets;
import java.util.HashMap;
import java.util.Map;

public class SuttasOpenActivity extends BaseActivityClass {

    private TextView textViewLink;

    private static final String TAG = "SUTTA_DEBUG";
    private static final String DB_NAME = "suttapitaka_ru.db";
    private static final String ASSET_DB_PATH = "databases/" + DB_NAME;
    private static final String ASSET_DB_VERSION = "8.1";

    private static final String PREFS_NAME = "sutta_db_prefs";
    private static final String KEY_COPIED_DB_VERSION = "copied_db_version";

    private static final String BM_PREFS = "sutta_bookmarks_prefs";
    private static final String KEY_BOOKMARKS = "bookmarks_json";
    private static final String KEY_RECENTS = "recents_json";
    private static final int MAX_BOOKMARKS = 100;
    private static final int MAX_RECENTS = 10;

    private WebView webView;
    private ScrollView scrollView;
    private LinearLayout buttonLayout;
    private Button plusButton;
    private Button minusButton;

    private SQLiteDatabase db;
    private SuttaHtmlGenerator htmlGenerator;

    // mode: "menu" | "list" | "sutta" | "search" | "bookmarks" | "comment"
    private String currentNikaya = null;
    private String currentSuttaUid = null;
    private String mode = "menu";
    private String suttaReturnMode = "list";
    private String lastQuery = "";
    private String lastSearchHtml = "";

    private boolean randomMode = false;
    private int pendingScrollY = -1;
    private boolean bookmarksPagePending = false;
    private String pendingHighlight = null;

    // Текущий открытый комментарий: "att" | "tik" | null
    private String currentCommentKind = null;

    // Возврат из комментария в сутту с той же позиции
    private int savedSuttaScroll = 0;
    private String savedSuttaReturn = "list";

    private final Map<String, String> listStates = new HashMap<>();
    private String currentListNikaya = null;
    private String pendingListRestore = null;

    private float listFontSize = 12f;
    private float suttaFontSize = 16f;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suttas_open);

        enableEdgeToEdgeMode();

        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom);
            return insets;
        });

        webView = findViewById(R.id.webViewSuttasOpen);
        scrollView = findViewById(R.id.viewScrollSuttasOpen);
        buttonLayout = findViewById(R.id.button_layout_suttas_open);
        plusButton = findViewById(R.id.buttonPlusSuttasOpen);
        minusButton = findViewById(R.id.buttonMinusSuttasOpen);
        textViewLink = findViewById(R.id.textViewSuttasOpenAct);

        applyMenuTheme();

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setDefaultTextEncodingName("UTF-8");
        webView.clearCache(true);

        webView.addJavascriptInterface(new SearchBridge(), "AndroidSearch");
        webView.addJavascriptInterface(new BookmarkBridge(), "Android");

        if (textViewLink != null) {
            animateText(textViewLink, getString(R.string.openSuttas));
        }

        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, WebResourceRequest request) {
                String url = request.getUrl().toString();
                Log.d(TAG, "Клик: url = " + url);
                if (url.startsWith("sutta://")) {
                    String raw = url.substring("sutta://".length());
                    String highlight = null;
                    int cut = raw.indexOf('?');
                    if (cut >= 0) {
                        String params = raw.substring(cut + 1);
                        raw = raw.substring(0, cut);
                        for (String p : params.split("&")) {
                            if (p.startsWith("q=")) {
                                highlight = Uri.decode(p.substring(2));
                            }
                        }
                    }
                    cut = raw.indexOf('#');
                    if (cut >= 0) raw = raw.substring(0, cut);
                    String uid = Uri.decode(raw);
                    pendingHighlight = (highlight != null && !highlight.trim().isEmpty())
                            ? highlight.trim() : null;
                    openSuttaByUid(uid);
                    return true;
                }
                return super.shouldOverrideUrlLoading(view, request);
            }

            @Override
            public void onPageFinished(WebView view, String url) {
                try {
                    if (bookmarksPagePending) {
                        bookmarksPagePending = false;
                        view.evaluateJavascript(
                                "loadData(" + jsString(getPref(KEY_BOOKMARKS, "[]")) + ", "
                                        + jsString(getPref(KEY_RECENTS, "[]")) + ")",
                                null);
                    }
                    if ("list".equals(mode) && pendingListRestore != null) {
                        final String st = pendingListRestore;
                        pendingListRestore = null;
                        view.evaluateJavascript("restoreState(" + jsString(st) + ")", null);
                    }
                    if (pendingScrollY >= 0) {
                        final int y = pendingScrollY;
                        pendingScrollY = -1;
                        view.evaluateJavascript("window.scrollTo(0," + y + ")", null);
                    }
                    if (pendingHighlight != null) {
                        final String h = pendingHighlight;
                        pendingHighlight = null;
                        view.evaluateJavascript("highlightQuery(" + jsString(h) + ")", null);
                    }
                    if ("sutta".equals(mode) && currentSuttaUid != null) {
                        view.evaluateJavascript(
                                "setBookmarkState(" + isBookmarked(currentSuttaUid) + ")", null);
                        view.evaluateJavascript(
                                "setRandomMode(" + randomMode + ")", null);
                    }
                    if ("comment".equals(mode) && currentSuttaUid != null
                            && currentCommentKind != null) {
                        view.evaluateJavascript(
                                "setBookmarkState("
                                        + isCommentBookmarked(currentSuttaUid, currentCommentKind)
                                        + ")", null);
                    }
                    if ("list".equals(mode) || "search".equals(mode)
                            || "sutta".equals(mode) || "comment".equals(mode)) {
                        applyFontSize();
                    }
                } catch (Exception e) {
                    Log.e(TAG, "onPageFinished error", e);
                }
            }
        });

        plusButton.setOnClickListener(v -> changeFontSize(1f));
        minusButton.setOnClickListener(v -> changeFontSize(-1f));

        try {
            openDatabase();
            htmlGenerator = new SuttaHtmlGenerator(this);
        } catch (IOException e) {
            e.printStackTrace();
        }

        getOnBackPressedDispatcher().addCallback(this,
                new androidx.activity.OnBackPressedCallback(true) {
                    @Override
                    public void handleOnBackPressed() {
                        handleBack();
                    }
                });
    }

    private void animateText(TextView targetTextView, String textToAnimate) {
        ValueAnimator animator = ValueAnimator.ofInt(0, textToAnimate.length());
        animator.setDuration(2000);
        animator.addUpdateListener(animation -> {
            int animatedValue = (int) animation.getAnimatedValue();
            targetTextView.setText(textToAnimate.substring(0, animatedValue));
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
            }
        });
        animator.start();
    }

    // ============================================================
    // ТЕМА МЕНЮ
    // ============================================================
    private void applyMenuTheme() {
        int bg = Color.parseColor("#161923");
        int card = Color.parseColor("#232A3A");
        int yellow = Color.parseColor("#FFE082");
        int salmon = Color.parseColor("#FFAB91");
        int green = Color.parseColor("#66BB6A");
        int textDark = Color.parseColor("#161923");

        View main = findViewById(R.id.main);
        if (main != null) main.setBackgroundColor(bg);
        scrollView.setBackgroundColor(bg);
        LinearLayout menu = findViewById(R.id.linearLayoutScrollSuttasOpen);
        if (menu != null) menu.setBackgroundColor(bg);
        if (buttonLayout != null) buttonLayout.setBackgroundColor(Color.TRANSPARENT);

        int[] nikayaBtns = {
                R.id.button_suttas_open_digha,
                R.id.button_suttas_open_majhima,
                R.id.button_suttas_open_sanutta,
                R.id.button_suttas_open_anguttara,
                R.id.button_suttas_open_kuddaka
        };
        for (int id : nikayaBtns) {
            Button b = findViewById(id);
            if (b != null) {
                ViewCompat.setBackgroundTintList(b, ColorStateList.valueOf(yellow));
                b.setTextColor(textDark);
            }
        }
        int[] accentBtns = {
                R.id.button_suttas_open_search,
                R.id.button_suttas_open_random_sutta
        };
        for (int id : accentBtns) {
            Button b = findViewById(id);
            if (b != null) {
                ViewCompat.setBackgroundTintList(b, ColorStateList.valueOf(salmon));
                b.setTextColor(textDark);
            }
        }
        Button bmBtn = findViewById(R.id.button_suttas_open_bookmarks);
        if (bmBtn != null) {
            ViewCompat.setBackgroundTintList(bmBtn, ColorStateList.valueOf(green));
            bmBtn.setTextColor(textDark);
        }
        ViewCompat.setBackgroundTintList(plusButton, ColorStateList.valueOf(card));
        plusButton.setTextColor(yellow);
        ViewCompat.setBackgroundTintList(minusButton, ColorStateList.valueOf(card));
        minusButton.setTextColor(yellow);
        ImageButton back = findViewById(R.id.backButton);
        if (back != null) {
            ViewCompat.setBackgroundTintList(back, ColorStateList.valueOf(bg));
        }
    }

    // ============================================================
    // БАЗА ДАННЫХ
    // ============================================================
    private void openDatabase() throws IOException {
        File dbFile = getDatabasePath(DB_NAME);
        String copiedVersion = getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
                .getString(KEY_COPIED_DB_VERSION, "");
        boolean needCopy = !dbFile.exists()
                || !ASSET_DB_VERSION.equals(copiedVersion);
        if (needCopy) {
            Log.d(TAG, "Копирую базу из assets, версия " + ASSET_DB_VERSION);
            if (dbFile.exists()) {
                dbFile.delete();
            }
            copyDatabaseFromAssets(dbFile);
            getSharedPreferences(PREFS_NAME, MODE_PRIVATE)
                    .edit()
                    .putString(KEY_COPIED_DB_VERSION, ASSET_DB_VERSION)
                    .apply();
        } else {
            Log.d(TAG, "Использую уже скопированную базу, версия " + copiedVersion);
        }
        db = SQLiteDatabase.openDatabase(
                dbFile.getAbsolutePath(),
                null,
                SQLiteDatabase.OPEN_READONLY
        );
    }

    private void copyDatabaseFromAssets(File dbFile) throws IOException {
        File parent = dbFile.getParentFile();
        if (parent != null && !parent.exists()) {
            parent.mkdirs();
        }
        InputStream in = getAssets().open(ASSET_DB_PATH);
        OutputStream out = new FileOutputStream(dbFile);
        byte[] buffer = new byte[8192];
        int length;
        while ((length = in.read(buffer)) > 0) {
            out.write(buffer, 0, length);
        }
        out.flush();
        out.close();
        in.close();
    }

    // ============================================================
    // НАВИГАЦИЯ
    // ============================================================
    private void showMainMenu() {
        currentNikaya = null;
        currentSuttaUid = null;
        currentCommentKind = null;
        mode = "menu";
        randomMode = false;
        lastSearchHtml = "";
        scrollView.setVisibility(View.VISIBLE);
        webView.setVisibility(View.INVISIBLE);
        buttonLayout.setVisibility(View.INVISIBLE);
    }

    private void openNikayaList(String nikaya) {
        if (nikaya == null) {
            showMainMenu();
            return;
        }
        currentNikaya = nikaya;
        currentListNikaya = nikaya;
        currentSuttaUid = null;
        mode = "list";
        pendingListRestore = listStates.get(nikaya);
        listFontSize = 12f;
        try {
            String html = htmlGenerator.generateSuttasListHtml(db, nikaya);
            webView.loadDataWithBaseURL("sutta://base/", html, "text/html", "UTF-8", null);
            scrollView.setVisibility(View.INVISIBLE);
            webView.setVisibility(View.VISIBLE);
            buttonLayout.setVisibility(View.VISIBLE);
            applyFontSize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void openSuttaByUid(String uid) {
        suttaReturnMode = mode;
        currentSuttaUid = uid;
        currentCommentKind = null;
        mode = "sutta";
        randomMode = false;
        try {
            String html = htmlGenerator.generateSuttaTextHtml(db, uid);
            webView.loadDataWithBaseURL("sutta://base/", html, "text/html", "UTF-8", null);
            webView.scrollTo(0, 0);
            scrollView.setVisibility(View.INVISIBLE);
            webView.setVisibility(View.VISIBLE);
            buttonLayout.setVisibility(View.VISIBLE);
            applyFontSize();
            addRecent(uid);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showSearchPage(String query) {
        lastQuery = query;
        currentSuttaUid = null;
        mode = "search";
        listFontSize = 12f;
        try {
            String template = readAssetTemplate("templates/search_page.html");
            String resultsHtml = "";
            if (query != null && !query.isEmpty()
                    && lastSearchHtml != null && !lastSearchHtml.isEmpty()) {
                resultsHtml = lastSearchHtml;
            }
            String html = template
                    .replace("{{QUERY}}", escapeHtml(query == null ? "" : query))
                    .replace("{{RESULTS}}", resultsHtml);
            webView.loadDataWithBaseURL("sutta://base/", html, "text/html", "UTF-8", null);
            scrollView.setVisibility(View.INVISIBLE);
            webView.setVisibility(View.VISIBLE);
            buttonLayout.setVisibility(View.VISIBLE);
            applyFontSize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private void showBookmarksPage() {
        currentSuttaUid = null;
        mode = "bookmarks";
        try {
            String html = readAssetTemplate("templates/bookmarks_page.html");
            bookmarksPagePending = true;
            webView.loadDataWithBaseURL("sutta://base/", html, "text/html", "UTF-8", null);
            scrollView.setVisibility(View.INVISIBLE);
            webView.setVisibility(View.VISIBLE);
            buttonLayout.setVisibility(View.INVISIBLE);
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    // ============================================================
    // КОММЕНТАРИИ (Аттхакатха / Тика)
    // ============================================================
    private void openCommentNow(final String kind) {
        if (db == null || currentSuttaUid == null) return;
        final String uid = currentSuttaUid;
        Cursor c = db.rawQuery(
                "SELECT title, content FROM comments WHERE kind = ? AND ref = ?",
                new String[]{kind, uid});
        if (!c.moveToFirst()) {
            c.close();
            Toast.makeText(this, "К этой сутте комментария нет",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        final String ctitle = c.getString(0);
        final String ccontent = c.getString(1);
        c.close();
        webView.evaluateJavascript("window.scrollY", value -> runOnUiThread(() -> {
            int y = 0;
            try {
                y = (int) Float.parseFloat(value);
            } catch (Exception e) {
                y = 0;
            }
            savedSuttaScroll = y;
            savedSuttaReturn = suttaReturnMode;
            currentCommentKind = kind;
            showComment(kind, ctitle, ccontent, uid);
        }));
    }

    private void openCommentFromBookmark(String uid, String kind, int scrollY) {
        if (db == null || uid == null) return;
        Cursor c = db.rawQuery(
                "SELECT title, content FROM comments WHERE kind = ? AND ref = ?",
                new String[]{kind, uid});
        if (!c.moveToFirst()) {
            c.close();
            Toast.makeText(this, "Комментарий не найден",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        String ctitle = c.getString(0);
        String ccontent = c.getString(1);
        c.close();
        savedSuttaScroll = 0;
        savedSuttaReturn = "bookmarks";
        pendingScrollY = scrollY;
        pendingHighlight = null;
        currentCommentKind = kind;
        showComment(kind, ctitle, ccontent, uid);
    }

    private void showComment(String kind, String ctitle, String content, String uid) {
        mode = "comment";
        currentSuttaUid = uid;
        currentCommentKind = kind;
        try {
            String template = readAssetTemplate("templates/comment_page.html");
            String kindTitle = "att".equals(kind)
                    ? "Аттхакатха (комментарий)"
                    : "Тика (субкомментарий)";
            String stitle = "";
            Cursor sc = db.rawQuery(
                    "SELECT title FROM suttas WHERE uid = ?", new String[]{uid});
            if (sc.moveToFirst()) {
                stitle = sc.getString(0);
            }
            sc.close();
            String html = template
                    .replace("{{COMMENT_KIND}}", escapeHtml(kindTitle))
                    .replace("{{SUTTA_TITLE}}", escapeHtml(stitle))
                    .replace("{{SUTTA_UID}}", escapeHtml(uid.toUpperCase()))
                    .replace("{{CONTENT}}", formatParagraphs(content));
            webView.loadDataWithBaseURL("sutta://base/", html, "text/html", "UTF-8", null);
            webView.scrollTo(0, 0);
            scrollView.setVisibility(View.INVISIBLE);
            webView.setVisibility(View.VISIBLE);
            buttonLayout.setVisibility(View.VISIBLE);
            applyFontSize();
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String formatParagraphs(String raw) {
        if (raw == null || raw.isEmpty()) {
            return "<p></p>";
        }
        StringBuilder html = new StringBuilder();
        for (String line : raw.split("\n")) {
            String trimmed = line.trim();
            if (trimmed.isEmpty()) {
                continue;
            }
            html.append("<p>").append(escapeHtml(trimmed)).append("</p>\n");
        }
        return html.toString();
    }

    // ============================================================
    // ЛИСТАНИЕ СУТТ И КОММЕНТАРИЕВ (❮ / ❯)
    // ============================================================
    private void stepSutta(boolean next) {
        String uid = adjacentSuttaUid(currentSuttaUid, next);
        if (uid == null) {
            Toast.makeText(this,
                    next ? "Это последняя сутта в никае" : "Это первая сутта в никае",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        // НОВОЕ: сохраняем режим рандома и режим возврата, чтобы кубик 🎲 не пропадал
        boolean keepRandom = randomMode;
        String keepReturn = suttaReturnMode;
        openSuttaByUid(uid);
        suttaReturnMode = keepReturn;
        randomMode = keepRandom;
    }

    private void stepComment(boolean next) {
        String uid = adjacentCommentUid(currentSuttaUid, currentCommentKind, next);
        if (uid == null) {
            Toast.makeText(this,
                    next ? "Дальше комментариев нет" : "Раньше комментариев нет",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        openCommentForUid(uid, currentCommentKind);
    }

    private void openCommentForUid(String uid, String kind) {
        if (db == null || uid == null || kind == null) return;
        Cursor c = db.rawQuery(
                "SELECT title, content FROM comments WHERE kind = ? AND ref = ?",
                new String[]{kind, uid});
        if (!c.moveToFirst()) {
            c.close();
            Toast.makeText(this, "У этой сутты комментария нет",
                    Toast.LENGTH_SHORT).show();
            return;
        }
        String ctitle = c.getString(0);
        String ccontent = c.getString(1);
        c.close();
        savedSuttaScroll = 0;
        savedSuttaReturn = suttaReturnMode;
        showComment(kind, ctitle, ccontent, uid);
    }

    private String adjacentSuttaUid(String uid, boolean next) {
        if (db == null || uid == null) return null;
        Cursor c = db.rawQuery(
                "SELECT nikaya, canonical_number, local_number, id FROM suttas WHERE uid = ?",
                new String[]{uid});
        if (!c.moveToFirst()) { c.close(); return null; }
        String nik = c.getString(0);
        int cn = c.getInt(1);
        int ln = c.getInt(2);
        int id = c.getInt(3);
        c.close();
        String cmp = next ? ">" : "<";
        String dir = next ? "ASC" : "DESC";
        String sql = "SELECT uid FROM suttas WHERE nikaya = ? AND ("
                + "canonical_number " + cmp + " ? "
                + "OR (canonical_number = ? AND local_number " + cmp + " ?) "
                + "OR (canonical_number = ? AND local_number = ? AND id " + cmp + " ?)) "
                + "ORDER BY canonical_number " + dir + ", local_number " + dir + ", id " + dir
                + " LIMIT 1";
        Cursor c2 = db.rawQuery(sql, new String[]{
                nik,
                String.valueOf(cn), String.valueOf(cn), String.valueOf(ln),
                String.valueOf(cn), String.valueOf(ln), String.valueOf(id)});
        String res = c2.moveToFirst() ? c2.getString(0) : null;
        c2.close();
        return res;
    }

    private String adjacentCommentUid(String uid, String kind, boolean next) {
        if (db == null || uid == null || kind == null) return null;
        Cursor c = db.rawQuery(
                "SELECT nikaya, canonical_number, local_number, id FROM suttas WHERE uid = ?",
                new String[]{uid});
        if (!c.moveToFirst()) { c.close(); return null; }
        String nik = c.getString(0);
        int cn = c.getInt(1);
        int ln = c.getInt(2);
        int id = c.getInt(3);
        c.close();
        String cmp = next ? ">" : "<";
        String dir = next ? "ASC" : "DESC";
        String sql = "SELECT c.ref FROM comments c JOIN suttas s ON s.uid = c.ref "
                + "WHERE c.kind = ? AND s.nikaya = ? AND ("
                + "s.canonical_number " + cmp + " ? "
                + "OR (s.canonical_number = ? AND s.local_number " + cmp + " ?) "
                + "OR (s.canonical_number = ? AND s.local_number = ? AND s.id " + cmp + " ?)) "
                + "ORDER BY s.canonical_number " + dir + ", s.local_number " + dir + ", s.id " + dir
                + " LIMIT 1";
        Cursor c2 = db.rawQuery(sql, new String[]{
                kind, nik,
                String.valueOf(cn), String.valueOf(cn), String.valueOf(ln),
                String.valueOf(cn), String.valueOf(ln), String.valueOf(id)});
        String res = c2.moveToFirst() ? c2.getString(0) : null;
        c2.close();
        return res;
    }

    // ============================================================
    // КНОПКА "НАЗАД"
    // ============================================================
    private void handleBack() {
        if (mode.equals("comment")) {
            String ret = savedSuttaReturn;
            // НОВОЕ: сохраняем режим рандома, чтобы кубик 🎲 не пропадал после комментария
            boolean keepRandom = randomMode;
            pendingScrollY = savedSuttaScroll;
            openSuttaByUid(currentSuttaUid);
            suttaReturnMode = ret;
            randomMode = keepRandom;
        } else if (mode.equals("sutta")) {
            if (randomMode) {
                showMainMenu();
            } else if (suttaReturnMode.equals("search")) {
                showSearchPage(lastQuery);
            } else if (suttaReturnMode.equals("bookmarks")) {
                showBookmarksPage();
            } else if (suttaReturnMode.equals("list") && currentNikaya != null) {
                openNikayaList(currentNikaya);
            } else {
                showMainMenu();
            }
        } else if (mode.equals("search") || mode.equals("list") || mode.equals("bookmarks")) {
            showMainMenu();
        } else {
            startIntentActivityAndFinish(MainActivity.class);
        }
    }

    // ============================================================
    // ШРИФТ
    // ============================================================
    private float clampFont(float v) {
        if (v < 12f) v = 12f;
        if (v > 28f) v = 28f;
        return v;
    }

    private void changeFontSize(float delta) {
        if ("list".equals(mode) || "search".equals(mode)) {
            listFontSize = clampFont(listFontSize + delta);
        } else {
            suttaFontSize = clampFont(suttaFontSize + delta);
        }
        applyFontSize();
    }

    private void applyFontSize() {
        float size = ("list".equals(mode) || "search".equals(mode))
                ? listFontSize
                : suttaFontSize;
        webView.evaluateJavascript("setFontSize(" + size + ")", null);
    }

    // ============================================================
    // ПОИСК
    // ============================================================
    public class SearchBridge {
        @JavascriptInterface
        public String search(String query) {
            try {
                String result = doSearch(query);
                lastQuery = query;
                try {
                    JSONObject obj = new JSONObject(result);
                    lastSearchHtml = obj.optString("html", "");
                } catch (Exception e) {
                    lastSearchHtml = "";
                }
                return result;
            } catch (Exception e) {
                Log.e(TAG, "Ошибка поиска", e);
                return "{\"count\":0,\"html\":\"<p>Ошибка поиска</p>\"}";
            }
        }
    }

    private String doSearch(String query) throws Exception {
        if (db == null) return "{\"count\":0,\"html\":\"\"}";
        String match = buildMatch(query);
        if (match.isEmpty()) return "{\"count\":0,\"html\":\"\"}";
        String qEnc = (query == null) ? "" : Uri.encode(query.trim());
        Cursor c = db.rawQuery(
                "SELECT s.uid, s.nikaya, s.title, " +
                        "snippet(suttas_fts, '\u0001', '\u0002', ' … ', -1, 12) " +
                        "FROM suttas_fts " +
                        "JOIN suttas s ON s.id = suttas_fts.docid " +
                        "WHERE suttas_fts MATCH ? " +
                        "LIMIT 300",
                new String[]{match});
        StringBuilder html = new StringBuilder();
        int count = 0;
        while (c.moveToNext()) {
            count++;
            String uid = c.getString(0);
            String nikaya = c.getString(1);
            String title = c.getString(2);
            String snippet = c.getString(3);
            String snipEsc = escapeHtml(snippet == null ? "" : snippet)
                    .replace("\u0001", "<b>")
                    .replace("\u0002", "</b>");
            html.append("<a class=\"sutta-item\" href=\"sutta://").append(uid);
            if (!qEnc.isEmpty()) {
                html.append("?q=").append(qEnc);
            }
            html.append("\">")
                    .append("<span class=\"sutta-uid\">").append(escapeHtml(nikaya)).append("</span>")
                    .append("<span class=\"sutta-title\">").append(escapeHtml(title)).append("</span>")
                    .append("<div class=\"search-snippet\">").append(snipEsc).append("</div>")
                    .append("</a>");
        }
        c.close();
        JSONObject o = new JSONObject();
        o.put("count", count);
        if (count > 0) {
            o.put("html", html.toString());
        } else {
            o.put("html", "<p class=\"search-count\">Ничего не найдено. Попробуйте другой запрос или короче слово.</p>");
        }
        return o.toString();
    }

    private String buildMatch(String query) {
        if (query == null) return "";
        String s = query.replaceAll("[\"\\^\\*\\(\\)\\{\\}\\[\\]:;,@#=/\\\\!\\+\\-~]", " ");
        s = s.replaceAll("\\s+", " ").trim();
        if (s.isEmpty()) return "";
        String[] tokens = s.split(" ");
        StringBuilder sb = new StringBuilder();
        for (String t : tokens) {
            if (t.length() < 1) continue;
            sb.append(t).append("* ");
        }
        return sb.toString().trim();
    }

    // ============================================================
    // МОСТ ЗАКЛАДОК / КОММЕНТАРИЕВ / СПИСКОВ / ЛИСТАНИЯ
    // ============================================================
    public class BookmarkBridge {
        @JavascriptInterface
        public void goBack() {
            runOnUiThread(() -> handleBack());
        }

        @JavascriptInterface
        public void openBookmark(final String uid, final int scrollY,
                                 final String type, final String kind) {
            runOnUiThread(() -> {
                pendingHighlight = null;
                if ("comment".equals(type)) {
                    openCommentFromBookmark(uid, kind, scrollY);
                } else {
                    pendingScrollY = scrollY;
                    suttaReturnMode = "bookmarks";
                    openSuttaByUid(uid);
                }
            });
        }

        @JavascriptInterface
        public void nextRandom() {
            runOnUiThread(() -> openRandomSutta());
        }

        @JavascriptInterface
        public void openComment(final String kind) {
            runOnUiThread(() -> openCommentNow(kind));
        }

        @JavascriptInterface
        public void openPrevSutta() {
            runOnUiThread(() -> stepSutta(false));
        }

        @JavascriptInterface
        public void openNextSutta() {
            runOnUiThread(() -> stepSutta(true));
        }

        @JavascriptInterface
        public void openPrevComment() {
            runOnUiThread(() -> stepComment(false));
        }

        @JavascriptInterface
        public void openNextComment() {
            runOnUiThread(() -> stepComment(true));
        }

        @JavascriptInterface
        public void saveListState(final String json) {
            runOnUiThread(() -> {
                if (currentListNikaya != null && json != null) {
                    listStates.put(currentListNikaya, json);
                }
            });
        }

        @JavascriptInterface
        public void toggleBookmark(final int scrollY) {
            runOnUiThread(() -> {
                String uid = currentSuttaUid;
                if (uid == null) return;
                if (isBookmarked(uid)) {
                    removeBookmarkByUid(uid);
                    webView.evaluateJavascript("setBookmarkState(false)", null);
                    Toast.makeText(SuttasOpenActivity.this,
                            "Закладка удалена", Toast.LENGTH_SHORT).show();
                } else {
                    addBookmarkNow(uid, scrollY);
                    webView.evaluateJavascript("setBookmarkState(true)", null);
                    Toast.makeText(SuttasOpenActivity.this,
                            "Закладка добавлена", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @JavascriptInterface
        public void toggleCommentBookmark(final int scrollY) {
            runOnUiThread(() -> {
                String uid = currentSuttaUid;
                String kind = currentCommentKind;
                if (uid == null || kind == null) return;
                if (isCommentBookmarked(uid, kind)) {
                    removeCommentBookmark(uid, kind);
                    webView.evaluateJavascript("setBookmarkState(false)", null);
                    Toast.makeText(SuttasOpenActivity.this,
                            "Закладка удалена", Toast.LENGTH_SHORT).show();
                } else {
                    addCommentBookmark(uid, kind, scrollY);
                    webView.evaluateJavascript("setBookmarkState(true)", null);
                    Toast.makeText(SuttasOpenActivity.this,
                            "Закладка добавлена", Toast.LENGTH_SHORT).show();
                }
            });
        }

        @JavascriptInterface
        public void deleteBookmark(final String id) {
            runOnUiThread(() -> {
                try {
                    JSONArray arr = new JSONArray(getPref(KEY_BOOKMARKS, "[]"));
                    JSONArray out = new JSONArray();
                    for (int i = 0; i < arr.length(); i++) {
                        JSONObject it = arr.getJSONObject(i);
                        if (!id.equals(it.optString("id"))) out.put(it);
                    }
                    putPref(KEY_BOOKMARKS, out.toString());
                } catch (Exception e) {
                    Log.e(TAG, "deleteBookmark", e);
                }
            });
        }

        @JavascriptInterface
        public void clearBookmarks() {
            runOnUiThread(() -> putPref(KEY_BOOKMARKS, "[]"));
        }

        @JavascriptInterface
        public void clearRecents() {
            runOnUiThread(() -> putPref(KEY_RECENTS, "[]"));
        }

        @JavascriptInterface
        public void updateBookmarkNote(final String id, final String note) {
            runOnUiThread(() -> updateBookmarkField(id, "note", note));
        }

        @JavascriptInterface
        public void updateBookmarkTitle(final String id, final String title) {
            runOnUiThread(() -> updateBookmarkField(id, "title", title));
        }
    }

    // ============================================================
    // ЗАКЛАДКИ: ХРАНИЛИЩЕ
    // ============================================================
    private String getPref(String key, String def) {
        return getSharedPreferences(BM_PREFS, MODE_PRIVATE).getString(key, def);
    }

    private void putPref(String key, String val) {
        getSharedPreferences(BM_PREFS, MODE_PRIVATE).edit().putString(key, val).apply();
    }

    private String jsString(String s) {
        if (s == null) s = "";
        return "'" + s.replace("\\", "\\\\").replace("'", "\\'")
                .replace("\n", "\\n").replace("\r", "\\r") + "'";
    }

    private boolean isBookmarked(String uid) {
        try {
            JSONArray arr = new JSONArray(getPref(KEY_BOOKMARKS, "[]"));
            for (int i = 0; i < arr.length(); i++) {
                JSONObject it = arr.getJSONObject(i);
                if (!"comment".equals(it.optString("type"))
                        && uid.equals(it.optString("filePath"))) return true;
            }
        } catch (Exception e) { }
        return false;
    }

    private void removeBookmarkByUid(String uid) {
        try {
            JSONArray arr = new JSONArray(getPref(KEY_BOOKMARKS, "[]"));
            JSONArray out = new JSONArray();
            for (int i = 0; i < arr.length(); i++) {
                JSONObject it = arr.getJSONObject(i);
                if (!(!"comment".equals(it.optString("type"))
                        && uid.equals(it.optString("filePath")))) out.put(it);
            }
            putPref(KEY_BOOKMARKS, out.toString());
        } catch (Exception e) { }
    }

    private void addBookmarkNow(String uid, int scrollY) {
        try {
            JSONObject meta = buildSuttaMetaJson(uid);
            if (meta == null) return;
            JSONArray arr = new JSONArray(getPref(KEY_BOOKMARKS, "[]"));
            JSONArray out = new JSONArray();
            JSONObject bm = new JSONObject();
            bm.put("id", String.valueOf(System.currentTimeMillis()));
            bm.put("type", "sutta");
            bm.put("filePath", uid);
            bm.put("title", meta.optString("title"));
            bm.put("subtitle", meta.optString("subtitle"));
            bm.put("scrollY", scrollY);
            bm.put("date", System.currentTimeMillis());
            bm.put("note", "");
            out.put(bm);
            for (int i = 0; i < arr.length() && out.length() < MAX_BOOKMARKS; i++) {
                JSONObject it = arr.getJSONObject(i);
                if (!(!"comment".equals(it.optString("type"))
                        && uid.equals(it.optString("filePath")))) out.put(it);
            }
            putPref(KEY_BOOKMARKS, out.toString());
        } catch (Exception e) {
            Log.e(TAG, "addBookmarkNow", e);
        }
    }

    private boolean isCommentBookmarked(String uid, String kind) {
        try {
            JSONArray arr = new JSONArray(getPref(KEY_BOOKMARKS, "[]"));
            for (int i = 0; i < arr.length(); i++) {
                JSONObject it = arr.getJSONObject(i);
                if ("comment".equals(it.optString("type"))
                        && kind.equals(it.optString("kind"))
                        && uid.equals(it.optString("filePath"))) return true;
            }
        } catch (Exception e) { }
        return false;
    }

    private void removeCommentBookmark(String uid, String kind) {
        try {
            JSONArray arr = new JSONArray(getPref(KEY_BOOKMARKS, "[]"));
            JSONArray out = new JSONArray();
            for (int i = 0; i < arr.length(); i++) {
                JSONObject it = arr.getJSONObject(i);
                if (!("comment".equals(it.optString("type"))
                        && kind.equals(it.optString("kind"))
                        && uid.equals(it.optString("filePath")))) out.put(it);
            }
            putPref(KEY_BOOKMARKS, out.toString());
        } catch (Exception e) { }
    }

    private void addCommentBookmark(String uid, String kind, int scrollY) {
        try {
            JSONObject meta = buildSuttaMetaJson(uid);
            if (meta == null) return;
            String kindLabel = "tik".equals(kind) ? "Тика" : "Аттхакатха";
            JSONArray arr = new JSONArray(getPref(KEY_BOOKMARKS, "[]"));
            JSONArray out = new JSONArray();
            JSONObject bm = new JSONObject();
            bm.put("id", String.valueOf(System.currentTimeMillis()));
            bm.put("type", "comment");
            bm.put("kind", kind);
            bm.put("filePath", uid);
            bm.put("title", meta.optString("title") + " — " + kindLabel);
            bm.put("subtitle", meta.optString("subtitle") + " · " + kindLabel);
            bm.put("scrollY", scrollY);
            bm.put("date", System.currentTimeMillis());
            bm.put("note", "");
            out.put(bm);
            for (int i = 0; i < arr.length() && out.length() < MAX_BOOKMARKS; i++) {
                JSONObject it = arr.getJSONObject(i);
                if (!("comment".equals(it.optString("type"))
                        && kind.equals(it.optString("kind"))
                        && uid.equals(it.optString("filePath")))) out.put(it);
            }
            putPref(KEY_BOOKMARKS, out.toString());
        } catch (Exception e) {
            Log.e(TAG, "addCommentBookmark", e);
        }
    }

    private void addRecent(String uid) {
        try {
            JSONObject meta = buildSuttaMetaJson(uid);
            if (meta == null) return;
            meta.put("date", System.currentTimeMillis());
            JSONArray arr = new JSONArray(getPref(KEY_RECENTS, "[]"));
            JSONArray out = new JSONArray();
            out.put(meta);
            for (int i = 0; i < arr.length() && out.length() < MAX_RECENTS; i++) {
                JSONObject it = arr.getJSONObject(i);
                if (!uid.equals(it.optString("filePath"))) out.put(it);
            }
            putPref(KEY_RECENTS, out.toString());
        } catch (Exception e) { }
    }

    private void updateBookmarkField(String id, String field, String value) {
        try {
            JSONArray arr = new JSONArray(getPref(KEY_BOOKMARKS, "[]"));
            for (int i = 0; i < arr.length(); i++) {
                JSONObject it = arr.getJSONObject(i);
                if (id.equals(it.optString("id"))) {
                    it.put(field, value);
                    break;
                }
            }
            putPref(KEY_BOOKMARKS, arr.toString());
        } catch (Exception e) { }
    }

    private JSONObject buildSuttaMetaJson(String uid) {
        if (db == null) return null;
        Cursor c = db.rawQuery(
                "SELECT title, nikaya, book, vagga, canonical_number, local_number " +
                        "FROM suttas WHERE uid = ? LIMIT 1",
                new String[]{uid});
        if (!c.moveToFirst()) {
            c.close();
            return null;
        }
        String title = c.getString(0);
        String nikaya = c.getString(1);
        String book = c.getString(2);
        String vagga = c.getString(3);
        int canon = c.getInt(4);
        int local = c.getInt(5);
        c.close();
        String ref;
        if ("Самьютта-никая".equals(nikaya) || "Ангуттара-никая".equals(nikaya)) {
            ref = ("Самьютта-никая".equals(nikaya) ? "СН " : "АН ") + canon + "." + local;
        } else if ("Дигха-никая".equals(nikaya) || "Мадджхима-никая".equals(nikaya)) {
            ref = ("Дигха-никая".equals(nikaya) ? "ДН " : "МН ") + canon;
        } else {
            ref = (vagga != null && !vagga.isEmpty()) ? vagga
                    : (book != null && !book.isEmpty() ? book : "");
        }
        JSONObject o = new JSONObject();
        try {
            o.put("filePath", uid);
            o.put("title", title);
            o.put("subtitle", nikaya + " · " + ref);
        } catch (Exception e) { }
        return o;
    }

    // ============================================================
    // ПРОЧЕЕ
    // ============================================================
    private String readAssetTemplate(String assetPath) throws IOException {
        InputStream is = getAssets().open(assetPath);
        byte[] buffer = new byte[is.available()];
        is.read(buffer);
        is.close();
        return new String(buffer, StandardCharsets.UTF_8);
    }

    private String escapeHtml(String text) {
        if (text == null) return "";
        return text
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }

    // ============================================================
    // ОБРАБОТЧИКИ КНОПОК
    // ============================================================
    public void toMainAct(View view) {
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toSuttasOpenBack(View view) {
        handleBack();
    }

    public void toSuttasOpenDighaAct(View view) {
        openNikayaList("Дигха-никая");
    }

    public void toSuttasOpenMajhimaAct(View view) {
        openNikayaList("Мадджхима-никая");
    }

    public void toSuttasOpenSanuttaAct(View view) {
        openNikayaList("Самьютта-никая");
    }

    public void toSuttasOpenAnguttaraAct(View view) {
        openNikayaList("Ангуттара-никая");
    }

    public void toSuttasOpenKuddakaAct(View view) {
        openNikayaList("Кхуддака-никая");
    }

    public void toSuttasOpenSearchAct(View view) {
        showSearchPage("");
    }

    public void toSuttasOpenRandomSuttaAct(View view) {
        openRandomSutta();
    }

    public void toSuttasOpenBookmarksAct(View view) {
        showBookmarksPage();
    }

    // ============================================================
    // СЛУЧАЙНАЯ СУТТА
    // ============================================================
    private void openRandomSutta() {
        if (db == null) return;
        Cursor cursor = db.rawQuery(
                "SELECT uid FROM suttas ORDER BY RANDOM() LIMIT 1", null);
        if (cursor.moveToFirst()) {
            String uid = cursor.getString(0);
            cursor.close();
            currentNikaya = null;
            pendingHighlight = null;
            mode = "menu";
            openSuttaByUid(uid);
            randomMode = true;
            suttaReturnMode = "menu";
        } else {
            cursor.close();
        }
    }

    // ============================================================
    // ЖИЗНЕННЫЙ ЦИКЛ
    // ============================================================
    @Override
    protected void onDestroy() {
        super.onDestroy();
        if (db != null && db.isOpen()) {
            db.close();
        }
    }
}