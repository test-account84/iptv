package com.google.ads.interactivemedia.v3.internal;

import android.graphics.Bitmap;
import android.webkit.WebView;
import android.webkit.WebViewClient;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class akd extends WebViewClient {
    final /* synthetic */ ake a;

    public akd(ake akeVar) {
        this.a = akeVar;
    }

    public final void onPageFinished(WebView webView, String str) {
        com.google.ads.interactivemedia.v3.impl.data.m.c("Finished loading WebView".concat(String.valueOf(str)));
    }

    public final void onPageStarted(WebView webView, String str, Bitmap bitmap) {
        com.google.ads.interactivemedia.v3.impl.data.m.c("Started loading WebView".concat(String.valueOf(str)));
    }

    public final void onReceivedError(WebView webView, int i, String str, String str2) {
        com.google.ads.interactivemedia.v3.impl.data.m.c("Error: " + i + " " + str + " " + str2);
    }

    public final boolean shouldOverrideUrlLoading(WebView webView, String str) {
        if (!str.startsWith("gmsg://")) {
            return false;
        }
        this.a.f(str, "0");
        return true;
    }
}
