package com.google.android.gms.internal.cast;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzmi extends zzsh implements zztq {
    private static final zzmi zzb;
    private int zzd;
    private zznc zze;
    private boolean zzf;
    private long zzg;
    private int zzh;
    private int zzi;
    private int zzj;
    private int zzk;
    private int zzl;
    private zzov zzm;
    private int zzn;
    private int zzo;
    private boolean zzp;
    private int zzq;
    private int zzr;
    private boolean zzs;

    static {
        zzmi zzmiVar = new zzmi();
        zzb = zzmiVar;
        zzsh.zzG(zzmi.class, zzmiVar);
    }

    private zzmi() {
    }

    public static zzmh zza() {
        return (zzmh) zzb.zzu();
    }

    public static zzmh zzc(zzmi zzmiVar) {
        zzse zzu = zzb.zzu();
        zzu.zzo(zzmiVar);
        return (zzmh) zzu;
    }

    public static /* synthetic */ zzmi zzd() {
        return zzb;
    }

    public static zzmi zze() {
        return zzb;
    }

    public static /* synthetic */ void zzf(zzmi zzmiVar, zznc zzncVar) {
        zzncVar.getClass();
        zzmiVar.zze = zzncVar;
        zzmiVar.zzd |= 1;
    }

    public static /* synthetic */ void zzg(zzmi zzmiVar, boolean z) {
        zzmiVar.zzd |= 2;
        zzmiVar.zzf = z;
    }

    public static /* synthetic */ void zzh(zzmi zzmiVar, long j) {
        zzmiVar.zzd |= 4;
        zzmiVar.zzg = j;
    }

    public static /* synthetic */ void zzi(zzmi zzmiVar, int i) {
        zzmiVar.zzd |= 64;
        zzmiVar.zzk = i;
    }

    public static /* synthetic */ void zzj(zzmi zzmiVar, int i) {
        zzmiVar.zzd |= 128;
        zzmiVar.zzl = i;
    }

    public static /* synthetic */ void zzk(zzmi zzmiVar, int i) {
        zzmiVar.zzd |= 1024;
        zzmiVar.zzo = i;
    }

    public static /* synthetic */ void zzl(zzmi zzmiVar, boolean z) {
        zzmiVar.zzd |= 2048;
        zzmiVar.zzp = z;
    }

    public static /* synthetic */ void zzm(zzmi zzmiVar, int i) {
        zzmiVar.zzd |= 4096;
        zzmiVar.zzq = i;
    }

    public static /* synthetic */ void zzn(zzmi zzmiVar, int i) {
        zzmiVar.zzd |= 8192;
        zzmiVar.zzr = i;
    }

    public static /* synthetic */ void zzo(zzmi zzmiVar, boolean z) {
        zzmiVar.zzd |= 16384;
        zzmiVar.zzs = z;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\u000f\u0000\u0001\u0001\u000f\u000f\u0000\u0000\u0000\u0001ဉ\u0000\u0002ဇ\u0001\u0003စ\u0002\u0004ဆ\u0003\u0005ဌ\u0004\u0006ဌ\u0005\u0007င\u0006\bင\u0007\tဉ\b\nဌ\t\u000bင\n\fဇ\u000b\rင\f\u000eင\r\u000fဇ\u000e", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", "zzi", zzgu.zza(), "zzj", zzgr.zza(), "zzk", "zzl", "zzm", "zzn", zzih.zza(), "zzo", "zzp", "zzq", "zzr", "zzs"});
        }
        if (i2 == 3) {
            return new zzmi();
        }
        if (i2 == 4) {
            return new zzmh(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
