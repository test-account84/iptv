package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzmg extends zzsh implements zztq {
    private static final zzmg zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zzmg zzmgVar = new zzmg();
        zzb = zzmgVar;
        zzsh.zzG(zzmg.class, zzmgVar);
    }

    private zzmg() {
    }

    public static zzmf zza() {
        return (zzmf) zzb.zzu();
    }

    public static /* synthetic */ zzmg zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzmg zzmgVar, String str) {
        str.getClass();
        zzmgVar.zzd |= 1;
        zzmgVar.zze = str;
    }

    public static /* synthetic */ void zze(zzmg zzmgVar, String str) {
        str.getClass();
        zzmgVar.zzd |= 2;
        zzmgVar.zzf = str;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzmg();
        }
        if (i2 == 4) {
            return new zzmf(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
