package com.google.android.recaptcha.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzlg extends zzgo implements zzhz {
    private static final zzlg zzb;
    private zzfw zzd;
    private zzjd zze;
    private zzfw zzf;
    private zzjd zzg;

    static {
        zzlg zzlgVar = new zzlg();
        zzb = zzlgVar;
        zzgo.zzC(zzlg.class, zzlgVar);
    }

    private zzlg() {
    }

    public static /* synthetic */ void zzG(zzlg zzlgVar, zzfw zzfwVar) {
        zzfwVar.getClass();
        zzlgVar.zzf = zzfwVar;
    }

    public static zzlf zzf() {
        return (zzlf) zzb.zzp();
    }

    public static /* synthetic */ zzlg zzg() {
        return zzb;
    }

    public static /* synthetic */ void zzi(zzlg zzlgVar, zzfw zzfwVar) {
        zzfwVar.getClass();
        zzlgVar.zzd = zzfwVar;
    }

    public static /* synthetic */ void zzj(zzlg zzlgVar, zzjd zzjdVar) {
        zzjdVar.getClass();
        zzlgVar.zzg = zzjdVar;
    }

    public static /* synthetic */ void zzk(zzlg zzlgVar, zzjd zzjdVar) {
        zzjdVar.getClass();
        zzlgVar.zze = zzjdVar;
    }

    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgo.zzz(zzb, "\u0000\u0004\u0000\u0000\u0001\u0004\u0004\u0000\u0000\u0000\u0001\t\u0002\t\u0003\t\u0004\t", new Object[]{"zzd", "zze", "zzf", "zzg"});
        }
        if (i2 == 3) {
            return new zzlg();
        }
        if (i2 == 4) {
            return new zzlf(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
