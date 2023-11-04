package com.dhammamobile.dictionary_of_pali_term;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


public class SuttasAnguttaraActivity extends BaseActivityClass {

    private WebView webView;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Здесь вы можете добавить свои действия при изменении ориентации, если это необходимо
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suttas_anguttara);

        setWindowFlagsFullscreenAndNoLimits();

        Button buttonBack = findViewById(R.id.buttonliveToBeforePageAnguttara);
        webView = findViewById(R.id.webViewAnguttara);

        webView.getSettings().setBuiltInZoomControls(true); // Разрешить встроенное масштабирование
        webView.getSettings().setSupportZoom(true); // Разрешить поддержку жестов масштабирования
        webView.getSettings().setDisplayZoomControls(false); // Скрыть контролы масштабирования
        webView.getSettings().setUseWideViewPort(true); // Разрешить широкий видовой порт


        webView.getSettings().setJavaScriptEnabled(true); // Разрешить JavaScript, если нужно
        webView.clearCache(true);

        // Загрузка первой страницы
        webView.loadUrl("file:///android_asset/canon/Teaching/Canon/Suttanta/anguttara.html");
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
    protected void onDestroy() {
        WebView webView = findViewById(R.id.webViewAnguttara);
        super.onDestroy();
        webView.destroy();
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toSuttasAct(View view){
        startIntentActivityAndFinish(SuttasActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(SuttasActivity.class);
    }
}