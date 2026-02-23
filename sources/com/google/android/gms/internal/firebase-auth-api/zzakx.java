package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzakx {
    private static final zzakv zza = zzc();
    private static final zzakv zzb = new zzaku();

    public static zzakv zza() {
        return zza;
    }

    public static zzakv zzb() {
        return zzb;
    }

    private static zzakv zzc() {
        try {
            return (zzakv) Class.forName("com.google.protobuf.NewInstanceSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
            return null;
        }
    }
}
