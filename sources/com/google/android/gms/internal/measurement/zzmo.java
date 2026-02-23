package com.google.android.gms.internal.measurement;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzmo {
    private static final zzmn zza;
    private static final zzmn zzb;

    static {
        zzmn zzmnVar = null;
        try {
            zzmnVar = (zzmn) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
        }
        zza = zzmnVar;
        zzb = new zzmn();
    }

    public static zzmn zza() {
        return zza;
    }

    public static zzmn zzb() {
        return zzb;
    }
}
