package j$.util.stream;

import j$.util.Objects;
import java.util.Comparator;
import java.util.function.DoubleConsumer;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
abstract class Y2 implements j$.util.N {
    int a;
    final int b;
    int c;
    final int d;
    Object e;
    final /* synthetic */ Z2 f;

    Y2(Z2 z2, int i, int i2, int i3, int i4) {
        this.f = z2;
        this.a = i;
        this.b = i2;
        this.c = i3;
        this.d = i4;
        Object[] objArr = z2.f;
        this.e = objArr == null ? z2.e : objArr[i];
    }

    abstract void a(int i, Object obj, Object obj2);

    abstract j$.util.N b(Object obj, int i, int i2);

    abstract j$.util.N c(int i, int i2, int i3, int i4);

    public final int characteristics() {
        return 16464;
    }

    public final long estimateSize() {
        int i = this.a;
        int i2 = this.d;
        int i3 = this.b;
        if (i == i3) {
            return i2 - this.c;
        }
        long[] jArr = this.f.d;
        return ((jArr[i3] + i2) - jArr[i]) - this.c;
    }

    public final void forEachRemaining(Object obj) {
        Z2 z2;
        Objects.requireNonNull(obj);
        int i = this.a;
        int i2 = this.d;
        int i3 = this.b;
        if (i < i3 || (i == i3 && this.c < i2)) {
            int i4 = this.c;
            while (true) {
                z2 = this.f;
                if (i >= i3) {
                    break;
                }
                Object obj2 = z2.f[i];
                z2.s(obj2, i4, z2.t(obj2), obj);
                i++;
                i4 = 0;
            }
            z2.s(this.a == i3 ? this.e : z2.f[i3], i4, i2, obj);
            this.a = i3;
            this.c = i2;
        }
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        forEachRemaining((Object) doubleConsumer);
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        forEachRemaining((Object) intConsumer);
    }

    public /* bridge */ /* synthetic */ void forEachRemaining(LongConsumer longConsumer) {
        forEachRemaining((Object) longConsumer);
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return j$.util.A.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return j$.util.A.e(this, i);
    }

    public final boolean tryAdvance(Object obj) {
        Objects.requireNonNull(obj);
        int i = this.a;
        int i2 = this.b;
        if (i >= i2 && (i != i2 || this.c >= this.d)) {
            return false;
        }
        Object obj2 = this.e;
        int i3 = this.c;
        this.c = i3 + 1;
        a(i3, obj2, obj);
        int i4 = this.c;
        Object obj3 = this.e;
        Z2 z2 = this.f;
        if (i4 == z2.t(obj3)) {
            this.c = 0;
            int i5 = this.a + 1;
            this.a = i5;
            Object[] objArr = z2.f;
            if (objArr != null && i5 <= i2) {
                this.e = objArr[i5];
            }
        }
        return true;
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return tryAdvance((Object) doubleConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return tryAdvance((Object) intConsumer);
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(LongConsumer longConsumer) {
        return tryAdvance((Object) longConsumer);
    }

    public /* bridge */ /* synthetic */ j$.util.E trySplit() {
        return (j$.util.E) trySplit();
    }

    public /* bridge */ /* synthetic */ j$.util.H trySplit() {
        return (j$.util.H) trySplit();
    }

    public /* bridge */ /* synthetic */ j$.util.K trySplit() {
        return (j$.util.K) trySplit();
    }

    public final j$.util.N trySplit() {
        int i = this.a;
        int i2 = this.b;
        if (i < i2) {
            int i3 = i2 - 1;
            int i4 = this.c;
            Z2 z2 = this.f;
            j$.util.N c = c(i, i3, i4, z2.t(z2.f[i3]));
            this.a = i2;
            this.c = 0;
            this.e = z2.f[i2];
            return c;
        }
        if (i != i2) {
            return null;
        }
        int i5 = this.c;
        int i6 = (this.d - i5) / 2;
        if (i6 == 0) {
            return null;
        }
        j$.util.N b = b(this.e, i5, i6);
        this.c += i6;
        return b;
    }
}
