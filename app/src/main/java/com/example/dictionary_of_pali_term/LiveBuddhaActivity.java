package com.example.dictionary_of_pali_term;

import androidx.annotation.DrawableRes;
import androidx.annotation.StringRes;
import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.graphics.drawable.Drawable;
import android.os.Bundle;
import android.view.View;
import android.widget.ArrayAdapter;
import android.widget.Button;
import android.widget.ImageView;
import android.widget.ListView;
import android.widget.ScrollView;
import android.widget.TextView;

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


    public void toMaya(View view) {
        ScrollView scrollText = findViewById(R.id.liveScrollTextMaya);
        scrollText.setVisibility(view.VISIBLE);
    }

    public void toBirthSidhartha(View view) {
        ScrollView scrollText = findViewById(R.id.liveScrollTextBirthSidhartha);
        scrollText.setVisibility(view.VISIBLE);
    }

    public void tobackIzTextVLive(View view) {
        ScrollView scrollText = findViewById(R.id.liveScrollText);
        scrollText.setVisibility(view.INVISIBLE);
        ScrollView scrollText2 = findViewById(R.id.liveScrollTextMaya);
        scrollText2.setVisibility(view.INVISIBLE);
        ScrollView scrollText3 = findViewById(R.id.liveScrollTextBirthSidhartha);
        scrollText3.setVisibility(view.INVISIBLE);
    }

}