package com.google.android.gms.internal.cast;

import o4.w;
import o4.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzbl implements y {
    final /* synthetic */ zzbm zza;

    public /* synthetic */ zzbl(zzbm zzbmVar, zzbk zzbkVar) {
        this.zza = zzbmVar;
    }

    public final /* bridge */ /* synthetic */ void onSessionEnded(w wVar, int i) {
        zzbm.zzc().a("onSessionEnded with error = %d", Integer.valueOf(i));
        zzbm.zzg(this.zza);
        zzbm zzbmVar = this.zza;
        if (zzbm.zza(zzbmVar) == 2) {
            return;
        }
        zzbm.zzh(zzbmVar);
    }

    public final /* bridge */ /* synthetic */ void onSessionEnding(w wVar) {
    }

    public final /* bridge */ /* synthetic */ void onSessionResumeFailed(w wVar, int i) {
    }

    public final /* bridge */ /* synthetic */ void onSessionResumed(w wVar, boolean z) {
    }

    public final /* bridge */ /* synthetic */ void onSessionResuming(w wVar, String str) {
    }

    public final /* bridge */ /* synthetic */ void onSessionStartFailed(w wVar, int i) {
    }

    public final /* bridge */ /* synthetic */ void onSessionStarted(w wVar, String str) {
        zzbm.zzc().a("onSessionStarted with transferType = %d", Integer.valueOf(zzbm.zza(this.zza)));
        if (zzbm.zzb(this.zza).zzg()) {
            zzbm zzbmVar = this.zza;
            if (zzbm.zza(zzbmVar) == 2) {
                zzbm.zzi(zzbmVar);
            }
        }
        zzbm.zzh(this.zza);
    }

    public final /* bridge */ /* synthetic */ void onSessionStarting(w wVar) {
    }

    public final /* bridge */ /* synthetic */ void onSessionSuspended(w wVar, int i) {
    }
}
