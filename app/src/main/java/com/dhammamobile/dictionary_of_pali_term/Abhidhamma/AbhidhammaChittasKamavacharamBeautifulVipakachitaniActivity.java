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

public class AbhidhammaChittasKamavacharamBeautifulVipakachitaniActivity extends BaseActivityClass {

    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8;
    private TextView textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_summ;

    private Button vipakachitani1, vipakachitani2, vipakachitani3, vipakachitani4,
            vipakachitani5, vipakachitani6, vipakachitani7, vipakachitani8, vipakachitaniSumm;

    private Button koren1,koren2,koren3,koren4,koren5,koren6,koren7,koren8,
            funkciya1,funkciya2,funkciya3,funkciya4,funkciya5,funkciya6,funkciya7,funkciya8,
            kombinaciya1,kombinaciya2,kombinaciya3,kombinaciya4,kombinaciya5,kombinaciya6,kombinaciya7,kombinaciya8;

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_kamavacharam_beautiful_vipakachitani);

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1);
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2);
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3);
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4);
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5);
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6);
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7);
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8 = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8);
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_summ = findViewById(R.id.textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_summ);

        vipakachitani1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1);
        vipakachitani2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2);
        vipakachitani3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3);
        vipakachitani4 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4);
        vipakachitani5 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5);
        vipakachitani6 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6);
        vipakachitani7 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7);
        vipakachitani8 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8);

        koren1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_koren1);
        koren2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_koren2);
        koren3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_koren3);
        koren4 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_koren4);
        koren5 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_koren5);
        koren6 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_koren6);
        koren7 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_koren7);
        koren8 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_koren8);

        funkciya1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_funkciya1);
        funkciya2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_funkciya2);
        funkciya3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_funkciya3);
        funkciya4 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_funkciya4);
        funkciya5 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_funkciya5);
        funkciya6 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_funkciya6);
        funkciya7 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_funkciya7);
        funkciya8 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_funkciya8);

        kombinaciya1 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_kombinaciya1);
        kombinaciya2 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_kombinaciya2);
        kombinaciya3 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_kombinaciya3);
        kombinaciya4 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_kombinaciya4);
        kombinaciya5 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_kombinaciya5);
        kombinaciya6 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_kombinaciya6);
        kombinaciya7 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_kombinaciya7);
        kombinaciya8 =findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_kombinaciya8);

        vipakachitaniSumm = findViewById(R.id.button_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_summ);
    }

    public void onButtonClickAbhidhammaVipakachitaniGroup1(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_summ.setText("");
        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == koren1) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1.setText(R.string.textKusalachitaniKorenThri);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1, getString(R.string.textKusalachitaniKorenThri));
            } else if (clickedButton == funkciya1) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1.setText(R.string.textBeautifulKusalachitaniVipaka);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1, getString(R.string.textBeautifulKusalachitaniVipaka));
            } else if (clickedButton == kombinaciya1) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1.setText(R.string.textVipakachitaniKombinaciya1);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1, getString(R.string.textVipakachitaniKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }
    public void onButtonClickAbhidhammaVipakachitaniGroup2(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_summ.setText("");
        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == koren2) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2.setText(R.string.textKusalachitaniKorenThri);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2, getString(R.string.textKusalachitaniKorenThri));
            } else if (clickedButton == funkciya2) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2.setText(R.string.textBeautifulKusalachitaniVipaka);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2, getString(R.string.textBeautifulKusalachitaniVipaka));
            } else if (clickedButton == kombinaciya2) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2.setText(R.string.textVipakachitaniKombinaciya2);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2, getString(R.string.textVipakachitaniKombinaciya2));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }
    public void onButtonClickAbhidhammaVipakachitaniGroup3(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_summ.setText("");
        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == koren3) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3.setText(R.string.textKusalachitaniKorenTwo);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3, getString(R.string.textKusalachitaniKorenTwo));
            } else if (clickedButton == funkciya3) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3.setText(R.string.textBeautifulKusalachitaniVipaka);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3, getString(R.string.textBeautifulKusalachitaniVipaka));
            } else if (clickedButton == kombinaciya3) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3.setText(R.string.textVipakachitaniKombinaciya3);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3, getString(R.string.textVipakachitaniKombinaciya3));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }
    public void onButtonClickAbhidhammaVipakachitaniGroup4(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_summ.setText("");
        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == koren4) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4.setText(R.string.textKusalachitaniKorenTwo);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4, getString(R.string.textKusalachitaniKorenTwo));
            } else if (clickedButton == funkciya4) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4.setText(R.string.textBeautifulKusalachitaniVipaka);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4, getString(R.string.textBeautifulKusalachitaniVipaka));
            } else if (clickedButton == kombinaciya4) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4.setText(R.string.textVipakachitaniKombinaciya4);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4, getString(R.string.textVipakachitaniKombinaciya4));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }
    public void onButtonClickAbhidhammaVipakachitaniGroup5(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_summ.setText("");
        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == koren5) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5.setText(R.string.textKusalachitaniKorenThri);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5, getString(R.string.textKusalachitaniKorenThri));
            } else if (clickedButton == funkciya5) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5.setText(R.string.textBeautifulKusalachitaniVipaka);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5, getString(R.string.textBeautifulKusalachitaniVipaka));
            } else if (clickedButton == kombinaciya5) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5.setText(R.string.textVipakachitaniKombinaciya5);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5, getString(R.string.textVipakachitaniKombinaciya5));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }
    public void onButtonClickAbhidhammaVipakachitaniGroup6(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_summ.setText("");
        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == koren6) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6.setText(R.string.textKusalachitaniKorenThri);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6, getString(R.string.textKusalachitaniKorenThri));
            } else if (clickedButton == funkciya6) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6.setText(R.string.textBeautifulKusalachitaniVipaka);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6, getString(R.string.textBeautifulKusalachitaniVipaka));
            } else if (clickedButton == kombinaciya6) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6.setText(R.string.textVipakachitaniKombinaciya6);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6, getString(R.string.textVipakachitaniKombinaciya6));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }
    public void onButtonClickAbhidhammaVipakachitaniGroup7(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_summ.setText("");
        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == koren7) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7.setText(R.string.textKusalachitaniKorenTwo);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7, getString(R.string.textKusalachitaniKorenTwo));
            } else if (clickedButton == funkciya7) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7.setText(R.string.textBeautifulKusalachitaniVipaka);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7, getString(R.string.textBeautifulKusalachitaniVipaka));
            } else if (clickedButton == kombinaciya7) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7.setText(R.string.textVipakachitaniKombinaciya7);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7, getString(R.string.textVipakachitaniKombinaciya7));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }
    public void onButtonClickAbhidhammaVipakachitaniGroup8(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_summ.setText("");
        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == koren8) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8.setText(R.string.textKusalachitaniKorenTwo);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8, getString(R.string.textKusalachitaniKorenTwo));
            } else if (clickedButton == funkciya8) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8.setText(R.string.textBeautifulKusalachitaniVipaka);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8, getString(R.string.textBeautifulKusalachitaniVipaka));
            } else if (clickedButton == kombinaciya8) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8.setText(R.string.textVipakachitaniKombinaciya8);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8, getString(R.string.textVipakachitaniKombinaciya8));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }
    public void onButtonClickAbhidhammaVipakachitaniGroup9(View view) {
        Button clickedButton = (Button) view;
        int visibility = textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_summ.getVisibility();
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani1.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani2.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani3.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani4.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani5.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani6.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani7.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani8.setText("");
        textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_summ.setText("");
        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_summ.setText(""); // Установите текст в пустую строку
            textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_summ.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == vipakachitaniSumm) {
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_summ.setText(R.string.textVipakachitaniResult);
                textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_summ.setVisibility(View.VISIBLE);
                animateText(textView_abhidhamma_chittas_kamavachara_beautiful_vipakachitani_summ, getString(R.string.textVipakachitaniResult));
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