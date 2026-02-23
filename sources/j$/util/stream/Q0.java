package j$.util.stream;

import java.util.function.Predicate;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class q0 extends u0 {
    final /* synthetic */ v0 c;
    final /* synthetic */ Predicate d;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    q0(v0 v0Var, Predicate predicate) {
        super(v0Var);
        this.c = v0Var;
        this.d = predicate;
    }

    public final void accept(Object obj) {
        if (this.a) {
            return;
        }
        boolean test = this.d.test(obj);
        v0 v0Var = this.c;
        if (test == v0.k(v0Var)) {
            this.a = true;
            this.b = v0.i(v0Var);
        }
    }
}
