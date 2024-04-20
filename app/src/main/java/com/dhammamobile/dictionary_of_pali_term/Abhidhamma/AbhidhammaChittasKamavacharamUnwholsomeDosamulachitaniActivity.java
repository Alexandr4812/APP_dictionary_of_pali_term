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

public class AbhidhammaChittasKamavacharamUnwholsomeDosamulachitaniActivity extends BaseActivityClass {

    private TextView textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta1;
    private TextView textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta2;

    private Button dosamulachittani1, dosamulachittani2;

    private Button koren1,koren2,
            funkciya1,funkciya2,
            kombinaciya1,kombinaciya2;

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_kamavacharam_unwholsome_dosamulachitani);

      //  setWindowFlagsFullscreenAndNoLimits();

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta1 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_unwholsome_dosamulachitani1);
        textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta2 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_unwholsome_dosamulachitani2);

        dosamulachittani1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_dosamulachitani1);
        dosamulachittani2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_dosamulachitani2);


        koren1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_dosamulachitan_koren1);
        koren2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_dosamulachitan_koren2);


        funkciya1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_dosamulachitan_funkciya1);
        funkciya2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_dosamulachitan_funkciya2);


        kombinaciya1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_dosamulachitan_kombinaciya1);
        kombinaciya2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_dosamulachitan_kombinaciya2);
    }

    public void onButtonClickAbhidhammaDosaGroup1(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta1.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta1.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta2.setText("");


        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta1.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta1.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == dosamulachittani1) {
                textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta1.setText(R.string.textDosamulachitta1);
                textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta1, getString(R.string.textDosamulachitta1));
            } else if (clickedButton == koren1) {
                textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta1.setText(R.string.textDosamulachittaKoren1);
                textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta1, getString(R.string.textDosamulachittaKoren1));
            } else if (clickedButton == funkciya1) {
                textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta1.setText(R.string.textDosamulachittaFunkciya1);
                textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta1, getString(R.string.textDosamulachittaFunkciya1));
            } else if (clickedButton == kombinaciya1) {
                textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta1.setText(R.string.textDosamulachittaKombinaciya1);
                textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta1, getString(R.string.textDosamulachittaKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaDosaGroup2(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta2.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta1.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta2.setText("");


        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta2.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta2.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == dosamulachittani2) {
                textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta2.setText(R.string.textDosamulachitta2);
                textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta2, getString(R.string.textDosamulachitta2));
            } else if (clickedButton == koren2) {
                textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta2.setText(R.string.textDosamulachittaKoren2);
                textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta2, getString(R.string.textDosamulachittaKoren2));
            } else if (clickedButton == funkciya2) {
                textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta2.setText(R.string.textDosamulachittaFunkciya2);
                textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta2, getString(R.string.textDosamulachittaFunkciya2));
            } else if (clickedButton == kombinaciya2) {
                textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta2.setText(R.string.textDosamulachittaKombinaciya2);
                textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeDosamulachitta2, getString(R.string.textDosamulachittaKombinaciya2));
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

    public void toAbhidhammaChittasKamavacharamUnwholsomeAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamUnwholsomeActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamUnwholsomeActivity.class);
    }
}