package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class DeklomationMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deklomation_main);

        // Убрать строку состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Убрать панель навигации (если нужно)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        Button button1 = findViewById(R.id.button_sutta);
        Button button2 = findViewById(R.id.button_paritta);
        Button button3 = findViewById(R.id.button_dhammapada);
        Button button4 = findViewById(R.id.button_puja);
        Button button5 = findViewById(R.id.button_over_declamation);
        ImageView im1 =findViewById(R.id.imageViewRazdelitelDeklomationMain);

        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        Animation slideFromLeftAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_left);
        Animation slideFromRightAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_right);

        button1.startAnimation(slideFromLeftAnimation);
        button2.startAnimation(slideFromRightAnimation);
        button3.startAnimation(slideFromLeftAnimation);
        button4.startAnimation(slideFromRightAnimation);
        button5.startAnimation(slideFromLeftAnimation);
        im1.startAnimation(slideDown);
    }

    public void toMainAct(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void toMorningPuja(View view){
        Intent intent = new Intent(this, DeclomationPujaActivity.class);
        startActivity(intent);
        finish();
    }

    public void toDeclomationSutta(View view){
        Intent intent = new Intent(this, DeclomationSuttaActivity.class);
        startActivity(intent);
        finish();
    }

    public void toDeclomationOver(View view){
        Intent intent = new Intent(this, DeclomationOverActivity.class);
        startActivity(intent);
        finish();
    }

    public void toDeclomationParitta(View view){
        Intent intent = new Intent(this, DeclomationParittaActivity.class);
        startActivity(intent);
        finish();
    }

    public void toDeclomationDhammapada(View view){
        Intent intent = new Intent(this, DeklomationDhammapadaActivity.class);
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