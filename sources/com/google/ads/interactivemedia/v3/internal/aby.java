package com.google.ads.interactivemedia.v3.internal;

import java.io.EOFException;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aby implements zh {
    private final int a;
    private final long b;
    private final cj c;
    private final zr d;
    private final zp e;
    private final aae f;
    private zk g;
    private aae h;
    private aae i;
    private int j;
    private ao k;
    private long l;
    private long m;
    private long n;
    private int o;
    private abz p;
    private boolean q;
    private long r;
    private final wo s;

    static {
        abx abxVar = abx.a;
    }

    public aby() {
        this((byte[]) null);
    }

    /* JADX WARN: Removed duplicated region for block: B:101:0x0068  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x007d  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x003c  */
    /* JADX WARN: Removed duplicated region for block: B:11:0x0057  */
    /* JADX WARN: Removed duplicated region for block: B:38:0x0155  */
    /* JADX WARN: Removed duplicated region for block: B:66:0x024f  */
    /* JADX WARN: Removed duplicated region for block: B:70:? A[RETURN, SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:71:0x015b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int g(com.google.ads.interactivemedia.v3.internal.zi r20) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 631
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.aby.g(com.google.ads.interactivemedia.v3.internal.zi):int");
    }

    private final long h(long j) {
        return this.l + ((j * 1000000) / this.d.d);
    }

    private static boolean i(int i, long j) {
        return ((long) (i & (-128000))) == (j & (-128000));
    }

    private final boolean j(zi ziVar) throws IOException {
        abz abzVar = this.p;
        if (abzVar != null) {
            long a = abzVar.a();
            if (a != -1 && ziVar.c() > a - 4) {
                return true;
            }
        }
        try {
            return !ziVar.k(this.c.H(), 0, 4, true);
        } catch (EOFException unused) {
            return true;
        }
    }

    private final boolean k(zi ziVar, boolean z) throws IOException {
        int i;
        int i2;
        int b;
        int i3 = true != z ? 131072 : 32768;
        ziVar.h();
        if (ziVar.d() == 0) {
            ao d = this.s.d(ziVar, null);
            this.k = d;
            if (d != null) {
                this.e.b(d);
            }
            i2 = (int) ziVar.c();
            if (!z) {
                ziVar.i(i2);
            }
            i = 0;
        } else {
            i = 0;
            i2 = 0;
        }
        int i4 = 0;
        int i5 = 0;
        while (true) {
            if (!j(ziVar)) {
                this.c.F(0);
                int e = this.c.e();
                if ((i == 0 || i(e, i)) && (b = zs.b(e)) != -1) {
                    i4++;
                    if (i4 != 1) {
                        if (i4 == 4) {
                            break;
                        }
                    } else {
                        this.d.a(e);
                        i = e;
                    }
                    ziVar.e(b - 4);
                } else {
                    int i6 = i5 + 1;
                    if (i5 == i3) {
                        if (z) {
                            return false;
                        }
                        throw as.a("Searched too many bytes.", null);
                    }
                    if (z) {
                        ziVar.h();
                        ziVar.e(i2 + i6);
                    } else {
                        ziVar.i(1);
                    }
                    i5 = i6;
                    i = 0;
                    i4 = 0;
                }
            } else if (i4 <= 0) {
                throw new EOFException();
            }
        }
        if (z) {
            ziVar.i(i2 + i5);
        } else {
            ziVar.h();
        }
        this.j = i;
        return true;
    }

    private final abz l(zi ziVar) throws IOException {
        ziVar.f(this.c.H(), 0, 4);
        this.c.F(0);
        this.d.a(this.c.e());
        return new abu(ziVar.b(), ziVar.d(), this.d);
    }

    public final boolean C(zi ziVar) throws IOException {
        return k(ziVar, true);
    }

    public final int a(zi ziVar, zy zyVar) throws IOException {
        af.t(this.h);
        int i = cq.a;
        int g = g(ziVar);
        if (g == -1 && (this.p instanceof abv)) {
            if (this.p.e() != h(this.m)) {
                throw null;
            }
        }
        return g;
    }

    public final void b(zk zkVar) {
        this.g = zkVar;
        aae i = zkVar.i(0, 1);
        this.h = i;
        this.i = i;
        this.g.n();
    }

    public final void c() {
    }

    public final void d(long j, long j2) {
        this.j = 0;
        this.l = -9223372036854775807L;
        this.m = 0L;
        this.o = 0;
        this.r = j2;
        if (this.p instanceof abv) {
            throw null;
        }
    }

    public final void f() {
        this.q = true;
    }

    public aby(long j) {
        this.a = 0;
        this.b = j;
        this.c = new cj(10);
        this.d = new zr();
        this.e = new zp();
        this.l = -9223372036854775807L;
        this.s = new wo(null);
        zg zgVar = new zg();
        this.f = zgVar;
        this.i = zgVar;
    }

    public aby(byte[] bArr) {
        this(-9223372036854775807L);
    }
}
