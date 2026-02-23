package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import android.os.Handler;
import android.os.Message;
import android.util.Pair;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.HashMap;
import java.util.HashSet;
import java.util.IdentityHashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class sp extends si {
    private static final ai a;
    private final List b;
    private final Set c;
    private Handler d;
    private final List e;
    private final IdentityHashMap f;
    private final Map g;
    private final Set h;
    private boolean i;
    private Set j;
    private ui k;

    static {
        v vVar = new v();
        vVar.c(Uri.EMPTY);
        a = vVar.a();
    }

    public sp(ui uiVar, tg... tgVarArr) {
        this.k = uiVar.c() > 0 ? uiVar.f() : uiVar;
        this.f = new IdentityHashMap();
        this.g = new HashMap();
        this.b = new ArrayList();
        this.e = new ArrayList();
        this.j = new HashSet();
        this.c = new HashSet();
        this.h = new HashSet();
        s(Arrays.asList(tgVarArr));
    }

    public static /* synthetic */ void N(sp spVar, Message message) {
        int i;
        int i2 = message.what;
        if (i2 == 0) {
            Object obj = message.obj;
            int i3 = cq.a;
            so soVar = (so) obj;
            spVar.k = spVar.k.g(soVar.a, ((Collection) soVar.b).size());
            spVar.Q(soVar.a, (Collection) soVar.b);
            spVar.Z(null);
            return;
        }
        if (i2 != 1) {
            if (i2 != 2) {
                if (i2 == 3) {
                    Object obj2 = message.obj;
                    int i4 = cq.a;
                    spVar.k = (ui) ((so) obj2).b;
                    spVar.Z(null);
                    return;
                }
                if (i2 == 4) {
                    spVar.X();
                    return;
                } else {
                    if (i2 != 5) {
                        throw new IllegalStateException();
                    }
                    Object obj3 = message.obj;
                    int i5 = cq.a;
                    spVar.T((Set) obj3);
                    return;
                }
            }
            Object obj4 = message.obj;
            int i6 = cq.a;
            so soVar2 = (so) obj4;
            ui uiVar = spVar.k;
            int i7 = soVar2.a;
            ui h = uiVar.h(i7, i7 + 1);
            spVar.k = h;
            spVar.k = h.g(((Integer) soVar2.b).intValue(), 1);
            int i8 = soVar2.a;
            int intValue = ((Integer) soVar2.b).intValue();
            int min = Math.min(i8, intValue);
            int max = Math.max(i8, intValue);
            int i9 = ((sn) spVar.e.get(min)).e;
            List list = spVar.e;
            list.add(intValue, (sn) list.remove(i8));
            while (min <= max) {
                sn snVar = (sn) spVar.e.get(min);
                snVar.d = min;
                snVar.e = i9;
                i9 += snVar.a.k().c();
                min++;
            }
            spVar.Z(null);
            return;
        }
        Object obj5 = message.obj;
        int i10 = cq.a;
        so soVar3 = (so) obj5;
        int i11 = soVar3.a;
        int intValue2 = ((Integer) soVar3.b).intValue();
        if (i11 == 0) {
            i = 0;
            if (intValue2 == spVar.k.c()) {
                spVar.k = spVar.k.f();
            } else {
                i11 = 0;
                spVar.k = spVar.k.h(i11, intValue2);
                i = i11;
            }
        } else {
            spVar.k = spVar.k.h(i11, intValue2);
            i = i11;
        }
        while (true) {
            intValue2--;
            if (intValue2 < i) {
                spVar.Z(null);
                return;
            }
            sn snVar2 = (sn) spVar.e.remove(intValue2);
            spVar.g.remove(snVar2.b);
            spVar.R(intValue2, -1, -snVar2.a.k().c());
            snVar2.f = true;
            spVar.U(snVar2);
        }
    }

    private final Handler P() {
        Handler handler = this.d;
        af.s(handler);
        return handler;
    }

    private final void Q(int i, Collection collection) {
        int i2;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            sn snVar = (sn) it.next();
            int i3 = i + 1;
            if (i > 0) {
                sn snVar2 = (sn) this.e.get(i - 1);
                i2 = snVar2.e + snVar2.a.k().c();
            } else {
                i2 = 0;
            }
            snVar.a(i, i2);
            R(i, 1, snVar.a.k().c());
            this.e.add(i, snVar);
            this.g.put(snVar.b, snVar);
            g(snVar, snVar.a);
            if (K() && this.f.isEmpty()) {
                this.h.add(snVar);
            } else {
                e(snVar);
            }
            i = i3;
        }
    }

    private final void R(int i, int i2, int i3) {
        while (i < this.e.size()) {
            sn snVar = (sn) this.e.get(i);
            snVar.d += i2;
            snVar.e += i3;
            i++;
        }
    }

    private final void S() {
        Iterator it = this.h.iterator();
        while (it.hasNext()) {
            sn snVar = (sn) it.next();
            if (snVar.c.isEmpty()) {
                e(snVar);
                it.remove();
            }
        }
    }

    private final synchronized void T(Set set) {
        Iterator it = set.iterator();
        if (it.hasNext()) {
            throw null;
        }
        this.c.removeAll(set);
    }

    private final void U(sn snVar) {
        if (snVar.f && snVar.c.isEmpty()) {
            this.h.remove(snVar);
            i(snVar);
        }
    }

    private final void V() {
        Z(null);
    }

    /* JADX INFO: Access modifiers changed from: private */
    /* renamed from: W, reason: merged with bridge method [inline-methods] */
    public final void j(sn snVar, be beVar) {
        if (snVar.d + 1 < this.e.size()) {
            int c = beVar.c() - (((sn) this.e.get(snVar.d + 1)).e - snVar.e);
            if (c != 0) {
                R(snVar.d + 1, 0, c);
            }
        }
        V();
    }

    private final void X() {
        this.i = false;
        Set set = this.j;
        this.j = new HashSet();
        G(new sl(this.e, this.k));
        P().obtainMessage(5, set).sendToTarget();
    }

    private final void Y(int i, Collection collection) {
        af.u(true);
        Handler handler = this.d;
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            af.s((tg) it.next());
        }
        ArrayList arrayList = new ArrayList(collection.size());
        Iterator it2 = collection.iterator();
        while (it2.hasNext()) {
            arrayList.add(new sn((tg) it2.next()));
        }
        this.b.addAll(i, arrayList);
        if (handler == null || collection.isEmpty()) {
            return;
        }
        handler.obtainMessage(0, new so(i, arrayList, null, null, null, null)).sendToTarget();
    }

    private final void Z(ws wsVar) {
        if (this.i) {
            return;
        }
        P().obtainMessage(4).sendToTarget();
        this.i = true;
    }

    public static /* bridge */ /* synthetic */ ai k() {
        return a;
    }

    public final void C() {
        super.C();
        this.h.clear();
    }

    public final void E() {
    }

    public final boolean L() {
        return false;
    }

    public final synchronized void O(int i) {
        l(i);
        int i2 = i + 1;
        af.u(true);
        Handler handler = this.d;
        cq.T(this.b, i, i2);
        if (handler != null) {
            handler.obtainMessage(1, new so(i, Integer.valueOf(i2), null, null, null, null)).sendToTarget();
        }
    }

    public final ai a() {
        return a;
    }

    public final /* bridge */ /* synthetic */ int b(Object obj, int i) {
        return i + ((sn) obj).e;
    }

    public final /* bridge */ /* synthetic */ te d(Object obj, te teVar) {
        int i = 0;
        while (true) {
            sn snVar = (sn) obj;
            if (i >= snVar.c.size()) {
                return null;
            }
            if (((te) snVar.c.get(i)).d == teVar.d) {
                return teVar.c(Pair.create(snVar.b, teVar.a));
            }
            i++;
        }
    }

    public final synchronized tg l(int i) {
        return ((sn) this.b.get(i)).a;
    }

    public final synchronized void m(tg tgVar) {
        r(this.b.size(), tgVar);
    }

    public final synchronized void n(dw dwVar) {
        super.n(dwVar);
        this.d = new Handler(new sk(this, 0));
        if (this.b.isEmpty()) {
            X();
            return;
        }
        this.k = this.k.g(0, this.b.size());
        Q(0, this.b);
        V();
    }

    public final void o(td tdVar) {
        sn snVar = (sn) this.f.remove(tdVar);
        af.s(snVar);
        snVar.a.o(tdVar);
        snVar.c.remove(((sx) tdVar).a);
        if (!this.f.isEmpty()) {
            S();
        }
        U(snVar);
    }

    public final synchronized void p() {
        try {
            super.p();
            this.e.clear();
            this.h.clear();
            this.g.clear();
            this.k = this.k.f();
            Handler handler = this.d;
            if (handler != null) {
                handler.removeCallbacksAndMessages((Object) null);
                this.d = null;
            }
            this.i = false;
            this.j.clear();
            T(this.c);
        } catch (Throwable th) {
            throw th;
        }
    }

    public final td q(te teVar, wr wrVar, long j) {
        Object y = eg.y(teVar.a);
        te c = teVar.c(eg.x(teVar.a));
        sn snVar = (sn) this.g.get(y);
        if (snVar == null) {
            snVar = new sn(new sm(null));
            snVar.f = true;
            g(snVar, snVar.a);
        }
        this.h.add(snVar);
        f(snVar);
        snVar.c.add(c);
        sx s = snVar.a.s(c, wrVar, j);
        this.f.put(s, snVar);
        S();
        return s;
    }

    public final synchronized void r(int i, tg tgVar) {
        Y(i, Collections.singletonList(tgVar));
    }

    public final synchronized void s(Collection collection) {
        Y(this.b.size(), collection);
    }

    public final synchronized be t() {
        try {
        } catch (Throwable th) {
            throw th;
        }
        return new sl(this.b, this.k.c() != this.b.size() ? this.k.f().g(0, this.b.size()) : this.k);
    }
}
