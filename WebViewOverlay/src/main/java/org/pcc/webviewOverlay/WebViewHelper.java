package org.pcc.webviewOverlay;

import android.app.Dialog;
import android.content.Context;
import android.view.LayoutInflater;
import android.view.View;
import android.view.WindowManager;
import android.webkit.URLUtil;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.Button;


/**
 * Created by ptyagi on 12/30/16.
 */

public class WebViewHelper implements View.OnClickListener {
    private WebView mWebView;
    private Context mContext;
    private Dialog mWebviewDialog = null;

    /**
     * Initializes helper class
     *
     * @param context Activity context.
     */
    public WebViewHelper(Context context) {
        mContext = context;
    }

    /***
     * Opens url in a webview in a full-screen overlay mode.
     * Overlay can be closed by clicking on "x" button in top right corner.
     * @param url URL
     * @param popupTitle Title for Overlay (optional)
     * @throws WebViewOverlayException Throws exception
     */
    public void openWebViewInOverlay(String url, String popupTitle) throws WebViewOverlayException {
        if (!URLUtil.isValidUrl(url)) {
            throw new WebViewOverlayException("Invalid url passed into WebViewOverlay");
        }

        if (popupTitle instanceof String) {
            mWebviewDialog = new Dialog(mContext, android.R.style.Theme_DeviceDefault);
            mWebviewDialog.setTitle(popupTitle);
        } else {
            mWebviewDialog = new Dialog(mContext, android.R.style.Theme_Holo_Light_NoActionBar_Fullscreen);
        }

        //load webview in dialog
        LayoutInflater inflater = (LayoutInflater)mContext.getApplicationContext().getSystemService
                (Context.LAYOUT_INFLATER_SERVICE);
        View view = View.inflate(mContext, R.layout.webview_modal, null);//inflater.inflate(R.layout.webview_modal, null);
        Button closeSurvey = (Button) view.findViewById(R.id.closeOverlay);
        closeSurvey.setOnClickListener(this);

        mWebView = (WebView) view.findViewById(R.id.webviewoverlay);
        mWebView.getSettings().setJavaScriptEnabled(true);
        mWebView.loadUrl(url);
        mWebView.setWebViewClient(new WebViewClient() {
            @Override
            public boolean shouldOverrideUrlLoading(WebView view, String url) {
                view.loadUrl(url);
                return true;
            }
        });

        mWebviewDialog.setContentView(view);
        mWebviewDialog.show();

        //set full-screen params
        WindowManager.LayoutParams lp = new WindowManager.LayoutParams();
        lp.copyFrom(mWebviewDialog.getWindow().getAttributes());
        lp.width = WindowManager.LayoutParams.FILL_PARENT;
        lp.height = WindowManager.LayoutParams.FILL_PARENT;
        mWebviewDialog.getWindow().setAttributes(lp);
    }

    @Override
    public void onClick(View v) {
        if (mWebviewDialog != null) {
            mWebviewDialog.dismiss();
        }
    }
}
