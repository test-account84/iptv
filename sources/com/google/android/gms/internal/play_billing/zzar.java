package com.google.android.gms.internal.play_billing;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzar extends zzam {
    private final transient zzal zza;
    private final transient zzai zzb;

    public zzar(zzal zzalVar, zzai zzaiVar) {
        this.zza = zzalVar;
        this.zzb = zzaiVar;
    }

    public final boolean contains(Object obj) {
        return this.zza.get(obj) != null;
    }

    public final /* synthetic */ Iterator iterator() {
        return this.zzb.listIterator(0);
    }

    public final int size() {
        return this.zza.size();
    }

    public final int zza(Object[] objArr, int i) {
        return this.zzb.zza(objArr, 0);
    }

    public final zzai zzd() {
        return this.zzb;
    }

    public final zzav zze() {
        return this.zzb.listIterator(0);
    }

    public final boolean zzf() {
        throw null;
    }
}
