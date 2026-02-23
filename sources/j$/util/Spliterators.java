package j$.util;

import java.util.Iterator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final class Spliterators {
    private static final Spliterator a = new Z();
    private static final H b = new X();
    private static final K c = new Y();
    private static final E d = new W();

    private static void a(int i, int i2, int i3) {
        if (i2 <= i3) {
            if (i2 < 0) {
                throw new ArrayIndexOutOfBoundsException(i2);
            }
            if (i3 > i) {
                throw new ArrayIndexOutOfBoundsException(i3);
            }
            return;
        }
        throw new ArrayIndexOutOfBoundsException("origin(" + i2 + ") > fence(" + i3 + ")");
    }

    public static E b() {
        return d;
    }

    public static H c() {
        return b;
    }

    public static K d() {
        return c;
    }

    public static Spliterator e() {
        return a;
    }

    public static q f(E e) {
        Objects.requireNonNull(e);
        return new T(e);
    }

    public static u g(H h) {
        Objects.requireNonNull(h);
        return new Q(h);
    }

    public static y h(K k) {
        Objects.requireNonNull(k);
        return new S(k);
    }

    public static Iterator i(Spliterator spliterator) {
        Objects.requireNonNull(spliterator);
        return new P(spliterator);
    }

    public static E j(double[] dArr, int i, int i2) {
        a(((double[]) Objects.requireNonNull(dArr)).length, i, i2);
        return new V(dArr, i, i2, 1040);
    }

    public static H k(int[] iArr, int i, int i2) {
        a(((int[]) Objects.requireNonNull(iArr)).length, i, i2);
        return new a0(iArr, i, i2, 1040);
    }

    public static K l(long[] jArr, int i, int i2) {
        a(((long[]) Objects.requireNonNull(jArr)).length, i, i2);
        return new c0(jArr, i, i2, 1040);
    }

    public static Spliterator m(Object[] objArr, int i, int i2) {
        a(((Object[]) Objects.requireNonNull(objArr)).length, i, i2);
        return new U(objArr, i, i2, 1040);
    }

    public static Spliterator n(Iterator it, int i) {
        return new b0((Iterator) Objects.requireNonNull(it), i);
    }

    public static Spliterator spliterator(java.util.Collection collection, int i) {
        return new b0((java.util.Collection) Objects.requireNonNull(collection), i);
    }
}
