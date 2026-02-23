package o4;

import android.os.Parcel;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class s0 extends zzb implements t0 {
    public s0() {
        super("com.google.android.gms.cast.framework.ICastConnectionController");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i == 1) {
            String readString = parcel.readString();
            String readString2 = parcel.readString();
            zzc.zzb(parcel);
            J0(readString, readString2);
        } else if (i == 2) {
            String readString3 = parcel.readString();
            n4.i iVar = (n4.i) zzc.zza(parcel, n4.i.CREATOR);
            zzc.zzb(parcel);
            A0(readString3, iVar);
        } else if (i == 3) {
            String readString4 = parcel.readString();
            zzc.zzb(parcel);
            p0(readString4);
        } else {
            if (i != 4) {
                if (i != 5) {
                    return false;
                }
                parcel2.writeNoException();
                parcel2.writeInt(12451000);
                return true;
            }
            int readInt = parcel.readInt();
            zzc.zzb(parcel);
            zzb(readInt);
        }
        parcel2.writeNoException();
        return true;
    }
}
