package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzok {
    private final Map zza;
    private final Map zzb;

    private zzok(zzoj zzojVar) {
        this.zza = new HashMap(zzoj.zza(zzojVar));
        this.zzb = new HashMap(zzoj.zzb(zzojVar));
    }

    public static zzoj zza(zzok zzokVar) {
        return new zzoj(zzokVar, null);
    }

    public static /* bridge */ /* synthetic */ Map zzb(zzok zzokVar) {
        return zzokVar.zza;
    }

    public static /* bridge */ /* synthetic */ Map zzc(zzok zzokVar) {
        return zzokVar.zzb;
    }

    public /* synthetic */ zzok(zzoj zzojVar, zzon zzonVar) {
        this(zzojVar);
    }

    public final Class zza(Class cls) throws GeneralSecurityException {
        if (this.zzb.containsKey(cls)) {
            return ((zzcp) this.zzb.get(cls)).zza();
        }
        throw new GeneralSecurityException("No input primitive class for " + String.valueOf(cls) + " available");
    }

    public final Object zza(zzbt zzbtVar, Class cls) throws GeneralSecurityException {
        zzol zzolVar = new zzol(zzbtVar.getClass(), cls, null);
        if (this.zza.containsKey(zzolVar)) {
            return ((zzod) this.zza.get(zzolVar)).zza(zzbtVar);
        }
        throw new GeneralSecurityException("No PrimitiveConstructor for " + String.valueOf(zzolVar) + " available");
    }

    public final Object zza(zzcg zzcgVar, Class cls) throws GeneralSecurityException {
        if (!this.zzb.containsKey(cls)) {
            throw new GeneralSecurityException("No wrapper found for " + String.valueOf(cls));
        }
        zzcp zzcpVar = (zzcp) this.zzb.get(cls);
        if (zzcgVar.zzc().equals(zzcpVar.zza()) && zzcpVar.zza().equals(zzcgVar.zzc())) {
            return zzcpVar.zza(zzcgVar);
        }
        throw new GeneralSecurityException("Input primitive type of the wrapper doesn't match the type of primitives in the provided PrimitiveSet");
    }
}
