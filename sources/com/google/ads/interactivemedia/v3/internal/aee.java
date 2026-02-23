package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aee implements adr {
    private final cj a;
    private final zr b;
    private final String c;
    private aae d;
    private String e;
    private int f;
    private int g;
    private boolean h;
    private boolean i;
    private long j;
    private int k;
    private long l;

    public aee() {
        this(null);
    }

    public final void a(cj cjVar) {
        af.t(this.d);
        while (cjVar.a() > 0) {
            int i = this.f;
            if (i == 0) {
                byte[] H = cjVar.H();
                int d = cjVar.d();
                for (int c = cjVar.c(); c < d; c++) {
                    byte b = H[c];
                    boolean z = (b & 255) == 255;
                    boolean z2 = this.i && (b & 224) == 224;
                    this.i = z;
                    if (z2) {
                        cjVar.F(c + 1);
                        this.i = false;
                        this.a.H()[1] = H[c];
                        this.g = 2;
                        this.f = 1;
                        break;
                        break;
                    }
                }
                cjVar.F(d);
            } else if (i != 1) {
                int min = Math.min(cjVar.a(), this.k - this.g);
                this.d.e(cjVar, min);
                int i2 = this.g + min;
                this.g = i2;
                int i3 = this.k;
                if (i2 >= i3) {
                    long j = this.l;
                    if (j != -9223372036854775807L) {
                        this.d.f(j, 1, i3, 0, null);
                        this.l += this.j;
                    }
                    this.g = 0;
                    this.f = 0;
                }
            } else {
                int min2 = Math.min(cjVar.a(), 4 - this.g);
                cjVar.A(this.a.H(), this.g, min2);
                int i4 = this.g + min2;
                this.g = i4;
                if (i4 >= 4) {
                    this.a.F(0);
                    if (!this.b.a(this.a.e())) {
                        this.g = 0;
                        this.f = 1;
                        break;
                    }
                    this.k = this.b.c;
                    if (!this.h) {
                        this.j = (r0.g * 1000000) / r0.d;
                        r rVar = new r();
                        rVar.S(this.e);
                        rVar.ae(this.b.b);
                        rVar.W(4096);
                        rVar.H(this.b.e);
                        rVar.af(this.b.d);
                        rVar.V(this.c);
                        this.d.b(rVar.v());
                        this.h = true;
                    }
                    this.a.F(0);
                    this.d.e(this.a, 4);
                    this.f = 2;
                }
            }
        }
    }

    public final void b(zk zkVar, aet aetVar) {
        aetVar.c();
        this.e = aetVar.b();
        this.d = zkVar.i(aetVar.a(), 1);
    }

    public final void c() {
    }

    public final void d(long j, int i) {
        if (j != -9223372036854775807L) {
            this.l = j;
        }
    }

    public final void e() {
        this.f = 0;
        this.g = 0;
        this.i = false;
        this.l = -9223372036854775807L;
    }

    public aee(String str) {
        this.f = 0;
        cj cjVar = new cj(4);
        this.a = cjVar;
        cjVar.H()[0] = -1;
        this.b = new zr();
        this.l = -9223372036854775807L;
        this.c = str;
    }
}
