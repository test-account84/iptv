package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zznv {
    private final zzxt zza;
    private final Class zzb;

    private zznv(zzxt zzxtVar, Class cls) {
        this.zza = zzxtVar;
        this.zzb = cls;
    }

    public static zznv zza(zznx zznxVar, zzxt zzxtVar, Class cls) {
        return new zzny(zzxtVar, cls, zznxVar);
    }

    public abstract zzch zza(zzov zzovVar) throws GeneralSecurityException;

    public final Class zzb() {
        return this.zzb;
    }

    public /* synthetic */ zznv(zzxt zzxtVar, Class cls, zzoa zzoaVar) {
        this(zzxtVar, cls);
    }

    public final zzxt zza() {
        return this.zza;
    }
}
