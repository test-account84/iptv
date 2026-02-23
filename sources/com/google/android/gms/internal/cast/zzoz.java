package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzoz extends zzsh implements zztq {
    private static final zzoz zzb;
    private int zzd;
    private long zze;
    private long zzf;
    private zzsp zzg = zzsh.zzz();

    static {
        zzoz zzozVar = new zzoz();
        zzb = zzozVar;
        zzsh.zzG(zzoz.class, zzozVar);
    }

    private zzoz() {
    }

    public static /* synthetic */ zzoz zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဂ\u0000\u0002ဂ\u0001\u0003\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", zzpb.class});
        }
        if (i2 == 3) {
            return new zzoz();
        }
        if (i2 == 4) {
            return new zzoy(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
