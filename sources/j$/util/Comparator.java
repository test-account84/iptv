package j$.util;

import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
public interface Comparator {

    public final /* synthetic */ class -CC {
        public static java.util.Comparator $default$thenComparing(java.util.Comparator comparator, java.util.Comparator comparator2) {
            Objects.requireNonNull(comparator2);
            return new c(comparator, comparator2, 0);
        }

        public static java.util.Comparator $default$thenComparing(java.util.Comparator comparator, Function function) {
            return A.t(comparator, comparing(function));
        }

        public static java.util.Comparator $default$thenComparing(java.util.Comparator comparator, Function function, java.util.Comparator comparator2) {
            Objects.requireNonNull(function);
            Objects.requireNonNull(comparator2);
            return A.t(comparator, new c(comparator2, function, 1));
        }

        public static java.util.Comparator $default$thenComparingDouble(java.util.Comparator comparator, ToDoubleFunction toDoubleFunction) {
            Objects.requireNonNull(toDoubleFunction);
            return A.t(comparator, new b(toDoubleFunction, 1));
        }

        public static java.util.Comparator $default$thenComparingInt(java.util.Comparator comparator, ToIntFunction toIntFunction) {
            Objects.requireNonNull(toIntFunction);
            return A.t(comparator, new b(toIntFunction, 0));
        }

        public static java.util.Comparator $default$thenComparingLong(java.util.Comparator comparator, ToLongFunction toLongFunction) {
            Objects.requireNonNull(toLongFunction);
            return A.t(comparator, new b(toLongFunction, 3));
        }

        public static java.util.Comparator a() {
            return d.INSTANCE;
        }

        public static java.util.Comparator comparing(Function function) {
            Objects.requireNonNull(function);
            return new b(function, 2);
        }
    }

    java.util.Comparator reversed();

    java.util.Comparator thenComparing(java.util.Comparator comparator);

    java.util.Comparator thenComparing(Function function);

    java.util.Comparator thenComparing(Function function, java.util.Comparator comparator);

    java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction);

    java.util.Comparator thenComparingInt(ToIntFunction toIntFunction);

    java.util.Comparator thenComparingLong(ToLongFunction toLongFunction);
}
