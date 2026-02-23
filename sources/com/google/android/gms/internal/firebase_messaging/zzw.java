package com.google.android.gms.internal.firebase_messaging;

import c6.e;
import c6.g;
import d6.b;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzw implements b {
    public static final /* synthetic */ int zza = 0;
    private static final e zzb = zzv.zza;
    private final Map zzc = new HashMap();
    private final Map zzd = new HashMap();
    private final e zze = zzb;

    public final /* bridge */ /* synthetic */ b registerEncoder(Class cls, e eVar) {
        this.zzc.put(cls, eVar);
        this.zzd.remove(cls);
        return this;
    }

    public final zzx zza() {
        return new zzx(new HashMap(this.zzc), new HashMap(this.zzd), this.zze);
    }

    public final /* bridge */ /* synthetic */ b registerEncoder(Class cls, g gVar) {
        this.zzd.put(cls, gVar);
        this.zzc.remove(cls);
        return this;
    }
}
