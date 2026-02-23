package j$.util;

import j$.util.Spliterator;
import java.util.Spliterator;
import java.util.function.Consumer;
import java.util.function.DoubleConsumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class D implements Spliterator.OfDouble {
    public final /* synthetic */ E a;

    private /* synthetic */ D(E e) {
        this.a = e;
    }

    public static /* synthetic */ Spliterator.OfDouble a(E e) {
        if (e == null) {
            return null;
        }
        return e instanceof C ? ((C) e).a : new D(e);
    }

    public final /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        E e = this.a;
        if (obj instanceof D) {
            obj = ((D) obj).a;
        }
        return e.equals(obj);
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

    public final /* synthetic */ void forEachRemaining(DoubleConsumer doubleConsumer) {
        this.a.forEachRemaining(doubleConsumer);
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

    public final /* synthetic */ boolean tryAdvance(DoubleConsumer doubleConsumer) {
        return this.a.tryAdvance(doubleConsumer);
    }

    public final /* synthetic */ Spliterator.OfDouble trySplit() {
        return a(this.a.trySplit());
    }

    public final /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return M.a(this.a.trySplit());
    }

    public final /* synthetic */ java.util.Spliterator trySplit() {
        return Spliterator.Wrapper.convert(this.a.trySplit());
    }
}
