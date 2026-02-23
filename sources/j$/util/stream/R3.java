package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class r3 extends g3 implements j$.util.H {
    final void d() {
        V2 v2 = new V2();
        this.h = v2;
        Objects.requireNonNull(v2);
        this.e = this.b.W(new q3(v2, 0));
        this.f = new a(this, 3);
    }

    final g3 e(Spliterator spliterator) {
        return new r3(this.b, spliterator, this.a);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.A.b(this, consumer);
    }

    public final void forEachRemaining(IntConsumer intConsumer) {
        if (this.h != null || this.i) {
            while (tryAdvance(intConsumer)) {
            }
            return;
        }
        Objects.requireNonNull(intConsumer);
        c();
        Objects.requireNonNull(intConsumer);
        q3 q3Var = new q3(intConsumer, 1);
        this.b.V(this.d, q3Var);
        this.i = true;
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.A.h(this, consumer);
    }

    public final boolean tryAdvance(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        boolean a = a();
        if (a) {
            V2 v2 = (V2) this.h;
            long j = this.g;
            int u = v2.u(j);
            intConsumer.accept((v2.c == 0 && u == 0) ? ((int[]) v2.e)[(int) j] : ((int[][]) v2.f)[u][(int) (j - v2.d[u])]);
        }
        return a;
    }

    public final j$.util.H trySplit() {
        return (j$.util.H) super.trySplit();
    }

    public final j$.util.N trySplit() {
        return (j$.util.H) super.trySplit();
    }

    public final Spliterator trySplit() {
        return (j$.util.H) super.trySplit();
    }
}
