package com.google.android.recaptcha.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzks extends zzgo implements zzhz {
    private static final zzks zzb;
    private String zzd = "";
    private String zze = "";

    static {
        zzks zzksVar = new zzks();
        zzb = zzksVar;
        zzgo.zzC(zzks.class, zzksVar);
    }

    private zzks() {
    }

    public static /* synthetic */ zzks zzf() {
        return zzb;
    }

    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgo.zzz(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001Ȉ\u0002Ȉ", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzks();
        }
        if (i2 == 4) {
            return new zzkr(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
