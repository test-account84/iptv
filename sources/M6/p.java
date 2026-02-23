package M6;

import java.util.Arrays;
import java.util.Map;
import x6.r;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class p extends k {
    public static final int[] d = {1, 1, 1};
    public static final int[] e = {1, 1, 1, 1, 1};
    public static final int[] f = {1, 1, 1, 1, 1, 1};
    public static final int[][] g;
    public static final int[][] h;
    public final StringBuilder a = new StringBuilder(20);
    public final o b = new o();
    public final g c = new g();

    static {
        int[][] iArr = {new int[]{3, 2, 1, 1}, new int[]{2, 2, 2, 1}, new int[]{2, 1, 2, 2}, new int[]{1, 4, 1, 1}, new int[]{1, 1, 3, 2}, new int[]{1, 2, 3, 1}, new int[]{1, 1, 1, 4}, new int[]{1, 3, 1, 2}, new int[]{1, 2, 1, 3}, new int[]{3, 1, 1, 2}};
        g = iArr;
        int[][] iArr2 = new int[20][];
        h = iArr2;
        System.arraycopy(iArr, 0, iArr2, 0, 10);
        for (int i = 10; i < 20; i++) {
            int[] iArr3 = g[i - 10];
            int[] iArr4 = new int[iArr3.length];
            for (int i2 = 0; i2 < iArr3.length; i2++) {
                iArr4[i2] = iArr3[(iArr3.length - i2) - 1];
            }
            h[i] = iArr4;
        }
    }

    public static boolean i(CharSequence charSequence) {
        int length = charSequence.length();
        if (length == 0) {
            return false;
        }
        int i = length - 1;
        return r(charSequence.subSequence(0, i)) == Character.digit(charSequence.charAt(i), 10);
    }

    public static int j(D6.a aVar, int[] iArr, int i, int[][] iArr2) {
        k.f(aVar, i, iArr);
        int length = iArr2.length;
        float f2 = 0.48f;
        int i2 = -1;
        for (int i3 = 0; i3 < length; i3++) {
            float e2 = k.e(iArr, iArr2[i3], 0.7f);
            if (e2 < f2) {
                i2 = i3;
                f2 = e2;
            }
        }
        if (i2 >= 0) {
            return i2;
        }
        throw x6.k.a();
    }

    public static int[] n(D6.a aVar, int i, boolean z, int[] iArr) {
        return o(aVar, i, z, iArr, new int[iArr.length]);
    }

    public static int[] o(D6.a aVar, int i, boolean z, int[] iArr, int[] iArr2) {
        int l = aVar.l();
        int k = z ? aVar.k(i) : aVar.j(i);
        int length = iArr.length;
        boolean z2 = z;
        int i2 = 0;
        int i3 = k;
        while (k < l) {
            if (aVar.h(k) != z2) {
                iArr2[i2] = iArr2[i2] + 1;
            } else {
                if (i2 != length - 1) {
                    i2++;
                } else {
                    if (k.e(iArr2, iArr, 0.7f) < 0.48f) {
                        return new int[]{i3, k};
                    }
                    i3 += iArr2[0] + iArr2[1];
                    int i4 = i2 - 1;
                    System.arraycopy(iArr2, 2, iArr2, 0, i4);
                    iArr2[i4] = 0;
                    iArr2[i2] = 0;
                    i2--;
                }
                iArr2[i2] = 1;
                z2 = !z2;
            }
            k++;
        }
        throw x6.k.a();
    }

    public static int[] p(D6.a aVar) {
        int[] iArr = new int[d.length];
        int[] iArr2 = null;
        boolean z = false;
        int i = 0;
        while (!z) {
            int[] iArr3 = d;
            Arrays.fill(iArr, 0, iArr3.length, 0);
            iArr2 = o(aVar, i, false, iArr3, iArr);
            int i2 = iArr2[0];
            int i3 = iArr2[1];
            int i4 = i2 - (i3 - i2);
            if (i4 >= 0) {
                z = aVar.n(i4, i2, false);
            }
            i = i3;
        }
        return iArr2;
    }

    public static int r(CharSequence charSequence) {
        int length = charSequence.length();
        int i = 0;
        for (int i2 = length - 1; i2 >= 0; i2 -= 2) {
            int charAt = charSequence.charAt(i2) - '0';
            if (charAt < 0 || charAt > 9) {
                throw x6.g.a();
            }
            i += charAt;
        }
        int i3 = i * 3;
        for (int i4 = length - 2; i4 >= 0; i4 -= 2) {
            int charAt2 = charSequence.charAt(i4) - '0';
            if (charAt2 < 0 || charAt2 > 9) {
                throw x6.g.a();
            }
            i3 += charAt2;
        }
        return (1000 - i3) % 10;
    }

    public x6.o c(int i, D6.a aVar, Map map) {
        return m(i, aVar, p(aVar), map);
    }

    public boolean h(String str) {
        return i(str);
    }

    public int[] k(D6.a aVar, int i) {
        return n(aVar, i, false, d);
    }

    public abstract int l(D6.a aVar, int[] iArr, StringBuilder sb);

    public x6.o m(int i, D6.a aVar, int[] iArr, Map map) {
        int i2;
        String c;
        r rVar = map == null ? null : (r) map.get(x6.e.NEED_RESULT_POINT_CALLBACK);
        if (rVar != null) {
            rVar.a(new x6.q((iArr[0] + iArr[1]) / 2.0f, i));
        }
        StringBuilder sb = this.a;
        sb.setLength(0);
        int l = l(aVar, iArr, sb);
        if (rVar != null) {
            rVar.a(new x6.q(l, i));
        }
        int[] k = k(aVar, l);
        if (rVar != null) {
            rVar.a(new x6.q((k[0] + k[1]) / 2.0f, i));
        }
        int i3 = k[1];
        int i4 = (i3 - k[0]) + i3;
        if (i4 >= aVar.l() || !aVar.n(i3, i4, false)) {
            throw x6.k.a();
        }
        String sb2 = sb.toString();
        if (sb2.length() < 8) {
            throw x6.g.a();
        }
        if (!h(sb2)) {
            throw x6.d.a();
        }
        x6.a q = q();
        float f2 = i;
        x6.o oVar = new x6.o(sb2, null, new x6.q[]{new x6.q((iArr[1] + iArr[0]) / 2.0f, f2), new x6.q((k[1] + k[0]) / 2.0f, f2)}, q);
        try {
            x6.o a = this.b.a(i, aVar, k[1]);
            oVar.h(x6.p.UPC_EAN_EXTENSION, a.f());
            oVar.g(a.d());
            oVar.a(a.e());
            i2 = a.f().length();
        } catch (x6.n unused) {
            i2 = 0;
        }
        int[] iArr2 = map != null ? (int[]) map.get(x6.e.ALLOWED_EAN_EXTENSIONS) : null;
        if (iArr2 != null) {
            for (int i5 : iArr2) {
                if (i2 != i5) {
                }
            }
            throw x6.k.a();
        }
        if ((q == x6.a.EAN_13 || q == x6.a.UPC_A) && (c = this.c.c(sb2)) != null) {
            oVar.h(x6.p.POSSIBLE_COUNTRY, c);
        }
        return oVar;
    }

    public abstract x6.a q();
}
