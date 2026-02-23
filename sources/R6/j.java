package R6;

import java.lang.reflect.Array;
import java.util.ArrayList;
import x6.k;
import x6.q;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class j {
    public static final S6.a a = new S6.a();

    public static c a(h hVar) {
        int[] j;
        if (hVar == null || (j = hVar.j()) == null) {
            return null;
        }
        int p = p(j);
        int i = 0;
        int i2 = 0;
        for (int i3 : j) {
            i2 += p - i3;
            if (i3 > 0) {
                break;
            }
        }
        d[] d = hVar.d();
        for (int i4 = 0; i2 > 0 && d[i4] == null; i4++) {
            i2--;
        }
        for (int length = j.length - 1; length >= 0; length--) {
            int i5 = j[length];
            i += p - i5;
            if (i5 > 0) {
                break;
            }
        }
        for (int length2 = d.length - 1; i > 0 && d[length2] == null; length2--) {
            i--;
        }
        return hVar.a().a(i2, i, hVar.k());
    }

    public static void b(f fVar, b[][] bVarArr) {
        b bVar = bVarArr[0][1];
        int[] a2 = bVar.a();
        int j = (fVar.j() * fVar.l()) - r(fVar.k());
        if (a2.length == 0) {
            if (j <= 0 || j > 928) {
                throw k.a();
            }
            bVar.b(j);
            return;
        }
        if (a2[0] == j || j <= 0 || j > 928) {
            return;
        }
        bVar.b(j);
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0022, code lost:
    
        continue;
     */
    /* JADX WARN: Removed duplicated region for block: B:8:0x0011  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int c(D6.b r5, int r6, int r7, boolean r8, int r9, int r10) {
        /*
            if (r8 == 0) goto L4
            r0 = -1
            goto L5
        L4:
            r0 = 1
        L5:
            r1 = 0
            r2 = r9
        L7:
            r3 = 2
            if (r1 >= r3) goto L28
        La:
            if (r8 == 0) goto Lf
            if (r2 < r6) goto L22
            goto L11
        Lf:
            if (r2 >= r7) goto L22
        L11:
            boolean r4 = r5.f(r2, r10)
            if (r8 != r4) goto L22
            int r4 = r9 - r2
            int r4 = java.lang.Math.abs(r4)
            if (r4 <= r3) goto L20
            return r9
        L20:
            int r2 = r2 + r0
            goto La
        L22:
            int r0 = -r0
            r8 = r8 ^ 1
            int r1 = r1 + 1
            goto L7
        L28:
            return r2
        */
        throw new UnsupportedOperationException("Method not decompiled: R6.j.c(D6.b, int, int, boolean, int, int):int");
    }

    public static boolean d(int i, int i2, int i3) {
        return i2 + (-2) <= i && i <= i3 + 2;
    }

    public static int e(int[] iArr, int[] iArr2, int i) {
        if ((iArr2 == null || iArr2.length <= (i / 2) + 3) && i >= 0 && i <= 512) {
            return a.a(iArr, i, iArr2);
        }
        throw x6.d.a();
    }

    public static b[][] f(f fVar) {
        int c;
        b[][] bVarArr = (b[][]) Array.newInstance(b.class, new int[]{fVar.l(), fVar.j() + 2});
        for (b[] bVarArr2 : bVarArr) {
            int i = 0;
            while (true) {
                if (i < bVarArr2.length) {
                    bVarArr2[i] = new b();
                    i++;
                }
            }
        }
        int i2 = 0;
        for (g gVar : fVar.o()) {
            if (gVar != null) {
                for (d dVar : gVar.d()) {
                    if (dVar != null && (c = dVar.c()) >= 0 && c < bVarArr.length) {
                        bVarArr[c][i2].b(dVar.e());
                    }
                }
            }
            i2++;
        }
        return bVarArr;
    }

    public static D6.e g(f fVar) {
        b[][] f = f(fVar);
        b(fVar, f);
        ArrayList arrayList = new ArrayList();
        int[] iArr = new int[fVar.l() * fVar.j()];
        ArrayList arrayList2 = new ArrayList();
        ArrayList arrayList3 = new ArrayList();
        for (int i = 0; i < fVar.l(); i++) {
            int i2 = 0;
            while (i2 < fVar.j()) {
                int i3 = i2 + 1;
                int[] a2 = f[i][i3].a();
                int j = (fVar.j() * i) + i2;
                if (a2.length == 0) {
                    arrayList.add(Integer.valueOf(j));
                } else if (a2.length == 1) {
                    iArr[j] = a2[0];
                } else {
                    arrayList3.add(Integer.valueOf(j));
                    arrayList2.add(a2);
                }
                i2 = i3;
            }
        }
        int size = arrayList2.size();
        int[][] iArr2 = new int[size][];
        for (int i4 = 0; i4 < size; i4++) {
            iArr2[i4] = (int[]) arrayList2.get(i4);
        }
        return h(fVar.k(), iArr, Q6.a.b(arrayList), Q6.a.b(arrayList3), iArr2);
    }

    public static D6.e h(int i, int[] iArr, int[] iArr2, int[] iArr3, int[][] iArr4) {
        int length = iArr3.length;
        int[] iArr5 = new int[length];
        int i2 = 100;
        while (true) {
            int i3 = i2 - 1;
            if (i2 <= 0) {
                throw x6.d.a();
            }
            for (int i4 = 0; i4 < length; i4++) {
                iArr[iArr3[i4]] = iArr4[i4][iArr5[i4]];
            }
            try {
                return j(iArr, i, iArr2);
            } catch (x6.d unused) {
                if (length == 0) {
                    throw x6.d.a();
                }
                int i5 = 0;
                while (true) {
                    if (i5 >= length) {
                        break;
                    }
                    int i6 = iArr5[i5];
                    if (i6 < iArr4[i5].length - 1) {
                        iArr5[i5] = i6 + 1;
                        break;
                    }
                    iArr5[i5] = 0;
                    if (i5 == length - 1) {
                        throw x6.d.a();
                    }
                    i5++;
                }
                i2 = i3;
            }
        }
    }

    /* JADX WARN: Code restructure failed: missing block: B:16:0x005b, code lost:
    
        r3.p(r9);
        r5 = r3.j() + 1;
        r3.q(0, r0);
        r3.q(r5, r2);
     */
    /* JADX WARN: Code restructure failed: missing block: B:17:0x0069, code lost:
    
        if (r0 == null) goto L20;
     */
    /* JADX WARN: Code restructure failed: missing block: B:18:0x006b, code lost:
    
        r0 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:19:0x006e, code lost:
    
        r2 = r26;
        r6 = r27;
        r7 = 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:20:0x0073, code lost:
    
        if (r7 > r5) goto L66;
     */
    /* JADX WARN: Code restructure failed: missing block: B:21:0x0075, code lost:
    
        if (r0 == false) goto L25;
     */
    /* JADX WARN: Code restructure failed: missing block: B:22:0x0077, code lost:
    
        r8 = r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:24:0x007f, code lost:
    
        if (r3.n(r8) != null) goto L67;
     */
    /* JADX WARN: Code restructure failed: missing block: B:25:0x0081, code lost:
    
        if (r8 == 0) goto L33;
     */
    /* JADX WARN: Code restructure failed: missing block: B:26:0x0083, code lost:
    
        if (r8 != r5) goto L31;
     */
    /* JADX WARN: Code restructure failed: missing block: B:27:0x0086, code lost:
    
        r10 = new R6.g(r9);
     */
    /* JADX WARN: Code restructure failed: missing block: B:28:0x008b, code lost:
    
        r15 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:29:0x0098, code lost:
    
        r3.q(r8, r15);
        r14 = -1;
        r13 = r9.g();
        r12 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:31:0x00a6, code lost:
    
        if (r13 > r9.e()) goto L68;
     */
    /* JADX WARN: Code restructure failed: missing block: B:32:0x00a8, code lost:
    
        r10 = t(r3, r8, r13, r0);
     */
    /* JADX WARN: Code restructure failed: missing block: B:33:0x00ac, code lost:
    
        if (r10 < 0) goto L47;
     */
    /* JADX WARN: Code restructure failed: missing block: B:35:0x00b2, code lost:
    
        if (r10 <= r9.d()) goto L46;
     */
    /* JADX WARN: Code restructure failed: missing block: B:36:0x00b5, code lost:
    
        r18 = r10;
     */
    /* JADX WARN: Code restructure failed: missing block: B:37:0x00bc, code lost:
    
        r19 = r12;
        r22 = r13;
        r1 = r15;
        r10 = k(r21, r9.f(), r9.d(), r0, r18, r22, r2, r6);
        r11 = r22;
     */
    /* JADX WARN: Code restructure failed: missing block: B:38:0x00de, code lost:
    
        if (r10 == null) goto L53;
     */
    /* JADX WARN: Code restructure failed: missing block: B:39:0x00e0, code lost:
    
        r1.f(r11, r10);
        r2 = java.lang.Math.min(r2, r10.f());
        r6 = java.lang.Math.max(r6, r10.f());
        r12 = r18;
     */
    /* JADX WARN: Code restructure failed: missing block: B:41:0x00fe, code lost:
    
        r13 = r11 + 1;
        r15 = r1;
        r14 = -1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:42:0x00fc, code lost:
    
        r12 = r19;
     */
    /* JADX WARN: Code restructure failed: missing block: B:44:0x00b8, code lost:
    
        if (r12 == r14) goto L52;
     */
    /* JADX WARN: Code restructure failed: missing block: B:45:0x00ba, code lost:
    
        r18 = r12;
     */
    /* JADX WARN: Code restructure failed: missing block: B:46:0x00f6, code lost:
    
        r19 = r12;
        r11 = r13;
        r1 = r15;
     */
    /* JADX WARN: Code restructure failed: missing block: B:48:0x0104, code lost:
    
        r7 = r7 + 1;
     */
    /* JADX WARN: Code restructure failed: missing block: B:50:0x008f, code lost:
    
        if (r8 != 0) goto L36;
     */
    /* JADX WARN: Code restructure failed: missing block: B:51:0x0091, code lost:
    
        r11 = true;
     */
    /* JADX WARN: Code restructure failed: missing block: B:52:0x0094, code lost:
    
        r10 = new R6.h(r9, r11);
     */
    /* JADX WARN: Code restructure failed: missing block: B:53:0x0093, code lost:
    
        r11 = false;
     */
    /* JADX WARN: Code restructure failed: missing block: B:55:0x0079, code lost:
    
        r8 = r5 - r7;
     */
    /* JADX WARN: Code restructure failed: missing block: B:58:0x010d, code lost:
    
        return g(r3);
     */
    /* JADX WARN: Code restructure failed: missing block: B:60:0x006d, code lost:
    
        r0 = false;
     */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static D6.e i(D6.b r21, x6.q r22, x6.q r23, x6.q r24, x6.q r25, int r26, int r27) {
        /*
            Method dump skipped, instructions count: 275
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: R6.j.i(D6.b, x6.q, x6.q, x6.q, x6.q, int, int):D6.e");
    }

    public static D6.e j(int[] iArr, int i, int[] iArr2) {
        if (iArr.length == 0) {
            throw x6.g.a();
        }
        int i2 = 1 << (i + 1);
        int e = e(iArr, iArr2, i2);
        w(iArr, i2);
        D6.e b = e.b(iArr, String.valueOf(i));
        b.k(Integer.valueOf(e));
        b.j(Integer.valueOf(iArr2.length));
        return b;
    }

    public static d k(D6.b bVar, int i, int i2, boolean z, int i3, int i4, int i5, int i6) {
        int i7;
        int d;
        int a2;
        int c = c(bVar, i, i2, z, i3, i4);
        int[] q = q(bVar, i, i2, z, c, i4);
        if (q == null) {
            return null;
        }
        int d2 = E6.a.d(q);
        if (z) {
            i7 = c + d2;
        } else {
            for (int i8 = 0; i8 < q.length / 2; i8++) {
                int i9 = q[i8];
                q[i8] = q[(q.length - 1) - i8];
                q[(q.length - 1) - i8] = i9;
            }
            c -= d2;
            i7 = c;
        }
        if (d(d2, i5, i6) && (a2 = Q6.a.a((d = i.d(q)))) != -1) {
            return new d(c, i7, n(d), a2);
        }
        return null;
    }

    public static a l(h hVar, h hVar2) {
        a i;
        a i2;
        if (hVar == null || (i = hVar.i()) == null) {
            if (hVar2 == null) {
                return null;
            }
            return hVar2.i();
        }
        if (hVar2 == null || (i2 = hVar2.i()) == null || i.a() == i2.a() || i.b() == i2.b() || i.c() == i2.c()) {
            return i;
        }
        return null;
    }

    public static int[] m(int i) {
        int[] iArr = new int[8];
        int i2 = 0;
        int i3 = 7;
        while (true) {
            int i4 = i & 1;
            if (i4 != i2) {
                i3--;
                if (i3 < 0) {
                    return iArr;
                }
                i2 = i4;
            }
            iArr[i3] = iArr[i3] + 1;
            i >>= 1;
        }
    }

    public static int n(int i) {
        return o(m(i));
    }

    public static int o(int[] iArr) {
        return ((((iArr[0] - iArr[2]) + iArr[4]) - iArr[6]) + 9) % 9;
    }

    public static int p(int[] iArr) {
        int i = -1;
        for (int i2 : iArr) {
            i = Math.max(i, i2);
        }
        return i;
    }

    /* JADX WARN: Removed duplicated region for block: B:7:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static int[] q(D6.b r7, int r8, int r9, boolean r10, int r11, int r12) {
        /*
            r0 = 8
            int[] r1 = new int[r0]
            r2 = 1
            if (r10 == 0) goto L9
            r3 = 1
            goto La
        L9:
            r3 = -1
        La:
            r4 = 0
            r5 = r10
        Lc:
            if (r10 == 0) goto L11
            if (r11 >= r9) goto L27
            goto L13
        L11:
            if (r11 < r8) goto L27
        L13:
            if (r4 >= r0) goto L27
            boolean r6 = r7.f(r11, r12)
            if (r6 != r5) goto L22
            r6 = r1[r4]
            int r6 = r6 + r2
            r1[r4] = r6
            int r11 = r11 + r3
            goto Lc
        L22:
            int r4 = r4 + 1
            r5 = r5 ^ 1
            goto Lc
        L27:
            if (r4 == r0) goto L34
            if (r10 == 0) goto L2c
            r8 = r9
        L2c:
            if (r11 != r8) goto L32
            r7 = 7
            if (r4 != r7) goto L32
            goto L34
        L32:
            r7 = 0
            return r7
        L34:
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: R6.j.q(D6.b, int, int, boolean, int, int):int[]");
    }

    public static int r(int i) {
        return 2 << i;
    }

    public static h s(D6.b bVar, c cVar, q qVar, boolean z, int i, int i2) {
        h hVar = new h(cVar, z);
        int i3 = 0;
        while (i3 < 2) {
            int i4 = i3 == 0 ? 1 : -1;
            int c = (int) qVar.c();
            for (int d = (int) qVar.d(); d <= cVar.e() && d >= cVar.g(); d += i4) {
                d k = k(bVar, 0, bVar.l(), z, c, d, i, i2);
                if (k != null) {
                    hVar.f(d, k);
                    c = z ? k.d() : k.b();
                }
            }
            i3++;
        }
        return hVar;
    }

    public static int t(f fVar, int i, int i2, boolean z) {
        int i3 = z ? 1 : -1;
        int i4 = i - i3;
        d b = u(fVar, i4) ? fVar.n(i4).b(i2) : null;
        if (b != null) {
            return z ? b.b() : b.d();
        }
        d c = fVar.n(i).c(i2);
        if (c != null) {
            return z ? c.d() : c.b();
        }
        if (u(fVar, i4)) {
            c = fVar.n(i4).c(i2);
        }
        if (c != null) {
            return z ? c.b() : c.d();
        }
        int i5 = 0;
        while (true) {
            i -= i3;
            if (!u(fVar, i)) {
                c m = fVar.m();
                return z ? m.f() : m.d();
            }
            for (d dVar : fVar.n(i).d()) {
                if (dVar != null) {
                    return (z ? dVar.b() : dVar.d()) + (i3 * i5 * (dVar.b() - dVar.d()));
                }
            }
            i5++;
        }
    }

    public static boolean u(f fVar, int i) {
        return i >= 0 && i <= fVar.j() + 1;
    }

    public static f v(h hVar, h hVar2) {
        a l;
        if ((hVar == null && hVar2 == null) || (l = l(hVar, hVar2)) == null) {
            return null;
        }
        return new f(l, c.j(a(hVar), a(hVar2)));
    }

    public static void w(int[] iArr, int i) {
        if (iArr.length < 4) {
            throw x6.g.a();
        }
        int i2 = iArr[0];
        if (i2 > iArr.length) {
            throw x6.g.a();
        }
        if (i2 == 0) {
            if (i >= iArr.length) {
                throw x6.g.a();
            }
            iArr[0] = iArr.length - i;
        }
    }
}
