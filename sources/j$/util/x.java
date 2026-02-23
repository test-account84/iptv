package j$.util;

import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class X extends A implements H {
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        A.b(this, consumer);
    }

    public final void forEachRemaining(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
    }

    public final java.util.Comparator getComparator() {
        throw new IllegalStateException();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return A.d(this);
    }

    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return A.e(this, i);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return A.h(this, consumer);
    }

    public final boolean tryAdvance(IntConsumer intConsumer) {
        Objects.requireNonNull(intConsumer);
        return false;
    }

    public final /* bridge */ /* synthetic */ H trySplit() {
        return null;
    }

    public final /* bridge */ /* synthetic */ N trySplit() {
        return null;
    }
}
