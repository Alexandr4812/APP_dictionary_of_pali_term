package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;
import androidx.cardview.widget.CardView;

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
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.TextView;

public class SuttasActivity extends AppCompatActivity {

    private TextView textView1;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suttas);

        TextView textViewLink = findViewById(R.id.textViewyy);
        Linkify.addLinks(textViewLink, Linkify.WEB_URLS);


        // Убрать строку состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Убрать панель навигации (если нужно)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        Button button1 = findViewById(R.id.button_suttas_for_dighanikaya);
        Button button2 = findViewById(R.id.button_suttas_for_majhimaNikaya);
        Button button3 = findViewById(R.id.button_suttas_for_sanyuttaNikaya);
        Button button4 = findViewById(R.id.button_suttas_for_anguttaraNikaya);
        Button button5 = findViewById(R.id.button_suttas_for_kuddakaNikaya);
        Button button6 = findViewById(R.id.button_suttas_for_by_category);
        ImageView im1 = findViewById(R.id.im1);
        ImageView im2 = findViewById(R.id.im2);
        textView1 = findViewById(R.id.textViewyy);


        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        Animation slideFromLeftAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_left);
        Animation slideFromRightAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_right);

        button1.startAnimation(slideFromLeftAnimation);
        button2.startAnimation(slideFromRightAnimation);
        button3.startAnimation(slideFromLeftAnimation);
        button4.startAnimation(slideFromRightAnimation);
        button5.startAnimation(slideFromLeftAnimation);
        button6.startAnimation(slideFromRightAnimation);
        im1.startAnimation(slideDown);
        im2.startAnimation(slideFromLeftAnimation);
        animateText(textView1, getString(R.string.theravada_ru));
    }

    private void animateText(TextView targetTextView, String textToAnimate) {
        ValueAnimator animator = ValueAnimator.ofInt(0, textToAnimate.length());
        animator.setDuration(2000); // Продолжительность анимации в миллисекундах
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

    // Метод для открытия веб-сайта
    public void openWebsite(View view) {
        String url = "https://www.theravada.ru";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
    }

    public void toMainAct(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void toSuttasDighaAct(View view){
        Intent intent = new Intent(this, SuttasDighaActivity.class);
        startActivity(intent);
        finish();
    }

    public void toSuttasMajjhimaAct(View view){
        Intent intent = new Intent(this, SuttasMajjhimaActivity.class);
        startActivity(intent);
        finish();
    }

    public void toSuttasSanyuttaAct(View view){
        Intent intent = new Intent(this, SuttasSanyuttaActivity.class);
        startActivity(intent);
        finish();
    }

    public void toSuttasAnguttaraAct(View view){
        Intent intent = new Intent(this, SuttasAnguttaraActivity.class);
        startActivity(intent);
        finish();
    }

    public void toSuttasKuddakaAct(View view){
        Intent intent = new Intent(this, SuttasKuddakaActivity.class);
        startActivity(intent);
        finish();
    }

    public void toSuttasByCategory(View view){
        Intent intent = new Intent(this, SuttasByCategoryActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}