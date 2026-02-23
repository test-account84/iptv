package j$.util.stream;

import j$.util.Spliterator;
import java.util.ArrayDeque;
import java.util.Comparator;
import java.util.Deque;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
abstract class o1 implements Spliterator {
    K0 a;
    int b;
    Spliterator c;
    Spliterator d;
    ArrayDeque e;

    o1(K0 k0) {
        this.a = k0;
    }

    protected static K0 a(Deque deque) {
        while (true) {
            K0 k0 = (K0) deque.pollFirst();
            if (k0 == null) {
                return null;
            }
            if (k0.r() != 0) {
                for (int r = k0.r() - 1; r >= 0; r--) {
                    deque.addFirst(k0.b(r));
                }
            } else if (k0.count() > 0) {
                return k0;
            }
        }
    }

    protected final ArrayDeque b() {
        ArrayDeque arrayDeque = new ArrayDeque(8);
        int r = this.a.r();
        while (true) {
            r--;
            if (r < this.b) {
                return arrayDeque;
            }
            arrayDeque.addFirst(this.a.b(r));
        }
    }

    protected final boolean c() {
        if (this.a == null) {
            return false;
        }
        if (this.d != null) {
            return true;
        }
        Spliterator spliterator = this.c;
        if (spliterator == null) {
            ArrayDeque b = b();
            this.e = b;
            K0 a = a(b);
            if (a == null) {
                this.a = null;
                return false;
            }
            spliterator = a.spliterator();
        }
        this.d = spliterator;
        return true;
    }

    public final int characteristics() {
        return 64;
    }

    public final long estimateSize() {
        long j = 0;
        if (this.a == null) {
            return 0L;
        }
        Spliterator spliterator = this.c;
        if (spliterator != null) {
            return spliterator.estimateSize();
        }
        for (int i = this.b; i < this.a.r(); i++) {
            j += this.a.b(i).count();
        }
        return j;
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
        K0 k0 = this.a;
        if (k0 == null || this.d != null) {
            return null;
        }
        Spliterator spliterator = this.c;
        if (spliterator != null) {
            return spliterator.trySplit();
        }
        if (this.b < k0.r() - 1) {
            K0 k02 = this.a;
            int i = this.b;
            this.b = i + 1;
            return k02.b(i).spliterator();
        }
        K0 b = this.a.b(this.b);
        this.a = b;
        if (b.r() == 0) {
            Spliterator spliterator2 = this.a.spliterator();
            this.c = spliterator2;
            return spliterator2.trySplit();
        }
        K0 k03 = this.a;
        this.b = 1;
        return k03.b(0).spliterator();
    }
}
