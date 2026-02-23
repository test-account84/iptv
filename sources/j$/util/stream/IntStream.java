package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.Stream;
import java.util.IntSummaryStatistics;
import java.util.Iterator;
import java.util.OptionalDouble;
import java.util.OptionalInt;
import java.util.PrimitiveIterator;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;
import java.util.stream.BaseStream;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public interface IntStream extends h {

    public final /* synthetic */ class VivifiedWrapper implements IntStream {
        public final /* synthetic */ java.util.stream.IntStream a;

        private /* synthetic */ VivifiedWrapper(java.util.stream.IntStream intStream) {
            this.a = intStream;
        }

        public static /* synthetic */ IntStream convert(java.util.stream.IntStream intStream) {
            if (intStream == null) {
                return null;
            }
            return intStream instanceof Wrapper ? IntStream.this : new VivifiedWrapper(intStream);
        }

        public final /* synthetic */ IntStream a() {
            return convert(this.a.takeWhile((IntPredicate) null));
        }

        public final /* synthetic */ F asDoubleStream() {
            return D.k(this.a.asDoubleStream());
        }

        public final /* synthetic */ n0 asLongStream() {
            return l0.k(this.a.asLongStream());
        }

        public final /* synthetic */ j$.util.k average() {
            return j$.util.A.k(this.a.average());
        }

        public final /* synthetic */ IntStream b() {
            return convert(this.a.filter((IntPredicate) null));
        }

        public final /* synthetic */ Stream boxed() {
            return b3.k(this.a.boxed());
        }

        public final /* synthetic */ IntStream c() {
            return convert(this.a.dropWhile((IntPredicate) null));
        }

        public final /* synthetic */ void close() {
            this.a.close();
        }

        public final /* synthetic */ Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
            return this.a.collect(supplier, objIntConsumer, biConsumer);
        }

        public final /* synthetic */ long count() {
            return this.a.count();
        }

        public final /* synthetic */ IntStream d() {
            return convert(this.a.map((IntUnaryOperator) null));
        }

        public final /* synthetic */ IntStream distinct() {
            return convert(this.a.distinct());
        }

        public final /* synthetic */ boolean equals(Object obj) {
            java.util.stream.IntStream intStream = this.a;
            if (obj instanceof VivifiedWrapper) {
                obj = ((VivifiedWrapper) obj).a;
            }
            return intStream.equals(obj);
        }

        public final /* synthetic */ F f() {
            return D.k(this.a.mapToDouble((IntToDoubleFunction) null));
        }

        public final /* synthetic */ j$.util.l findAny() {
            return j$.util.A.l(this.a.findAny());
        }

        public final /* synthetic */ j$.util.l findFirst() {
            return j$.util.A.l(this.a.findFirst());
        }

        public final /* synthetic */ void forEach(IntConsumer intConsumer) {
            this.a.forEach(intConsumer);
        }

        public final /* synthetic */ void forEachOrdered(IntConsumer intConsumer) {
            this.a.forEachOrdered(intConsumer);
        }

        public final /* synthetic */ boolean g() {
            return this.a.noneMatch((IntPredicate) null);
        }

        public final /* synthetic */ int hashCode() {
            return this.a.hashCode();
        }

        public final /* synthetic */ boolean isParallel() {
            return this.a.isParallel();
        }

        public final /* synthetic */ j$.util.u iterator() {
            return j$.util.s.a(this.a.iterator());
        }

        public final /* synthetic */ Iterator iterator() {
            return this.a.iterator();
        }

        public final /* synthetic */ IntStream limit(long j) {
            return convert(this.a.limit(j));
        }

        public final /* synthetic */ n0 m() {
            return l0.k(this.a.mapToLong((IntToLongFunction) null));
        }

        public final /* synthetic */ Stream mapToObj(IntFunction intFunction) {
            return b3.k(this.a.mapToObj(intFunction));
        }

        public final /* synthetic */ j$.util.l max() {
            return j$.util.A.l(this.a.max());
        }

        public final /* synthetic */ j$.util.l min() {
            return j$.util.A.l(this.a.min());
        }

        public final /* synthetic */ h onClose(Runnable runnable) {
            return f.k(this.a.onClose(runnable));
        }

        public final /* synthetic */ IntStream parallel() {
            return convert(this.a.parallel());
        }

        public final /* synthetic */ h parallel() {
            return f.k(this.a.parallel());
        }

        public final /* synthetic */ IntStream peek(IntConsumer intConsumer) {
            return convert(this.a.peek(intConsumer));
        }

        public final IntStream q(Q0 q0) {
            java.util.stream.IntStream intStream = this.a;
            Q0 q02 = new Q0();
            q02.a = q0;
            return convert(intStream.flatMap(q02));
        }

        public final /* synthetic */ int reduce(int i, IntBinaryOperator intBinaryOperator) {
            return this.a.reduce(i, intBinaryOperator);
        }

        public final /* synthetic */ j$.util.l reduce(IntBinaryOperator intBinaryOperator) {
            return j$.util.A.l(this.a.reduce(intBinaryOperator));
        }

        public final /* synthetic */ boolean s() {
            return this.a.anyMatch((IntPredicate) null);
        }

        public final /* synthetic */ IntStream sequential() {
            return convert(this.a.sequential());
        }

        public final /* synthetic */ h sequential() {
            return f.k(this.a.sequential());
        }

        public final /* synthetic */ IntStream skip(long j) {
            return convert(this.a.skip(j));
        }

        public final /* synthetic */ IntStream sorted() {
            return convert(this.a.sorted());
        }

        public final /* synthetic */ j$.util.H spliterator() {
            return j$.util.F.a(this.a.spliterator());
        }

        public final /* synthetic */ Spliterator spliterator() {
            return j$.util.O.a(this.a.spliterator());
        }

        public final /* synthetic */ int sum() {
            return this.a.sum();
        }

        public final j$.util.h summaryStatistics() {
            this.a.summaryStatistics();
            throw new Error("Java 8+ API desugaring (library desugaring) cannot convert from java.util.IntSummaryStatistics");
        }

        public final /* synthetic */ int[] toArray() {
            return this.a.toArray();
        }

        public final /* synthetic */ h unordered() {
            return f.k(this.a.unordered());
        }

        public final /* synthetic */ boolean v() {
            return this.a.allMatch((IntPredicate) null);
        }
    }

    public final /* synthetic */ class Wrapper implements java.util.stream.IntStream {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.stream.IntStream convert(IntStream intStream) {
            if (intStream == null) {
                return null;
            }
            return intStream instanceof VivifiedWrapper ? ((VivifiedWrapper) intStream).a : intStream.new Wrapper();
        }

        public final /* synthetic */ boolean allMatch(IntPredicate intPredicate) {
            return IntStream.this.v();
        }

        public final /* synthetic */ boolean anyMatch(IntPredicate intPredicate) {
            return IntStream.this.s();
        }

        public final /* synthetic */ DoubleStream asDoubleStream() {
            return E.k(IntStream.this.asDoubleStream());
        }

        public final /* synthetic */ LongStream asLongStream() {
            return m0.k(IntStream.this.asLongStream());
        }

        public final /* synthetic */ OptionalDouble average() {
            return j$.util.A.o(IntStream.this.average());
        }

        public final /* synthetic */ java.util.stream.Stream boxed() {
            return Stream.Wrapper.convert(IntStream.this.boxed());
        }

        public final /* synthetic */ void close() {
            IntStream.this.close();
        }

        public final /* synthetic */ Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
            return IntStream.this.collect(supplier, objIntConsumer, biConsumer);
        }

        public final /* synthetic */ long count() {
            return IntStream.this.count();
        }

        public final /* synthetic */ java.util.stream.IntStream distinct() {
            return convert(IntStream.this.distinct());
        }

        public final /* synthetic */ java.util.stream.IntStream dropWhile(IntPredicate intPredicate) {
            return convert(IntStream.this.c());
        }

        public final /* synthetic */ boolean equals(Object obj) {
            IntStream intStream = IntStream.this;
            if (obj instanceof Wrapper) {
                obj = IntStream.this;
            }
            return intStream.equals(obj);
        }

        public final /* synthetic */ java.util.stream.IntStream filter(IntPredicate intPredicate) {
            return convert(IntStream.this.b());
        }

        public final /* synthetic */ OptionalInt findAny() {
            return j$.util.A.p(IntStream.this.findAny());
        }

        public final /* synthetic */ OptionalInt findFirst() {
            return j$.util.A.p(IntStream.this.findFirst());
        }

        public final java.util.stream.IntStream flatMap(IntFunction intFunction) {
            IntStream intStream = IntStream.this;
            Q0 q0 = new Q0();
            q0.a = intFunction;
            return convert(intStream.q(q0));
        }

        public final /* synthetic */ void forEach(IntConsumer intConsumer) {
            IntStream.this.forEach(intConsumer);
        }

        public final /* synthetic */ void forEachOrdered(IntConsumer intConsumer) {
            IntStream.this.forEachOrdered(intConsumer);
        }

        public final /* synthetic */ int hashCode() {
            return IntStream.this.hashCode();
        }

        public final /* synthetic */ boolean isParallel() {
            return IntStream.this.isParallel();
        }

        public final /* synthetic */ Iterator iterator() {
            return IntStream.this.iterator();
        }

        public final /* synthetic */ PrimitiveIterator.OfInt iterator() {
            return j$.util.t.a(IntStream.this.iterator());
        }

        public final /* synthetic */ java.util.stream.IntStream limit(long j) {
            return convert(IntStream.this.limit(j));
        }

        public final /* synthetic */ java.util.stream.IntStream map(IntUnaryOperator intUnaryOperator) {
            return convert(IntStream.this.d());
        }

        public final /* synthetic */ DoubleStream mapToDouble(IntToDoubleFunction intToDoubleFunction) {
            return E.k(IntStream.this.f());
        }

        public final /* synthetic */ LongStream mapToLong(IntToLongFunction intToLongFunction) {
            return m0.k(IntStream.this.m());
        }

        public final /* synthetic */ java.util.stream.Stream mapToObj(IntFunction intFunction) {
            return Stream.Wrapper.convert(IntStream.this.mapToObj(intFunction));
        }

        public final /* synthetic */ OptionalInt max() {
            return j$.util.A.p(IntStream.this.max());
        }

        public final /* synthetic */ OptionalInt min() {
            return j$.util.A.p(IntStream.this.min());
        }

        public final /* synthetic */ boolean noneMatch(IntPredicate intPredicate) {
            return IntStream.this.g();
        }

        public final /* synthetic */ BaseStream onClose(Runnable runnable) {
            return g.k(IntStream.this.onClose(runnable));
        }

        public final /* synthetic */ BaseStream parallel() {
            return g.k(IntStream.this.parallel());
        }

        public final /* synthetic */ java.util.stream.IntStream parallel() {
            return convert(IntStream.this.parallel());
        }

        public final /* synthetic */ java.util.stream.IntStream peek(IntConsumer intConsumer) {
            return convert(IntStream.this.peek(intConsumer));
        }

        public final /* synthetic */ int reduce(int i, IntBinaryOperator intBinaryOperator) {
            return IntStream.this.reduce(i, intBinaryOperator);
        }

        public final /* synthetic */ OptionalInt reduce(IntBinaryOperator intBinaryOperator) {
            return j$.util.A.p(IntStream.this.reduce(intBinaryOperator));
        }

        public final /* synthetic */ BaseStream sequential() {
            return g.k(IntStream.this.sequential());
        }

        public final /* synthetic */ java.util.stream.IntStream sequential() {
            return convert(IntStream.this.sequential());
        }

        public final /* synthetic */ java.util.stream.IntStream skip(long j) {
            return convert(IntStream.this.skip(j));
        }

        public final /* synthetic */ java.util.stream.IntStream sorted() {
            return convert(IntStream.this.sorted());
        }

        public final /* synthetic */ Spliterator.OfInt spliterator() {
            return j$.util.G.a(IntStream.this.spliterator());
        }

        public final /* synthetic */ java.util.Spliterator spliterator() {
            return Spliterator.Wrapper.convert(IntStream.this.spliterator());
        }

        public final /* synthetic */ int sum() {
            return IntStream.this.sum();
        }

        public final IntSummaryStatistics summaryStatistics() {
            IntStream.this.summaryStatistics();
            throw new Error("Java 8+ API desugaring (library desugaring) cannot convert to java.util.IntSummaryStatistics");
        }

        public final /* synthetic */ java.util.stream.IntStream takeWhile(IntPredicate intPredicate) {
            return convert(IntStream.this.a());
        }

        public final /* synthetic */ int[] toArray() {
            return IntStream.this.toArray();
        }

        public final /* synthetic */ BaseStream unordered() {
            return g.k(IntStream.this.unordered());
        }
    }

    IntStream a();

    F asDoubleStream();

    n0 asLongStream();

    j$.util.k average();

    IntStream b();

    Stream boxed();

    IntStream c();

    Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer);

    long count();

    IntStream d();

    IntStream distinct();

    F f();

    j$.util.l findAny();

    j$.util.l findFirst();

    void forEach(IntConsumer intConsumer);

    void forEachOrdered(IntConsumer intConsumer);

    boolean g();

    j$.util.u iterator();

    IntStream limit(long j);

    n0 m();

    Stream mapToObj(IntFunction intFunction);

    j$.util.l max();

    j$.util.l min();

    IntStream parallel();

    IntStream peek(IntConsumer intConsumer);

    IntStream q(Q0 q0);

    int reduce(int i, IntBinaryOperator intBinaryOperator);

    j$.util.l reduce(IntBinaryOperator intBinaryOperator);

    boolean s();

    IntStream sequential();

    IntStream skip(long j);

    IntStream sorted();

    j$.util.H spliterator();

    int sum();

    j$.util.h summaryStatistics();

    int[] toArray();

    boolean v();
}
