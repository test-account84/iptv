package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class zzei {
    private static final ThreadLocal zza = new zzec();

    public static zzei zzb() {
        return (zzei) zza.get();
    }

    public abstract void zza(zzef zzefVar);
}
