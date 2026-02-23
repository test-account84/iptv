package com.google.android.gms.internal.firebase-auth-api;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzax extends zzap {
    static final zzap zza = new zzax(new Object[0], 0);
    private final transient Object[] zzb;
    private final transient int zzc;

    public zzax(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    public final Object get(int i) {
        zzy.zza(i, this.zzc);
        Object obj = this.zzb[i];
        obj.getClass();
        return obj;
    }

    public final int size() {
        return this.zzc;
    }

    public final int zza() {
        return this.zzc;
    }

    public final int zzb() {
        return 0;
    }

    public final boolean zze() {
        return false;
    }

    public final Object[] zzf() {
        return this.zzb;
    }

    public final int zza(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, i, this.zzc);
        return i + this.zzc;
    }
}
