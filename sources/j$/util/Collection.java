package j$.util;

import j$.lang.Iterable;
import j$.util.stream.Stream;
import j$.util.stream.y0;
import java.util.Iterator;
import java.util.function.Consumer;
import java.util.function.IntFunction;
import java.util.function.Predicate;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public interface Collection extends Iterable {

    public final /* synthetic */ class -CC {
        public static Stream $default$parallelStream(java.util.Collection collection) {
            return y0.f0(A.s(collection), true);
        }

        public static boolean $default$removeIf(java.util.Collection collection, Predicate predicate) {
            if (DesugarCollections.a.isInstance(collection)) {
                return DesugarCollections.c(collection, predicate);
            }
            Objects.requireNonNull(predicate);
            Iterator it = collection.iterator();
            boolean z = false;
            while (it.hasNext()) {
                if (predicate.test(it.next())) {
                    it.remove();
                    z = true;
                }
            }
            return z;
        }

        public static Stream $default$stream(java.util.Collection collection) {
            return y0.f0(A.s(collection), false);
        }

        public static Object[] $default$toArray(java.util.Collection collection, IntFunction intFunction) {
            return collection.toArray((Object[]) intFunction.apply(0));
        }
    }

    void forEach(Consumer consumer);

    Stream parallelStream();

    boolean removeIf(Predicate predicate);

    Spliterator spliterator();

    Stream stream();

    Object[] toArray(IntFunction intFunction);
}
