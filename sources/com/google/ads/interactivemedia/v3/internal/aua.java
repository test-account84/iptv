package com.google.ads.interactivemedia.v3.internal;

import java.util.Collection;
import java.util.Iterator;
import java.util.Map;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aua extends aud implements NavigableMap {
    final /* synthetic */ auj c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aua(auj aujVar, NavigableMap navigableMap) {
        super(aujVar, navigableMap);
        this.c = aujVar;
    }

    public final Map.Entry c(Iterator it) {
        if (!it.hasNext()) {
            return null;
        }
        Map.Entry entry = (Map.Entry) it.next();
        Collection a = this.c.a();
        a.addAll((Collection) entry.getValue());
        it.remove();
        return axo.r(entry.getKey(), this.c.b(a));
    }

    public final Map.Entry ceilingEntry(Object obj) {
        Map.Entry ceilingEntry = h().ceilingEntry(obj);
        if (ceilingEntry == null) {
            return null;
        }
        return a(ceilingEntry);
    }

    public final Object ceilingKey(Object obj) {
        return h().ceilingKey(obj);
    }

    /* renamed from: d, reason: merged with bridge method [inline-methods] */
    public final NavigableMap h() {
        return super.h();
    }

    public final NavigableSet descendingKeySet() {
        return ((aua) descendingMap()).keySet();
    }

    public final NavigableMap descendingMap() {
        return new aua(this.c, h().descendingMap());
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final NavigableSet i() {
        return new aub(this.c, h());
    }

    /* renamed from: f, reason: merged with bridge method [inline-methods] and merged with bridge method [inline-methods] */
    public final NavigableSet keySet() {
        return super.j();
    }

    public final Map.Entry firstEntry() {
        Map.Entry firstEntry = h().firstEntry();
        if (firstEntry == null) {
            return null;
        }
        return a(firstEntry);
    }

    public final Map.Entry floorEntry(Object obj) {
        Map.Entry floorEntry = h().floorEntry(obj);
        if (floorEntry == null) {
            return null;
        }
        return a(floorEntry);
    }

    public final Object floorKey(Object obj) {
        return h().floorKey(obj);
    }

    public final NavigableMap headMap(Object obj, boolean z) {
        return new aua(this.c, h().headMap(obj, z));
    }

    public final Map.Entry higherEntry(Object obj) {
        Map.Entry higherEntry = h().higherEntry(obj);
        if (higherEntry == null) {
            return null;
        }
        return a(higherEntry);
    }

    public final Object higherKey(Object obj) {
        return h().higherKey(obj);
    }

    public final Map.Entry lastEntry() {
        Map.Entry lastEntry = h().lastEntry();
        if (lastEntry == null) {
            return null;
        }
        return a(lastEntry);
    }

    public final Map.Entry lowerEntry(Object obj) {
        Map.Entry lowerEntry = h().lowerEntry(obj);
        if (lowerEntry == null) {
            return null;
        }
        return a(lowerEntry);
    }

    public final Object lowerKey(Object obj) {
        return h().lowerKey(obj);
    }

    public final NavigableSet navigableKeySet() {
        return keySet();
    }

    public final Map.Entry pollFirstEntry() {
        return c(entrySet().iterator());
    }

    public final Map.Entry pollLastEntry() {
        return c(descendingMap().entrySet().iterator());
    }

    public final NavigableMap subMap(Object obj, boolean z, Object obj2, boolean z2) {
        return new aua(this.c, h().subMap(obj, z, obj2, z2));
    }

    public final NavigableMap tailMap(Object obj, boolean z) {
        return new aua(this.c, h().tailMap(obj, z));
    }

    public final /* bridge */ /* synthetic */ SortedMap headMap(Object obj) {
        return headMap(obj, false);
    }

    public final /* bridge */ /* synthetic */ SortedMap subMap(Object obj, Object obj2) {
        return subMap(obj, true, obj2, false);
    }

    public final /* bridge */ /* synthetic */ SortedMap tailMap(Object obj) {
        return tailMap(obj, true);
    }
}
