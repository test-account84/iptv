package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.util.SparseArray;
import java.io.IOException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class lh extends sa {
    private long A;
    private int B;
    private final lf C;
    private final ly D;
    private final aeq E;
    private final ws F;
    private final ws G;
    private final ai a;
    private final cx b;
    private final nt c;
    private final long d;
    private final tj e;
    private final xe f;
    private final Object g;
    private final SparseArray h;
    private final Runnable i;
    private final Runnable j;
    private final lp k;
    private final xd l;
    private cy m;
    private xc n;
    private dw o;
    private IOException p;
    private Handler q;
    private ac r;
    private Uri s;
    private final Uri t;
    private lu u;
    private boolean v;
    private long w;
    private long x;
    private long y;
    private int z;

    static {
        aj.b("media3.exoplayer.dash");
    }

    public /* synthetic */ lh(ai aiVar, cx cxVar, xe xeVar, aeq aeqVar, ws wsVar, nt ntVar, ws wsVar2, long j, byte[] bArr, byte[] bArr2, byte[] bArr3, byte[] bArr4) {
        this.a = aiVar;
        this.r = aiVar.c;
        ad adVar = aiVar.b;
        af.s(adVar);
        this.s = adVar.a;
        this.t = aiVar.b.a;
        this.u = null;
        this.b = cxVar;
        this.f = xeVar;
        this.E = aeqVar;
        this.c = ntVar;
        this.F = wsVar2;
        this.d = 30000L;
        this.G = wsVar;
        this.D = new ly();
        this.e = x(null);
        this.g = new Object();
        this.h = new SparseArray();
        this.k = new lb(this);
        this.A = -9223372036854775807L;
        this.y = -9223372036854775807L;
        this.C = new lf(this, 1);
        this.l = new le(this);
        this.i = new ky(this, 0);
        this.j = new ky(this, 2);
    }

    private final void N() {
        xm.f(this.n, new kz(this));
    }

    private final void O(IOException iOException) {
        cd.c("DashMediaSource", "Failed to resolve time offset.", iOException);
        Q(true);
    }

    private final void P(long j) {
        this.y = j;
        Q(true);
    }

    /* JADX WARN: Removed duplicated region for block: B:181:0x01f0  */
    /* JADX WARN: Removed duplicated region for block: B:185:0x01d9  */
    /* JADX WARN: Removed duplicated region for block: B:75:0x01a0 A[PHI: r5
      0x01a0: PHI (r5v32 long) = (r5v21 long), (r5v25 long) binds: [B:74:0x019e, B:189:0x01af] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:83:0x01d1  */
    /* JADX WARN: Removed duplicated region for block: B:86:0x01e5 A[PHI: r1
      0x01e5: PHI (r1v41 long) = (r1v31 long), (r1v34 long) binds: [B:85:0x01e3, B:184:0x01fa] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:98:0x0219  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void Q(boolean r38) {
        /*
            Method dump skipped, instructions count: 986
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.lh.Q(boolean):void");
    }

    private final void R(mo moVar, xe xeVar) {
        T(new xf(this.m, Uri.parse(moVar.b), 5, xeVar), new lf(this, 0), 1);
    }

    private final void S(long j) {
        this.q.postDelayed(this.i, j);
    }

    private final void T(xf xfVar, ww wwVar, int i) {
        this.n.b(xfVar, wwVar, i);
        this.e.j(new sw(xfVar.b), xfVar.c);
    }

    private final void U() {
        Uri uri;
        this.q.removeCallbacks(this.i);
        if (this.n.l()) {
            return;
        }
        if (this.n.m()) {
            this.v = true;
            return;
        }
        synchronized (this.g) {
            uri = this.s;
        }
        this.v = false;
        T(new xf(this.m, uri, 4, this.f), this.C, ws.c(4));
    }

    private static boolean V(lz lzVar) {
        for (int i = 0; i < lzVar.c.size(); i++) {
            int i2 = ((ls) lzVar.c.get(i)).b;
            if (i2 == 1 || i2 == 2) {
                return true;
            }
        }
        return false;
    }

    public static /* bridge */ /* synthetic */ xc b(lh lhVar) {
        return lhVar.n;
    }

    public static /* bridge */ /* synthetic */ IOException c(lh lhVar) {
        return lhVar.p;
    }

    public static /* synthetic */ void d(lh lhVar) {
        lhVar.U();
    }

    public static /* bridge */ /* synthetic */ void e(lh lhVar, IOException iOException) {
        lhVar.O(iOException);
    }

    public static /* bridge */ /* synthetic */ void f(lh lhVar, long j) {
        lhVar.P(j);
    }

    public final ai a() {
        return this.a;
    }

    public final /* synthetic */ void g() {
        Q(false);
    }

    public final void h() throws IOException {
        this.l.a();
    }

    public final void i(long j) {
        long j2 = this.A;
        if (j2 == -9223372036854775807L || j2 < j) {
            this.A = j;
        }
    }

    public final void j() {
        this.q.removeCallbacks(this.j);
        U();
    }

    public final void k(xf xfVar, long j, long j2) {
        long j3 = xfVar.a;
        xfVar.c();
        xfVar.f();
        xfVar.a();
        this.e.d(new sw(), xfVar.c);
    }

    public final void l(xf xfVar, long j, long j2) {
        long j3 = xfVar.a;
        xfVar.c();
        xfVar.f();
        xfVar.a();
        this.e.f(new sw(), xfVar.c);
        lu luVar = (lu) xfVar.d();
        lu luVar2 = this.u;
        int a = luVar2 == null ? 0 : luVar2.a();
        long j4 = luVar.d(0).b;
        int i = 0;
        while (i < a && this.u.d(i).b < j4) {
            i++;
        }
        if (luVar.d) {
            if (a - i > luVar.a()) {
                cd.e("DashMediaSource", "Loaded out of sync manifest");
            } else {
                long j5 = this.A;
                if (j5 != -9223372036854775807L) {
                    long j6 = luVar.h;
                    if (1000 * j6 <= j5) {
                        cd.e("DashMediaSource", "Loaded stale dynamic manifest: " + j6 + ", " + j5);
                    }
                }
                this.z = 0;
            }
            int i2 = this.z;
            this.z = i2 + 1;
            if (i2 < ws.c(xfVar.c)) {
                S(Math.min((this.z - 1) * 1000, 5000));
                return;
            } else {
                this.p = new kv();
                return;
            }
        }
        this.u = luVar;
        this.v = luVar.d & this.v;
        this.w = j - j2;
        this.x = j;
        synchronized (this.g) {
            try {
                if (xfVar.b.a == this.s) {
                    Uri uri = this.u.k;
                    if (uri == null) {
                        uri = xfVar.c();
                    }
                    this.s = uri;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (a != 0) {
            this.B += i;
            Q(true);
            return;
        }
        lu luVar3 = this.u;
        if (!luVar3.d) {
            Q(true);
            return;
        }
        mo moVar = luVar3.i;
        if (moVar == null) {
            N();
            return;
        }
        String str = moVar.a;
        if (cq.V(str, "urn:mpeg:dash:utc:direct:2014") || cq.V(str, "urn:mpeg:dash:utc:direct:2012")) {
            try {
                P(cq.u(moVar.b) - this.x);
                return;
            } catch (as e) {
                O(e);
                return;
            }
        }
        if (cq.V(str, "urn:mpeg:dash:utc:http-iso:2014") || cq.V(str, "urn:mpeg:dash:utc:http-iso:2012")) {
            R(moVar, new ld());
            return;
        }
        if (cq.V(str, "urn:mpeg:dash:utc:http-xsdate:2014") || cq.V(str, "urn:mpeg:dash:utc:http-xsdate:2012")) {
            R(moVar, new lg(null));
        } else if (cq.V(str, "urn:mpeg:dash:utc:ntp:2014") || cq.V(str, "urn:mpeg:dash:utc:ntp:2012")) {
            N();
        } else {
            O(new IOException("Unsupported UTC timing scheme"));
        }
    }

    public final void m(xf xfVar, long j, long j2) {
        long j3 = xfVar.a;
        xfVar.c();
        xfVar.f();
        xfVar.a();
        this.e.f(new sw(), xfVar.c);
        P(((Long) xfVar.d()).longValue() - j);
    }

    public final void n(dw dwVar) {
        this.o = dwVar;
        this.c.o();
        this.c.q(Looper.myLooper(), u());
        this.m = ((df) this.b).a();
        this.n = new xc("DashMediaSource");
        this.q = cq.A();
        U();
    }

    public final void o(td tdVar) {
        kx kxVar = (kx) tdVar;
        kxVar.m();
        this.h.remove(kxVar.a);
    }

    public final void p() {
        this.v = false;
        this.m = null;
        xc xcVar = this.n;
        if (xcVar != null) {
            xcVar.j();
            this.n = null;
        }
        this.w = 0L;
        this.x = 0L;
        this.u = null;
        this.s = this.t;
        this.p = null;
        Handler handler = this.q;
        if (handler != null) {
            handler.removeCallbacksAndMessages((Object) null);
            this.q = null;
        }
        this.y = -9223372036854775807L;
        this.z = 0;
        this.A = -9223372036854775807L;
        this.B = 0;
        this.h.clear();
        this.D.e();
        this.c.p();
    }

    public final td q(te teVar, wr wrVar, long j) {
        int intValue = ((Integer) teVar.a).intValue() - this.B;
        tj y = y(teVar, this.u.d(intValue).b);
        kx kxVar = new kx(intValue + this.B, this.u, this.D, intValue, this.E, this.o, this.c, v(teVar), this.F, y, this.y, this.l, wrVar, this.G, this.k, u(), null, null, null, null);
        this.h.put(kxVar.a, kxVar);
        return kxVar;
    }

    public final wv r(xf xfVar, long j, long j2, IOException iOException, int i) {
        long j3 = xfVar.a;
        xfVar.c();
        xfVar.f();
        xfVar.a();
        sw swVar = new sw();
        long e = ws.e(new bdz(iOException, i));
        wv n = e == -9223372036854775807L ? xc.c : xc.n(false, e);
        this.e.h(swVar, xfVar.c, iOException, !n.a());
        return n;
    }

    public final wv s(xf xfVar, long j, long j2, IOException iOException) {
        tj tjVar = this.e;
        long j3 = xfVar.a;
        xfVar.c();
        xfVar.f();
        xfVar.a();
        tjVar.h(new sw(), xfVar.c, iOException, true);
        O(iOException);
        return xc.b;
    }
}
