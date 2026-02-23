package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class adx {
    private boolean a;
    private boolean b;
    private zv c;
    private int d;
    private int e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private boolean j;
    private boolean k;
    private int l;
    private int m;
    private int n;
    private int o;
    private int p;

    private adx() {
    }

    public static /* bridge */ /* synthetic */ boolean d(adx adxVar, adx adxVar2) {
        int i;
        int i2;
        int i3;
        boolean z;
        if (!adxVar.a) {
            return false;
        }
        if (!adxVar2.a) {
            return true;
        }
        zv zvVar = adxVar.c;
        af.t(zvVar);
        zv zvVar2 = adxVar2.c;
        af.t(zvVar2);
        return (adxVar.f == adxVar2.f && adxVar.g == adxVar2.g && adxVar.h == adxVar2.h && (!adxVar.i || !adxVar2.i || adxVar.j == adxVar2.j) && (((i = adxVar.d) == (i2 = adxVar2.d) || (i != 0 && i2 != 0)) && ((i3 = zvVar.k) != 0 ? !(i3 == 1 && zvVar2.k == 1 && (adxVar.o != adxVar2.o || adxVar.p != adxVar2.p)) : zvVar2.k != 0 || (adxVar.m == adxVar2.m && adxVar.n == adxVar2.n)) && (z = adxVar.k) == adxVar2.k && (!z || adxVar.l == adxVar2.l))) ? false : true;
    }

    public final void a() {
        this.b = false;
        this.a = false;
    }

    public final void b(zv zvVar, int i, int i2, int i3, int i4, boolean z, boolean z2, boolean z3, boolean z4, int i5, int i6, int i7, int i8, int i9) {
        this.c = zvVar;
        this.d = i;
        this.e = i2;
        this.f = i3;
        this.g = i4;
        this.h = z;
        this.i = z2;
        this.j = z3;
        this.k = z4;
        this.l = i5;
        this.m = i6;
        this.n = i7;
        this.o = i8;
        this.p = i9;
        this.a = true;
        this.b = true;
    }

    public final void c(int i) {
        this.e = i;
        this.b = true;
    }

    public final boolean e() {
        if (!this.b) {
            return false;
        }
        int i = this.e;
        return i == 7 || i == 2;
    }

    public /* synthetic */ adx(byte[] bArr) {
    }
}
