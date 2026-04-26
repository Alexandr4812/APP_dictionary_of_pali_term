package com.dhammamobile.dictionary_of_pali_term.Rules;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;

import androidx.activity.OnBackPressedCallback;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

import java.util.Locale;


public class RulesBhikkhuPatimokhaActivity extends BaseActivityClass {

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Здесь вы можете добавить свои действия при изменении ориентации, если это необходимо
    }
    private Button buttonHome;
    private Button buttonBack;

    LinearLayout buttonPatimokha;
    Button plusText, minusText;
    WebView webView; // Declare WebView as a class member for easy access

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_bhikkhu_patimokha);

       // setWindowFlagsFullscreenAndNoLimits();

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        plusText = findViewById(R.id.buttonPlusPatimokha);
        minusText = findViewById(R.id.buttonMinusPatimokha);

        webView = findViewById(R.id.webViewPatimokha);

        buttonPatimokha = findViewById(R.id.button_layout_patimokha);

        this.buttonBack = findViewById(R.id.buttonliveToBhikkhu);
        this.buttonHome = findViewById(R.id.buttonliveHomeFromUpasampada);

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



        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Вместо закрытия — переходим на главную
                startIntentActivityAndFinish(RulesBhikkhuActivity.class);
            }
        });
    }

    private void loadHtmlPage(String htmlFilePath) {
        webView.loadUrl(htmlFilePath);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }


    public void toPatimokhaBack(View view){
        webView.setVisibility(View.INVISIBLE);
        buttonPatimokha.setVisibility(View.INVISIBLE);
        // Восстанавливаем +/- для следующего открытия основного раздела
        plusText.setVisibility(View.VISIBLE);
        minusText.setVisibility(View.VISIBLE);
    }

    public void openExtraPatimokha(View view) {
        openExtraSection("file:///android_asset/offences_ru/patimokha.html");
    }

    private void openExtraSection(String htmlFilePath) {
        buttonPatimokha.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        // Скрываем +/- — в дополнительных разделах они не нужны
        plusText.setVisibility(View.GONE);
        minusText.setVisibility(View.GONE);
        loadHtmlPage(htmlFilePath);
    }

    public void toRulesBhikkhuAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuActivity.class);
    }

    public void toRulesPatimokhaParajikaAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaParajikaActivity.class);
    }

    public void toRulesPatimokhaSanghadisesaAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaSanghadisesaActivity.class);
    }

    public void toPatimokhaAbout(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollPatimokhaAbout);
        scrollText.setVisibility(View.VISIBLE);
        buttonBack.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
    }

    public void toPatimokhaAboutPunish(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollPatimokhaAboutPunish);
        scrollText.setVisibility(View.VISIBLE);
        buttonBack.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
    }

    public void tobackIzTextPatimokha(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollPatimokhaAbout);
        scrollText.setVisibility(View.INVISIBLE);
        ScrollView scrollText2 = findViewById(R.id.viewScrollPatimokhaAboutPunish);
        scrollText2.setVisibility(View.INVISIBLE);
        buttonBack.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
    }
}