package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Arrays;
import java.util.function.IntFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class K2 extends j0 {
    public final K0 O(b bVar, Spliterator spliterator, IntFunction intFunction) {
        if (e3.SORTED.q(bVar.K())) {
            return bVar.C(spliterator, false, intFunction);
        }
        long[] jArr = (long[]) ((I0) bVar.C(spliterator, true, intFunction)).e();
        Arrays.sort(jArr);
        return new p1(jArr);
    }

    public final q2 R(int i, q2 q2Var) {
        Objects.requireNonNull(q2Var);
        return e3.SORTED.q(i) ? q2Var : e3.SIZED.q(i) ? new P2(q2Var) : new H2(q2Var);
    }
}
