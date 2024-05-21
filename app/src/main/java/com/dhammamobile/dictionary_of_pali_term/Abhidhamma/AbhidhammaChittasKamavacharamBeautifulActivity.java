package com.dhammamobile.dictionary_of_pali_term.Abhidhamma;

import androidx.appcompat.app.AppCompatActivity;

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

public class AbhidhammaChittasKamavacharamBeautifulActivity extends BaseActivityClass {

    private Button infoButtonAbhidhammaKammavacharamWholsome;
    private TextView textViewAbhidhammaKammavacharamWholsome;
    private Button infoButtonAbhidhammaKammavacharamResult;
    private TextView textViewAbhidhammaKammavacharamResult;
    private Button infoButtonAbhidhammaKammavacharamFunction;
    private TextView textViewAbhidhammaKammavacharamFunction;

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_kamavacharam_beautiful);

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        infoButtonAbhidhammaKammavacharamWholsome = findViewById(R.id.infoButtonKamamavacharamWholsome);
        textViewAbhidhammaKammavacharamWholsome = findViewById(R.id.textViewAbhidhammaKammavacharamWholsome);
        infoButtonAbhidhammaKammavacharamResult = findViewById(R.id.infoButtonKamamavacharamResult);
        textViewAbhidhammaKammavacharamResult = findViewById(R.id.textViewAbhidhammaKammavacharamResult);
        infoButtonAbhidhammaKammavacharamFunction = findViewById(R.id.infoButtonKamamavacharamFunсtion);
        textViewAbhidhammaKammavacharamFunction = findViewById(R.id.textViewAbhidhammaKammavacharamFunktion);
    }

    public void onButtonClickAbhidhammaKammavacharamWholsome(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamWholsome.getVisibility();
        textViewAbhidhammaKammavacharamWholsome.setText("");
        textViewAbhidhammaKammavacharamResult.setText("");
        textViewAbhidhammaKammavacharamFunction.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamWholsome.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamWholsome.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaKammavacharamWholsome) {
                textViewAbhidhammaKammavacharamWholsome.setText(R.string.textDescriptionKusalachitani);
                textViewAbhidhammaKammavacharamWholsome.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsome, getString(R.string.textDescriptionKusalachitani));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaKammavacharamResult(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamResult.getVisibility();
        textViewAbhidhammaKammavacharamWholsome.setText("");
        textViewAbhidhammaKammavacharamResult.setText("");
        textViewAbhidhammaKammavacharamFunction.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamResult.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamResult.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaKammavacharamResult) {
                textViewAbhidhammaKammavacharamResult.setText(R.string.textDescriptionVipakachitani);
                textViewAbhidhammaKammavacharamResult.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamResult, getString(R.string.textDescriptionVipakachitani));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaKammavacharamFunktion(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamFunction.getVisibility();
        textViewAbhidhammaKammavacharamWholsome.setText("");
        textViewAbhidhammaKammavacharamResult.setText("");
        textViewAbhidhammaKammavacharamFunction.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamFunction.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamFunction.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaKammavacharamFunction) {
                textViewAbhidhammaKammavacharamFunction.setText(R.string.textDescriptionKriyachitani);
                textViewAbhidhammaKammavacharamFunction.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamFunction, getString(R.string.textDescriptionKriyachitani));
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

    public void toAbhidhammaChittasKamavacharamAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamActivity.class);
    }

    public void toAbhidhammaChittasKamavacharamBeautifulKusalachitaniAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamBeautifulKusalachitaniActivity.class);
    }

    public void toAbhidhammaChittasKamavacharamBeautifulVipakachitaniAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamBeautifulVipakachitaniActivity.class);
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