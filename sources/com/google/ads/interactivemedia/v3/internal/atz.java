package com.google.ads.interactivemedia.v3.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class atz extends awn {
    final /* synthetic */ auj a;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public atz(auj aujVar, Map map) {
        super(map);
        this.a = aujVar;
    }

    public final void clear() {
        axo.x(iterator());
    }

    public final boolean containsAll(Collection collection) {
        return this.d.keySet().containsAll(collection);
    }

    public final boolean equals(Object obj) {
        return this == obj || this.d.keySet().equals(obj);
    }

    public final int hashCode() {
        return this.d.keySet().hashCode();
    }

    public final Iterator iterator() {
        return new aty(this, this.d.entrySet().iterator());
    }

    public final boolean remove(Object obj) {
        Collection collection = (Collection) this.d.remove(obj);
        if (collection == null) {
            return false;
        }
        int size = collection.size();
        collection.clear();
        auj.t(this.a, size);
        return size > 0;
    }
}
