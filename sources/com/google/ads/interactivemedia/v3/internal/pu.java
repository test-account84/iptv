package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.os.SystemClock;
import java.io.IOException;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class pu implements ww {
    final /* synthetic */ pv a;
    private final Uri b;
    private final xc c = new xc("DefaultHlsPlaylistTracker:MediaPlaylist");
    private final cy d;
    private qd e;
    private long f;
    private long g;
    private long h;
    private long i;
    private boolean j;
    private IOException k;

    public pu(pv pvVar, Uri uri) {
        this.a = pvVar;
        this.b = uri;
        this.d = pv.B(pvVar).d();
    }

    public static /* bridge */ /* synthetic */ long d(pu puVar) {
        return puVar.i;
    }

    public static /* bridge */ /* synthetic */ Uri e(pu puVar) {
        return puVar.b;
    }

    public static /* bridge */ /* synthetic */ qd f(pu puVar) {
        return puVar.e;
    }

    public static /* bridge */ /* synthetic */ void h(pu puVar, Uri uri) {
        puVar.q(uri);
    }

    public static /* bridge */ /* synthetic */ void i(pu puVar, qd qdVar, sw swVar) {
        puVar.r(qdVar, swVar);
    }

    public static /* bridge */ /* synthetic */ boolean n(pu puVar, long j) {
        puVar.i = SystemClock.elapsedRealtime() + j;
        return puVar.b.equals(pv.e(puVar.a)) && !pv.x(puVar.a);
    }

    private final void p(Uri uri) {
        pv pvVar = this.a;
        xf xfVar = new xf(this.d, uri, 4, pv.l(pvVar).b(pv.j(pvVar), this.e));
        this.c.b(xfVar, this, ws.c(xfVar.c));
        pv.m(this.a).j(new sw(xfVar.b), xfVar.c);
    }

    private final void q(Uri uri) {
        this.i = 0L;
        if (this.j) {
            return;
        }
        xc xcVar = this.c;
        if (xcVar.m() || xcVar.l()) {
            return;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long j = this.h;
        if (elapsedRealtime >= j) {
            p(uri);
        } else {
            this.j = true;
            pv.f(this.a).postDelayed(new pt(this, uri), j - elapsedRealtime);
        }
    }

    private final void r(qd qdVar, sw swVar) {
        boolean z;
        Uri build;
        qd qdVar2 = this.e;
        long elapsedRealtime = SystemClock.elapsedRealtime();
        this.f = elapsedRealtime;
        qd h = pv.h(this.a, qdVar2, qdVar);
        this.e = h;
        IOException iOException = null;
        if (h != qdVar2) {
            this.k = null;
            this.g = elapsedRealtime;
            pv.p(this.a, this.b, h);
        } else if (!h.l) {
            if (qdVar.h + qdVar.o.size() < this.e.h) {
                iOException = new qn();
                z = true;
            } else {
                z = false;
                if (elapsedRealtime - this.g > cq.x(r2.j) * 3.5d) {
                    iOException = new qo();
                }
            }
            if (iOException != null) {
                this.k = iOException;
                pv.C(this.a, this.b, new bdz(iOException, 1), z);
            }
        }
        qd qdVar3 = this.e;
        this.h = elapsedRealtime + cq.x(!qdVar3.s.e ? qdVar3 != qdVar2 ? qdVar3.j : qdVar3.j / 2 : 0L);
        if (this.e.k != -9223372036854775807L || this.b.equals(pv.e(this.a))) {
            qd qdVar4 = this.e;
            if (qdVar4.l) {
                return;
            }
            qc qcVar = qdVar4.s;
            if (qcVar.a != -9223372036854775807L || qcVar.e) {
                Uri.Builder buildUpon = this.b.buildUpon();
                qd qdVar5 = this.e;
                if (qdVar5.s.e) {
                    buildUpon.appendQueryParameter("_HLS_msn", String.valueOf(qdVar5.h + qdVar5.o.size()));
                    qd qdVar6 = this.e;
                    if (qdVar6.k != -9223372036854775807L) {
                        List list = qdVar6.p;
                        int size = list.size();
                        if (!list.isEmpty() && ((py) axo.z(list)).b) {
                            size--;
                        }
                        buildUpon.appendQueryParameter("_HLS_part", String.valueOf(size));
                    }
                }
                qc qcVar2 = this.e.s;
                if (qcVar2.a != -9223372036854775807L) {
                    buildUpon.appendQueryParameter("_HLS_skip", true != qcVar2.b ? "YES" : "v2");
                }
                build = buildUpon.build();
            } else {
                build = this.b;
            }
            q(build);
        }
    }

    public final /* bridge */ /* synthetic */ void bj(wy wyVar, long j, long j2) {
        xf xfVar = (xf) wyVar;
        qh qhVar = (qh) xfVar.d();
        xfVar.c();
        xfVar.f();
        xfVar.a();
        sw swVar = new sw();
        if (qhVar instanceof qd) {
            r((qd) qhVar, swVar);
            pv.m(this.a).f(swVar, 4);
        } else {
            this.k = as.c("Loaded playlist has unexpected type.", null);
            pv.m(this.a).h(swVar, 4, this.k, true);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:19:0x0028  */
    /* JADX WARN: Removed duplicated region for block: B:27:0x002e  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final /* bridge */ /* synthetic */ com.google.ads.interactivemedia.v3.internal.wv bk(com.google.ads.interactivemedia.v3.internal.wy r4, long r5, long r7, java.io.IOException r9, int r10) {
        /*
            r3 = this;
            com.google.ads.interactivemedia.v3.internal.xf r4 = (com.google.ads.interactivemedia.v3.internal.xf) r4
            com.google.ads.interactivemedia.v3.internal.sw r5 = new com.google.ads.interactivemedia.v3.internal.sw
            long r6 = r4.a
            r4.c()
            r4.f()
            r4.a()
            r5.<init>()
            android.net.Uri r6 = r4.c()
            java.lang.String r7 = "_HLS_msn"
            java.lang.String r6 = r6.getQueryParameter(r7)
            boolean r7 = r9 instanceof com.google.ads.interactivemedia.v3.internal.qi
            r8 = 1
            if (r6 != 0) goto L24
            if (r7 == 0) goto L3c
            r7 = 1
        L24:
            boolean r6 = r9 instanceof com.google.ads.interactivemedia.v3.internal.dq
            if (r6 == 0) goto L2e
            r6 = r9
            com.google.ads.interactivemedia.v3.internal.dq r6 = (com.google.ads.interactivemedia.v3.internal.dq) r6
            int r6 = r6.c
            goto L31
        L2e:
            r6 = 2147483647(0x7fffffff, float:NaN)
        L31:
            if (r7 != 0) goto L77
            r7 = 400(0x190, float:5.6E-43)
            if (r6 == r7) goto L77
            r7 = 503(0x1f7, float:7.05E-43)
            if (r6 != r7) goto L3c
            goto L77
        L3c:
            com.google.ads.interactivemedia.v3.internal.bdz r6 = new com.google.ads.interactivemedia.v3.internal.bdz
            r6.<init>(r9, r10)
            com.google.ads.interactivemedia.v3.internal.pv r7 = r3.a
            android.net.Uri r10 = r3.b
            r0 = 0
            boolean r7 = com.google.ads.interactivemedia.v3.internal.pv.C(r7, r10, r6, r0)
            if (r7 == 0) goto L61
            long r6 = com.google.ads.interactivemedia.v3.internal.ws.e(r6)
            r1 = -9223372036854775807(0x8000000000000001, double:-4.9E-324)
            int r10 = (r6 > r1 ? 1 : (r6 == r1 ? 0 : -1))
            if (r10 == 0) goto L5e
            com.google.ads.interactivemedia.v3.internal.wv r6 = com.google.ads.interactivemedia.v3.internal.xc.n(r0, r6)
            goto L63
        L5e:
            com.google.ads.interactivemedia.v3.internal.wv r6 = com.google.ads.interactivemedia.v3.internal.xc.c
            goto L63
        L61:
            com.google.ads.interactivemedia.v3.internal.wv r6 = com.google.ads.interactivemedia.v3.internal.xc.b
        L63:
            boolean r7 = r6.a()
            r7 = r7 ^ r8
            com.google.ads.interactivemedia.v3.internal.pv r8 = r3.a
            com.google.ads.interactivemedia.v3.internal.tj r8 = com.google.ads.interactivemedia.v3.internal.pv.m(r8)
            int r4 = r4.c
            r8.h(r5, r4, r9, r7)
            if (r7 != 0) goto L76
            goto L8f
        L76:
            return r6
        L77:
            long r6 = android.os.SystemClock.elapsedRealtime()
            r3.h = r6
            r3.k()
            com.google.ads.interactivemedia.v3.internal.pv r6 = r3.a
            com.google.ads.interactivemedia.v3.internal.tj r6 = com.google.ads.interactivemedia.v3.internal.pv.m(r6)
            int r7 = com.google.ads.interactivemedia.v3.internal.cq.a
            int r4 = r4.c
            r6.h(r5, r4, r9, r8)
            com.google.ads.interactivemedia.v3.internal.wv r6 = com.google.ads.interactivemedia.v3.internal.xc.b
        L8f:
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.pu.bk(com.google.ads.interactivemedia.v3.internal.wy, long, long, java.io.IOException, int):com.google.ads.interactivemedia.v3.internal.wv");
    }

    public final /* bridge */ /* synthetic */ void bn(wy wyVar, long j, long j2, boolean z) {
        xf xfVar = (xf) wyVar;
        long j3 = xfVar.a;
        xfVar.c();
        xfVar.f();
        xfVar.a();
        pv.m(this.a).d(new sw(), 4);
    }

    public final qd g() {
        return this.e;
    }

    public final /* synthetic */ void j(Uri uri) {
        this.j = false;
        p(uri);
    }

    public final void k() {
        q(this.b);
    }

    public final void l() throws IOException {
        this.c.a();
        IOException iOException = this.k;
        if (iOException != null) {
            throw iOException;
        }
    }

    public final void m() {
        this.c.j();
    }

    public final boolean o() {
        int i;
        if (this.e == null) {
            return false;
        }
        long elapsedRealtime = SystemClock.elapsedRealtime();
        long max = Math.max(30000L, cq.x(this.e.r));
        qd qdVar = this.e;
        return qdVar.l || (i = qdVar.a) == 2 || i == 1 || this.f + max > elapsedRealtime;
    }
}
