package j$.com.android.tools.r8;

import j$.util.Objects;
import j$.util.concurrent.t;
import j$.util.function.b;
import j$.util.function.d;
import j$.util.function.e;
import j$.util.function.f;
import java.util.AbstractMap;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;
import java.util.function.Predicate;
import sun.misc.Unsafe;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public abstract /* synthetic */ class a {
    public static f a(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new f(predicate, predicate2, 0);
    }

    public static t b(BiConsumer biConsumer, BiConsumer biConsumer2) {
        Objects.requireNonNull(biConsumer2);
        return new t(1, biConsumer, biConsumer2);
    }

    public static t c(BiFunction biFunction, Function function) {
        Objects.requireNonNull(function);
        return new t(biFunction, function);
    }

    public static t d(Consumer consumer, Consumer consumer2) {
        Objects.requireNonNull(consumer2);
        return new t(3, consumer, consumer2);
    }

    public static b e(DoubleConsumer doubleConsumer, DoubleConsumer doubleConsumer2) {
        Objects.requireNonNull(doubleConsumer2);
        return new b(doubleConsumer, doubleConsumer2);
    }

    public static d f(IntConsumer intConsumer, IntConsumer intConsumer2) {
        Objects.requireNonNull(intConsumer2);
        return new d(intConsumer, intConsumer2);
    }

    public static e g(LongConsumer longConsumer, LongConsumer longConsumer2) {
        Objects.requireNonNull(longConsumer2);
        return new e(longConsumer, longConsumer2);
    }

    public static f h(Predicate predicate, Predicate predicate2) {
        Objects.requireNonNull(predicate2);
        return new f(predicate, predicate2, 1);
    }

    public static /* synthetic */ long i(long j, long j2) {
        long j3 = j + j2;
        if (((j2 ^ j) < 0) || ((j ^ j3) >= 0)) {
            return j3;
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ AbstractMap.SimpleImmutableEntry j(String str, String str2) {
        return new AbstractMap.SimpleImmutableEntry(Objects.requireNonNull(str), Objects.requireNonNull(str2));
    }

    public static /* synthetic */ List k(Object[] objArr) {
        ArrayList arrayList = new ArrayList(objArr.length);
        for (Object obj : objArr) {
            arrayList.add(Objects.requireNonNull(obj));
        }
        return Collections.unmodifiableList(arrayList);
    }

    public static /* synthetic */ boolean l(Unsafe unsafe, Object obj, long j, Object obj2) {
        while (!unsafe.compareAndSwapObject(obj, j, (Object) null, obj2)) {
            if (unsafe.getObject(obj, j) != null) {
                return false;
            }
        }
        return true;
    }

    public static /* synthetic */ long m(long j, long j2) {
        long j3 = j % j2;
        if (j3 == 0) {
            return 0L;
        }
        return (((j ^ j2) >> 63) | 1) > 0 ? j3 : j3 + j2;
    }

    public static /* synthetic */ long n(long j, long j2) {
        long j3 = j / j2;
        return (j - (j2 * j3) != 0 && (((j ^ j2) >> 63) | 1) < 0) ? j3 - 1 : j3;
    }

    public static /* synthetic */ long o(long j, long j2) {
        int numberOfLeadingZeros = Long.numberOfLeadingZeros(~j2) + Long.numberOfLeadingZeros(j2) + Long.numberOfLeadingZeros(~j) + Long.numberOfLeadingZeros(j);
        if (numberOfLeadingZeros > 65) {
            return j * j2;
        }
        if (numberOfLeadingZeros >= 64) {
            if ((j >= 0) | (j2 != Long.MIN_VALUE)) {
                long j3 = j * j2;
                if (j == 0 || j3 / j == j2) {
                    return j3;
                }
            }
        }
        throw new ArithmeticException();
    }

    public static /* synthetic */ long p(long j, long j2) {
        long j3 = j - j2;
        if (((j2 ^ j) >= 0) || ((j ^ j3) >= 0)) {
            return j3;
        }
        throw new ArithmeticException();
    }
}
