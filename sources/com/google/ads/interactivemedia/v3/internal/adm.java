package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class adm implements zh {
    private final int a;
    private final adn b;
    private final cj c;
    private final cj d;
    private final ci e;
    private zk f;
    private long g;
    private long h;
    private int i;
    private boolean j;
    private boolean k;

    static {
        adj adjVar = adj.a;
    }

    public adm() {
        this(null);
    }

    private final int f(zi ziVar) throws IOException {
        int i = 0;
        while (true) {
            ziVar.f(this.d.H(), 0, 10);
            this.d.F(0);
            if (this.d.k() != 4801587) {
                break;
            }
            this.d.G(3);
            int h = this.d.h();
            i += h + 10;
            ziVar.e(h);
        }
        ziVar.h();
        ziVar.e(i);
        if (this.h == -1) {
            this.h = i;
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:4:0x0023  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean C(com.google.ads.interactivemedia.v3.internal.zi r9) throws java.io.IOException {
        /*
            r8 = this;
            int r0 = r8.f(r9)
            r1 = 0
            r3 = r0
            r2 = 0
            r4 = 0
        L8:
            com.google.ads.interactivemedia.v3.internal.cj r5 = r8.d
            byte[] r5 = r5.H()
            r6 = 2
            r9.f(r5, r1, r6)
            com.google.ads.interactivemedia.v3.internal.cj r5 = r8.d
            r5.F(r1)
            com.google.ads.interactivemedia.v3.internal.cj r5 = r8.d
            int r5 = r5.m()
            boolean r5 = com.google.ads.interactivemedia.v3.internal.adn.f(r5)
            if (r5 != 0) goto L2e
        L23:
            int r3 = r3 + 1
            r9.h()
            r9.e(r3)
            r2 = 0
            r4 = 0
            goto L5b
        L2e:
            r5 = 1
            int r2 = r2 + r5
            r6 = 4
            if (r2 < r6) goto L39
            r7 = 188(0xbc, float:2.63E-43)
            if (r4 > r7) goto L38
            goto L39
        L38:
            return r5
        L39:
            com.google.ads.interactivemedia.v3.internal.cj r5 = r8.d
            byte[] r5 = r5.H()
            r9.f(r5, r1, r6)
            com.google.ads.interactivemedia.v3.internal.ci r5 = r8.e
            r6 = 14
            r5.g(r6)
            com.google.ads.interactivemedia.v3.internal.ci r5 = r8.e
            r6 = 13
            int r5 = r5.c(r6)
            r6 = 6
            if (r5 > r6) goto L55
            goto L23
        L55:
            int r6 = r5 + (-6)
            r9.e(r6)
            int r4 = r4 + r5
        L5b:
            int r5 = r3 - r0
            r6 = 8192(0x2000, float:1.14794E-41)
            if (r5 < r6) goto L8
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.adm.C(com.google.ads.interactivemedia.v3.internal.zi):boolean");
    }

    public final int a(zi ziVar, zy zyVar) throws IOException {
        af.t(this.f);
        int a = ziVar.a(this.c.H(), 0, 2048);
        if (!this.k) {
            this.f.x(new aaa(-9223372036854775807L));
            this.k = true;
        }
        if (a == -1) {
            return -1;
        }
        this.c.F(0);
        this.c.E(a);
        if (!this.j) {
            this.b.d(this.g, 4);
            this.j = true;
        }
        this.b.a(this.c);
        return 0;
    }

    public final void b(zk zkVar) {
        this.f = zkVar;
        this.b.b(zkVar, new aet(0, 1));
        zkVar.n();
    }

    public final void c() {
    }

    public final void d(long j, long j2) {
        this.j = false;
        this.b.e();
        this.g = j2;
    }

    public adm(byte[] bArr) {
        this.a = 0;
        this.b = new adn(true, null);
        this.c = new cj(2048);
        this.i = -1;
        this.h = -1L;
        cj cjVar = new cj(10);
        this.d = cjVar;
        this.e = new ci(cjVar.H());
    }
}
