package j$.util;

import j$.util.Spliterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class G implements Spliterator.OfInt {
    public final /* synthetic */ H a;

    private /* synthetic */ G(H h) {
        this.a = h;
    }

    public static /* synthetic */ Spliterator.OfInt a(H h) {
        if (h == null) {
            return null;
        }
        return h instanceof F ? ((F) h).a : new G(h);
    }

    public final /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        H h = this.a;
        if (obj instanceof G) {
            obj = ((G) obj).a;
        }
        return h.equals(obj);
    }

    public final /* synthetic */ long estimateSize() {
        return this.a.estimateSize();
    }

    public final /* synthetic */ void forEachRemaining(Object obj) {
        this.a.forEachRemaining(obj);
    }

    public final /* synthetic */ void forEachRemaining(Consumer consumer) {
        this.a.forEachRemaining(consumer);
    }

    public final /* synthetic */ void forEachRemaining(IntConsumer intConsumer) {
        this.a.forEachRemaining(intConsumer);
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

    public final /* synthetic */ boolean tryAdvance(Object obj) {
        return this.a.tryAdvance(obj);
    }

    public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
        return this.a.tryAdvance(consumer);
    }

    public final /* synthetic */ boolean tryAdvance(IntConsumer intConsumer) {
        return this.a.tryAdvance(intConsumer);
    }

    public final /* synthetic */ Spliterator.OfInt trySplit() {
        return a(this.a.trySplit());
    }

    public final /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return M.a(this.a.trySplit());
    }

    public final /* synthetic */ java.util.Spliterator trySplit() {
        return Spliterator.Wrapper.convert(this.a.trySplit());
    }
}
