package com.dhammamobile.dictionary_of_pali_term.Rules;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

public class RulesBhikkhuAboutOffencesActivity extends BaseActivityClass {
    private Button buttonHome;
    private Button buttonLiveToBhikhuAbout;

    private TextView textViewOffences1;

    private ScrollView scrollTextOffences1;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_bhikkhu_about_offences);

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.buttonHome = findViewById(R.id.buttonBhikkhuOffencesHome);
        this.buttonLiveToBhikhuAbout = findViewById(R.id.buttonBhikkhuOffencesLive);

        this.textViewOffences1 = findViewById(R.id.textViewOffences1);

        this.scrollTextOffences1 = findViewById(R.id.viewScrollTextRulesBhikkhuOffences1);
    }

    public void toRlesBhikkhuOffences1(View view) {
        textViewOffences1.setText(Html.fromHtml(getString(R.string.textOffences1)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextOffences1.setVisibility(View.VISIBLE);
    }

    public void tobackBhikhuRequisites(View view) {
        scrollTextOffences1.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.INVISIBLE);
    }

    public void toRulesBhikkhuAboutAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuAboutActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(RulesBhikkhuAboutActivity.class);
    }
}