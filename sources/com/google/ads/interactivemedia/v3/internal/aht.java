package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Looper;
import android.view.View;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.TimeUnit;
import org.json.JSONObject;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aht implements ahf {
    private static final aht a = new aht();
    private static final Handler b = new Handler(Looper.getMainLooper());
    private static Handler c = null;
    private static final Runnable d = new ahq(1);
    private static final Runnable e = new ahq(0);
    private int g;
    private long k;
    private final List f = new ArrayList();
    private boolean h = false;
    private final List i = new ArrayList();
    private final aho j = new aho();
    private final bdy m = new bdy((byte[]) null);
    private final aly l = new aly(new ahw());

    public static /* bridge */ /* synthetic */ Handler b() {
        return c;
    }

    public static aht c() {
        return a;
    }

    public static /* bridge */ /* synthetic */ Runnable d() {
        return e;
    }

    public static /* bridge */ /* synthetic */ Runnable e() {
        return d;
    }

    public static /* bridge */ /* synthetic */ void f(aht ahtVar) {
        ahtVar.g = 0;
        ahtVar.i.clear();
        ahtVar.h = false;
        for (agt agtVar : agz.a().b()) {
        }
        ahtVar.k = System.nanoTime();
        ahtVar.j.h();
        long nanoTime = System.nanoTime();
        ahg g = ahtVar.m.g();
        if (ahtVar.j.d().size() > 0) {
            Iterator it = ahtVar.j.d().iterator();
            while (it.hasNext()) {
                String str = (String) it.next();
                JSONObject a2 = g.a(null);
                View a3 = ahtVar.j.a(str);
                ahg h = ahtVar.m.h();
                String b2 = ahtVar.j.b(str);
                if (b2 != null) {
                    JSONObject a4 = h.a(a3);
                    ahn.c(a4, str);
                    ahn.f(a4, b2);
                    ahn.d(a2, a4);
                }
                ahn.i(a2);
                HashSet hashSet = new HashSet();
                hashSet.add(str);
                ahtVar.l.e(a2, hashSet, nanoTime);
            }
        }
        if (ahtVar.j.e().size() > 0) {
            JSONObject a5 = g.a(null);
            ahtVar.k(null, g, a5, 1, false);
            ahn.i(a5);
            ahtVar.l.f(a5, ahtVar.j.e(), nanoTime);
        } else {
            ahtVar.l.d();
        }
        ahtVar.j.f();
        long nanoTime2 = System.nanoTime() - ahtVar.k;
        if (ahtVar.f.size() > 0) {
            for (ahs ahsVar : ahtVar.f) {
                TimeUnit.NANOSECONDS.toMillis(nanoTime2);
                ahsVar.b();
                if (ahsVar instanceof ahr) {
                    ((ahr) ahsVar).a();
                }
            }
        }
    }

    public static /* bridge */ /* synthetic */ aly j(aht ahtVar) {
        return ahtVar.l;
    }

    private final void k(View view, ahg ahgVar, JSONObject jSONObject, int i, boolean z) {
        ahgVar.b(view, jSONObject, this, i == 1, z);
    }

    private static final void l() {
        Handler handler = c;
        if (handler != null) {
            handler.removeCallbacks(e);
            c = null;
        }
    }

    public final void a(View view, ahg ahgVar, JSONObject jSONObject, boolean z) {
        int j;
        boolean z2;
        if (com.google.ads.interactivemedia.v3.impl.data.i.c(view) != null || (j = this.j.j(view)) == 3) {
            return;
        }
        JSONObject a2 = ahgVar.a(view);
        ahn.d(jSONObject, a2);
        String c2 = this.j.c(view);
        if (c2 != null) {
            ahn.c(a2, c2);
            ahn.e(a2, Boolean.valueOf(this.j.i(view)));
            this.j.g();
        } else {
            aeq k = this.j.k(view);
            if (k != null) {
                ahn.k(a2, k);
                z2 = true;
            } else {
                z2 = false;
            }
            k(view, ahgVar, a2, j, z || z2);
        }
        this.g++;
    }

    public final void g() {
        l();
    }

    public final void h() {
        if (c == null) {
            Handler handler = new Handler(Looper.getMainLooper());
            c = handler;
            handler.post(d);
            c.postDelayed(e, 200L);
        }
    }

    public final void i() {
        l();
        this.f.clear();
        b.post(new ahp(this));
    }
}
