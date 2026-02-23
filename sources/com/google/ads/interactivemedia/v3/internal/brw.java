package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class brw implements bsi {
    private final brs a;
    private final boolean b;
    private final bto c;
    private final bsr d;

    private brw(bto btoVar, bsr bsrVar, brs brsVar, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.c = btoVar;
        this.b = bsr.q(brsVar);
        this.d = bsrVar;
        this.a = brsVar;
    }

    public static brw c(bto btoVar, bsr bsrVar, brs brsVar) {
        return new brw(btoVar, bsrVar, brsVar, null, null, null);
    }

    public final int a(Object obj) {
        int u = bto.u(this.c.j(obj));
        return this.b ? u + bsr.o(obj).c() : u;
    }

    public final int b(Object obj) {
        int hashCode = this.c.j(obj).hashCode();
        return this.b ? (hashCode * 53) + bsr.o(obj).hashCode() : hashCode;
    }

    public final Object e() {
        brs brsVar = this.a;
        return brsVar instanceof bqn ? ((bqn) brsVar).aA() : brsVar.bp().aZ();
    }

    public final void f(Object obj) {
        this.c.k(obj);
        this.d.l(obj);
    }

    public final void g(Object obj, Object obj2) {
        bsk.Y(this.c, obj, obj2);
        if (this.b) {
            bsk.aa(this.d, obj, obj2);
        }
    }

    public final void h(Object obj, bsd bsdVar, bqb bqbVar) throws IOException {
        boolean Q;
        bto btoVar = this.c;
        Object i = btoVar.i(obj);
        bqe p = bsr.p(obj);
        while (bsdVar.c() != Integer.MAX_VALUE) {
            try {
                int d = bsdVar.d();
                if (d != btm.a) {
                    if (btm.b(d) == 2) {
                        Object n = bsr.n(bqbVar, this.a, btm.a(d));
                        if (n != null) {
                            bsr.r(bsdVar, n, bqbVar, p);
                        } else {
                            Q = btoVar.h(i, bsdVar);
                        }
                    } else {
                        Q = bsdVar.Q();
                    }
                    if (!Q) {
                        btoVar.l(obj, i);
                        return;
                    }
                } else {
                    Object obj2 = null;
                    bpb bpbVar = null;
                    int i2 = 0;
                    while (bsdVar.c() != Integer.MAX_VALUE) {
                        int d2 = bsdVar.d();
                        if (d2 == btm.c) {
                            i2 = bsdVar.j();
                            obj2 = bsr.n(bqbVar, this.a, i2);
                        } else if (d2 == btm.d) {
                            if (obj2 != null) {
                                bsr.r(bsdVar, obj2, bqbVar, p);
                            } else {
                                bpbVar = bsdVar.p();
                            }
                        } else if (!bsdVar.Q()) {
                            break;
                        }
                    }
                    if (bsdVar.d() != btm.b) {
                        throw bqw.b();
                    }
                    if (bpbVar != null) {
                        if (obj2 != null) {
                            bsr.s(bpbVar, obj2, bqbVar, p);
                        } else {
                            bto.q(i, i2, bpbVar);
                        }
                    }
                }
            } catch (Throwable th) {
                btoVar.l(obj, i);
                throw th;
            }
        }
        btoVar.l(obj, i);
    }

    /* JADX WARN: Removed duplicated region for block: B:22:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:24:0x00c3 A[EDGE_INSN: B:24:0x00c3->B:25:0x00c3 BREAK  A[LOOP:1: B:10:0x0069->B:18:0x0069], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void i(java.lang.Object r11, byte[] r12, int r13, int r14, com.google.ads.interactivemedia.v3.internal.boq r15) throws java.io.IOException {
        /*
            r10 = this;
            r0 = r11
            com.google.ads.interactivemedia.v3.internal.bqn r0 = (com.google.ads.interactivemedia.v3.internal.bqn) r0
            com.google.ads.interactivemedia.v3.internal.bsx r1 = r0.c
            com.google.ads.interactivemedia.v3.internal.bsx r2 = com.google.ads.interactivemedia.v3.internal.bsx.c()
            if (r1 != r2) goto L11
            com.google.ads.interactivemedia.v3.internal.bsx r1 = com.google.ads.interactivemedia.v3.internal.bsx.e()
            r0.c = r1
        L11:
            com.google.ads.interactivemedia.v3.internal.bql r11 = (com.google.ads.interactivemedia.v3.internal.bql) r11
            com.google.ads.interactivemedia.v3.internal.bqe r11 = r11.f()
            r0 = 0
            r2 = r0
        L19:
            if (r13 >= r14) goto Lcf
            int r4 = com.google.ads.interactivemedia.v3.internal.bpd.n(r12, r13, r15)
            int r13 = r15.a
            int r3 = com.google.ads.interactivemedia.v3.internal.btm.a
            r5 = 2
            if (r13 == r3) goto L67
            int r3 = com.google.ads.interactivemedia.v3.internal.btm.b(r13)
            if (r3 != r5) goto L62
            com.google.ads.interactivemedia.v3.internal.bqb r2 = r15.d
            com.google.ads.interactivemedia.v3.internal.brs r3 = r10.a
            int r5 = com.google.ads.interactivemedia.v3.internal.btm.a(r13)
            java.lang.Object r8 = com.google.ads.interactivemedia.v3.internal.bsr.n(r2, r3, r5)
            if (r8 == 0) goto L58
            com.google.ads.interactivemedia.v3.internal.bsa r13 = com.google.ads.interactivemedia.v3.internal.bsa.a()
            r2 = r8
            com.google.ads.interactivemedia.v3.internal.bpz r2 = (com.google.ads.interactivemedia.v3.internal.bpz) r2
            com.google.ads.interactivemedia.v3.internal.brs r3 = r2.a
            java.lang.Class r3 = r3.getClass()
            com.google.ads.interactivemedia.v3.internal.bsi r13 = r13.b(r3)
            int r13 = com.google.ads.interactivemedia.v3.internal.bpd.h(r13, r12, r4, r14, r15)
            com.google.ads.interactivemedia.v3.internal.bqm r2 = r2.b
            java.lang.Object r3 = r15.c
            r11.k(r2, r3)
        L56:
            r2 = r8
            goto L19
        L58:
            r2 = r13
            r3 = r12
            r5 = r14
            r6 = r1
            r7 = r15
            int r13 = com.google.ads.interactivemedia.v3.internal.bpd.m(r2, r3, r4, r5, r6, r7)
            goto L56
        L62:
            int r13 = com.google.ads.interactivemedia.v3.internal.bpd.t(r13, r12, r4, r14, r15)
            goto L19
        L67:
            r13 = 0
            r3 = r0
        L69:
            if (r4 >= r14) goto Lc3
            int r4 = com.google.ads.interactivemedia.v3.internal.bpd.n(r12, r4, r15)
            int r6 = r15.a
            int r7 = com.google.ads.interactivemedia.v3.internal.btm.b(r6)
            int r8 = com.google.ads.interactivemedia.v3.internal.btm.a(r6)
            if (r8 == r5) goto La9
            r9 = 3
            if (r8 == r9) goto L7f
            goto Lba
        L7f:
            if (r2 == 0) goto L9e
            com.google.ads.interactivemedia.v3.internal.bsa r6 = com.google.ads.interactivemedia.v3.internal.bsa.a()
            r7 = r2
            com.google.ads.interactivemedia.v3.internal.bpz r7 = (com.google.ads.interactivemedia.v3.internal.bpz) r7
            com.google.ads.interactivemedia.v3.internal.brs r8 = r7.a
            java.lang.Class r8 = r8.getClass()
            com.google.ads.interactivemedia.v3.internal.bsi r6 = r6.b(r8)
            int r4 = com.google.ads.interactivemedia.v3.internal.bpd.h(r6, r12, r4, r14, r15)
            com.google.ads.interactivemedia.v3.internal.bqm r6 = r7.b
            java.lang.Object r7 = r15.c
            r11.k(r6, r7)
            goto L69
        L9e:
            if (r7 != r5) goto Lba
            int r4 = com.google.ads.interactivemedia.v3.internal.bpd.e(r12, r4, r15)
            java.lang.Object r3 = r15.c
            com.google.ads.interactivemedia.v3.internal.bpb r3 = (com.google.ads.interactivemedia.v3.internal.bpb) r3
            goto L69
        La9:
            if (r7 != 0) goto Lba
            int r4 = com.google.ads.interactivemedia.v3.internal.bpd.n(r12, r4, r15)
            int r13 = r15.a
            com.google.ads.interactivemedia.v3.internal.bqb r2 = r15.d
            com.google.ads.interactivemedia.v3.internal.brs r6 = r10.a
            java.lang.Object r2 = com.google.ads.interactivemedia.v3.internal.bsr.n(r2, r6, r13)
            goto L69
        Lba:
            int r7 = com.google.ads.interactivemedia.v3.internal.btm.b
            if (r6 == r7) goto Lc3
            int r4 = com.google.ads.interactivemedia.v3.internal.bpd.t(r6, r12, r4, r14, r15)
            goto L69
        Lc3:
            if (r3 == 0) goto Lcc
            int r13 = com.google.ads.interactivemedia.v3.internal.btm.c(r13, r5)
            r1.i(r13, r3)
        Lcc:
            r13 = r4
            goto L19
        Lcf:
            if (r13 != r14) goto Ld2
            return
        Ld2:
            com.google.ads.interactivemedia.v3.internal.bqw r11 = com.google.ads.interactivemedia.v3.internal.bqw.g()
            throw r11
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.brw.i(java.lang.Object, byte[], int, int, com.google.ads.interactivemedia.v3.internal.boq):void");
    }

    public final void j(Object obj, btn btnVar) throws IOException {
        Iterator g = bsr.o(obj).g();
        while (g.hasNext()) {
            Map.Entry entry = (Map.Entry) g.next();
            bqd bqdVar = (bqd) entry.getKey();
            if (bqdVar.d() != btl.i || bqdVar.e()) {
                throw new IllegalStateException("Found invalid MessageSet item.");
            }
            bqdVar.g();
            btnVar.x(bqdVar.a(), entry instanceof bqz ? ((bqz) entry).a().b() : entry.getValue());
        }
        bto.z(this.c.j(obj), btnVar);
    }

    public final boolean k(Object obj, Object obj2) {
        if (!this.c.j(obj).equals(this.c.j(obj2))) {
            return false;
        }
        if (this.b) {
            return bsr.o(obj).equals(bsr.o(obj2));
        }
        return true;
    }

    public final boolean l(Object obj) {
        return bsr.o(obj).n();
    }
}
