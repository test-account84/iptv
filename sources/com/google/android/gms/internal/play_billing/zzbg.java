package com.google.android.gms.internal.play_billing;

import java.util.NoSuchElementException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzbg extends zzbi {
    final /* synthetic */ zzbq zza;
    private int zzb = 0;
    private final int zzc;

    public zzbg(zzbq zzbqVar) {
        this.zza = zzbqVar;
        this.zzc = zzbqVar.zzd();
    }

    public final boolean hasNext() {
        return this.zzb < this.zzc;
    }

    public final byte zza() {
        int i = this.zzb;
        if (i >= this.zzc) {
            throw new NoSuchElementException();
        }
        this.zzb = i + 1;
        return this.zza.zzb(i);
    }
}
