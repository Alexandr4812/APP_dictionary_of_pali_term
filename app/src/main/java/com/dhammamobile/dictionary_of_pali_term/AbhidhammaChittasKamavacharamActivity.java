package com.dhammamobile.dictionary_of_pali_term;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class AbhidhammaChittasKamavacharamActivity extends BaseActivityClass {

    private TextView textViewAbhidhammaKammavacharamUnwholsome;

    private Button infoButtonAbhidhammaKammavacharamUnwholsome;

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_kamavacharam);

        setWindowFlagsFullscreenAndNoLimits();

        textViewAbhidhammaKammavacharamUnwholsome = findViewById(R.id.textViewAbhidhammaKammavacharamUnwholsome);
        infoButtonAbhidhammaKammavacharamUnwholsome = findViewById(R.id.infoButtonKamamavacharaUwholsome);
    }

    public void onButtonClickAbhidhammaKammavacharamUnwholsome(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsome.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsome.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsome.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsome.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaKammavacharamUnwholsome) {
                textViewAbhidhammaKammavacharamUnwholsome.setText(R.string.textDiscribeKamavacharachitamUnwholsome);
                textViewAbhidhammaKammavacharamUnwholsome.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsome, getString(R.string.textDiscribeKamavacharachitamUnwholsome));
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

    public void toAbhidhammaChittasKamavacharamUnwholsomeAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamUnwholsomeActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(AbhidhammaChittasActivity.class);
    }
}