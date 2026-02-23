package com.google.android.gms.internal.measurement;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzfb extends zzlb implements zzmj {
    private static final zzfb zza;
    private int zzd;
    private String zze = "";
    private zzli zzf = zzlb.zzbH();
    private boolean zzg;

    static {
        zzfb zzfbVar = new zzfb();
        zza = zzfbVar;
        zzlb.zzbO(zzfb.class, zzfbVar);
    }

    private zzfb() {
    }

    public static /* synthetic */ zzfb zza() {
        return zza;
    }

    public final String zzb() {
        return this.zze;
    }

    public final Object zzl(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzlb.zzbL(zza, "\u0001\u0003\u0000\u0001\u0001\u0003\u0003\u0000\u0001\u0000\u0001ဈ\u0000\u0002\u001b\u0003ဇ\u0001", new Object[]{"zzd", "zze", "zzf", zzfh.class, "zzg"});
        }
        if (i2 == 3) {
            return new zzfb();
        }
        if (i2 == 4) {
            return new zzfa(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zza;
    }
}
