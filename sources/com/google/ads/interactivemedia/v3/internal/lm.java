package com.google.ads.interactivemedia.v3.internal;

import android.os.SystemClock;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class lm implements ku {
    protected final lk[] a;
    private final xd b;
    private final int[] c;
    private final int d;
    private final cy e;
    private final long f;
    private final lq g;
    private we h;
    private lu i;
    private int j;
    private IOException k;
    private boolean l;
    private final ly m;

    public lm(xd xdVar, lu luVar, ly lyVar, int i, int[] iArr, we weVar, int i2, cy cyVar, long j, boolean z, List list, lq lqVar, byte[] bArr) {
        zh acsVar;
        this.b = xdVar;
        this.i = luVar;
        this.m = lyVar;
        this.c = iArr;
        this.h = weVar;
        this.d = i2;
        this.e = cyVar;
        this.j = i;
        this.f = j;
        this.g = lqVar;
        long c = luVar.c(i);
        ArrayList m = m();
        this.a = new lk[weVar.n()];
        int i3 = 0;
        int i4 = 0;
        while (i4 < this.a.length) {
            me meVar = (me) m.get(weVar.j(i4));
            lt c2 = lyVar.c(meVar.c);
            lk[] lkVarArr = this.a;
            lt ltVar = c2 == null ? (lt) meVar.c.get(i3) : c2;
            s sVar = meVar.b;
            String str = sVar.k;
            ut utVar = null;
            if (!ar.p(str)) {
                if (ar.o(str)) {
                    acsVar = new abr(1);
                } else {
                    acsVar = new acs(true != z ? 0 : 4, null, list, lqVar);
                }
                utVar = new ut(acsVar, i2, sVar);
            }
            int i5 = i4;
            lkVarArr[i5] = new lk(c, meVar, ltVar, utVar, 0L, meVar.k());
            i4 = i5 + 1;
            i3 = 0;
        }
    }

    private final long k(long j) {
        lu luVar = this.i;
        long j2 = luVar.a;
        if (j2 == -9223372036854775807L) {
            return -9223372036854775807L;
        }
        return j - cq.t(j2 + luVar.d(this.j).b);
    }

    private final lk l(int i) {
        lk lkVar = this.a[i];
        lt c = this.m.c(lkVar.b.c);
        if (c == null || c.equals(lkVar.c)) {
            return lkVar;
        }
        lk k = lkVar.k(c);
        this.a[i] = k;
        return k;
    }

    private final ArrayList m() {
        List list = this.i.d(this.j).c;
        ArrayList arrayList = new ArrayList();
        for (int i : this.c) {
            arrayList.addAll(((ls) list.get(i)).c);
        }
        return arrayList;
    }

    private static final long n(lk lkVar, ve veVar, long j, long j2, long j3) {
        return veVar != null ? veVar.s() : cq.p(lkVar.g(j), j2, j3);
    }

    public final void a(lu luVar, int i) {
        try {
            this.i = luVar;
            this.j = i;
            long c = luVar.c(i);
            ArrayList m = m();
            for (int i2 = 0; i2 < this.a.length; i2++) {
                me meVar = (me) m.get(this.h.j(i2));
                lk[] lkVarArr = this.a;
                lkVarArr[i2] = lkVarArr[i2].i(c, meVar);
            }
        } catch (sb e) {
            this.k = e;
        }
    }

    public final void b(we weVar) {
        this.h = weVar;
    }

    public final int c(long j, List list) {
        return (this.k != null || this.h.n() < 2) ? list.size() : this.h.e(j, list);
    }

    public final long d(long j, hl hlVar) {
        for (lk lkVar : this.a) {
            if (lkVar.d != null) {
                long g = lkVar.g(j);
                long h = lkVar.h(g);
                long e = lkVar.e();
                return hlVar.a(j, h, (h >= j || (e != -1 && g >= (lkVar.c() + e) + (-1))) ? h : lkVar.h(g + 1));
            }
        }
        return j;
    }

    public final void e(long j, long j2, List list, uw uwVar) {
        uu vbVar;
        long j3;
        int i;
        vg[] vgVarArr;
        int i2;
        if (this.k != null) {
            return;
        }
        long j4 = j2 - j;
        long t = cq.t(this.i.a) + cq.t(this.i.d(this.j).b) + j2;
        lq lqVar = this.g;
        if (lqVar == null || !lqVar.a.f(t)) {
            long t2 = cq.t(cq.r(this.f));
            long k = k(t2);
            ve veVar = list.isEmpty() ? null : (ve) list.get(list.size() - 1);
            int n = this.h.n();
            vg[] vgVarArr2 = new vg[n];
            int i3 = 0;
            while (i3 < n) {
                lk lkVar = this.a[i3];
                if (lkVar.d == null) {
                    vgVarArr2[i3] = vg.a;
                    vgVarArr = vgVarArr2;
                    i2 = n;
                    j3 = k;
                    i = i3;
                } else {
                    long b = lkVar.b(t2);
                    long d = lkVar.d(t2);
                    j3 = k;
                    i = i3;
                    vgVarArr = vgVarArr2;
                    i2 = n;
                    long n2 = n(lkVar, veVar, j2, b, d);
                    if (n2 < b) {
                        vgVarArr[i] = vg.a;
                    } else {
                        vgVarArr[i] = new ll(l(i), n2, d);
                    }
                }
                i3 = i + 1;
                k = j3;
                vgVarArr2 = vgVarArr;
                n = i2;
            }
            long j5 = k;
            this.h.d(j4, !this.i.d ? -9223372036854775807L : Math.max(0L, Math.min(k(t2), this.a[0].f(this.a[0].d(t2))) - j), list, vgVarArr2);
            lk l = l(this.h.a());
            uv uvVar = l.a;
            if (uvVar != null) {
                me meVar = l.b;
                mb n3 = uvVar.d() == null ? meVar.n() : null;
                mb l2 = l.d == null ? meVar.l() : null;
                if (n3 != null || l2 != null) {
                    cy cyVar = this.e;
                    s p = this.h.p();
                    int b2 = this.h.b();
                    this.h.c();
                    me meVar2 = l.b;
                    if (n3 == null || (l2 = n3.b(l2, l.c.a)) != null) {
                        n3 = l2;
                    }
                    uwVar.a = new vd(cyVar, pi.e(meVar2, l.c.a, n3, 0), p, b2, l.a);
                    return;
                }
            }
            long a = lk.a(l);
            boolean z = a != -9223372036854775807L;
            if (l.e() == 0) {
                uwVar.b = z;
                return;
            }
            long b3 = l.b(t2);
            long d2 = l.d(t2);
            boolean z2 = z;
            long n4 = n(l, veVar, j2, b3, d2);
            if (n4 < b3) {
                this.k = new sb();
                return;
            }
            if (n4 > d2 || (this.l && n4 >= d2)) {
                uwVar.b = z2;
                return;
            }
            if (z2 && l.h(n4) >= a) {
                uwVar.b = true;
                return;
            }
            int min = (int) Math.min(1L, (d2 - n4) + 1);
            if (a != -9223372036854775807L) {
                for (int i4 = 1; min > i4 && l.h((min + n4) - 1) >= a; i4 = 1) {
                    min--;
                }
            }
            long j6 = true != list.isEmpty() ? -9223372036854775807L : j2;
            cy cyVar2 = this.e;
            int i5 = this.d;
            s p2 = this.h.p();
            int b4 = this.h.b();
            this.h.c();
            me meVar3 = l.b;
            long h = l.h(n4);
            mb l3 = l.l(n4);
            if (l.a == null) {
                vbVar = new vh(cyVar2, pi.e(meVar3, l.c.a, l3, true != l.m(n4, j5) ? 8 : 0), p2, b4, h, l.f(n4), n4, i5, p2);
            } else {
                int i6 = 1;
                int i7 = 1;
                while (i6 < min) {
                    mb b5 = l3.b(l.l(i6 + n4), l.c.a);
                    if (b5 == null) {
                        break;
                    }
                    i7++;
                    i6++;
                    l3 = b5;
                }
                long j7 = (i7 + n4) - 1;
                long f = l.f(j7);
                long a2 = lk.a(l);
                vbVar = new vb(cyVar2, pi.e(meVar3, l.c.a, l3, true != l.m(j7, j5) ? 8 : 0), p2, b4, h, f, j6, (a2 == -9223372036854775807L || a2 > f) ? -9223372036854775807L : a2, n4, i7, -meVar3.d, l.a);
            }
            uwVar.a = vbVar;
        }
    }

    public final void f() throws IOException {
        IOException iOException = this.k;
        if (iOException != null) {
            throw iOException;
        }
        this.b.a();
    }

    public final void g(uu uuVar) {
        yz a;
        if (uuVar instanceof vd) {
            int m = this.h.m(((vd) uuVar).i);
            lk lkVar = this.a[m];
            if (lkVar.d == null && (a = lkVar.a.a()) != null) {
                this.a[m] = lkVar.j(new lj(a, lkVar.b.d));
            }
        }
        lq lqVar = this.g;
        if (lqVar != null) {
            lqVar.c(uuVar);
        }
    }

    public final void h() {
        for (lk lkVar : this.a) {
            uv uvVar = lkVar.a;
            if (uvVar != null) {
                uvVar.b();
            }
        }
    }

    public final void i(long j, uu uuVar, List list) {
        if (this.k != null) {
            return;
        }
        this.h.t();
    }

    public final boolean j(uu uuVar, boolean z, bdz bdzVar, ws wsVar) {
        wv d;
        if (!z) {
            return false;
        }
        lq lqVar = this.g;
        if (lqVar != null && lqVar.g(uuVar)) {
            return true;
        }
        if (!this.i.d && (uuVar instanceof ve)) {
            Object obj = bdzVar.a;
            if ((obj instanceof dq) && ((dq) obj).c == 404) {
                long e = this.a[this.h.m(uuVar.i)].e();
                if (e != -1 && e != 0) {
                    if (((ve) uuVar).s() > (r11.c() + e) - 1) {
                        this.l = true;
                        return true;
                    }
                }
            }
        }
        lk lkVar = this.a[this.h.m(uuVar.i)];
        lt c = this.m.c(lkVar.b.c);
        if (c != null && !lkVar.c.equals(c)) {
            return true;
        }
        we weVar = this.h;
        avo avoVar = lkVar.b.c;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        int n = weVar.n();
        int i = 0;
        for (int i2 = 0; i2 < n; i2++) {
            if (weVar.s(i2, elapsedRealtime)) {
                i++;
            }
        }
        HashSet hashSet = new HashSet();
        for (int i3 = 0; i3 < avoVar.size(); i3++) {
            hashSet.add(Integer.valueOf(((lt) avoVar.get(i3)).c));
        }
        int size = hashSet.size();
        wu wuVar = new wu(size, size - this.m.b(avoVar), n, i);
        if ((wuVar.a(2) || wuVar.a(1)) && (d = ws.d(wuVar, bdzVar)) != null) {
            int i4 = d.a;
            if (wuVar.a(i4)) {
                if (i4 == 2) {
                    we weVar2 = this.h;
                    return weVar2.r(weVar2.m(uuVar.i), d.b);
                }
                this.m.d(lkVar.c, d.b);
                return true;
            }
        }
        return false;
    }
}
