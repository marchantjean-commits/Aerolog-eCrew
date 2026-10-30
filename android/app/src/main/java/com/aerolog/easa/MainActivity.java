package com.aerolog.easa;

import android.content.ContentValues;
import android.os.Bundle;
import android.os.Environment;
import android.provider.MediaStore;
import android.webkit.JavascriptInterface;
import android.webkit.WebView;
import android.widget.Toast;
import com.getcapacitor.BridgeActivity;
import java.io.OutputStream;
import java.util.Base64;

public class MainActivity extends BridgeActivity {
  @Override public void onCreate(Bundle state) {
    super.onCreate(state);
    WebView webView = getBridge().getWebView();
    webView.addJavascriptInterface(new PdfBridge(), "AndroidPdf");
  }
  public class PdfBridge {
    @JavascriptInterface public void save(String name, String base64) {
      try {
        ContentValues values = new ContentValues();
        values.put(MediaStore.Downloads.DISPLAY_NAME, name);
        values.put(MediaStore.Downloads.MIME_TYPE, "application/pdf");
        values.put(MediaStore.Downloads.RELATIVE_PATH, Environment.DIRECTORY_DOWNLOADS);
        android.net.Uri uri = getContentResolver().insert(MediaStore.Downloads.EXTERNAL_CONTENT_URI, values);
        if (uri == null) throw new Exception("No se pudo crear el archivo");
        try (OutputStream out = getContentResolver().openOutputStream(uri)) { out.write(Base64.getDecoder().decode(base64)); }
        runOnUiThread(() -> Toast.makeText(MainActivity.this, "PDF guardado en Descargas", Toast.LENGTH_LONG).show());
      } catch (Exception e) { runOnUiThread(() -> Toast.makeText(MainActivity.this, "Error guardando PDF: " + e.getMessage(), Toast.LENGTH_LONG).show()); }
    }
  }
}
