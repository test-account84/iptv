package com.google.android.gms.internal.measurement;

import android.os.RemoteException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
abstract class zzdu implements Runnable {
    final long zzh;
    final long zzi;
    final boolean zzj;
    final /* synthetic */ zzef zzk;

    public zzdu(zzef zzefVar, boolean z) {
        this.zzk = zzefVar;
        this.zzh = zzefVar.zza.a();
        this.zzi = zzefVar.zza.b();
        this.zzj = z;
    }

    public final void run() {
        if (zzef.zzQ(this.zzk)) {
            zzb();
            return;
        }
        try {
            zza();
        } catch (Exception e) {
            zzef.zzt(this.zzk, e, false, this.zzj);
            zzb();
        }
    }

    public abstract void zza() throws RemoteException;

    public void zzb() {
    }
}
