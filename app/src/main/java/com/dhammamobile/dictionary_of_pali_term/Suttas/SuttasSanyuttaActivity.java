package com.dhammamobile.dictionary_of_pali_term.Suttas;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

import com.dhammamobile.dictionary_of_pali_term.Suttas.BookmarkManager;
import android.widget.Toast;


public class SuttasSanyuttaActivity extends BaseActivityClass {

    private WebView webView;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Здесь вы можете добавить свои действия при изменении ориентации, если это необходимо
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suttas_sanyutta);

       // setWindowFlagsFullscreenAndNoLimits();

        // Скрытие панели навигации и панели состояния
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);
        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        Button buttonBack = findViewById(R.id.buttonliveToBeforePageSanyutta);
        webView = findViewById(R.id.webViewSanyutta);

        // Настройки масштабирования - порядок важен!
        webView.getSettings().setJavaScriptEnabled(true); // Сначала включаем JavaScript
        webView.getSettings().setSupportZoom(true); // Разрешить жестовое масштабирование
        webView.getSettings().setBuiltInZoomControls(true); // Включить поддержку масштабирования
        webView.getSettings().setDisplayZoomControls(false); // Скрыть кнопки +/-
        /*webView.getSettings().setUseWideViewPort(false); // ОТКЛЮЧАЕМ - это может блокировать масштабирование!*/
        // Не используем setLoadWithOverviewMode - блокирует уменьшение
        webView.clearCache(true);

        webView.getSettings().setUseWideViewPort(true);
        webView.getSettings().setLoadWithOverviewMode(true);
        webView.getSettings().setDomStorageEnabled(true);          // Включаем localStorage
        webView.getSettings().setAllowFileAccess(true);            // Разрешаем доступ к файлам
        webView.getSettings().setAllowContentAccess(true);         // Дополнительно, для доступа к контенту
        webView.getSettings().setAllowUniversalAccessFromFileURLs(true); // Для file:// скриптов (может понадобитьс

        // Загрузка первой страницы
        String intentFilePath = getIntent().getStringExtra("FILE_PATH");
        int intentScrollY = getIntent().getIntExtra("SCROLL_Y", 0);

        if (intentFilePath != null && !intentFilePath.isEmpty()) {
            webView.loadUrl("file:///android_asset/" + intentFilePath);
        } else {
            webView.loadUrl("file:///android_asset/canon/Teaching/Canon/Suttanta/samyutta.html");
        }
        // Используем AdaptiveWebViewClient для автоматического масштабирования
        webView.setWebViewClient(new AdaptiveWebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                super.onPageFinished(view, url);
                if (intentScrollY > 0) {
                    view.postDelayed(() ->
                                    view.evaluateJavascript("window.scrollTo(0, " + intentScrollY + ");", null)
                            , 500);
                }
            }
        });
        buttonBack.setOnClickListener(v -> goBack());

        BookmarkManager bookmarkManager = new BookmarkManager(this);

        findViewById(R.id.btnAddBookmark).setOnClickListener(v -> {
            webView.evaluateJavascript("window.scrollY", value -> {
                int scrollY = 0;
                try { scrollY = (int) Double.parseDouble(value.trim()); }
                catch (Exception ignored) {}

                final int finalScrollY = scrollY;
                final String currentUrl = webView.getUrl();
                final String filePath = currentUrl.replace("file:///android_asset/", "");

                runOnUiThread(() -> {
                    bookmarkManager.addBookmark(
                            "СН",
                            filePath,
                            "",
                            filePath,
                            finalScrollY
                    );
                    Toast.makeText(this, "Закладка сохранена 🔖", Toast.LENGTH_SHORT).show();
                });
            });
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
        WebView webView = findViewById(R.id.webViewSanyutta);
        super.onDestroy();
        webView.destroy();
    }
    public void toMainAct(View view){
        String currentUrl = webView.getUrl();
        saveLastVisitedPage(currentUrl);
        startIntentActivityAndFinish(MainActivity.class);
    }
    public void toSuttasAct(View view){
        String currentUrl = webView.getUrl();
        saveLastVisitedPage(currentUrl);
        startIntentActivityAndFinish(SuttasActivity.class);
    }
    @Override
    public void onBackPressed() {
        super.onBackPressed();
        String currentUrl = webView.getUrl();
        saveLastVisitedPage(currentUrl);
        startIntentActivityAndFinish(SuttasActivity.class);
    }
}