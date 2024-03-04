package com.dhammamobile.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AbhidhammaChittasKamavacharamAhetukaActivity extends BaseActivityClass {

    private Button infoButtonKamamavacharaAhetukaUnwholsomeResult;
    private Button infoButtonKamamavacharaAhetukaWholsomeResult;
    private Button infoButtonKamamavacharaAhetukaFunktion;
    private TextView textViewAbhidhammaKammavacharamAhetukaUnwholsomeResult;
    private TextView textViewAbhidhammaKammavacharamAhetukaWholsomeResult;
    private TextView textViewAbhidhammaKammavacharamAhetukaFunktion;

    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_kamavacharam_ahetuka);

        setWindowFlagsFullscreenAndNoLimits();

        infoButtonKamamavacharaAhetukaUnwholsomeResult = findViewById(R.id.infoButtonKamamavacharaAhetukaUnwholsomeResult);
        infoButtonKamamavacharaAhetukaWholsomeResult = findViewById(R.id.infoButtonKamamavacharaAhetukaWholsomeResult);
        infoButtonKamamavacharaAhetukaFunktion = findViewById(R.id.infoButtonKamamavacharaAhetukaFunktion);
        textViewAbhidhammaKammavacharamAhetukaUnwholsomeResult = findViewById(R.id.textViewAbhidhammaKammavacharamAhetukaUnwholsomeResult);
        textViewAbhidhammaKammavacharamAhetukaWholsomeResult = findViewById(R.id.textViewAbhidhammaKammavacharamAhetukaWholsomeResult);
        textViewAbhidhammaKammavacharamAhetukaFunktion = findViewById(R.id.textViewAbhidhammaKammavacharamAhetukaFunktion);
    }

    public void onButtonClickAbhidhammaKammavacharamAhetukaUnwholsomeResult(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamAhetukaUnwholsomeResult.getVisibility();
        textViewAbhidhammaKammavacharamAhetukaUnwholsomeResult.setText("");
        textViewAbhidhammaKammavacharamAhetukaWholsomeResult.setText("");
        textViewAbhidhammaKammavacharamAhetukaFunktion.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamAhetukaUnwholsomeResult.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamAhetukaUnwholsomeResult.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonKamamavacharaAhetukaUnwholsomeResult) {
                textViewAbhidhammaKammavacharamAhetukaUnwholsomeResult.setText(R.string.textDiscribeAhetukaUnwholsomeResult);
                textViewAbhidhammaKammavacharamAhetukaUnwholsomeResult.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamAhetukaUnwholsomeResult, getString(R.string.textDiscribeAhetukaUnwholsomeResult));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaKammavacharamAhetukaWholsomeResult(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamAhetukaWholsomeResult.getVisibility();
        textViewAbhidhammaKammavacharamAhetukaUnwholsomeResult.setText("");
        textViewAbhidhammaKammavacharamAhetukaWholsomeResult.setText("");
        textViewAbhidhammaKammavacharamAhetukaFunktion.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamAhetukaWholsomeResult.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamAhetukaWholsomeResult.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonKamamavacharaAhetukaWholsomeResult) {
                textViewAbhidhammaKammavacharamAhetukaWholsomeResult.setText(R.string.textDiscribeAhetukaWholsomeResult);
                textViewAbhidhammaKammavacharamAhetukaWholsomeResult.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamAhetukaWholsomeResult, getString(R.string.textDiscribeAhetukaWholsomeResult));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaKammavacharamAhetukaFunktion(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamAhetukaFunktion.getVisibility();
        textViewAbhidhammaKammavacharamAhetukaUnwholsomeResult.setText("");
        textViewAbhidhammaKammavacharamAhetukaWholsomeResult.setText("");
        textViewAbhidhammaKammavacharamAhetukaFunktion.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamAhetukaFunktion.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamAhetukaFunktion.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonKamamavacharaAhetukaFunktion) {
                textViewAbhidhammaKammavacharamAhetukaFunktion.setText(R.string.textDiscribeAhetukaFunktion);
                textViewAbhidhammaKammavacharamAhetukaFunktion.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamAhetukaFunktion, getString(R.string.textDiscribeAhetukaFunktion));
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

    public void toAbhidhammaChittasKamavacharamAhetukaUnwholsomeResultAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamAhetukaUnwholsomeResultActivity.class);
    }

    public void toAbhidhammaChittasKamavacharamAhetukaWholsomeResultAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamAhetukaWholsomeResultActivity.class);
    }

    public void toAbhidhammaChittasKamavacharamAhetukaFunkcionalAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamAhetukaFunkcionalActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamActivity.class);
    }
}