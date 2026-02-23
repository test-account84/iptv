package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class eu implements gp {
    private final ho a;
    private final et b;
    private hh c;
    private gp d;
    private boolean e = true;
    private boolean f;

    public eu(et etVar, bn bnVar) {
        this.b = etVar;
        this.a = new ho(bnVar);
    }

    public final long a() {
        throw null;
    }

    /* JADX WARN: Removed duplicated region for block: B:27:0x005b  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long b(boolean r6) {
        /*
            r5 = this;
            com.google.ads.interactivemedia.v3.internal.hh r0 = r5.c
            if (r0 == 0) goto L66
            boolean r0 = r0.N()
            if (r0 != 0) goto L66
            com.google.ads.interactivemedia.v3.internal.hh r0 = r5.c
            boolean r0 = r0.O()
            if (r0 != 0) goto L1d
            if (r6 != 0) goto L66
            com.google.ads.interactivemedia.v3.internal.hh r6 = r5.c
            boolean r6 = r6.G()
            if (r6 == 0) goto L1d
            goto L66
        L1d:
            com.google.ads.interactivemedia.v3.internal.gp r6 = r5.d
            com.google.ads.interactivemedia.v3.internal.af.s(r6)
            long r0 = r6.a()
            boolean r2 = r5.e
            if (r2 == 0) goto L46
            com.google.ads.interactivemedia.v3.internal.ho r2 = r5.a
            long r2 = r2.a()
            int r4 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r4 >= 0) goto L3a
            com.google.ads.interactivemedia.v3.internal.ho r6 = r5.a
            r6.e()
            goto L72
        L3a:
            r2 = 0
            r5.e = r2
            boolean r2 = r5.f
            if (r2 == 0) goto L46
            com.google.ads.interactivemedia.v3.internal.ho r2 = r5.a
            r2.d()
        L46:
            com.google.ads.interactivemedia.v3.internal.ho r2 = r5.a
            r2.b(r0)
            com.google.ads.interactivemedia.v3.internal.au r6 = r6.c()
            com.google.ads.interactivemedia.v3.internal.ho r0 = r5.a
            com.google.ads.interactivemedia.v3.internal.au r0 = r0.c()
            boolean r0 = r6.equals(r0)
            if (r0 != 0) goto L72
            com.google.ads.interactivemedia.v3.internal.ho r0 = r5.a
            r0.g(r6)
            com.google.ads.interactivemedia.v3.internal.et r0 = r5.b
            r0.a(r6)
            goto L72
        L66:
            r6 = 1
            r5.e = r6
            boolean r6 = r5.f
            if (r6 == 0) goto L72
            com.google.ads.interactivemedia.v3.internal.ho r6 = r5.a
            r6.d()
        L72:
            boolean r6 = r5.e
            if (r6 == 0) goto L7d
            com.google.ads.interactivemedia.v3.internal.ho r6 = r5.a
            long r0 = r6.a()
            goto L86
        L7d:
            com.google.ads.interactivemedia.v3.internal.gp r6 = r5.d
            com.google.ads.interactivemedia.v3.internal.af.s(r6)
            long r0 = r6.a()
        L86:
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.eu.b(boolean):long");
    }

    public final au c() {
        gp gpVar = this.d;
        return gpVar != null ? gpVar.c() : this.a.c();
    }

    public final void d(hh hhVar) {
        if (hhVar == this.c) {
            this.d = null;
            this.c = null;
            this.e = true;
        }
    }

    public final void e(hh hhVar) throws ev {
        gp gpVar;
        gp j = hhVar.j();
        if (j == null || j == (gpVar = this.d)) {
            return;
        }
        if (gpVar != null) {
            throw ev.d(new IllegalStateException("Multiple renderer media clocks enabled."), 1000);
        }
        this.d = j;
        this.c = hhVar;
        j.g(this.a.c());
    }

    public final void f(long j) {
        this.a.b(j);
    }

    public final void g(au auVar) {
        gp gpVar = this.d;
        if (gpVar != null) {
            gpVar.g(auVar);
            auVar = this.d.c();
        }
        this.a.g(auVar);
    }

    public final void h() {
        this.f = true;
        this.a.d();
    }

    public final void i() {
        this.f = false;
        this.a.e();
    }
}
