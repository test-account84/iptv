package j$.util;

import java.util.function.Consumer;
import java.util.function.LongConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
final class Y extends A implements K {
    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        A.c(this, consumer);
    }

    public final void forEachRemaining(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
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
        return A.i(this, consumer);
    }

    public final boolean tryAdvance(LongConsumer longConsumer) {
        Objects.requireNonNull(longConsumer);
        return false;
    }

    public final /* bridge */ /* synthetic */ K trySplit() {
        return null;
    }

    public final /* bridge */ /* synthetic */ N trySplit() {
        return null;
    }
}
