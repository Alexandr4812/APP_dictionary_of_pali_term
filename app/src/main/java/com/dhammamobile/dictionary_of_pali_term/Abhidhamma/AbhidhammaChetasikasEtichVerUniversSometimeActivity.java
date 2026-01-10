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

public class AbhidhammaChetasikasEtichVerUniversSometimeActivity extends BaseActivityClass {

    private TextView textViewAbhidhammaChetasikaSometime1;
    private Button buttonMentalnieFaktoriSometime1, buttonHarakteristika1, buttonFunkciya1, buttonProyavlenie1, buttonPrichina1,
            buttonAssociaciya1;

    private TextView textViewAbhidhammaChetasikaSometime2;
    private Button buttonMentalnieFaktoriSometime2, buttonHarakteristika2, buttonFunkciya2, buttonProyavlenie2, buttonPrichina2,
            buttonAssociaciya2;

    private TextView textViewAbhidhammaChetasikaSometime3;
    private Button buttonMentalnieFaktoriSometime3, buttonHarakteristika3, buttonFunkciya3, buttonProyavlenie3, buttonPrichina3,
            buttonAssociaciya3;

    private TextView textViewAbhidhammaChetasikaSometime4;
    private Button buttonMentalnieFaktoriSometime4, buttonHarakteristika4, buttonFunkciya4, buttonProyavlenie4, buttonPrichina4,
            buttonAssociaciya4;

    private TextView textViewAbhidhammaChetasikaSometime5;
    private Button buttonMentalnieFaktoriSometime5, buttonHarakteristika5, buttonFunkciya5, buttonProyavlenie5, buttonPrichina5,
            buttonAssociaciya5;

    private TextView textViewAbhidhammaChetasikaSometime6;
    private Button buttonMentalnieFaktoriSometime6, buttonHarakteristika6, buttonFunkciya6, buttonProyavlenie6, buttonPrichina6,
            buttonAssociaciya6;


    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        EdgeToEdge.enable(this);
        setContentView(R.layout.activity_abhidhamma_chetasikas_etich_ver_univers_sometime);

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        textViewAbhidhammaChetasikaSometime1 = findViewById(R.id.textViewAbhidhammaChetasikaSometime1);
        textViewAbhidhammaChetasikaSometime2 = findViewById(R.id.textViewAbhidhammaChetasikaSometime2);
        textViewAbhidhammaChetasikaSometime3 = findViewById(R.id.textViewAbhidhammaChetasikaSometime3);
        textViewAbhidhammaChetasikaSometime4 = findViewById(R.id.textViewAbhidhammaChetasikaSometime4);
        textViewAbhidhammaChetasikaSometime5 = findViewById(R.id.textViewAbhidhammaChetasikaSometime5);
        textViewAbhidhammaChetasikaSometime6 = findViewById(R.id.textViewAbhidhammaChetasikaSometime6);

        buttonMentalnieFaktoriSometime1 = findViewById(R.id.button_mentalnie_faktori_sometime1);
        buttonHarakteristika1 = findViewById(R.id.button_chetasika_harakteristika_sometime1);
        buttonFunkciya1 = findViewById(R.id.button_chetasika_function_sometime1);
        buttonProyavlenie1 = findViewById(R.id.button_chetasika_proyavlenie_sometime1);
        buttonPrichina1 = findViewById(R.id.button_chetasika_prichina_sometime1);
        buttonAssociaciya1 = findViewById(R.id.button_chetasika_associaciya_sometime1);

        buttonMentalnieFaktoriSometime2 = findViewById(R.id.button_mentalnie_faktori_sometime2);
        buttonHarakteristika2 = findViewById(R.id.button_chetasika_harakteristika_sometime2);
        buttonFunkciya2 = findViewById(R.id.button_chetasika_function_sometime2);
        buttonProyavlenie2 = findViewById(R.id.button_chetasika_proyavlenie_sometime2);
        buttonPrichina2 = findViewById(R.id.button_chetasika_prichina_sometime2);
        buttonAssociaciya2 = findViewById(R.id.button_chetasika_kontakt_associaciya_sometime2);

