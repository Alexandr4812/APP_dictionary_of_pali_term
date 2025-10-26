package com.dhammamobile.dictionary_of_pali_term.Abhidhamma;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

public class AbhidhammaChittasActivity extends BaseActivityClass {

    private TextView textViewAbhidhammaKammavacharam, textViewAbhidhammaRupavacharam,
            textViewAbhidhammaArupavacharam, textViewAbhidhammaLokutara;

    private Button infoButtonAbhidhammaKammavacharam, infoButtonAbhidhammaRupavacharam,
            infoButtonAbhidhammaArupavacharam, infoButtonAbhidhammaLokutara;

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas);

       // setWindowFlagsFullscreenAndNoLimits();

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        textViewAbhidhammaKammavacharam = findViewById(R.id.textViewAbhidhammaKammavacharam);
        infoButtonAbhidhammaKammavacharam = findViewById(R.id.infoButtonKamamavachara);

        textViewAbhidhammaRupavacharam = findViewById(R.id.textViewAbhidhammaRupavachara);
        infoButtonAbhidhammaRupavacharam = findViewById(R.id.infoButtonRupavachara);

        textViewAbhidhammaArupavacharam = findViewById(R.id.textViewAbhidhammaArupavachara);
        infoButtonAbhidhammaArupavacharam = findViewById(R.id.infoButtonArupavachara);

        textViewAbhidhammaLokutara = findViewById(R.id.textViewAbhidhammaLokutara);
        infoButtonAbhidhammaLokutara = findViewById(R.id.infoButtonLokutara);
    }

    public void onButtonClickAbhidhammaKammavacharam(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharam.getVisibility();
        textViewAbhidhammaKammavacharam.setText("");
        textViewAbhidhammaRupavacharam.setText("");
        textViewAbhidhammaArupavacharam.setText("");
        textViewAbhidhammaLokutara.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharam.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharam.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaKammavacharam) {
                textViewAbhidhammaKammavacharam.setText(R.string.textDiscribeKamavacharachitam);
                textViewAbhidhammaKammavacharam.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharam, getString(R.string.textDiscribeKamavacharachitam));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaRupavachara(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaRupavacharam.getVisibility();
        textViewAbhidhammaKammavacharam.setText("");
        textViewAbhidhammaRupavacharam.setText("");
        textViewAbhidhammaArupavacharam.setText("");
        textViewAbhidhammaLokutara.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaRupavacharam.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaRupavacharam.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaRupavacharam) {
                textViewAbhidhammaRupavacharam.setText(R.string.textDiscribeRupavacharachitani);
                textViewAbhidhammaRupavacharam.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacharam, getString(R.string.textDiscribeRupavacharachitani));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaArupavachara(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaArupavacharam.getVisibility();
        textViewAbhidhammaKammavacharam.setText("");
        textViewAbhidhammaRupavacharam.setText("");
        textViewAbhidhammaArupavacharam.setText("");
        textViewAbhidhammaLokutara.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaArupavacharam.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaArupavacharam.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaArupavacharam) {
                textViewAbhidhammaArupavacharam.setText(R.string.textDiscribeArupavacharachitani);
                textViewAbhidhammaArupavacharam.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharam, getString(R.string.textDiscribeArupavacharachitani));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaLokutara(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaLokutara.getVisibility();
        textViewAbhidhammaKammavacharam.setText("");
        textViewAbhidhammaRupavacharam.setText("");
        textViewAbhidhammaArupavacharam.setText("");
        textViewAbhidhammaLokutara.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaLokutara.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaLokutara.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaLokutara) {
                textViewAbhidhammaLokutara.setText(R.string.textDiscribeLokutarachitani);
                textViewAbhidhammaLokutara.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutara, getString(R.string.textDiscribeLokutarachitani));
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

    public void toAbhidhammaAct(View view){
        startIntentActivityAndFinish(AbhidhammaActivity.class);
    }

    public void toAbhidhammaChittasKamavacharam(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamActivity.class);
    }

    public void toAbhidhammaChittasRupavacara(View view){
        startIntentActivityAndFinish(AbhidhammaChittasRupavacaraActivity.class);
    }

    public void toAbhidhammaChittasArupavacara(View view){
        startIntentActivityAndFinish(AbhidhammaChittasArupavacharaActivity.class);
    }

    public void toAbhidhammaChittasLokutara(View view){
        startIntentActivityAndFinish(AbhidhammaChittasLokutaraActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(AbhidhammaActivity.class);
    }

}