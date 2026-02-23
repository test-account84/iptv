package com.google.ads.interactivemedia.v3.internal;

import java.util.Comparator;
import java.util.SortedMap;
import java.util.SortedSet;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
class aud extends atw implements SortedMap {
    SortedSet d;
    final /* synthetic */ auj e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public aud(auj aujVar, SortedMap sortedMap) {
        super(aujVar, sortedMap);
        this.e = aujVar;
    }

    public final Comparator comparator() {
        return h().comparator();
    }

    public final Object firstKey() {
        return h().firstKey();
    }

    public SortedMap h() {
        return ((atw) this).a;
    }

    public SortedMap headMap(Object obj) {
        return new aud(this.e, h().headMap(obj));
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public SortedSet g() {
        return new aue(this.e, h());
    }

    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public SortedSet keySet() {
        SortedSet sortedSet = this.d;
        if (sortedSet != null) {
            return sortedSet;
        }
        SortedSet g = g();
        this.d = g;
        return g;
    }

    public final Object lastKey() {
        return h().lastKey();
    }

    public SortedMap subMap(Object obj, Object obj2) {
        return new aud(this.e, h().subMap(obj, obj2));
    }

    public SortedMap tailMap(Object obj) {
        return new aud(this.e, h().tailMap(obj));
    }
}
