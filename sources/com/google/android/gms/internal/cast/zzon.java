package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzon extends zzsh implements zztq {
    private static final zzon zzb;
    private int zzd;
    private int zze;
    private String zzf = "";

    static {
        zzon zzonVar = new zzon();
        zzb = zzonVar;
        zzsh.zzG(zzon.class, zzonVar);
    }

    private zzon() {
    }

    public static /* synthetic */ zzon zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001င\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzon();
        }
        if (i2 == 4) {
            return new zzom(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
