package j$.util.stream;

import j$.util.Spliterator;
import java.util.concurrent.CountedCompleter;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class b2 extends e {
    private final y0 h;

    b2(b2 b2Var, Spliterator spliterator) {
        super(b2Var, spliterator);
        this.h = b2Var.h;
    }

    b2(y0 y0Var, b bVar, Spliterator spliterator) {
        super(bVar, spliterator);
        this.h = y0Var;
    }

    protected final Object a() {
        b bVar = this.a;
        U1 e0 = this.h.e0();
        bVar.V(this.b, e0);
        return e0;
    }

    protected final e e(Spliterator spliterator) {
        return new b2(this, spliterator);
    }

    public final void onCompletion(CountedCompleter countedCompleter) {
        e eVar = this.d;
        if (eVar != null) {
            U1 u1 = (U1) ((b2) eVar).c();
            u1.h((U1) ((b2) this.e).c());
            f(u1);
        }
        super.onCompletion(countedCompleter);
    }
}
