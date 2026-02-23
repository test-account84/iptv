package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzvg;
import j$.util.concurrent.ConcurrentHashMap;
import java.security.GeneralSecurityException;
import java.util.ArrayList;
import java.util.List;
import java.util.concurrent.ConcurrentMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzcj {
    private final Class zza;
    private ConcurrentMap zzb;
    private final List zzc;
    private zzcl zzd;
    private zzrn zze;

    private zzcj(Class cls) {
        this.zzb = new ConcurrentHashMap();
        this.zzc = new ArrayList();
        this.zza = cls;
        this.zze = zzrn.zza;
    }

    public final zzcg zza() throws GeneralSecurityException {
        ConcurrentMap concurrentMap = this.zzb;
        if (concurrentMap == null) {
            throw new IllegalStateException("build cannot be called twice");
        }
        zzcg zzcgVar = new zzcg(concurrentMap, this.zzc, this.zzd, this.zze, this.zza, null);
        this.zzb = null;
        return zzcgVar;
    }

    public final zzcj zzb(Object obj, Object obj2, zzvg.zzb zzbVar) throws GeneralSecurityException {
        return zza(obj, obj2, zzbVar, true);
    }

    public /* synthetic */ zzcj(Class cls, zzci zzciVar) {
        this(cls);
    }

    public final zzcj zza(zzrn zzrnVar) {
        if (this.zzb == null) {
            throw new IllegalStateException("setAnnotations cannot be called after build");
        }
        this.zze = zzrnVar;
        return this;
    }

    public final zzcj zza(Object obj, Object obj2, zzvg.zzb zzbVar) throws GeneralSecurityException {
        return zza(obj, obj2, zzbVar, false);
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x00d9  */
    /* JADX WARN: Removed duplicated region for block: B:28:0x00f0  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final com.google.android.gms.internal.firebase-auth-api.zzcj zza(java.lang.Object r13, java.lang.Object r14, com.google.android.gms.internal.firebase-auth-api.zzvg.zzb r15, boolean r16) throws java.security.GeneralSecurityException {
        /*
            Method dump skipped, instructions count: 272
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-auth-api.zzcj.zza(java.lang.Object, java.lang.Object, com.google.android.gms.internal.firebase-auth-api.zzvg$zzb, boolean):com.google.android.gms.internal.firebase-auth-api.zzcj");
    }
}
