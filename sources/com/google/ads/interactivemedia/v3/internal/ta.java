package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ta extends uo {
    private final boolean b;
    private final bd c;
    private final bc d;
    private sy e;
    private sx f;
    private boolean g;
    private boolean h;
    private boolean i;

    public ta(tg tgVar, boolean z) {
        super(tgVar);
        boolean z2 = false;
        if (z && tgVar.L()) {
            z2 = true;
        }
        this.b = z2;
        this.c = new bd();
        this.d = new bc();
        be t = tgVar.t();
        if (t == null) {
            this.e = sy.s(tgVar.a());
        } else {
            this.e = sy.t(t, null, null);
            this.i = true;
        }
    }

    private final Object O(Object obj) {
        return (sy.u(this.e) == null || !obj.equals(sy.c)) ? obj : sy.u(this.e);
    }

    private final void P(long j) {
        sx sxVar = this.f;
        int a = this.e.a(sxVar.a.a);
        if (a == -1) {
            return;
        }
        long j2 = this.e.m(a, this.d).d;
        if (j2 != -9223372036854775807L && j >= j2) {
            j = Math.max(0L, j2 - 1);
        }
        sxVar.r(j);
    }

    public final void h() {
    }

    public final be k() {
        return this.e;
    }

    public final te l(te teVar) {
        Object obj = teVar.a;
        if (sy.u(this.e) != null && sy.u(this.e).equals(obj)) {
            obj = sy.c;
        }
        return teVar.c(obj);
    }

    /* JADX WARN: Removed duplicated region for block: B:31:0x006d  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void m(com.google.ads.interactivemedia.v3.internal.be r11) {
        /*
            r10 = this;
            boolean r0 = r10.h
            r6 = 0
            if (r0 == 0) goto L1a
            com.google.ads.interactivemedia.v3.internal.sy r0 = r10.e
            com.google.ads.interactivemedia.v3.internal.sy r0 = r0.r(r11)
            r10.e = r0
            com.google.ads.interactivemedia.v3.internal.sx r0 = r10.f
            if (r0 == 0) goto La6
            long r0 = r0.j()
            r10.P(r0)
            goto La6
        L1a:
            boolean r0 = r11.p()
            if (r0 == 0) goto L37
            boolean r0 = r10.i
            if (r0 == 0) goto L2b
            com.google.ads.interactivemedia.v3.internal.sy r0 = r10.e
            com.google.ads.interactivemedia.v3.internal.sy r0 = r0.r(r11)
            goto L33
        L2b:
            java.lang.Object r0 = com.google.ads.interactivemedia.v3.internal.bd.a
            java.lang.Object r1 = com.google.ads.interactivemedia.v3.internal.sy.c
            com.google.ads.interactivemedia.v3.internal.sy r0 = com.google.ads.interactivemedia.v3.internal.sy.t(r11, r0, r1)
        L33:
            r10.e = r0
            goto La6
        L37:
            com.google.ads.interactivemedia.v3.internal.bd r0 = r10.c
            r1 = 0
            r11.o(r1, r0)
            com.google.ads.interactivemedia.v3.internal.bd r0 = r10.c
            long r2 = r0.m
            java.lang.Object r7 = r0.b
            com.google.ads.interactivemedia.v3.internal.sx r0 = r10.f
            if (r0 == 0) goto L6d
            long r4 = r0.m()
            com.google.ads.interactivemedia.v3.internal.sy r0 = r10.e
            com.google.ads.interactivemedia.v3.internal.sx r8 = r10.f
            com.google.ads.interactivemedia.v3.internal.te r8 = r8.a
            java.lang.Object r8 = r8.a
            com.google.ads.interactivemedia.v3.internal.bc r9 = r10.d
            r0.n(r8, r9)
            com.google.ads.interactivemedia.v3.internal.bc r0 = r10.d
            long r8 = r0.e
            long r8 = r8 + r4
            com.google.ads.interactivemedia.v3.internal.sy r0 = r10.e
            com.google.ads.interactivemedia.v3.internal.bd r4 = r10.c
            com.google.ads.interactivemedia.v3.internal.bd r0 = r0.o(r1, r4)
            long r0 = r0.m
            int r4 = (r8 > r0 ? 1 : (r8 == r0 ? 0 : -1))
            if (r4 == 0) goto L6d
            r4 = r8
            goto L6e
        L6d:
            r4 = r2
        L6e:
            com.google.ads.interactivemedia.v3.internal.bd r1 = r10.c
            com.google.ads.interactivemedia.v3.internal.bc r2 = r10.d
            r3 = 0
            r0 = r11
            android.util.Pair r0 = r0.k(r1, r2, r3, r4)
            java.lang.Object r1 = r0.first
            java.lang.Object r0 = r0.second
            java.lang.Long r0 = (java.lang.Long) r0
            long r2 = r0.longValue()
            boolean r0 = r10.i
            if (r0 == 0) goto L8d
            com.google.ads.interactivemedia.v3.internal.sy r0 = r10.e
            com.google.ads.interactivemedia.v3.internal.sy r0 = r0.r(r11)
            goto L91
        L8d:
            com.google.ads.interactivemedia.v3.internal.sy r0 = com.google.ads.interactivemedia.v3.internal.sy.t(r11, r7, r1)
        L91:
            r10.e = r0
            com.google.ads.interactivemedia.v3.internal.sx r0 = r10.f
            if (r0 == 0) goto La6
            r10.P(r2)
            com.google.ads.interactivemedia.v3.internal.te r0 = r0.a
            java.lang.Object r1 = r0.a
            java.lang.Object r1 = r10.O(r1)
            com.google.ads.interactivemedia.v3.internal.te r6 = r0.c(r1)
        La6:
            r0 = 1
            r10.i = r0
            r10.h = r0
            com.google.ads.interactivemedia.v3.internal.sy r0 = r10.e
            r10.G(r0)
            if (r6 == 0) goto Lba
            com.google.ads.interactivemedia.v3.internal.sx r0 = r10.f
            com.google.ads.interactivemedia.v3.internal.af.s(r0)
            r0.n(r6)
        Lba:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.ta.m(com.google.ads.interactivemedia.v3.internal.be):void");
    }

    public final void o(td tdVar) {
        ((sx) tdVar).s();
        if (tdVar == this.f) {
            this.f = null;
        }
    }

    public final void p() {
        this.h = false;
        this.g = false;
        super.p();
    }

    public final void r() {
        if (this.b) {
            return;
        }
        this.g = true;
        N();
    }

    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final sx q(te teVar, wr wrVar, long j) {
        sx sxVar = new sx(teVar, wrVar, j);
        sxVar.t(((uo) this).a);
        if (this.h) {
            sxVar.n(teVar.c(O(teVar.a)));
        } else {
            this.f = sxVar;
            if (!this.g) {
                this.g = true;
                N();
            }
        }
        return sxVar;
    }
}
