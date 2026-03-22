package com.dhammamobile.dictionary_of_pali_term;

import android.app.Application;
import android.content.SharedPreferences;

import androidx.appcompat.app.AppCompatDelegate;
import androidx.core.os.LocaleListCompat;

public class DhammaApplication extends Application {

    private static final String LOCALE_PREFS = "locale";
    private static final String LEGACY_LANGUAGE_PREF_KEY = "LANGUAGE_PREF_KEY";

    @Override
    public void onCreate() {
        super.onCreate();
        AppCompatDelegate.setDefaultNightMode(AppCompatDelegate.MODE_NIGHT_NO);
        AppCompatDelegate.setApplicationLocales(LocaleListCompat.forLanguageTags("ru"));
        SharedPreferences p = getSharedPreferences(LOCALE_PREFS, MODE_PRIVATE);
        if (p.contains(LEGACY_LANGUAGE_PREF_KEY)) {
            p.edit().remove(LEGACY_LANGUAGE_PREF_KEY).apply();
        }
    }
}
