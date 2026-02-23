package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class gj {
    public hb a;
    public int b;
    public boolean c;
    public int d;
    public boolean e;
    public int f;
    private boolean g;

    public gj(hb hbVar) {
        this.a = hbVar;
    }

    public static /* bridge */ /* synthetic */ boolean e(gj gjVar) {
        return gjVar.g;
    }

    public final void a(int i) {
        this.g = 1 == ((this.g ? 1 : 0) | i);
        this.b += i;
    }

    public final void b(int i) {
        this.g = true;
        this.e = true;
        this.f = i;
    }

    public final void c(hb hbVar) {
        this.g |= this.a != hbVar;
        this.a = hbVar;
    }

    public final void d(int i) {
        if (this.c && this.d != 5) {
            af.u(i == 5);
            return;
        }
        this.g = true;
        this.c = true;
        this.d = i;
    }
}
