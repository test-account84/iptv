package com.google.android.gms.internal.measurement;

import C4.e;
import C4.h;
import M4.O2;
import M4.P2;
import M4.d2;
import M4.z3;
import android.app.Activity;
import android.app.Application;
import android.content.Context;
import android.os.BadParcelableException;
import android.os.Bundle;
import android.os.NetworkOnMainThreadException;
import android.os.RemoteException;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.dynamite.DynamiteModule;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.List;
import java.util.Map;
import java.util.Random;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.LinkedBlockingQueue;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzef {
    private static volatile zzef zzc;
    protected final e zza;
    protected final ExecutorService zzb;
    private final String zzd;
    private final L4.a zze;
    private final List zzf;
    private int zzg;
    private boolean zzh;
    private final String zzi;
    private volatile zzcc zzj;

    public zzef(Context context, String str, String str2, String str3, Bundle bundle) {
        this.zzd = (str == null || !zzW(str2, str3)) ? "FA" : str;
        this.zza = h.c();
        zzbx.zza();
        ThreadPoolExecutor threadPoolExecutor = new ThreadPoolExecutor(1, 1, 60L, TimeUnit.SECONDS, new LinkedBlockingQueue(), new zzdi(this));
        threadPoolExecutor.allowCoreThreadTimeOut(true);
        this.zzb = Executors.unconfigurableExecutorService(threadPoolExecutor);
        this.zze = new L4.a(this);
        this.zzf = new ArrayList();
        try {
            if (z3.b(context, "google_app_id", d2.a(context)) != null && !zzS()) {
                this.zzi = null;
                this.zzh = true;
                Log.w(this.zzd, "Disabling data collection. Found google_app_id in strings.xml but Google Analytics for Firebase is missing. Remove this value or add Google Analytics for Firebase to resume data collection.");
                return;
            }
        } catch (IllegalStateException unused) {
        }
        if (zzW(str2, str3)) {
            this.zzi = str2;
        } else {
            this.zzi = "fa";
            if (str2 == null || str3 == null) {
                if ((str2 == null) ^ (str3 == null)) {
                    Log.w(this.zzd, "Specified origin or custom app id is null. Both parameters will be ignored.");
                }
            } else {
                Log.v(this.zzd, "Deferring to Google Analytics for Firebase for event data collection. https://firebase.google.com/docs/analytics");
            }
        }
        zzV(new zzcx(this, str2, str3, context, bundle));
        Application applicationContext = context.getApplicationContext();
        if (applicationContext == null) {
            Log.w(this.zzd, "Unable to register lifecycle notifications. Application null.");
        } else {
            applicationContext.registerActivityLifecycleCallbacks(new zzee(this));
        }
    }

    public static /* bridge */ /* synthetic */ boolean zzQ(zzef zzefVar) {
        return zzefVar.zzh;
    }

    public static /* bridge */ /* synthetic */ boolean zzR(zzef zzefVar, String str, String str2) {
        return zzefVar.zzW(str, str2);
    }

    private final void zzT(Exception exc, boolean z, boolean z2) {
        this.zzh |= z;
        if (z) {
            Log.w(this.zzd, "Data collection startup failed. No data will be collected.", exc);
            return;
        }
        if (z2) {
            zzB(5, "Error with data collection. Data lost.", exc, null, null);
        }
        Log.w(this.zzd, "Error with data collection. Data lost.", exc);
    }

    private final void zzU(String str, String str2, Bundle bundle, boolean z, boolean z2, Long l) {
        zzV(new zzds(this, l, str, str2, bundle, z, z2));
    }

    private final void zzV(zzdu zzduVar) {
        this.zzb.execute(zzduVar);
    }

    private final boolean zzW(String str, String str2) {
        return (str2 == null || str == null || zzS()) ? false : true;
    }

    public static /* bridge */ /* synthetic */ zzcc zze(zzef zzefVar) {
        return zzefVar.zzj;
    }

    public static zzef zzg(Context context, String str, String str2, String str3, Bundle bundle) {
        r.m(context);
        if (zzc == null) {
            synchronized (zzef.class) {
                try {
                    if (zzc == null) {
                        zzc = new zzef(context, str, str2, str3, bundle);
                    }
                } finally {
                }
            }
        }
        return zzc;
    }

    public static /* bridge */ /* synthetic */ String zzj(zzef zzefVar) {
        return zzefVar.zzd;
    }

    public static /* bridge */ /* synthetic */ void zzs(zzef zzefVar, zzcc zzccVar) {
        zzefVar.zzj = zzccVar;
    }

    public static /* bridge */ /* synthetic */ void zzt(zzef zzefVar, Exception exc, boolean z, boolean z2) {
        zzefVar.zzT(exc, z, z2);
    }

    public static /* bridge */ /* synthetic */ void zzu(zzef zzefVar, zzdu zzduVar) {
        zzefVar.zzV(zzduVar);
    }

    public final void zzA(String str, String str2, Bundle bundle, long j) {
        zzU(str, str2, bundle, true, false, Long.valueOf(j));
    }

    public final void zzB(int i, String str, Object obj, Object obj2, Object obj3) {
        zzV(new zzdg(this, false, 5, str, obj, null, null));
    }

    public final void zzC(P2 p2) {
        r.m(p2);
        synchronized (this.zzf) {
            for (int i = 0; i < this.zzf.size(); i++) {
                try {
                    if (p2.equals(((Pair) this.zzf.get(i)).first)) {
                        Log.w(this.zzd, "OnEventListener already registered.");
                        return;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            zzdw zzdwVar = new zzdw(p2);
            this.zzf.add(new Pair(p2, zzdwVar));
            if (this.zzj != null) {
                try {
                    this.zzj.registerOnMeasurementEventListener(zzdwVar);
                    return;
                } catch (RemoteException | BadParcelableException | IllegalArgumentException | IllegalStateException | NetworkOnMainThreadException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(this.zzd, "Failed to register event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            zzV(new zzdq(this, zzdwVar));
        }
    }

    public final void zzD() {
        zzV(new zzcv(this));
    }

    public final void zzE(Bundle bundle) {
        zzV(new zzcn(this, bundle));
    }

    public final void zzF(Bundle bundle) {
        zzV(new zzct(this, bundle));
    }

    public final void zzG(Bundle bundle) {
        zzV(new zzcu(this, bundle));
    }

    public final void zzH(Activity activity, String str, String str2) {
        zzV(new zzcr(this, activity, str, str2));
    }

    public final void zzI(boolean z) {
        zzV(new zzdn(this, z));
    }

    public final void zzJ(Bundle bundle) {
        zzV(new zzdo(this, bundle));
    }

    public final void zzK(O2 o2) {
        zzdv zzdvVar = new zzdv(o2);
        if (this.zzj != null) {
            try {
                this.zzj.setEventInterceptor(zzdvVar);
                return;
            } catch (RemoteException | BadParcelableException | IllegalArgumentException | IllegalStateException | NetworkOnMainThreadException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                Log.w(this.zzd, "Failed to set event interceptor on calling thread. Trying again on the dynamite thread.");
            }
        }
        zzV(new zzdp(this, zzdvVar));
    }

    public final void zzL(Boolean bool) {
        zzV(new zzcs(this, bool));
    }

    public final void zzM(long j) {
        zzV(new zzcw(this, j));
    }

    public final void zzN(String str) {
        zzV(new zzcq(this, str));
    }

    public final void zzO(String str, String str2, Object obj, boolean z) {
        zzV(new zzdt(this, str, str2, obj, z));
    }

    public final void zzP(P2 p2) {
        Pair pair;
        r.m(p2);
        synchronized (this.zzf) {
            int i = 0;
            while (true) {
                try {
                    if (i >= this.zzf.size()) {
                        pair = null;
                        break;
                    } else {
                        if (p2.equals(((Pair) this.zzf.get(i)).first)) {
                            pair = (Pair) this.zzf.get(i);
                            break;
                        }
                        i++;
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
            if (pair == null) {
                Log.w(this.zzd, "OnEventListener had not been registered.");
                return;
            }
            this.zzf.remove(pair);
            zzdw zzdwVar = (zzdw) pair.second;
            if (this.zzj != null) {
                try {
                    this.zzj.unregisterOnMeasurementEventListener(zzdwVar);
                    return;
                } catch (RemoteException | BadParcelableException | IllegalArgumentException | IllegalStateException | NetworkOnMainThreadException | NullPointerException | SecurityException | UnsupportedOperationException unused) {
                    Log.w(this.zzd, "Failed to unregister event listener on calling thread. Trying again on the dynamite thread.");
                }
            }
            zzV(new zzdr(this, zzdwVar));
        }
    }

    public final boolean zzS() {
        try {
            Class.forName("com.google.firebase.analytics.FirebaseAnalytics", false, zzef.class.getClassLoader());
            return true;
        } catch (ClassNotFoundException unused) {
            return false;
        }
    }

    public final int zza(String str) {
        zzbz zzbzVar = new zzbz();
        zzV(new zzdj(this, str, zzbzVar));
        Integer num = (Integer) zzbz.zzf(zzbzVar.zzb(10000L), Integer.class);
        if (num == null) {
            return 25;
        }
        return num.intValue();
    }

    public final long zzb() {
        zzbz zzbzVar = new zzbz();
        zzV(new zzdc(this, zzbzVar));
        Long zzc2 = zzbzVar.zzc(500L);
        if (zzc2 != null) {
            return zzc2.longValue();
        }
        long nextLong = new Random(System.nanoTime() ^ this.zza.a()).nextLong();
        int i = this.zzg + 1;
        this.zzg = i;
        return nextLong + i;
    }

    public final Bundle zzc(Bundle bundle, boolean z) {
        zzbz zzbzVar = new zzbz();
        zzV(new zzdh(this, bundle, zzbzVar));
        if (z) {
            return zzbzVar.zzb(5000L);
        }
        return null;
    }

    public final L4.a zzd() {
        return this.zze;
    }

    public final zzcc zzf(Context context, boolean z) {
        try {
            return zzcb.asInterface(DynamiteModule.e(context, DynamiteModule.e, "com.google.android.gms.measurement.dynamite").d("com.google.android.gms.measurement.internal.AppMeasurementDynamiteService"));
        } catch (DynamiteModule.a e) {
            zzT(e, true, false);
            return null;
        }
    }

    public final Long zzh() {
        zzbz zzbzVar = new zzbz();
        zzV(new zzdl(this, zzbzVar));
        return zzbzVar.zzc(120000L);
    }

    public final Object zzi(int i) {
        zzbz zzbzVar = new zzbz();
        zzV(new zzdm(this, zzbzVar, i));
        return zzbz.zzf(zzbzVar.zzb(15000L), Object.class);
    }

    public final String zzk() {
        return this.zzi;
    }

    public final String zzl() {
        zzbz zzbzVar = new zzbz();
        zzV(new zzdk(this, zzbzVar));
        return zzbzVar.zzd(120000L);
    }

    public final String zzm() {
        zzbz zzbzVar = new zzbz();
        zzV(new zzdb(this, zzbzVar));
        return zzbzVar.zzd(50L);
    }

    public final String zzn() {
        zzbz zzbzVar = new zzbz();
        zzV(new zzde(this, zzbzVar));
        return zzbzVar.zzd(500L);
    }

    public final String zzo() {
        zzbz zzbzVar = new zzbz();
        zzV(new zzdd(this, zzbzVar));
        return zzbzVar.zzd(500L);
    }

    public final String zzp() {
        zzbz zzbzVar = new zzbz();
        zzV(new zzda(this, zzbzVar));
        return zzbzVar.zzd(500L);
    }

    public final List zzq(String str, String str2) {
        zzbz zzbzVar = new zzbz();
        zzV(new zzcp(this, str, str2, zzbzVar));
        List list = (List) zzbz.zzf(zzbzVar.zzb(5000L), List.class);
        return list == null ? Collections.emptyList() : list;
    }

    public final Map zzr(String str, String str2, boolean z) {
        zzbz zzbzVar = new zzbz();
        zzV(new zzdf(this, str, str2, z, zzbzVar));
        Bundle zzb = zzbzVar.zzb(5000L);
        if (zzb == null || zzb.size() == 0) {
            return Collections.emptyMap();
        }
        HashMap hashMap = new HashMap(zzb.size());
        for (String str3 : zzb.keySet()) {
            Object obj = zzb.get(str3);
            if ((obj instanceof Double) || (obj instanceof Long) || (obj instanceof String)) {
                hashMap.put(str3, obj);
            }
        }
        return hashMap;
    }

    public final void zzv(String str) {
        zzV(new zzcy(this, str));
    }

    public final void zzw(String str, String str2, Bundle bundle) {
        zzV(new zzco(this, str, str2, bundle));
    }

    public final void zzx(String str) {
        zzV(new zzcz(this, str));
    }

    public final void zzy(String str, Bundle bundle) {
        zzU(null, str, bundle, false, true, null);
    }

    public final void zzz(String str, String str2, Bundle bundle) {
        zzU(str, str2, bundle, true, true, null);
    }
}
