package com.dhammamobile.dictionary_of_pali_term.Declomation;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

import java.util.Locale;


public class DeclomationPujaActivity extends BaseActivityClass {

    private Button buttonHome;
    private Button buttonLiveToPuja;

    LinearLayout buttonVandana;
    Button plusText, minusText;
    WebView webView; // Declare WebView as a class member for easy access

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declomation_puja);

      //  setWindowFlagsFullscreenAndNoLimits();

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        plusText = findViewById(R.id.buttonPlusVandana);
        minusText = findViewById(R.id.buttonMinusVandana);

        webView = findViewById(R.id.webViewVandana);

        buttonVandana = findViewById(R.id.button_layout_vandana);

        this.buttonHome = findViewById(R.id.buttonPujaHome);
        this.buttonLiveToPuja = findViewById(R.id.buttonliveToPuja);

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

    public void toDeclomation(View view){
        buttonHome.setVisibility(View.INVISIBLE);
        buttonLiveToPuja.setVisibility(View.INVISIBLE);
        startIntentActivityAndFinish(DeklomationMainActivity.class);
    }

    public void toDeclomaciyaMorningPuja(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextMorningPuja);
        scrollText.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToPuja.setVisibility(View.VISIBLE);
    }

    public void toDeclomaciyaOftereveningMeditation(View view) {
        buttonVandana.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/vandana_ru/vandanaPart2Ru.html";
        } else {
            htmlFilePath = "file:///android_asset/vandana_en/vandanaPart2En.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void toDeclamaciyaBeforeEveningMeditation(View view) {
        buttonVandana.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/vandana_ru/vandanaPart1Ru.html";
        } else {
            htmlFilePath = "file:///android_asset/vandana_en/vandanaPart1Ru.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void toVandanaBack(View view){
        webView.setVisibility(View.INVISIBLE);
        buttonVandana.setVisibility(View.INVISIBLE);
    }

    public void toDeclomaciyaVandanaAmbokote(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextVandanaAmbokote);
        scrollText.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToPuja.setVisibility(View.VISIBLE);
    }

    public void toDeclomaciyaVandanaWithLayman(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextVandanaWithLayman);
        scrollText.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToPuja.setVisibility(View.VISIBLE);
    }

    public void tobackOver(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextMorningPuja);
        ScrollView scrollTextVandanaWithLayman = findViewById(R.id.overScrollTextVandanaWithLayman);
        ScrollView scrollTextVandanaAmbokote = findViewById(R.id.overScrollTextVandanaAmbokote);
//        ScrollView scrollTextAfterEvening = findViewById(R.id.overScrollTextDeclomaciyaOftereveningMeditstion);
        scrollText.setVisibility(View.INVISIBLE);
        scrollTextVandanaWithLayman.setVisibility(View.INVISIBLE);
        scrollTextVandanaAmbokote.setVisibility(View.INVISIBLE);
//        scrollTextAfterEvening.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
        buttonLiveToPuja.setVisibility(View.INVISIBLE);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(DeklomationMainActivity.class);
    }
}