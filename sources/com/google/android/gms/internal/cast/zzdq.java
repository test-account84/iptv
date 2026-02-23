package com.google.android.gms.internal.cast;

import android.os.Parcel;
import android.os.RemoteException;
import android.view.Surface;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzdq extends zzb implements zzdr {
    public zzdq() {
        super("com.google.android.gms.cast.remote_display.ICastRemoteDisplayCallbacks");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i == 1) {
            int readInt = parcel.readInt();
            int readInt2 = parcel.readInt();
            Surface surface = (Surface) zzc.zza(parcel, Surface.CREATOR);
            zzc.zzb(parcel);
            zzb(readInt, readInt2, surface);
        } else if (i == 2) {
            int readInt3 = parcel.readInt();
            zzc.zzb(parcel);
            zzd(readInt3);
        } else if (i == 3) {
            zzf();
        } else if (i == 4) {
            zzc();
        } else {
            if (i != 5) {
                return false;
            }
            boolean zzf = zzc.zzf(parcel);
            zzc.zzb(parcel);
            zze(zzf);
        }
        parcel2.writeNoException();
        return true;
    }
}
