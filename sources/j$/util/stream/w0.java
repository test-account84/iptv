package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class W0 extends M0 {
    public final void forEach(Consumer consumer) {
        this.a.forEach(consumer);
        this.b.forEach(consumer);
    }

    public final K0 i(long j, long j2, IntFunction intFunction) {
        if (j == 0 && j2 == count()) {
            return this;
        }
        long count = this.a.count();
        if (j >= count) {
            return this.b.i(j - count, j2 - count, intFunction);
        }
        if (j2 <= count) {
            return this.a.i(j, j2, intFunction);
        }
        return y0.I(f3.REFERENCE, this.a.i(j, count, intFunction), this.b.i(0L, j2 - count, intFunction));
    }

    public final void j(Object[] objArr, int i) {
        Objects.requireNonNull(objArr);
        K0 k0 = this.a;
        k0.j(objArr, i);
        this.b.j(objArr, i + ((int) k0.count()));
    }

    public final Object[] p(IntFunction intFunction) {
        long count = count();
        if (count >= 2147483639) {
            throw new IllegalArgumentException("Stream size exceeds max array size");
        }
        Object[] objArr = (Object[]) intFunction.apply((int) count);
        j(objArr, 0);
        return objArr;
    }

    public final Spliterator spliterator() {
        return new n1(this);
    }

    public final String toString() {
        return count() < 32 ? String.format("ConcNode[%s.%s]", new Object[]{this.a, this.b}) : String.format("ConcNode[size=%d]", new Object[]{Long.valueOf(count())});
    }
}
