package com.google.android.exoplayer2.extractor;

import O2.l1;
import android.util.Base64;
import com.google.android.exoplayer2.metadata.flac.PictureFrame;
import d3.y;
import d4.B;
import d4.M;
import d4.k0;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class h {

    public static final class a {
        public final String a;
        public final String[] b;
        public final int c;

        public a(String str, String[] strArr, int i) {
            this.a = str;
            this.b = strArr;
            this.c = i;
        }
    }

    public static final class b {
        public final boolean a;
        public final int b;
        public final int c;
        public final int d;

        public b(boolean z, int i, int i2, int i3) {
            this.a = z;
            this.b = i;
            this.c = i2;
            this.d = i3;
        }
    }

    public static final class c {
        public final int a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;
        public final int h;
        public final boolean i;
        public final byte[] j;

        public c(int i, int i2, int i3, int i4, int i5, int i6, int i7, int i8, boolean z, byte[] bArr) {
            this.a = i;
            this.b = i2;
            this.c = i3;
            this.d = i4;
            this.e = i5;
            this.f = i6;
            this.g = i7;
            this.h = i8;
            this.i = z;
            this.j = bArr;
        }
    }

    public static int a(int i) {
        int i2 = 0;
        while (i > 0) {
            i2++;
            i >>>= 1;
        }
        return i2;
    }

    public static long b(long j, long j2) {
        return (long) Math.floor(Math.pow(j, 1.0d / j2));
    }

    public static q3.a c(List list) {
        ArrayList arrayList = new ArrayList();
        for (int i = 0; i < list.size(); i++) {
            String str = (String) list.get(i);
            String[] j1 = k0.j1(str, "=");
            if (j1.length != 2) {
                B.j("VorbisUtil", "Failed to parse Vorbis comment: " + str);
            } else if (j1[0].equals("METADATA_BLOCK_PICTURE")) {
                try {
                    arrayList.add(PictureFrame.fromPictureBlock(new M(Base64.decode(j1[1], 0))));
                } catch (RuntimeException e) {
                    B.k("VorbisUtil", "Failed to parse vorbis picture", e);
                }
            } else {
                arrayList.add(new y3.a(j1[0], j1[1]));
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new q3.a((List) arrayList);
    }

    public static void d(y yVar) {
        int d = yVar.d(6) + 1;
        for (int i = 0; i < d; i++) {
            int d2 = yVar.d(16);
            if (d2 == 0) {
                yVar.e(8);
                yVar.e(16);
                yVar.e(16);
                yVar.e(6);
                yVar.e(8);
                int d3 = yVar.d(4) + 1;
                for (int i2 = 0; i2 < d3; i2++) {
                    yVar.e(8);
                }
            } else {
                if (d2 != 1) {
                    throw l1.a("floor type greater than 1 not decodable: " + d2, null);
                }
                int d4 = yVar.d(5);
                int[] iArr = new int[d4];
                int i3 = -1;
                for (int i4 = 0; i4 < d4; i4++) {
                    int d5 = yVar.d(4);
                    iArr[i4] = d5;
                    if (d5 > i3) {
                        i3 = d5;
                    }
                }
                int i5 = i3 + 1;
                int[] iArr2 = new int[i5];
                for (int i6 = 0; i6 < i5; i6++) {
                    iArr2[i6] = yVar.d(3) + 1;
                    int d6 = yVar.d(2);
                    if (d6 > 0) {
                        yVar.e(8);
                    }
                    for (int i7 = 0; i7 < (1 << d6); i7++) {
                        yVar.e(8);
                    }
                }
                yVar.e(2);
                int d7 = yVar.d(4);
                int i8 = 0;
                int i9 = 0;
                for (int i10 = 0; i10 < d4; i10++) {
                    i8 += iArr2[iArr[i10]];
                    while (i9 < i8) {
                        yVar.e(d7);
                        i9++;
                    }
                }
            }
        }
    }

    public static void e(int i, y yVar) {
        int d = yVar.d(6) + 1;
        for (int i2 = 0; i2 < d; i2++) {
            int d2 = yVar.d(16);
            if (d2 != 0) {
                B.d("VorbisUtil", "mapping type other than 0 not supported: " + d2);
            } else {
                int d3 = yVar.c() ? yVar.d(4) + 1 : 1;
                if (yVar.c()) {
                    int d4 = yVar.d(8) + 1;
                    for (int i3 = 0; i3 < d4; i3++) {
                        int i4 = i - 1;
                        yVar.e(a(i4));
                        yVar.e(a(i4));
                    }
                }
                if (yVar.d(2) != 0) {
                    throw l1.a("to reserved bits must be zero after mapping coupling steps", null);
                }
                if (d3 > 1) {
                    for (int i5 = 0; i5 < i; i5++) {
                        yVar.e(4);
                    }
                }
                for (int i6 = 0; i6 < d3; i6++) {
                    yVar.e(8);
                    yVar.e(8);
                    yVar.e(8);
                }
            }
        }
    }

    public static b[] f(y yVar) {
        int d = yVar.d(6) + 1;
        b[] bVarArr = new b[d];
        for (int i = 0; i < d; i++) {
            bVarArr[i] = new b(yVar.c(), yVar.d(16), yVar.d(16), yVar.d(8));
        }
        return bVarArr;
    }

    public static void g(y yVar) {
        int d = yVar.d(6) + 1;
        for (int i = 0; i < d; i++) {
            if (yVar.d(16) > 2) {
                throw l1.a("residueType greater than 2 is not decodable", null);
            }
            yVar.e(24);
            yVar.e(24);
            yVar.e(24);
            int d2 = yVar.d(6) + 1;
            yVar.e(8);
            int[] iArr = new int[d2];
            for (int i2 = 0; i2 < d2; i2++) {
                iArr[i2] = ((yVar.c() ? yVar.d(5) : 0) * 8) + yVar.d(3);
            }
            for (int i3 = 0; i3 < d2; i3++) {
                for (int i4 = 0; i4 < 8; i4++) {
                    if ((iArr[i3] & (1 << i4)) != 0) {
                        yVar.e(8);
                    }
                }
            }
        }
    }

    public static a h(M m) {
        return i(m, true, true);
    }

    public static a i(M m, boolean z, boolean z2) {
        if (z) {
            m(3, m, false);
        }
        String E = m.E((int) m.x());
        int length = E.length();
        long x = m.x();
        String[] strArr = new String[(int) x];
        int i = length + 15;
        for (int i2 = 0; i2 < x; i2++) {
            String E2 = m.E((int) m.x());
            strArr[i2] = E2;
            i = i + 4 + E2.length();
        }
        if (z2 && (m.H() & 1) == 0) {
            throw l1.a("framing bit expected to be set", null);
        }
        return new a(E, strArr, i + 1);
    }

    public static c j(M m) {
        m(1, m, false);
        int y = m.y();
        int H = m.H();
        int y2 = m.y();
        int u = m.u();
        if (u <= 0) {
            u = -1;
        }
        int u2 = m.u();
        if (u2 <= 0) {
            u2 = -1;
        }
        int u3 = m.u();
        if (u3 <= 0) {
            u3 = -1;
        }
        int H2 = m.H();
        return new c(y, H, y2, u, u2, u3, (int) Math.pow(2.0d, H2 & 15), (int) Math.pow(2.0d, (H2 & 240) >> 4), (m.H() & 1) > 0, Arrays.copyOf(m.e(), m.g()));
    }

    public static b[] k(M m, int i) {
        m(5, m, false);
        int H = m.H() + 1;
        y yVar = new y(m.e());
        yVar.e(m.f() * 8);
        for (int i2 = 0; i2 < H; i2++) {
            l(yVar);
        }
        int d = yVar.d(6) + 1;
        for (int i3 = 0; i3 < d; i3++) {
            if (yVar.d(16) != 0) {
                throw l1.a("placeholder of time domain transforms not zeroed out", null);
            }
        }
        d(yVar);
        g(yVar);
        e(i, yVar);
        b[] f = f(yVar);
        if (yVar.c()) {
            return f;
        }
        throw l1.a("framing bit after modes not set as expected", null);
    }

    public static void l(y yVar) {
        if (yVar.d(24) != 5653314) {
            throw l1.a("expected code book to start with [0x56, 0x43, 0x42] at " + yVar.b(), null);
        }
        int d = yVar.d(16);
        int d2 = yVar.d(24);
        int i = 0;
        if (yVar.c()) {
            yVar.e(5);
            while (i < d2) {
                i += yVar.d(a(d2 - i));
            }
        } else {
            boolean c2 = yVar.c();
            while (i < d2) {
                if (!c2 || yVar.c()) {
                    yVar.e(5);
                }
                i++;
            }
        }
        int d3 = yVar.d(4);
        if (d3 > 2) {
            throw l1.a("lookup type greater than 2 not decodable: " + d3, null);
        }
        if (d3 == 1 || d3 == 2) {
            yVar.e(32);
            yVar.e(32);
            int d4 = yVar.d(4) + 1;
            yVar.e(1);
            yVar.e((int) ((d3 == 1 ? d != 0 ? b(d2, d) : 0L : d * d2) * d4));
        }
    }

    public static boolean m(int i, M m, boolean z) {
        if (m.a() < 7) {
            if (z) {
                return false;
            }
            throw l1.a("too short header: " + m.a(), null);
        }
        if (m.H() != i) {
            if (z) {
                return false;
            }
            throw l1.a("expected header type " + Integer.toHexString(i), null);
        }
        if (m.H() == 118 && m.H() == 111 && m.H() == 114 && m.H() == 98 && m.H() == 105 && m.H() == 115) {
            return true;
        }
        if (z) {
            return false;
        }
        throw l1.a("expected characters 'vorbis'", null);
    }
}
