package com.dhammamobile.dictionary_of_pali_term.Rules;

import android.annotation.SuppressLint;
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


public class RulesSamaneraActivity extends BaseActivityClass {

    LinearLayout buttonSekhiya;
    private Button buttonHome;
    private Button buttonLiveToRulesSamanera;

    WebView webView;

    private ScrollView scrollTextNissaya;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_samanera);

       // setWindowFlagsFullscreenAndNoLimits();

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        webView = findViewById(R.id.webViewSekhiya);
        buttonSekhiya = findViewById(R.id.button_layout_sekhiya);

        this.buttonHome = findViewById(R.id.buttonRulesSamaneraHome);
        this.buttonLiveToRulesSamanera = findViewById(R.id.buttonliveToRulesSamanera);
        this.scrollTextNissaya = findViewById(R.id.viewScrollRulesSamaneraNissaya);

        // Настройки WebView
        WebSettings webSettings = webView.getSettings();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.clearCache(true);
        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Вместо закрытия — переходим на главную
                startIntentActivityAndFinish(RulesActivity.class);
            }
        });

    }

    private void loadHtmlPage(String htmlFilePath) {
        webView.loadUrl(htmlFilePath);
    }

    public void toRulesSekhiyaAct(View view){
        buttonSekhiya.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/samanera_rules_ru/sekhiya_ru.html";
        } else {
            htmlFilePath = "file:///android_asset/samanera_rules_ru/sekhiya_ru.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void toSekhiyaBack(View view){
        webView.setVisibility(View.INVISIBLE);
        buttonSekhiya.setVisibility(View.INVISIBLE);
    }

    public void toRulesAct(View view){
        startIntentActivityAndFinish(RulesActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }



    public void toBecomingSamaneraPabajaAct(View view){
        startIntentActivityAndFinish(RulesSamaneraPabbajjaActivity.class);
    }

    public void toTextNissaya(View view) {
        scrollTextNissaya.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public void toMajorRules(View view){
        startIntentActivityAndFinish(RulesSamaneraObInfoActivity.class);
    }


    public void tobackRulsSamanera(View view) {
        scrollTextNissaya.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.INVISIBLE);
    }
}