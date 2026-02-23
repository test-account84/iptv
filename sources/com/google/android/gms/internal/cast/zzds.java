package com.google.android.gms.internal.cast;

import android.app.PendingIntent;
import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzds extends zza implements IInterface {
    public zzds(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.remote_display.ICastRemoteDisplayService");
    }

    public final void zze() throws RemoteException {
        zzd(3, zza());
    }

    public final void zzf(zzdr zzdrVar, int i) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzdrVar);
        zza.writeInt(i);
        zzd(5, zza);
    }

    public final void zzg(zzdr zzdrVar, zzdu zzduVar, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzdrVar);
        zzc.zze(zza, zzduVar);
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzc(zza, bundle);
        zzd(7, zza);
    }

    public final void zzh(zzdr zzdrVar, PendingIntent pendingIntent, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzdrVar);
        zzc.zzc(zza, pendingIntent);
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzc(zza, bundle);
        zzd(8, zza);
    }

    public final void zzi(zzdr zzdrVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, zzdrVar);
        zzd(6, zza);
    }
}
