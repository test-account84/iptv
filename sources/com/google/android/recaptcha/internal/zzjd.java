package com.google.android.recaptcha.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzjd extends zzgo implements zzhz {
    private static final zzjd zzb;
    private long zzd;
    private int zze;

    static {
        zzjd zzjdVar = new zzjd();
        zzb = zzjdVar;
        zzgo.zzC(zzjd.class, zzjdVar);
    }

    private zzjd() {
    }

    public static /* synthetic */ void zzG(zzjd zzjdVar, int i) {
        zzjdVar.zze = i;
    }

    public static zzjc zzi() {
        return (zzjc) zzb.zzp();
    }

    public static /* synthetic */ zzjd zzj() {
        return zzb;
    }

    public static /* synthetic */ void zzk(zzjd zzjdVar, long j) {
        zzjdVar.zzd = j;
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
            return new zzjd();
        }
        if (i2 == 4) {
            return new zzjc(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
