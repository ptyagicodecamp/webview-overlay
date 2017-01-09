A widget to load WebView as an Overlay.

The source code for WebViewOverlay widget library is located at [Github](https://github.com/ptyagicodecamp/webview-overlay)

## Motivation
I created a widget that can load a WebView widget in a closable overlay/modal. I wanted to re-use
this new, shiny widget in my other projects as well to provide me easy way to load a WebView in a
full-screen modal rather keep writing the same piece of code again and over again.
So, decided to upload WebViewOverlay library to JCenter.

## WebViewOverlay Widget
WebViewOverlay widget loads a WebView widget in a full-screen pop-up. It has option to close it by
clicking on top-right corner 'x'

## API
There're two APIs to load WebView either in full-screen mode or in a dialog with a custom title.

***Full Screen Overlay***

```
void loadWebViewOverlay(String urlToBeLoaded, HashMap<String, String> params);
```
![Alt Text](./screenshots/OverlayFullScreen.png)

***Full Screen Overlay With Custom Title***

```
void loadWebViewOverlay(String urlToBeLoaded, HashMap<String, String> params, String popupTitle);
```
![Alt Text](./screenshots/OverlayWithTitle.png)

## Integration
In Android Studio, it can be added to your project by adding following in `build.gradle`
```
compile 'org.ptyagicodecamp:WebViewOverlay:1.0.2'
```

## Initialization
WebViewOverlay widget can be initialized in Activity or BaseActivity's `onCreate()` method.
```
WebViewOverlay webViewOverlay;

@Override
protected void onCreate(Bundle savedInstanceState) {
    super.onCreate(savedInstanceState);
    setContentView(R.layout.activity_main);

    webViewOverlay = new WebViewOverlay(this);
}
```

## Usage
After initializing widget, it can simply be used by calling either of the API.
Here's examples to demonstrate both APIs:
```
public void openWebViewOverlay(View view) {
    String url = "https://ptyagicodecamp.github.io";
    webViewOverlay.loadWebViewOverlay(url, null);
}

public void openWebViewOverlayWithTitle(View view) {
    String url = "https://ptyagicodecamp.github.io";
    webViewOverlay.loadWebViewOverlay(url, null, "WebViewOverlay Demo");
}
```
>>>>>>> done with readme
