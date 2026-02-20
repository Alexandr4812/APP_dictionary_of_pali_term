package com.dhammamobile.dictionary_of_pali_term.Suttas; // <-- замени на свой package

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity для экрана закладок.
 * Загружает bookmarks.html из assets и передаёт данные закладок.
 *
 * В AndroidManifest.xml добавь:
 *   <activity android:name=".BookmarksActivity" />
 */
public class BookmarksActivity extends AppCompatActivity {

    private WebView         webView;
    private BookmarkManager bookmarkManager;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);

        webView = new WebView(this);
        setContentView(webView);

        bookmarkManager = new BookmarkManager(this);

        // Настройки WebView
        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);

        // Подключаем JS-интерфейс
        BookmarkJsInterface jsInterface = new BookmarkJsInterface(this, bookmarkManager, webView);
        webView.addJavascriptInterface(jsInterface, "Android");

        // Загружаем страницу закладок из assets
        webView.loadUrl("file:///android_asset/bookmarks.html");

        // После загрузки страницы передаём данные закладок в JS
        webView.setWebViewClient(new android.webkit.WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                loadBookmarksIntoPage();
            }
        });
    }

    /** Передаёт JSON закладок в JavaScript на странице */
    private void loadBookmarksIntoPage() {
        String json = bookmarkManager.getAllAsJsonString();
        // Экранируем одинарные кавычки для безопасной вставки в JS
        String escaped = json.replace("\\", "\\\\").replace("'", "\\'");
        webView.evaluateJavascript("loadBookmarks('" + escaped + "');", null);
    }

    @Override
    public void onBackPressed() {
        if (webView.canGoBack()) {
            webView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}
