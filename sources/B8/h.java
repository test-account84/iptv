package B8;

import B8.a;
import java.util.NoSuchElementException;
import kotlin.jvm.internal.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class h extends g {
    public static float b(float f, float f2) {
        return f < f2 ? f2 : f;
    }

    public static int c(int i, int i2) {
        return i < i2 ? i2 : i;
    }

    public static long d(long j, long j2) {
        return j < j2 ? j2 : j;
    }

    public static int e(int i, int i2) {
        return i > i2 ? i2 : i;
    }

    public static long f(long j, long j2) {
        return j > j2 ? j2 : j;
    }

    public static float g(float f, float f2, float f3) {
        if (f2 <= f3) {
            return f < f2 ? f2 : f > f3 ? f3 : f;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + f3 + " is less than minimum " + f2 + '.');
    }

    public static int h(int i, int i2, int i3) {
        if (i2 <= i3) {
            return i < i2 ? i2 : i > i3 ? i3 : i;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + i3 + " is less than minimum " + i2 + '.');
    }

    public static long i(long j, long j2, long j3) {
        if (j2 <= j3) {
            return j < j2 ? j2 : j > j3 ? j3 : j;
        }
        throw new IllegalArgumentException("Cannot coerce value to an empty range: maximum " + j3 + " is less than minimum " + j2 + '.');
    }

    public static a j(int i, int i2) {
        return a.e.a(i, i2, -1);
    }

    public static int k(c cVar, z8.c random) {
        l.e(cVar, "<this>");
        l.e(random, "random");
        try {
            return z8.d.d(random, cVar);
        } catch (IllegalArgumentException e) {
            throw new NoSuchElementException(e.getMessage());
        }
    }

    public static a l(a aVar, int i) {
        l.e(aVar, "<this>");
        g.a(i > 0, Integer.valueOf(i));
        a.a aVar2 = a.e;
        int d = aVar.d();
        int f = aVar.f();
        if (aVar.g() <= 0) {
            i = -i;
        }
        return aVar2.a(d, f, i);
    }

    public static c m(int i, int i2) {
        return i2 <= Integer.MIN_VALUE ? c.f.a() : new c(i, i2 - 1);
    }
}
