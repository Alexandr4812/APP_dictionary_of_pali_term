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
 * Менеджер закладок. Хранит до 100 закладок в SharedPreferences.
 * Каждая закладка содержит:
 *   - id         : уникальный ID
 *   - suttaRef   : номер сутты, например "СН 5.2"
 *   - title      : название сутты, например "Сома сутта — Сома"
 *   - subtitle   : подзаголовок/описание (краткое)
 *   - filePath   : путь к HTML-файлу в assets, например "SN/Texts/sn5_2-soma-sutta-sv.html"
 *   - scrollY    : позиция скролла (пиксели)
 *   - note       : произвольное описание/заметка пользователя
 *   - date       : ISO дата сохранения
 */
public class BookmarkManager {

    private static final String PREFS_NAME    = "bookmarks_prefs";
    private static final String KEY_DATA      = "bookmarks_json";
    private static final int    MAX_BOOKMARKS = 100;

    private final SharedPreferences prefs;

    public BookmarkManager(Context context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    /**
     * Извлекает читаемое название из пути к файлу.
     * Например: "SN/Texts/sn5_2-soma-sutta-sv.html" → "SN 5.2 Soma Sutta"
     */
    public static String extractTitleFromPath(String filePath) {
        if (filePath == null || filePath.isEmpty()) return filePath;

        // Берём имя файла без папок
        String name = filePath;
        int slash = name.lastIndexOf('/');
        if (slash >= 0) name = name.substring(slash + 1);

        // Убираем расширение
        int dot = name.lastIndexOf('.');
        if (dot >= 0) name = name.substring(0, dot);

        // Убираем суффиксы переводчиков в конце: -sv, -bh, -tb, -nm и т.п.
        name = name.replaceAll("-[a-z]{2,3}$", "");

        // Парсим номер: sn5_2-..., an1_1-..., mn10-..., dn2-... → "SN 5.2 ...", "MN 10 ..."
        name = name.replaceAll("^([a-zA-Z]{2})(\\d+)_(\\d+)-?(.*)", "$1 $2.$3 $4");
        name = name.replaceAll("^([a-zA-Z]{2})(\\d+)-?(.*)",         "$1 $2 $3");

        // Заменяем дефисы/подчёркивания на пробелы и капитализируем каждое слово
        String[] parts = name.trim().split("[-_\\s]+");
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            if (part.isEmpty()) continue;
            if (sb.length() > 0) sb.append(" ");
            // Не трогаем уже заглавные аббревиатуры вроде SN, AN, MN
            if (part.matches("[A-Z]{1,3}\\s*\\d.*")) {
                sb.append(part);
            } else {
                sb.append(Character.toUpperCase(part.charAt(0)));
                sb.append(part.substring(1).toLowerCase());
            }
        }
        return sb.toString().trim();
    }

    /**
     * Добавить или обновить закладку. Если для этого filePath уже есть закладка — обновляет scrollY.
     * Если закладок >= MAX_BOOKMARKS — удаляет самую старую (последнюю в массиве).
     */
    public void addBookmark(String suttaRef, String title, String subtitle,
                            String filePath, int scrollY) {
        // Если title пустой или совпадает с filePath — генерируем красивое имя из пути
        if (title == null || title.isEmpty() || title.equals(filePath)) {
            title = extractTitleFromPath(filePath);
        }

        JSONArray arr = getAll();

        // Ищем существующую с таким же filePath — обновляем позицию и дату
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
            bm.put("note",     "");      // поле для произвольной заметки пользователя
            bm.put("date",     nowIso());

            arr = prependTo(arr, bm);

            // Обрезаем до MAX_BOOKMARKS
            while (arr.length() > MAX_BOOKMARKS) {
                arr.remove(arr.length() - 1);
            }

            save(arr);
        } catch (Exception ignored) {}
    }

    /** Обновить заголовок закладки */
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

    /** Обновить заметку (note) закладки */
    public void updateNote(String id, String newNote) {
        JSONArray arr = getAll();
        for (int i = 0; i < arr.length(); i++) {
            try {
                JSONObject bm = arr.getJSONObject(i);
                if (id.equals(bm.optString("id"))) {
                    bm.put("note", newNote);
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