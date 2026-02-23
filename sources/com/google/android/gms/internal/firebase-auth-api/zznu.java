package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zznu {
    private static final zznu zza = (zznu) zzpd.zza(zznt.zza);
    private final AtomicReference zzb = new AtomicReference(new zzox().zza());

    public final zzbt zza(zzos zzosVar, zzcs zzcsVar) throws GeneralSecurityException {
        return !((zzoy) this.zzb.get()).zzb(zzosVar) ? new zznd(zzosVar, zzcsVar) : ((zzoy) this.zzb.get()).zza(zzosVar, zzcsVar);
    }

    public final boolean zzb(zzov zzovVar) {
        return ((zzoy) this.zzb.get()).zzc(zzovVar);
    }

    public final zzch zza(zzov zzovVar) throws GeneralSecurityException {
        return ((zzoy) this.zzb.get()).zza(zzovVar);
    }

    public static zznu zza() {
        return zza;
    }

    public final zzov zza(zzch zzchVar, Class cls) throws GeneralSecurityException {
        return ((zzoy) this.zzb.get()).zza(zzchVar, cls);
    }

    public final synchronized void zza(zzmu zzmuVar) throws GeneralSecurityException {
        this.zzb.set(new zzox((zzoy) this.zzb.get()).zza(zzmuVar).zza());
    }

    public final synchronized void zza(zzmx zzmxVar) throws GeneralSecurityException {
        this.zzb.set(new zzox((zzoy) this.zzb.get()).zza(zzmxVar).zza());
    }

    public final synchronized void zza(zznv zznvVar) throws GeneralSecurityException {
        this.zzb.set(new zzox((zzoy) this.zzb.get()).zza(zznvVar).zza());
    }

    public final synchronized void zza(zznz zznzVar) throws GeneralSecurityException {
        this.zzb.set(new zzox((zzoy) this.zzb.get()).zza(zznzVar).zza());
    }
}
