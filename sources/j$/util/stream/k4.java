package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.Predicate;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class k4 extends l4 implements Consumer {
    final Predicate f;
    Object g;
    public final /* synthetic */ int h;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k4(Spliterator spliterator, k4 k4Var, int i) {
        super(spliterator, k4Var);
        this.h = i;
        this.f = k4Var.f;
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public k4(Spliterator spliterator, Predicate predicate, int i) {
        super(spliterator);
        this.h = i;
        this.f = predicate;
    }

    public final void accept(Object obj) {
        this.e = (this.e + 1) & 63;
        this.g = obj;
    }

    public final /* synthetic */ Consumer andThen(Consumer consumer) {
        return j$.com.android.tools.r8.a.d(this, consumer);
    }

    final Spliterator c(Spliterator spliterator) {
        switch (this.h) {
            case 0:
                return new k4(spliterator, this, 0);
            default:
                return new k4(spliterator, this, 1);
        }
    }

    public final boolean tryAdvance(Consumer consumer) {
        boolean tryAdvance;
        boolean z;
        switch (this.h) {
            case 0:
                boolean z2 = this.d;
                Spliterator spliterator = this.a;
                if (!z2) {
                    return spliterator.tryAdvance(consumer);
                }
                boolean z3 = false;
                this.d = false;
                while (true) {
                    tryAdvance = spliterator.tryAdvance(this);
                    if (tryAdvance && b() && this.f.test(this.g)) {
                        z3 = true;
                    }
                }
                if (!tryAdvance) {
                    return tryAdvance;
                }
                if (z3) {
                    this.c.set(true);
                }
                consumer.accept(this.g);
                return tryAdvance;
            default:
                if (this.d && b() && this.a.tryAdvance(this)) {
                    z = this.f.test(this.g);
                    if (z) {
                        consumer.accept(this.g);
                        return true;
                    }
                } else {
                    z = true;
                }
                this.d = false;
                if (!z) {
                    this.c.set(true);
                }
                return false;
        }
    }

    public Spliterator trySplit() {
        switch (this.h) {
            case 1:
                if (!this.c.get()) {
                    break;
                }
                break;
        }
        return super.trySplit();
    }
}
