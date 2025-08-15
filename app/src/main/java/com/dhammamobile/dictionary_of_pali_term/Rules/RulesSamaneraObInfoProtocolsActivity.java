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

public class RulesSamaneraObInfoProtocolsActivity extends BaseActivityClass {

    private Button buttonHome, buttonLiveToRulesSamanera;

    private ScrollView scrollTextProtocols, scrollTextProtocols2, scrollTextProtocols3,
            scrollTextProtocols4, scrollTextProtocols5, scrollTextProtocols6, scrollTextProtocols7,
            scrollTextProtocols8, scrollTextProtocols9, scrollTextProtocols10, scrollTextProtocols11,
            scrollTextProtocols12;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_samanera_ob_info_protocols);

       // setWindowFlagsFullscreenAndNoLimits();

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        this.buttonHome = findViewById(R.id.buttonRulesSamaneraObInfoProtocolsHome);
        this.buttonLiveToRulesSamanera = findViewById(R.id.buttonliveToRulesSamaneraObInfoProtocols);


        this.scrollTextProtocols = findViewById(R.id.viewScrollTextRulesSamaneraObInfoProtocols);
        this.scrollTextProtocols2 = findViewById(R.id.viewScrollTextRulesSamaneraObInfoProtocols2);
        this.scrollTextProtocols3 = findViewById(R.id.viewScrollTextRulesSamaneraObInfoProtocols3);
        this.scrollTextProtocols4 = findViewById(R.id.viewScrollTextRulesSamaneraObInfoProtocols4);
        this.scrollTextProtocols5 = findViewById(R.id.viewScrollTextRulesSamaneraObInfoProtocols5);
        this.scrollTextProtocols6 = findViewById(R.id.viewScrollTextRulesSamaneraObInfoProtocols6);
        this.scrollTextProtocols7 = findViewById(R.id.viewScrollTextRulesSamaneraObInfoProtocols7);
        this.scrollTextProtocols8 = findViewById(R.id.viewScrollTextRulesSamaneraObInfoProtocols8);
        this.scrollTextProtocols9 = findViewById(R.id.viewScrollTextRulesSamaneraObInfoProtocols9);
        this.scrollTextProtocols10 = findViewById(R.id.viewScrollTextRulesSamaneraObInfoProtocols10);
        this.scrollTextProtocols11 = findViewById(R.id.viewScrollTextRulesSamaneraObInfoProtocols11);
        this.scrollTextProtocols12 = findViewById(R.id.viewScrollTextRulesSamaneraObInfoProtocols12);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toRulesSamaneraObInfoAct(View view){
        startIntentActivityAndFinish(RulesSamaneraObInfoActivity.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(RulesSamaneraObInfoActivity.class);
    }

    public  void toText1(View view) {
        scrollTextProtocols.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public  void toText2(View view) {
        scrollTextProtocols2.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public  void toText3(View view) {
        scrollTextProtocols3.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public  void toText4(View view) {
        scrollTextProtocols4.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public  void toText5(View view) {
        scrollTextProtocols5.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public  void toText6(View view) {
        scrollTextProtocols6.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public  void toText7(View view) {
        scrollTextProtocols7.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public  void toText8(View view) {
        scrollTextProtocols8.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public  void toText9(View view) {
        scrollTextProtocols9.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public  void toText10(View view) {
        scrollTextProtocols10.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public  void toText11(View view) {
        scrollTextProtocols11.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public  void toText12(View view) {
        scrollTextProtocols12.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public void tobackRulesSamaneraObInfoProtocolAct(View view) {
        scrollTextProtocols.setVisibility(View.INVISIBLE);
        scrollTextProtocols2.setVisibility(View.INVISIBLE);
        scrollTextProtocols3.setVisibility(View.INVISIBLE);
        scrollTextProtocols4.setVisibility(View.INVISIBLE);
        scrollTextProtocols5.setVisibility(View.INVISIBLE);
        scrollTextProtocols6.setVisibility(View.INVISIBLE);
        scrollTextProtocols7.setVisibility(View.INVISIBLE);
        scrollTextProtocols8.setVisibility(View.INVISIBLE);
        scrollTextProtocols9.setVisibility(View.INVISIBLE);
        scrollTextProtocols10.setVisibility(View.INVISIBLE);
        scrollTextProtocols11.setVisibility(View.INVISIBLE);
        scrollTextProtocols12.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.INVISIBLE);
    }
}