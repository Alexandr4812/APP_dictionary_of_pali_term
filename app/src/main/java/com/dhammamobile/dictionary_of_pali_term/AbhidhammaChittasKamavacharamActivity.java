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

    private TextView textViewAbhidhammaKammavacharamAhetuka;

    private Button infoButtonAbhidhammaKammavacharamAhetuka;

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

        textViewAbhidhammaKammavacharamAhetuka = findViewById(R.id.textViewAbhidhammaKammavacharamAhetuka);
        infoButtonAbhidhammaKammavacharamAhetuka = findViewById(R.id.infoButtonKamamavacharaAhetuka);
    }

    public void onButtonClickAbhidhammaKammavacharamUnwholsome(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsome.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsome.setText("");
        textViewAbhidhammaKammavacharamAhetuka.setText("");

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

    public void onButtonClickAbhidhammaKammavacharamAhetuka(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamAhetuka.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsome.setText("");
        textViewAbhidhammaKammavacharamAhetuka.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamAhetuka.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamAhetuka.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaKammavacharamAhetuka) {
                textViewAbhidhammaKammavacharamAhetuka.setText(R.string.textDiscribeKamavacharachitamAhetuka);
                textViewAbhidhammaKammavacharamAhetuka.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamAhetuka, getString(R.string.textDiscribeKamavacharachitamAhetuka));
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

    public void toAbhidhammaChittasKamavacharamAhetukaAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamAhetukaActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(AbhidhammaChittasActivity.class);
    }
}