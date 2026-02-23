package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzbp extends zzbm implements zzbr {
    public zzbp(IBinder iBinder) {
        super(iBinder, "com.google.android.finsky.externalreferrer.IGetInstallReferrerService");
    }

    public final Bundle zzd(Bundle bundle) throws RemoteException {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        Parcel zzb = zzb(1, zza);
        Bundle zza2 = zzbo.zza(zzb, Bundle.CREATOR);
        zzb.recycle();
        return zza2;
    }
}
