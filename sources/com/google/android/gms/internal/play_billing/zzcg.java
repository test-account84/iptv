package com.google.android.gms.internal.play_billing;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzcg {
    private static final zzce zza = new zzcf();
    private static final zzce zzb;

    static {
        zzce zzceVar = null;
        try {
            zzceVar = (zzce) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
        }
        zzb = zzceVar;
    }

    public static zzce zza() {
        zzce zzceVar = zzb;
        if (zzceVar != null) {
            return zzceVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zzce zzb() {
        return zza;
    }
}
