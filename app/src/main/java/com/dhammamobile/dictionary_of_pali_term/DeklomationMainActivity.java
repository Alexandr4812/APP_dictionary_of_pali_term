package com.dhammamobile.dictionary_of_pali_term;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;


public class DeklomationMainActivity extends BaseActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deklomation_main);

       // setWindowFlagsFullscreenAndNoLimits();

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
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toMorningPuja(View view){
        startIntentActivityAndFinish(DeclomationPujaActivity.class);
    }

    public void toDeclomationSutta(View view){
        startIntentActivityAndFinish(DeclomationSuttaActivity.class);
    }

    public void toDeclomationOver(View view){
        startIntentActivityAndFinish(DeclomationOverActivity.class);
    }

    public void toDeclomationParitta(View view){
        startIntentActivityAndFinish(DeclomationParittaActivity.class);
    }

    public void toDeclomationDhammapada(View view){
        startIntentActivityAndFinish(DeklomationDhammapadaActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(MainActivity.class);
    }



}