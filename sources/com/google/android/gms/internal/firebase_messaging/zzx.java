package com.google.android.gms.internal.firebase_messaging;

import c6.e;
import java.io.IOException;
import java.io.OutputStream;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzx {
    private final Map zza;
    private final Map zzb;
    private final e zzc;

    public zzx(Map map, Map map2, e eVar) {
        this.zza = map;
        this.zzb = map2;
        this.zzc = eVar;
    }

    public final void zza(Object obj, OutputStream outputStream) throws IOException {
        new zzu(outputStream, this.zza, this.zzb, this.zzc).zzf(obj);
    }
}
