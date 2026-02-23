package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zztv {
    private static final zztu zza;
    private static final zztu zzb;

    static {
        zztu zztuVar = null;
        try {
            zztuVar = (zztu) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
        }
        zza = zztuVar;
        zzb = new zztu();
    }

    public static zztu zza() {
        return zza;
    }

    public static zztu zzb() {
        return zzb;
    }
}
