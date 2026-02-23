package j$.util;

import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.IntConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class F implements H {
    public final /* synthetic */ Spliterator.OfInt a;

    private /* synthetic */ F(Spliterator.OfInt ofInt) {
        this.a = ofInt;
    }

    public static /* synthetic */ H a(Spliterator.OfInt ofInt) {
        if (ofInt == null) {
            return null;
        }
        return ofInt instanceof G ? ((G) ofInt).a : new F(ofInt);
    }

    public final /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        Spliterator.OfInt ofInt = this.a;
        if (obj instanceof F) {
            obj = ((F) obj).a;
        }
        return ofInt.equals(obj);
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

    public final /* synthetic */ H trySplit() {
        return a(this.a.trySplit());
    }

    public final /* synthetic */ N trySplit() {
        return L.a(this.a.trySplit());
    }

    public final /* synthetic */ Spliterator trySplit() {
        return O.a(this.a.trySplit());
    }
}
