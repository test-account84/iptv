package com.google.android.gms.internal.play_billing;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzho extends zzcs implements zzed {
    private static final zzho zzb;
    private int zzd;
    private int zze;

    static {
        zzho zzhoVar = new zzho();
        zzb = zzhoVar;
        zzcs.zzt(zzho.class, zzhoVar);
    }

    private zzho() {
    }

    public static /* synthetic */ zzho zzy() {
        return zzb;
    }

    public final Object zzx(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzcs.zzq(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001င\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzho();
        }
        if (i2 == 4) {
            return new zzhn(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
