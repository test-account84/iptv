package com.nst.iptvsmarterstvbox.view.activity;

import a7.f;
import a7.g;
import a7.j;
import android.app.ProgressDialog;
import android.os.Bundle;
import android.webkit.WebResourceRequest;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class PrivacyPolicyActivity extends androidx.appcompat.app.b {
    public String d;
    public WebView e;
    public ProgressDialog f;

    public class b extends WebViewClient {
        public b() {
        }

        public void onPageFinished(WebView webView, String str) {
            super.onPageFinished(webView, str);
            PrivacyPolicyActivity.this.f.dismiss();
        }

        public boolean shouldOverrideUrlLoading(WebView webView, WebResourceRequest webResourceRequest) {
            PrivacyPolicyActivity.this.f.show();
            return shouldOverrideUrlLoading(webView, webResourceRequest.getUrl().toString());
        }

        public /* synthetic */ b(PrivacyPolicyActivity privacyPolicyActivity, a aVar) {
            this();
        }
    }

    public void onBackPressed() {
        if (this.e.canGoBack()) {
            this.e.goBack();
        } else {
            super/*androidx.activity.ComponentActivity*/.onBackPressed();
        }
    }

    public void onCreate(Bundle bundle) {
        super/*androidx.fragment.app.e*/.onCreate(bundle);
        setContentView(g.r0);
        getIntent();
        this.d = getIntent().getStringExtra("url");
        this.e = findViewById(f.Tm);
        ProgressDialog progressDialog = new ProgressDialog(this);
        this.f = progressDialog;
        progressDialog.setMessage(getResources().getString(j.v5));
        this.f.show();
        this.f.setCancelable(false);
        this.e.getSettings().setJavaScriptEnabled(true);
        this.e.getSettings().setLoadWithOverviewMode(true);
        this.e.getSettings().setUseWideViewPort(true);
        this.e.setWebViewClient(new b(this, null));
        this.e.loadUrl(this.d);
    }
}
