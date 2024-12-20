package com.dhammamobile.dictionary_of_pali_term.Rules;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

import java.util.Locale;

public class RulesBhikkhuAboutOffencesActivity extends BaseActivityClass {
    LinearLayout buttonOffence;
    Button plusText, minusText;
    WebView webView; // Declare WebView as a class member for easy access

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_bhikkhu_about_offences);
        updateLocale(); // Установка языка

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        plusText = findViewById(R.id.buttonPlusOffence);
        minusText = findViewById(R.id.buttonMinusOffence);

        webView = findViewById(R.id.webViewOffence);

        buttonOffence = findViewById(R.id.button_layout_offence);

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

    public void toOffence1(View view) {
        buttonOffence.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/offences_ru/offenceRu.html";
        } else {
            htmlFilePath = "file:///android_asset/offences_en/offenceEn.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void toOffenceSanghadisesa(View view) {
        buttonOffence.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/offences_ru/offenceSanghadisesaRu.html";
        } else {
            htmlFilePath = "file:///android_asset/offences_en/offenceSanghadisesaEn.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void toOffenceBack(View view){
        webView.setVisibility(View.INVISIBLE);
        buttonOffence.setVisibility(View.INVISIBLE);
    }


    public void toRlesBhikkhuOffences2(View view){
        startIntentActivityAndFinish(RulesBhikkhuAboutOffencesPacittiyaActivity.class);
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