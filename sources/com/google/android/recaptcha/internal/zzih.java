package com.google.android.recaptcha.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.concurrent.ConcurrentMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzih {
    public static final /* synthetic */ int zza = 0;
    private static final zzih zzb = new zzih();
    private final ConcurrentMap zzd = new ConcurrentHashMap();
    private final zzim zzc = new zzhq();

    private zzih() {
    }

    public static zzih zza() {
        return zzb;
    }

    public final zzil zzb(Class cls) {
        zzgw.zzc(cls, "messageType");
        zzil zzilVar = (zzil) this.zzd.get(cls);
        if (zzilVar == null) {
            zzilVar = this.zzc.zza(cls);
            zzgw.zzc(cls, "messageType");
            zzgw.zzc(zzilVar, "schema");
            zzil zzilVar2 = (zzil) this.zzd.putIfAbsent(cls, zzilVar);
            if (zzilVar2 != null) {
                return zzilVar2;
            }
        }
        return zzilVar;
    }
}
