package com.google.ads.interactivemedia.v3.internal;

import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Set;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class nj implements nt {
    volatile nb a;
    private final UUID c;
    private final oj d;
    private final HashMap e;
    private final int[] f;
    private final ng g;
    private final ni h;
    private final long i;
    private final List j;
    private final Set k;
    private final Set l;
    private int m;
    private ob n;
    private my o;
    private my p;
    private Looper q;
    private Handler r;
    private byte[] s;
    private iw t;
    private final od u;
    private final ws v;

    public /* synthetic */ nj(UUID uuid, od odVar, oj ojVar, HashMap hashMap, int[] iArr, ws wsVar, long j, byte[] bArr, byte[] bArr2, byte[] bArr3) {
        af.s(uuid);
        af.v(!i.b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.c = uuid;
        this.u = odVar;
        this.d = ojVar;
        this.e = hashMap;
        this.f = iArr;
        this.v = wsVar;
        this.g = new ng();
        this.h = new ni(this);
        this.j = new ArrayList();
        this.k = axo.f();
        this.l = axo.f();
        this.i = 300000L;
    }

    private final void A() {
        if (this.n != null && this.m == 0 && this.j.isEmpty() && this.k.isEmpty()) {
            ob obVar = this.n;
            af.s(obVar);
            obVar.f();
            this.n = null;
        }
    }

    private final void B() {
        axq e = avx.l(this.l).e();
        while (e.hasNext()) {
            ((nm) e.next()).m(null);
        }
    }

    private final void C() {
        axq e = avx.l(this.k).e();
        while (e.hasNext()) {
            ((nf) e.next()).c();
        }
    }

    private static boolean D(nm nmVar) {
        if (nmVar.a() != 1) {
            return false;
        }
        if (cq.a < 19) {
            return true;
        }
        nl c = nmVar.c();
        af.s(c);
        return c.getCause() instanceof ResourceBusyException;
    }

    private static final void E(nm nmVar, nn nnVar) {
        nmVar.m(nnVar);
        nmVar.m(null);
    }

    public static /* bridge */ /* synthetic */ int a(nj njVar) {
        return njVar.m;
    }

    public static /* bridge */ /* synthetic */ long c(nj njVar) {
        return njVar.i;
    }

    public static /* bridge */ /* synthetic */ Handler d(nj njVar) {
        return njVar.r;
    }

    public static /* bridge */ /* synthetic */ Looper e(nj njVar) {
        return njVar.q;
    }

    public static /* bridge */ /* synthetic */ my f(nj njVar) {
        return njVar.p;
    }

    public static /* bridge */ /* synthetic */ my g(nj njVar) {
        return njVar.o;
    }

    public static /* bridge */ /* synthetic */ ng h(nj njVar) {
        return njVar.g;
    }

    public static /* bridge */ /* synthetic */ List k(nj njVar) {
        return njVar.j;
    }

    public static /* bridge */ /* synthetic */ Set l(nj njVar) {
        return njVar.l;
    }

    public static /* bridge */ /* synthetic */ Set m(nj njVar) {
        return njVar.k;
    }

    public static /* bridge */ /* synthetic */ void n(nj njVar) {
        njVar.A();
    }

    public static /* bridge */ /* synthetic */ void r(nj njVar) {
        njVar.p = null;
    }

    public static /* bridge */ /* synthetic */ void s(nj njVar) {
        njVar.o = null;
    }

    public static /* bridge */ /* synthetic */ nm t(nj njVar, Looper looper, nn nnVar, s sVar) {
        return njVar.x(looper, nnVar, sVar, false);
    }

    private final my v(List list, boolean z, nn nnVar) {
        af.s(this.n);
        UUID uuid = this.c;
        ob obVar = this.n;
        ng ngVar = this.g;
        ni niVar = this.h;
        byte[] bArr = this.s;
        HashMap hashMap = this.e;
        oj ojVar = this.d;
        Looper looper = this.q;
        af.s(looper);
        ws wsVar = this.v;
        iw iwVar = this.t;
        af.s(iwVar);
        my myVar = new my(uuid, obVar, ngVar, niVar, list, z, z, bArr, hashMap, ojVar, looper, wsVar, iwVar, null, null, null);
        myVar.h(nnVar);
        myVar.h(null);
        return myVar;
    }

    private final my w(List list, boolean z, nn nnVar, boolean z2) {
        my v = v(list, z, nnVar);
        if (D(v) && !this.l.isEmpty()) {
            B();
            E(v, nnVar);
            v = v(list, z, nnVar);
        }
        if (!D(v) || !z2 || this.k.isEmpty()) {
            return v;
        }
        C();
        if (!this.l.isEmpty()) {
            B();
        }
        E(v, nnVar);
        return v(list, z, nnVar);
    }

    private final nm x(Looper looper, nn nnVar, s sVar, boolean z) {
        if (this.a == null) {
            this.a = new nb(this, looper);
        }
        o oVar = sVar.o;
        List list = null;
        if (oVar == null) {
            int b = ar.b(sVar.l);
            ob obVar = this.n;
            af.s(obVar);
            if ((obVar.a() == 2 && oc.a) || cq.n(this.f, b) == -1 || obVar.a() == 1) {
                return null;
            }
            my myVar = this.o;
            if (myVar == null) {
                my w = w(avo.o(), true, null, z);
                this.j.add(w);
                this.o = w;
            } else {
                myVar.h(null);
            }
            return this.o;
        }
        if (this.s == null) {
            af.s(oVar);
            list = y(oVar, this.c, false);
            if (list.isEmpty()) {
                nc ncVar = new nc(this.c);
                cd.c("DefaultDrmSessionMgr", "DRM error", ncVar);
                if (nnVar != null) {
                    nnVar.f(ncVar);
                }
                return new nz(new nl(ncVar, 6003));
            }
        }
        my myVar2 = this.p;
        if (myVar2 != null) {
            myVar2.h(nnVar);
            return myVar2;
        }
        my w2 = w(list, false, nnVar, z);
        this.p = w2;
        this.j.add(w2);
        return w2;
    }

    private static List y(o oVar, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(oVar.b);
        for (int i = 0; i < oVar.b; i++) {
            n a = oVar.a(i);
            if ((a.c(uuid) || (i.c.equals(uuid) && a.c(i.b))) && (a.d != null || z)) {
                arrayList.add(a);
            }
        }
        return arrayList;
    }

    private final synchronized void z(Looper looper) {
        Looper looper2 = this.q;
        if (looper2 == null) {
            this.q = looper;
            this.r = new Handler(looper);
        } else {
            af.w(looper2 == looper);
            af.s(this.r);
        }
    }

    public final int b(s sVar) {
        ob obVar = this.n;
        af.s(obVar);
        int a = obVar.a();
        o oVar = sVar.o;
        if (oVar == null) {
            if (cq.n(this.f, ar.b(sVar.l)) != -1) {
                return a;
            }
            return 0;
        }
        if (this.s == null) {
            if (y(oVar, this.c, true).isEmpty()) {
                if (oVar.b == 1 && oVar.a(0).c(i.b)) {
                    cd.e("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: ".concat(String.valueOf(this.c)));
                }
                return 1;
            }
            String str = oVar.a;
            if (str != null && !"cenc".equals(str) && (!"cbcs".equals(str) ? "cbc1".equals(str) || "cens".equals(str) : cq.a < 25)) {
                return 1;
            }
        }
        return a;
    }

    public final nm i(nn nnVar, s sVar) {
        af.w(this.m > 0);
        af.t(this.q);
        return x(this.q, nnVar, sVar, true);
    }

    public final ns j(nn nnVar, s sVar) {
        af.w(this.m > 0);
        af.t(this.q);
        nf nfVar = new nf(this, nnVar);
        Handler d = d(nfVar.a);
        af.s(d);
        d.post(new ne(nfVar, sVar));
        return nfVar;
    }

    public final void o() {
        int i = this.m;
        this.m = i + 1;
        if (i != 0) {
            return;
        }
        if (this.n == null) {
            ob a = this.u.a(this.c);
            this.n = a;
            a.h(new na(this));
        } else {
            for (int i2 = 0; i2 < this.j.size(); i2++) {
                ((my) this.j.get(i2)).h(null);
            }
        }
    }

    public final void p() {
        int i = this.m - 1;
        this.m = i;
        if (i != 0) {
            return;
        }
        ArrayList arrayList = new ArrayList(this.j);
        for (int i2 = 0; i2 < arrayList.size(); i2++) {
            ((my) arrayList.get(i2)).m(null);
        }
        C();
        A();
    }

    public final void q(Looper looper, iw iwVar) {
        z(looper);
        this.t = iwVar;
    }

    public final void u(byte[] bArr) {
        af.w(this.j.isEmpty());
        this.s = bArr;
    }
}
