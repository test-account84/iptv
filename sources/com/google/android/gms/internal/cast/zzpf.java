package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzpf extends zzsh implements zztq {
    private static final zzpf zzb;
    private int zzd;
    private long zze;
    private boolean zzf;
    private long zzg;
    private boolean zzh;

    static {
        zzpf zzpfVar = new zzpf();
        zzb = zzpfVar;
        zzsh.zzG(zzpf.class, zzpfVar);
    }

    private zzpf() {
    }

    public static /* synthetic */ zzpf zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001ဂ\u0000\u0002ဇ\u0001\u0003ဂ\u0002\u0004ဇ\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zzpf();
        }
        if (i2 == 4) {
            return new zzpe(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
