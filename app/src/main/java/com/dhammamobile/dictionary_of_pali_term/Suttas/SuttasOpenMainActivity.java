package com.dhammamobile.dictionary_of_pali_term.Suttas;

import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.Button;
import android.widget.ImageView;

import androidx.activity.OnBackPressedCallback;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

public class SuttasOpenMainActivity extends BaseActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suttas_open_main);

        // setWindowFlagsFullscreenAndNoLimits();

        // Скрытие панели навигации и панели состояния
        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });


        Button button1 = findViewById(R.id.button_suttas_open_main1);
        Button button2 = findViewById(R.id.button_suttas_open_main2);
        ImageView im1 =findViewById(R.id.imageSuttasOpenMain1);


        Animation appearFast = AnimationUtils.loadAnimation(this, R.anim.appear_fast);
        button1.startAnimation(appearFast);
        button2.startAnimation(appearFast);
        im1.startAnimation(appearFast);


        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Вместо закрытия — переходим на главную
                startIntentActivityAndFinish(MainActivity.class);
            }
        });
    }

    public void toTheravada(View view){
        startIntentActivityAndFinish(SuttasActivity.class);
    }
    public void toSuttasOpenAct(View view){
        startIntentActivityAndFinish(SuttasOpenActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }



}