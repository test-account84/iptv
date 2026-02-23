package com.google.android.gms.internal.cast;

import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzdj extends zzdh {
    final /* synthetic */ zzdk zza;

    public zzdj(zzdk zzdkVar) {
        this.zza = zzdkVar;
    }

    public final void zzd(int i) throws RemoteException {
        zzdm.zzb().a("onError: %d", Integer.valueOf(i));
        zzdm.zzf(this.zza.zzc);
        this.zza.setResult((h) new zzdl(Status.m));
    }

    public final void zzf() throws RemoteException {
        zzdm.zzb().a("onDisconnected", new Object[0]);
        zzdm.zzf(this.zza.zzc);
        this.zza.setResult((h) new zzdl(Status.k));
    }
}
