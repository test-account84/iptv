package com.google.ads.interactivemedia.v3.internal;

import java.io.Serializable;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.NavigableMap;
import java.util.RandomAccess;
import java.util.Set;
import java.util.SortedMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class auj extends aum implements Serializable {
    private static final long serialVersionUID = 2447537837011683357L;
    private transient Map a;
    private transient int b;

    public auj(Map map) {
        atp.e(map.isEmpty());
        this.a = map;
    }

    public static /* synthetic */ Map h(auj aujVar) {
        return aujVar.a;
    }

    public static /* synthetic */ void n(auj aujVar, Object obj) {
        Object obj2;
        Map map = aujVar.a;
        atp.k(map);
        try {
            obj2 = map.remove(obj);
        } catch (ClassCastException | NullPointerException unused) {
            obj2 = null;
        }
        Collection collection = (Collection) obj2;
        if (collection != null) {
            int size = collection.size();
            collection.clear();
            aujVar.b -= size;
        }
    }

    public static /* synthetic */ void q(auj aujVar) {
        aujVar.b++;
    }

    public static /* synthetic */ void r(auj aujVar) {
        aujVar.b--;
    }

    public static /* synthetic */ void s(auj aujVar, int i) {
        aujVar.b += i;
    }

    public static /* synthetic */ void t(auj aujVar, int i) {
        aujVar.b -= i;
    }

    public abstract Collection a();

    public Collection b(Collection collection) {
        throw null;
    }

    public Collection c(Object obj, Collection collection) {
        throw null;
    }

    public final int d() {
        return this.b;
    }

    public final Collection e() {
        return new aul(this);
    }

    public final Iterator f() {
        return new atx(this, null);
    }

    public final List g(Object obj, List list, aug augVar) {
        return list instanceof RandomAccess ? new auc(this, obj, list, augVar) : new aui(this, obj, list, augVar);
    }

    public final Map i() {
        return this.a;
    }

    public Map j() {
        throw null;
    }

    public final Map k() {
        NavigableMap navigableMap = this.a;
        return navigableMap instanceof NavigableMap ? new aua(this, navigableMap) : navigableMap instanceof SortedMap ? new aud(this, (SortedMap) navigableMap) : new atw(this, navigableMap);
    }

    public Set l() {
        throw null;
    }

    public final Set m() {
        NavigableMap navigableMap = this.a;
        return navigableMap instanceof NavigableMap ? new aub(this, navigableMap) : navigableMap instanceof SortedMap ? new aue(this, (SortedMap) navigableMap) : new atz(this, navigableMap);
    }

    public final void o() {
        Iterator it = this.a.values().iterator();
        while (it.hasNext()) {
            ((Collection) it.next()).clear();
        }
        this.a.clear();
        this.b = 0;
    }

    public final void p(Map map) {
        this.a = map;
        this.b = 0;
        for (Collection collection : map.values()) {
            atp.e(!collection.isEmpty());
            this.b += collection.size();
        }
    }

    public final void u(Object obj, Object obj2) {
        Collection collection = (Collection) this.a.get(obj);
        if (collection != null) {
            if (collection.add(obj2)) {
                this.b++;
            }
        } else {
            Collection a = a();
            if (!a.add(obj2)) {
                throw new AssertionError("New Collection violated the Collection spec");
            }
            this.b++;
            this.a.put(obj, a);
        }
    }
}
