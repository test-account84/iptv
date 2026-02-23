package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class yf implements Runnable {
    public final /* synthetic */ yh a;
    public final /* synthetic */ String b;
    public final /* synthetic */ long c;
    public final /* synthetic */ long d;

    public /* synthetic */ yf(yh yhVar, String str, long j, long j2) {
        this.a = yhVar;
        this.b = str;
        this.c = j;
        this.d = j2;
    }

    public final void run() {
        this.a.g(this.b, this.c, this.d);
    }
}
