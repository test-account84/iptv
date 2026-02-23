package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zznr {
    private static zznr zza = new zznr();
    private final AtomicReference zzb = new AtomicReference(new zzoj((zzom) null).zza());

    public static zznr zza() {
        return zza;
    }

    public final Class zza(Class cls) throws GeneralSecurityException {
        return ((zzok) this.zzb.get()).zza(cls);
    }

    public final Object zza(zzbt zzbtVar, Class cls) throws GeneralSecurityException {
        return ((zzok) this.zzb.get()).zza(zzbtVar, cls);
    }

    public final Object zza(zzcg zzcgVar, Class cls) throws GeneralSecurityException {
        return ((zzok) this.zzb.get()).zza(zzcgVar, cls);
    }

    public final synchronized void zza(zzcp zzcpVar) throws GeneralSecurityException {
        this.zzb.set(zzok.zza((zzok) this.zzb.get()).zza(zzcpVar).zza());
    }

    public final synchronized void zza(zzod zzodVar) throws GeneralSecurityException {
        this.zzb.set(zzok.zza((zzok) this.zzb.get()).zza(zzodVar).zza());
    }
}
