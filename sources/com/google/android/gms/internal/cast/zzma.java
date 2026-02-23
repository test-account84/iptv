package com.google.android.gms.internal.cast;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class zzma extends zzsh implements zztq {
    private static final zzsn zzb = new zzly();
    private static final zzma zzd;
    private int zze;
    private zzmg zzf;
    private zzob zzg;
    private zzsp zzh = zzsh.zzz();
    private zzsm zzi = zzsh.zzx();

    static {
        zzma zzmaVar = new zzma();
        zzd = zzmaVar;
        zzsh.zzG(zzma.class, zzmaVar);
    }

    private zzma() {
    }

    public static zzlz zza() {
        return (zzlz) zzd.zzu();
    }

    public static /* synthetic */ zzma zzc() {
        return zzd;
    }

    public static /* synthetic */ void zzd(zzma zzmaVar, zzmg zzmgVar) {
        zzmgVar.getClass();
        zzmaVar.zzf = zzmgVar;
        zzmaVar.zze |= 1;
    }

    public static /* synthetic */ void zze(zzma zzmaVar, Iterable iterable) {
        zzsm zzsmVar = zzmaVar.zzi;
        if (!zzsmVar.zzc()) {
            int size = zzsmVar.size();
            zzmaVar.zzi = zzsmVar.zzf(size == 0 ? 10 : size + size);
        }
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            zzmaVar.zzi.zzh(((zzln) it.next()).zza());
        }
    }

    public final Object zzb(int i, Object obj, Object obj2) {
        int i2 = i - 1;
        if (i2 == 0) {
            return (byte) 1;
        }
        if (i2 == 2) {
            return zzsh.zzD(zzd, "\u0001\u0004\u0000\u0001\u0001\u0004\u0004\u0000\u0002\u0000\u0001ဉ\u0000\u0002ဉ\u0001\u0003\u001b\u0004\u001e", new Object[]{"zze", "zzf", "zzg", "zzh", zznx.class, "zzi", zzln.zzb()});
        }
        if (i2 == 3) {
            return new zzma();
        }
        if (i2 == 4) {
            return new zzlz(null);
        }
        if (i2 != 5) {
            return null;
        }
        return zzd;
    }
}
