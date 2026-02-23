package com.google.ads.interactivemedia.v3.internal;

import android.util.Base64;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Random;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ip implements iu {
    public static final atq a = in.a;
    private static final Random b = new Random();
    private it g;
    private String i;
    private final atq f = a;
    private final bd c = new bd();
    private final bc d = new bc();
    private final HashMap e = new HashMap();
    private be h = be.a;

    public static /* bridge */ /* synthetic */ bc a(ip ipVar) {
        return ipVar.d;
    }

    public static /* bridge */ /* synthetic */ bd b(ip ipVar) {
        return ipVar.c;
    }

    public static /* synthetic */ String c() {
        return l();
    }

    private final io k(int i, te teVar) {
        io ioVar = null;
        long j = Long.MAX_VALUE;
        for (io ioVar2 : this.e.values()) {
            ioVar2.e(i, teVar);
            if (ioVar2.h(i, teVar)) {
                long b2 = io.b(ioVar2);
                if (b2 == -1 || b2 < j) {
                    ioVar = ioVar2;
                    j = b2;
                } else if (b2 == j) {
                    int i2 = cq.a;
                    if (io.c(ioVar) != null && io.c(ioVar2) != null) {
                        ioVar = ioVar2;
                    }
                }
            }
        }
        if (ioVar != null) {
            return ioVar;
        }
        String l = l();
        io ioVar3 = new io(this, l, i, teVar);
        this.e.put(l, ioVar3);
        return ioVar3;
    }

    private static String l() {
        byte[] bArr = new byte[12];
        b.nextBytes(bArr);
        return Base64.encodeToString(bArr, 10);
    }

    private final void m(hv hvVar) {
        if (hvVar.b.p()) {
            this.i = null;
            return;
        }
        io ioVar = (io) this.e.get(this.i);
        io k = k(hvVar.c, hvVar.d);
        this.i = io.d(k);
        h(hvVar);
        te teVar = hvVar.d;
        if (teVar == null || !teVar.b()) {
            return;
        }
        if (ioVar != null && io.b(ioVar) == hvVar.d.d && io.c(ioVar) != null && io.c(ioVar).b == hvVar.d.b && io.c(ioVar).c == hvVar.d.c) {
            return;
        }
        te teVar2 = hvVar.d;
        io.d(k(hvVar.c, new te(teVar2.a, teVar2.d)));
        io.d(k);
    }

    public final synchronized String d() {
        return this.i;
    }

    public final synchronized String e(be beVar, te teVar) {
        return io.d(k(beVar.n(teVar.a, this.d).c, teVar));
    }

    public final synchronized void f(hv hvVar) {
        it itVar;
        this.i = null;
        Iterator it = this.e.values().iterator();
        while (it.hasNext()) {
            io ioVar = (io) it.next();
            it.remove();
            if (io.g(ioVar) && (itVar = this.g) != null) {
                itVar.m(hvVar, io.d(ioVar));
            }
        }
    }

    public final void g(it itVar) {
        this.g = itVar;
    }

    /* JADX WARN: Code restructure failed: missing block: B:20:0x0040, code lost:
    
        if (r9.d.d < com.google.ads.interactivemedia.v3.internal.io.b(r0)) goto L20;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final synchronized void h(com.google.ads.interactivemedia.v3.internal.hv r9) {
        /*
            r8 = this;
            monitor-enter(r8)
            com.google.ads.interactivemedia.v3.internal.it r0 = r8.g     // Catch: java.lang.Throwable -> L33
            com.google.ads.interactivemedia.v3.internal.af.s(r0)     // Catch: java.lang.Throwable -> L33
            com.google.ads.interactivemedia.v3.internal.be r0 = r9.b     // Catch: java.lang.Throwable -> L33
            boolean r0 = r0.p()     // Catch: java.lang.Throwable -> L33
            if (r0 == 0) goto L10
            monitor-exit(r8)
            return
        L10:
            java.util.HashMap r0 = r8.e     // Catch: java.lang.Throwable -> L33
            java.lang.String r1 = r8.i     // Catch: java.lang.Throwable -> L33
            java.lang.Object r0 = r0.get(r1)     // Catch: java.lang.Throwable -> L33
            com.google.ads.interactivemedia.v3.internal.io r0 = (com.google.ads.interactivemedia.v3.internal.io) r0     // Catch: java.lang.Throwable -> L33
            com.google.ads.interactivemedia.v3.internal.te r1 = r9.d     // Catch: java.lang.Throwable -> L33
            if (r1 == 0) goto L44
            if (r0 == 0) goto L44
            long r1 = com.google.ads.interactivemedia.v3.internal.io.b(r0)     // Catch: java.lang.Throwable -> L33
            r3 = -1
            int r5 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r5 != 0) goto L36
            int r0 = com.google.ads.interactivemedia.v3.internal.io.a(r0)     // Catch: java.lang.Throwable -> L33
            int r1 = r9.c     // Catch: java.lang.Throwable -> L33
            if (r0 != r1) goto L42
            goto L44
        L33:
            r9 = move-exception
            goto Ld1
        L36:
            com.google.ads.interactivemedia.v3.internal.te r1 = r9.d     // Catch: java.lang.Throwable -> L33
            long r1 = r1.d     // Catch: java.lang.Throwable -> L33
            long r3 = com.google.ads.interactivemedia.v3.internal.io.b(r0)     // Catch: java.lang.Throwable -> L33
            int r0 = (r1 > r3 ? 1 : (r1 == r3 ? 0 : -1))
            if (r0 >= 0) goto L44
        L42:
            monitor-exit(r8)
            return
        L44:
            int r0 = r9.c     // Catch: java.lang.Throwable -> L33
            com.google.ads.interactivemedia.v3.internal.te r1 = r9.d     // Catch: java.lang.Throwable -> L33
            com.google.ads.interactivemedia.v3.internal.io r0 = r8.k(r0, r1)     // Catch: java.lang.Throwable -> L33
            java.lang.String r1 = r8.i     // Catch: java.lang.Throwable -> L33
            if (r1 != 0) goto L56
            java.lang.String r1 = com.google.ads.interactivemedia.v3.internal.io.d(r0)     // Catch: java.lang.Throwable -> L33
            r8.i = r1     // Catch: java.lang.Throwable -> L33
        L56:
            com.google.ads.interactivemedia.v3.internal.te r1 = r9.d     // Catch: java.lang.Throwable -> L33
            if (r1 == 0) goto La3
            boolean r1 = r1.b()     // Catch: java.lang.Throwable -> L33
            if (r1 == 0) goto La3
            com.google.ads.interactivemedia.v3.internal.te r1 = new com.google.ads.interactivemedia.v3.internal.te     // Catch: java.lang.Throwable -> L33
            com.google.ads.interactivemedia.v3.internal.te r2 = r9.d     // Catch: java.lang.Throwable -> L33
            java.lang.Object r3 = r2.a     // Catch: java.lang.Throwable -> L33
            long r4 = r2.d     // Catch: java.lang.Throwable -> L33
            int r2 = r2.b     // Catch: java.lang.Throwable -> L33
            r1.<init>(r3, r4, r2)     // Catch: java.lang.Throwable -> L33
            int r2 = r9.c     // Catch: java.lang.Throwable -> L33
            com.google.ads.interactivemedia.v3.internal.io r1 = r8.k(r2, r1)     // Catch: java.lang.Throwable -> L33
            boolean r2 = com.google.ads.interactivemedia.v3.internal.io.g(r1)     // Catch: java.lang.Throwable -> L33
            if (r2 != 0) goto La3
            com.google.ads.interactivemedia.v3.internal.io.l(r1)     // Catch: java.lang.Throwable -> L33
            com.google.ads.interactivemedia.v3.internal.be r2 = r9.b     // Catch: java.lang.Throwable -> L33
            com.google.ads.interactivemedia.v3.internal.te r3 = r9.d     // Catch: java.lang.Throwable -> L33
            java.lang.Object r3 = r3.a     // Catch: java.lang.Throwable -> L33
            com.google.ads.interactivemedia.v3.internal.bc r4 = r8.d     // Catch: java.lang.Throwable -> L33
            r2.n(r3, r4)     // Catch: java.lang.Throwable -> L33
            com.google.ads.interactivemedia.v3.internal.bc r2 = r8.d     // Catch: java.lang.Throwable -> L33
            com.google.ads.interactivemedia.v3.internal.te r3 = r9.d     // Catch: java.lang.Throwable -> L33
            int r3 = r3.b     // Catch: java.lang.Throwable -> L33
            r2.i(r3)     // Catch: java.lang.Throwable -> L33
            r2 = 0
            long r4 = com.google.ads.interactivemedia.v3.internal.cq.x(r2)     // Catch: java.lang.Throwable -> L33
            com.google.ads.interactivemedia.v3.internal.bc r6 = r8.d     // Catch: java.lang.Throwable -> L33
            long r6 = r6.g()     // Catch: java.lang.Throwable -> L33
            long r4 = r4 + r6
            java.lang.Math.max(r2, r4)     // Catch: java.lang.Throwable -> L33
            com.google.ads.interactivemedia.v3.internal.io.d(r1)     // Catch: java.lang.Throwable -> L33
        La3:
            boolean r1 = com.google.ads.interactivemedia.v3.internal.io.g(r0)     // Catch: java.lang.Throwable -> L33
            if (r1 != 0) goto Laf
            com.google.ads.interactivemedia.v3.internal.io.l(r0)     // Catch: java.lang.Throwable -> L33
            com.google.ads.interactivemedia.v3.internal.io.d(r0)     // Catch: java.lang.Throwable -> L33
        Laf:
            java.lang.String r1 = com.google.ads.interactivemedia.v3.internal.io.d(r0)     // Catch: java.lang.Throwable -> L33
            java.lang.String r2 = r8.i     // Catch: java.lang.Throwable -> L33
            boolean r1 = r1.equals(r2)     // Catch: java.lang.Throwable -> L33
            if (r1 == 0) goto Lcf
            boolean r1 = com.google.ads.interactivemedia.v3.internal.io.f(r0)     // Catch: java.lang.Throwable -> L33
            if (r1 != 0) goto Lcf
            com.google.ads.interactivemedia.v3.internal.io.k(r0)     // Catch: java.lang.Throwable -> L33
            com.google.ads.interactivemedia.v3.internal.it r1 = r8.g     // Catch: java.lang.Throwable -> L33
            java.lang.String r0 = com.google.ads.interactivemedia.v3.internal.io.d(r0)     // Catch: java.lang.Throwable -> L33
            r1.l(r9, r0)     // Catch: java.lang.Throwable -> L33
            monitor-exit(r8)
            return
        Lcf:
            monitor-exit(r8)
            return
        Ld1:
            monitor-exit(r8)
            throw r9
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ip.h(com.google.ads.interactivemedia.v3.internal.hv):void");
    }

    public final synchronized void i(hv hvVar, int i) {
        try {
            af.s(this.g);
            Iterator it = this.e.values().iterator();
            while (it.hasNext()) {
                io ioVar = (io) it.next();
                if (ioVar.i(hvVar)) {
                    it.remove();
                    if (io.g(ioVar)) {
                        boolean equals = io.d(ioVar).equals(this.i);
                        if (i == 0) {
                            if (equals) {
                                io.f(ioVar);
                                this.i = null;
                            }
                            this.g.m(hvVar, io.d(ioVar));
                        } else {
                            if (equals) {
                                this.i = null;
                            }
                            this.g.m(hvVar, io.d(ioVar));
                        }
                    }
                }
            }
            m(hvVar);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final synchronized void j(hv hvVar) {
        try {
            af.s(this.g);
            be beVar = this.h;
            this.h = hvVar.b;
            Iterator it = this.e.values().iterator();
            while (it.hasNext()) {
                io ioVar = (io) it.next();
                if (!ioVar.j(beVar, this.h) || ioVar.i(hvVar)) {
                    it.remove();
                    if (io.g(ioVar)) {
                        if (io.d(ioVar).equals(this.i)) {
                            this.i = null;
                        }
                        this.g.m(hvVar, io.d(ioVar));
                    }
                }
            }
            m(hvVar);
        } catch (Throwable th) {
            throw th;
        }
    }
}
