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
        }, 100);
    }
    
    private void injectAdaptiveStyles(WebView webView) {
        // JavaScript код для добавления viewport meta тега и адаптивного CSS
        // Без фиксированных размеров, чтобы не блокировать жестовое масштабирование
        String js = "(function() {" +
                "var viewport = document.querySelector('meta[name=viewport]');" +
                "if (!viewport) {" +
                "  viewport = document.createElement('meta');" +
                "  viewport.name = 'viewport';" +
                "  document.getElementsByTagName('head')[0].appendChild(viewport);" +
                "}" +
                "viewport.content = 'width=device-width, initial-scale=1.0, minimum-scale=0.5, maximum-scale=5.0, user-scalable=yes';" +
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
                "      if (widthValue > 800) {" +
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
