package j$.util.concurrent;

import j$.util.A;
import j$.util.E;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class x implements E {
    long a;
    final long b;
    final double c;
    final double d;

    x(long j, long j2, double d, double d2) {
        this.a = j;
        this.b = j2;
        this.c = d;
        this.d = d2;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final x trySplit() {
        long j = this.a;
        long j2 = (this.b + j) >>> 1;
        if (j2 <= j) {
            return null;
        }
        this.a = j2;
        return new x(j, j2, this.c, this.d);
    }

    public final int characteristics() {
        return 17728;
    }

    public final long estimateSize() {
        return this.b - this.a;
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        A.a(this, consumer);
    }

    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        doubleConsumer.getClass();
        long j = this.a;
        long j2 = this.b;
        if (j < j2) {
            this.a = j2;
            ThreadLocalRandom current = ThreadLocalRandom.current();
            do {
                doubleConsumer.accept(current.c(this.c, this.d));
                j++;
            } while (j < j2);
        }
    }

    public final Comparator getComparator() {
        throw new IllegalStateException();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return A.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return A.e(this, i);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return A.g(this, consumer);
    }

    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        doubleConsumer.getClass();
        long j = this.a;
        if (j >= this.b) {
            return false;
        }
        doubleConsumer.accept(ThreadLocalRandom.current().c(this.c, this.d));
        this.a = j + 1;
        return true;
    }
}
