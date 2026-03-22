package com.dhammamobile.dictionary_of_pali_term.Suttas;

import android.graphics.Color;
import android.os.Build;
import android.webkit.WebSettings;
import android.webkit.WebView;

import androidx.webkit.WebSettingsCompat;
import androidx.webkit.WebViewFeature;

/**
 * Отключает принудительную тёмную тему в WebView (в т.ч. MIUI при системной тёмной теме).
 */
public final class WebViewLightHelper {

    private WebViewLightHelper() {
    }

    public static void apply(WebView webView) {
        if (webView == null) {
            return;
        }
        webView.setBackgroundColor(Color.WHITE);
        WebSettings settings = webView.getSettings();
        if (Build.VERSION.SDK_INT >= Build.VERSION_CODES.TIRAMISU) {
            settings.setForceDark(WebSettings.FORCE_DARK_OFF);
        } else if (WebViewFeature.isFeatureSupported(WebViewFeature.FORCE_DARK)) {
            WebSettingsCompat.setForceDark(settings, WebSettingsCompat.FORCE_DARK_OFF);
        }
    }
}
