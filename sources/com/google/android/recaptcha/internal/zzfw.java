package com.google.android.recaptcha.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzfw extends zzgo implements zzhz {
    private static final zzfw zzb;
    private long zzd;
    private int zze;

    static {
        zzfw zzfwVar = new zzfw();
        zzb = zzfwVar;
        zzgo.zzC(zzfw.class, zzfwVar);
    }

    private zzfw() {
    }

    public static zzfv zzi() {
        return (zzfv) zzb.zzp();
    }

    public static /* synthetic */ zzfw zzj() {
        return zzb;
    }

    public static /* synthetic */ void zzk(zzfw zzfwVar, long j) {
        zzfwVar.zzd = j;
    }

    public static /* synthetic */ void zzl(zzfw zzfwVar, int i) {
        zzfwVar.zze = i;
    }

    public final int zzf() {
        return this.zze;
    }

    public final long zzg() {
        return this.zzd;
    }

    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return new zzij(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0000\u0000\u0001\u0002\u0002\u0004", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzfw();
        }
        if (i2 == 4) {
            return new zzfv(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
