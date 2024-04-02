package com.dhammamobile.dictionary_of_pali_term;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;


public class DeclomationPujaActivity extends BaseActivityClass {

    private Button buttonHome;
    private Button buttonLiveToPuja;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declomation_puja);

      //  setWindowFlagsFullscreenAndNoLimits();

        this.buttonHome = findViewById(R.id.buttonPujaHome);
        this.buttonLiveToPuja = findViewById(R.id.buttonliveToPuja);
    }

    public void toDeclomation(View view){
        buttonHome.setVisibility(View.INVISIBLE);
        buttonLiveToPuja.setVisibility(View.INVISIBLE);
        startIntentActivityAndFinish(DeklomationMainActivity.class);
    }

    public void toDeclomaciyaMorningPuja(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextMorningPuja);
        scrollText.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToPuja.setVisibility(View.VISIBLE);
    }

    public void toDeclomaciyaVandanaAmbokote(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextVandanaAmbokote);
        scrollText.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToPuja.setVisibility(View.VISIBLE);
    }

    public void toDeclomaciyaVandanaWithLayman(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextVandanaWithLayman);
        scrollText.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToPuja.setVisibility(View.VISIBLE);
    }

    public void tobackOver(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextMorningPuja);
        ScrollView scrollTextVandanaWithLayman = findViewById(R.id.overScrollTextVandanaWithLayman);
        ScrollView scrollTextVandanaAmbokote = findViewById(R.id.overScrollTextVandanaAmbokote);
        scrollText.setVisibility(View.INVISIBLE);
        scrollTextVandanaWithLayman.setVisibility(View.INVISIBLE);
        scrollTextVandanaAmbokote.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
        buttonLiveToPuja.setVisibility(View.INVISIBLE);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(DeklomationMainActivity.class);
    }
}