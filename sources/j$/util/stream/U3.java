package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class u3 extends x3 implements j$.util.E {
    protected final Spliterator a(Spliterator spliterator, long j, long j2, long j3, long j4) {
        return new u3((j$.util.E) spliterator, j, j2, j3, j4);
    }

    protected final Object b() {
        return new D0(1);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        j$.util.A.a(this, consumer);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return j$.util.A.g(this, consumer);
    }
}
