package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class yd implements Runnable {
    public final /* synthetic */ yh a;
    public final /* synthetic */ long b;
    public final /* synthetic */ int c;
    private final /* synthetic */ int d;

    public /* synthetic */ yd(yh yhVar, int i, long j, int i2) {
        this.d = i2;
        this.a = yhVar;
        this.c = i;
        this.b = j;
    }

    public final void run() {
        if (this.d != 0) {
            this.a.j(this.c, this.b);
        } else {
            this.a.n(this.b, this.c);
        }
    }

    public /* synthetic */ yd(yh yhVar, long j, int i, int i2) {
        this.d = i2;
        this.a = yhVar;
        this.b = j;
        this.c = i;
    }
}
