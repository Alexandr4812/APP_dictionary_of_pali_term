package com.dhammamobile.dictionary_of_pali_term.Abhidhamma;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;


public class AbhidhammaChittasKamavacharamActivity extends BaseActivityClass {

    private TextView textViewAbhidhammaKammavacharamUnwholsome;

    private Button infoButtonAbhidhammaKammavacharamUnwholsome;

    private TextView textViewAbhidhammaKammavacharamAhetuka;

    private Button infoButtonAbhidhammaKammavacharamAhetuka;

    private TextView textViewAbhidhammaKammavacharamBeautiful;

    private Button infoButtonAbhidhammaKammavacharamBeautiful;

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_kamavacharam);

       // setWindowFlagsFullscreenAndNoLimits();

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textViewAbhidhammaKammavacharamUnwholsome = findViewById(R.id.textViewAbhidhammaKammavacharamUnwholsome);
        infoButtonAbhidhammaKammavacharamUnwholsome = findViewById(R.id.infoButtonKamamavacharaUwholsome);

        textViewAbhidhammaKammavacharamAhetuka = findViewById(R.id.textViewAbhidhammaKammavacharamAhetuka);
        infoButtonAbhidhammaKammavacharamAhetuka = findViewById(R.id.infoButtonKamamavacharaAhetuka);

        textViewAbhidhammaKammavacharamBeautiful = findViewById(R.id.textViewAbhidhammaKammavacharamBeautiful);
        infoButtonAbhidhammaKammavacharamBeautiful = findViewById(R.id.infoButtonKamamavacharaBeautiful);
    }

    public void onButtonClickAbhidhammaKammavacharamUnwholsome(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsome.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsome.setText("");
        textViewAbhidhammaKammavacharamAhetuka.setText("");
        textViewAbhidhammaKammavacharamBeautiful.setText("");

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
        textViewAbhidhammaKammavacharamBeautiful.setText("");

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

    public void onButtonClickAbhidhammaKammavacharamBeautiful(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamBeautiful.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsome.setText("");
        textViewAbhidhammaKammavacharamAhetuka.setText("");
        textViewAbhidhammaKammavacharamBeautiful.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamBeautiful.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamBeautiful.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaKammavacharamBeautiful) {
                textViewAbhidhammaKammavacharamBeautiful.setText(R.string.textDiscribeKamavacharachitamBeautiful);
                textViewAbhidhammaKammavacharamBeautiful.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamBeautiful, getString(R.string.textDiscribeKamavacharachitamBeautiful));
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

    public void toAbhidhammaChittasKamavacharamBeautifulAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamBeautifulActivity.class);
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