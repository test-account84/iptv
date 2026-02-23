package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzna extends zzsh implements zztq {
    private static final zzna zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzmc zzg;

    static {
        zzna zznaVar = new zzna();
        zzb = zznaVar;
        zzsh.zzG(zzna.class, zznaVar);
    }

    private zzna() {
    }

    public static /* synthetic */ zzna zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဋ\u0001\u0003ဉ\u0002", new Object[]{"zzd", "zze", zzhy.zza(), "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzna();
        }
        if (i2 == 4) {
            return new zzmz(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
