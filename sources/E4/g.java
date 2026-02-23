package e4;

import O2.l1;
import d4.G;
import d4.M;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g {
    public final List a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final float h;
    public final String i;

    public g(List list, int i, int i2, int i3, int i4, int i5, int i6, float f, String str) {
        this.a = list;
        this.b = i;
        this.c = i2;
        this.d = i3;
        this.e = i4;
        this.f = i5;
        this.g = i6;
        this.h = f;
        this.i = str;
    }

    public static g a(M m) {
        int i;
        int i2;
        try {
            m.V(21);
            int H = m.H() & 3;
            int H2 = m.H();
            int f = m.f();
            int i3 = 0;
            int i4 = 0;
            for (int i5 = 0; i5 < H2; i5++) {
                m.V(1);
                int N = m.N();
                for (int i6 = 0; i6 < N; i6++) {
                    int N2 = m.N();
                    i4 += N2 + 4;
                    m.V(N2);
                }
            }
            m.U(f);
            byte[] bArr = new byte[i4];
            String str = null;
            int i7 = 0;
            int i8 = 0;
            int i9 = -1;
            int i10 = -1;
            int i11 = -1;
            int i12 = -1;
            int i13 = -1;
            float f2 = 1.0f;
            while (i7 < H2) {
                int H3 = m.H() & 63;
                int N3 = m.N();
                int i14 = 0;
                while (i14 < N3) {
                    int N4 = m.N();
                    byte[] bArr2 = G.a;
                    int i15 = H2;
                    System.arraycopy(bArr2, i3, bArr, i8, bArr2.length);
                    int length = i8 + bArr2.length;
                    System.arraycopy(m.e(), m.f(), bArr, length, N4);
                    if (H3 == 33 && i14 == 0) {
                        G.a h = G.h(bArr, length, length + N4);
                        int i16 = h.k;
                        i10 = h.l;
                        i11 = h.n;
                        int i17 = h.o;
                        int i18 = h.p;
                        float f3 = h.m;
                        i = H3;
                        i2 = N3;
                        i9 = i16;
                        str = d4.f.c(h.a, h.b, h.c, h.d, h.h, h.i);
                        i13 = i18;
                        i12 = i17;
                        f2 = f3;
                    } else {
                        i = H3;
                        i2 = N3;
                    }
                    i8 = length + N4;
                    m.V(N4);
                    i14++;
                    H2 = i15;
                    H3 = i;
                    N3 = i2;
                    i3 = 0;
                }
                i7++;
                i3 = 0;
            }
            return new g(i4 == 0 ? Collections.emptyList() : Collections.singletonList(bArr), H + 1, i9, i10, i11, i12, i13, f2, str);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw l1.a("Error parsing HEVC config", e);
        }
    }
}
