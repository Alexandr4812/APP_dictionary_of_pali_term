package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class RulesActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules);
    }

    public void toRulesSamaneraAct(View view){
        Intent intent = new Intent(this, RulesSamanera.class);
        startActivity(intent);
        finish();
    }

    public void toBecomingSamaneraPabajaAct(View view){
        Intent intent = new Intent(this, ActivityBecomingSamsneraPpabaja.class);
        startActivity(intent);
        finish();
    }

    public void toMainAct(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }
}