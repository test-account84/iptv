package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Predicate;
import java.util.function.Supplier;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class G implements K3 {
    final int a;
    final Object b;
    final Predicate c;
    final Supplier d;

    G(boolean z, f3 f3Var, Object obj, Predicate predicate, Supplier supplier) {
        this.a = (z ? 0 : e3.r) | e3.u;
        this.b = obj;
        this.c = predicate;
        this.d = supplier;
    }

    public final Object b(b bVar, Spliterator spliterator) {
        L3 l3 = (L3) this.d.get();
        bVar.V(spliterator, l3);
        Object obj = l3.get();
        return obj != null ? obj : this.b;
    }

    public final Object c(b bVar, Spliterator spliterator) {
        return new M(this, e3.ORDERED.q(bVar.K()), bVar, spliterator).invoke();
    }

    public final int d() {
        return this.a;
    }
}
