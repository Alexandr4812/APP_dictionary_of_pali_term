package com.dhammamobile.dictionary_of_pali_term.Rules;

import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.text.Html;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;
import android.widget.TextView;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

public class RulesBhikkhuAboutOffencesPacittiyaActivity extends BaseActivityClass {
    private Button buttonHome;
    private Button buttonLiveToBhikhuAbout;

    private TextView textViewOffencesPacittiya1;
    private TextView textViewOffencesPacittiya2;
    private TextView textViewOffencesPacittiya3;
    private TextView textViewOffencesPacittiya6;
    private TextView textViewOffencesPacittiya7;
    private TextView textViewOffencesPacittiya8;
    private TextView textViewOffencesPacittiya9;
    private TextView textViewOffencesPacittiya10, textViewOffencesPacittiya18, textViewOffencesPacittiya19,
            textViewOffencesPacittiya20, textViewOffencesPacittiya21, textViewOffencesPacittiya22,
            textViewOffencesPacittiya23, textViewOffencesPacittiya25, textViewOffencesPacittiya28,
            textViewOffencesPacittiya29, textViewOffencesPacittiya30;



    private ScrollView scrollTextOffencesPacittiya1;
    private ScrollView scrollTextOffencesPacittiya2;
    private ScrollView scrollTextOffencesPacittiya3;
    private ScrollView scrollTextOffencesPacittiya6;
    private ScrollView scrollTextOffencesPacittiya7;
    private ScrollView scrollTextOffencesPacittiya8;
    private ScrollView scrollTextOffencesPacittiya9;
    private ScrollView scrollTextOffencesPacittiya10, scrollTextOffencesPacittiya18, scrollTextOffencesPacittiya19,
            scrollTextOffencesPacittiya20, scrollTextOffencesPacittiya21, scrollTextOffencesPacittiya22,
            scrollTextOffencesPacittiya23, scrollTextOffencesPacittiya25, scrollTextOffencesPacittiya28,
            scrollTextOffencesPacittiya29, scrollTextOffencesPacittiya30;
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_bhikkhu_about_offences_pacittiya);

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        this.buttonHome = findViewById(R.id.buttonBhikkhuOffencesPacittiyaHome);
        this.buttonLiveToBhikhuAbout = findViewById(R.id.buttonBhikkhuOffencesPacittiyaLive);

        this.textViewOffencesPacittiya1 = findViewById(R.id.textViewOffencesPacittiya1);
        this.textViewOffencesPacittiya2 = findViewById(R.id.textViewOffencesPacittiya2);
        this.textViewOffencesPacittiya3 = findViewById(R.id.textViewOffencesPacittiya3);
        this.textViewOffencesPacittiya6 = findViewById(R.id.textViewOffencesPacittiya6);
        this.textViewOffencesPacittiya7 = findViewById(R.id.textViewOffencesPacittiya7);
        this.textViewOffencesPacittiya8 = findViewById(R.id.textViewOffencesPacittiya8);
        this.textViewOffencesPacittiya9 = findViewById(R.id.textViewOffencesPacittiya9);
        this.textViewOffencesPacittiya10 = findViewById(R.id.textViewOffencesPacittiya10);
        this.textViewOffencesPacittiya18 = findViewById(R.id.textViewOffencesPacittiya18);
        this.textViewOffencesPacittiya19 = findViewById(R.id.textViewOffencesPacittiya19);
        this.textViewOffencesPacittiya20 = findViewById(R.id.textViewOffencesPacittiya20);
        this.textViewOffencesPacittiya21 = findViewById(R.id.textViewOffencesPacittiya21);
        this.textViewOffencesPacittiya22 = findViewById(R.id.textViewOffencesPacittiya22);
        this.textViewOffencesPacittiya23 = findViewById(R.id.textViewOffencesPacittiya23);
        this.textViewOffencesPacittiya25 = findViewById(R.id.textViewOffencesPacittiya25);
        this.textViewOffencesPacittiya28 = findViewById(R.id.textViewOffencesPacittiya28);
        this.textViewOffencesPacittiya29 = findViewById(R.id.textViewOffencesPacittiya29);
        this.textViewOffencesPacittiya30 = findViewById(R.id.textViewOffencesPacittiya30);

        TextView textViewLink = findViewById(R.id.textViewPacitiyaAbout);

        this.scrollTextOffencesPacittiya1 = findViewById(R.id.viewScrollTextRulesBhikkhuOffencesPacittiya1);
        this.scrollTextOffencesPacittiya2 = findViewById(R.id.viewScrollTextRulesBhikkhuOffencesPacittiya2);
        this.scrollTextOffencesPacittiya3 = findViewById(R.id.viewScrollTextRulesBhikkhuOffencesPacittiya3);
        this.scrollTextOffencesPacittiya6 = findViewById(R.id.viewScrollTextRulesBhikkhuOffencesPacittiya6);
        this.scrollTextOffencesPacittiya7 = findViewById(R.id.viewScrollTextRulesBhikkhuOffencesPacittiya7);
        this.scrollTextOffencesPacittiya8 = findViewById(R.id.viewScrollTextRulesBhikkhuOffencesPacittiya8);
        this.scrollTextOffencesPacittiya9 = findViewById(R.id.viewScrollTextRulesBhikkhuOffencesPacittiya9);
        this.scrollTextOffencesPacittiya10 = findViewById(R.id.viewScrollTextRulesBhikkhuOffencesPacittiya10);
        this.scrollTextOffencesPacittiya18 = findViewById(R.id.viewScrollTextRulesBhikkhuOffencesPacittiya18);
        this.scrollTextOffencesPacittiya19 = findViewById(R.id.viewScrollTextRulesBhikkhuOffencesPacittiya19);
        this.scrollTextOffencesPacittiya20 = findViewById(R.id.viewScrollTextRulesBhikkhuOffencesPacittiya20);
        this.scrollTextOffencesPacittiya21 = findViewById(R.id.viewScrollTextRulesBhikkhuOffencesPacittiya21);
        this.scrollTextOffencesPacittiya22 = findViewById(R.id.viewScrollTextRulesBhikkhuOffencesPacittiya22);
        this.scrollTextOffencesPacittiya23 = findViewById(R.id.viewScrollTextRulesBhikkhuOffencesPacittiya23);
        this.scrollTextOffencesPacittiya25 = findViewById(R.id.viewScrollTextRulesBhikkhuOffencesPacittiya25);
        this.scrollTextOffencesPacittiya28 = findViewById(R.id.viewScrollTextRulesBhikkhuOffencesPacittiya28);
        this.scrollTextOffencesPacittiya29 = findViewById(R.id.viewScrollTextRulesBhikkhuOffencesPacittiya29);
        this.scrollTextOffencesPacittiya30 = findViewById(R.id.viewScrollTextRulesBhikkhuOffencesPacittiya30);

        animateText(textViewLink, getString(R.string.textOffencesPacittiyaAbout));
    }

    public void toRlesBhikkhuOffencesPacittiya1(View view){
        textViewOffencesPacittiya1.setText(Html.fromHtml(getString(R.string.textPacittiya1)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextOffencesPacittiya1.setVisibility(View.VISIBLE);
    }
    public void toRlesBhikkhuOffencesPacittiya2(View view){
        textViewOffencesPacittiya2.setText(Html.fromHtml(getString(R.string.textPacittiya2)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextOffencesPacittiya2.setVisibility(View.VISIBLE);
    }
    public void toRlesBhikkhuOffencesPacittiya3(View view){
        textViewOffencesPacittiya3.setText(Html.fromHtml(getString(R.string.textPacittiya3)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextOffencesPacittiya3.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuOffencesPacittiya6(View view){
        textViewOffencesPacittiya6.setText(Html.fromHtml(getString(R.string.textPacittiya6)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextOffencesPacittiya6.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuOffencesPacittiya7(View view){
        textViewOffencesPacittiya7.setText(Html.fromHtml(getString(R.string.textPacittiya7)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextOffencesPacittiya7.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuOffencesPacittiya8(View view){
        textViewOffencesPacittiya8.setText(Html.fromHtml(getString(R.string.textPacittiya8)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextOffencesPacittiya8.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuOffencesPacittiya9(View view){
        textViewOffencesPacittiya9.setText(Html.fromHtml(getString(R.string.textPacittiya9)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextOffencesPacittiya9.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuOffencesPacittiya10(View view){
        textViewOffencesPacittiya10.setText(Html.fromHtml(getString(R.string.textPacittiya10)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextOffencesPacittiya10.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuOffencesPacittiya18(View view){
        textViewOffencesPacittiya18.setText(Html.fromHtml(getString(R.string.textPacittiya18)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextOffencesPacittiya18.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuOffencesPacittiya19(View view){
        textViewOffencesPacittiya19.setText(Html.fromHtml(getString(R.string.textPacittiya19)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextOffencesPacittiya19.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuOffencesPacittiya20(View view){
        textViewOffencesPacittiya20.setText(Html.fromHtml(getString(R.string.textPacittiya20)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextOffencesPacittiya20.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuOffencesPacittiya21(View view){
        textViewOffencesPacittiya21.setText(Html.fromHtml(getString(R.string.textPacittiya21)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextOffencesPacittiya21.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuOffencesPacittiya22(View view){
        textViewOffencesPacittiya22.setText(Html.fromHtml(getString(R.string.textPacittiya22)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextOffencesPacittiya22.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuOffencesPacittiya23(View view){
        textViewOffencesPacittiya23.setText(Html.fromHtml(getString(R.string.textPacittiya23)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextOffencesPacittiya23.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuOffencesPacittiya25(View view){
        textViewOffencesPacittiya25.setText(Html.fromHtml(getString(R.string.textPacittiya25)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextOffencesPacittiya25.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuOffencesPacittiya28(View view){
        textViewOffencesPacittiya28.setText(Html.fromHtml(getString(R.string.textPacittiya28)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextOffencesPacittiya28.setVisibility(View.VISIBLE);
    }

    public void toRlesBhikkhuOffencesPacittiya29(View view){
        textViewOffencesPacittiya29.setText(Html.fromHtml(getString(R.string.textPacittiya29)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextOffencesPacittiya29.setVisibility(View.VISIBLE);
    }
    public void toRlesBhikkhuOffencesPacittiya30(View view){
        textViewOffencesPacittiya30.setText(Html.fromHtml(getString(R.string.textPacittiya30)));
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.VISIBLE);
        scrollTextOffencesPacittiya30.setVisibility(View.VISIBLE);
    }

    public void tobackBhikhuOffencesPacittiya(View view) {
        scrollTextOffencesPacittiya1.setVisibility(View.INVISIBLE);
        scrollTextOffencesPacittiya2.setVisibility(View.INVISIBLE);
        scrollTextOffencesPacittiya3.setVisibility(View.INVISIBLE);
        scrollTextOffencesPacittiya6.setVisibility(View.INVISIBLE);
        scrollTextOffencesPacittiya7.setVisibility(View.INVISIBLE);
        scrollTextOffencesPacittiya8.setVisibility(View.INVISIBLE);
        scrollTextOffencesPacittiya9.setVisibility(View.INVISIBLE);
        scrollTextOffencesPacittiya10.setVisibility(View.INVISIBLE);
        scrollTextOffencesPacittiya18.setVisibility(View.INVISIBLE);
        scrollTextOffencesPacittiya19.setVisibility(View.INVISIBLE);
        scrollTextOffencesPacittiya20.setVisibility(View.INVISIBLE);
        scrollTextOffencesPacittiya21.setVisibility(View.INVISIBLE);
        scrollTextOffencesPacittiya22.setVisibility(View.INVISIBLE);
        scrollTextOffencesPacittiya23.setVisibility(View.INVISIBLE);
        scrollTextOffencesPacittiya25.setVisibility(View.INVISIBLE);
        scrollTextOffencesPacittiya28.setVisibility(View.INVISIBLE);
        scrollTextOffencesPacittiya29.setVisibility(View.INVISIBLE);
        scrollTextOffencesPacittiya30.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
        buttonLiveToBhikhuAbout.setVisibility(View.INVISIBLE);
    }

    private void animateText(TextView targetTextView, String textToAnimate) {
        ValueAnimator animator = ValueAnimator.ofInt(0, textToAnimate.length());
        animator.setDuration(2000); // Продолжительность анимации в миллисекундах
        animator.addUpdateListener(animation -> {
            int animatedValue = (int) animation.getAnimatedValue();
            String partialText = textToAnimate.substring(0, animatedValue);
            targetTextView.setText(partialText);
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

    public void toRulesBhikkhuAboutOffencesAct(View view){
        startIntentActivityAndFinish(RulesBhikkhuAboutOffencesActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed(){
        startIntentActivityAndFinish(RulesBhikkhuAboutOffencesActivity.class);
    }
}