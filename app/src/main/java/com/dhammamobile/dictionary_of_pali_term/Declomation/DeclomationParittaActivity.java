package com.dhammamobile.dictionary_of_pali_term.Declomation;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

import java.util.Locale;


public class DeclomationParittaActivity extends BaseActivityClass {

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Здесь вы можете добавить свои действия при изменении ориентации, если это необходимо
    }
    LinearLayout buttonParittas;
    Button plusText, minusText;
    WebView webView; // Declare WebView as a class member for easy access

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateLocale(); // Установка языка
        setContentView(R.layout.activity_declomation_paritta);

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        plusText = findViewById(R.id.buttonPlusParittas);
        minusText = findViewById(R.id.buttonMinusParittas);

        webView = findViewById(R.id.webViewParittas);

        buttonParittas = findViewById(R.id.button_layout_parittas);

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

    public void moraParitta(View view) {
        buttonParittas.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/parittas_ru/moraParittaRu.html";
        } else {
            htmlFilePath = "file:///android_asset/parittas_en/moraParittaEn.html";
        }
        loadHtmlPage(htmlFilePath);
    }
    public void angulimalaParitta(View view) {
        buttonParittas.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/parittas_ru/angulimalaParittaRu.html";
        } else {
            htmlFilePath = "file:///android_asset/parittas_en/angulimalaParittaEn.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void toDeclomation(View view){
        startIntentActivityAndFinish(DeklomationMainActivity.class);
    }

    public void toParittasBack(View view){
        webView.setVisibility(View.INVISIBLE);
        buttonParittas.setVisibility(View.INVISIBLE);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(DeklomationMainActivity.class);
    }

}