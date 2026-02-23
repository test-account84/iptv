package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Comparator;
import java.util.function.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class E3 extends G3 implements Spliterator, Consumer {
    Object f;

    public final void accept(Object obj) {
        this.f = obj;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return j$.com.android.tools.r8.a.d(this, consumer);
    }

    protected final Spliterator c(Spliterator spliterator) {
        return new E3(spliterator, this);
    }

    public final void forEachRemaining(Consumer consumer) {
        Objects.requireNonNull(consumer);
        l3 l3Var = null;
        while (true) {
            F3 d = d();
            if (d == F3.NO_MORE) {
                return;
            }
            F3 f3 = F3.MAYBE_MORE;
            Spliterator spliterator = this.a;
            if (d != f3) {
                spliterator.forEachRemaining(consumer);
                return;
            }
            int i = this.c;
            if (l3Var == null) {
                l3Var = new l3(i);
            } else {
                l3Var.a = 0;
            }
            long j = 0;
            while (spliterator.tryAdvance(l3Var)) {
                j++;
                if (j >= i) {
                    break;
                }
            }
            if (j == 0) {
                return;
            }
            long b = b(j);
            for (int i2 = 0; i2 < b; i2++) {
                consumer.accept(l3Var.b[i2]);
            }
        }
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

    public final boolean tryAdvance(Consumer consumer) {
        Objects.requireNonNull(consumer);
        while (d() != F3.NO_MORE && this.a.tryAdvance(this)) {
            if (b(1L) == 1) {
                consumer.accept(this.f);
                this.f = null;
                return true;
            }
        }
        return false;
    }
}
