package com.google.ads.interactivemedia.v3.internal;

import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bsq implements Iterator {
    final /* synthetic */ bst a;
    private int b = -1;
    private boolean c;
    private Iterator d;

    public /* synthetic */ bsq(bst bstVar) {
        this.a = bstVar;
    }

    private final Iterator a() {
        if (this.d == null) {
            this.d = bst.h(this.a).entrySet().iterator();
        }
        return this.d;
    }

    public final boolean hasNext() {
        if (this.b + 1 >= bst.f(this.a).size()) {
            return !bst.h(this.a).isEmpty() && a().hasNext();
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.c = true;
        int i = this.b + 1;
        this.b = i;
        return (Map.Entry) (i < bst.f(this.a).size() ? bst.f(this.a).get(this.b) : a().next());
    }

    public final void remove() {
        if (!this.c) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.c = false;
        bst.i(this.a);
        if (this.b >= bst.f(this.a).size()) {
            a().remove();
            return;
        }
        bst bstVar = this.a;
        int i = this.b;
        this.b = i - 1;
        bst.k(bstVar, i);
    }
}
