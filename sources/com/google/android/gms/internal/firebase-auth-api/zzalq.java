package com.google.android.gms.internal.firebase-auth-api;

import java.util.Iterator;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzalq implements Iterator {
    private int zza;
    private boolean zzb;
    private Iterator zzc;
    private final /* synthetic */ zzalg zzd;

    private zzalq(zzalg zzalgVar) {
        this.zzd = zzalgVar;
        this.zza = -1;
    }

    private final Iterator zza() {
        if (this.zzc == null) {
            this.zzc = zzalg.zzb(this.zzd).entrySet().iterator();
        }
        return this.zzc;
    }

    public final boolean hasNext() {
        return this.zza + 1 < zzalg.zza(this.zzd).size() || (!zzalg.zzb(this.zzd).isEmpty() && zza().hasNext());
    }

    public final /* synthetic */ Object next() {
        this.zzb = true;
        int i = this.zza + 1;
        this.zza = i;
        return (Map.Entry) (i < zzalg.zza(this.zzd).size() ? zzalg.zza(this.zzd).get(this.zza) : zza().next());
    }

    public final void remove() {
        if (!this.zzb) {
            throw new IllegalStateException("remove() was called before next()");
        }
        this.zzb = false;
        zzalg.zzd(this.zzd);
        if (this.zza >= zzalg.zza(this.zzd).size()) {
            zza().remove();
            return;
        }
        zzalg zzalgVar = this.zzd;
        int i = this.zza;
        this.zza = i - 1;
        zzalg.zza(zzalgVar, i);
    }

    public /* synthetic */ zzalq(zzalg zzalgVar, zzalt zzaltVar) {
        this(zzalgVar);
    }
}
