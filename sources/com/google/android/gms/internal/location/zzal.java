package com.google.android.gms.internal.location;

import J4.P;
import J4.d;
import J4.h;
import J4.l;
import J4.q;
import android.app.PendingIntent;
import android.location.Location;
import android.os.IBinder;
import android.os.Parcel;
import android.os.RemoteException;
import com.google.android.gms.location.LocationAvailability;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzal extends zza implements zzam {
    public zzal(IBinder iBinder) {
        super(iBinder, "com.google.android.gms.location.internal.IGoogleLocationManagerService");
    }

    public final void zzd(h hVar, PendingIntent pendingIntent, zzak zzakVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, hVar);
        zzc.zzc(zza, pendingIntent);
        zzc.zzd(zza, zzakVar);
        zzx(57, zza);
    }

    public final void zze(PendingIntent pendingIntent, zzak zzakVar, String str) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, pendingIntent);
        zzc.zzd(zza, zzakVar);
        zza.writeString(str);
        zzx(2, zza);
    }

    public final void zzf(String[] strArr, zzak zzakVar, String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeStringArray(strArr);
        zzc.zzd(zza, zzakVar);
        zza.writeString(str);
        zzx(3, zza);
    }

    public final void zzg(P p, zzak zzakVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, p);
        zzc.zzd(zza, zzakVar);
        zzx(74, zza);
    }

    public final void zzh(long j, boolean z, PendingIntent pendingIntent) throws RemoteException {
        Parcel zza = zza();
        zza.writeLong(j);
        zzc.zza(zza, true);
        zzc.zzc(zza, pendingIntent);
        zzx(5, zza);
    }

    public final void zzi(d dVar, PendingIntent pendingIntent, com.google.android.gms.common.api.internal.h hVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, dVar);
        zzc.zzc(zza, pendingIntent);
        zzc.zzd(zza, hVar);
        zzx(72, zza);
    }

    public final void zzj(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.h hVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, pendingIntent);
        zzc.zzd(zza, hVar);
        zzx(73, zza);
    }

    public final void zzk(PendingIntent pendingIntent) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, pendingIntent);
        zzx(6, zza);
    }

    public final void zzl(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.h hVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, pendingIntent);
        zzc.zzd(zza, hVar);
        zzx(69, zza);
    }

    public final Location zzm() throws RemoteException {
        Parcel zzw = zzw(7, zza());
        Location zzb = zzc.zzb(zzw, Location.CREATOR);
        zzw.recycle();
        return zzb;
    }

    public final Location zzn(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzw = zzw(80, zza);
        Location zzb = zzc.zzb(zzw, Location.CREATOR);
        zzw.recycle();
        return zzb;
    }

    public final void zzo(zzbc zzbcVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzbcVar);
        zzx(59, zza);
    }

    public final void zzp(boolean z) throws RemoteException {
        Parcel zza = zza();
        zzc.zza(zza, z);
        zzx(12, zza);
    }

    public final void zzq(Location location) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, location);
        zzx(13, zza);
    }

    public final void zzr(zzai zzaiVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzd(zza, zzaiVar);
        zzx(67, zza);
    }

    public final LocationAvailability zzs(String str) throws RemoteException {
        Parcel zza = zza();
        zza.writeString(str);
        Parcel zzw = zzw(34, zza);
        LocationAvailability locationAvailability = (LocationAvailability) zzc.zzb(zzw, LocationAvailability.CREATOR);
        zzw.recycle();
        return locationAvailability;
    }

    public final void zzt(l lVar, zzao zzaoVar, String str) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, lVar);
        zzc.zzd(zza, zzaoVar);
        zza.writeString((String) null);
        zzx(63, zza);
    }

    public final void zzu(zzl zzlVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, zzlVar);
        zzx(75, zza);
    }

    public final void zzv(PendingIntent pendingIntent, q qVar, com.google.android.gms.common.api.internal.h hVar) throws RemoteException {
        Parcel zza = zza();
        zzc.zzc(zza, pendingIntent);
        zzc.zzc(zza, qVar);
        zzc.zzd(zza, hVar);
        zzx(79, zza);
    }
}
