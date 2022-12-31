package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.Intent;
import android.os.Bundle;
import android.view.Menu;
import android.view.View;
import androidx.appcompat.widget.PopupMenu;
import android.view.MenuItem;

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
        Intent intent = new Intent(this, DeklomationMainActivity.class);
        startActivity(intent);
        finish();
    }

    public void toSuttas(View view){
        Intent intent = new Intent(this, SuttasActivity.class);
        startActivity(intent);
        finish();
    }

    public void toTermins(View view){
        Intent intent = new Intent(this, TerminsActivity.class);
        startActivity(intent);
        finish();
    }

    private void showPopupMenu(View v){
        PopupMenu popupMenu = new PopupMenu(this, v);
        popupMenu.inflate(R.menu.popupmenu);
    }
}