package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ack implements ach {
    private final cj a;
    private final int b;
    private final int c;
    private int d;
    private int e;

    public ack(acd acdVar) {
        cj cjVar = acdVar.a;
        this.a = cjVar;
        cjVar.F(12);
        this.c = cjVar.l() & 255;
        this.b = cjVar.l();
    }

    public final int a() {
        return -1;
    }

    public final int b() {
        return this.b;
    }

    public final int c() {
        int i = this.c;
        if (i == 8) {
            return this.a.i();
        }
        if (i == 16) {
            return this.a.m();
        }
        int i2 = this.d;
        this.d = i2 + 1;
        if (i2 % 2 != 0) {
            return this.e & 15;
        }
        int i3 = this.a.i();
        this.e = i3;
        return (i3 & 240) >> 4;
    }
}
