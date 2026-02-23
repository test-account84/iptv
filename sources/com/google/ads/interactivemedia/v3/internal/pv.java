package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.SystemClock;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class pv implements qq, ww {
    public static final pr a = pr.a;
    private final ql b;
    private tj e;
    private xc f;
    private Handler g;
    private qp h;
    private qg i;
    private Uri j;
    private qd k;
    private boolean l;
    private final oq n;
    private final ws o;
    private final CopyOnWriteArrayList d = new CopyOnWriteArrayList();
    private final HashMap c = new HashMap();
    private long m = -9223372036854775807L;

    public pv(oq oqVar, ws wsVar, ql qlVar, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        this.n = oqVar;
        this.b = qlVar;
        this.o = wsVar;
    }

    public static /* bridge */ /* synthetic */ oq B(pv pvVar) {
        return pvVar.n;
    }

    public static /* bridge */ /* synthetic */ boolean C(pv pvVar, Uri uri, bdz bdzVar, boolean z) {
        Iterator it = pvVar.d.iterator();
        boolean z2 = false;
        while (it.hasNext()) {
            z2 |= !((qm) it.next()).s(uri, bdzVar, z);
        }
        return z2;
    }

    private final Uri D(Uri uri) {
        pz pzVar;
        qd qdVar = this.k;
        if (qdVar == null || !qdVar.s.e || (pzVar = (pz) qdVar.q.get(uri)) == null) {
            return uri;
        }
        Uri.Builder buildUpon = uri.buildUpon();
        buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(pzVar.b));
        int i = pzVar.c;
        if (i != -1) {
            buildUpon.appendQueryParameter("_HLS_part", String.valueOf(i));
        }
        return buildUpon.build();
    }

    private static qa E(qd qdVar, qd qdVar2) {
        int i = (int) (qdVar2.h - qdVar.h);
        List list = qdVar.o;
        if (i < list.size()) {
            return (qa) list.get(i);
        }
        return null;
    }

    public static /* bridge */ /* synthetic */ Uri e(pv pvVar) {
        return pvVar.j;
    }

    public static /* bridge */ /* synthetic */ Handler f(pv pvVar) {
        return pvVar.g;
    }

    public static /* bridge */ /* synthetic */ qd g(pv pvVar) {
        return pvVar.k;
    }

    public static /* bridge */ /* synthetic */ qd h(pv pvVar, qd qdVar, qd qdVar2) {
        long j;
        int i;
        qa E;
        int size;
        int size2;
        int size3;
        if (qdVar != null) {
            long j2 = qdVar2.h;
            long j3 = qdVar.h;
            if (j2 <= j3 && (j2 < j3 || ((size = qdVar2.o.size() - qdVar.o.size()) == 0 ? !((size2 = qdVar2.p.size()) > (size3 = qdVar.p.size()) || (size2 == size3 && qdVar2.l && !qdVar.l)) : size <= 0))) {
                return (!qdVar2.l || qdVar.l) ? qdVar : new qd(qdVar.a, qdVar.t, qdVar.u, qdVar.b, qdVar.d, qdVar.e, qdVar.f, qdVar.g, qdVar.h, qdVar.i, qdVar.j, qdVar.k, qdVar.v, true, qdVar.m, qdVar.n, qdVar.o, qdVar.p, qdVar.s, qdVar.q);
            }
        }
        if (qdVar2.m) {
            j = qdVar2.e;
        } else {
            qd qdVar3 = pvVar.k;
            j = qdVar3 != null ? qdVar3.e : 0L;
            if (qdVar != null) {
                int size4 = qdVar.o.size();
                qa E2 = E(qdVar, qdVar2);
                if (E2 != null) {
                    j = qdVar.e + E2.g;
                } else if (size4 == qdVar2.h - qdVar.h) {
                    j = qdVar.a();
                }
            }
        }
        long j4 = j;
        if (qdVar2.f) {
            i = qdVar2.g;
        } else {
            qd qdVar4 = pvVar.k;
            i = qdVar4 != null ? qdVar4.g : 0;
            if (qdVar != null && (E = E(qdVar, qdVar2)) != null) {
                i = (qdVar.g + E.f) - ((qa) qdVar2.o.get(0)).f;
            }
        }
        return new qd(qdVar2.a, qdVar2.t, qdVar2.u, qdVar2.b, qdVar2.d, j4, true, i, qdVar2.h, qdVar2.i, qdVar2.j, qdVar2.k, qdVar2.v, qdVar2.l, qdVar2.m, qdVar2.n, qdVar2.o, qdVar2.p, qdVar2.s, qdVar2.q);
    }

    public static /* bridge */ /* synthetic */ qg j(pv pvVar) {
        return pvVar.i;
    }

    public static /* bridge */ /* synthetic */ ql l(pv pvVar) {
        return pvVar.b;
    }

    public static /* bridge */ /* synthetic */ tj m(pv pvVar) {
        return pvVar.e;
    }

    public static /* bridge */ /* synthetic */ HashMap n(pv pvVar) {
        return pvVar.c;
    }

    public static /* bridge */ /* synthetic */ CopyOnWriteArrayList o(pv pvVar) {
        return pvVar.d;
    }

    public static /* bridge */ /* synthetic */ void p(pv pvVar, Uri uri, qd qdVar) {
        if (uri.equals(pvVar.j)) {
            if (pvVar.k == null) {
                pvVar.l = !qdVar.l;
                pvVar.m = qdVar.e;
            }
            pvVar.k = qdVar;
            pvVar.h.b(qdVar);
        }
        Iterator it = pvVar.d.iterator();
        while (it.hasNext()) {
            ((qm) it.next()).j();
        }
    }

    public static /* bridge */ /* synthetic */ boolean x(pv pvVar) {
        List list = pvVar.i.c;
        int size = list.size();
        long elapsedRealtime = SystemClock.elapsedRealtime();
        for (int i = 0; i < size; i++) {
            pu puVar = (pu) pvVar.c.get(((qf) list.get(i)).a);
            af.s(puVar);
            if (elapsedRealtime > pu.d(puVar)) {
                Uri e = pu.e(puVar);
                pvVar.j = e;
                pu.h(puVar, pvVar.D(e));
                return true;
            }
        }
        return false;
    }

    public final boolean A(Uri uri) {
        return ((pu) this.c.get(uri)).o();
    }

    public final /* bridge */ /* synthetic */ void bj(wy wyVar, long j, long j2) {
        xf xfVar = (xf) wyVar;
        qh qhVar = (qh) xfVar.d();
        boolean z = qhVar instanceof qd;
        qg a2 = z ? qg.a(qhVar.t) : (qg) qhVar;
        this.i = a2;
        this.j = ((qf) a2.c.get(0)).a;
        this.d.add(new ps(this));
        List list = a2.b;
        int size = list.size();
        for (int i = 0; i < size; i++) {
            Uri uri = (Uri) list.get(i);
            this.c.put(uri, new pu(this, uri));
        }
        xfVar.c();
        xfVar.f();
        xfVar.a();
        sw swVar = new sw();
        pu puVar = (pu) this.c.get(this.j);
        if (z) {
            pu.i(puVar, (qd) qhVar, swVar);
        } else {
            puVar.k();
        }
        this.e.f(swVar, 4);
    }

    public final /* bridge */ /* synthetic */ wv bk(wy wyVar, long j, long j2, IOException iOException, int i) {
        xf xfVar = (xf) wyVar;
        long j3 = xfVar.a;
        xfVar.c();
        xfVar.f();
        xfVar.a();
        sw swVar = new sw();
        long e = ws.e(new bdz(iOException, i));
        boolean z = e == -9223372036854775807L;
        this.e.h(swVar, xfVar.c, iOException, z);
        return z ? xc.c : xc.n(false, e);
    }

    public final /* bridge */ /* synthetic */ void bn(wy wyVar, long j, long j2, boolean z) {
        xf xfVar = (xf) wyVar;
        long j3 = xfVar.a;
        xfVar.c();
        xfVar.f();
        xfVar.a();
        this.e.d(new sw(), 4);
    }

    public final long d() {
        return this.m;
    }

    public final qd i(Uri uri, boolean z) {
        qd g = ((pu) this.c.get(uri)).g();
        if (g != null && z && !uri.equals(this.j)) {
            List list = this.i.c;
            int i = 0;
            while (true) {
                if (i >= list.size()) {
                    break;
                }
                if (uri.equals(((qf) list.get(i)).a)) {
                    qd qdVar = this.k;
                    if (qdVar == null || !qdVar.l) {
                        this.j = uri;
                        pu puVar = (pu) this.c.get(uri);
                        qd f = pu.f(puVar);
                        if (f == null || !f.l) {
                            pu.h(puVar, D(uri));
                        } else {
                            this.k = f;
                            this.h.b(f);
                        }
                    }
                } else {
                    i++;
                }
            }
        }
        return g;
    }

    public final qg k() {
        return this.i;
    }

    public final void q(qm qmVar) {
        this.d.add(qmVar);
    }

    public final void r(Uri uri) throws IOException {
        ((pu) this.c.get(uri)).l();
    }

    public final void s() throws IOException {
        xc xcVar = this.f;
        if (xcVar != null) {
            xcVar.a();
        }
        Uri uri = this.j;
        if (uri != null) {
            r(uri);
        }
    }

    public final void t(Uri uri) {
        ((pu) this.c.get(uri)).k();
    }

    public final void u(qm qmVar) {
        this.d.remove(qmVar);
    }

    public final void v(Uri uri, tj tjVar, qp qpVar) {
        this.g = cq.A();
        this.e = tjVar;
        this.h = qpVar;
        xf xfVar = new xf(this.n.d(), uri, 4, this.b.a());
        af.w(this.f == null);
        xc xcVar = new xc("DefaultHlsPlaylistTracker:MultivariantPlaylist");
        this.f = xcVar;
        xcVar.b(xfVar, this, ws.c(xfVar.c));
        tjVar.j(new sw(xfVar.b), xfVar.c);
    }

    public final void w() {
        this.j = null;
        this.k = null;
        this.i = null;
        this.m = -9223372036854775807L;
        this.f.j();
        this.f = null;
        Iterator it = this.c.values().iterator();
        while (it.hasNext()) {
            ((pu) it.next()).m();
        }
        this.g.removeCallbacksAndMessages((Object) null);
        this.g = null;
        this.c.clear();
    }

    public final boolean y(Uri uri, long j) {
        pu puVar = (pu) this.c.get(uri);
        return (puVar == null || pu.n(puVar, j)) ? false : true;
    }

    public final boolean z() {
        return this.l;
    }
}
