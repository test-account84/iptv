package com.google.android.gms.internal.measurement;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzme {
    private static final zzmd zza;
    private static final zzmd zzb;

    static {
        zzmd zzmdVar = null;
        try {
            zzmdVar = (zzmd) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
        }
        zza = zzmdVar;
        zzb = new zzmd();
    }

    public static zzmd zza() {
        return zza;
    }

    public static zzmd zzb() {
        return zzb;
    }
}
