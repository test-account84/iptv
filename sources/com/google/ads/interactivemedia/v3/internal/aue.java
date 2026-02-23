package com.google.ads.interactivemedia.v3.internal;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class aue extends atz implements SortedSet {
    final /* synthetic */ auj c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aue(auj aujVar, SortedMap sortedMap) {
        super(aujVar, sortedMap);
        this.c = aujVar;
    }

    public SortedMap b() {
        return this.d;
    }

    public final Comparator comparator() {
        return b().comparator();
    }

    public final Object first() {
        return b().firstKey();
    }

    public SortedSet headSet(Object obj) {
        return new aue(this.c, b().headMap(obj));
    }

    public final Object last() {
        return b().lastKey();
    }

    public SortedSet subSet(Object obj, Object obj2) {
        return new aue(this.c, b().subMap(obj, obj2));
    }

    public SortedSet tailSet(Object obj) {
        return new aue(this.c, b().tailMap(obj));
    }
}
