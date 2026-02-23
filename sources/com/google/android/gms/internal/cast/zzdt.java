package com.google.android.gms.internal.cast;

import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzdt extends zzb implements zzdu {
    public zzdt() {
        super("com.google.android.gms.cast.remote_display.ICastRemoteDisplaySessionCallbacks");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            return false;
        }
        int readInt = parcel.readInt();
        zzc.zzb(parcel);
        zzb(readInt);
        return true;
    }
}
