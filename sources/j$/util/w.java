package j$.util;

import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class W extends A implements E {
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        A.a(this, consumer);
    }

    public final void forEachRemaining(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
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
        return A.g(this, consumer);
    }

    public final boolean tryAdvance(DoubleConsumer doubleConsumer) {
        Objects.requireNonNull(doubleConsumer);
        return false;
    }

    public final /* bridge */ /* synthetic */ E trySplit() {
        return null;
    }

    public final /* bridge */ /* synthetic */ N trySplit() {
        return null;
    }
}
