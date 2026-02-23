package j$.util.stream;

import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public interface F extends h {
    F a();

    j$.util.k average();

    F b();

    Stream boxed();

    F c();

    Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer);

    long count();

    F d();

    F distinct();

    F e(a aVar);

    j$.util.k findAny();

    j$.util.k findFirst();

    void forEach(DoubleConsumer doubleConsumer);

    void forEachOrdered(DoubleConsumer doubleConsumer);

    boolean i();

    j$.util.q iterator();

    n0 j();

    F limit(long j);

    Stream mapToObj(DoubleFunction doubleFunction);

    j$.util.k max();

    j$.util.k min();

    boolean p();

    F parallel();

    F peek(DoubleConsumer doubleConsumer);

    double reduce(double d, DoubleBinaryOperator doubleBinaryOperator);

    j$.util.k reduce(DoubleBinaryOperator doubleBinaryOperator);

    F sequential();

    F skip(long j);

    F sorted();

    j$.util.E spliterator();

    double sum();

    j$.util.g summaryStatistics();

    double[] toArray();

    IntStream u();

    boolean y();
}
