package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzph extends zzsh implements zztq {
    private static final zzph zzb;
    private int zzd;
    private String zze = "";

    static {
        zzph zzphVar = new zzph();
        zzb = zzphVar;
        zzsh.zzG(zzph.class, zzphVar);
    }

    private zzph() {
    }

    public static /* synthetic */ zzph zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဈ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzph();
        }
        if (i2 == 4) {
            return new zzpg(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
