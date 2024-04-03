package com.dhammamobile.dictionary_of_pali_term;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhammamobile.dictionary_of_pali_term.R;

public class AbhidhammaActivity extends BaseActivityClass {

    private TextView textViewAbhidhammaChitta, textViewAbhidhammaChitasikas;
    private Button button1, button2, infoButton1, infoButton2;
    private Button buttonHarakteristika, buttonFunkciya, buttonProyavlenie, buttonPrichina;

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma);

       // setWindowFlagsFullscreenAndNoLimits();
        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textViewAbhidhammaChitta = findViewById(R.id.textViewAbhidhammaChitta);
        textViewAbhidhammaChitasikas = findViewById(R.id.textViewAbhidhammaChetasika);

        infoButton1 = findViewById(R.id.infoButton1);
        button1 = findViewById(R.id.button_mentalnie_faktori);
        infoButton2 = findViewById(R.id.infoButton2);
        button2 = findViewById(R.id.button_chittas);

        buttonHarakteristika = findViewById(R.id.button_chitta_harakteristika);
        buttonFunkciya = findViewById(R.id.button_chitta_function);
        buttonProyavlenie = findViewById(R.id.button_chitta_proyavlenie);
        buttonPrichina = findViewById(R.id.button_chitta_prichina);



        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        Animation slideFromLeftAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_left);
        Animation slideFromRightAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_right);

        infoButton1.setAnimation(slideDown);
        button1.startAnimation(slideFromLeftAnimation);
        infoButton2.setAnimation(slideDown);
        button2.startAnimation(slideFromRightAnimation);
        ImageView im1 = findViewById(R.id.imageVievAbhidhamma1);
        im1.startAnimation(slideDown);
    }

    public void onButtonClickAbhidhamma1(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaChitta.getVisibility();
        textViewAbhidhammaChitasikas.setText("");

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
        textViewAbhidhammaChitta.setText("");

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

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(MainActivity.class);
    }
}