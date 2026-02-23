package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import java.io.IOException;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class tj {
    public final int a;
    public final te b;
    private final CopyOnWriteArrayList c;
    private final long d;

    public tj() {
        this(new CopyOnWriteArrayList(), 0, null, 0L);
    }

    private final long t(long j) {
        long x = cq.x(j);
        if (x == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return this.d + x;
    }

    public final tj a(int i, te teVar, long j) {
        return new tj(this.c, i, teVar, j);
    }

    public final void b(Handler handler, tk tkVar) {
        af.s(handler);
        af.s(tkVar);
        this.c.add(new uc(handler, tkVar));
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.ads.interactivemedia.v3.internal.tk, java.lang.Object] */
    public final void c(tb tbVar) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            uc ucVar = (uc) it.next();
            ?? r2 = ucVar.b;
            cq.at((Handler) ucVar.a, new jg(this, (tk) r2, tbVar, 2));
        }
    }

    public final void d(sw swVar, int i) {
        p(swVar, i, -1, null, 0, -9223372036854775807L, -9223372036854775807L);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.ads.interactivemedia.v3.internal.tk, java.lang.Object] */
    public final void e(sw swVar, tb tbVar) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            uc ucVar = (uc) it.next();
            ?? r4 = ucVar.b;
            cq.at((Handler) ucVar.a, new ti(this, (tk) r4, swVar, tbVar, 1));
        }
    }

    public final void f(sw swVar, int i) {
        q(swVar, i, -1, null, 0, -9223372036854775807L, -9223372036854775807L);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.ads.interactivemedia.v3.internal.tk, java.lang.Object] */
    public final void g(sw swVar, tb tbVar) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            uc ucVar = (uc) it.next();
            ?? r4 = ucVar.b;
            cq.at((Handler) ucVar.a, new ti(this, (tk) r4, swVar, tbVar, 3));
        }
    }

    public final void h(sw swVar, int i, IOException iOException, boolean z) {
        r(swVar, i, -1, null, 0, -9223372036854775807L, -9223372036854775807L, iOException, z);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.ads.interactivemedia.v3.internal.tk, java.lang.Object] */
    public final void i(sw swVar, tb tbVar, IOException iOException, boolean z) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            uc ucVar = (uc) it.next();
            ?? r4 = ucVar.b;
            cq.at((Handler) ucVar.a, new th(this, r4, swVar, tbVar, iOException, z));
        }
    }

    public final void j(sw swVar, int i) {
        s(swVar, i, -1, null, 0, -9223372036854775807L, -9223372036854775807L);
    }

    /* JADX WARN: Type inference failed for: r4v0, types: [com.google.ads.interactivemedia.v3.internal.tk, java.lang.Object] */
    public final void k(sw swVar, tb tbVar) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            uc ucVar = (uc) it.next();
            ?? r4 = ucVar.b;
            cq.at((Handler) ucVar.a, new ti(this, (tk) r4, swVar, tbVar, 2));
        }
    }

    public final void l(tk tkVar) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            uc ucVar = (uc) it.next();
            if (ucVar.b == tkVar) {
                this.c.remove(ucVar);
            }
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.ads.interactivemedia.v3.internal.tk, java.lang.Object] */
    public final void m(tb tbVar) {
        te teVar = this.b;
        af.s(teVar);
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            uc ucVar = (uc) it.next();
            ?? r2 = ucVar.b;
            cq.at((Handler) ucVar.a, new ti(this, (tk) r2, teVar, tbVar, 0));
        }
    }

    public final void n(int i, long j, long j2) {
        m(new tb(1, i, null, 3, t(j), t(j2)));
    }

    public final void o(int i, s sVar, int i2, long j) {
        c(new tb(1, i, sVar, i2, t(j), -9223372036854775807L));
    }

    public final void p(sw swVar, int i, int i2, s sVar, int i3, long j, long j2) {
        e(swVar, new tb(i, i2, sVar, i3, t(j), t(j2)));
    }

    public final void q(sw swVar, int i, int i2, s sVar, int i3, long j, long j2) {
        g(swVar, new tb(i, i2, sVar, i3, t(j), t(j2)));
    }

    public final void r(sw swVar, int i, int i2, s sVar, int i3, long j, long j2, IOException iOException, boolean z) {
        i(swVar, new tb(i, i2, sVar, i3, t(j), t(j2)), iOException, z);
    }

    public final void s(sw swVar, int i, int i2, s sVar, int i3, long j, long j2) {
        k(swVar, new tb(i, i2, sVar, i3, t(j), t(j2)));
    }

    private tj(CopyOnWriteArrayList copyOnWriteArrayList, int i, te teVar, long j) {
        this.c = copyOnWriteArrayList;
        this.a = i;
        this.b = teVar;
        this.d = j;
    }
}
