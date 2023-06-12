package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class ActivityBecomingSamsneraPpabaja extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_becoming_samsnera_pabaja);
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

    public void toRulesAct(View view){
        Intent intent = new Intent(this, RulesActivity.class);
        startActivity(intent);
        finish();
    }
}