package com.example.dictionary_of_pali_term;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import java.util.Locale;

public class MainActivity extends BaseActivityClass {
    ImageButton imageButtonRu;
    ImageButton imageButtonEn;

    private TextView textView;
    private String textToAnimate;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        setWindowFlagsFullscreenAndNoLimits();

        imageButtonRu = findViewById(R.id.imageButtonRu);
        imageButtonEn = findViewById(R.id.imageButtonUk);

        textView = findViewById(R.id.textViewHintMain);
        textToAnimate = "Приложение находится в стадии разработки, материал в разделах не полный, он только добавляется." +
                " В данный момент приложение корректно работает если на телефоне установленна светлая тема. Если у вас темная тема," +
                " сделайте исключение для этого приложения в настройках телефона.";

        animateText();
    }

    private void animateText() {
        ValueAnimator animator = ValueAnimator.ofInt(0, textToAnimate.length());
        animator.setDuration(2000); // Продолжительность анимации в миллисекундах
        animator.addUpdateListener(animation -> {
            int animatedValue = (int) animation.getAnimatedValue();
            String partialText = textToAnimate.substring(0, animatedValue);
            textView.setText(partialText);
        });
        animator.addListener(new AnimatorListenerAdapter() {
            @Override
            public void onAnimationEnd(Animator animation) {
                super.onAnimationEnd(animation);
                // Анимация завершена
            }
        });
        animator.start();
    }


    public void changeLangEn(View view) {
        Locale locale = new Locale("en");
        changeLocale(locale);

        ScrollView scrollText = findViewById(R.id.popupMenuSV);
        ImageButton imageButtonEx = findViewById(R.id.button_menu_exit);
        ImageButton imageButtonM = findViewById(R.id.button_menu);
        scrollText.setVisibility(View.INVISIBLE);
        imageButtonEx.setVisibility(View.INVISIBLE);
        imageButtonM.setVisibility(View.VISIBLE);
    }

    public void changeLangRu(View view) {
        Locale locale = new Locale("en-us");
        changeLocale(locale);

        ScrollView scrollText = findViewById(R.id.popupMenuSV);
        ImageButton imageButtonEx = findViewById(R.id.button_menu_exit);
        ImageButton imageButtonM = findViewById(R.id.button_menu);
        scrollText.setVisibility(View.INVISIBLE);
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

        TextView tv = findViewById(R.id.textView4);
        tv.setText(R.string.mainButtonLiveBuddha);
        tv = findViewById(R.id.textView3);
        tv.setText(R.string.mainButtonStofiDlyaDeclomacii);
        tv = findViewById(R.id.textView2);
        tv.setText(R.string.mainButtonShortSuttas);
        tv = findViewById(R.id.textView1);
        tv.setText(R.string.mainButtonMonksRules);
        tv = findViewById(R.id.textView0);
        tv.setText(R.string.mainButtonMonksAbhidhamma);
    }

    public void toLiveBu(View view){
        startIntentActivityAndFinish(LiveBuddhaActivity.class);
    }

    public void toDeclomation(View view){
        startIntentActivityAndFinish(DeklomationMainActivity.class);
    }

    public void toSuttas(View view){
        startIntentActivityAndFinish(SuttasActivity.class);
    }

    public void toRulesAct(View view){
        startIntentActivityAndFinish(RulesActivity.class);
    }

    public void toAbhidhammaAct(View view){
        startIntentActivityAndFinish(AbhidhammaActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toPopupMenu(View view) {
        ScrollView scrollText = findViewById(R.id.popupMenuSV);

        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        imageButtonRu.startAnimation(slideDown);
        imageButtonEn.startAnimation(slideDown);

        ImageButton imageButtonEx = findViewById(R.id.button_menu_exit);
        ImageButton imageButtonM = findViewById(R.id.button_menu);


        scrollText.setVisibility(View.VISIBLE);
        imageButtonEx.setVisibility(View.VISIBLE);
        imageButtonM.setVisibility(View.INVISIBLE);
    }

    public void toPopupMenuExit(View view) {
        ScrollView scrollText = findViewById(R.id.popupMenuSV);
        ImageButton imageButtonEx = findViewById(R.id.button_menu_exit);
        ImageButton imageButtonM = findViewById(R.id.button_menu);
        scrollText.setVisibility(View.INVISIBLE);
        imageButtonEx.setVisibility(View.INVISIBLE);
        imageButtonM.setVisibility(View.VISIBLE);
    }


}