package t4;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class l extends zza implements IInterface {
    public l(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.internal.ICastService");
    }

    public final void A(h hVar, String[] strArr) {
        Parcel zza = zza();
        zzc.zze(zza, hVar);
        zza.writeStringArray(strArr);
        zzd(5, zza);
    }

    public final void E(h hVar, String[] strArr) {
        Parcel zza = zza();
        zzc.zze(zza, hVar);
        zza.writeStringArray(strArr);
        zzd(7, zza);
    }

    public final void Z(h hVar, String[] strArr) {
        Parcel zza = zza();
        zzc.zze(zza, hVar);
        zza.writeStringArray(strArr);
        zzd(6, zza);
    }
}
