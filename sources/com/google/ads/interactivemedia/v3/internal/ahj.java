package com.google.ads.interactivemedia.v3.internal;

import android.annotation.SuppressLint;
import android.webkit.WebView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ahj extends ahi {
    @SuppressLint({"SetJavaScriptEnabled"})
    public ahj(WebView webView) {
        if (!webView.getSettings().getJavaScriptEnabled()) {
            webView.getSettings().setJavaScriptEnabled(true);
        }
        i(webView);
    }
}
