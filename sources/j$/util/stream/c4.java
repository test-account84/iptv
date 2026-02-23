package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class c4 extends B implements d4 {
    final K0 O(b bVar, Spliterator spliterator, IntFunction intFunction) {
        return (K0) new f4(this, bVar, spliterator, intFunction).invoke();
    }

    final Spliterator P(b bVar, Spliterator spliterator) {
        return e3.ORDERED.q(bVar.K()) ? O(bVar, spliterator, new c2(11)).spliterator() : new h4((j$.util.E) bVar.X(spliterator), 0);
    }

    final q2 R(int i, q2 q2Var) {
        return new b4(this, q2Var, false);
    }

    public final e4 k(C0 c0, boolean z) {
        return new b4(this, c0, z);
    }
}
