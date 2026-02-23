package com.google.android.gms.internal.cast;

import java.util.ArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzmu extends zzsh implements zztq {
    private static final zzmu zzb;
    private int zzd;
    private long zzf;
    private long zzg;
    private int zzi;
    private boolean zzj;
    private long zzl;
    private long zzm;
    private String zze = "";
    private zzsp zzh = zzsh.zzz();
    private String zzk = "";

    static {
        zzmu zzmuVar = new zzmu();
        zzb = zzmuVar;
        zzsh.zzG(zzmu.class, zzmuVar);
    }

    private zzmu() {
    }

    public static zzmt zza() {
        return (zzmt) zzb.zzu();
    }

    public static /* synthetic */ zzmu zzc() {
        return zzb;
    }

    public static /* synthetic */ void zzd(zzmu zzmuVar, String str) {
        str.getClass();
        zzmuVar.zzd |= 1;
        zzmuVar.zze = str;
    }

    public static /* synthetic */ void zze(zzmu zzmuVar, long j) {
        zzmuVar.zzd |= 2;
        zzmuVar.zzf = j;
    }

    public static /* synthetic */ void zzf(zzmu zzmuVar, long j) {
        zzmuVar.zzd |= 4;
        zzmuVar.zzg = j;
    }

    public static /* synthetic */ void zzg(zzmu zzmuVar, Iterable iterable) {
        zzsp zzspVar = zzmuVar.zzh;
        if (!zzspVar.zzc()) {
            zzmuVar.zzh = zzsh.zzA(zzspVar);
        }
        ArrayList arrayList = zzmuVar.zzh;
        byte[] bArr = zzsq.zzd;
        if (arrayList instanceof ArrayList) {
            arrayList.ensureCapacity(arrayList.size() + iterable.size());
        }
        int size = arrayList.size();
        for (Object obj : iterable) {
            if (obj == null) {
                String str = "Element at index " + (arrayList.size() - size) + " is null.";
                int size2 = arrayList.size();
                while (true) {
                    size2--;
                    if (size2 < size) {
                        throw new NullPointerException(str);
                    }
                    arrayList.remove(size2);
                }
            } else {
                arrayList.add(obj);
            }
        }
    }

    public static /* synthetic */ void zzh(zzmu zzmuVar, int i) {
        zzmuVar.zzd |= 8;
        zzmuVar.zzi = i;
    }

    public static /* synthetic */ void zzi(zzmu zzmuVar, boolean z) {
        zzmuVar.zzd |= 16;
        zzmuVar.zzj = z;
    }

    public static /* synthetic */ void zzj(zzmu zzmuVar, String str) {
        str.getClass();
        zzmuVar.zzd |= 32;
        zzmuVar.zzk = str;
    }

    public static /* synthetic */ void zzk(zzmu zzmuVar, long j) {
        zzmuVar.zzd |= 64;
        zzmuVar.zzl = j;
    }

    public static /* synthetic */ void zzl(zzmu zzmuVar, long j) {
        zzmuVar.zzd |= 128;
        zzmuVar.zzm = j;
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzb, "\u0001\t\u0000\u0001\u0001\t\t\u0000\u0001\u0000\u0001ဈ\u0000\u0002ဂ\u0001\u0003ဂ\u0002\u0004\u001b\u0005င\u0003\u0006ဇ\u0004\u0007ဈ\u0005\bဂ\u0006\tဂ\u0007", new Object[]{"zzd", "zze", "zzf", "zzg", "zzh", zzms.class, "zzi", "zzj", "zzk", "zzl", "zzm"});
        }
        if (i2 == 3) {
            return new zzmu();
        }
        if (i2 == 4) {
            return new zzmt(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzb;
    }
}
