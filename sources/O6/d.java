package O6;

import N6.f;
import P6.j;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import x6.k;
import x6.o;
import x6.q;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class d extends N6.a {
    public static final int[] k = {7, 5, 4, 3, 1};
    public static final int[] l = {4, 20, 52, 104, 204};
    public static final int[] m = {0, 348, 1388, 2948, 3988};
    public static final int[][] n = {new int[]{1, 8, 4, 1}, new int[]{3, 6, 4, 1}, new int[]{3, 4, 6, 1}, new int[]{3, 2, 8, 1}, new int[]{2, 6, 5, 1}, new int[]{2, 2, 9, 1}};
    public static final int[][] o = {new int[]{1, 3, 9, 27, 81, 32, 96, 77}, new int[]{20, 60, 180, 118, 143, 7, 21, 63}, new int[]{189, 145, 13, 39, 117, 140, 209, 205}, new int[]{193, 157, 49, 147, 19, 57, 171, 91}, new int[]{62, 186, 136, 197, 169, 85, 44, 132}, new int[]{185, 133, 188, 142, 4, 12, 36, 108}, new int[]{113, 128, 173, 97, 80, 29, 87, 50}, new int[]{150, 28, 84, 41, 123, 158, 52, 156}, new int[]{46, 138, 203, 187, 139, 206, 196, 166}, new int[]{76, 17, 51, 153, 37, 111, 122, 155}, new int[]{43, 129, 176, 106, 107, 110, 119, 146}, new int[]{16, 48, 144, 10, 30, 90, 59, 177}, new int[]{109, 116, 137, 200, 178, 112, 125, 164}, new int[]{70, 210, 208, 202, 184, 130, 179, 115}, new int[]{134, 191, 151, 31, 93, 68, 204, 190}, new int[]{148, 22, 66, 198, 172, 94, 71, 2}, new int[]{6, 18, 54, 162, 64, 192, 154, 40}, new int[]{120, 149, 25, 75, 14, 42, 126, 167}, new int[]{79, 26, 78, 23, 69, 207, 199, 175}, new int[]{103, 98, 83, 38, 114, 131, 182, 124}, new int[]{161, 61, 183, 127, 170, 88, 53, 159}, new int[]{55, 165, 73, 8, 24, 72, 5, 15}, new int[]{45, 135, 194, 160, 58, 174, 100, 89}};
    public static final int[][] p = {new int[]{0, 0}, new int[]{0, 1, 1}, new int[]{0, 2, 1, 3}, new int[]{0, 4, 1, 3, 2}, new int[]{0, 4, 1, 3, 3, 5}, new int[]{0, 4, 1, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 2, 3, 3}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 4}, new int[]{0, 0, 1, 1, 2, 2, 3, 4, 5, 5}, new int[]{0, 0, 1, 1, 2, 3, 3, 4, 4, 5, 5}};
    public final List g = new ArrayList(11);
    public final List h = new ArrayList();
    public final int[] i = new int[2];
    public boolean j;

    public static boolean A(N6.c cVar, boolean z, boolean z2) {
        return (cVar.c() == 0 && z && z2) ? false : true;
    }

    public static boolean B(Iterable iterable, Iterable iterable2) {
        Iterator it = iterable2.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            Iterator it2 = iterable.iterator();
            while (it2.hasNext()) {
                b bVar = (b) it2.next();
                Iterator it3 = cVar.a().iterator();
                while (it3.hasNext()) {
                    if (bVar.equals((b) it3.next())) {
                        break;
                    }
                }
            }
            return true;
        }
        return false;
    }

    public static boolean C(List list) {
        for (int[] iArr : p) {
            if (list.size() <= iArr.length) {
                for (int i = 0; i < list.size(); i++) {
                    if (((b) list.get(i)).a().c() != iArr[i]) {
                        break;
                    }
                }
                return true;
            }
        }
        return false;
    }

    public static void E(Collection collection, Collection collection2) {
        Iterator it = collection2.iterator();
        while (it.hasNext()) {
            c cVar = (c) it.next();
            if (cVar.a().size() != collection.size()) {
                Iterator it2 = cVar.a().iterator();
                while (true) {
                    if (!it2.hasNext()) {
                        it.remove();
                        break;
                    } else if (!collection.contains((b) it2.next())) {
                        break;
                    }
                }
            }
        }
    }

    public static void G(int[] iArr) {
        int length = iArr.length;
        for (int i = 0; i < length / 2; i++) {
            int i2 = iArr[i];
            int i3 = (length - i) - 1;
            iArr[i] = iArr[i3];
            iArr[i3] = i2;
        }
    }

    public static o v(List list) {
        String d = j.a(a.a(list)).d();
        q[] a = ((b) list.get(0)).a().a();
        q[] a2 = ((b) list.get(list.size() - 1)).a().a();
        return new o(d, null, new q[]{a[0], a[1], a2[0], a2[1]}, x6.a.RSS_EXPANDED);
    }

    public static int z(D6.a aVar, int i) {
        return aVar.h(i) ? aVar.j(aVar.k(i)) : aVar.k(aVar.j(i));
    }

    public final N6.c D(D6.a aVar, int i, boolean z) {
        int i2;
        int i3;
        int i4;
        if (z) {
            int i5 = this.i[0] - 1;
            while (i5 >= 0 && !aVar.h(i5)) {
                i5--;
            }
            int i6 = i5 + 1;
            int[] iArr = this.i;
            i4 = iArr[0] - i6;
            i2 = iArr[1];
            i3 = i6;
        } else {
            int[] iArr2 = this.i;
            int i7 = iArr2[0];
            int k2 = aVar.k(iArr2[1] + 1);
            i2 = k2;
            i3 = i7;
            i4 = k2 - this.i[1];
        }
        int[] j = j();
        System.arraycopy(j, 0, j, 1, j.length - 1);
        j[0] = i4;
        try {
            return new N6.c(N6.a.q(j, n), new int[]{i3, i2}, i3, i2, i);
        } catch (k unused) {
            return null;
        }
    }

    public b F(D6.a aVar, List list, int i) {
        N6.c D;
        N6.b bVar;
        boolean z = list.size() % 2 == 0;
        if (this.j) {
            z = !z;
        }
        int i2 = -1;
        boolean z2 = true;
        do {
            y(aVar, list, i2);
            D = D(aVar, i, z);
            if (D == null) {
                i2 = z(aVar, this.i[0]);
            } else {
                z2 = false;
            }
        } while (z2);
        N6.b w = w(aVar, D, z, true);
        if (!list.isEmpty() && ((b) list.get(list.size() - 1)).d()) {
            throw k.a();
        }
        try {
            bVar = w(aVar, D, z, false);
        } catch (k unused) {
            bVar = null;
        }
        return new b(w, bVar, D);
    }

    public final void H(int i) {
        boolean z;
        int i2 = 0;
        boolean z2 = false;
        while (true) {
            if (i2 >= this.h.size()) {
                z = false;
                break;
            }
            c cVar = (c) this.h.get(i2);
            if (cVar.b() > i) {
                z = cVar.c(this.g);
                break;
            } else {
                z2 = cVar.c(this.g);
                i2++;
            }
        }
        if (z || z2 || B(this.g, this.h)) {
            return;
        }
        this.h.add(i2, new c(this.g, i, false));
        E(this.g, this.h);
    }

    public o c(int i, D6.a aVar, Map map) {
        this.g.clear();
        this.j = false;
        try {
            return v(x(i, aVar));
        } catch (k unused) {
            this.g.clear();
            this.j = true;
            return v(x(i, aVar));
        }
    }

    public final void r(int i) {
        boolean z;
        boolean z2;
        boolean z3;
        boolean z4;
        int d = E6.a.d(m());
        int d2 = E6.a.d(k());
        boolean z5 = true;
        if (d > 13) {
            z = false;
            z2 = true;
        } else {
            z = d < 4;
            z2 = false;
        }
        if (d2 > 13) {
            z3 = false;
            z4 = true;
        } else {
            z3 = d2 < 4;
            z4 = false;
        }
        int i2 = (d + d2) - i;
        boolean z6 = (d & 1) == 1;
        boolean z7 = (d2 & 1) == 0;
        if (i2 != -1) {
            if (i2 != 0) {
                if (i2 != 1) {
                    throw k.a();
                }
                if (z6) {
                    if (z7) {
                        throw k.a();
                    }
                    z5 = z;
                    z2 = true;
                } else {
                    if (!z7) {
                        throw k.a();
                    }
                    z5 = z;
                    z4 = true;
                }
            } else if (z6) {
                if (!z7) {
                    throw k.a();
                }
                if (d >= d2) {
                    z5 = z;
                    z3 = true;
                    z2 = true;
                }
                z4 = true;
            } else {
                if (z7) {
                    throw k.a();
                }
                z5 = z;
            }
        } else if (z6) {
            if (z7) {
                throw k.a();
            }
        } else {
            if (!z7) {
                throw k.a();
            }
            z5 = z;
            z3 = true;
        }
        if (z5) {
            if (z2) {
                throw k.a();
            }
            N6.a.o(m(), n());
        }
        if (z2) {
            N6.a.h(m(), n());
        }
        if (z3) {
            if (z4) {
                throw k.a();
            }
            N6.a.o(k(), n());
        }
        if (z4) {
            N6.a.h(k(), l());
        }
    }

    public void reset() {
        this.g.clear();
        this.h.clear();
    }

    public final boolean s() {
        b bVar = (b) this.g.get(0);
        N6.b b = bVar.b();
        N6.b c = bVar.c();
        if (c == null) {
            return false;
        }
        int a = c.a();
        int i = 2;
        for (int i2 = 1; i2 < this.g.size(); i2++) {
            b bVar2 = (b) this.g.get(i2);
            a += bVar2.b().a();
            int i3 = i + 1;
            N6.b c2 = bVar2.c();
            if (c2 != null) {
                a += c2.a();
                i += 2;
            } else {
                i = i3;
            }
        }
        return ((i + (-4)) * 211) + (a % 211) == b.b();
    }

    public final List t(List list, int i) {
        while (i < this.h.size()) {
            c cVar = (c) this.h.get(i);
            this.g.clear();
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.g.addAll(((c) it.next()).a());
            }
            this.g.addAll(cVar.a());
            if (C(this.g)) {
                if (s()) {
                    return this.g;
                }
                ArrayList arrayList = new ArrayList(list);
                arrayList.add(cVar);
                try {
                    return t(arrayList, i + 1);
                } catch (k unused) {
                    continue;
                }
            }
            i++;
        }
        throw k.a();
    }

    public final List u(boolean z) {
        List list = null;
        if (this.h.size() > 25) {
            this.h.clear();
            return null;
        }
        this.g.clear();
        if (z) {
            Collections.reverse(this.h);
        }
        try {
            list = t(new ArrayList(), 0);
        } catch (k unused) {
        }
        if (z) {
            Collections.reverse(this.h);
        }
        return list;
    }

    public N6.b w(D6.a aVar, N6.c cVar, boolean z, boolean z2) {
        int[] i = i();
        Arrays.fill(i, 0);
        int[] b = cVar.b();
        if (z2) {
            M6.k.g(aVar, b[0], i);
        } else {
            M6.k.f(aVar, b[1], i);
            int i2 = 0;
            for (int length = i.length - 1; i2 < length; length--) {
                int i3 = i[i2];
                i[i2] = i[length];
                i[length] = i3;
                i2++;
            }
        }
        float d = E6.a.d(i) / 17.0f;
        float f = (cVar.b()[1] - cVar.b()[0]) / 15.0f;
        if (Math.abs(d - f) / f > 0.3f) {
            throw k.a();
        }
        int[] m2 = m();
        int[] k2 = k();
        float[] n2 = n();
        float[] l2 = l();
        for (int i4 = 0; i4 < i.length; i4++) {
            float f2 = (i[i4] * 1.0f) / d;
            int i5 = (int) (0.5f + f2);
            if (i5 <= 0) {
                if (f2 < 0.3f) {
                    throw k.a();
                }
                i5 = 1;
            } else if (i5 > 8) {
                if (f2 > 8.7f) {
                    throw k.a();
                }
                i5 = 8;
            }
            int i6 = i4 / 2;
            if ((i4 & 1) == 0) {
                m2[i6] = i5;
                n2[i6] = f2 - i5;
            } else {
                k2[i6] = i5;
                l2[i6] = f2 - i5;
            }
        }
        r(17);
        int c = (((cVar.c() * 4) + (z ? 0 : 2)) + (!z2 ? 1 : 0)) - 1;
        int i7 = 0;
        int i8 = 0;
        for (int length2 = m2.length - 1; length2 >= 0; length2--) {
            if (A(cVar, z, z2)) {
                i7 += m2[length2] * o[c][length2 * 2];
            }
            i8 += m2[length2];
        }
        int i9 = 0;
        for (int length3 = k2.length - 1; length3 >= 0; length3--) {
            if (A(cVar, z, z2)) {
                i9 += k2[length3] * o[c][(length3 * 2) + 1];
            }
        }
        int i10 = i7 + i9;
        if ((i8 & 1) != 0 || i8 > 13 || i8 < 4) {
            throw k.a();
        }
        int i11 = (13 - i8) / 2;
        int i12 = k[i11];
        return new N6.b((f.b(m2, i12, true) * l[i11]) + f.b(k2, 9 - i12, false) + m[i11], i10);
    }

    public List x(int i, D6.a aVar) {
        boolean z = false;
        while (!z) {
            try {
                List list = this.g;
                list.add(F(aVar, list, i));
            } catch (k e) {
                if (this.g.isEmpty()) {
                    throw e;
                }
                z = true;
            }
        }
        if (s()) {
            return this.g;
        }
        boolean z2 = !this.h.isEmpty();
        H(i);
        if (z2) {
            List u = u(false);
            if (u != null) {
                return u;
            }
            List u2 = u(true);
            if (u2 != null) {
                return u2;
            }
        }
        throw k.a();
    }

    public final void y(D6.a aVar, List list, int i) {
        int[] j = j();
        j[0] = 0;
        j[1] = 0;
        j[2] = 0;
        j[3] = 0;
        int l2 = aVar.l();
        if (i < 0) {
            i = list.isEmpty() ? 0 : ((b) list.get(list.size() - 1)).a().b()[1];
        }
        boolean z = list.size() % 2 != 0;
        if (this.j) {
            z = !z;
        }
        boolean z2 = false;
        while (i < l2) {
            z2 = !aVar.h(i);
            if (!z2) {
                break;
            } else {
                i++;
            }
        }
        boolean z3 = z2;
        int i2 = 0;
        int i3 = i;
        while (i < l2) {
            if (aVar.h(i) != z3) {
                j[i2] = j[i2] + 1;
            } else {
                if (i2 == 3) {
                    if (z) {
                        G(j);
                    }
                    if (N6.a.p(j)) {
                        int[] iArr = this.i;
                        iArr[0] = i3;
                        iArr[1] = i;
                        return;
                    }
                    if (z) {
                        G(j);
                    }
                    i3 += j[0] + j[1];
                    j[0] = j[2];
                    j[1] = j[3];
                    j[2] = 0;
                    j[3] = 0;
                    i2--;
                } else {
                    i2++;
                }
                j[i2] = 1;
                z3 = !z3;
            }
            i++;
        }
        throw k.a();
    }
}
