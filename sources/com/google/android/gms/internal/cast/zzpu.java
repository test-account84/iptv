package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzpu extends zzsh implements zztq {
    private static final zzpu zzb;
    private int zzd;
    private String zze = "";
    private long zzf;
    private long zzg;
    private zzpw zzh;

    static {
        zzpu zzpuVar = new zzpu();
        zzb = zzpuVar;
        zzsh.zzG(zzpu.class, zzpuVar);
    }

    private zzpu() {
    }

    public static /* synthetic */ zzpu zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004ဉ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzpu();
        }
        if (i2 == 4) {
            return new zzpt(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
