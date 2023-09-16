package com.example.dictionary_of_pali_term;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RulesBhikkhuUpasampadaActivity extends BaseActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_bhikkhu_upasampada);

        setWindowFlagsFullscreenAndNoLimits();
    }

    public void toMainAct(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, RulesBhikkhuActivity.class);
        startActivity(intent);
        finish();
    }


    public void toRulesBhikkhuAct(View view){
        Intent intent = new Intent(this, RulesBhikkhuActivity.class);
        startActivity(intent);
        finish();
    }
}