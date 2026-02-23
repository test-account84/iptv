package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzmu {
    private final zzxt zza;
    private final Class zzb;

    private zzmu(zzxt zzxtVar, Class cls) {
        this.zza = zzxtVar;
        this.zzb = cls;
    }

    public static zzmu zza(zzmv zzmvVar, zzxt zzxtVar, Class cls) {
        return new zzmw(zzxtVar, cls, zzmvVar);
    }

    public abstract zzbt zza(zzov zzovVar, zzcs zzcsVar) throws GeneralSecurityException;

    public final Class zzb() {
        return this.zzb;
    }

    public /* synthetic */ zzmu(zzxt zzxtVar, Class cls, zzmy zzmyVar) {
        this(zzxtVar, cls);
    }

    public final zzxt zza() {
        return this.zza;
    }
}
