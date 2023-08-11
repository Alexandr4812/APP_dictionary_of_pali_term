package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class RulesSamaneraActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_samanera);

        // Убрать строку состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Убрать панель навигации (если нужно)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public void toRulesSekhiyaAct(View view){
        Intent intent = new Intent(this, RulesSamaneraSekhiyaActivity.class);
        startActivity(intent);
        finish();
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

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, RulesActivity.class);
        startActivity(intent);
        finish();
    }

    public void toBecomingSamaneraPabajaAct(View view){
        Intent intent = new Intent(this, RulesSamaneraPabbajjaActivity.class);
        startActivity(intent);
        finish();
    }
}