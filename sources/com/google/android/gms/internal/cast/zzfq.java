package com.google.android.gms.internal.cast;

import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzfq extends zzfl {
    private final transient zzfk zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    public zzfq(zzfk zzfkVar, Object[] objArr, int i, int i2) {
        this.zza = zzfkVar;
        this.zzb = objArr;
        this.zzc = i2;
    }

    public static /* bridge */ /* synthetic */ int zzm(zzfq zzfqVar) {
        return zzfqVar.zzc;
    }

    public static /* bridge */ /* synthetic */ Object[] zzn(zzfq zzfqVar) {
        return zzfqVar.zzb;
    }

    public final boolean contains(Object obj) {
        if (obj instanceof Map.Entry) {
            Map.Entry entry = (Map.Entry) obj;
            Object key = entry.getKey();
            Object value = entry.getValue();
            if (value != null && value.equals(this.zza.get(key))) {
                return true;
            }
        }
        return false;
    }

    public final /* synthetic */ Iterator iterator() {
        return zzd().listIterator(0);
    }

    public final int size() {
        return this.zzc;
    }

    public final int zza(Object[] objArr, int i) {
        return zzd().zza(objArr, 0);
    }

    public final zzfx zze() {
        return zzd().listIterator(0);
    }

    public final boolean zzf() {
        throw null;
    }

    public final zzfh zzi() {
        return new zzfp(this);
    }
}
