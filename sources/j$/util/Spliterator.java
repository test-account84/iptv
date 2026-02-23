package j$.util;

import java.util.function.Consumer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public interface Spliterator {

    public final /* synthetic */ class Wrapper implements java.util.Spliterator {
        private /* synthetic */ Wrapper() {
        }

        public static /* synthetic */ java.util.Spliterator convert(Spliterator spliterator) {
            if (spliterator == null) {
                return null;
            }
            return spliterator instanceof O ? ((O) spliterator).a : spliterator instanceof N ? M.a((N) spliterator) : spliterator.new Wrapper();
        }

        public final /* synthetic */ int characteristics() {
            return Spliterator.this.characteristics();
        }

        public final /* synthetic */ boolean equals(Object obj) {
            Spliterator spliterator = Spliterator.this;
            if (obj instanceof Wrapper) {
                obj = Spliterator.this;
            }
            return spliterator.equals(obj);
        }

        public final /* synthetic */ long estimateSize() {
            return Spliterator.this.estimateSize();
        }

        public final /* synthetic */ void forEachRemaining(Consumer consumer) {
            Spliterator.this.forEachRemaining(consumer);
        }

        public final /* synthetic */ java.util.Comparator getComparator() {
            return Spliterator.this.getComparator();
        }

        public final /* synthetic */ long getExactSizeIfKnown() {
            return Spliterator.this.getExactSizeIfKnown();
        }

        public final /* synthetic */ boolean hasCharacteristics(int i) {
            return Spliterator.this.hasCharacteristics(i);
        }

        public final /* synthetic */ int hashCode() {
            return Spliterator.this.hashCode();
        }

        public final /* synthetic */ boolean tryAdvance(Consumer consumer) {
            return Spliterator.this.tryAdvance(consumer);
        }

        public final /* synthetic */ java.util.Spliterator trySplit() {
            return convert(Spliterator.this.trySplit());
        }
    }

    int characteristics();

    long estimateSize();

    void forEachRemaining(Consumer consumer);

    java.util.Comparator getComparator();

    long getExactSizeIfKnown();

    boolean hasCharacteristics(int i);

    boolean tryAdvance(Consumer consumer);

    Spliterator trySplit();
}
