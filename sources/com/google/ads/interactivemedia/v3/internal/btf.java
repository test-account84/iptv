package com.google.ads.interactivemedia.v3.internal;

import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.util.logging.Level;
import java.util.logging.Logger;
import libcore.io.Memory;
import sun.misc.Unsafe;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class btf {
    static final long a;
    static final boolean b;
    public static final /* synthetic */ int c = 0;
    private static final Unsafe d;
    private static final Class e;
    private static final boolean f;
    private static final boolean g;
    private static final bte h;
    private static final boolean i;
    private static final boolean j;
    private static final long k;

    static {
        Unsafe j2 = j();
        d = j2;
        e = Memory.class;
        boolean z = z(Long.TYPE);
        f = z;
        boolean z2 = z(Integer.TYPE);
        g = z2;
        bte bteVar = null;
        if (j2 != null) {
            if (z) {
                bteVar = new btd(j2);
            } else if (z2) {
                bteVar = new btc(j2);
            }
        }
        h = bteVar;
        i = bteVar == null ? false : bteVar.t();
        j = bteVar == null ? false : bteVar.s();
        a = E(byte[].class);
        E(boolean[].class);
        J(boolean[].class);
        E(int[].class);
        J(int[].class);
        E(long[].class);
        J(long[].class);
        E(float[].class);
        J(float[].class);
        E(double[].class);
        J(double[].class);
        E(Object[].class);
        J(Object[].class);
        Field F = F();
        long j3 = -1;
        if (F != null && bteVar != null) {
            j3 = bteVar.n(F);
        }
        k = j3;
        b = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    private btf() {
    }

    public static boolean A(Object obj, long j2) {
        return h.i(obj, j2);
    }

    public static boolean B() {
        return j;
    }

    private static byte C(Object obj, long j2) {
        return (byte) ((d(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3))) & 255);
    }

    private static byte D(Object obj, long j2) {
        return (byte) ((d(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3))) & 255);
    }

    private static int E(Class cls) {
        if (j) {
            return h.j(cls);
        }
        return -1;
    }

    private static Field F() {
        Field G = G(Buffer.class, "effectiveDirectAddress");
        if (G != null) {
            return G;
        }
        Field G2 = G(Buffer.class, "address");
        if (G2 == null || G2.getType() != Long.TYPE) {
            return null;
        }
        return G2;
    }

    private static Field G(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    private static void H(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = ((~((int) j2)) & 3) << 3;
        u(obj, j3, ((b2 & 255) << i2) | (d(obj, j3) & (~(255 << i2))));
    }

    private static void I(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        u(obj, j3, ((b2 & 255) << i2) | (d(obj, j3) & (~(255 << i2))));
    }

    private static void J(Class cls) {
        if (j) {
            h.k(cls);
        }
    }

    public static byte a(long j2) {
        return h.a(j2);
    }

    public static double b(Object obj, long j2) {
        return h.b(obj, j2);
    }

    public static float c(Object obj, long j2) {
        return h.c(obj, j2);
    }

    public static int d(Object obj, long j2) {
        return h.l(obj, j2);
    }

    public static long e(ByteBuffer byteBuffer) {
        return h.m(byteBuffer, k);
    }

    public static long f(Object obj, long j2) {
        return h.m(obj, j2);
    }

    public static Object g(Class cls) {
        try {
            return d.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static Object h(Object obj, long j2) {
        return h.o(obj, j2);
    }

    public static /* bridge */ /* synthetic */ Field i() {
        return F();
    }

    public static Unsafe j() {
        try {
            return (Unsafe) AccessController.doPrivileged(new btb());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static /* bridge */ /* synthetic */ void k(Throwable th) {
        Logger.getLogger(btf.class.getName()).logp(Level.WARNING, "com.google.protobuf.UnsafeUtil", "logMissingMethod", "platform method missing - proto runtime falling back to safer methods: ".concat(th.toString()));
    }

    public static /* synthetic */ void l(Object obj, long j2, boolean z) {
        H(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    public static /* synthetic */ void m(Object obj, long j2, boolean z) {
        I(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    public static /* bridge */ /* synthetic */ void n(Object obj, long j2, byte b2) {
        H(obj, j2, b2);
    }

    public static /* bridge */ /* synthetic */ void o(Object obj, long j2, byte b2) {
        I(obj, j2, b2);
    }

    public static void p(long j2, byte[] bArr, long j3, long j4) {
        h.d(j2, bArr, j3, j4);
    }

    public static void q(Object obj, long j2, boolean z) {
        h.e(obj, j2, z);
    }

    public static void r(byte[] bArr, long j2, byte b2) {
        h.f(bArr, a + j2, b2);
    }

    public static void s(Object obj, long j2, double d2) {
        h.g(obj, j2, d2);
    }

    public static void t(Object obj, long j2, float f2) {
        h.h(obj, j2, f2);
    }

    public static void u(Object obj, long j2, int i2) {
        h.p(obj, j2, i2);
    }

    public static void v(Object obj, long j2, long j3) {
        h.q(obj, j2, j3);
    }

    public static void w(Object obj, long j2, Object obj2) {
        h.r(obj, j2, obj2);
    }

    public static /* bridge */ /* synthetic */ boolean x(Object obj, long j2) {
        return C(obj, j2) != 0;
    }

    public static /* bridge */ /* synthetic */ boolean y(Object obj, long j2) {
        return D(obj, j2) != 0;
    }

    public static boolean z(Class cls) {
        try {
            Class cls2 = e;
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
}
