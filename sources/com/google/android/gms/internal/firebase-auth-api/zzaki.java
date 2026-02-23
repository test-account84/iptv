package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzaki {
    private static final zzakg zza = zzc();
    private static final zzakg zzb = new zzakj();

    public static zzakg zza() {
        return zza;
    }

    public static zzakg zzb() {
        return zzb;
    }

    private static zzakg zzc() {
        try {
            return (zzakg) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }
}
