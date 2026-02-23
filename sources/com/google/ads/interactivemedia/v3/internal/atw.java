package com.google.ads.interactivemedia.v3.internal;

import java.util.Collection;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class atw extends awp {
    final transient Map a;
    final /* synthetic */ auj b;

    public atw(auj aujVar, Map map) {
        this.b = aujVar;
        this.a = map;
    }

    public final Map.Entry a(Map.Entry entry) {
        Object key = entry.getKey();
        return axo.r(key, this.b.c(key, (Collection) entry.getValue()));
    }

    public final Set b() {
        return new atu(this);
    }

    public final void clear() {
        Map map = this.a;
        auj aujVar = this.b;
        if (map == auj.h(aujVar)) {
            aujVar.o();
        } else {
            axo.x(new atv(this));
        }
    }

    public final boolean containsKey(Object obj) {
        Map map = this.a;
        atp.k(map);
        try {
            return map.containsKey(obj);
        } catch (ClassCastException | NullPointerException unused) {
            return false;
        }
    }

    public final boolean equals(Object obj) {
        return this == obj || this.a.equals(obj);
    }

    public final /* bridge */ /* synthetic */ Object get(Object obj) {
        Collection collection = (Collection) axo.o(this.a, obj);
        if (collection == null) {
            return null;
        }
        return this.b.c(obj, collection);
    }

    public final int hashCode() {
        return this.a.hashCode();
    }

    public Set keySet() {
        return this.b.x();
    }

    public final /* bridge */ /* synthetic */ Object remove(Object obj) {
        Collection collection = (Collection) this.a.remove(obj);
        if (collection == null) {
            return null;
        }
        Collection a = this.b.a();
        a.addAll(collection);
        auj.t(this.b, collection.size());
        collection.clear();
        return a;
    }

    public final int size() {
        return this.a.size();
    }

    public final String toString() {
        return this.a.toString();
    }
}
