package com.google.android.gms.internal.firebase-auth-api;

import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaz extends zzau {
    private final transient zzat zza;
    private final transient Object[] zzb;
    private final transient int zzc = 0;
    private final transient int zzd;

    public zzaz(zzat zzatVar, Object[] objArr, int i, int i2) {
        this.zza = zzatVar;
        this.zzb = objArr;
        this.zzd = i2;
    }

    public static /* bridge */ /* synthetic */ int zza(zzaz zzazVar) {
        return zzazVar.zzd;
    }

    public static /* bridge */ /* synthetic */ Object[] zzb(zzaz zzazVar) {
        return zzazVar.zzb;
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
        return iterator();
    }

    public final int size() {
        return this.zzd;
    }

    public final zzbc zzd() {
        return (zzbc) zzc().iterator();
    }

    public final boolean zze() {
        return true;
    }

    public final zzap zzg() {
        return new zzay(this);
    }

    public final int zza(Object[] objArr, int i) {
        return zzc().zza(objArr, i);
    }
}
