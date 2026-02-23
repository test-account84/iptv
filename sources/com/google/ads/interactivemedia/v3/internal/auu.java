package com.google.ads.interactivemedia.v3.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class auu extends auv implements Map {
    public /* bridge */ /* synthetic */ Object a() {
        throw null;
    }

    public abstract Map b();

    public final int c() {
        return axo.b(entrySet());
    }

    public final void clear() {
        b().clear();
    }

    public boolean containsKey(Object obj) {
        return b().containsKey(obj);
    }

    public boolean containsValue(Object obj) {
        return b().containsValue(obj);
    }

    public final boolean d(Object obj) {
        Iterator q = axo.q(entrySet().iterator());
        if (obj == null) {
            while (q.hasNext()) {
                if (q.next() == null) {
                }
            }
            return false;
        }
        while (q.hasNext()) {
            if (obj.equals(q.next())) {
            }
        }
        return false;
        return true;
    }

    public final boolean e(Object obj) {
        return axo.s(this, obj);
    }

    public Set entrySet() {
        return b().entrySet();
    }

    public boolean equals(Object obj) {
        return obj == this || b().equals(obj);
    }

    public Object get(Object obj) {
        return b().get(obj);
    }

    public int hashCode() {
        return b().hashCode();
    }

    public boolean isEmpty() {
        return b().isEmpty();
    }

    public Set keySet() {
        return b().keySet();
    }

    public final Object put(Object obj, Object obj2) {
        return b().put(obj, obj2);
    }

    public final void putAll(Map map) {
        b().putAll(map);
    }

    public final Object remove(Object obj) {
        return b().remove(obj);
    }

    public int size() {
        return b().size();
    }

    public final Collection values() {
        return b().values();
    }
}
