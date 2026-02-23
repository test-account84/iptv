package j$.util.stream;

import java.util.function.DoubleConsumer;
import java.util.function.DoubleFunction;
import java.util.function.DoublePredicate;
import java.util.function.DoubleToIntFunction;
import java.util.function.DoubleToLongFunction;
import java.util.function.DoubleUnaryOperator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class t extends j2 {
    public final /* synthetic */ int b;
    final /* synthetic */ b c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ t(b bVar, q2 q2Var, int i) {
        super(q2Var);
        this.b = i;
        this.c = bVar;
    }

    public final void accept(double d) {
        switch (this.b) {
            case 0:
                this.a.accept(((DoubleFunction) ((u) this.c).n).apply(d));
                return;
            case 1:
                ((v) this.c).getClass();
                DoubleUnaryOperator doubleUnaryOperator = null;
                doubleUnaryOperator.applyAsDouble(d);
                throw null;
            case 2:
                ((w) this.c).getClass();
                DoubleToIntFunction doubleToIntFunction = null;
                doubleToIntFunction.applyAsInt(d);
                throw null;
            case 3:
                ((x) this.c).getClass();
                DoubleToLongFunction doubleToLongFunction = null;
                doubleToLongFunction.applyAsLong(d);
                throw null;
            case 4:
                ((v) this.c).getClass();
                DoublePredicate doublePredicate = null;
                doublePredicate.test(d);
                throw null;
            default:
                ((DoubleConsumer) ((z) this.c).n).accept(d);
                this.a.accept(d);
                return;
        }
    }

    public void m(long j) {
        switch (this.b) {
            case 4:
                this.a.m(-1L);
                break;
            default:
                super.m(j);
                break;
        }
    }
}
