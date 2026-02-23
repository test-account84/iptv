package com.google.android.recaptcha.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzlm extends zzgo implements zzhz {
    private static final zzlm zzb;
    private int zzd;
    private boolean zze;
    private zzfw zzf;
    private zzjd zzg;
    private int zzh;
    private zzkm zzi;
    private zzgv zzj = zzgo.zzw();

    static {
        zzlm zzlmVar = new zzlm();
        zzb = zzlmVar;
        zzgo.zzC(zzlm.class, zzlmVar);
    }

    private zzlm() {
    }

    public static /* synthetic */ zzlm zzf() {
        return zzb;
    }

    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgo.zzz(zzb, "\u0000\u0007\u0000\u0000\u0001\u0007\u0007\u0000\u0001\u0000\u0001\u0004\u0002\u0007\u0003\t\u0004\t\u0005\f\u0006\t\u0007\u001b", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", "zzj", zzld.class});
        }
        if (i2 == 3) {
            return new zzlm();
        }
        if (i2 == 4) {
            return new zzll(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
