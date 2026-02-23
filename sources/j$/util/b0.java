package j$.util;

import java.util.Iterator;
import java.util.function.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
class b0 implements Spliterator {
    private final java.util.Collection a;
    private Iterator b;
    private final int c;
    private long d;
    private int e;

    public b0(java.util.Collection collection, int i) {
        this.a = collection;
        this.b = null;
        this.c = (i & 4096) == 0 ? i | 16448 : i;
    }

    public b0(Iterator it, int i) {
        this.a = null;
        this.b = it;
        this.d = Long.MAX_VALUE;
        this.c = i & (-16449);
    }

    public final int characteristics() {
        return this.c;
    }

    public final long estimateSize() {
        if (this.b != null) {
            return this.d;
        }
        java.util.Collection collection = this.a;
        this.b = collection.iterator();
        long size = collection.size();
        this.d = size;
        return size;
    }

    public final void forEachRemaining(Consumer consumer) {
        consumer.getClass();
        Iterator it = this.b;
        if (it == null) {
            Iterator it2 = this.a.iterator();
            this.b = it2;
            this.d = r0.size();
            it = it2;
        }
        if (it instanceof i) {
            ((i) it).forEachRemaining(consumer);
            return;
        }
        Objects.requireNonNull(consumer);
        while (it.hasNext()) {
            consumer.accept(it.next());
        }
    }

    public java.util.Comparator getComparator() {
        if (A.e(this, 4)) {
            return null;
        }
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
        if (this.b == null) {
            this.b = this.a.iterator();
            this.d = r0.size();
        }
        if (!this.b.hasNext()) {
            return false;
        }
        consumer.accept(this.b.next());
        return true;
    }

    public final Spliterator trySplit() {
        long j;
        Iterator it = this.b;
        if (it == null) {
            java.util.Collection collection = this.a;
            Iterator it2 = collection.iterator();
            this.b = it2;
            j = collection.size();
            this.d = j;
            it = it2;
        } else {
            j = this.d;
        }
        if (j <= 1 || !it.hasNext()) {
            return null;
        }
        int i = this.e + 1024;
        if (i > j) {
            i = (int) j;
        }
        if (i > 33554432) {
            i = 33554432;
        }
        Object[] objArr = new Object[i];
        int i2 = 0;
        do {
            objArr[i2] = it.next();
            i2++;
            if (i2 >= i) {
                break;
            }
        } while (it.hasNext());
        this.e = i2;
        long j2 = this.d;
        if (j2 != Long.MAX_VALUE) {
            this.d = j2 - i2;
        }
        return new U(objArr, 0, i2, this.c);
    }
}
