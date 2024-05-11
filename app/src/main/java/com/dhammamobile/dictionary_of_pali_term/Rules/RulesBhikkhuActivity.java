package com.dhammamobile.dictionary_of_pali_term.Rules;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;


public class RulesBhikkhuActivity extends BaseActivityClass {

    private Button buttonHome;
    private Button buttonLiveToBhikhu;

    private TextView textViewUpasampada;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_bhikkhu);

       // setWindowFlagsFullscreenAndNoLimits();

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.buttonHome = findViewById(R.id.buttonBhikhuHome);
        this.buttonLiveToBhikhu = findViewById(R.id.buttonliveToBhikhuFromUps);

        this.textViewUpasampada = findViewById(R.id.textViewUpasampada);
    }

    public void toRulesAct(View view){
        startIntentActivityAndFinish(RulesActivity.class);
    }

    public void toBhikkhuAboutAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuAboutActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toRulesPatimokhaAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuPatimokhaActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(RulesActivity.class);
    }

    public void tobackBhikhuUps(View view) {
        ScrollView scrollTextUpasampada = findViewById(R.id.overScrollTextUpasampada);
        scrollTextUpasampada.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
        buttonLiveToBhikhu.setVisibility(View.INVISIBLE);
    }

    public void toRlesBhikkhuUpasampada(View view) {
        textViewUpasampada.setText(Html.fromHtml(getString(R.string.textForUpasampada)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhu.setVisibility(View.VISIBLE);
        ScrollView scrollTextUpasampada = findViewById(R.id.overScrollTextUpasampada);
        scrollTextUpasampada.setVisibility(View.VISIBLE);
    }
}