package j$.util.concurrent;

import j$.util.A;
import j$.util.K;
import java.util.Comparator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class z implements K {
    long a;
    final long b;
    final long c;
    final long d;

    z(long j, long j2, long j3, long j4) {
        this.a = j;
        this.b = j2;
        this.c = j3;
        this.d = j4;
    }

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public final z trySplit() {
        long j = this.a;
        long j2 = (this.b + j) >>> 1;
        if (j2 <= j) {
            return null;
        }
        this.a = j2;
        return new z(j, j2, this.c, this.d);
    }

    public final int characteristics() {
        return 17728;
    }

    public final long estimateSize() {
        return this.b - this.a;
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        A.c(this, consumer);
    }

    public final void forEachRemaining(LongConsumer longConsumer) {
        longConsumer.getClass();
        long j = this.a;
        long j2 = this.b;
        if (j < j2) {
            this.a = j2;
            ThreadLocalRandom current = ThreadLocalRandom.current();
            do {
                longConsumer.accept(current.e(this.c, this.d));
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
        return A.i(this, consumer);
    }

    public final boolean tryAdvance(LongConsumer longConsumer) {
        longConsumer.getClass();
        long j = this.a;
        if (j >= this.b) {
            return false;
        }
        longConsumer.accept(ThreadLocalRandom.current().e(this.c, this.d));
        this.a = j + 1;
        return true;
    }
}
