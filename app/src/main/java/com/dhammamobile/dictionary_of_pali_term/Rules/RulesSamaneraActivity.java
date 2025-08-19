package com.dhammamobile.dictionary_of_pali_term.Rules;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;


public class RulesSamaneraActivity extends BaseActivityClass {

    private Button buttonHome;
    private Button buttonLiveToRulesSamanera;



    private ScrollView scrollTextNissaya;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_samanera);

       // setWindowFlagsFullscreenAndNoLimits();

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        this.buttonHome = findViewById(R.id.buttonRulesSamaneraHome);
        this.buttonLiveToRulesSamanera = findViewById(R.id.buttonliveToRulesSamanera);
        this.scrollTextNissaya = findViewById(R.id.viewScrollRulesSamaneraNissaya);
    }

    public void toRulesSekhiyaAct(View view){
        startIntentActivityAndFinish(RulesSamaneraSekhiyaActivity.class);
    }

    public void toRulesAct(View view){
        startIntentActivityAndFinish(RulesActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(RulesActivity.class);
    }

    public void toBecomingSamaneraPabajaAct(View view){
        startIntentActivityAndFinish(RulesSamaneraPabbajjaActivity.class);
    }

    public void toTextNissaya(View view) {
        scrollTextNissaya.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public void toMajorRules(View view){
        startIntentActivityAndFinish(RulesSamaneraObInfoActivity.class);
    }


    public void tobackRulsSamanera(View view) {
        scrollTextNissaya.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.INVISIBLE);
    }
}