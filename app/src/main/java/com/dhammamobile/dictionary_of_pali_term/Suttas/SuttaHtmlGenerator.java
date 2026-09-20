package com.dhammamobile.dictionary_of_pali_term.Suttas;

import android.content.Context;
import android.database.Cursor;
import android.database.sqlite.SQLiteDatabase;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;

public class SuttaHtmlGenerator {

    private final Context context;

    public SuttaHtmlGenerator(Context context) {
        this.context = context;
    }

    private String readTemplate(String assetPath) throws IOException {
        InputStream is = context.getAssets().open(assetPath);
        byte[] buffer = new byte[is.available()];
        is.read(buffer);
        is.close();
        return new String(buffer, StandardCharsets.UTF_8);
    }

    public String generateSuttasListHtml(SQLiteDatabase db, String nikaya) throws IOException {
        String template = readTemplate("templates/suttas_list.html");

        StringBuilder content = new StringBuilder();
        String currentGroup = null;
        String currentSection = null;
        boolean groupOpened = false;
        boolean sectionOpened = false;

        Cursor cursor = db.rawQuery(
                "SELECT uid, canonical_number, local_number, title, vagga, book, nikaya " +
                        "FROM suttas WHERE nikaya = ? " +
                        "ORDER BY canonical_number, local_number, id",
                new String[]{nikaya}
        );

        while (cursor.moveToNext()) {
            String uid = cursor.getString(0);
            int canonicalNumber = cursor.getInt(1);
            int localNumber = cursor.getInt(2);
            String title = cursor.getString(3);
            String vagga = cursor.getString(4);
            String book = cursor.getString(5);
            String nikayaStr = cursor.getString(6);

            String group;
            String section;

            if (vagga != null && vagga.contains(" · ")) {
                int idx = vagga.indexOf(" · ");
                group = vagga.substring(0, idx).trim();
                section = vagga.substring(idx + 3).trim();
                if (section.isEmpty()) {
                    section = null;
                }
            } else if (vagga != null && !vagga.trim().isEmpty()) {
                group = vagga.trim();
                section = null;
            } else if (book != null && !book.trim().isEmpty()) {
                group = book.trim();
                section = null;
            } else {
                group = "Другие сутты";
                section = null;
            }

            if (!group.equals(currentGroup)) {
                if (sectionOpened) {
                    content.append("      </div>\n    </details>\n");
                    sectionOpened = false;
                }
                if (groupOpened) {
                    content.append("  </div>\n</details>\n");
                }
                currentGroup = group;
                currentSection = null;
                groupOpened = true;
                content.append("<details class=\"group-details\">\n")
                        .append("  <summary class=\"group-divider\">")
                        .append(escapeHtml(group))
                        .append("</summary>\n")
                        .append("  <div class=\"group-content\">\n");
            }

            if (section == null) {
                if (sectionOpened) {
                    content.append("      </div>\n    </details>\n");
                    sectionOpened = false;
                    currentSection = null;
                }
            } else if (!section.equals(currentSection)) {
                if (sectionOpened) {
                    content.append("      </div>\n    </details>\n");
                }
                currentSection = section;
                sectionOpened = true;
                content.append("    <details class=\"vagga-details\">\n")
                        .append("      <summary class=\"vagga-divider\">")
                        .append(escapeHtml(section))
                        .append("</summary>\n")
                        .append("      <div class=\"vagga-content\">\n");
            }

            String displayNumber;
            if ("Самьютта-никая".equals(nikayaStr)
                    || "Ангуттара-никая".equals(nikayaStr)) {
                displayNumber = canonicalNumber + "." + localNumber;
            } else if ("Кхуддака-никая".equals(nikayaStr)) {
                displayNumber = String.valueOf(localNumber);
            } else if (canonicalNumber > 0) {
                displayNumber = String.valueOf(canonicalNumber);
            } else {
                displayNumber = String.valueOf(localNumber);
            }

            content.append("        <a class=\"sutta-item\" href=\"sutta://").append(uid).append("\">\n")
                    .append("          <span class=\"sutta-uid\">").append(escapeHtml(uid.toUpperCase())).append("</span>\n")
                    .append("          <span class=\"sutta-number\">").append(displayNumber).append("</span>\n")
                    .append("          <span class=\"sutta-title\">").append(escapeHtml(title)).append("</span>\n")
                    .append("        </a>\n");
        }
        cursor.close();

        if (sectionOpened) {
            content.append("      </div>\n    </details>\n");
        }
        if (groupOpened) {
            content.append("  </div>\n</details>\n");
        }

        return template
                .replace("{{NIKAYA_TITLE}}", escapeHtml(nikaya))
                .replace("{{CONTENT}}", content.toString());
    }

    public String generateSuttaTextHtml(SQLiteDatabase db, String uid) throws IOException {
        String template = readTemplate("templates/sutta_text.html");

        Cursor cursor = db.rawQuery(
                "SELECT uid, nikaya, book, vagga, canonical_number, local_number, title, content " +
                        "FROM suttas WHERE uid = ? LIMIT 1",
                new String[]{uid}
        );

        if (!cursor.moveToFirst()) {
            cursor.close();
            return "<html><body><p>Сутта не найдена: " + escapeHtml(uid) + "</p></body></html>";
        }

        String suttaUid = cursor.getString(0);
        String nikaya = cursor.getString(1);
        String book = cursor.getString(2);
        String vagga = cursor.getString(3);
        int canonicalNumber = cursor.getInt(4);
        int localNumber = cursor.getInt(5);
        String title = cursor.getString(6);
        String rawContent = cursor.getString(7);

        cursor.close();

        StringBuilder meta = new StringBuilder();
        meta.append(nikaya);
        if (canonicalNumber > 0
                && ("Самьютта-никая".equals(nikaya) || "Ангуттара-никая".equals(nikaya))) {
            String prefix = "Самьютта-никая".equals(nikaya) ? "СН " : "АН ";
            meta.append(" · ").append(prefix)
                    .append(canonicalNumber).append(".").append(localNumber);
        }
        if (book != null && !book.isEmpty()) {
            meta.append(" · ").append(book);
        }
        if (vagga != null && !vagga.isEmpty()) {
            meta.append(" · ").append(vagga);
        }

        String formattedContent = formatSuttaContent(rawContent);

        return template
                .replace("{{SUTTA_UID}}", escapeHtml(suttaUid.toUpperCase()))
                .replace("{{SUTTA_TITLE}}", escapeHtml(title))
                .replace("{{SUTTA_META}}", escapeHtml(meta.toString()))
                .replace("{{SUTTA_CONTENT}}", formattedContent);
    }

    private String formatSuttaContent(String raw) {
        if (raw == null || raw.isEmpty()) {
            return "<p></p>";
        }

        String[] lines = raw.split("\n");
        StringBuilder html = new StringBuilder();

        for (String line : lines) {
            String trimmed = line.trim();
            if (trimmed.isEmpty()) {
                continue;
            }
            if (trimmed.startsWith("#") && trimmed.endsWith("#")) {
                String heading = trimmed.substring(1, trimmed.length() - 1).trim();
                html.append("<p class=\"sub-heading\">")
                        .append(escapeHtml(heading))
                        .append("</p>\n");
            } else {
                html.append("<p>").append(escapeHtml(trimmed)).append("</p>\n");
            }
        }
        return html.toString();
    }

    private String escapeHtml(String text) {
        if (text == null) return "";
        return text
                .replace("&", "&amp;")
                .replace("<", "&lt;")
                .replace(">", "&gt;")
                .replace("\"", "&quot;");
    }
}