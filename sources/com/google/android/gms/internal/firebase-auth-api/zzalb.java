package com.google.android.gms.internal.firebase-auth-api;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzalb {
    private static final zzalb zza = new zzalb();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzale zzb = new zzakb();

    private zzalb() {
    }

    public static zzalb zza() {
        return zza;
    }

    public final zzalf zza(Class cls) {
        zzajf.zza(cls, "messageType");
        zzalf zzalfVar = (zzalf) this.zzc.get(cls);
        if (zzalfVar != null) {
            return zzalfVar;
        }
        zzalf zza2 = this.zzb.zza(cls);
        zzajf.zza(cls, "messageType");
        zzajf.zza(zza2, "schema");
        zzalf zzalfVar2 = (zzalf) this.zzc.putIfAbsent(cls, zza2);
        return zzalfVar2 != null ? zzalfVar2 : zza2;
    }

    public final zzalf zza(Object obj) {
        return zza(obj.getClass());
    }
}
