package com.dhammamobile.dictionary_of_pali_term;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;


public class LiveBuddhaActivity extends BaseActivityClass {

    private Button home, back;

    private ScrollView saveSwan, showAbilities, show8, show9;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_buddha);

       // setWindowFlagsFullscreenAndNoLimits();

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        home = findViewById(R.id.buttonLiveHome);
        back = findViewById(R.id.buttonliveToLive);

        saveSwan = findViewById(R.id.liveScrollTextSaveSwan);
        showAbilities = findViewById(R.id.liveScrollTextShowAbilities);
        show8 = findViewById(R.id.liveScrollTextShow8);
        show9 = findViewById(R.id.liveScrollTextShow9);

    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
        home.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
    }

    public void toSumedha(View view) {
        ScrollView scrollText = findViewById(R.id.liveScrollText);
        home.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
        scrollText.setVisibility(View.VISIBLE);
    }


    public void toMaya(View view) {
        ScrollView scrollText = findViewById(R.id.liveScrollTextMaya);
        home.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toBirthSidhartha(View view) {
        ScrollView scrollText = findViewById(R.id.liveScrollTextBirthSidhartha);
        home.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toAsita(View view) {
        ScrollView scrollText = findViewById(R.id.liveScrollTextAsita);
        home.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toJhana(View view) {
        ScrollView scrollText = findViewById(R.id.liveScrollTextJhana);
        home.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toSaveSwan(View view) {
        home.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
        saveSwan.setVisibility(View.VISIBLE);
    }

    public void toShowAbilities(View view) {
        home.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
        showAbilities.setVisibility(View.VISIBLE);
    }

    public void toShow8(View view) {
        home.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
        show8.setVisibility(View.VISIBLE);
    }

    public void toShow9(View view) {
        home.setVisibility(View.VISIBLE);
        back.setVisibility(View.VISIBLE);
        show9.setVisibility(View.VISIBLE);
    }

    public void tobackIzTextVLive(View view) {
        home.setVisibility(View.INVISIBLE);
        back.setVisibility(View.INVISIBLE);
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
        saveSwan.setVisibility(View.INVISIBLE);
        showAbilities.setVisibility(View.INVISIBLE);
        show8.setVisibility(View.INVISIBLE);
        show9.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(MainActivity.class);
    }

}