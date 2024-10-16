package com.dhammamobile.dictionary_of_pali_term.Declomation;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;


public class DeclomationOverActivity extends BaseActivityClass {

    private Button buttonHome;
    private Button buttonLiveToOver;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declomation_over);

       // setWindowFlagsFullscreenAndNoLimits();

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.buttonHome = findViewById(R.id.buttonDeclomationHome);
        this.buttonLiveToOver = findViewById(R.id.buttonliveToOver);
    }

    public void toDeclomation(View view){
        startIntentActivityAndFinish(DeklomationMainActivity.class);
    }


    public void toDeclomaciyaAlmsWish(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextAlmsWish);
        scrollText.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToOver.setVisibility(View.VISIBLE);
    }



    public void toDeclomaciyaRefleksiyaOProshlihNeobhodimostyah(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextDeclomaciyaRefleksiyaOProshlihNeobhodimostyah);
        scrollText.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToOver.setVisibility(View.VISIBLE);
    }

    public void toDeclomaciya32chasti(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextDeclomaciya32chasti);
        scrollText.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToOver.setVisibility(View.VISIBLE);
    }

    public void tobackOver(View view) {
        ScrollView scrollText3 = findViewById(R.id.overScrollTextAlmsWish);
        scrollText3.setVisibility(View.INVISIBLE);
        ScrollView scrollText5 = findViewById(R.id.overScrollTextDeclomaciyaRefleksiyaOProshlihNeobhodimostyah);
        scrollText5.setVisibility(View.INVISIBLE);
        ScrollView scrollText6 = findViewById(R.id.overScrollTextDeclomaciya32chasti);
        scrollText6.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
        buttonLiveToOver.setVisibility(View.INVISIBLE);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(DeklomationMainActivity.class);
    }
}