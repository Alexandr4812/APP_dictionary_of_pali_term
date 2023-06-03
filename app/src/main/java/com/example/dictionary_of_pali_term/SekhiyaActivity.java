package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.content.Intent;
import android.view.View;
import android.widget.ScrollView;

public class SekhiyaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_sekhiya);
    }

    public void toRulesSamaneraAct(View view){
        Intent intent = new Intent(this, RulesSamanera.class);
        startActivity(intent);
        finish();
    }

    public void toMainAct(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void toComm1(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm1);
        scrollText.setVisibility(view.VISIBLE);
    }

    public void toComm2(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm2);
        scrollText.setVisibility(view.VISIBLE);
    }

    public void toComm5_6(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm5_6);
        scrollText.setVisibility(view.VISIBLE);
    }

    public void toComm7_8(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm7_8);
        scrollText.setVisibility(view.VISIBLE);
    }

    public void toComm9_10(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm9_10);
        scrollText.setVisibility(view.VISIBLE);
    }

    public void toComm11_12(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm11_12);
        scrollText.setVisibility(view.VISIBLE);
    }

    public void toComm13_14(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm13_14);
        scrollText.setVisibility(view.VISIBLE);
    }

    public void toComm15_16(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm15_16);
        scrollText.setVisibility(view.VISIBLE);
    }

    public void toComm17_18(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm17_18);
        scrollText.setVisibility(view.VISIBLE);
    }

    public void toComm19_20(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm19_20);
        scrollText.setVisibility(view.VISIBLE);
    }

    public void toComm21_22(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm21_22);
        scrollText.setVisibility(view.VISIBLE);
    }

    public void tobackIzTextSekhiya(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollSekhiyaComm1);
        scrollText.setVisibility(view.INVISIBLE);
        ScrollView scrollText2 = findViewById(R.id.viewScrollSekhiyaComm2);
        scrollText2.setVisibility(view.INVISIBLE);
        ScrollView scrollText3 = findViewById(R.id.viewScrollSekhiyaComm5_6);
        scrollText3.setVisibility(view.INVISIBLE);
        ScrollView scrollText4 = findViewById(R.id.viewScrollSekhiyaComm7_8);
        scrollText4.setVisibility(view.INVISIBLE);
        ScrollView scrollText5 = findViewById(R.id.viewScrollSekhiyaComm9_10);
        scrollText5.setVisibility(view.INVISIBLE);
        ScrollView scrollText6 = findViewById(R.id.viewScrollSekhiyaComm11_12);
        scrollText6.setVisibility(view.INVISIBLE);
        ScrollView scrollText7 = findViewById(R.id.viewScrollSekhiyaComm13_14);
        scrollText7.setVisibility(view.INVISIBLE);
        ScrollView scrollText8 = findViewById(R.id.viewScrollSekhiyaComm15_16);
        scrollText8.setVisibility(view.INVISIBLE);
        ScrollView scrollText9 = findViewById(R.id.viewScrollSekhiyaComm17_18);
        scrollText9.setVisibility(view.INVISIBLE);
        ScrollView scrollText10 = findViewById(R.id.viewScrollSekhiyaComm19_20);
        scrollText10.setVisibility(view.INVISIBLE);
        ScrollView scrollText11 = findViewById(R.id.viewScrollSekhiyaComm21_22);
        scrollText11.setVisibility(view.INVISIBLE);
    }
}