package N6;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collection;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import x6.k;
import x6.o;
import x6.q;
import x6.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class e extends a {
    public static final int[] i = {1, 10, 34, 70, 126};
    public static final int[] j = {4, 20, 48, 81};
    public static final int[] k = {0, 161, 961, 2015, 2715};
    public static final int[] l = {0, 336, 1036, 1516};
    public static final int[] m = {8, 6, 4, 3, 1};
    public static final int[] n = {2, 4, 6, 8};
    public static final int[][] o = {new int[]{3, 8, 2, 1}, new int[]{3, 5, 5, 1}, new int[]{3, 3, 7, 1}, new int[]{3, 1, 9, 1}, new int[]{2, 7, 4, 1}, new int[]{2, 5, 6, 1}, new int[]{2, 3, 8, 1}, new int[]{1, 5, 7, 1}, new int[]{1, 3, 9, 1}};
    public final List g = new ArrayList();
    public final List h = new ArrayList();

    public static void r(Collection collection, d dVar) {
        if (dVar == null) {
            return;
        }
        Iterator it = collection.iterator();
        while (it.hasNext()) {
            d dVar2 = (d) it.next();
            if (dVar2.b() == dVar.b()) {
                dVar2.e();
                return;
            }
        }
        collection.add(dVar);
    }

    public static boolean t(d dVar, d dVar2) {
        int a = (dVar.a() + (dVar2.a() * 16)) % 79;
        int c = (dVar.d().c() * 9) + dVar2.d().c();
        if (c > 72) {
            c--;
        }
        if (c > 8) {
            c--;
        }
        return a == c;
    }

    public static o u(d dVar, d dVar2) {
        String valueOf = String.valueOf((dVar.b() * 4537077) + dVar2.b());
        StringBuilder sb = new StringBuilder(14);
        for (int length = 13 - valueOf.length(); length > 0; length--) {
            sb.append('0');
        }
        sb.append(valueOf);
        int i2 = 0;
        for (int i3 = 0; i3 < 13; i3++) {
            int charAt = sb.charAt(i3) - '0';
            if ((i3 & 1) == 0) {
                charAt *= 3;
            }
            i2 += charAt;
        }
        int i4 = 10 - (i2 % 10);
        if (i4 == 10) {
            i4 = 0;
        }
        sb.append(i4);
        q[] a = dVar.d().a();
        q[] a2 = dVar2.d().a();
        return new o(sb.toString(), null, new q[]{a[0], a[1], a2[0], a2[1]}, x6.a.RSS_14);
    }

    public o c(int i2, D6.a aVar, Map map) {
        r(this.g, w(aVar, false, i2, map));
        aVar.p();
        r(this.h, w(aVar, true, i2, map));
        aVar.p();
        for (d dVar : this.g) {
            if (dVar.c() > 1) {
                for (d dVar2 : this.h) {
                    if (dVar2.c() > 1 && t(dVar, dVar2)) {
                        return u(dVar, dVar2);
                    }
                }
            }
        }
        throw k.a();
    }

    public void reset() {
        this.g.clear();
        this.h.clear();
    }

    /* JADX WARN: Removed duplicated region for block: B:68:0x002a A[PHI: r6 r7
      0x002a: PHI (r6v7 boolean) = (r6v3 boolean), (r6v13 boolean) binds: [B:80:0x0043, B:67:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x002a: PHI (r7v5 boolean) = (r7v1 boolean), (r7v11 boolean) binds: [B:80:0x0043, B:67:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /* JADX WARN: Removed duplicated region for block: B:70:0x002d A[PHI: r6 r7
      0x002d: PHI (r6v5 boolean) = (r6v3 boolean), (r6v13 boolean) binds: [B:80:0x0043, B:67:0x0028] A[DONT_GENERATE, DONT_INLINE]
      0x002d: PHI (r7v3 boolean) = (r7v1 boolean), (r7v11 boolean) binds: [B:80:0x0043, B:67:0x0028] A[DONT_GENERATE, DONT_INLINE]] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void s(boolean r10, int r11) {
        /*
            Method dump skipped, instructions count: 231
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: N6.e.s(boolean, int):void");
    }

    public final b v(D6.a aVar, c cVar, boolean z) {
        int[] i2 = i();
        Arrays.fill(i2, 0);
        int[] b = cVar.b();
        if (z) {
            M6.k.g(aVar, b[0], i2);
        } else {
            M6.k.f(aVar, b[1], i2);
            int i3 = 0;
            for (int length = i2.length - 1; i3 < length; length--) {
                int i4 = i2[i3];
                i2[i3] = i2[length];
                i2[length] = i4;
                i3++;
            }
        }
        int i5 = z ? 16 : 15;
        float d = E6.a.d(i2) / i5;
        int[] m2 = m();
        int[] k2 = k();
        float[] n2 = n();
        float[] l2 = l();
        for (int i6 = 0; i6 < i2.length; i6++) {
            float f = i2[i6] / d;
            int i7 = (int) (0.5f + f);
            if (i7 <= 0) {
                i7 = 1;
            } else if (i7 > 8) {
                i7 = 8;
            }
            int i8 = i6 / 2;
            if ((i6 & 1) == 0) {
                m2[i8] = i7;
                n2[i8] = f - i7;
            } else {
                k2[i8] = i7;
                l2[i8] = f - i7;
            }
        }
        s(z, i5);
        int i9 = 0;
        int i10 = 0;
        for (int length2 = m2.length - 1; length2 >= 0; length2--) {
            int i11 = m2[length2];
            i9 = (i9 * 9) + i11;
            i10 += i11;
        }
        int i12 = 0;
        int i13 = 0;
        for (int length3 = k2.length - 1; length3 >= 0; length3--) {
            int i14 = k2[length3];
            i12 = (i12 * 9) + i14;
            i13 += i14;
        }
        int i15 = i9 + (i12 * 3);
        if (!z) {
            if ((i13 & 1) != 0 || i13 > 10 || i13 < 4) {
                throw k.a();
            }
            int i16 = (10 - i13) / 2;
            int i17 = n[i16];
            return new b((f.b(k2, 9 - i17, false) * j[i16]) + f.b(m2, i17, true) + l[i16], i15);
        }
        if ((i10 & 1) != 0 || i10 > 12 || i10 < 4) {
            throw k.a();
        }
        int i18 = (12 - i10) / 2;
        int i19 = m[i18];
        return new b((f.b(m2, i19, false) * i[i18]) + f.b(k2, 9 - i19, true) + k[i18], i15);
    }

    public final d w(D6.a aVar, boolean z, int i2, Map map) {
        try {
            c y = y(aVar, i2, z, x(aVar, z));
            r rVar = map == null ? null : (r) map.get(x6.e.NEED_RESULT_POINT_CALLBACK);
            if (rVar != null) {
                int[] b = y.b();
                float f = ((b[0] + b[1]) - 1) / 2.0f;
                if (z) {
                    f = (aVar.l() - 1) - f;
                }
                rVar.a(new q(f, i2));
            }
            b v = v(aVar, y, true);
            b v2 = v(aVar, y, false);
            return new d((v.b() * 1597) + v2.b(), v.a() + (v2.a() * 4), y);
        } catch (k unused) {
            return null;
        }
    }

    public final int[] x(D6.a aVar, boolean z) {
        int[] j2 = j();
        j2[0] = 0;
        j2[1] = 0;
        j2[2] = 0;
        j2[3] = 0;
        int l2 = aVar.l();
        int i2 = 0;
        boolean z2 = false;
        while (i2 < l2) {
            z2 = !aVar.h(i2);
            if (z == z2) {
                break;
            }
            i2++;
        }
        int i3 = i2;
        int i4 = 0;
        while (i2 < l2) {
            if (aVar.h(i2) != z2) {
                j2[i4] = j2[i4] + 1;
            } else {
                if (i4 != 3) {
                    i4++;
                } else {
                    if (a.p(j2)) {
                        return new int[]{i3, i2};
                    }
                    i3 += j2[0] + j2[1];
                    j2[0] = j2[2];
                    j2[1] = j2[3];
                    j2[2] = 0;
                    j2[3] = 0;
                    i4--;
                }
                j2[i4] = 1;
                z2 = !z2;
            }
            i2++;
        }
        throw k.a();
    }

    public final c y(D6.a aVar, int i2, boolean z, int[] iArr) {
        int i3;
        int i4;
        boolean h = aVar.h(iArr[0]);
        int i5 = iArr[0] - 1;
        while (i5 >= 0 && h != aVar.h(i5)) {
            i5--;
        }
        int i6 = i5 + 1;
        int i7 = iArr[0] - i6;
        int[] j2 = j();
        System.arraycopy(j2, 0, j2, 1, j2.length - 1);
        j2[0] = i7;
        int q = a.q(j2, o);
        int i8 = iArr[1];
        if (z) {
            int l2 = (aVar.l() - 1) - i6;
            i3 = (aVar.l() - 1) - i8;
            i4 = l2;
        } else {
            i3 = i8;
            i4 = i6;
        }
        return new c(q, new int[]{i6, iArr[1]}, i4, i3, i2);
    }
}
