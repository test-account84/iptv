package com.google.android.gms.internal.cast;

import android.os.RemoteException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdo extends zzdt {
    final /* synthetic */ zzdu zza;
    final /* synthetic */ zzdp zzb;

    public zzdo(zzdp zzdpVar, zzdu zzduVar) {
        this.zzb = zzdpVar;
        this.zza = zzduVar;
    }

    public final void zzb(int i) throws RemoteException {
        zzdp.zzq().a("onRemoteDisplayEnded", new Object[0]);
        zzdu zzduVar = this.zza;
        if (zzduVar != null) {
            zzduVar.zzb(i);
        }
        zzdp.zzp(this.zzb);
    }
}
