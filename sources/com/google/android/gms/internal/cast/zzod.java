package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzod extends zzsh implements zztq {
    private static final zzod zzb;
    private int zzd;
    private int zze;
    private long zzf;
    private int zzg;

    static {
        zzod zzodVar = new zzod();
        zzb = zzodVar;
        zzsh.zzG(zzod.class, zzodVar);
    }

    private zzod() {
    }

    public static /* synthetic */ zzod zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဂ\u0001\u0003ဌ\u0002", new Object[]{"zzd", "zze", zzjf.zza(), "zzf", "zzg", zzha.zza()});
        }
        if (i2 == 3) {
            return new zzod();
        }
        if (i2 == 4) {
            return new zzoc(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
