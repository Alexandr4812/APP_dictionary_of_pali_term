package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;

public class RulesBhikkhuPatimokhaSanghadisesaActivity extends AppCompatActivity {

    private Button buttonHome;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_bhikkhu_patimokha_sanghadisesa);

        // Убрать строку состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Убрать панель навигации (если нужно)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        this.buttonBack = (Button) findViewById(R.id.buttonliveToSanghadisesa);
        this.buttonHome = (Button) findViewById(R.id.buttonSanghadisesaHome);
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

    public void toRulesPatimokhaAct(View view){
        Intent intent = new Intent(this, RulesBhikkhuPatimokhaActivity.class);
        startActivity(intent);
        finish();
    }

    public void toSanghadisesaAbout(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSanghadisesaAbout);
        scrollText.setVisibility(view.VISIBLE);
        buttonBack.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
    }

    public void toBackButtonSanghadisesa(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSanghadisesaAbout);
        scrollText.setVisibility(view.INVISIBLE);
        buttonBack.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
    }
}