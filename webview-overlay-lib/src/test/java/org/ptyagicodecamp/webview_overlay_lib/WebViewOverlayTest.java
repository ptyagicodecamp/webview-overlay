package org.ptyagicodecamp.webview_overlay_lib;

import org.junit.Before;
import org.junit.Test;

import java.util.HashMap;

import static org.junit.Assert.assertEquals;

/**
 * Example local unit test, which will execute on the development machine (host).
 *
 * @see <a href="http://d.android.com/tools/testing">Testing documentation</a>
 */
public class WebViewOverlayTest {
    WebViewOverlay webViewOverlay;

    @Before
    public void setUp() {
        webViewOverlay = new WebViewOverlay(null);
    }

    @Test
    public void testGetUrl() {
        String url = "https://ptyagicodecamp.github.io";

        String expectedUrl = "https://ptyagicodecamp.github.io";
        String actualUrl = "";
        try {
            actualUrl = webViewOverlay.getUrl(url, null);

            assertEquals(expectedUrl, actualUrl);
        } catch (WebViewOverlayException e) {
            assert (false);
        }
    }

    @Test
    public void testGetUrl2() {
        String url = "https://ptyagicodecamp.github.io";
        HashMap<String, String> params = new HashMap<>();
        params.put("param1", "1234");
        params.put("param2", "testParam");

        String expectedUrl = "https://ptyagicodecamp.github.io/?param1=1234&param2=testParam";
        String actualUrl = "";
        try {
            actualUrl = webViewOverlay.getUrl(url, params);

            assertEquals(expectedUrl, actualUrl);
        } catch (WebViewOverlayException e) {
            assert (false);
        }
    }

    @Test
    public void testGetSurveyUrl3() {
        String url = "https://ptyagicodecamp.github.io";
        HashMap<String, String> params = new HashMap<>();
        params.put("param1", "1234");

        String expectedUrl = "https://ptyagicodecamp.github.io/?param1=1234";
        String actualUrl = "";
        try {
            actualUrl = webViewOverlay.getUrl(url, params);

            assertEquals(expectedUrl, actualUrl);
        } catch (WebViewOverlayException e) {
            assert (false);
        }
    }
}