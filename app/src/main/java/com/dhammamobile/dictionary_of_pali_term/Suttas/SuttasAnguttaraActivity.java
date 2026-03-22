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

import com.dhammamobile.dictionary_of_pali_term.Suttas.BookmarkManager;
import android.widget.Toast;


public class SuttasAnguttaraActivity extends BaseActivityClass {

    private WebView webView;

    // Стартовая страница раздела — её не записываем в историю
    private static final String INDEX_PAGE = "canon/Teaching/Canon/Suttanta/anguttara.html";

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suttas_anguttara);

        enableEdgeToEdgeMode();

        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom);
            return insets;
        });

        Button buttonBack = findViewById(R.id.buttonliveToBeforePageAnguttara);
        webView = findViewById(R.id.webViewAnguttara);

        webView.getSettings().setJavaScriptEnabled(true);
        webView.getSettings().setSupportZoom(true);
        webView.getSettings().setBuiltInZoomControls(true);
        webView.getSettings().setDisplayZoomControls(false);
        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setDomStorageEnabled(true);
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowContentAccess(true);
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true);
        webView.clearCache(true);

        WebViewLightHelper.apply(webView);

        String intentFilePath = getIntent().getStringExtra("FILE_PATH");
        int intentScrollY = getIntent().getIntExtra("SCROLL_Y", 0);

        if (intentFilePath != null && !intentFilePath.isEmpty()) {
            webView.loadUrl("file:///android_asset/" + intentFilePath);
        } else {
            webView.loadUrl("file:///android_asset/" + INDEX_PAGE);
        }

        BookmarkManager bookmarkManager = new BookmarkManager(this);

        webView.setWebViewClient(new AdaptiveWebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);

                // Восстанавливаем позицию прокрутки (только при открытии по Intent)
                if (intentScrollY > 0) {
                    view.postDelayed(() ->
                                    view.evaluateJavascript(
                                            "window.scrollTo(0, " + intentScrollY + ");", null),
                            500);
                }

                // Записываем в историю недавних — пропускаем индексную страницу
                String filePath = url.replace("file:///android_asset/", "");
                if (!filePath.equals(INDEX_PAGE) && filePath.endsWith(".html")) {
                    // Читаем заголовок страницы и scrollY, затем сохраняем
                    view.evaluateJavascript(
                            "(function(){ return JSON.stringify({ title: document.title, scrollY: window.scrollY }); })()",
                            result -> {
                                String title   = "";
                                int    scrollY = 0;
                                try {
                                    // result приходит как строка вида "\"{ ... }\""
                                    String json = result.replaceAll("^\"|\"$", "")
                                            .replace("\\\"", "\"");
                                    org.json.JSONObject obj = new org.json.JSONObject(json);
                                    title   = obj.optString("title", "");
                                    scrollY = obj.optInt("scrollY", 0);
                                } catch (Exception ignored) {}

                                final String finalTitle   = title;
                                final int    finalScrollY = scrollY;

                                runOnUiThread(() ->
                                        bookmarkManager.addRecent(
                                                "АН",        // suttaRef — префикс никаи
                                                finalTitle,  // берём из <title> страницы
                                                "",          // subtitle — можно заполнить позже
                                                filePath,    // путь к файлу в assets
                                                finalScrollY
                                        )
                                );
                            }
                    );
                }
            }
        });

        buttonBack.setOnClickListener(v -> goBack());

        // Кнопка добавления закладки
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
                            "АН",
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

    private void goBack() {
        if (webView.canGoBack()) {
            webView.goBack();
        }
    }

    @Override
    protected void onPause() {
        String currentUrl = webView.getUrl();
        saveLastVisitedPage(currentUrl);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        WebView webView = findViewById(R.id.webViewAnguttara);
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