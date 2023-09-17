package com.example.dictionary_of_pali_term;

import android.os.Bundle;
import android.view.View;

public class RulesBhikkhuUpasampadaActivity extends BaseActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_bhikkhu_upasampada);

        setWindowFlagsFullscreenAndNoLimits();
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(RulesBhikkhuActivity.class);
    }


    public void toRulesBhikkhuAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuActivity.class);
    }
}