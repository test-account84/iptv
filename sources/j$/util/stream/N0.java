package j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public interface n0 extends h {
    n0 a();

    F asDoubleStream();

    j$.util.k average();

    n0 b();

    Stream boxed();

    n0 c();

    Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer);

    long count();

    n0 d();

    n0 distinct();

    n0 e(a aVar);

    j$.util.m findAny();

    j$.util.m findFirst();

    void forEach(LongConsumer longConsumer);

    void forEachOrdered(LongConsumer longConsumer);

    j$.util.y iterator();

    F l();

    n0 limit(long j);

    Stream mapToObj(LongFunction longFunction);

    j$.util.m max();

    j$.util.m min();

    boolean n();

    n0 parallel();

    n0 peek(LongConsumer longConsumer);

    boolean r();

    long reduce(long j, LongBinaryOperator longBinaryOperator);

    j$.util.m reduce(LongBinaryOperator longBinaryOperator);

    n0 sequential();

    n0 skip(long j);

    n0 sorted();

    j$.util.K spliterator();

    long sum();

    j$.util.j summaryStatistics();

    long[] toArray();

    boolean w();

    IntStream x();
}
