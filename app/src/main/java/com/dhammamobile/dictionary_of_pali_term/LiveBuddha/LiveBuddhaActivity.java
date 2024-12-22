package com.dhammamobile.dictionary_of_pali_term.LiveBuddha;

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


public class LiveBuddhaActivity extends BaseActivityClass {

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Здесь вы можете добавить свои действия при изменении ориентации, если это необходимо
    }
    LinearLayout buttonBuddha;
    Button plusText, minusText;
    WebView webView; // Declare WebView as a class member for easy access

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateLocale(); // Установка языка
        setContentView(R.layout.activity_live_buddha);

       // setWindowFlagsFullscreenAndNoLimits();

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        plusText = findViewById(R.id.buttonPlusTextLiveBuddha);
        minusText = findViewById(R.id.buttonMinusTextLiveBuddha);

        webView = findViewById(R.id.webViewLiveBuddha);

        buttonBuddha = findViewById(R.id.button_layout_live_buddha);

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

    public void toShow10(View view) {
        buttonBuddha.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/live_1_ru/live10.html";
        } else {
            htmlFilePath = "file:///android_asset/live_1_en/liveEn10.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void toShow11(View view) {
        buttonBuddha.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/live_1_ru/live11.html";
        } else {
            htmlFilePath = "file:///android_asset/live_1_en/liveEn11.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void toShow12(View view) {
        buttonBuddha.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/live_1_ru/live12.html";
        } else {
            htmlFilePath = "file:///android_asset/live_1_en/liveEn12.html";
        }
        loadHtmlPage(htmlFilePath);
    }


    public void toShow13(View view) {
        buttonBuddha.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/live_1_ru/live13.html";
        } else {
            htmlFilePath = "file:///android_asset/live_1_en/liveEn13.html";
        }
        loadHtmlPage(htmlFilePath);
    }
    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toShow1(View view) {
        buttonBuddha.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/live_1_ru/live1.html";
        } else {
            htmlFilePath = "file:///android_asset/live_1_en/liveEn1.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void toShow2(View view) {
        buttonBuddha.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/live_1_ru/live2.html";
        } else {
            htmlFilePath = "file:///android_asset/live_1_en/liveEn2.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void toShow3(View view) {
        buttonBuddha.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/live_1_ru/live3.html";
        } else {
            htmlFilePath = "file:///android_asset/live_1_en/liveEn3.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void toShow4(View view) {
        buttonBuddha.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/live_1_ru/live4.html";
        } else {
            htmlFilePath = "file:///android_asset/live_1_en/liveEn4.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void toShow5(View view) {
        buttonBuddha.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/live_1_ru/live5.html";
        } else {
            htmlFilePath = "file:///android_asset/live_1_en/liveEn5.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void toShow6(View view) {
        buttonBuddha.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/live_1_ru/live6.html";
        } else {
            htmlFilePath = "file:///android_asset/live_1_en/liveEn6.html";
        }
        loadHtmlPage(htmlFilePath);
    }
    public void toShow7(View view) {
        buttonBuddha.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/live_1_ru/live7.html";
        } else {
            htmlFilePath = "file:///android_asset/live_1_en/liveEn7.html";
        }
        loadHtmlPage(htmlFilePath);
    }
    public void toShow8(View view) {
        buttonBuddha.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/live_1_ru/live8.html";
        } else {
            htmlFilePath = "file:///android_asset/live_1_en/liveEn8.html";
        }
        loadHtmlPage(htmlFilePath);
    }
    public void toShow9(View view) {
        buttonBuddha.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/live_1_ru/live9.html";
        } else {
            htmlFilePath = "file:///android_asset/live_1_en/liveEn9.html";
        }
        loadHtmlPage(htmlFilePath);
    }



    public void toLiveBack(View view){
        webView.setVisibility(View.INVISIBLE);
        buttonBuddha.setVisibility(View.INVISIBLE);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(MainActivity.class);
    }

}