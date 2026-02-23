package com.google.android.gms.internal.firebase-auth-api;

import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaho extends zzahq {
    private int zza = 0;
    private final int zzb;
    private final /* synthetic */ zzahp zzc;

    public zzaho(zzahp zzahpVar) {
        this.zzc = zzahpVar;
        this.zzb = zzahpVar.zzb();
    }

    public final boolean hasNext() {
        return this.zza < this.zzb;
    }

    public final byte zza() {
        int i = this.zza;
        if (i >= this.zzb) {
            throw new NoSuchElementException();
        }
        this.zza = i + 1;
        return this.zzc.zzb(i);
    }
}
