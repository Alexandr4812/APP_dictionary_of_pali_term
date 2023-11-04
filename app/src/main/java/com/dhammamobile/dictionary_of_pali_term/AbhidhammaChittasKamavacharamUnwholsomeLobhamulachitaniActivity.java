package com.dhammamobile.dictionary_of_pali_term;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;


public class AbhidhammaChittasKamavacharamUnwholsomeLobhamulachitaniActivity extends BaseActivityClass{

    private TextView textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1;
    private TextView textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2;
    private TextView textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3;
    private TextView textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4;
    private TextView textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5;
    private TextView textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6;
    private TextView textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7;
    private TextView textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8;

    private Button lobhamulachittani1, lobhamulachittani2, lobhamulachittani3, lobhamulachittani4,
            lobhamulachittani5, lobhamulachittani6, lobhamulachittani7, lobhamulachittani8;
    private Button koren1,koren2,koren3,koren4,koren5,koren6,koren7,koren8,
    funkciya1,funkciya2,funkciya3,funkciya4,funkciya5,funkciya6,funkciya7,funkciya8,
    kombinaciya1,kombinaciya2,kombinaciya3,kombinaciya4,kombinaciya5,kombinaciya6,kombinaciya7,kombinaciya8;

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_kamavacharam_unwholsome_lobhamulachitani);

        setWindowFlagsFullscreenAndNoLimits();

        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitani1);
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitani2);

        lobhamulachittani1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitani1);
        lobhamulachittani2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitani2);

        koren1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_koren1);
        koren2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_koren2);

        funkciya1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_funkciya1);
        funkciya2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_funkciya2);

        kombinaciya1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_kombinaciya1);
        kombinaciya2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_kombinaciya2);
    }

    public void onButtonClickAbhidhammaLobhaGroup1(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == lobhamulachittani1) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setText(R.string.textLobhamulachitta1);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1, getString(R.string.textLobhamulachitta1));
            } else if (clickedButton == koren1) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setText(R.string.textLobhamulachittaKoren1);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1, getString(R.string.textLobhamulachittaKoren1));
            } else if (clickedButton == funkciya1) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setText(R.string.textLobhamulachittaFunkciya1);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1, getString(R.string.textLobhamulachittaFunkciya1));
            } else if (clickedButton == kombinaciya1) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setText(R.string.textLobhamulachittaKombinaciya1);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1, getString(R.string.textLobhamulachittaKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaLobhaGroup2(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == lobhamulachittani2) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setText(R.string.textLobhamulachitta2);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2, getString(R.string.textLobhamulachitta2));
            } else if (clickedButton == koren2) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setText(R.string.textLobhamulachittaKoren2);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2, getString(R.string.textLobhamulachittaKoren2));
            } else if (clickedButton == funkciya2) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setText(R.string.textLobhamulachittaFunkciya2);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2, getString(R.string.textLobhamulachittaFunkciya2));
            } else if (clickedButton == kombinaciya2) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setText(R.string.textLobhamulachittaKombinaciya2);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2, getString(R.string.textLobhamulachittaKombinaciya2));
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
    public void onBackPressed(){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamUnwholsomeActivity.class);
    }
}