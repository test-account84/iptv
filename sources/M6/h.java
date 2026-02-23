package M6;

import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class h extends k {
    public static final int[] b = {6, 8, 10, 12, 14};
    public static final int[] c = {1, 1, 1, 1};
    public static final int[][] d = {new int[]{1, 1, 2}, new int[]{1, 1, 3}};
    public static final int[][] e = {new int[]{1, 1, 2, 2, 1}, new int[]{2, 1, 1, 1, 2}, new int[]{1, 2, 1, 1, 2}, new int[]{2, 2, 1, 1, 1}, new int[]{1, 1, 2, 1, 2}, new int[]{2, 1, 2, 1, 1}, new int[]{1, 2, 2, 1, 1}, new int[]{1, 1, 1, 2, 2}, new int[]{2, 1, 1, 2, 1}, new int[]{1, 2, 1, 2, 1}, new int[]{1, 1, 3, 3, 1}, new int[]{3, 1, 1, 1, 3}, new int[]{1, 3, 1, 1, 3}, new int[]{3, 3, 1, 1, 1}, new int[]{1, 1, 3, 1, 3}, new int[]{3, 1, 3, 1, 1}, new int[]{1, 3, 3, 1, 1}, new int[]{1, 1, 1, 3, 3}, new int[]{3, 1, 1, 3, 1}, new int[]{1, 3, 1, 3, 1}};
    public int a = -1;

    public static int h(int[] iArr) {
        int length = e.length;
        float f = 0.38f;
        int i = -1;
        for (int i2 = 0; i2 < length; i2++) {
            float e2 = k.e(iArr, e[i2], 0.5f);
            if (e2 < f) {
                i = i2;
                f = e2;
            } else if (e2 == f) {
                i = -1;
            }
        }
        if (i >= 0) {
            return i % 10;
        }
        throw x6.k.a();
    }

    public static void j(D6.a aVar, int i, int i2, StringBuilder sb) {
        int[] iArr = new int[10];
        int[] iArr2 = new int[5];
        int[] iArr3 = new int[5];
        while (i < i2) {
            k.f(aVar, i, iArr);
            for (int i3 = 0; i3 < 5; i3++) {
                int i4 = i3 * 2;
                iArr2[i3] = iArr[i4];
                iArr3[i3] = iArr[i4 + 1];
            }
            sb.append((char) (h(iArr2) + 48));
            sb.append((char) (h(iArr3) + 48));
            for (int i5 = 0; i5 < 10; i5++) {
                i += iArr[i5];
            }
        }
    }

    public static int[] l(D6.a aVar, int i, int[] iArr) {
        int length = iArr.length;
        int[] iArr2 = new int[length];
        int l = aVar.l();
        int i2 = i;
        boolean z = false;
        int i3 = 0;
        while (i < l) {
            if (aVar.h(i) != z) {
                iArr2[i3] = iArr2[i3] + 1;
            } else {
                if (i3 != length - 1) {
                    i3++;
                } else {
                    if (k.e(iArr2, iArr, 0.5f) < 0.38f) {
                        return new int[]{i2, i};
                    }
                    i2 += iArr2[0] + iArr2[1];
                    int i4 = i3 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i4);
                    iArr2[i4] = 0;
                    iArr2[i3] = 0;
                    i3--;
                }
                iArr2[i3] = 1;
                z = !z;
            }
            i++;
        }
        throw x6.k.a();
    }

    public static int m(D6.a aVar) {
        int l = aVar.l();
        int j = aVar.j(0);
        if (j != l) {
            return j;
        }
        throw x6.k.a();
    }

    public x6.o c(int i, D6.a aVar, Map map) {
        boolean z;
        int[] k = k(aVar);
        int[] i2 = i(aVar);
        StringBuilder sb = new StringBuilder(20);
        j(aVar, k[1], i2[0], sb);
        String sb2 = sb.toString();
        int[] iArr = map != null ? (int[]) map.get(x6.e.ALLOWED_LENGTHS) : null;
        if (iArr == null) {
            iArr = b;
        }
        int length = sb2.length();
        int length2 = iArr.length;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            if (i3 >= length2) {
                z = false;
                break;
            }
            int i5 = iArr[i3];
            if (length == i5) {
                z = true;
                break;
            }
            if (i5 > i4) {
                i4 = i5;
            }
            i3++;
        }
        if (!z && length > i4) {
            z = true;
        }
        if (!z) {
            throw x6.g.a();
        }
        float f = i;
        return new x6.o(sb2, null, new x6.q[]{new x6.q(k[1], f), new x6.q(i2[0], f)}, x6.a.ITF);
    }

    public final int[] i(D6.a aVar) {
        int[] l;
        aVar.p();
        try {
            int m = m(aVar);
            try {
                l = l(aVar, m, d[0]);
            } catch (x6.k unused) {
                l = l(aVar, m, d[1]);
            }
            n(aVar, l[0]);
            int i = l[0];
            l[0] = aVar.l() - l[1];
            l[1] = aVar.l() - i;
            return l;
        } finally {
            aVar.p();
        }
    }

    public final int[] k(D6.a aVar) {
        int[] l = l(aVar, m(aVar), c);
        int i = l[1];
        int i2 = l[0];
        this.a = (i - i2) / 4;
        n(aVar, i2);
        return l;
    }

    public final void n(D6.a aVar, int i) {
        int min = Math.min(this.a * 10, i);
        for (int i2 = i - 1; min > 0 && i2 >= 0 && !aVar.h(i2); i2--) {
            min--;
        }
        if (min != 0) {
            throw x6.k.a();
        }
    }
}
