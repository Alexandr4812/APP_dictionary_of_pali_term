package com.example.dictionary_of_pali_term;

import android.os.Bundle;
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

        Button button1 = findViewById(R.id.button_mentalnie_enich_ver_faktori);
        ImageView im1 = findViewById(R.id.imageVievAbhidhamma1);

        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        Animation slideFromLeftAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_left);

        button1.startAnimation(slideFromLeftAnimation);
        im1.startAnimation(slideDown);
    }

    @Override
    public void onBackPressed(){
        toMainAct(null);
    }
}