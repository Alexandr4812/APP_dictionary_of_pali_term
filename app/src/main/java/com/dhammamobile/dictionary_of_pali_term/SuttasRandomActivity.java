package com.dhammamobile.dictionary_of_pali_term;

import androidx.appcompat.app.AppCompatActivity;

import android.content.res.Configuration;
import android.os.Bundle;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;

import java.io.IOException;
import java.io.InputStream;
import java.nio.charset.StandardCharsets;
import java.util.Random;

public class SuttasRandomActivity extends BaseActivityClass {

    private WebView webView;
    private String[] validFolders = {"Texts"};
    private Random random = new Random();

    @Override
    public void onConfigurationChanged(Configuration newConfig) {
        super.onConfigurationChanged(newConfig);
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_suttas_random);

       // setWindowFlagsFullscreenAndNoLimits();

        webView = findViewById(R.id.webViewRandomSutta);

        webView.getSettings().setBuiltInZoomControls(true); // Разрешить встроенное масштабирование
        webView.getSettings().setSupportZoom(true); // Разрешить поддержку жестов масштабирования
        webView.getSettings().setDisplayZoomControls(false); // Скрыть контролы масштабирования
        webView.getSettings().setUseWideViewPort(true); // Разрешить широкий видовой порт
        webView.getSettings().setAllowFileAccess(true);
        webView.getSettings().setAllowContentAccess(true);

        // Загрузка случайной страницы
        loadRandomPage();

        Button buttonLoadRandomPage = findViewById(R.id.buttonNextSutta);
        buttonLoadRandomPage.setOnClickListener(v -> loadRandomPage());
    }

    // Загрузка случайной страницы
    private void loadRandomPage() {
        // Выбор случайной папки из списка
        String randomFolder = getRandomFolder();

        // Получение списка файлов в выбранной папке
        try {
            String[] filesInFolder = getAssets().list("canon/Teaching/Canon/Suttanta/" + randomFolder);

            // Выбор случайного файла из списка
            String randomFile = getRandomFile(filesInFolder);

            // Загрузка выбранной страницы в веб-вью
            if (randomFile != null) {
                String path = "file:///android_asset/canon/Teaching/Canon/Suttanta/" + randomFolder + "/" + randomFile;

                // Добавляем WebViewClient для обработки событий
                webView.setWebViewClient(new WebViewClient() {
                    @Override
                    public void onPageFinished(WebView view, String url) {
                        super.onPageFinished(view, url);
                        // Сохранение выбранной страницы после ее загрузки
                        saveLastVisitedPage(url);
                    }
                });

                // Загрузка данных в WebView
                webView.loadUrl(path);
            }
        } catch (IOException e) {
            e.printStackTrace();
        }
    }

    private String getRandomFolder() {
        return validFolders[random.nextInt(validFolders.length)];
    }

    private String getRandomFile(String[] files) {
        if (files != null && files.length > 0) {
            return files[random.nextInt(files.length)];
        }
        return null;
    }

    @Override
    protected void onPause() {
        String currentUrl = webView.getUrl();
        saveLastVisitedPage(currentUrl);
        super.onPause();
    }

    @Override
    protected void onDestroy() {
        WebView webView = findViewById(R.id.webViewRandomSutta);
        super.onDestroy();
        webView.destroy();
    }

    public void toMainAct(View view){
        String currentUrl = webView.getUrl();
        saveLastVisitedPage(currentUrl);
        startIntentActivityAndFinish(MainActivity.class);
    }

    public void toSuttasAct(View view){
        String currentUrl = webView.getUrl();
        saveLastVisitedPage(currentUrl);
        startIntentActivityAndFinish(SuttasActivity.class);
    }

    @Override
    public void onBackPressed() {
        super.onBackPressed();
        String currentUrl = webView.getUrl();
        saveLastVisitedPage(currentUrl);
        startIntentActivityAndFinish(SuttasActivity.class);
    }
}