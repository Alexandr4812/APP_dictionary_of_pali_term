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

public class RulesBhikkhuAboutRequisitesActivity extends BaseActivityClass {
    private Button buttonHome;
    private Button buttonLiveToBhikhuAbout;

    private TextView textViewRequisites1;
    private TextView textViewRequisites2;
    private TextView textViewRequisites3;
    private TextView textViewRequisites4;
    private TextView textViewRequisites5;

    private ScrollView scrollTextRequisites1;
    private ScrollView scrollTextRequisites2;
    private ScrollView scrollTextRequisites3;
    private ScrollView scrollTextRequisites4;
    private ScrollView scrollTextRequisites5;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_bhikkhu_about_requisites);

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.buttonHome = findViewById(R.id.buttonBhikkhuRequisitesHome);
        this.buttonLiveToBhikhuAbout = findViewById(R.id.buttonBhikkhuRequisitesLive);

        this.textViewRequisites1 = findViewById(R.id.textViewRequisites1);
        this.textViewRequisites2 = findViewById(R.id.textViewRequisites2);
        this.textViewRequisites3 = findViewById(R.id.textViewRequisites3);
        this.textViewRequisites4 = findViewById(R.id.textViewRequisites4);
        this.textViewRequisites5 = findViewById(R.id.textViewRequisites5);

        this.scrollTextRequisites1 = findViewById(R.id.viewScrollTextRulesBhikkhuRequisites1);
        this.scrollTextRequisites2 = findViewById(R.id.viewScrollTextRulesBhikkhuRequisites2);
        this.scrollTextRequisites3 = findViewById(R.id.viewScrollTextRulesBhikkhuRequisites3);
        this.scrollTextRequisites4 = findViewById(R.id.viewScrollTextRulesBhikkhuRequisites4);
        this.scrollTextRequisites5 = findViewById(R.id.viewScrollTextRulesBhikkhuRequisites5);
    }

    public void toRlesBhikkhuRequisites1(View view) {
        textViewRequisites1.setText(Html.fromHtml(getString(R.string.textRequisites1)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextRequisites1.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuRequisites2(View view) {
        textViewRequisites2.setText(Html.fromHtml(getString(R.string.textRequisites2)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextRequisites2.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuRequisites3(View view) {
        textViewRequisites3.setText(Html.fromHtml(getString(R.string.textRequisites3)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextRequisites3.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuRequisites4(View view) {
        textViewRequisites4.setText(Html.fromHtml(getString(R.string.textRequisites4)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextRequisites4.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuRequisites5(View view) {
        textViewRequisites5.setText(Html.fromHtml(getString(R.string.textRequisites5)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextRequisites5.setVisibility(View.VISIBLE);
    }

    public void tobackBhikhuRequisites(View view) {
        scrollTextRequisites1.setVisibility(View.INVISIBLE);
        scrollTextRequisites2.setVisibility(View.INVISIBLE);
        scrollTextRequisites3.setVisibility(View.INVISIBLE);
        scrollTextRequisites4.setVisibility(View.INVISIBLE);
        scrollTextRequisites5.setVisibility(View.INVISIBLE);
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