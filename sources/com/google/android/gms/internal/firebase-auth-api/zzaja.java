package com.google.android.gms.internal.firebase-auth-api;

import com.google.android.gms.internal.firebase-auth-api.zzajc;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaja implements zzakk {
    private static final zzaja zza = new zzaja();

    private zzaja() {
    }

    public static zzaja zza() {
        return zza;
    }

    public final boolean zzb(Class cls) {
        return zzajc.class.isAssignableFrom(cls);
    }

    public final zzakl zza(Class cls) {
        if (!zzajc.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: " + cls.getName());
        }
        try {
            return (zzakl) zzajc.zza(cls.asSubclass(zzajc.class)).zza(zzajc.zzf.zzc, (Object) null, (Object) null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for " + cls.getName(), e);
        }
    }
}
