package com.google.android.gms.internal.location;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzah extends zzb implements zzai {
    public zzah() {
        super("com.google.android.gms.location.internal.IFusedLocationProviderCallback");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            zzb((zzaa) zzc.zzb(parcel, zzaa.CREATOR));
        } else {
            if (i != 2) {
                return false;
            }
            zzc();
        }
        return true;
    }
}
