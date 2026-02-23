package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zznz {
    private final Class zza;
    private final Class zzb;

    private zznz(Class cls, Class cls2) {
        this.zza = cls;
        this.zzb = cls2;
    }

    public static zznz zza(zzob zzobVar, Class cls, Class cls2) {
        return new zzoc(cls, cls2, zzobVar);
    }

    public abstract zzov zza(zzch zzchVar) throws GeneralSecurityException;

    public final Class zzb() {
        return this.zzb;
    }

    public /* synthetic */ zznz(Class cls, Class cls2, zzoe zzoeVar) {
        this(cls, cls2);
    }

    public final Class zza() {
        return this.zza;
    }
}
