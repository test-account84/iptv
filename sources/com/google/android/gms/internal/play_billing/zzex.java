package com.google.android.gms.internal.play_billing;

import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzex implements Iterator {
    final /* synthetic */ zzfb zza;
    private int zzb = -1;
    private boolean zzc;
    private Iterator zzd;

    public /* synthetic */ zzex(zzfb zzfbVar, zzew zzewVar) {
        this.zza = zzfbVar;
    }

    private final Iterator zza() {
        if (this.zzd == null) {
            this.zzd = zzfb.zzh(this.zza).entrySet().iterator();
        }
        return this.zzd;
    }

    public final boolean hasNext() {
        if (this.zzb + 1 >= zzfb.zzf(this.zza).size()) {
            return !zzfb.zzh(this.zza).isEmpty() && zza().hasNext();
        }
        return true;
    }

    public final /* bridge */ /* synthetic */ Object next() {
        this.zzc = true;
        int i = this.zzb + 1;
        this.zzb = i;
        return (Map.Entry) (i < zzfb.zzf(this.zza).size() ? zzfb.zzf(this.zza).get(this.zzb) : zza().next());
    }

    public final void remove() {
        if (!this.zzc) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzc = false;
        zzfb.zzi(this.zza);
        if (this.zzb >= zzfb.zzf(this.zza).size()) {
            zza().remove();
            return;
        }
        zzfb zzfbVar = this.zza;
        int i = this.zzb;
        this.zzb = i - 1;
        zzfb.zzd(zzfbVar, i);
    }
}
