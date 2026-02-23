package j$.util.stream;

import j$.util.Spliterator;
import j$.util.Spliterators;
import java.util.Arrays;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.LongConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
class p1 implements I0 {
    final long[] a;
    int b;

    p1(long j) {
        if (j >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        this.a = new long[(int) j];
        this.b = 0;
    }

    p1(long[] jArr) {
        this.a = jArr;
        this.b = jArr.length;
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
        System.arraycopy(this.a, 0, (long[]) obj, i, i2);
    }

    public final Object e() {
        long[] jArr = this.a;
        int length = jArr.length;
        int i = this.b;
        return length == i ? jArr : Arrays.copyOf(jArr, i);
    }

    public final void f(Object obj) {
        LongConsumer longConsumer = (LongConsumer) obj;
        for (int i = 0; i < this.b; i++) {
            longConsumer.accept(this.a[i]);
        }
    }

    public final /* synthetic */ void forEach(Consumer consumer) {
        y0.s(this, consumer);
    }

    public final /* synthetic */ Object[] p(IntFunction intFunction) {
        return y0.m(this, intFunction);
    }

    public final /* synthetic */ int r() {
        return 0;
    }

    /* renamed from: s, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ void j(Long[] lArr, int i) {
        y0.p(this, lArr, i);
    }

    public final j$.util.N spliterator() {
        return Spliterators.l(this.a, 0, this.b);
    }

    public final Spliterator spliterator() {
        return Spliterators.l(this.a, 0, this.b);
    }

    /* renamed from: t, reason: merged with bridge method [inline-methods] */
    public final /* synthetic */ I0 i(long j, long j2, IntFunction intFunction) {
        return y0.v(this, j, j2);
    }

    public String toString() {
        long[] jArr = this.a;
        return String.format("LongArrayNode[%d][%s]", new Object[]{Integer.valueOf(jArr.length - this.b), Arrays.toString(jArr)});
    }
}
