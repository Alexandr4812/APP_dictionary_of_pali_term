package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RulesBhikkhuActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_bhikkhu);
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