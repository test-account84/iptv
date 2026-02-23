package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class acf {
    public final int a;
    public int b;
    public int c;
    public long d;
    private final boolean e;
    private final cj f;
    private final cj g;
    private int h;
    private int i;

    public acf(cj cjVar, cj cjVar2, boolean z) throws as {
        this.g = cjVar;
        this.f = cjVar2;
        this.e = z;
        cjVar2.F(12);
        this.a = cjVar2.l();
        cjVar.F(12);
        this.i = cjVar.l();
        fz.k(cjVar.e() == 1, "first_chunk must be 1");
        this.b = -1;
    }

    public final boolean a() {
        int i = this.b + 1;
        this.b = i;
        if (i == this.a) {
            return false;
        }
        this.d = this.e ? this.f.q() : this.f.p();
        if (this.b == this.h) {
            this.c = this.g.l();
            this.g.G(4);
            int i2 = this.i - 1;
            this.i = i2;
            this.h = i2 > 0 ? (-1) + this.g.l() : -1;
        }
        return true;
    }
}
