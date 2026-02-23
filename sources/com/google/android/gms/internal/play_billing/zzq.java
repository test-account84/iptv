package com.google.android.gms.internal.play_billing;

import android.os.Bundle;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzq extends zzv implements zzs {
    public zzq(IBinder iBinder) {
        super(iBinder, "com.android.vending.billing.IInAppBillingService");
    }

    public final int zza(int i, String str, String str2) throws RemoteException {
        Parcel zzu = zzu();
        zzu.writeInt(3);
        zzu.writeString(str);
        zzu.writeString(str2);
        Parcel zzv = zzv(5, zzu);
        int readInt = zzv.readInt();
        zzv.recycle();
        return readInt;
    }

    public final int zzc(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzu = zzu();
        zzu.writeInt(i);
        zzu.writeString(str);
        zzu.writeString(str2);
        zzx.zzc(zzu, bundle);
        Parcel zzv = zzv(10, zzu);
        int readInt = zzv.readInt();
        zzv.recycle();
        return readInt;
    }

    public final Bundle zzd(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzu = zzu();
        zzu.writeInt(9);
        zzu.writeString(str);
        zzu.writeString(str2);
        zzx.zzc(zzu, bundle);
        Parcel zzv = zzv(902, zzu);
        Bundle zza = zzx.zza(zzv, Bundle.CREATOR);
        zzv.recycle();
        return zza;
    }

    public final Bundle zze(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzu = zzu();
        zzu.writeInt(9);
        zzu.writeString(str);
        zzu.writeString(str2);
        zzx.zzc(zzu, bundle);
        Parcel zzv = zzv(12, zzu);
        Bundle zza = zzx.zza(zzv, Bundle.CREATOR);
        zzv.recycle();
        return zza;
    }

    public final Bundle zzf(int i, String str, String str2, String str3, String str4) throws RemoteException {
        Parcel zzu = zzu();
        zzu.writeInt(3);
        zzu.writeString(str);
        zzu.writeString(str2);
        zzu.writeString(str3);
        zzu.writeString((String) null);
        Parcel zzv = zzv(3, zzu);
        Bundle zza = zzx.zza(zzv, Bundle.CREATOR);
        zzv.recycle();
        return zza;
    }

    public final Bundle zzg(int i, String str, String str2, String str3, String str4, Bundle bundle) throws RemoteException {
        Parcel zzu = zzu();
        zzu.writeInt(i);
        zzu.writeString(str);
        zzu.writeString(str2);
        zzu.writeString(str3);
        zzu.writeString((String) null);
        zzx.zzc(zzu, bundle);
        Parcel zzv = zzv(8, zzu);
        Bundle zza = zzx.zza(zzv, Bundle.CREATOR);
        zzv.recycle();
        return zza;
    }

    public final Bundle zzh(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel zzu = zzu();
        zzu.writeInt(6);
        zzu.writeString(str);
        zzu.writeString(str2);
        zzu.writeString(str3);
        zzx.zzc(zzu, bundle);
        Parcel zzv = zzv(9, zzu);
        Bundle zza = zzx.zza(zzv, Bundle.CREATOR);
        zzv.recycle();
        return zza;
    }

    public final Bundle zzi(int i, String str, String str2, String str3) throws RemoteException {
        Parcel zzu = zzu();
        zzu.writeInt(3);
        zzu.writeString(str);
        zzu.writeString(str2);
        zzu.writeString(str3);
        Parcel zzv = zzv(4, zzu);
        Bundle zza = zzx.zza(zzv, Bundle.CREATOR);
        zzv.recycle();
        return zza;
    }

    public final Bundle zzj(int i, String str, String str2, String str3, Bundle bundle) throws RemoteException {
        Parcel zzu = zzu();
        zzu.writeInt(i);
        zzu.writeString(str);
        zzu.writeString(str2);
        zzu.writeString(str3);
        zzx.zzc(zzu, bundle);
        Parcel zzv = zzv(11, zzu);
        Bundle zza = zzx.zza(zzv, Bundle.CREATOR);
        zzv.recycle();
        return zza;
    }

    public final Bundle zzk(int i, String str, String str2, Bundle bundle) throws RemoteException {
        Parcel zzu = zzu();
        zzu.writeInt(3);
        zzu.writeString(str);
        zzu.writeString(str2);
        zzx.zzc(zzu, bundle);
        Parcel zzv = zzv(2, zzu);
        Bundle zza = zzx.zza(zzv, Bundle.CREATOR);
        zzv.recycle();
        return zza;
    }

    public final Bundle zzl(int i, String str, String str2, Bundle bundle, Bundle bundle2) throws RemoteException {
        Parcel zzu = zzu();
        zzu.writeInt(i);
        zzu.writeString(str);
        zzu.writeString(str2);
        zzx.zzc(zzu, bundle);
        zzx.zzc(zzu, bundle2);
        Parcel zzv = zzv(901, zzu);
        Bundle zza = zzx.zza(zzv, Bundle.CREATOR);
        zzv.recycle();
        return zza;
    }

    public final void zzm(int i, String str, Bundle bundle, zzd zzdVar) throws RemoteException {
        Parcel zzu = zzu();
        zzu.writeInt(21);
        zzu.writeString(str);
        zzx.zzc(zzu, bundle);
        zzu.writeStrongBinder(zzdVar);
        zzx(1501, zzu);
    }

    public final void zzn(int i, String str, Bundle bundle, zzf zzfVar) throws RemoteException {
        Parcel zzu = zzu();
        zzu.writeInt(22);
        zzu.writeString(str);
        zzx.zzc(zzu, bundle);
        zzu.writeStrongBinder(zzfVar);
        zzx(1801, zzu);
    }

    public final void zzo(int i, String str, Bundle bundle, zzh zzhVar) throws RemoteException {
        Parcel zzu = zzu();
        zzu.writeInt(21);
        zzu.writeString(str);
        zzx.zzc(zzu, bundle);
        zzu.writeStrongBinder(zzhVar);
        zzx(1601, zzu);
    }

    public final void zzp(int i, String str, Bundle bundle, zzj zzjVar) throws RemoteException {
        Parcel zzu = zzu();
        zzu.writeInt(18);
        zzu.writeString(str);
        zzx.zzc(zzu, bundle);
        zzu.writeStrongBinder(zzjVar);
        zzw(1301, zzu);
    }

    public final void zzq(int i, String str, Bundle bundle, zzl zzlVar) throws RemoteException {
        Parcel zzu = zzu();
        zzu.writeInt(22);
        zzu.writeString(str);
        zzx.zzc(zzu, bundle);
        zzu.writeStrongBinder(zzlVar);
        zzx(1901, zzu);
    }

    public final void zzr(int i, String str, Bundle bundle, zzn zznVar) throws RemoteException {
        Parcel zzu = zzu();
        zzu.writeInt(21);
        zzu.writeString(str);
        zzx.zzc(zzu, bundle);
        zzu.writeStrongBinder(zznVar);
        zzx(1401, zzu);
    }

    public final void zzs(int i, String str, Bundle bundle, zzp zzpVar) throws RemoteException {
        Parcel zzu = zzu();
        zzu.writeInt(22);
        zzu.writeString(str);
        zzx.zzc(zzu, bundle);
        zzu.writeStrongBinder(zzpVar);
        zzx(1701, zzu);
    }

    public final void zzt(int i, String str, Bundle bundle, zzu zzuVar) throws RemoteException {
        Parcel zzu = zzu();
        zzu.writeInt(12);
        zzu.writeString(str);
        zzx.zzc(zzu, bundle);
        zzu.writeStrongBinder(zzuVar);
        zzw(1201, zzu);
    }

    public final int zzy(int i, String str, String str2) throws RemoteException {
        Parcel zzu = zzu();
        zzu.writeInt(i);
        zzu.writeString(str);
        zzu.writeString(str2);
        Parcel zzv = zzv(1, zzu);
        int readInt = zzv.readInt();
        zzv.recycle();
        return readInt;
    }
}
