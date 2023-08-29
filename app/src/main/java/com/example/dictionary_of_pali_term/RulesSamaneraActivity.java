package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;

public class RulesSamaneraActivity extends AppCompatActivity {

    private Button buttonHome;
    private Button buttonLiveToRulesSamanera;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_samanera);

        // Убрать строку состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Убрать панель навигации (если нужно)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        this.buttonHome = findViewById(R.id.buttonRulesSamaneraHome);
        this.buttonLiveToRulesSamanera = findViewById(R.id.buttonliveToRulesSamanera);
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

    public void toTextNissaya(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollRulesSamaneraNissaya);
        scrollText.setVisibility(view.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public void tobackDhammapada(View view) {
        ScrollView scrollTextNissaya = findViewById(R.id.viewScrollRulesSamaneraNissaya);
        scrollTextNissaya.setVisibility(view.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.INVISIBLE);
    }
}