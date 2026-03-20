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
 * Менеджер закладок + история недавних сутт.
 * Закладки: до 100, хранятся в "bookmarks_json".
 * Недавние: до 5, хранятся в "recents_json", старые вытесняются новыми.
 */
public class BookmarkManager {

    private static final String PREFS_NAME    = "bookmarks_prefs";
    private static final String KEY_DATA      = "bookmarks_json";
    private static final String KEY_RECENTS   = "recents_json";
    private static final int    MAX_BOOKMARKS = 100;
    private static final int    MAX_RECENTS   = 10;

    private final SharedPreferences prefs;

    public BookmarkManager(Context context) {
        prefs = context.getSharedPreferences(PREFS_NAME, Context.MODE_PRIVATE);
    }

    // ─────────────────────────────────────────────────────────────
    //  НЕДАВНИЕ СУТТЫ
    // ─────────────────────────────────────────────────────────────

    /**
     * Добавить сутту в историю недавних просмотров.
     * Если такой filePath уже есть — обновляет запись и поднимает наверх.
     * Если записей >= MAX_RECENTS — удаляет самую старую (последнюю).
     * Вызывать из SuttasActivity при загрузке каждой сутты.
     */
    public void addRecent(String suttaRef, String title, String subtitle,
                          String filePath, int scrollY) {
        if (title == null || title.isEmpty() || title.equals(filePath)) {
            title = extractTitleFromPath(filePath);
        }

        JSONArray arr = getRecents();

        // Ищем существующую запись с таким же filePath
        for (int i = 0; i < arr.length(); i++) {
            try {
                JSONObject item = arr.getJSONObject(i);
                if (filePath.equals(item.optString("filePath"))) {
                    item.put("scrollY", scrollY);
                    item.put("date", nowIso());
                    arr.remove(i);
                    arr = prependTo(arr, item);
                    saveRecents(arr);
                    return;
                }
            } catch (Exception ignored) {}
        }

        // Новая запись
        try {
            JSONObject item = new JSONObject();
            item.put("id",       UUID.randomUUID().toString());
            item.put("suttaRef", suttaRef  != null ? suttaRef  : "");
            item.put("title",    title);
            item.put("subtitle", subtitle  != null ? subtitle  : "");
            item.put("filePath", filePath);
            item.put("scrollY",  scrollY);
            item.put("date",     nowIso());

            arr = prependTo(arr, item);

            // Обрезаем до MAX_RECENTS — старая запись вытесняется автоматически
            while (arr.length() > MAX_RECENTS) {
                arr.remove(arr.length() - 1);
            }

            saveRecents(arr);
        } catch (Exception ignored) {}
    }

    /** Получить историю просмотров как JSON-строку (для передачи в WebView) */
    public String getRecentsAsJsonString() {
        return prefs.getString(KEY_RECENTS, "[]");
    }

    /** Получить JSONArray истории просмотров */
    public JSONArray getRecents() {
        try {
            return new JSONArray(prefs.getString(KEY_RECENTS, "[]"));
        } catch (Exception e) {
            return new JSONArray();
        }
    }

    /** Очистить историю просмотров */
    public void clearRecents() {
        prefs.edit().putString(KEY_RECENTS, "[]").apply();
    }

    // ─────────────────────────────────────────────────────────────
    //  ЗАКЛАДКИ
    // ─────────────────────────────────────────────────────────────

    /**
     * Извлекает читаемое название из пути к файлу.
     * Например: "SN/Texts/sn5_2-soma-sutta-sv.html" → "SN 5.2 Soma Sutta"
     */
    public static String extractTitleFromPath(String filePath) {
        if (filePath == null || filePath.isEmpty()) return filePath;

        String name = filePath;
        int slash = name.lastIndexOf('/');
        if (slash >= 0) name = name.substring(slash + 1);

        int dot = name.lastIndexOf('.');
        if (dot >= 0) name = name.substring(0, dot);

        name = name.replaceAll("-[a-z]{2,3}$", "");
        name = name.replaceAll("^([a-zA-Z]{2})(\\d+)_(\\d+)-?(.*)", "$1 $2.$3 $4");
        name = name.replaceAll("^([a-zA-Z]{2})(\\d+)-?(.*)",         "$1 $2 $3");

        String[] parts = name.trim().split("[-_\\s]+");
        StringBuilder sb = new StringBuilder();
        for (String part : parts) {
            if (part.isEmpty()) continue;
            if (sb.length() > 0) sb.append(" ");
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
     */
    public void addBookmark(String suttaRef, String title, String subtitle,
                            String filePath, int scrollY) {
        if (title == null || title.isEmpty() || title.equals(filePath)) {
            title = extractTitleFromPath(filePath);
        }

        JSONArray arr = getAll();

        for (int i = 0; i < arr.length(); i++) {
            try {
                JSONObject bm = arr.getJSONObject(i);
                if (filePath.equals(bm.optString("filePath"))) {
                    bm.put("scrollY", scrollY);
                    bm.put("date", nowIso());
                    arr.remove(i);
                    arr = prependTo(arr, bm);
                    save(arr);
                    return;
                }
            } catch (Exception ignored) {}
        }

        try {
            JSONObject bm = new JSONObject();
            bm.put("id",       UUID.randomUUID().toString());
            bm.put("suttaRef", suttaRef);
            bm.put("title",    title);
            bm.put("subtitle", subtitle);
            bm.put("filePath", filePath);
            bm.put("scrollY",  scrollY);
            bm.put("note",     "");
            bm.put("date",     nowIso());

            arr = prependTo(arr, bm);

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

    public void clearAll() {
        save(new JSONArray());
    }

    public String getAllAsJsonString() {
        return prefs.getString(KEY_DATA, "[]");
    }

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

    private void saveRecents(JSONArray arr) {
        prefs.edit().putString(KEY_RECENTS, arr.toString()).apply();
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