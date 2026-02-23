package com.google.android.gms.internal.cast;

import java.util.Arrays;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.Map;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zztj extends LinkedHashMap {
    private static final zztj zza;
    private boolean zzb;

    static {
        zztj zztjVar = new zztj();
        zza = zztjVar;
        zztjVar.zzb = false;
    }

    private zztj() {
        this.zzb = true;
    }

    private static int zze(Object obj) {
        if (!(obj instanceof byte[])) {
            if (obj instanceof zzsj) {
                throw new UnsupportedOperationException();
            }
            return obj.hashCode();
        }
        byte[] bArr = (byte[]) obj;
        byte[] bArr2 = zzsq.zzd;
        int length = bArr.length;
        int zzb = zzsq.zzb(length, bArr, 0, length);
        if (zzb == 0) {
            return 1;
        }
        return zzb;
    }

    private final void zzf() {
        if (!this.zzb) {
            throw new UnsupportedOperationException();
        }
    }

    public final void clear() {
        zzf();
        super.clear();
    }

    public final Set entrySet() {
        return isEmpty() ? Collections.emptySet() : super.entrySet();
    }

    public final boolean equals(Object obj) {
        if (!(obj instanceof Map)) {
            return false;
        }
        Map map = (Map) obj;
        if (this == map) {
            return true;
        }
        if (size() != map.size()) {
            return false;
        }
        for (Map.Entry entry : entrySet()) {
            if (!map.containsKey(entry.getKey())) {
                return false;
            }
            Object value = entry.getValue();
            Object obj2 = map.get(entry.getKey());
            if (!(((value instanceof byte[]) && (obj2 instanceof byte[])) ? Arrays.equals((byte[]) value, (byte[]) obj2) : value.equals(obj2))) {
                return false;
            }
        }
        return true;
    }

    public final int hashCode() {
        int i = 0;
        for (Map.Entry entry : entrySet()) {
            i += zze(entry.getValue()) ^ zze(entry.getKey());
        }
        return i;
    }

    public final Object put(Object obj, Object obj2) {
        zzf();
        byte[] bArr = zzsq.zzd;
        obj.getClass();
        obj2.getClass();
        return super.put(obj, obj2);
    }

    public final void putAll(Map map) {
        zzf();
        for (Object obj : map.keySet()) {
            byte[] bArr = zzsq.zzd;
            obj.getClass();
            map.get(obj).getClass();
        }
        super.putAll(map);
    }

    public final Object remove(Object obj) {
        zzf();
        return super.remove(obj);
    }

    public final zztj zza() {
        return isEmpty() ? new zztj() : new zztj(this);
    }

    public final void zzb() {
        this.zzb = false;
    }

    public final void zzc(zztj zztjVar) {
        zzf();
        if (zztjVar.isEmpty()) {
            return;
        }
        putAll(zztjVar);
    }

    public final boolean zzd() {
        return this.zzb;
    }

    private zztj(Map map) {
        super(map);
        this.zzb = true;
    }
}
