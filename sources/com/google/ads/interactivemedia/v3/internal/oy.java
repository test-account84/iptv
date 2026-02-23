package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.io.EOFException;
import java.io.IOException;
import java.io.InterruptedIOException;
import java.math.BigInteger;
import java.util.List;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class oy extends ve {
    private static final AtomicInteger p = new AtomicInteger();
    private final cj A;
    private final boolean B;
    private final boolean C;
    private final iw D;
    private oz E;
    private pk F;
    private int G;
    private boolean H;
    private volatile boolean I;
    private boolean J;
    private avo K;
    private boolean L;
    private boolean M;
    public final int a;
    public final int b;
    public final Uri c;
    public final boolean d;
    public final int e;
    private final cy q;
    private final dc r;
    private final oz s;
    private final boolean t;
    private final boolean u;
    private final co v;
    private final ox w;
    private final List x;
    private final o y;
    private final aaz z;

    private oy(ox oxVar, cy cyVar, dc dcVar, s sVar, boolean z, cy cyVar2, dc dcVar2, boolean z2, Uri uri, List list, int i, long j, long j2, long j3, int i2, boolean z3, int i3, boolean z4, boolean z5, co coVar, o oVar, oz ozVar, aaz aazVar, cj cjVar, boolean z6, iw iwVar) {
        super(cyVar, dcVar, sVar, i, j, j2, j3);
        this.B = z;
        this.e = i2;
        this.M = z3;
        this.b = i3;
        this.r = dcVar2;
        this.q = cyVar2;
        this.H = dcVar2 != null;
        this.C = z2;
        this.c = uri;
        this.t = z5;
        this.v = coVar;
        this.u = z4;
        this.w = oxVar;
        this.x = list;
        this.y = oVar;
        this.s = ozVar;
        this.z = aazVar;
        this.A = cjVar;
        this.d = z6;
        this.D = iwVar;
        this.K = avo.o();
        this.a = p.getAndIncrement();
    }

    /* JADX WARN: Code restructure failed: missing block: B:17:0x0028, code lost:
    
        if (r5.v != false) goto L19;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static boolean i(com.google.ads.interactivemedia.v3.internal.oy r3, android.net.Uri r4, com.google.ads.interactivemedia.v3.internal.qd r5, com.google.ads.interactivemedia.v3.internal.ov r6, long r7) {
        /*
            r0 = 0
            if (r3 != 0) goto L4
            return r0
        L4:
            android.net.Uri r1 = r3.c
            boolean r4 = r4.equals(r1)
            if (r4 == 0) goto L12
            boolean r4 = r3.J
            if (r4 != 0) goto L11
            goto L12
        L11:
            return r0
        L12:
            com.google.ads.interactivemedia.v3.internal.qb r4 = r6.a
            long r1 = r4.g
            long r7 = r7 + r1
            boolean r1 = r4 instanceof com.google.ads.interactivemedia.v3.internal.py
            r2 = 1
            if (r1 == 0) goto L2e
            com.google.ads.interactivemedia.v3.internal.py r4 = (com.google.ads.interactivemedia.v3.internal.py) r4
            boolean r4 = r4.a
            if (r4 != 0) goto L2a
            int r4 = r6.c
            if (r4 != 0) goto L2c
            boolean r4 = r5.v
            if (r4 == 0) goto L3a
        L2a:
            r4 = 1
            goto L30
        L2c:
            r4 = 0
            goto L30
        L2e:
            boolean r4 = r5.v
        L30:
            if (r4 == 0) goto L3a
            long r3 = r3.m
            int r5 = (r7 > r3 ? 1 : (r7 == r3 ? 0 : -1))
            if (r5 >= 0) goto L39
            goto L3a
        L39:
            return r0
        L3a:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.oy.i(com.google.ads.interactivemedia.v3.internal.oy, android.net.Uri, com.google.ads.interactivemedia.v3.internal.qd, com.google.ads.interactivemedia.v3.internal.ov, long):boolean");
    }

    public static oy j(ox oxVar, cy cyVar, s sVar, long j, qd qdVar, ov ovVar, Uri uri, List list, int i, boolean z, vk vkVar, oy oyVar, byte[] bArr, byte[] bArr2, boolean z2, iw iwVar) {
        byte[] bArr3;
        dc dcVar;
        cy cyVar2;
        boolean z3;
        aaz aazVar;
        oz ozVar;
        cj cjVar;
        byte[] bArr4;
        qb qbVar = ovVar.a;
        db dbVar = new db();
        dbVar.i(af.l(qdVar.t, qbVar.c));
        dbVar.h(qbVar.k);
        dbVar.g(qbVar.l);
        dbVar.b(true != ovVar.d ? 0 : 8);
        dc a = dbVar.a();
        boolean z4 = bArr != null;
        if (z4) {
            String str = qbVar.j;
            af.s(str);
            bArr3 = q(str);
        } else {
            bArr3 = null;
        }
        cy o = o(cyVar, bArr, bArr3);
        qa qaVar = qbVar.d;
        if (qaVar != null) {
            boolean z5 = bArr2 != null;
            if (z5) {
                String str2 = qaVar.j;
                af.s(str2);
                bArr4 = q(str2);
            } else {
                bArr4 = null;
            }
            dc dcVar2 = new dc(af.l(qdVar.t, qaVar.c), qaVar.k, qaVar.l);
            z3 = z5;
            cyVar2 = o(cyVar, bArr2, bArr4);
            dcVar = dcVar2;
        } else {
            dcVar = null;
            cyVar2 = null;
            z3 = false;
        }
        long j2 = j + qbVar.g;
        long j3 = j2 + qbVar.e;
        int i2 = qdVar.g + qbVar.f;
        if (oyVar != null) {
            dc dcVar3 = oyVar.r;
            boolean z6 = dcVar == dcVar3 || (dcVar != null && dcVar3 != null && dcVar.a.equals(dcVar3.a) && dcVar.e == oyVar.r.e);
            boolean z7 = uri.equals(oyVar.c) && oyVar.J;
            aaz aazVar2 = oyVar.z;
            cj cjVar2 = oyVar.A;
            ozVar = (z6 && z7 && !oyVar.L && oyVar.b == i2) ? oyVar.E : null;
            aazVar = aazVar2;
            cjVar = cjVar2;
        } else {
            aazVar = new aaz(null);
            ozVar = null;
            cjVar = new cj(10);
        }
        return new oy(oxVar, o, a, sVar, z4, cyVar2, dcVar, z3, uri, list, i, j2, j3, ovVar.b, ovVar.c, !ovVar.d, i2, qbVar.m, z, vkVar.b(i2), qbVar.h, ozVar, aazVar, cjVar, z2, iwVar);
    }

    private final long n(zi ziVar) throws IOException {
        ziVar.h();
        try {
            this.A.B(10);
            ziVar.f(this.A.H(), 0, 10);
        } catch (EOFException unused) {
        }
        if (this.A.k() != 4801587) {
            return -9223372036854775807L;
        }
        this.A.G(3);
        int h = this.A.h();
        int i = h + 10;
        if (i > this.A.b()) {
            cj cjVar = this.A;
            byte[] H = cjVar.H();
            cjVar.B(i);
            System.arraycopy(H, 0, this.A.H(), 0, 10);
        }
        ziVar.f(this.A.H(), 10, h);
        ao c = this.z.c(this.A.H(), h);
        if (c == null) {
            return -9223372036854775807L;
        }
        int a = c.a();
        for (int i2 = 0; i2 < a; i2++) {
            an b = c.b(i2);
            if (b instanceof abd) {
                abd abdVar = (abd) b;
                if ("com.apple.streaming.transportStreamTimestamp".equals(abdVar.a)) {
                    System.arraycopy(abdVar.b, 0, this.A.H(), 0, 8);
                    this.A.F(0);
                    this.A.E(8);
                    return this.A.o() & 8589934591L;
                }
            }
        }
        return -9223372036854775807L;
    }

    private static cy o(cy cyVar, byte[] bArr, byte[] bArr2) {
        if (bArr == null) {
            return cyVar;
        }
        af.s(bArr2);
        return new om(cyVar, bArr, bArr2);
    }

    private final void p(cy cyVar, dc dcVar, boolean z, boolean z2) throws IOException {
        dc b;
        cy cyVar2;
        long d;
        long j;
        int i = this.G;
        if (z) {
            r0 = i != 0;
            cyVar2 = cyVar;
            b = dcVar;
        } else {
            b = dcVar.b(i);
            cyVar2 = cyVar;
        }
        try {
            long b2 = cyVar2.b(b);
            if (z2) {
                try {
                    this.v.i(this.t, this.l);
                } catch (InterruptedException unused) {
                    throw new InterruptedIOException();
                }
            }
            zb zbVar = new zb(cyVar, b.e, b2);
            if (this.E == null) {
                long n = n(zbVar);
                zbVar.h();
                oz ozVar = this.s;
                oz a = ozVar != null ? ozVar.a() : ((oo) this.w).a(b.a, this.i, this.x, this.v, cyVar.e(), zbVar);
                this.E = a;
                zh zhVar = ((on) a).a;
                if ((zhVar instanceof adm) || (zhVar instanceof adh) || (zhVar instanceof adk) || (zhVar instanceof aby)) {
                    this.F.A(n != -9223372036854775807L ? this.v.b(n) : this.l);
                } else {
                    this.F.A(0L);
                }
                this.F.u();
                ((on) this.E).a.b(this.F);
            }
            this.F.y(this.y);
            if (r0) {
                zbVar.i(this.G);
            }
            while (!this.I && this.E.c(zbVar)) {
                try {
                    try {
                    } catch (EOFException e) {
                        if ((this.i.e & 16384) == 0) {
                            throw e;
                        }
                        ((on) this.E).a.d(0L, 0L);
                        d = zbVar.d();
                        j = dcVar.e;
                    }
                } catch (Throwable th) {
                    this.G = (int) (zbVar.d() - dcVar.e);
                    throw th;
                }
            }
            d = zbVar.d();
            j = dcVar.e;
            this.G = (int) (d - j);
        } finally {
            af.e(cyVar);
        }
    }

    private static byte[] q(String str) {
        if (com.google.ads.interactivemedia.v3.impl.data.k.d(str).startsWith("0x")) {
            str = str.substring(2);
        }
        byte[] byteArray = new BigInteger(str, 16).toByteArray();
        byte[] bArr = new byte[16];
        int length = byteArray.length;
        int i = length > 16 ? length - 16 : 0;
        System.arraycopy(byteArray, i, bArr, (16 - length) + i, length - i);
        return bArr;
    }

    public final int a(int i) {
        af.w(!this.d);
        if (i >= this.K.size()) {
            return 0;
        }
        return ((Integer) this.K.get(i)).intValue();
    }

    public final void c(pk pkVar, avo avoVar) {
        this.F = pkVar;
        this.K = avoVar;
    }

    public final void d() {
        this.L = true;
    }

    public final void e() throws IOException {
        oz ozVar;
        af.s(this.F);
        if (this.E == null && (ozVar = this.s) != null && ozVar.b()) {
            this.E = this.s;
            this.H = false;
        }
        if (this.H) {
            af.s(this.q);
            af.s(this.r);
            p(this.q, this.r, this.C, false);
            this.G = 0;
            this.H = false;
        }
        if (this.I) {
            return;
        }
        if (!this.u) {
            p(this.n, this.g, this.B, true);
        }
        this.J = !this.I;
    }

    public final void f() {
        this.M = true;
    }

    public final boolean g() {
        return this.J;
    }

    public final boolean h() {
        return this.M;
    }

    public final void r() {
        this.I = true;
    }
}
