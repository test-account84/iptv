package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzpn extends zzsh implements zztq {
    private static final zzpn zzb;
    private int zzd;
    private int zze;
    private int zzf;
    private zzsp zzg = zzsh.zzz();
    private zzsp zzh = zzsh.zzz();
    private int zzi;

    static {
        zzpn zzpnVar = new zzpn();
        zzb = zzpnVar;
        zzsh.zzG(zzpn.class, zzpnVar);
    }

    private zzpn() {
    }

    public static /* synthetic */ zzpn zza() {
        return zzb;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u0005\u0000\u0001\u0001\u0005\u0005\u0000\u0002\u0000\u0001ဌ\u0000\u0002ဌ\u0001\u0003\u001b\u0004\u001b\u0005ဌ\u0002", new Object[]{"zzd", "zze", zzlb.zza(), "zzf", zzle.zza(), "zzg", zznc.class, "zzh", zznc.class, "zzi", zzie.zza()});
        }
        if (i2 == 3) {
            return new zzpn();
        }
        if (i2 == 4) {
            return new zzpm(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
