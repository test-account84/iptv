package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;
import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzaio {
    static final zzaio zza = new zzaio(true);
    private static volatile boolean zzb = false;
    private static boolean zzc = true;
    private final Map zzd;

    public zzaio() {
        this.zzd = new HashMap();
    }

    public static zzaio zza() {
        return zza;
    }

    private zzaio(boolean z) {
        this.zzd = Collections.emptyMap();
    }

    public final zzajc.zzd zza(zzakn zzaknVar, int i) {
        return (zzajc.zzd) this.zzd.get(new zzair(zzaknVar, i));
    }
}
