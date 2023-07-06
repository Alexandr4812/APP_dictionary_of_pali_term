package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.Button;
import android.widget.ScrollView;

public class RulesBhikkhuPatimokhaActivity extends AppCompatActivity {

    private Button buttonHome;
    private Button buttonBack;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_bhikkhu_patimokha);

        this.buttonBack = (Button) findViewById(R.id.buttonliveToPatimokha);
        this.buttonHome = (Button) findViewById(R.id.buttonliveHomeFromPatimokha);
    }

    public void toMainAct(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    @Override
    public void onBackPressed(){
        Intent intent = new Intent(this, RulesBhikkhuActivity.class);
        startActivity(intent);
        finish();
    }


    public void toRulesBhikkhuAct(View view){
        Intent intent = new Intent(this, RulesBhikkhuActivity.class);
        startActivity(intent);
        finish();
    }

    public void toRulesPatimokhaParajikaAct(View view){
        Intent intent = new Intent(this, RulesBhikkhuPatimokhaParajikaActivity.class);
        startActivity(intent);
        finish();
    }

    public void toPatimokhaAbout(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollPatimokhaAbout);
        scrollText.setVisibility(view.VISIBLE);
        buttonBack.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
    }

    public void toPatimokhaAboutPunish(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollPatimokhaAboutPunish);
        scrollText.setVisibility(view.VISIBLE);
        buttonBack.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
    }

    public void tobackIzTextPatimokha(View view) {
        ScrollView scrollText = findViewById(R.id.viewScrollPatimokhaAbout);
        scrollText.setVisibility(view.INVISIBLE);
        ScrollView scrollText2 = findViewById(R.id.viewScrollPatimokhaAboutPunish);
        scrollText2.setVisibility(view.INVISIBLE);
        buttonBack.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
    }
}