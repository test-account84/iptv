package com.google.android.gms.internal.firebase-auth-api;

import java.security.GeneralSecurityException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzor implements zzov {
    private final zzxt zza;
    private final zzvb zzb;

    private zzor(zzvb zzvbVar, zzxt zzxtVar) {
        this.zzb = zzvbVar;
        this.zza = zzxtVar;
    }

    public static zzor zza(zzvb zzvbVar) throws GeneralSecurityException {
        return new zzor(zzvbVar, zzpf.zza(zzvbVar.zzf()));
    }

    public static zzor zzb(zzvb zzvbVar) {
        return new zzor(zzvbVar, zzpf.zzb(zzvbVar.zzf()));
    }

    public final zzvb zza() {
        return this.zzb;
    }

    public final zzxt zzb() {
        return this.zza;
    }
}
