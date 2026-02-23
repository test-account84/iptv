package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zznz extends zzsh implements zztq {
    private static final zznz zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private byte zzh = 2;

    static {
        zznz zznzVar = new zznz();
        zzb = zznzVar;
        zzsh.zzG(zznz.class, zznzVar);
    }

    private zznz() {
    }

    public static /* synthetic */ zznz zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzh);
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0001\u0001ᔌ\u0000\u0002င\u0001\u0003ဌ\u0002", new Object[]{"zzd", "zze", zzjc.zza(), "zzf", "zzg", zzlt.zza()});
        }
        if (i2 == 3) {
            return new zznz();
        }
        if (i2 == 4) {
            return new zzny(null);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzh = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
