package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.Spliterators;
import java.util.function.BiConsumer;
import java.util.function.BinaryOperator;
import java.util.function.IntBinaryOperator;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.ObjIntConsumer;
import java.util.function.Supplier;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
abstract class c0 extends b implements IntStream {
    static /* bridge */ /* synthetic */ j$.util.H Y(Spliterator spliterator) {
        return Z(spliterator);
    }

    private static j$.util.H Z(Spliterator spliterator) {
        if (spliterator instanceof j$.util.H) {
            return (j$.util.H) spliterator;
        }
        if (!N3.a) {
            throw new UnsupportedOperationException("IntStream.adapt(Spliterator<Integer> s)");
        }
        N3.a(b.class, "using IntStream.adapt(Spliterator<Integer> s)");
        throw null;
    }

    final K0 F(b bVar, Spliterator spliterator, boolean z, IntFunction intFunction) {
        return y0.G(bVar, spliterator, z);
    }

    final boolean H(Spliterator spliterator, q2 q2Var) {
        IntConsumer v;
        boolean o;
        j$.util.H Z = Z(spliterator);
        if (q2Var instanceof IntConsumer) {
            v = (IntConsumer) q2Var;
        } else {
            if (N3.a) {
                N3.a(b.class, "using IntStream.adapt(Sink<Integer> s)");
                throw null;
            }
            Objects.requireNonNull(q2Var);
            v = new V(q2Var);
        }
        do {
            o = q2Var.o();
            if (o) {
                break;
            }
        } while (Z.tryAdvance(v));
        return o;
    }

    final f3 I() {
        return f3.INT_VALUE;
    }

    final C0 N(long j, IntFunction intFunction) {
        return y0.S(j);
    }

    final Spliterator U(b bVar, Supplier supplier, boolean z) {
        return new r3(bVar, supplier, z);
    }

    public final IntStream a() {
        int i = m4.a;
        Objects.requireNonNull(null);
        return new S3(this, m4.a, 0);
    }

    public final F asDoubleStream() {
        return new v(this, 0, 3);
    }

    public final n0 asLongStream() {
        return new x(this, 0, 1);
    }

    public final j$.util.k average() {
        long j = ((long[]) collect(new s(14), new s(15), new s(16)))[0];
        return j > 0 ? j$.util.k.d(r0[1] / j) : j$.util.k.a();
    }

    public final IntStream b() {
        Objects.requireNonNull(null);
        return new w(this, e3.t, 3);
    }

    public final Stream boxed() {
        return new u(this, 0, new s(8), 1);
    }

    public final IntStream c() {
        int i = m4.a;
        Objects.requireNonNull(null);
        return new U3(this, m4.b, 0);
    }

    public final Object collect(Supplier supplier, ObjIntConsumer objIntConsumer, BiConsumer biConsumer) {
        Objects.requireNonNull(biConsumer);
        r rVar = new r(biConsumer, 1);
        Objects.requireNonNull(supplier);
        Objects.requireNonNull(objIntConsumer);
        Objects.requireNonNull(rVar);
        return D(new E1(f3.INT_VALUE, (BinaryOperator) rVar, (Object) objIntConsumer, supplier, 4));
    }

    public final long count() {
        return ((Long) D(new G1(3))).longValue();
    }

    public final IntStream d() {
        Objects.requireNonNull(null);
        return new w(this, e3.p | e3.n, 1);
    }

    public final IntStream distinct() {
        return ((i2) ((i2) boxed()).distinct()).mapToInt(new s(7));
    }

    public final F f() {
        Objects.requireNonNull(null);
        return new v(this, e3.p | e3.n, 4);
    }

    public final j$.util.l findAny() {
        return (j$.util.l) D(I.d);
    }

    public final j$.util.l findFirst() {
        return (j$.util.l) D(I.c);
    }

    public void forEach(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        D(new O(intConsumer, false));
    }

    public void forEachOrdered(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        D(new O(intConsumer, true));
    }

    public final boolean g() {
        return ((Boolean) D(y0.Z(v0.NONE))).booleanValue();
    }

    public final j$.util.u iterator() {
        return Spliterators.g(spliterator());
    }

    public final IntStream limit(long j) {
        if (j >= 0) {
            return y0.Y(this, 0L, j);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    public final n0 m() {
        Objects.requireNonNull(null);
        return new x(this, e3.p | e3.n, 2);
    }

    public final Stream mapToObj(IntFunction intFunction) {
        Objects.requireNonNull(intFunction);
        return new u(this, e3.p | e3.n, intFunction, 1);
    }

    public final j$.util.l max() {
        return reduce(new s(13));
    }

    public final j$.util.l min() {
        return reduce(new s(9));
    }

    public final IntStream peek(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        return new X(this, intConsumer);
    }

    public final IntStream q(Q0 q0) {
        Objects.requireNonNull(q0);
        return new X(this, e3.p | e3.n | e3.t, q0, 1);
    }

    public final int reduce(int i, IntBinaryOperator intBinaryOperator) {
        Objects.requireNonNull(intBinaryOperator);
        return ((Integer) D(new P1(f3.INT_VALUE, intBinaryOperator, i))).intValue();
    }

    public final j$.util.l reduce(IntBinaryOperator intBinaryOperator) {
        Objects.requireNonNull(intBinaryOperator);
        return (j$.util.l) D(new C1(f3.INT_VALUE, intBinaryOperator, 3));
    }

    public final boolean s() {
        return ((Boolean) D(y0.Z(v0.ANY))).booleanValue();
    }

    public final IntStream skip(long j) {
        if (j >= 0) {
            return j == 0 ? this : y0.Y(this, j, -1L);
        }
        throw new IllegalArgumentException(Long.toString(j));
    }

    public final IntStream sorted() {
        return new J2(this, e3.q | e3.o, 0);
    }

    public final j$.util.H spliterator() {
        return Z(super.spliterator());
    }

    public final int sum() {
        return reduce(0, new s(12));
    }

    public final j$.util.h summaryStatistics() {
        return (j$.util.h) collect(new q(17), new s(10), new s(11));
    }

    public final int[] toArray() {
        return (int[]) y0.P((G0) E(new s(6))).e();
    }

    public final boolean v() {
        return ((Boolean) D(y0.Z(v0.ALL))).booleanValue();
    }
}