        buttonMentalnieFaktoriSometime3 = findViewById(R.id.button_mentalnie_faktori_sometime3);
        buttonHarakteristika3 = findViewById(R.id.button_chetasika_harakteristika_sometime3);
        buttonFunkciya3 = findViewById(R.id.button_chetasika_function_sometime3);
        buttonProyavlenie3 = findViewById(R.id.button_chetasika_proyavlenie_sometime3);
        buttonPrichina3 = findViewById(R.id.button_chetasika_prichina_sometime3);
        buttonAssociaciya3 = findViewById(R.id.button_chetasika_kontakt_associaciya_sometime3);

        buttonMentalnieFaktoriSometime4 = findViewById(R.id.button_mentalnie_faktori_sometime4);
        buttonHarakteristika4 = findViewById(R.id.button_chetasika_harakteristika_sometime4);
        buttonFunkciya4 = findViewById(R.id.button_chetasika_function_sometime4);
        buttonProyavlenie4 = findViewById(R.id.button_chetasika_proyavlenie_sometime4);
        buttonPrichina4 = findViewById(R.id.button_chetasika_prichina_sometime4);
        buttonAssociaciya4 = findViewById(R.id.button_chetasika_kontakt_associaciya_sometime4);

        buttonMentalnieFaktoriSometime5 = findViewById(R.id.button_mentalnie_faktori_sometime5);
        buttonHarakteristika5 = findViewById(R.id.button_chetasika_harakteristika_sometime5);
        buttonFunkciya5 = findViewById(R.id.button_chetasika_function_sometime5);
        buttonProyavlenie5 = findViewById(R.id.button_chetasika_proyavlenie_sometime5);
        buttonPrichina5 = findViewById(R.id.button_chetasika_prichina_sometime5);
        buttonAssociaciya5 = findViewById(R.id.button_chetasika_kontakt_associaciya_sometime5);

