package com.google.ads.interactivemedia.v3.internal;

import android.os.Handler;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class nn {
    public final int a;
    public final te b;
    private final CopyOnWriteArrayList c;

    public nn() {
        this(new CopyOnWriteArrayList(), 0, null);
    }

    public final nn a(int i, te teVar) {
        return new nn(this.c, i, teVar);
    }

    public final void b(Handler handler, no noVar) {
        af.s(handler);
        af.s(noVar);
        this.c.add(new aeq(handler, noVar));
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.ads.interactivemedia.v3.internal.no, java.lang.Object] */
    public final void c() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            aeq aeqVar = (aeq) it.next();
            ?? r2 = aeqVar.a;
            cq.at((Handler) aeqVar.b, new jc(this, (no) r2, 9));
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.ads.interactivemedia.v3.internal.no, java.lang.Object] */
    public final void d() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            aeq aeqVar = (aeq) it.next();
            ?? r2 = aeqVar.a;
            cq.at((Handler) aeqVar.b, new jc(this, (no) r2, 7));
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.ads.interactivemedia.v3.internal.no, java.lang.Object] */
    public final void e(int i) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            aeq aeqVar = (aeq) it.next();
            ?? r2 = aeqVar.a;
            cq.at((Handler) aeqVar.b, new bw(this, (no) r2, i, 1));
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.ads.interactivemedia.v3.internal.no, java.lang.Object] */
    public final void f(Exception exc) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            aeq aeqVar = (aeq) it.next();
            ?? r2 = aeqVar.a;
            cq.at((Handler) aeqVar.b, new jg(this, (no) r2, exc, 1));
        }
    }

    /* JADX WARN: Type inference failed for: r2v0, types: [com.google.ads.interactivemedia.v3.internal.no, java.lang.Object] */
    public final void g() {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            aeq aeqVar = (aeq) it.next();
            ?? r2 = aeqVar.a;
            cq.at((Handler) aeqVar.b, new jc(this, (no) r2, 8));
        }
    }

    public final void h(no noVar) {
        Iterator it = this.c.iterator();
        while (it.hasNext()) {
            aeq aeqVar = (aeq) it.next();
            if (aeqVar.a == noVar) {
                this.c.remove(aeqVar);
            }
        }
    }

    private nn(CopyOnWriteArrayList copyOnWriteArrayList, int i, te teVar) {
        this.c = copyOnWriteArrayList;
        this.a = i;
        this.b = teVar;
    }
}
