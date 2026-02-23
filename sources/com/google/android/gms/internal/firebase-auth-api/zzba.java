package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzba extends zzap {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    public zzba(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    public final Object get(int i) {
        zzy.zza(i, this.zzc);
        Object obj = this.zza[(i * 2) + this.zzb];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return this.zzc;
    }

    public final boolean zze() {
        return true;
    }
}
