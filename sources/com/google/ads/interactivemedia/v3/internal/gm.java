package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Set;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class gm implements Handler.Callback, tc, wi, gz, et, hc {
    private boolean C;
    private boolean D;
    private boolean E;
    private int F;
    private gl G;
    private long H;
    private int I;
    private boolean J;
    private ev K;
    private final es M;
    private final fk N;
    private final er O;
    private final hh[] a;
    private final Set b;
    private final hi[] c;
    private final wj d;
    private final wk e;
    private final wq f;
    private final bv g;
    private final HandlerThread h;
    private final Looper i;
    private final bd j;
    private final bc k;
    private final long l;
    private final eu m;
    private final ArrayList n;
    private final bn o;
    private final gt p;
    private final ha q;
    private hl s;
    private hb t;
    private gj u;
    private boolean v;
    private boolean x;
    private boolean y;
    private boolean z;
    private int A = 0;
    private boolean B = false;
    private final long r = 500;
    private boolean w = false;
    private long L = -9223372036854775807L;

    public gm(hh[] hhVarArr, wj wjVar, wk wkVar, es esVar, wq wqVar, hu huVar, hl hlVar, er erVar, long j, Looper looper, bn bnVar, fk fkVar, iw iwVar) {
        this.N = fkVar;
        this.a = hhVarArr;
        this.d = wjVar;
        this.e = wkVar;
        this.M = esVar;
        this.f = wqVar;
        this.s = hlVar;
        this.O = erVar;
        this.o = bnVar;
        this.l = esVar.a();
        hb g = hb.g(wkVar);
        this.t = g;
        this.u = new gj(g);
        int length = hhVarArr.length;
        this.c = new hi[2];
        for (int i = 0; i < 2; i++) {
            hhVarArr[i].r(i, iwVar);
            this.c[i] = hhVarArr[i].k();
        }
        this.m = new eu(this, bnVar);
        this.n = new ArrayList();
        this.b = axo.f();
        this.j = new bd();
        this.k = new bc();
        wjVar.n(this, wqVar);
        this.J = true;
        Handler handler = new Handler(looper);
        this.p = new gt(huVar, handler);
        this.q = new ha(this, huVar, handler, iwVar);
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:Playback", -16);
        this.h = handlerThread;
        handlerThread.start();
        Looper looper2 = handlerThread.getLooper();
        this.i = looper2;
        this.g = bnVar.b(looper2, this);
    }

    private final void A(hh hhVar) throws ev {
        if (ad(hhVar)) {
            this.m.d(hhVar);
            al(hhVar);
            hhVar.o();
            this.F--;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:150:0x0272  */
    /* JADX WARN: Removed duplicated region for block: B:228:0x0450  */
    /* JADX WARN: Removed duplicated region for block: B:263:0x04d7  */
    /* JADX WARN: Removed duplicated region for block: B:274:0x0535  */
    /* JADX WARN: Removed duplicated region for block: B:278:0x04d0  */
    /* JADX WARN: Removed duplicated region for block: B:279:0x04c3  */
    /* JADX WARN: Removed duplicated region for block: B:284:0x04af  */
    /* JADX WARN: Removed duplicated region for block: B:293:0x0403  */
    /* JADX WARN: Removed duplicated region for block: B:317:0x0407  */
    /* JADX WARN: Removed duplicated region for block: B:325:0x0427  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void B() throws com.google.ads.interactivemedia.v3.internal.ev, java.io.IOException {
        /*
            Method dump skipped, instructions count: 1353
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.gm.B():void");
    }

    private final void C() throws ev {
        int length = this.a.length;
        D(new boolean[2]);
    }

    private final void D(boolean[] zArr) throws ev {
        gq e = this.p.e();
        wk j = e.j();
        int i = 0;
        while (true) {
            int length = this.a.length;
            if (i >= 2) {
                break;
            }
            if (!j.b(i) && this.b.remove(this.a[i])) {
                this.a[i].A();
            }
            i++;
        }
        int i2 = 0;
        while (true) {
            int length2 = this.a.length;
            if (i2 >= 2) {
                e.g = true;
                return;
            }
            if (j.b(i2)) {
                boolean z = zArr[i2];
                hh hhVar = this.a[i2];
                if (!ad(hhVar)) {
                    gq e2 = this.p.e();
                    boolean z2 = e2 == this.p.d();
                    wk j2 = e2.j();
                    hj hjVar = j2.b[i2];
                    s[] aj = aj(j2.c[i2]);
                    boolean z3 = ah() && this.t.e == 3;
                    boolean z4 = !z && z3;
                    this.F++;
                    this.b.add(hhVar);
                    hhVar.p(hjVar, aj, e2.c[i2], this.H, z4, z2, e2.e(), e2.d());
                    hhVar.q(11, new gf(this));
                    this.m.e(hhVar);
                    if (z3) {
                        hhVar.E();
                    }
                }
            }
            i2++;
        }
    }

    private final void E(IOException iOException, int i) {
        ev c = ev.c(iOException, i);
        gq d = this.p.d();
        if (d != null) {
            c = c.a(d.f.a);
        }
        cd.c("ExoPlayerImplInternal", "Playback error", c);
        V(false, false);
        this.t = this.t.d(c);
    }

    private final void F(boolean z) {
        gq c = this.p.c();
        te teVar = c == null ? this.t.b : c.f.a;
        boolean z2 = !this.t.k.equals(teVar);
        if (z2) {
            this.t = this.t.a(teVar);
        }
        hb hbVar = this.t;
        hbVar.p = c == null ? hbVar.r : c.b();
        this.t.q = t();
        if ((z2 || z) && c != null && c.d) {
            Y(c.i(), c.j());
        }
    }

    /* JADX WARN: Multi-variable type inference failed */
    /* JADX WARN: Removed duplicated region for block: B:103:0x03ad  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x03a1  */
    /* JADX WARN: Removed duplicated region for block: B:106:0x0371  */
    /* JADX WARN: Removed duplicated region for block: B:84:0x036e  */
    /* JADX WARN: Removed duplicated region for block: B:91:0x03d7  */
    /* JADX WARN: Removed duplicated region for block: B:94:0x0384  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void G(com.google.ads.interactivemedia.v3.internal.be r37, boolean r38) throws com.google.ads.interactivemedia.v3.internal.ev {
        /*
            Method dump skipped, instructions count: 990
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.gm.G(com.google.ads.interactivemedia.v3.internal.be, boolean):void");
    }

    private final void H(au auVar, boolean z) throws ev {
        I(auVar, auVar.b, true, z);
    }

    private final void I(au auVar, float f, boolean z, boolean z2) throws ev {
        int i;
        gm gmVar = this;
        if (z) {
            if (z2) {
                gmVar.u.a(1);
            }
            hb hbVar = gmVar.t;
            gmVar = this;
            gmVar.t = new hb(hbVar.a, hbVar.b, hbVar.c, hbVar.d, hbVar.e, hbVar.f, hbVar.g, hbVar.h, hbVar.i, hbVar.j, hbVar.k, hbVar.l, hbVar.m, auVar, hbVar.p, hbVar.q, hbVar.r, hbVar.o);
        }
        float f2 = auVar.b;
        gq d = gmVar.p.d();
        while (true) {
            i = 0;
            if (d == null) {
                break;
            }
            we[] weVarArr = d.j().c;
            int length = weVarArr.length;
            while (i < length) {
                we weVar = weVarArr[i];
                if (weVar != null) {
                    weVar.h(f2);
                }
                i++;
            }
            d = d.h();
        }
        hh[] hhVarArr = gmVar.a;
        int length2 = hhVarArr.length;
        while (i < 2) {
            hh hhVar = hhVarArr[i];
            if (hhVar != null) {
                hhVar.D(f, auVar.b);
            }
            i++;
        }
    }

    private final void J() {
        boolean h;
        if (ac()) {
            gq c = this.p.c();
            long u = u(c.c());
            if (c == this.p.d()) {
                c.f(this.H);
            } else {
                c.f(this.H);
                long j = c.f.b;
            }
            h = this.M.h(u, this.m.c().b);
            if (!h && u < 500000 && this.l > 0) {
                this.p.d().a.q(this.t.r);
                h = this.M.h(u, this.m.c().b);
            }
        } else {
            h = false;
        }
        this.z = h;
        if (h) {
            this.p.c().l(this.H);
        }
        X();
    }

    private final void K() {
        this.u.c(this.t);
        if (gj.e(this.u)) {
            this.N.a(this.u);
            this.u = new gj(this.t);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:60:0x00a6 A[PHI: r4 r5 r7
      0x00a6: PHI (r4v3 com.google.ads.interactivemedia.v3.internal.te) = (r4v2 com.google.ads.interactivemedia.v3.internal.te), (r4v8 com.google.ads.interactivemedia.v3.internal.te) binds: [B:34:0x0079, B:36:0x009e] A[DONT_GENERATE, DONT_INLINE]
      0x00a6: PHI (r5v3 long) = (r5v2 long), (r5v5 long) binds: [B:34:0x0079, B:36:0x009e] A[DONT_GENERATE, DONT_INLINE]
      0x00a6: PHI (r7v3 long) = (r7v2 long), (r7v5 long) binds: [B:34:0x0079, B:36:0x009e] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void L(boolean r29, boolean r30, boolean r31, boolean r32) {
        /*
            Method dump skipped, instructions count: 262
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.gm.L(boolean, boolean, boolean, boolean):void");
    }

    private final void M() {
        gq d = this.p.d();
        boolean z = false;
        if (d != null && d.f.h && this.w) {
            z = true;
        }
        this.x = z;
    }

    private final void N(long j) throws ev {
        gq d = this.p.d();
        long g = d == null ? j + 1000000000000L : d.g(j);
        this.H = g;
        this.m.f(g);
        hh[] hhVarArr = this.a;
        int length = hhVarArr.length;
        for (int i = 0; i < 2; i++) {
            hh hhVar = hhVarArr[i];
            if (ad(hhVar)) {
                hhVar.B(this.H);
            }
        }
        for (gq d2 = this.p.d(); d2 != null; d2 = d2.h()) {
            for (we weVar : d2.j().c) {
            }
        }
    }

    private final void O(be beVar, be beVar2) {
        if (beVar.p() && beVar2.p()) {
            return;
        }
        int size = this.n.size();
        while (true) {
            size--;
            if (size < 0) {
                Collections.sort(this.n);
                return;
            } else if (!ag((gi) this.n.get(size), beVar, beVar2, this.A, this.B, this.j, this.k)) {
                ((gi) this.n.get(size)).a.h(false);
                this.n.remove(size);
            }
        }
    }

    private final void P(long j, long j2) {
        this.g.i(j + j2);
    }

    private final void Q(boolean z) throws ev {
        te teVar = this.p.d().f.a;
        long w = w(teVar, this.t.r, true, false);
        if (w != this.t.r) {
            hb hbVar = this.t;
            this.t = z(teVar, w, hbVar.c, hbVar.d, z, 5);
        }
    }

    private final void R(he heVar) throws ev {
        if (heVar.d() != this.i) {
            this.g.b(15, heVar).a();
            return;
        }
        ak(heVar);
        int i = this.t.e;
        if (i == 3 || i == 2) {
            this.g.h(2);
        }
    }

    private final void S(boolean z, int i, boolean z2, int i2) throws ev {
        this.u.a(z2 ? 1 : 0);
        this.u.b(i2);
        this.t = this.t.c(z, i);
        this.y = false;
        for (gq d = this.p.d(); d != null; d = d.h()) {
            for (we weVar : d.j().c) {
            }
        }
        if (!ah()) {
            W();
            Z();
            return;
        }
        int i3 = this.t.e;
        if (i3 == 3) {
            U();
            this.g.h(2);
        } else if (i3 == 2) {
            this.g.h(2);
        }
    }

    private final void T(int i) {
        hb hbVar = this.t;
        if (hbVar.e != i) {
            if (i != 2) {
                this.L = -9223372036854775807L;
            }
            this.t = hbVar.e(i);
        }
    }

    private final void U() throws ev {
        this.y = false;
        this.m.h();
        hh[] hhVarArr = this.a;
        int length = hhVarArr.length;
        for (int i = 0; i < 2; i++) {
            hh hhVar = hhVarArr[i];
            if (ad(hhVar)) {
                hhVar.E();
            }
        }
    }

    private final void V(boolean z, boolean z2) {
        L(z || !this.C, false, true, false);
        this.u.a(z2 ? 1 : 0);
        this.M.d();
        T(1);
    }

    private final void W() throws ev {
        this.m.i();
        hh[] hhVarArr = this.a;
        int length = hhVarArr.length;
        for (int i = 0; i < 2; i++) {
            hh hhVar = hhVarArr[i];
            if (ad(hhVar)) {
                al(hhVar);
            }
        }
    }

    private final void X() {
        gq c = this.p.c();
        boolean z = this.z || (c != null && c.a.p());
        hb hbVar = this.t;
        if (z != hbVar.g) {
            this.t = new hb(hbVar.a, hbVar.b, hbVar.c, hbVar.d, hbVar.e, hbVar.f, z, hbVar.h, hbVar.i, hbVar.j, hbVar.k, hbVar.l, hbVar.m, hbVar.n, hbVar.p, hbVar.q, hbVar.r, hbVar.o);
        }
    }

    private final void Y(um umVar, wk wkVar) {
        this.M.g(this.a, wkVar.c);
    }

    /* JADX WARN: Code restructure failed: missing block: B:102:0x00d0, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x00c4, code lost:
    
        if (r5 < r13.n.size()) goto L43;
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x00c6, code lost:
    
        r7 = (com.google.ads.interactivemedia.v3.internal.gi) r13.n.get(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x00d0, code lost:
    
        if (r7 == null) goto L96;
     */
    /* JADX WARN: Code restructure failed: missing block: B:57:0x00d4, code lost:
    
        if (r7.d == null) goto L98;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x00d6, code lost:
    
        r8 = r7.b;
     */
    /* JADX WARN: Code restructure failed: missing block: B:59:0x00d8, code lost:
    
        if (r8 < r4) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x00da, code lost:
    
        if (r8 != r4) goto L100;
     */
    /* JADX WARN: Code restructure failed: missing block: B:62:0x00e0, code lost:
    
        if (r7.c > r2) goto L97;
     */
    /* JADX WARN: Code restructure failed: missing block: B:65:0x00ed, code lost:
    
        if (r7 == null) goto L102;
     */
    /* JADX WARN: Code restructure failed: missing block: B:67:0x00f1, code lost:
    
        if (r7.d == null) goto L103;
     */
    /* JADX WARN: Code restructure failed: missing block: B:69:0x00f5, code lost:
    
        if (r7.b != r4) goto L104;
     */
    /* JADX WARN: Code restructure failed: missing block: B:70:0x00f7, code lost:
    
        r8 = r7.c;
     */
    /* JADX WARN: Code restructure failed: missing block: B:71:0x00fb, code lost:
    
        if (r8 <= r2) goto L106;
     */
    /* JADX WARN: Code restructure failed: missing block: B:73:0x00ff, code lost:
    
        if (r8 > r0) goto L107;
     */
    /* JADX WARN: Code restructure failed: missing block: B:75:0x0101, code lost:
    
        R(r7.a);
     */
    /* JADX WARN: Code restructure failed: missing block: B:76:0x0106, code lost:
    
        r7.a.i();
        r13.n.remove(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:77:0x0116, code lost:
    
        if (r5 >= r13.n.size()) goto L105;
     */
    /* JADX WARN: Code restructure failed: missing block: B:79:0x0121, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Code restructure failed: missing block: B:83:0x0118, code lost:
    
        r7 = (com.google.ads.interactivemedia.v3.internal.gi) r13.n.get(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:86:0x0123, code lost:
    
        r0 = move-exception;
     */
    /* JADX WARN: Code restructure failed: missing block: B:87:0x0124, code lost:
    
        r7.a.i();
        r13.n.remove(r5);
     */
    /* JADX WARN: Code restructure failed: missing block: B:88:0x012e, code lost:
    
        throw r0;
     */
    /* JADX WARN: Code restructure failed: missing block: B:90:0x012f, code lost:
    
        r13.I = r5;
     */
    /* JADX WARN: Code restructure failed: missing block: B:96:0x00e2, code lost:
    
        r5 = r5 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:97:0x00ea, code lost:
    
        if (r5 >= r13.n.size()) goto L44;
     */
    /* JADX WARN: Code restructure failed: missing block: B:98:0x00cf, code lost:
    
        r7 = null;
     */
    /* JADX WARN: Unsupported multi-entry loop pattern (BACK_EDGE: B:61:0x00ea -> B:51:0x00c6). Please report as a decompilation issue!!! */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void Z() throws com.google.ads.interactivemedia.v3.internal.ev {
        /*
            Method dump skipped, instructions count: 430
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.gm.Z():void");
    }

    private final void aa(be beVar, te teVar, be beVar2, te teVar2, long j) {
        if (!ai(beVar, teVar)) {
            au auVar = teVar.b() ? au.a : this.t.n;
            if (this.m.c().equals(auVar)) {
                return;
            }
            this.m.g(auVar);
            return;
        }
        beVar.o(beVar.n(teVar.a, this.k).c, this.j);
        er erVar = this.O;
        ac acVar = this.j.k;
        int i = cq.a;
        erVar.d(acVar);
        if (j != -9223372036854775807L) {
            this.O.e(s(beVar, teVar.a, j));
            return;
        }
        if (cq.V(!beVar2.p() ? beVar2.o(beVar2.n(teVar2.a, this.k).c, this.j).b : null, this.j.b)) {
            return;
        }
        this.O.e(-9223372036854775807L);
    }

    private final synchronized void ab(atq atqVar, long j) {
        long elapsedRealtime = SystemClock.elapsedRealtime() + 500;
        boolean z = false;
        for (long j2 = 500; !((Boolean) atqVar.a()).booleanValue() && j2 > 0; j2 = elapsedRealtime - SystemClock.elapsedRealtime()) {
            try {
                wait(j2);
            } catch (InterruptedException unused) {
                z = true;
            }
        }
        if (z) {
            Thread.currentThread().interrupt();
        }
    }

    private final boolean ac() {
        gq c = this.p.c();
        return (c == null || c.c() == Long.MIN_VALUE) ? false : true;
    }

    private static boolean ad(hh hhVar) {
        return hhVar.bg() != 0;
    }

    private final boolean ae() {
        gq d = this.p.d();
        long j = d.f.e;
        if (d.d) {
            return j == -9223372036854775807L || this.t.r < j || !ah();
        }
        return false;
    }

    private static boolean af(hb hbVar, bc bcVar) {
        te teVar = hbVar.b;
        be beVar = hbVar.a;
        return beVar.p() || beVar.n(teVar.a, bcVar).f;
    }

    private static boolean ag(gi giVar, be beVar, be beVar2, int i, boolean z, bd bdVar, bc bcVar) {
        Object obj = giVar.d;
        if (obj == null) {
            giVar.a.c();
            giVar.a.c();
            Pair y = y(beVar, new gl(giVar.a.e(), giVar.a.a(), cq.t(-9223372036854775807L)), false, i, z, bdVar, bcVar);
            if (y == null) {
                return false;
            }
            giVar.a(beVar.a(y.first), ((Long) y.second).longValue(), y.first);
            giVar.a.c();
            return true;
        }
        int a = beVar.a(obj);
        if (a == -1) {
            return false;
        }
        giVar.a.c();
        giVar.b = a;
        beVar2.n(giVar.d, bcVar);
        if (bcVar.f && beVar2.o(bcVar.c, bdVar).o == beVar2.a(giVar.d)) {
            Pair k = beVar.k(bdVar, bcVar, beVar.n(giVar.d, bcVar).c, giVar.c + bcVar.e);
            giVar.a(beVar.a(k.first), ((Long) k.second).longValue(), k.first);
        }
        return true;
    }

    private final boolean ah() {
        hb hbVar = this.t;
        return hbVar.l && hbVar.m == 0;
    }

    private final boolean ai(be beVar, te teVar) {
        if (!teVar.b() && !beVar.p()) {
            beVar.o(beVar.n(teVar.a, this.k).c, this.j);
            if (this.j.c()) {
                bd bdVar = this.j;
                if (bdVar.i && bdVar.f != -9223372036854775807L) {
                    return true;
                }
            }
        }
        return false;
    }

    private static s[] aj(we weVar) {
        int n = weVar != null ? weVar.n() : 0;
        s[] sVarArr = new s[n];
        for (int i = 0; i < n; i++) {
            sVarArr[i] = weVar.o(i);
        }
        return sVarArr;
    }

    private static final void ak(he heVar) throws ev {
        heVar.k();
        try {
            heVar.f().q(heVar.b(), heVar.g());
        } finally {
            heVar.h(true);
        }
    }

    private static final void al(hh hhVar) throws ev {
        if (hhVar.bg() == 2) {
            hhVar.F();
        }
    }

    private static final void am(hh hhVar) {
        hhVar.C();
        if (hhVar instanceof vi) {
            throw null;
        }
    }

    public static /* bridge */ /* synthetic */ bv c(gm gmVar) {
        return gmVar.g;
    }

    public static Object e(bd bdVar, bc bcVar, int i, boolean z, Object obj, be beVar, be beVar2) {
        int a = beVar.a(obj);
        int b = beVar.b();
        int i2 = 0;
        int i3 = a;
        int i4 = -1;
        while (true) {
            if (i2 >= b || i4 != -1) {
                break;
            }
            i3 = beVar.i(i3, bcVar, bdVar, i, z);
            if (i3 == -1) {
                i4 = -1;
                break;
            }
            i4 = beVar2.a(beVar.f(i3));
            i2++;
        }
        if (i4 == -1) {
            return null;
        }
        return beVar2.f(i4);
    }

    public static /* bridge */ /* synthetic */ void r(gm gmVar) {
        gmVar.D = true;
    }

    private final long s(be beVar, Object obj, long j) {
        beVar.o(beVar.n(obj, this.k).c, this.j);
        bd bdVar = this.j;
        if (bdVar.f != -9223372036854775807L && bdVar.c()) {
            bd bdVar2 = this.j;
            if (bdVar2.i) {
                return cq.t(cq.r(bdVar2.g) - this.j.f) - (j + this.k.e);
            }
        }
        return -9223372036854775807L;
    }

    private final long t() {
        return u(this.t.p);
    }

    private final long u(long j) {
        gq c = this.p.c();
        if (c == null) {
            return 0L;
        }
        return Math.max(0L, j - c.f(this.H));
    }

    private final long v(te teVar, long j, boolean z) throws ev {
        return w(teVar, j, this.p.d() != this.p.e(), z);
    }

    private final long w(te teVar, long j, boolean z, boolean z2) throws ev {
        W();
        this.y = false;
        if (z2 || this.t.e == 3) {
            T(2);
        }
        gq d = this.p.d();
        gq gqVar = d;
        while (gqVar != null && !teVar.equals(gqVar.f.a)) {
            gqVar = gqVar.h();
        }
        if (z || d != gqVar || (gqVar != null && gqVar.g(j) < 0)) {
            hh[] hhVarArr = this.a;
            int length = hhVarArr.length;
            for (int i = 0; i < 2; i++) {
                A(hhVarArr[i]);
            }
            if (gqVar != null) {
                while (this.p.d() != gqVar) {
                    this.p.a();
                }
                this.p.m(gqVar);
                gqVar.t();
                C();
            }
        }
        gt gtVar = this.p;
        if (gqVar != null) {
            gtVar.m(gqVar);
            if (!gqVar.d) {
                gqVar.f = gqVar.f.b(j);
            } else if (gqVar.e) {
                j = gqVar.a.e(j);
                gqVar.a.q(j - this.l);
            }
            N(j);
            J();
        } else {
            gtVar.i();
            N(j);
        }
        F(false);
        this.g.h(2);
        return j;
    }

    private final Pair x(be beVar) {
        long j = 0;
        if (beVar.p()) {
            return Pair.create(hb.h(), 0L);
        }
        Pair k = beVar.k(this.j, this.k, beVar.g(this.B), -9223372036854775807L);
        te h = this.p.h(beVar, k.first, 0L);
        long longValue = ((Long) k.second).longValue();
        if (h.b()) {
            beVar.n(h.a, this.k);
            if (h.c == this.k.d(h.b)) {
                this.k.j();
            }
        } else {
            j = longValue;
        }
        return Pair.create(h, Long.valueOf(j));
    }

    private static Pair y(be beVar, gl glVar, boolean z, int i, boolean z2, bd bdVar, bc bcVar) {
        Pair k;
        Object e;
        int i2;
        long j;
        be beVar2 = glVar.a;
        if (beVar.p()) {
            return null;
        }
        be beVar3 = true == beVar2.p() ? beVar : beVar2;
        try {
            k = beVar3.k(bdVar, bcVar, glVar.b, glVar.c);
        } catch (IndexOutOfBoundsException unused) {
        }
        if (beVar.equals(beVar3)) {
            return k;
        }
        if (beVar.a(k.first) == -1) {
            if (z && (e = e(bdVar, bcVar, i, z2, k.first, beVar3, beVar)) != null) {
                i2 = beVar.n(e, bcVar).c;
                j = -9223372036854775807L;
            }
            return null;
        }
        if (!beVar3.n(k.first, bcVar).f || beVar3.o(bcVar.c, bdVar).o != beVar3.a(k.first)) {
            return k;
        }
        i2 = beVar.n(k.first, bcVar).c;
        j = glVar.c;
        return beVar.k(bdVar, bcVar, i2, j);
    }

    /* JADX WARN: Removed duplicated region for block: B:37:0x00b1  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.ads.interactivemedia.v3.internal.hb z(com.google.ads.interactivemedia.v3.internal.te r17, long r18, long r20, long r22, boolean r24, int r25) {
        /*
            r16 = this;
            r0 = r16
            r2 = r17
            r5 = r20
            boolean r1 = r0.J
            r3 = 0
            r4 = 1
            if (r1 != 0) goto L1e
            com.google.ads.interactivemedia.v3.internal.hb r1 = r0.t
            long r7 = r1.r
            int r1 = (r18 > r7 ? 1 : (r18 == r7 ? 0 : -1))
            if (r1 != 0) goto L1e
            com.google.ads.interactivemedia.v3.internal.hb r1 = r0.t
            com.google.ads.interactivemedia.v3.internal.te r1 = r1.b
            boolean r1 = r2.equals(r1)
            if (r1 != 0) goto L20
        L1e:
            r1 = 1
            goto L21
        L20:
            r1 = 0
        L21:
            r0.J = r1
            r16.M()
            com.google.ads.interactivemedia.v3.internal.hb r1 = r0.t
            com.google.ads.interactivemedia.v3.internal.um r7 = r1.h
            com.google.ads.interactivemedia.v3.internal.wk r8 = r1.i
            java.util.List r1 = r1.j
            com.google.ads.interactivemedia.v3.internal.ha r9 = r0.q
            boolean r9 = r9.h()
            if (r9 == 0) goto L97
            com.google.ads.interactivemedia.v3.internal.gt r1 = r0.p
            com.google.ads.interactivemedia.v3.internal.gq r1 = r1.d()
            if (r1 != 0) goto L41
            com.google.ads.interactivemedia.v3.internal.um r7 = com.google.ads.interactivemedia.v3.internal.um.a
            goto L45
        L41:
            com.google.ads.interactivemedia.v3.internal.um r7 = r1.i()
        L45:
            if (r1 != 0) goto L4a
            com.google.ads.interactivemedia.v3.internal.wk r8 = r0.e
            goto L4e
        L4a:
            com.google.ads.interactivemedia.v3.internal.wk r8 = r1.j()
        L4e:
            com.google.ads.interactivemedia.v3.internal.we[] r9 = r8.c
            com.google.ads.interactivemedia.v3.internal.avk r10 = new com.google.ads.interactivemedia.v3.internal.avk
            r10.<init>()
            int r11 = r9.length
            r12 = 0
            r13 = 0
        L58:
            if (r12 >= r11) goto L78
            r14 = r9[r12]
            if (r14 == 0) goto L75
            com.google.ads.interactivemedia.v3.internal.s r14 = r14.o(r3)
            com.google.ads.interactivemedia.v3.internal.ao r14 = r14.j
            if (r14 != 0) goto L71
            com.google.ads.interactivemedia.v3.internal.ao r14 = new com.google.ads.interactivemedia.v3.internal.ao
            com.google.ads.interactivemedia.v3.internal.an[] r15 = new com.google.ads.interactivemedia.v3.internal.an[r3]
            r14.<init>(r15)
            r10.g(r14)
            goto L75
        L71:
            r10.g(r14)
            r13 = 1
        L75:
            int r12 = r12 + 1
            goto L58
        L78:
            if (r13 == 0) goto L7f
            com.google.ads.interactivemedia.v3.internal.avo r3 = r10.f()
            goto L83
        L7f:
            com.google.ads.interactivemedia.v3.internal.avo r3 = com.google.ads.interactivemedia.v3.internal.avo.o()
        L83:
            if (r1 == 0) goto L93
            com.google.ads.interactivemedia.v3.internal.gr r4 = r1.f
            long r9 = r4.c
            int r11 = (r9 > r5 ? 1 : (r9 == r5 ? 0 : -1))
            if (r11 == 0) goto L93
            com.google.ads.interactivemedia.v3.internal.gr r4 = r4.a(r5)
            r1.f = r4
        L93:
            r13 = r3
        L94:
            r11 = r7
            r12 = r8
            goto Laf
        L97:
            com.google.ads.interactivemedia.v3.internal.hb r3 = r0.t
            com.google.ads.interactivemedia.v3.internal.te r3 = r3.b
            boolean r3 = r2.equals(r3)
            if (r3 != 0) goto Lad
            com.google.ads.interactivemedia.v3.internal.um r1 = com.google.ads.interactivemedia.v3.internal.um.a
            com.google.ads.interactivemedia.v3.internal.wk r3 = r0.e
            com.google.ads.interactivemedia.v3.internal.avo r4 = com.google.ads.interactivemedia.v3.internal.avo.o()
            r11 = r1
            r12 = r3
            r13 = r4
            goto Laf
        Lad:
            r13 = r1
            goto L94
        Laf:
            if (r24 == 0) goto Lb8
            com.google.ads.interactivemedia.v3.internal.gj r1 = r0.u
            r3 = r25
            r1.d(r3)
        Lb8:
            com.google.ads.interactivemedia.v3.internal.hb r1 = r0.t
            long r9 = r16.t()
            r2 = r17
            r3 = r18
            r5 = r20
            r7 = r22
            com.google.ads.interactivemedia.v3.internal.hb r1 = r1.b(r2, r3, r5, r7, r9, r11, r12, r13)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.gm.z(com.google.ads.interactivemedia.v3.internal.te, long, long, long, boolean, int):com.google.ads.interactivemedia.v3.internal.hb");
    }

    public final void a(au auVar) {
        this.g.b(16, auVar).a();
    }

    public final Looper b() {
        return this.i;
    }

    public final void bl(td tdVar) {
        this.g.b(8, tdVar).a();
    }

    public final /* synthetic */ Boolean d() {
        return Boolean.valueOf(this.v);
    }

    public final /* synthetic */ void f(he heVar) {
        try {
            ak(heVar);
        } catch (ev e) {
            cd.c("ExoPlayerImplInternal", "Unexpected error delivering message on external thread.", e);
            throw new RuntimeException(e);
        }
    }

    public final /* bridge */ /* synthetic */ void g(uh uhVar) {
        this.g.b(9, (td) uhVar).a();
    }

    public final void h() {
        this.g.h(22);
    }

    public final boolean handleMessage(Message message) {
        IOException iOException;
        int i;
        boolean z;
        gq e;
        int i2;
        bv bvVar;
        long longValue;
        long j;
        boolean z2;
        te teVar;
        Throwable th;
        long j2;
        boolean z3;
        long j3;
        hb hbVar;
        int i3;
        hb z4;
        be k;
        try {
        } catch (as e2) {
            int i4 = e2.b;
            E(e2, i4 == 1 ? true != e2.a ? 3003 : 3001 : i4 == 4 ? true != e2.a ? 3004 : 3002 : 1000);
        } catch (cz e3) {
            cz czVar = e3;
            i = czVar.a;
            iOException = czVar;
            E(iOException, i);
        } catch (ev e4) {
            ev evVar = e4;
            if (evVar.c == 1 && (e = this.p.e()) != null) {
                evVar = evVar.a(e.f.a);
            }
            if (evVar.i && this.K == null) {
                cd.f("ExoPlayerImplInternal", "Recoverable renderer error", evVar);
                this.K = evVar;
                bv bvVar2 = this.g;
                bvVar2.j(bvVar2.b(25, evVar));
            } else {
                ev evVar2 = this.K;
                if (evVar2 != null) {
                    try {
                        Throwable.class.getDeclaredMethod("addSuppressed", new Class[]{Throwable.class}).invoke(evVar2, new Object[]{evVar});
                    } catch (Exception unused) {
                    }
                    evVar = this.K;
                }
                cd.c("ExoPlayerImplInternal", "Playback error", evVar);
                z = true;
                V(true, false);
                this.t = this.t.d(evVar);
            }
        } catch (nl e5) {
            nl nlVar = e5;
            i = nlVar.a;
            iOException = nlVar;
            E(iOException, i);
        } catch (sb e6) {
            iOException = e6;
            i = 1002;
            E(iOException, i);
        } catch (IOException e7) {
            iOException = e7;
            i = 2000;
            E(iOException, i);
        } catch (RuntimeException e8) {
            ev d = ev.d(e8, ((e8 instanceof IllegalStateException) || (e8 instanceof IllegalArgumentException)) ? 1004 : 1000);
            cd.c("ExoPlayerImplInternal", "Playback error", d);
            V(true, false);
            this.t = this.t.d(d);
        }
        switch (message.what) {
            case 0:
                i2 = 2;
                this.u.a(1);
                L(false, false, false, true);
                this.M.b();
                T(true != this.t.a.p() ? 2 : 4);
                this.q.e(this.f.f());
                bvVar = this.g;
                bvVar.h(i2);
                z = true;
                K();
                return z;
            case 1:
                S(message.arg1 != 0, message.arg2, true, 1);
                z = true;
                K();
                return z;
            case 2:
                B();
                z = true;
                K();
                return z;
            case 3:
                gl glVar = (gl) message.obj;
                this.u.a(1);
                Pair y = y(this.t.a, glVar, true, this.A, this.B, this.j, this.k);
                if (y == null) {
                    Pair x = x(this.t.a);
                    teVar = (te) x.first;
                    longValue = ((Long) x.second).longValue();
                    j = -9223372036854775807L;
                    z2 = !this.t.a.p();
                } else {
                    Object obj = y.first;
                    longValue = ((Long) y.second).longValue();
                    j = glVar.c == -9223372036854775807L ? -9223372036854775807L : longValue;
                    te h = this.p.h(this.t.a, obj, longValue);
                    if (h.b()) {
                        this.t.a.n(h.a, this.k);
                        if (this.k.d(h.b) == h.c) {
                            this.k.j();
                        }
                        teVar = h;
                        longValue = 0;
                        z2 = true;
                    } else {
                        z2 = glVar.c == -9223372036854775807L;
                        teVar = h;
                    }
                }
                try {
                    if (this.t.a.p()) {
                        this.G = glVar;
                    } else if (y == null) {
                        if (this.t.e != 1) {
                            T(4);
                        }
                        L(false, true, false, true);
                    } else {
                        try {
                            if (teVar.equals(this.t.b)) {
                                gq d2 = this.p.d();
                                j3 = (d2 == null || !d2.d || longValue == 0) ? longValue : d2.a.a(longValue, this.s);
                                if (cq.x(j3) == cq.x(this.t.r) && ((i3 = (hbVar = this.t).e) == 2 || i3 == 3)) {
                                    long j4 = hbVar.r;
                                    z4 = z(teVar, j4, j, j4, z2, 2);
                                    this.t = z4;
                                    z = true;
                                    K();
                                    return z;
                                }
                            } else {
                                j3 = longValue;
                            }
                            hb hbVar2 = this.t;
                            be beVar = hbVar2.a;
                            aa(beVar, teVar, beVar, hbVar2.b, j);
                            z4 = z(teVar, j2, j, j2, z3, 2);
                            this.t = z4;
                            z = true;
                            K();
                            return z;
                        } catch (Throwable th2) {
                            th = th2;
                            Throwable th3 = th;
                            this.t = z(teVar, j2, j, j2, z3, 2);
                            throw th3;
                        }
                        j2 = v(teVar, j3, this.t.e == 4);
                        z3 = z2 | (longValue != j2);
                    }
                    j2 = longValue;
                    z3 = z2;
                    z4 = z(teVar, j2, j, j2, z3, 2);
                    this.t = z4;
                    z = true;
                    K();
                    return z;
                } catch (Throwable th4) {
                    th = th4;
                    j2 = longValue;
                    z3 = z2;
                }
                break;
            case 4:
                this.m.g((au) message.obj);
                H(this.m.c(), true);
                z = true;
                K();
                return z;
            case 5:
                this.s = (hl) message.obj;
                z = true;
                K();
                return z;
            case 6:
                V(false, true);
                z = true;
                K();
                return z;
            case 7:
                L(true, false, true, false);
                this.M.c();
                T(1);
                this.h.quit();
                synchronized (this) {
                    this.v = true;
                    notifyAll();
                }
                return true;
            case 8:
                if (this.p.l((td) message.obj)) {
                    gq c = this.p.c();
                    c.m(this.m.c().b, this.t.a);
                    Y(c.i(), c.j());
                    if (c == this.p.d()) {
                        N(c.f.b);
                        C();
                        hb hbVar3 = this.t;
                        te teVar2 = hbVar3.b;
                        long j5 = c.f.b;
                        this.t = z(teVar2, j5, hbVar3.c, j5, false, 5);
                    }
                    J();
                }
                z = true;
                K();
                return z;
            case 9:
                if (this.p.l((td) message.obj)) {
                    this.p.k(this.H);
                    J();
                }
                z = true;
                K();
                return z;
            case 10:
                float f = this.m.c().b;
                gq d3 = this.p.d();
                gq e9 = this.p.e();
                boolean z5 = true;
                while (d3 != null && d3.d) {
                    wk k2 = d3.k(f, this.t.a);
                    wk j6 = d3.j();
                    if (j6 != null && j6.c.length == k2.c.length) {
                        for (int i5 = 0; i5 < k2.c.length; i5++) {
                            if (k2.a(j6, i5)) {
                            }
                        }
                        z5 &= d3 != e9;
                        d3 = d3.h();
                    }
                    if (z5) {
                        gq d4 = this.p.d();
                        boolean m = this.p.m(d4);
                        int length = this.a.length;
                        boolean[] zArr = new boolean[2];
                        long a = d4.a(k2, this.t.r, m, zArr);
                        hb hbVar4 = this.t;
                        boolean z6 = (hbVar4.e == 4 || a == hbVar4.r) ? false : true;
                        hb hbVar5 = this.t;
                        i2 = 2;
                        this.t = z(hbVar5.b, a, hbVar5.c, hbVar5.d, z6, 5);
                        if (z6) {
                            N(a);
                        }
                        int length2 = this.a.length;
                        boolean[] zArr2 = new boolean[2];
                        int i6 = 0;
                        while (true) {
                            hh[] hhVarArr = this.a;
                            int length3 = hhVarArr.length;
                            if (i6 < 2) {
                                hh hhVar = hhVarArr[i6];
                                boolean ad = ad(hhVar);
                                zArr2[i6] = ad;
                                uf ufVar = d4.c[i6];
                                if (ad) {
                                    if (ufVar != hhVar.n()) {
                                        A(hhVar);
                                    } else if (zArr[i6]) {
                                        hhVar.B(this.H);
                                    }
                                }
                                i6++;
                            } else {
                                D(zArr2);
                            }
                        }
                    } else {
                        i2 = 2;
                        this.p.m(d3);
                        if (d3.d) {
                            d3.s(k2, Math.max(d3.f.b, d3.f(this.H)));
                        }
                    }
                    F(true);
                    if (this.t.e != 4) {
                        J();
                        Z();
                        bvVar = this.g;
                        bvVar.h(i2);
                    }
                }
                z = true;
                K();
                return z;
            case 11:
                int i7 = message.arg1;
                this.A = i7;
                if (!this.p.p(this.t.a, i7)) {
                    Q(true);
                }
                F(false);
                z = true;
                K();
                return z;
            case 12:
                boolean z7 = message.arg1 != 0;
                this.B = z7;
                if (!this.p.q(this.t.a, z7)) {
                    Q(true);
                }
                F(false);
                z = true;
                K();
                return z;
            case 13:
                boolean z8 = message.arg1 != 0;
                AtomicBoolean atomicBoolean = (AtomicBoolean) message.obj;
                if (this.C != z8) {
                    this.C = z8;
                    if (!z8) {
                        hh[] hhVarArr2 = this.a;
                        int length4 = hhVarArr2.length;
                        for (int i8 = 0; i8 < 2; i8++) {
                            hh hhVar2 = hhVarArr2[i8];
                            if (!ad(hhVar2) && this.b.remove(hhVar2)) {
                                hhVar2.A();
                            }
                        }
                    }
                }
                if (atomicBoolean != null) {
                    synchronized (this) {
                        atomicBoolean.set(true);
                        notifyAll();
                    }
                }
                z = true;
                K();
                return z;
            case 14:
                he heVar = (he) message.obj;
                heVar.c();
                R(heVar);
                z = true;
                K();
                return z;
            case 15:
                he heVar2 = (he) message.obj;
                Looper d5 = heVar2.d();
                if (d5.getThread().isAlive()) {
                    this.o.b(d5, null).e(new ge(this, heVar2));
                } else {
                    cd.e("TAG", "Trying to send message on a dead thread.");
                    heVar2.h(false);
                }
                z = true;
                K();
                return z;
            case 16:
                H((au) message.obj, false);
                z = true;
                K();
                return z;
            case 17:
                gg ggVar = (gg) message.obj;
                this.u.a(1);
                if (gg.a(ggVar) != -1) {
                    this.G = new gl(new hf(gg.c(ggVar), gg.d(ggVar)), gg.a(ggVar), gg.b(ggVar));
                }
                k = this.q.k(gg.c(ggVar), gg.d(ggVar));
                G(k, false);
                z = true;
                K();
                return z;
            case 18:
                gg ggVar2 = (gg) message.obj;
                int i9 = message.arg1;
                this.u.a(1);
                ha haVar = this.q;
                if (i9 == -1) {
                    i9 = haVar.a();
                }
                k = haVar.i(i9, gg.c(ggVar2), gg.d(ggVar2));
                G(k, false);
                z = true;
                K();
                return z;
            case 19:
                gh ghVar = (gh) message.obj;
                this.u.a(1);
                ha haVar2 = this.q;
                int i10 = ghVar.a;
                k = haVar2.o();
                G(k, false);
                z = true;
                K();
                return z;
            case 20:
                int i11 = message.arg1;
                int i12 = message.arg2;
                ui uiVar = (ui) message.obj;
                this.u.a(1);
                k = this.q.j(i11, i12, uiVar);
                G(k, false);
                z = true;
                K();
                return z;
            case 21:
                ui uiVar2 = (ui) message.obj;
                this.u.a(1);
                k = this.q.l(uiVar2);
                G(k, false);
                z = true;
                K();
                return z;
            case 22:
                G(this.q.b(), true);
                z = true;
                K();
                return z;
            case 23:
                this.w = message.arg1 != 0;
                M();
                if (this.x && this.p.e() != this.p.d()) {
                    Q(true);
                    F(false);
                }
                z = true;
                K();
                return z;
            case 24:
                boolean z9 = message.arg1 == 1;
                if (z9 != this.E) {
                    this.E = z9;
                    if (!z9 && this.t.o) {
                        this.g.h(2);
                    }
                }
                z = true;
                K();
                return z;
            case 25:
                Q(true);
                z = true;
                K();
                return z;
            default:
                return false;
        }
    }

    public final void j() {
        this.g.h(10);
    }

    public final void k() {
        this.g.a(0).a();
    }

    public final void l(be beVar, int i, long j) {
        this.g.b(3, new gl(beVar, i, j)).a();
    }

    public final synchronized void m(he heVar) {
        if (!this.v && this.h.isAlive()) {
            this.g.b(14, heVar).a();
            return;
        }
        cd.e("ExoPlayerImplInternal", "Ignoring messages sent after release.");
        heVar.h(false);
    }

    public final void n(boolean z, int i) {
        this.g.d(z ? 1 : 0, i).a();
    }

    public final void o() {
        this.g.a(6).a();
    }

    public final synchronized boolean p() {
        if (!this.v && this.h.isAlive()) {
            this.g.h(7);
            ab(new gd(this), 500L);
            return this.v;
        }
        return true;
    }

    public final void q(List list, int i, long j, ui uiVar) {
        this.g.b(17, new gg(list, uiVar, i, j)).a();
    }
}
