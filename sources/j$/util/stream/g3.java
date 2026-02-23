package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.atomic.AtomicLong;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
abstract class G3 {
    protected final Spliterator a;
    protected final boolean b;
    protected final int c;
    private final long d;
    private final AtomicLong e;

    G3(Spliterator spliterator, long j, long j2) {
        this.a = spliterator;
        this.b = j2 < 0;
        this.d = j2 >= 0 ? j2 : 0L;
        this.c = 128;
        this.e = new AtomicLong(j2 >= 0 ? j + j2 : j);
    }

    G3(Spliterator spliterator, G3 g3) {
        this.a = spliterator;
        this.b = g3.b;
        this.e = g3.e;
        this.d = g3.d;
        this.c = g3.c;
    }

    protected final long b(long j) {
        AtomicLong atomicLong;
        long j2;
        boolean z;
        long min;
        do {
            atomicLong = this.e;
            j2 = atomicLong.get();
            z = this.b;
            if (j2 != 0) {
                min = Math.min(j2, j);
                if (min <= 0) {
                    break;
                }
            } else {
                if (z) {
                    return j;
                }
                return 0L;
            }
        } while (!atomicLong.compareAndSet(j2, j2 - min));
        if (z) {
            return Math.max(j - min, 0L);
        }
        long j3 = this.d;
        return j2 > j3 ? Math.max(min - (j2 - j3), 0L) : min;
    }

    protected abstract Spliterator c(Spliterator spliterator);

    public final int characteristics() {
        return this.a.characteristics() & (-16465);
    }

    protected final F3 d() {
        return this.e.get() > 0 ? F3.MAYBE_MORE : this.b ? F3.UNLIMITED : F3.NO_MORE;
    }

    public final long estimateSize() {
        return this.a.estimateSize();
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

    public /* bridge */ /* synthetic */ j$.util.N trySplit() {
        return (j$.util.N) trySplit();
    }

    public final Spliterator trySplit() {
        Spliterator trySplit;
        if (this.e.get() == 0 || (trySplit = this.a.trySplit()) == null) {
            return null;
        }
        return c(trySplit);
    }
}
