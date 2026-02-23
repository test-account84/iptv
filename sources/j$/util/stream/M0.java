package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import java.util.Iterator;
import java.util.LongSummaryStatistics;
import java.util.OptionalDouble;
import java.util.OptionalLong;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.LongBinaryOperator;
import java.util.function.LongConsumer;
import java.util.function.LongFunction;
import java.util.function.LongPredicate;
import java.util.function.LongToDoubleFunction;
import java.util.function.LongToIntFunction;
import java.util.function.LongUnaryOperator;
import java.util.function.ObjLongConsumer;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class m0 implements LongStream {
    public final /* synthetic */ n0 a;

    private /* synthetic */ m0(n0 n0Var) {
        this.a = n0Var;
    }

    public static /* synthetic */ LongStream k(n0 n0Var) {
        if (n0Var == null) {
            return null;
        }
        return n0Var instanceof l0 ? ((l0) n0Var).a : new m0(n0Var);
    }

    public final /* synthetic */ boolean allMatch(LongPredicate longPredicate) {
        return this.a.r();
    }

    public final /* synthetic */ boolean anyMatch(LongPredicate longPredicate) {
        return this.a.w();
    }

    public final /* synthetic */ DoubleStream asDoubleStream() {
        return E.k(this.a.asDoubleStream());
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

    public final /* synthetic */ Object collect(Supplier supplier, ObjLongConsumer objLongConsumer, BiConsumer biConsumer) {
        return this.a.collect(supplier, objLongConsumer, biConsumer);
    }

    public final /* synthetic */ long count() {
        return this.a.count();
    }

    public final /* synthetic */ LongStream distinct() {
        return k(this.a.distinct());
    }

    public final /* synthetic */ LongStream dropWhile(LongPredicate longPredicate) {
        return k(this.a.c());
    }

    public final /* synthetic */ boolean equals(Object obj) {
        n0 n0Var = this.a;
        if (obj instanceof m0) {
            obj = ((m0) obj).a;
        }
        return n0Var.equals(obj);
    }

    public final /* synthetic */ LongStream filter(LongPredicate longPredicate) {
        return k(this.a.b());
    }

    public final /* synthetic */ OptionalLong findAny() {
        return j$.util.A.q(this.a.findAny());
    }

    public final /* synthetic */ OptionalLong findFirst() {
        return j$.util.A.q(this.a.findFirst());
    }

    public final LongStream flatMap(LongFunction longFunction) {
        n0 n0Var = this.a;
        a aVar = new a(9);
        aVar.b = longFunction;
        return k(n0Var.e(aVar));
    }

    public final /* synthetic */ void forEach(LongConsumer longConsumer) {
        this.a.forEach(longConsumer);
    }

    public final /* synthetic */ void forEachOrdered(LongConsumer longConsumer) {
        this.a.forEachOrdered(longConsumer);
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

    public final /* synthetic */ PrimitiveIterator.OfLong iterator() {
        return j$.util.x.a(this.a.iterator());
    }

    public final /* synthetic */ LongStream limit(long j) {
        return k(this.a.limit(j));
    }

    public final /* synthetic */ LongStream map(LongUnaryOperator longUnaryOperator) {
        return k(this.a.d());
    }

    public final /* synthetic */ DoubleStream mapToDouble(LongToDoubleFunction longToDoubleFunction) {
        return E.k(this.a.l());
    }

    public final /* synthetic */ java.util.stream.IntStream mapToInt(LongToIntFunction longToIntFunction) {
        return IntStream.Wrapper.convert(this.a.x());
    }

    public final /* synthetic */ java.util.stream.Stream mapToObj(LongFunction longFunction) {
        return Stream.Wrapper.convert(this.a.mapToObj(longFunction));
    }

    public final /* synthetic */ OptionalLong max() {
        return j$.util.A.q(this.a.max());
    }

    public final /* synthetic */ OptionalLong min() {
        return j$.util.A.q(this.a.min());
    }

    public final /* synthetic */ boolean noneMatch(LongPredicate longPredicate) {
        return this.a.n();
    }

    public final /* synthetic */ BaseStream onClose(Runnable runnable) {
        return g.k(this.a.onClose(runnable));
    }

    public final /* synthetic */ BaseStream parallel() {
        return g.k(this.a.parallel());
    }

    public final /* synthetic */ LongStream parallel() {
        return k(this.a.parallel());
    }

    public final /* synthetic */ LongStream peek(LongConsumer longConsumer) {
        return k(this.a.peek(longConsumer));
    }

    public final /* synthetic */ long reduce(long j, LongBinaryOperator longBinaryOperator) {
        return this.a.reduce(j, longBinaryOperator);
    }

    public final /* synthetic */ OptionalLong reduce(LongBinaryOperator longBinaryOperator) {
        return j$.util.A.q(this.a.reduce(longBinaryOperator));
    }

    public final /* synthetic */ BaseStream sequential() {
        return g.k(this.a.sequential());
    }

    public final /* synthetic */ LongStream sequential() {
        return k(this.a.sequential());
    }

    public final /* synthetic */ LongStream skip(long j) {
        return k(this.a.skip(j));
    }

    public final /* synthetic */ LongStream sorted() {
        return k(this.a.sorted());
    }

    public final /* synthetic */ Spliterator.OfLong spliterator() {
        return j$.util.J.a(this.a.spliterator());
    }

    public final /* synthetic */ Spliterator spliterator() {
        return Spliterator.Wrapper.convert(this.a.spliterator());
    }

    public final /* synthetic */ long sum() {
        return this.a.sum();
    }

    public final LongSummaryStatistics summaryStatistics() {
        this.a.summaryStatistics();
        throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.LongSummaryStatistics");
    }

    public final /* synthetic */ LongStream takeWhile(LongPredicate longPredicate) {
        return k(this.a.a());
    }

    public final /* synthetic */ long[] toArray() {
        return this.a.toArray();
    }

    public final /* synthetic */ BaseStream unordered() {
        return g.k(this.a.unordered());
    }
}
