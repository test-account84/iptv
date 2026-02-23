package com.google.android.recaptcha.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzgh implements zzhw {
    private static final zzgh zza = new zzgh();

    private zzgh() {
    }

    public static zzgh zza() {
        return zza;
    }

    public final zzhv zzb(Class cls) {
        if (!zzgo.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zzhv) zzgo.zzr(cls.asSubclass(zzgo.class)).zzh(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
        }
    }

    public final boolean zzc(Class cls) {
        return zzgo.class.isAssignableFrom(cls);
    }
}
