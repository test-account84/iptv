package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.Arrays;
import java.util.function.IntFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class I2 extends B {
    public final K0 O(b bVar, Spliterator spliterator, IntFunction intFunction) {
        if (e3.SORTED.q(bVar.K())) {
            return bVar.C(spliterator, false, intFunction);
        }
        double[] dArr = (double[]) ((E0) bVar.C(spliterator, true, intFunction)).e();
        Arrays.sort(dArr);
        return new X0(dArr);
    }

    public final q2 R(int i, q2 q2Var) {
        Objects.requireNonNull(q2Var);
        return e3.SORTED.q(i) ? q2Var : e3.SIZED.q(i) ? new N2(q2Var) : new F2(q2Var);
    }
}
