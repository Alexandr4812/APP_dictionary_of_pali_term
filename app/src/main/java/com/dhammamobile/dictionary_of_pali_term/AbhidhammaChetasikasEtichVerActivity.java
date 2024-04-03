package com.dhammamobile.dictionary_of_pali_term;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class AbhidhammaChetasikasEtichVerActivity extends BaseActivityClass {

    private TextView textViewAbhidhammaEticheskiVeriabelnieUnivers;

    private Button infoButtonAbhidhammaEticheskiVeriabelnieUnivers;

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chetasikas_etich_ver);

       // setWindowFlagsFullscreenAndNoLimits();
        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textViewAbhidhammaEticheskiVeriabelnieUnivers = findViewById(R.id.textViewAbhidhammaEticheskiVerUnivers);
        infoButtonAbhidhammaEticheskiVeriabelnieUnivers = findViewById(R.id.infoButtonEticheskiVeriabelnieUnivers);
    }

    public void onButtonClickAbhidhammaEyicheskiVeriabelnieUnivers(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaEticheskiVeriabelnieUnivers.getVisibility();
        textViewAbhidhammaEticheskiVeriabelnieUnivers.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaEticheskiVeriabelnieUnivers.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaEticheskiVeriabelnieUnivers.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaEticheskiVeriabelnieUnivers) {
                textViewAbhidhammaEticheskiVeriabelnieUnivers.setText(R.string.textDescribeEtichVeriabUniversal);
                textViewAbhidhammaEticheskiVeriabelnieUnivers.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaEticheskiVeriabelnieUnivers, getString(R.string.textDescribeEtichVeriabUniversal));
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

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toChetasikasAct(View view){
        startIntentActivityAndFinish(AbhidhammaChetasikasActivity.class);
    }

    public void toChetasikasEtichVerUniversalAct(View view){
        startIntentActivityAndFinish(AbhidhammaChetasikasEtichVerUniversActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(AbhidhammaChetasikasActivity.class);
    }
}