package com.google.android.gms.internal.auth-api-phone;

import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.h;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzi extends zzb implements zzj {
    public zzi(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.auth.api.phone.internal.ISmsRetrieverApiService");
    }

    public final void zza(h hVar) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, hVar);
        zza(3, zza);
    }

    public final void zza(zzf zzfVar) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzfVar);
        zza(4, zza);
    }

    public final void zza(zzl zzlVar) throws RemoteException {
        Parcel zza = zza();
        zzd.zza(zza, zzlVar);
        zza(1, zza);
    }

    public final void zza(String str, zzh zzhVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, zzhVar);
        zza(5, zza);
    }

    public final void zza(String str, zzl zzlVar) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zzd.zza(zza, zzlVar);
        zza(2, zza);
    }
}
