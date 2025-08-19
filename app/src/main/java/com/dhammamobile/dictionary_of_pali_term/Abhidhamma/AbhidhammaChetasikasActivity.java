package com.dhammamobile.dictionary_of_pali_term.Abhidhamma;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

public class AbhidhammaChetasikasActivity extends BaseActivityClass {

    private TextView textViewAbhidhammaEticheskiVeriabelnie;

    private Button infoButtonAbhidhammaEticheskiVeriabelnie;

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_shetasikas);

       // setWindowFlagsFullscreenAndNoLimits();
        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        textViewAbhidhammaEticheskiVeriabelnie = findViewById(R.id.textViewAbhidhammaEticheskiVeriabelnie);
        infoButtonAbhidhammaEticheskiVeriabelnie = findViewById(R.id.infoButtonEticheskiVeriabelnie);
    }

    public void onButtonClickAbhidhammaEyicheskiVeriabelnie(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaEticheskiVeriabelnie.getVisibility();
        textViewAbhidhammaEticheskiVeriabelnie.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaEticheskiVeriabelnie.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaEticheskiVeriabelnie.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaEticheskiVeriabelnie) {
                textViewAbhidhammaEticheskiVeriabelnie.setText(R.string.text_for_eticheski_veriabelnie);
                textViewAbhidhammaEticheskiVeriabelnie.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaEticheskiVeriabelnie, getString(R.string.text_for_eticheski_veriabelnie));
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

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toChetasikasEtichVerAct(View view){
        startIntentActivityAndFinish(AbhidhammaChetasikasEtichVerActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(AbhidhammaActivity.class);
    }
}