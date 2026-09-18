package com.dhammamobile.dictionary_of_pali_term.LiveBuddha;

import android.annotation.SuppressLint;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.os.Bundle;
import android.util.Log;
import android.view.View;
import android.view.WindowManager;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;
import android.widget.LinearLayout;
import android.widget.Toast;

import androidx.activity.OnBackPressedCallback;
import androidx.core.graphics.Insets;
import androidx.core.view.ViewCompat;
import androidx.core.view.WindowInsetsCompat;

import com.dhammamobile.dictionary_of_pali_term.BaseActivityClass;
import com.dhammamobile.dictionary_of_pali_term.MainActivity;
import com.dhammamobile.dictionary_of_pali_term.R;

import java.util.Locale;

import android.graphics.drawable.GradientDrawable;
import android.widget.ImageView;
import android.widget.ScrollView;
import androidx.core.content.ContextCompat;
import java.util.ArrayList;
import java.util.List;
import android.widget.ImageButton;

public class LiveBuddhaActivity extends BaseActivityClass {
    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
        // Здесь вы можете добавить свои действия при изменении ориентации, если это необходимо
    }
    int savedScrollY = 0;
    private String currentHtmlFilePath; // полный путь к HTML
    private String getBookmarkKeyFromPath(String fullPath) {
        return fullPath.replace("file:///android_asset/", "");
    }

    ScrollView mainScroll, thumbScroll;
    LinearLayout thumbColumn;
    private final List<View> storyCards = new ArrayList<>();
    private ImageView activeThumbView;
    private String activeTag = "";
    ImageButton thumbToggle;

    LinearLayout buttonBuddha;
    Button plusText, minusText, buttonZakladka;
    WebView webView;

    @SuppressLint("SetJavaScriptEnabled")
    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_live_buddha);

       // setWindowFlagsFullscreenAndNoLimits();

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

        webView = findViewById(R.id.webViewLiveBuddha);

        buttonBuddha = findViewById(R.id.button_layout_live_buddha);

        mainScroll = findViewById(R.id.viewScrollDeclomation);
        thumbScroll = findViewById(R.id.thumbScroll);
        thumbColumn = findViewById(R.id.thumbColumn);
        buildThumbColumn();
        mainScroll.setOnScrollChangeListener((v, sx, sy, oldSx, oldSy) -> updateActiveThumb());
        mainScroll.post(this::updateActiveThumb);

        // Настройки WebView
        WebSettings webSettings = webView.getSettings();
        webView.getSettings().setJavaScriptEnabled(true);
        webView.clearCache(true);

        thumbToggle = findViewById(R.id.thumbToggle);
        boolean thumbsVisible = getSharedPreferences("ui", MODE_PRIVATE).getBoolean("thumbsVisible", false);
        thumbScroll.setVisibility(thumbsVisible ? View.VISIBLE : View.GONE);
        thumbToggle.setRotation(thumbsVisible ? 0f : 180f); // стрелка смотрит по действию

        // Обработчики нажатий кнопок для увеличения/уменьшения шрифта
        plusText.setOnClickListener(v -> {
            webView.evaluateJavascript("javascript:increaseFontSize();", null);
        });

        minusText.setOnClickListener(v -> {
            webView.evaluateJavascript("javascript:decreaseFontSize();", null);
        });

        getOnBackPressedDispatcher().addCallback(this, new OnBackPressedCallback(true) {
            @Override
            public void handleOnBackPressed() {
                // Вместо закрытия — переходим на главную
                startIntentActivityAndFinish(MainActivity.class);
            }
        });

    }

    private void saveScrollPosition() {
        if (currentHtmlFilePath == null) return;

        webView.evaluateJavascript("window.scrollY.toString()", value -> {
            try {
                if (value == null || value.equals("null") || value.equals("")) return;

                value = value.replaceAll("\"", "");
                float scrollYFloat = Float.parseFloat(value);
                int scrollY = Math.round(scrollYFloat);

                SharedPreferences prefs = getSharedPreferences("Bookmarks", MODE_PRIVATE);
                String key = getBookmarkKeyFromPath(currentHtmlFilePath);
                prefs.edit().putInt("scroll_" + key, scrollY).apply();

            } catch (NumberFormatException e) {
                e.printStackTrace();
            }
        });
    }

    private void loadHtmlPage(String htmlFilePath) {
        currentHtmlFilePath = htmlFilePath;

        // Получаем сохранённую позицию
        SharedPreferences prefs = getSharedPreferences("Bookmarks", MODE_PRIVATE);
        String key = getBookmarkKeyFromPath(htmlFilePath);
        savedScrollY = prefs.getInt("scroll_" + key, 0);

        webView.loadUrl(htmlFilePath);

        // После полной загрузки страницы — прокручиваем
        webView.setWebViewClient(new WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                // Устанавливаем позицию с небольшой задержкой
                webView.postDelayed(() -> {
                    webView.evaluateJavascript(
                            "window.scrollTo({ top: " + savedScrollY + ", behavior: 'smooth' });",
                            null);

                }, 100);
            }
        });
    }

    public void showHtmlByNumber(View view) {
        Object tagObj = view.getTag();
        if (tagObj == null) return;

        String tag = tagObj.toString();
        String currentLanguage = Locale.getDefault().getLanguage();

        String htmlFilePath;
        if (currentLanguage.equals("ru")) {
            htmlFilePath = "file:///android_asset/live_1_ru/live" + tag + ".html";
        } else {
            htmlFilePath = "file:///android_asset/live_1_en/liveEn" + tag + ".html";
        }

        buttonBuddha.setVisibility(View.VISIBLE);
        webView.setVisibility(View.VISIBLE);
        loadHtmlPage(htmlFilePath);
    }

    public void toMainAct(View view){
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toLiveBack(View view){
        saveScrollPosition();
        webView.setVisibility(View.INVISIBLE);
        buttonBuddha.setVisibility(View.INVISIBLE);
    }

    private int dp(int value) {
        return Math.round(value * getResources().getDisplayMetrics().density);
    }

    // Строим колонку миниатюр из уже существующих CardView основного списка
    private void buildThumbColumn() {
        LinearLayout mainList = (LinearLayout) mainScroll.getChildAt(0);
        for (int i = 0; i < mainList.getChildCount(); i++) {
            View child = mainList.getChildAt(i);
            if (!(child instanceof androidx.cardview.widget.CardView) || child.getTag() == null) continue;
            storyCards.add(child);

            ImageView source = (ImageView) ((androidx.cardview.widget.CardView) child).getChildAt(0);
            ImageView thumb = new ImageView(this);
            thumb.setTag(child.getTag());
            thumb.setScaleType(ImageView.ScaleType.CENTER_CROP);
            thumb.setImageDrawable(source.getDrawable());
            thumb.setContentDescription("Перейти к истории " + child.getTag());

            GradientDrawable bg = new GradientDrawable();
            bg.setCornerRadius(dp(8));
            bg.setColor(0x00000000);
            thumb.setBackground(bg);
            thumb.setClipToOutline(true); // скругляем углы миниатюры

            LinearLayout.LayoutParams lp = new LinearLayout.LayoutParams(
                    LinearLayout.LayoutParams.MATCH_PARENT, dp(40));
            lp.setMargins(dp(6), dp(3), dp(6), dp(3));
            thumb.setLayoutParams(lp);
            thumb.setAlpha(0.45f);
            thumb.setOnClickListener(this::jumpToStory);
            thumbColumn.addView(thumb);
        }
    }

    // Нажатие на миниатюру — плавно прокручиваем основной список к истории
    public void jumpToStory(View thumbView) {
        Object tagObj = thumbView.getTag();
        if (tagObj == null) return;
        View target = mainScroll.findViewWithTag(tagObj.toString());
        if (target == null) return;
        mainScroll.smoothScrollTo(0, Math.max(0, target.getTop() - dp(4)));
    }

    // Определяем, какая история сейчас на экране, и подсвечиваем её миниатюру
    private void updateActiveThumb() {
        if (storyCards.isEmpty()) return;
        int probe = mainScroll.getScrollY() + mainScroll.getHeight() / 3;
        String tag = (String) storyCards.get(0).getTag();
        for (View card : storyCards) {
            if (card.getTop() <= probe) tag = (String) card.getTag();
            else break;
        }
        // если доскроллили до самого низа — активна последняя история
        if (mainScroll.getScrollY() + mainScroll.getHeight() >= mainScroll.getChildAt(0).getHeight() - dp(8)) {
            tag = (String) storyCards.get(storyCards.size() - 1).getTag();
        }
        setActiveThumb(tag, true);
    }

    private void setActiveThumb(String tag, boolean centerColumn) {
        if (tag.equals(activeTag)) return;
        activeTag = tag;
        if (activeThumbView != null) {
            activeThumbView.setAlpha(0.45f);
            activeThumbView.setPadding(0, 0, 0, 0);
            ((GradientDrawable) activeThumbView.getBackground()).setColor(0x00000000);
        }
        View v = thumbColumn.findViewWithTag(tag);
        if (!(v instanceof ImageView)) return;
        activeThumbView = (ImageView) v;
        activeThumbView.setAlpha(1f);
        activeThumbView.setPadding(dp(2), dp(2), dp(2), dp(2)); // рамка за счёт фона
        ((GradientDrawable) activeThumbView.getBackground())
                .setColor(ContextCompat.getColor(this, R.color.my_text_bacground_color));
        if (centerColumn) {
            thumbScroll.smoothScrollTo(0, activeThumbView.getTop()
                    - thumbScroll.getHeight() / 2 + activeThumbView.getHeight() / 2);
        }
    }

    // Показать/скрыть боковую колонку миниатюр с анимацией
    public void toggleThumbColumn(View v) {
        boolean show = thumbScroll.getVisibility() != View.VISIBLE;
        getSharedPreferences("ui", MODE_PRIVATE).edit().putBoolean("thumbsVisible", show).apply();
        thumbToggle.setRotation(show ? 0f : 180f);

        float off = dp(64); // ширина колонки
        if (show) {
            thumbScroll.setVisibility(View.VISIBLE);
            thumbScroll.setTranslationX(off);
            thumbToggle.setTranslationX(off);
            thumbScroll.animate().translationX(0).setDuration(180).start();
            thumbToggle.animate().translationX(0).setDuration(180).start();
        } else {
            thumbScroll.animate().translationX(off).setDuration(180)
                    .withEndAction(() -> {
                        thumbScroll.setVisibility(View.GONE);
                        thumbScroll.setTranslationX(0);
                    }).start();
            thumbToggle.animate().translationX(off).setDuration(180)
                    .withEndAction(() -> thumbToggle.setTranslationX(0)).start();
        }
    }


}