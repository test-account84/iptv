package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzod {
    private final Class zza;
    private final Class zzb;

    private zzod(Class cls, Class cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zzod zza(zzof zzofVar, Class cls, Class cls2) {
        return new zzog(cls, cls2, zzofVar);
    }

    public abstract Object zza(zzbt zzbtVar) throws GeneralSecurityException;

    public final Class zzb() {
        return this.zzb;
    }

    public /* synthetic */ zzod(Class cls, Class cls2, zzoi zzoiVar) {
        this(cls, cls2);
    }

    public final Class zza() {
        return this.zza;
    }
}
