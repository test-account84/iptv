package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.y;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class g0 {
    public static final Class a = A();
    public static final l0 b = B(false);
    public static final l0 c = B(true);
    public static final l0 d = new n0();

    public static Class A() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.GeneratedMessageV3");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static l0 B(boolean z) {
        try {
            Class C = C();
            if (C == null) {
                return null;
            }
            return (l0) C.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused) {
            return null;
        }
    }

    public static Class C() {
        try {
            return Class.forName("androidx.datastore.preferences.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            return null;
        }
    }

    public static void D(p pVar, Object obj, Object obj2) {
        s c2 = pVar.c(obj2);
        if (c2.j()) {
            return;
        }
        pVar.d(obj).p(c2);
    }

    public static void E(J j, Object obj, Object obj2, long j2) {
        p0.O(obj, j2, j.a(p0.A(obj, j2), p0.A(obj2, j2)));
    }

    public static void F(l0 l0Var, Object obj, Object obj2) {
        l0Var.p(obj, l0Var.k(l0Var.g(obj), l0Var.g(obj2)));
    }

    public static l0 G() {
        return b;
    }

    public static l0 H() {
        return c;
    }

    public static void I(Class cls) {
        Class cls2;
        if (!w.class.isAssignableFrom(cls) && (cls2 = a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static boolean J(Object obj, Object obj2) {
        return obj == obj2 || (obj != null && obj.equals(obj2));
    }

    public static Object K(int i, int i2, Object obj, l0 l0Var) {
        if (obj == null) {
            obj = l0Var.n();
        }
        l0Var.e(obj, i, i2);
        return obj;
    }

    public static l0 L() {
        return d;
    }

    public static void M(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.G(i, list, z);
    }

    public static void N(int i, List list, s0 s0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.O(i, list);
    }

    public static void O(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.M(i, list, z);
    }

    public static void P(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.q(i, list, z);
    }

    public static void Q(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.l(i, list, z);
    }

    public static void R(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.E(i, list, z);
    }

    public static void S(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.a(i, list, z);
    }

    public static void T(int i, List list, s0 s0Var, e0 e0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.e(i, list, e0Var);
    }

    public static void U(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.h(i, list, z);
    }

    public static void V(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.L(i, list, z);
    }

    public static void W(int i, List list, s0 s0Var, e0 e0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.z(i, list, e0Var);
    }

    public static void X(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.F(i, list, z);
    }

    public static void Y(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.v(i, list, z);
    }

    public static void Z(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.J(i, list, z);
    }

    public static int a(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? j.P(i) + j.y(size) : size * j.c(i, true);
    }

    public static void a0(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.o(i, list, z);
    }

    public static int b(List list) {
        return list.size();
    }

    public static void b0(int i, List list, s0 s0Var) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.d(i, list);
    }

    public static int c(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int P = size * j.P(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            P += j.g((g) list.get(i2));
        }
        return P;
    }

    public static void c0(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.n(i, list, z);
    }

    public static int d(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int e = e(list);
        int P = j.P(i);
        return z ? P + j.y(e) : e + (size * P);
    }

    public static void d0(int i, List list, s0 s0Var, boolean z) {
        if (list == null || list.isEmpty()) {
            return;
        }
        s0Var.w(i, list, z);
    }

    public static int e(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof x) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += j.k(((Integer) list.get(i2)).intValue());
        }
        return i;
    }

    public static int f(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? j.P(i) + j.y(size * 4) : size * j.l(i, 0);
    }

    public static int g(List list) {
        return list.size() * 4;
    }

    public static int h(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return z ? j.P(i) + j.y(size * 8) : size * j.n(i, 0L);
    }

    public static int i(List list) {
        return list.size() * 8;
    }

    public static int j(int i, List list, e0 e0Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += j.r(i, (O) list.get(i3), e0Var);
        }
        return i2;
    }

    public static int k(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int l = l(list);
        int P = j.P(i);
        return z ? P + j.y(l) : l + (size * P);
    }

    public static int l(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof x) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += j.v(((Integer) list.get(i2)).intValue());
        }
        return i;
    }

    public static int m(int i, List list, boolean z) {
        if (list.size() == 0) {
            return 0;
        }
        int n = n(list);
        return z ? j.P(i) + j.y(n) : n + (list.size() * j.P(i));
    }

    public static int n(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof F) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += j.x(((Long) list.get(i2)).longValue());
        }
        return i;
    }

    public static int o(int i, Object obj, e0 e0Var) {
        return j.z(i, (O) obj, e0Var);
    }

    public static int p(int i, List list, e0 e0Var) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int P = j.P(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            P += j.B((O) list.get(i2), e0Var);
        }
        return P;
    }

    public static int q(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int r = r(list);
        int P = j.P(i);
        return z ? P + j.y(r) : r + (size * P);
    }

    public static int r(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof x) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += j.K(((Integer) list.get(i2)).intValue());
        }
        return i;
    }

    public static int s(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int t = t(list);
        int P = j.P(i);
        return z ? P + j.y(t) : t + (size * P);
    }

    public static int t(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof F) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += j.M(((Long) list.get(i2)).longValue());
        }
        return i;
    }

    public static int u(int i, List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int P = j.P(i) * size;
        if (list instanceof D) {
            D d2 = (D) list;
            while (i2 < size) {
                Object G = d2.G(i2);
                P += G instanceof g ? j.g((g) G) : j.O((String) G);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                P += obj instanceof g ? j.g((g) obj) : j.O((String) obj);
                i2++;
            }
        }
        return P;
    }

    public static int v(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int w = w(list);
        int P = j.P(i);
        return z ? P + j.y(w) : w + (size * P);
    }

    public static int w(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof x) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += j.R(((Integer) list.get(i2)).intValue());
        }
        return i;
    }

    public static int x(int i, List list, boolean z) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int y = y(list);
        int P = j.P(i);
        return z ? P + j.y(y) : y + (size * P);
    }

    public static int y(List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        if (list instanceof F) {
            if (size <= 0) {
                return 0;
            }
            throw null;
        }
        int i = 0;
        for (int i2 = 0; i2 < size; i2++) {
            i += j.T(((Long) list.get(i2)).longValue());
        }
        return i;
    }

    public static Object z(int i, List list, y.a aVar, Object obj, l0 l0Var) {
        if (aVar == null) {
            return obj;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int intValue = num.intValue();
                if (aVar.a(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj = K(i, intValue, obj, l0Var);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!aVar.a(intValue2)) {
                    obj = K(i, intValue2, obj, l0Var);
                    it.remove();
                }
            }
        }
        return obj;
    }
}
