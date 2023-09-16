package com.example.dictionary_of_pali_term;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

public class LiveBuddhaActivity extends BaseActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_buddha);

        setWindowFlagsFullscreenAndNoLimits();
    }

    public void toMainAct(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void toSumedha(View view) {
        ScrollView scrollText = findViewById(R.id.liveScrollText);
        scrollText.setVisibility(View.VISIBLE);
    }


    public void toMaya(View view) {
        ScrollView scrollText = findViewById(R.id.liveScrollTextMaya);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toBirthSidhartha(View view) {
        ScrollView scrollText = findViewById(R.id.liveScrollTextBirthSidhartha);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toAsita(View view) {
        ScrollView scrollText = findViewById(R.id.liveScrollTextAsita);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toJhana(View view) {
        ScrollView scrollText = findViewById(R.id.liveScrollTextJhana);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void tobackIzTextVLive(View view) {
        ScrollView scrollText = findViewById(R.id.liveScrollText);
        scrollText.setVisibility(View.INVISIBLE);
        ScrollView scrollText2 = findViewById(R.id.liveScrollTextMaya);
        scrollText2.setVisibility(View.INVISIBLE);
        ScrollView scrollText3 = findViewById(R.id.liveScrollTextBirthSidhartha);
        scrollText3.setVisibility(View.INVISIBLE);
        ScrollView scrollText4 = findViewById(R.id.liveScrollTextAsita);
        scrollText4.setVisibility(View.INVISIBLE);
        ScrollView scrollText5 = findViewById(R.id.liveScrollTextJhana);
        scrollText5.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

}