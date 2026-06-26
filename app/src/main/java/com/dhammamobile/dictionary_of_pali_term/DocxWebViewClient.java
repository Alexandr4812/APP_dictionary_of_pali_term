package com.dhammamobile.dictionary_of_pali_term;

import android.content.Context;
import android.content.Intent;
import android.webkit.WebView;
import android.webkit.WebViewClient;

import androidx.core.content.FileProvider;

import java.io.File;
import java.io.FileOutputStream;
import java.io.InputStream;


public class DocxWebViewClient extends WebViewClient {

    private final Context context;

    public DocxWebViewClient(Context context) {
        this.context = context;
    }

    @Override
    public boolean shouldOverrideUrlLoading(WebView view, String url) {
        if (url != null && url.startsWith("docxopen://")) {
            String filename = url.replace("docxopen://", "");
            openDocxFromAssets(context, filename);
            return true;
        }
        return super.shouldOverrideUrlLoading(view, url);
    }

    public static void openDocxFromAssets(Context context, String filename) {
        try {
            // Папка в assets, где лежат docx-файлы
            String assetPath = "Docx/" + filename;

            // Копируем из assets во временную папку
            File cacheFile = new File(context.getCacheDir(), filename);
            InputStream input = context.getAssets().open(assetPath);
            FileOutputStream output = new FileOutputStream(cacheFile);
            byte[] buffer = new byte[4096];
            int bytesRead;
            while ((bytesRead = input.read(buffer)) != -1) {
                output.write(buffer, 0, bytesRead);
            }
            input.close();
            output.close();

            // Создаём content:// URI через FileProvider
            android.net.Uri uri = FileProvider.getUriForFile(
                    context,
                    context.getPackageName() + ".fileprovider",
                    cacheFile
            );

            // Открываем в стороннем приложении
            Intent intent = new Intent(Intent.ACTION_VIEW);
            intent.setDataAndType(uri,
                    "application/vnd.openxmlformats-officedocument.wordprocessingml.document");
            intent.addFlags(Intent.FLAG_GRANT_READ_URI_PERMISSION);
            intent.addFlags(Intent.FLAG_ACTIVITY_NEW_TASK);

            context.startActivity(Intent.createChooser(intent, "Открыть в..."));

        } catch (Exception e) {
            e.printStackTrace();
            // Можно показать Toast: "Файл не найден"
        }
    }
}