package com.google.android.gms.internal.firebase-auth-api;

import H5.m;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzzl implements zzadk {
    private final /* synthetic */ zzagg zza;
    private final /* synthetic */ zzacd zzb;

    public zzzl(zzyj zzyjVar, zzagg zzaggVar, zzacd zzacdVar) {
        this.zza = zzaggVar;
        this.zzb = zzacdVar;
    }

    public final /* synthetic */ void zza(Object obj) {
        zzagj zzagjVar = (zzagj) obj;
        zzagg zzaggVar = this.zza;
        if (zzaggVar instanceof zzagk) {
            this.zzb.zzb(zzagjVar.zza());
            return;
        }
        if (zzaggVar instanceof zzagm) {
            this.zzb.zza(zzagjVar);
            return;
        }
        throw new IllegalArgumentException("startMfaEnrollmentRequest must be an instance of either StartPhoneMfaEnrollmentRequest or StartTotpMfaEnrollmentRequest but was " + this.zza.getClass().getName() + ".");
    }

    public final void zza(String str) {
        this.zzb.zza(m.a(str));
    }
}
