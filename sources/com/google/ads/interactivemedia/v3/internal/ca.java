package com.google.ads.interactivemedia.v3.internal;

import android.os.Looper;
import java.util.ArrayDeque;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArraySet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class ca {
    private final bn a;
    private final bv b;
    private final by c;
    private final CopyOnWriteArraySet d;
    private final ArrayDeque e;
    private final ArrayDeque f;
    private boolean g;

    public ca(Looper looper, bn bnVar, by byVar) {
        this(new CopyOnWriteArraySet(), looper, bnVar, byVar);
    }

    public static /* synthetic */ void h(ca caVar) {
        Iterator it = caVar.d.iterator();
        while (it.hasNext()) {
            ((bz) it.next()).b(caVar.c);
            if (caVar.b.c()) {
                return;
            }
        }
    }

    public final ca a(Looper looper, by byVar) {
        return new ca(this.d, looper, this.a, byVar);
    }

    public final void b(Object obj) {
        if (this.g) {
            return;
        }
        af.s(obj);
        this.d.add(new bz(obj));
    }

    public final void c() {
        if (this.f.isEmpty()) {
            return;
        }
        if (!this.b.c()) {
            bv bvVar = this.b;
            bvVar.j(bvVar.a(0));
        }
        boolean isEmpty = this.e.isEmpty();
        this.e.addAll(this.f);
        this.f.clear();
        if (!isEmpty) {
            return;
        }
        while (!this.e.isEmpty()) {
            ((Runnable) this.e.peekFirst()).run();
            this.e.removeFirst();
        }
    }

    public final void d(int i, bx bxVar) {
        this.f.add(new bw(new CopyOnWriteArraySet(this.d), i, bxVar, 0));
    }

    public final void e() {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            ((bz) it.next()).c(this.c);
        }
        this.d.clear();
        this.g = true;
    }

    public final void f(Object obj) {
        Iterator it = this.d.iterator();
        while (it.hasNext()) {
            bz bzVar = (bz) it.next();
            if (bzVar.a.equals(obj)) {
                bzVar.c(this.c);
                this.d.remove(bzVar);
            }
        }
    }

    public final void g(int i, bx bxVar) {
        d(i, bxVar);
        c();
    }

    private ca(CopyOnWriteArraySet copyOnWriteArraySet, Looper looper, bn bnVar, by byVar) {
        this.a = bnVar;
        this.d = copyOnWriteArraySet;
        this.c = byVar;
        this.e = new ArrayDeque();
        this.f = new ArrayDeque();
        this.b = bnVar.b(looper, new sk(this, 1));
    }
}
