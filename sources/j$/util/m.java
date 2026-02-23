package j$.util;

import j$.util.Spliterator;
import java.util.Spliterator;
import java.util.function.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public final /* synthetic */ class M implements Spliterator.OfPrimitive {
    public final /* synthetic */ N a;

    private /* synthetic */ M(N n) {
        this.a = n;
    }

    public static /* synthetic */ Spliterator.OfPrimitive a(N n) {
        if (n == null) {
            return null;
        }
        return n instanceof L ? ((L) n).a : n instanceof E ? D.a((E) n) : n instanceof H ? G.a((H) n) : n instanceof K ? J.a((K) n) : new M(n);
    }

    public final /* synthetic */ int characteristics() {
        return this.a.characteristics();
    }

    public final /* synthetic */ boolean equals(Object obj) {
        N n = this.a;
        if (obj instanceof M) {
            obj = ((M) obj).a;
        }
        return n.equals(obj);
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

    public final /* synthetic */ Spliterator.OfPrimitive trySplit() {
        return a(this.a.trySplit());
    }

    public final /* synthetic */ java.util.Spliterator trySplit() {
        return Spliterator.Wrapper.convert(this.a.trySplit());
    }
}
