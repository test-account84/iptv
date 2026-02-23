package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zznt extends zzsh implements zztq {
    private static final zznt zzb;
    private int zzd;
    private zzsp zze = zzsh.zzz();
    private boolean zzf;
    private boolean zzg;
    private long zzh;
    private long zzi;
    private long zzj;

    static {
        zznt zzntVar = new zznt();
        zzb = zzntVar;
        zzsh.zzG(zznt.class, zzntVar);
    }

    private zznt() {
    }

    public static /* synthetic */ zznt zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0006\u0000\u0001\u0001\u0006\u0006\u0000\u0001\u0000\u0001\u001b\u0002ဇ\u0000\u0003ဇ\u0001\u0004ဂ\u0002\u0005ဂ\u0003\u0006ဂ\u0004", new Object[]{"zzd", "zze", zznl.class, "zzf", "zzg", "zzh", "zzi", "zzj"});
        }
        if (i2 == 3) {
            return new zznt();
        }
        if (i2 == 4) {
            return new zzns(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
