package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Deklomation extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deklomation_main);
    }

    public void toMainAct(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void toMorningPuja(View view){
        Intent intent = new Intent(this, Declomation_morning_puja.class);
        startActivity(intent);
        finish();
    }

    public void toDeclomationSutta(View view){
        Intent intent = new Intent(this, Declomation_sutta.class);
        startActivity(intent);
        finish();
    }

    public void toDeclomationOver(View view){
        Intent intent = new Intent(this, Declomation_over.class);
        startActivity(intent);
        finish();
    }



}