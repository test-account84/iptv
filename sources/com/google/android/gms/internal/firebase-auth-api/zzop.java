package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzop extends zznb {
    private final Class zza;

    @SafeVarargs
    public zzop(Class cls, Class cls2, zzoh... zzohVarArr) {
        super(cls, zzohVarArr);
        this.zza = cls2;
    }

    public abstract zzakn zzb(zzakn zzaknVar) throws GeneralSecurityException;
}
