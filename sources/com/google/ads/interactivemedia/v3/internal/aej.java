package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aej implements aeu {
    private final aei a;
    private final cj b = new cj(32);
    private int c;
    private int d;
    private boolean e;
    private boolean f;

    public aej(aei aeiVar) {
        this.a = aeiVar;
    }

    public final void a(cj cjVar, int i) {
        int i2 = i & 1;
        int c = i2 != 0 ? cjVar.c() + cjVar.i() : -1;
        if (this.f) {
            if (i2 == 0) {
                return;
            }
            this.f = false;
            cjVar.F(c);
            this.d = 0;
        }
        while (cjVar.a() > 0) {
            int i3 = this.d;
            if (i3 < 3) {
                if (i3 == 0) {
                    int i4 = cjVar.i();
                    cjVar.F(cjVar.c() - 1);
                    if (i4 == 255) {
                        this.f = true;
                        return;
                    }
                }
                int min = Math.min(cjVar.a(), 3 - this.d);
                cjVar.A(this.b.H(), this.d, min);
                int i5 = this.d + min;
                this.d = i5;
                if (i5 == 3) {
                    this.b.F(0);
                    this.b.E(3);
                    this.b.G(1);
                    int i6 = this.b.i();
                    int i7 = this.b.i();
                    this.e = (i6 & 128) != 0;
                    this.c = (((i6 & 15) << 8) | i7) + 3;
                    int b = this.b.b();
                    int i8 = this.c;
                    if (b < i8) {
                        int b2 = this.b.b();
                        this.b.y(Math.min(4098, Math.max(i8, b2 + b2)));
                    }
                }
            } else {
                int min2 = Math.min(cjVar.a(), this.c - i3);
                cjVar.A(this.b.H(), this.d, min2);
                int i9 = this.d + min2;
                this.d = i9;
                int i10 = this.c;
                if (i9 != i10) {
                    continue;
                } else {
                    if (!this.e) {
                        this.b.E(i10);
                    } else {
                        if (cq.ar(this.b.H(), i10) != 0) {
                            this.f = true;
                            return;
                        }
                        this.b.E(this.c - 4);
                    }
                    this.b.F(0);
                    this.a.a(this.b);
                    this.d = 0;
                }
            }
        }
    }

    public final void b(co coVar, zk zkVar, aet aetVar) {
        this.a.b(coVar, zkVar, aetVar);
        this.f = true;
    }

    public final void c() {
        this.f = true;
    }
}
