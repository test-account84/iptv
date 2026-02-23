package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import android.os.Looper;
import java.util.ArrayList;
import java.util.HashSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class sa implements tg {
    private final ArrayList a = new ArrayList(1);
    private final HashSet b = new HashSet(1);
    private final tj c = new tj();
    private final nn d = new nn();
    private Looper e;
    private be f;
    private iw g;

    public final void A(Handler handler, tk tkVar) {
        af.s(handler);
        af.s(tkVar);
        this.c.b(handler, tkVar);
    }

    public final void B(tf tfVar) {
        boolean isEmpty = this.b.isEmpty();
        this.b.remove(tfVar);
        if ((!isEmpty) && this.b.isEmpty()) {
            C();
        }
    }

    public void C() {
    }

    public final void D(tf tfVar) {
        af.s(this.e);
        boolean isEmpty = this.b.isEmpty();
        this.b.add(tfVar);
        if (isEmpty) {
            E();
        }
    }

    public void E() {
    }

    public final void F(tf tfVar, dw dwVar, iw iwVar) {
        Looper myLooper = Looper.myLooper();
        Looper looper = this.e;
        boolean z = true;
        if (looper != null && looper != myLooper) {
            z = false;
        }
        af.u(z);
        this.g = iwVar;
        be beVar = this.f;
        this.a.add(tfVar);
        if (this.e == null) {
            this.e = myLooper;
            this.b.add(tfVar);
            n(dwVar);
        } else if (beVar != null) {
            D(tfVar);
            tfVar.a(this, beVar);
        }
    }

    public final void G(be beVar) {
        this.f = beVar;
        ArrayList arrayList = this.a;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((tf) arrayList.get(i)).a(this, beVar);
        }
    }

    public final void H(tf tfVar) {
        this.a.remove(tfVar);
        if (!this.a.isEmpty()) {
            B(tfVar);
            return;
        }
        this.e = null;
        this.f = null;
        this.g = null;
        this.b.clear();
        p();
    }

    public final void I(no noVar) {
        this.d.h(noVar);
    }

    public final void J(tk tkVar) {
        this.c.l(tkVar);
    }

    public final boolean K() {
        return !this.b.isEmpty();
    }

    public /* synthetic */ boolean L() {
        return true;
    }

    public final tj M(int i, te teVar) {
        return this.c.a(i, teVar, 0L);
    }

    public abstract void n(dw dwVar);

    public abstract void p();

    public /* synthetic */ be t() {
        return null;
    }

    public final iw u() {
        iw iwVar = this.g;
        af.t(iwVar);
        return iwVar;
    }

    public final nn v(te teVar) {
        return this.d.a(0, teVar);
    }

    public final nn w(int i, te teVar) {
        return this.d.a(i, teVar);
    }

    public final tj x(te teVar) {
        return this.c.a(0, teVar, 0L);
    }

    public final tj y(te teVar, long j) {
        return this.c.a(0, teVar, j);
    }

    public final void z(Handler handler, no noVar) {
        af.s(handler);
        af.s(noVar);
        this.d.b(handler, noVar);
    }
}
