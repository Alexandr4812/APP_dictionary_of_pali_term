package com.dhammamobile.dictionary_of_pali_term;

import android.app.AlertDialog;
import android.content.DialogInterface;
import android.content.Intent;
import android.view.View;
import android.view.WindowManager;

import androidx.annotation.IdRes;
import androidx.appcompat.app.AppCompatActivity;

public abstract class BaseActivityClass extends AppCompatActivity {
    protected void setWindowFlagsFullscreenAndNoLimits() {
        // Убрать строку состояния
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_FULLSCREEN, WindowManager.LayoutParams.FLAG_FULLSCREEN);
        // Убрать панель навигации (если нужно)
        getWindow().setFlags(WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS, WindowManager.LayoutParams.FLAG_LAYOUT_NO_LIMITS);
    }

    protected void startIntentActivityAndFinish(Class<?> cls) {
        Intent intent = new Intent(this, cls);
        startActivity(intent);
        finish();
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
