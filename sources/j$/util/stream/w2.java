package j$.util.stream;

import j$.util.Spliterators;
import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class W2 extends Y2 implements j$.util.K {
    final /* synthetic */ X2 g;

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    W2(X2 x2, int i, int i2, int i3, int i4) {
        super(x2, i, i2, i3, i4);
        this.g = x2;
    }

    final void a(int i, Object obj, Object obj2) {
        ((LongConsumer) obj2).accept(((long[]) obj)[i]);
    }

    final j$.util.N b(Object obj, int i, int i2) {
        return Spliterators.l((long[]) obj, i, i2 + i);
    }

    final j$.util.N c(int i, int i2, int i3, int i4) {
        return new W2(this.g, i, i2, i3, i4);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.A.c(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.A.i(this, consumer);
    }
}
