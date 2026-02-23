package com.google.android.gms.internal.cast;

import j$.util.Map;
import java.io.Serializable;
import java.util.Collection;
import java.util.Map;
import java.util.Set;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Function;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzfk implements Map, Serializable, j$.util.Map {
    private transient zzfl zza;
    private transient zzfl zzb;
    private transient zzfd zzc;

    public static zzfk zzc(Iterable iterable) {
        zzfj zzfjVar = new zzfj(iterable instanceof Collection ? iterable.size() : 4);
        zzfjVar.zza(iterable);
        zzfi zzfiVar = zzfjVar.zzc;
        if (zzfiVar != null) {
            throw zzfiVar.zza();
        }
        zzft zzh = zzft.zzh(zzfjVar.zzb, zzfjVar.zza, zzfjVar);
        zzfi zzfiVar2 = zzfjVar.zzc;
        if (zzfiVar2 == null) {
            return zzh;
        }
        throw zzfiVar2.zza();
    }

    public static zzfk zzd() {
        return zzft.zza;
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

    public final boolean equals(Object obj) {
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

    public final int hashCode() {
        return zzfv.zza(entrySet());
    }

    public final boolean isEmpty() {
        return size() == 0;
    }

    public final /* bridge */ /* synthetic */ Set keySet() {
        zzfl zzflVar = this.zzb;
        if (zzflVar != null) {
            return zzflVar;
        }
        zzfl zzf = zzf();
        this.zzb = zzf;
        return zzf;
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
        if (size < 0) {
            throw new IllegalArgumentException("size cannot be negative but was: " + size);
        }
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

    public abstract zzfd zza();

    /* renamed from: zzb, reason: merged with bridge method [inline-methods] */
    public final zzfd values() {
        zzfd zzfdVar = this.zzc;
        if (zzfdVar != null) {
            return zzfdVar;
        }
        zzfd zza = zza();
        this.zzc = zza;
        return zza;
    }

    public abstract zzfl zze();

    public abstract zzfl zzf();

    /* renamed from: zzg, reason: merged with bridge method [inline-methods] */
    public final zzfl entrySet() {
        zzfl zzflVar = this.zza;
        if (zzflVar != null) {
            return zzflVar;
        }
        zzfl zze = zze();
        this.zza = zze;
        return zze;
    }

    public /* synthetic */ boolean remove(Object obj, Object obj2) {
        return Map.-CC.$default$remove(this, obj, obj2);
    }

    public /* synthetic */ boolean replace(Object obj, Object obj2, Object obj3) {
        return Map.-CC.$default$replace(this, obj, obj2, obj3);
    }
}
