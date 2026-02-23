package com.google.android.recaptcha.internal;

import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zziu implements Iterator {
    final /* synthetic */ zziy zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    public /* synthetic */ zziu(zziy zziyVar, zzit zzitVar) {
        this.zza = zziyVar;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = zziy.zzh(this.zza).entrySet().iterator();
        }
        return this.zzd;
    }

    public final boolean hasNext() {
        if (this.zzb + 1 >= zziy.zzf(this.zza).size()) {
            return !zziy.zzh(this.zza).isEmpty() && zza().hasNext();
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        return (Map.Entry) (i < zziy.zzf(this.zza).size() ? zziy.zzf(this.zza).get(this.zzb) : zza().next());
    }

    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zziy.zzi(this.zza);
        if (this.zzb >= zziy.zzf(this.zza).size()) {
            zza().remove();
            return;
        }
        zziy zziyVar = this.zza;
        int i = this.zzb;
        this.zzb = i - 1;
        zziy.zzd(zziyVar, i);
    }
}
