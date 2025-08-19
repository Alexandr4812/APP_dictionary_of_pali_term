package com.dhammamobile.dictionary_of_pali_term.Rules;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;


public class RulesActivity extends BaseActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);

       // setWindowFlagsFullscreenAndNoLimits();

        // Скрытие панели навигации и панели состояния
        enableEdgeToEdgeMode();
        
        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        Button button0 = findViewById(R.id.button_rules_for_lay);
        Button button1 = findViewById(R.id.button_rules_for_samanera);
        Button button2 = findViewById(R.id.button_rules_for_bhikkhu);
        ImageView im1 =findViewById(R.id.imageVievRules1);

        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        Animation slideFromLeftAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_left);
        Animation slideFromRightAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_right);

        button0.startAnimation(slideFromLeftAnimation);
        button1.startAnimation(slideFromRightAnimation);
        button2.startAnimation(slideFromLeftAnimation);
        im1.startAnimation(slideDown);
    }

    public void toRulesSamaneraAct(View view){
        startIntentActivityAndFinish(RulesSamaneraActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toRulesBhikhuAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuActivity.class);
    }
    public void toRulesLayAct(View view){
        startIntentActivityAndFinish(RulesLayActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(MainActivity.class);
    }
}