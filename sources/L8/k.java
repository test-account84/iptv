package l8;

import java.util.ArrayList;
import java.util.Collection;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class k extends j {
    public static final Collection c(Object[] objArr) {
        kotlin.jvm.internal.l.e(objArr, "<this>");
        return new d(objArr, false);
    }

    public static final int d(List list, Comparable comparable, int i, int i2) {
        kotlin.jvm.internal.l.e(list, "<this>");
        l(list.size(), i, i2);
        int i3 = i2 - 1;
        while (i <= i3) {
            int i4 = (i + i3) >>> 1;
            int a = m8.a.a((Comparable) list.get(i4), comparable);
            if (a < 0) {
                i = i4 + 1;
            } else {
                if (a <= 0) {
                    return i4;
                }
                i3 = i4 - 1;
            }
        }
        return -(i + 1);
    }

    public static /* synthetic */ int e(List list, Comparable comparable, int i, int i2, int i3, Object obj) {
        if ((i3 & 2) != 0) {
            i = 0;
        }
        if ((i3 & 4) != 0) {
            i2 = list.size();
        }
        return d(list, comparable, i, i2);
    }

    public static List f() {
        return u.a;
    }

    public static int g(List list) {
        kotlin.jvm.internal.l.e(list, "<this>");
        return list.size() - 1;
    }

    public static List h(Object... elements) {
        kotlin.jvm.internal.l.e(elements, "elements");
        return elements.length > 0 ? g.b(elements) : f();
    }

    public static List i(Object... elements) {
        kotlin.jvm.internal.l.e(elements, "elements");
        return h.o(elements);
    }

    public static List j(Object... elements) {
        kotlin.jvm.internal.l.e(elements, "elements");
        return elements.length == 0 ? new ArrayList() : new ArrayList(new d(elements, true));
    }

    public static List k(List list) {
        kotlin.jvm.internal.l.e(list, "<this>");
        int size = list.size();
        return size != 0 ? size != 1 ? list : j.b(list.get(0)) : f();
    }

    public static final void l(int i, int i2, int i3) {
        if (i2 > i3) {
            throw new IllegalArgumentException("fromIndex (" + i2 + ") is greater than toIndex (" + i3 + ").");
        }
        if (i2 < 0) {
            throw new IndexOutOfBoundsException("fromIndex (" + i2 + ") is less than zero.");
        }
        if (i3 <= i) {
            return;
        }
        throw new IndexOutOfBoundsException("toIndex (" + i3 + ") is greater than size (" + i + ").");
    }

    public static void m() {
        throw new ArithmeticException("Count overflow has happened.");
    }

    public static void n() {
        throw new ArithmeticException("Index overflow has happened.");
    }
}
