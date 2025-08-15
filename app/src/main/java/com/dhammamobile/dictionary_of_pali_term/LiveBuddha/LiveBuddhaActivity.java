package com.dhammamobile.dictionary_of_pali_term.LiveBuddha;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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
    int savedScrollY = 0;
    private String currentHtmlFilePath; // полный путь к HTML
    private String getBookmarkKeyFromPath(String fullPath) {
        return fullPath.replace("file:///android_asset/", "");
    }

    LinearLayout buttonBuddha;
    Button plusText, minusText, buttonZakladka;
    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateLocale(); // Установка языка
        setContentView(R.layout.activity_live_buddha);

       // setWindowFlagsFullscreenAndNoLimits();

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

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

    private void saveScrollPosition() {
        if (currentHtmlFilePath == null) return;

        webView.evaluateJavascript("window.scrollY.toString()", value -> {
            try {
                if (value == null || value.equals("null") || value.equals("")) return;

                value = value.replaceAll("\"", "");
                float scrollYFloat = Float.parseFloat(value);
                int scrollY = Math.round(scrollYFloat);

                SharedPreferences prefs = getSharedPreferences("Bookmarks", MODE_PRIVATE);
                String key = getBookmarkKeyFromPath(currentHtmlFilePath);
                prefs.edit().putInt("scroll_" + key, scrollY).apply();

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
    }

    private void loadHtmlPage(String htmlFilePath) {
        currentHtmlFilePath = htmlFilePath;

        // Получаем сохранённую позицию
        SharedPreferences prefs = getSharedPreferences("Bookmarks", MODE_PRIVATE);
        String key = getBookmarkKeyFromPath(htmlFilePath);
        savedScrollY = prefs.getInt("scroll_" + key, 0);

        webView.loadUrl(htmlFilePath);

        // После полной загрузки страницы — прокручиваем
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                // Устанавливаем позицию с небольшой задержкой
                webView.postDelayed(() -> {
                    webView.evaluateJavascript(
                            "window.scrollTo({ top: " + savedScrollY + ", behavior: 'smooth' });",
                            null);

                }, 100);
            }
        });
    }

    public void showHtmlByNumber(View view) {
        Object tagObj = view.getTag();
        if (tagObj == null) return;

        String tag = tagObj.toString();
        String currentLanguage = Locale.getDefault().getLanguage();

        String htmlFilePath;
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/live_1_ru/live" + tag + ".html";
        } else {
            htmlFilePath = "file:///android_asset/live_1_en/liveEn" + tag + ".html";
        }

        buttonBuddha.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        loadHtmlPage(htmlFilePath);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toLiveBack(View view){
        saveScrollPosition();
        webView.setVisibility(View.INVISIBLE);
        buttonBuddha.setVisibility(View.INVISIBLE);
    }


    @Override
    public void onBackPressed() {
        saveScrollPosition();
        super.onBackPressed();
        startIntentActivityAndFinish(MainActivity.class);
    }

}