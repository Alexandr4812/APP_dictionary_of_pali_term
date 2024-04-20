package com.dhammamobile.dictionary_of_pali_term.Abhidhamma;

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


public class AbhidhammaChittasKamavacharamUnwholsomeLobhamulachitaniActivity extends BaseActivityClass {

    private TextView textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1;
    private TextView textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2;
    private TextView textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3;
    private TextView textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4;
    private TextView textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5;
    private TextView textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6;
    private TextView textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7;
    private TextView textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8;

    private Button lobhamulachittani1, lobhamulachittani2, lobhamulachittani3, lobhamulachittani4,
            lobhamulachittani5, lobhamulachittani6, lobhamulachittani7, lobhamulachittani8;
    private Button koren1,koren2,koren3,koren4,koren5,koren6,koren7,koren8,
    funkciya1,funkciya2,funkciya3,funkciya4,funkciya5,funkciya6,funkciya7,funkciya8,
    kombinaciya1,kombinaciya2,kombinaciya3,kombinaciya4,kombinaciya5,kombinaciya6,kombinaciya7,kombinaciya8;

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_kamavacharam_unwholsome_lobhamulachitani);

      //  setWindowFlagsFullscreenAndNoLimits();

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitani1);
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitani2);
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitani3);
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitani4);
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitani5);
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitani6);
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitani7);
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitani8);

        lobhamulachittani1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitani1);
        lobhamulachittani2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitani2);
        lobhamulachittani3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitani3);
        lobhamulachittani4 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitani4);
        lobhamulachittani5 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitani5);
        lobhamulachittani6 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitani6);
        lobhamulachittani7 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitani7);
        lobhamulachittani8 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitani8);

        koren1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_koren1);
        koren2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_koren2);
        koren3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_koren3);
        koren4 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_koren4);
        koren5 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_koren5);
        koren6 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_koren6);
        koren7 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_koren7);
        koren8 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_koren8);

        funkciya1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_funkciya1);
        funkciya2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_funkciya2);
        funkciya3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_funkciya3);
        funkciya4 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_funkciya4);
        funkciya5 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_funkciya5);
        funkciya6 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_funkciya6);
        funkciya7 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_funkciya7);
        funkciya8 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_funkciya8);

        kombinaciya1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_kombinaciya1);
        kombinaciya2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_kombinaciya2);
        kombinaciya3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_kombinaciya3);
        kombinaciya4 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_kombinaciya4);
        kombinaciya5 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_kombinaciya5);
        kombinaciya6 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_kombinaciya6);
        kombinaciya7 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_kombinaciya7);
        kombinaciya8 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_lobhamulachitan_kombinaciya8);
    }

    public void onButtonClickAbhidhammaLobhaGroup1(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == lobhamulachittani1) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setText(R.string.textLobhamulachitta1);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1, getString(R.string.textLobhamulachitta1));
            } else if (clickedButton == koren1) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setText(R.string.textLobhamulachittaKoren1);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1, getString(R.string.textLobhamulachittaKoren1));
            } else if (clickedButton == funkciya1) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setText(R.string.textLobhamulachittaFunkciya1);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1, getString(R.string.textLobhamulachittaFunkciya1));
            } else if (clickedButton == kombinaciya1) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setText(R.string.textLobhamulachittaKombinaciya1);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1, getString(R.string.textLobhamulachittaKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaLobhaGroup2(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == lobhamulachittani2) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setText(R.string.textLobhamulachitta2);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2, getString(R.string.textLobhamulachitta2));
            } else if (clickedButton == koren2) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setText(R.string.textLobhamulachittaKoren2);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2, getString(R.string.textLobhamulachittaKoren2));
            } else if (clickedButton == funkciya2) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setText(R.string.textLobhamulachittaFunkciya2);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2, getString(R.string.textLobhamulachittaFunkciya2));
            } else if (clickedButton == kombinaciya2) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setText(R.string.textLobhamulachittaKombinaciya2);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2, getString(R.string.textLobhamulachittaKombinaciya2));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaLobhaGroup3(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == lobhamulachittani3) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3.setText(R.string.textLobhamulachitta3);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3, getString(R.string.textLobhamulachitta3));
            } else if (clickedButton == koren3) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3.setText(R.string.textLobhamulachittaKoren3);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3, getString(R.string.textLobhamulachittaKoren3));
            } else if (clickedButton == funkciya3) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3.setText(R.string.textLobhamulachittaFunkciya3);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3, getString(R.string.textLobhamulachittaFunkciya3));
            } else if (clickedButton == kombinaciya3) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3.setText(R.string.textLobhamulachittaKombinaciya3);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3, getString(R.string.textLobhamulachittaKombinaciya3));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaLobhaGroup4(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == lobhamulachittani4) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4.setText(R.string.textLobhamulachitta4);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4, getString(R.string.textLobhamulachitta4));
            } else if (clickedButton == koren4) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4.setText(R.string.textLobhamulachittaKoren4);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4, getString(R.string.textLobhamulachittaKoren4));
            } else if (clickedButton == funkciya4) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4.setText(R.string.textLobhamulachittaFunkciya4);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4, getString(R.string.textLobhamulachittaFunkciya4));
            } else if (clickedButton == kombinaciya4) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4.setText(R.string.textLobhamulachittaKombinaciya4);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4, getString(R.string.textLobhamulachittaKombinaciya4));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaLobhaGroup5(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == lobhamulachittani5) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5.setText(R.string.textLobhamulachitta5);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5, getString(R.string.textLobhamulachitta5));
            } else if (clickedButton == koren5) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5.setText(R.string.textLobhamulachittaKoren5);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5, getString(R.string.textLobhamulachittaKoren5));
            } else if (clickedButton == funkciya5) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5.setText(R.string.textLobhamulachittaFunkciya5);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5, getString(R.string.textLobhamulachittaFunkciya5));
            } else if (clickedButton == kombinaciya5) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5.setText(R.string.textLobhamulachittaKombinaciya5);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5, getString(R.string.textLobhamulachittaKombinaciya5));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaLobhaGroup6(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == lobhamulachittani6) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6.setText(R.string.textLobhamulachitta6);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6, getString(R.string.textLobhamulachitta6));
            } else if (clickedButton == koren6) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6.setText(R.string.textLobhamulachittaKoren6);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6, getString(R.string.textLobhamulachittaKoren6));
            } else if (clickedButton == funkciya6) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6.setText(R.string.textLobhamulachittaFunkciya6);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6, getString(R.string.textLobhamulachittaFunkciya6));
            } else if (clickedButton == kombinaciya6) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6.setText(R.string.textLobhamulachittaKombinaciya6);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6, getString(R.string.textLobhamulachittaKombinaciya6));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaLobhaGroup7(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == lobhamulachittani7) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7.setText(R.string.textLobhamulachitta7);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7, getString(R.string.textLobhamulachitta7));
            } else if (clickedButton == koren7) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7.setText(R.string.textLobhamulachittaKoren7);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7, getString(R.string.textLobhamulachittaKoren7));
            } else if (clickedButton == funkciya7) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7.setText(R.string.textLobhamulachittaFunkciya7);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7, getString(R.string.textLobhamulachittaFunkciya7));
            } else if (clickedButton == kombinaciya7) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7.setText(R.string.textLobhamulachittaKombinaciya7);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7, getString(R.string.textLobhamulachittaKombinaciya7));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaLobhaGroup8(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta1.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta2.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta3.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta4.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta5.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta6.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta7.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == lobhamulachittani8) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8.setText(R.string.textLobhamulachitta8);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8, getString(R.string.textLobhamulachitta8));
            } else if (clickedButton == koren8) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8.setText(R.string.textLobhamulachittaKoren8);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8, getString(R.string.textLobhamulachittaKoren8));
            } else if (clickedButton == funkciya8) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8.setText(R.string.textLobhamulachittaFunkciya8);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8, getString(R.string.textLobhamulachittaFunkciya8));
            } else if (clickedButton == kombinaciya8) {
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8.setText(R.string.textLobhamulachittaKombinaciya8);
                textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeLobhamulachitta8, getString(R.string.textLobhamulachittaKombinaciya8));
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

    public void toAbhidhammaChittasKamavacharamUnwholsomeAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamUnwholsomeActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamUnwholsomeActivity.class);
    }
}