package com.dhammamobile.dictionary_of_pali_term.Abhidhamma;

import android.animation.Animator;
import android.animation.AnimatorListenerAdapter;
import android.animation.ValueAnimator;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.TextView;

import androidx.activity.EdgeToEdge;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

import java.util.Locale;

public class AbhidhammaChittasLokutaraResultActivity extends BaseActivityClass {

    private TextView
            textViewAbhidhammaLokutaraResult1,
            textViewAbhidhammaLokutaraResult2,
            textViewAbhidhammaLokutaraResult3,
            textViewAbhidhammaLokutaraResult4;

    LinearLayout buttonInfo;
    Button plusText, minusText;
    WebView webView;


    private Button
            lokutaraResult1,
            lokutaraResult2,
            lokutaraResult3,
            lokutaraResult4,
            lokutaraResult5;





    private Button
            koren1,
            koren2,
            koren3,
            koren4,
            funkciya1,
            funkciya2,
            funkciya3,
            funkciya4,
            kombinaciya1,
            kombinaciya2,
            kombinaciya3,
            kombinaciya4;

    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_abhidhamma_chittas_lokutara_result);

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        plusText = findViewById(R.id.buttonPlusTextLiveBuddha);
        minusText = findViewById(R.id.buttonMinusTextLiveBuddha);

        buttonInfo = findViewById(R.id.button_layout_live_buddha);

        webView = findViewById(R.id.webViewLokutaraResult);

        textViewAbhidhammaLokutaraResult1 = findViewById(R.id.textView_abhidhamma_lokutara_result1);
        textViewAbhidhammaLokutaraResult2 = findViewById(R.id.textView_abhidhamma_lokutara_result2);
        textViewAbhidhammaLokutaraResult3 = findViewById(R.id.textView_abhidhamma_lokutara_result3);
        textViewAbhidhammaLokutaraResult4 = findViewById(R.id.textView_abhidhamma_lokutara_result4);


        lokutaraResult1 = findViewById(R.id.button_abhidhamma_lokutara_result1);
        lokutaraResult2 = findViewById(R.id.button_abhidhamma_lokutara_result2);
        lokutaraResult3 = findViewById(R.id.button_abhidhamma_lokutara_result3);
        lokutaraResult4 = findViewById(R.id.button_abhidhamma_lokutara_result4);
        lokutaraResult5 = findViewById(R.id.button_abhidhamma_lokutara_result5);



        koren1 = findViewById(R.id.button_abhidhamma_chittas_lokutara_result_koren1);
        koren2 = findViewById(R.id.button_abhidhamma_chittas_lokutara_result_koren2);
        koren3 = findViewById(R.id.button_abhidhamma_chittas_lokutara_result_koren3);
        koren4 = findViewById(R.id.button_abhidhamma_chittas_lokutara_result_koren4);

        funkciya1 = findViewById(R.id.button_abhidhamma_chittas_lokutara_result_funkciya1);
        funkciya2 = findViewById(R.id.button_abhidhamma_chittas_lokutara_result_funkciya2);
        funkciya3 = findViewById(R.id.button_abhidhamma_chittas_lokutara_result_funkciya3);
        funkciya4 = findViewById(R.id.button_abhidhamma_chittas_lokutara_result_funkciya4);

        kombinaciya1 = findViewById(R.id.button_abhidhamma_chittas_lokutara_result_kombinaciya1);
        kombinaciya2 = findViewById(R.id.button_abhidhamma_chittas_lokutara_result_kombinaciya2);
        kombinaciya3 = findViewById(R.id.button_abhidhamma_chittas_lokutara_result_kombinaciya3);
        kombinaciya4 = findViewById(R.id.button_abhidhamma_chittas_lokutara_result_kombinaciya4);

        // Настройки WebView
        WebSettings webSettings = webView.getSettings();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.clearCache(true);

        // Обработчики нажатий кнопок для увеличения/уменьшения шрифта
        plusText.setOnClickListener(v -> {
            webView.evaluateJavascript("javascript:increaseFontSize();", null);
        });

        minusText.setOnClickListener(v -> {
            webView.evaluateJavascript("javascript:decreaseFontSize();", null);
        });
    }

    private void loadHtmlPage(String htmlFilePath) {
        webView.loadUrl(htmlFilePath);
    }

    public void onButtonClickAbhidhammaLokutaraResultGroup5(View view) {
        buttonInfo.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        String htmlFilePath;
        String currentLanguage = Locale.getDefault().getLanguage();
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/info_rupavachara_arupavachara_lokutara_ru/121_conscience_ru.html";
        } else {
            htmlFilePath = "file:///android_asset/info_rupavachara_arupavachara_lokutara_en/121_conscience_en.html";
        }
        loadHtmlPage(htmlFilePath);
    }

    public void onButtonClickAbhidhammaLokutaraResultGroup1(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaLokutaraResult1.getVisibility();
        textViewAbhidhammaLokutaraResult1.setText("");
        textViewAbhidhammaLokutaraResult2.setText("");
        textViewAbhidhammaLokutaraResult3.setText("");
        textViewAbhidhammaLokutaraResult4.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaLokutaraResult1.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaLokutaraResult1.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == lokutaraResult1) {
                textViewAbhidhammaLokutaraResult1.setText(R.string.textLokutaraResult1);
                textViewAbhidhammaLokutaraResult1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraResult1, getString(R.string.textLokutaraResult1));
            } else if (clickedButton == koren1) {
                textViewAbhidhammaLokutaraResult1.setText(R.string.textLokutaraResultKoren1);
                textViewAbhidhammaLokutaraResult1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraResult1, getString(R.string.textLokutaraResultKoren1));
            } else if (clickedButton == funkciya1) {
                textViewAbhidhammaLokutaraResult1.setText(R.string.textLokutaraResultFunkciya1);
                textViewAbhidhammaLokutaraResult1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraResult1, getString(R.string.textLokutaraResultFunkciya1));
            } else if (clickedButton == kombinaciya1) {
                textViewAbhidhammaLokutaraResult1.setText(R.string.textLokutaraResultKombinaciya1);
                textViewAbhidhammaLokutaraResult1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraResult1, getString(R.string.textLokutaraResultKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaLokutaraResultGroup2(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaLokutaraResult2.getVisibility();
        textViewAbhidhammaLokutaraResult1.setText("");
        textViewAbhidhammaLokutaraResult2.setText("");
        textViewAbhidhammaLokutaraResult3.setText("");
        textViewAbhidhammaLokutaraResult4.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaLokutaraResult2.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaLokutaraResult2.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == lokutaraResult2) {
                textViewAbhidhammaLokutaraResult2.setText(R.string.textLokutaraResult1);
                textViewAbhidhammaLokutaraResult2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraResult2, getString(R.string.textLokutaraResult1));
            } else if (clickedButton == koren2) {
                textViewAbhidhammaLokutaraResult2.setText(R.string.textLokutaraResultKoren1);
                textViewAbhidhammaLokutaraResult2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraResult2, getString(R.string.textLokutaraResultKoren1));
            } else if (clickedButton == funkciya2) {
                textViewAbhidhammaLokutaraResult2.setText(R.string.textLokutaraResultFunkciya1);
                textViewAbhidhammaLokutaraResult2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraResult2, getString(R.string.textLokutaraResultFunkciya1));
            } else if (clickedButton == kombinaciya2) {
                textViewAbhidhammaLokutaraResult2.setText(R.string.textLokutaraResultKombinaciya1);
                textViewAbhidhammaLokutaraResult2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraResult2, getString(R.string.textLokutaraResultKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaLokutaraResultGroup3(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaLokutaraResult3.getVisibility();
        textViewAbhidhammaLokutaraResult1.setText("");
        textViewAbhidhammaLokutaraResult2.setText("");
        textViewAbhidhammaLokutaraResult3.setText("");
        textViewAbhidhammaLokutaraResult4.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaLokutaraResult3.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaLokutaraResult3.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == lokutaraResult3) {
                textViewAbhidhammaLokutaraResult3.setText(R.string.textLokutaraResult1);
                textViewAbhidhammaLokutaraResult3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraResult3, getString(R.string.textLokutaraResult1));
            } else if (clickedButton == koren3) {
                textViewAbhidhammaLokutaraResult3.setText(R.string.textLokutaraResultKoren1);
                textViewAbhidhammaLokutaraResult3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraResult3, getString(R.string.textLokutaraResultKoren1));
            } else if (clickedButton == funkciya3) {
                textViewAbhidhammaLokutaraResult3.setText(R.string.textLokutaraResultFunkciya1);
                textViewAbhidhammaLokutaraResult3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraResult3, getString(R.string.textLokutaraResultFunkciya1));
            } else if (clickedButton == kombinaciya3) {
                textViewAbhidhammaLokutaraResult3.setText(R.string.textLokutaraResultKombinaciya1);
                textViewAbhidhammaLokutaraResult3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraResult3, getString(R.string.textLokutaraResultKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaLokutaraResultGroup4(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaLokutaraResult4.getVisibility();
        textViewAbhidhammaLokutaraResult1.setText("");
        textViewAbhidhammaLokutaraResult2.setText("");
        textViewAbhidhammaLokutaraResult3.setText("");
        textViewAbhidhammaLokutaraResult4.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaLokutaraResult4.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaLokutaraResult4.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == lokutaraResult4) {
                textViewAbhidhammaLokutaraResult4.setText(R.string.textLokutaraResult1);
                textViewAbhidhammaLokutaraResult4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraResult4, getString(R.string.textLokutaraResult1));
            } else if (clickedButton == koren4) {
                textViewAbhidhammaLokutaraResult4.setText(R.string.textLokutaraResultKoren1);
                textViewAbhidhammaLokutaraResult4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraResult4, getString(R.string.textLokutaraResultKoren1));
            } else if (clickedButton == funkciya4) {
                textViewAbhidhammaLokutaraResult4.setText(R.string.textLokutaraResultFunkciya1);
                textViewAbhidhammaLokutaraResult4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraResult4, getString(R.string.textLokutaraResultFunkciya1));
            } else if (clickedButton == kombinaciya4) {
                textViewAbhidhammaLokutaraResult4.setText(R.string.textLokutaraResultKombinaciya1);
                textViewAbhidhammaLokutaraResult4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraResult4, getString(R.string.textLokutaraResultKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }


    private void animateText(TextView targetTextView, String textToAnimate) {
        animator = ValueAnimator.ofInt(0, textToAnimate.length());
        animator.setDuration(1000); // Продолжительность анимации в миллисекундах
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

    private void resetAnimator() {
        // Остановить и сбросить аниматор
        if (animator != null) {
            animator.cancel();
        }
    }

    public void toAbhidhammaChittasLokutara(View view){
        startIntentActivityAndFinish(AbhidhammaChittasLokutaraActivity.class);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toLiveBack(View view){
        webView.setVisibility(View.INVISIBLE);
        buttonInfo.setVisibility(View.INVISIBLE);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(AbhidhammaChittasLokutaraActivity.class);
    }
}