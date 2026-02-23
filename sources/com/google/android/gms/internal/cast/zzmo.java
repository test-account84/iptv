package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzmo extends zzsh implements zztq {
    private static final zzmo zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private int zzg;
    private boolean zzh;
    private int zzi;

    static {
        zzmo zzmoVar = new zzmo();
        zzb = zzmoVar;
        zzsh.zzG(zzmo.class, zzmoVar);
    }

    private zzmo() {
    }

    public static /* synthetic */ zzmo zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0000\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003ဌ\u0002\u0004ဇ\u0003\u0005င\u0004", new Object[]{"zzd", "zze", zzka.zza(), "zzf", zzju.zza(), "zzg", zzjx.zza(), "zzh", "zzi"});
        }
        if (i2 == 3) {
            return new zzmo();
        }
        if (i2 == 4) {
            return new zzmn(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
