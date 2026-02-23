package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import j$.util.concurrent.ConcurrentHashMap;
import java.util.Collection;
import java.util.HashSet;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.function.IntFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class o extends h2 {
    static O0 Y(b bVar, Spliterator spliterator) {
        q qVar = new q(19);
        q qVar2 = new q(20);
        q qVar3 = new q(21);
        Objects.requireNonNull(qVar);
        Objects.requireNonNull(qVar2);
        Objects.requireNonNull(qVar3);
        return new O0((Collection) new E1(f3.REFERENCE, (Object) qVar3, (Object) qVar2, (Object) qVar, 3).c(bVar, spliterator));
    }

    final K0 O(b bVar, Spliterator spliterator, IntFunction intFunction) {
        if (e3.DISTINCT.q(bVar.K())) {
            return bVar.C(spliterator, false, intFunction);
        }
        if (e3.ORDERED.q(bVar.K())) {
            return Y(bVar, spliterator);
        }
        AtomicBoolean atomicBoolean = new AtomicBoolean(false);
        ConcurrentHashMap concurrentHashMap = new ConcurrentHashMap();
        p0 p0Var = new p0(2, atomicBoolean, concurrentHashMap);
        Objects.requireNonNull(p0Var);
        new Q(p0Var, false).e(bVar, spliterator);
        Collection keySet = concurrentHashMap.keySet();
        if (atomicBoolean.get()) {
            Collection hashSet = new HashSet(keySet);
            hashSet.add((Object) null);
            keySet = hashSet;
        }
        return new O0(keySet);
    }

    final Spliterator P(b bVar, Spliterator spliterator) {
        return e3.DISTINCT.q(bVar.K()) ? bVar.X(spliterator) : e3.ORDERED.q(bVar.K()) ? Y(bVar, spliterator).spliterator() : new n3(bVar.X(spliterator));
    }

    final q2 R(int i, q2 q2Var) {
        Objects.requireNonNull(q2Var);
        return e3.DISTINCT.q(i) ? q2Var : e3.SORTED.q(i) ? new m(q2Var) : new n(q2Var);
    }
}
