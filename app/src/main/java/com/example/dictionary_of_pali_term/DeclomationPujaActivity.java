package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ScrollView;

public class DeclomationPujaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declomation_puja);

        // Убрать строку состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Убрать панель навигации (если нужно)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    public void toDeclomation(View view){
        Intent intent = new Intent(this, DeklomationMainActivity.class);
        startActivity(intent);
        finish();
    }

    public void toDeclomaciyaMorningPuja(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextMorningPuja);
        scrollText.setVisibility(view.VISIBLE);
    }

    public void toDeclomaciyaVandanaWithLayman(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextVandanaWithLayman);
        scrollText.setVisibility(view.VISIBLE);
    }

    public void tobackOver(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextMorningPuja);
        ScrollView scrollTextVandanaWithLayman = findViewById(R.id.overScrollTextVandanaWithLayman);
        scrollText.setVisibility(view.INVISIBLE);
        scrollTextVandanaWithLayman.setVisibility(view.INVISIBLE);
    }

    public void toMainAct(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, DeklomationMainActivity.class);
        startActivity(intent);
        finish();
    }
}