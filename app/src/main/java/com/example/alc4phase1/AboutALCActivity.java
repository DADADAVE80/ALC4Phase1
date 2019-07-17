package com.example.alc4phase1;

import android.net.http.SslError;
import android.support.v7.app.AppCompatActivity;
import android.os.Bundle;
import android.webkit.SslErrorHandler;
import android.webkit.WebSettings;
import android.webkit.WebView;
import android.webkit.WebViewClient;

public class AboutALCActivity extends AppCompatActivity {

    private WebView mWebView;
    // A new webclient that ignore ssl errors
    private class IgnoreSSLErrorWebViewClient extends WebViewClient {

        @Override
        public void onReceivedSslError(WebView view, SslErrorHandler handler, SslError error) {
            handler.proceed(); // When an error occurs, ignore and go on
        }
    }

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_about_alc);
        mWebView = (WebView) findViewById(R.id.webview_about_alc);
        WebSettings webSettings = mWebView.getSettings();
        webSettings.supportZoom();
        mWebView.getSettings().setDatabaseEnabled(true);
        mWebView.getSettings().setDomStorageEnabled(true);
        mWebView.getSettings().setBuiltInZoomControls(true);
        mWebView.setWebViewClient(new WebViewClient() {

            public void onReceiveSslError(SslErrorHandler handler) {
                handler.proceed();
            }
        });
        mWebView.loadUrl("https://andela.com/alc/");
        mWebView.setWebViewClient(new IgnoreSSLErrorWebViewClient());
    }

    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }
}