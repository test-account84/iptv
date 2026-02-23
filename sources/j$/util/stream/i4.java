package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;
import java.util.function.IntPredicate;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class i4 extends l4 implements IntConsumer, j$.util.H {
    int f;
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i4(Spliterator spliterator, int i) {
        super(spliterator);
        this.g = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ i4(Spliterator spliterator, l4 l4Var, int i) {
        super(spliterator, l4Var);
        this.g = i;
    }

    public final void accept(int i) {
        this.e = (this.e + 1) & 63;
        this.f = i;
    }

    public final /* synthetic */ IntConsumer andThen(IntConsumer intConsumer) {
        return j$.com.android.tools.r8.a.f(this, intConsumer);
    }

    final Spliterator c(Spliterator spliterator) {
        j$.util.H h = (j$.util.H) spliterator;
        switch (this.g) {
            case 0:
                return new i4(h, this, 0);
            default:
                return new i4(h, this, 1);
        }
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.A.b(this, consumer);
    }

    public final void forEachRemaining(IntConsumer intConsumer) {
        while (tryAdvance(intConsumer)) {
        }
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(Object obj) {
        switch (this.g) {
            case 1:
                d((IntConsumer) obj);
                return false;
            default:
                return d(obj);
        }
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.A.h(this, consumer);
    }

    /* renamed from: tryAdvance, reason: merged with bridge method [inline-methods] */
    public final boolean d(IntConsumer intConsumer) {
        switch (this.g) {
            case 0:
                boolean z = this.d;
                Spliterator spliterator = this.a;
                if (!z) {
                    return ((j$.util.H) spliterator).tryAdvance(intConsumer);
                }
                this.d = false;
                boolean tryAdvance = ((j$.util.H) spliterator).tryAdvance((IntConsumer) this);
                if (tryAdvance && b()) {
                    IntPredicate intPredicate = null;
                    intPredicate.test(this.f);
                    throw null;
                }
                if (!tryAdvance) {
                    return tryAdvance;
                }
                intConsumer.accept(this.f);
                return tryAdvance;
            default:
                if (!this.d || !b() || !((j$.util.H) this.a).tryAdvance((IntConsumer) this)) {
                    this.d = false;
                    return false;
                }
                IntPredicate intPredicate2 = null;
                intPredicate2.test(this.f);
                throw null;
        }
    }

    public j$.util.H trySplit() {
        switch (this.g) {
            case 1:
                if (this.c.get()) {
                    return null;
                }
                return (j$.util.H) super.trySplit();
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
