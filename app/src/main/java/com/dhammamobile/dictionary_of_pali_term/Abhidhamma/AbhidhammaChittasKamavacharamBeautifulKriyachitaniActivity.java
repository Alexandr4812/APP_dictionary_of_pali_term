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

public class AbhidhammaChittasKamavacharamBeautifulKriyachitaniActivity extends BaseActivityClass {
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_summ;

    private Button kriyachitani1, kriyachitani2, kriyachitani3, kriyachitani4,
            kriyachitani5, kriyachitani6, kriyachitani7, kriyachitani8, kriyachitaniSumm;

    private Button koren1,koren2,koren3,koren4,koren5,koren6,koren7,koren8,
            funkciya1,funkciya2,funkciya3,funkciya4,funkciya5,funkciya6,funkciya7,funkciya8,
            kombinaciya1,kombinaciya2,kombinaciya3,kombinaciya4,kombinaciya5,kombinaciya6,kombinaciya7,kombinaciya8;

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_kamavacharam_beautiful_kriyachitani);

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1);
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2);
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3);
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4);
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5);
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6);
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7);
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8);
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_summ = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_summ);

        kriyachitani1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1);
        kriyachitani2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2);
        kriyachitani3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3);
        kriyachitani4 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4);
        kriyachitani5 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5);
        kriyachitani6 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6);
        kriyachitani7 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7);
        kriyachitani8 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8);

        koren1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_koren1);
        koren2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_koren2);
        koren3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_koren3);
        koren4 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_koren4);
        koren5 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_koren5);
        koren6 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_koren6);
        koren7 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_koren7);
        koren8 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_koren8);

        funkciya1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_funkciya1);
        funkciya2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_funkciya2);
        funkciya3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_funkciya3);
        funkciya4 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_funkciya4);
        funkciya5 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_funkciya5);
        funkciya6 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_funkciya6);
        funkciya7 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_funkciya7);
        funkciya8 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_funkciya8);

        kombinaciya1 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_kombinaciya1);
        kombinaciya2 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_kombinaciya2);
        kombinaciya3 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_kombinaciya3);
        kombinaciya4 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_kombinaciya4);
        kombinaciya5 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_kombinaciya5);
        kombinaciya6 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_kombinaciya6);
        kombinaciya7 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_kombinaciya7);
        kombinaciya8 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_kombinaciya8);

        kriyachitaniSumm = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_summ);
    }

    public void onButtonClickAbhidhammaKriyachitaniGroup1(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_summ.setText("");
        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == koren1) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1.setText(R.string.textKusalachitaniKorenThri);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1, getString(R.string.textKusalachitaniKorenThri));
            } else if (clickedButton == funkciya1) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1.setText(R.string.textKusalachitaniFunkciyaJavana);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1, getString(R.string.textKusalachitaniFunkciyaJavana));
            } else if (clickedButton == kombinaciya1) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1.setText(R.string.textKriyachitaniKombinaciya1);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1, getString(R.string.textKriyachitaniKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaKriyachitaniGroup2(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_summ.setText("");
        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == koren2) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2.setText(R.string.textKusalachitaniKorenThri);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2, getString(R.string.textKusalachitaniKorenThri));
            } else if (clickedButton == funkciya2) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2.setText(R.string.textKusalachitaniFunkciyaJavana);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2, getString(R.string.textKusalachitaniFunkciyaJavana));
            } else if (clickedButton == kombinaciya2) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2.setText(R.string.textKriyachitaniKombinaciya2);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2, getString(R.string.textKriyachitaniKombinaciya2));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaKriyachitaniGroup3(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_summ.setText("");
        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == koren3) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3.setText(R.string.textKusalachitaniKorenTwo);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3, getString(R.string.textKusalachitaniKorenTwo));
            } else if (clickedButton == funkciya3) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3.setText(R.string.textKusalachitaniFunkciyaJavana);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3, getString(R.string.textKusalachitaniFunkciyaJavana));
            } else if (clickedButton == kombinaciya3) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3.setText(R.string.textKriyachitaniKombinaciya3);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3, getString(R.string.textKriyachitaniKombinaciya3));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaKriyachitaniGroup4(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_summ.setText("");
        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == koren4) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4.setText(R.string.textKusalachitaniKorenTwo);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4, getString(R.string.textKusalachitaniKorenTwo));
            } else if (clickedButton == funkciya4) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4.setText(R.string.textKusalachitaniFunkciyaJavana);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4, getString(R.string.textKusalachitaniFunkciyaJavana));
            } else if (clickedButton == kombinaciya4) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4.setText(R.string.textKriyachitaniKombinaciya4);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4, getString(R.string.textKriyachitaniKombinaciya4));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaKriyachitaniGroup5(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_summ.setText("");
        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == koren5) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5.setText(R.string.textKusalachitaniKorenThri);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5, getString(R.string.textKusalachitaniKorenThri));
            } else if (clickedButton == funkciya5) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5.setText(R.string.textKusalachitaniFunkciyaJavana);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5, getString(R.string.textKusalachitaniFunkciyaJavana));
            } else if (clickedButton == kombinaciya5) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5.setText(R.string.textKriyachitaniKombinaciya5);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5, getString(R.string.textKriyachitaniKombinaciya5));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaKriyachitaniGroup6(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_summ.setText("");
        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == koren6) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6.setText(R.string.textKusalachitaniKorenThri);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6, getString(R.string.textKusalachitaniKorenThri));
            } else if (clickedButton == funkciya6) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6.setText(R.string.textKusalachitaniFunkciyaJavana);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6, getString(R.string.textKusalachitaniFunkciyaJavana));
            } else if (clickedButton == kombinaciya6) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6.setText(R.string.textKriyachitaniKombinaciya6);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6, getString(R.string.textKriyachitaniKombinaciya6));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaKriyachitaniGroup7(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_summ.setText("");
        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == koren7) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7.setText(R.string.textKusalachitaniKorenTwo);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7, getString(R.string.textKusalachitaniKorenTwo));
            } else if (clickedButton == funkciya7) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7.setText(R.string.textKusalachitaniFunkciyaJavana);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7, getString(R.string.textKusalachitaniFunkciyaJavana));
            } else if (clickedButton == kombinaciya7) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7.setText(R.string.textKriyachitaniKombinaciya7);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7, getString(R.string.textKriyachitaniKombinaciya7));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaKriyachitaniGroup8(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_summ.setText("");
        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == koren8) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8.setText(R.string.textKusalachitaniKorenTwo);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8, getString(R.string.textKusalachitaniKorenTwo));
            } else if (clickedButton == funkciya8) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8.setText(R.string.textKusalachitaniFunkciyaJavana);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8, getString(R.string.textKusalachitaniFunkciyaJavana));
            } else if (clickedButton == kombinaciya8) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8.setText(R.string.textKriyachitaniKombinaciya8);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8, getString(R.string.textKriyachitaniKombinaciya8));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaKriyachitaniGroup9(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_summ.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_summ.setText("");
        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_summ.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_summ.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == kriyachitaniSumm) {
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_summ.setText(R.string.textDescriptionKriyachitani);
                textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_summ.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_kriyachitani_summ, getString(R.string.textDescriptionKriyachitani));
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