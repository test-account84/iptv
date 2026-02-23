package com.google.android.recaptcha.internal;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzmp extends zzgo implements zzhz {
    private static final zzmp zzb;
    private String zzd = "";
    private zzgt zze = zzgo.zzv();

    static {
        zzmp zzmpVar = new zzmp();
        zzb = zzmpVar;
        zzgo.zzC(zzmp.class, zzmpVar);
    }

    private zzmp() {
    }

    public static /* synthetic */ zzmp zzf() {
        return zzb;
    }

    public static zzmp zzg(byte[] bArr) throws zzgy {
        return (zzmp) zzgo.zzu(zzb, bArr);
    }

    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgo.zzz(zzb, "\u0000\u0002\u0000\u0000\u0001\u0002\u0002\u0000\u0001\u0000\u0001Ȉ\u0002'", new Object[]{"zzd", "zze"});
        }
        if (i2 == 3) {
            return new zzmp();
        }
        if (i2 == 4) {
            return new zzmo(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final String zzi() {
        return this.zzd;
    }

    public final List zzj() {
        return this.zze;
    }
}
