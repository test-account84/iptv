package j$.util.stream;

import j$.util.Objects;
import java.util.function.IntConsumer;
import java.util.function.IntFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class Z extends k2 {
    boolean b;
    V c;
    final /* synthetic */ X d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Z(X x, q2 q2Var) {
        super(q2Var);
        this.d = x;
        q2 q2Var2 = this.a;
        Objects.requireNonNull(q2Var2);
        this.c = new V(q2Var2);
    }

    public final void accept(int i) {
        IntStream intStream = (IntStream) ((IntFunction) this.d.n).apply(i);
        if (intStream != null) {
            try {
                boolean z = this.b;
                V v = this.c;
                if (z) {
                    j$.util.H spliterator = intStream.sequential().spliterator();
                    while (!this.a.o() && spliterator.tryAdvance((IntConsumer) v)) {
                    }
                } else {
                    intStream.sequential().forEach(v);
                }
            } catch (Throwable th) {
                try {
                    intStream.close();
                } catch (Throwable th2) {
                    th.addSuppressed(th2);
                }
                throw th;
            }
        }
        if (intStream != null) {
            intStream.close();
        }
    }

    public final void m(long j) {
        this.a.m(-1L);
    }

    public final boolean o() {
        this.b = true;
        return this.a.o();
    }
}
