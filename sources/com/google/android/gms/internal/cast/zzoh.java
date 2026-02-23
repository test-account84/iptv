package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzoh extends zzsh implements zztq {
    private static final zzoh zzb;
    private int zzd;
    private long zze;
    private zzso zzf = zzsh.zzy();
    private zzso zzg = zzsh.zzy();

    static {
        zzoh zzohVar = new zzoh();
        zzb = zzohVar;
        zzsh.zzG(zzoh.class, zzohVar);
    }

    private zzoh() {
    }

    public static /* synthetic */ zzoh zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0002\u0000\u0001စ\u0000\u0002\u0017\u0003\u0017", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzoh();
        }
        if (i2 == 4) {
            return new zzog(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
