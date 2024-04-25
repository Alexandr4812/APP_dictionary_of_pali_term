package com.dhammamobile.dictionary_of_pali_term.Rules;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

import java.util.Locale;

public class RulesBhikkhuPatimokhaSanghadisesaDetail8Activity extends BaseActivityClass {
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Здесь вы можете добавить свои действия при изменении ориентации, если это необходимо
    }

    public WebView webView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateLocale(); // Установка языка
        setContentView(R.layout.activity_rules_bhikkhu_patimokha_sanghadisesa_detail8);

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        webView = findViewById(R.id.webViewSanghadisesaDetail8);



        webView.getSettings().setBuiltInZoomControls(true); // Разрешить встроенное масштабирование
        webView.getSettings().setSupportZoom(true); // Разрешить поддержку жестов масштабирования
        webView.getSettings().setDisplayZoomControls(false); // Скрыть контролы масштабирования
        webView.getSettings().setUseWideViewPort(true); // Разрешить широкий видовой порт

        webView.getSettings().setJavaScriptEnabled(true); // Разрешить JavaScript, если нужно
        webView.clearCache(true);

        // Получить текущий язык устройства
        String currentLanguage = Locale.getDefault().getLanguage();
        // Определить путь к HTML файлу в соответствии с текущим языком
        String htmlFilePath;
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/par_detail_ru/sd8.html";
        } else {
            htmlFilePath = "file:///android_asset/par_detail_en/sd8.html";
        }

        webView.loadUrl(htmlFilePath);
    }

    @Override
    protected void onResume() {
        super.onResume();
    }


    public void toBack(View view){
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaSanghadisesaActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaSanghadisesaActivity.class);
    }
}