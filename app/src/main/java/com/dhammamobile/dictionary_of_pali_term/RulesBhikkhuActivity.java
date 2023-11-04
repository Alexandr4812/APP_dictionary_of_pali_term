package com.dhammamobile.dictionary_of_pali_term;

import android.os.Bundle;
import android.view.View;


public class RulesBhikkhuActivity extends BaseActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_bhikkhu);

        setWindowFlagsFullscreenAndNoLimits();
    }

    public void toRulesAct(View view){
        startIntentActivityAndFinish(RulesActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toRulesUpasampadaAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuUpasampadaActivity.class);
    }

    public void toRulesPatimokhaAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(RulesActivity.class);
    }
}