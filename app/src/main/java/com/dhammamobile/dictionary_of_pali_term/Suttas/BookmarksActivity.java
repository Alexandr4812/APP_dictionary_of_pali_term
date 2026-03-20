package com.dhammamobile.dictionary_of_pali_term.Suttas; // <-- замени на свой package

import android.os.Bundle;
import android.webkit.WebSettings;
import android.webkit.WebView;
import androidx.appcompat.app.AppCompatActivity;

/**
 * Activity для экрана закладок.
 * Загружает bookmarks.html из assets и передаёт данные закладок + историю.
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

        WebSettings settings = webView.getSettings();
        settings.setJavaScriptEnabled(true);
        settings.setDomStorageEnabled(true);

        BookmarkJsInterface jsInterface = new BookmarkJsInterface(this, bookmarkManager, webView);
        webView.addJavascriptInterface(jsInterface, "Android");

        webView.loadUrl("file:///android_asset/bookmarks.html");

        webView.setWebViewClient(new android.webkit.WebViewClient() {
            @Override
            public void onPageFinished(WebView view, String url) {
                loadDataIntoPage();
            }
        });
    }

    /**
     * Передаёт JSON закладок и JSON истории просмотров в JavaScript.
     */
    private void loadDataIntoPage() {
        String bmJson      = bookmarkManager.getAllAsJsonString();
        String recentsJson = bookmarkManager.getRecentsAsJsonString();

        String escapedBm      = bmJson.replace("\\", "\\\\").replace("'", "\\'");
        String escapedRecents = recentsJson.replace("\\", "\\\\").replace("'", "\\'");

        webView.evaluateJavascript(
                "loadData('" + escapedBm + "', '" + escapedRecents + "');",
                null
        );
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