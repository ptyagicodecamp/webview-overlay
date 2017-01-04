package org.ptyagicodecamp.webview_overlay_lib;

import java.util.HashMap;

/**
 * Created by ptyagi on 12/30/16.
 */

public interface WebViewOverlayAPI {
    void loadWebViewOverlay(String urlToBeLoaded, HashMap<String, String> params);

    void loadWebViewOverlay(String urlToBeLoaded, HashMap<String, String> params, String popupTitle);
}
