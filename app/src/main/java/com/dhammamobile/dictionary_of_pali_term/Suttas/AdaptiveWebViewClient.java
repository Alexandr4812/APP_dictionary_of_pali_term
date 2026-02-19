package com.dhammamobile.dictionary_of_pali_term.Suttas;

import android.webkit.WebView;
import android.webkit.WebViewClient;

/**
 * WebViewClient с поддержкой автоматического адаптивного масштабирования для HTML файлов сутт
 */
public class AdaptiveWebViewClient extends WebViewClient {

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

        // Небольшая задержка для гарантии полной загрузки DOM
        view.postDelayed(() -> {
            // Инжектируем CSS и JavaScript для адаптивного масштабирования
            injectAdaptiveStyles(view);
            
            // Принудительно разрешаем масштабирование через WebView API
            // Это гарантирует, что жесты будут работать в обе стороны
            view.getSettings().setSupportZoom(true);
            view.getSettings().setBuiltInZoomControls(true);
        }, 200);
    }

    private void injectAdaptiveStyles(WebView webView) {
        // Финальный простой подход: минимальный viewport, который не блокирует жестовое масштабирование
        // Убираем все автоматические расчеты - пусть WebView сам управляет масштабированием
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
                "var style = document.createElement('style');" +
                "style.type = 'text/css';" +
                "style.textContent = " +
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

        webView.evaluateJavascript(js, null);
    }
}
