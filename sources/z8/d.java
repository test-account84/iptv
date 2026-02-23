package z8;

import kotlin.jvm.internal.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class d {
    public static final String a(Object from, Object until) {
        l.e(from, "from");
        l.e(until, "until");
        return "Random range is empty: [" + from + ", " + until + ").";
    }

    public static final void b(int i, int i2) {
        if (i2 <= i) {
            throw new IllegalArgumentException(a(Integer.valueOf(i), Integer.valueOf(i2)).toString());
        }
    }

    public static final int c(int i) {
        return 31 - Integer.numberOfLeadingZeros(i);
    }

    public static final int d(c cVar, B8.c range) {
        l.e(cVar, "<this>");
        l.e(range, "range");
        if (!range.isEmpty()) {
            return range.f() < Integer.MAX_VALUE ? cVar.d(range.d(), range.f() + 1) : range.d() > Integer.MIN_VALUE ? cVar.d(range.d() - 1, range.f()) + 1 : cVar.c();
        }
        throw new IllegalArgumentException("Cannot get random in empty range: " + range);
    }

    public static final int e(int i, int i2) {
        return (i >>> (32 - i2)) & ((-i2) >> 31);
    }
}
