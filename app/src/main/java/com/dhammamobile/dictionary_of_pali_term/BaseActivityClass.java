package com.dhammamobile.dictionary_of_pali_term;

import android.app.AlertDialog;
import android.content.Context;
import android.content.DialogInterface;
import android.content.Intent;
import android.content.res.Configuration;
import android.media.MediaPlayer;
import android.os.Bundle;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;
import androidx.core.view.WindowCompat;
import androidx.core.view.WindowInsetsCompat;
import androidx.core.view.WindowInsetsControllerCompat;

import java.util.Locale;


public abstract class BaseActivityClass extends AppCompatActivity {
    private static final Locale APP_LOCALE = new Locale("ru");
    private MediaPlayer mediaPlayer;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        // Устанавливаем флаг, чтобы экран не гас
        getWindow().addFlags(WindowManager.LayoutParams.FLAG_KEEP_SCREEN_ON);

        super.onCreate(savedInstanceState);

        OrientationPreferenceHelper.apply(this);

        // Принудительно отключаем темную тему (чтобы не было багов на Xiaomi)
        androidx.appcompat.app.AppCompatDelegate.setDefaultNightMode(androidx.appcompat.app.AppCompatDelegate.MODE_NIGHT_NO);
    }

    protected void setWindowFlagsFullscreenAndNoLimits() {
        // Убрать строку состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Убрать панель навигации (если нужно)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    protected void enableEdgeToEdgeMode() {
        View decorView = getWindow().getDecorView();
        WindowCompat.setDecorFitsSystemWindows(getWindow(), false); // Важно!

        WindowInsetsControllerCompat controller = new WindowInsetsControllerCompat(getWindow(), decorView);
        controller.hide(WindowInsetsCompat.Type.systemBars()); // Скрыть навигацию + статус
        controller.setSystemBarsBehavior(WindowInsetsControllerCompat.BEHAVIOR_SHOW_TRANSIENT_BARS_BY_SWIPE);
    }

    @Override
    protected void attachBaseContext(Context newBase) {
        Locale.setDefault(APP_LOCALE);
        Configuration config = newBase.getResources().getConfiguration();
        config.setLocale(APP_LOCALE);
        Context context = newBase.createConfigurationContext(config);
        super.attachBaseContext(context);
    }

    @Override
    protected void onResume() {
        super.onResume();
        updateLocale();
    }

    protected void updateLocale() {
        Locale.setDefault(APP_LOCALE);
        Configuration config = getResources().getConfiguration();
        config.setLocale(APP_LOCALE);
        getResources().updateConfiguration(config, getResources().getDisplayMetrics());
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
