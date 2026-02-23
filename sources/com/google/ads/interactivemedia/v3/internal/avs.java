package com.google.ads.interactivemedia.v3.internal;

import j$.util.Map;
import java.io.InvalidObjectException;
import java.io.ObjectInputStream;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.SortedMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class avs implements Map, Serializable, j$.util.Map {
    private transient avx a;
    private transient avx b;
    private transient avi c;

    public static avs c(Map map) {
        if ((map instanceof avs) && !(map instanceof SortedMap)) {
            avs avsVar = (avs) map;
            if (!avsVar.i()) {
                return avsVar;
            }
        }
        Iterable entrySet = map.entrySet();
        avq avqVar = new avq(entrySet instanceof Collection ? entrySet.size() : 4);
        avqVar.d(entrySet);
        return avqVar.b();
    }

    public static avs d() {
        return axe.a;
    }

    public static avs j(Object obj) {
        axo.I("adBreakTime", obj);
        return axe.k(1, new Object[]{"adBreakTime", obj}, null);
    }

    private void readObject(ObjectInputStream objectInputStream) throws InvalidObjectException {
        throw new InvalidObjectException("Use SerializedForm");
    }

    public abstract avi a();

    /* renamed from: b, reason: merged with bridge method [inline-methods] */
    public avi values() {
        avi aviVar = this.c;
        if (aviVar != null) {
            return aviVar;
        }
        avi a = a();
        this.c = a;
        return a;
    }

    @Deprecated
    public final void clear() {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ Object compute(Object obj, BiFunction biFunction) {
        return Map.-CC.$default$compute(this, obj, biFunction);
    }

    public /* synthetic */ Object computeIfAbsent(Object obj, Function function) {
        return Map.-CC.$default$computeIfAbsent(this, obj, function);
    }

    public /* synthetic */ Object computeIfPresent(Object obj, BiFunction biFunction) {
        return Map.-CC.$default$computeIfPresent(this, obj, biFunction);
    }

    public final boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public final boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public abstract avx e();

    public final boolean equals(Object obj) {
        return axo.s(this, obj);
    }

    public abstract avx f();

    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.-CC.$default$forEach(this, biConsumer);
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public final avx entrySet() {
        avx avxVar = this.a;
        if (avxVar != null) {
            return avxVar;
        }
        avx e = e();
        this.a = e;
        return e;
    }

    public abstract Object get(Object obj);

    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public avx keySet() {
        avx avxVar = this.b;
        if (avxVar != null) {
            return avxVar;
        }
        avx f = f();
        this.b = f;
        return f;
    }

    public final int hashCode() {
        return axo.b(entrySet());
    }

    public abstract boolean i();

    public final boolean isEmpty() {
        return size() == 0;
    }

    public /* synthetic */ Object merge(Object obj, Object obj2, BiFunction biFunction) {
        return Map.-CC.$default$merge(this, obj, obj2, biFunction);
    }

    @Deprecated
    public final Object put(Object obj, Object obj2) {
        throw new UnsupportedOperationException();
    }

    @Deprecated
    public final void putAll(java.util.Map map) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ Object putIfAbsent(Object obj, Object obj2) {
        return Map.-CC.$default$putIfAbsent(this, obj, obj2);
    }

    @Deprecated
    public final Object remove(Object obj) {
        throw new UnsupportedOperationException();
    }

    public /* synthetic */ Object replace(Object obj, Object obj2) {
        return Map.-CC.$default$replace(this, obj, obj2);
    }

    public /* synthetic */ void replaceAll(BiFunction biFunction) {
        Map.-CC.$default$replaceAll(this, biFunction);
    }

    public final String toString() {
        int size = size();
        axo.K(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(size * 8, 1073741824L));
        sb.append('{');
        boolean z = true;
        for (Map.Entry entry : entrySet()) {
            if (!z) {
                sb.append(", ");
            }
            sb.append(entry.getKey());
            sb.append('=');
            sb.append(entry.getValue());
            z = false;
        }
        sb.append('}');
        return sb.toString();
    }

    public Object writeReplace() {
        return new avr(this);
    }

    public /* synthetic */ boolean remove(Object obj, Object obj2) {
        return Map.-CC.$default$remove(this, obj, obj2);
    }

    public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return Map.-CC.$default$replace(this, obj, obj2, obj3);
    }
}
