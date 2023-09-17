package com.example.dictionary_of_pali_term;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class DeclomationParittaActivity extends BaseActivityClass {
    private Button buttonHome;
    private Button buttonLiveToParitta;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declomation_paritta);

        setWindowFlagsFullscreenAndNoLimits();

        this.buttonHome = findViewById(R.id.buttonParittaHome);
        this.buttonLiveToParitta = findViewById(R.id.buttonliveToParitta);
    }

    public void toDeclomation(View view){
        startIntentActivityAndFinish(DeklomationMainActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(DeklomationMainActivity.class);
    }

    public void tobackParitta(View view) {
        ScrollView scrollTextMora = findViewById(R.id.overScrollTextMoraParitta);
        scrollTextMora.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
        buttonLiveToParitta.setVisibility(View.INVISIBLE);
    }

    public void toDeclomaciyaParittaMora(View view) {
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToParitta.setVisibility(View.VISIBLE);
        ScrollView scrollText = findViewById(R.id.overScrollTextMoraParitta);
        scrollText.setVisibility(View.VISIBLE);
    }
}