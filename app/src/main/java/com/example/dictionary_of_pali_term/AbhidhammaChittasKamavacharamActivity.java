package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.View;

public class AbhidhammaChittasKamavacharamActivity extends BaseActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_kamavacharam);

        setWindowFlagsFullscreenAndNoLimits();
    }

    public void toAbhidhammaChittasAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasActivity.class);
    }

    public void toAbhidhammaChittasKamavacharamUnwholsomeAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamUnwholsomeActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(AbhidhammaChittasActivity.class);
    }
}