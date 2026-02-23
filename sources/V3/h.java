package v3;

import d4.B;
import d4.L;
import d4.M;
import d4.k0;
import java.nio.ByteBuffer;
import java.nio.charset.Charset;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import java.util.Locale;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class h extends q3.h {
    public static final a b = new g();
    public final a a;

    public interface a {
        boolean a(int i, int i2, int i3, int i4, int i5);
    }

    public static final class b {
        public final int a;
        public final boolean b;
        public final int c;

        public b(int i, boolean z, int i2) {
            this.a = i;
            this.b = z;
            this.c = i2;
        }

        public static /* synthetic */ int a(b bVar) {
            return bVar.a;
        }

        public static /* synthetic */ int b(b bVar) {
            return bVar.c;
        }

        public static /* synthetic */ boolean c(b bVar) {
            return bVar.b;
        }
    }

    public h() {
        this(null);
    }

    public static /* synthetic */ boolean A(int i, int i2, int i3, int i4, int i5) {
        return false;
    }

    public static int B(M m, int i) {
        byte[] e = m.e();
        int f = m.f();
        int i2 = f;
        while (true) {
            int i3 = i2 + 1;
            if (i3 >= f + i) {
                return i;
            }
            if ((e[i2] & 255) == 255 && e[i3] == 0) {
                System.arraycopy(e, i2 + 2, e, i3, (i - (i2 - f)) - 2);
                i--;
            }
            i2 = i3;
        }
    }

    public static boolean C(M m, int i, int i2, boolean z) {
        int K;
        long K2;
        int i3;
        int i4;
        int f = m.f();
        while (true) {
            try {
                boolean z2 = true;
                if (m.a() < i2) {
                    m.U(f);
                    return true;
                }
                if (i >= 3) {
                    K = m.q();
                    K2 = m.J();
                    i3 = m.N();
                } else {
                    K = m.K();
                    K2 = m.K();
                    i3 = 0;
                }
                if (K == 0 && K2 == 0 && i3 == 0) {
                    m.U(f);
                    return true;
                }
                if (i == 4 && !z) {
                    if ((8421504 & K2) != 0) {
                        m.U(f);
                        return false;
                    }
                    K2 = (((K2 >> 24) & 255) << 21) | (K2 & 255) | (((K2 >> 8) & 255) << 7) | (((K2 >> 16) & 255) << 14);
                }
                if (i == 4) {
                    i4 = (i3 & 64) != 0 ? 1 : 0;
                    if ((i3 & 1) == 0) {
                        z2 = false;
                    }
                } else {
                    if (i == 3) {
                        i4 = (i3 & 32) != 0 ? 1 : 0;
                        if ((i3 & 128) == 0) {
                        }
                    } else {
                        i4 = 0;
                    }
                    z2 = false;
                }
                if (z2) {
                    i4 += 4;
                }
                if (K2 < i4) {
                    m.U(f);
                    return false;
                }
                if (m.a() < K2) {
                    m.U(f);
                    return false;
                }
                m.V((int) K2);
            } catch (Throwable th) {
                m.U(f);
                throw th;
            }
        }
    }

    public static /* synthetic */ boolean c(int i, int i2, int i3, int i4, int i5) {
        return A(i, i2, i3, i4, i5);
    }

    public static byte[] d(byte[] bArr, int i, int i2) {
        return i2 <= i ? k0.f : Arrays.copyOfRange(bArr, i, i2);
    }

    public static v3.a f(M m, int i, int i2) {
        int z;
        String str;
        int H = m.H();
        Charset w = w(H);
        int i3 = i - 1;
        byte[] bArr = new byte[i3];
        m.l(bArr, 0, i3);
        if (i2 == 2) {
            str = "image/" + r5.b.e(new String(bArr, 0, 3, r5.d.b));
            if ("image/jpg".equals(str)) {
                str = "image/jpeg";
            }
            z = 2;
        } else {
            z = z(bArr, 0);
            String e = r5.b.e(new String(bArr, 0, z, r5.d.b));
            if (e.indexOf(47) == -1) {
                str = "image/" + e;
            } else {
                str = e;
            }
        }
        int i4 = bArr[z + 1] & 255;
        int i5 = z + 2;
        int y = y(bArr, i5, H);
        return new v3.a(str, new String(bArr, i5, y - i5, w), i4, d(bArr, y + v(H), i3));
    }

    public static v3.b g(M m, int i, String str) {
        byte[] bArr = new byte[i];
        m.l(bArr, 0, i);
        return new v3.b(str, bArr);
    }

    public static c h(M m, int i, int i2, boolean z, int i3, a aVar) {
        int f = m.f();
        int z2 = z(m.e(), f);
        String str = new String(m.e(), f, z2 - f, r5.d.b);
        m.U(z2 + 1);
        int q = m.q();
        int q2 = m.q();
        long J = m.J();
        long j = J == 4294967295L ? -1L : J;
        long J2 = m.J();
        long j2 = J2 == 4294967295L ? -1L : J2;
        ArrayList arrayList = new ArrayList();
        int i4 = f + i;
        while (m.f() < i4) {
            i k = k(i2, m, z, i3, aVar);
            if (k != null) {
                arrayList.add(k);
            }
        }
        return new c(str, q, q2, j, j2, (i[]) arrayList.toArray(new i[0]));
    }

    public static d i(M m, int i, int i2, boolean z, int i3, a aVar) {
        int f = m.f();
        int z2 = z(m.e(), f);
        String str = new String(m.e(), f, z2 - f, r5.d.b);
        m.U(z2 + 1);
        int H = m.H();
        boolean z3 = (H & 2) != 0;
        boolean z4 = (H & 1) != 0;
        int H2 = m.H();
        String[] strArr = new String[H2];
        for (int i4 = 0; i4 < H2; i4++) {
            int f2 = m.f();
            int z5 = z(m.e(), f2);
            strArr[i4] = new String(m.e(), f2, z5 - f2, r5.d.b);
            m.U(z5 + 1);
        }
        ArrayList arrayList = new ArrayList();
        int i5 = f + i;
        while (m.f() < i5) {
            i k = k(i2, m, z, i3, aVar);
            if (k != null) {
                arrayList.add(k);
            }
        }
        return new d(str, z3, z4, strArr, (i[]) arrayList.toArray(new i[0]));
    }

    public static e j(M m, int i) {
        if (i < 4) {
            return null;
        }
        int H = m.H();
        Charset w = w(H);
        byte[] bArr = new byte[3];
        m.l(bArr, 0, 3);
        String str = new String(bArr, 0, 3);
        int i2 = i - 4;
        byte[] bArr2 = new byte[i2];
        m.l(bArr2, 0, i2);
        int y = y(bArr2, 0, H);
        String str2 = new String(bArr2, 0, y, w);
        int v = y + v(H);
        return new e(str, str2, p(bArr2, v, y(bArr2, v, H), w));
    }

    /* JADX WARN: Removed duplicated region for block: B:106:0x01a9  */
    /* JADX WARN: Removed duplicated region for block: B:112:0x01c3  */
    /* JADX WARN: Removed duplicated region for block: B:117:0x01db  */
    /* JADX WARN: Removed duplicated region for block: B:123:0x01ea A[Catch: all -> 0x0122, TryCatch #0 {all -> 0x0122, blocks: (B:58:0x011c, B:60:0x01f4, B:65:0x0127, B:72:0x013d, B:74:0x0145, B:82:0x015f, B:91:0x0177, B:98:0x0192, B:105:0x01a4, B:111:0x01b3, B:116:0x01cb, B:122:0x01e5, B:123:0x01ea), top: B:52:0x0112 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static v3.i k(int r19, d4.M r20, boolean r21, int r22, v3.h.a r23) {
        /*
            Method dump skipped, instructions count: 549
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: v3.h.k(int, d4.M, boolean, int, v3.h$a):v3.i");
    }

    public static f l(M m, int i) {
        int H = m.H();
        Charset w = w(H);
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        m.l(bArr, 0, i2);
        int z = z(bArr, 0);
        String str = new String(bArr, 0, z, r5.d.b);
        int i3 = z + 1;
        int y = y(bArr, i3, H);
        String p = p(bArr, i3, y, w);
        int v = y + v(H);
        int y2 = y(bArr, v, H);
        return new f(str, p, p(bArr, v, y2, w), d(bArr, y2 + v(H), i2));
    }

    public static b m(M m) {
        StringBuilder sb;
        String str;
        boolean z = false;
        if (m.a() < 10) {
            str = "Data too short to be an ID3 tag";
        } else {
            int K = m.K();
            if (K == 4801587) {
                int H = m.H();
                m.V(1);
                int H2 = m.H();
                int G = m.G();
                if (H == 2) {
                    if ((H2 & 64) != 0) {
                        str = "Skipped ID3 tag with majorVersion=2 and undefined compression scheme";
                    }
                } else if (H == 3) {
                    if ((H2 & 64) != 0) {
                        int q = m.q();
                        m.V(q);
                        G -= q + 4;
                    }
                } else if (H == 4) {
                    if ((H2 & 64) != 0) {
                        int G2 = m.G();
                        m.V(G2 - 4);
                        G -= G2;
                    }
                    if ((H2 & 16) != 0) {
                        G -= 10;
                    }
                } else {
                    sb = new StringBuilder();
                    sb.append("Skipped ID3 tag with unsupported majorVersion=");
                    sb.append(H);
                }
                if (H < 4 && (H2 & 128) != 0) {
                    z = true;
                }
                return new b(H, z, G);
            }
            sb = new StringBuilder();
            sb.append("Unexpected first three bytes of ID3 tag header: 0x");
            sb.append(String.format("%06X", new Object[]{Integer.valueOf(K)}));
            str = sb.toString();
        }
        B.j("Id3Decoder", str);
        return null;
    }

    public static k n(M m, int i) {
        int N = m.N();
        int K = m.K();
        int K2 = m.K();
        int H = m.H();
        int H2 = m.H();
        L l = new L();
        l.m(m);
        int i2 = ((i - 10) * 8) / (H + H2);
        int[] iArr = new int[i2];
        int[] iArr2 = new int[i2];
        for (int i3 = 0; i3 < i2; i3++) {
            int h = l.h(H);
            int h2 = l.h(H2);
            iArr[i3] = h;
            iArr2[i3] = h2;
        }
        return new k(N, K, K2, iArr, iArr2);
    }

    public static l o(M m, int i) {
        byte[] bArr = new byte[i];
        m.l(bArr, 0, i);
        int z = z(bArr, 0);
        return new l(new String(bArr, 0, z, r5.d.b), d(bArr, z + 1, i));
    }

    public static String p(byte[] bArr, int i, int i2, Charset charset) {
        return (i2 <= i || i2 > bArr.length) ? "" : new String(bArr, i, i2 - i, charset);
    }

    public static m q(M m, int i, String str) {
        if (i < 1) {
            return null;
        }
        int H = m.H();
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        m.l(bArr, 0, i2);
        return new m(str, null, r(bArr, H, 0));
    }

    public static y r(byte[] bArr, int i, int i2) {
        if (i2 >= bArr.length) {
            return y.A("");
        }
        y.a p = y.p();
        while (true) {
            int y = y(bArr, i2, i);
            if (i2 >= y) {
                break;
            }
            p.a(new String(bArr, i2, y - i2, w(i)));
            i2 = v(i) + y;
        }
        y k = p.k();
        return k.isEmpty() ? y.A("") : k;
    }

    public static m s(M m, int i) {
        if (i < 1) {
            return null;
        }
        int H = m.H();
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        m.l(bArr, 0, i2);
        int y = y(bArr, 0, H);
        return new m("TXXX", new String(bArr, 0, y, w(H)), r(bArr, H, y + v(H)));
    }

    public static n t(M m, int i, String str) {
        byte[] bArr = new byte[i];
        m.l(bArr, 0, i);
        return new n(str, null, new String(bArr, 0, z(bArr, 0), r5.d.b));
    }

    public static n u(M m, int i) {
        if (i < 1) {
            return null;
        }
        int H = m.H();
        int i2 = i - 1;
        byte[] bArr = new byte[i2];
        m.l(bArr, 0, i2);
        int y = y(bArr, 0, H);
        String str = new String(bArr, 0, y, w(H));
        int v = y + v(H);
        return new n("WXXX", str, p(bArr, v, z(bArr, v), r5.d.b));
    }

    public static int v(int i) {
        return (i == 0 || i == 3) ? 1 : 2;
    }

    public static Charset w(int i) {
        return i != 1 ? i != 2 ? i != 3 ? r5.d.b : r5.d.c : r5.d.d : r5.d.f;
    }

    public static String x(int i, int i2, int i3, int i4, int i5) {
        return i == 2 ? String.format(Locale.US, "%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4)}) : String.format(Locale.US, "%c%c%c%c", new Object[]{Integer.valueOf(i2), Integer.valueOf(i3), Integer.valueOf(i4), Integer.valueOf(i5)});
    }

    public static int y(byte[] bArr, int i, int i2) {
        int z = z(bArr, i);
        if (i2 == 0 || i2 == 3) {
            return z;
        }
        while (z < bArr.length - 1) {
            if ((z - i) % 2 == 0 && bArr[z + 1] == 0) {
                return z;
            }
            z = z(bArr, z + 1);
        }
        return bArr.length;
    }

    public static int z(byte[] bArr, int i) {
        while (i < bArr.length) {
            if (bArr[i] == 0) {
                return i;
            }
            i++;
        }
        return bArr.length;
    }

    public q3.a b(q3.e eVar, ByteBuffer byteBuffer) {
        return e(byteBuffer.array(), byteBuffer.limit());
    }

    public q3.a e(byte[] bArr, int i) {
        ArrayList arrayList = new ArrayList();
        M m = new M(bArr, i);
        b m2 = m(m);
        if (m2 == null) {
            return null;
        }
        int f = m.f();
        int i2 = b.a(m2) == 2 ? 6 : 10;
        int b2 = b.b(m2);
        if (b.c(m2)) {
            b2 = B(m, b.b(m2));
        }
        m.T(f + b2);
        boolean z = false;
        if (!C(m, b.a(m2), i2, false)) {
            if (b.a(m2) != 4 || !C(m, 4, i2, true)) {
                B.j("Id3Decoder", "Failed to validate ID3 tag with majorVersion=" + b.a(m2));
                return null;
            }
            z = true;
        }
        while (m.a() >= i2) {
            i k = k(b.a(m2), m, z, i2, this.a);
            if (k != null) {
                arrayList.add(k);
            }
        }
        return new q3.a((List) arrayList);
    }

    public h(a aVar) {
        this.a = aVar;
    }
}
