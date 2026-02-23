package f4;

import d4.L;
import d4.M;
import d4.k0;
import f4.e;
import java.util.ArrayList;
import java.util.zip.Inflater;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class f {
    public static e a(byte[] bArr, int i) {
        ArrayList arrayList;
        M m = new M(bArr);
        try {
            arrayList = c(m) ? f(m) : e(m);
        } catch (ArrayIndexOutOfBoundsException unused) {
            arrayList = null;
        }
        if (arrayList == null) {
            return null;
        }
        int size = arrayList.size();
        if (size == 1) {
            return new e((e.a) arrayList.get(0), i);
        }
        if (size != 2) {
            return null;
        }
        return new e((e.a) arrayList.get(0), (e.a) arrayList.get(1), i);
    }

    public static int b(int i) {
        return (-(i & 1)) ^ (i >> 1);
    }

    public static boolean c(M m) {
        m.V(4);
        int q = m.q();
        m.U(0);
        return q == 1886547818;
    }

    public static e.a d(M m) {
        int q = m.q();
        if (q > 10000) {
            return null;
        }
        float[] fArr = new float[q];
        for (int i = 0; i < q; i++) {
            fArr[i] = m.p();
        }
        int q2 = m.q();
        if (q2 > 32000) {
            return null;
        }
        double d = 2.0d;
        double log = Math.log(2.0d);
        int ceil = (int) Math.ceil(Math.log(q * 2.0d) / log);
        L l = new L(m.e());
        int i2 = 8;
        l.p(m.f() * 8);
        float[] fArr2 = new float[q2 * 5];
        int i3 = 5;
        int[] iArr = new int[5];
        int i4 = 0;
        int i5 = 0;
        while (i4 < q2) {
            int i6 = 0;
            while (i6 < i3) {
                int b = iArr[i6] + b(l.h(ceil));
                if (b >= q || b < 0) {
                    return null;
                }
                fArr2[i5] = fArr[b];
                iArr[i6] = b;
                i6++;
                i5++;
                i3 = 5;
            }
            i4++;
            i3 = 5;
        }
        l.p((l.e() + 7) & (-8));
        int i7 = 32;
        int h = l.h(32);
        e.b[] bVarArr = new e.b[h];
        int i8 = 0;
        while (i8 < h) {
            int h2 = l.h(i2);
            int h3 = l.h(i2);
            int h4 = l.h(i7);
            if (h4 > 128000) {
                return null;
            }
            int ceil2 = (int) Math.ceil(Math.log(q2 * d) / log);
            float[] fArr3 = new float[h4 * 3];
            float[] fArr4 = new float[h4 * 2];
            int i9 = 0;
            for (int i10 = 0; i10 < h4; i10++) {
                i9 += b(l.h(ceil2));
                if (i9 < 0 || i9 >= q2) {
                    return null;
                }
                int i11 = i10 * 3;
                int i12 = i9 * 5;
                fArr3[i11] = fArr2[i12];
                fArr3[i11 + 1] = fArr2[i12 + 1];
                fArr3[i11 + 2] = fArr2[i12 + 2];
                int i13 = i10 * 2;
                fArr4[i13] = fArr2[i12 + 3];
                fArr4[i13 + 1] = fArr2[i12 + 4];
            }
            bVarArr[i8] = new e.b(h2, fArr3, fArr4, h3);
            i8++;
            i7 = 32;
            d = 2.0d;
            i2 = 8;
        }
        return new e.a(bVarArr);
    }

    public static ArrayList e(M m) {
        if (m.H() != 0) {
            return null;
        }
        m.V(7);
        int q = m.q();
        if (q == 1684433976) {
            M m2 = new M();
            Inflater inflater = new Inflater(true);
            try {
                if (!k0.z0(m, m2, inflater)) {
                    return null;
                }
                m = m2;
            } finally {
                inflater.end();
            }
        } else if (q != 1918990112) {
            return null;
        }
        return g(m);
    }

    public static ArrayList f(M m) {
        int q;
        m.V(8);
        int f = m.f();
        int g = m.g();
        while (f < g && (q = m.q() + f) > f && q <= g) {
            int q2 = m.q();
            if (q2 == 2037673328 || q2 == 1836279920) {
                m.T(q);
                return e(m);
            }
            m.U(q);
            f = q;
        }
        return null;
    }

    public static ArrayList g(M m) {
        ArrayList arrayList = new ArrayList();
        int f = m.f();
        int g = m.g();
        while (f < g) {
            int q = m.q() + f;
            if (q <= f || q > g) {
                return null;
            }
            if (m.q() == 1835365224) {
                e.a d = d(m);
                if (d == null) {
                    return null;
                }
                arrayList.add(d);
            }
            m.U(q);
            f = q;
        }
        return arrayList;
    }
}
