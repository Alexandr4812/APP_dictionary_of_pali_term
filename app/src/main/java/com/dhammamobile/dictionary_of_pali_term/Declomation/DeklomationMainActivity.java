package com.dhammamobile.dictionary_of_pali_term.Declomation;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
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


public class DeklomationMainActivity extends BaseActivityClass {

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_deklomation_main);

       // setWindowFlagsFullscreenAndNoLimits();

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        Button button1 = findViewById(R.id.button_sutta);
        Button button2 = findViewById(R.id.button_paritta);
        Button buttonG = findViewById(R.id.button_gatha);
        Button button3 = findViewById(R.id.button_dhammapada);
        Button button4 = findViewById(R.id.button_puja);
        Button button5 = findViewById(R.id.button_over_declamation);
        Button button6 = findViewById(R.id.button_anumodana);
        ImageView im1 =findViewById(R.id.imageViewRazdelitelDeklomationMain);

        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        Animation slideFromLeftAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_left);
        Animation slideFromRightAnimation = AnimationUtils.loadAnimation(this, R.anim.slide_from_right);
        Animation appearFast = AnimationUtils.loadAnimation(this, R.anim.appear_fast);

        button1.startAnimation(appearFast);
        button2.startAnimation(appearFast);
        buttonG.startAnimation(appearFast);
        button3.startAnimation(appearFast);
        button4.startAnimation(appearFast);
        button5.startAnimation(appearFast);
        button6.startAnimation(appearFast);
        im1.startAnimation(appearFast);

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Вместо закрытия — переходим на главную
                startIntentActivityAndFinish(MainActivity.class);
            }
        });
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toMorningPuja(View view){
        startIntentActivityAndFinish(DeclomationPujaActivity.class);
    }

    public void toDeclomationSutta(View view){
        startIntentActivityAndFinish(DeclomationSuttaActivity.class);
    }

    public void toDeclomationOver(View view){
        startIntentActivityAndFinish(DeclomationOverActivity.class);
    }

    public void toDeclomationParitta(View view){
        startIntentActivityAndFinish(DeclomationParittaActivity.class);
    }
    public void toDeclomationGatha(View view){
        startIntentActivityAndFinish(DeklomationGatha.class);
    }

    public void toDeclomationAnumodana(View view){
        startIntentActivityAndFinish(DeklomationAnumodanaActivity.class);
    }

    public void toDeclomationDhammapada(View view){
        startIntentActivityAndFinish(DeklomationDhammapadaActivity.class);
    }





}