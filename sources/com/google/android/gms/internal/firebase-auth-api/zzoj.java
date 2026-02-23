package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzoj {
    private final Map zza;
    private final Map zzb;

    private zzoj() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public static /* bridge */ /* synthetic */ Map zzb(zzoj zzojVar) {
        return zzojVar.zzb;
    }

    public final zzoj zza(zzcp zzcpVar) throws GeneralSecurityException {
        if (zzcpVar == null) {
            throw new NullPointerException("wrapper must be non-null");
        }
        Class zzb = zzcpVar.zzb();
        if (this.zzb.containsKey(zzb)) {
            zzcp zzcpVar2 = (zzcp) this.zzb.get(zzb);
            if (!zzcpVar2.equals(zzcpVar) || !zzcpVar.equals(zzcpVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveWrapper object or input class object for already existing object of type" + String.valueOf(zzb));
            }
        } else {
            this.zzb.put(zzb, zzcpVar);
        }
        return this;
    }

    private zzoj(zzok zzokVar) {
        this.zza = new HashMap(zzok.zzb(zzokVar));
        this.zzb = new HashMap(zzok.zzc(zzokVar));
    }

    public final zzoj zza(zzod zzodVar) throws GeneralSecurityException {
        if (zzodVar == null) {
            throw new NullPointerException("primitive constructor must be non-null");
        }
        zzol zzolVar = new zzol(zzodVar.zza(), zzodVar.zzb(), null);
        if (this.zza.containsKey(zzolVar)) {
            zzod zzodVar2 = (zzod) this.zza.get(zzolVar);
            if (!zzodVar2.equals(zzodVar) || !zzodVar.equals(zzodVar2)) {
                throw new GeneralSecurityException("Attempt to register non-equal PrimitiveConstructor object for already existing object of type: " + String.valueOf(zzolVar));
            }
        } else {
            this.zza.put(zzolVar, zzodVar);
        }
        return this;
    }

    public /* synthetic */ zzoj(zzok zzokVar, zzom zzomVar) {
        this(zzokVar);
    }

    public final zzok zza() {
        return new zzok(this, null);
    }

    public /* synthetic */ zzoj(zzom zzomVar) {
        this();
    }

    public static /* bridge */ /* synthetic */ Map zza(zzoj zzojVar) {
        return zzojVar.zza;
    }
}
