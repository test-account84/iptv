package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class yc implements Runnable {
    public final /* synthetic */ yh a;
    public final /* synthetic */ Object b;
    public final /* synthetic */ long c;

    public /* synthetic */ yc(yh yhVar, Object obj, long j) {
        this.a = yhVar;
        this.b = obj;
        this.c = j;
    }

    public final void run() {
        this.a.m(this.b, this.c);
    }
}
