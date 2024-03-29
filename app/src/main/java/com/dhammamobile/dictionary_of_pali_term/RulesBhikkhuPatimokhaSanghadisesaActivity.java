package com.dhammamobile.dictionary_of_pali_term;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;


public class RulesBhikkhuPatimokhaSanghadisesaActivity extends BaseActivityClass {

    private TextView textView;
    private String textToAnimate;

    private Button buttonHome;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_bhikkhu_patimokha_sanghadisesa);

        setWindowFlagsFullscreenAndNoLimits();

        this.buttonBack = findViewById(R.id.buttonliveToSanghadisesa);
        this.buttonHome = findViewById(R.id.buttonSanghadisesaHome);

        textView = findViewById(R.id.textViewHintSangkhadisesa);
        textToAnimate = getString(R.string.textViewHintParajika);

        animateText();
    }

    private void animateText() {
        ValueAnimator animator = ValueAnimator.ofInt(0, textToAnimate.length());
        animator.setDuration(2000); // Продолжительность анимации в миллисекундах
        animator.addUpdateListener(animation -> {
            int animatedValue = (int) animation.getAnimatedValue();
            String partialText = textToAnimate.substring(0, animatedValue);
            textView.setText(partialText);
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

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(RulesBhikkhuActivity.class);
    }

    public void toRulesPatimokhaAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaActivity.class);
    }

    public void toSanghadisesaAbout(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSanghadisesaAbout);
        scrollText.setVisibility(View.VISIBLE);
        buttonBack.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
    }

    public void toSanghadisesaText1(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSanghadisesaText1);
        scrollText.setVisibility(View.VISIBLE);
        buttonBack.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
    }

    public void toSanghadisesaText2(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSanghadisesaText2);
        scrollText.setVisibility(View.VISIBLE);
        buttonBack.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
    }

    public void toSanghadisesaText3(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSanghadisesaText3);
        scrollText.setVisibility(View.VISIBLE);
        buttonBack.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
    }

    public void toSanghadisesaText4(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSanghadisesaText4);
        scrollText.setVisibility(View.VISIBLE);
        buttonBack.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
    }

    public void toSanghadisesaText5(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSanghadisesaText5);
        scrollText.setVisibility(View.VISIBLE);
        buttonBack.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
    }

    public void toBackButtonSanghadisesa(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSanghadisesaAbout);
        ScrollView scrollText1 = findViewById(R.id.viewScrollSanghadisesaText1);
        ScrollView scrollText2 = findViewById(R.id.viewScrollSanghadisesaText2);
        ScrollView scrollText3 = findViewById(R.id.viewScrollSanghadisesaText3);
        ScrollView scrollText4 = findViewById(R.id.viewScrollSanghadisesaText4);
        ScrollView scrollText5 = findViewById(R.id.viewScrollSanghadisesaText5);
        scrollText.setVisibility(View.INVISIBLE);
        scrollText1.setVisibility(View.INVISIBLE);
        scrollText2.setVisibility(View.INVISIBLE);
        scrollText3.setVisibility(View.INVISIBLE);
        scrollText4.setVisibility(View.INVISIBLE);
        scrollText5.setVisibility(View.INVISIBLE);
        buttonBack.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
    }
}