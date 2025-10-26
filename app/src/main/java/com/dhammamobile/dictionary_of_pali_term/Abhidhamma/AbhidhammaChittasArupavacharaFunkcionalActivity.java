package com.dhammamobile.dictionary_of_pali_term.Abhidhamma;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

public class AbhidhammaChittasArupavacharaFunkcionalActivity extends BaseActivityClass {

    private TextView textViewAbhidhammaArupavacharaFunkcional1, textViewAbhidhammaArupavacharaFunkcional2,
            textViewAbhidhammaArupavacharaFunkcional3, textViewAbhidhammaArupavacharaFunkcional4;

    private Button funkcionalButton1, funkcionalButton2, funkcionalButton3, funkcionalButton4;

    private Button koren1,koren2,koren3,koren4,
            funkciya1,funkciya2,funkciya3,funkciya4,
            kombinaciya1,kombinaciya2,kombinaciya3,kombinaciya4;

    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_arupavachara_funkcional);

        //  setWindowFlagsFullscreenAndNoLimits();

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        textViewAbhidhammaArupavacharaFunkcional1 =
                findViewById(R.id.textView_abhidhamma_chittas_arupavachara_funkcional1);
        textViewAbhidhammaArupavacharaFunkcional2 =
                findViewById(R.id.textView_abhidhamma_chittas_arupavachara_funkcional2);
        textViewAbhidhammaArupavacharaFunkcional3 =
                findViewById(R.id.textView_abhidhamma_chittas_arupavachara_funkcional3);
        textViewAbhidhammaArupavacharaFunkcional4 =
                findViewById(R.id.textView_abhidhamma_chittas_arupavachara_funkcional4);

        funkcionalButton1 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_funkcional1);
        funkcionalButton2 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_funkcional2);
        funkcionalButton3 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_funkcional3);
        funkcionalButton4 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_funkcional4);

        koren1 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_funkcional_koren1);
        koren2 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_funkcional_koren2);
        koren3 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_funkcional_koren3);
        koren4 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_funkcional_koren4);

        funkciya1 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_funkcional_funkciya1);
        funkciya2 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_funkcional_funkciya2);
        funkciya3 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_funkcional_funkciya3);
        funkciya4 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_funkcional_funkciya4);

        kombinaciya1 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_funkcional_kombinaciya1);
        kombinaciya2 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_funkcional_kombinaciya2);
        kombinaciya3 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_funkcional_kombinaciya3);
        kombinaciya4 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_funkcional_kombinaciya4);
    }

    public void onButtonClickAbhidhammaArupavacharaFunkcionalGroup1(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaArupavacharaFunkcional1.getVisibility();
        textViewAbhidhammaArupavacharaFunkcional1.setText("");
        textViewAbhidhammaArupavacharaFunkcional2.setText("");
        textViewAbhidhammaArupavacharaFunkcional3.setText("");
        textViewAbhidhammaArupavacharaFunkcional4.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaArupavacharaFunkcional1.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaArupavacharaFunkcional1.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == funkcionalButton1) {
                textViewAbhidhammaArupavacharaFunkcional1.setText(R.string.textArupavacharaFunkcional1);
                textViewAbhidhammaArupavacharaFunkcional1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaFunkcional1, getString(R.string.textArupavacharaFunkcional1));
            } else if (clickedButton == koren1) {
                textViewAbhidhammaArupavacharaFunkcional1.setText(R.string.textArupavacharaResultKoren);
                textViewAbhidhammaArupavacharaFunkcional1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaFunkcional1, getString(R.string.textArupavacharaResultKoren));
            } else if (clickedButton == funkciya1) {
                textViewAbhidhammaArupavacharaFunkcional1.setText(R.string.textArupavacharaFunkcionalFunkciya1);
                textViewAbhidhammaArupavacharaFunkcional1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaFunkcional1, getString(R.string.textArupavacharaFunkcionalFunkciya1));
            } else if (clickedButton == kombinaciya1) {
                textViewAbhidhammaArupavacharaFunkcional1.setText(R.string.textArupavacharaFunkcionalKombinaciya1);
                textViewAbhidhammaArupavacharaFunkcional1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaFunkcional1, getString(R.string.textArupavacharaFunkcionalKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaArupavacharaFunkcionalGroup2(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaArupavacharaFunkcional2.getVisibility();
        textViewAbhidhammaArupavacharaFunkcional1.setText("");
        textViewAbhidhammaArupavacharaFunkcional2.setText("");
        textViewAbhidhammaArupavacharaFunkcional3.setText("");
        textViewAbhidhammaArupavacharaFunkcional4.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaArupavacharaFunkcional2.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaArupavacharaFunkcional2.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == funkcionalButton2) {
                textViewAbhidhammaArupavacharaFunkcional2.setText(R.string.textArupavacharaFunkcional2);
                textViewAbhidhammaArupavacharaFunkcional2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaFunkcional2, getString(R.string.textArupavacharaFunkcional2));
            } else if (clickedButton == koren2) {
                textViewAbhidhammaArupavacharaFunkcional2.setText(R.string.textArupavacharaResultKoren);
                textViewAbhidhammaArupavacharaFunkcional2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaFunkcional2, getString(R.string.textArupavacharaResultKoren));
            } else if (clickedButton == funkciya2) {
                textViewAbhidhammaArupavacharaFunkcional2.setText(R.string.textArupavacharaFunkcionalFunkciya1);
                textViewAbhidhammaArupavacharaFunkcional2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaFunkcional2, getString(R.string.textArupavacharaFunkcionalFunkciya1));
            } else if (clickedButton == kombinaciya2) {
                textViewAbhidhammaArupavacharaFunkcional2.setText(R.string.textArupavacharaFunkcionalKombinaciya1);
                textViewAbhidhammaArupavacharaFunkcional2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaFunkcional2, getString(R.string.textArupavacharaFunkcionalKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaArupavacharaFunkcionalGroup3(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaArupavacharaFunkcional3.getVisibility();
        textViewAbhidhammaArupavacharaFunkcional1.setText("");
        textViewAbhidhammaArupavacharaFunkcional2.setText("");
        textViewAbhidhammaArupavacharaFunkcional3.setText("");
        textViewAbhidhammaArupavacharaFunkcional4.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaArupavacharaFunkcional3.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaArupavacharaFunkcional3.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == funkcionalButton3) {
                textViewAbhidhammaArupavacharaFunkcional3.setText(R.string.textArupavacharaFunkcional3);
                textViewAbhidhammaArupavacharaFunkcional3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaFunkcional3, getString(R.string.textArupavacharaFunkcional3));
            } else if (clickedButton == koren3) {
                textViewAbhidhammaArupavacharaFunkcional3.setText(R.string.textArupavacharaResultKoren);
                textViewAbhidhammaArupavacharaFunkcional3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaFunkcional3, getString(R.string.textArupavacharaResultKoren));
            } else if (clickedButton == funkciya3) {
                textViewAbhidhammaArupavacharaFunkcional3.setText(R.string.textArupavacharaFunkcionalFunkciya1);
                textViewAbhidhammaArupavacharaFunkcional3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaFunkcional3, getString(R.string.textArupavacharaFunkcionalFunkciya1));
            } else if (clickedButton == kombinaciya3) {
                textViewAbhidhammaArupavacharaFunkcional3.setText(R.string.textArupavacharaFunkcionalKombinaciya1);
                textViewAbhidhammaArupavacharaFunkcional3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaFunkcional3, getString(R.string.textArupavacharaFunkcionalKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaArupavacharaFunkcionalGroup4(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaArupavacharaFunkcional4.getVisibility();
        textViewAbhidhammaArupavacharaFunkcional1.setText("");
        textViewAbhidhammaArupavacharaFunkcional2.setText("");
        textViewAbhidhammaArupavacharaFunkcional3.setText("");
        textViewAbhidhammaArupavacharaFunkcional4.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaArupavacharaFunkcional4.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaArupavacharaFunkcional4.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == funkcionalButton4) {
                textViewAbhidhammaArupavacharaFunkcional4.setText(R.string.textArupavacharaFunkcional4);
                textViewAbhidhammaArupavacharaFunkcional4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaFunkcional4, getString(R.string.textArupavacharaFunkcional4));
            } else if (clickedButton == koren4) {
                textViewAbhidhammaArupavacharaFunkcional4.setText(R.string.textArupavacharaResultKoren);
                textViewAbhidhammaArupavacharaFunkcional4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaFunkcional4, getString(R.string.textArupavacharaResultKoren));
            } else if (clickedButton == funkciya4) {
                textViewAbhidhammaArupavacharaFunkcional4.setText(R.string.textArupavacharaFunkcionalFunkciya1);
                textViewAbhidhammaArupavacharaFunkcional4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaFunkcional4, getString(R.string.textArupavacharaFunkcionalFunkciya1));
            } else if (clickedButton == kombinaciya4) {
                textViewAbhidhammaArupavacharaFunkcional4.setText(R.string.textArupavacharaFunkcionalKombinaciya1);
                textViewAbhidhammaArupavacharaFunkcional4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaFunkcional4, getString(R.string.textArupavacharaFunkcionalKombinaciya1));
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

    public void toAbhidhammaChittasArupavacara(View view){
        startIntentActivityAndFinish(AbhidhammaChittasArupavacharaActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(AbhidhammaChittasArupavacharaActivity.class);
    }
}