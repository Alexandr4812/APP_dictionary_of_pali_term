package com.dhammamobile.dictionary_of_pali_term.Rules;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

public class RulesBhikkhuPatimokhaSanghadisesaDetail2Activity extends BaseActivityClass {
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
        setContentView(R.layout.activity_rules_bhikkhu_patimokha_sanghadisesa_detail2);

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        webView = findViewById(R.id.webViewSanghadisesaDetail2);



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
            htmlFilePath = "file:///android_asset/par_detail_ru/sd2.html";
        } else {
            htmlFilePath = "file:///android_asset/par_detail_en/sd2.html";
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