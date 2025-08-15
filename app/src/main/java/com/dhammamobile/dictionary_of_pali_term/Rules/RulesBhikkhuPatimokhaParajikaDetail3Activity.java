package com.dhammamobile.dictionary_of_pali_term.Rules;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

import java.util.Locale;

public class RulesBhikkhuPatimokhaParajikaDetail3Activity extends BaseActivityClass {
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

    public WebView webView;
    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateLocale(); // Установка языка
        setContentView(R.layout.activity_rules_bhikkhu_patimokha_parajika_detail3);

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        webView = findViewById(R.id.webViewParajikaDetail3);



        webView.getSettings().setBuiltInZoomControls(true); // Разрешить встроенное масштабирование
        webView.getSettings().setSupportZoom(true); // Разрешить поддержку жестов масштабирования
        webView.getSettings().setDisplayZoomControls(false); // Скрыть контролы масштабирования
        webView.getSettings().setUseWideViewPort(true); // Разрешить широкий видовой порт

        webView.getSettings().setJavaScriptEnabled(true); // Разрешить JavaScript, если нужно
        webView.clearCache(true);

        // Получить текущий язык устройства
        String currentLanguage = Locale.getDefault().getLanguage();
        // Определить путь к HTML файлу в соответствии с текущим языком
        String htmlFilePath;
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/par_detail_ru/pr3.html";
        } else {
            htmlFilePath = "file:///android_asset/par_detail_en/pr3.html";
        }

        webView.loadUrl(htmlFilePath);
        loadHtmlPage(htmlFilePath);
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

    @Override
    protected void onResume() {
        super.onResume();
    }


    public void toBack(View view){
        saveScrollPosition();
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaParajikaActivity.class);
    }

    public void toMainAct(View view){
        saveScrollPosition();
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed() {
        saveScrollPosition();
        super.onBackPressed();
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaParajikaActivity.class);
    }
}