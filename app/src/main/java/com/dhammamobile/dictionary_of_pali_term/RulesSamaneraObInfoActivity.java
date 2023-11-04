package com.dhammamobile.dictionary_of_pali_term;

import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class RulesSamaneraObInfoActivity extends BaseActivityClass {
    private Button buttonHome;
    private Button buttonLiveToRulesSamanera;
    private ScrollView scrollTextMajorInfo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_samanera_ob_info);

        setWindowFlagsFullscreenAndNoLimits();

        this.buttonHome = findViewById(R.id.buttonRulesSamaneraProtocolsHome);
        this.buttonLiveToRulesSamanera = findViewById(R.id.buttonliveToRulesSamaneraProtocols);

        this.scrollTextMajorInfo = findViewById(R.id.viewScrollRulesSamaneraMagorInfo);
    }

    public void toRulesSamaneraAct(View view){
        startIntentActivityAndFinish(RulesSamaneraActivity.class);
    }

    public void toRulesSamaneraObInfoProtocolsAct(View view){
        startIntentActivityAndFinish(RulesSamaneraObInfoProtocolsActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(RulesSamaneraActivity.class);
    }


    public void toTextMajorInfo(View view) {
        scrollTextMajorInfo.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }


    public void tobackRulesSamaneraProtocolAct(View view) {
        scrollTextMajorInfo.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.INVISIBLE);
    }
}