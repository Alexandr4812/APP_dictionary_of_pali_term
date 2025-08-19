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


public class SuttasMajjhimaActivity extends BaseActivityClass {

    private WebView webView;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Здесь вы можете добавить свои действия при изменении ориентации, если это необходимо
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suttas_majjhima);

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

        Button buttonBack = findViewById(R.id.buttonliveToBeforePageMajjhima);
        webView = findViewById(R.id.webViewMajjhima);

        webView.getSettings().setBuiltInZoomControls(true); // Разрешить встроенное масштабирование
        webView.getSettings().setSupportZoom(true); // Разрешить поддержку жестов масштабирования
        webView.getSettings().setDisplayZoomControls(false); // Скрыть контролы масштабирования
        webView.getSettings().setUseWideViewPort(true); // Разрешить широкий видовой порт

        webView.getSettings().setJavaScriptEnabled(true); // Разрешить JavaScript, если нужно
        webView.clearCache(true);

        // Загрузка первой страницы
        webView.loadUrl("file:///android_asset/canon/Teaching/Canon/Suttanta/majjhima.html");
        // Обработка переходов между страницами через ссылки
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("file:///android_asset/")) {
                    view.loadUrl(url);
                    return true;
                }
                return false;
            }
        });

        buttonBack.setOnClickListener(v -> goBack());
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
        WebView webView = findViewById(R.id.webViewMajjhima);
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