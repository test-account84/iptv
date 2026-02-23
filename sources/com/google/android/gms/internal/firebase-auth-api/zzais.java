package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzais {
    private static final zzaiq zza = new zzait();
    private static final zzaiq zzb = zzc();

    public static zzaiq zza() {
        zzaiq zzaiqVar = zzb;
        if (zzaiqVar != null) {
            return zzaiqVar;
        }
        throw new IllegalStateException("Protobuf runtime is not correctly loaded.");
    }

    public static zzaiq zzb() {
        return zza;
    }

    private static zzaiq zzc() {
        try {
            return (zzaiq) Class.forName("com.google.protobuf.ExtensionSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }
}
