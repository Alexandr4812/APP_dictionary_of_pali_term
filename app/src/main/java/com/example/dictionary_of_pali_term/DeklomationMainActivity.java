package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

public class DeklomationMainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deklomation_main);

        // Убрать строку состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Убрать панель навигации (если нужно)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public void toMainAct(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void toMorningPuja(View view){
        Intent intent = new Intent(this, DeclomationPujaActivity.class);
        startActivity(intent);
        finish();
    }

    public void toDeclomationSutta(View view){
        Intent intent = new Intent(this, DeclomationSuttaActivity.class);
        startActivity(intent);
        finish();
    }

    public void toDeclomationOver(View view){
        Intent intent = new Intent(this, DeclomationOverActivity.class);
        startActivity(intent);
        finish();
    }

    public void toDeclomationParitta(View view){
        Intent intent = new Intent(this, DeclomationParittaActivity.class);
        startActivity(intent);
        finish();
    }

    public void toDeclomationDhammapada(View view){
        Intent intent = new Intent(this, DeklomationDhammapadaActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }



}