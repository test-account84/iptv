package j$.util.stream;

import j$.util.Spliterator;
import java.util.Comparator;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
abstract class l4 implements Spliterator {
    final Spliterator a;
    final boolean b;
    final AtomicBoolean c;
    boolean d;
    int e;

    l4(Spliterator spliterator) {
        this.d = true;
        this.a = spliterator;
        this.b = false;
        this.c = new AtomicBoolean();
    }

    l4(Spliterator spliterator, l4 l4Var) {
        this.d = true;
        this.a = spliterator;
        this.b = l4Var.b;
        this.c = l4Var.c;
    }

    final boolean b() {
        return (this.e == 0 && this.c.get()) ? false : true;
    }

    abstract Spliterator c(Spliterator spliterator);

    public final int characteristics() {
        return this.a.characteristics() & (-16449);
    }

    public final long estimateSize() {
        return this.a.estimateSize();
    }

    public void forEachRemaining(Consumer consumer) {
        while (tryAdvance(consumer)) {
        }
    }

    public final Comparator getComparator() {
        return this.a.getComparator();
    }

    public final long getExactSizeIfKnown() {
        return -1L;
    }

    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return j$.util.A.e(this, i);
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

    public Spliterator trySplit() {
        Spliterator trySplit = this.b ? null : this.a.trySplit();
        if (trySplit != null) {
            return c(trySplit);
        }
        return null;
    }
}
