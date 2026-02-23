package j$.util.stream;

import java.util.function.LongPredicate;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class V3 extends l2 {
    boolean b;
    final /* synthetic */ W3 c;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    V3(W3 w3, q2 q2Var) {
        super(q2Var);
        this.c = w3;
        this.b = true;
    }

    public final void accept(long j) {
        if (this.b) {
            this.c.getClass();
            LongPredicate longPredicate = null;
            longPredicate.test(j);
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
