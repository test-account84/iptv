package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;
import java.util.function.DoublePredicate;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class h4 extends l4 implements DoubleConsumer, j$.util.E {
    double f;
    public final /* synthetic */ int g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h4(Spliterator spliterator, int i) {
        super(spliterator);
        this.g = i;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ h4(Spliterator spliterator, l4 l4Var, int i) {
        super(spliterator, l4Var);
        this.g = i;
    }

    public final void accept(double d) {
        this.e = (this.e + 1) & 63;
        this.f = d;
    }

    public final /* synthetic */ DoubleConsumer andThen(DoubleConsumer doubleConsumer) {
        return j$.com.android.tools.r8.a.e(this, doubleConsumer);
    }

    final Spliterator c(Spliterator spliterator) {
        j$.util.E e = (j$.util.E) spliterator;
        switch (this.g) {
            case 0:
                return new h4(e, this, 0);
            default:
                return new h4(e, this, 1);
        }
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.A.a(this, consumer);
    }

    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        while (tryAdvance(doubleConsumer)) {
        }
    }

    public /* bridge */ /* synthetic */ boolean tryAdvance(Object obj) {
        switch (this.g) {
            case 1:
                d((DoubleConsumer) obj);
                return false;
            default:
                return d(obj);
        }
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.A.g(this, consumer);
    }

    /* renamed from: tryAdvance, reason: merged with bridge method [inline-methods] */
    public final boolean d(DoubleConsumer doubleConsumer) {
        switch (this.g) {
            case 0:
                boolean z = this.d;
                Spliterator spliterator = this.a;
                if (!z) {
                    return ((j$.util.E) spliterator).tryAdvance(doubleConsumer);
                }
                this.d = false;
                boolean tryAdvance = ((j$.util.E) spliterator).tryAdvance((DoubleConsumer) this);
                if (tryAdvance && b()) {
                    DoublePredicate doublePredicate = null;
                    doublePredicate.test(this.f);
                    throw null;
                }
                if (!tryAdvance) {
                    return tryAdvance;
                }
                doubleConsumer.accept(this.f);
                return tryAdvance;
            default:
                if (!this.d || !b() || !((j$.util.E) this.a).tryAdvance((DoubleConsumer) this)) {
                    this.d = false;
                    return false;
                }
                DoublePredicate doublePredicate2 = null;
                doublePredicate2.test(this.f);
                throw null;
        }
    }

    public j$.util.E trySplit() {
        switch (this.g) {
            case 1:
                if (this.c.get()) {
                    return null;
                }
                return (j$.util.E) super.trySplit();
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
