package com.google.android.gms.internal.measurement;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcg extends zzbm implements zzci {
    public zzcg(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.api.internal.IEventHandlerProxy");
    }

    public final int zzd() throws RemoteException {
        Parcel zzb = zzb(2, zza());
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    public final void zze(String str, String str2, Bundle bundle, long j) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zzd(zza, bundle);
        zza.writeLong(j);
        zzc(1, zza);
    }
}
