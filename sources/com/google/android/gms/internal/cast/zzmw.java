package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzmw extends zzsh implements zztq {
    private static final zzmw zzb;
    private int zzd;
    private int zze;
    private int zzf;

    static {
        zzmw zzmwVar = new zzmw();
        zzb = zzmwVar;
        zzsh.zzG(zzmw.class, zzmwVar);
    }

    private zzmw() {
    }

    public static /* synthetic */ zzmw zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001", new Object[]{"zzd", "zze", zzhs.zza(), "zzf", zzhp.zza()});
        }
        if (i2 == 3) {
            return new zzmw();
        }
        if (i2 == 4) {
            return new zzmv(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
