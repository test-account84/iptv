package t4;

import android.os.IBinder;
import android.os.IInterface;
import android.os.Parcel;
import com.google.android.gms.internal.cast.zza;
import com.google.android.gms.internal.cast.zzc;
import n4.Z;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class i extends zza implements IInterface {
    public i(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.internal.ICastDeviceController");
    }

    public final void A(String str, String str2, Z z) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zzc(zza, z);
        zzd(14, zza);
    }

    public final void E(String str, n4.i iVar) {
        Parcel zza = zza();
        zza.writeString(str);
        zzc.zzc(zza, iVar);
        zzd(13, zza);
    }

    public final void Z(k kVar) {
        Parcel zza = zza();
        zzc.zze(zza, kVar);
        zzd(18, zza);
    }

    public final void c0(String str) {
        Parcel zza = zza();
        zza.writeString(str);
        zzd(11, zza);
    }

    public final void c1(String str, String str2, long j) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeLong(j);
        zzd(9, zza);
    }

    public final void d1(boolean z, double d, boolean z2) {
        Parcel zza = zza();
        int i = zzc.zza;
        zza.writeInt(z ? 1 : 0);
        zza.writeDouble(d);
        zza.writeInt(z2 ? 1 : 0);
        zzd(8, zza);
    }

    public final void e1(String str) {
        Parcel zza = zza();
        zza.writeString(str);
        zzd(5, zza);
    }

    public final void f1() {
        zzd(19, zza());
    }

    public final void g1(String str) {
        Parcel zza = zza();
        zza.writeString(str);
        zzd(12, zza);
    }

    public final void zze() {
        zzd(17, zza());
    }

    public final void zzf() {
        zzd(1, zza());
    }
}
