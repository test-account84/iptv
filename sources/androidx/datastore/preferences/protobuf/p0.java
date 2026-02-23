package androidx.datastore.preferences.protobuf;

import java.lang.reflect.AccessibleObject;
import java.lang.reflect.Field;
import java.nio.Buffer;
import java.nio.ByteOrder;
import java.security.AccessController;
import java.security.PrivilegedExceptionAction;
import java.util.logging.Level;
import java.util.logging.Logger;
import sun.misc.Unsafe;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class p0 {
    public static final Logger a = Logger.getLogger(p0.class.getName());
    public static final Unsafe b = B();
    public static final Class c = androidx.datastore.preferences.protobuf.d.b();
    public static final boolean d = m(Long.TYPE);
    public static final boolean e = m(Integer.TYPE);
    public static final e f = z();
    public static final boolean g = Q();
    public static final boolean h = P();
    public static final long i;
    public static final long j;
    public static final long k;
    public static final long l;
    public static final long m;
    public static final long n;
    public static final long o;
    public static final long p;
    public static final long q;
    public static final long r;
    public static final long s;
    public static final long t;
    public static final long u;
    public static final long v;
    public static final int w;
    public static final boolean x;

    public static class a implements PrivilegedExceptionAction {
        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Unsafe run() {
            for (AccessibleObject accessibleObject : Unsafe.class.getDeclaredFields()) {
                accessibleObject.setAccessible(true);
                Object obj = accessibleObject.get((Object) null);
                if (Unsafe.class.isInstance(obj)) {
                    return (Unsafe) Unsafe.class.cast(obj);
                }
            }
            return null;
        }
    }

    public static final class b extends e {
        public b(Unsafe unsafe) {
            super(unsafe);
        }

        public boolean c(Object obj, long j) {
            return p0.x ? p0.e(obj, j) : p0.f(obj, j);
        }

        public byte d(Object obj, long j) {
            return p0.x ? p0.a(obj, j) : p0.b(obj, j);
        }

        public double e(Object obj, long j) {
            return Double.longBitsToDouble(h(obj, j));
        }

        public float f(Object obj, long j) {
            return Float.intBitsToFloat(g(obj, j));
        }

        public void k(Object obj, long j, boolean z) {
            if (p0.x) {
                p0.g(obj, j, z);
            } else {
                p0.h(obj, j, z);
            }
        }

        public void l(Object obj, long j, byte b) {
            if (p0.x) {
                p0.c(obj, j, b);
            } else {
                p0.d(obj, j, b);
            }
        }

        public void m(Object obj, long j, double d) {
            p(obj, j, Double.doubleToLongBits(d));
        }

        public void n(Object obj, long j, float f) {
            o(obj, j, Float.floatToIntBits(f));
        }
    }

    public static final class c extends e {
        public c(Unsafe unsafe) {
            super(unsafe);
        }

        public boolean c(Object obj, long j) {
            return p0.x ? p0.e(obj, j) : p0.f(obj, j);
        }

        public byte d(Object obj, long j) {
            return p0.x ? p0.a(obj, j) : p0.b(obj, j);
        }

        public double e(Object obj, long j) {
            return Double.longBitsToDouble(h(obj, j));
        }

        public float f(Object obj, long j) {
            return Float.intBitsToFloat(g(obj, j));
        }

        public void k(Object obj, long j, boolean z) {
            if (p0.x) {
                p0.g(obj, j, z);
            } else {
                p0.h(obj, j, z);
            }
        }

        public void l(Object obj, long j, byte b) {
            if (p0.x) {
                p0.c(obj, j, b);
            } else {
                p0.d(obj, j, b);
            }
        }

        public void m(Object obj, long j, double d) {
            p(obj, j, Double.doubleToLongBits(d));
        }

        public void n(Object obj, long j, float f) {
            o(obj, j, Float.floatToIntBits(f));
        }
    }

    public static final class d extends e {
        public d(Unsafe unsafe) {
            super(unsafe);
        }

        public boolean c(Object obj, long j) {
            return this.a.getBoolean(obj, j);
        }

        public byte d(Object obj, long j) {
            return this.a.getByte(obj, j);
        }

        public double e(Object obj, long j) {
            return this.a.getDouble(obj, j);
        }

        public float f(Object obj, long j) {
            return this.a.getFloat(obj, j);
        }

        public void k(Object obj, long j, boolean z) {
            this.a.putBoolean(obj, j, z);
        }

        public void l(Object obj, long j, byte b) {
            this.a.putByte(obj, j, b);
        }

        public void m(Object obj, long j, double d) {
            this.a.putDouble(obj, j, d);
        }

        public void n(Object obj, long j, float f) {
            this.a.putFloat(obj, j, f);
        }
    }

    public static abstract class e {
        public Unsafe a;

        public e(Unsafe unsafe) {
            this.a = unsafe;
        }

        public final int a(Class cls) {
            return this.a.arrayBaseOffset(cls);
        }

        public final int b(Class cls) {
            return this.a.arrayIndexScale(cls);
        }

        public abstract boolean c(Object obj, long j);

        public abstract byte d(Object obj, long j);

        public abstract double e(Object obj, long j);

        public abstract float f(Object obj, long j);

        public final int g(Object obj, long j) {
            return this.a.getInt(obj, j);
        }

        public final long h(Object obj, long j) {
            return this.a.getLong(obj, j);
        }

        public final Object i(Object obj, long j) {
            return this.a.getObject(obj, j);
        }

        public final long j(Field field) {
            return this.a.objectFieldOffset(field);
        }

        public abstract void k(Object obj, long j, boolean z);

        public abstract void l(Object obj, long j, byte b);

        public abstract void m(Object obj, long j, double d);

        public abstract void n(Object obj, long j, float f);

        public final void o(Object obj, long j, int i) {
            this.a.putInt(obj, j, i);
        }

        public final void p(Object obj, long j, long j2) {
            this.a.putLong(obj, j, j2);
        }

        public final void q(Object obj, long j, Object obj2) {
            this.a.putObject(obj, j, obj2);
        }
    }

    static {
        long j2 = j(byte[].class);
        i = j2;
        j = j(boolean[].class);
        k = k(boolean[].class);
        l = j(int[].class);
        m = k(int[].class);
        n = j(long[].class);
        o = k(long[].class);
        p = j(float[].class);
        q = k(float[].class);
        r = j(double[].class);
        s = k(double[].class);
        t = j(Object[].class);
        u = k(Object[].class);
        v = o(l());
        w = (int) (j2 & 7);
        x = ByteOrder.nativeOrder() == ByteOrder.BIG_ENDIAN;
    }

    public static Object A(Object obj, long j2) {
        return f.i(obj, j2);
    }

    public static Unsafe B() {
        try {
            return (Unsafe) AccessController.doPrivileged(new a());
        } catch (Throwable unused) {
            return null;
        }
    }

    public static boolean C() {
        return h;
    }

    public static boolean D() {
        return g;
    }

    public static void E(Object obj, long j2, boolean z) {
        f.k(obj, j2, z);
    }

    public static void F(Object obj, long j2, boolean z) {
        I(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    public static void G(Object obj, long j2, boolean z) {
        J(obj, j2, z ? (byte) 1 : (byte) 0);
    }

    public static void H(byte[] bArr, long j2, byte b2) {
        f.l(bArr, i + j2, b2);
    }

    public static void I(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int x2 = x(obj, j3);
        int i2 = ((~((int) j2)) & 3) << 3;
        M(obj, j3, ((255 & b2) << i2) | (x2 & (~(255 << i2))));
    }

    public static void J(Object obj, long j2, byte b2) {
        long j3 = (-4) & j2;
        int i2 = (((int) j2) & 3) << 3;
        M(obj, j3, ((255 & b2) << i2) | (x(obj, j3) & (~(255 << i2))));
    }

    public static void K(Object obj, long j2, double d2) {
        f.m(obj, j2, d2);
    }

    public static void L(Object obj, long j2, float f2) {
        f.n(obj, j2, f2);
    }

    public static void M(Object obj, long j2, int i2) {
        f.o(obj, j2, i2);
    }

    public static void N(Object obj, long j2, long j3) {
        f.p(obj, j2, j3);
    }

    public static void O(Object obj, long j2, Object obj2) {
        f.q(obj, j2, obj2);
    }

    public static boolean P() {
        Unsafe unsafe = b;
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
            if (androidx.datastore.preferences.protobuf.d.c()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{Object.class, cls2});
            cls.getMethod("putByte", new Class[]{Object.class, cls2, Byte.TYPE});
            cls.getMethod("getBoolean", new Class[]{Object.class, cls2});
            cls.getMethod("putBoolean", new Class[]{Object.class, cls2, Boolean.TYPE});
            cls.getMethod("getFloat", new Class[]{Object.class, cls2});
            cls.getMethod("putFloat", new Class[]{Object.class, cls2, Float.TYPE});
            cls.getMethod("getDouble", new Class[]{Object.class, cls2});
            cls.getMethod("putDouble", new Class[]{Object.class, cls2, Double.TYPE});
            return true;
        } catch (Throwable th) {
            a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    public static boolean Q() {
        Unsafe unsafe = b;
        if (unsafe == null) {
            return false;
        }
        try {
            Class cls = unsafe.getClass();
            cls.getMethod("objectFieldOffset", new Class[]{Field.class});
            Class cls2 = Long.TYPE;
            cls.getMethod("getLong", new Class[]{Object.class, cls2});
            if (l() == null) {
                return false;
            }
            if (androidx.datastore.preferences.protobuf.d.c()) {
                return true;
            }
            cls.getMethod("getByte", new Class[]{cls2});
            cls.getMethod("putByte", new Class[]{cls2, Byte.TYPE});
            cls.getMethod("getInt", new Class[]{cls2});
            cls.getMethod("putInt", new Class[]{cls2, Integer.TYPE});
            cls.getMethod("getLong", new Class[]{cls2});
            cls.getMethod("putLong", new Class[]{cls2, cls2});
            cls.getMethod("copyMemory", new Class[]{cls2, cls2, cls2});
            cls.getMethod("copyMemory", new Class[]{Object.class, cls2, Object.class, cls2, cls2});
            return true;
        } catch (Throwable th) {
            a.log(Level.WARNING, "platform method missing - proto runtime falling back to safer methods: " + th);
            return false;
        }
    }

    public static /* synthetic */ byte a(Object obj, long j2) {
        return t(obj, j2);
    }

    public static /* synthetic */ byte b(Object obj, long j2) {
        return u(obj, j2);
    }

    public static /* synthetic */ void c(Object obj, long j2, byte b2) {
        I(obj, j2, b2);
    }

    public static /* synthetic */ void d(Object obj, long j2, byte b2) {
        J(obj, j2, b2);
    }

    public static /* synthetic */ boolean e(Object obj, long j2) {
        return q(obj, j2);
    }

    public static /* synthetic */ boolean f(Object obj, long j2) {
        return r(obj, j2);
    }

    public static /* synthetic */ void g(Object obj, long j2, boolean z) {
        F(obj, j2, z);
    }

    public static /* synthetic */ void h(Object obj, long j2, boolean z) {
        G(obj, j2, z);
    }

    public static Object i(Class cls) {
        try {
            return b.allocateInstance(cls);
        } catch (InstantiationException e2) {
            throw new IllegalStateException(e2);
        }
    }

    public static int j(Class cls) {
        if (h) {
            return f.a(cls);
        }
        return -1;
    }

    public static int k(Class cls) {
        if (h) {
            return f.b(cls);
        }
        return -1;
    }

    public static Field l() {
        Field n2;
        if (androidx.datastore.preferences.protobuf.d.c() && (n2 = n(Buffer.class, "effectiveDirectAddress")) != null) {
            return n2;
        }
        Field n3 = n(Buffer.class, "address");
        if (n3 == null || n3.getType() != Long.TYPE) {
            return null;
        }
        return n3;
    }

    public static boolean m(Class cls) {
        if (!androidx.datastore.preferences.protobuf.d.c()) {
            return false;
        }
        try {
            Class cls2 = c;
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

    public static Field n(Class cls, String str) {
        try {
            return cls.getDeclaredField(str);
        } catch (Throwable unused) {
            return null;
        }
    }

    public static long o(Field field) {
        e eVar;
        if (field == null || (eVar = f) == null) {
            return -1L;
        }
        return eVar.j(field);
    }

    public static boolean p(Object obj, long j2) {
        return f.c(obj, j2);
    }

    public static boolean q(Object obj, long j2) {
        return t(obj, j2) != 0;
    }

    public static boolean r(Object obj, long j2) {
        return u(obj, j2) != 0;
    }

    public static byte s(byte[] bArr, long j2) {
        return f.d(bArr, i + j2);
    }

    public static byte t(Object obj, long j2) {
        return (byte) ((x(obj, (-4) & j2) >>> ((int) (((~j2) & 3) << 3))) & 255);
    }

    public static byte u(Object obj, long j2) {
        return (byte) ((x(obj, (-4) & j2) >>> ((int) ((j2 & 3) << 3))) & 255);
    }

    public static double v(Object obj, long j2) {
        return f.e(obj, j2);
    }

    public static float w(Object obj, long j2) {
        return f.f(obj, j2);
    }

    public static int x(Object obj, long j2) {
        return f.g(obj, j2);
    }

    public static long y(Object obj, long j2) {
        return f.h(obj, j2);
    }

    public static e z() {
        Unsafe unsafe = b;
        if (unsafe == null) {
            return null;
        }
        if (!androidx.datastore.preferences.protobuf.d.c()) {
            return new d(unsafe);
        }
        if (d) {
            return new c(unsafe);
        }
        if (e) {
            return new b(unsafe);
        }
        return null;
    }
}
