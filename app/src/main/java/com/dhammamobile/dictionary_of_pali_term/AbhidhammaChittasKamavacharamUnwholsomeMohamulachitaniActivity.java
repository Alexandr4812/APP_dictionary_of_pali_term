package com.dhammamobile.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class AbhidhammaChittasKamavacharamUnwholsomeMohamulachitaniActivity extends BaseActivityClass {

    private TextView textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta1;
    private TextView textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta2;

    private Button mohamulachittani1, mohamulachittani2;

    private Button koren1,koren2,
            funkciya1,funkciya2,
            kombinaciya1,kombinaciya2;

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_kamavacharam_unwholsome_mohamulachitani);

       // setWindowFlagsFullscreenAndNoLimits();

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta1 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_unwholsome_mohamulachitani1);
        textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta2 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_unwholsome_mohamulachitani2);

        mohamulachittani1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_mohamulachitani1);
        mohamulachittani2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_mohamulachitani2);


        koren1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_mohamulachitan_koren1);
        koren2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_mohamulachitan_koren2);


        funkciya1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_mohamulachitan_funkciya1);
        funkciya2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_mohamulachitan_funkciya2);


        kombinaciya1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_mohamulachitan_kombinaciya1);
        kombinaciya2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_mohamulachitan_kombinaciya2);
    }

    public void onButtonClickAbhidhammaMohaGroup1(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta1.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta1.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta2.setText("");


        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta1.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta1.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == mohamulachittani1) {
                textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta1.setText(R.string.textMohamulachitta1);
                textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta1, getString(R.string.textMohamulachitta1));
            } else if (clickedButton == koren1) {
                textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta1.setText(R.string.textMohamulachittaKoren1);
                textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta1, getString(R.string.textMohamulachittaKoren1));
            } else if (clickedButton == funkciya1) {
                textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta1.setText(R.string.textMohamulachittaFunkciya1);
                textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta1, getString(R.string.textMohamulachittaFunkciya1));
            } else if (clickedButton == kombinaciya1) {
                textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta1.setText(R.string.textMohamulachittaKombinaciya1);
                textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta1, getString(R.string.textMohamulachittaKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaMohaGroup2(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta2.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta1.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta2.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta2.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta2.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == mohamulachittani2) {
                textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta2.setText(R.string.textMohamulachitta2);
                textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta2, getString(R.string.textMohamulachitta2));
            } else if (clickedButton == koren2) {
                textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta2.setText(R.string.textMohamulachittaKoren2);
                textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta2, getString(R.string.textMohamulachittaKoren2));
            } else if (clickedButton == funkciya2) {
                textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta2.setText(R.string.textMohamulachittaFunkciya2);
                textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta2, getString(R.string.textMohamulachittaFunkciya2));
            } else if (clickedButton == kombinaciya2) {
                textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta2.setText(R.string.textMohamulachittaKombinaciya2);
                textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeMohamulachitta2, getString(R.string.textMohamulachittaKombinaciya2));
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