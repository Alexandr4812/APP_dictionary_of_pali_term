package com.dhammamobile.dictionary_of_pali_term.Suttas;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

public class SuttasActivity extends BaseActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suttas);

        TextView textViewLink = findViewById(R.id.textViewyy);
        Linkify.addLinks(textViewLink, Linkify.WEB_URLS);

       // setWindowFlagsFullscreenAndNoLimits();

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        Button button1 = findViewById(R.id.button_suttas_for_dighanikaya);
        Button button2 = findViewById(R.id.button_suttas_for_majhimaNikaya);
        Button button3 = findViewById(R.id.button_suttas_for_sanyuttaNikaya);
        Button button4 = findViewById(R.id.button_suttas_for_anguttaraNikaya);
        Button button5 = findViewById(R.id.button_suttas_for_kuddakaNikaya);
        Button button6 = findViewById(R.id.button_suttas_for_by_category);
        Button button7 = findViewById(R.id.button_suttas_for_last_sutta);
        Button button8 = findViewById(R.id.button_suttas_random_sutta);
        ImageView im1 = findViewById(R.id.im1);
        ImageView im2 = findViewById(R.id.im2);

        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        Animation slideFromLeftAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_left);
        Animation slideFromRightAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_right);

        button1.startAnimation(slideFromLeftAnimation);
        button2.startAnimation(slideFromRightAnimation);
        button3.startAnimation(slideFromLeftAnimation);
        button4.startAnimation(slideFromRightAnimation);
        button5.startAnimation(slideFromLeftAnimation);
        button6.startAnimation(slideFromRightAnimation);
        button8.startAnimation(slideFromLeftAnimation);
        button7.startAnimation(slideFromRightAnimation);
        im1.startAnimation(slideDown);
        im2.startAnimation(slideFromLeftAnimation);
        animateText(textViewLink, getString(R.string.theravada_ru));
    }

    private void animateText(TextView targetTextView, String textToAnimate) {
        ValueAnimator animator = ValueAnimator.ofInt(0, textToAnimate.length());
        animator.setDuration(2000); // Продолжительность анимации в миллисекундах
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

    // Метод для открытия веб-сайта
    public void openWebsite(View view) {
        String url = "https://www.theravada.ru";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toSuttasDighaAct(View view){
        startIntentActivityAndFinish(SuttasDighaActivity.class);
    }

    public void toSuttasMajjhimaAct(View view){
        startIntentActivityAndFinish(SuttasMajjhimaActivity.class);
    }

    public void toSuttasSanyuttaAct(View view){
        startIntentActivityAndFinish(SuttasSanyuttaActivity.class);
    }

    public void toSuttasAnguttaraAct(View view){
        startIntentActivityAndFinish(SuttasAnguttaraActivity.class);
    }

    public void toSuttasKuddakaAct(View view){
        startIntentActivityAndFinish(SuttasKuddakaActivity.class);
    }

    public void toSuttasByCategory(View view){
        startIntentActivityAndFinish(SuttasByCategoryActivity.class);
    }

    public void toSuttasLastSutta(View view){
        startIntentActivityAndFinish(SuttasLastSuttaActivity.class);
    }

    public void toSuttasRandomSutta(View view){
        startIntentActivityAndFinish(SuttasRandomActivity.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(MainActivity.class);
    }
}