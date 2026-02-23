package j$.util.stream;

import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Comparator;
import java.util.function.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class n3 implements Spliterator, Consumer {
    private static final Object d = new Object();
    private final Spliterator a;
    private final ConcurrentHashMap b;
    private Object c;

    n3(Spliterator spliterator) {
        this(spliterator, new ConcurrentHashMap());
    }

    private n3(Spliterator spliterator, ConcurrentHashMap concurrentHashMap) {
        this.a = spliterator;
        this.b = concurrentHashMap;
    }

    public final void accept(Object obj) {
        this.c = obj;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return j$.com.android.tools.r8.a.d(this, consumer);
    }

    final void b(Consumer consumer, Object obj) {
        if (this.b.putIfAbsent(obj != null ? obj : d, Boolean.TRUE) == null) {
            consumer.accept(obj);
        }
    }

    public final int characteristics() {
        return (this.a.characteristics() & (-16469)) | 1;
    }

    public final long estimateSize() {
        return this.a.estimateSize();
    }

    public final void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(new p0(1, this, consumer));
    }

    public final Comparator getComparator() {
        return this.a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return j$.util.A.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return j$.util.A.e(this, i);
    }

    public final boolean tryAdvance(Consumer consumer) {
        while (this.a.tryAdvance(this)) {
            Object obj = this.c;
            if (obj == null) {
                obj = d;
            }
            if (this.b.putIfAbsent(obj, Boolean.TRUE) == null) {
                consumer.accept(this.c);
                this.c = null;
                return true;
            }
        }
        return false;
    }

    public final Spliterator trySplit() {
        Spliterator trySplit = this.a.trySplit();
        if (trySplit != null) {
            return new n3(trySplit, this.b);
        }
        return null;
    }
}
