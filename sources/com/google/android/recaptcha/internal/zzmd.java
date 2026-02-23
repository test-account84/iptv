package com.google.android.recaptcha.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzmd extends zzgo implements zzhz {
    private static final zzmd zzb;
    private int zzd;

    static {
        zzmd zzmdVar = new zzmd();
        zzb = zzmdVar;
        zzgo.zzC(zzmd.class, zzmdVar);
    }

    private zzmd() {
    }

    public static /* synthetic */ zzmd zzf() {
        return zzb;
    }

    public static zzmd zzg(byte[] bArr) throws zzgy {
        return (zzmd) zzgo.zzu(zzb, bArr);
    }

    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgo.zzz(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0000\u0000\u0001\f", new Object[]{"zzd"});
        }
        if (i2 == 3) {
            return new zzmd();
        }
        if (i2 == 4) {
            return new zzmc(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final zzmf zzi() {
        zzmf zzb2 = zzmf.zzb(this.zzd);
        return zzb2 == null ? zzmf.zzk : zzb2;
    }
}
