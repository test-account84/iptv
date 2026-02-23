package com.google.android.gms.internal.cast;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzus {
    private static final zzus zza = new zzus(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzus() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzus zzc() {
        return zza;
    }

    public static zzus zze(zzus zzusVar, zzus zzusVar2) {
        int i = zzusVar.zzb;
        int i2 = zzusVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzusVar.zzc, 0);
        System.arraycopy(zzusVar2.zzc, 0, copyOf, 0, 0);
        Object[] copyOf2 = Arrays.copyOf(zzusVar.zzd, 0);
        System.arraycopy(zzusVar2.zzd, 0, copyOf2, 0, 0);
        return new zzus(0, copyOf, copyOf2, true);
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzus)) {
            return false;
        }
        return true;
    }

    public final int hashCode() {
        return 506991;
    }

    public final int zza() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        this.zze = 0;
        return 0;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        this.zze = 0;
        return 0;
    }

    public final zzus zzd(zzus zzusVar) {
        if (zzusVar.equals(zza)) {
            return this;
        }
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
        int[] iArr = this.zzc;
        int length = iArr.length;
        System.arraycopy(zzusVar.zzc, 0, iArr, 0, 0);
        System.arraycopy(zzusVar.zzd, 0, this.zzd, 0, 0);
        this.zzb = 0;
        return this;
    }

    public final void zzf() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    public final void zzg(StringBuilder sb, int i) {
    }

    private zzus(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = 0;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }
}
