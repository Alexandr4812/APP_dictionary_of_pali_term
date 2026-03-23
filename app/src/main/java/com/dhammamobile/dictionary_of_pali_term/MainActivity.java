package com.dhammamobile.dictionary_of_pali_term;

import android.annotation.SuppressLint;
import android.os.Bundle;
import android.view.View;
import android.view.animation.Animation;
import android.view.animation.AnimationUtils;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.ImageButton;
import android.widget.ScrollView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.Abhidhamma.AbhidhammaActivity;
import com.dhammamobile.dictionary_of_pali_term.Declomation.DeklomationMainActivity;
import com.dhammamobile.dictionary_of_pali_term.LiveBuddha.LiveBuddhaActivity;
import com.dhammamobile.dictionary_of_pali_term.Rules.RulesActivity;
import com.dhammamobile.dictionary_of_pali_term.Suttas.SuttasActivity;
import com.dhammamobile.dictionary_of_pali_term.Teacher.TeacherActivity;
import androidx.activity.OnBackPressedCallback;

public class MainActivity extends BaseActivityClass {
    ImageButton imageButtonInfo;

    Button toBackFromInfo;
    WebView webViewMainInfo;

    private static final String KEY_INFO_WEBVIEW_STATE = "info_webview_state";
    private static final String KEY_INFO_WEBVIEW_VISIBILITY = "info_webview_visibility";
    private static final String KEY_INFO_BACK_VISIBILITY = "info_back_visibility";

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateLocale();

        setContentView(R.layout.activity_main);

        enableEdgeToEdgeMode();

        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom);
            return insets;
        });

        imageButtonInfo = findViewById(R.id.imageButtonInfoMain);

        toBackFromInfo = findViewById(R.id.buttonToBackFromInfo);
        webViewMainInfo =findViewById(R.id.webViewMainInfo);

        // Восстанавливаем состояние WebView и видимость кнопок после ротации экрана.
        if (savedInstanceState != null) {
            int infoVisibility = savedInstanceState.getInt(KEY_INFO_WEBVIEW_VISIBILITY, View.INVISIBLE);
            int backVisibility = savedInstanceState.getInt(KEY_INFO_BACK_VISIBILITY, View.INVISIBLE);
            webViewMainInfo.setVisibility(infoVisibility);
            toBackFromInfo.setVisibility(backVisibility);

            Bundle webViewBundle = savedInstanceState.getBundle(KEY_INFO_WEBVIEW_STATE);
            if (webViewBundle != null) {
                webViewMainInfo.restoreState(webViewBundle);
            }
        }

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                if (webViewMainInfo.getVisibility() == View.VISIBLE) {
                    toBackFromInfo(null);
                } else if (findViewById(R.id.popupMenuSV).getVisibility() == View.VISIBLE) {
                    toPopupMenuExit(null);
                } else {
                    showConfirmationDialog();
                }
            }
        });
    }

    @Override
    protected void onSaveInstanceState(Bundle outState) {
        super.onSaveInstanceState(outState);
        if (webViewMainInfo != null) {
            outState.putInt(KEY_INFO_WEBVIEW_VISIBILITY, webViewMainInfo.getVisibility());
            outState.putBundle(KEY_INFO_WEBVIEW_STATE, webViewMainInfo.saveState());
        }
        if (toBackFromInfo != null) {
            outState.putInt(KEY_INFO_BACK_VISIBILITY, toBackFromInfo.getVisibility());
        }
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateLocale();
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

    public void setOrientationPortrait(View view) {
        OrientationPreferenceHelper.saveAndApply(this, OrientationPreferenceHelper.MODE_PORTRAIT);
    }

    public void setOrientationLandscape(View view) {
        OrientationPreferenceHelper.saveAndApply(this, OrientationPreferenceHelper.MODE_LANDSCAPE);
    }

    public void setOrientationSensor(View view) {
        OrientationPreferenceHelper.saveAndApply(this, OrientationPreferenceHelper.MODE_SENSOR);
    }

    public void toPopupMenu(View view) {
        ScrollView scrollText = findViewById(R.id.popupMenuSV);

        Animation slideDown = AnimationUtils.loadAnimation(this, R.anim.slide_down);
        imageButtonInfo.startAnimation(slideDown);
        findViewById(R.id.buttonOrientationPortrait).startAnimation(slideDown);
        findViewById(R.id.buttonOrientationLandscape).startAnimation(slideDown);
        findViewById(R.id.buttonOrientationSensor).startAnimation(slideDown);

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
        loadHtmlPage("file:///android_asset/info_ru/infoRu.html");
    }

    public void toBackFromInfo(View view){
        toBackFromInfo.setVisibility(View.INVISIBLE);
        webViewMainInfo.setVisibility(View.INVISIBLE);
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
