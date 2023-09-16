package com.example.dictionary_of_pali_term;

import android.content.Intent;
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

        setWindowFlagsFullscreenAndNoLimits();

        this.buttonBack = (Button) findViewById(R.id.buttonliveToBhikkhu);
        this.buttonHome = (Button) findViewById(R.id.buttonliveHomeFromUpasampada);
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

    public void toRulesPatimokhaParajikaAct(View view){
        Intent intent = new Intent(this, RulesBhikkhuPatimokhaParajikaActivity.class);
        startActivity(intent);
        finish();
    }

    public void toRulesPatimokhaSanghadisesaAct(View view){
        Intent intent = new Intent(this, RulesBhikkhuPatimokhaSanghadisesaActivity.class);
        startActivity(intent);
        finish();
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