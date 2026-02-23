package com.google.android.gms.internal.location;

import C4.b;
import J4.P;
import J4.a0;
import J4.d;
import J4.h;
import J4.l;
import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.Looper;
import android.os.RemoteException;
import android.util.Log;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.internal.e;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzaz extends zzi {
    private final zzav zzf;

    public zzaz(Context context, Looper looper, GoogleApiClient.b bVar, GoogleApiClient.c cVar, String str, e eVar) {
        super(context, looper, bVar, cVar, str, eVar);
        this.zzf = new zzav(context, this.zze);
    }

    public final void disconnect() {
        synchronized (this.zzf) {
            if (isConnected()) {
                try {
                    this.zzf.zzn();
                    this.zzf.zzo();
                } catch (Exception e) {
                    Log.e("LocationClientImpl", "Client disconnected before listeners could be cleaned up", e);
                }
                super.disconnect();
            } else {
                super.disconnect();
            }
        }
    }

    public final boolean usesClientTelemetry() {
        return true;
    }

    public final LocationAvailability zzA() throws RemoteException {
        return this.zzf.zzc();
    }

    public final void zzB(zzba zzbaVar, k kVar, zzai zzaiVar) throws RemoteException {
        synchronized (this.zzf) {
            this.zzf.zze(zzbaVar, kVar, zzaiVar);
        }
    }

    public final void zzC(LocationRequest locationRequest, k kVar, zzai zzaiVar) throws RemoteException {
        synchronized (this.zzf) {
            this.zzf.zzd(locationRequest, kVar, zzaiVar);
        }
    }

    public final void zzD(zzba zzbaVar, PendingIntent pendingIntent, zzai zzaiVar) throws RemoteException {
        this.zzf.zzf(zzbaVar, pendingIntent, zzaiVar);
    }

    public final void zzE(LocationRequest locationRequest, PendingIntent pendingIntent, zzai zzaiVar) throws RemoteException {
        this.zzf.zzg(locationRequest, pendingIntent, zzaiVar);
    }

    public final void zzF(k.a aVar, zzai zzaiVar) throws RemoteException {
        this.zzf.zzh(aVar, zzaiVar);
    }

    public final void zzG(PendingIntent pendingIntent, zzai zzaiVar) throws RemoteException {
        this.zzf.zzj(pendingIntent, zzaiVar);
    }

    public final void zzH(k.a aVar, zzai zzaiVar) throws RemoteException {
        this.zzf.zzi(aVar, zzaiVar);
    }

    public final void zzI(boolean z) throws RemoteException {
        this.zzf.zzk(z);
    }

    public final void zzJ(Location location) throws RemoteException {
        this.zzf.zzl(location);
    }

    public final void zzK(zzai zzaiVar) throws RemoteException {
        this.zzf.zzm(zzaiVar);
    }

    public final void zzL(l lVar, com.google.android.gms.common.api.internal.e eVar, String str) throws RemoteException {
        checkConnected();
        r.b(lVar != null, "locationSettingsRequest can't be null nor empty.");
        r.b(eVar != null, "listener can't be null.");
        ((zzam) getService()).zzt(lVar, new zzay(eVar), null);
    }

    public final void zzq(long j, PendingIntent pendingIntent) throws RemoteException {
        checkConnected();
        r.m(pendingIntent);
        r.b(j >= 0, "detectionIntervalMillis must be >= 0");
        ((zzam) getService()).zzh(j, true, pendingIntent);
    }

    public final void zzr(d dVar, PendingIntent pendingIntent, com.google.android.gms.common.api.internal.e eVar) throws RemoteException {
        checkConnected();
        r.n(dVar, "activityTransitionRequest must be specified.");
        r.n(pendingIntent, "PendingIntent must be specified.");
        r.n(eVar, "ResultHolder not provided.");
        ((zzam) getService()).zzi(dVar, pendingIntent, new com.google.android.gms.common.api.internal.r(eVar));
    }

    public final void zzs(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.e eVar) throws RemoteException {
        checkConnected();
        r.n(eVar, "ResultHolder not provided.");
        ((zzam) getService()).zzj(pendingIntent, new com.google.android.gms.common.api.internal.r(eVar));
    }

    public final void zzt(PendingIntent pendingIntent) throws RemoteException {
        checkConnected();
        r.m(pendingIntent);
        ((zzam) getService()).zzk(pendingIntent);
    }

    public final void zzu(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.e eVar) throws RemoteException {
        checkConnected();
        r.n(pendingIntent, "PendingIntent must be specified.");
        r.n(eVar, "ResultHolder not provided.");
        ((zzam) getService()).zzl(pendingIntent, new com.google.android.gms.common.api.internal.r(eVar));
    }

    public final void zzv(h hVar, PendingIntent pendingIntent, com.google.android.gms.common.api.internal.e eVar) throws RemoteException {
        checkConnected();
        r.n(hVar, "geofencingRequest can't be null.");
        r.n(pendingIntent, "PendingIntent must be specified.");
        r.n(eVar, "ResultHolder not provided.");
        ((zzam) getService()).zzd(hVar, pendingIntent, new zzaw(eVar));
    }

    public final void zzw(P p, com.google.android.gms.common.api.internal.e eVar) throws RemoteException {
        checkConnected();
        r.n(p, "removeGeofencingRequest can't be null.");
        r.n(eVar, "ResultHolder not provided.");
        ((zzam) getService()).zzg(p, new zzax(eVar));
    }

    public final void zzx(PendingIntent pendingIntent, com.google.android.gms.common.api.internal.e eVar) throws RemoteException {
        checkConnected();
        r.n(pendingIntent, "PendingIntent must be specified.");
        r.n(eVar, "ResultHolder not provided.");
        ((zzam) getService()).zze(pendingIntent, new zzax(eVar), getContext().getPackageName());
    }

    public final void zzy(List list, com.google.android.gms.common.api.internal.e eVar) throws RemoteException {
        checkConnected();
        r.b(list != null && list.size() > 0, "geofenceRequestIds can't be null nor empty.");
        r.n(eVar, "ResultHolder not provided.");
        ((zzam) getService()).zzf((String[]) list.toArray(new String[0]), new zzax(eVar), getContext().getPackageName());
    }

    public final Location zzz(String str) throws RemoteException {
        return b.b(getAvailableFeatures(), a0.c) ? this.zzf.zza(str) : this.zzf.zzb();
    }
}
