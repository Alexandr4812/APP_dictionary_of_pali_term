package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.TextView;

public class AbhidhammaChetasikasActivity extends BaseActivityClass {

    private TextView textViewAbhidhammaChetasika1;
    private Button buttonKontakt, buttonHarakteristika1, buttonFunkciya1, buttonProyavlenie1, buttonPrichina1;

    private TextView textViewAbhidhammaChuvstvo2;
    private Button buttonKontakt2, buttonHarakteristika2, buttonFunkciya2, buttonProyavlenie2, buttonPrichina2;

    private TextView textViewAbhidhammaVospriyatie3;
    private Button buttonVospriyatie3, buttonHarakteristika3, buttonFunkciya3, buttonProyavlenie3, buttonPrichina3;

    private TextView textViewAbhidhammaVolenie4;
    private Button buttonVolenie4, buttonHarakteristika4, buttonFunkciya4, buttonProyavlenie4, buttonPrichina4;

    private TextView textViewAbhidhammaOdnonapravlennost5;
    private Button buttonOdnonapravlennost5, buttonHarakteristika5, buttonFunkciya5, buttonProyavlenie5, buttonPrichina5;

    private TextView textViewAbhidhammaJivitindriya6;
    private Button buttonJivitindriya6, buttonHarakteristika6, buttonFunkciya6, buttonProyavlenie6, buttonPrichina6;

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chetasikas);

        textViewAbhidhammaChetasika1 = findViewById(R.id.textViewAbhidhammaChetasika1);
        textViewAbhidhammaChuvstvo2 = findViewById(R.id.textViewAbhidhammaChetasikaChuvstvo2);
        textViewAbhidhammaVospriyatie3 = findViewById(R.id.textViewAbhidhammaChetasikaVospriyatie3);
        textViewAbhidhammaVolenie4 = findViewById(R.id.textViewAbhidhammaChetasikaVolenie4);
        textViewAbhidhammaOdnonapravlennost5 = findViewById(R.id.textViewAbhidhammaChetasikaodnonapravlennost5);
        textViewAbhidhammaJivitindriya6 = findViewById(R.id.textViewAbhidhammaChetasikaJivitindriya6);

        buttonKontakt = findViewById(R.id.button_chetasika_kontakt);
        buttonHarakteristika1 = findViewById(R.id.button_chetasika_harakteristika);
        buttonFunkciya1 = findViewById(R.id.button_chetasika_function);
        buttonProyavlenie1 = findViewById(R.id.button_chetasika_proyavlenie);
        buttonPrichina1 = findViewById(R.id.button_chetasika_prichina);

        buttonKontakt2 = findViewById(R.id.button_chetasika_Chuvstvo2);
        buttonHarakteristika2 = findViewById(R.id.button_chetasika_harakteristika2);
        buttonFunkciya2 = findViewById(R.id.button_chetasika_function2);
        buttonProyavlenie2 = findViewById(R.id.button_chetasika_proyavlenie2);
        buttonPrichina2 = findViewById(R.id.button_chetasika_prichina2);

        buttonVospriyatie3 = findViewById(R.id.button_chetasika_vospriyatie3);
        buttonHarakteristika3 = findViewById(R.id.button_chetasika_harakteristika3);
        buttonFunkciya3 = findViewById(R.id.button_chetasika_function3);
        buttonProyavlenie3 = findViewById(R.id.button_chetasika_proyavlenie3);
        buttonPrichina3 = findViewById(R.id.button_chetasika_prichina3);

        buttonVolenie4 = findViewById(R.id.button_chetasika_volenie4);
        buttonHarakteristika4 = findViewById(R.id.button_chetasika_harakteristika4);
        buttonFunkciya4 = findViewById(R.id.button_chetasika_function4);
        buttonProyavlenie4 = findViewById(R.id.button_chetasika_proyavlenie4);
        buttonPrichina4 = findViewById(R.id.button_chetasika_prichina4);

        buttonOdnonapravlennost5 = findViewById(R.id.button_chetasika_odnonapravlennost5);
        buttonHarakteristika5 = findViewById(R.id.button_chetasika_harakteristika5);
        buttonFunkciya5 = findViewById(R.id.button_chetasika_function5);
        buttonProyavlenie5 = findViewById(R.id.button_chetasika_proyavlenie5);
        buttonPrichina5 = findViewById(R.id.button_chetasika_prichina5);

        buttonJivitindriya6 = findViewById(R.id.button_chetasika_jivitindriya6);
        buttonHarakteristika6 = findViewById(R.id.button_chetasika_harakteristika6);
        buttonFunkciya6 = findViewById(R.id.button_chetasika_function6);
        buttonProyavlenie6 = findViewById(R.id.button_chetasika_proyavlenie6);
        buttonPrichina6 = findViewById(R.id.button_chetasika_prichina6);

        setWindowFlagsFullscreenAndNoLimits();
    }

    public void onButtonClickGroup1(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaChetasika1.getVisibility();
        textViewAbhidhammaChuvstvo2.setText("");
        textViewAbhidhammaVospriyatie3.setText("");
        textViewAbhidhammaVolenie4.setText("");
        textViewAbhidhammaOdnonapravlennost5.setText("");
        textViewAbhidhammaJivitindriya6.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaChetasika1.setText(""); // Установите текст в пустую строку
        } else {
            if (clickedButton == buttonHarakteristika1) {
                textViewAbhidhammaChetasika1.setText(R.string.text_for_kontakt_harakteristika);
                animateText(textViewAbhidhammaChetasika1, getString(R.string.text_for_kontakt_harakteristika));
            } else if (clickedButton == buttonFunkciya1) {
                textViewAbhidhammaChetasika1.setText(R.string.text_for_kontakt_function);
                animateText(textViewAbhidhammaChetasika1, getString(R.string.text_for_kontakt_function));
            } else if (clickedButton == buttonProyavlenie1) {
                textViewAbhidhammaChetasika1.setText(R.string.text_for_kontakt_proyavlenie);
                animateText(textViewAbhidhammaChetasika1, getString(R.string.text_for_kontakt_proyavlenie));
            } else if (clickedButton == buttonPrichina1) {
                textViewAbhidhammaChetasika1.setText(R.string.text_for_kontakt_prichina);
                animateText(textViewAbhidhammaChetasika1, getString(R.string.text_for_kontakt_prichina));
            } else if (clickedButton == buttonKontakt) {
                textViewAbhidhammaChetasika1.setText(R.string.text_for_kontakt);
                animateText(textViewAbhidhammaChetasika1, getString(R.string.text_for_kontakt));
            }

            textViewAbhidhammaChetasika1.setVisibility(View.VISIBLE);
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickGroup2(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaChuvstvo2.getVisibility();
        textViewAbhidhammaChetasika1.setText("");
        textViewAbhidhammaVospriyatie3.setText("");
        textViewAbhidhammaVolenie4.setText("");
        textViewAbhidhammaOdnonapravlennost5.setText("");
        textViewAbhidhammaJivitindriya6.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaChuvstvo2.setText("");
            // Установите текст в пустую строку
        } else {
            if (clickedButton == buttonHarakteristika2) {
                textViewAbhidhammaChuvstvo2.setText(R.string.text_for_chuvstvo_harakteristika);
                animateText(textViewAbhidhammaChuvstvo2, getString(R.string.text_for_chuvstvo_harakteristika));
            } else if (clickedButton == buttonFunkciya2) {
                textViewAbhidhammaChuvstvo2.setText(R.string.text_for_chuvstvo_function);
                animateText(textViewAbhidhammaChuvstvo2, getString(R.string.text_for_chuvstvo_function));
            } else if (clickedButton == buttonProyavlenie2) {
                textViewAbhidhammaChuvstvo2.setText(R.string.text_for_chuvstvo_proyavlenie);
                animateText(textViewAbhidhammaChuvstvo2, getString(R.string.text_for_chuvstvo_proyavlenie));
            } else if (clickedButton == buttonPrichina2) {
                textViewAbhidhammaChuvstvo2.setText(R.string.text_for_chuvstvo_prichina);
                animateText(textViewAbhidhammaChuvstvo2, getString(R.string.text_for_chuvstvo_prichina));
            } else if (clickedButton == buttonKontakt2) {
                textViewAbhidhammaChuvstvo2.setText(R.string.text_for_chuvstvo);
                animateText(textViewAbhidhammaChuvstvo2, getString(R.string.text_for_chuvstvo));
            }

            textViewAbhidhammaChuvstvo2.setVisibility(View.VISIBLE);
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickGroup3(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaVospriyatie3.getVisibility();
        textViewAbhidhammaChetasika1.setText("");
        textViewAbhidhammaChuvstvo2.setText("");
        textViewAbhidhammaVolenie4.setText("");
        textViewAbhidhammaOdnonapravlennost5.setText("");
        textViewAbhidhammaJivitindriya6.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaVospriyatie3.setText("");
            // Установите текст в пустую строку
        } else {
            if (clickedButton == buttonHarakteristika3) {
                textViewAbhidhammaVospriyatie3.setText(R.string.text_for_vospriyatie_harakteristika);
                animateText(textViewAbhidhammaVospriyatie3, getString(R.string.text_for_vospriyatie_harakteristika));
            } else if (clickedButton == buttonFunkciya3) {
                textViewAbhidhammaVospriyatie3.setText(R.string.text_for_vospriyatie_function);
                animateText(textViewAbhidhammaVospriyatie3, getString(R.string.text_for_vospriyatie_function));
            } else if (clickedButton == buttonProyavlenie3) {
                textViewAbhidhammaVospriyatie3.setText(R.string.text_for_vospriyatie_proyavlenie);
                animateText(textViewAbhidhammaVospriyatie3, getString(R.string.text_for_vospriyatie_proyavlenie));
            } else if (clickedButton == buttonPrichina3) {
                textViewAbhidhammaVospriyatie3.setText(R.string.text_for_vospriyatie_prichina);
                animateText(textViewAbhidhammaVospriyatie3, getString(R.string.text_for_vospriyatie_prichina));
            } else if (clickedButton == buttonVospriyatie3) {
                textViewAbhidhammaVospriyatie3.setText(R.string.text_for_vospriyatie);
                animateText(textViewAbhidhammaVospriyatie3, getString(R.string.text_for_vospriyatie));
            }

            textViewAbhidhammaVospriyatie3.setVisibility(View.VISIBLE);
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickGroup4(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaVolenie4.getVisibility();
        textViewAbhidhammaChetasika1.setText("");
        textViewAbhidhammaChuvstvo2.setText("");
        textViewAbhidhammaVospriyatie3.setText("");
        textViewAbhidhammaOdnonapravlennost5.setText("");
        textViewAbhidhammaJivitindriya6.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaVolenie4.setText("");
            // Установите текст в пустую строку
        } else {
            if (clickedButton == buttonHarakteristika4) {
                textViewAbhidhammaVolenie4.setText(R.string.text_for_volenie_harakteristika);
                animateText(textViewAbhidhammaVolenie4, getString(R.string.text_for_volenie_harakteristika));
            } else if (clickedButton == buttonFunkciya4) {
                textViewAbhidhammaVolenie4.setText(R.string.text_for_vospriyatie_function);
                animateText(textViewAbhidhammaVolenie4, getString(R.string.text_for_volenie_function));
            } else if (clickedButton == buttonProyavlenie4) {
                textViewAbhidhammaVolenie4.setText(R.string.text_for_vospriyatie_proyavlenie);
                animateText(textViewAbhidhammaVolenie4, getString(R.string.text_for_volenie_proyavlenie));
            } else if (clickedButton == buttonPrichina4) {
                textViewAbhidhammaVolenie4.setText(R.string.text_for_volenie_prichina);
                animateText(textViewAbhidhammaVolenie4, getString(R.string.text_for_volenie_prichina));
            } else if (clickedButton == buttonVolenie4) {
                textViewAbhidhammaVolenie4.setText(R.string.text_for_volenie);
                animateText(textViewAbhidhammaVolenie4, getString(R.string.text_for_volenie));
            }

            textViewAbhidhammaVolenie4.setVisibility(View.VISIBLE);
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickGroup5(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaOdnonapravlennost5.getVisibility();
        textViewAbhidhammaChetasika1.setText("");
        textViewAbhidhammaChuvstvo2.setText("");
        textViewAbhidhammaVospriyatie3.setText("");
        textViewAbhidhammaVolenie4.setText("");
        textViewAbhidhammaJivitindriya6.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaOdnonapravlennost5.setText("");
            // Установите текст в пустую строку
        } else {
            if (clickedButton == buttonHarakteristika5) {
                textViewAbhidhammaOdnonapravlennost5.setText(R.string.text_for_odnonapravlennost_harakteristika);
                animateText(textViewAbhidhammaOdnonapravlennost5, getString(R.string.text_for_odnonapravlennost_harakteristika));
            } else if (clickedButton == buttonFunkciya5) {
                textViewAbhidhammaOdnonapravlennost5.setText(R.string.text_for_odnonapravlennost_function);
                animateText(textViewAbhidhammaOdnonapravlennost5, getString(R.string.text_for_odnonapravlennost_function));
            } else if (clickedButton == buttonProyavlenie5) {
                textViewAbhidhammaOdnonapravlennost5.setText(R.string.text_for_odnonapravlennost_proyavlenie);
                animateText(textViewAbhidhammaOdnonapravlennost5, getString(R.string.text_for_odnonapravlennost_proyavlenie));
            } else if (clickedButton == buttonPrichina5) {
                textViewAbhidhammaOdnonapravlennost5.setText(R.string.text_for_odnonapravlennost_prichina);
                animateText(textViewAbhidhammaOdnonapravlennost5, getString(R.string.text_for_odnonapravlennost_prichina));
            } else if (clickedButton == buttonOdnonapravlennost5) {
                textViewAbhidhammaOdnonapravlennost5.setText(R.string.text_for_odnonapravlennost);
                animateText(textViewAbhidhammaOdnonapravlennost5, getString(R.string.text_for_odnonapravlennost));
            }

            textViewAbhidhammaOdnonapravlennost5.setVisibility(View.VISIBLE);
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickGroup6(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaJivitindriya6.getVisibility();
        textViewAbhidhammaChetasika1.setText("");
        textViewAbhidhammaChuvstvo2.setText("");
        textViewAbhidhammaVospriyatie3.setText("");
        textViewAbhidhammaVolenie4.setText("");
        textViewAbhidhammaOdnonapravlennost5.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaJivitindriya6.setText("");
            // Установите текст в пустую строку
        } else {
            if (clickedButton == buttonHarakteristika6) {
                textViewAbhidhammaJivitindriya6.setText(R.string.text_for_jivitindriya_harakteristika);
                animateText(textViewAbhidhammaJivitindriya6, getString(R.string.text_for_jivitindriya_harakteristika));
            } else if (clickedButton == buttonFunkciya6) {
                textViewAbhidhammaJivitindriya6.setText(R.string.text_for_jivitindriya_function);
                animateText(textViewAbhidhammaJivitindriya6, getString(R.string.text_for_jivitindriya_function));
            } else if (clickedButton == buttonProyavlenie6) {
                textViewAbhidhammaJivitindriya6.setText(R.string.text_for_jivitindriya_proyavlenie);
                animateText(textViewAbhidhammaJivitindriya6, getString(R.string.text_for_jivitindriya_proyavlenie));
            } else if (clickedButton == buttonPrichina6) {
                textViewAbhidhammaJivitindriya6.setText(R.string.text_for_jivitindriya_prichina);
                animateText(textViewAbhidhammaJivitindriya6, getString(R.string.text_for_jivitindriya_prichina));
            } else if (clickedButton == buttonJivitindriya6) {
                textViewAbhidhammaJivitindriya6.setText(R.string.text_for_jivitindriya);
                animateText(textViewAbhidhammaJivitindriya6, getString(R.string.text_for_jivitindriya));
            }

            textViewAbhidhammaJivitindriya6.setVisibility(View.VISIBLE);
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }




    private void animateText(TextView targetTextView, String textToAnimate) {
        ValueAnimator animator = ValueAnimator.ofInt(0, textToAnimate.length());
        animator.setDuration(1000); // Продолжительность анимации в миллисекундах
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int) animation.getAnimatedValue();
                String partialText = textToAnimate.substring(0, animatedValue);
                targetTextView.setText(partialText);
            }
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
        Intent intent = new Intent(this, AbhidhammaActivity.class);
        startActivity(intent);
        finish();
    }

    public void toMainAct(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, AbhidhammaActivity.class);
        startActivity(intent);
        finish();
    }
}