        buttonMentalnieFaktoriSometime6 = findViewById(R.id.button_mentalnie_faktori_sometime6);
        buttonHarakteristika6 = findViewById(R.id.button_chetasika_harakteristika_sometime6);
        buttonFunkciya6 = findViewById(R.id.button_chetasika_function_sometime6);
        buttonProyavlenie6 = findViewById(R.id.button_chetasika_proyavlenie_sometime6);
        buttonPrichina6 = findViewById(R.id.button_chetasika_prichina_sometime6);
        buttonAssociaciya6 = findViewById(R.id.button_chetasika_kontakt_associaciya_sometime6);
    }

    public void onButtonClickGroupSometime1(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaChetasikaSometime1.getVisibility();
        textViewAbhidhammaChetasikaSometime2.setText("");
        textViewAbhidhammaChetasikaSometime3.setText("");
        textViewAbhidhammaChetasikaSometime4.setText("");
        textViewAbhidhammaChetasikaSometime5.setText("");
        textViewAbhidhammaChetasikaSometime6.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaChetasikaSometime1.setText(""); // Установите текст в пустую строку
        } else {
            if (clickedButton == buttonHarakteristika1) {
                textViewAbhidhammaChetasikaSometime1.setText(R.string.text_for_harakteristika_sometime1);
                animateText(textViewAbhidhammaChetasikaSometime1, getString(R.string.text_for_harakteristika_sometime1));
            } else if (clickedButton == buttonFunkciya1) {
                textViewAbhidhammaChetasikaSometime1.setText(R.string.text_for_function_sometime1);
                animateText(textViewAbhidhammaChetasikaSometime1, getString(R.string.text_for_function_sometime1));
            } else if (clickedButton == buttonProyavlenie1) {
                textViewAbhidhammaChetasikaSometime1.setText(R.string.text_for_proyavlenie_sometime1);
                animateText(textViewAbhidhammaChetasikaSometime1, getString(R.string.text_for_proyavlenie_sometime1));
            } else if (clickedButton == buttonPrichina1) {
                textViewAbhidhammaChetasikaSometime1.setText(R.string.text_for_prichina_sometime1);
                animateText(textViewAbhidhammaChetasikaSometime1, getString(R.string.text_for_prichina_sometime1));
            } else if (clickedButton == buttonMentalnieFaktoriSometime1) {
                textViewAbhidhammaChetasikaSometime1.setText(R.string.text_for_mentalnie_faktori_sometime1);
                animateText(textViewAbhidhammaChetasikaSometime1, getString(R.string.text_for_mentalnie_faktori_sometime1));
            } else if (clickedButton == buttonAssociaciya1) {
                textViewAbhidhammaChetasikaSometime1.setText(R.string.text_for_button_associaciya_sometime1);
                animateText(textViewAbhidhammaChetasikaSometime1, getString(R.string.text_for_button_associaciya_sometime1));
            }

            textViewAbhidhammaChetasikaSometime1.setVisibility(View.VISIBLE);
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickGroupSometime2(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaChetasikaSometime2.getVisibility();
        textViewAbhidhammaChetasikaSometime2.setText("");
        textViewAbhidhammaChetasikaSometime3.setText("");
        textViewAbhidhammaChetasikaSometime4.setText("");
        textViewAbhidhammaChetasikaSometime5.setText("");
        textViewAbhidhammaChetasikaSometime6.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaChetasikaSometime2.setText(""); // Установите текст в пустую строку
        } else {
            if (clickedButton == buttonHarakteristika2) {
                textViewAbhidhammaChetasikaSometime2.setText(R.string.text_for_harakteristika_sometime2);
                animateText(textViewAbhidhammaChetasikaSometime2, getString(R.string.text_for_harakteristika_sometime2));
            } else if (clickedButton == buttonFunkciya2) {
                textViewAbhidhammaChetasikaSometime2.setText(R.string.text_for_function_sometime2);
                animateText(textViewAbhidhammaChetasikaSometime2, getString(R.string.text_for_function_sometime2));
            } else if (clickedButton == buttonProyavlenie2) {
                textViewAbhidhammaChetasikaSometime2.setText(R.string.text_for_proyavlenie_sometime2);
                animateText(textViewAbhidhammaChetasikaSometime2, getString(R.string.text_for_proyavlenie_sometime2));
            } else if (clickedButton == buttonPrichina2) {
                textViewAbhidhammaChetasikaSometime2.setText(R.string.text_for_prichina_sometime2);
                animateText(textViewAbhidhammaChetasikaSometime2, getString(R.string.text_for_prichina_sometime2));
            } else if (clickedButton == buttonMentalnieFaktoriSometime2) {
                textViewAbhidhammaChetasikaSometime2.setText(R.string.text_for_mentalnie_faktori_sometime2);
                animateText(textViewAbhidhammaChetasikaSometime2, getString(R.string.text_for_mentalnie_faktori_sometime2));
            } else if (clickedButton == buttonAssociaciya2) {
                textViewAbhidhammaChetasikaSometime2.setText(R.string.text_for_button_associaciya_sometime2);
                animateText(textViewAbhidhammaChetasikaSometime2, getString(R.string.text_for_button_associaciya_sometime2));
            }

            textViewAbhidhammaChetasikaSometime2.setVisibility(View.VISIBLE);
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickGroupSometime3(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaChetasikaSometime3.getVisibility();
        textViewAbhidhammaChetasikaSometime2.setText("");
        textViewAbhidhammaChetasikaSometime3.setText("");
        textViewAbhidhammaChetasikaSometime4.setText("");
        textViewAbhidhammaChetasikaSometime5.setText("");
        textViewAbhidhammaChetasikaSometime6.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaChetasikaSometime3.setText(""); // Установите текст в пустую строку
        } else {
            if (clickedButton == buttonHarakteristika3) {
                textViewAbhidhammaChetasikaSometime3.setText(R.string.text_for_harakteristika_sometime3);
                animateText(textViewAbhidhammaChetasikaSometime3, getString(R.string.text_for_harakteristika_sometime3));
            } else if (clickedButton == buttonFunkciya3) {
                textViewAbhidhammaChetasikaSometime3.setText(R.string.text_for_function_sometime3);
                animateText(textViewAbhidhammaChetasikaSometime3, getString(R.string.text_for_function_sometime3));
            } else if (clickedButton == buttonProyavlenie3) {
                textViewAbhidhammaChetasikaSometime3.setText(R.string.text_for_proyavlenie_sometime3);
                animateText(textViewAbhidhammaChetasikaSometime3, getString(R.string.text_for_proyavlenie_sometime3));
            } else if (clickedButton == buttonPrichina3) {
                textViewAbhidhammaChetasikaSometime3.setText(R.string.text_for_prichina_sometime3);
                animateText(textViewAbhidhammaChetasikaSometime3, getString(R.string.text_for_prichina_sometime3));
            } else if (clickedButton == buttonMentalnieFaktoriSometime3) {
                textViewAbhidhammaChetasikaSometime3.setText(R.string.text_for_mentalnie_faktori_sometime3);
                animateText(textViewAbhidhammaChetasikaSometime3, getString(R.string.text_for_mentalnie_faktori_sometime3));
            } else if (clickedButton == buttonAssociaciya3) {
                textViewAbhidhammaChetasikaSometime3.setText(R.string.text_for_button_associaciya_sometime3);
                animateText(textViewAbhidhammaChetasikaSometime3, getString(R.string.text_for_button_associaciya_sometime3));
            }

            textViewAbhidhammaChetasikaSometime3.setVisibility(View.VISIBLE);
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickGroupSometime4(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaChetasikaSometime4.getVisibility();
        textViewAbhidhammaChetasikaSometime2.setText("");
        textViewAbhidhammaChetasikaSometime3.setText("");
        textViewAbhidhammaChetasikaSometime4.setText("");
        textViewAbhidhammaChetasikaSometime5.setText("");
        textViewAbhidhammaChetasikaSometime6.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaChetasikaSometime4.setText(""); // Установите текст в пустую строку
        } else {
            if (clickedButton == buttonHarakteristika4) {
                textViewAbhidhammaChetasikaSometime4.setText(R.string.text_for_harakteristika_sometime4);
                animateText(textViewAbhidhammaChetasikaSometime4, getString(R.string.text_for_harakteristika_sometime4));
            } else if (clickedButton == buttonFunkciya4) {
                textViewAbhidhammaChetasikaSometime4.setText(R.string.text_for_function_sometime4);
                animateText(textViewAbhidhammaChetasikaSometime4, getString(R.string.text_for_function_sometime4));
            } else if (clickedButton == buttonProyavlenie4) {
                textViewAbhidhammaChetasikaSometime4.setText(R.string.text_for_proyavlenie_sometime4);
                animateText(textViewAbhidhammaChetasikaSometime4, getString(R.string.text_for_proyavlenie_sometime4));
            } else if (clickedButton == buttonPrichina4) {
                textViewAbhidhammaChetasikaSometime4.setText(R.string.text_for_prichina_sometime4);
                animateText(textViewAbhidhammaChetasikaSometime4, getString(R.string.text_for_prichina_sometime4));
            } else if (clickedButton == buttonMentalnieFaktoriSometime4) {
                textViewAbhidhammaChetasikaSometime4.setText(R.string.text_for_mentalnie_faktori_sometime4);
                animateText(textViewAbhidhammaChetasikaSometime4, getString(R.string.text_for_mentalnie_faktori_sometime4));
            } else if (clickedButton == buttonAssociaciya4) {
                textViewAbhidhammaChetasikaSometime4.setText(R.string.text_for_button_associaciya_sometime4);
                animateText(textViewAbhidhammaChetasikaSometime4, getString(R.string.text_for_button_associaciya_sometime4));
            }

            textViewAbhidhammaChetasikaSometime4.setVisibility(View.VISIBLE);
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickGroupSometime5(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaChetasikaSometime5.getVisibility();
        textViewAbhidhammaChetasikaSometime2.setText("");
        textViewAbhidhammaChetasikaSometime3.setText("");
        textViewAbhidhammaChetasikaSometime4.setText("");
        textViewAbhidhammaChetasikaSometime5.setText("");
        textViewAbhidhammaChetasikaSometime6.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaChetasikaSometime5.setText(""); // Установите текст в пустую строку
        } else {
            if (clickedButton == buttonHarakteristika5) {
                textViewAbhidhammaChetasikaSometime5.setText(R.string.text_for_harakteristika_sometime5);
                animateText(textViewAbhidhammaChetasikaSometime5, getString(R.string.text_for_harakteristika_sometime5));
            } else if (clickedButton == buttonFunkciya5) {
                textViewAbhidhammaChetasikaSometime5.setText(R.string.text_for_function_sometime5);
                animateText(textViewAbhidhammaChetasikaSometime5, getString(R.string.text_for_function_sometime5));
            } else if (clickedButton == buttonProyavlenie5) {
                textViewAbhidhammaChetasikaSometime5.setText(R.string.text_for_proyavlenie_sometime5);
                animateText(textViewAbhidhammaChetasikaSometime5, getString(R.string.text_for_proyavlenie_sometime5));
            } else if (clickedButton == buttonPrichina5) {
                textViewAbhidhammaChetasikaSometime5.setText(R.string.text_for_prichina_sometime5);
                animateText(textViewAbhidhammaChetasikaSometime5, getString(R.string.text_for_prichina_sometime5));
            } else if (clickedButton == buttonMentalnieFaktoriSometime5) {
                textViewAbhidhammaChetasikaSometime5.setText(R.string.text_for_mentalnie_faktori_sometime5);
                animateText(textViewAbhidhammaChetasikaSometime5, getString(R.string.text_for_mentalnie_faktori_sometime5));
            } else if (clickedButton == buttonAssociaciya5) {
                textViewAbhidhammaChetasikaSometime5.setText(R.string.text_for_button_associaciya_sometime5);
                animateText(textViewAbhidhammaChetasikaSometime5, getString(R.string.text_for_button_associaciya_sometime5));
            }

            textViewAbhidhammaChetasikaSometime5.setVisibility(View.VISIBLE);
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickGroupSometime6(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaChetasikaSometime6.getVisibility();
        textViewAbhidhammaChetasikaSometime2.setText("");
        textViewAbhidhammaChetasikaSometime3.setText("");
        textViewAbhidhammaChetasikaSometime4.setText("");
        textViewAbhidhammaChetasikaSometime5.setText("");
        textViewAbhidhammaChetasikaSometime6.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaChetasikaSometime6.setText(""); // Установите текст в пустую строку
        } else {
            if (clickedButton == buttonHarakteristika6) {
                textViewAbhidhammaChetasikaSometime6.setText(R.string.text_for_harakteristika_sometime6);
                animateText(textViewAbhidhammaChetasikaSometime6, getString(R.string.text_for_harakteristika_sometime6));
            } else if (clickedButton == buttonFunkciya6) {
                textViewAbhidhammaChetasikaSometime6.setText(R.string.text_for_function_sometime6);
                animateText(textViewAbhidhammaChetasikaSometime6, getString(R.string.text_for_function_sometime6));
            } else if (clickedButton == buttonProyavlenie6) {
                textViewAbhidhammaChetasikaSometime6.setText(R.string.text_for_proyavlenie_sometime6);
                animateText(textViewAbhidhammaChetasikaSometime6, getString(R.string.text_for_proyavlenie_sometime6));
            } else if (clickedButton == buttonPrichina6) {
                textViewAbhidhammaChetasikaSometime6.setText(R.string.text_for_prichina_sometime6);
                animateText(textViewAbhidhammaChetasikaSometime6, getString(R.string.text_for_prichina_sometime6));
            } else if (clickedButton == buttonMentalnieFaktoriSometime6) {
                textViewAbhidhammaChetasikaSometime6.setText(R.string.text_for_mentalnie_faktori_sometime6);
                animateText(textViewAbhidhammaChetasikaSometime6, getString(R.string.text_for_mentalnie_faktori_sometime6));
            } else if (clickedButton == buttonAssociaciya6) {
                textViewAbhidhammaChetasikaSometime6.setText(R.string.text_for_button_associaciya_sometime6);
                animateText(textViewAbhidhammaChetasikaSometime6, getString(R.string.text_for_button_associaciya_sometime6));
            }

            textViewAbhidhammaChetasikaSometime6.setVisibility(View.VISIBLE);
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    private void animateText(TextView targetTextView, String textToAnimate) {
        ValueAnimator animator = ValueAnimator.ofInt(0, textToAnimate.length());
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

    public void toAbhidhammaAct(View view){
        startIntentActivityAndFinish(AbhidhammaActivity.class);
    }

    public void toChetasikasEtichVerAct(View view){
        startIntentActivityAndFinish(AbhidhammaChetasikasEtichVerActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(AbhidhammaChetasikasEtichVerActivity.class);
    }
}