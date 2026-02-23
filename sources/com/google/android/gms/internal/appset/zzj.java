package com.google.android.gms.internal.appset;

import C4.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzj implements Runnable {
    final /* synthetic */ zzl zza;

    public /* synthetic */ zzj(zzl zzlVar, zzi zziVar) {
        this.zza = zzlVar;
    }

    public final void run() {
        long zza = this.zza.zza();
        if (zza == -1 || h.c().a() <= zza) {
            return;
        }
        zzl.zze(zzl.zzb(this.zza));
    }
}
