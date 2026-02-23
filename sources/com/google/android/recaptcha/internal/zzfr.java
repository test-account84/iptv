package com.google.android.recaptcha.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzfr extends zzgo implements zzhz {
    private static final zzfr zzb;
    private int zzd;
    private boolean zzf;
    private byte zzg = 2;
    private String zze = "";

    static {
        zzfr zzfrVar = new zzfr();
        zzb = zzfrVar;
        zzgo.zzC(zzfr.class, zzfrVar);
    }

    private zzfr() {
    }

    public static /* synthetic */ zzfr zzf() {
        return zzb;
    }

    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return Byte.valueOf(this.zzg);
        }
        if (i2 == 2) {
            return new zzij(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0002\u0001ᔈ\u0000\u0002ᔇ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzfr();
        }
        if (i2 == 4) {
            return new zzfq(null);
        }
        if (i2 == 5) {
            return zzb;
        }
        this.zzg = obj == null ? (byte) 0 : (byte) 1;
        return null;
    }
}
