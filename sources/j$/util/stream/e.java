package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import java.util.DoubleSummaryStatistics;
import java.util.Iterator;
import java.util.OptionalDouble;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.DoubleBinaryOperator;
import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;
import java.util.function.ObjDoubleConsumer;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class E implements DoubleStream {
    public final /* synthetic */ F a;

    private /* synthetic */ E(F f) {
        this.a = f;
    }

    public static /* synthetic */ DoubleStream k(F f) {
        if (f == null) {
            return null;
        }
        return f instanceof D ? ((D) f).a : new E(f);
    }

    public final /* synthetic */ boolean allMatch(DoublePredicate doublePredicate) {
        return this.a.i();
    }

    public final /* synthetic */ boolean anyMatch(DoublePredicate doublePredicate) {
        return this.a.p();
    }

    public final /* synthetic */ OptionalDouble average() {
        return j$.util.A.o(this.a.average());
    }

    public final /* synthetic */ java.util.stream.Stream boxed() {
        return Stream.Wrapper.convert(this.a.boxed());
    }

    public final /* synthetic */ void close() {
        this.a.close();
    }

    public final /* synthetic */ Object collect(Supplier supplier, ObjDoubleConsumer objDoubleConsumer, BiConsumer biConsumer) {
        return this.a.collect(supplier, objDoubleConsumer, biConsumer);
    }

    public final /* synthetic */ long count() {
        return this.a.count();
    }

    public final /* synthetic */ DoubleStream distinct() {
        return k(this.a.distinct());
    }

    public final /* synthetic */ DoubleStream dropWhile(DoublePredicate doublePredicate) {
        return k(this.a.c());
    }

    public final /* synthetic */ boolean equals(Object obj) {
        F f = this.a;
        if (obj instanceof E) {
            obj = ((E) obj).a;
        }
        return f.equals(obj);
    }

    public final /* synthetic */ DoubleStream filter(DoublePredicate doublePredicate) {
        return k(this.a.b());
    }

    public final /* synthetic */ OptionalDouble findAny() {
        return j$.util.A.o(this.a.findAny());
    }

    public final /* synthetic */ OptionalDouble findFirst() {
        return j$.util.A.o(this.a.findFirst());
    }

    public final DoubleStream flatMap(DoubleFunction doubleFunction) {
        F f = this.a;
        a aVar = new a(7);
        aVar.b = doubleFunction;
        return k(f.e(aVar));
    }

    public final /* synthetic */ void forEach(DoubleConsumer doubleConsumer) {
        this.a.forEach(doubleConsumer);
    }

    public final /* synthetic */ void forEachOrdered(DoubleConsumer doubleConsumer) {
        this.a.forEachOrdered(doubleConsumer);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    public final /* synthetic */ boolean isParallel() {
        return this.a.isParallel();
    }

    public final /* synthetic */ Iterator iterator() {
        return this.a.iterator();
    }

    public final /* synthetic */ PrimitiveIterator.OfDouble iterator() {
        return j$.util.p.a(this.a.iterator());
    }

    public final /* synthetic */ DoubleStream limit(long j) {
        return k(this.a.limit(j));
    }

    public final /* synthetic */ DoubleStream map(DoubleUnaryOperator doubleUnaryOperator) {
        return k(this.a.d());
    }

    public final /* synthetic */ java.util.stream.IntStream mapToInt(DoubleToIntFunction doubleToIntFunction) {
        return IntStream.Wrapper.convert(this.a.u());
    }

    public final /* synthetic */ LongStream mapToLong(DoubleToLongFunction doubleToLongFunction) {
        return m0.k(this.a.j());
    }

    public final /* synthetic */ java.util.stream.Stream mapToObj(DoubleFunction doubleFunction) {
        return Stream.Wrapper.convert(this.a.mapToObj(doubleFunction));
    }

    public final /* synthetic */ OptionalDouble max() {
        return j$.util.A.o(this.a.max());
    }

    public final /* synthetic */ OptionalDouble min() {
        return j$.util.A.o(this.a.min());
    }

    public final /* synthetic */ boolean noneMatch(DoublePredicate doublePredicate) {
        return this.a.y();
    }

    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return g.k(this.a.onClose(runnable));
    }

    public final /* synthetic */ BaseStream parallel() {
        return g.k(this.a.parallel());
    }

    public final /* synthetic */ DoubleStream parallel() {
        return k(this.a.parallel());
    }

    public final /* synthetic */ DoubleStream peek(DoubleConsumer doubleConsumer) {
        return k(this.a.peek(doubleConsumer));
    }

    public final /* synthetic */ double reduce(double d, DoubleBinaryOperator doubleBinaryOperator) {
        return this.a.reduce(d, doubleBinaryOperator);
    }

    public final /* synthetic */ OptionalDouble reduce(DoubleBinaryOperator doubleBinaryOperator) {
        return j$.util.A.o(this.a.reduce(doubleBinaryOperator));
    }

    public final /* synthetic */ BaseStream sequential() {
        return g.k(this.a.sequential());
    }

    public final /* synthetic */ DoubleStream sequential() {
        return k(this.a.sequential());
    }

    public final /* synthetic */ DoubleStream skip(long j) {
        return k(this.a.skip(j));
    }

    public final /* synthetic */ DoubleStream sorted() {
        return k(this.a.sorted());
    }

    public final /* synthetic */ Spliterator.OfDouble spliterator() {
        return j$.util.D.a(this.a.spliterator());
    }

    public final /* synthetic */ Spliterator spliterator() {
        return Spliterator.Wrapper.convert(this.a.spliterator());
    }

    public final /* synthetic */ double sum() {
        return this.a.sum();
    }

    public final DoubleSummaryStatistics summaryStatistics() {
        this.a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.DoubleSummaryStatistics");
    }

    public final /* synthetic */ DoubleStream takeWhile(DoublePredicate doublePredicate) {
        return k(this.a.a());
    }

    public final /* synthetic */ double[] toArray() {
        return this.a.toArray();
    }

    public final /* synthetic */ BaseStream unordered() {
        return g.k(this.a.unordered());
    }
}
