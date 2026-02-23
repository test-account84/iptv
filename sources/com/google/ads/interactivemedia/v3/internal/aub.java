package com.google.ads.interactivemedia.v3.internal;

import java.util.Iterator;
import java.util.NavigableMap;
import java.util.NavigableSet;
import java.util.SortedSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class aub extends aue implements NavigableSet {
    final /* synthetic */ auj b;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aub(auj aujVar, NavigableMap navigableMap) {
        super(aujVar, navigableMap);
        this.b = aujVar;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final NavigableMap b() {
        return super.b();
    }

    public final Object ceiling(Object obj) {
        return b().ceilingKey(obj);
    }

    public final Iterator descendingIterator() {
        return descendingSet().iterator();
    }

    public final NavigableSet descendingSet() {
        return new aub(this.b, b().descendingMap());
    }

    public final Object floor(Object obj) {
        return b().floorKey(obj);
    }

    public final NavigableSet headSet(Object obj, boolean z) {
        return new aub(this.b, b().headMap(obj, z));
    }

    public final Object higher(Object obj) {
        return b().higherKey(obj);
    }

    public final Object lower(Object obj) {
        return b().lowerKey(obj);
    }

    public final Object pollFirst() {
        return axo.w(iterator());
    }

    public final Object pollLast() {
        return axo.w(descendingIterator());
    }

    public final NavigableSet subSet(Object obj, boolean z, Object obj2, boolean z2) {
        return new aub(this.b, b().subMap(obj, z, obj2, z2));
    }

    public final NavigableSet tailSet(Object obj, boolean z) {
        return new aub(this.b, b().tailMap(obj, z));
    }

    public final /* bridge */ /* synthetic */ SortedSet headSet(Object obj) {
        return headSet(obj, false);
    }

    public final /* bridge */ /* synthetic */ SortedSet subSet(Object obj, Object obj2) {
        return subSet(obj, true, obj2, false);
    }

    public final /* bridge */ /* synthetic */ SortedSet tailSet(Object obj) {
        return tailSet(obj, true);
    }
}
