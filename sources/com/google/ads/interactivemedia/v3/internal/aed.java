package com.google.ads.interactivemedia.v3.internal;

import java.util.Collections;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aed implements adr {
    private final String a;
    private final cj b;
    private final ci c;
    private aae d;
    private String e;
    private s f;
    private int g;
    private int h;
    private int i;
    private int j;
    private long k;
    private boolean l;
    private int m;
    private int n;
    private int o;
    private boolean p;
    private long q;
    private int r;
    private long s;
    private int t;
    private String u;

    public aed(String str) {
        this.a = str;
        cj cjVar = new cj(1024);
        this.b = cjVar;
        this.c = new ci(cjVar.H());
        this.k = -9223372036854775807L;
    }

    private final int f(ci ciVar) throws as {
        int a = ciVar.a();
        yl b = ym.b(ciVar, true);
        this.u = b.c;
        this.r = b.a;
        this.t = b.b;
        return a - ciVar.a();
    }

    private static long g(ci ciVar) {
        return ciVar.c((ciVar.c(2) + 1) * 8);
    }

    public final void a(cj cjVar) throws as {
        int i;
        int i2;
        int i3;
        boolean k;
        af.t(this.d);
        while (cjVar.a() > 0) {
            int i4 = this.g;
            if (i4 != 0) {
                if (i4 == 1) {
                    int i5 = cjVar.i();
                    if ((i5 & 224) == 224) {
                        this.j = i5;
                        this.g = 2;
                    } else if (i5 != 86) {
                        this.g = 0;
                    }
                } else if (i4 != 2) {
                    int min = Math.min(cjVar.a(), this.i - this.h);
                    cjVar.A(this.c.a, this.h, min);
                    int i6 = this.h + min;
                    this.h = i6;
                    if (i6 == this.i) {
                        this.c.g(0);
                        ci ciVar = this.c;
                        if (ciVar.k()) {
                            if (this.l) {
                            }
                            this.g = 0;
                        } else {
                            this.l = true;
                            int c = ciVar.c(1);
                            if (c == 1) {
                                i3 = ciVar.c(1);
                                i2 = 1;
                            } else {
                                i2 = c;
                                i3 = 0;
                            }
                            this.m = i3;
                            if (i3 != 0) {
                                throw as.a(null, null);
                            }
                            if (i2 == 1) {
                                g(ciVar);
                            }
                            if (!ciVar.k()) {
                                throw as.a(null, null);
                            }
                            this.n = ciVar.c(6);
                            int c2 = ciVar.c(4);
                            int c3 = ciVar.c(3);
                            if (c2 != 0 || c3 != 0) {
                                throw as.a(null, null);
                            }
                            if (i2 == 0) {
                                int b = ciVar.b();
                                int f = f(ciVar);
                                ciVar.g(b);
                                byte[] bArr = new byte[(f + 7) / 8];
                                ciVar.m(bArr, f);
                                r rVar = new r();
                                rVar.S(this.e);
                                rVar.ae("audio/mp4a-latm");
                                rVar.I(this.u);
                                rVar.H(this.t);
                                rVar.af(this.r);
                                rVar.T(Collections.singletonList(bArr));
                                rVar.V(this.a);
                                s v = rVar.v();
                                if (!v.equals(this.f)) {
                                    this.f = v;
                                    this.s = 1024000000 / v.z;
                                    this.d.b(v);
                                }
                            } else {
                                ciVar.i(((int) g(ciVar)) - f(ciVar));
                            }
                            int c4 = ciVar.c(3);
                            this.o = c4;
                            if (c4 == 0) {
                                ciVar.i(8);
                            } else if (c4 == 1) {
                                ciVar.i(9);
                            } else if (c4 == 3 || c4 == 4 || c4 == 5) {
                                ciVar.i(6);
                            } else {
                                if (c4 != 6 && c4 != 7) {
                                    throw new IllegalStateException();
                                }
                                ciVar.i(1);
                            }
                            boolean k2 = ciVar.k();
                            this.p = k2;
                            this.q = 0L;
                            if (k2) {
                                if (i2 != 1) {
                                    do {
                                        k = ciVar.k();
                                        this.q = (this.q << 8) + ciVar.c(8);
                                    } while (k);
                                } else {
                                    this.q = g(ciVar);
                                }
                            }
                            if (ciVar.k()) {
                                ciVar.i(8);
                            }
                        }
                        if (this.m != 0) {
                            throw as.a(null, null);
                        }
                        if (this.n != 0) {
                            throw as.a(null, null);
                        }
                        if (this.o != 0) {
                            throw as.a(null, null);
                        }
                        int i7 = 0;
                        while (true) {
                            int c5 = ciVar.c(8);
                            i = i7 + c5;
                            if (c5 != 255) {
                                break;
                            } else {
                                i7 = i;
                            }
                        }
                        int b2 = ciVar.b();
                        if ((b2 & 7) == 0) {
                            this.b.F(b2 >> 3);
                        } else {
                            ciVar.m(this.b.H(), i * 8);
                            this.b.F(0);
                        }
                        this.d.e(this.b, i);
                        long j = this.k;
                        if (j != -9223372036854775807L) {
                            this.d.f(j, 1, i, 0, null);
                            this.k += this.s;
                        }
                        if (this.p) {
                            ciVar.i((int) this.q);
                        }
                        this.g = 0;
                    } else {
                        continue;
                    }
                } else {
                    int i8 = ((this.j & (-225)) << 8) | cjVar.i();
                    this.i = i8;
                    cj cjVar2 = this.b;
                    if (i8 > cjVar2.H().length) {
                        cjVar2.B(i8);
                        this.c.e(this.b.H());
                    }
                    this.h = 0;
                    this.g = 3;
                }
            } else if (cjVar.i() == 86) {
                this.g = 1;
            }
        }
    }

    public final void b(zk zkVar, aet aetVar) {
        aetVar.c();
        this.d = zkVar.i(aetVar.a(), 1);
        this.e = aetVar.b();
    }

    public final void c() {
    }

    public final void d(long j, int i) {
        if (j != -9223372036854775807L) {
            this.k = j;
        }
    }

    public final void e() {
        this.g = 0;
        this.k = -9223372036854775807L;
        this.l = false;
    }
}
