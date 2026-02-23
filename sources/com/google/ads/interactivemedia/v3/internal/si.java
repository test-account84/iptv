package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import java.io.IOException;
import java.util.HashMap;
import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class si extends sa {
    private final HashMap a = new HashMap();
    private Handler b;
    private dw c;

    public void C() {
        for (sh shVar : this.a.values()) {
            shVar.a.B(shVar.b);
        }
    }

    public void E() {
        for (sh shVar : this.a.values()) {
            shVar.a.D(shVar.b);
        }
    }

    public int b(Object obj, int i) {
        throw null;
    }

    public long c(Object obj, long j) {
        return j;
    }

    public te d(Object obj, te teVar) {
        throw null;
    }

    public final void e(Object obj) {
        sh shVar = (sh) this.a.get(obj);
        af.s(shVar);
        shVar.a.B(shVar.b);
    }

    public final void f(Object obj) {
        sh shVar = (sh) this.a.get(obj);
        af.s(shVar);
        shVar.a.D(shVar.b);
    }

    public final void g(Object obj, tg tgVar) {
        af.u(!this.a.containsKey(obj));
        tf sfVar = new sf(this, obj);
        sg sgVar = new sg(this, obj);
        this.a.put(obj, new sh(tgVar, sfVar, sgVar));
        Handler handler = this.b;
        af.s(handler);
        tgVar.A(handler, sgVar);
        Handler handler2 = this.b;
        af.s(handler2);
        tgVar.z(handler2, sgVar);
        tgVar.F(sfVar, this.c, u());
        if (K()) {
            return;
        }
        tgVar.B(sfVar);
    }

    public void h() throws IOException {
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            ((sh) it.next()).a.h();
        }
    }

    public final void i(Object obj) {
        sh shVar = (sh) this.a.remove(obj);
        af.s(shVar);
        shVar.a.H(shVar.b);
        shVar.a.J(shVar.c);
        shVar.a.I(shVar.c);
    }

    public abstract void j(Object obj, be beVar);

    public void n(dw dwVar) {
        this.c = dwVar;
        this.b = cq.A();
    }

    public void p() {
        for (sh shVar : this.a.values()) {
            shVar.a.H(shVar.b);
            shVar.a.J(shVar.c);
            shVar.a.I(shVar.c);
        }
        this.a.clear();
    }
}
