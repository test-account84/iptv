package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class acr {
    public final aae a;
    public ade d;
    public acn e;
    public int f;
    public int g;
    public int h;
    public int i;
    private boolean l;
    public final add b = new add();
    public final cj c = new cj();
    private final cj j = new cj(1);
    private final cj k = new cj();

    public acr(aae aaeVar, ade adeVar, acn acnVar) {
        this.a = aaeVar;
        this.d = adeVar;
        this.e = acnVar;
        g(adeVar, acnVar);
    }

    public static /* bridge */ /* synthetic */ boolean i(acr acrVar) {
        return acrVar.l;
    }

    public static /* bridge */ /* synthetic */ void k(acr acrVar) {
        acrVar.l = true;
    }

    public final int a() {
        int i = !this.l ? this.d.g[this.f] : this.b.j[this.f] ? 1 : 0;
        return f() != null ? i | 1073741824 : i;
    }

    public final int b() {
        return !this.l ? this.d.d[this.f] : this.b.h[this.f];
    }

    public final int c(int i, int i2) {
        cj cjVar;
        adc f = f();
        if (f == null) {
            return 0;
        }
        int i3 = f.d;
        if (i3 != 0) {
            cjVar = this.b.n;
        } else {
            byte[] bArr = (byte[]) cq.G(f.e);
            cj cjVar2 = this.k;
            int length = bArr.length;
            cjVar2.D(bArr, length);
            cjVar = this.k;
            i3 = length;
        }
        boolean c = this.b.c(this.f);
        boolean z = c || i2 != 0;
        cj cjVar3 = this.j;
        cjVar3.H()[0] = (byte) ((true != z ? 0 : 128) | i3);
        cjVar3.F(0);
        this.a.i(this.j, 1);
        this.a.i(cjVar, i3);
        if (!z) {
            return i3 + 1;
        }
        if (!c) {
            this.c.B(8);
            cj cjVar4 = this.c;
            byte[] H = cjVar4.H();
            H[0] = 0;
            H[1] = 1;
            H[2] = 0;
            H[3] = (byte) i2;
            H[4] = (byte) ((i >> 24) & 255);
            H[5] = (byte) ((i >> 16) & 255);
            H[6] = (byte) ((i >> 8) & 255);
            H[7] = (byte) (i & 255);
            this.a.i(cjVar4, 8);
            return i3 + 9;
        }
        cj cjVar5 = this.b.n;
        int m = cjVar5.m();
        cjVar5.G(-2);
        int i4 = (m * 6) + 2;
        if (i2 != 0) {
            this.c.B(i4);
            byte[] H2 = this.c.H();
            cjVar5.A(H2, 0, i4);
            int i5 = (((H2[2] & 255) << 8) | (H2[3] & 255)) + i2;
            H2[2] = (byte) ((i5 >> 8) & 255);
            H2[3] = (byte) (i5 & 255);
            cjVar5 = this.c;
        }
        this.a.i(cjVar5, i4);
        return i3 + 1 + i4;
    }

    public final long d() {
        return !this.l ? this.d.c[this.f] : this.b.f[this.h];
    }

    public final long e() {
        return !this.l ? this.d.f[this.f] : this.b.a(this.f);
    }

    public final adc f() {
        if (!this.l) {
            return null;
        }
        add addVar = this.b;
        acn acnVar = addVar.a;
        int i = cq.a;
        int i2 = acnVar.a;
        adc adcVar = addVar.m;
        if (adcVar == null) {
            adcVar = this.d.a.a(i2);
        }
        if (adcVar == null || !adcVar.a) {
            return null;
        }
        return adcVar;
    }

    public final void g(ade adeVar, acn acnVar) {
        this.d = adeVar;
        this.e = acnVar;
        this.a.b(adeVar.a.f);
        h();
    }

    public final void h() {
        add addVar = this.b;
        addVar.d = 0;
        addVar.p = 0L;
        addVar.q = false;
        addVar.k = false;
        addVar.o = false;
        addVar.m = null;
        this.f = 0;
        this.h = 0;
        this.g = 0;
        this.i = 0;
        this.l = false;
    }

    public final boolean j() {
        this.f++;
        if (!this.l) {
            return false;
        }
        int i = this.g + 1;
        this.g = i;
        int[] iArr = this.b.g;
        int i2 = this.h;
        if (i != iArr[i2]) {
            return true;
        }
        this.h = i2 + 1;
        this.g = 0;
        return false;
    }
}
