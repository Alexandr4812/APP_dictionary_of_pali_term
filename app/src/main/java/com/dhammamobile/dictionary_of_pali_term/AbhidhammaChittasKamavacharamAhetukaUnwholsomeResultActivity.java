package com.dhammamobile.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

public class AbhidhammaChittasKamavacharamAhetukaUnwholsomeResultActivity extends BaseActivityClass {

    private TextView textViewAbhidhammaKammavacharamUnwholsomeAhetuka1, textViewAbhidhammaKammavacharamUnwholsomeAhetuka2,
            textViewAbhidhammaKammavacharamUnwholsomeAhetuka3, textViewAbhidhammaKammavacharamUnwholsomeAhetuka4,
            textViewAbhidhammaKammavacharamUnwholsomeAhetuka5, textViewAbhidhammaKammavacharamUnwholsomeAhetuka6,
            textViewAbhidhammaKammavacharamUnwholsomeAhetuka7;


    private Button ahetukaUnwholsome1, ahetukaUnwholsome2, ahetukaUnwholsome3, ahetukaUnwholsome4,
            ahetukaUnwholsome5, ahetukaUnwholsome6, ahetukaUnwholsome7;

    private Button koren1,koren2,koren3,koren4,koren5,koren6,koren7,
            funkciya1,funkciya2,funkciya3,funkciya4,funkciya5,funkciya6,funkciya7,
            kombinaciya1,kombinaciya2,kombinaciya3,kombinaciya4,kombinaciya5,kombinaciya6,kombinaciya7;

    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_kamavacharam_ahetuka_unwholsome_result);

        setWindowFlagsFullscreenAndNoLimits();

        textViewAbhidhammaKammavacharamUnwholsomeAhetuka1 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_unwholsome_ahetuka1);
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka2 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_unwholsome_ahetuka2);
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka3 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_unwholsome_ahetuka3);
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka4 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_unwholsome_ahetuka4);
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka5 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_unwholsome_ahetuka5);
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka6 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_unwholsome_ahetuka6);
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka7 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_unwholsome_ahetuka7);

        ahetukaUnwholsome1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka1);
        ahetukaUnwholsome2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka2);
        ahetukaUnwholsome3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka3);
        ahetukaUnwholsome4 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka4);
        ahetukaUnwholsome5 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka5);
        ahetukaUnwholsome6 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka6);
        ahetukaUnwholsome7 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka7);

        koren1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka_koren1);
        koren2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka_koren2);
        koren3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka_koren3);
        koren4 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka_koren4);
        koren5 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka_koren5);
        koren6 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka_koren6);
        koren7 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka_koren7);

        funkciya1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka_funkciya1);
        funkciya2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka_funkciya2);
        funkciya3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka_funkciya3);
        funkciya4 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka_funkciya4);
        funkciya5 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka_funkciya5);
        funkciya6 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka_funkciya6);
        funkciya7 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka_funkciya7);

        kombinaciya1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka_kombinaciya1);
        kombinaciya2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka_kombinaciya2);
        kombinaciya3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka_kombinaciya3);
        kombinaciya4 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka_kombinaciya4);
        kombinaciya5 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka_kombinaciya5);
        kombinaciya6 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka_kombinaciya6);
        kombinaciya7 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_unwholsome_ahetuka_kombinaciya7);
    }

    public void onButtonClickAbhidhammaAhetukaUnwholsomeGroup1(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeAhetuka1.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka1.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka2.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka3.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka4.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka5.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka6.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka7.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeAhetuka1.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeAhetuka1.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == ahetukaUnwholsome1) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka1.setText(R.string.textUnwholsomeAhetuka1);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka1, getString(R.string.textUnwholsomeAhetuka1));
            } else if (clickedButton == koren1) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka1.setText(R.string.textAhetukaKoren);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka1, getString(R.string.textAhetukaKoren));
            } else if (clickedButton == funkciya1) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka1.setText(R.string.textAhetukaUnwholsomeFunkciya1);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka1, getString(R.string.textAhetukaUnwholsomeFunkciya1));
            } else if (clickedButton == kombinaciya1) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka1.setText(R.string.textAhetukaUnwholsomeKombinaciya1);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka1, getString(R.string.textAhetukaUnwholsomeKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaAhetukaUnwholsomeGroup2(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeAhetuka2.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka1.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka2.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka3.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka4.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka5.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka6.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka7.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeAhetuka2.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeAhetuka2.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == ahetukaUnwholsome2) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka2.setText(R.string.textUnwholsomeAhetuka2);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka2, getString(R.string.textUnwholsomeAhetuka2));
            } else if (clickedButton == koren2) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka2.setText(R.string.textAhetukaKoren);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka2, getString(R.string.textAhetukaKoren));
            } else if (clickedButton == funkciya2) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka2.setText(R.string.textAhetukaUnwholsomeFunkciya2);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka2, getString(R.string.textAhetukaUnwholsomeFunkciya2));
            } else if (clickedButton == kombinaciya2) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka2.setText(R.string.textAhetukaUnwholsomeKombinaciya2);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka2, getString(R.string.textAhetukaUnwholsomeKombinaciya2));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaAhetukaUnwholsomeGroup3(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeAhetuka3.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka1.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka2.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka3.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka4.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka5.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka6.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka7.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeAhetuka3.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeAhetuka3.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == ahetukaUnwholsome3) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka3.setText(R.string.textUnwholsomeAhetuka3);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka3, getString(R.string.textUnwholsomeAhetuka3));
            } else if (clickedButton == koren3) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka3.setText(R.string.textAhetukaKoren);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka3, getString(R.string.textAhetukaKoren));
            } else if (clickedButton == funkciya3) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka3.setText(R.string.textAhetukaUnwholsomeFunkciya3);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka3, getString(R.string.textAhetukaUnwholsomeFunkciya3));
            } else if (clickedButton == kombinaciya3) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka3.setText(R.string.textAhetukaUnwholsomeKombinaciya3);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka3, getString(R.string.textAhetukaUnwholsomeKombinaciya3));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaAhetukaUnwholsomeGroup4(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeAhetuka4.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka1.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka2.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka3.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka4.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka5.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka6.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka7.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeAhetuka4.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeAhetuka4.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == ahetukaUnwholsome4) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka4.setText(R.string.textUnwholsomeAhetuka4);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka4, getString(R.string.textUnwholsomeAhetuka4));
            } else if (clickedButton == koren4) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka4.setText(R.string.textAhetukaKoren);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka4, getString(R.string.textAhetukaKoren));
            } else if (clickedButton == funkciya4) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka4.setText(R.string.textAhetukaUnwholsomeFunkciya4);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka4, getString(R.string.textAhetukaUnwholsomeFunkciya4));
            } else if (clickedButton == kombinaciya4) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka4.setText(R.string.textAhetukaUnwholsomeKombinaciya4);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka4, getString(R.string.textAhetukaUnwholsomeKombinaciya4));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaAhetukaUnwholsomeGroup5(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeAhetuka5.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka1.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka2.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka3.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka4.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka5.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka6.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka7.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeAhetuka5.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeAhetuka5.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == ahetukaUnwholsome5) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka5.setText(R.string.textUnwholsomeAhetuka5);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka5.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka5, getString(R.string.textUnwholsomeAhetuka5));
            } else if (clickedButton == koren5) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka5.setText(R.string.textAhetukaKoren);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka5.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka5, getString(R.string.textAhetukaKoren));
            } else if (clickedButton == funkciya5) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka5.setText(R.string.textAhetukaUnwholsomeFunkciya5);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka5.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka5, getString(R.string.textAhetukaUnwholsomeFunkciya5));
            } else if (clickedButton == kombinaciya5) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka5.setText(R.string.textAhetukaUnwholsomeKombinaciya5);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka5.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka5, getString(R.string.textAhetukaUnwholsomeKombinaciya5));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaAhetukaUnwholsomeGroup6(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeAhetuka6.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka1.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka2.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka3.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka4.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka5.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka6.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka7.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeAhetuka6.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeAhetuka6.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == ahetukaUnwholsome6) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka6.setText(R.string.textUnwholsomeAhetuka6);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka6.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka6, getString(R.string.textUnwholsomeAhetuka6));
            } else if (clickedButton == koren6) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka6.setText(R.string.textAhetukaKoren);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka6.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka6, getString(R.string.textAhetukaKoren));
            } else if (clickedButton == funkciya6) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka6.setText(R.string.textAhetukaUnwholsomeFunkciya6);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka6.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka6, getString(R.string.textAhetukaUnwholsomeFunkciya6));
            } else if (clickedButton == kombinaciya6) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka6.setText(R.string.textAhetukaUnwholsomeKombinaciya6);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka6.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka6, getString(R.string.textAhetukaUnwholsomeKombinaciya6));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaAhetukaUnwholsomeGroup7(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaKammavacharamUnwholsomeAhetuka7.getVisibility();
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka1.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka2.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka3.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka4.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka5.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka6.setText("");
        textViewAbhidhammaKammavacharamUnwholsomeAhetuka7.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaKammavacharamUnwholsomeAhetuka7.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaKammavacharamUnwholsomeAhetuka7.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == ahetukaUnwholsome7) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka7.setText(R.string.textUnwholsomeAhetuka6);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka7.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka7, getString(R.string.textUnwholsomeAhetuka7));
            } else if (clickedButton == koren7) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka7.setText(R.string.textAhetukaKoren);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka7.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka7, getString(R.string.textAhetukaKoren));
            } else if (clickedButton == funkciya7) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka7.setText(R.string.textAhetukaUnwholsomeFunkciya7);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka7.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka7, getString(R.string.textAhetukaUnwholsomeFunkciya7));
            } else if (clickedButton == kombinaciya7) {
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka7.setText(R.string.textAhetukaUnwholsomeKombinaciya7);
                textViewAbhidhammaKammavacharamUnwholsomeAhetuka7.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaKammavacharamUnwholsomeAhetuka7, getString(R.string.textAhetukaUnwholsomeKombinaciya7));
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