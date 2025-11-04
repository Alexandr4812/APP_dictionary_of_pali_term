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

public class AbhidhammaChittasLokutaraWholsomeActivity extends BaseActivityClass {

    private TextView
            textViewAbhidhammaLokutaraWholsome1,
            textViewAbhidhammaLokutaraWholsome2,
            textViewAbhidhammaLokutaraWholsome3,
            textViewAbhidhammaLokutaraWholsome4;

    LinearLayout buttonInfo;
    Button plusText, minusText;
    WebView webView;


    private Button
            lokutaraWholsome1,
            lokutaraWholsome2,
            lokutaraWholsome3,
            lokutaraWholsome4,
            lokutaraWholsome5;




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
        setContentView(R.layout.activity_abhidhamma_chittas_lokutara_wholsome);

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

        webView = findViewById(R.id.webViewLokutaraWholsome);

        textViewAbhidhammaLokutaraWholsome1 = findViewById(R.id.textView_abhidhamma_lokutara_wholsome1);
        textViewAbhidhammaLokutaraWholsome2 = findViewById(R.id.textView_abhidhamma_lokutara_wholsome2);
        textViewAbhidhammaLokutaraWholsome3 = findViewById(R.id.textView_abhidhamma_lokutara_wholsome3);
        textViewAbhidhammaLokutaraWholsome4 = findViewById(R.id.textView_abhidhamma_lokutara_wholsome4);


        lokutaraWholsome1 = findViewById(R.id.button_abhidhamma_lokutara_wholsome1);
        lokutaraWholsome2 = findViewById(R.id.button_abhidhamma_lokutara_wholsome2);
        lokutaraWholsome3 = findViewById(R.id.button_abhidhamma_lokutara_wholsome3);
        lokutaraWholsome4 = findViewById(R.id.button_abhidhamma_lokutara_wholsome4);
        lokutaraWholsome5 = findViewById(R.id.button_abhidhamma_lokutara_wholsome5);


        koren1 = findViewById(R.id.button_abhidhamma_chittas_lokutara_wholsome_koren1);
        koren2 = findViewById(R.id.button_abhidhamma_chittas_lokutara_wholsome_koren2);
        koren3 = findViewById(R.id.button_abhidhamma_chittas_lokutara_wholsome_koren3);
        koren4 = findViewById(R.id.button_abhidhamma_chittas_lokutara_wholsome_koren4);

        funkciya1 = findViewById(R.id.button_abhidhamma_chittas_lokutara_wholsome_funkciya1);
        funkciya2 = findViewById(R.id.button_abhidhamma_chittas_lokutara_wholsome_funkciya2);
        funkciya3 = findViewById(R.id.button_abhidhamma_chittas_lokutara_wholsome_funkciya3);
        funkciya4 = findViewById(R.id.button_abhidhamma_chittas_lokutara_wholsome_funkciya4);

        kombinaciya1 = findViewById(R.id.button_abhidhamma_chittas_lokutara_wholsome_kombinaciya1);
        kombinaciya2 = findViewById(R.id.button_abhidhamma_chittas_lokutara_wholsome_kombinaciya2);
        kombinaciya3 = findViewById(R.id.button_abhidhamma_chittas_lokutara_wholsome_kombinaciya3);
        kombinaciya4 = findViewById(R.id.button_abhidhamma_chittas_lokutara_wholsome_kombinaciya4);

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

