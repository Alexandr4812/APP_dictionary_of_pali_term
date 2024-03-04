package com.dhammamobile.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AbhidhammaChittasKamavacharamAhetukaWholsomeResultActivity extends BaseActivityClass {

    private TextView textViewAbhidhammaKammavacharamWholsomeAhetuka1, textViewAbhidhammaKammavacharamWholsomeAhetuka2,
            textViewAbhidhammaKammavacharamWholsomeAhetuka3, textViewAbhidhammaKammavacharamWholsomeAhetuka4,
            textViewAbhidhammaKammavacharamWholsomeAhetuka5, textViewAbhidhammaKammavacharamWholsomeAhetuka6,
            textViewAbhidhammaKammavacharamWholsomeAhetuka7, textViewAbhidhammaKammavacharamWholsomeAhetuka8;

    private Button ahetukaWholsome1, ahetukaWholsome2, ahetukaWholsome3, ahetukaWholsome4,
            ahetukaWholsome5, ahetukaWholsome6, ahetukaWholsome7, ahetukaWholsome8;

    private Button koren1,koren2,koren3,koren4,koren5,koren6,koren7, koren8,
            funkciya1,funkciya2,funkciya3,funkciya4,funkciya5,funkciya6,funkciya7, funkciya8,
            kombinaciya1,kombinaciya2,kombinaciya3,kombinaciya4,kombinaciya5,kombinaciya6,kombinaciya7,kombinaciya8;

    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_kamavacharam_ahetuka_wholsome_result);

        setWindowFlagsFullscreenAndNoLimits();

        textViewAbhidhammaKammavacharamWholsomeAhetuka1 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_wholsome_ahetuka1);
        textViewAbhidhammaKammavacharamWholsomeAhetuka2 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_wholsome_ahetuka2);
        textViewAbhidhammaKammavacharamWholsomeAhetuka3 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_wholsome_ahetuka3);
        textViewAbhidhammaKammavacharamWholsomeAhetuka4 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_wholsome_ahetuka4);
        textViewAbhidhammaKammavacharamWholsomeAhetuka5 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_wholsome_ahetuka5);
        textViewAbhidhammaKammavacharamWholsomeAhetuka6 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_wholsome_ahetuka6);
        textViewAbhidhammaKammavacharamWholsomeAhetuka7 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_wholsome_ahetuka7);
        textViewAbhidhammaKammavacharamWholsomeAhetuka8 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_wholsome_ahetuka8);

        ahetukaWholsome1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka1);
        ahetukaWholsome2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka2);
        ahetukaWholsome3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka3);
        ahetukaWholsome4 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka4);
        ahetukaWholsome5 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka5);
        ahetukaWholsome6 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka6);
        ahetukaWholsome7 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka7);
        ahetukaWholsome8 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka8);

        koren1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_koren1);
        koren2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_koren2);
        koren3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_koren3);
        koren4 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_koren4);
        koren5 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_koren5);
        koren6 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_koren6);
        koren7 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_koren7);
        koren8 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_koren8);

        funkciya1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_funkciya1);
        funkciya2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_funkciya2);
        funkciya3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_funkciya3);
        funkciya4 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_funkciya4);
        funkciya5 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_funkciya5);
        funkciya6 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_funkciya6);
        funkciya7 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_funkciya7);
        funkciya8 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_funkciya8);

        kombinaciya1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_kombinaciya1);
        kombinaciya2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_kombinaciya2);
        kombinaciya3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_kombinaciya3);
        kombinaciya4 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_kombinaciya4);
        kombinaciya5 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_kombinaciya5);
        kombinaciya6 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_kombinaciya6);
        kombinaciya7 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_kombinaciya7);
        kombinaciya8 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_wholsome_ahetuka_kombinaciya8);
    }

    public void onButtonClickAbhidhammaAhetukaWholsomeGroup1(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamWholsomeAhetuka1.getVisibility();
        textViewAbhidhammaKammavacharamWholsomeAhetuka1.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka2.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka3.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka4.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka5.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka6.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka7.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamWholsomeAhetuka1.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamWholsomeAhetuka1.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == ahetukaWholsome1) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka1.setText(R.string.textWholsomeAhetuka1);
                textViewAbhidhammaKammavacharamWholsomeAhetuka1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka1, getString(R.string.textWholsomeAhetuka1));
            } else if (clickedButton == koren1) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka1.setText(R.string.textAhetukaKoren);
                textViewAbhidhammaKammavacharamWholsomeAhetuka1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka1, getString(R.string.textAhetukaKoren));
            } else if (clickedButton == funkciya1) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka1.setText(R.string.textAhetukaWholsomeFunkciya1);
                textViewAbhidhammaKammavacharamWholsomeAhetuka1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka1, getString(R.string.textAhetukaWholsomeFunkciya1));
            } else if (clickedButton == kombinaciya1) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka1.setText(R.string.textAhetukaWholsomeKombinaciya1);
                textViewAbhidhammaKammavacharamWholsomeAhetuka1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka1, getString(R.string.textAhetukaWholsomeKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaAhetukaWholsomeGroup2(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamWholsomeAhetuka2.getVisibility();
        textViewAbhidhammaKammavacharamWholsomeAhetuka1.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka2.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka3.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka4.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka5.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka6.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka7.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamWholsomeAhetuka2.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamWholsomeAhetuka2.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == ahetukaWholsome2) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka2.setText(R.string.textWholsomeAhetuka2);
                textViewAbhidhammaKammavacharamWholsomeAhetuka2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka2, getString(R.string.textWholsomeAhetuka2));
            } else if (clickedButton == koren2) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka2.setText(R.string.textAhetukaKoren);
                textViewAbhidhammaKammavacharamWholsomeAhetuka2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka2, getString(R.string.textAhetukaKoren));
            } else if (clickedButton == funkciya2) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka2.setText(R.string.textAhetukaWholsomeFunkciya2);
                textViewAbhidhammaKammavacharamWholsomeAhetuka2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka2, getString(R.string.textAhetukaWholsomeFunkciya2));
            } else if (clickedButton == kombinaciya2) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka2.setText(R.string.textAhetukaWholsomeKombinaciya2);
                textViewAbhidhammaKammavacharamWholsomeAhetuka2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka2, getString(R.string.textAhetukaWholsomeKombinaciya2));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaAhetukaWholsomeGroup3(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamWholsomeAhetuka3.getVisibility();
        textViewAbhidhammaKammavacharamWholsomeAhetuka1.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka2.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka3.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka4.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka5.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka6.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka7.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamWholsomeAhetuka3.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamWholsomeAhetuka3.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == ahetukaWholsome3) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka3.setText(R.string.textWholsomeAhetuka3);
                textViewAbhidhammaKammavacharamWholsomeAhetuka3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka3, getString(R.string.textWholsomeAhetuka3));
            } else if (clickedButton == koren3) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka3.setText(R.string.textAhetukaKoren);
                textViewAbhidhammaKammavacharamWholsomeAhetuka3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka3, getString(R.string.textAhetukaKoren));
            } else if (clickedButton == funkciya3) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka3.setText(R.string.textAhetukaWholsomeFunkciya3);
                textViewAbhidhammaKammavacharamWholsomeAhetuka3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka3, getString(R.string.textAhetukaWholsomeFunkciya3));
            } else if (clickedButton == kombinaciya3) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka3.setText(R.string.textAhetukaWholsomeKombinaciya3);
                textViewAbhidhammaKammavacharamWholsomeAhetuka3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka3, getString(R.string.textAhetukaWholsomeKombinaciya3));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaAhetukaWholsomeGroup4(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamWholsomeAhetuka4.getVisibility();
        textViewAbhidhammaKammavacharamWholsomeAhetuka1.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka2.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka3.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka4.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka5.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka6.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka7.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamWholsomeAhetuka4.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamWholsomeAhetuka4.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == ahetukaWholsome4) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka4.setText(R.string.textWholsomeAhetuka4);
                textViewAbhidhammaKammavacharamWholsomeAhetuka4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka4, getString(R.string.textWholsomeAhetuka4));
            } else if (clickedButton == koren4) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka4.setText(R.string.textAhetukaKoren);
                textViewAbhidhammaKammavacharamWholsomeAhetuka4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka4, getString(R.string.textAhetukaKoren));
            } else if (clickedButton == funkciya4) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka4.setText(R.string.textAhetukaWholsomeFunkciya4);
                textViewAbhidhammaKammavacharamWholsomeAhetuka4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka4, getString(R.string.textAhetukaWholsomeFunkciya4));
            } else if (clickedButton == kombinaciya4) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka4.setText(R.string.textAhetukaWholsomeKombinaciya4);
                textViewAbhidhammaKammavacharamWholsomeAhetuka4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka4, getString(R.string.textAhetukaWholsomeKombinaciya4));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaAhetukaWholsomeGroup5(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamWholsomeAhetuka5.getVisibility();
        textViewAbhidhammaKammavacharamWholsomeAhetuka1.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka2.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka3.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka4.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka5.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka6.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka7.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamWholsomeAhetuka5.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamWholsomeAhetuka5.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == ahetukaWholsome5) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka5.setText(R.string.textWholsomeAhetuka5);
                textViewAbhidhammaKammavacharamWholsomeAhetuka5.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka5, getString(R.string.textWholsomeAhetuka5));
            } else if (clickedButton == koren5) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka5.setText(R.string.textAhetukaKoren);
                textViewAbhidhammaKammavacharamWholsomeAhetuka5.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka5, getString(R.string.textAhetukaKoren));
            } else if (clickedButton == funkciya5) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka5.setText(R.string.textAhetukaWholsomeFunkciya5);
                textViewAbhidhammaKammavacharamWholsomeAhetuka5.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka5, getString(R.string.textAhetukaWholsomeFunkciya5));
            } else if (clickedButton == kombinaciya5) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka5.setText(R.string.textAhetukaWholsomeKombinaciya5);
                textViewAbhidhammaKammavacharamWholsomeAhetuka5.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka5, getString(R.string.textAhetukaWholsomeKombinaciya5));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaAhetukaWholsomeGroup6(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamWholsomeAhetuka6.getVisibility();
        textViewAbhidhammaKammavacharamWholsomeAhetuka1.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka2.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka3.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka4.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka5.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka6.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka7.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamWholsomeAhetuka6.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamWholsomeAhetuka6.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == ahetukaWholsome6) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka6.setText(R.string.textWholsomeAhetuka6);
                textViewAbhidhammaKammavacharamWholsomeAhetuka6.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka6, getString(R.string.textWholsomeAhetuka6));
            } else if (clickedButton == koren6) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka6.setText(R.string.textAhetukaKoren);
                textViewAbhidhammaKammavacharamWholsomeAhetuka6.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka6, getString(R.string.textAhetukaKoren));
            } else if (clickedButton == funkciya6) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka6.setText(R.string.textAhetukaWholsomeFunkciya6);
                textViewAbhidhammaKammavacharamWholsomeAhetuka6.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka6, getString(R.string.textAhetukaWholsomeFunkciya6));
            } else if (clickedButton == kombinaciya6) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka6.setText(R.string.textAhetukaWholsomeKombinaciya6);
                textViewAbhidhammaKammavacharamWholsomeAhetuka6.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka6, getString(R.string.textAhetukaWholsomeKombinaciya6));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaAhetukaWholsomeGroup7(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamWholsomeAhetuka7.getVisibility();
        textViewAbhidhammaKammavacharamWholsomeAhetuka1.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka2.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka3.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka4.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka5.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka6.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka7.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamWholsomeAhetuka7.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamWholsomeAhetuka7.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == ahetukaWholsome7) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka7.setText(R.string.textWholsomeAhetuka7);
                textViewAbhidhammaKammavacharamWholsomeAhetuka7.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka7, getString(R.string.textWholsomeAhetuka7));
            } else if (clickedButton == koren7) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka7.setText(R.string.textAhetukaKoren);
                textViewAbhidhammaKammavacharamWholsomeAhetuka7.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka7, getString(R.string.textAhetukaKoren));
            } else if (clickedButton == funkciya7) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka7.setText(R.string.textAhetukaWholsomeFunkciya7);
                textViewAbhidhammaKammavacharamWholsomeAhetuka7.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka7, getString(R.string.textAhetukaWholsomeFunkciya7));
            } else if (clickedButton == kombinaciya7) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka7.setText(R.string.textAhetukaWholsomeKombinaciya7);
                textViewAbhidhammaKammavacharamWholsomeAhetuka7.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka7, getString(R.string.textAhetukaWholsomeKombinaciya7));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaAhetukaWholsomeGroup8(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamWholsomeAhetuka8.getVisibility();
        textViewAbhidhammaKammavacharamWholsomeAhetuka1.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka2.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka3.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka4.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka5.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka6.setText("");
        textViewAbhidhammaKammavacharamWholsomeAhetuka7.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamWholsomeAhetuka8.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamWholsomeAhetuka8.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == ahetukaWholsome8) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka8.setText(R.string.textWholsomeAhetuka8);
                textViewAbhidhammaKammavacharamWholsomeAhetuka8.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka8, getString(R.string.textWholsomeAhetuka8));
            } else if (clickedButton == koren8) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka8.setText(R.string.textAhetukaKoren);
                textViewAbhidhammaKammavacharamWholsomeAhetuka8.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka8, getString(R.string.textAhetukaKoren));
            } else if (clickedButton == funkciya8) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka8.setText(R.string.textAhetukaWholsomeFunkciya8);
                textViewAbhidhammaKammavacharamWholsomeAhetuka8.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka8, getString(R.string.textAhetukaWholsomeFunkciya8));
            } else if (clickedButton == kombinaciya8) {
                textViewAbhidhammaKammavacharamWholsomeAhetuka8.setText(R.string.textAhetukaWholsomeKombinaciya8);
                textViewAbhidhammaKammavacharamWholsomeAhetuka8.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamWholsomeAhetuka8, getString(R.string.textAhetukaWholsomeKombinaciya8));
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

    public void toAbhidhammaChittasKamavacharamAhetuka(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamAhetukaActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamAhetukaActivity.class);
    }
}