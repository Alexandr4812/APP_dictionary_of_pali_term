package com.dhammamobile.dictionary_of_pali_term.Teacher;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

import java.util.Locale;

public class TeacherActivity extends BaseActivityClass {

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

    LinearLayout buttonTeacher;
    Button plusText, minusText, buttonZakladka;
    WebView webView;


    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateLocale(); // Установка языка
        setContentView(R.layout.activity_teacher);


        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        plusText = findViewById(R.id.buttonPlusTextTeacher);
        minusText = findViewById(R.id.buttonMinusTextTeacher);

        webView = findViewById(R.id.webViewTeacher);

        buttonTeacher = findViewById(R.id.button_layout_teacher);

        ImageView im1 =findViewById(R.id.img_1);
        Button button1 = findViewById(R.id.button_teacher_about);
        ImageView im2 =findViewById(R.id.img_2);
        Button button1_12 = findViewById(R.id.button_lecture1_12);
        Button button8 = findViewById(R.id.button_lecture7);
        Button button9 = findViewById(R.id.button_lecture8);
        Button button10 = findViewById(R.id.button_lecture9);
        Button button11 = findViewById(R.id.button_lecture10);
        Button button2 = findViewById(R.id.button_lecture1);
        Button button3 = findViewById(R.id.button_lecture2);
        Button button4 = findViewById(R.id.button_lecture3);
        Button button5 = findViewById(R.id.button_lecture4);
        Button button6 = findViewById(R.id.button_lecture5);
        Button button7 = findViewById(R.id.button_lecture6);
        Button button12 = findViewById(R.id.button_lecture11);

        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        Animation slideFromLeftAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_left);
        Animation slideFromRightAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_right);

        im1.startAnimation(slideDown);
        button1.startAnimation(slideFromLeftAnimation);
        im2.startAnimation(slideFromRightAnimation);
        button1_12.startAnimation(slideFromLeftAnimation);
        button8.startAnimation(slideFromRightAnimation);
        button9.startAnimation(slideFromLeftAnimation);
        button10.startAnimation(slideFromRightAnimation);
        button11.startAnimation(slideFromLeftAnimation);
        button2.startAnimation(slideFromRightAnimation);
        button3.startAnimation(slideFromLeftAnimation);
        button4.startAnimation(slideFromRightAnimation);
        button5.startAnimation(slideFromLeftAnimation);
        button6.startAnimation(slideFromRightAnimation);
        button7.startAnimation(slideFromLeftAnimation);
        button12.startAnimation(slideFromRightAnimation);

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
            htmlFilePath = "file:///android_asset/lec_ru/lec" + tag + ".html";
        } else {
            htmlFilePath = "file:///android_asset/lec_ru/lecEn" + tag + ".html";
        }

        buttonTeacher.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        loadHtmlPage(htmlFilePath);
    }

    protected void onResume() {
        super.onResume();
    }

    public void toTeacherAboutAct(View view){
        startIntentActivityAndFinish(TeacherAboutActivity.class);
    }



    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toBack(View view){
        saveScrollPosition();
        webView.setVisibility(View.INVISIBLE);
        buttonTeacher.setVisibility(View.INVISIBLE);
    }



    @Override
    public void onBackPressed() {
        saveScrollPosition();
        super.onBackPressed();
        startIntentActivityAndFinish(MainActivity.class);
    }
}