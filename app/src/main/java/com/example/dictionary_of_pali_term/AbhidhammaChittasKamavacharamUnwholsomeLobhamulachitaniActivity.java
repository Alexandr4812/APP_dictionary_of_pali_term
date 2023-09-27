package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;
import android.os.Bundle;
import android.view.View;

public class AbhidhammaChittasKamavacharamUnwholsomeLobhamulachitaniActivity extends BaseActivityClass{

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_kamavacharam_unwholsome_lobhamulachitani);

        setWindowFlagsFullscreenAndNoLimits();
    }

    public void toAbhidhammaChittasKamavacharamUnwholsomeAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamUnwholsomeActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(AbhidhammaChittasKamavacharamUnwholsomeActivity.class);
    }
}