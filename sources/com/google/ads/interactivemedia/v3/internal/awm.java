package com.google.ads.interactivemedia.v3.internal;

import java.util.Collection;
import java.util.HashSet;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class awm extends axl {
    public abstract Map a();

    public final void clear() {
        a().clear();
    }

    public boolean contains(Object obj) {
        if (!(obj instanceof Map.Entry)) {
            return false;
        }
        Map.Entry entry = (Map.Entry) obj;
        Object key = entry.getKey();
        Object o = axo.o(a(), key);
        if (com.google.ads.interactivemedia.v3.impl.data.k.c(o, entry.getValue())) {
            return o != null || a().containsKey(key);
        }
        return false;
    }

    public final boolean isEmpty() {
        return a().isEmpty();
    }

    public boolean remove(Object obj) {
        if (contains(obj) && (obj instanceof Map.Entry)) {
            return a().keySet().remove(((Map.Entry) obj).getKey());
        }
        return false;
    }

    public final boolean removeAll(Collection collection) {
        try {
            atp.k(collection);
            return axo.h(this, collection);
        } catch (UnsupportedOperationException unused) {
            return axo.i(this, collection.iterator());
        }
    }

    public final boolean retainAll(Collection collection) {
        try {
            atp.k(collection);
            return super.retainAll(collection);
        } catch (UnsupportedOperationException unused) {
            HashSet d = axo.d(collection.size());
            for (Object obj : collection) {
                if (contains(obj) && (obj instanceof Map.Entry)) {
                    d.add(((Map.Entry) obj).getKey());
                }
            }
            return a().keySet().retainAll(d);
        }
    }

    public final int size() {
        return a().size();
    }
}
