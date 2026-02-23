package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzlx extends zzsh implements zztq {
    private static final zzsn zzb = new zzlv();
    private static final zzlx zzd;
    private int zze;
    private String zzf = "";
    private String zzg = "";
    private zzsm zzh = zzsh.zzx();

    static {
        zzlx zzlxVar = new zzlx();
        zzd = zzlxVar;
        zzsh.zzG(zzlx.class, zzlxVar);
    }

    private zzlx() {
    }

    public static /* synthetic */ zzlx zza() {
        return zzd;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzd, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003\u001e", new Object[]{"zze", "zzf", "zzg", "zzh", zzln.zzb()});
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
        return zzd;
    }
}
