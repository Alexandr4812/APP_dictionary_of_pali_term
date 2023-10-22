package com.dhammamobile.dictionary_of_pali_term;

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

    @Override
    public <T extends View> T findViewById(@IdRes int id) {
        T view = super.findViewById(id);
        view.setOnDragListener(null);
        return view;
    }


}
