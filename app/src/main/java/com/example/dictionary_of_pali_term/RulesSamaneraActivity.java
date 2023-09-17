package com.example.dictionary_of_pali_term;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class RulesSamaneraActivity extends BaseActivityClass {

    private Button buttonHome;
    private Button buttonLiveToRulesSamanera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_samanera);

        setWindowFlagsFullscreenAndNoLimits();

        this.buttonHome = findViewById(R.id.buttonRulesSamaneraHome);
        this.buttonLiveToRulesSamanera = findViewById(R.id.buttonliveToRulesSamanera);
    }

    public void toRulesSekhiyaAct(View view){
        startIntentActivityAndFinish(RulesSamaneraSekhiyaActivity.class);
    }

    public void toRulesAct(View view){
        startIntentActivityAndFinish(RulesActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(RulesActivity.class);
    }

    public void toBecomingSamaneraPabajaAct(View view){
        startIntentActivityAndFinish(RulesSamaneraPabbajjaActivity.class);
    }

    public void toTextNissaya(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollRulesSamaneraNissaya);
        scrollText.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public void tobackDhammapada(View view) {
        ScrollView scrollTextNissaya = findViewById(R.id.viewScrollRulesSamaneraNissaya);
        scrollTextNissaya.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.INVISIBLE);
    }
}