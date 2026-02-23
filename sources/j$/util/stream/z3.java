package j$.util.stream;

import java.util.function.DoublePredicate;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class Z3 extends j2 {
    boolean b;
    final /* synthetic */ a4 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    Z3(a4 a4Var, q2 q2Var) {
        super(q2Var);
        this.c = a4Var;
        this.b = true;
    }

    public final void accept(double d) {
        if (this.b) {
            this.c.getClass();
            DoublePredicate doublePredicate = null;
            doublePredicate.test(d);
            throw null;
        }
    }

    public final void m(long j) {
        this.a.m(-1L);
    }

    public final boolean o() {
        return !this.b || this.a.o();
    }
}
