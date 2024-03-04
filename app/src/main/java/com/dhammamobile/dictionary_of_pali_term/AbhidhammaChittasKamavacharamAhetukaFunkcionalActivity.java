 package com.dhammamobile.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.TextView;

 public class AbhidhammaChittasKamavacharamAhetukaFunkcionalActivity extends BaseActivityClass {

     private TextView textViewAbhidhammaKammavacharamAhetukaFunkcional1, textViewAbhidhammaKammavacharamAhetukaFunkcional2,
             textViewAbhidhammaKammavacharamAhetukaFunkcional3;

     private Button ahetukaFunkcional1, ahetukaFunkcional2, ahetukaFunkcional3;

     private Button koren1,koren2,koren3,
             funkciya1,funkciya2,funkciya3,
             kombinaciya1,kombinaciya2,kombinaciya3;

     private Button lastClickedButton = null;

     private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_kamavacharam_ahetuka_funkcional);

        setWindowFlagsFullscreenAndNoLimits();

        textViewAbhidhammaKammavacharamAhetukaFunkcional1 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_ahetuka_funkcional1);
        textViewAbhidhammaKammavacharamAhetukaFunkcional2 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_ahetuka_funkcional2);
        textViewAbhidhammaKammavacharamAhetukaFunkcional3 =
                findViewById(R.id.textView_abhidhamma_chittas_kamavachara_ahetuka_funkcional3);

        ahetukaFunkcional1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_ahetuka_funkcional1);
        ahetukaFunkcional2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_ahetuka_funkcional2);
        ahetukaFunkcional3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_ahetuka_funkcional3);

        koren1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_ahetuka_funkcional_koren1);
        koren2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_ahetuka_funkcional_koren2);
        koren3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_ahetuka_funkcional_koren3);

        funkciya1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_ahetuka_funkcional_funkciya1);
        funkciya2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_ahetuka_funkcional_funkciya2);
        funkciya3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_ahetuka_funkcional_funkciya3);

        kombinaciya1 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_ahetuka_funkcional_kombinaciya1);
        kombinaciya2 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_ahetuka_funkcional_kombinaciya2);
        kombinaciya3 = findViewById(R.id.button_abhidhamma_chittas_kamavachara_ahetuka_funkcional_kombinaciya3);
    }

     public void onButtonClickAbhidhammaAhetukaFunkcionalGroup1(View view) {
         Button clickedButton = (Button) view;
         int visibility = textViewAbhidhammaKammavacharamAhetukaFunkcional1.getVisibility();
         textViewAbhidhammaKammavacharamAhetukaFunkcional1.setText("");
         textViewAbhidhammaKammavacharamAhetukaFunkcional2.setText("");
         textViewAbhidhammaKammavacharamAhetukaFunkcional3.setText("");

         // Если нажата та же кнопка, что и ранее
         if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
             textViewAbhidhammaKammavacharamAhetukaFunkcional1.setText(""); // Установите текст в пустую строку
             textViewAbhidhammaKammavacharamAhetukaFunkcional1.setVisibility(View.INVISIBLE);
             resetAnimator();
         } else {
             if (clickedButton == ahetukaFunkcional1) {
                 textViewAbhidhammaKammavacharamAhetukaFunkcional1.setText(R.string.textAhetukaFunkcional1);
                 textViewAbhidhammaKammavacharamAhetukaFunkcional1.setVisibility(View.VISIBLE);
                 animateText(textViewAbhidhammaKammavacharamAhetukaFunkcional1, getString(R.string.textAhetukaFunkcional1));
             } else if (clickedButton == koren1) {
                 textViewAbhidhammaKammavacharamAhetukaFunkcional1.setText(R.string.textAhetukaKoren);
                 textViewAbhidhammaKammavacharamAhetukaFunkcional1.setVisibility(View.VISIBLE);
                 animateText(textViewAbhidhammaKammavacharamAhetukaFunkcional1, getString(R.string.textAhetukaKoren));
             } else if (clickedButton == funkciya1) {
                 textViewAbhidhammaKammavacharamAhetukaFunkcional1.setText(R.string.textAhetukaFunkcionalFunkciya1);
                 textViewAbhidhammaKammavacharamAhetukaFunkcional1.setVisibility(View.VISIBLE);
                 animateText(textViewAbhidhammaKammavacharamAhetukaFunkcional1, getString(R.string.textAhetukaFunkcionalFunkciya1));
             } else if (clickedButton == kombinaciya1) {
                 textViewAbhidhammaKammavacharamAhetukaFunkcional1.setText(R.string.textAhetukaFunkcionalKombinaciya1);
                 textViewAbhidhammaKammavacharamAhetukaFunkcional1.setVisibility(View.VISIBLE);
                 animateText(textViewAbhidhammaKammavacharamAhetukaFunkcional1, getString(R.string.textAhetukaFunkcionalKombinaciya1));
             }
             lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
         }
     }

     public void onButtonClickAbhidhammaAhetukaFunkcionalGroup2(View view) {
         Button clickedButton = (Button) view;
         int visibility = textViewAbhidhammaKammavacharamAhetukaFunkcional2.getVisibility();
         textViewAbhidhammaKammavacharamAhetukaFunkcional1.setText("");
         textViewAbhidhammaKammavacharamAhetukaFunkcional2.setText("");
         textViewAbhidhammaKammavacharamAhetukaFunkcional3.setText("");

         // Если нажата та же кнопка, что и ранее
         if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
             textViewAbhidhammaKammavacharamAhetukaFunkcional2.setText(""); // Установите текст в пустую строку
             textViewAbhidhammaKammavacharamAhetukaFunkcional2.setVisibility(View.INVISIBLE);
             resetAnimator();
         } else {
             if (clickedButton == ahetukaFunkcional2) {
                 textViewAbhidhammaKammavacharamAhetukaFunkcional2.setText(R.string.textAhetukaFunkcional2);
                 textViewAbhidhammaKammavacharamAhetukaFunkcional2.setVisibility(View.VISIBLE);
                 animateText(textViewAbhidhammaKammavacharamAhetukaFunkcional2, getString(R.string.textAhetukaFunkcional2));
             } else if (clickedButton == koren2) {
                 textViewAbhidhammaKammavacharamAhetukaFunkcional2.setText(R.string.textAhetukaKoren);
                 textViewAbhidhammaKammavacharamAhetukaFunkcional2.setVisibility(View.VISIBLE);
                 animateText(textViewAbhidhammaKammavacharamAhetukaFunkcional2, getString(R.string.textAhetukaKoren));
             } else if (clickedButton == funkciya2) {
                 textViewAbhidhammaKammavacharamAhetukaFunkcional2.setText(R.string.textAhetukaFunkcionalFunkciya2);
                 textViewAbhidhammaKammavacharamAhetukaFunkcional2.setVisibility(View.VISIBLE);
                 animateText(textViewAbhidhammaKammavacharamAhetukaFunkcional2, getString(R.string.textAhetukaFunkcionalFunkciya2));
             } else if (clickedButton == kombinaciya2) {
                 textViewAbhidhammaKammavacharamAhetukaFunkcional2.setText(R.string.textAhetukaFunkcionalKombinaciya2);
                 textViewAbhidhammaKammavacharamAhetukaFunkcional2.setVisibility(View.VISIBLE);
                 animateText(textViewAbhidhammaKammavacharamAhetukaFunkcional2, getString(R.string.textAhetukaFunkcionalKombinaciya2));
             }
             lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
         }
     }

     public void onButtonClickAbhidhammaAhetukaFunkcionalGroup3(View view) {
         Button clickedButton = (Button) view;
         int visibility = textViewAbhidhammaKammavacharamAhetukaFunkcional3.getVisibility();
         textViewAbhidhammaKammavacharamAhetukaFunkcional1.setText("");
         textViewAbhidhammaKammavacharamAhetukaFunkcional2.setText("");
         textViewAbhidhammaKammavacharamAhetukaFunkcional3.setText("");

         // Если нажата та же кнопка, что и ранее
         if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
             textViewAbhidhammaKammavacharamAhetukaFunkcional3.setText(""); // Установите текст в пустую строку
             textViewAbhidhammaKammavacharamAhetukaFunkcional3.setVisibility(View.INVISIBLE);
             resetAnimator();
         } else {
             if (clickedButton == ahetukaFunkcional3) {
                 textViewAbhidhammaKammavacharamAhetukaFunkcional3.setText(R.string.textAhetukaFunkcional3);
                 textViewAbhidhammaKammavacharamAhetukaFunkcional3.setVisibility(View.VISIBLE);
                 animateText(textViewAbhidhammaKammavacharamAhetukaFunkcional3, getString(R.string.textAhetukaFunkcional3));
             } else if (clickedButton == koren3) {
                 textViewAbhidhammaKammavacharamAhetukaFunkcional3.setText(R.string.textAhetukaKoren);
                 textViewAbhidhammaKammavacharamAhetukaFunkcional3.setVisibility(View.VISIBLE);
                 animateText(textViewAbhidhammaKammavacharamAhetukaFunkcional3, getString(R.string.textAhetukaKoren));
             } else if (clickedButton == funkciya3) {
                 textViewAbhidhammaKammavacharamAhetukaFunkcional3.setText(R.string.textAhetukaFunkcionalFunkciya3);
                 textViewAbhidhammaKammavacharamAhetukaFunkcional3.setVisibility(View.VISIBLE);
                 animateText(textViewAbhidhammaKammavacharamAhetukaFunkcional3, getString(R.string.textAhetukaFunkcionalFunkciya3));
             } else if (clickedButton == kombinaciya3) {
                 textViewAbhidhammaKammavacharamAhetukaFunkcional3.setText(R.string.textAhetukaFunkcionalKombinaciya3);
                 textViewAbhidhammaKammavacharamAhetukaFunkcional3.setVisibility(View.VISIBLE);
                 animateText(textViewAbhidhammaKammavacharamAhetukaFunkcional3, getString(R.string.textAhetukaFunkcionalKombinaciya3));
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