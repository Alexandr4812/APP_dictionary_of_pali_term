package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class Declomation_second extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declomation_puja);
    }

    public void toDeclomation(View view){
        Intent intent = new Intent(this, Deklomation.class);
        startActivity(intent);
        finish();
    }
}