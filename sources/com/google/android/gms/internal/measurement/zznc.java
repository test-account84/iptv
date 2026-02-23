package com.google.android.gms.internal.measurement;

import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zznc implements Iterator {
    final /* synthetic */ zzng zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    public /* synthetic */ zznc(zzng zzngVar, zznb zznbVar) {
        this.zza = zzngVar;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = zzng.zzh(this.zza).entrySet().iterator();
        }
        return this.zzd;
    }

    public final boolean hasNext() {
        if (this.zzb + 1 >= zzng.zzf(this.zza).size()) {
            return !zzng.zzh(this.zza).isEmpty() && zza().hasNext();
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        return (Map.Entry) (i < zzng.zzf(this.zza).size() ? zzng.zzf(this.zza).get(this.zzb) : zza().next());
    }

    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzng.zzi(this.zza);
        if (this.zzb >= zzng.zzf(this.zza).size()) {
            zza().remove();
            return;
        }
        zzng zzngVar = this.zza;
        int i = this.zzb;
        this.zzb = i - 1;
        zzng.zzd(zzngVar, i);
    }
}
