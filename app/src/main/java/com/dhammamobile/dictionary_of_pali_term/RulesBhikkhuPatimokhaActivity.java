package com.dhammamobile.dictionary_of_pali_term;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;


public class RulesBhikkhuPatimokhaActivity extends BaseActivityClass {
    private Button buttonHome;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_bhikkhu_patimokha);

       // setWindowFlagsFullscreenAndNoLimits();

        this.buttonBack = findViewById(R.id.buttonliveToBhikkhu);
        this.buttonHome = findViewById(R.id.buttonliveHomeFromUpasampada);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(RulesBhikkhuActivity.class);
    }


    public void toRulesBhikkhuAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuActivity.class);
    }

    public void toRulesPatimokhaParajikaAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaParajikaActivity.class);
    }

    public void toRulesPatimokhaSanghadisesaAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaSanghadisesaActivity.class);
    }

    public void toPatimokhaAbout(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollPatimokhaAbout);
        scrollText.setVisibility(View.VISIBLE);
        buttonBack.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
    }

    public void toPatimokhaAboutPunish(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollPatimokhaAboutPunish);
        scrollText.setVisibility(View.VISIBLE);
        buttonBack.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
    }

    public void tobackIzTextPatimokha(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollPatimokhaAbout);
        scrollText.setVisibility(View.INVISIBLE);
        ScrollView scrollText2 = findViewById(R.id.viewScrollPatimokhaAboutPunish);
        scrollText2.setVisibility(View.INVISIBLE);
        buttonBack.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
    }
}