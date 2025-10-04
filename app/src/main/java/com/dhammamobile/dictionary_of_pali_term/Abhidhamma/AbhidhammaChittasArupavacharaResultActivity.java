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

public class AbhidhammaChittasArupavacharaResultActivity extends BaseActivityClass {

    private TextView textViewAbhidhammaArupavacharaResult1, textViewAbhidhammaArupavacharaResult2,
            textViewAbhidhammaArupavacharaResult3, textViewAbhidhammaArupavacharaResult4;

    private Button resultButton1, resultButton2, resultButton3, resultButton4;

    private Button koren1,koren2,koren3,koren4,
            funkciya1,funkciya2,funkciya3,funkciya4,
            kombinaciya1,kombinaciya2,kombinaciya3,kombinaciya4;

    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_arupavachara_result);

        //  setWindowFlagsFullscreenAndNoLimits();

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        textViewAbhidhammaArupavacharaResult1 =
                findViewById(R.id.textView_abhidhamma_chittas_arupavachara_result1);
        textViewAbhidhammaArupavacharaResult2 =
                findViewById(R.id.textView_abhidhamma_chittas_arupavachara_result2);
        textViewAbhidhammaArupavacharaResult3 =
                findViewById(R.id.textView_abhidhamma_chittas_arupavachara_result3);
        textViewAbhidhammaArupavacharaResult4 =
                findViewById(R.id.textView_abhidhamma_chittas_arupavachara_result4);

        resultButton1 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_result1);
        resultButton2 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_result2);
        resultButton3 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_result3);
        resultButton4 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_result4);

        koren1 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_result_koren1);
        koren2 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_result_koren2);
        koren3 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_result_koren3);
        koren4 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_result_koren4);

        funkciya1 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_result_funkciya1);
        funkciya2 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_result_funkciya2);
        funkciya3 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_result_funkciya3);
        funkciya4 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_result_funkciya4);

        kombinaciya1 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_result_kombinaciya1);
        kombinaciya2 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_result_kombinaciya2);
        kombinaciya3 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_result_kombinaciya3);
        kombinaciya4 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_result_kombinaciya4);
    }

    public void onButtonClickAbhidhammaArupavacharaResultGroup1(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaArupavacharaResult1.getVisibility();
        textViewAbhidhammaArupavacharaResult1.setText("");
        textViewAbhidhammaArupavacharaResult2.setText("");
        textViewAbhidhammaArupavacharaResult3.setText("");
        textViewAbhidhammaArupavacharaResult4.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaArupavacharaResult1.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaArupavacharaResult1.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == resultButton1) {
                textViewAbhidhammaArupavacharaResult1.setText(R.string.textArupavacharaResult1);
                textViewAbhidhammaArupavacharaResult1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaResult1, getString(R.string.textArupavacharaResult1));
            } else if (clickedButton == koren1) {
                textViewAbhidhammaArupavacharaResult1.setText(R.string.textArupavacharaResultKoren);
                textViewAbhidhammaArupavacharaResult1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaResult1, getString(R.string.textArupavacharaResultKoren));
            } else if (clickedButton == funkciya1) {
                textViewAbhidhammaArupavacharaResult1.setText(R.string.textArupavacharaResultFunkciya1);
                textViewAbhidhammaArupavacharaResult1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaResult1, getString(R.string.textArupavacharaResultFunkciya1));
            } else if (clickedButton == kombinaciya1) {
                textViewAbhidhammaArupavacharaResult1.setText(R.string.textArupavacharaResultKombinaciya1);
                textViewAbhidhammaArupavacharaResult1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaResult1, getString(R.string.textArupavacharaResultKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaArupavacharaResultGroup2(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaArupavacharaResult2.getVisibility();
        textViewAbhidhammaArupavacharaResult1.setText("");
        textViewAbhidhammaArupavacharaResult2.setText("");
        textViewAbhidhammaArupavacharaResult3.setText("");
        textViewAbhidhammaArupavacharaResult4.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaArupavacharaResult2.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaArupavacharaResult2.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == resultButton2) {
                textViewAbhidhammaArupavacharaResult2.setText(R.string.textArupavacharaResult2);
                textViewAbhidhammaArupavacharaResult2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaResult2, getString(R.string.textArupavacharaResult2));
            } else if (clickedButton == koren2) {
                textViewAbhidhammaArupavacharaResult2.setText(R.string.textArupavacharaResultKoren);
                textViewAbhidhammaArupavacharaResult2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaResult2, getString(R.string.textArupavacharaResultKoren));
            } else if (clickedButton == funkciya2) {
                textViewAbhidhammaArupavacharaResult2.setText(R.string.textArupavacharaResultFunkciya1);
                textViewAbhidhammaArupavacharaResult2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaResult2, getString(R.string.textArupavacharaResultFunkciya1));
            } else if (clickedButton == kombinaciya2) {
                textViewAbhidhammaArupavacharaResult2.setText(R.string.textArupavacharaResultKombinaciya1);
                textViewAbhidhammaArupavacharaResult2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaResult2, getString(R.string.textArupavacharaResultKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaArupavacharaResultGroup3(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaArupavacharaResult3.getVisibility();
        textViewAbhidhammaArupavacharaResult1.setText("");
        textViewAbhidhammaArupavacharaResult2.setText("");
        textViewAbhidhammaArupavacharaResult3.setText("");
        textViewAbhidhammaArupavacharaResult4.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaArupavacharaResult3.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaArupavacharaResult3.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == resultButton3) {
                textViewAbhidhammaArupavacharaResult3.setText(R.string.textArupavacharaResult3);
                textViewAbhidhammaArupavacharaResult3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaResult3, getString(R.string.textArupavacharaResult3));
            } else if (clickedButton == koren3) {
                textViewAbhidhammaArupavacharaResult3.setText(R.string.textArupavacharaResultKoren);
                textViewAbhidhammaArupavacharaResult3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaResult3, getString(R.string.textArupavacharaResultKoren));
            } else if (clickedButton == funkciya3) {
                textViewAbhidhammaArupavacharaResult3.setText(R.string.textArupavacharaResultFunkciya1);
                textViewAbhidhammaArupavacharaResult3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaResult3, getString(R.string.textArupavacharaResultFunkciya1));
            } else if (clickedButton == kombinaciya3) {
                textViewAbhidhammaArupavacharaResult3.setText(R.string.textArupavacharaResultKombinaciya1);
                textViewAbhidhammaArupavacharaResult3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaResult3, getString(R.string.textArupavacharaResultKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaArupavacharaResultGroup4(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaArupavacharaResult4.getVisibility();
        textViewAbhidhammaArupavacharaResult1.setText("");
        textViewAbhidhammaArupavacharaResult2.setText("");
        textViewAbhidhammaArupavacharaResult3.setText("");
        textViewAbhidhammaArupavacharaResult4.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaArupavacharaResult4.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaArupavacharaResult4.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == resultButton4) {
                textViewAbhidhammaArupavacharaResult4.setText(R.string.textArupavacharaResult4);
                textViewAbhidhammaArupavacharaResult4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaResult4, getString(R.string.textArupavacharaResult4));
            } else if (clickedButton == koren4) {
                textViewAbhidhammaArupavacharaResult4.setText(R.string.textArupavacharaResultKoren);
                textViewAbhidhammaArupavacharaResult4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaResult4, getString(R.string.textArupavacharaResultKoren));
            } else if (clickedButton == funkciya4) {
                textViewAbhidhammaArupavacharaResult4.setText(R.string.textArupavacharaResultFunkciya1);
                textViewAbhidhammaArupavacharaResult4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaResult4, getString(R.string.textArupavacharaResultFunkciya1));
            } else if (clickedButton == kombinaciya4) {
                textViewAbhidhammaArupavacharaResult4.setText(R.string.textArupavacharaResultKombinaciya1);
                textViewAbhidhammaArupavacharaResult4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaResult4, getString(R.string.textArupavacharaResultKombinaciya1));
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