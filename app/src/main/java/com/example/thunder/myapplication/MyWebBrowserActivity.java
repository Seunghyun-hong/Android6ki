package com.example.thunder.myapplication;

import android.os.Bundle;
import android.support.v7.app.AppCompatActivity;
import android.view.View;
import android.webkit.WebView;
import android.webkit.WebViewClient;
import android.widget.EditText;

public class MyWebBrowserActivity extends AppCompatActivity {

    private WebView mWebView;
    private EditText mUrlEditText;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_my_web_browser);

        mWebView = (WebView) findViewById(R.id.web_view);
        mUrlEditText = (EditText) findViewById(R.id.url_edit);

        // 요거 해 줘야 된뎅
        mWebView.setWebViewClient(new WebViewClient());

        //자바 스크립트를 사용하는 페이지를 볼 수 있게
        mWebView.getSettings().setJavaScriptEnabled(true);

        // 위에 두줄은 필!수! .

    }


    public void showWebPage(View view) {
        String url = mUrlEditText.getText().toString();
        if (url.startsWith("http://")||url.startsWith("https://")) {
            mWebView.loadUrl(url);
        } else {
            mWebView.loadUrl("http://" + url);
        }

    }

    public void goBack(View view) {
        mWebView.goBack();
    }

    public void goForward(View view) {
        mWebView.goForward();
    }

    public void resetButtonClicked(View view) {
        mWebView.reload();
    }

    @Override
    public void onBackPressed() {
        if (mWebView.canGoBack()) {
            mWebView.goBack();
        } else {
            super.onBackPressed();
        }
    }


}
