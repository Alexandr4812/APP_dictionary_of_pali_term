package com.example.dictionary_of_pali_term;

import android.os.Bundle;
import android.view.View;

public class RulesSamaneraPabbajjaActivity extends BaseActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_samanera_pabbajja);

        setWindowFlagsFullscreenAndNoLimits();
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(RulesSamaneraActivity.class);
    }

    public void toRulesSamaneraAct(View view){
        startIntentActivityAndFinish(RulesSamaneraActivity.class);
    }


}