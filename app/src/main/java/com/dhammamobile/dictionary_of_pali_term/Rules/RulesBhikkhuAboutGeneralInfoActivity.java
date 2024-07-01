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

public class RulesBhikkhuAboutGeneralInfoActivity extends BaseActivityClass {

    private Button buttonHome;
    private Button buttonLiveToBhikhuAbout;

    private TextView textViewAboutGeneralInfo1;
    private TextView textViewAboutGeneralInfo2;
    private TextView textViewAboutGeneralInfo3;
    private TextView textViewAboutGeneralInfo4;
    private TextView textViewAboutGeneralInfo5;
    private TextView textViewAboutGeneralInfo6;
    private TextView textViewAboutGeneralInfo7;
    private TextView textViewAboutGeneralInfo8;
    private TextView textViewAboutGeneralInfo9;
    private TextView textViewAboutGeneralInfo10;

    private TextView textViewAboutGeneralInfo11;
    private TextView textViewAboutGeneralInfo12;

    private ScrollView scrollTextGeneralInfo1;
    private ScrollView scrollTextGeneralInfo2;
    private ScrollView scrollTextGeneralInfo3;
    private ScrollView scrollTextGeneralInfo4;
    private ScrollView scrollTextGeneralInfo5;
    private ScrollView scrollTextGeneralInfo6;
    private ScrollView scrollTextGeneralInfo7;
    private ScrollView scrollTextGeneralInfo8;
    private ScrollView scrollTextGeneralInfo9;
    private ScrollView scrollTextGeneralInfo10;
    private ScrollView scrollTextGeneralInfo11;
    private ScrollView scrollTextGeneralInfo12;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_bhikkhu_about_general_info);

        // Скрытие панели навигации и панели состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        this.buttonHome = findViewById(R.id.buttonBhikkhuAmoutGeneralInfoHome);
        this.buttonLiveToBhikhuAbout = findViewById(R.id.buttonBhikkhuAmoutGeneralInfoLive);

        this.textViewAboutGeneralInfo1 = findViewById(R.id.textViewAboutGeneralInfo1);
        this.textViewAboutGeneralInfo2 = findViewById(R.id.textViewAboutGeneralInfo2);
        this.textViewAboutGeneralInfo3 = findViewById(R.id.textViewAboutGeneralInfo3);
        this.textViewAboutGeneralInfo4 = findViewById(R.id.textViewAboutGeneralInfo4);
        this.textViewAboutGeneralInfo5 = findViewById(R.id.textViewAboutGeneralInfo5);
        this.textViewAboutGeneralInfo6 = findViewById(R.id.textViewAboutGeneralInfo6);
        this.textViewAboutGeneralInfo7 = findViewById(R.id.textViewAboutGeneralInfo7);
        this.textViewAboutGeneralInfo8 = findViewById(R.id.textViewAboutGeneralInfo8);
        this.textViewAboutGeneralInfo9 = findViewById(R.id.textViewAboutGeneralInfo9);
        this.textViewAboutGeneralInfo10 = findViewById(R.id.textViewAboutGeneralInfo10);
        this.textViewAboutGeneralInfo11 = findViewById(R.id.textViewAboutGeneralInfo11);
        this.textViewAboutGeneralInfo12 = findViewById(R.id.textViewAboutGeneralInfo12);

        this.scrollTextGeneralInfo1 = findViewById(R.id.viewScrollTextRulesBhikkhuAboutGeneralInfo1);
        this.scrollTextGeneralInfo2 = findViewById(R.id.viewScrollTextRulesBhikkhuAboutGeneralInfo2);
        this.scrollTextGeneralInfo3 = findViewById(R.id.viewScrollTextRulesBhikkhuAboutGeneralInfo3);
        this.scrollTextGeneralInfo4 = findViewById(R.id.viewScrollTextRulesBhikkhuAboutGeneralInfo4);
        this.scrollTextGeneralInfo5 = findViewById(R.id.viewScrollTextRulesBhikkhuAboutGeneralInfo5);
        this.scrollTextGeneralInfo6 = findViewById(R.id.viewScrollTextRulesBhikkhuAboutGeneralInfo6);
        this.scrollTextGeneralInfo7 = findViewById(R.id.viewScrollTextRulesBhikkhuAboutGeneralInfo7);
        this.scrollTextGeneralInfo8 = findViewById(R.id.viewScrollTextRulesBhikkhuAboutGeneralInfo8);
        this.scrollTextGeneralInfo9 = findViewById(R.id.viewScrollTextRulesBhikkhuAboutGeneralInfo9);
        this.scrollTextGeneralInfo10 = findViewById(R.id.viewScrollTextRulesBhikkhuAboutGeneralInfo10);
        this.scrollTextGeneralInfo11 = findViewById(R.id.viewScrollTextRulesBhikkhuAboutGeneralInfo11);
        this.scrollTextGeneralInfo12 = findViewById(R.id.viewScrollTextRulesBhikkhuAboutGeneralInfo12);
    }

    public void toRlesBhikkhuGeneralInfo1(View view) {
        textViewAboutGeneralInfo1.setText(Html.fromHtml(getString(R.string.textGeneralInfo1)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextGeneralInfo1.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuGeneralInfo2(View view) {
        textViewAboutGeneralInfo2.setText(Html.fromHtml(getString(R.string.textGeneralInfo2)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextGeneralInfo2.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuGeneralInfo3(View view) {
        textViewAboutGeneralInfo3.setText(Html.fromHtml(getString(R.string.textGeneralInfo3)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextGeneralInfo3.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuGeneralInfo4(View view) {
        textViewAboutGeneralInfo4.setText(Html.fromHtml(getString(R.string.textGeneralInfo4)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextGeneralInfo4.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuGeneralInfo5(View view) {
        textViewAboutGeneralInfo5.setText(Html.fromHtml(getString(R.string.textGeneralInfo5)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextGeneralInfo5.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuGeneralInfo6(View view) {
        textViewAboutGeneralInfo6.setText(Html.fromHtml(getString(R.string.textGeneralInfo6)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextGeneralInfo6.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuGeneralInfo7(View view) {
        textViewAboutGeneralInfo7.setText(Html.fromHtml(getString(R.string.textGeneralInfo7)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextGeneralInfo7.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuGeneralInfo8(View view) {
        textViewAboutGeneralInfo8.setText(Html.fromHtml(getString(R.string.textGeneralInfo8)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextGeneralInfo8.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuGeneralInfo9(View view) {
        textViewAboutGeneralInfo9.setText(Html.fromHtml(getString(R.string.textGeneralInfo9)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextGeneralInfo9.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuGeneralInfo10(View view) {
        textViewAboutGeneralInfo10.setText(Html.fromHtml(getString(R.string.textGeneralInfo10)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextGeneralInfo10.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuGeneralInfo11(View view) {
        textViewAboutGeneralInfo11.setText(Html.fromHtml(getString(R.string.textGeneralInfo11)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextGeneralInfo11.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuGeneralInfo12(View view) {
        textViewAboutGeneralInfo12.setText(Html.fromHtml(getString(R.string.textGeneralInfo12)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextGeneralInfo12.setVisibility(View.VISIBLE);
    }

    public void tobackBhikhuGeneralInfo(View view) {
        scrollTextGeneralInfo1.setVisibility(View.INVISIBLE);
        scrollTextGeneralInfo2.setVisibility(View.INVISIBLE);
        scrollTextGeneralInfo3.setVisibility(View.INVISIBLE);
        scrollTextGeneralInfo4.setVisibility(View.INVISIBLE);
        scrollTextGeneralInfo5.setVisibility(View.INVISIBLE);
        scrollTextGeneralInfo6.setVisibility(View.INVISIBLE);
        scrollTextGeneralInfo7.setVisibility(View.INVISIBLE);
        scrollTextGeneralInfo8.setVisibility(View.INVISIBLE);
        scrollTextGeneralInfo9.setVisibility(View.INVISIBLE);
        scrollTextGeneralInfo10.setVisibility(View.INVISIBLE);
        scrollTextGeneralInfo11.setVisibility(View.INVISIBLE);
        scrollTextGeneralInfo12.setVisibility(View.INVISIBLE);
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