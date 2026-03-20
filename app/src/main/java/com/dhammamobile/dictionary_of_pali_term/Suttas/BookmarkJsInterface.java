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
 *   Android.clearRecents()
 *   Android.updateBookmarkTitle(id, newTitle)
 *   Android.updateBookmarkNote(id, newNote)
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
     * Вызывается из bookmarks.html при нажатии на закладку или недавнюю сутту.
     */
    @JavascriptInterface
    public void openBookmark(String filePath, int scrollY) {
        android.os.Handler handler = new android.os.Handler(android.os.Looper.getMainLooper());
        handler.post(() -> {
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
                targetClass = SuttasAnguttaraActivity.class;
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
    public void updateBookmarkNote(String id, String newNote) {
        manager.updateNote(id, newNote);
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

    @JavascriptInterface
    public void deleteBookmark(String id) {
        manager.deleteById(id);
    }

    @JavascriptInterface
    public void clearBookmarks() {
        manager.clearAll();
    }

    /**
     * Очистить историю недавних просмотров.
     * Вызывается из bookmarks.html при нажатии "Очистить историю".
     */
    @JavascriptInterface
    public void clearRecents() {
        manager.clearRecents();
    }
}