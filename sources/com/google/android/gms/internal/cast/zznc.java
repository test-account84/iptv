package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zznc extends zzsh implements zztq {
    private static final zznc zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";

    static {
        zznc zzncVar = new zznc();
        zzb = zzncVar;
        zzsh.zzG(zznc.class, zzncVar);
    }

    private zznc() {
    }

    public static zznb zza() {
        return (zznb) zzb.zzu();
    }

    public static /* synthetic */ zznc zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zznc zzncVar, String str) {
        str.getClass();
        zzncVar.zzd |= 1;
        zzncVar.zze = str;
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
            return new zznc();
        }
        if (i2 == 4) {
            return new zznb(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
