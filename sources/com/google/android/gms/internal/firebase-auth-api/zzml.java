package com.google.android.gms.internal.firebase-auth-api;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzml {
    private Map zza;
    private Map zzb;

    private zzml() {
        this.zza = new HashMap();
        this.zzb = new HashMap();
    }

    public final zzmi zza() {
        return new zzmi(Collections.unmodifiableMap(this.zza), Collections.unmodifiableMap(this.zzb), null);
    }

    public /* synthetic */ zzml(zzmk zzmkVar) {
        this();
    }

    public final zzml zza(Enum r2, Object obj) {
        this.zza.put(r2, obj);
        this.zzb.put(obj, r2);
        return this;
    }
}
