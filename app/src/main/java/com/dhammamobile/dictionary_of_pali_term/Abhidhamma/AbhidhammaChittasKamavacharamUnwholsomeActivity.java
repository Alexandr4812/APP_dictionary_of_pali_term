package com.dhammamobile.dictionary_of_pali_term.Abhidhamma;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.annotation.SuppressLint;
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


public class AbhidhammaChittasKamavacharamUnwholsomeActivity extends BaseActivityClass {

    private TextView textViewAbhidhammaKammavacharamUnwholsomeLobha;

    private Button infoButtonAbhidhammaKammavacharamUnwholsomeLobha;
    private TextView textViewAbhidhammaKammavacharamUnwholsomeDosa;

    private Button infoButtonAbhidhammaKammavacharamUnwholsomeDosa;

    private TextView textViewAbhidhammaKammavacharamUnwholsomeMoha;

    private Button infoButtonAbhidhammaKammavacharamUnwholsomeMoha;

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_kamavacharam_unwholsome);

       // setWindowFlagsFullscreenAndNoLimits();

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        textViewAbhidhammaKammavacharamUnwholsomeLobha = findViewById(R.id.textViewAbhidhammaKammavacharamUnwholsomeLobha);
        infoButtonAbhidhammaKammavacharamUnwholsomeLobha = findViewById(R.id.infoButtonKamamavacharaUwholsomeLobha);
        textViewAbhidhammaKammavacharamUnwholsomeDosa = findViewById(R.id.textViewAbhidhammaKammavacharamUnwholsomeDosa);
        infoButtonAbhidhammaKammavacharamUnwholsomeDosa = findViewById(R.id.infoButtonKamamavacharaUwholsomeDosa);
        textViewAbhidhammaKammavacharamUnwholsomeMoha = findViewById(R.id.textViewAbhidhammaKammavacharamUnwholsomeMoha);
        infoButtonAbhidhammaKammavacharamUnwholsomeMoha = findViewById(R.id.infoButtonKamamavacharaUwholsomeMoha);
    }


    public void onButtonClickAbhidhammaKammavacharamUnwholsomeLobha(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeLobha.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeLobha.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeDosa.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeMoha.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeLobha.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeLobha.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaKammavacharamUnwholsomeLobha) {
                textViewAbhidhammaKammavacharamUnwholsomeLobha.setText(R.string.textDiscribeKamavacharachitamUnwholsomeLobha);
                textViewAbhidhammaKammavacharamUnwholsomeLobha.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobha, getString(R.string.textDiscribeKamavacharachitamUnwholsomeLobha));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaKammavacharamUnwholsomeDosa(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeDosa.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeLobha.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeDosa.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeMoha.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeDosa.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeDosa.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaKammavacharamUnwholsomeDosa) {
                textViewAbhidhammaKammavacharamUnwholsomeDosa.setText(R.string.textDiscribeKamavacharachitamUnwholsomeDosa);
                textViewAbhidhammaKammavacharamUnwholsomeDosa.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeDosa, getString(R.string.textDiscribeKamavacharachitamUnwholsomeDosa));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaKammavacharamUnwholsomeMoha(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeMoha.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeLobha.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeDosa.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeMoha.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeMoha.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeMoha.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaKammavacharamUnwholsomeMoha) {
                textViewAbhidhammaKammavacharamUnwholsomeMoha.setText(R.string.textDiscribeKamavacharachitamUnwholsomeMoha);
                textViewAbhidhammaKammavacharamUnwholsomeMoha.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeMoha, getString(R.string.textDiscribeKamavacharachitamUnwholsomeMoha));
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

    public void toAbhidhammaChittasKamavacharamUnwholsomeLobhamulachitaniAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamUnwholsomeLobhamulachitaniActivity.class);
    }

    public void toAbhidhammaChittasKamavacharamUnwholsomeDosamulachitaniAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamUnwholsomeDosamulachitaniActivity.class);
    }


    public void toAbhidhammaChittasKamavacharamUnwholsomeMohamulachitaniAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamUnwholsomeMohamulachitaniActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @SuppressLint("MissingSuperCall")
    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamActivity.class);
    }
}