package Q3;

import P3.b;
import P3.i;
import P3.n;
import P3.o;
import android.text.Layout;
import android.text.SpannableString;
import android.text.SpannableStringBuilder;
import android.text.style.ForegroundColorSpan;
import android.text.style.StyleSpan;
import android.text.style.UnderlineSpan;
import d4.B;
import d4.M;
import d4.k0;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a extends e {
    public final int h;
    public final int i;
    public final int j;
    public final long k;
    public List n;
    public List o;
    public int p;
    public int q;
    public boolean r;
    public boolean s;
    public byte t;
    public byte u;
    public boolean w;
    public long x;
    public static final int[] y = {11, 1, 3, 12, 14, 5, 7, 9};
    public static final int[] z = {0, 4, 8, 12, 16, 20, 24, 28};
    public static final int[] A = {-1, -16711936, -16776961, -16711681, -65536, -256, -65281};
    public static final int[] B = {32, 33, 34, 35, 36, 37, 38, 39, 40, 41, 225, 43, 44, 45, 46, 47, 48, 49, 50, 51, 52, 53, 54, 55, 56, 57, 58, 59, 60, 61, 62, 63, 64, 65, 66, 67, 68, 69, 70, 71, 72, 73, 74, 75, 76, 77, 78, 79, 80, 81, 82, 83, 84, 85, 86, 87, 88, 89, 90, 91, 233, 93, 237, 243, 250, 97, 98, 99, 100, 101, 102, 103, 104, 105, 106, 107, 108, 109, 110, 111, 112, 113, 114, 115, 116, 117, 118, 119, 120, 121, 122, 231, 247, 209, 241, 9632};
    public static final int[] C = {174, 176, 189, 191, 8482, 162, 163, 9834, 224, 32, 232, 226, 234, 238, 244, 251};
    public static final int[] D = {193, 201, 211, 218, 220, 252, 8216, 161, 42, 39, 8212, 169, 8480, 8226, 8220, 8221, 192, 194, 199, 200, 202, 203, 235, 206, 207, 239, 212, 217, 249, 219, 171, 187};
    public static final int[] E = {195, 227, 205, 204, 236, 210, 242, 213, 245, 123, 125, 92, 94, 95, 124, 126, 196, 228, 214, 246, 223, 165, 164, 9474, 197, 229, 216, 248, 9484, 9488, 9492, 9496};
    public static final boolean[] F = {false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false, false, true, true, false, true, false, false, true, false, true, true, false, true, false, false, true, true, false, false, true, false, true, true, false};
    public final M g = new M();
    public final ArrayList l = new ArrayList();
    public a m = new a(0, 4);
    public int v = 0;

    public static final class a {
        public final List a = new ArrayList();
        public final List b = new ArrayList();
        public final StringBuilder c = new StringBuilder();
        public int d;
        public int e;
        public int f;
        public int g;
        public int h;

        public static class a {
            public final int a;
            public final boolean b;
            public int c;

            public a(int i, boolean z, int i2) {
                this.a = i;
                this.b = z;
                this.c = i2;
            }
        }

        public a(int i, int i2) {
            j(i);
            this.h = i2;
        }

        public static /* synthetic */ int a(a aVar, int i) {
            aVar.f = i;
            return i;
        }

        public static /* synthetic */ int b(a aVar) {
            return aVar.d;
        }

        public static /* synthetic */ int c(a aVar, int i) {
            aVar.d = i;
            return i;
        }

        public static /* synthetic */ int d(a aVar, int i) {
            aVar.e = i;
            return i;
        }

        public static void n(SpannableStringBuilder spannableStringBuilder, int i, int i2, int i3) {
            if (i3 == -1) {
                return;
            }
            spannableStringBuilder.setSpan(new ForegroundColorSpan(i3), i, i2, 33);
        }

        public static void o(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new StyleSpan(2), i, i2, 33);
        }

        public static void q(SpannableStringBuilder spannableStringBuilder, int i, int i2) {
            spannableStringBuilder.setSpan(new UnderlineSpan(), i, i2, 33);
        }

        public void e(char c) {
            if (this.c.length() < 32) {
                this.c.append(c);
            }
        }

        public void f() {
            int length = this.c.length();
            if (length > 0) {
                this.c.delete(length - 1, length);
                for (int size = this.a.size() - 1; size >= 0; size--) {
                    a aVar = (a) this.a.get(size);
                    int i = aVar.c;
                    if (i != length) {
                        return;
                    }
                    aVar.c = i - 1;
                }
            }
        }

        public P3.b g(int i) {
            float f;
            int i2 = this.e + this.f;
            int i3 = 32 - i2;
            CharSequence spannableStringBuilder = new SpannableStringBuilder();
            for (int i4 = 0; i4 < this.b.size(); i4++) {
                spannableStringBuilder.append(k0.v1((CharSequence) this.b.get(i4), i3));
                spannableStringBuilder.append('\n');
            }
            spannableStringBuilder.append(k0.v1(h(), i3));
            if (spannableStringBuilder.length() == 0) {
                return null;
            }
            int length = i3 - spannableStringBuilder.length();
            int i5 = i2 - length;
            if (i == Integer.MIN_VALUE) {
                i = (this.g != 2 || (Math.abs(i5) >= 3 && length >= 0)) ? (this.g != 2 || i5 <= 0) ? 0 : 2 : 1;
            }
            if (i != 1) {
                if (i == 2) {
                    i2 = 32 - length;
                }
                f = ((i2 / 32.0f) * 0.8f) + 0.1f;
            } else {
                f = 0.5f;
            }
            int i6 = this.d;
            if (i6 > 7) {
                i6 -= 17;
            } else if (this.g == 1) {
                i6 -= this.h - 1;
            }
            return new b.b().o(spannableStringBuilder).p(Layout.Alignment.ALIGN_NORMAL).h(i6, 1).k(f).l(i).a();
        }

        public final SpannableString h() {
            SpannableStringBuilder spannableStringBuilder = new SpannableStringBuilder(this.c);
            int length = spannableStringBuilder.length();
            int i = 0;
            int i2 = -1;
            int i3 = -1;
            int i4 = 0;
            int i5 = -1;
            int i6 = -1;
            boolean z = false;
            while (i < this.a.size()) {
                a aVar = (a) this.a.get(i);
                boolean z2 = aVar.b;
                int i7 = aVar.a;
                if (i7 != 8) {
                    boolean z3 = i7 == 7;
                    if (i7 != 7) {
                        i6 = a.o()[i7];
                    }
                    z = z3;
                }
                int i8 = aVar.c;
                i++;
                if (i8 != (i < this.a.size() ? ((a) this.a.get(i)).c : length)) {
                    if (i2 != -1 && !z2) {
                        q(spannableStringBuilder, i2, i8);
                        i2 = -1;
                    } else if (i2 == -1 && z2) {
                        i2 = i8;
                    }
                    if (i3 != -1 && !z) {
                        o(spannableStringBuilder, i3, i8);
                        i3 = -1;
                    } else if (i3 == -1 && z) {
                        i3 = i8;
                    }
                    if (i6 != i5) {
                        n(spannableStringBuilder, i4, i8, i5);
                        i5 = i6;
                        i4 = i8;
                    }
                }
            }
            if (i2 != -1 && i2 != length) {
                q(spannableStringBuilder, i2, length);
            }
            if (i3 != -1 && i3 != length) {
                o(spannableStringBuilder, i3, length);
            }
            if (i4 != length) {
                n(spannableStringBuilder, i4, length, i5);
            }
            return new SpannableString(spannableStringBuilder);
        }

        public boolean i() {
            return this.a.isEmpty() && this.b.isEmpty() && this.c.length() == 0;
        }

        public void j(int i) {
            this.g = i;
            this.a.clear();
            this.b.clear();
            this.c.setLength(0);
            this.d = 15;
            this.e = 0;
            this.f = 0;
        }

        public void k() {
            this.b.add(h());
            this.c.setLength(0);
            this.a.clear();
            int min = Math.min(this.h, this.d);
            while (this.b.size() >= min) {
                this.b.remove(0);
            }
        }

        public void l(int i) {
            this.g = i;
        }

        public void m(int i) {
            this.h = i;
        }

        public void p(int i, boolean z) {
            this.a.add(new a(i, z, this.c.length()));
        }
    }

    public a(String str, int i, long j) {
        this.k = j > 0 ? j * 1000 : -9223372036854775807L;
        this.h = "application/x-mp4-cea-608".equals(str) ? 2 : 3;
        if (i == 1) {
            this.j = 0;
            this.i = 0;
        } else if (i != 2) {
            if (i == 3) {
                this.j = 0;
            } else if (i != 4) {
                B.j("Cea608Decoder", "Invalid channel. Defaulting to CC1.");
                this.j = 0;
                this.i = 0;
            } else {
                this.j = 1;
            }
            this.i = 1;
        } else {
            this.j = 1;
            this.i = 0;
        }
        M(0);
        L();
        this.w = true;
        this.x = -9223372036854775807L;
    }

    public static boolean A(byte b, byte b2) {
        return (b & 246) == 18 && (b2 & 224) == 32;
    }

    public static boolean B(byte b, byte b2) {
        return (b & 247) == 17 && (b2 & 240) == 32;
    }

    public static boolean C(byte b, byte b2) {
        return (b & 246) == 20 && (b2 & 240) == 32;
    }

    public static boolean D(byte b, byte b2) {
        return (b & 240) == 16 && (b2 & 192) == 64;
    }

    public static boolean E(byte b) {
        return (b & 240) == 16;
    }

    public static boolean G(byte b) {
        return (b & 246) == 20;
    }

    public static boolean H(byte b, byte b2) {
        return (b & 247) == 17 && (b2 & 240) == 48;
    }

    public static boolean I(byte b, byte b2) {
        return (b & 247) == 23 && b2 >= 33 && b2 <= 35;
    }

    public static boolean J(byte b) {
        return 1 <= b && b <= 15;
    }

    public static /* synthetic */ int[] o() {
        return A;
    }

    public static char p(byte b) {
        return (char) B[(b & Byte.MAX_VALUE) - 32];
    }

    public static int q(byte b) {
        return (b >> 3) & 1;
    }

    public static char s(byte b) {
        return (char) D[b & 31];
    }

    public static char t(byte b) {
        return (char) E[b & 31];
    }

    public static char u(byte b, byte b2) {
        return (b & 1) == 0 ? s(b2) : t(b2);
    }

    public static char v(byte b) {
        return (char) C[b & 15];
    }

    public static boolean z(byte b) {
        return (b & 224) == 0;
    }

    public final boolean F(boolean z2, byte b, byte b2) {
        if (!z2 || !E(b)) {
            this.s = false;
        } else {
            if (this.s && this.t == b && this.u == b2) {
                this.s = false;
                return true;
            }
            this.s = true;
            this.t = b;
            this.u = b2;
        }
        return false;
    }

    public final void K(byte b, byte b2) {
        if (!J(b)) {
            if (G(b)) {
                if (b2 != 32 && b2 != 47) {
                    switch (b2) {
                        default:
                            switch (b2) {
                            }
                            return;
                        case 37:
                        case 38:
                        case 39:
                            this.w = true;
                            return;
                    }
                }
                this.w = true;
                return;
            }
            return;
        }
        this.w = false;
    }

    public final void L() {
        this.m.j(this.p);
        this.l.clear();
        this.l.add(this.m);
    }

    public final void M(int i) {
        int i2 = this.p;
        if (i2 == i) {
            return;
        }
        this.p = i;
        if (i == 3) {
            for (int i3 = 0; i3 < this.l.size(); i3++) {
                ((a) this.l.get(i3)).l(i);
            }
            return;
        }
        L();
        if (i2 == 3 || i == 1 || i == 0) {
            this.n = Collections.emptyList();
        }
    }

    public final void N(int i) {
        this.q = i;
        this.m.m(i);
    }

    public final boolean O() {
        return (this.k == -9223372036854775807L || this.x == -9223372036854775807L || j() - this.x < this.k) ? false : true;
    }

    public final boolean P(byte b) {
        if (z(b)) {
            this.v = q(b);
        }
        return this.v == this.j;
    }

    public /* bridge */ /* synthetic */ void a(long j) {
        super.a(j);
    }

    public i e() {
        List list = this.n;
        this.o = list;
        return new f((List) d4.a.e(list));
    }

    /* JADX WARN: Removed duplicated region for block: B:71:0x0063  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public void f(P3.n r10) {
        /*
            Method dump skipped, instructions count: 261
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: Q3.a.f(P3.n):void");
    }

    public void flush() {
        super.flush();
        this.n = null;
        this.o = null;
        M(0);
        N(4);
        L();
        this.r = false;
        this.s = false;
        this.t = (byte) 0;
        this.u = (byte) 0;
        this.v = 0;
        this.w = true;
        this.x = -9223372036854775807L;
    }

    public /* bridge */ /* synthetic */ n g() {
        return super.g();
    }

    public String getName() {
        return "Cea608Decoder";
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public o b() {
        o i;
        o h = super.h();
        if (h != null) {
            return h;
        }
        if (!O() || (i = i()) == null) {
            return null;
        }
        this.n = Collections.emptyList();
        this.x = -9223372036854775807L;
        i.d(j(), e(), Long.MAX_VALUE);
        return i;
    }

    public boolean k() {
        return this.n != this.o;
    }

    public /* bridge */ /* synthetic */ void l(n nVar) {
        super.l(nVar);
    }

    public final List r() {
        int size = this.l.size();
        ArrayList arrayList = new ArrayList(size);
        int i = 2;
        for (int i2 = 0; i2 < size; i2++) {
            P3.b g = ((a) this.l.get(i2)).g(Integer.MIN_VALUE);
            arrayList.add(g);
            if (g != null) {
                i = Math.min(i, g.j);
            }
        }
        ArrayList arrayList2 = new ArrayList(size);
        for (int i3 = 0; i3 < size; i3++) {
            P3.b bVar = (P3.b) arrayList.get(i3);
            if (bVar != null) {
                if (bVar.j != i) {
                    bVar = (P3.b) d4.a.e(((a) this.l.get(i3)).g(i));
                }
                arrayList2.add(bVar);
            }
        }
        return arrayList2;
    }

    public final void w(byte b) {
        this.m.e(' ');
        this.m.p((b >> 1) & 7, (b & 1) == 1);
    }

    public final void x(byte b) {
        if (b == 32) {
            M(2);
            return;
        }
        if (b == 41) {
            M(3);
            return;
        }
        switch (b) {
            case 37:
                M(1);
                N(2);
                break;
            case 38:
                M(1);
                N(3);
                break;
            case 39:
                M(1);
                N(4);
                break;
            default:
                int i = this.p;
                if (i != 0) {
                    if (b == 33) {
                        this.m.f();
                        break;
                    } else {
                        switch (b) {
                            case 44:
                                this.n = Collections.emptyList();
                                int i2 = this.p;
                                if (i2 != 1 && i2 != 3) {
                                }
                                break;
                            case 45:
                                if (i == 1 && !this.m.i()) {
                                    this.m.k();
                                    break;
                                }
                                break;
                            case 47:
                                this.n = r();
                                break;
                        }
                        L();
                        break;
                    }
                }
                break;
        }
    }

    public final void y(byte b, byte b2) {
        int i = y[b & 7];
        if ((b2 & 32) != 0) {
            i++;
        }
        if (i != a.b(this.m)) {
            if (this.p != 1 && !this.m.i()) {
                a aVar = new a(this.p, this.q);
                this.m = aVar;
                this.l.add(aVar);
            }
            a.c(this.m, i);
        }
        boolean z2 = (b2 & 16) == 16;
        boolean z3 = (b2 & 1) == 1;
        int i2 = (b2 >> 1) & 7;
        this.m.p(z2 ? 8 : i2, z3);
        if (z2) {
            a.d(this.m, z[i2]);
        }
    }

    public void release() {
    }
}
