package com.google.android.recaptcha.internal;

import java.util.Collections;
import java.util.HashMap;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzfz {
    static final zzfz zza = new zzfz(true);
    public static final /* synthetic */ int zzb = 0;
    private static volatile boolean zzc = false;
    private final Map zzd;

    public zzfz() {
        this.zzd = new HashMap();
    }

    public final zzgm zza(zzhy zzhyVar, int i) {
        return (zzgm) this.zzd.get(new zzfy(zzhyVar, i));
    }

    public zzfz(boolean z) {
        this.zzd = Collections.emptyMap();
    }
}
