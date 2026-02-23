package com.google.android.gms.internal.cast;

import java.io.Serializable;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzeq implements Serializable {
    public static zzeq zzb(Object obj) {
        return obj == null ? zzem.zza : new zzev(obj);
    }

    public abstract Object zza();
}
