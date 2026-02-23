package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzob extends zzsh implements zztq {
    private static final zzob zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzob zzobVar = new zzob();
        zzb = zzobVar;
        zzsh.zzG(zzob.class, zzobVar);
    }

    private zzob() {
    }

    public static /* synthetic */ zzob zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzob();
        }
        if (i2 == 4) {
            return new zzoa(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
