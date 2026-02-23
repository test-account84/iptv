package j$.util.concurrent;

import j$.util.A;
import j$.util.Spliterator;
import java.util.Comparator;
import java.util.function.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class f extends p implements Spliterator {
    final ConcurrentHashMap i;
    long j;

    f(l[] lVarArr, int i, int i2, int i3, long j, ConcurrentHashMap concurrentHashMap) {
        super(lVarArr, i, i2, i3);
        this.i = concurrentHashMap;
        this.j = j;
    }

    public final int characteristics() {
        return 4353;
    }

    public final long estimateSize() {
        return this.j;
    }

    public final void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        while (true) {
            l a = a();
            if (a == null) {
                return;
            } else {
                consumer.accept(new k(a.b, a.c, this.i));
            }
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

    public final boolean tryAdvance(Consumer consumer) {
        consumer.getClass();
        l a = a();
        if (a == null) {
            return false;
        }
        consumer.accept(new k(a.b, a.c, this.i));
        return true;
    }

    public final Spliterator trySplit() {
        int i = this.f;
        int i2 = this.g;
        int i3 = (i + i2) >>> 1;
        if (i3 <= i) {
            return null;
        }
        l[] lVarArr = this.a;
        this.g = i3;
        long j = this.j >>> 1;
        this.j = j;
        return new f(lVarArr, this.h, i3, i2, j, this.i);
    }
}
