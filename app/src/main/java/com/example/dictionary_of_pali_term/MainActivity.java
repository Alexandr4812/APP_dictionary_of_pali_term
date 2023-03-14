package com.example.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;
import android.content.res.Configuration;

import android.content.Intent;
import android.content.res.Resources;
import android.widget.Button;
import android.os.Bundle;
import android.view.View;
import android.widget.EditText;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;
import java.util.Locale;

public class MainActivity extends AppCompatActivity {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

            }

    public void changeLangEn(View view) {
        Locale locale = new Locale("en");
        changeLocale(locale);

        ScrollView scrollText = findViewById(R.id.popupMenuSV);
        ImageButton imageButtonEx = findViewById(R.id.imageButtonExit);
        ImageButton imageButtonM = findViewById(R.id.button_menu);
        scrollText.setVisibility(view.INVISIBLE);
        imageButtonEx.setVisibility(View.INVISIBLE);
        imageButtonM.setVisibility(View.VISIBLE);
    }

    public void changeLangRu(View view) {
        Locale locale = new Locale("en-us");
        changeLocale(locale);

        ScrollView scrollText = findViewById(R.id.popupMenuSV);
        ImageButton imageButtonEx = findViewById(R.id.imageButtonExit);
        ImageButton imageButtonM = findViewById(R.id.button_menu);
        scrollText.setVisibility(view.INVISIBLE);
        imageButtonEx.setVisibility(View.INVISIBLE);
        imageButtonM.setVisibility(View.VISIBLE);
    }

    @SuppressWarnings("deprecation")
    private void changeLocale(Locale locale)
    {
        Locale.setDefault(locale);
        Configuration configuration = new Configuration();
        configuration.setLocale(locale);
        getBaseContext().getResources()
                .updateConfiguration(configuration,
                        getBaseContext()
                                .getResources()
                                .getDisplayMetrics());
        setTitle(R.string.app_name);

        TextView tv = (TextView) findViewById(R.id.textView4);
        tv.setText(R.string.mainButtonLiveBuddha);
        tv = (TextView) findViewById(R.id.textView3);
        tv.setText(R.string.mainButtonStofiDlyaDeclomacii);
        tv = (TextView) findViewById(R.id.textView2);
        tv.setText(R.string.mainButtonShortSuttas);
        tv = (TextView) findViewById(R.id.textView1);
        tv.setText(R.string.mainButtonMonksRules);
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

    public void toRulesAct(View view){
        Intent intent = new Intent(this, RulesActivity.class);
        startActivity(intent);
        finish();
    }

    public void toMainAct(View view){
        Intent intent = new Intent(this, MainActivity.class);
        startActivity(intent);
        finish();
    }

    public void toPopupMenu(View view) {
        ScrollView scrollText = findViewById(R.id.popupMenuSV);
        ImageButton imageButtonEx = findViewById(R.id.imageButtonExit);
        ImageButton imageButtonM = findViewById(R.id.button_menu);
        scrollText.setVisibility(view.VISIBLE);
        imageButtonEx.setVisibility(View.VISIBLE);
        imageButtonM.setVisibility(View.INVISIBLE);
    }

    public void toPopupMenuExit(View view) {
        ScrollView scrollText = findViewById(R.id.popupMenuSV);
        ImageButton imageButtonEx = findViewById(R.id.imageButtonExit);
        ImageButton imageButtonM = findViewById(R.id.button_menu);
        scrollText.setVisibility(view.INVISIBLE);
        imageButtonEx.setVisibility(View.INVISIBLE);
        imageButtonM.setVisibility(View.VISIBLE);
    }


}