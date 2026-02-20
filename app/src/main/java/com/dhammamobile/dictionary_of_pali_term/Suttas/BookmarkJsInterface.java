package com.dhammamobile.dictionary_of_pali_term.Suttas; // <-- замени на свой package

import android.content.Intent;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.content.Context;

/**
 * JavaScript-интерфейс. Прикрепляется к WebView через:
 *   webView.addJavascriptInterface(new BookmarkJsInterface(context, bookmarkManager, webView), "Android");
 *
 * В HTML вызывается как:
 *   Android.openBookmark(filePath, scrollY)
 *   Android.deleteBookmark(id)
 *   Android.clearBookmarks()
 */
public class BookmarkJsInterface {

    private final Context         context;
    private final BookmarkManager manager;
    private final WebView         webView;

    public BookmarkJsInterface(Context context, BookmarkManager manager, WebView webView) {
        this.context = context;
        this.manager = manager;
        this.webView = webView;
    }

    /**
     * Открыть сутту по filePath и прокрутить до scrollY.
     * Вызывается из bookmarks.html при нажатии на закладку.
     */
    @JavascriptInterface
    public void openBookmark(String filePath, int scrollY) {
        android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
        handler.post(() -> {
            // Открываем нужную Activity в зависимости от раздела
            Class<?> targetClass;
            if (filePath.contains("anguttara") || filePath.contains("AN")) {
                targetClass = SuttasAnguttaraActivity.class;
            } else if (filePath.contains("sanyutta") || filePath.contains("SN")) {
                targetClass = SuttasSanyuttaActivity.class;
            } else if (filePath.contains("majjhima") || filePath.contains("MN")) {
                targetClass = SuttasMajjhimaActivity.class;
            } else if (filePath.contains("digha") || filePath.contains("DN")) {
                targetClass = SuttasDighaActivity.class;
            } else {
                targetClass = SuttasAnguttaraActivity.class; // по умолчанию
            }

            Intent intent = new Intent(context, targetClass);
            intent.putExtra("FILE_PATH", filePath);
            intent.putExtra("SCROLL_Y", scrollY);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);
            context.startActivity(intent);
        });
    }

    @JavascriptInterface
    public void updateBookmarkTitle(String id, String newTitle) {
        manager.updateTitle(id, newTitle);
    }

    @JavascriptInterface
    public void goBack() {
        android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
        handler.post(() -> {
            if (context instanceof android.app.Activity) {
                ((android.app.Activity) context).finish();
            }
        });
    }

    /**
     * Удалить закладку по id.
     * Вызывается из bookmarks.html при нажатии ✕ у закладки.
     */
    @JavascriptInterface
    public void deleteBookmark(String id) {
        manager.deleteById(id);
        // Данные уже обновлены в JS-стороне через render(),
        // но можно синхронизировать из Java на всякий случай
    }

    /**
     * Очистить все закладки.
     * Вызывается из bookmarks.html при нажатии "Очистить все".
     */
    @JavascriptInterface
    public void clearBookmarks() {
        manager.clearAll();
    }
}
