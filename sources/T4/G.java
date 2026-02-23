package t4;

import android.os.Bundle;
import android.os.Parcel;
import com.google.android.gms.internal.cast.zzb;
import com.google.android.gms.internal.cast.zzc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class g extends zzb implements h {
    public g() {
        super("com.google.android.gms.cast.internal.IBundleCallback");
    }

    public final boolean zza(int i, Parcel parcel, Parcel parcel2, int i2) {
        if (i != 1) {
            return false;
        }
        Bundle bundle = (Bundle) zzc.zza(parcel, Bundle.CREATOR);
        zzc.zzb(parcel);
        D0(bundle);
        return true;
    }
}
