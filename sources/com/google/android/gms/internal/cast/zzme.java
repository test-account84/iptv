package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzme extends zzsh implements zztq {
    private static final zzme zzb;
    private int zzd;
    private int zze;
    private boolean zzf;
    private int zzg;
    private boolean zzh;
    private zzsp zzi = zzsh.zzz();
    private zzsp zzj = zzsh.zzz();
    private String zzk = "";

    static {
        zzme zzmeVar = new zzme();
        zzb = zzmeVar;
        zzsh.zzG(zzme.class, zzmeVar);
    }

    private zzme() {
    }

    public static /* synthetic */ zzme zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0007\u0000\u0001\u0001\t\u0007\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဇ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0007\u001b\b\u001b\tဈ\u0004", new Object[]{"zzd", "zze", zzgo.zza(), "zzf", "zzg", zzie.zza(), "zzh", "zzi", zzon.class, "zzj", zzon.class, "zzk"});
        }
        if (i2 == 3) {
            return new zzme();
        }
        if (i2 == 4) {
            return new zzmd(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
