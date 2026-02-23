package com.google.android.gms.internal.cast;

import android.os.Bundle;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzac {
    private static long zza = 6000;
    private static boolean zzb = false;

    public static long zza() {
        return zza;
    }

    public static /* synthetic */ void zzb(Bundle bundle) {
        bundle.getLong("com.google.android.gms.cast.FLAG_MEDIA_ROUTE_DIALOG_UPDATE_DEVICES_DELAY_MS", 300L);
        bundle.getLong("com.google.android.gms.cast.FLAG_MEDIA_ROUTE_DIALOG_DISCOVERY_TIMEOUT_MS", 10000L);
        zza = bundle.getLong("com.google.android.gms.cast.FLAG_MEDIA_ROUTE_DIALOG_ZERO_DEVICE_TIMEOUT_MS", 6000L);
        zzb = bundle.getBoolean("com.google.android.gms.cast.FLAG_MEDIA_ROUTE_DIALOG_ENABLE_WIFI_WARNING", false);
    }

    public static boolean zzc() {
        return zzb;
    }
}
