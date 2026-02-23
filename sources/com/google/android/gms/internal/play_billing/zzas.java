package com.google.android.gms.internal.play_billing;

import j$.util.Objects;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzas extends zzai {
    private final transient Object[] zza;
    private final transient int zzb;
    private final transient int zzc;

    public zzas(Object[] objArr, int i, int i2) {
        this.zza = objArr;
        this.zzb = i;
        this.zzc = i2;
    }

    public final Object get(int i) {
        zzaa.zza(i, this.zzc, "index");
        Object obj = this.zza[i + i + this.zzb];
        Objects.requireNonNull(obj);
        return obj;
    }

    public final int size() {
        return this.zzc;
    }

    public final boolean zzf() {
        return true;
    }
}
