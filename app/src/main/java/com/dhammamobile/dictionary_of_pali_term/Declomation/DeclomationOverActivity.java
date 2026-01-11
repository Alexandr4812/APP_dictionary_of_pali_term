package com.dhammamobile.dictionary_of_pali_term.Declomation;

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


public class DeclomationOverActivity extends BaseActivityClass {

    private Button buttonHome;
    private Button buttonLiveToOver;

    LinearLayout buttonOver;
    Button plusText, minusText;
    WebView webView;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declomation_over);

       // setWindowFlagsFullscreenAndNoLimits();

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        this.buttonHome = findViewById(R.id.buttonDeclomationHome);
        this.buttonLiveToOver = findViewById(R.id.buttonliveToOver);

        plusText = findViewById(R.id.buttonPlusOver);
        minusText = findViewById(R.id.buttonMinusOver);

        webView = findViewById(R.id.webViewOver);

        buttonOver = findViewById(R.id.button_layout_over);

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

    public void toDeclomaciyaChaturarakha(View view) {
        buttonOver.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/parittas_ru/chaturarakha_ru.html";
        } else {
            htmlFilePath = "file:///android_asset/parittas_en/chaturarakha_en.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    private void loadHtmlPage(String htmlFilePath) {
        webView.loadUrl(htmlFilePath);
    }



    public void toOverBack(View view){
        webView.setVisibility(View.INVISIBLE);
        buttonOver.setVisibility(View.INVISIBLE);
    }

    public void toDeclomation(View view){
        startIntentActivityAndFinish(DeklomationMainActivity.class);
    }


    public void toDeclomaciyaAlmsWish(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextAlmsWish);
        scrollText.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToOver.setVisibility(View.VISIBLE);
    }



    public void toDeclomaciyaRefleksiyaOProshlihNeobhodimostyah(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextDeclomaciyaRefleksiyaOProshlihNeobhodimostyah);
        scrollText.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToOver.setVisibility(View.VISIBLE);
    }

    public void toDeclomaciya32chasti(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextDeclomaciya32chasti);
        scrollText.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToOver.setVisibility(View.VISIBLE);
    }

    public void tobackOver(View view) {
        ScrollView scrollText3 = findViewById(R.id.overScrollTextAlmsWish);
        scrollText3.setVisibility(View.INVISIBLE);
        ScrollView scrollText5 = findViewById(R.id.overScrollTextDeclomaciyaRefleksiyaOProshlihNeobhodimostyah);
        scrollText5.setVisibility(View.INVISIBLE);
        ScrollView scrollText6 = findViewById(R.id.overScrollTextDeclomaciya32chasti);
        scrollText6.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
        buttonLiveToOver.setVisibility(View.INVISIBLE);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(DeklomationMainActivity.class);
    }
}