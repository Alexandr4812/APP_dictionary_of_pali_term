package com.example.dictionary_of_pali_term;

import android.content.Intent;
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
        Intent intent = new Intent(this, AbhidhammaActivity.class);
        startActivity(intent);
        finish();
    }

    public void toMainAct(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void toChetasikasEtichVerAct(View view){
        Intent intent = new Intent(this, AbhidhammaChetasikasEtichVerActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, AbhidhammaActivity.class);
        startActivity(intent);
        finish();
    }
}