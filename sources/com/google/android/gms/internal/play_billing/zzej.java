package com.google.android.gms.internal.play_billing;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzej {
    private static final zzei zza;
    private static final zzei zzb;

    static {
        zzei zzeiVar = null;
        try {
            zzeiVar = (zzei) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
        }
        zza = zzeiVar;
        zzb = new zzei();
    }

    public static zzei zza() {
        return zza;
    }

    public static zzei zzb() {
        return zzb;
    }
}