    public void onButtonClickAbhidhammaLokutaraWholsomeGroup5(View view) {
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

    public void onButtonClickAbhidhammaLokutaraWholsomeGroup1(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaLokutaraWholsome1.getVisibility();
        textViewAbhidhammaLokutaraWholsome1.setText("");
        textViewAbhidhammaLokutaraWholsome2.setText("");
        textViewAbhidhammaLokutaraWholsome3.setText("");
        textViewAbhidhammaLokutaraWholsome4.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaLokutaraWholsome1.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaLokutaraWholsome1.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == lokutaraWholsome1) {
                textViewAbhidhammaLokutaraWholsome1.setText(R.string.textLokutaraWholsome1);
                textViewAbhidhammaLokutaraWholsome1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraWholsome1, getString(R.string.textLokutaraWholsome1));
            } else if (clickedButton == koren1) {
                textViewAbhidhammaLokutaraWholsome1.setText(R.string.textLokutaraWholsomeKoren1);
                textViewAbhidhammaLokutaraWholsome1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraWholsome1, getString(R.string.textLokutaraWholsomeKoren1));
            } else if (clickedButton == funkciya1) {
                textViewAbhidhammaLokutaraWholsome1.setText(R.string.textLokutaraWholsomeFunkciya1);
                textViewAbhidhammaLokutaraWholsome1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraWholsome1, getString(R.string.textLokutaraWholsomeFunkciya1));
            } else if (clickedButton == kombinaciya1) {
                textViewAbhidhammaLokutaraWholsome1.setText(R.string.textLokutaraWholsomeKombinaciya1);
                textViewAbhidhammaLokutaraWholsome1.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraWholsome1, getString(R.string.textLokutaraWholsomeKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaLokutaraWholsomeGroup2(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaLokutaraWholsome2.getVisibility();
        textViewAbhidhammaLokutaraWholsome1.setText("");
        textViewAbhidhammaLokutaraWholsome2.setText("");
        textViewAbhidhammaLokutaraWholsome3.setText("");
        textViewAbhidhammaLokutaraWholsome4.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaLokutaraWholsome2.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaLokutaraWholsome2.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == lokutaraWholsome2) {
                textViewAbhidhammaLokutaraWholsome2.setText(R.string.textLokutaraWholsome2);
                textViewAbhidhammaLokutaraWholsome2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraWholsome2, getString(R.string.textLokutaraWholsome2));
            } else if (clickedButton == koren2) {
                textViewAbhidhammaLokutaraWholsome2.setText(R.string.textLokutaraWholsomeKoren1);
                textViewAbhidhammaLokutaraWholsome2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraWholsome2, getString(R.string.textLokutaraWholsomeKoren1));
            } else if (clickedButton == funkciya2) {
                textViewAbhidhammaLokutaraWholsome2.setText(R.string.textLokutaraWholsomeFunkciya1);
                textViewAbhidhammaLokutaraWholsome2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraWholsome2, getString(R.string.textLokutaraWholsomeFunkciya1));
            } else if (clickedButton == kombinaciya2) {
                textViewAbhidhammaLokutaraWholsome2.setText(R.string.textLokutaraWholsomeKombinaciya1);
                textViewAbhidhammaLokutaraWholsome2.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraWholsome2, getString(R.string.textLokutaraWholsomeKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaLokutaraWholsomeGroup3(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaLokutaraWholsome3.getVisibility();
        textViewAbhidhammaLokutaraWholsome1.setText("");
        textViewAbhidhammaLokutaraWholsome2.setText("");
        textViewAbhidhammaLokutaraWholsome3.setText("");
        textViewAbhidhammaLokutaraWholsome4.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaLokutaraWholsome3.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaLokutaraWholsome3.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == lokutaraWholsome3) {
                textViewAbhidhammaLokutaraWholsome3.setText(R.string.textLokutaraWholsome3);
                textViewAbhidhammaLokutaraWholsome3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraWholsome3, getString(R.string.textLokutaraWholsome3));
            } else if (clickedButton == koren3) {
                textViewAbhidhammaLokutaraWholsome3.setText(R.string.textLokutaraWholsomeKoren1);
                textViewAbhidhammaLokutaraWholsome3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraWholsome3, getString(R.string.textLokutaraWholsomeKoren1));
            } else if (clickedButton == funkciya3) {
                textViewAbhidhammaLokutaraWholsome3.setText(R.string.textLokutaraWholsomeFunkciya1);
                textViewAbhidhammaLokutaraWholsome3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraWholsome3, getString(R.string.textLokutaraWholsomeFunkciya1));
            } else if (clickedButton == kombinaciya3) {
                textViewAbhidhammaLokutaraWholsome3.setText(R.string.textLokutaraWholsomeKombinaciya1);
                textViewAbhidhammaLokutaraWholsome3.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraWholsome3, getString(R.string.textLokutaraWholsomeKombinaciya1));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaLokutaraWholsomeGroup4(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaLokutaraWholsome4.getVisibility();
        textViewAbhidhammaLokutaraWholsome1.setText("");
        textViewAbhidhammaLokutaraWholsome2.setText("");
        textViewAbhidhammaLokutaraWholsome3.setText("");
        textViewAbhidhammaLokutaraWholsome4.setText("");


        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaLokutaraWholsome4.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaLokutaraWholsome4.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == lokutaraWholsome4) {
                textViewAbhidhammaLokutaraWholsome4.setText(R.string.textLokutaraWholsome4);
                textViewAbhidhammaLokutaraWholsome4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraWholsome4, getString(R.string.textLokutaraWholsome4));
            } else if (clickedButton == koren4) {
                textViewAbhidhammaLokutaraWholsome4.setText(R.string.textLokutaraWholsomeKoren1);
                textViewAbhidhammaLokutaraWholsome4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraWholsome4, getString(R.string.textLokutaraWholsomeKoren1));
            } else if (clickedButton == funkciya4) {
                textViewAbhidhammaLokutaraWholsome4.setText(R.string.textLokutaraWholsomeFunkciya1);
                textViewAbhidhammaLokutaraWholsome4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraWholsome4, getString(R.string.textLokutaraWholsomeFunkciya1));
            } else if (clickedButton == kombinaciya4) {
                textViewAbhidhammaLokutaraWholsome4.setText(R.string.textLokutaraWholsomeKombinaciya1);
                textViewAbhidhammaLokutaraWholsome4.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraWholsome4, getString(R.string.textLokutaraWholsomeKombinaciya1));
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