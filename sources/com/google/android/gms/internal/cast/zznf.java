package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zznf extends zzsh implements zztq {
    private static final zznf zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private int zzh;

    static {
        zznf zznfVar = new zznf();
        zzb = zznfVar;
        zzsh.zzG(zznf.class, zznfVar);
    }

    private zznf() {
    }

    public static /* synthetic */ zznf zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001င\u0000\u0002င\u0001\u0003င\u0002\u0004င\u0003", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh"});
        }
        if (i2 == 3) {
            return new zznf();
        }
        if (i2 == 4) {
            return new zzne(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
