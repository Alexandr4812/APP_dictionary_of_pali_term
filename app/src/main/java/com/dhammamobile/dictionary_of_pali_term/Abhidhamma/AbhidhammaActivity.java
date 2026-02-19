package com.dhammamobile.dictionary_of_pali_term.Abhidhamma;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

import java.util.Locale;

public class AbhidhammaActivity extends BaseActivityClass {

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Здесь вы можете добавить свои действия при изменении ориентации, если это необходимо
    }

    LinearLayout buttonAbhidhamma;
    Button plusText, minusText;
    WebView webView; // Declare WebView as a class member for easy access

    private TextView textViewAbhidhammaChitta, textViewAbhidhammaChitasikas, textViewAbhidhammaMaterial, textViewAbhidhammaNibbana;
    private Button button1, button2, button3, button4, infoButton1, infoButton2, infoButton3,
            tableButton1, tableButton2;

    private Button buttonHarakteristika, buttonFunkciya, buttonProyavlenie, buttonPrichina;
    private Button buttonMaterialHarakteristika, buttonMaterialFunkciya, buttonMaterialProyavlenie, buttonMaterialPrichina;
    private Button buttonNibbanaHarakteristika, buttonNibbanaFunkciya, buttonNibbanaProyavlenie, buttonNibbanaPrichina;

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateLocale(); // Установка языка
        setContentView(R.layout.activity_abhidhamma);

       // setWindowFlagsFullscreenAndNoLimits();
        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        plusText = findViewById(R.id.buttonPlusAbhidhamma);
        minusText = findViewById(R.id.buttonMinusAbhidhamma);

        webView = findViewById(R.id.webViewAbhidhamma);

        buttonAbhidhamma = findViewById(R.id.button_layout_abhidhamma);

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

        textViewAbhidhammaChitta = findViewById(R.id.textViewAbhidhammaChitta);
        textViewAbhidhammaChitasikas = findViewById(R.id.textViewAbhidhammaChetasika);
        textViewAbhidhammaMaterial = findViewById(R.id.textViewAbhidhammaMaterial);
        textViewAbhidhammaNibbana = findViewById(R.id.textViewAbhidhammaNibbana);

        tableButton1 = findViewById(R.id.tableButton1);
        tableButton2 = findViewById(R.id.tableButton2);

        infoButton1 = findViewById(R.id.infoButton1);
        button1 = findViewById(R.id.button_mentalnie_faktori);
        infoButton2 = findViewById(R.id.infoButton2);
        button2 = findViewById(R.id.button_chittas);
        infoButton3 = findViewById(R.id.infoButton3);
        button3 = findViewById(R.id.button_materials);
        button4 = findViewById(R.id.button_nibbana);

        buttonHarakteristika = findViewById(R.id.button_chitta_harakteristika);
        buttonFunkciya = findViewById(R.id.button_chitta_function);
        buttonProyavlenie = findViewById(R.id.button_chitta_proyavlenie);
        buttonPrichina = findViewById(R.id.button_chitta_prichina);

        buttonMaterialHarakteristika = findViewById(R.id.button_material_harakteristika);
        buttonMaterialFunkciya = findViewById(R.id.button_material_function);
        buttonMaterialProyavlenie = findViewById(R.id.button_material_proyavlenie);
        buttonMaterialPrichina = findViewById(R.id.button_material_prichina);

        buttonNibbanaHarakteristika = findViewById(R.id.button_nibbana_harakteristika);
        buttonNibbanaFunkciya = findViewById(R.id.button_nibbana_function);
        buttonNibbanaProyavlenie = findViewById(R.id.button_nibbana_proyavlenie);
        buttonNibbanaPrichina = findViewById(R.id.button_nibbana_prichina);



        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        Animation slideFromLeftAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_left);
        Animation slideFromRightAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_right);

        infoButton1.setAnimation(slideDown);
        tableButton1.setAnimation(slideFromLeftAnimation);
        tableButton2.setAnimation(slideFromLeftAnimation);
        infoButton2.setAnimation(slideDown);
        infoButton3.setAnimation(slideDown);
        button1.startAnimation(slideFromLeftAnimation);
        button2.startAnimation(slideFromRightAnimation);
        button3.startAnimation(slideFromLeftAnimation);
        button4.startAnimation(slideFromRightAnimation);
        ImageView im1 = findViewById(R.id.imageVievAbhidhamma1);
        im1.startAnimation(slideDown);
    }

    private void loadHtmlPage(String htmlFilePath) {
        webView.loadUrl(htmlFilePath);
    }

    public void nibbanaAbhidhammaText(View view) {
        buttonAbhidhamma.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/abhidhamma_ru/nibannaRu.html";
        } else {
            htmlFilePath = "file:///android_asset/abhidhamma_en/nibbanaEn.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void tableChittas1(View view) {
        buttonAbhidhamma.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/abhidhamma_ru/table_chittas_ru1.html";
        } else {
            htmlFilePath = "file:///android_asset/abhidhamma_en/table_chittas_en1.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void tableChittas2(View view) {
        buttonAbhidhamma.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/abhidhamma_ru/table_chetasikas_ru.html";
        } else {
            htmlFilePath = "file:///android_asset/abhidhamma_en/table_chetasikas_en.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void onButtonClickAbhidhamma1(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaChitta.getVisibility();
        textViewAbhidhammaChitasikas.setText("");
        textViewAbhidhammaChitta.setText("");
        textViewAbhidhammaMaterial.setText("");
        textViewAbhidhammaNibbana.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaChitta.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaChitta.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButton1) {
                textViewAbhidhammaChitta.setText(R.string.text_for_chittas);
                textViewAbhidhammaChitta.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaChitta, getString(R.string.text_for_chittas));
            } else if (clickedButton == buttonHarakteristika) {
                textViewAbhidhammaChitta.setText(R.string.text_for_chitta_harakteristika);
                textViewAbhidhammaChitta.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaChitta, getString(R.string.text_for_chitta_harakteristika));
            } else if (clickedButton == buttonFunkciya) {
                textViewAbhidhammaChitta.setText(R.string.text_for_chitta_function);
                textViewAbhidhammaChitta.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaChitta, getString(R.string.text_for_chitta_function));
            } else if (clickedButton == buttonProyavlenie) {
                textViewAbhidhammaChitta.setText(R.string.text_for_chitta_proyavlenie);
                textViewAbhidhammaChitta.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaChitta, getString(R.string.text_for_chitta_proyavlenie));
            } else if (clickedButton == buttonPrichina) {
                textViewAbhidhammaChitta.setText(R.string.text_for_chitta_prichina);
                textViewAbhidhammaChitta.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaChitta, getString(R.string.text_for_chitta_prichina));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhamma2(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaChitasikas.getVisibility();
        textViewAbhidhammaChitasikas.setText("");
        textViewAbhidhammaChitta.setText("");
        textViewAbhidhammaMaterial.setText("");
        textViewAbhidhammaNibbana.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaChitasikas.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaChitasikas.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButton2) {
                textViewAbhidhammaChitasikas.setText(R.string.text_for_chittasiki);
                textViewAbhidhammaChitasikas.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaChitasikas, getString(R.string.text_for_chittasiki));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhamma3(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaMaterial.getVisibility();
        textViewAbhidhammaChitasikas.setText("");
        textViewAbhidhammaChitta.setText("");
        textViewAbhidhammaMaterial.setText("");
        textViewAbhidhammaNibbana.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaMaterial.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaMaterial.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButton3) {
                textViewAbhidhammaMaterial.setText(R.string.text_for_info_button_materials);
                textViewAbhidhammaMaterial.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaMaterial, getString(R.string.text_for_info_button_materials));
            } else if (clickedButton == buttonMaterialHarakteristika) {
                textViewAbhidhammaMaterial.setText(R.string.text_for_harakteristika_materials);
                textViewAbhidhammaMaterial.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaMaterial, getString(R.string.text_for_harakteristika_materials));
            } else if (clickedButton == buttonMaterialFunkciya) {
                textViewAbhidhammaMaterial.setText(R.string.text_for_function_materials);
                textViewAbhidhammaMaterial.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaMaterial, getString(R.string.text_for_function_materials));
            } else if (clickedButton == buttonMaterialProyavlenie) {
                textViewAbhidhammaMaterial.setText(R.string.text_for_proyavlenie_materials);
                textViewAbhidhammaMaterial.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaMaterial, getString(R.string.text_for_proyavlenie_materials));
            } else if (clickedButton == buttonMaterialPrichina) {
                textViewAbhidhammaMaterial.setText(R.string.text_for_prichina_materials);
                textViewAbhidhammaMaterial.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaMaterial, getString(R.string.text_for_prichina_materials));
            } else if (clickedButton == button3) {
                textViewAbhidhammaMaterial.setText(R.string.inProcess);
                textViewAbhidhammaMaterial.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaMaterial, getString(R.string.inProcess));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhamma4(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaNibbana.getVisibility();
        textViewAbhidhammaChitasikas.setText("");
        textViewAbhidhammaChitta.setText("");
        textViewAbhidhammaMaterial.setText("");
        textViewAbhidhammaNibbana.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaMaterial.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaMaterial.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == buttonNibbanaHarakteristika) {
                textViewAbhidhammaNibbana.setText(R.string.text_for_harakteristika_nibbana);
                textViewAbhidhammaNibbana.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaNibbana, getString(R.string.text_for_harakteristika_nibbana));
            } else if (clickedButton == buttonNibbanaFunkciya) {
                textViewAbhidhammaNibbana.setText(R.string.text_for_function_nibbana);
                textViewAbhidhammaNibbana.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaNibbana, getString(R.string.text_for_function_nibbana));
            } else if (clickedButton == buttonNibbanaProyavlenie) {
                textViewAbhidhammaNibbana.setText(R.string.text_for_proyavlenie_nibbana);
                textViewAbhidhammaNibbana.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaNibbana, getString(R.string.text_for_proyavlenie_nibbana));
            } else if (clickedButton == buttonNibbanaPrichina) {
                textViewAbhidhammaNibbana.setText(R.string.text_for_prichina_nibbana);
                textViewAbhidhammaNibbana.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaNibbana, getString(R.string.text_for_prichina_nibbana));
            } else if (clickedButton == button4) {
                nibbanaAbhidhammaText(view);
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

    public void toChetasikasAct(View view){
        startIntentActivityAndFinish(AbhidhammaChetasikasActivity.class);
    }

    public void toChittasAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasActivity.class);
    }

    public void toAbhidhammaBack(View view){
        webView.setVisibility(View.INVISIBLE);
        buttonAbhidhamma.setVisibility(View.INVISIBLE);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(MainActivity.class);
    }
}