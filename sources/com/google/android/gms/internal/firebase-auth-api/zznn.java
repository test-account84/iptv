package com.google.android.gms.internal.firebase-auth-api;

import java.util.concurrent.atomic.AtomicReference;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zznn {
    private static final zznn zza = new zznn();
    private static final zznq zzb = new zznq(null);
    private final AtomicReference zzc = new AtomicReference();

    public static zznn zza() {
        return zza;
    }

    public final zzro zzb() {
        zzro zzroVar = (zzro) this.zzc.get();
        return zzroVar == null ? zzb : zzroVar;
    }
}
