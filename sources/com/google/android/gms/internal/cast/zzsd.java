package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzsd implements zztn {
    private static final zzsd zza = new zzsd();

    private zzsd() {
    }

    public static zzsd zza() {
        return zza;
    }

    public final zztm zzb(Class cls) {
        if (!zzsh.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zztm) zzsh.zzv(cls.asSubclass(zzsh.class)).zzb(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
        }
    }

    public final boolean zzc(Class cls) {
        return zzsh.class.isAssignableFrom(cls);
    }
}
