package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class jf implements Runnable {
    public final /* synthetic */ ji a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;

    public /* synthetic */ jf(ji jiVar, String str, long j, long j2) {
        this.a = jiVar;
        this.b = str;
        this.c = j;
        this.d = j2;
    }

    public final void run() {
        this.a.j(this.b, this.c, this.d);
    }
}
