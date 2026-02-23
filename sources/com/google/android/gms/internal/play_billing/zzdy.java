package com.google.android.gms.internal.play_billing;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzdy {
    private static final zzdx zza;
    private static final zzdx zzb;

    static {
        zzdx zzdxVar = null;
        try {
            zzdxVar = (zzdx) Class.forName("com.google.protobuf.MapFieldSchemaFull").getDeclaredConstructor((Class[]) null).newInstance((Object[]) null);
        } catch (Exception unused) {
        }
        zza = zzdxVar;
        zzb = new zzdx();
    }

    public static zzdx zza() {
        return zza;
    }

    public static zzdx zzb() {
        return zzb;
    }
}
