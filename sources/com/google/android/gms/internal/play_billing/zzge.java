package com.google.android.gms.internal.play_billing;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzge extends zzcs implements zzed {
    private static final zzge zzb;
    private int zzd;
    private int zze = 0;
    private Object zzf;
    private int zzg;

    static {
        zzge zzgeVar = new zzge();
        zzb = zzgeVar;
        zzcs.zzt(zzge.class, zzgeVar);
    }

    private zzge() {
    }

    public static /* synthetic */ void zzA(zzge zzgeVar, zzhb zzhbVar) {
        zzhbVar.getClass();
        zzgeVar.zzf = zzhbVar;
        zzgeVar.zze = 2;
    }

    public static /* synthetic */ void zzB(zzge zzgeVar, int i) {
        zzgeVar.zzg = i - 1;
        zzgeVar.zzd |= 1;
    }

    public static zzgd zzy() {
        return (zzgd) zzb.zzg();
    }

    public static /* synthetic */ zzge zzz() {
        return zzb;
    }

    public final Object zzx(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzcs.zzq(zzb, "\u0001\u0003\u0001\u0001\u0001\u0003\u0003\u0000\u0000\u0000\u0001᠌\u0000\u0002<\u0000\u0003<\u0000", new Object[]{"zzf", "zze", "zzd", "zzg", zzgb.zza, zzhb.class, zzho.class});
        }
        if (i2 == 3) {
            return new zzge();
        }
        if (i2 == 4) {
            return new zzgd(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
