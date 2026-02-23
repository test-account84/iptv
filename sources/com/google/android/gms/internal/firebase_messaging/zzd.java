package com.google.android.gms.internal.firebase_messaging;

import d6.a;
import d6.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzd implements a {
    public static final a zza = new zzd();

    private zzd() {
    }

    public final void configure(b bVar) {
        bVar.registerEncoder(zze.class, zzc.zza);
        bVar.registerEncoder(r6.b.class, zzb.zza);
        bVar.registerEncoder(r6.a.class, zza.zza);
    }
}
