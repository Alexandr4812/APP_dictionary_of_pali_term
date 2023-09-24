package com.example.dictionary_of_pali_term;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class AbhidhammaActivity extends BaseActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma);

        setWindowFlagsFullscreenAndNoLimits();

        Button button1 = findViewById(R.id.button_mentalnie_faktori);
        Button button2 = findViewById(R.id.button_chittas);
        ImageView im1 = findViewById(R.id.imageVievAbhidhamma1);

        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        Animation slideFromLeftAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_left);
        Animation slideFromRightAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_right);

        button1.startAnimation(slideFromLeftAnimation);
        button2.startAnimation(slideFromRightAnimation);
        im1.startAnimation(slideDown);
    }

    public void toChetasikasAct(View view){
        startIntentActivityAndFinish(AbhidhammaChetasikasActivity.class);
    }

    public void toChittasAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(MainActivity.class);
    }
}