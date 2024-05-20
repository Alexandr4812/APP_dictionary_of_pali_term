package com.dhammamobile.dictionary_of_pali_term.Abhidhamma;

import androidx.appcompat.app.AppCompatActivity;

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

public class AbhidhammaChittasKamavacharamBeautifulKusalachitaniActivity extends BaseActivityClass {

    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_summ;


    private Button kusalachitani1, kusalachitani2, kusalachitani3, kusalachitani4,
            kusalachitani5, kusalachitani6, kusalachitani7, kusalachitani8, kusalachitaniSumm;

    private Button koren1,koren2,koren3,koren4,koren5,koren6,koren7,koren8,
            funkciya1,funkciya2,funkciya3,funkciya4,funkciya5,funkciya6,funkciya7,funkciya8,
            kombinaciya1,kombinaciya2,kombinaciya3,kombinaciya4,kombinaciya5,kombinaciya6,kombinaciya7,kombinaciya8;

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_kamavacharam_beautiful_kusalachitani);

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1);
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2);
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3);
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4);
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5);
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6);
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7);
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8);
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_summ = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_summ);

        kusalachitani1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1);
        kusalachitani2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2);
        kusalachitani3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3);
        kusalachitani4 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4);
        kusalachitani5 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5);
        kusalachitani6 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6);
        kusalachitani7 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7);
        kusalachitani8 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8);

        koren1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_koren1);
        koren2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_koren2);
        koren3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_koren3);
        koren4 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_koren4);
        koren5 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_koren5);
        koren6 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_koren6);
        koren7 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_koren7);
        koren8 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_koren8);

        funkciya1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_funkciya1);
        funkciya2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_funkciya2);
        funkciya3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_funkciya3);
        funkciya4 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_funkciya4);
        funkciya5 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_funkciya5);
        funkciya6 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_funkciya6);
        funkciya7 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_funkciya7);
        funkciya8 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_funkciya8);

        kombinaciya1 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_kombinaciya1);
        kombinaciya2 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_kombinaciya2);
        kombinaciya3 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_kombinaciya3);
        kombinaciya4 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_kombinaciya4);
        kombinaciya5 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_kombinaciya5);
        kombinaciya6 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_kombinaciya6);
        kombinaciya7 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_kombinaciya7);
        kombinaciya8 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_kombinaciya8);

        kusalachitaniSumm = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_summ);

    }

    public void onButtonClickAbhidhammaKusalachitaniGroup1(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_summ.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == kusalachitani1) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1.setText(R.string.textKusalachitani1);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1, getString(R.string.textKusalachitani1));
            } else if (clickedButton == koren1) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1.setText(R.string.textKusalachitaniKorenThri);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1, getString(R.string.textKusalachitaniKorenThri));
            } else if (clickedButton == funkciya1) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1.setText(R.string.textKusalachitaniFunkciyaJavana);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1, getString(R.string.textKusalachitaniFunkciyaJavana));
            } else if (clickedButton == kombinaciya1) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1.setText(R.string.textKusalachitaniKombinaciya1);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1, getString(R.string.textKusalachitaniKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaKusalachitaniGroup2(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_summ.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == kusalachitani2) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2.setText(R.string.textKusalachitani2);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2, getString(R.string.textKusalachitani2));
            } else if (clickedButton == koren2) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2.setText(R.string.textKusalachitaniKorenThri);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2, getString(R.string.textKusalachitaniKorenThri));
            } else if (clickedButton == funkciya2) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2.setText(R.string.textKusalachitaniFunkciyaJavana);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2, getString(R.string.textKusalachitaniFunkciyaJavana));
            } else if (clickedButton == kombinaciya2) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2.setText(R.string.textKusalachitaniKombinaciya2);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2, getString(R.string.textKusalachitaniKombinaciya2));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaKusalachitaniGroup3(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_summ.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == kusalachitani3) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3.setText(R.string.textKusalachitani3);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3, getString(R.string.textKusalachitani3));
            } else if (clickedButton == koren3) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3.setText(R.string.textKusalachitaniKorenTwo);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3, getString(R.string.textKusalachitaniKorenTwo));
            } else if (clickedButton == funkciya3) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3.setText(R.string.textKusalachitaniFunkciyaJavana);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3, getString(R.string.textKusalachitaniFunkciyaJavana));
            } else if (clickedButton == kombinaciya3) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3.setText(R.string.textKusalachitaniKombinaciya3);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3, getString(R.string.textKusalachitaniKombinaciya3));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaKusalachitaniGroup4(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_summ.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == kusalachitani4) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4.setText(R.string.textKusalachitani4);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4, getString(R.string.textKusalachitani4));
            } else if (clickedButton == koren4) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4.setText(R.string.textKusalachitaniKorenTwo);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4, getString(R.string.textKusalachitaniKorenTwo));
            } else if (clickedButton == funkciya4) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4.setText(R.string.textKusalachitaniFunkciyaJavana);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4, getString(R.string.textKusalachitaniFunkciyaJavana));
            } else if (clickedButton == kombinaciya4) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4.setText(R.string.textKusalachitaniKombinaciya4);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4, getString(R.string.textKusalachitaniKombinaciya4));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }
    public void onButtonClickAbhidhammaKusalachitaniGroup5(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_summ.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == kusalachitani5) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5.setText(R.string.textKusalachitani5_6);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5, getString(R.string.textKusalachitani5_6));
            } else if (clickedButton == koren5) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5.setText(R.string.textKusalachitaniKorenThri);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5, getString(R.string.textKusalachitaniKorenThri));
            } else if (clickedButton == funkciya5) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5.setText(R.string.textKusalachitaniFunkciyaJavana);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5, getString(R.string.textKusalachitaniFunkciyaJavana));
            } else if (clickedButton == kombinaciya5) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5.setText(R.string.textKusalachitaniKombinaciya5);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5, getString(R.string.textKusalachitaniKombinaciya5));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }
    public void onButtonClickAbhidhammaKusalachitaniGroup6(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_summ.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == kusalachitani6) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6.setText(R.string.textKusalachitani5_6);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6, getString(R.string.textKusalachitani5_6));
            } else if (clickedButton == koren6) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6.setText(R.string.textKusalachitaniKorenThri);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6, getString(R.string.textKusalachitaniKorenThri));
            } else if (clickedButton == funkciya6) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6.setText(R.string.textKusalachitaniFunkciyaJavana);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6, getString(R.string.textKusalachitaniFunkciyaJavana));
            } else if (clickedButton == kombinaciya6) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6.setText(R.string.textKusalachitaniKombinaciya6);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6, getString(R.string.textKusalachitaniKombinaciya6));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }
    public void onButtonClickAbhidhammaKusalachitaniGroup7(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_summ.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == kusalachitani7) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7.setText(R.string.textKusalachitani5_6);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7, getString(R.string.textKusalachitani5_6));
            } else if (clickedButton == koren7) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7.setText(R.string.textKusalachitaniKorenTwo);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7, getString(R.string.textKusalachitaniKorenTwo));
            } else if (clickedButton == funkciya7) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7.setText(R.string.textKusalachitaniFunkciyaJavana);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7, getString(R.string.textKusalachitaniFunkciyaJavana));
            } else if (clickedButton == kombinaciya7) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7.setText(R.string.textKusalachitaniKombinaciya7);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7, getString(R.string.textKusalachitaniKombinaciya7));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaKusalachitaniGroup8(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_summ.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == kusalachitani8) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8.setText(R.string.textKusalachitani5_6);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8, getString(R.string.textKusalachitani5_6));
            } else if (clickedButton == koren8) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8.setText(R.string.textKusalachitaniKorenTwo);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8, getString(R.string.textKusalachitaniKorenTwo));
            } else if (clickedButton == funkciya8) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8.setText(R.string.textKusalachitaniFunkciyaJavana);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8, getString(R.string.textKusalachitaniFunkciyaJavana));
            } else if (clickedButton == kombinaciya8) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8.setText(R.string.textKusalachitaniKombinaciya8);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8, getString(R.string.textKusalachitaniKombinaciya8));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }
    public void onButtonClickAbhidhammaKusalachitaniGroup9(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_summ.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_summ.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_summ.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_summ.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == kusalachitaniSumm) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_summ.setText(R.string.textKusalachitaniResult);
                textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_summ.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kusalachitani_summ, getString(R.string.textKusalachitaniResult));
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

    public void toAbhidhammaChittasKamavacharamBeautifulBackAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamBeautifulActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamBeautifulActivity.class);
    }
}