package com.dhammamobile.dictionary_of_pali_term.Suttas;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * WebViewClient с поддержкой автоматического адаптивного масштабирования для HTML файлов сутт
 */
public class AdaptiveWebViewClient extends WebViewClient {

    @Override
    public void onPageStarted(WebView view, String url, Bitmap favicon) {
        super.onPageStarted(view, url, favicon);
        WebViewLightHelper.apply(view);
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url.startsWith("file:///android_asset/")) {
            view.loadUrl(url);
            return true;
        }
        return false;
    }

    @Override
    public void onPageFinished(WebView view, String url) {
        super.onPageFinished(view, url);

        // На некоторых устройствах при быстрой смене ориентации Activity может быть
        // пересоздана, а WebView уничтожен. Защитимся от отложенной работы после destroy().
        view.postDelayed(() -> {
            try {
                if (view == null || !view.isAttachedToWindow()) return;
                injectAdaptiveStyles(view);
                if (view.getSettings() != null) {
                    view.getSettings().setSupportZoom(true);
                    view.getSettings().setBuiltInZoomControls(true);
                }
            } catch (Throwable ignored) {
                // Цель - не падать при ротации/закрытии.
            }
        }, 200);
    }

    private void injectAdaptiveStyles(WebView webView) {
        // Фиксируем светлую схему и оставляем масштабирование управляемым пользователем.
        // На MIUI тёмная тема может инвертировать страницу WebView, поэтому задаём явные light-ограничения.
        String js = "(function() {" +
                "var viewport = document.querySelector('meta[name=viewport]');" +
                "if (viewport) {" +
                "  viewport.remove();" +
                "}" +
                "viewport = document.createElement('meta');" +
                "viewport.name = 'viewport';" +
                // Минимальный viewport: только разрешаем масштабирование, без автоматических расчетов
                "viewport.content = 'width=device-width, initial-scale=0.7, minimum-scale=0.25, maximum-scale=2.0, user-scalable=yes';" +
                "var head = document.getElementsByTagName('head')[0];" +
                "if (head.firstChild) {" +
                "  head.insertBefore(viewport, head.firstChild);" +
                "} else {" +
                "  head.appendChild(viewport);" +
                "}" +
                "var colorSchemeMeta = document.querySelector('meta[name=color-scheme]');" +
                "if (!colorSchemeMeta) {" +
                "  colorSchemeMeta = document.createElement('meta');" +
                "  colorSchemeMeta.name = 'color-scheme';" +
                "  head.appendChild(colorSchemeMeta);" +
                "}" +
                "colorSchemeMeta.content = 'light only';" +
                "document.documentElement.style.setProperty('color-scheme', 'light', 'important');" +
                "if (document.body) {" +
                "  document.body.style.setProperty('color-scheme', 'light', 'important');" +
                "}" +
                "var style = document.createElement('style');" +
                "style.type = 'text/css';" +
                "style.textContent = " +
                // Не используем unset для всех элементов — это и давало «почернение» на части устройств.
                "'html, body {' +" +
                "'  color-scheme: light !important;' +" +
                "'  background-color: #f2f0cc !important;' +" +
                "'  color: #222222 !important;' +" +
                "'}' +" +
                "'img, picture, video, canvas, svg {' +" +
                "'  filter: none !important;' +" +
                "'  mix-blend-mode: normal !important;' +" +
                "'}' +" +
                "'body { word-wrap: break-word; overflow-wrap: break-word; }' +" +
                "'table { max-width: 100%; table-layout: auto; }' +" +
                "'td, th { word-wrap: break-word; overflow-wrap: break-word; }';" +
                "document.getElementsByTagName('head')[0].appendChild(style);" +
                "function makeTablesResponsive() {" +
                "  var tables = document.querySelectorAll('table[width]');" +
                "  tables.forEach(function(table) {" +
                "    var width = table.getAttribute('width');" +
                "    if (width && width.indexOf('px') !== -1) {" +
                "      var widthValue = parseInt(width);" +
                "      if (widthValue > 600) {" +
                "        if (!table.hasAttribute('data-original-width')) {" +
                "          table.setAttribute('data-original-width', width);" +
                "        }" +
                "        table.removeAttribute('width');" +
                "      }" +
                "    }" +
                "  });" +
                "}" +
                "makeTablesResponsive();" +
                "})();";

        try {
            webView.evaluateJavascript(js, null);
        } catch (Throwable ignored) {
            // Могут быть исключения при разрушенных/отключенных WebView.
        }
    }
}