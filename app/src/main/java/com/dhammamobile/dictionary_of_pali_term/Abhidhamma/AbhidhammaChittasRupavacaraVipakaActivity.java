package com.dhammamobile.dictionary_of_pali_term.Abhidhamma;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

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

public class AbhidhammaChittasRupavacaraVipakaActivity extends BaseActivityClass {

    private TextView
            textViewAbhidhammaRupavacaraKusala1,
            textViewAbhidhammaRupavacaraKusala2,
            textViewAbhidhammaRupavacaraKusala3,
            textViewAbhidhammaRupavacaraKusala4,
            textViewAbhidhammaRupavacaraKusala5,
            textViewAbhidhammaRupavacaraKusala6;

    private Button
            rupavacaraKusala1,
            rupavacaraKusala2,
            rupavacaraKusala3,
            rupavacaraKusala4,
            rupavacaraKusala5,
            rupavacaraKusala6;

    private Button
            koren1,
            koren2,
            koren3,
            koren4,
            koren5,
            funkciya1,
            funkciya2,
            funkciya3,
            funkciya4,
            funkciya5,
            kombinaciya1,
            kombinaciya2,
            kombinaciya3,
            kombinaciya4,
            kombinaciya5;

    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_rupavacara_vipaka);

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        textViewAbhidhammaRupavacaraKusala1 = findViewById(R.id.textView_abhidhamma_chittas_rupavacara_vipaka1);
        textViewAbhidhammaRupavacaraKusala2 = findViewById(R.id.textView_abhidhamma_chittas_rupavacara_vipaka2);
        textViewAbhidhammaRupavacaraKusala3 = findViewById(R.id.textView_abhidhamma_chittas_rupavacara_vipaka3);
        textViewAbhidhammaRupavacaraKusala4 = findViewById(R.id.textView_abhidhamma_chittas_rupavacara_vipaka4);
        textViewAbhidhammaRupavacaraKusala5 = findViewById(R.id.textView_abhidhamma_chittas_rupavacara_vipaka5);
        textViewAbhidhammaRupavacaraKusala6 = findViewById(R.id.textView_abhidhamma_chittas_rupavacara_vipaka6);

        rupavacaraKusala1 = findViewById(R.id.button_abhidhamma_chittas_rupavacara_vipaka1);
        rupavacaraKusala2 = findViewById(R.id.button_abhidhamma_chittas_rupavacara_vipaka2);
        rupavacaraKusala3 = findViewById(R.id.button_abhidhamma_chittas_rupavacara_vipaka3);
        rupavacaraKusala4 = findViewById(R.id.button_abhidhamma_chittas_rupavacara_vipaka4);
        rupavacaraKusala5 = findViewById(R.id.button_abhidhamma_chittas_rupavacara_vipaka5);
        rupavacaraKusala6 = findViewById(R.id.button_abhidhamma_chittas_rupavacara_vipaka6);

        koren1 = findViewById(R.id.button_abhidhamma_chittas_rupavacara_vipaka_koren1);
        koren2 = findViewById(R.id.button_abhidhamma_chittas_rupavacara_vipaka_koren2);
        koren3 = findViewById(R.id.button_abhidhamma_chittas_rupavacara_vipaka_koren3);
        koren4 = findViewById(R.id.button_abhidhamma_chittas_rupavacara_vipaka_koren4);
        koren5 = findViewById(R.id.button_abhidhamma_chittas_rupavacara_vipaka_koren5);

        funkciya1 = findViewById(R.id.button_abhidhamma_chittas_rupavacara_vipaka_funkciya1);
        funkciya2 = findViewById(R.id.button_abhidhamma_chittas_rupavacara_vipaka_funkciya2);
        funkciya3 = findViewById(R.id.button_abhidhamma_chittas_rupavacara_vipaka_funkciya3);
        funkciya4 = findViewById(R.id.button_abhidhamma_chittas_rupavacara_vipaka_funkciya4);
        funkciya5 = findViewById(R.id.button_abhidhamma_chittas_rupavacara_vipaka_funkciya5);


        kombinaciya1 = findViewById(R.id.button_abhidhamma_chittas_rupavacara_vipaka_kombinaciya1);
        kombinaciya2 = findViewById(R.id.button_abhidhamma_chittas_rupavacara_vipaka_kombinaciya2);
        kombinaciya3 = findViewById(R.id.button_abhidhamma_chittas_rupavacara_vipaka_kombinaciya3);
        kombinaciya4 = findViewById(R.id.button_abhidhamma_chittas_rupavacara_vipaka_kombinaciya4);
        kombinaciya5 = findViewById(R.id.button_abhidhamma_chittas_rupavacara_vipaka_kombinaciya5);
    }

    public void onButtonClickAbhidhammaRupavacaraVipakaGroup1(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaRupavacaraKusala1.getVisibility();
        textViewAbhidhammaRupavacaraKusala1.setText("");
        textViewAbhidhammaRupavacaraKusala2.setText("");
        textViewAbhidhammaRupavacaraKusala3.setText("");
        textViewAbhidhammaRupavacaraKusala4.setText("");
        textViewAbhidhammaRupavacaraKusala5.setText("");
        textViewAbhidhammaRupavacaraKusala6.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaRupavacaraKusala1.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaRupavacaraKusala1.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == rupavacaraKusala1) {
                textViewAbhidhammaRupavacaraKusala1.setText(R.string.textRupavacaraKusala1);
                textViewAbhidhammaRupavacaraKusala1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala1, getString(R.string.textRupavacaraKusala1));
            } else if (clickedButton == koren1) {
                textViewAbhidhammaRupavacaraKusala1.setText(R.string.textRupavacaraKusalaKoren1);
                textViewAbhidhammaRupavacaraKusala1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala1, getString(R.string.textRupavacaraKusalaKoren1));
            } else if (clickedButton == funkciya1) {
                textViewAbhidhammaRupavacaraKusala1.setText(R.string.textRupavacaraKusalaFunkciya2);
                textViewAbhidhammaRupavacaraKusala1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala1, getString(R.string.textRupavacaraKusalaFunkciya2));
            } else if (clickedButton == kombinaciya1) {
                textViewAbhidhammaRupavacaraKusala1.setText(R.string.textRupavacaraKusalaKombinaciya1);
                textViewAbhidhammaRupavacaraKusala1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala1, getString(R.string.textRupavacaraKusalaKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaRupavacaraVipakaGroup2(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaRupavacaraKusala2.getVisibility();
        textViewAbhidhammaRupavacaraKusala1.setText("");
        textViewAbhidhammaRupavacaraKusala2.setText("");
        textViewAbhidhammaRupavacaraKusala3.setText("");
        textViewAbhidhammaRupavacaraKusala4.setText("");
        textViewAbhidhammaRupavacaraKusala5.setText("");
        textViewAbhidhammaRupavacaraKusala6.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaRupavacaraKusala2.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaRupavacaraKusala2.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == rupavacaraKusala2) {
                textViewAbhidhammaRupavacaraKusala2.setText(R.string.textRupavacaraKusala2);
                textViewAbhidhammaRupavacaraKusala2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala2, getString(R.string.textRupavacaraKusala2));
            } else if (clickedButton == koren2) {
                textViewAbhidhammaRupavacaraKusala2.setText(R.string.textRupavacaraKusalaKoren1);
                textViewAbhidhammaRupavacaraKusala2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala2, getString(R.string.textRupavacaraKusalaKoren1));
            } else if (clickedButton == funkciya2) {
                textViewAbhidhammaRupavacaraKusala2.setText(R.string.textRupavacaraKusalaFunkciya2);
                textViewAbhidhammaRupavacaraKusala2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala2, getString(R.string.textRupavacaraKusalaFunkciya2));
            } else if (clickedButton == kombinaciya2) {
                textViewAbhidhammaRupavacaraKusala2.setText(R.string.textRupavacaraKusalaKombinaciya2);
                textViewAbhidhammaRupavacaraKusala2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala2, getString(R.string.textRupavacaraKusalaKombinaciya2));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaRupavacaraVipakaGroup3(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaRupavacaraKusala3.getVisibility();
        textViewAbhidhammaRupavacaraKusala1.setText("");
        textViewAbhidhammaRupavacaraKusala2.setText("");
        textViewAbhidhammaRupavacaraKusala3.setText("");
        textViewAbhidhammaRupavacaraKusala4.setText("");
        textViewAbhidhammaRupavacaraKusala5.setText("");
        textViewAbhidhammaRupavacaraKusala6.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaRupavacaraKusala3.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaRupavacaraKusala3.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == rupavacaraKusala3) {
                textViewAbhidhammaRupavacaraKusala3.setText(R.string.textRupavacaraKusala3);
                textViewAbhidhammaRupavacaraKusala3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala3, getString(R.string.textRupavacaraKusala3));
            } else if (clickedButton == koren3) {
                textViewAbhidhammaRupavacaraKusala3.setText(R.string.textRupavacaraKusalaKoren1);
                textViewAbhidhammaRupavacaraKusala3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala3, getString(R.string.textRupavacaraKusalaKoren1));
            } else if (clickedButton == funkciya3) {
                textViewAbhidhammaRupavacaraKusala3.setText(R.string.textRupavacaraKusalaFunkciya2);
                textViewAbhidhammaRupavacaraKusala3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala3, getString(R.string.textRupavacaraKusalaFunkciya2));
            } else if (clickedButton == kombinaciya3) {
                textViewAbhidhammaRupavacaraKusala3.setText(R.string.textRupavacaraKusalaKombinaciya3);
                textViewAbhidhammaRupavacaraKusala3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala3, getString(R.string.textRupavacaraKusalaKombinaciya3));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }
    public void onButtonClickAbhidhammaRupavacaraVipakaGroup4(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaRupavacaraKusala4.getVisibility();
        textViewAbhidhammaRupavacaraKusala1.setText("");
        textViewAbhidhammaRupavacaraKusala2.setText("");
        textViewAbhidhammaRupavacaraKusala3.setText("");
        textViewAbhidhammaRupavacaraKusala4.setText("");
        textViewAbhidhammaRupavacaraKusala5.setText("");
        textViewAbhidhammaRupavacaraKusala6.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaRupavacaraKusala4.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaRupavacaraKusala4.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == rupavacaraKusala4) {
                textViewAbhidhammaRupavacaraKusala4.setText(R.string.textRupavacaraKusala4);
                textViewAbhidhammaRupavacaraKusala4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala4, getString(R.string.textRupavacaraKusala4));
            } else if (clickedButton == koren4) {
                textViewAbhidhammaRupavacaraKusala4.setText(R.string.textRupavacaraKusalaKoren1);
                textViewAbhidhammaRupavacaraKusala4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala4, getString(R.string.textRupavacaraKusalaKoren1));
            } else if (clickedButton == funkciya4) {
                textViewAbhidhammaRupavacaraKusala4.setText(R.string.textRupavacaraKusalaFunkciya2);
                textViewAbhidhammaRupavacaraKusala4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala4, getString(R.string.textRupavacaraKusalaFunkciya2));
            } else if (clickedButton == kombinaciya4) {
                textViewAbhidhammaRupavacaraKusala4.setText(R.string.textRupavacaraKusalaKombinaciya4);
                textViewAbhidhammaRupavacaraKusala4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala4, getString(R.string.textRupavacaraKusalaKombinaciya4));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaRupavacaraVipakaGroup5(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaRupavacaraKusala5.getVisibility();
        textViewAbhidhammaRupavacaraKusala1.setText("");
        textViewAbhidhammaRupavacaraKusala2.setText("");
        textViewAbhidhammaRupavacaraKusala3.setText("");
        textViewAbhidhammaRupavacaraKusala4.setText("");
        textViewAbhidhammaRupavacaraKusala5.setText("");
        textViewAbhidhammaRupavacaraKusala6.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaRupavacaraKusala5.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaRupavacaraKusala5.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == rupavacaraKusala5) {
                textViewAbhidhammaRupavacaraKusala5.setText(R.string.textRupavacaraKusala5);
                textViewAbhidhammaRupavacaraKusala5.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala5, getString(R.string.textRupavacaraKusala5));
            } else if (clickedButton == koren5) {
                textViewAbhidhammaRupavacaraKusala5.setText(R.string.textRupavacaraKusalaKoren1);
                textViewAbhidhammaRupavacaraKusala5.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala5, getString(R.string.textRupavacaraKusalaKoren1));
            } else if (clickedButton == funkciya5) {
                textViewAbhidhammaRupavacaraKusala5.setText(R.string.textRupavacaraKusalaFunkciya2);
                textViewAbhidhammaRupavacaraKusala5.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala5, getString(R.string.textRupavacaraKusalaFunkciya2));
            } else if (clickedButton == kombinaciya5) {
                textViewAbhidhammaRupavacaraKusala5.setText(R.string.textRupavacaraKusalaKombinaciya5);
                textViewAbhidhammaRupavacaraKusala5.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala5, getString(R.string.textRupavacaraKusalaKombinaciya5));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaRupavacaraVipakaGroup6(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaRupavacaraKusala6.getVisibility();
        textViewAbhidhammaRupavacaraKusala1.setText("");
        textViewAbhidhammaRupavacaraKusala2.setText("");
        textViewAbhidhammaRupavacaraKusala3.setText("");
        textViewAbhidhammaRupavacaraKusala4.setText("");
        textViewAbhidhammaRupavacaraKusala5.setText("");
        textViewAbhidhammaRupavacaraKusala6.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaRupavacaraKusala6.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaRupavacaraKusala6.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == rupavacaraKusala6) {
                textViewAbhidhammaRupavacaraKusala6.setText(R.string.textRupavacaraKusala6);
                textViewAbhidhammaRupavacaraKusala6.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaRupavacaraKusala6, getString(R.string.textRupavacaraKusala6));
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

    public void toAbhidhammaChittasVipaka(View view){
        startIntentActivityAndFinish(AbhidhammaChittasRupavacaraActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(AbhidhammaChittasRupavacaraActivity.class);
    }
}