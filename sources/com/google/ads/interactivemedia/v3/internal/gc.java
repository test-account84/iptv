package com.google.ads.interactivemedia.v3.internal;

import android.annotation.SuppressLint;
import android.content.Context;
import android.graphics.Rect;
import android.graphics.SurfaceTexture;
import android.media.AudioTrack;
import android.os.Handler;
import android.os.Looper;
import android.util.Pair;
import android.view.Surface;
import android.view.SurfaceHolder;
import android.view.SurfaceView;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.TimeoutException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class gc extends h implements az {
    public static final /* synthetic */ int d = 0;
    private int A;
    private int B;
    private boolean C;
    private int D;
    private hl E;
    private aw F;
    private al G;
    private AudioTrack H;
    private Object I;
    private Surface J;
    private SurfaceHolder K;
    private boolean L;
    private int M;
    private int N;
    private int O;
    private int P;
    private f Q;
    private float R;
    private boolean S;
    private boolean T;
    private boolean U;
    private l V;
    private al W;
    private hb X;
    private int Y;
    private long Z;
    private final fk aa;
    private ui ab;
    private final agp ac;
    private final ht ad;
    final wk b;
    final aw c;
    private final Context e;
    private final az f;
    private final hh[] g;
    private final wj h;
    private final bv i;
    private final gm j;
    private final ca k;
    private final CopyOnWriteArraySet l;
    private final bc m;
    private final List n;
    private final boolean o;
    private final hu p;
    private final Looper q;
    private final wq r;
    private final bn s;
    private final fy t;
    private final ga u;
    private final ej v;
    private final en w;
    private final hs x;
    private final ht y;
    private final long z;

    static {
        aj.b("media3.exoplayer");
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Type inference failed for: r10v6, types: [com.google.ads.interactivemedia.v3.internal.ax, com.google.ads.interactivemedia.v3.internal.hu, com.google.ads.interactivemedia.v3.internal.wp, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r11v7, types: [com.google.ads.interactivemedia.v3.internal.hk, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v2, types: [com.google.ads.interactivemedia.v3.internal.wq, java.lang.Object] */
    /* JADX WARN: Type inference failed for: r3v3, types: [byte[], com.google.ads.interactivemedia.v3.internal.f] */
    @SuppressLint({"HandlerLeak"})
    public gc(fa faVar, az azVar) {
        Object obj;
        int e;
        agp agpVar = new agp();
        this.ac = agpVar;
        try {
            cd.d("ExoPlayerImpl", "Init " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.0.0-beta02] [" + cq.e + "]");
            Context applicationContext = faVar.a.getApplicationContext();
            this.e = applicationContext;
            ?? a = faVar.h.a(faVar.b);
            this.p = a;
            this.Q = faVar.j;
            this.M = 1;
            this.S = false;
            this.z = 2000L;
            fy fyVar = new fy(this);
            this.t = fyVar;
            ga gaVar = new ga(null);
            this.u = gaVar;
            Handler handler = new Handler(faVar.i);
            hh[] a2 = ((ex) faVar.c).a.a(handler, fyVar, fyVar);
            this.g = a2;
            int length = a2.length;
            af.w(true);
            wj wjVar = (wj) faVar.e.a();
            this.h = wjVar;
            faVar.d.a();
            ?? a3 = faVar.g.a();
            this.r = a3;
            this.o = true;
            this.E = faVar.m;
            Looper looper = faVar.i;
            this.q = looper;
            bn bnVar = faVar.b;
            this.s = bnVar;
            this.f = azVar;
            this.k = new ca(looper, bnVar, new fj(this));
            CopyOnWriteArraySet copyOnWriteArraySet = new CopyOnWriteArraySet();
            this.l = copyOnWriteArraySet;
            this.n = new ArrayList();
            this.ab = new ui();
            int length2 = a2.length;
            wk wkVar = new wk(new hj[2], new we[2], bk.a, null);
            this.b = wkVar;
            this.m = new bc();
            av avVar = new av();
            avVar.d(1, 2, 3, 13, 14, 15, 16, 17, 18, 19, 31, 20, 30, 21, 22, 23, 24, 25, 26, 27, 28);
            wjVar.k();
            avVar.e(29, true);
            aw a4 = avVar.a();
            this.c = a4;
            av avVar2 = new av();
            avVar2.c(a4);
            avVar2.b(4);
            avVar2.b(10);
            this.F = avVar2.a();
            this.i = bnVar.b(looper, null);
            fk fkVar = new fk(this);
            this.aa = fkVar;
            this.X = hb.g(wkVar);
            a.R(azVar, looper);
            int i = cq.a;
            this.j = new gm(a2, wjVar, wkVar, (es) faVar.f.a(), a3, a, this.E, faVar.t, 500L, looper, bnVar, fkVar, i < 31 ? new iw() : fu.a(applicationContext, this, true));
            this.R = 1.0f;
            al alVar = al.a;
            this.G = alVar;
            this.W = alVar;
            this.Y = -1;
            if (i < 21) {
                AudioTrack audioTrack = this.H;
                if (audioTrack == null || audioTrack.getAudioSessionId() == 0) {
                    obj = null;
                } else {
                    this.H.release();
                    obj = null;
                    this.H = null;
                }
                if (this.H == null) {
                    this.H = new AudioTrack(3, 4000, 4, 2, 2, 0, 0);
                }
                e = this.H.getAudioSessionId();
            } else {
                obj = null;
                e = cq.e(applicationContext);
            }
            this.P = e;
            bm bmVar = bm.a;
            this.T = true;
            N(a);
            a3.g(new Handler(looper), a);
            copyOnWriteArraySet.add(fyVar);
            ?? r3 = obj;
            ej ejVar = new ej(faVar.a, handler, fyVar);
            this.v = ejVar;
            ejVar.a();
            en enVar = new en(faVar.a, handler, fyVar);
            this.w = enVar;
            enVar.e(r3);
            hs hsVar = new hs(faVar.a, handler, fyVar);
            this.x = hsVar;
            int i2 = this.Q.c;
            hsVar.f(3);
            ht htVar = new ht(faVar.a, r3);
            this.ad = htVar;
            htVar.c();
            ht htVar2 = new ht(faVar.a);
            this.y = htVar2;
            htVar2.a();
            this.V = aj(hsVar);
            wjVar.h(this.Q);
            ao(1, 10, Integer.valueOf(this.P));
            ao(2, 10, Integer.valueOf(this.P));
            ao(1, 3, this.Q);
            ao(2, 4, Integer.valueOf(this.M));
            ao(2, 5, 0);
            ao(1, 9, Boolean.valueOf(this.S));
            ao(2, 7, gaVar);
            ao(6, 8, gaVar);
            agpVar.f();
        } catch (Throwable th) {
            this.ac.f();
            throw th;
        }
    }

    public static /* bridge */ /* synthetic */ hs B(gc gcVar) {
        return gcVar.x;
    }

    public static /* bridge */ /* synthetic */ hu C(gc gcVar) {
        return gcVar.p;
    }

    public static /* bridge */ /* synthetic */ Object D(gc gcVar) {
        return gcVar.I;
    }

    public static /* bridge */ /* synthetic */ void E(gc gcVar, l lVar) {
        gcVar.V = lVar;
    }

    public static /* bridge */ /* synthetic */ void F(gc gcVar, boolean z) {
        gcVar.S = z;
    }

    public static /* bridge */ /* synthetic */ void G(gc gcVar, int i, int i2) {
        gcVar.am(i, i2);
    }

    public static /* bridge */ /* synthetic */ void H(gc gcVar) {
        gcVar.ao(1, 2, Float.valueOf(gcVar.R * gcVar.w.a()));
    }

    public static /* bridge */ /* synthetic */ void I(gc gcVar, SurfaceTexture surfaceTexture) {
        Surface surface = new Surface(surfaceTexture);
        gcVar.ap(surface);
        gcVar.J = surface;
    }

    public static /* bridge */ /* synthetic */ void J(gc gcVar, Object obj) {
        gcVar.ap(obj);
    }

    public static /* bridge */ /* synthetic */ void K(gc gcVar, boolean z, int i, int i2) {
        gcVar.aq(z, i, i2);
    }

    public static /* bridge */ /* synthetic */ void L(gc gcVar) {
        gcVar.as();
    }

    public static /* synthetic */ void R(hb hbVar, ax axVar) {
        axVar.e(au(hbVar));
    }

    public static /* bridge */ /* synthetic */ boolean aa(gc gcVar) {
        return gcVar.S;
    }

    public static /* bridge */ /* synthetic */ boolean ab(gc gcVar) {
        return gcVar.L;
    }

    private final int ad() {
        if (this.X.a.p()) {
            return this.Y;
        }
        hb hbVar = this.X;
        return hbVar.a.n(hbVar.b.a, this.m).c;
    }

    private static int ae(boolean z, int i) {
        return (!z || i == 1) ? 1 : 2;
    }

    private final long af(hb hbVar) {
        return hbVar.a.p() ? cq.t(this.Z) : hbVar.b.b() ? hbVar.r : ah(hbVar.a, hbVar.b, hbVar.r);
    }

    private static long ag(hb hbVar) {
        bd bdVar = new bd();
        bc bcVar = new bc();
        hbVar.a.n(hbVar.b.a, bcVar);
        long j = hbVar.c;
        return j == -9223372036854775807L ? hbVar.a.o(bcVar.c, bdVar).m : bcVar.e + j;
    }

    private final long ah(be beVar, te teVar, long j) {
        beVar.n(teVar.a, this.m);
        return j + this.m.e;
    }

    private final Pair ai(be beVar, int i, long j) {
        if (beVar.p()) {
            this.Y = i;
            if (j == -9223372036854775807L) {
                j = 0;
            }
            this.Z = j;
            return null;
        }
        if (i == -1 || i >= beVar.c()) {
            i = beVar.g(false);
            j = beVar.o(i, this.a).a();
        }
        return beVar.k(this.a, this.m, i, cq.t(j));
    }

    private static l aj(hs hsVar) {
        return new l(hsVar.b(), hsVar.a());
    }

    private final hb ak(hb hbVar, be beVar, Pair pair) {
        long j;
        hb b;
        af.u(beVar.p() || pair != null);
        be beVar2 = hbVar.a;
        hb f = hbVar.f(beVar);
        if (beVar.p()) {
            te h = hb.h();
            long t = cq.t(this.Z);
            hb a = f.b(h, t, t, t, 0L, um.a, this.b, avo.o()).a(h);
            a.p = a.r;
            return a;
        }
        Object obj = f.b.a;
        int i = cq.a;
        boolean z = !obj.equals(pair.first);
        te teVar = z ? new te(pair.first) : f.b;
        long longValue = ((Long) pair.second).longValue();
        long t2 = cq.t(l());
        if (!beVar2.p()) {
            t2 -= beVar2.n(obj, this.m).e;
        }
        if (z || longValue < t2) {
            af.w(!teVar.b());
            hb a2 = f.b(teVar, longValue, longValue, longValue, 0L, z ? um.a : f.h, z ? this.b : f.i, z ? avo.o() : f.j).a(teVar);
            a2.p = longValue;
            return a2;
        }
        if (longValue == t2) {
            int a3 = beVar.a(f.k.a);
            if (a3 != -1 && beVar.m(a3, this.m).c == beVar.n(teVar.a, this.m).c) {
                return f;
            }
            beVar.n(teVar.a, this.m);
            j = teVar.b() ? this.m.f(teVar.b, teVar.c) : this.m.d;
            b = f.b(teVar, f.r, f.r, f.d, j - f.r, f.h, f.i, f.j).a(teVar);
        } else {
            af.w(!teVar.b());
            long max = Math.max(0L, f.q - (longValue - t2));
            j = f.p;
            if (f.k.equals(f.b)) {
                j = longValue + max;
            }
            b = f.b(teVar, longValue, longValue, longValue, max, f.h, f.i, f.j);
        }
        b.p = j;
        return b;
    }

    private final he al(hd hdVar) {
        int ad = ad();
        gm gmVar = this.j;
        return new he(gmVar, hdVar, this.X.a, ad == -1 ? 0 : ad, this.s, gmVar.b());
    }

    private final void am(int i, int i2) {
        if (i == this.N && i2 == this.O) {
            return;
        }
        this.N = i;
        this.O = i2;
        this.k.g(24, new fm(i, i2));
    }

    private final void an() {
        SurfaceHolder surfaceHolder = this.K;
        if (surfaceHolder != null) {
            surfaceHolder.removeCallback(this.t);
            this.K = null;
        }
    }

    private final void ao(int i, int i2, Object obj) {
        hh[] hhVarArr = this.g;
        int length = hhVarArr.length;
        for (int i3 = 0; i3 < 2; i3++) {
            hh hhVar = hhVarArr[i3];
            if (hhVar.b() == i) {
                he al = al(hhVar);
                al.n(i2);
                al.m(obj);
                al.l();
            }
        }
    }

    private final void ap(Object obj) {
        ArrayList arrayList = new ArrayList();
        hh[] hhVarArr = this.g;
        int length = hhVarArr.length;
        boolean z = false;
        for (int i = 0; i < 2; i++) {
            hh hhVar = hhVarArr[i];
            if (hhVar.b() == 2) {
                he al = al(hhVar);
                al.n(1);
                al.m(obj);
                al.l();
                arrayList.add(al);
            }
        }
        Object obj2 = this.I;
        if (obj2 != null && obj2 != obj) {
            try {
                Iterator it = arrayList.iterator();
                while (it.hasNext()) {
                    ((he) it.next()).j(this.z);
                }
            } catch (TimeoutException unused) {
                z = true;
            } catch (InterruptedException unused2) {
                Thread.currentThread().interrupt();
            }
            Object obj3 = this.I;
            Surface surface = this.J;
            if (obj3 == surface) {
                surface.release();
                this.J = null;
            }
        }
        this.I = obj;
        if (z) {
            av(ev.d(new gn(3), 1003));
        }
    }

    private final void aq(boolean z, int i, int i2) {
        int i3 = 0;
        boolean z2 = z && i != -1;
        if (z2 && i != 1) {
            i3 = 1;
        }
        hb hbVar = this.X;
        if (hbVar.l == z2 && hbVar.m == i3) {
            return;
        }
        this.A++;
        hb c = hbVar.c(z2, i3);
        this.j.n(z2, i3);
        ar(c, 0, i2, false, false, 5, -9223372036854775807L, -1);
    }

    /* JADX WARN: Removed duplicated region for block: B:39:0x0259  */
    /* JADX WARN: Removed duplicated region for block: B:42:0x02a1  */
    /* JADX WARN: Removed duplicated region for block: B:89:0x02ae  */
    /* JADX WARN: Removed duplicated region for block: B:90:0x0289  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void ar(com.google.ads.interactivemedia.v3.internal.hb r39, int r40, int r41, boolean r42, boolean r43, int r44, long r45, int r47) {
        /*
            Method dump skipped, instructions count: 995
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.gc.ar(com.google.ads.interactivemedia.v3.internal.hb, int, int, boolean, boolean, int, long, int):void");
    }

    private final void as() {
        ht htVar;
        int j = j();
        if (j == 2 || j == 3) {
            at();
            boolean z = this.X.o;
            ht htVar2 = this.ad;
            q();
            htVar2.d();
            htVar = this.y;
            q();
        } else {
            this.ad.d();
            htVar = this.y;
        }
        htVar.b();
    }

    private final void at() {
        this.ac.d();
        if (Thread.currentThread() != this.q.getThread()) {
            String H = cq.H("Player is accessed on the wrong thread.\nCurrent thread: '%s'\nExpected thread: '%s'\nSee https://exoplayer.dev/issues/player-accessed-on-wrong-thread", Thread.currentThread().getName(), this.q.getThread().getName());
            if (this.T) {
                throw new IllegalStateException(H);
            }
            cd.f("ExoPlayerImpl", H, this.U ? null : new IllegalStateException());
            this.U = true;
        }
    }

    private static boolean au(hb hbVar) {
        return hbVar.e == 3 && hbVar.l && hbVar.m == 0;
    }

    private final void av(ev evVar) {
        hb hbVar = this.X;
        hb a = hbVar.a(hbVar.b);
        a.p = a.r;
        a.q = 0L;
        hb e = a.e(1);
        if (evVar != null) {
            e = e.d(evVar);
        }
        hb hbVar2 = e;
        this.A++;
        this.j.o();
        ar(hbVar2, 0, 1, false, hbVar2.a.p() && !this.X.a.p(), 4, af(hbVar2), -1);
    }

    public static /* bridge */ /* synthetic */ int v(boolean z, int i) {
        return ae(z, i);
    }

    public static /* bridge */ /* synthetic */ l x(gc gcVar) {
        return gcVar.V;
    }

    public static /* bridge */ /* synthetic */ l y(hs hsVar) {
        return aj(hsVar);
    }

    public static /* bridge */ /* synthetic */ ca z(gc gcVar) {
        return gcVar.k;
    }

    public final ev A() {
        at();
        return this.X.f;
    }

    public final void M(hw hwVar) {
        hu huVar = this.p;
        af.s(hwVar);
        huVar.v(hwVar);
    }

    public final void N(ax axVar) {
        ca caVar = this.k;
        af.s(axVar);
        caVar.b(axVar);
    }

    public final /* synthetic */ void O(gj gjVar) {
        long j;
        boolean z;
        long j2;
        int i = this.A - gjVar.b;
        this.A = i;
        boolean z2 = true;
        if (gjVar.c) {
            this.B = gjVar.d;
            this.C = true;
        }
        if (gjVar.e) {
            this.D = gjVar.f;
        }
        if (i == 0) {
            be beVar = gjVar.a.a;
            if (!this.X.a.p() && beVar.p()) {
                this.Y = -1;
                this.Z = 0L;
            }
            if (!beVar.p()) {
                List A = ((hf) beVar).A();
                af.w(A.size() == this.n.size());
                for (int i2 = 0; i2 < A.size(); i2++) {
                    gb.c((gb) this.n.get(i2), (be) A.get(i2));
                }
            }
            if (this.C) {
                if (gjVar.a.b.equals(this.X.b) && gjVar.a.d == this.X.r) {
                    z2 = false;
                }
                if (z2) {
                    if (beVar.p() || gjVar.a.b.b()) {
                        j2 = gjVar.a.d;
                    } else {
                        hb hbVar = gjVar.a;
                        j2 = ah(beVar, hbVar.b, hbVar.d);
                    }
                    j = j2;
                } else {
                    j = -9223372036854775807L;
                }
                z = z2;
            } else {
                j = -9223372036854775807L;
                z = false;
            }
            this.C = false;
            ar(gjVar.a, 1, this.D, false, z, this.B, j, -1);
        }
    }

    public final /* synthetic */ void P(gj gjVar) {
        this.i.e(new fl(this, gjVar));
    }

    public final /* synthetic */ void Q(ax axVar) {
        axVar.a(this.F);
    }

    @Deprecated
    public final void S(tg tgVar) {
        at();
        at();
        List singletonList = Collections.singletonList(tgVar);
        at();
        at();
        ad();
        m();
        this.A++;
        if (!this.n.isEmpty()) {
            int size = this.n.size();
            for (int i = size - 1; i >= 0; i--) {
                this.n.remove(i);
            }
            this.ab = this.ab.h(0, size);
        }
        List arrayList = new ArrayList();
        for (int i2 = 0; i2 < singletonList.size(); i2++) {
            gy gyVar = new gy((tg) singletonList.get(i2), this.o);
            arrayList.add(gyVar);
            this.n.add(i2, new gb(gyVar.b, gyVar.a.k()));
        }
        this.ab = this.ab.g(0, arrayList.size());
        hf hfVar = new hf(this.n, this.ab);
        if (!hfVar.p() && hfVar.c() < 0) {
            throw new t();
        }
        int g = hfVar.g(false);
        hb ak = ak(this.X, hfVar, ai(hfVar, g, -9223372036854775807L));
        int i3 = ak.e;
        if (g != -1 && i3 != 1) {
            i3 = (hfVar.p() || g >= hfVar.c()) ? 4 : 2;
        }
        hb e = ak.e(i3);
        this.j.q(arrayList, g, cq.t(-9223372036854775807L), this.ab);
        ar(e, 0, 1, false, (this.X.b.a.equals(e.b.a) || this.X.a.p()) ? false : true, 4, af(e), -1);
        at();
        boolean q = q();
        int b = this.w.b(q, 2);
        aq(q, b, ae(q, b));
        hb hbVar = this.X;
        if (hbVar.e != 1) {
            return;
        }
        hb d2 = hbVar.d(null);
        hb e2 = d2.e(true == d2.a.p() ? 4 : 2);
        this.A++;
        this.j.k();
        ar(e2, 1, 1, false, false, 5, -9223372036854775807L, -1);
    }

    public final void T() {
        AudioTrack audioTrack;
        cd.d("ExoPlayerImpl", "Release " + Integer.toHexString(System.identityHashCode(this)) + " [AndroidXMedia3/1.0.0-beta02] [" + cq.e + "] [" + aj.a() + "]");
        at();
        if (cq.a < 21 && (audioTrack = this.H) != null) {
            audioTrack.release();
            this.H = null;
        }
        this.v.a();
        this.x.e();
        this.ad.d();
        this.y.b();
        this.w.d();
        if (!this.j.p()) {
            this.k.g(10, fs.b);
        }
        this.k.e();
        this.i.f();
        this.r.h(this.p);
        hb e = this.X.e(1);
        this.X = e;
        hb a = e.a(e.b);
        this.X = a;
        a.p = a.r;
        this.X.q = 0L;
        this.p.P();
        this.h.g();
        an();
        Surface surface = this.J;
        if (surface != null) {
            surface.release();
            this.J = null;
        }
        bm bmVar = bm.a;
    }

    public final void U(hw hwVar) {
        hu huVar = this.p;
        af.s(hwVar);
        huVar.Q(hwVar);
    }

    public final void V(ax axVar) {
        af.s(axVar);
        this.k.f(axVar);
    }

    public final void W(boolean z) {
        at();
        int b = this.w.b(z, j());
        aq(z, b, ae(z, b));
    }

    public final void X(SurfaceHolder surfaceHolder) {
        at();
        if (surfaceHolder == null) {
            at();
            an();
            ap(null);
            am(0, 0);
            return;
        }
        an();
        this.L = true;
        this.K = surfaceHolder;
        surfaceHolder.addCallback(this.t);
        Surface surface = surfaceHolder.getSurface();
        if (surface == null || !surface.isValid()) {
            ap(null);
            am(0, 0);
        } else {
            ap(surface);
            Rect surfaceFrame = surfaceHolder.getSurfaceFrame();
            am(surfaceFrame.width(), surfaceFrame.height());
        }
    }

    public final void Y(SurfaceView surfaceView) {
        at();
        X(surfaceView == null ? null : surfaceView.getHolder());
    }

    public final void Z() {
        at();
        at();
        this.w.b(q(), 1);
        av(null);
        avo o = avo.o();
        long j = this.X.r;
        new bm(o);
    }

    public final void ac() {
        at();
        an();
        ap(null);
        am(0, 0);
    }

    public final int f() {
        at();
        if (r()) {
            return this.X.b.b;
        }
        return -1;
    }

    public final int g() {
        at();
        if (r()) {
            return this.X.b.c;
        }
        return -1;
    }

    public final int h() {
        at();
        int ad = ad();
        if (ad == -1) {
            return 0;
        }
        return ad;
    }

    public final int i() {
        at();
        if (this.X.a.p()) {
            return 0;
        }
        hb hbVar = this.X;
        return hbVar.a.a(hbVar.b.a);
    }

    public final int j() {
        at();
        return this.X.e;
    }

    public final int k() {
        at();
        return this.X.m;
    }

    public final long l() {
        at();
        if (!r()) {
            return m();
        }
        hb hbVar = this.X;
        hbVar.a.n(hbVar.b.a, this.m);
        hb hbVar2 = this.X;
        return hbVar2.c == -9223372036854775807L ? hbVar2.a.o(h(), this.a).a() : this.m.g() + cq.x(this.X.c);
    }

    public final long m() {
        at();
        return cq.x(af(this.X));
    }

    public final long n() {
        at();
        return cq.x(this.X.q);
    }

    public final be o() {
        at();
        return this.X.a;
    }

    public final bk p() {
        at();
        return this.X.i.d;
    }

    public final boolean q() {
        at();
        return this.X.l;
    }

    public final boolean r() {
        at();
        return this.X.b.b();
    }

    public final void s() {
        at();
    }

    public final void t() {
        at();
    }

    public final void u(int i) {
        at();
        this.p.w();
        be beVar = this.X.a;
        if (i < 0 || (!beVar.p() && i >= beVar.c())) {
            throw new t();
        }
        this.A++;
        if (r()) {
            cd.e("ExoPlayerImpl", "seekTo ignored because an ad is playing");
            gj gjVar = new gj(this.X);
            gjVar.a(1);
            this.aa.a(gjVar);
            return;
        }
        int i2 = j() != 1 ? 2 : 1;
        int h = h();
        hb ak = ak(this.X.e(i2), beVar, ai(beVar, i, 0L));
        this.j.l(beVar, i, cq.t(0L));
        ar(ak, 0, 1, true, true, 1, af(ak), h);
    }

    public final long w() {
        at();
        if (r()) {
            hb hbVar = this.X;
            te teVar = hbVar.b;
            hbVar.a.n(teVar.a, this.m);
            return cq.x(this.m.f(teVar.b, teVar.c));
        }
        be o = o();
        if (o.p()) {
            return -9223372036854775807L;
        }
        return o.o(h(), this.a).b();
    }
}
