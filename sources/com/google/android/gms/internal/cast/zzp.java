package com.google.android.gms.internal.cast;

import C4.e;
import C4.h;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.internal.r;
import j$.util.DesugarCollections;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;
import t4.b;
import u0.L;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzp {
    private static final b zza = new b("DialogDiscovery");
    private static final String zzb = "21.3.0";
    private static zzp zzc;
    private final zzf zzd;
    private final String zze;
    private String zzi;
    private final Map zzg = DesugarCollections.synchronizedMap(new HashMap());
    private int zzp = 1;
    private long zzj = 1;
    private long zzk = 1;
    private long zzl = -1;
    private int zzm = -1;
    private int zzn = 0;
    private int zzo = 0;
    private final zzn zzf = new zzn(this);
    private final e zzh = h.c();

    private zzp(zzf zzfVar, String str) {
        this.zzd = zzfVar;
        this.zze = str;
    }

    public static zzv zza() {
        zzp zzpVar = zzc;
        if (zzpVar == null) {
            return null;
        }
        return zzpVar.zzf;
    }

    public static /* bridge */ /* synthetic */ void zzb(zzp zzpVar, int i) {
        zzpVar.zzl(1);
    }

    public static /* bridge */ /* synthetic */ void zzc(zzp zzpVar) {
        zzpVar.zzd.zzd(zzpVar.zzj(null), 354);
    }

    public static /* bridge */ /* synthetic */ void zzd(zzp zzpVar, L.h hVar) {
        zzpVar.zzm(hVar);
    }

    public static /* bridge */ /* synthetic */ void zze(zzp zzpVar, List list) {
        zzpVar.zzn(list);
    }

    public static /* bridge */ /* synthetic */ void zzf(zzp zzpVar) {
        zzpVar.zzo();
    }

    public static void zzg(zzf zzfVar, String str) {
        if (zzc == null) {
            zzc = new zzp(zzfVar, str);
        }
    }

    private final long zzh() {
        return this.zzh.a();
    }

    private final zzo zzi(L.h hVar) {
        String str;
        String str2;
        CastDevice K = CastDevice.K(hVar.i());
        if (K == null || K.H() == null) {
            int i = this.zzn;
            this.zzn = i + 1;
            str = "UNKNOWN_DEVICE_ID" + i;
        } else {
            str = K.H();
        }
        if (K == null || K.zzc() == null) {
            int i2 = this.zzo;
            this.zzo = i2 + 1;
            str2 = "UNKNOWN_RECEIVER_METRICS_ID" + i2;
        } else {
            str2 = K.zzc();
        }
        if (!str.startsWith("UNKNOWN_DEVICE_ID") && this.zzg.containsKey(str)) {
            return (zzo) this.zzg.get(str);
        }
        zzo zzoVar = new zzo((String) r.m(str2), zzh());
        this.zzg.put(str, zzoVar);
        return zzoVar;
    }

    private final zzmq zzj(zzmt zzmtVar) {
        zzmf zza2 = zzmg.zza();
        zza2.zzb(zzb);
        zza2.zza(this.zze);
        zzmg zzmgVar = (zzmg) zza2.zzp();
        zzmp zzc2 = zzmq.zzc();
        zzc2.zzb(zzmgVar);
        if (zzmtVar != null) {
            o4.b d = o4.b.d();
            boolean z = false;
            if (d != null && d.a().R()) {
                z = true;
            }
            zzmtVar.zzh(z);
            zzmtVar.zzd(this.zzj);
            zzc2.zzg(zzmtVar);
        }
        return (zzmq) zzc2.zzp();
    }

    private final void zzk() {
        this.zzg.clear();
        this.zzi = "";
        this.zzj = -1L;
        this.zzk = -1L;
        this.zzl = -1L;
        this.zzm = -1;
        this.zzn = 0;
        this.zzo = 0;
        this.zzp = 1;
    }

    private final synchronized void zzl(int i) {
        zzk();
        this.zzi = UUID.randomUUID().toString();
        this.zzj = zzh();
        this.zzm = 1;
        this.zzp = 2;
        zzmt zza2 = zzmu.zza();
        zza2.zzg(this.zzi);
        zza2.zzd(this.zzj);
        zza2.zzb(1);
        this.zzd.zzd(zzj(zza2), 351);
    }

    private final synchronized void zzm(L.h hVar) {
        if (this.zzp == 1) {
            this.zzd.zzd(zzj(null), 353);
            return;
        }
        this.zzp = 4;
        zzmt zza2 = zzmu.zza();
        zza2.zzg(this.zzi);
        zza2.zzd(this.zzj);
        zza2.zze(this.zzk);
        zza2.zzf(this.zzl);
        zza2.zzb(this.zzm);
        zza2.zzc(zzh());
        ArrayList arrayList = new ArrayList();
        for (zzo zzoVar : this.zzg.values()) {
            zzmr zza3 = zzms.zza();
            zza3.zzb(zzoVar.zza);
            zza3.zza(zzoVar.zzb);
            arrayList.add((zzms) zza3.zzp());
        }
        zza2.zza(arrayList);
        if (hVar != null) {
            zza2.zzi(zzi(hVar).zza);
        }
        zzmq zzj = zzj(zza2);
        zzk();
        zza.a("logging ClientDiscoverySessionSummary. Device Count: " + this.zzg.size(), new Object[0]);
        this.zzd.zzd(zzj, 353);
    }

    private final synchronized void zzn(List list) {
        try {
            if (this.zzp != 2) {
                return;
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                zzi((L.h) it.next());
            }
            if (this.zzl < 0) {
                this.zzl = zzh();
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    private final synchronized void zzo() {
        if (this.zzp != 2) {
            this.zzd.zzd(zzj(null), 352);
            return;
        }
        this.zzk = zzh();
        this.zzp = 3;
        zzmt zza2 = zzmu.zza();
        zza2.zzg(this.zzi);
        zza2.zze(this.zzk);
        this.zzd.zzd(zzj(zza2), 352);
    }
}
