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

    public void toShow2(View view) {
        startIntentActivityAndFinish(LiveBuddhaToShow2Activity.class);
    }

    public void toShow3(View view) {
        startIntentActivityAndFinish(LiveBuddhaToShow3Activity.class);
    }

    public void toShow4(View view) {
        startIntentActivityAndFinish(LiveBuddhaToShow4Activity.class);
    }

    public void toShow5(View view) {
        startIntentActivityAndFinish(LiveBuddhaToShow5Activity.class);
    }

    public void toShow6(View view) {
        startIntentActivityAndFinish(LiveBuddhaToShow6Activity.class);
    }
    public void toShow7(View view) {
        startIntentActivityAndFinish(LiveBuddhaToShow7Activity.class);
    }
    public void toShow8(View view) {
        startIntentActivityAndFinish(LiveBuddhaToShow8Activity.class);
    }
    public void toShow9(View view) {
        startIntentActivityAndFinish(LiveBuddhaToShow9Activity.class);
    }






    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(MainActivity.class);
    }

}