package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzpb extends zzsh implements zztq {
    private static final zzpb zzb;
    private int zzd;
    private String zze = "";
    private zzsp zzf = zzsh.zzz();
    private zzsp zzg = zzsh.zzz();
    private boolean zzh;

    static {
        zzpb zzpbVar = new zzpb();
        zzb = zzpbVar;
        zzsh.zzG(zzpb.class, zzpbVar);
    }

    private zzpb() {
    }

    public static /* synthetic */ zzpb zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဈ\u0000\u0002\u001b\u0003\u001b\u0004ဇ\u0001", new Object[]{"zzd", "zze", "zzf", zznr.class, "zzg", zznc.class, "zzh"});
        }
        if (i2 == 3) {
            return new zzpb();
        }
        if (i2 == 4) {
            return new zzpa(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
