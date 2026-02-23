package com.google.android.gms.internal.location;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzbt extends zzbs {
    static final zzbs zza = new zzbt(new Object[0], 0);
    final transient Object[] zzb;
    private final transient int zzc;

    public zzbt(Object[] objArr, int i) {
        this.zzb = objArr;
        this.zzc = i;
    }

    public final Object get(int i) {
        zzbm.zza(i, this.zzc, "index");
        return this.zzb[i];
    }

    public final int size() {
        return this.zzc;
    }

    public final Object[] zzb() {
        return this.zzb;
    }

    public final int zzc() {
        return 0;
    }

    public final int zzd() {
        return this.zzc;
    }

    public final boolean zzf() {
        return false;
    }

    public final int zzg(Object[] objArr, int i) {
        System.arraycopy(this.zzb, 0, objArr, 0, this.zzc);
        return this.zzc;
    }
}
