package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;

public class DeclomationSuttaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declomation_sutta);
    }

    public void toMainAct(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void toDeclomation(View view){
        Intent intent = new Intent(this, DeklomationMainActivity.class);
        startActivity(intent);
        finish();
    }

    public void toDeclomaciyaSuttaMetta(View view) {
        ScrollView scrollText = findViewById(R.id.suttaScrollTextMetta);
        Button buttonBackToHome = findViewById(R.id.buttonliveHomeFromMettaSutta);
        Button buttonBackToDeclomationSutta = findViewById(R.id.buttonliveToDeclomationSutta);
        Button play = findViewById(R.id.buttonPlayMettaSutta);
        buttonBackToHome.setVisibility(view.VISIBLE);
        buttonBackToDeclomationSutta.setVisibility(view.VISIBLE);
        play.setVisibility(view.VISIBLE);
        scrollText.setVisibility(view.VISIBLE);
    }

    public void tobackDeclomationSutta(View view) {
        ScrollView scrollText = findViewById(R.id.suttaScrollTextMetta);
        Button buttonBackToHome = findViewById(R.id.buttonliveHomeFromMettaSutta);
        Button buttonBackToDeclomationSutta = findViewById(R.id.buttonliveToDeclomationSutta);
        Button play = findViewById(R.id.buttonPlayMettaSutta);
        buttonBackToHome.setVisibility(view.INVISIBLE);
        buttonBackToDeclomationSutta.setVisibility(view.INVISIBLE);
        play.setVisibility(view.INVISIBLE);
        scrollText.setVisibility(view.INVISIBLE);
    }
    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, DeklomationMainActivity.class);
        startActivity(intent);
        finish();
    }
}