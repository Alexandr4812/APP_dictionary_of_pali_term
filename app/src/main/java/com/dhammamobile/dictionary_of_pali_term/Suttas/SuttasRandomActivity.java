package com.dhammamobile.dictionary_of_pali_term.Suttas;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.widget.Button;

import androidx.activity.OnBackPressedCallback;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

import java.io.IOException;
import java.util.Random;

import com.dhammamobile.dictionary_of_pali_term.Suttas.BookmarkManager;
import android.widget.Toast;

public class SuttasRandomActivity extends BaseActivityClass {

    private WebView webView;
    private String[] validFolders = {"Texts"};
    private Random random = new Random();
    private static final String KEY_WEBVIEW_STATE = "suttas_webview_state";

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suttas_random);

        enableEdgeToEdgeMode();

        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom);
            return insets;
        });

        webView = findViewById(R.id.webViewRandomSutta);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.clearCache(true);

        WebViewLightHelper.apply(webView);

        // Восстанавливаем состояние WebView после ротации.
        final Bundle webViewBundle;
        final boolean restoredFromState;
        if (savedInstanceState != null) {
            webViewBundle = savedInstanceState.getBundle(KEY_WEBVIEW_STATE);
            restoredFromState = webViewBundle != null;
        } else {
            webViewBundle = null;
            restoredFromState = false;
        }

        BookmarkManager bookmarkManager = new BookmarkManager(this);

        webView.setWebViewClient(new AdaptiveWebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                // Записываем каждую случайную сутту в историю недавних
                String filePath = url.replace("file:///android_asset/", "");
                if (filePath.endsWith(".html")) {
                    view.evaluateJavascript(
                            "(function(){ return JSON.stringify({ title: document.title, scrollY: window.scrollY }); })()",
                            result -> {
                                String title   = "";
                                int    scrollY = 0;
                                try {
                                    String json = result.replaceAll("^\"|\"$", "")
                                            .replace("\\\"", "\"");
                                    org.json.JSONObject obj = new org.json.JSONObject(json);
                                    title   = obj.optString("title", "");
                                    scrollY = obj.optInt("scrollY", 0);
                                } catch (Exception ignored) {}

                                final String finalTitle   = title;
                                final int    finalScrollY = scrollY;

                                // Определяем никаю из пути к файлу для suttaRef
                                final String suttaRef = detectNikaya(filePath);

                                runOnUiThread(() ->
                                        bookmarkManager.addRecent(
                                                suttaRef,
                                                finalTitle,
                                                "",
                                                filePath,
                                                finalScrollY
                                        )
                                );
                            }
                    );
                }
            }
        });

        // Если WebView уже был открыт — восстановим его.
        // Иначе грузим случайную страницу.
        if (restoredFromState) {
            webView.restoreState(webViewBundle);
        } else {
            loadRandomPage();
        }

        Button buttonLoadRandomPage = findViewById(R.id.buttonNextSutta);
        buttonLoadRandomPage.setOnClickListener(v -> loadRandomPage());

        findViewById(R.id.btnAddBookmark).setOnClickListener(v -> {
            webView.evaluateJavascript("window.scrollY", value -> {
                int scrollY = 0;
                try { scrollY = (int) Double.parseDouble(value.trim()); }
                catch (Exception ignored) {}

                final int    finalScrollY = scrollY;
                final String currentUrl   = webView.getUrl();
                final String filePath     = currentUrl.replace("file:///android_asset/", "");

                runOnUiThread(() -> {
                    bookmarkManager.addBookmark(
                            detectNikaya(filePath),
                            filePath,
                            "",
                            filePath,
                            finalScrollY
                    );
                    Toast.makeText(this, "Закладка сохранена 🔖", Toast.LENGTH_SHORT).show();
                });
            });
        });

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                String currentUrl = webView.getUrl();
                saveLastVisitedPage(currentUrl);
                startIntentActivityAndFinish(SuttasActivity.class);
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (webView != null) {
            Bundle webViewBundle = new Bundle();
            webView.saveState(webViewBundle);
            outState.putBundle(KEY_WEBVIEW_STATE, webViewBundle);
        }
    }

    /**
     * Определяет префикс никаи по пути к файлу.
     * Например: "AN/Texts/an1_1-..." → "АН"
     */
    private String detectNikaya(String filePath) {
        String lp = filePath.toLowerCase();
        if (lp.contains("anguttara") || lp.contains("/an/") || lp.contains("an/")) return "АН";
        if (lp.contains("majjhima")  || lp.contains("/mn/") || lp.contains("mn/")) return "МН";
        if (lp.contains("sanyutta")  || lp.contains("samyutta") ||
                lp.contains("/sn/")      || lp.contains("sn/"))      return "СН";
        if (lp.contains("digha")     || lp.contains("/dn/") || lp.contains("dn/")) return "ДН";
        if (lp.contains("khuddaka")  || lp.contains("/kn/") || lp.contains("kn/")) return "КН";
        return "СН"; // fallback для папки Texts без явного указания никаи
    }

    private void loadRandomPage() {
        String randomFolder = getRandomFolder();
        try {
            String[] filesInFolder = getAssets().list(
                    "canon/Teaching/Canon/Suttanta/" + randomFolder);
            String randomFile = getRandomFile(filesInFolder);
            if (randomFile != null) {
                String path = "file:///android_asset/canon/Teaching/Canon/Suttanta/"
                        + randomFolder + "/" + randomFile;
                webView.loadUrl(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getRandomFolder() {
        return validFolders[random.nextInt(validFolders.length)];
    }

    private String getRandomFile(String[] files) {
        if (files != null && files.length > 0) {
            return files[random.nextInt(files.length)];
        }
        return null;
    }

    @Override
    protected void onPause() {
        String currentUrl = webView.getUrl();
        saveLastVisitedPage(currentUrl);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        WebView webView = findViewById(R.id.webViewRandomSutta);
        super.onDestroy();
        webView.destroy();
    }

    public void toMainAct(View view) {
        String currentUrl = webView.getUrl();
        saveLastVisitedPage(currentUrl);
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toSuttasAct(View view) {
        String currentUrl = webView.getUrl();
        saveLastVisitedPage(currentUrl);
        startIntentActivityAndFinish(SuttasActivity.class);
    }
}