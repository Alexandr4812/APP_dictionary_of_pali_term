package com.dhammamobile.dictionary_of_pali_term.Rules;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

import java.util.Locale;

public class RulesLaySilaActivity extends BaseActivityClass {

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Здесь вы можете добавить свои действия при изменении ориентации, если это необходимо
    }

    LinearLayout buttonLaySila;
    Button plusText, minusText;
    WebView webView; // Declare WebView as a class member for easy access

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateLocale(); // Установка языка
        setContentView(R.layout.activity_rules_lay_sila);

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        plusText = findViewById(R.id.buttonPlusLaySila);
        minusText = findViewById(R.id.buttonMinusLaySila);

        webView = findViewById(R.id.webViewLaySila);

        buttonLaySila = findViewById(R.id.button_layout_lay_sila);

        // Настройки WebView
        WebSettings webSettings = webView.getSettings();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.clearCache(true);

        // Обработчики нажатий кнопок для увеличения/уменьшения шрифта
        plusText.setOnClickListener(v -> {
            webView.evaluateJavascript("javascript:increaseFontSize();", null);
        });

        minusText.setOnClickListener(v -> {
            webView.evaluateJavascript("javascript:decreaseFontSize();", null);
        });
    }
    private void loadHtmlPage(String htmlFilePath) {
        webView.loadUrl(htmlFilePath);
    }

    public void sila1(View view) {
        buttonLaySila.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/upasaka_ru/1_panchasila_ru.html";
        } else {
            htmlFilePath = "file:///android_asset/upasaka_en/1_panchasila_en.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void sila2(View view) {
        buttonLaySila.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/upasaka_ru/2_BrahmacariyaSīla_ru.html";
        } else {
            htmlFilePath = "file:///android_asset/upasaka_en/2_BrahmacariyaSīla_en.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void sila3(View view) {
        buttonLaySila.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/upasaka_ru/3_UposathaSīla_ru.html";
        } else {
            htmlFilePath = "file:///android_asset/upasaka_en/3_UposathaSīla_en.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void sila4(View view) {
        buttonLaySila.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/upasaka_ru/4_AtthamakaSila_ru.html";
        } else {
            htmlFilePath = "file:///android_asset/upasaka_en/4_AyyhamakaSila_en.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void sila5(View view) {
        buttonLaySila.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/upasaka_ru/5_NavangaUposathaSila_ru.html";
        } else {
            htmlFilePath = "file:///android_asset/upasaka_en/5_NavangaUposathaSila_en.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void sila6(View view) {
        buttonLaySila.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/upasaka_ru/6_DasaSila_ru.html";
        } else {
            htmlFilePath = "file:///android_asset/upasaka_en/6_DasaSila_en.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void sila7(View view) {
        buttonLaySila.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/upasaka_ru/7_AnagarikaDasaSila_ru.html";
        } else {
            htmlFilePath = "file:///android_asset/upasaka_en/7_AnagarikaDasaSila_en.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void toRulesLayAct(View view){
        startIntentActivityAndFinish(RulesLayActivity.class);
    }
    public void toLaySilaBack(View view){
        webView.setVisibility(View.INVISIBLE);
        buttonLaySila.setVisibility(View.INVISIBLE);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(RulesLayActivity.class);
    }
}