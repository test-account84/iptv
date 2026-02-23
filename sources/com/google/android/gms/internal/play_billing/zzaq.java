package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaq extends zzam {
    private final transient zzal zza;
    private final transient Object[] zzb;
    private final transient int zzc;

    public zzaq(zzal zzalVar, Object[] objArr, int i, int i2) {
        this.zza = zzalVar;
        this.zzb = objArr;
        this.zzc = i2;
    }

    public static /* bridge */ /* synthetic */ int zzi(zzaq zzaqVar) {
        return zzaqVar.zzc;
    }

    public static /* bridge */ /* synthetic */ Object[] zzj(zzaq zzaqVar) {
        return zzaqVar.zzb;
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

    public final zzav zze() {
        return zzd().listIterator(0);
    }

    public final boolean zzf() {
        throw null;
    }

    public final zzai zzh() {
        return new zzap(this);
    }
}
