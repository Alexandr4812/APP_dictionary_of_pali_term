package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;

public class DeklomationDhammapadaActivity extends BaseActivityClass {

    private Button buttonHome;
    private Button buttonLiveToDhammapada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deklomation_dhammapada);

        setWindowFlagsFullscreenAndNoLimits();

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
        scrollText.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToDhammapada.setVisibility(View.VISIBLE);
    }

    public void toTextabout2Dhammapada(View view) {
        ScrollView scrollText = findViewById(R.id.dhammapadaScrollTextAbout2Dhammapada);
        scrollText.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToDhammapada.setVisibility(View.VISIBLE);
    }

    public void toTextabout3Dhammapada(View view) {
        ScrollView scrollText = findViewById(R.id.dhammapadaScrollTextAbout3Dhammapada);
        scrollText.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToDhammapada.setVisibility(View.VISIBLE);
    }

    public void toTextabout4Dhammapada(View view) {
        ScrollView scrollText = findViewById(R.id.dhammapadaScrollTextAbout4Dhammapada);
        scrollText.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToDhammapada.setVisibility(View.VISIBLE);
    }

    public void toTextabout5Dhammapada(View view) {
        ScrollView scrollText = findViewById(R.id.dhammapadaScrollTextAbout5Dhammapada);
        scrollText.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToDhammapada.setVisibility(View.VISIBLE);
    }

    public void toTextabout6Dhammapada(View view) {
        ScrollView scrollText = findViewById(R.id.dhammapadaScrollTextAbout6Dhammapada);
        scrollText.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToDhammapada.setVisibility(View.VISIBLE);
    }

    public void tobackDhammapada(View view) {
        ScrollView scrollText1Dhammapada = findViewById(R.id.dhammapadaScrollTextAbout1Dhammapada);
        scrollText1Dhammapada.setVisibility(View.INVISIBLE);
        ScrollView scrollText2Dhammapada = findViewById(R.id.dhammapadaScrollTextAbout2Dhammapada);
        scrollText2Dhammapada.setVisibility(View.INVISIBLE);
        ScrollView scrollText3Dhammapada = findViewById(R.id.dhammapadaScrollTextAbout3Dhammapada);
        scrollText3Dhammapada.setVisibility(View.INVISIBLE);
        ScrollView scrollText4Dhammapada = findViewById(R.id.dhammapadaScrollTextAbout4Dhammapada);
        scrollText4Dhammapada.setVisibility(View.INVISIBLE);
        ScrollView scrollText5Dhammapada = findViewById(R.id.dhammapadaScrollTextAbout5Dhammapada);
        scrollText5Dhammapada.setVisibility(View.INVISIBLE);
        ScrollView scrollText6Dhammapada = findViewById(R.id.dhammapadaScrollTextAbout6Dhammapada);
        scrollText6Dhammapada.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
        buttonLiveToDhammapada.setVisibility(View.INVISIBLE);
    }
}