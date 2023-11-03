package com.dhammamobile.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class RulesSamaneraObInfoProtocolsActivity extends BaseActivityClass {

    private Button buttonHome, buttonLiveToRulesSamanera;

    private ScrollView scrollTextProtocols, scrollTextProtocols2;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_samanera_ob_info_protocols);

        setWindowFlagsFullscreenAndNoLimits();

        this.buttonHome = findViewById(R.id.buttonRulesSamaneraObInfoProtocolsHome);
        this.buttonLiveToRulesSamanera = findViewById(R.id.buttonliveToRulesSamaneraObInfoProtocols);


        this.scrollTextProtocols = findViewById(R.id.viewScrollTextRulesSamaneraObInfoProtocols);
        this.scrollTextProtocols2 = findViewById(R.id.viewScrollTextRulesSamaneraObInfoProtocols2);
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

    public void tobackRulesSamaneraObInfoProtocolAct(View view) {
        scrollTextProtocols.setVisibility(View.INVISIBLE);
        scrollTextProtocols2.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.INVISIBLE);
    }
}