package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class ha {
    private final iw a;
    private final gz e;
    private final tj f;
    private final nn g;
    private final HashMap h;
    private final Set i;
    private boolean j;
    private dw k;
    private ui l = new ui();
    private final IdentityHashMap c = new IdentityHashMap();
    private final Map d = new HashMap();
    private final List b = new ArrayList();

    public ha(gz gzVar, hu huVar, Handler handler, iw iwVar) {
        this.a = iwVar;
        this.e = gzVar;
        tj tjVar = new tj();
        this.f = tjVar;
        nn nnVar = new nn();
        this.g = nnVar;
        this.h = new HashMap();
        this.i = new HashSet();
        tjVar.b(handler, huVar);
        nnVar.b(handler, huVar);
    }

    public static /* bridge */ /* synthetic */ nn c(ha haVar) {
        return haVar.g;
    }

    public static /* bridge */ /* synthetic */ tj d(ha haVar) {
        return haVar.f;
    }

    private final void p(int i, int i2) {
        while (i < this.b.size()) {
            ((gy) this.b.get(i)).d += i2;
            i++;
        }
    }

    private final void q(gy gyVar) {
        gx gxVar = (gx) this.h.get(gyVar);
        if (gxVar != null) {
            gxVar.a.B(gxVar.b);
        }
    }

    private final void r() {
        Iterator it = this.i.iterator();
        while (it.hasNext()) {
            gy gyVar = (gy) it.next();
            if (gyVar.c.isEmpty()) {
                q(gyVar);
                it.remove();
            }
        }
    }

    private final void s(gy gyVar) {
        if (gyVar.e && gyVar.c.isEmpty()) {
            gx gxVar = (gx) this.h.remove(gyVar);
            af.s(gxVar);
            gxVar.a.H(gxVar.b);
            gxVar.a.J(gxVar.c);
            gxVar.a.I(gxVar.c);
            this.i.remove(gyVar);
        }
    }

    private final void t(gy gyVar) {
        ta taVar = gyVar.a;
        gv gvVar = new gv(this);
        gw gwVar = new gw(this, gyVar);
        this.h.put(gyVar, new gx(taVar, gvVar, gwVar));
        taVar.A(cq.C(), gwVar);
        taVar.z(cq.C(), gwVar);
        taVar.F(gvVar, this.k, this.a);
    }

    private final void u(int i, int i2) {
        while (true) {
            i2--;
            if (i2 < i) {
                return;
            }
            gy gyVar = (gy) this.b.remove(i2);
            this.d.remove(gyVar.b);
            p(i2, -gyVar.a.k().c());
            gyVar.e = true;
            if (this.j) {
                s(gyVar);
            }
        }
    }

    public final int a() {
        return this.b.size();
    }

    public final be b() {
        if (this.b.isEmpty()) {
            return be.a;
        }
        int i = 0;
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            gy gyVar = (gy) this.b.get(i2);
            gyVar.d = i;
            i += gyVar.a.k().c();
        }
        return new hf(this.b, this.l);
    }

    public final void e(dw dwVar) {
        af.w(!this.j);
        this.k = dwVar;
        for (int i = 0; i < this.b.size(); i++) {
            gy gyVar = (gy) this.b.get(i);
            t(gyVar);
            this.i.add(gyVar);
        }
        this.j = true;
    }

    public final void f() {
        for (gx gxVar : this.h.values()) {
            try {
                gxVar.a.H(gxVar.b);
            } catch (RuntimeException e) {
                cd.c("MediaSourceList", "Failed to release child source.", e);
            }
            gxVar.a.J(gxVar.c);
            gxVar.a.I(gxVar.c);
        }
        this.h.clear();
        this.i.clear();
        this.j = false;
    }

    public final void g(td tdVar) {
        gy gyVar = (gy) this.c.remove(tdVar);
        af.s(gyVar);
        gyVar.a.o(tdVar);
        gyVar.c.remove(((sx) tdVar).a);
        if (!this.c.isEmpty()) {
            r();
        }
        s(gyVar);
    }

    public final boolean h() {
        return this.j;
    }

    public final be i(int i, List list, ui uiVar) {
        int i2;
        if (!list.isEmpty()) {
            this.l = uiVar;
            for (int i3 = i; i3 < list.size() + i; i3++) {
                gy gyVar = (gy) list.get(i3 - i);
                if (i3 > 0) {
                    gy gyVar2 = (gy) this.b.get(i3 - 1);
                    i2 = gyVar2.d + gyVar2.a.k().c();
                } else {
                    i2 = 0;
                }
                gyVar.c(i2);
                p(i3, gyVar.a.k().c());
                this.b.add(i3, gyVar);
                this.d.put(gyVar.b, gyVar);
                if (this.j) {
                    t(gyVar);
                    if (this.c.isEmpty()) {
                        this.i.add(gyVar);
                    } else {
                        q(gyVar);
                    }
                }
            }
        }
        return b();
    }

    public final be j(int i, int i2, ui uiVar) {
        boolean z = false;
        if (i >= 0 && i <= i2 && i2 <= a()) {
            z = true;
        }
        af.u(z);
        this.l = uiVar;
        u(i, i2);
        return b();
    }

    public final be k(List list, ui uiVar) {
        u(0, this.b.size());
        return i(this.b.size(), list, uiVar);
    }

    public final be l(ui uiVar) {
        int a = a();
        if (uiVar.c() != a) {
            uiVar = uiVar.f().g(0, a);
        }
        this.l = uiVar;
        return b();
    }

    public final td m(te teVar, wr wrVar, long j) {
        Object y = eg.y(teVar.a);
        te c = teVar.c(eg.x(teVar.a));
        gy gyVar = (gy) this.d.get(y);
        af.s(gyVar);
        this.i.add(gyVar);
        gx gxVar = (gx) this.h.get(gyVar);
        if (gxVar != null) {
            gxVar.a.D(gxVar.b);
        }
        gyVar.c.add(c);
        sx s = gyVar.a.s(c, wrVar, j);
        this.c.put(s, gyVar);
        r();
        return s;
    }

    public final /* synthetic */ void n() {
        this.e.h();
    }

    public final be o() {
        af.u(a() >= 0);
        this.l = null;
        return b();
    }
}
