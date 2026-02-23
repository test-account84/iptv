package o4;

import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class q0 extends zzb implements r0 {
    public q0() {
        super("com.google.android.gms.cast.framework.IAppVisibilityListener");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) throws RemoteException {
        if (i != 1) {
            if (i == 2) {
                zzd();
            } else if (i == 3) {
                zzc();
            } else {
                if (i != 4) {
                    return false;
                }
                parcel2.writeNoException();
                parcel2.writeInt(12451000);
            }
            parcel2.writeNoException();
        } else {
            F4.a zzb = zzb();
            parcel2.writeNoException();
            zzc.zze(parcel2, zzb);
        }
        return true;
    }
}
