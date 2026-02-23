package j$.util.stream;

import j$.util.Spliterator;
import j$.util.Spliterators;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.IntFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
class X0 implements E0 {
    final double[] a;
    int b;

    X0(long j) {
        if (j >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.a = new double[(int) j];
        this.b = 0;
    }

    X0(double[] dArr) {
        this.a = dArr;
        this.b = dArr.length;
    }

    public final J0 b(int i) {
        throw new IndexOutOfBoundsException();
    }

    public final /* bridge */ /* synthetic */ K0 b(int i) {
        b(i);
        throw null;
    }

    public final long count() {
        return this.b;
    }

    public final void d(Object obj, int i) {
        int i2 = this.b;
        System.arraycopy(this.a, 0, (double[]) obj, i, i2);
    }

    public final Object e() {
        double[] dArr = this.a;
        int length = dArr.length;
        int i = this.b;
        return length == i ? dArr : Arrays.copyOf(dArr, i);
    }

    public final void f(Object obj) {
        DoubleConsumer doubleConsumer = (DoubleConsumer) obj;
        for (int i = 0; i < this.b; i++) {
            doubleConsumer.accept(this.a[i]);
        }
    }

    public final /* synthetic */ void forEach(Consumer consumer) {
        y0.q(this, consumer);
    }

    public final /* synthetic */ Object[] p(IntFunction intFunction) {
        return y0.m(this, intFunction);
    }

    public final /* synthetic */ int r() {
        return 0;
    }

    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void j(Double[] dArr, int i) {
        y0.n(this, dArr, i);
    }

    public final j$.util.N spliterator() {
        return Spliterators.j(this.a, 0, this.b);
    }

    public final Spliterator spliterator() {
        return Spliterators.j(this.a, 0, this.b);
    }

    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ E0 i(long j, long j2, IntFunction intFunction) {
        return y0.t(this, j, j2);
    }

    public String toString() {
        double[] dArr = this.a;
        return String.format("DoubleArrayNode[%d][%s]", new Object[]{Integer.valueOf(dArr.length - this.b), Arrays.toString(dArr)});
    }
}
