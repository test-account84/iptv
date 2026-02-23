package com.google.android.gms.internal.cast;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzvb {
    static final long zza;
    static final boolean zzb;
    private static final Unsafe zzc;
    private static final Class zzd;
    private static final boolean zze;
    private static final zzva zzf;
    private static final boolean zzg;
    private static final boolean zzh;

    /* JADX WARN: Removed duplicated region for block: B:9:0x003f  */
    static {
        /*
            Method dump skipped, instructions count: 307
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.cast.zzvb.<clinit>():void");
    }

    private zzvb() {
    }

    private static int zzA(Class cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    private static Field zzB() {
        int i = zzrb.zza;
        Field zzC = zzC(Buffer.class, "effectiveDirectAddress");
        if (zzC != null) {
            return zzC;
        }
        Field zzC2 = zzC(Buffer.class, "address");
        if (zzC2 == null || zzC2.getType() != Long.TYPE) {
            return null;
        }
        return zzC2;
    }

    private static Field zzC(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void zzD(Object obj, long j, byte b) {
        zzva zzvaVar = zzf;
        long j2 = (-4) & j;
        int i = zzvaVar.zza.getInt(obj, j2);
        int i2 = ((~((int) j)) & 3) << 3;
        zzvaVar.zza.putInt(obj, j2, ((255 & b) << i2) | (i & (~(255 << i2))));
    }

    private static void zzE(Object obj, long j, byte b) {
        zzva zzvaVar = zzf;
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        zzvaVar.zza.putInt(obj, j2, ((255 & b) << i) | (zzvaVar.zza.getInt(obj, j2) & (~(255 << i))));
    }

    public static double zza(Object obj, long j) {
        return zzf.zza(obj, j);
    }

    public static float zzb(Object obj, long j) {
        return zzf.zzb(obj, j);
    }

    public static int zzc(Object obj, long j) {
        return zzf.zza.getInt(obj, j);
    }

    public static long zzd(Object obj, long j) {
        return zzf.zza.getLong(obj, j);
    }

    public static Object zze(Class cls) {
        try {
            return zzc.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    public static Object zzf(Object obj, long j) {
        return zzf.zza.getObject(obj, j);
    }

    public static Unsafe zzg() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzux());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* bridge */ /* synthetic */ void zzh(Throwable th) {
        Logger.getLogger(zzvb.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    public static /* synthetic */ void zzi(Object obj, long j, boolean z) {
        zzD(obj, j, z ? (byte) 1 : (byte) 0);
    }

    public static /* synthetic */ void zzj(Object obj, long j, boolean z) {
        zzE(obj, j, z ? (byte) 1 : (byte) 0);
    }

    public static /* bridge */ /* synthetic */ void zzk(Object obj, long j, byte b) {
        zzD(obj, j, b);
    }

    public static /* bridge */ /* synthetic */ void zzl(Object obj, long j, byte b) {
        zzE(obj, j, b);
    }

    public static void zzm(Object obj, long j, boolean z) {
        zzf.zzc(obj, j, z);
    }

    public static void zzn(byte[] bArr, long j, byte b) {
        zzf.zzd(bArr, zza + j, b);
    }

    public static void zzo(Object obj, long j, double d) {
        zzf.zze(obj, j, d);
    }

    public static void zzp(Object obj, long j, float f) {
        zzf.zzf(obj, j, f);
    }

    public static void zzq(Object obj, long j, int i) {
        zzf.zza.putInt(obj, j, i);
    }

    public static void zzr(Object obj, long j, long j2) {
        zzf.zza.putLong(obj, j, j2);
    }

    public static void zzs(Object obj, long j, Object obj2) {
        zzf.zza.putObject(obj, j, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean zzt(Object obj, long j) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3))) & 255)) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean zzu(Object obj, long j) {
        return ((byte) ((zzf.zza.getInt(obj, (-4) & j) >>> ((int) ((j & 3) << 3))) & 255)) != 0;
    }

    public static boolean zzv(Class cls) {
        int i = zzrb.zza;
        try {
            Class cls2 = zzd;
            Class cls3 = Boolean.TYPE;
            cls2.getMethod("peekLong", new Class[]{cls, cls3});
            cls2.getMethod("pokeLong", new Class[]{cls, Long.TYPE, cls3});
            Class cls4 = Integer.TYPE;
            cls2.getMethod("pokeInt", new Class[]{cls, cls4, cls3});
            cls2.getMethod("peekInt", new Class[]{cls, cls3});
            cls2.getMethod("pokeByte", new Class[]{cls, Byte.TYPE});
            cls2.getMethod("peekByte", new Class[]{cls});
            cls2.getMethod("pokeByteArray", new Class[]{cls, byte[].class, cls4, cls4});
            cls2.getMethod("peekByteArray", new Class[]{cls, byte[].class, cls4, cls4});
            return true;
        } catch (Throwable unused) {
            return false;
        }
    }

    public static boolean zzw(Object obj, long j) {
        return zzf.zzg(obj, j);
    }

    public static boolean zzx() {
        return zzh;
    }

    public static boolean zzy() {
        return zzg;
    }

    private static int zzz(Class cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }
}
