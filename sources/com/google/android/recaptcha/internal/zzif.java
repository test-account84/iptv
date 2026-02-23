package com.google.android.recaptcha.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzif {
    private static final zzie zza;
    private static final zzie zzb;

    static {
        zzie zzieVar = null;
        try {
            zzieVar = (zzie) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
        }
        zza = zzieVar;
        zzb = new zzie();
    }

    public static zzie zza() {
        return zza;
    }

    public static zzie zzb() {
        return zzb;
    }
}
