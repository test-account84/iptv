package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzmm extends zzsh implements zztq {
    private static final zzmm zzb;
    private int zzd;
    private int zze;

    static {
        zzmm zzmmVar = new zzmm();
        zzb = zzmmVar;
        zzsh.zzG(zzmm.class, zzmmVar);
    }

    private zzmm() {
    }

    public static /* synthetic */ zzmm zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzd", "zze", zzhd.zza()});
        }
        if (i2 == 3) {
            return new zzmm();
        }
        if (i2 == 4) {
            return new zzml(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
