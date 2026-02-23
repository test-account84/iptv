package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class pt implements Runnable {
    public final /* synthetic */ pu a;
    public final /* synthetic */ Uri b;

    public /* synthetic */ pt(pu puVar, Uri uri) {
        this.a = puVar;
        this.b = uri;
    }

    public final void run() {
        this.a.j(this.b);
    }
}
