package m8;

import j$.util.Comparator;
import java.util.Comparator;
import java.util.function.Function;
import java.util.function.ToDoubleFunction;
import java.util.function.ToIntFunction;
import java.util.function.ToLongFunction;
import kotlin.jvm.internal.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class b implements Comparator, j$.util.Comparator {
    public static final b a = new b();

    /* renamed from: a, reason: merged with bridge method [inline-methods] */
    public int compare(Comparable a2, Comparable b) {
        l.e(a2, "a");
        l.e(b, "b");
        return a2.compareTo(b);
    }

    public final Comparator reversed() {
        return c.a;
    }

    public /* synthetic */ Comparator thenComparing(Comparator comparator) {
        return Comparator.-CC.$default$thenComparing(this, comparator);
    }

    public /* synthetic */ java.util.Comparator thenComparingDouble(ToDoubleFunction toDoubleFunction) {
        return Comparator.-CC.$default$thenComparingDouble(this, toDoubleFunction);
    }

    public /* synthetic */ java.util.Comparator thenComparingInt(ToIntFunction toIntFunction) {
        return Comparator.-CC.$default$thenComparingInt(this, toIntFunction);
    }

    public /* synthetic */ java.util.Comparator thenComparingLong(ToLongFunction toLongFunction) {
        return Comparator.-CC.$default$thenComparingLong(this, toLongFunction);
    }

    public /* synthetic */ java.util.Comparator thenComparing(Function function) {
        return Comparator.-CC.$default$thenComparing(this, function);
    }

    public /* synthetic */ java.util.Comparator thenComparing(Function function, java.util.Comparator comparator) {
        return Comparator.-CC.$default$thenComparing(this, function, comparator);
    }
}
