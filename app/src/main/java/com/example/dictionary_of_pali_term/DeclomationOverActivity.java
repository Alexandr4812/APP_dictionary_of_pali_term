package com.example.dictionary_of_pali_term;

import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

public class DeclomationOverActivity extends BaseActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declomation_over);

        setWindowFlagsFullscreenAndNoLimits();
    }

    public void toDeclomation(View view){
        startIntentActivityAndFinish(DeklomationMainActivity.class);
    }

    public void toDeclomaciyaPeredObedom(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextObed);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toDeclomaciyaForgivennes(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextForgivennes);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toDeclomaciyaAlmsWish(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextAlmsWish);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toDeclomaciyaOftereveningMeditstion(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextDeclomaciyaOftereveningMeditstion);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void tobackOver(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextObed);
        scrollText.setVisibility(View.INVISIBLE);
        ScrollView scrollText2 = findViewById(R.id.overScrollTextForgivennes);
        scrollText2.setVisibility(View.INVISIBLE);
        ScrollView scrollText3 = findViewById(R.id.overScrollTextAlmsWish);
        scrollText3.setVisibility(View.INVISIBLE);
        ScrollView scrollText4 = findViewById(R.id.overScrollTextDeclomaciyaOftereveningMeditstion);
        scrollText4.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(DeklomationMainActivity.class);
    }
}