package com.google.android.gms.internal.play_billing;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzgu extends zzcs implements zzed {
    private static final zzgu zzb;
    private int zzd;
    private String zze = "";
    private String zzf = "";
    private int zzg;

    static {
        zzgu zzguVar = new zzgu();
        zzb = zzguVar;
        zzcs.zzt(zzgu.class, zzguVar);
    }

    private zzgu() {
    }

    public static /* synthetic */ void zzA(zzgu zzguVar, String str) {
        str.getClass();
        zzguVar.zzd |= 1;
        zzguVar.zze = str;
    }

    public static /* synthetic */ void zzB(zzgu zzguVar, String str) {
        str.getClass();
        zzguVar.zzd |= 2;
        zzguVar.zzf = str;
    }

    public static /* synthetic */ void zzC(zzgu zzguVar, int i) {
        zzguVar.zzd |= 4;
        zzguVar.zzg = i;
    }

    public static zzgt zzy() {
        return (zzgt) zzb.zzg();
    }

    public static /* synthetic */ zzgu zzz() {
        return zzb;
    }

    public final Object zzx(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzcs.zzq(zzb, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001ဈ\u0000\u0002ဈ\u0001\u0003င\u0002", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzgu();
        }
        if (i2 == 4) {
            return new zzgt(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
