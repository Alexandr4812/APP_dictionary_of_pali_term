package com.dhammamobile.dictionary_of_pali_term;

import android.annotation.SuppressLint;
import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;
import android.widget.TextView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.Abhidhamma.AbhidhammaActivity;
import com.dhammamobile.dictionary_of_pali_term.Declomation.DeklomationMainActivity;
import com.dhammamobile.dictionary_of_pali_term.LiveBuddha.LiveBuddhaActivity;
import com.dhammamobile.dictionary_of_pali_term.Rules.RulesActivity;
import com.dhammamobile.dictionary_of_pali_term.Suttas.SuttasActivity;
import com.dhammamobile.dictionary_of_pali_term.Teacher.TeacherActivity;

import java.util.Locale;

public class MainActivity extends BaseActivityClass {
    ImageButton imageButtonRu;
    ImageButton imageButtonEn;
    ImageButton imageButtonInfo;

    Button toBackFromInfo;
    WebView webViewMainInfo;

    private TextView textView;
    private String textToAnimate;
//    private static final String LANGUAGE_PREF_KEY = "LANGUAGE_PREF_KEY";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        // Устанавливаем язык
        updateLocale();


        // Загружаем макет
        setContentView(R.layout.activity_main);

        // Скрытие панели навигации и панели состояния
//        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN,
//                WindowManager.LayoutParams.FLAG_FULLSCREEN);

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });


        // Находим элементы управления
        imageButtonRu = findViewById(R.id.imageButtonRu);
        imageButtonEn = findViewById(R.id.imageButtonUk);
        imageButtonInfo = findViewById(R.id.imageButtonInfoMain);

        toBackFromInfo = findViewById(R.id.buttonToBackFromInfo);
        webViewMainInfo =findViewById(R.id.webViewMainInfo);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateLocale();
    }


    public void changeLangEn(View view) {
        setLocales("en");
        updateViewsVisibility();
    }

    public void changeLangRu(View view) {
        setLocales("ru");
        updateViewsVisibility();
    }


    private void setLocales(String language) {
        Locale locale = new Locale(language);
        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
        saveLanguage(language);
    }


    private void updateViewsVisibility() {
        ScrollView scrollText = findViewById(R.id.popupMenuSV);
        ImageButton imageButtonEx = findViewById(R.id.button_menu_exit);
        ImageButton imageButtonM = findViewById(R.id.button_menu);
        scrollText.setVisibility(View.INVISIBLE);
        imageButtonEx.setVisibility(View.INVISIBLE);
        imageButtonM.setVisibility(View.VISIBLE);

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

    public void toTeacherAct(View view){
        startIntentActivityAndFinish(TeacherActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toPopupMenu(View view) {
        ScrollView scrollText = findViewById(R.id.popupMenuSV);

        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        imageButtonRu.startAnimation(slideDown);
        imageButtonEn.startAnimation(slideDown);
        imageButtonInfo.startAnimation(slideDown);

        ImageButton imageButtonEx = findViewById(R.id.button_menu_exit);
        ImageButton imageButtonM = findViewById(R.id.button_menu);


        scrollText.setVisibility(View.VISIBLE);
        imageButtonEx.setVisibility(View.VISIBLE);
        imageButtonM.setVisibility(View.INVISIBLE);
    }

    private void loadHtmlPage(String htmlFilePath) {
        webViewMainInfo.loadUrl(htmlFilePath);
    }

    public void toMainInfo(View view) {
        toBackFromInfo.setVisibility(View.VISIBLE);
        webViewMainInfo.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/info_ru/infoRu.html";
        } else {
            htmlFilePath = "file:///android_asset/info_en/infoEn.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void toBackFromInfo(View view){
        toBackFromInfo.setVisibility(View.INVISIBLE);
        webViewMainInfo.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onBackPressed() {
        showConfirmationDialog();
        super.onBackPressed();

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