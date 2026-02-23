package com.google.android.gms.internal.cast;

import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzuj implements Iterator {
    final /* synthetic */ zzun zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    public /* synthetic */ zzuj(zzun zzunVar, zzui zzuiVar) {
        this.zza = zzunVar;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = zzun.zzh(this.zza).entrySet().iterator();
        }
        return this.zzd;
    }

    public final boolean hasNext() {
        if (this.zzb + 1 >= zzun.zzf(this.zza).size()) {
            return !zzun.zzh(this.zza).isEmpty() && zza().hasNext();
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        return (Map.Entry) (i < zzun.zzf(this.zza).size() ? zzun.zzf(this.zza).get(this.zzb) : zza().next());
    }

    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzun.zzi(this.zza);
        if (this.zzb >= zzun.zzf(this.zza).size()) {
            zza().remove();
            return;
        }
        zzun zzunVar = this.zza;
        int i = this.zzb;
        this.zzb = i - 1;
        zzun.zzd(zzunVar, i);
    }
}
