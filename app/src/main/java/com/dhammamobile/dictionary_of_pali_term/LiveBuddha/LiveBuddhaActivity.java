package com.dhammamobile.dictionary_of_pali_term.LiveBuddha;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;


public class LiveBuddhaActivity extends BaseActivityClass {


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_buddha);

       // setWindowFlagsFullscreenAndNoLimits();

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toShow1(View view) {
        startIntentActivityAndFinish(LiveBuddhaToShow1Activity.class);
    }




    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(MainActivity.class);
    }

}