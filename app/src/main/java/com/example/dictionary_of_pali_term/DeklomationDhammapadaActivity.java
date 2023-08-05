package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class DeklomationDhammapadaActivity extends AppCompatActivity {

    private Button buttonHome;
    private Button buttonLiveToDhammapada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deklomation_dhammapada);

        this.buttonHome = findViewById(R.id.buttonDhammapadaHome);
        this.buttonLiveToDhammapada = findViewById(R.id.buttonliveToDhammapada);
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

    public void toTextabout1Dhammapada(View view) {
        ScrollView scrollText = findViewById(R.id.dhammapadaScrollTextAbout1Dhammapada);
        scrollText.setVisibility(view.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToDhammapada.setVisibility(View.VISIBLE);
    }

    public void tobackDhammapada(View view) {
        ScrollView scrollTextDhammapada = findViewById(R.id.dhammapadaScrollTextAbout1Dhammapada);
        scrollTextDhammapada.setVisibility(view.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
        buttonLiveToDhammapada.setVisibility(View.INVISIBLE);
    }
}