package com.dhammamobile.dictionary_of_pali_term.Rules;

import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;
import android.widget.Button;
import android.widget.ScrollView;

import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

public class RulesSamaneraObInfoActivity extends BaseActivityClass {
    private Button buttonHome;
    private Button buttonLiveToRulesSamanera;
    private ScrollView scrollTextMajorInfo, scrollTextRulesSamaneraObInfoPermissible,
            scrollTextRulesSamaneraPurMoral, scrollTextRulesSamaneraUseMonksThings,
            scrollTextRulesSamaneraDirectionMind, scrollTextRulesSamaneraTypesGoods,
            scrollTextRulesSamaneraGarmony, scrollTextRulesSamaneraCriticism,
            scrollTextRulesSamaneraProtector, scrollTextRulesSamaneraTo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_rules_samanera_ob_info);

       // setWindowFlagsFullscreenAndNoLimits();

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        this.buttonHome = findViewById(R.id.buttonRulesSamaneraProtocolsHome);
        this.buttonLiveToRulesSamanera = findViewById(R.id.buttonliveToRulesSamaneraProtocols);

        this.scrollTextMajorInfo = findViewById(R.id.viewScrollRulesSamaneraMagorInfo);
        this.scrollTextRulesSamaneraObInfoPermissible = findViewById(R.id.viewScrollRulesSamaneraObInfoPermissible);
        this.scrollTextRulesSamaneraPurMoral = findViewById(R.id.viewScrollRulesSamaneraPurMoral);
        this.scrollTextRulesSamaneraUseMonksThings = findViewById(R.id.viewScrollRulesSamaneraUseMonksThings);
        this.scrollTextRulesSamaneraDirectionMind = findViewById(R.id.viewScrollRulesSamaneraDirectionMind);
        this.scrollTextRulesSamaneraTypesGoods =findViewById(R.id.viewScrollRulesSamaneraTypesGoods);
        this.scrollTextRulesSamaneraGarmony = findViewById(R.id.viewScrollRulesSamaneraGarmony);
        this.scrollTextRulesSamaneraCriticism = findViewById(R.id.viewScrollRulesSamaneraCriticism);
        this.scrollTextRulesSamaneraProtector = findViewById(R.id.viewScrollRulesSamaneraProtector);
        this.scrollTextRulesSamaneraTo = findViewById(R.id.viewScrollRulesSamaneraTo);
    }

    public void toRulesSamaneraAct(View view){
        startIntentActivityAndFinish(RulesSamaneraActivity.class);
    }

    public void toRulesSamaneraObInfoProtocolsAct(View view){
        startIntentActivityAndFinish(RulesSamaneraObInfoProtocolsActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(RulesSamaneraActivity.class);
    }


    public void toTextMajorInfo(View view) {
        scrollTextMajorInfo.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public void toTextRulesSamaneraObInfoPermissible(View view) {
        scrollTextRulesSamaneraObInfoPermissible.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public void toTextRulesSamaneraPurMoral(View view) {
        scrollTextRulesSamaneraPurMoral.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public void toTextRulesSamaneraUseMonksThings(View view) {
        scrollTextRulesSamaneraUseMonksThings.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public void toTextRulesSamaneraDirectionMind(View view) {
        scrollTextRulesSamaneraDirectionMind.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public void toTextRulesSamaneraTypesGoods(View view) {
        scrollTextRulesSamaneraTypesGoods.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public void toTextRulesSamaneraGarmony(View view) {
        scrollTextRulesSamaneraGarmony.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public void toTextRulesSamaneraCriticism(View view) {
        scrollTextRulesSamaneraCriticism.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public void toTextRulesSamaneraProtector(View view) {
        scrollTextRulesSamaneraProtector.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }

    public void toTextRulesSamaneraTo(View view) {
        scrollTextRulesSamaneraTo.setVisibility(View.VISIBLE);
        buttonHome.setVisibility(View.VISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.VISIBLE);
    }


    public void tobackRulesSamaneraProtocolAct(View view) {
        scrollTextMajorInfo.setVisibility(View.INVISIBLE);
        scrollTextRulesSamaneraObInfoPermissible.setVisibility(View.INVISIBLE);
        scrollTextRulesSamaneraPurMoral.setVisibility(View.INVISIBLE);
        scrollTextRulesSamaneraUseMonksThings.setVisibility(View.INVISIBLE);
        scrollTextRulesSamaneraDirectionMind.setVisibility(View.INVISIBLE);
        scrollTextRulesSamaneraTypesGoods.setVisibility(View.INVISIBLE);
        scrollTextRulesSamaneraGarmony.setVisibility(View.INVISIBLE);
        scrollTextRulesSamaneraCriticism.setVisibility(View.INVISIBLE);
        scrollTextRulesSamaneraProtector.setVisibility(View.INVISIBLE);
        scrollTextRulesSamaneraTo.setVisibility(View.INVISIBLE);
        buttonHome.setVisibility(View.INVISIBLE);
        buttonLiveToRulesSamanera.setVisibility(View.INVISIBLE);
    }
}