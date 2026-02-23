package com.google.android.recaptcha.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzhu {
    private static final zzht zza;
    private static final zzht zzb;

    static {
        zzht zzhtVar = null;
        try {
            zzhtVar = (zzht) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
        }
        zza = zzhtVar;
        zzb = new zzht();
    }

    public static zzht zza() {
        return zza;
    }

    public static zzht zzb() {
        return zzb;
    }
}
