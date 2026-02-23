package com.google.ads.interactivemedia.v3.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aty implements Iterator {
    Map.Entry a;
    final /* synthetic */ Iterator b;
    final /* synthetic */ atz c;

    public aty(atz atzVar, Iterator it) {
        this.c = atzVar;
        this.b = it;
    }

    public final boolean hasNext() {
        return this.b.hasNext();
    }

    public final Object next() {
        Map.Entry entry = (Map.Entry) this.b.next();
        this.a = entry;
        return entry.getKey();
    }

    public final void remove() {
        atp.i(this.a != null, "no calls to next() since the last call to remove()");
        Collection collection = (Collection) this.a.getValue();
        this.b.remove();
        auj.t(this.c.a, collection.size());
        collection.clear();
        this.a = null;
    }
}
