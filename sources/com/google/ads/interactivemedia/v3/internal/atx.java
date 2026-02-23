package com.google.ads.interactivemedia.v3.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class atx implements Iterator {
    final Iterator a;
    Collection b;
    Iterator c;
    final /* synthetic */ auj d;

    public atx(auj aujVar) {
        this.d = aujVar;
        this.a = auj.h(aujVar).entrySet().iterator();
        this.b = null;
        this.c = awi.a;
    }

    public final boolean hasNext() {
        return this.a.hasNext() || this.c.hasNext();
    }

    public final Object next() {
        if (!this.c.hasNext()) {
            Map.Entry entry = (Map.Entry) this.a.next();
            entry.getKey();
            Collection collection = (Collection) entry.getValue();
            this.b = collection;
            this.c = collection.iterator();
        }
        return this.c.next();
    }

    public final void remove() {
        this.c.remove();
        Collection collection = this.b;
        collection.getClass();
        if (collection.isEmpty()) {
            this.a.remove();
        }
        auj.r(this.d);
    }

    public atx(auj aujVar, byte[] bArr) {
        this(aujVar);
    }
}
