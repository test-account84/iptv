package androidx.datastore.preferences.protobuf;

import androidx.datastore.preferences.protobuf.H;
import androidx.datastore.preferences.protobuf.r0;
import androidx.datastore.preferences.protobuf.s0;
import java.util.Arrays;
import java.util.Iterator;
import java.util.List;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class k implements s0 {
    public final j a;

    public static /* synthetic */ class a {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[r0.b.values().length];
            a = iArr;
            try {
                iArr[r0.b.BOOL.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[r0.b.FIXED32.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[r0.b.INT32.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[r0.b.SFIXED32.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[r0.b.SINT32.ordinal()] = 5;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[r0.b.UINT32.ordinal()] = 6;
            } catch (NoSuchFieldError unused6) {
            }
            try {
                a[r0.b.FIXED64.ordinal()] = 7;
            } catch (NoSuchFieldError unused7) {
            }
            try {
                a[r0.b.INT64.ordinal()] = 8;
            } catch (NoSuchFieldError unused8) {
            }
            try {
                a[r0.b.SFIXED64.ordinal()] = 9;
            } catch (NoSuchFieldError unused9) {
            }
            try {
                a[r0.b.SINT64.ordinal()] = 10;
            } catch (NoSuchFieldError unused10) {
            }
            try {
                a[r0.b.UINT64.ordinal()] = 11;
            } catch (NoSuchFieldError unused11) {
            }
            try {
                a[r0.b.STRING.ordinal()] = 12;
            } catch (NoSuchFieldError unused12) {
            }
        }
    }

    public k(j jVar) {
        j jVar2 = (j) y.b(jVar, "output");
        this.a = jVar2;
        jVar2.a = this;
    }

    public static k P(j jVar) {
        k kVar = jVar.a;
        return kVar != null ? kVar : new k(jVar);
    }

    public void A(int i, long j) {
        this.a.x0(i, j);
    }

    public void B(int i, boolean z) {
        this.a.b0(i, z);
    }

    public void C(int i, int i2) {
        this.a.D0(i, i2);
    }

    public void D(int i) {
        this.a.N0(i, 3);
    }

    public void E(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.n0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += j.o(((Long) list.get(i4)).longValue());
        }
        this.a.P0(i3);
        while (i2 < list.size()) {
            this.a.o0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public void F(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.D0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += j.G(((Integer) list.get(i4)).intValue());
        }
        this.a.P0(i3);
        while (i2 < list.size()) {
            this.a.E0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public void G(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.b0(i, ((Boolean) list.get(i2)).booleanValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += j.d(((Boolean) list.get(i4)).booleanValue());
        }
        this.a.P0(i3);
        while (i2 < list.size()) {
            this.a.c0(((Boolean) list.get(i2)).booleanValue());
            i2++;
        }
    }

    public void H(int i, float f) {
        this.a.p0(i, f);
    }

    public void I(int i) {
        this.a.N0(i, 4);
    }

    public void J(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.H0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += j.K(((Integer) list.get(i4)).intValue());
        }
        this.a.P0(i3);
        while (i2 < list.size()) {
            this.a.I0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public void K(int i, int i2) {
        this.a.j0(i, i2);
    }

    public void L(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.x0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += j.x(((Long) list.get(i4)).longValue());
        }
        this.a.P0(i3);
        while (i2 < list.size()) {
            this.a.y0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public void M(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.h0(i, ((Double) list.get(i2)).doubleValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += j.i(((Double) list.get(i4)).doubleValue());
        }
        this.a.P0(i3);
        while (i2 < list.size()) {
            this.a.i0(((Double) list.get(i2)).doubleValue());
            i2++;
        }
    }

    public void N(int i, int i2) {
        this.a.H0(i, i2);
    }

    public void O(int i, List list) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            this.a.f0(i, (g) list.get(i2));
        }
    }

    public final void Q(int i, boolean z, Object obj, H.a aVar) {
        this.a.N0(i, 2);
        this.a.P0(H.b(aVar, Boolean.valueOf(z), obj));
        H.e(this.a, aVar, Boolean.valueOf(z), obj);
    }

    public final void R(int i, H.a aVar, Map map) {
        int size = map.size();
        int[] iArr = new int[size];
        Iterator it = map.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            iArr[i2] = ((Integer) it.next()).intValue();
            i2++;
        }
        Arrays.sort(iArr);
        for (int i3 = 0; i3 < size; i3++) {
            int i4 = iArr[i3];
            Object obj = map.get(Integer.valueOf(i4));
            this.a.N0(i, 2);
            this.a.P0(H.b(aVar, Integer.valueOf(i4), obj));
            H.e(this.a, aVar, Integer.valueOf(i4), obj);
        }
    }

    public final void S(int i, H.a aVar, Map map) {
        int size = map.size();
        long[] jArr = new long[size];
        Iterator it = map.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            jArr[i2] = ((Long) it.next()).longValue();
            i2++;
        }
        Arrays.sort(jArr);
        for (int i3 = 0; i3 < size; i3++) {
            long j = jArr[i3];
            Object obj = map.get(Long.valueOf(j));
            this.a.N0(i, 2);
            this.a.P0(H.b(aVar, Long.valueOf(j), obj));
            H.e(this.a, aVar, Long.valueOf(j), obj);
        }
    }

    public final void T(int i, H.a aVar, Map map) {
        switch (a.a[aVar.a.ordinal()]) {
            case 1:
                Object obj = map.get(Boolean.FALSE);
                if (obj != null) {
                    Q(i, false, obj, aVar);
                }
                Object obj2 = map.get(Boolean.TRUE);
                if (obj2 != null) {
                    Q(i, true, obj2, aVar);
                    return;
                }
                return;
            case 2:
            case 3:
            case 4:
            case 5:
            case 6:
                R(i, aVar, map);
                return;
            case 7:
            case 8:
            case 9:
            case 10:
            case 11:
                S(i, aVar, map);
                return;
            case 12:
                U(i, aVar, map);
                return;
            default:
                throw new IllegalArgumentException("does not support key type: " + aVar.a);
        }
    }

    public final void U(int i, H.a aVar, Map map) {
        int size = map.size();
        String[] strArr = new String[size];
        Iterator it = map.keySet().iterator();
        int i2 = 0;
        while (it.hasNext()) {
            strArr[i2] = (String) it.next();
            i2++;
        }
        Arrays.sort(strArr);
        for (int i3 = 0; i3 < size; i3++) {
            String str = strArr[i3];
            Object obj = map.get(str);
            this.a.N0(i, 2);
            this.a.P0(H.b(aVar, str, obj));
            H.e(this.a, aVar, str, obj);
        }
    }

    public final void V(int i, Object obj) {
        if (obj instanceof String) {
            this.a.L0(i, (String) obj);
        } else {
            this.a.f0(i, (g) obj);
        }
    }

    public void a(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.p0(i, ((Float) list.get(i2)).floatValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += j.q(((Float) list.get(i4)).floatValue());
        }
        this.a.P0(i3);
        while (i2 < list.size()) {
            this.a.q0(((Float) list.get(i2)).floatValue());
            i2++;
        }
    }

    public final void b(int i, Object obj) {
        if (obj instanceof g) {
            this.a.C0(i, (g) obj);
        } else {
            this.a.B0(i, (O) obj);
        }
    }

    public void c(int i, int i2) {
        this.a.l0(i, i2);
    }

    public void d(int i, List list) {
        int i2 = 0;
        if (!(list instanceof D)) {
            while (i2 < list.size()) {
                this.a.L0(i, (String) list.get(i2));
                i2++;
            }
        } else {
            D d = (D) list;
            while (i2 < list.size()) {
                V(i, d.G(i2));
                i2++;
            }
        }
    }

    public void e(int i, List list, e0 e0Var) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            s(i, list.get(i2), e0Var);
        }
    }

    public void f(int i, String str) {
        this.a.L0(i, str);
    }

    public void g(int i, long j) {
        this.a.Q0(i, j);
    }

    public void h(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.v0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += j.v(((Integer) list.get(i4)).intValue());
        }
        this.a.P0(i3);
        while (i2 < list.size()) {
            this.a.w0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public void i(int i, int i2) {
        this.a.v0(i, i2);
    }

    public void j(int i, g gVar) {
        this.a.f0(i, gVar);
    }

    public void k(int i, long j) {
        this.a.F0(i, j);
    }

    public void l(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.l0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += j.m(((Integer) list.get(i4)).intValue());
        }
        this.a.P0(i3);
        while (i2 < list.size()) {
            this.a.m0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public void m(int i, Object obj, e0 e0Var) {
        this.a.z0(i, (O) obj, e0Var);
    }

    public void n(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.O0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += j.R(((Integer) list.get(i4)).intValue());
        }
        this.a.P0(i3);
        while (i2 < list.size()) {
            this.a.P0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public void o(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.J0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += j.M(((Long) list.get(i4)).longValue());
        }
        this.a.P0(i3);
        while (i2 < list.size()) {
            this.a.K0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public void p(int i, long j) {
        this.a.J0(i, j);
    }

    public void q(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.j0(i, ((Integer) list.get(i2)).intValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += j.k(((Integer) list.get(i4)).intValue());
        }
        this.a.P0(i3);
        while (i2 < list.size()) {
            this.a.k0(((Integer) list.get(i2)).intValue());
            i2++;
        }
    }

    public void r(int i, H.a aVar, Map map) {
        if (this.a.Y()) {
            T(i, aVar, map);
            return;
        }
        for (Map.Entry entry : map.entrySet()) {
            this.a.N0(i, 2);
            this.a.P0(H.b(aVar, entry.getKey(), entry.getValue()));
            H.e(this.a, aVar, entry.getKey(), entry.getValue());
        }
    }

    public void s(int i, Object obj, e0 e0Var) {
        this.a.s0(i, (O) obj, e0Var);
    }

    public void t(int i, int i2) {
        this.a.O0(i, i2);
    }

    public void u(int i, double d) {
        this.a.h0(i, d);
    }

    public void v(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.F0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += j.I(((Long) list.get(i4)).longValue());
        }
        this.a.P0(i3);
        while (i2 < list.size()) {
            this.a.G0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public void w(int i, List list, boolean z) {
        int i2 = 0;
        if (!z) {
            while (i2 < list.size()) {
                this.a.Q0(i, ((Long) list.get(i2)).longValue());
                i2++;
            }
            return;
        }
        this.a.N0(i, 2);
        int i3 = 0;
        for (int i4 = 0; i4 < list.size(); i4++) {
            i3 += j.T(((Long) list.get(i4)).longValue());
        }
        this.a.P0(i3);
        while (i2 < list.size()) {
            this.a.R0(((Long) list.get(i2)).longValue());
            i2++;
        }
    }

    public void x(int i, long j) {
        this.a.n0(i, j);
    }

    public s0.a y() {
        return s0.a.ASCENDING;
    }

    public void z(int i, List list, e0 e0Var) {
        for (int i2 = 0; i2 < list.size(); i2++) {
            m(i, list.get(i2), e0Var);
        }
    }
}
