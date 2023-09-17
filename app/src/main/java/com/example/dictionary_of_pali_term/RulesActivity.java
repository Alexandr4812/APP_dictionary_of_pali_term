package com.example.dictionary_of_pali_term;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

public class RulesActivity extends BaseActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

        setWindowFlagsFullscreenAndNoLimits();

        Button button1 = findViewById(R.id.button_rules_for_samanera);
        Button button2 = findViewById(R.id.button_rules_for_bhikkhu);
        ImageView im1 =findViewById(R.id.imageVievRules1);

        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        Animation slideFromLeftAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_left);
        Animation slideFromRightAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_right);
        button1.startAnimation(slideFromLeftAnimation);
        button2.startAnimation(slideFromRightAnimation);
        im1.startAnimation(slideDown);
    }

    public void toRulesSamaneraAct(View view){
        startIntentActivityAndFinish(RulesSamaneraActivity.class);
    }

    public void toRulesBhikhuAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(MainActivity.class);
    }
}