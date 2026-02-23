package W6;

import java.io.Serializable;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Comparator;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import x6.q;
import x6.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class e {
    public static final b f = new b(null);
    public final D6.b a;
    public boolean c;
    public final r e;
    public final List b = new ArrayList();
    public final int[] d = new int[5];

    public static final class b implements Serializable, Comparator {
        public b() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public int compare(d dVar, d dVar2) {
            return Float.compare(dVar.i(), dVar2.i());
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public e(D6.b bVar, r rVar) {
        this.a = bVar;
        this.e = rVar;
    }

    public static float a(int[] iArr, int i) {
        return ((i - iArr[4]) - iArr[3]) - (iArr[2] / 2.0f);
    }

    public static void e(int[] iArr) {
        Arrays.fill(iArr, 0);
    }

    public static void f(int[] iArr) {
        iArr[0] = iArr[2];
        iArr[1] = iArr[3];
        iArr[2] = iArr[4];
        iArr[3] = 1;
        iArr[4] = 0;
    }

    public static boolean i(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f2 = i / 7.0f;
        float f3 = f2 / 2.0f;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    public static boolean j(int[] iArr) {
        int i = 0;
        for (int i2 = 0; i2 < 5; i2++) {
            int i3 = iArr[i2];
            if (i3 == 0) {
                return false;
            }
            i += i3;
        }
        if (i < 7) {
            return false;
        }
        float f2 = i / 7.0f;
        float f3 = f2 / 1.333f;
        return Math.abs(f2 - ((float) iArr[0])) < f3 && Math.abs(f2 - ((float) iArr[1])) < f3 && Math.abs((f2 * 3.0f) - ((float) iArr[2])) < 3.0f * f3 && Math.abs(f2 - ((float) iArr[3])) < f3 && Math.abs(f2 - ((float) iArr[4])) < f3;
    }

    public static double o(d dVar, d dVar2) {
        double c = dVar.c() - dVar2.c();
        double d = dVar.d() - dVar2.d();
        return (c * c) + (d * d);
    }

    public final boolean b(int i, int i2) {
        int i3;
        int i4;
        int i5;
        int[] k = k();
        int i6 = 0;
        while (i >= i6 && i2 >= i6 && this.a.f(i2 - i6, i - i6)) {
            k[2] = k[2] + 1;
            i6++;
        }
        if (k[2] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && !this.a.f(i2 - i6, i - i6)) {
            k[1] = k[1] + 1;
            i6++;
        }
        if (k[1] == 0) {
            return false;
        }
        while (i >= i6 && i2 >= i6 && this.a.f(i2 - i6, i - i6)) {
            k[0] = k[0] + 1;
            i6++;
        }
        if (k[0] == 0) {
            return false;
        }
        int i7 = this.a.i();
        int l = this.a.l();
        int i8 = 1;
        while (true) {
            int i9 = i + i8;
            if (i9 >= i7 || (i5 = i2 + i8) >= l || !this.a.f(i5, i9)) {
                break;
            }
            k[2] = k[2] + 1;
            i8++;
        }
        while (true) {
            int i10 = i + i8;
            if (i10 >= i7 || (i4 = i2 + i8) >= l || this.a.f(i4, i10)) {
                break;
            }
            k[3] = k[3] + 1;
            i8++;
        }
        if (k[3] == 0) {
            return false;
        }
        while (true) {
            int i11 = i + i8;
            if (i11 >= i7 || (i3 = i2 + i8) >= l || !this.a.f(i3, i11)) {
                break;
            }
            k[4] = k[4] + 1;
            i8++;
        }
        if (k[4] == 0) {
            return false;
        }
        return j(k);
    }

    public final float c(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        D6.b bVar = this.a;
        int l = bVar.l();
        int[] k = k();
        int i8 = i;
        while (i8 >= 0 && bVar.f(i8, i2)) {
            k[2] = k[2] + 1;
            i8--;
        }
        if (i8 < 0) {
            return Float.NaN;
        }
        while (i8 >= 0 && !bVar.f(i8, i2)) {
            int i9 = k[1];
            if (i9 > i3) {
                break;
            }
            k[1] = i9 + 1;
            i8--;
        }
        if (i8 >= 0 && k[1] <= i3) {
            while (i8 >= 0 && bVar.f(i8, i2) && (i7 = k[0]) <= i3) {
                k[0] = i7 + 1;
                i8--;
            }
            if (k[0] > i3) {
                return Float.NaN;
            }
            int i10 = i + 1;
            while (i10 < l && bVar.f(i10, i2)) {
                k[2] = k[2] + 1;
                i10++;
            }
            if (i10 == l) {
                return Float.NaN;
            }
            while (i10 < l && !bVar.f(i10, i2) && (i6 = k[3]) < i3) {
                k[3] = i6 + 1;
                i10++;
            }
            if (i10 != l && k[3] < i3) {
                while (i10 < l && bVar.f(i10, i2) && (i5 = k[4]) < i3) {
                    k[4] = i5 + 1;
                    i10++;
                }
                int i11 = k[4];
                if (i11 < i3 && Math.abs(((((k[0] + k[1]) + k[2]) + k[3]) + i11) - i4) * 5 < i4 && i(k)) {
                    return a(k, i10);
                }
            }
        }
        return Float.NaN;
    }

    public final float d(int i, int i2, int i3, int i4) {
        int i5;
        int i6;
        int i7;
        D6.b bVar = this.a;
        int i8 = bVar.i();
        int[] k = k();
        int i9 = i;
        while (i9 >= 0 && bVar.f(i2, i9)) {
            k[2] = k[2] + 1;
            i9--;
        }
        if (i9 < 0) {
            return Float.NaN;
        }
        while (i9 >= 0 && !bVar.f(i2, i9)) {
            int i10 = k[1];
            if (i10 > i3) {
                break;
            }
            k[1] = i10 + 1;
            i9--;
        }
        if (i9 >= 0 && k[1] <= i3) {
            while (i9 >= 0 && bVar.f(i2, i9) && (i7 = k[0]) <= i3) {
                k[0] = i7 + 1;
                i9--;
            }
            if (k[0] > i3) {
                return Float.NaN;
            }
            int i11 = i + 1;
            while (i11 < i8 && bVar.f(i2, i11)) {
                k[2] = k[2] + 1;
                i11++;
            }
            if (i11 == i8) {
                return Float.NaN;
            }
            while (i11 < i8 && !bVar.f(i2, i11) && (i6 = k[3]) < i3) {
                k[3] = i6 + 1;
                i11++;
            }
            if (i11 != i8 && k[3] < i3) {
                while (i11 < i8 && bVar.f(i2, i11) && (i5 = k[4]) < i3) {
                    k[4] = i5 + 1;
                    i11++;
                }
                int i12 = k[4];
                if (i12 < i3 && Math.abs(((((k[0] + k[1]) + k[2]) + k[3]) + i12) - i4) * 5 < i4 * 2 && i(k)) {
                    return a(k, i11);
                }
            }
        }
        return Float.NaN;
    }

    public final f g(Map map) {
        boolean z = map != null && map.containsKey(x6.e.TRY_HARDER);
        int i = this.a.i();
        int l = this.a.l();
        int i2 = (i * 3) / 388;
        if (i2 < 3 || z) {
            i2 = 3;
        }
        int[] iArr = new int[5];
        int i3 = i2 - 1;
        boolean z2 = false;
        while (i3 < i && !z2) {
            e(iArr);
            int i4 = 0;
            int i5 = 0;
            while (i4 < l) {
                if (this.a.f(i4, i3)) {
                    if ((i5 & 1) == 1) {
                        i5++;
                    }
                    iArr[i5] = iArr[i5] + 1;
                } else if ((i5 & 1) != 0) {
                    iArr[i5] = iArr[i5] + 1;
                } else if (i5 != 4) {
                    i5++;
                    iArr[i5] = iArr[i5] + 1;
                } else if (i(iArr) && l(iArr, i3, i4)) {
                    if (this.c) {
                        z2 = m();
                    } else {
                        int h = h();
                        int i6 = iArr[2];
                        if (h > i6) {
                            i3 += (h - i6) - 2;
                            i4 = l - 1;
                        }
                    }
                    e(iArr);
                    i2 = 2;
                    i5 = 0;
                } else {
                    f(iArr);
                    i5 = 3;
                }
                i4++;
            }
            if (i(iArr) && l(iArr, i3, l)) {
                i2 = iArr[0];
                if (this.c) {
                    z2 = m();
                }
            }
            i3 += i2;
        }
        d[] n = n();
        q.e(n);
        return new f(n);
    }

    public final int h() {
        if (this.b.size() <= 1) {
            return 0;
        }
        d dVar = null;
        for (d dVar2 : this.b) {
            if (dVar2.h() >= 2) {
                if (dVar != null) {
                    this.c = true;
                    return ((int) (Math.abs(dVar.c() - dVar2.c()) - Math.abs(dVar.d() - dVar2.d()))) / 2;
                }
                dVar = dVar2;
            }
        }
        return 0;
    }

    public final int[] k() {
        e(this.d);
        return this.d;
    }

    public final boolean l(int[] iArr, int i, int i2) {
        int i3 = 0;
        int i4 = iArr[0] + iArr[1] + iArr[2] + iArr[3] + iArr[4];
        int a2 = (int) a(iArr, i2);
        float d = d(i, a2, iArr[2], i4);
        if (!Float.isNaN(d)) {
            int i5 = (int) d;
            float c = c(a2, i5, iArr[2], i4);
            if (!Float.isNaN(c) && b(i5, (int) c)) {
                float f2 = i4 / 7.0f;
                while (true) {
                    if (i3 < this.b.size()) {
                        d dVar = (d) this.b.get(i3);
                        if (dVar.f(f2, d, c)) {
                            this.b.set(i3, dVar.g(d, c, f2));
                            break;
                        }
                        i3++;
                    } else {
                        d dVar2 = new d(c, d, f2);
                        this.b.add(dVar2);
                        r rVar = this.e;
                        if (rVar != null) {
                            rVar.a(dVar2);
                        }
                    }
                }
                return true;
            }
        }
        return false;
    }

    public final boolean m() {
        int size = this.b.size();
        float f2 = 0.0f;
        int i = 0;
        float f3 = 0.0f;
        for (d dVar : this.b) {
            if (dVar.h() >= 2) {
                i++;
                f3 += dVar.i();
            }
        }
        if (i < 3) {
            return false;
        }
        float f4 = f3 / size;
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            f2 += Math.abs(((d) it.next()).i() - f4);
        }
        return f2 <= f3 * 0.05f;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00be  */
    /* JADX WARN: Removed duplicated region for block: B:26:0x00c6 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final W6.d[] n() {
        /*
            r26 = this;
            r0 = r26
            java.util.List r1 = r0.b
            int r1 = r1.size()
            r2 = 3
            if (r1 < r2) goto Ld8
            java.util.List r1 = r0.b
            W6.e$b r3 = W6.e.f
            j$.util.List.-EL.sort(r1, r3)
            W6.d[] r1 = new W6.d[r2]
            r2 = 0
            r5 = 0
            r6 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
        L1b:
            java.util.List r8 = r0.b
            int r8 = r8.size()
            r9 = 2
            int r8 = r8 - r9
            if (r5 >= r8) goto Lc9
            java.util.List r8 = r0.b
            java.lang.Object r8 = r8.get(r5)
            W6.d r8 = (W6.d) r8
            float r10 = r8.i()
            int r5 = r5 + 1
            r11 = r5
        L34:
            java.util.List r12 = r0.b
            int r12 = r12.size()
            r13 = 1
            int r12 = r12 - r13
            if (r11 >= r12) goto L1b
            java.util.List r12 = r0.b
            java.lang.Object r12 = r12.get(r11)
            W6.d r12 = (W6.d) r12
            double r14 = o(r8, r12)
            int r11 = r11 + 1
            r3 = r11
        L4d:
            java.util.List r4 = r0.b
            int r4 = r4.size()
            if (r3 >= r4) goto L34
            java.util.List r4 = r0.b
            java.lang.Object r4 = r4.get(r3)
            W6.d r4 = (W6.d) r4
            float r16 = r4.i()
            r17 = 1068708659(0x3fb33333, float:1.4)
            float r17 = r17 * r10
            int r16 = (r16 > r17 ? 1 : (r16 == r17 ? 0 : -1))
            if (r16 > 0) goto Lc6
            double r16 = o(r12, r4)
            double r18 = o(r8, r4)
            int r20 = (r14 > r16 ? 1 : (r14 == r16 ? 0 : -1))
            if (r20 >= 0) goto L8f
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 <= 0) goto L86
            int r20 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r20 >= 0) goto L81
            r20 = r14
            goto La6
        L81:
            r20 = r18
        L83:
            r18 = r14
            goto La6
        L86:
            r20 = r14
            r24 = r16
            r16 = r18
            r18 = r24
            goto La6
        L8f:
            int r20 = (r16 > r18 ? 1 : (r16 == r18 ? 0 : -1))
            if (r20 >= 0) goto La1
            int r20 = (r14 > r18 ? 1 : (r14 == r18 ? 0 : -1))
            if (r20 >= 0) goto L9c
            r20 = r16
            r16 = r18
            goto L83
        L9c:
            r20 = r16
        L9e:
            r16 = r14
            goto La6
        La1:
            r20 = r18
            r18 = r16
            goto L9e
        La6:
            r22 = 4611686018427387904(0x4000000000000000, double:2.0)
            double r18 = r18 * r22
            double r18 = r16 - r18
            double r18 = java.lang.Math.abs(r18)
            double r20 = r20 * r22
            double r16 = r16 - r20
            double r16 = java.lang.Math.abs(r16)
            double r18 = r18 + r16
            int r16 = (r18 > r6 ? 1 : (r18 == r6 ? 0 : -1))
            if (r16 >= 0) goto Lc6
            r1[r2] = r8
            r1[r13] = r12
            r1[r9] = r4
            r6 = r18
        Lc6:
            int r3 = r3 + 1
            goto L4d
        Lc9:
            r3 = 9218868437227405311(0x7fefffffffffffff, double:1.7976931348623157E308)
            int r2 = (r6 > r3 ? 1 : (r6 == r3 ? 0 : -1))
            if (r2 == 0) goto Ld3
            return r1
        Ld3:
            x6.k r1 = x6.k.a()
            throw r1
        Ld8:
            x6.k r1 = x6.k.a()
            throw r1
        */
        throw new UnsupportedOperationException("Method not decompiled: W6.e.n():W6.d[]");
    }
}
