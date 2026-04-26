package com.dhammamobile.dictionary_of_pali_term;

import android.app.Activity;
import android.content.Context;
import android.content.pm.ActivityInfo;

/**
 * Сохраняет и применяет режим ориентации экрана для приложения.
 */
public final class OrientationPreferenceHelper {

    private static final String PREFS_NAME = "app_settings";
    private static final String KEY_ORIENTATION = "screen_orientation_mode";

    public static final String MODE_PORTRAIT = "portrait";
    public static final String MODE_LANDSCAPE = "landscape";
    public static final String MODE_SENSOR = "sensor";

    private OrientationPreferenceHelper() {
    }

    public static void apply(Activity activity) {
        if (activity == null) {
            return;
        }
        String mode = activity.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE)
                .getString(KEY_ORIENTATION, MODE_SENSOR);
        int orientation = ActivityInfo.SCREEN_ORIENTATION_FULL_SENSOR;
        if (MODE_PORTRAIT.equals(mode)) {
            orientation = ActivityInfo.SCREEN_ORIENTATION_PORTRAIT;
        } else if (MODE_LANDSCAPE.equals(mode)) {
            orientation = ActivityInfo.SCREEN_ORIENTATION_LANDSCAPE;
        }
        activity.setRequestedOrientation(orientation);
    }

    public static void saveAndApply(Activity activity, String mode) {
        if (activity == null) {
            return;
        }
        activity.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE).edit()
                .putString(KEY_ORIENTATION, mode)
                .apply();
        apply(activity);
    }
}
