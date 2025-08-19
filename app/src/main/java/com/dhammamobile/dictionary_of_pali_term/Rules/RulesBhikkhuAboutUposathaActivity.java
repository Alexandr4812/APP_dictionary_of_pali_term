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
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

import java.util.Locale;

public class RulesBhikkhuAboutUposathaActivity extends BaseActivityClass {

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Здесь вы можете добавить свои действия при изменении ориентации, если это необходимо
    }
    LinearLayout buttonUposatha;
    Button plusText, minusText;
    WebView webView; // Declare WebView as a class member for easy access

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateLocale(); // Установка языка
        setContentView(R.layout.activity_rules_bhikkhu_about_uposatha);

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        plusText = findViewById(R.id.buttonPlusUposatha);
        minusText = findViewById(R.id.buttonMinusUposatha);

        webView = findViewById(R.id.webViewBhikkhuAboutUposatha);

        buttonUposatha = findViewById(R.id.button_layout_uposatha);

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

    public void uposatha1(View view) {
        buttonUposatha.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/bhikkhu_manual_ru/uposathaRu1.html";
        } else {
            htmlFilePath = "file:///android_asset/bhikkhu_manual_en/uposathaEn1.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void uposatha2(View view) {
        buttonUposatha.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/bhikkhu_manual_ru/uposathaRu2.html";
        } else {
            htmlFilePath = "file:///android_asset/bhikkhu_manual_en/uposathaEn2.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void uposatha3(View view) {
        buttonUposatha.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/bhikkhu_manual_ru/uposathaRu3.html";
        } else {
            htmlFilePath = "file:///android_asset/bhikkhu_manual_en/uposathaEn3.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void toUposathaBack(View view){
        webView.setVisibility(View.INVISIBLE);
        buttonUposatha.setVisibility(View.INVISIBLE);
    }

    public void toRulesBhikkhuAboutAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuAboutActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(RulesBhikkhuAboutActivity.class);
    }
}