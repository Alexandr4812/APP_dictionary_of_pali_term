package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RulesPabbajjaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_pabbajja);
    }

    public void toMainAct(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, RulesSamaneraActivity.class);
        startActivity(intent);
        finish();
    }

    public void toRulesSamaneraAct(View view){
        Intent intent = new Intent(this, RulesSamaneraActivity.class);
        startActivity(intent);
        finish();
    }


}