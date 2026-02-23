package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aeh implements aeu {
    private final adr a;
    private final ci b = new ci(new byte[10]);
    private int c = 0;
    private int d;
    private co e;
    private boolean f;
    private boolean g;
    private boolean h;
    private int i;
    private int j;
    private boolean k;
    private long l;

    public aeh(adr adrVar) {
        this.a = adrVar;
    }

    private final void d(int i) {
        this.c = i;
        this.d = 0;
    }

    private final boolean e(cj cjVar, byte[] bArr, int i) {
        int min = Math.min(cjVar.a(), i - this.d);
        if (min <= 0) {
            return true;
        }
        if (bArr == null) {
            cjVar.G(min);
        } else {
            cjVar.A(bArr, this.d, min);
        }
        int i2 = this.d + min;
        this.d = i2;
        return i2 == i;
    }

    public final void a(cj cjVar, int i) throws as {
        af.t(this.e);
        int i2 = -1;
        int i3 = 2;
        if ((i & 1) != 0) {
            int i4 = this.c;
            if (i4 != 0 && i4 != 1) {
                if (i4 != 2) {
                    int i5 = this.j;
                    if (i5 != -1) {
                        cd.e("PesReader", "Unexpected start indicator: expected " + i5 + " more bytes");
                    }
                    this.a.c();
                } else {
                    cd.e("PesReader", "Unexpected start indicator reading extended header");
                }
            }
            d(1);
        }
        int i6 = i;
        while (cjVar.a() > 0) {
            int i7 = this.c;
            if (i7 != 0) {
                if (i7 != 1) {
                    if (i7 != i3) {
                        int a = cjVar.a();
                        int i8 = this.j;
                        int i9 = i8 != i2 ? a - i8 : 0;
                        if (i9 > 0) {
                            a -= i9;
                            cjVar.E(cjVar.c() + a);
                        }
                        this.a.a(cjVar);
                        int i10 = this.j;
                        if (i10 != i2) {
                            int i11 = i10 - a;
                            this.j = i11;
                            if (i11 == 0) {
                                this.a.c();
                                d(1);
                            }
                        }
                    } else {
                        if (e(cjVar, this.b.a, Math.min(10, this.i)) && e(cjVar, null, this.i)) {
                            this.b.g(0);
                            long j = -9223372036854775807L;
                            this.l = -9223372036854775807L;
                            if (this.f) {
                                this.b.i(4);
                                int c = this.b.c(3);
                                this.b.i(1);
                                int c2 = this.b.c(15);
                                this.b.i(1);
                                long c3 = (c2 << 15) | (c << 30) | this.b.c(15);
                                this.b.i(1);
                                if (!this.h && this.g) {
                                    this.b.i(4);
                                    int c4 = this.b.c(3);
                                    this.b.i(1);
                                    int c5 = this.b.c(15);
                                    this.b.i(1);
                                    int c6 = this.b.c(15);
                                    this.b.i(1);
                                    this.e.b((c4 << 30) | (c5 << 15) | c6);
                                    this.h = true;
                                }
                                j = this.e.b(c3);
                                this.l = j;
                            }
                            i6 |= true != this.k ? 0 : 4;
                            this.a.d(j, i6);
                            d(3);
                            i2 = -1;
                        }
                    }
                } else if (e(cjVar, this.b.a, 9)) {
                    int i12 = 0;
                    this.b.g(0);
                    int c7 = this.b.c(24);
                    if (c7 != 1) {
                        cd.e("PesReader", "Unexpected start code prefix: " + c7);
                        i2 = -1;
                        this.j = -1;
                    } else {
                        this.b.i(8);
                        int c8 = this.b.c(16);
                        this.b.i(5);
                        this.k = this.b.k();
                        this.b.i(2);
                        this.f = this.b.k();
                        this.g = this.b.k();
                        this.b.i(6);
                        int c9 = this.b.c(8);
                        this.i = c9;
                        if (c8 == 0) {
                            this.j = -1;
                        } else {
                            int i13 = (c8 - 3) - c9;
                            this.j = i13;
                            if (i13 < 0) {
                                cd.e("PesReader", "Found negative packet payload size: " + i13);
                                i2 = -1;
                                this.j = -1;
                            }
                            i12 = 2;
                        }
                        i2 = -1;
                        i12 = 2;
                    }
                    d(i12);
                } else {
                    i2 = -1;
                }
            } else {
                cjVar.G(cjVar.a());
            }
            i3 = 2;
        }
    }

    public final void b(co coVar, zk zkVar, aet aetVar) {
        this.e = coVar;
        this.a.b(zkVar, aetVar);
    }

    public final void c() {
        this.c = 0;
        this.d = 0;
        this.h = false;
        this.a.e();
    }
}
