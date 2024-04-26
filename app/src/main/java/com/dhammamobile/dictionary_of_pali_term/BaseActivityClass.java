package com.dhammamobile.dictionary_of_pali_term;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.SharedPreferences;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.text.TextUtils;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

import java.util.Locale;

public abstract class BaseActivityClass extends AppCompatActivity {
    protected static final String LANGUAGE_PREF_KEY = "LANGUAGE_PREF_KEY";
    private MediaPlayer mediaPlayer;
    protected void setWindowFlagsFullscreenAndNoLimits() {
        // Убрать строку состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Убрать панель навигации (если нужно)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateLocale();
    }

    protected void updateLocale() {
        // Получаем сохраненный язык, если он есть, иначе устанавливаем русский язык по умолчанию
        String savedLanguage = getSavedLanguage();
        Locale locale;
        if (!TextUtils.isEmpty(savedLanguage)) {
            locale = new Locale(savedLanguage);
        } else {
            locale = new Locale("ru");
        }

        Locale.setDefault(locale);
        Configuration config = new Configuration();
        config.locale = locale;
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
    }

    protected String getSavedLanguage() {
        SharedPreferences preferences = getSharedPreferences("locale", Context.MODE_PRIVATE);
        return preferences.getString(LANGUAGE_PREF_KEY, "");
    }

    protected void saveLanguage(String language) {
        SharedPreferences preferences = getSharedPreferences("locale", Context.MODE_PRIVATE);
        SharedPreferences.Editor editor = preferences.edit();
        editor.putString(LANGUAGE_PREF_KEY, language);
        editor.apply();
    }

    protected void startIntentActivityAndFinish(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
        finish();
        if (this.mediaPlayer != null) this.mediaPlayer.stop();
    }


    protected void saveLastVisitedPage(String url) {
        if (!url.isEmpty()) {
            getSharedPreferences("MyPrefs", MODE_PRIVATE)
                    .edit()
                    .putString("last_visited_page", url)
                    .apply();
        }
    }

    @Override
    public <T extends View> T findViewById(@IdRes int id) {
        T view = super.findViewById(id);
        view.setOnDragListener(null);
        return view;
    }

    protected void showConfirmationDialog() {
        AlertDialog.Builder builder = new AlertDialog.Builder(this);
        builder.setMessage("Вы уверены, что хотите закрыть приложение?");
        builder.setPositiveButton("Да", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                finish(); // Закрыть активность и приложение
            }
        });
        builder.setNegativeButton("Отмена", new DialogInterface.OnClickListener() {
            @Override
            public void onClick(DialogInterface dialog, int which) {
                // Пользователь отменил закрытие приложения
            }
        });
        AlertDialog dialog = builder.create();
        dialog.show();
    }


}
