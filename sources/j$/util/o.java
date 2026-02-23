package j$.util;

import j$.util.Spliterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class O implements Spliterator {
    public final /* synthetic */ java.util.Spliterator a;

    private /* synthetic */ O(java.util.Spliterator spliterator) {
        this.a = spliterator;
    }

    public static /* synthetic */ Spliterator a(java.util.Spliterator spliterator) {
        if (spliterator == null) {
            return null;
        }
        return spliterator instanceof Spliterator.Wrapper ? ((Spliterator.Wrapper) spliterator).a : spliterator instanceof Spliterator.OfPrimitive ? L.a((Spliterator.OfPrimitive) spliterator) : new O(spliterator);
    }

    public final /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        java.util.Spliterator spliterator = this.a;
        if (obj instanceof O) {
            obj = ((O) obj).a;
        }
        return spliterator.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(consumer);
    }

    public final /* synthetic */ java.util.Comparator getComparator() {
        return this.a.getComparator();
    }

    public final /* synthetic */ long getExactSizeIfKnown() {
        return this.a.getExactSizeIfKnown();
    }

    public final /* synthetic */ boolean hasCharacteristics(int i) {
        return this.a.hasCharacteristics(i);
    }

    public final /* synthetic */ int hashCode() {
        return this.a.hashCode();
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.a.tryAdvance(consumer);
    }

    public final /* synthetic */ Spliterator trySplit() {
        return a(this.a.trySplit());
    }
}
