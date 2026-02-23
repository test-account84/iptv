package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzms extends zzsh implements zztq {
    private static final zzms zzb;
    private int zzd;
    private String zze = "";
    private long zzf;

    static {
        zzms zzmsVar = new zzms();
        zzb = zzmsVar;
        zzsh.zzG(zzms.class, zzmsVar);
    }

    private zzms() {
    }

    public static zzmr zza() {
        return (zzmr) zzb.zzu();
    }

    public static /* synthetic */ zzms zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzms zzmsVar, String str) {
        str.getClass();
        zzmsVar.zzd |= 1;
        zzmsVar.zze = str;
    }

    public static /* synthetic */ void zze(zzms zzmsVar, long j) {
        zzmsVar.zzd |= 2;
        zzmsVar.zzf = j;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0002\u0000\u0001\u0001\u0002\u0002\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဂ\u0001", new Object[]{"zzd", "zze", "zzf"});
        }
        if (i2 == 3) {
            return new zzms();
        }
        if (i2 == 4) {
            return new zzmr(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
