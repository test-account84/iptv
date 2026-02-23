package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzfi {
    private final Object zza;
    private final Object zzb;
    private final Object zzc;

    public zzfi(Object obj, Object obj2, Object obj3) {
        this.zza = obj;
        this.zzb = obj2;
        this.zzc = obj3;
    }

    public final IllegalArgumentException zza() {
        return new IllegalArgumentException("Multiple entries with same key: " + String.valueOf(this.zza) + "=" + String.valueOf(this.zzb) + " and " + String.valueOf(this.zza) + "=" + String.valueOf(this.zzc));
    }
}
