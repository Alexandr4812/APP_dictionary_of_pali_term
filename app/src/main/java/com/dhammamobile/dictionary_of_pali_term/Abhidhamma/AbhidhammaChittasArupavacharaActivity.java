package com.dhammamobile.dictionary_of_pali_term.Abhidhamma;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

import java.util.Locale;

public class AbhidhammaChittasArupavacharaActivity extends BaseActivityClass {

    LinearLayout buttonInfo;
    Button plusText, minusText;
    WebView webView; // Declare WebView as a class member for easy access

    private TextView textViewAbhidhammaArupavacharamWholsome;

    private Button infoButtonAbhidhammaArupavacharamWholsome;

    private TextView textViewAbhidhammaArupavacharaVipaka;

    private Button infoButtonAbhidhammaArupavacharaVipaka;

    private TextView textViewAbhidhammaArupavacharaFunkcional;

    private Button infoButtonAbhidhammaArupavacharaFunkcional;

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateLocale(); // Установка языка
        setContentView(R.layout.activity_abhidhamma_chittas_arupavachara);

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

        webView = findViewById(R.id.webViewuArupavachara);

        buttonInfo = findViewById(R.id.button_layout_live_buddha);

        textViewAbhidhammaArupavacharamWholsome = findViewById(R.id.textViewAbhidhammaArupavacharamWholsome);
        infoButtonAbhidhammaArupavacharamWholsome = findViewById(R.id.infoButtonArupavacharaWholsome);

        textViewAbhidhammaArupavacharaVipaka = findViewById(R.id.textViewAbhidhammaArupavacharaVipaka);
        infoButtonAbhidhammaArupavacharaVipaka = findViewById(R.id.infoButtonArupavacharaVipaka);

        textViewAbhidhammaArupavacharaFunkcional = findViewById(R.id.textViewAbhidhammaArupavacharaFunkcional);
        infoButtonAbhidhammaArupavacharaFunkcional = findViewById(R.id.infoButtonArupavacharaFunkcional);

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

    public void toShowInfoArupavacara(View view) {
        buttonInfo.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/info_rupavachara_arupavachara_lokutara_ru/commentArupalokaRu.html";
        } else {
            htmlFilePath = "file:///android_asset/info_rupavachara_arupavachara_lokutara_en/commentArupalokaEn.html";
        }
        loadHtmlPage(htmlFilePath);
    }


    public void onButtonClickAbhidhammaArupavacharamWholsome(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaArupavacharamWholsome.getVisibility();
        textViewAbhidhammaArupavacharamWholsome.setText("");
        textViewAbhidhammaArupavacharaVipaka.setText("");
        textViewAbhidhammaArupavacharaFunkcional.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaArupavacharamWholsome.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaArupavacharamWholsome.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaArupavacharamWholsome) {
                textViewAbhidhammaArupavacharamWholsome.setText(R.string.textDiscribeArupavacharaWholsome);
                textViewAbhidhammaArupavacharamWholsome.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharamWholsome, getString(R.string.textDiscribeArupavacharaWholsome));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaArupavacharaVipaka(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaArupavacharaVipaka.getVisibility();
        textViewAbhidhammaArupavacharamWholsome.setText("");
        textViewAbhidhammaArupavacharaVipaka.setText("");
        textViewAbhidhammaArupavacharaFunkcional.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaArupavacharaVipaka.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaArupavacharaVipaka.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaArupavacharaVipaka) {
                textViewAbhidhammaArupavacharaVipaka.setText(R.string.textDiscribeArupavacharaResult);
                textViewAbhidhammaArupavacharaVipaka.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaVipaka, getString(R.string.textDiscribeArupavacharaResult));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaArupavacharaFunkcional(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaArupavacharaFunkcional.getVisibility();
        textViewAbhidhammaArupavacharamWholsome.setText("");
        textViewAbhidhammaArupavacharaVipaka.setText("");
        textViewAbhidhammaArupavacharaFunkcional.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaArupavacharaFunkcional.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaArupavacharaFunkcional.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaArupavacharaFunkcional) {
                textViewAbhidhammaArupavacharaFunkcional.setText(R.string.textDiscribeArupavacharaFunkcional);
                textViewAbhidhammaArupavacharaFunkcional.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaFunkcional, getString(R.string.textDiscribeArupavacharaFunkcional));
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

    public void toAbhidhammaChittasArupavacharamWholsomeAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasArupavacharaWholsomeActivity.class);
    }

    public void toAbhidhammaChittasArupavacharaVipakaAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasArupavacharaResultActivity.class);
    }

    public void toAbhidhammaChittasArupavacharaFunkcionalAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasArupavacharaFunkcionalActivity.class);
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