package com.google.android.gms.internal.cast;

import u0.K;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class zzbc implements Runnable {
    public final /* synthetic */ zzbf zza;
    public final /* synthetic */ K zzb;
    public final /* synthetic */ int zzc;

    public /* synthetic */ zzbc(zzbf zzbfVar, K k, int i) {
        this.zza = zzbfVar;
        this.zzb = k;
        this.zzc = i;
    }

    public final void run() {
        this.zza.zzo(this.zzb, this.zzc);
    }
}
