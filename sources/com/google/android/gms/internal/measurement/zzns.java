package com.google.android.gms.internal.measurement;

import sun.misc.Unsafe;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzns extends zznt {
    public zzns(Unsafe unsafe) {
        super(unsafe);
    }

    public final double zza(Object obj, long j) {
        return Double.longBitsToDouble(this.zza.getLong(obj, j));
    }

    public final float zzb(Object obj, long j) {
        return Float.intBitsToFloat(this.zza.getInt(obj, j));
    }

    public final void zzc(Object obj, long j, boolean z) {
        if (zznu.zzb) {
            zznu.zzi(obj, j, z);
        } else {
            zznu.zzj(obj, j, z);
        }
    }

    public final void zzd(Object obj, long j, byte b) {
        if (zznu.zzb) {
            zznu.zzk(obj, j, b);
        } else {
            zznu.zzl(obj, j, b);
        }
    }

    public final void zze(Object obj, long j, double d) {
        this.zza.putLong(obj, j, Double.doubleToLongBits(d));
    }

    public final void zzf(Object obj, long j, float f) {
        this.zza.putInt(obj, j, Float.floatToIntBits(f));
    }

    public final boolean zzg(Object obj, long j) {
        return zznu.zzb ? zznu.zzt(obj, j) : zznu.zzu(obj, j);
    }
}
