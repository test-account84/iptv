package G4;

import F4.a;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.common.zza;
import com.google.android.gms.internal.common.zzc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class j extends zza implements IInterface {
    public j(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.dynamite.IDynamiteLoader");
    }

    public final int A(F4.a aVar, String str, boolean z) {
        Parcel zza = zza();
        zzc.zze(zza, aVar);
        zza.writeString(str);
        zza.writeInt(z ? 1 : 0);
        Parcel zzB = zzB(3, zza);
        int readInt = zzB.readInt();
        zzB.recycle();
        return readInt;
    }

    public final int E(F4.a aVar, String str, boolean z) {
        Parcel zza = zza();
        zzc.zze(zza, aVar);
        zza.writeString(str);
        zza.writeInt(z ? 1 : 0);
        Parcel zzB = zzB(5, zza);
        int readInt = zzB.readInt();
        zzB.recycle();
        return readInt;
    }

    public final F4.a Z(F4.a aVar, String str, int i) {
        Parcel zza = zza();
        zzc.zze(zza, aVar);
        zza.writeString(str);
        zza.writeInt(i);
        Parcel zzB = zzB(2, zza);
        F4.a A = a.a.A(zzB.readStrongBinder());
        zzB.recycle();
        return A;
    }

    public final F4.a c0(F4.a aVar, String str, int i, F4.a aVar2) {
        Parcel zza = zza();
        zzc.zze(zza, aVar);
        zza.writeString(str);
        zza.writeInt(i);
        zzc.zze(zza, aVar2);
        Parcel zzB = zzB(8, zza);
        F4.a A = a.a.A(zzB.readStrongBinder());
        zzB.recycle();
        return A;
    }

    public final F4.a c1(F4.a aVar, String str, int i) {
        Parcel zza = zza();
        zzc.zze(zza, aVar);
        zza.writeString(str);
        zza.writeInt(i);
        Parcel zzB = zzB(4, zza);
        F4.a A = a.a.A(zzB.readStrongBinder());
        zzB.recycle();
        return A;
    }

    public final F4.a d1(F4.a aVar, String str, boolean z, long j) {
        Parcel zza = zza();
        zzc.zze(zza, aVar);
        zza.writeString(str);
        zza.writeInt(z ? 1 : 0);
        zza.writeLong(j);
        Parcel zzB = zzB(7, zza);
        F4.a A = a.a.A(zzB.readStrongBinder());
        zzB.recycle();
        return A;
    }

    public final int zze() {
        Parcel zzB = zzB(6, zza());
        int readInt = zzB.readInt();
        zzB.recycle();
        return readInt;
    }
}
