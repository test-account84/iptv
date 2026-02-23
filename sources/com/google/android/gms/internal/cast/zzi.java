package com.google.android.gms.internal.cast;

import com.google.android.gms.common.internal.r;
import com.google.android.gms.common.util.VisibleForTesting;
import o4.e;
import o4.w;
import o4.y;

@VisibleForTesting
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzi implements y {
    final /* synthetic */ zzk zza;

    public zzi(zzk zzkVar) {
        this.zza = zzkVar;
    }

    public final /* bridge */ /* synthetic */ void onSessionEnded(w wVar, int i) {
        zzk.zzi(this.zza, (e) wVar);
        zzk.zzn(this.zza, i);
    }

    public final /* synthetic */ void onSessionEnding(w wVar) {
        zzk.zzi(this.zza, (e) wVar);
    }

    public final /* bridge */ /* synthetic */ void onSessionResumeFailed(w wVar, int i) {
        zzk.zzi(this.zza, (e) wVar);
        zzk.zzn(this.zza, i);
    }

    public final /* bridge */ /* synthetic */ void onSessionResumed(w wVar, boolean z) {
        zzk.zzf().a("onSessionResumed with wasSuspended = %b", Boolean.valueOf(z));
        zzk.zzi(this.zza, (e) wVar);
        zzk.zzl(this.zza);
        r.m(zzk.zzd(this.zza));
        zzk zzkVar = this.zza;
        zzk.zzb(this.zza).zzd(zzk.zze(zzkVar).zzb(zzk.zzd(zzkVar), z), 227);
        zzk.zzp(this.zza);
        zzk.zzq(this.zza);
    }

    public final /* bridge */ /* synthetic */ void onSessionResuming(w wVar, String str) {
        zzk.zzf().a("onSessionResuming with sessionId = %s", str);
        zzk.zzi(this.zza, (e) wVar);
        zzk zzkVar = this.zza;
        zzk.zzo(zzkVar, zzk.zza(zzkVar), str);
        r.m(zzk.zzd(this.zza));
        zzk zzkVar2 = this.zza;
        zzk.zzb(this.zza).zzd(zzk.zze(zzkVar2).zzc(zzk.zzd(zzkVar2)), 226);
    }

    public final /* bridge */ /* synthetic */ void onSessionStartFailed(w wVar, int i) {
        zzk.zzi(this.zza, (e) wVar);
        zzk.zzn(this.zza, i);
    }

    public final /* bridge */ /* synthetic */ void onSessionStarted(w wVar, String str) {
        zzk.zzf().a("onSessionStarted with sessionId = %s", str);
        zzk.zzi(this.zza, (e) wVar);
        zzk.zzl(this.zza);
        zzk zzkVar = this.zza;
        zzk.zzd(zzkVar).zzf = str;
        zzk.zzb(this.zza).zzd(zzk.zze(zzkVar).zza(zzk.zzd(zzkVar)), 222);
        zzk.zzp(this.zza);
        zzk.zzq(this.zza);
    }

    public final /* bridge */ /* synthetic */ void onSessionStarting(w wVar) {
        zzk.zzf().a("onSessionStarting", new Object[0]);
        zzk.zzi(this.zza, (e) wVar);
        if (zzk.zzd(this.zza) != null) {
            zzk.zzf().f("Start a session while there's already an active session. Create a new one.", new Object[0]);
        }
        zzk.zzm(this.zza);
        zzk zzkVar = this.zza;
        zzk.zzb(this.zza).zzd(zzk.zze(zzkVar).zzd(zzk.zzd(zzkVar)), 221);
    }

    public final /* bridge */ /* synthetic */ void onSessionSuspended(w wVar, int i) {
        zzk.zzf().a("onSessionSuspended with reason = %d", Integer.valueOf(i));
        zzk.zzi(this.zza, (e) wVar);
        zzk.zzl(this.zza);
        r.m(zzk.zzd(this.zza));
        zzk zzkVar = this.zza;
        zzk.zzb(this.zza).zzd(zzk.zze(zzkVar).zze(zzk.zzd(zzkVar), i), 225);
        zzk.zzp(this.zza);
        zzk.zzk(this.zza);
    }
}
