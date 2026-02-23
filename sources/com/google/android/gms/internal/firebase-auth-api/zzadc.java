package com.google.android.gms.internal.firebase-auth-api;

import G5.H;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzadc implements Runnable {
    private final /* synthetic */ zzadf zza;
    private final /* synthetic */ zzacz zzb;

    public zzadc(zzacz zzaczVar, zzadf zzadfVar) {
        this.zzb = zzaczVar;
        this.zza = zzadfVar;
    }

    public final void run() {
        synchronized (this.zzb.zza.zzh) {
            try {
                if (!this.zzb.zza.zzh.isEmpty()) {
                    this.zza.zza((H) this.zzb.zza.zzh.get(0), new Object[0]);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
