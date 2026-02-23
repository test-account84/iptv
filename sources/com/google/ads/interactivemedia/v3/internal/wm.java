package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class wm implements Runnable {
    public final /* synthetic */ wn a;
    public final /* synthetic */ int b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;

    public /* synthetic */ wm(wn wnVar, int i, long j, long j2) {
        this.a = wnVar;
        this.b = i;
        this.c = j;
        this.d = j2;
    }

    public final void run() {
        wn wnVar = this.a;
        wn.b(wnVar).X(this.b, this.c, this.d);
    }
}
