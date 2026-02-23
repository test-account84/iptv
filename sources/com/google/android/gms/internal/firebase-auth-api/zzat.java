package com.google.android.gms.internal.firebase-auth-api;

import j$.util.Map;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.SortedMap;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzat implements Serializable, Map, j$.util.Map {
    private static final Map.Entry[] zza = new Map.Entry[0];
    private transient zzau zzb;
    private transient zzau zzc;
    private transient zzak zzd;

    public static zzat zza(Map map) {
        if ((map instanceof zzat) && !(map instanceof SortedMap)) {
            zzat zzatVar = (zzat) map;
            zzatVar.zzd();
            return zzatVar;
        }
        Collection entrySet = map.entrySet();
        zzas zzasVar = new zzas(entrySet instanceof Collection ? entrySet.size() : 4);
        zzasVar.zza((Iterable) entrySet);
        return zzasVar.zza();
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

    public boolean containsKey(Object obj) {
        return get(obj) != null;
    }

    public boolean containsValue(Object obj) {
        return values().contains(obj);
    }

    public /* synthetic */ Set entrySet() {
        zzau zzauVar = this.zzb;
        if (zzauVar != null) {
            return zzauVar;
        }
        zzau zzb = zzb();
        this.zzb = zzb;
        return zzb;
    }

    public boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj instanceof java.util.Map) {
            return entrySet().equals(((java.util.Map) obj).entrySet());
        }
        return false;
    }

    public /* synthetic */ void forEach(BiConsumer biConsumer) {
        Map.-CC.$default$forEach(this, biConsumer);
    }

    public abstract Object get(Object obj);

    public final Object getOrDefault(Object obj, Object obj2) {
        Object obj3 = get(obj);
        return obj3 != null ? obj3 : obj2;
    }

    public int hashCode() {
        return zzbd.zza((zzau) entrySet());
    }

    public boolean isEmpty() {
        return size() == 0;
    }

    public /* synthetic */ Set keySet() {
        zzau zzauVar = this.zzc;
        if (zzauVar != null) {
            return zzauVar;
        }
        zzau zzc = zzc();
        this.zzc = zzc;
        return zzc;
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

    public String toString() {
        int size = size();
        zzai.zza(size, "size");
        StringBuilder sb = new StringBuilder((int) Math.min(size << 3, 1073741824L));
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

    public /* synthetic */ Collection values() {
        zzak zzakVar = this.zzd;
        if (zzakVar != null) {
            return zzakVar;
        }
        zzak zza2 = zza();
        this.zzd = zza2;
        return zza2;
    }

    public abstract zzak zza();

    public abstract zzau zzb();

    public abstract zzau zzc();

    public abstract boolean zzd();

    public /* synthetic */ boolean remove(Object obj, Object obj2) {
        return Map.-CC.$default$remove(this, obj, obj2);
    }

    public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return Map.-CC.$default$replace(this, obj, obj2, obj3);
    }
}
