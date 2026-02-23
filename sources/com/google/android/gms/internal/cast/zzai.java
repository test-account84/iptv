package com.google.android.gms.internal.cast;

import F4.a;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import java.util.Map;
import o4.D;
import o4.E;
import o4.I;
import o4.J;
import o4.L;
import o4.M;
import o4.V;
import o4.c;
import o4.t0;
import o4.v0;
import o4.w0;
import q4.h;
import q4.i;
import q4.k;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzai extends zza implements zzaj {
    public zzai(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.cast.framework.internal.ICastDynamiteModule");
    }

    public final w0 zze(a aVar, c cVar, zzal zzalVar, Map map) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, aVar);
        zzc.zzc(zza, cVar);
        zzc.zze(zza, zzalVar);
        zza.writeMap(map);
        Parcel zzb = zzb(1, zza);
        w0 A = v0.A(zzb.readStrongBinder());
        zzb.recycle();
        return A;
    }

    public final E zzf(c cVar, a aVar, t0 t0Var) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, cVar);
        zzc.zze(zza, aVar);
        zzc.zze(zza, t0Var);
        Parcel zzb = zzb(3, zza);
        E A = D.A(zzb.readStrongBinder());
        zzb.recycle();
        return A;
    }

    public final J zzg(a aVar, a aVar2, a aVar3) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, aVar);
        zzc.zze(zza, aVar2);
        zzc.zze(zza, aVar3);
        Parcel zzb = zzb(5, zza);
        J A = I.A(zzb.readStrongBinder());
        zzb.recycle();
        return A;
    }

    public final M zzh(String str, String str2, V v) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        zza.writeString(str2);
        zzc.zze(zza, v);
        Parcel zzb = zzb(2, zza);
        M A = L.A(zzb.readStrongBinder());
        zzb.recycle();
        return A;
    }

    public final i zzi(a aVar, k kVar, int i, int i2, boolean z, long j, int i3, int i4, int i5) throws RemoteException {
        Parcel zza = zza();
        zzc.zze(zza, aVar);
        zzc.zze(zza, kVar);
        zza.writeInt(i);
        zza.writeInt(i2);
        zza.writeInt(0);
        zza.writeLong(2097152L);
        zza.writeInt(5);
        zza.writeInt(333);
        zza.writeInt(10000);
        Parcel zzb = zzb(6, zza);
        i A = h.A(zzb.readStrongBinder());
        zzb.recycle();
        return A;
    }
}
