package j$.util.stream;

import j$.util.Optional;
import j$.util.Spliterator;
import j$.util.stream.IntStream;
import j$.util.stream.Stream;
import java.util.Comparator;
import java.util.Iterator;
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

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class b3 implements Stream {
    public final /* synthetic */ java.util.stream.Stream a;

    private /* synthetic */ b3(java.util.stream.Stream stream) {
        this.a = stream;
    }

    public static /* synthetic */ Stream k(java.util.stream.Stream stream) {
        if (stream == null) {
            return null;
        }
        return stream instanceof Stream.Wrapper ? Stream.this : new b3(stream);
    }

    public final /* synthetic */ boolean allMatch(Predicate predicate) {
        return this.a.allMatch(predicate);
    }

    public final /* synthetic */ boolean anyMatch(Predicate predicate) {
        return this.a.anyMatch(predicate);
    }

    public final /* synthetic */ void close() {
        this.a.close();
    }

    public final /* synthetic */ Object collect(Supplier supplier, BiConsumer biConsumer, BiConsumer biConsumer2) {
        return this.a.collect(supplier, biConsumer, biConsumer2);
    }

    public final /* synthetic */ long count() {
        return this.a.count();
    }

    public final /* synthetic */ Stream distinct() {
        return k(this.a.distinct());
    }

    public final /* synthetic */ Stream dropWhile(Predicate predicate) {
        return k(this.a.dropWhile(predicate));
    }

    public final /* synthetic */ Stream e(a aVar) {
        return k(this.a.flatMap(y0.R(aVar)));
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.util.stream.Stream stream = this.a;
        if (obj instanceof b3) {
            obj = ((b3) obj).a;
        }
        return stream.equals(obj);
    }

    public final /* synthetic */ Stream filter(Predicate predicate) {
        return k(this.a.filter(predicate));
    }

    public final /* synthetic */ Optional findAny() {
        return j$.util.A.j(this.a.findAny());
    }

    public final /* synthetic */ Optional findFirst() {
        return j$.util.A.j(this.a.findFirst());
    }

    public final /* synthetic */ void forEach(Consumer consumer) {
        this.a.forEach(consumer);
    }

    public final /* synthetic */ void forEachOrdered(Consumer consumer) {
        this.a.forEachOrdered(consumer);
    }

    public final /* synthetic */ Object h(j jVar) {
        return this.a.collect(jVar == null ? null : jVar.a);
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

    public final /* synthetic */ Stream limit(long j) {
        return k(this.a.limit(j));
    }

    public final /* synthetic */ Stream map(Function function) {
        return k(this.a.map(function));
    }

    public final /* synthetic */ F mapToDouble(ToDoubleFunction toDoubleFunction) {
        return D.k(this.a.mapToDouble(toDoubleFunction));
    }

    public final /* synthetic */ IntStream mapToInt(ToIntFunction toIntFunction) {
        return IntStream.VivifiedWrapper.convert(this.a.mapToInt(toIntFunction));
    }

    public final /* synthetic */ n0 mapToLong(ToLongFunction toLongFunction) {
        return l0.k(this.a.mapToLong(toLongFunction));
    }

    public final /* synthetic */ Optional max(Comparator comparator) {
        return j$.util.A.j(this.a.max(comparator));
    }

    public final /* synthetic */ Optional min(Comparator comparator) {
        return j$.util.A.j(this.a.min(comparator));
    }

    public final /* synthetic */ boolean noneMatch(Predicate predicate) {
        return this.a.noneMatch(predicate);
    }

    public final /* synthetic */ n0 o(a aVar) {
        return l0.k(this.a.flatMapToLong(y0.R(aVar)));
    }

    public final /* synthetic */ h onClose(Runnable runnable) {
        return f.k(this.a.onClose(runnable));
    }

    public final /* synthetic */ h parallel() {
        return f.k(this.a.parallel());
    }

    public final /* synthetic */ Stream peek(Consumer consumer) {
        return k(this.a.peek(consumer));
    }

    public final /* synthetic */ Optional reduce(BinaryOperator binaryOperator) {
        return j$.util.A.j(this.a.reduce(binaryOperator));
    }

    public final /* synthetic */ Object reduce(Object obj, BiFunction biFunction, BinaryOperator binaryOperator) {
        return this.a.reduce(obj, biFunction, binaryOperator);
    }

    public final /* synthetic */ Object reduce(Object obj, BinaryOperator binaryOperator) {
        return this.a.reduce(obj, binaryOperator);
    }

    public final /* synthetic */ h sequential() {
        return f.k(this.a.sequential());
    }

    public final /* synthetic */ Stream skip(long j) {
        return k(this.a.skip(j));
    }

    public final /* synthetic */ Stream sorted() {
        return k(this.a.sorted());
    }

    public final /* synthetic */ Stream sorted(Comparator comparator) {
        return k(this.a.sorted(comparator));
    }

    public final /* synthetic */ Spliterator spliterator() {
        return j$.util.O.a(this.a.spliterator());
    }

    public final /* synthetic */ IntStream t(a aVar) {
        return IntStream.VivifiedWrapper.convert(this.a.flatMapToInt(y0.R(aVar)));
    }

    public final /* synthetic */ Stream takeWhile(Predicate predicate) {
        return k(this.a.takeWhile(predicate));
    }

    public final /* synthetic */ Object[] toArray() {
        return this.a.toArray();
    }

    public final /* synthetic */ Object[] toArray(IntFunction intFunction) {
        return this.a.toArray(intFunction);
    }

    public final /* synthetic */ h unordered() {
        return f.k(this.a.unordered());
    }

    public final /* synthetic */ F z(a aVar) {
        return D.k(this.a.flatMapToDouble(y0.R(aVar)));
    }
}
