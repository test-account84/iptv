package j$.util.stream;

import j$.util.Objects;
import java.util.function.DoubleConsumer;
import java.util.function.Function;
import java.util.function.IntConsumer;
import java.util.function.LongConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class d2 extends m2 {
    public final /* synthetic */ int b = 1;
    boolean c;
    Object d;
    final /* synthetic */ b e;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d2(X x, q2 q2Var) {
        super(q2Var);
        this.e = x;
        q2 q2Var2 = this.a;
        Objects.requireNonNull(q2Var2);
        this.d = new V(q2Var2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d2(h0 h0Var, q2 q2Var) {
        super(q2Var);
        this.e = h0Var;
        q2 q2Var2 = this.a;
        Objects.requireNonNull(q2Var2);
        this.d = new d0(q2Var2);
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public d2(z zVar, q2 q2Var) {
        super(q2Var);
        this.e = zVar;
        q2 q2Var2 = this.a;
        Objects.requireNonNull(q2Var2);
        this.d = new p(q2Var2);
    }

    public final void accept(Object obj) {
        switch (this.b) {
            case 0:
                n0 n0Var = (n0) ((Function) ((h0) this.e).n).apply(obj);
                if (n0Var != null) {
                    try {
                        boolean z = this.c;
                        d0 d0Var = (d0) this.d;
                        if (z) {
                            j$.util.K spliterator = n0Var.sequential().spliterator();
                            while (!this.a.o() && spliterator.tryAdvance((LongConsumer) d0Var)) {
                            }
                        } else {
                            n0Var.sequential().forEach(d0Var);
                        }
                    } catch (Throwable th) {
                        try {
                            n0Var.close();
                        } catch (Throwable th2) {
                            th.addSuppressed(th2);
                        }
                        throw th;
                    }
                }
                if (n0Var != null) {
                    n0Var.close();
                    return;
                }
                return;
            case 1:
                IntStream intStream = (IntStream) ((Function) ((X) this.e).n).apply(obj);
                if (intStream != null) {
                    try {
                        boolean z2 = this.c;
                        V v = (V) this.d;
                        if (z2) {
                            j$.util.H spliterator2 = intStream.sequential().spliterator();
                            while (!this.a.o() && spliterator2.tryAdvance((IntConsumer) v)) {
                            }
                        } else {
                            intStream.sequential().forEach(v);
                        }
                    } catch (Throwable th3) {
                        try {
                            intStream.close();
                        } catch (Throwable th4) {
                            th3.addSuppressed(th4);
                        }
                        throw th3;
                    }
                }
                if (intStream != null) {
                    intStream.close();
                    return;
                }
                return;
            default:
                F f = (F) ((Function) ((z) this.e).n).apply(obj);
                if (f != null) {
                    try {
                        boolean z3 = this.c;
                        p pVar = (p) this.d;
                        if (z3) {
                            j$.util.E spliterator3 = f.sequential().spliterator();
                            while (!this.a.o() && spliterator3.tryAdvance((DoubleConsumer) pVar)) {
                            }
                        } else {
                            f.sequential().forEach(pVar);
                        }
                    } catch (Throwable th5) {
                        try {
                            f.close();
                        } catch (Throwable th6) {
                            th5.addSuppressed(th6);
                        }
                        throw th5;
                    }
                }
                if (f != null) {
                    f.close();
                    return;
                }
                return;
        }
    }

    public final void m(long j) {
        switch (this.b) {
            case 0:
                this.a.m(-1L);
                break;
            case 1:
                this.a.m(-1L);
                break;
            default:
                this.a.m(-1L);
                break;
        }
    }

    public final boolean o() {
        switch (this.b) {
            case 0:
                this.c = true;
                break;
            case 1:
                this.c = true;
                break;
            default:
                this.c = true;
                break;
        }
        return this.a.o();
    }
}
