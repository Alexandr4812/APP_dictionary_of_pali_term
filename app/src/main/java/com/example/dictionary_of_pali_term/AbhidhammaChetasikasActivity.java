package com.example.dictionary_of_pali_term;

import android.os.Bundle;
import android.view.View;

public class AbhidhammaChetasikasActivity extends BaseActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_shetasikas);

        setWindowFlagsFullscreenAndNoLimits();
    }

    public void toAbhidhammaAct(View view){
        startIntentActivityAndFinish(AbhidhammaActivity.class);
    }

    public void toChetasikasEtichVerAct(View view){
        startIntentActivityAndFinish(AbhidhammaChetasikasEtichVerActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(AbhidhammaActivity.class);
    }
}