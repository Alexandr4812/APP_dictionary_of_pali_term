package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebResourceRequest;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import java.io.File;

public class SuttasDighaActivity extends AppCompatActivity {
    //"file:///android_asset/canon/Teaching/Canon/Suttanta/digha.html"
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Здесь вы можете добавить свои действия при изменении ориентации, если это необходимо
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suttas_digha);

        WebView webView = findViewById(R.id.webView);
        webView.getSettings().setJavaScriptEnabled(true); // Разрешить JavaScript, если нужно
        webView.clearCache(true);

// Загрузка первой страницы
        webView.loadUrl("file:///android_asset/canon/Teaching/Canon/Suttanta/digha.html");
// Обработка переходов между страницами через ссылки
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                if (url.startsWith("file:///android_asset/")) {
                    view.loadUrl(url);
                    return true;
                }
                return false;
            }
        });

    }

    @Override
    protected void onResume() {
        WebView webView = findViewById(R.id.webView);
        super.onResume();
        webView.reload();
    }

    @Override
    protected void onDestroy() {
        WebView webView = findViewById(R.id.webView);
        super.onDestroy();
        webView.destroy();
    }

    public void toMainAct(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void toSuttasAct(View view){
        Intent intent = new Intent(this, SuttasActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, SuttasActivity.class);
        startActivity(intent);
        finish();
    }
}