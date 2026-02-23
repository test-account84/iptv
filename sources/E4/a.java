package e4;

import O2.l1;
import d4.G;
import d4.M;
import java.util.ArrayList;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a {
    public final List a;
    public final int b;
    public final int c;
    public final int d;
    public final int e;
    public final int f;
    public final int g;
    public final float h;
    public final String i;

    public a(List list, int i, int i2, int i3, int i4, int i5, int i6, float f, String str) {
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

    public static byte[] a(M m) {
        int N = m.N();
        int f = m.f();
        m.V(N);
        return d4.f.d(m.e(), f, N);
    }

    public static a b(M m) {
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        float f;
        try {
            m.V(4);
            int H = (m.H() & 3) + 1;
            if (H == 3) {
                throw new IllegalStateException();
            }
            ArrayList arrayList = new ArrayList();
            int H2 = m.H() & 31;
            for (int i6 = 0; i6 < H2; i6++) {
                arrayList.add(a(m));
            }
            int H3 = m.H();
            for (int i7 = 0; i7 < H3; i7++) {
                arrayList.add(a(m));
            }
            if (H2 > 0) {
                G.c l = G.l((byte[]) arrayList.get(0), H, ((byte[]) arrayList.get(0)).length);
                int i8 = l.f;
                int i9 = l.g;
                int i10 = l.o;
                int i11 = l.p;
                int i12 = l.q;
                float f2 = l.h;
                str = d4.f.a(l.a, l.b, l.c);
                i4 = i11;
                i5 = i12;
                f = f2;
                i = i8;
                i2 = i9;
                i3 = i10;
            } else {
                str = null;
                i = -1;
                i2 = -1;
                i3 = -1;
                i4 = -1;
                i5 = -1;
                f = 1.0f;
            }
            return new a(arrayList, H, i, i2, i3, i4, i5, f, str);
        } catch (ArrayIndexOutOfBoundsException e) {
            throw l1.a("Error parsing AVC config", e);
        }
    }
}
