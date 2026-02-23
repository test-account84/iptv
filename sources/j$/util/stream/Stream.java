package j$.util.stream;

import j$.util.Spliterator;
import j$.util.stream.IntStream;
import java.util.Comparator;
import java.util.Iterator;
import java.util.Optional;
import java.util.Spliterator;
import java.util.function.BiConsumer;
import java.util.function.BiFunction;
import java.util.function.BinaryOperator;
import java.util.function.Consumer;
import java.util.function.Function;
import java.util.function.IntFunction;
import java.util.function.Predicate;
import java.util.function.Supplier;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import java.util.stream.BaseStream;
import java.util.stream.Collector;
import java.util.stream.DoubleStream;
import java.util.stream.LongStream;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public interface Stream extends h {

    public final /* synthetic */ class Wrapper implements java.util.stream.Stream {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.stream.Stream convert(Stream stream) {
            if (stream == null) {
                return null;
            }
            return stream instanceof b3 ? ((b3) stream).a : stream.new Wrapper();
        }

        public final /* synthetic */ boolean allMatch(Predicate predicate) {
            return Stream.this.allMatch(predicate);
        }

        public final /* synthetic */ boolean anyMatch(Predicate predicate) {
            return Stream.this.anyMatch(predicate);
        }

        public final /* synthetic */ void close() {
            Stream.this.close();
        }

        public final /* synthetic */ Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
            return Stream.this.collect(supplier, biConsumer, biConsumer2);
        }

        public final /* synthetic */ Object collect(Collector collector) {
            return Stream.this.h(j.a(collector));
        }

        public final /* synthetic */ long count() {
            return Stream.this.count();
        }

        public final /* synthetic */ java.util.stream.Stream distinct() {
            return convert(Stream.this.distinct());
        }

        public final /* synthetic */ java.util.stream.Stream dropWhile(Predicate predicate) {
            return convert(Stream.this.dropWhile(predicate));
        }

        public final /* synthetic */ boolean equals(Object obj) {
            Stream stream = Stream.this;
            if (obj instanceof Wrapper) {
                obj = Stream.this;
            }
            return stream.equals(obj);
        }

        public final /* synthetic */ java.util.stream.Stream filter(Predicate predicate) {
            return convert(Stream.this.filter(predicate));
        }

        public final /* synthetic */ Optional findAny() {
            return j$.util.A.n(Stream.this.findAny());
        }

        public final /* synthetic */ Optional findFirst() {
            return j$.util.A.n(Stream.this.findFirst());
        }

        public final /* synthetic */ java.util.stream.Stream flatMap(Function function) {
            return convert(Stream.this.e(y0.R(function)));
        }

        public final /* synthetic */ DoubleStream flatMapToDouble(Function function) {
            return E.k(Stream.this.z(y0.R(function)));
        }

        public final /* synthetic */ java.util.stream.IntStream flatMapToInt(Function function) {
            return IntStream.Wrapper.convert(Stream.this.t(y0.R(function)));
        }

        public final /* synthetic */ LongStream flatMapToLong(Function function) {
            return m0.k(Stream.this.o(y0.R(function)));
        }

        public final /* synthetic */ void forEach(Consumer consumer) {
            Stream.this.forEach(consumer);
        }

        public final /* synthetic */ void forEachOrdered(Consumer consumer) {
            Stream.this.forEachOrdered(consumer);
        }

        public final /* synthetic */ int hashCode() {
            return Stream.this.hashCode();
        }

        public final /* synthetic */ boolean isParallel() {
            return Stream.this.isParallel();
        }

        public final /* synthetic */ Iterator iterator() {
            return Stream.this.iterator();
        }

        public final /* synthetic */ java.util.stream.Stream limit(long j) {
            return convert(Stream.this.limit(j));
        }

        public final /* synthetic */ java.util.stream.Stream map(Function function) {
            return convert(Stream.this.map(function));
        }

        public final /* synthetic */ DoubleStream mapToDouble(ToDoubleFunction toDoubleFunction) {
            return E.k(Stream.this.mapToDouble(toDoubleFunction));
        }

        public final /* synthetic */ java.util.stream.IntStream mapToInt(ToIntFunction toIntFunction) {
            return IntStream.Wrapper.convert(Stream.this.mapToInt(toIntFunction));
        }

        public final /* synthetic */ LongStream mapToLong(ToLongFunction toLongFunction) {
            return m0.k(Stream.this.mapToLong(toLongFunction));
        }

        public final /* synthetic */ Optional max(Comparator comparator) {
            return j$.util.A.n(Stream.this.max(comparator));
        }

        public final /* synthetic */ Optional min(Comparator comparator) {
            return j$.util.A.n(Stream.this.min(comparator));
        }

        public final /* synthetic */ boolean noneMatch(Predicate predicate) {
            return Stream.this.noneMatch(predicate);
        }

        public final /* synthetic */ BaseStream onClose(Runnable runnable) {
            return g.k(Stream.this.onClose(runnable));
        }

        public final /* synthetic */ BaseStream parallel() {
            return g.k(Stream.this.parallel());
        }

        public final /* synthetic */ java.util.stream.Stream peek(Consumer consumer) {
            return convert(Stream.this.peek(consumer));
        }

        public final /* synthetic */ Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
            return Stream.this.reduce(obj, biFunction, binaryOperator);
        }

        public final /* synthetic */ Object reduce(Object obj, BinaryOperator binaryOperator) {
            return Stream.this.reduce(obj, binaryOperator);
        }

        public final /* synthetic */ Optional reduce(BinaryOperator binaryOperator) {
            return j$.util.A.n(Stream.this.reduce(binaryOperator));
        }

        public final /* synthetic */ BaseStream sequential() {
            return g.k(Stream.this.sequential());
        }

        public final /* synthetic */ java.util.stream.Stream skip(long j) {
            return convert(Stream.this.skip(j));
        }

        public final /* synthetic */ java.util.stream.Stream sorted() {
            return convert(Stream.this.sorted());
        }

        public final /* synthetic */ java.util.stream.Stream sorted(Comparator comparator) {
            return convert(Stream.this.sorted(comparator));
        }

        public final /* synthetic */ Spliterator spliterator() {
            return Spliterator.Wrapper.convert(Stream.this.spliterator());
        }

        public final /* synthetic */ java.util.stream.Stream takeWhile(Predicate predicate) {
            return convert(Stream.this.takeWhile(predicate));
        }

        public final /* synthetic */ Object[] toArray() {
            return Stream.this.toArray();
        }

        public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
            return Stream.this.toArray(intFunction);
        }

        public final /* synthetic */ BaseStream unordered() {
            return g.k(Stream.this.unordered());
        }
    }

    boolean allMatch(Predicate predicate);

    boolean anyMatch(Predicate predicate);

    Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2);

    long count();

    Stream distinct();

    Stream dropWhile(Predicate predicate);

    Stream e(a aVar);

    Stream filter(Predicate predicate);

    j$.util.Optional findAny();

    j$.util.Optional findFirst();

    void forEach(Consumer consumer);

    void forEachOrdered(Consumer consumer);

    Object h(j jVar);

    Stream limit(long j);

    Stream map(Function function);

    F mapToDouble(ToDoubleFunction toDoubleFunction);

    IntStream mapToInt(ToIntFunction toIntFunction);

    n0 mapToLong(ToLongFunction toLongFunction);

    j$.util.Optional max(Comparator comparator);

    j$.util.Optional min(Comparator comparator);

    boolean noneMatch(Predicate predicate);

    n0 o(a aVar);

    Stream peek(Consumer consumer);

    j$.util.Optional reduce(BinaryOperator binaryOperator);

    Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator);

    Object reduce(Object obj, BinaryOperator binaryOperator);

    Stream skip(long j);

    Stream sorted();

    Stream sorted(Comparator comparator);

    IntStream t(a aVar);

    Stream takeWhile(Predicate predicate);

    Object[] toArray();

    Object[] toArray(IntFunction intFunction);

    F z(a aVar);
}
