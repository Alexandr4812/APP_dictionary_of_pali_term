package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ListView;
import android.widget.ScrollView;

public class LiveBuddhaActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_buddha);
    }

    public void toMainAct(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void toSumedha(View view) {
        ScrollView scrollText = findViewById(R.id.liveScrollText);
        scrollText.setVisibility(view.VISIBLE);
    }

    public void tobackIzTextVLive(View view) {
        ScrollView scrollText = findViewById(R.id.liveScrollText);
        scrollText.setVisibility(view.INVISIBLE);
    }
}