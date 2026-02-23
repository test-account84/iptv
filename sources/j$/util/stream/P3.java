package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class p3 extends g3 implements j$.util.E {
    final void d() {
        T2 t2 = new T2();
        this.h = t2;
        Objects.requireNonNull(t2);
        this.e = this.b.W(new o3(t2, 0));
        this.f = new a(this, 2);
    }

    final g3 e(Spliterator spliterator) {
        return new p3(this.b, spliterator, this.a);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.A.a(this, consumer);
    }

    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        if (this.h != null || this.i) {
            while (tryAdvance(doubleConsumer)) {
            }
            return;
        }
        Objects.requireNonNull(doubleConsumer);
        c();
        Objects.requireNonNull(doubleConsumer);
        o3 o3Var = new o3(doubleConsumer, 1);
        this.b.V(this.d, o3Var);
        this.i = true;
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.A.g(this, consumer);
    }

    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        boolean a = a();
        if (a) {
            T2 t2 = (T2) this.h;
            long j = this.g;
            int u = t2.u(j);
            doubleConsumer.accept((t2.c == 0 && u == 0) ? ((double[]) t2.e)[(int) j] : ((double[][]) t2.f)[u][(int) (j - t2.d[u])]);
        }
        return a;
    }

    public final j$.util.E trySplit() {
        return (j$.util.E) super.trySplit();
    }

    public final j$.util.N trySplit() {
        return (j$.util.E) super.trySplit();
    }

    public final Spliterator trySplit() {
        return (j$.util.E) super.trySplit();
    }
}
