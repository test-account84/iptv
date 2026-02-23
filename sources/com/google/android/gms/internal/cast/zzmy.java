package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzmy extends zzsh implements zztq {
    private static final zzmy zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private long zzg;

    static {
        zzmy zzmyVar = new zzmy();
        zzb = zzmyVar;
        zzsh.zzG(zzmy.class, zzmyVar);
    }

    private zzmy() {
    }

    public static /* synthetic */ zzmy zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0004\u0001\u0001\u0001\u0004\u0004\u0000\u0000\u0000\u0001စ\u0000\u0002:\u0000\u00035\u0000\u00048\u0000", new Object[]{"zzf", "zze", "zzd", "zzg"});
        }
        if (i2 == 3) {
            return new zzmy();
        }
        if (i2 == 4) {
            return new zzmx(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
