package j$.util.stream;

import j$.util.Spliterator;
import java.util.function.IntConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class a0 extends c0 {
    final boolean Q() {
        throw new UnsupportedOperationException();
    }

    final q2 R(int i, q2 q2Var) {
        throw new UnsupportedOperationException();
    }

    public final void forEach(IntConsumer intConsumer) {
        if (isParallel()) {
            super.forEach(intConsumer);
        } else {
            c0.Y(T()).forEachRemaining(intConsumer);
        }
    }

    public final void forEachOrdered(IntConsumer intConsumer) {
        if (isParallel()) {
            super.forEachOrdered(intConsumer);
        } else {
            c0.Y(T()).forEachRemaining(intConsumer);
        }
    }

    public final /* bridge */ /* synthetic */ IntStream parallel() {
        parallel();
        return this;
    }

    public final /* bridge */ /* synthetic */ IntStream sequential() {
        sequential();
        return this;
    }

    public final /* bridge */ /* synthetic */ Spliterator spliterator() {
        return spliterator();
    }

    public final h unordered() {
        return !L() ? this : new w(this, e3.r, 2);
    }
}
