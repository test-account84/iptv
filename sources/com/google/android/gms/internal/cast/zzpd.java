package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzpd extends zzsh implements zztq {
    private static final zzpd zzb;
    private int zzd;
    private zzmc zze;

    static {
        zzpd zzpdVar = new zzpd();
        zzb = zzpdVar;
        zzsh.zzG(zzpd.class, zzpdVar);
    }

    private zzpd() {
    }

    public static /* synthetic */ zzpd zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0001\u0000\u0001\u0001\u0001\u0001\u0000\u0000\u0000\u0001ဉ\u0000", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzpd();
        }
        if (i2 == 4) {
            return new zzpc(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
