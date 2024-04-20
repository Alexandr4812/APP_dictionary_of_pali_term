package com.dhammamobile.dictionary_of_pali_term.Suttas;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

public class SuttasLastSuttaActivity extends BaseActivityClass {

    private WebView webView;

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Здесь вы можете добавить свои действия при изменении ориентации, если это необходимо
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suttas_last_sutta);

       // setWindowFlagsFullscreenAndNoLimits();

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        webView = findViewById(R.id.webViewLastSutta);

        webView.getSettings().setBuiltInZoomControls(true); // Разрешить встроенное масштабирование
        webView.getSettings().setSupportZoom(true); // Разрешить поддержку жестов масштабирования
        webView.getSettings().setDisplayZoomControls(false); // Скрыть контролы масштабирования
        webView.getSettings().setUseWideViewPort(true); // Разрешить широкий видовой порт

        // Загрузка последней просмотренной страницы, если она существует
        String lastVisitedPage = getLastVisitedPage();
        if (!lastVisitedPage.isEmpty()) {
            webView.loadUrl(lastVisitedPage);
        } else {
            webView.loadUrl("file:///android_asset/canon/Teaching/Canon/Suttanta/khuddaka.html");
        }
    }

    private String getLastVisitedPage() {
        return getSharedPreferences("MyPrefs", MODE_PRIVATE)
                .getString("last_visited_page", "");
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