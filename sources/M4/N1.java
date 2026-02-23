package M4;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import com.google.android.gms.internal.measurement.zzbm;
import com.google.android.gms.internal.measurement.zzbo;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class n1 extends zzbm implements p1 {
    public n1(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.measurement.internal.IMeasurementService");
    }

    public final void C(long j, String str, String str2, String str3) {
        Parcel zza = zza();
        zza.writeLong(j);
        zza.writeString(str);
        zza.writeString(str2);
        zza.writeString(str3);
        zzc(10, zza);
    }

    public final byte[] F(v vVar, String str) {
        Parcel zza = zza();
        zzbo.zzd(zza, vVar);
        zza.writeString(str);
        Parcel zzb = zzb(9, zza);
        byte[] createByteArray = zzb.createByteArray();
        zzb.recycle();
        return createByteArray;
    }

    public final String I(f5 f5Var) {
        Parcel zza = zza();
        zzbo.zzd(zza, f5Var);
        Parcel zzb = zzb(11, zza);
        String readString = zzb.readString();
        zzb.recycle();
        return readString;
    }

    public final void N(v vVar, f5 f5Var) {
        Parcel zza = zza();
        zzbo.zzd(zza, vVar);
        zzbo.zzd(zza, f5Var);
        zzc(1, zza);
    }

    public final void P0(d dVar, f5 f5Var) {
        Parcel zza = zza();
        zzbo.zzd(zza, dVar);
        zzbo.zzd(zza, f5Var);
        zzc(12, zza);
    }

    public final void T0(f5 f5Var) {
        Parcel zza = zza();
        zzbo.zzd(zza, f5Var);
        zzc(18, zza);
    }

    public final void a1(V4 v4, f5 f5Var) {
        Parcel zza = zza();
        zzbo.zzd(zza, v4);
        zzbo.zzd(zza, f5Var);
        zzc(2, zza);
    }

    public final List b(String str, String str2, boolean z, f5 f5Var) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        int i = zzbo.zza;
        zza.writeInt(z ? 1 : 0);
        zzbo.zzd(zza, f5Var);
        Parcel zzb = zzb(14, zza);
        ArrayList createTypedArrayList = zzb.createTypedArrayList(V4.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    public final List b0(String str, String str2, String str3, boolean z) {
        Parcel zza = zza();
        zza.writeString((String) null);
        zza.writeString(str2);
        zza.writeString(str3);
        int i = zzbo.zza;
        zza.writeInt(z ? 1 : 0);
        Parcel zzb = zzb(15, zza);
        ArrayList createTypedArrayList = zzb.createTypedArrayList(V4.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    public final void j0(f5 f5Var) {
        Parcel zza = zza();
        zzbo.zzd(zza, f5Var);
        zzc(20, zza);
    }

    public final List l0(String str, String str2, String str3) {
        Parcel zza = zza();
        zza.writeString((String) null);
        zza.writeString(str2);
        zza.writeString(str3);
        Parcel zzb = zzb(17, zza);
        ArrayList createTypedArrayList = zzb.createTypedArrayList(d.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    public final void r(f5 f5Var) {
        Parcel zza = zza();
        zzbo.zzd(zza, f5Var);
        zzc(4, zza);
    }

    public final List s0(String str, String str2, f5 f5Var) {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzbo.zzd(zza, f5Var);
        Parcel zzb = zzb(16, zza);
        ArrayList createTypedArrayList = zzb.createTypedArrayList(d.CREATOR);
        zzb.recycle();
        return createTypedArrayList;
    }

    public final void u0(f5 f5Var) {
        Parcel zza = zza();
        zzbo.zzd(zza, f5Var);
        zzc(6, zza);
    }

    public final void z0(Bundle bundle, f5 f5Var) {
        Parcel zza = zza();
        zzbo.zzd(zza, bundle);
        zzbo.zzd(zza, f5Var);
        zzc(19, zza);
    }
}
