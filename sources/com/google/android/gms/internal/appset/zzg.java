package com.google.android.gms.internal.appset;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;
import i4.d;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzg extends zza implements IInterface {
    public zzg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.appset.internal.IAppSetService");
    }

    public final void zzc(d dVar, zzf zzfVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzb(zza, dVar);
        zzc.zzc(zza, zzfVar);
        zzb(1, zza);
    }
}
