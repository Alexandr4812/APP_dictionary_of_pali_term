package com.dhammamobile.dictionary_of_pali_term.Suttas;

import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.core.content.ContextCompat;
import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;

import com.dhammamobile.dictionary_of_pali_term.R;

/**
 * Отключает принудительную тёмную тему в WebView (в т.ч. MIUI при системной тёмной теме)
 * и задаёт непрозрачный фон как у экрана — прозрачный WebView на части устройств даёт «рваную» картинку.
 */
public final class WebViewLightHelper {

    private WebViewLightHelper() {
    }

    public static void apply(WebView webView) {
        if (webView == null) {
            return;
        }
        webView.setBackgroundColor(ContextCompat.getColor(webView.getContext(), R.color.my_main_color));
        WebSettings settings = webView.getSettings();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            settings.setForceDark(WebSettings.FORCE_DARK_OFF);
        } else if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
            WebSettingsCompat.setForceDark(settings, WebSettingsCompat.FORCE_DARK_OFF);
        }
        if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK_STRATEGY)) {
            WebSettingsCompat.setForceDarkStrategy(
                    settings,
                    WebSettingsCompat.DARK_STRATEGY_USER_AGENT_DARKENING_ONLY
            );
        }
        if (WebViewFeature.isFeatureSupported(WebViewFeature.ALGORITHMIC_DARKENING)) {
            WebSettingsCompat.setAlgorithmicDarkeningAllowed(settings, false);
        }
    }
}
