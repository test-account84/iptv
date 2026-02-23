package com.google.ads.interactivemedia.v3.internal;

import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.SystemClock;
import android.util.Pair;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class my implements nm {
    public final List a;
    final oj b;
    final UUID c;
    final mw d;
    private final ob e;
    private final ms f;
    private final mt g;
    private final boolean h;
    private final boolean i;
    private final HashMap j;
    private final bq k;
    private final iw l;
    private int m;
    private int n;
    private HandlerThread o;
    private mu p;
    private ea q;
    private nl r;
    private byte[] s;
    private byte[] t;
    private zo u;
    private aeq v;
    private final ws w;

    public my(UUID uuid, ob obVar, ms msVar, mt mtVar, List list, boolean z, boolean z2, byte[] bArr, HashMap hashMap, oj ojVar, Looper looper, ws wsVar, iw iwVar, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        List unmodifiableList;
        this.c = uuid;
        this.f = msVar;
        this.g = mtVar;
        this.e = obVar;
        this.h = z;
        this.i = z2;
        if (bArr != null) {
            this.t = bArr;
            unmodifiableList = null;
        } else {
            af.s(list);
            unmodifiableList = Collections.unmodifiableList(list);
        }
        this.a = unmodifiableList;
        this.j = hashMap;
        this.b = ojVar;
        this.k = new bq();
        this.w = wsVar;
        this.l = iwVar;
        this.m = 2;
        this.d = new mw(this, looper);
    }

    public static /* bridge */ /* synthetic */ void f(my myVar, Object obj, Object obj2) {
        if (obj == myVar.v && myVar.v()) {
            myVar.v = null;
            if (obj2 instanceof Exception) {
                myVar.t((Exception) obj2, false);
                return;
            }
            try {
                byte[] l = myVar.e.l(myVar.s, (byte[]) obj2);
                if (myVar.t != null && l != null && l.length != 0) {
                    myVar.t = l;
                }
                myVar.m = 4;
                myVar.q(mr.a);
            } catch (Exception e) {
                myVar.t(e, true);
            }
        }
    }

    public static /* bridge */ /* synthetic */ void g(my myVar, Object obj, Object obj2) {
        if (obj == myVar.u) {
            if (myVar.m == 2 || myVar.v()) {
                myVar.u = null;
                if (obj2 instanceof Exception) {
                    myVar.f.b((Exception) obj2, false);
                    return;
                }
                try {
                    myVar.e.e((byte[]) obj2);
                    myVar.f.a();
                } catch (Exception e) {
                    myVar.f.b(e, true);
                }
            }
        }
    }

    private final void q(bp bpVar) {
        Iterator it = this.k.b().iterator();
        while (it.hasNext()) {
            bpVar.a((nn) it.next());
        }
    }

    private final void r(boolean z) {
        long min;
        if (this.i) {
            return;
        }
        byte[] bArr = (byte[]) cq.G(this.s);
        byte[] bArr2 = this.t;
        if (bArr2 == null) {
            u(bArr, 1, z);
            return;
        }
        if (this.m != 4) {
            try {
                this.e.g(this.s, bArr2);
            } catch (Exception e) {
                s(e, 1);
                return;
            }
        }
        if (i.d.equals(this.c)) {
            Pair a = pi.a(this);
            af.s(a);
            min = Math.min(((Long) a.first).longValue(), ((Long) a.second).longValue());
        } else {
            min = Long.MAX_VALUE;
        }
        if (min > 60) {
            this.m = 4;
            q(mr.b);
            return;
        }
        cd.a("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + min);
        u(bArr, 2, z);
    }

    /* JADX WARN: Removed duplicated region for block: B:16:0x0020  */
    /* JADX WARN: Removed duplicated region for block: B:21:0x002f  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void s(java.lang.Exception r8, int r9) {
        /*
            r7 = this;
            com.google.ads.interactivemedia.v3.internal.nl r0 = new com.google.ads.interactivemedia.v3.internal.nl
            int r1 = com.google.ads.interactivemedia.v3.internal.cq.a
            r2 = 21
            r3 = 1
            if (r1 < r2) goto L14
            boolean r2 = com.google.ads.interactivemedia.v3.internal.nw.b(r8)
            if (r2 == 0) goto L14
            int r9 = com.google.ads.interactivemedia.v3.internal.nw.a(r8)
            goto L5a
        L14:
            r2 = 23
            r4 = 6006(0x1776, float:8.416E-42)
            if (r1 < r2) goto L23
            boolean r2 = com.google.ads.interactivemedia.v3.internal.nx.a(r8)
            if (r2 == 0) goto L23
        L20:
            r9 = 6006(0x1776, float:8.416E-42)
            goto L5a
        L23:
            r2 = 6002(0x1772, float:8.41E-42)
            r5 = 18
            if (r1 < r5) goto L32
            boolean r6 = com.google.ads.interactivemedia.v3.internal.nv.b(r8)
            if (r6 == 0) goto L32
        L2f:
            r9 = 6002(0x1772, float:8.41E-42)
            goto L5a
        L32:
            if (r1 < r5) goto L3d
            boolean r1 = com.google.ads.interactivemedia.v3.internal.nv.a(r8)
            if (r1 == 0) goto L3d
            r9 = 6007(0x1777, float:8.418E-42)
            goto L5a
        L3d:
            boolean r1 = r8 instanceof com.google.ads.interactivemedia.v3.internal.ol
            if (r1 == 0) goto L44
            r9 = 6001(0x1771, float:8.409E-42)
            goto L5a
        L44:
            boolean r1 = r8 instanceof com.google.ads.interactivemedia.v3.internal.nc
            if (r1 == 0) goto L4b
            r9 = 6003(0x1773, float:8.412E-42)
            goto L5a
        L4b:
            boolean r1 = r8 instanceof com.google.ads.interactivemedia.v3.internal.oi
            if (r1 == 0) goto L52
            r9 = 6008(0x1778, float:8.419E-42)
            goto L5a
        L52:
            if (r9 != r3) goto L55
            goto L20
        L55:
            r1 = 2
            if (r9 != r1) goto L2f
            r9 = 6004(0x1774, float:8.413E-42)
        L5a:
            r0.<init>(r8, r9)
            r7.r = r0
            java.lang.String r9 = "DefaultDrmSession"
            java.lang.String r0 = "DRM session error"
            com.google.ads.interactivemedia.v3.internal.cd.c(r9, r0, r8)
            com.google.ads.interactivemedia.v3.internal.mp r9 = new com.google.ads.interactivemedia.v3.internal.mp
            r9.<init>(r8)
            r7.q(r9)
            int r8 = r7.m
            r9 = 4
            if (r8 == r9) goto L75
            r7.m = r3
        L75:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.my.s(java.lang.Exception, int):void");
    }

    private final void t(Exception exc, boolean z) {
        if (exc instanceof NotProvisionedException) {
            this.f.c(this);
        } else {
            s(exc, true != z ? 2 : 1);
        }
    }

    private final void u(byte[] bArr, int i, boolean z) {
        try {
            aeq n = this.e.n(bArr, this.a, i, this.j);
            this.v = n;
            mu muVar = this.p;
            int i2 = cq.a;
            af.s(n);
            muVar.a(1, n, z);
        } catch (Exception e) {
            t(e, true);
        }
    }

    private final boolean v() {
        int i = this.m;
        return i == 3 || i == 4;
    }

    private final boolean w() {
        if (v()) {
            return true;
        }
        try {
            byte[] k = this.e.k();
            this.s = k;
            this.e.i(k, this.l);
            this.q = this.e.b(this.s);
            this.m = 3;
            q(new mq(3));
            af.s(this.s);
            return true;
        } catch (NotProvisionedException unused) {
            this.f.c(this);
            return false;
        } catch (Exception e) {
            s(e, 1);
            return false;
        }
    }

    public final int a() {
        return this.m;
    }

    public final ea b() {
        return this.q;
    }

    public final nl c() {
        if (this.m == 1) {
            return this.r;
        }
        return null;
    }

    public final Map d() {
        byte[] bArr = this.s;
        if (bArr == null) {
            return null;
        }
        return this.e.c(bArr);
    }

    public final UUID e() {
        return this.c;
    }

    public final void h(nn nnVar) {
        int i = this.n;
        if (i < 0) {
            cd.b("DefaultDrmSession", "Session reference count less than zero: " + i);
            this.n = 0;
        }
        if (nnVar != null) {
            this.k.c(nnVar);
        }
        int i2 = this.n + 1;
        this.n = i2;
        if (i2 == 1) {
            af.w(this.m == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.o = handlerThread;
            handlerThread.start();
            this.p = new mu(this, this.o.getLooper());
            if (w()) {
                r(true);
            }
        } else if (nnVar != null && v() && this.k.a(nnVar) == 1) {
            nnVar.e(this.m);
        }
        ni niVar = (ni) this.g;
        nj.l(niVar.a).remove(this);
        Handler d = nj.d(niVar.a);
        af.s(d);
        d.removeCallbacksAndMessages(this);
    }

    public final void i(int i) {
        if (i == 2 && this.m == 4) {
            int i2 = cq.a;
            r(false);
        }
    }

    public final void j() {
        if (w()) {
            r(true);
        }
    }

    public final void k(Exception exc, boolean z) {
        s(exc, true != z ? 3 : 1);
    }

    public final void l() {
        zo m = this.e.m();
        this.u = m;
        mu muVar = this.p;
        int i = cq.a;
        af.s(m);
        muVar.a(0, m, true);
    }

    public final void m(nn nnVar) {
        int i = this.n;
        if (i <= 0) {
            cd.b("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i2 = i - 1;
        this.n = i2;
        if (i2 == 0) {
            this.m = 0;
            mw mwVar = this.d;
            int i3 = cq.a;
            mwVar.removeCallbacksAndMessages((Object) null);
            this.p.b();
            this.p = null;
            this.o.quit();
            this.o = null;
            this.q = null;
            this.r = null;
            this.v = null;
            this.u = null;
            byte[] bArr = this.s;
            if (bArr != null) {
                this.e.d(bArr);
                this.s = null;
            }
        }
        if (nnVar != null) {
            this.k.d(nnVar);
            if (this.k.a(nnVar) == 0) {
                nnVar.g();
            }
        }
        mt mtVar = this.g;
        int i4 = this.n;
        if (i4 == 1) {
            ni niVar = (ni) mtVar;
            nj njVar = niVar.a;
            if (nj.a(njVar) > 0) {
                nj.l(njVar).add(this);
                Handler d = nj.d(niVar.a);
                af.s(d);
                d.postAtTime(new nh(this), this, SystemClock.uptimeMillis() + nj.c(niVar.a));
            }
        } else if (i4 == 0) {
            ni niVar2 = (ni) mtVar;
            nj.k(niVar2.a).remove(this);
            nj njVar2 = niVar2.a;
            if (nj.g(njVar2) == this) {
                nj.s(njVar2);
            }
            nj njVar3 = niVar2.a;
            if (nj.f(njVar3) == this) {
                nj.r(njVar3);
            }
            nj.h(niVar2.a).d(this);
            Handler d2 = nj.d(niVar2.a);
            af.s(d2);
            d2.removeCallbacksAndMessages(this);
            nj.l(niVar2.a).remove(this);
        }
        nj.n(((ni) mtVar).a);
    }

    public final boolean n(byte[] bArr) {
        return Arrays.equals(this.s, bArr);
    }

    public final boolean o() {
        return this.h;
    }

    public final boolean p(String str) {
        return this.e.j((byte[]) af.t(this.s), str);
    }
}
