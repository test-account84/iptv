package com.google.android.gms.internal.firebase-auth-api;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzamd {
    private static final zzamd zza = new zzamd(0, new int[0], new Object[0], false);
    private int zzb;
    private int[] zzc;
    private Object[] zzd;
    private int zze;
    private boolean zzf;

    private zzamd() {
        this(0, new int[8], new Object[8], true);
    }

    public static zzamd zzc() {
        return zza;
    }

    public static zzamd zzd() {
        return new zzamd();
    }

    private final void zzf() {
        if (!this.zzf) {
            throw new UnsupportedOperationException();
        }
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        if (obj == null || !(obj instanceof zzamd)) {
            return false;
        }
        zzamd zzamdVar = (zzamd) obj;
        int i = this.zzb;
        if (i == zzamdVar.zzb) {
            int[] iArr = this.zzc;
            int[] iArr2 = zzamdVar.zzc;
            int i2 = 0;
            while (true) {
                if (i2 >= i) {
                    Object[] objArr = this.zzd;
                    Object[] objArr2 = zzamdVar.zzd;
                    int i3 = this.zzb;
                    for (int i4 = 0; i4 < i3; i4++) {
                        if (objArr[i4].equals(objArr2[i4])) {
                        }
                    }
                    return true;
                }
                if (iArr[i2] != iArr2[i2]) {
                    break;
                }
                i2++;
            }
        }
        return false;
    }

    public final int hashCode() {
        int i = this.zzb;
        int i2 = (i + 527) * 31;
        int[] iArr = this.zzc;
        int i3 = 17;
        int i4 = 17;
        for (int i5 = 0; i5 < i; i5++) {
            i4 = (i4 * 31) + iArr[i5];
        }
        int i6 = (i2 + i4) * 31;
        Object[] objArr = this.zzd;
        int i7 = this.zzb;
        for (int i8 = 0; i8 < i7; i8++) {
            i3 = (i3 * 31) + objArr[i8].hashCode();
        }
        return i6 + i3;
    }

    public final int zza() {
        int zze;
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            int i4 = this.zzc[i3];
            int i5 = i4 >>> 3;
            int i6 = i4 & 7;
            if (i6 == 0) {
                zze = zzaik.zze(i5, ((Long) this.zzd[i3]).longValue());
            } else if (i6 == 1) {
                zze = zzaik.zza(i5, ((Long) this.zzd[i3]).longValue());
            } else if (i6 == 2) {
                zze = zzaik.zza(i5, (zzahp) this.zzd[i3]);
            } else if (i6 == 3) {
                zze = (zzaik.zzi(i5) << 1) + ((zzamd) this.zzd[i3]).zza();
            } else {
                if (i6 != 5) {
                    throw new IllegalStateException(zzaji.zza());
                }
                zze = zzaik.zzc(i5, ((Integer) this.zzd[i3]).intValue());
            }
            i2 += zze;
        }
        this.zze = i2;
        return i2;
    }

    public final int zzb() {
        int i = this.zze;
        if (i != -1) {
            return i;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < this.zzb; i3++) {
            i2 += zzaik.zzb(this.zzc[i3] >>> 3, (zzahp) this.zzd[i3]);
        }
        this.zze = i2;
        return i2;
    }

    public final void zze() {
        if (this.zzf) {
            this.zzf = false;
        }
    }

    private zzamd(int i, int[] iArr, Object[] objArr, boolean z) {
        this.zze = -1;
        this.zzb = i;
        this.zzc = iArr;
        this.zzd = objArr;
        this.zzf = z;
    }

    public final zzamd zza(zzamd zzamdVar) {
        if (zzamdVar.equals(zza)) {
            return this;
        }
        zzf();
        int i = this.zzb + zzamdVar.zzb;
        zza(i);
        System.arraycopy(zzamdVar.zzc, 0, this.zzc, this.zzb, zzamdVar.zzb);
        System.arraycopy(zzamdVar.zzd, 0, this.zzd, this.zzb, zzamdVar.zzb);
        this.zzb = i;
        return this;
    }

    public final void zzb(zzana zzanaVar) throws IOException {
        if (this.zzb == 0) {
            return;
        }
        if (zzanaVar.zza() == zzand.zza) {
            for (int i = 0; i < this.zzb; i++) {
                zza(this.zzc[i], this.zzd[i], zzanaVar);
            }
            return;
        }
        for (int i2 = this.zzb - 1; i2 >= 0; i2--) {
            zza(this.zzc[i2], this.zzd[i2], zzanaVar);
        }
    }

    public static zzamd zza(zzamd zzamdVar, zzamd zzamdVar2) {
        int i = zzamdVar.zzb + zzamdVar2.zzb;
        int[] copyOf = Arrays.copyOf(zzamdVar.zzc, i);
        System.arraycopy(zzamdVar2.zzc, 0, copyOf, zzamdVar.zzb, zzamdVar2.zzb);
        Object[] copyOf2 = Arrays.copyOf(zzamdVar.zzd, i);
        System.arraycopy(zzamdVar2.zzd, 0, copyOf2, zzamdVar.zzb, zzamdVar2.zzb);
        return new zzamd(i, copyOf, copyOf2, true);
    }

    private final void zza(int i) {
        int[] iArr = this.zzc;
        if (i > iArr.length) {
            int i2 = this.zzb;
            int i3 = i2 + (i2 / 2);
            if (i3 >= i) {
                i = i3;
            }
            if (i < 8) {
                i = 8;
            }
            this.zzc = Arrays.copyOf(iArr, i);
            this.zzd = Arrays.copyOf(this.zzd, i);
        }
    }

    public final void zza(int i, Object obj) {
        zzf();
        zza(this.zzb + 1);
        int[] iArr = this.zzc;
        int i2 = this.zzb;
        iArr[i2] = i;
        this.zzd[i2] = obj;
        this.zzb = i2 + 1;
    }

    private static void zza(int i, Object obj, zzana zzanaVar) throws IOException {
        int i2 = i >>> 3;
        int i3 = i & 7;
        if (i3 == 0) {
            zzanaVar.zzb(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 1) {
            zzanaVar.zza(i2, ((Long) obj).longValue());
            return;
        }
        if (i3 == 2) {
            zzanaVar.zza(i2, (zzahp) obj);
            return;
        }
        if (i3 != 3) {
            if (i3 != 5) {
                throw new RuntimeException(zzaji.zza());
            }
            zzanaVar.zzb(i2, ((Integer) obj).intValue());
        } else if (zzanaVar.zza() == zzand.zza) {
            zzanaVar.zzb(i2);
            ((zzamd) obj).zzb(zzanaVar);
            zzanaVar.zza(i2);
        } else {
            zzanaVar.zza(i2);
            ((zzamd) obj).zzb(zzanaVar);
            zzanaVar.zzb(i2);
        }
    }

    public final void zza(zzana zzanaVar) throws IOException {
        if (zzanaVar.zza() == zzand.zzb) {
            for (int i = this.zzb - 1; i >= 0; i--) {
                zzanaVar.zza(this.zzc[i] >>> 3, this.zzd[i]);
            }
            return;
        }
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzanaVar.zza(this.zzc[i2] >>> 3, this.zzd[i2]);
        }
    }

    public final void zza(StringBuilder sb, int i) {
        for (int i2 = 0; i2 < this.zzb; i2++) {
            zzako.zza(sb, i, String.valueOf(this.zzc[i2] >>> 3), this.zzd[i2]);
        }
    }
}
