package com.dhammamobile.dictionary_of_pali_term;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class AbhidhammaChittasKamavacharamUnwholsomeActivity extends BaseActivityClass {

    private TextView textViewAbhidhammaKammavacharamUnwholsomeLobha;

    private Button infoButtonAbhidhammaKammavacharamUnwholsomeLobha;

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_kamavacharam_unwholsome);

        setWindowFlagsFullscreenAndNoLimits();

        textViewAbhidhammaKammavacharamUnwholsomeLobha = findViewById(R.id.textViewAbhidhammaKammavacharamUnwholsomeLobha);
        infoButtonAbhidhammaKammavacharamUnwholsomeLobha = findViewById(R.id.infoButtonKamamavacharaUwholsomeLobha);
    }

    public void onButtonClickAbhidhammaKammavacharamUnwholsomeLobha(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeLobha.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeLobha.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeLobha.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeLobha.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaKammavacharamUnwholsomeLobha) {
                textViewAbhidhammaKammavacharamUnwholsomeLobha.setText(R.string.textDiscribeKamavacharachitamUnwholsomeLobha);
                textViewAbhidhammaKammavacharamUnwholsomeLobha.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobha, getString(R.string.textDiscribeKamavacharachitamUnwholsomeLobha));
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

    public void toAbhidhammaChittasKamavacharam(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamActivity.class);
    }

    public void toAbhidhammaChittasKamavacharamUnwholsomeLobhamulachitaniAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamUnwholsomeLobhamulachitaniActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamActivity.class);
    }
}