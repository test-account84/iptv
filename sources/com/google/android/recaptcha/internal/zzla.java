package com.google.android.recaptcha.internal;

import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzla extends zzgo implements zzhz {
    private static final zzla zzb;
    private zzgv zzd = zzgo.zzw();

    static {
        zzla zzlaVar = new zzla();
        zzb = zzlaVar;
        zzgo.zzC(zzla.class, zzlaVar);
    }

    private zzla() {
    }

    public static zzkz zzf() {
        return (zzkz) zzb.zzp();
    }

    public static /* synthetic */ zzla zzg() {
        return zzb;
    }

    public static zzla zzi(byte[] bArr) throws zzgy {
        return (zzla) zzgo.zzu(zzb, bArr);
    }

    public static /* synthetic */ void zzk(zzla zzlaVar, zzkx zzkxVar) {
        zzkxVar.getClass();
        zzgv zzgvVar = zzlaVar.zzd;
        if (!zzgvVar.zzc()) {
            zzlaVar.zzd = zzgo.zzx(zzgvVar);
        }
        zzlaVar.zzd.add(zzkxVar);
    }

    public final Object zzh(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzgo.zzz(zzb, "\u0000\u0001\u0000\u0000\u0001\u0001\u0001\u0000\u0001\u0000\u0001\u001b", new Object[]{"zzd", zzkx.class});
        }
        if (i2 == 3) {
            return new zzla();
        }
        if (i2 == 4) {
            return new zzkz(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }

    public final List zzj() {
        return this.zzd;
    }
}
