package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zznp extends zzsh implements zztq {
    private static final zznp zzb;
    private int zzd;
    private int zze;

    static {
        zznp zznpVar = new zznp();
        zzb = zznpVar;
        zzsh.zzG(zznp.class, zznpVar);
    }

    private zznp() {
    }

    public static /* synthetic */ zznp zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဌ\u0000", new Object[]{"zzd", "zze", zziq.zza()});
        }
        if (i2 == 3) {
            return new zznp();
        }
        if (i2 == 4) {
            return new zzno(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
