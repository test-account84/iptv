package com.google.android.recaptcha.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzlx extends zzgo implements zzhz {
    private static final zzlx zzb;
    private String zzd = "";
    private String zze = "";
    private String zzf = "";

    static {
        zzlx zzlxVar = new zzlx();
        zzb = zzlxVar;
        zzgo.zzC(zzlx.class, zzlxVar);
    }

    private zzlx() {
    }

    public static /* synthetic */ zzlx zzf() {
        return zzb;
    }

    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgo.zzz(zzb, "\u0000\u0003\u0000\u0000\u0001\u0003\u0003\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ\u0003Ȉ", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzlx();
        }
        if (i2 == 4) {
            return new zzlw(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
