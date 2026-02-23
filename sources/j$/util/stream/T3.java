package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class t3 extends g3 implements j$.util.K {
    final void d() {
        X2 x2 = new X2();
        this.h = x2;
        Objects.requireNonNull(x2);
        this.e = this.b.W(new s3(x2, 0));
        this.f = new a(this, 4);
    }

    final g3 e(Spliterator spliterator) {
        return new t3(this.b, spliterator, this.a);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.A.c(this, consumer);
    }

    public final void forEachRemaining(LongConsumer longConsumer) {
        if (this.h != null || this.i) {
            while (tryAdvance(longConsumer)) {
            }
            return;
        }
        Objects.requireNonNull(longConsumer);
        c();
        Objects.requireNonNull(longConsumer);
        s3 s3Var = new s3(longConsumer, 1);
        this.b.V(this.d, s3Var);
        this.i = true;
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.A.i(this, consumer);
    }

    public final boolean tryAdvance(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        boolean a = a();
        if (a) {
            X2 x2 = (X2) this.h;
            long j = this.g;
            int u = x2.u(j);
            longConsumer.accept((x2.c == 0 && u == 0) ? ((long[]) x2.e)[(int) j] : ((long[][]) x2.f)[u][(int) (j - x2.d[u])]);
        }
        return a;
    }

    public final j$.util.K trySplit() {
        return (j$.util.K) super.trySplit();
    }

    public final j$.util.N trySplit() {
        return (j$.util.K) super.trySplit();
    }

    public final Spliterator trySplit() {
        return (j$.util.K) super.trySplit();
    }
}
