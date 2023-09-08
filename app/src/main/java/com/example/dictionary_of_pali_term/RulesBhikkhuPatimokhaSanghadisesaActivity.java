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
import android.widget.ScrollView;
import android.widget.TextView;

public class RulesBhikkhuPatimokhaSanghadisesaActivity extends AppCompatActivity {

    private TextView textView;
    private String textToAnimate;
    private int currentIndex = 0;

    private Button buttonHome;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_bhikkhu_patimokha_sanghadisesa);

        // Убрать строку состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Убрать панель навигации (если нужно)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        this.buttonBack = (Button) findViewById(R.id.buttonliveToSanghadisesa);
        this.buttonHome = (Button) findViewById(R.id.buttonSanghadisesaHome);

        textView = findViewById(R.id.textViewHintSangkhadisesa);
        textToAnimate = getString(R.string.textViewHintParajika);

        animateText();
    }

    private void animateText() {
        ValueAnimator animator = ValueAnimator.ofInt(0, textToAnimate.length());
        animator.setDuration(2000); // Продолжительность анимации в миллисекундах
        animator.addUpdateListener(new ValueAnimator.AnimatorUpdateListener() {
            @Override
            public void onAnimationUpdate(ValueAnimator animation) {
                int animatedValue = (int) animation.getAnimatedValue();
                String partialText = textToAnimate.substring(0, animatedValue);
                textView.setText(partialText);
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

    public void toMainAct(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, RulesBhikkhuActivity.class);
        startActivity(intent);
        finish();
    }

    public void toRulesPatimokhaAct(View view){
        Intent intent = new Intent(this, RulesBhikkhuPatimokhaActivity.class);
        startActivity(intent);
        finish();
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

    public void toBackButtonSanghadisesa(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSanghadisesaAbout);
        ScrollView scrollText1 = findViewById(R.id.viewScrollSanghadisesaText1);
        scrollText.setVisibility(View.INVISIBLE);
        scrollText1.setVisibility(View.INVISIBLE);
        buttonBack.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
    }
}