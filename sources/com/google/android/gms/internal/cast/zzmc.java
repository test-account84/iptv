package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzmc extends zzsh implements zztq {
    private static final zzmc zzb;
    private int zzd;
    private int zze;
    private double zzf;
    private double zzg;
    private double zzh;
    private double zzi;

    static {
        zzmc zzmcVar = new zzmc();
        zzb = zzmcVar;
        zzsh.zzG(zzmc.class, zzmcVar);
    }

    private zzmc() {
    }

    public static /* synthetic */ zzmc zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဋ\u0000\u0002က\u0001\u0003က\u0002\u0004က\u0003\u0005က\u0004", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzmc();
        }
        if (i2 == 4) {
            return new zzmb(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
