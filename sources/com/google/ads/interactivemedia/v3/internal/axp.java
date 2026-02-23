package com.google.ads.interactivemedia.v3.internal;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class axp implements Iterator {
    final Iterator a;

    public axp(Iterator it) {
        atp.k(it);
        this.a = it;
    }

    public abstract Object a(Object obj);

    public final boolean hasNext() {
        return this.a.hasNext();
    }

    public final Object next() {
        return a(this.a.next());
    }

    public final void remove() {
        this.a.remove();
    }
}
