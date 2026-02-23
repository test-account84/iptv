package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class adh implements zh {
    private final adi a = new adi();
    private final cj b = new cj(2786);
    private boolean c;

    static {
        adj adjVar = adj.a;
    }

    /* JADX WARN: Code restructure failed: missing block: B:21:0x0037, code lost:
    
        r8.h();
        r4 = r4 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0040, code lost:
    
        if ((r4 - r3) < 8192) goto L12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0042, code lost:
    
        return false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean C(com.google.ads.interactivemedia.v3.internal.zi r8) throws java.io.IOException {
        /*
            r7 = this;
            com.google.ads.interactivemedia.v3.internal.cj r0 = new com.google.ads.interactivemedia.v3.internal.cj
            r1 = 10
            r0.<init>(r1)
            r2 = 0
            r3 = 0
        L9:
            byte[] r4 = r0.H()
            r8.f(r4, r2, r1)
            r0.F(r2)
            int r4 = r0.k()
            r5 = 4801587(0x494433, float:6.728456E-39)
            if (r4 == r5) goto L5f
            r8.h()
            r8.e(r3)
            r4 = r3
        L23:
            r1 = 0
        L24:
            byte[] r5 = r0.H()
            r6 = 6
            r8.f(r5, r2, r6)
            r0.F(r2)
            int r5 = r0.m()
            r6 = 2935(0xb77, float:4.113E-42)
            if (r5 == r6) goto L47
            r8.h()
            int r4 = r4 + 1
            int r1 = r4 - r3
            r5 = 8192(0x2000, float:1.14794E-41)
            if (r1 < r5) goto L43
            return r2
        L43:
            r8.e(r4)
            goto L23
        L47:
            r5 = 1
            int r1 = r1 + r5
            r6 = 4
            if (r1 < r6) goto L4d
            return r5
        L4d:
            byte[] r5 = r0.H()
            int r5 = com.google.ads.interactivemedia.v3.internal.yo.b(r5)
            r6 = -1
            if (r5 != r6) goto L59
            return r2
        L59:
            int r5 = r5 + (-6)
            r8.e(r5)
            goto L24
        L5f:
            r4 = 3
            r0.G(r4)
            int r4 = r0.h()
            int r5 = r4 + 10
            int r3 = r3 + r5
            r8.e(r4)
            goto L9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.adh.C(com.google.ads.interactivemedia.v3.internal.zi):boolean");
    }

    public final int a(zi ziVar, zy zyVar) throws IOException {
        int a = ziVar.a(this.b.H(), 0, 2786);
        if (a == -1) {
            return -1;
        }
        this.b.F(0);
        this.b.E(a);
        if (!this.c) {
            this.a.d(0L, 4);
            this.c = true;
        }
        this.a.a(this.b);
        return 0;
    }

    public final void b(zk zkVar) {
        this.a.b(zkVar, new aet(0, 1));
        zkVar.n();
        zkVar.x(new aaa(-9223372036854775807L));
    }

    public final void c() {
    }

    public final void d(long j, long j2) {
        this.c = false;
        this.a.e();
    }
}
