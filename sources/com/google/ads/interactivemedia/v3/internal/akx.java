package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class akx implements Runnable {
    public final /* synthetic */ aky a;
    public final /* synthetic */ Handler b;
    public final /* synthetic */ long c = 200;

    public /* synthetic */ akx(aky akyVar, Handler handler, long j) {
        this.a = akyVar;
        this.b = handler;
    }

    public final void run() {
        akz.a(this.a, this.b, 200L);
    }
}
