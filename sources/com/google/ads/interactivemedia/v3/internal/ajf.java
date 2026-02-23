package com.google.ads.interactivemedia.v3.internal;

import android.content.Context;
import android.os.Message;
import android.webkit.WebChromeClient;
import android.webkit.WebView;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ajf extends WebChromeClient {
    final /* synthetic */ Context a;
    final /* synthetic */ aly b;
    final /* synthetic */ List c;

    public ajf(Context context, aly alyVar, List list) {
        this.a = context;
        this.b = alyVar;
        this.c = list;
    }

    public final boolean onCreateWindow(WebView webView, boolean z, boolean z2, Message message) {
        WebView.WebViewTransport webViewTransport = (WebView.WebViewTransport) message.obj;
        WebView webView2 = new WebView(this.a);
        webViewTransport.setWebView(webView2);
        webView2.setWebViewClient(new aje(this));
        message.sendToTarget();
        return true;
    }
}
