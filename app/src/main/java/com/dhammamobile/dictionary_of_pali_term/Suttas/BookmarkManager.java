package com.dhammamobile.dictionary_of_pali_term.Suttas; // <-- замени на свой package

import android.content.Context;
import android.content.SharedPreferences;
import org.json.JSONArray;
import org.json.JSONObject;
import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Locale;
import java.util.UUID;

/**
 * Менеджер закладок. Хранит до 10 закладок в SharedPreferences.
 * Каждая закладка содержит:
 *   - id         : уникальный ID
 *   - suttaRef   : номер сутты, например "СН 5.2"
 *   - title      : название сутты, например "Сома сутта — Сома"
 *   - subtitle   : подзаголовок/описание (краткое)
 *   - filePath   : путь к HTML-файлу в assets, например "SN/Texts/sn5_2-soma-sutta-sv.html"
 *   - scrollY    : позиция скролла (пиксели)
 *   - date       : ISO дата сохранения
 */
public class BookmarkManager {

    private static final String PREFS_NAME  = "bookmarks_prefs";
    private static final String KEY_DATA    = "bookmarks_json";
    private static final int    MAX_BOOKMARKS = 10;

    private final SharedPreferences prefs;

    public BookmarkManager(Context context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    /** Добавить или обновить закладку. Если для этого filePath уже есть закладка — обновляет scrollY.
     *  Если закладок >= 10 — удаляет самую старую (последнюю в массиве). */
    public void addBookmark(String suttaRef, String title, String subtitle,
                            String filePath, int scrollY) {
        JSONArray arr = getAll();

        // Ищем существующую с таким же filePath — обновляем
        for (int i = 0; i < arr.length(); i++) {
            try {
                JSONObject bm = arr.getJSONObject(i);
                if (filePath.equals(bm.optString("filePath"))) {
                    bm.put("scrollY", scrollY);
                    bm.put("date", nowIso());
                    // перемещаем на начало (самая свежая)
                    arr.remove(i);
                    arr = prependTo(arr, bm);
                    save(arr);
                    return;
                }
            } catch (Exception ignored) {}
        }

        // Новая закладка
        try {
            JSONObject bm = new JSONObject();
            bm.put("id",       UUID.randomUUID().toString());
            bm.put("suttaRef", suttaRef);
            bm.put("title",    title);
            bm.put("subtitle", subtitle);
            bm.put("filePath", filePath);
            bm.put("scrollY",  scrollY);
            bm.put("date",     nowIso());

            arr = prependTo(arr, bm);

            // Обрезаем до MAX_BOOKMARKS
            while (arr.length() > MAX_BOOKMARKS) {
                arr.remove(arr.length() - 1);
            }

            save(arr);
        } catch (Exception ignored) {}
    }

    public void updateTitle(String id, String newTitle) {
        JSONArray arr = getAll();
        for (int i = 0; i < arr.length(); i++) {
            try {
                JSONObject bm = arr.getJSONObject(i);
                if (id.equals(bm.optString("id"))) {
                    bm.put("title", newTitle);
                    break;
                }
            } catch (Exception ignored) {}
        }
        save(arr);
    }

    /** Удалить закладку по id */
    public void deleteById(String id) {
        JSONArray arr = getAll();
        JSONArray result = new JSONArray();
        for (int i = 0; i < arr.length(); i++) {
            try {
                JSONObject bm = arr.getJSONObject(i);
                if (!id.equals(bm.optString("id"))) {
                    result.put(bm);
                }
            } catch (Exception ignored) {}
        }
        save(result);
    }

    /** Очистить все закладки */
    public void clearAll() {
        save(new JSONArray());
    }

    /** Получить все закладки как JSON-строку (для передачи в WebView) */
    public String getAllAsJsonString() {
        return prefs.getString(KEY_DATA, "[]");
    }

    /** Получить JSONArray всех закладок */
    public JSONArray getAll() {
        try {
            return new JSONArray(prefs.getString(KEY_DATA, "[]"));
        } catch (Exception e) {
            return new JSONArray();
        }
    }

    // ─── helpers ───────────────────────────────────────────

    private void save(JSONArray arr) {
        prefs.edit().putString(KEY_DATA, arr.toString()).apply();
    }

    private JSONArray prependTo(JSONArray arr, JSONObject item) {
        JSONArray result = new JSONArray();
        result.put(item);
        for (int i = 0; i < arr.length(); i++) {
            try { result.put(arr.get(i)); } catch (Exception ignored) {}
        }
        return result;
    }

    private String nowIso() {
        return new SimpleDateFormat("yyyy-MM-dd'T'HH:mm:ss", Locale.getDefault())
                .format(new Date());
    }
}
