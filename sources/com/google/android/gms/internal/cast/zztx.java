package com.google.android.gms.internal.cast;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zztx {
    private static final zztx zza = new zztx();
    private final ConcurrentMap zzc = new ConcurrentHashMap();
    private final zzub zzb = new zzth();

    private zztx() {
    }

    public static zztx zza() {
        return zza;
    }

    public final zzua zzb(Class cls) {
        zzsq.zzc(cls, "messageType");
        zzua zzuaVar = (zzua) this.zzc.get(cls);
        if (zzuaVar == null) {
            zzuaVar = this.zzb.zza(cls);
            zzsq.zzc(cls, "messageType");
            zzsq.zzc(zzuaVar, "schema");
            zzua zzuaVar2 = (zzua) this.zzc.putIfAbsent(cls, zzuaVar);
            if (zzuaVar2 != null) {
                return zzuaVar2;
            }
        }
        return zzuaVar;
    }
}
