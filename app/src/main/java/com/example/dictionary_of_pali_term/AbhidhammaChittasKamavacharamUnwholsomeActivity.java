package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class AbhidhammaChittasKamavacharamUnwholsomeActivity extends BaseActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_kamavacharam_unwholsome);

        setWindowFlagsFullscreenAndNoLimits();
    }

    public void toAbhidhammaChittasKamavacharam(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamActivity.class);
    }

    public void toAbhidhammaChittasKamavacharamUnwholsomeLobhamulachitaniAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamUnwholsomeLobhamulachitaniActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamActivity.class);
    }
}