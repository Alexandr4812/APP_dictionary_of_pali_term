package com.dhammamobile.dictionary_of_pali_term.Rules;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.ScrollView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;


public class RulesSamaneraSekhiyaActivity extends BaseActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_samanera_sekhiya);

       // setWindowFlagsFullscreenAndNoLimits();

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });
    }

    public void toRulesSamaneraAct(View view){
        startIntentActivityAndFinish(RulesSamaneraActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(RulesSamaneraActivity.class);
    }

    public void toComm1(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm1);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toComm2(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm2);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toComm5_6(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm5_6);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toComm7_8(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm7_8);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toComm9_10(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm9_10);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toComm11_12(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm11_12);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toComm13_14(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm13_14);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toComm15_16(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm15_16);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toComm17_18(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm17_18);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toComm19_20(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm19_20);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toComm21_22(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm21_22);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toComm23_24(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm23_24);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toComm25(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm25);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toComm26(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm26);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toComm27(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm27);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toComm28(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm28);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toComm29(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm29);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toComm30(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm30);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toComm31(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm31);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void toComm32(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm32);
        scrollText.setVisibility(View.VISIBLE);
    }

    public void tobackIzTextSekhiya(View view) {//TODO: remove view parameter
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm1);
        scrollText.setVisibility(View.INVISIBLE);
        ScrollView scrollText2 = findViewById(R.id.viewScrollSekhiyaComm2);
        scrollText2.setVisibility(View.INVISIBLE);
        ScrollView scrollText3 = findViewById(R.id.viewScrollSekhiyaComm5_6);
        scrollText3.setVisibility(View.INVISIBLE);
        ScrollView scrollText4 = findViewById(R.id.viewScrollSekhiyaComm7_8);
        scrollText4.setVisibility(View.INVISIBLE);
        ScrollView scrollText5 = findViewById(R.id.viewScrollSekhiyaComm9_10);
        scrollText5.setVisibility(View.INVISIBLE);
        ScrollView scrollText6 = findViewById(R.id.viewScrollSekhiyaComm11_12);
        scrollText6.setVisibility(View.INVISIBLE);
        ScrollView scrollText7 = findViewById(R.id.viewScrollSekhiyaComm13_14);
        scrollText7.setVisibility(View.INVISIBLE);
        ScrollView scrollText8 = findViewById(R.id.viewScrollSekhiyaComm15_16);
        scrollText8.setVisibility(View.INVISIBLE);
        ScrollView scrollText9 = findViewById(R.id.viewScrollSekhiyaComm17_18);
        scrollText9.setVisibility(View.INVISIBLE);
        ScrollView scrollText10 = findViewById(R.id.viewScrollSekhiyaComm19_20);
        scrollText10.setVisibility(View.INVISIBLE);
        ScrollView scrollText11 = findViewById(R.id.viewScrollSekhiyaComm21_22);
        scrollText11.setVisibility(View.INVISIBLE);
        ScrollView scrollText12 = findViewById(R.id.viewScrollSekhiyaComm23_24);
        scrollText12.setVisibility(View.INVISIBLE);
        ScrollView scrollText13 = findViewById(R.id.viewScrollSekhiyaComm25);
        scrollText13.setVisibility(View.INVISIBLE);
        ScrollView scrollText14 = findViewById(R.id.viewScrollSekhiyaComm26);
        scrollText14.setVisibility(View.INVISIBLE);
        ScrollView scrollText15 = findViewById(R.id.viewScrollSekhiyaComm27);
        scrollText15.setVisibility(View.INVISIBLE);
        ScrollView scrollText16 = findViewById(R.id.viewScrollSekhiyaComm28);
        scrollText16.setVisibility(View.INVISIBLE);
        ScrollView scrollText17 = findViewById(R.id.viewScrollSekhiyaComm29);
        scrollText17.setVisibility(View.INVISIBLE);
        ScrollView scrollText18 = findViewById(R.id.viewScrollSekhiyaComm30);
        scrollText18.setVisibility(View.INVISIBLE);
        ScrollView scrollText19 = findViewById(R.id.viewScrollSekhiyaComm31);
        scrollText19.setVisibility(View.INVISIBLE);
        ScrollView scrollText20 = findViewById(R.id.viewScrollSekhiyaComm32);
        scrollText20.setVisibility(View.INVISIBLE);
    }
}