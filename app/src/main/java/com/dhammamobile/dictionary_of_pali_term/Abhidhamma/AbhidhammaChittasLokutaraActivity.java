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

public class AbhidhammaChittasLokutaraActivity extends BaseActivityClass {


    private TextView textViewAbhidhammaLokutaraWholsome;

    private Button infoButtonAbhidhammaLokutaraWholsome;

    private TextView textViewAbhidhammaLokutaraVipaka;

    private Button infoButtonAbhidhammaLokutaraVipaka;


    // Переменная для хранения последней нажатой кнопки
    private Button lastClickedButton = null;

    private ValueAnimator animator;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        updateLocale(); // Установка языка
        setContentView(R.layout.activity_abhidhamma_chittas_lokutara);

        // setWindowFlagsFullscreenAndNoLimits();

        enableEdgeToEdgeMode();

        // Скрытие панели навигации и панели состояния
        View rootView = findViewById(android.R.id.content);
        ViewCompat.setOnApplyWindowInsetsListener(rootView, (v, insets) -> {
            Insets navInsets = insets.getInsets(WindowInsetsCompat.Type.navigationBars());
            v.setPadding(0, 0, 0, navInsets.bottom); // Учитываем панель навигации
            return insets;
        });

        textViewAbhidhammaLokutaraWholsome = findViewById(R.id.textViewAbhidhammaLokutaraWholsome);
        infoButtonAbhidhammaLokutaraWholsome = findViewById(R.id.infoButtonLokutaraWholsome);

        textViewAbhidhammaLokutaraVipaka = findViewById(R.id.textViewAbhidhammaLokutaraResult);
        infoButtonAbhidhammaLokutaraVipaka = findViewById(R.id.infoButtonLokutaraResult);
    }



    public void onButtonClickAbhidhammaLokutaraWholsome(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaLokutaraWholsome.getVisibility();
        textViewAbhidhammaLokutaraWholsome.setText("");
        textViewAbhidhammaLokutaraVipaka.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaLokutaraWholsome.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaLokutaraWholsome.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaLokutaraWholsome) {
                textViewAbhidhammaLokutaraWholsome.setText(R.string.textDiscribeLokutaraWholsome);
                textViewAbhidhammaLokutaraWholsome.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraWholsome, getString(R.string.textDiscribeLokutaraWholsome));
            }
            lastClickedButton = clickedButton; // Сохраняем последнюю нажатую кнопку
        }
    }

    public void onButtonClickAbhidhammaLokutaraResult(View view) {
        Button clickedButton = (Button) view;
        int visibility = textViewAbhidhammaLokutaraVipaka.getVisibility();
        textViewAbhidhammaLokutaraWholsome.setText("");
        textViewAbhidhammaLokutaraVipaka.setText("");

        // Если нажата та же кнопка, что и ранее
        if (clickedButton == lastClickedButton && visibility == View.VISIBLE) {
            textViewAbhidhammaLokutaraVipaka.setText(""); // Установите текст в пустую строку
            textViewAbhidhammaLokutaraVipaka.setVisibility(View.INVISIBLE);
            resetAnimator();
        } else {
            if (clickedButton == infoButtonAbhidhammaLokutaraVipaka) {
                textViewAbhidhammaLokutaraVipaka.setText(R.string.textDiscribeLokutaraResult);
                textViewAbhidhammaLokutaraVipaka.setVisibility(View.VISIBLE);
                animateText(textViewAbhidhammaLokutaraVipaka, getString(R.string.textDiscribeLokutaraResult));
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

    public void toAbhidhammaChittasAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasActivity.class);
    }

    public void toAbhidhammaChittasLokutaraWholsomeAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasLokutaraWholsomeActivity.class);
    }

    public void toAbhidhammaChittasLokutaraResultAct(View view){
        startIntentActivityAndFinish(AbhidhammaChittasLokutaraResultActivity.class);
    }


    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }


    @Override
    public void onBackPressed() {
        super.onBackPressed();
        startIntentActivityAndFinish(AbhidhammaChittasActivity.class);
    }
}