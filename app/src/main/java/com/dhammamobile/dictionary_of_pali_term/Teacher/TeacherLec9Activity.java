package com.dhammamobile.dictionary_of_pali_term.Teacher;

import androidx.appcompat.app.AppCompatActivity;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

import java.util.Locale;

public class TeacherLec9Activity extends BaseActivityClass {

    Button plusText, minusText;
    WebView webView; // Declare WebView as a class member for easy access
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Здесь вы можете добавить свои действия при изменении ориентации, если это необходимо
    }

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateLocale(); // Установка языка
        setContentView(R.layout.activity_teacher_lec9);

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        plusText = findViewById(R.id.buttonPlusTextTeacher9);
        minusText = findViewById(R.id.buttonMinusTextTeacher9);

        WebView webView = findViewById(R.id.webViewLec9);
        // Получить настройки WebView
        WebSettings webSettings = webView.getSettings();

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
            htmlFilePath = "file:///android_asset/lec_ru/lec9.html";
        } else {
            htmlFilePath = "file:///android_asset/lec_ru/lecEn9.html";
        }

        webView.loadUrl(htmlFilePath);

        // Set click listeners for buttons
        plusText.setOnClickListener(v -> {
            // Call JavaScript function to increase font size
            webView.evaluateJavascript("increaseFontSize();", null);
        });

        minusText.setOnClickListener(v -> {
            // Call JavaScript function to decrease font size
            webView.evaluateJavascript("decreaseFontSize();", null);
        });
    }

    protected void onResume() {
        super.onResume();
    }

    public void toBack(View view){
        startIntentActivityAndFinish(TeacherActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(TeacherActivity.class);
    }
}