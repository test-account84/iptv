package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zztl {
    private static final zztk zza;
    private static final zztk zzb;

    static {
        zztk zztkVar = null;
        try {
            zztkVar = (zztk) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
        }
        zza = zztkVar;
        zzb = new zztk();
    }

    public static zztk zza() {
        return zza;
    }

    public static zztk zzb() {
        return zzb;
    }
}
