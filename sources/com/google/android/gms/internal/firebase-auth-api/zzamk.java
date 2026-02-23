package com.google.android.gms.internal.firebase-auth-api;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class zzamk {
    static final boolean zza;
    private static final Unsafe zzb;
    private static final Class zzc;
    private static final boolean zzd;
    private static final boolean zze;
    private static final zzc zzf;
    private static final boolean zzg;
    private static final boolean zzh;
    private static final long zzi;
    private static final long zzj;
    private static final long zzk;
    private static final long zzl;
    private static final long zzm;
    private static final long zzn;
    private static final long zzo;
    private static final long zzp;
    private static final long zzq;
    private static final long zzr;
    private static final long zzs;
    private static final long zzt;
    private static final long zzu;
    private static final long zzv;
    private static final int zzw;

    public static final class zza extends zzc {
        public zza(Unsafe unsafe) {
            super(unsafe);
        }

        public final double zza(Object obj, long j) {
            return Double.longBitsToDouble(zze(obj, j));
        }

        public final float zzb(Object obj, long j) {
            return Float.intBitsToFloat(zzd(obj, j));
        }

        public final boolean zzc(Object obj, long j) {
            return zzamk.zza ? zzamk.zzf(obj, j) : zzamk.zzg(obj, j);
        }

        public final void zza(Object obj, long j, byte b) {
            if (zzamk.zza) {
                zzamk.zza(obj, j, b);
            } else {
                zzamk.zzb(obj, j, b);
            }
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzamk.zza) {
                zzamk.zza(obj, j, z);
            } else {
                zzamk.zzb(obj, j, z);
            }
        }
    }

    public static final class zzb extends zzc {
        public zzb(Unsafe unsafe) {
            super(unsafe);
        }

        public final double zza(Object obj, long j) {
            return Double.longBitsToDouble(zze(obj, j));
        }

        public final float zzb(Object obj, long j) {
            return Float.intBitsToFloat(zzd(obj, j));
        }

        public final boolean zzc(Object obj, long j) {
            return zzamk.zza ? zzamk.zzf(obj, j) : zzamk.zzg(obj, j);
        }

        public final void zza(Object obj, long j, byte b) {
            if (zzamk.zza) {
                zzamk.zza(obj, j, b);
            } else {
                zzamk.zzb(obj, j, b);
            }
        }

        public final void zza(Object obj, long j, double d) {
            zza(obj, j, Double.doubleToLongBits(d));
        }

        public final void zza(Object obj, long j, float f) {
            zza(obj, j, Float.floatToIntBits(f));
        }

        public final void zza(Object obj, long j, boolean z) {
            if (zzamk.zza) {
                zzamk.zza(obj, j, z);
            } else {
                zzamk.zzb(obj, j, z);
            }
        }
    }

    public static abstract class zzc {
        Unsafe zza;

        public zzc(Unsafe unsafe) {
            this.zza = unsafe;
        }

        public abstract double zza(Object obj, long j);

        public abstract void zza(Object obj, long j, byte b);

        public abstract void zza(Object obj, long j, double d);

        public abstract void zza(Object obj, long j, float f);

        public final void zza(Object obj, long j, int i) {
            this.zza.putInt(obj, j, i);
        }

        public abstract void zza(Object obj, long j, boolean z);

        public abstract float zzb(Object obj, long j);

        public final boolean zzb() {
            Unsafe unsafe = this.zza;
            if (unsafe == null) {
                return false;
            }
            try {
                Class cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls.getMethod("getLong", new Class[]{Object.class, Long.TYPE});
                return zzamk.zza() != null;
            } catch (Throwable th) {
                zzamk.zza(th);
                return false;
            }
        }

        public abstract boolean zzc(Object obj, long j);

        public final int zzd(Object obj, long j) {
            return this.zza.getInt(obj, j);
        }

        public final long zze(Object obj, long j) {
            return this.zza.getLong(obj, j);
        }

        public final void zza(Object obj, long j, long j2) {
            this.zza.putLong(obj, j, j2);
        }

        public final boolean zza() {
            Unsafe unsafe = this.zza;
            if (unsafe == null) {
                return false;
            }
            try {
                Class cls = unsafe.getClass();
                cls.getMethod("objectFieldOffset", new Class[]{Field.class});
                cls.getMethod("arrayBaseOffset", new Class[]{Class.class});
                cls.getMethod("arrayIndexScale", new Class[]{Class.class});
                Class cls2 = Long.TYPE;
                cls.getMethod("getInt", new Class[]{Object.class, cls2});
                cls.getMethod("putInt", new Class[]{Object.class, cls2, Integer.TYPE});
                cls.getMethod("getLong", new Class[]{Object.class, cls2});
                cls.getMethod("putLong", new Class[]{Object.class, cls2, cls2});
                cls.getMethod("getObject", new Class[]{Object.class, cls2});
                cls.getMethod("putObject", new Class[]{Object.class, cls2, Object.class});
                return true;
            } catch (Throwable th) {
                zzamk.zza(th);
                return false;
            }
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x002e  */
    static {
        /*
            sun.misc.Unsafe r0 = zzb()
            com.google.android.gms.internal.firebase-auth-api.zzamk.zzb = r0
            java.lang.Class r1 = com.google.android.gms.internal.firebase-auth-api.zzahi.zza()
            com.google.android.gms.internal.firebase-auth-api.zzamk.zzc = r1
            java.lang.Class r1 = java.lang.Long.TYPE
            boolean r1 = zzd(r1)
            com.google.android.gms.internal.firebase-auth-api.zzamk.zzd = r1
            java.lang.Class r2 = java.lang.Integer.TYPE
            boolean r2 = zzd(r2)
            com.google.android.gms.internal.firebase-auth-api.zzamk.zze = r2
            if (r0 == 0) goto L2e
            if (r1 == 0) goto L26
            com.google.android.gms.internal.firebase-auth-api.zzamk$zza r1 = new com.google.android.gms.internal.firebase-auth-api.zzamk$zza
            r1.<init>(r0)
            goto L2f
        L26:
            if (r2 == 0) goto L2e
            com.google.android.gms.internal.firebase-auth-api.zzamk$zzb r1 = new com.google.android.gms.internal.firebase-auth-api.zzamk$zzb
            r1.<init>(r0)
            goto L2f
        L2e:
            r1 = 0
        L2f:
            com.google.android.gms.internal.firebase-auth-api.zzamk.zzf = r1
            r0 = 0
            if (r1 != 0) goto L36
            r2 = 0
            goto L3a
        L36:
            boolean r2 = r1.zzb()
        L3a:
            com.google.android.gms.internal.firebase-auth-api.zzamk.zzg = r2
            if (r1 != 0) goto L40
            r2 = 0
            goto L44
        L40:
            boolean r2 = r1.zza()
        L44:
            com.google.android.gms.internal.firebase-auth-api.zzamk.zzh = r2
            java.lang.Class<byte[]> r2 = byte[].class
            int r2 = zzb(r2)
            long r2 = (long) r2
            com.google.android.gms.internal.firebase-auth-api.zzamk.zzi = r2
            java.lang.Class<boolean[]> r4 = boolean[].class
            int r5 = zzb(r4)
            long r5 = (long) r5
            com.google.android.gms.internal.firebase-auth-api.zzamk.zzj = r5
            int r4 = zzc(r4)
            long r4 = (long) r4
            com.google.android.gms.internal.firebase-auth-api.zzamk.zzk = r4
            java.lang.Class<int[]> r4 = int[].class
            int r5 = zzb(r4)
            long r5 = (long) r5
            com.google.android.gms.internal.firebase-auth-api.zzamk.zzl = r5
            int r4 = zzc(r4)
            long r4 = (long) r4
            com.google.android.gms.internal.firebase-auth-api.zzamk.zzm = r4
            java.lang.Class<long[]> r4 = long[].class
            int r5 = zzb(r4)
            long r5 = (long) r5
            com.google.android.gms.internal.firebase-auth-api.zzamk.zzn = r5
            int r4 = zzc(r4)
            long r4 = (long) r4
            com.google.android.gms.internal.firebase-auth-api.zzamk.zzo = r4
            java.lang.Class<float[]> r4 = float[].class
            int r5 = zzb(r4)
            long r5 = (long) r5
            com.google.android.gms.internal.firebase-auth-api.zzamk.zzp = r5
            int r4 = zzc(r4)
            long r4 = (long) r4
            com.google.android.gms.internal.firebase-auth-api.zzamk.zzq = r4
            java.lang.Class<double[]> r4 = double[].class
            int r5 = zzb(r4)
            long r5 = (long) r5
            com.google.android.gms.internal.firebase-auth-api.zzamk.zzr = r5
            int r4 = zzc(r4)
            long r4 = (long) r4
            com.google.android.gms.internal.firebase-auth-api.zzamk.zzs = r4
            java.lang.Class<java.lang.Object[]> r4 = java.lang.Object[].class
            int r5 = zzb(r4)
            long r5 = (long) r5
            com.google.android.gms.internal.firebase-auth-api.zzamk.zzt = r5
            int r4 = zzc(r4)
            long r4 = (long) r4
            com.google.android.gms.internal.firebase-auth-api.zzamk.zzu = r4
            java.lang.reflect.Field r4 = zze()
            if (r4 == 0) goto Lbf
            if (r1 != 0) goto Lb8
            goto Lbf
        Lb8:
            sun.misc.Unsafe r1 = r1.zza
            long r4 = r1.objectFieldOffset(r4)
            goto Lc1
        Lbf:
            r4 = -1
        Lc1:
            com.google.android.gms.internal.firebase-auth-api.zzamk.zzv = r4
            r4 = 7
            long r1 = r2 & r4
            int r2 = (int) r1
            com.google.android.gms.internal.firebase-auth-api.zzamk.zzw = r2
            java.nio.ByteOrder r1 = java.nio.ByteOrder.nativeOrder()
            java.nio.ByteOrder r2 = java.nio.ByteOrder.BIG_ENDIAN
            if (r1 != r2) goto Ld3
            r0 = 1
        Ld3:
            com.google.android.gms.internal.firebase-auth-api.zzamk.zza = r0
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.android.gms.internal.firebase-auth-api.zzamk.<clinit>():void");
    }

    private zzamk() {
    }

    public static double zza(Object obj, long j) {
        return zzf.zza(obj, j);
    }

    public static float zzb(Object obj, long j) {
        return zzf.zzb(obj, j);
    }

    private static int zzc(Class cls) {
        if (zzh) {
            return zzf.zza.arrayIndexScale(cls);
        }
        return -1;
    }

    public static long zzd(Object obj, long j) {
        return zzf.zze(obj, j);
    }

    public static Object zze(Object obj, long j) {
        return zzf.zza.getObject(obj, j);
    }

    public static /* synthetic */ boolean zzf(Object obj, long j) {
        return ((byte) (zzc(obj, (-4) & j) >>> ((int) (((~j) & 3) << 3)))) != 0;
    }

    public static /* synthetic */ boolean zzg(Object obj, long j) {
        return ((byte) (zzc(obj, (-4) & j) >>> ((int) ((j & 3) << 3)))) != 0;
    }

    public static boolean zzh(Object obj, long j) {
        return zzf.zzc(obj, j);
    }

    public static Object zza(Class cls) {
        try {
            return zzb.allocateInstance(cls);
        } catch (InstantiationException e) {
            throw new IllegalStateException(e);
        }
    }

    private static int zzb(Class cls) {
        if (zzh) {
            return zzf.zza.arrayBaseOffset(cls);
        }
        return -1;
    }

    public static int zzc(Object obj, long j) {
        return zzf.zzd(obj, j);
    }

    private static void zzd(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        int i = (((int) j) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzc(obj, j2) & (~(255 << i))));
    }

    private static Field zze() {
        Field zza2 = zza(Buffer.class, "effectiveDirectAddress");
        if (zza2 != null) {
            return zza2;
        }
        Field zza3 = zza(Buffer.class, "address");
        if (zza3 == null || zza3.getType() != Long.TYPE) {
            return null;
        }
        return zza3;
    }

    public static /* synthetic */ Field zza() {
        return zze();
    }

    public static Unsafe zzb() {
        try {
            return (Unsafe) AccessController.doPrivileged(new zzamj());
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void zzc(Object obj, long j, byte b) {
        long j2 = (-4) & j;
        int zzc2 = zzc(obj, j2);
        int i = ((~((int) j)) & 3) << 3;
        zza(obj, j2, ((255 & b) << i) | (zzc2 & (~(255 << i))));
    }

    public static boolean zzd() {
        return zzg;
    }

    private static Field zza(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* synthetic */ void zzb(Object obj, long j, byte b) {
        zzd(obj, j, b);
    }

    public static void zzc(Object obj, long j, boolean z) {
        zzf.zza(obj, j, z);
    }

    private static boolean zzd(Class cls) {
        try {
            Class cls2 = zzc;
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

    public static /* synthetic */ void zza(Object obj, long j, byte b) {
        zzc(obj, j, b);
    }

    public static /* synthetic */ void zzb(Object obj, long j, boolean z) {
        zzd(obj, j, z ? (byte) 1 : (byte) 0);
    }

    public static boolean zzc() {
        return zzh;
    }

    public static void zza(Object obj, long j, double d) {
        zzf.zza(obj, j, d);
    }

    public static void zza(Object obj, long j, float f) {
        zzf.zza(obj, j, f);
    }

    public static void zza(Object obj, long j, int i) {
        zzf.zza(obj, j, i);
    }

    public static void zza(Object obj, long j, long j2) {
        zzf.zza(obj, j, j2);
    }

    public static void zza(Object obj, long j, Object obj2) {
        zzf.zza.putObject(obj, j, obj2);
    }

    public static /* synthetic */ void zza(Object obj, long j, boolean z) {
        zzc(obj, j, z ? (byte) 1 : (byte) 0);
    }

    public static /* synthetic */ void zza(Throwable th) {
        Logger.getLogger(zzamk.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: " + String.valueOf(th));
    }

    public static void zza(byte[] bArr, long j, byte b) {
        zzf.zza((Object) bArr, zzi + j, b);
    }
}
