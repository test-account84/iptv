package com.google.android.gms.internal.appset;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.common.api.Status;
import i4.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zze extends zzb implements zzf {
    public zze() {
        super("com.google.android.gms.appset.internal.IAppSetIdCallback");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        zzb((Status) zzc.zza(parcel, Status.CREATOR), (f) zzc.zza(parcel, f.CREATOR));
        return true;
    }
}
