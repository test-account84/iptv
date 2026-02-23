package G4;

import F4.a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class k extends zza implements IInterface {
    public k(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoaderV2");
    }

    public final F4.a A(F4.a aVar, String str, int i, F4.a aVar2) {
        Parcel zza = zza();
        zzc.zze(zza, aVar);
        zza.writeString(str);
        zza.writeInt(i);
        zzc.zze(zza, aVar2);
        Parcel zzB = zzB(2, zza);
        F4.a A = a.a.A(zzB.readStrongBinder());
        zzB.recycle();
        return A;
    }

    public final F4.a E(F4.a aVar, String str, int i, F4.a aVar2) {
        Parcel zza = zza();
        zzc.zze(zza, aVar);
        zza.writeString(str);
        zza.writeInt(i);
        zzc.zze(zza, aVar2);
        Parcel zzB = zzB(3, zza);
        F4.a A = a.a.A(zzB.readStrongBinder());
        zzB.recycle();
        return A;
    }
}
