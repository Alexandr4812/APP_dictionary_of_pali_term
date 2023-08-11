package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;

public class DeclomationParittaActivity extends AppCompatActivity {
    private Button buttonHome;
    private Button buttonLiveToParitta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declomation_paritta);

        // Убрать строку состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Убрать панель навигации (если нужно)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

        this.buttonHome = findViewById(R.id.buttonParittaHome);
        this.buttonLiveToParitta = findViewById(R.id.buttonliveToParitta);
    }

    public void toDeclomation(View view){
        Intent intent = new Intent(this, DeklomationMainActivity.class);
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
        Intent intent = new Intent(this, DeklomationMainActivity.class);
        startActivity(intent);
        finish();
    }

    public void tobackParitta(View view) {
        ScrollView scrollTextMora = findViewById(R.id.overScrollTextMoraParitta);
        scrollTextMora.setVisibility(view.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
        buttonLiveToParitta.setVisibility(View.INVISIBLE);
    }

    public void toDeclomaciyaParittaMora(View view) {
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToParitta.setVisibility(View.VISIBLE);
        ScrollView scrollText = findViewById(R.id.overScrollTextMoraParitta);
        scrollText.setVisibility(view.VISIBLE);
    }
}