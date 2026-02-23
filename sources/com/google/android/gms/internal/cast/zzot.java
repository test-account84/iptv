package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzot extends zzsh implements zztq {
    private static final zzot zzb;
    private int zzd;
    private zzsp zze = zzsh.zzz();
    private zzsp zzf = zzsh.zzz();
    private zzpd zzg;

    static {
        zzot zzotVar = new zzot();
        zzb = zzotVar;
        zzsh.zzG(zzot.class, zzotVar);
    }

    private zzot() {
    }

    public static /* synthetic */ zzot zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001\u001b\u0002\u001b\u0003ဉ\u0000", new Object[]{"zzd", "zze", zzpj.class, "zzf", zzna.class, "zzg"});
        }
        if (i2 == 3) {
            return new zzot();
        }
        if (i2 == 4) {
            return new zzos(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
