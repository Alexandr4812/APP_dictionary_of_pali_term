package com.example.dictionary_of_pali_term;


import android.content.Intent;
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
        Intent intent = new Intent(this, RulesActivity.class);
        startActivity(intent);
        finish();
    }

    public void toMainAct(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void toRulesUpasampadaAct(View view){
        Intent intent = new Intent(this, RulesBhikkhuUpasampadaActivity.class);
        startActivity(intent);
        finish();
    }

    public void toRulesPatimokhaAct(View view){
        Intent intent = new Intent(this, RulesBhikkhuPatimokhaActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, RulesActivity.class);
        startActivity(intent);
        finish();
    }
}