package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.View;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);
            }

    public void toLiveBu(View view){
        Intent intent = new Intent(this, LiveBuddhaActivity.class);
        startActivity(intent);
        finish();
    }

    public void toDeclomation(View view){
        Intent intent = new Intent(this, Deklomation.class);
        startActivity(intent);
        finish();
    }

    public void toSuttas(View view){
        Intent intent = new Intent(this, Suttas.class);
        startActivity(intent);
        finish();
    }

    public void toTermins(View view){
        Intent intent = new Intent(this, Termins.class);
        startActivity(intent);
        finish();
    }


}