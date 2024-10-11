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

public class RulesBhikkhuAboutActivity extends BaseActivityClass {

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Здесь вы можете добавить свои действия при изменении ориентации, если это необходимо
    }
    LinearLayout buttonKathina;
    Button plusText, minusText;
    WebView webView; // Declare WebView as a class member for easy access

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateLocale(); // Установка языка
        setContentView(R.layout.activity_rules_bhikkhu_about);

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        plusText = findViewById(R.id.buttonPlusUposatha);
        minusText = findViewById(R.id.buttonMinusUposatha);

        webView = findViewById(R.id.webViewBhikkhuAboutKathina);

        buttonKathina = findViewById(R.id.button_layout_uposatha);

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

    public void otherProcedures(View view) {
        buttonKathina.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/bhikkhu_manual_ru/otherProcedurasRu.html";
        } else {
            htmlFilePath = "file:///android_asset/bhikkhu_manual_en/otherProcedurasEn.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void toUposathaBack(View view){
        webView.setVisibility(View.INVISIBLE);
        buttonKathina.setVisibility(View.INVISIBLE);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(RulesBhikkhuActivity.class);
    }


    public void toRulesBhikkhuAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuActivity.class);
    }

    public void toRulesBhikkhuAboutGeneralInfoAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuAboutGeneralInfoActivity.class);
    }

    public void toRulesBhikkhuAboutRequisitesAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuAboutRequisitesActivity.class);
    }

    public void toRulesBhikkhuAboutOffencesAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuAboutOffencesActivity.class);
    }

    public void toRulesBhikkhuAboutUposathaAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuAboutUposathaActivity.class);
    }

    public void toRulesBhikkhuAboutKathinaAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuAboutKathinaActivity.class);
    }
}