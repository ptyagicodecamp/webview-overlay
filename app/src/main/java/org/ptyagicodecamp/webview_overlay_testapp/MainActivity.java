package org.ptyagicodecamp.webview_overlay_testapp;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;

import org.pcc.webviewOverlay.WebViewOverlay;

public class MainActivity extends AppCompatActivity {

    WebViewOverlay webViewOverlay;


    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_main);

        webViewOverlay = new WebViewOverlay(this);
    }

    public void openWebViewOverlay(View view) {
        String url = "https://ptyagicodecamp.github.io";
        webViewOverlay.loadWebViewOverlay(url, null);
    }

    public void openWebViewOverlayWithTitle(View view) {
        String url = "https://ptyagicodecamp.github.io";
        webViewOverlay.loadWebViewOverlay(url, null, "WebViewOverlay Demo");
    }
}
