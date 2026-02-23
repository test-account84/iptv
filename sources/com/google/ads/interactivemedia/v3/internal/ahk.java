package com.google.ads.interactivemedia.v3.internal;

import android.webkit.WebView;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ahk implements Runnable {
    final /* synthetic */ ahl a;
    private final WebView b;

    public ahk(ahl ahlVar) {
        this.a = ahlVar;
        this.b = ahl.l(ahlVar);
    }

    public final void run() {
        this.b.destroy();
    }
}
