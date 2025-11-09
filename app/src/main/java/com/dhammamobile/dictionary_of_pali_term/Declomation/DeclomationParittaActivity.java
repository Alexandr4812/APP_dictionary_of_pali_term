package com.dhammamobile.dictionary_of_pali_term.Declomation;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

import java.util.Locale;


public class DeclomationParittaActivity extends BaseActivityClass {

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Здесь вы можете добавить свои действия при изменении ориентации, если это необходимо
    }

    private TextView textViewParittaGirimananda;

    private Button infoButtonParittaGirimananda;

    private TextView textViewParittaKhanda;

    private Button infoButtonParittaKhanda;
    LinearLayout buttonParittas;
    Button plusText, minusText;
    WebView webView; // Declare WebView as a class member for easy access

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateLocale(); // Установка языка
        setContentView(R.layout.activity_declomation_paritta);

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        plusText = findViewById(R.id.buttonPlusParittas);
        minusText = findViewById(R.id.buttonMinusParittas);

        webView = findViewById(R.id.webViewParittas);

        buttonParittas = findViewById(R.id.button_layout_parittas);

        textViewParittaGirimananda = findViewById(R.id.textViewParittaGirimananda);
        infoButtonParittaGirimananda = findViewById(R.id.infoButtonGirimananda);
        textViewParittaKhanda = findViewById(R.id.textViewParittaKhanda);
        infoButtonParittaKhanda = findViewById(R.id.infoButtonKhanda);

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

    public void onButtonClickParittaGirimananda(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewParittaGirimananda.getVisibility();
        textViewParittaGirimananda.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewParittaGirimananda.setText(""); // Установите текст в пустую строку
            textViewParittaGirimananda.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonParittaGirimananda) {
                textViewParittaGirimananda.setText(R.string.textDiscribeGirimananda);
                textViewParittaGirimananda.setVisibility(View.VISIBLE);
                animateText(textViewParittaGirimananda, getString(R.string.textDiscribeGirimananda));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickParittaKhanda(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewParittaGirimananda.getVisibility();
        textViewParittaGirimananda.setText("");
        textViewParittaKhanda.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewParittaKhanda.setText(""); // Установите текст в пустую строку
            textViewParittaKhanda.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonParittaKhanda) {
                textViewParittaKhanda.setText(R.string.textDiscribeKhanda);
                textViewParittaKhanda.setVisibility(View.VISIBLE);
                animateText(textViewParittaKhanda, getString(R.string.textDiscribeKhanda));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }
    private void loadHtmlPage(String htmlFilePath) {
        webView.loadUrl(htmlFilePath);
    }

    public void moraParitta(View view) {
        buttonParittas.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/parittas_ru/moraParittaRu.html";
        } else {
            htmlFilePath = "file:///android_asset/parittas_en/moraParittaEn.html";
        }
        loadHtmlPage(htmlFilePath);
    }
    public void angulimalaParitta(View view) {
        buttonParittas.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/parittas_ru/angulimalaParittaRu.html";
        } else {
            htmlFilePath = "file:///android_asset/parittas_en/angulimalaParittaEn.html";
        }
        loadHtmlPage(htmlFilePath);
    }
    public void girimanandaParitta(View view) {
        buttonParittas.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/parittas_ru/girimananda_ru.html";
        } else {
            htmlFilePath = "file:///android_asset/parittas_en/girimananda_en.html";
        }
        loadHtmlPage(htmlFilePath);
    }
    public void khandaParitta(View view) {
        buttonParittas.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/parittas_ru/khanda_paritta_ru.html";
        } else {
            htmlFilePath = "file:///android_asset/parittas_en/khanda_paritta_en.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    private void animateText(TextView targetTextView, String textToAnimate) {
        animator = ValueAnimator.ofInt(0, textToAnimate.length());
        animator.setDuration(1000); // Продолжительность анимации в миллисекундах
        animator.addUpdateListener(animation -> {
            int animatedValue = (int) animation.getAnimatedValue();
            String partialText = textToAnimate.substring(0, animatedValue);
            targetTextView.setText(partialText);
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                // Анимация завершена
            }
        });
        animator.start();
    }

    private void resetAnimator() {
        // Остановить и сбросить аниматор
        if (animator != null) {
            animator.cancel();
        }
    }

    public void toDeclomation(View view){
        startIntentActivityAndFinish(DeklomationMainActivity.class);
    }

    public void toParittasBack(View view){
        webView.setVisibility(View.INVISIBLE);
        buttonParittas.setVisibility(View.INVISIBLE);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(DeklomationMainActivity.class);
    }

}