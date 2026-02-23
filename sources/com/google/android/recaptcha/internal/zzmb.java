package com.google.android.recaptcha.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzmb extends zzgo implements zzhz {
    private static final zzmb zzb;
    private String zzd = "";
    private String zze = "";

    static {
        zzmb zzmbVar = new zzmb();
        zzb = zzmbVar;
        zzgo.zzC(zzmb.class, zzmbVar);
    }

    private zzmb() {
    }

    public static zzma zzf() {
        return (zzma) zzb.zzp();
    }

    public static /* synthetic */ zzmb zzg() {
        return zzb;
    }

    public static /* synthetic */ void zzi(zzmb zzmbVar, String str) {
        str.getClass();
        zzmbVar.zzd = str;
    }

    public static /* synthetic */ void zzj(zzmb zzmbVar, String str) {
        str.getClass();
        zzmbVar.zze = str;
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
            return new zzmb();
        }
        if (i2 == 4) {
            return new zzma(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
