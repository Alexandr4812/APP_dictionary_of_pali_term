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

public class AbhidhammaChittasArupavacharaWholsomeActivity extends BaseActivityClass {

    private TextView textViewAbhidhammaArupavacharaWholsome1, textViewAbhidhammaArupavacharaWholsome2,
            textViewAbhidhammaArupavacharaWholsome3, textViewAbhidhammaArupavacharaWholsome4;

    private Button wholsomeButton1, wholsomeButton2, wholsomeButton3, wholsomeButton4;

    private Button koren1,koren2,koren3,koren4,
            funkciya1,funkciya2,funkciya3,funkciya4,
            kombinaciya1,kombinaciya2,kombinaciya3,kombinaciya4;

    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_arupavachara_wholsome);

        //  setWindowFlagsFullscreenAndNoLimits();

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        textViewAbhidhammaArupavacharaWholsome1 =
                findViewById(R.id.textView_abhidhamma_chittas_arupavachara_wholsome1);
        textViewAbhidhammaArupavacharaWholsome2 =
                findViewById(R.id.textView_abhidhamma_chittas_arupavachara_wholsome2);
        textViewAbhidhammaArupavacharaWholsome3 =
                findViewById(R.id.textView_abhidhamma_chittas_arupavachara_wholsome3);
        textViewAbhidhammaArupavacharaWholsome4 =
                findViewById(R.id.textView_abhidhamma_chittas_arupavachara_wholsome4);

        wholsomeButton1 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_wholsome1);
        wholsomeButton2 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_wholsome2);
        wholsomeButton3 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_wholsome3);
        wholsomeButton4 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_wholsome4);

        koren1 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_wholsome_koren1);
        koren2 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_wholsome_koren2);
        koren3 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_wholsome_koren3);
        koren4 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_wholsome_koren4);

        funkciya1 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_wholsome_funkciya1);
        funkciya2 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_wholsome_funkciya2);
        funkciya3 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_wholsome_funkciya3);
        funkciya4 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_wholsome_funkciya4);

        kombinaciya1 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_wholsome_kombinaciya1);
        kombinaciya2 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_wholsome_kombinaciya2);
        kombinaciya3 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_wholsome_kombinaciya3);
        kombinaciya4 = findViewById(R.id.button_abhidhamma_chittas_arupavachara_wholsome_kombinaciya4);
    }

    public void onButtonClickAbhidhammaArupavacharaWholsomeGroup1(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaArupavacharaWholsome1.getVisibility();
        textViewAbhidhammaArupavacharaWholsome1.setText("");
        textViewAbhidhammaArupavacharaWholsome2.setText("");
        textViewAbhidhammaArupavacharaWholsome3.setText("");
        textViewAbhidhammaArupavacharaWholsome4.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaArupavacharaWholsome1.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaArupavacharaWholsome1.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == wholsomeButton1) {
                textViewAbhidhammaArupavacharaWholsome1.setText(R.string.textArupavacharaWholsome1);
                textViewAbhidhammaArupavacharaWholsome1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaWholsome1, getString(R.string.textArupavacharaWholsome1));
            } else if (clickedButton == koren1) {
                textViewAbhidhammaArupavacharaWholsome1.setText(R.string.textArupavacharaWholsomeKoren);
                textViewAbhidhammaArupavacharaWholsome1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaWholsome1, getString(R.string.textArupavacharaWholsomeKoren));
            } else if (clickedButton == funkciya1) {
                textViewAbhidhammaArupavacharaWholsome1.setText(R.string.textArupavacharaWholsomeFunkciya1);
                textViewAbhidhammaArupavacharaWholsome1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaWholsome1, getString(R.string.textArupavacharaWholsomeFunkciya1));
            } else if (clickedButton == kombinaciya1) {
                textViewAbhidhammaArupavacharaWholsome1.setText(R.string.textArupavacharaWholsomeKombinaciya1);
                textViewAbhidhammaArupavacharaWholsome1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaWholsome1, getString(R.string.textArupavacharaWholsomeKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaArupavacharaWholsomeGroup2(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaArupavacharaWholsome2.getVisibility();
        textViewAbhidhammaArupavacharaWholsome1.setText("");
        textViewAbhidhammaArupavacharaWholsome2.setText("");
        textViewAbhidhammaArupavacharaWholsome3.setText("");
        textViewAbhidhammaArupavacharaWholsome4.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaArupavacharaWholsome2.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaArupavacharaWholsome2.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == wholsomeButton2) {
                textViewAbhidhammaArupavacharaWholsome2.setText(R.string.textArupavacharaWholsome2);
                textViewAbhidhammaArupavacharaWholsome2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaWholsome2, getString(R.string.textArupavacharaWholsome2));
            } else if (clickedButton == koren2) {
                textViewAbhidhammaArupavacharaWholsome2.setText(R.string.textArupavacharaWholsomeKoren);
                textViewAbhidhammaArupavacharaWholsome2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaWholsome2, getString(R.string.textArupavacharaWholsomeKoren));
            } else if (clickedButton == funkciya2) {
                textViewAbhidhammaArupavacharaWholsome2.setText(R.string.textArupavacharaWholsomeFunkciya1);
                textViewAbhidhammaArupavacharaWholsome2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaWholsome2, getString(R.string.textArupavacharaWholsomeFunkciya1));
            } else if (clickedButton == kombinaciya2) {
                textViewAbhidhammaArupavacharaWholsome2.setText(R.string.textArupavacharaWholsomeKombinaciya1);
                textViewAbhidhammaArupavacharaWholsome2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaWholsome2, getString(R.string.textArupavacharaWholsomeKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaArupavacharaWholsomeGroup3(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaArupavacharaWholsome3.getVisibility();
        textViewAbhidhammaArupavacharaWholsome1.setText("");
        textViewAbhidhammaArupavacharaWholsome2.setText("");
        textViewAbhidhammaArupavacharaWholsome3.setText("");
        textViewAbhidhammaArupavacharaWholsome4.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaArupavacharaWholsome3.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaArupavacharaWholsome3.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == wholsomeButton3) {
                textViewAbhidhammaArupavacharaWholsome3.setText(R.string.textArupavacharaWholsome3);
                textViewAbhidhammaArupavacharaWholsome3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaWholsome3, getString(R.string.textArupavacharaWholsome3));
            } else if (clickedButton == koren3) {
                textViewAbhidhammaArupavacharaWholsome3.setText(R.string.textArupavacharaWholsomeKoren);
                textViewAbhidhammaArupavacharaWholsome3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaWholsome3, getString(R.string.textArupavacharaWholsomeKoren));
            } else if (clickedButton == funkciya3) {
                textViewAbhidhammaArupavacharaWholsome3.setText(R.string.textArupavacharaWholsomeFunkciya1);
                textViewAbhidhammaArupavacharaWholsome3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaWholsome3, getString(R.string.textArupavacharaWholsomeFunkciya1));
            } else if (clickedButton == kombinaciya3) {
                textViewAbhidhammaArupavacharaWholsome3.setText(R.string.textArupavacharaWholsomeKombinaciya1);
                textViewAbhidhammaArupavacharaWholsome3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaWholsome3, getString(R.string.textArupavacharaWholsomeKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaArupavacharaWholsomeGroup4(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaArupavacharaWholsome4.getVisibility();
        textViewAbhidhammaArupavacharaWholsome1.setText("");
        textViewAbhidhammaArupavacharaWholsome2.setText("");
        textViewAbhidhammaArupavacharaWholsome3.setText("");
        textViewAbhidhammaArupavacharaWholsome4.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaArupavacharaWholsome4.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaArupavacharaWholsome4.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == wholsomeButton4) {
                textViewAbhidhammaArupavacharaWholsome4.setText(R.string.textArupavacharaWholsome4);
                textViewAbhidhammaArupavacharaWholsome4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaWholsome4, getString(R.string.textArupavacharaWholsome4));
            } else if (clickedButton == koren4) {
                textViewAbhidhammaArupavacharaWholsome4.setText(R.string.textArupavacharaWholsomeKoren);
                textViewAbhidhammaArupavacharaWholsome4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaWholsome4, getString(R.string.textArupavacharaWholsomeKoren));
            } else if (clickedButton == funkciya4) {
                textViewAbhidhammaArupavacharaWholsome4.setText(R.string.textArupavacharaWholsomeFunkciya1);
                textViewAbhidhammaArupavacharaWholsome4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaWholsome4, getString(R.string.textArupavacharaWholsomeFunkciya1));
            } else if (clickedButton == kombinaciya4) {
                textViewAbhidhammaArupavacharaWholsome4.setText(R.string.textArupavacharaWholsomeKombinaciya1);
                textViewAbhidhammaArupavacharaWholsome4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaArupavacharaWholsome4, getString(R.string.textArupavacharaWholsomeKombinaciya1));
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