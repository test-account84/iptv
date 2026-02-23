package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Iterator;
import java.util.List;
import java.util.RandomAccess;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class bsk {
    private static final Class a;
    private static final bto b;
    private static final bto c;
    private static final bto d;

    static {
        Class cls;
        try {
            cls = Class.forName("com.google.protobuf.GeneratedMessage");
        } catch (Throwable unused) {
            cls = null;
        }
        a = cls;
        b = ab(false);
        c = ab(true);
        d = new bto(null);
    }

    public static void A(int i, List list, btn btnVar, bsi bsiVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((bpl) btnVar).w(i, list.get(i2), bsiVar);
        }
    }

    public static void B(int i, List list, btn btnVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        btnVar.z(i, list, z);
    }

    public static void C(int i, List list, btn btnVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        btnVar.B(i, list, z);
    }

    public static void D(int i, List list, btn btnVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        btnVar.D(i, list, z);
    }

    public static void E(int i, List list, btn btnVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        btnVar.F(i, list, z);
    }

    public static void F(int i, List list, btn btnVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        btnVar.I(i, list);
    }

    public static void G(int i, List list, btn btnVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        btnVar.K(i, list, z);
    }

    public static void H(int i, List list, btn btnVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        btnVar.M(i, list, z);
    }

    public static boolean I(Object obj, Object obj2) {
        if (obj != obj2) {
            return obj != null && obj.equals(obj2);
        }
        return true;
    }

    public static int J(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * bpk.aC(i);
    }

    public static int K(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return c(list) + (size * bpk.Q(i));
    }

    public static int L(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * bpk.aE(i);
    }

    public static int M(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return size * bpk.aF(i);
    }

    public static int N(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return g(list) + (size * bpk.Q(i));
    }

    public static int O(int i, List list) {
        if (list.size() == 0) {
            return 0;
        }
        return h(list) + (list.size() * bpk.Q(i));
    }

    public static int P(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return k(list) + (size * bpk.Q(i));
    }

    public static int Q(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return l(list) + (size * bpk.Q(i));
    }

    public static int R(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return n(list) + (size * bpk.Q(i));
    }

    public static int S(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        return o(list) + (size * bpk.Q(i));
    }

    public static bto T() {
        return b;
    }

    public static bto U() {
        return c;
    }

    public static bto V() {
        return d;
    }

    public static Object W(Object obj, int i, List list, bqr bqrVar, Object obj2, bto btoVar) {
        if (bqrVar == null) {
            return obj2;
        }
        if (list instanceof RandomAccess) {
            int size = list.size();
            int i2 = 0;
            for (int i3 = 0; i3 < size; i3++) {
                Integer num = (Integer) list.get(i3);
                int intValue = num.intValue();
                if (bqrVar.a(intValue)) {
                    if (i3 != i2) {
                        list.set(i2, num);
                    }
                    i2++;
                } else {
                    obj2 = X(obj, i, intValue, obj2, btoVar);
                }
            }
            if (i2 != size) {
                list.subList(i2, size).clear();
                return obj2;
            }
        } else {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                int intValue2 = ((Integer) it.next()).intValue();
                if (!bqrVar.a(intValue2)) {
                    obj2 = X(obj, i, intValue2, obj2, btoVar);
                    it.remove();
                }
            }
        }
        return obj2;
    }

    public static Object X(Object obj, int i, int i2, Object obj2, bto btoVar) {
        if (obj2 == null) {
            obj2 = btoVar.i(obj);
        }
        bto.r(obj2, i, i2);
        return obj2;
    }

    public static void Y(bto btoVar, Object obj, Object obj2) {
        btoVar.m(obj, bto.v(btoVar.j(obj), btoVar.j(obj2)));
    }

    public static void Z(bsr bsrVar, Object obj, Object obj2, long j) {
        btf.w(obj, j, bsr.g(btf.h(obj, j), btf.h(obj2, j)));
    }

    public static int a(List list) {
        return list.size();
    }

    public static void aa(bsr bsrVar, Object obj, Object obj2) {
        bqe o = bsr.o(obj2);
        if (o.l()) {
            return;
        }
        bsr.p(obj).j(o);
    }

    private static bto ab(boolean z) {
        Class cls;
        try {
            cls = Class.forName("com.google.protobuf.UnknownFieldSetSchema");
        } catch (Throwable unused) {
            cls = null;
        }
        if (cls == null) {
            return null;
        }
        try {
            return (bto) cls.getConstructor(new Class[]{Boolean.TYPE}).newInstance(new Object[]{Boolean.valueOf(z)});
        } catch (Throwable unused2) {
            return null;
        }
    }

    public static int b(int i, List list) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int Q = size * bpk.Q(i);
        for (int i2 = 0; i2 < list.size(); i2++) {
            Q += bpk.y((bpb) list.get(i2));
        }
        return Q;
    }

    public static int c(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bqo) {
            bqo bqoVar = (bqo) list;
            i = 0;
            while (i2 < size) {
                i += bpk.D(bqoVar.e(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bpk.D(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int d(List list) {
        return list.size() * 4;
    }

    public static int e(List list) {
        return list.size() * 8;
    }

    public static int f(int i, List list, bsi bsiVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int i2 = 0;
        for (int i3 = 0; i3 < size; i3++) {
            i2 += bpk.A(i, (brs) list.get(i3), bsiVar);
        }
        return i2;
    }

    public static int g(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bqo) {
            bqo bqoVar = (bqo) list;
            i = 0;
            while (i2 < size) {
                i += bpk.D(bqoVar.e(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bpk.D(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int h(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bri) {
            bri briVar = (bri) list;
            i = 0;
            while (i2 < size) {
                i += bpk.U(briVar.e(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bpk.U(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int i(int i, Object obj, bsi bsiVar) {
        return obj instanceof brc ? bpk.F(i, (brc) obj) : bpk.Q(i) + bpk.J((brs) obj, bsiVar);
    }

    public static int j(int i, List list, bsi bsiVar) {
        int size = list.size();
        if (size == 0) {
            return 0;
        }
        int Q = bpk.Q(i) * size;
        for (int i2 = 0; i2 < size; i2++) {
            Object obj = list.get(i2);
            Q += obj instanceof brc ? bpk.G((brc) obj) : bpk.J((brs) obj, bsiVar);
        }
        return Q;
    }

    public static int k(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bqo) {
            bqo bqoVar = (bqo) list;
            i = 0;
            while (i2 < size) {
                i += bpk.L(bqoVar.e(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bpk.L(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int l(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bri) {
            bri briVar = (bri) list;
            i = 0;
            while (i2 < size) {
                i += bpk.N(briVar.e(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bpk.N(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static int m(int i, List list) {
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        int Q = bpk.Q(i) * size;
        if (list instanceof bre) {
            bre breVar = (bre) list;
            while (i2 < size) {
                Object f = breVar.f(i2);
                Q += f instanceof bpb ? bpk.y((bpb) f) : bpk.P((String) f);
                i2++;
            }
        } else {
            while (i2 < size) {
                Object obj = list.get(i2);
                Q += obj instanceof bpb ? bpk.y((bpb) obj) : bpk.P((String) obj);
                i2++;
            }
        }
        return Q;
    }

    public static int n(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bqo) {
            bqo bqoVar = (bqo) list;
            i = 0;
            while (i2 < size) {
                i += bpk.S(bqoVar.e(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bpk.S(((Integer) list.get(i2)).intValue());
                i2++;
            }
        }
        return i;
    }

    public static int o(List list) {
        int i;
        int size = list.size();
        int i2 = 0;
        if (size == 0) {
            return 0;
        }
        if (list instanceof bri) {
            bri briVar = (bri) list;
            i = 0;
            while (i2 < size) {
                i += bpk.U(briVar.e(i2));
                i2++;
            }
        } else {
            i = 0;
            while (i2 < size) {
                i += bpk.U(((Long) list.get(i2)).longValue());
                i2++;
            }
        }
        return i;
    }

    public static void p(Class cls) {
        Class cls2;
        if (!bqn.class.isAssignableFrom(cls) && (cls2 = a) != null && !cls2.isAssignableFrom(cls)) {
            throw new IllegalArgumentException("Message classes must extend GeneratedMessage or GeneratedMessageLite");
        }
    }

    public static void q(int i, List list, btn btnVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        btnVar.c(i, list, z);
    }

    public static void r(int i, List list, btn btnVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        btnVar.e(i, list);
    }

    public static void s(int i, List list, btn btnVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        btnVar.g(i, list, z);
    }

    public static void t(int i, List list, btn btnVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        btnVar.j(i, list, z);
    }

    public static void u(int i, List list, btn btnVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        btnVar.l(i, list, z);
    }

    public static void v(int i, List list, btn btnVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        btnVar.n(i, list, z);
    }

    public static void w(int i, List list, btn btnVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        btnVar.p(i, list, z);
    }

    public static void x(int i, List list, btn btnVar, bsi bsiVar) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        for (int i2 = 0; i2 < list.size(); i2++) {
            ((bpl) btnVar).q(i, list.get(i2), bsiVar);
        }
    }

    public static void y(int i, List list, btn btnVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        btnVar.s(i, list, z);
    }

    public static void z(int i, List list, btn btnVar, boolean z) throws IOException {
        if (list == null || list.isEmpty()) {
            return;
        }
        btnVar.u(i, list, z);
    }
}
