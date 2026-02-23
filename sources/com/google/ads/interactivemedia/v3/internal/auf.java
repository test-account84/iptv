package com.google.ads.interactivemedia.v3.internal;

import java.util.Collection;
import java.util.ConcurrentModificationException;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class auf implements Iterator {
    final Iterator a;
    final Collection b;
    final /* synthetic */ aug c;

    public auf(aug augVar) {
        this.c = augVar;
        List list = augVar.b;
        this.b = list;
        this.a = list instanceof List ? list.listIterator() : list.iterator();
    }

    public final void a() {
        this.c.b();
        if (this.c.b != this.b) {
            throw new ConcurrentModificationException();
        }
    }

    public final boolean hasNext() {
        a();
        return this.a.hasNext();
    }

    public final Object next() {
        a();
        return this.a.next();
    }

    public final void remove() {
        this.a.remove();
        auj.r(this.c.e);
        this.c.c();
    }

    public auf(aug augVar, Iterator it) {
        this.c = augVar;
        this.b = augVar.b;
        this.a = it;
    }
}
