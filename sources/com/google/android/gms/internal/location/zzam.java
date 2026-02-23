package com.google.android.gms.internal.location;

import J4.P;
import J4.d;
import J4.h;
import J4.l;
import J4.q;
import android.app.PendingIntent;
import android.location.Location;
import android.os.IInterface;
import android.os.RemoteException;
import com.google.android.gms.location.LocationAvailability;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public interface zzam extends IInterface {
    void zzd(h hVar, PendingIntent pendingIntent, zzak zzakVar) throws RemoteException;

    void zze(PendingIntent pendingIntent, zzak zzakVar, String str) throws RemoteException;

    void zzf(String[] strArr, zzak zzakVar, String str) throws RemoteException;

    void zzg(P p, zzak zzakVar) throws RemoteException;

    void zzh(long j, boolean z, PendingIntent pendingIntent) throws RemoteException;

    void zzi(d dVar, PendingIntent pendingIntent, com.google.android.gms.common.api.internal.h hVar) throws RemoteException;

    void zzj(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.h hVar) throws RemoteException;

    void zzk(PendingIntent pendingIntent) throws RemoteException;

    void zzl(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.h hVar) throws RemoteException;

    @Deprecated
    Location zzm() throws RemoteException;

    Location zzn(String str) throws RemoteException;

    void zzo(zzbc zzbcVar) throws RemoteException;

    void zzp(boolean z) throws RemoteException;

    void zzq(Location location) throws RemoteException;

    void zzr(zzai zzaiVar) throws RemoteException;

    LocationAvailability zzs(String str) throws RemoteException;

    void zzt(l lVar, zzao zzaoVar, String str) throws RemoteException;

    void zzu(zzl zzlVar) throws RemoteException;

    void zzv(PendingIntent pendingIntent, q qVar, com.google.android.gms.common.api.internal.h hVar) throws RemoteException;
}
