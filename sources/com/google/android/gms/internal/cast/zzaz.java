package com.google.android.gms.internal.cast;

import t.c;
import u0.L;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final /* synthetic */ class zzaz implements Runnable {
    public final /* synthetic */ zzbb zza;
    public final /* synthetic */ L.h zzb;
    public final /* synthetic */ L.h zzc;
    public final /* synthetic */ c.a zzd;

    public /* synthetic */ zzaz(zzbb zzbbVar, L.h hVar, L.h hVar2, c.a aVar) {
        this.zza = zzbbVar;
        this.zzb = hVar;
        this.zzc = hVar2;
        this.zzd = aVar;
    }

    public final void run() {
        this.zza.zzb(this.zzb, this.zzc, this.zzd);
    }
}
