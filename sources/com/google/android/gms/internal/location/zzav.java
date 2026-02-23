package com.google.android.gms.internal.location;

import android.app.PendingIntent;
import android.content.Context;
import android.location.Location;
import android.os.IBinder;
import android.os.RemoteException;
import com.google.android.gms.common.api.internal.k;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.location.LocationAvailability;
import com.google.android.gms.location.LocationRequest;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzav {
    private final zzbg zza;
    private final Context zzb;
    private boolean zzc = false;
    private final Map zzd = new HashMap();
    private final Map zze = new HashMap();
    private final Map zzf = new HashMap();

    public zzav(Context context, zzbg zzbgVar) {
        this.zzb = context;
        this.zza = zzbgVar;
    }

    public final Location zza(String str) throws RemoteException {
        zzi.zzp(((zzh) this.zza).zza);
        return ((zzh) this.zza).zza().zzn(str);
    }

    @Deprecated
    public final Location zzb() throws RemoteException {
        zzi.zzp(((zzh) this.zza).zza);
        return ((zzh) this.zza).zza().zzm();
    }

    public final LocationAvailability zzc() throws RemoteException {
        zzi.zzp(((zzh) this.zza).zza);
        return ((zzh) this.zza).zza().zzs(this.zzb.getPackageName());
    }

    public final void zzd(LocationRequest locationRequest, k kVar, zzai zzaiVar) throws RemoteException {
        IBinder iBinder;
        IBinder iBinder2;
        zzi.zzp(((zzh) this.zza).zza);
        k.a b = kVar.b();
        if (b == null) {
            iBinder2 = null;
        } else {
            synchronized (this.zzd) {
                try {
                    iBinder = (zzau) this.zzd.get(b);
                    if (iBinder == null) {
                        iBinder = new zzau(kVar);
                    }
                    this.zzd.put(b, iBinder);
                } catch (Throwable th) {
                    throw th;
                }
            }
            iBinder2 = iBinder;
        }
        if (iBinder2 == null) {
            return;
        }
        ((zzh) this.zza).zza().zzo(new zzbc(1, zzba.zza(null, locationRequest), iBinder2, null, null, zzaiVar));
    }

    public final void zze(zzba zzbaVar, k kVar, zzai zzaiVar) throws RemoteException {
        IBinder iBinder;
        zzi.zzp(((zzh) this.zza).zza);
        k.a b = kVar.b();
        if (b == null) {
            iBinder = null;
        } else {
            synchronized (this.zzf) {
                try {
                    IBinder iBinder2 = (zzar) this.zzf.get(b);
                    if (iBinder2 == null) {
                        iBinder2 = new zzar(kVar);
                    }
                    iBinder = iBinder2;
                    this.zzf.put(b, iBinder);
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
        IBinder iBinder3 = iBinder;
        if (iBinder3 == null) {
            return;
        }
        ((zzh) this.zza).zza().zzo(new zzbc(1, zzbaVar, null, null, iBinder3, zzaiVar));
    }

    public final void zzf(zzba zzbaVar, PendingIntent pendingIntent, zzai zzaiVar) throws RemoteException {
        zzi.zzp(((zzh) this.zza).zza);
        ((zzh) this.zza).zza().zzo(zzbc.zzb(zzbaVar, pendingIntent, zzaiVar));
    }

    public final void zzg(LocationRequest locationRequest, PendingIntent pendingIntent, zzai zzaiVar) throws RemoteException {
        zzi.zzp(((zzh) this.zza).zza);
        ((zzh) this.zza).zza().zzo(zzbc.zzb(zzba.zza(null, locationRequest), pendingIntent, zzaiVar));
    }

    public final void zzh(k.a aVar, zzai zzaiVar) throws RemoteException {
        zzi.zzp(((zzh) this.zza).zza);
        r.n(aVar, "Invalid null listener key");
        synchronized (this.zzd) {
            try {
                zzau zzauVar = (zzau) this.zzd.remove(aVar);
                if (zzauVar != null) {
                    zzauVar.zzc();
                    ((zzh) this.zza).zza().zzo(zzbc.zza(zzauVar, zzaiVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzi(k.a aVar, zzai zzaiVar) throws RemoteException {
        zzi.zzp(((zzh) this.zza).zza);
        r.n(aVar, "Invalid null listener key");
        synchronized (this.zzf) {
            try {
                zzar zzarVar = (zzar) this.zzf.remove(aVar);
                if (zzarVar != null) {
                    zzarVar.zzc();
                    ((zzh) this.zza).zza().zzo(zzbc.zzc(zzarVar, zzaiVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void zzj(PendingIntent pendingIntent, zzai zzaiVar) throws RemoteException {
        zzi.zzp(((zzh) this.zza).zza);
        ((zzh) this.zza).zza().zzo(new zzbc(2, null, null, pendingIntent, null, zzaiVar));
    }

    public final void zzk(boolean z) throws RemoteException {
        zzi.zzp(((zzh) this.zza).zza);
        ((zzh) this.zza).zza().zzp(z);
        this.zzc = z;
    }

    public final void zzl(Location location) throws RemoteException {
        zzi.zzp(((zzh) this.zza).zza);
        ((zzh) this.zza).zza().zzq(location);
    }

    public final void zzm(zzai zzaiVar) throws RemoteException {
        zzi.zzp(((zzh) this.zza).zza);
        ((zzh) this.zza).zza().zzr(zzaiVar);
    }

    public final void zzn() throws RemoteException {
        synchronized (this.zzd) {
            try {
                for (zzau zzauVar : this.zzd.values()) {
                    if (zzauVar != null) {
                        ((zzh) this.zza).zza().zzo(zzbc.zza(zzauVar, null));
                    }
                }
                this.zzd.clear();
            } finally {
            }
        }
        synchronized (this.zzf) {
            try {
                for (zzar zzarVar : this.zzf.values()) {
                    if (zzarVar != null) {
                        ((zzh) this.zza).zza().zzo(zzbc.zzc(zzarVar, null));
                    }
                }
                this.zzf.clear();
            } finally {
            }
        }
        synchronized (this.zze) {
            try {
                for (zzas zzasVar : this.zze.values()) {
                    if (zzasVar != null) {
                        ((zzh) this.zza).zza().zzu(new zzl(2, null, zzasVar, null));
                    }
                }
                this.zze.clear();
            } finally {
            }
        }
    }

    public final void zzo() throws RemoteException {
        if (this.zzc) {
            zzk(false);
        }
    }
}
