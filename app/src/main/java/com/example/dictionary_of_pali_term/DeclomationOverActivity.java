package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ScrollView;

public class DeclomationOverActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_declomation_over);
    }

    public void toDeclomation(View view){
        Intent intent = new Intent(this, DeklomationMainActivity.class);
        startActivity(intent);
        finish();
    }

    public void toDeclomaciyaPeredObedom(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextObed);
        scrollText.setVisibility(view.VISIBLE);
    }

    public void toDeclomaciyaForgivennes(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextForgivennes);
        scrollText.setVisibility(view.VISIBLE);
    }

    public void tobackOver(View view) {
        ScrollView scrollText = findViewById(R.id.overScrollTextObed);
        scrollText.setVisibility(view.INVISIBLE);
        ScrollView scrollText2 = findViewById(R.id.overScrollTextForgivennes);
        scrollText2.setVisibility(view.INVISIBLE);
    }
}