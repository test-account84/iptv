package j$.util.stream;

import java.util.function.IntConsumer;
import java.util.function.IntFunction;
import java.util.function.IntPredicate;
import java.util.function.IntToDoubleFunction;
import java.util.function.IntToLongFunction;
import java.util.function.IntUnaryOperator;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class W extends k2 {
    public final /* synthetic */ int b;
    final /* synthetic */ b c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public /* synthetic */ W(b bVar, q2 q2Var, int i) {
        super(q2Var);
        this.b = i;
        this.c = bVar;
    }

    public final void accept(int i) {
        switch (this.b) {
            case 0:
                this.a.accept(((IntFunction) ((u) this.c).n).apply(i));
                return;
            case 1:
                ((IntConsumer) ((X) this.c).n).accept(i);
                this.a.accept(i);
                return;
            case 2:
                ((w) this.c).getClass();
                IntUnaryOperator intUnaryOperator = null;
                intUnaryOperator.applyAsInt(i);
                throw null;
            case 3:
                ((x) this.c).getClass();
                IntToLongFunction intToLongFunction = null;
                intToLongFunction.applyAsLong(i);
                throw null;
            case 4:
                ((v) this.c).getClass();
                IntToDoubleFunction intToDoubleFunction = null;
                intToDoubleFunction.applyAsDouble(i);
                throw null;
            default:
                ((w) this.c).getClass();
                IntPredicate intPredicate = null;
                intPredicate.test(i);
                throw null;
        }
    }

    public void m(long j) {
        switch (this.b) {
            case 5:
                this.a.m(-1L);
                break;
            default:
                super.m(j);
                break;
        }
    }
}
