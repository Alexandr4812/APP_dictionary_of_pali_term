package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.net.Uri;
import android.os.Bundle;
import android.text.util.Linkify;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebView;
import android.widget.TextView;

public class SuttasActivity extends AppCompatActivity {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suttas);

        TextView textViewLink = findViewById(R.id.textViewyy);
        Linkify.addLinks(textViewLink, Linkify.WEB_URLS);


        // Убрать строку состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Убрать панель навигации (если нужно)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);

    }

    // Метод для открытия веб-сайта
    public void openWebsite(View view) {
        String url = "https://www.theravada.ru";
        Intent intent = new Intent(Intent.ACTION_VIEW);
        intent.setData(Uri.parse(url));
        startActivity(intent);
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

    public void toSuttasMajjhimaAct(View view){
        Intent intent = new Intent(this, SuttasMajjhimaActivity.class);
        startActivity(intent);
        finish();
    }

    public void toSuttasSanyuttaAct(View view){
        Intent intent = new Intent(this, SuttasSanyuttaActivity.class);
        startActivity(intent);
        finish();
    }

    public void toSuttasAnguttaraAct(View view){
        Intent intent = new Intent(this, SuttasAnguttaraActivity.class);
        startActivity(intent);
        finish();
    }

    public void toSuttasKuddakaAct(View view){
        Intent intent = new Intent(this, SuttasKuddakaActivity.class);
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