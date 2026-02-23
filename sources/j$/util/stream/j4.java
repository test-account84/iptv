package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;
import java.util.function.LongPredicate;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class j4 extends l4 implements LongConsumer, j$.util.K {
    long f;
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j4(Spliterator spliterator, int i) {
        super(spliterator);
        this.g = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ j4(Spliterator spliterator, l4 l4Var, int i) {
        super(spliterator, l4Var);
        this.g = i;
    }

    public final void accept(long j) {
        this.e = (this.e + 1) & 63;
        this.f = j;
    }

    public final /* synthetic */ LongConsumer andThen(LongConsumer longConsumer) {
        return j$.com.android.tools.r8.a.g(this, longConsumer);
    }

    final Spliterator c(Spliterator spliterator) {
        j$.util.K k = (j$.util.K) spliterator;
        switch (this.g) {
            case 0:
                return new j4(k, this, 0);
            default:
                return new j4(k, this, 1);
        }
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.A.c(this, consumer);
    }

    public final void forEachRemaining(LongConsumer longConsumer) {
        while (tryAdvance(longConsumer)) {
        }
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(Object obj) {
        switch (this.g) {
            case 1:
                d((LongConsumer) obj);
                return false;
            default:
                return d(obj);
        }
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.A.i(this, consumer);
    }

    /* renamed from: tryAdvance, reason: merged with bridge method [inline-methods] */
    public final boolean d(LongConsumer longConsumer) {
        switch (this.g) {
            case 0:
                boolean z = this.d;
                Spliterator spliterator = this.a;
                if (!z) {
                    return ((j$.util.K) spliterator).tryAdvance(longConsumer);
                }
                this.d = false;
                boolean tryAdvance = ((j$.util.K) spliterator).tryAdvance((LongConsumer) this);
                if (tryAdvance && b()) {
                    LongPredicate longPredicate = null;
                    longPredicate.test(this.f);
                    throw null;
                }
                if (!tryAdvance) {
                    return tryAdvance;
                }
                longConsumer.accept(this.f);
                return tryAdvance;
            default:
                if (!this.d || !b() || !((j$.util.K) this.a).tryAdvance((LongConsumer) this)) {
                    this.d = false;
                    return false;
                }
                LongPredicate longPredicate2 = null;
                longPredicate2.test(this.f);
                throw null;
        }
    }

    public j$.util.K trySplit() {
        switch (this.g) {
            case 1:
                if (this.c.get()) {
                    return null;
                }
                return (j$.util.K) super.trySplit();
            default:
                return super.trySplit();
        }
    }

    public /* bridge */ /* synthetic */ j$.util.N trySplit() {
        switch (this.g) {
            case 1:
                return trySplit();
            default:
                return super.trySplit();
        }
    }

    public /* bridge */ /* synthetic */ Spliterator trySplit() {
        switch (this.g) {
            case 1:
                return trySplit();
            default:
                return super.trySplit();
        }
    }
}
