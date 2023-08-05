package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;

public class SuttasActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suttas);

       // WebView webView = findViewById(R.id.suttasVebViev);
      //  webView.getSettings().setJavaScriptEnabled(true); // Включаем поддержку JavaScript
       // webView.loadUrl("file:///android_asset/dighaNikaya/theravada.ru/Teaching/Canon/Suttanta/digha.html");
    }
    public void toMainAct(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void toSuttasDighaAct(View view){
        Intent intent = new Intent(this, SuttasDighaActivity.class);
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