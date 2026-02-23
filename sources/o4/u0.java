package o4;

import android.os.Bundle;
import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class u0 extends zza implements w0 {
    public u0(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.ICastContext");
    }

    public final void b1(r0 r0Var) {
        Parcel zza = zza();
        zzc.zze(zza, r0Var);
        zzc(3, zza);
    }

    public final void m0(boolean z) {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(0);
        zzc(14, zza);
    }

    public final int zze() {
        Parcel zzb = zzb(13, zza());
        int readInt = zzb.readInt();
        zzb.recycle();
        return readInt;
    }

    public final Bundle zzf() {
        Parcel zzb = zzb(1, zza());
        Bundle zza = zzc.zza(zzb, Bundle.CREATOR);
        zzb.recycle();
        return zza;
    }

    public final G zzg() {
        G f;
        Parcel zzb = zzb(6, zza());
        IBinder readStrongBinder = zzb.readStrongBinder();
        if (readStrongBinder == null) {
            f = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.cast.framework.IDiscoveryManager");
            f = queryLocalInterface instanceof G ? (G) queryLocalInterface : new F(readStrongBinder);
        }
        zzb.recycle();
        return f;
    }

    public final O zzh() {
        O n;
        Parcel zzb = zzb(5, zza());
        IBinder readStrongBinder = zzb.readStrongBinder();
        if (readStrongBinder == null) {
            n = null;
        } else {
            IInterface queryLocalInterface = readStrongBinder.queryLocalInterface("com.google.android.gms.cast.framework.ISessionManager");
            n = queryLocalInterface instanceof O ? (O) queryLocalInterface : new N(readStrongBinder);
        }
        zzb.recycle();
        return n;
    }
}
