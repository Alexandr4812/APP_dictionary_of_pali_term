package com.dhammamobile.dictionary_of_pali_term.Abhidhamma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

import java.util.Locale;

public class AbhidhammaChittasRupavacaraActivity extends BaseActivityClass {

    LinearLayout buttonInfo;
    Button plusText, minusText;
    WebView webView; // Declare WebView as a class member for easy access

    private TextView textViewAbhidhammaRupavacaraKusala;

    private Button infoButtonAbhidhammaRupavacaraKusala;

    private TextView textViewAbhidhammaRupavacaraVipaka;

    private Button infoButtonAbhidhammaRupavacaraVipaka;

    private TextView textViewAbhidhammaRupavacaraKriya;

    private Button infoButtonAbhidhammaRupavacaraKriya;

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateLocale(); // Установка языка
        setContentView(R.layout.activity_abhidhamma_chittas_rupavacara);

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

        webView = findViewById(R.id.webViewRupavachara);

        buttonInfo = findViewById(R.id.button_layout_live_buddha);

        textViewAbhidhammaRupavacaraKusala = findViewById(R.id.textViewAbhidhammaRupavacaraKusala);
        infoButtonAbhidhammaRupavacaraKusala = findViewById(R.id.infoButtonRupavacaraKusala);

        textViewAbhidhammaRupavacaraVipaka = findViewById(R.id.textViewAbhidhammaRupavacaraVipaka);
        infoButtonAbhidhammaRupavacaraVipaka = findViewById(R.id.infoButtonRupavacaraVipaka);

        textViewAbhidhammaRupavacaraKriya = findViewById(R.id.textViewAbhidhammaRupavacaraKriya);
        infoButtonAbhidhammaRupavacaraKriya = findViewById(R.id.infoButtonRupavacaraKriya);

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

    public void toShowInfo(View view) {
        buttonInfo.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/info_rupavachara_arupavachara_ru/infoRupavacharaRu.html";
        } else {
            htmlFilePath = "file:///android_asset/info_rupavachara_arupavachara_en/infoRupavacharaEn.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void onButtonClickAbhidhammaRupavacaraKusala(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaRupavacaraKusala.getVisibility();
        textViewAbhidhammaRupavacaraKusala.setText("");
        textViewAbhidhammaRupavacaraVipaka.setText("");
        textViewAbhidhammaRupavacaraKriya.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaRupavacaraKusala.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaRupavacaraKusala.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaRupavacaraKusala) {
                textViewAbhidhammaRupavacaraKusala.setText(R.string.textDiscribeRupavacaraKusala);
                textViewAbhidhammaRupavacaraKusala.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala, getString(R.string.textDiscribeRupavacaraKusala));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaRupavacaraVipaka(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaRupavacaraVipaka.getVisibility();
        textViewAbhidhammaRupavacaraKusala.setText("");
        textViewAbhidhammaRupavacaraVipaka.setText("");
        textViewAbhidhammaRupavacaraKriya.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaRupavacaraVipaka.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaRupavacaraVipaka.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaRupavacaraVipaka) {
                textViewAbhidhammaRupavacaraVipaka.setText(R.string.textDiscribeRupavacaraVipaka);
                textViewAbhidhammaRupavacaraVipaka.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraVipaka, getString(R.string.textDiscribeRupavacaraVipaka));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaRupavacaraKriya(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaRupavacaraKriya.getVisibility();
        textViewAbhidhammaRupavacaraKusala.setText("");
        textViewAbhidhammaRupavacaraVipaka.setText("");
        textViewAbhidhammaRupavacaraKriya.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaRupavacaraKriya.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaRupavacaraKriya.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaRupavacaraKriya) {
                textViewAbhidhammaRupavacaraKriya.setText(R.string.textDiscribeRupavacaraKriya);
                textViewAbhidhammaRupavacaraKriya.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKriya, getString(R.string.textDiscribeRupavacaraKriya));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
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

    public void toAbhidhammaChittasAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasActivity.class);
    }

    public void toAbhidhammaChittasRupavacaraKusalaAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasRupavacaraKusalaActivity.class);
    }

    public void toAbhidhammaChittasRupavacaraKriyaAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasRupavacaraKriyaActivity.class);
    }

    public void toAbhidhammaChittasRupavacaraVipakaAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasRupavacaraVipakaActivity.class);
    }





    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toLiveBack(View view){
        webView.setVisibility(View.INVISIBLE);
        buttonInfo.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(AbhidhammaChittasActivity.class);
    }
}