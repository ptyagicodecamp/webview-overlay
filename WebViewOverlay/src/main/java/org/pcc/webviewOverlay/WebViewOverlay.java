package org.pcc.webviewOverlay;

import android.content.Context;
import android.util.Log;

import java.util.HashMap;
import java.util.Map;

/**
 * Created by ptyagi on 12/30/16.
 *
 * This widget loads WebView widget as an Overlay.
 * The overlay can be closed with a close button in top right corner.
 */

public class WebViewOverlay implements WebViewOverlayAPI {
    public static int LIB_VERSION = BuildConfig.VERSION_CODE;
    public static String LIB_VERSION_NAME = BuildConfig.VERSION_NAME;

    static final String TAG = "WebViewOverlay";

    WebViewHelper mWebViewHelper;

    /**
     *
     * @param context This is Activity context.
     */
    public WebViewOverlay(Context context) {
        mWebViewHelper = new WebViewHelper(context);
    }

    /**
     * Loads given URL in WebViewOverlay widget
     * @param urlToBeLoaded URL that intended to be loaded in WebViewOverlay
     * @param params This is the optional extra params that are meant to be concatenated with URL
     */
    @Override
    public void loadWebViewOverlay(String urlToBeLoaded, HashMap<String, String> params) {
        try {
            String url = getUrl(urlToBeLoaded, params);
            mWebViewHelper.openWebViewInOverlay(url, null);
        } catch (WebViewOverlayException e) {
            Log.e(TAG, "Exception occurred while loading WebviewOverlay: " + e.getMessage());
        }
    }

    /**
     * Loads given URL in WebViewOverlay widget
     *
     * @param urlToBeLoaded URL that intended to be loaded in WebViewOverlay.
     * @param params This is the optional extra params that are meant to be concatenated with URL.
     * @param popupTitle This is optional title that you want to appear on Overlay widget
     */
    @Override
    public void loadWebViewOverlay(String urlToBeLoaded, HashMap<String, String> params, String popupTitle) {

        try {
            String url = getUrl(urlToBeLoaded, params);
            mWebViewHelper.openWebViewInOverlay(url, popupTitle);
        } catch (WebViewOverlayException e) {
            Log.e(TAG, "Exception occurred while loading WebviewOverlay: " + e.getMessage());
        }
    }

    /**
     * Adds params with passed URL
     * @param baseUrl URL to be loaded in WebViewOverlay
     * @param params optionals params
     * @return Returns url intented to be loaded in webview
     * @throws WebViewOverlayException Throws exception
     */
    public String getUrl(String baseUrl, HashMap<String, String> params) throws WebViewOverlayException {

        String finalUrl = null;

        if (baseUrl instanceof String) {
            if (params == null || params.isEmpty()) {
                return baseUrl;
            } else {
                finalUrl = baseUrl + "/?";

                int counter = 0;
                for (Map.Entry<String, String>attrib: params.entrySet()) {
                    counter++;
                    finalUrl += attrib.getKey() +"=" + attrib.getValue();

                    if (counter < params.size()) {
                        finalUrl += "&";
                    }
                }
            }

        } else {
            throw new WebViewOverlayException("Invalid URL passed into WebViewOverlay");
        }

        return finalUrl;
    }
}
