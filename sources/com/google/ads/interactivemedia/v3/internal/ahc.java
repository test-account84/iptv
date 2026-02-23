package com.google.ads.interactivemedia.v3.internal;

import android.webkit.WebView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ahc implements Runnable {
    final /* synthetic */ WebView a;
    final /* synthetic */ String b;

    public ahc(WebView webView, String str) {
        this.a = webView;
        this.b = str;
    }

    public final void run() {
        this.a.loadUrl(this.b);
    }
}
