package com.google.android.gms.internal.cast;

import android.content.SharedPreferences;
import android.os.Bundle;
import android.os.Handler;
import android.os.Looper;
import android.text.TextUtils;
import com.google.android.gms.cast.CastDevice;
import com.google.android.gms.common.internal.r;
import o4.e;
import org.checkerframework.checker.nullness.qual.EnsuresNonNull;
import org.checkerframework.checker.nullness.qual.EnsuresNonNullIf;
import org.checkerframework.dataflow.qual.Pure;
import t4.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzk {
    private static final b zza = new b("ApplicationAnalytics");
    private final zzf zzb;
    private final zzm zzc;
    private final SharedPreferences zzg;
    private zzl zzh;
    private e zzi;
    private boolean zzj;
    private boolean zzk;
    private final zzh zzd = new zzh(this);
    private final Handler zzf = new zzdy(Looper.getMainLooper());
    private final Runnable zze = new zzg(this);

    public zzk(SharedPreferences sharedPreferences, zzf zzfVar, Bundle bundle, String str) {
        this.zzg = sharedPreferences;
        this.zzb = zzfVar;
        this.zzc = new zzm(bundle, str);
    }

    public static /* bridge */ /* synthetic */ SharedPreferences zza(zzk zzkVar) {
        return zzkVar.zzg;
    }

    public static /* bridge */ /* synthetic */ zzf zzb(zzk zzkVar) {
        return zzkVar.zzb;
    }

    public static /* bridge */ /* synthetic */ zzl zzd(zzk zzkVar) {
        return zzkVar.zzh;
    }

    public static /* bridge */ /* synthetic */ zzm zze(zzk zzkVar) {
        return zzkVar.zzc;
    }

    public static /* bridge */ /* synthetic */ b zzf() {
        return zza;
    }

    public static /* synthetic */ void zzg(zzk zzkVar) {
        zzl zzlVar = zzkVar.zzh;
        if (zzlVar != null) {
            zzkVar.zzb.zzd(zzkVar.zzc.zza(zzlVar), 223);
        }
        zzkVar.zzw();
    }

    public static /* bridge */ /* synthetic */ void zzh(zzk zzkVar, zzl zzlVar) {
        zzkVar.zzh = null;
    }

    public static /* bridge */ /* synthetic */ void zzi(zzk zzkVar, e eVar) {
        zzkVar.zzi = eVar;
    }

    public static /* bridge */ /* synthetic */ void zzj(zzk zzkVar, boolean z) {
        zzkVar.zzk = z;
    }

    public static /* bridge */ /* synthetic */ void zzk(zzk zzkVar) {
        zzkVar.zzt();
    }

    public static /* bridge */ /* synthetic */ void zzl(zzk zzkVar) {
        zzkVar.zzu();
    }

    public static /* bridge */ /* synthetic */ void zzm(zzk zzkVar) {
        zzkVar.zzv();
    }

    public static /* bridge */ /* synthetic */ void zzn(zzk zzkVar, int i) {
        zza.a("log session ended with error = %d", Integer.valueOf(i));
        zzkVar.zzu();
        zzkVar.zzb.zzd(zzkVar.zzc.zze(zzkVar.zzh, i), 228);
        zzkVar.zzt();
        if (zzkVar.zzk) {
            return;
        }
        zzkVar.zzh = null;
    }

    public static /* bridge */ /* synthetic */ void zzo(zzk zzkVar, SharedPreferences sharedPreferences, String str) {
        boolean z = false;
        if (zzkVar.zzz(str)) {
            zza.a("Use the existing ApplicationAnalyticsSession if it is available and valid.", new Object[0]);
            r.m(zzkVar.zzh);
            return;
        }
        zzkVar.zzh = zzl.zzb(sharedPreferences);
        if (zzkVar.zzz(str)) {
            zza.a("Use the restored ApplicationAnalyticsSession if it is valid.", new Object[0]);
            r.m(zzkVar.zzh);
            zzl.zza = zzkVar.zzh.zzd + 1;
            return;
        }
        zza.a("The restored ApplicationAnalyticsSession is not valid, create a new one.", new Object[0]);
        zzl zza2 = zzl.zza(zzkVar.zzj);
        zzkVar.zzh = zza2;
        zzl zzlVar = (zzl) r.m(zza2);
        e eVar = zzkVar.zzi;
        if (eVar != null && eVar.C()) {
            z = true;
        }
        zzlVar.zzj = z;
        ((zzl) r.m(zzkVar.zzh)).zzb = zzs();
        ((zzl) r.m(zzkVar.zzh)).zzf = str;
    }

    public static /* bridge */ /* synthetic */ void zzp(zzk zzkVar) {
        zzkVar.zzh.zzc(zzkVar.zzg);
    }

    public static /* bridge */ /* synthetic */ void zzq(zzk zzkVar) {
        zzkVar.zzw();
    }

    public static /* bridge */ /* synthetic */ void zzr(zzk zzkVar, boolean z) {
        zza.a("update app visibility to %s", true != z ? "foreground" : "background");
        zzkVar.zzj = z;
        zzl zzlVar = zzkVar.zzh;
        if (zzlVar != null) {
            zzlVar.zzi = z;
        }
    }

    @Pure
    private static String zzs() {
        return ((o4.b) r.m(o4.b.d())).a().K();
    }

    private final void zzt() {
        this.zzf.removeCallbacks(this.zze);
    }

    @EnsuresNonNull({"analyticsSession"})
    private final void zzu() {
        if (!zzy()) {
            zza.f("The analyticsSession should not be null for logging. Create a dummy one.", new Object[0]);
            zzv();
            return;
        }
        e eVar = this.zzi;
        CastDevice q = eVar != null ? eVar.q() : null;
        if (q != null && !TextUtils.equals(this.zzh.zzc, q.zzc())) {
            zzx(q);
        }
        r.m(this.zzh);
    }

    @EnsuresNonNull({"analyticsSession"})
    private final void zzv() {
        zza.a("Create a new ApplicationAnalyticsSession based on CastSession", new Object[0]);
        zzl zza2 = zzl.zza(this.zzj);
        this.zzh = zza2;
        zzl zzlVar = (zzl) r.m(zza2);
        e eVar = this.zzi;
        zzlVar.zzj = eVar != null && eVar.C();
        ((zzl) r.m(this.zzh)).zzb = zzs();
        e eVar2 = this.zzi;
        CastDevice q = eVar2 == null ? null : eVar2.q();
        if (q != null) {
            zzx(q);
        }
        zzl zzlVar2 = (zzl) r.m(this.zzh);
        e eVar3 = this.zzi;
        zzlVar2.zzk = eVar3 != null ? eVar3.n() : 0;
        r.m(this.zzh);
    }

    private final void zzw() {
        ((Handler) r.m(this.zzf)).postDelayed((Runnable) r.m(this.zze), 300000L);
    }

    private final void zzx(CastDevice castDevice) {
        zzl zzlVar = this.zzh;
        if (zzlVar == null) {
            return;
        }
        zzlVar.zzc = castDevice.zzc();
        zzlVar.zzg = castDevice.Q();
        zzlVar.zzh = castDevice.M();
    }

    @EnsuresNonNullIf(expression = {"analyticsSession"}, result = true)
    private final boolean zzy() {
        String str;
        if (this.zzh == null) {
            zza.a("The analytics session is null when matching with application ID.", new Object[0]);
            return false;
        }
        String zzs = zzs();
        if (zzs == null || (str = this.zzh.zzb) == null || !TextUtils.equals(str, zzs)) {
            zza.a("The analytics session doesn't match the application ID %s", zzs);
            return false;
        }
        r.m(this.zzh);
        return true;
    }

    private final boolean zzz(String str) {
        String str2;
        if (!zzy()) {
            return false;
        }
        r.m(this.zzh);
        if (str != null && (str2 = this.zzh.zzf) != null && TextUtils.equals(str2, str)) {
            return true;
        }
        zza.a("The analytics session doesn't match the receiver session ID %s.", str);
        return false;
    }

    public final zzh zzc() {
        return this.zzd;
    }
}
