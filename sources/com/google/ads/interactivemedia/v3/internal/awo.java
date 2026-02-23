package com.google.ads.interactivemedia.v3.internal;

import java.util.AbstractCollection;
import java.util.Collection;
import java.util.HashSet;
import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class awo extends AbstractCollection {
    final Map a;

    public awo(Map map) {
        this.a = map;
    }

    public final void clear() {
        this.a.clear();
    }

    public final boolean contains(Object obj) {
        return this.a.containsValue(obj);
    }

    public final boolean isEmpty() {
        return this.a.isEmpty();
    }

    public final Iterator iterator() {
        return axo.q(this.a.entrySet().iterator());
    }

    public final boolean remove(Object obj) {
        try {
            return super.remove(obj);
        } catch (UnsupportedOperationException unused) {
            for (Map.Entry entry : this.a.entrySet()) {
                if (com.google.ads.interactivemedia.v3.impl.data.k.c(obj, entry.getValue())) {
                    this.a.remove(entry.getKey());
                    return true;
                }
            }
            return false;
        }
    }

    public final boolean removeAll(Collection collection) {
        try {
            atp.k(collection);
            return super.removeAll(collection);
        } catch (UnsupportedOperationException unused) {
            HashSet c = axo.c();
            for (Map.Entry entry : this.a.entrySet()) {
                if (collection.contains(entry.getValue())) {
                    c.add(entry.getKey());
                }
            }
            return this.a.keySet().removeAll(c);
        }
    }

    public final boolean retainAll(Collection collection) {
        try {
            atp.k(collection);
            return super.retainAll(collection);
        } catch (UnsupportedOperationException unused) {
            HashSet c = axo.c();
            for (Map.Entry entry : this.a.entrySet()) {
                if (collection.contains(entry.getValue())) {
                    c.add(entry.getKey());
                }
            }
            return this.a.keySet().retainAll(c);
        }
    }

    public final int size() {
        return this.a.size();
    }
}
