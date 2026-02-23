package com.google.android.gms.internal.play_billing;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzcm implements zzea {
    private static final zzcm zza = new zzcm();

    private zzcm() {
    }

    public static zzcm zza() {
        return zza;
    }

    public final zzdz zzb(Class cls) {
        if (!zzcs.class.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Unsupported message type: ".concat(cls.getName()));
        }
        try {
            return (zzdz) zzcs.zzj(cls.asSubclass(zzcs.class)).zzx(3, null, null);
        } catch (Exception e) {
            throw new RuntimeException("Unable to get message info for ".concat(cls.getName()), e);
        }
    }

    public final boolean zzc(Class cls) {
        return zzcs.class.isAssignableFrom(cls);
    }
}
