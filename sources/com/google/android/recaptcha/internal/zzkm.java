package com.google.android.recaptcha.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzkm extends zzgo implements zzhz {
    private static final zzkm zzb;
    private int zzf;
    private int zzi;
    private String zzd = "";
    private String zze = "";
    private String zzg = "";
    private String zzh = "";

    static {
        zzkm zzkmVar = new zzkm();
        zzb = zzkmVar;
        zzgo.zzC(zzkm.class, zzkmVar);
    }

    private zzkm() {
    }

    public static /* synthetic */ void zzG(zzkm zzkmVar, String str) {
        str.getClass();
        zzkmVar.zzd = str;
    }

    public static /* synthetic */ void zzH(zzkm zzkmVar, String str) {
        zzkmVar.zzh = str;
    }

    public static /* synthetic */ void zzI(zzkm zzkmVar, int i) {
        zzkmVar.zzf = i;
    }

    public static zzkl zzg() {
        return (zzkl) zzb.zzp();
    }

    public static /* synthetic */ zzkm zzi() {
        return zzb;
    }

    public static zzkm zzj() {
        return zzb;
    }

    public final int zzf() {
        return this.zzf;
    }

    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgo.zzz(zzb, "\u0000\u0006\u0000\u0000\u0001\u0006\u0006\u0000\u0000\u0000\u0001Ȉ\u0002\u0004\u0003Ȉ\u0004\u0004\u0005Ȉ\u0006Ȉ", new Object[]{"zzd", "zzf", "zzh", "zzi", "zze", "zzg"});
        }
        if (i2 == 3) {
            return new zzkm();
        }
        if (i2 == 4) {
            return new zzkl(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final String zzk() {
        return this.zzd;
    }
}
