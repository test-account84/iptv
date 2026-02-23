package l3;

import O2.l1;
import O2.z0;
import android.util.Pair;
import d4.B;
import d4.F;
import d4.M;
import d4.k0;
import java.nio.ByteBuffer;
import java.nio.ByteOrder;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
import l3.a;
import q3.a;
import s5.y;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class b {
    public static final byte[] a = k0.s0("OpusHead");

    public static final class a {
        public final int a;
        public int b;
        public int c;
        public long d;
        public final boolean e;
        public final M f;
        public final M g;
        public int h;
        public int i;

        public a(M m, M m2, boolean z) {
            this.g = m;
            this.f = m2;
            this.e = z;
            m2.U(12);
            this.a = m2.L();
            m.U(12);
            this.i = m.L();
            d3.l.a(m.q() == 1, "first_chunk must be 1");
            this.b = -1;
        }

        public boolean a() {
            int i = this.b + 1;
            this.b = i;
            if (i == this.a) {
                return false;
            }
            this.d = this.e ? this.f.M() : this.f.J();
            if (this.b == this.h) {
                this.c = this.g.L();
                this.g.V(4);
                int i2 = this.i - 1;
                this.i = i2;
                this.h = i2 > 0 ? this.g.L() - 1 : -1;
            }
            return true;
        }
    }

    public static final class b {
        public final String a;
        public final byte[] b;
        public final long c;
        public final long d;

        public b(String str, byte[] bArr, long j, long j2) {
            this.a = str;
            this.b = bArr;
            this.c = j;
            this.d = j2;
        }

        public static /* synthetic */ String a(b bVar) {
            return bVar.a;
        }

        public static /* synthetic */ byte[] b(b bVar) {
            return bVar.b;
        }

        public static /* synthetic */ long c(b bVar) {
            return bVar.d;
        }

        public static /* synthetic */ long d(b bVar) {
            return bVar.c;
        }
    }

    public static final class c {
        public final q3.a a;
        public final long b;

        public c(q3.a aVar, long j) {
            this.a = aVar;
            this.b = j;
        }
    }

    public interface d {
        int a();

        int b();

        int c();
    }

    public static final class e {
        public final p[] a;
        public z0 b;
        public int c;
        public int d = 0;

        public e(int i) {
            this.a = new p[i];
        }
    }

    public static final class f implements d {
        public final int a;
        public final int b;
        public final M c;

        public f(a.b bVar, z0 z0Var) {
            M m = bVar.b;
            this.c = m;
            m.U(12);
            int L = m.L();
            if ("audio/raw".equals(z0Var.m)) {
                int j0 = k0.j0(z0Var.B, z0Var.z);
                if (L == 0 || L % j0 != 0) {
                    B.j("AtomParsers", "Audio sample size mismatch. stsd sample size: " + j0 + ", stsz sample size: " + L);
                    L = j0;
                }
            }
            this.a = L == 0 ? -1 : L;
            this.b = m.L();
        }

        public int a() {
            int i = this.a;
            return i == -1 ? this.c.L() : i;
        }

        public int b() {
            return this.a;
        }

        public int c() {
            return this.b;
        }
    }

    public static final class g implements d {
        public final M a;
        public final int b;
        public final int c;
        public int d;
        public int e;

        public g(a.b bVar) {
            M m = bVar.b;
            this.a = m;
            m.U(12);
            this.c = m.L() & 255;
            this.b = m.L();
        }

        public int a() {
            int i = this.c;
            if (i == 8) {
                return this.a.H();
            }
            if (i == 16) {
                return this.a.N();
            }
            int i2 = this.d;
            this.d = i2 + 1;
            if (i2 % 2 != 0) {
                return this.e & 15;
            }
            int H = this.a.H();
            this.e = H;
            return (H & 240) >> 4;
        }

        public int b() {
            return -1;
        }

        public int c() {
            return this.b;
        }
    }

    public static final class h {
        public final int a;
        public final long b;
        public final int c;

        public h(int i, long j, int i2) {
            this.a = i;
            this.b = j;
            this.c = i2;
        }

        public static /* synthetic */ long a(h hVar) {
            return hVar.b;
        }

        public static /* synthetic */ int b(h hVar) {
            return hVar.a;
        }

        public static /* synthetic */ int c(h hVar) {
            return hVar.c;
        }
    }

    public static final class i {
        public final q3.a a;
        public final q3.a b;
        public final q3.a c;

        public i(q3.a aVar, q3.a aVar2, q3.a aVar3) {
            this.a = aVar;
            this.b = aVar2;
            this.c = aVar3;
        }
    }

    public static List A(a.a aVar, d3.r rVar, long j, V2.m mVar, boolean z, boolean z2, r5.f fVar) {
        o oVar;
        ArrayList arrayList = new ArrayList();
        for (int i2 = 0; i2 < aVar.d.size(); i2++) {
            a.a aVar2 = (a.a) aVar.d.get(i2);
            if (aVar2.a == 1953653099 && (oVar = (o) fVar.apply(z(aVar2, (a.b) d4.a.e(aVar.g(1836476516)), j, mVar, z, z2))) != null) {
                arrayList.add(v(oVar, (a.a) d4.a.e(((a.a) d4.a.e(((a.a) d4.a.e(aVar2.f(1835297121))).f(1835626086))).f(1937007212)), rVar));
            }
        }
        return arrayList;
    }

    public static i B(a.b bVar) {
        M m = bVar.b;
        m.U(8);
        q3.a aVar = null;
        q3.a aVar2 = null;
        q3.a aVar3 = null;
        while (m.a() >= 8) {
            int f2 = m.f();
            int q = m.q();
            int q2 = m.q();
            if (q2 == 1835365473) {
                m.U(f2);
                aVar = C(m, f2 + q);
            } else if (q2 == 1936553057) {
                m.U(f2);
                aVar2 = u(m, f2 + q);
            } else if (q2 == -1451722374) {
                aVar3 = E(m);
            }
            m.U(f2 + q);
        }
        return new i(aVar, aVar2, aVar3);
    }

    public static q3.a C(M m, int i2) {
        m.V(8);
        e(m);
        while (m.f() < i2) {
            int f2 = m.f();
            int q = m.q();
            if (m.q() == 1768715124) {
                m.U(f2);
                return l(m, f2 + q);
            }
            m.U(f2 + q);
        }
        return null;
    }

    public static void D(M m, int i2, int i3, int i4, int i5, int i6, V2.m mVar, e eVar, int i7) {
        String str;
        V2.m mVar2;
        int i8;
        int i9;
        float f2;
        List list;
        int i10;
        int i11;
        String str2;
        int i12;
        int i13;
        int i14;
        String str3;
        int i15 = i3;
        int i16 = i4;
        V2.m mVar3 = mVar;
        e eVar2 = eVar;
        m.U(i15 + 16);
        m.V(16);
        int N = m.N();
        int N2 = m.N();
        m.V(50);
        int f3 = m.f();
        int i17 = i2;
        if (i17 == 1701733238) {
            Pair s = s(m, i15, i16);
            if (s != null) {
                i17 = ((Integer) s.first).intValue();
                mVar3 = mVar3 == null ? null : mVar3.d(((p) s.second).b);
                eVar2.a[i7] = (p) s.second;
            }
            m.U(f3);
        }
        String str4 = "video/3gpp";
        String str5 = i17 == 1831958048 ? "video/mpeg" : i17 == 1211250227 ? "video/3gpp" : null;
        float f4 = 1.0f;
        String str6 = null;
        List list2 = null;
        byte[] bArr = null;
        int i18 = -1;
        int i19 = -1;
        int i20 = -1;
        int i21 = -1;
        ByteBuffer byteBuffer = null;
        b bVar = null;
        boolean z = false;
        while (f3 - i15 < i16) {
            m.U(f3);
            int f5 = m.f();
            int q = m.q();
            if (q == 0) {
                str = str4;
                if (m.f() - i15 == i16) {
                    break;
                }
            } else {
                str = str4;
            }
            d3.l.a(q > 0, "childAtomSize must be positive");
            int q2 = m.q();
            if (q2 == 1635148611) {
                d3.l.a(str5 == null, null);
                m.U(f5 + 8);
                e4.a b2 = e4.a.b(m);
                list2 = b2.a;
                eVar2.c = b2.b;
                if (!z) {
                    f4 = b2.h;
                }
                str6 = b2.i;
                i12 = b2.e;
                i13 = b2.f;
                i14 = b2.g;
                str3 = "video/avc";
            } else if (q2 == 1752589123) {
                d3.l.a(str5 == null, null);
                m.U(f5 + 8);
                e4.g a2 = e4.g.a(m);
                list2 = a2.a;
                eVar2.c = a2.b;
                if (!z) {
                    f4 = a2.h;
                }
                str6 = a2.i;
                i12 = a2.e;
                i13 = a2.f;
                i14 = a2.g;
                str3 = "video/hevc";
            } else {
                if (q2 == 1685480259 || q2 == 1685485123) {
                    mVar2 = mVar3;
                    i8 = N2;
                    i9 = i17;
                    f2 = f4;
                    list = list2;
                    i10 = i19;
                    i11 = i21;
                    e4.e a3 = e4.e.a(m);
                    if (a3 != null) {
                        str6 = a3.c;
                        str5 = "video/dolby-vision";
                    }
                } else {
                    if (q2 == 1987076931) {
                        d3.l.a(str5 == null, null);
                        str2 = i17 == 1987063864 ? "video/x-vnd.on2.vp8" : "video/x-vnd.on2.vp9";
                        m.U(f5 + 12);
                        m.V(2);
                        boolean z2 = (m.H() & 1) != 0;
                        int H = m.H();
                        int H2 = m.H();
                        i19 = e4.c.i(H);
                        i20 = z2 ? 1 : 2;
                        i21 = e4.c.j(H2);
                    } else if (q2 == 1635135811) {
                        d3.l.a(str5 == null, null);
                        str2 = "video/av01";
                    } else if (q2 == 1668050025) {
                        if (byteBuffer == null) {
                            byteBuffer = a();
                        }
                        ByteBuffer byteBuffer2 = byteBuffer;
                        byteBuffer2.position(21);
                        byteBuffer2.putShort(m.D());
                        byteBuffer2.putShort(m.D());
                        byteBuffer = byteBuffer2;
                        mVar2 = mVar3;
                        i8 = N2;
                        i9 = i17;
                        f3 += q;
                        i15 = i3;
                        i16 = i4;
                        eVar2 = eVar;
                        str4 = str;
                        i17 = i9;
                        mVar3 = mVar2;
                        N2 = i8;
                    } else if (q2 == 1835295606) {
                        if (byteBuffer == null) {
                            byteBuffer = a();
                        }
                        ByteBuffer byteBuffer3 = byteBuffer;
                        short D = m.D();
                        short D2 = m.D();
                        short D3 = m.D();
                        i9 = i17;
                        short D4 = m.D();
                        short D5 = m.D();
                        mVar2 = mVar3;
                        short D6 = m.D();
                        List list3 = list2;
                        short D7 = m.D();
                        float f6 = f4;
                        short D8 = m.D();
                        long J = m.J();
                        long J2 = m.J();
                        i8 = N2;
                        byteBuffer3.position(1);
                        byteBuffer3.putShort(D5);
                        byteBuffer3.putShort(D6);
                        byteBuffer3.putShort(D);
                        byteBuffer3.putShort(D2);
                        byteBuffer3.putShort(D3);
                        byteBuffer3.putShort(D4);
                        byteBuffer3.putShort(D7);
                        byteBuffer3.putShort(D8);
                        byteBuffer3.putShort((short) (J / 10000));
                        byteBuffer3.putShort((short) (J2 / 10000));
                        byteBuffer = byteBuffer3;
                        list2 = list3;
                        f4 = f6;
                        f3 += q;
                        i15 = i3;
                        i16 = i4;
                        eVar2 = eVar;
                        str4 = str;
                        i17 = i9;
                        mVar3 = mVar2;
                        N2 = i8;
                    } else {
                        mVar2 = mVar3;
                        i8 = N2;
                        i9 = i17;
                        f2 = f4;
                        list = list2;
                        if (q2 == 1681012275) {
                            d3.l.a(str5 == null, null);
                            str5 = str;
                        } else if (q2 == 1702061171) {
                            d3.l.a(str5 == null, null);
                            bVar = i(m, f5);
                            String a4 = b.a(bVar);
                            byte[] b3 = b.b(bVar);
                            list2 = b3 != null ? y.A(b3) : list;
                            str5 = a4;
                            f4 = f2;
                            f3 += q;
                            i15 = i3;
                            i16 = i4;
                            eVar2 = eVar;
                            str4 = str;
                            i17 = i9;
                            mVar3 = mVar2;
                            N2 = i8;
                        } else if (q2 == 1885434736) {
                            f4 = q(m, f5);
                            list2 = list;
                            z = true;
                            f3 += q;
                            i15 = i3;
                            i16 = i4;
                            eVar2 = eVar;
                            str4 = str;
                            i17 = i9;
                            mVar3 = mVar2;
                            N2 = i8;
                        } else if (q2 == 1937126244) {
                            bArr = r(m, f5, q);
                        } else if (q2 == 1936995172) {
                            int H3 = m.H();
                            m.V(3);
                            if (H3 == 0) {
                                int H4 = m.H();
                                if (H4 == 0) {
                                    i18 = 0;
                                } else if (H4 == 1) {
                                    i18 = 1;
                                } else if (H4 == 2) {
                                    i18 = 2;
                                } else if (H4 == 3) {
                                    i18 = 3;
                                }
                            }
                        } else {
                            i10 = i19;
                            if (q2 == 1668246642) {
                                i11 = i21;
                                if (i10 == -1 && i11 == -1) {
                                    int q3 = m.q();
                                    if (q3 == 1852009592 || q3 == 1852009571) {
                                        int N3 = m.N();
                                        int N4 = m.N();
                                        m.V(2);
                                        boolean z3 = q == 19 && (m.H() & 128) != 0;
                                        i19 = e4.c.i(N3);
                                        i20 = z3 ? 1 : 2;
                                        i21 = e4.c.j(N4);
                                    } else {
                                        B.j("AtomParsers", "Unsupported color type: " + l3.a.a(q3));
                                    }
                                }
                                f3 += q;
                                i15 = i3;
                                i16 = i4;
                                eVar2 = eVar;
                                str4 = str;
                                i17 = i9;
                                mVar3 = mVar2;
                                N2 = i8;
                            } else {
                                i11 = i21;
                            }
                        }
                        list2 = list;
                        f4 = f2;
                        f3 += q;
                        i15 = i3;
                        i16 = i4;
                        eVar2 = eVar;
                        str4 = str;
                        i17 = i9;
                        mVar3 = mVar2;
                        N2 = i8;
                    }
                    str5 = str2;
                    mVar2 = mVar3;
                    i8 = N2;
                    i9 = i17;
                    f3 += q;
                    i15 = i3;
                    i16 = i4;
                    eVar2 = eVar;
                    str4 = str;
                    i17 = i9;
                    mVar3 = mVar2;
                    N2 = i8;
                }
                i21 = i11;
                i19 = i10;
                list2 = list;
                f4 = f2;
                f3 += q;
                i15 = i3;
                i16 = i4;
                eVar2 = eVar;
                str4 = str;
                i17 = i9;
                mVar3 = mVar2;
                N2 = i8;
            }
            i21 = i14;
            mVar2 = mVar3;
            i8 = N2;
            i19 = i12;
            i9 = i17;
            i20 = i13;
            str5 = str3;
            f3 += q;
            i15 = i3;
            i16 = i4;
            eVar2 = eVar;
            str4 = str;
            i17 = i9;
            mVar3 = mVar2;
            N2 = i8;
        }
        V2.m mVar4 = mVar3;
        int i22 = N2;
        float f7 = f4;
        List list4 = list2;
        int i23 = i19;
        int i24 = i21;
        if (str5 == null) {
            return;
        }
        z0.b O = new z0.b().T(i5).g0(str5).K(str6).n0(N).S(i22).c0(f7).f0(i6).d0(bArr).j0(i18).V(list4).O(mVar4);
        int i25 = i20;
        if (i23 != -1 || i25 != -1 || i24 != -1 || byteBuffer != null) {
            O.L(new e4.c(i23, i25, i24, byteBuffer != null ? byteBuffer.array() : null));
        }
        if (bVar != null) {
            O.I(w5.f.k(b.d(bVar))).b0(w5.f.k(b.c(bVar)));
        }
        eVar.b = O.G();
    }

    public static q3.a E(M m) {
        short D = m.D();
        m.V(2);
        String E = m.E(D);
        int max = Math.max(E.lastIndexOf(43), E.lastIndexOf(45));
        try {
            return new q3.a(new R2.b(Float.parseFloat(E.substring(0, max)), Float.parseFloat(E.substring(max, E.length() - 1))));
        } catch (IndexOutOfBoundsException | NumberFormatException unused) {
            return null;
        }
    }

    public static ByteBuffer a() {
        return ByteBuffer.allocate(25).order(ByteOrder.LITTLE_ENDIAN);
    }

    public static boolean b(long[] jArr, long j, long j2, long j3) {
        int length = jArr.length - 1;
        return jArr[0] <= j2 && j2 < jArr[k0.r(4, 0, length)] && jArr[k0.r(jArr.length - 4, 0, length)] < j3 && j3 <= j;
    }

    public static int c(M m, int i2, int i3, int i4) {
        int f2 = m.f();
        d3.l.a(f2 >= i3, null);
        while (f2 - i3 < i4) {
            m.U(f2);
            int q = m.q();
            d3.l.a(q > 0, "childAtomSize must be positive");
            if (m.q() == i2) {
                return f2;
            }
            f2 += q;
        }
        return -1;
    }

    public static int d(int i2) {
        if (i2 == 1936684398) {
            return 1;
        }
        if (i2 == 1986618469) {
            return 2;
        }
        if (i2 == 1952807028 || i2 == 1935832172 || i2 == 1937072756 || i2 == 1668047728) {
            return 3;
        }
        return i2 == 1835365473 ? 5 : -1;
    }

    public static void e(M m) {
        int f2 = m.f();
        m.V(4);
        if (m.q() != 1751411826) {
            f2 += 4;
        }
        m.U(f2);
    }

    /* JADX WARN: Removed duplicated region for block: B:26:0x0166  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static void f(d4.M r22, int r23, int r24, int r25, int r26, java.lang.String r27, boolean r28, V2.m r29, l3.b.e r30, int r31) {
        /*
            Method dump skipped, instructions count: 873
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.b.f(d4.M, int, int, int, int, java.lang.String, boolean, V2.m, l3.b$e, int):void");
    }

    public static Pair g(M m, int i2, int i3) {
        int i4 = i2 + 8;
        String str = null;
        Integer num = null;
        int i5 = -1;
        int i6 = 0;
        while (i4 - i2 < i3) {
            m.U(i4);
            int q = m.q();
            int q2 = m.q();
            if (q2 == 1718775137) {
                num = Integer.valueOf(m.q());
            } else if (q2 == 1935894637) {
                m.V(4);
                str = m.E(4);
            } else if (q2 == 1935894633) {
                i5 = i4;
                i6 = q;
            }
            i4 += q;
        }
        if (!"cenc".equals(str) && !"cbc1".equals(str) && !"cens".equals(str) && !"cbcs".equals(str)) {
            return null;
        }
        d3.l.a(num != null, "frma atom is mandatory");
        d3.l.a(i5 != -1, "schi atom is mandatory");
        p t = t(m, i5, i6, str);
        d3.l.a(t != null, "tenc atom is mandatory");
        return Pair.create(num, (p) k0.j(t));
    }

    public static Pair h(a.a aVar) {
        a.b g2 = aVar.g(1701606260);
        if (g2 == null) {
            return null;
        }
        M m = g2.b;
        m.U(8);
        int c2 = l3.a.c(m.q());
        int L = m.L();
        long[] jArr = new long[L];
        long[] jArr2 = new long[L];
        for (int i2 = 0; i2 < L; i2++) {
            jArr[i2] = c2 == 1 ? m.M() : m.J();
            jArr2[i2] = c2 == 1 ? m.A() : m.q();
            if (m.D() != 1) {
                throw new IllegalArgumentException("Unsupported media rate.");
            }
            m.V(2);
        }
        return Pair.create(jArr, jArr2);
    }

    public static b i(M m, int i2) {
        m.U(i2 + 12);
        m.V(1);
        j(m);
        m.V(2);
        int H = m.H();
        if ((H & 128) != 0) {
            m.V(2);
        }
        if ((H & 64) != 0) {
            m.V(m.H());
        }
        if ((H & 32) != 0) {
            m.V(2);
        }
        m.V(1);
        j(m);
        String h2 = F.h(m.H());
        if ("audio/mpeg".equals(h2) || "audio/vnd.dts".equals(h2) || "audio/vnd.dts.hd".equals(h2)) {
            return new b(h2, null, -1L, -1L);
        }
        m.V(4);
        long J = m.J();
        long J2 = m.J();
        m.V(1);
        int j = j(m);
        byte[] bArr = new byte[j];
        m.l(bArr, 0, j);
        return new b(h2, bArr, J2 > 0 ? J2 : -1L, J > 0 ? J : -1L);
    }

    public static int j(M m) {
        int H = m.H();
        int i2 = H & 127;
        while ((H & 128) == 128) {
            H = m.H();
            i2 = (i2 << 7) | (H & 127);
        }
        return i2;
    }

    public static int k(M m) {
        m.U(16);
        return m.q();
    }

    public static q3.a l(M m, int i2) {
        m.V(8);
        ArrayList arrayList = new ArrayList();
        while (m.f() < i2) {
            a.b c2 = l3.h.c(m);
            if (c2 != null) {
                arrayList.add(c2);
            }
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new q3.a((List) arrayList);
    }

    public static Pair m(M m) {
        m.U(8);
        int c2 = l3.a.c(m.q());
        m.V(c2 == 0 ? 8 : 16);
        long J = m.J();
        m.V(c2 == 0 ? 4 : 8);
        int N = m.N();
        return Pair.create(Long.valueOf(J), "" + ((char) (((N >> 10) & 31) + 96)) + ((char) (((N >> 5) & 31) + 96)) + ((char) ((N & 31) + 96)));
    }

    public static q3.a n(a.a aVar) {
        a.b g2 = aVar.g(1751411826);
        a.b g3 = aVar.g(1801812339);
        a.b g4 = aVar.g(1768715124);
        if (g2 == null || g3 == null || g4 == null || k(g2.b) != 1835299937) {
            return null;
        }
        M m = g3.b;
        m.U(12);
        int q = m.q();
        String[] strArr = new String[q];
        for (int i2 = 0; i2 < q; i2++) {
            int q2 = m.q();
            m.V(4);
            strArr[i2] = m.E(q2 - 8);
        }
        M m2 = g4.b;
        m2.U(8);
        ArrayList arrayList = new ArrayList();
        while (m2.a() > 8) {
            int f2 = m2.f();
            int q3 = m2.q();
            int q4 = m2.q() - 1;
            if (q4 < 0 || q4 >= q) {
                B.j("AtomParsers", "Skipped metadata with unknown key index: " + q4);
            } else {
                w3.a f3 = l3.h.f(m2, f2 + q3, strArr[q4]);
                if (f3 != null) {
                    arrayList.add(f3);
                }
            }
            m2.U(f2 + q3);
        }
        if (arrayList.isEmpty()) {
            return null;
        }
        return new q3.a((List) arrayList);
    }

    public static void o(M m, int i2, int i3, int i4, e eVar) {
        m.U(i3 + 16);
        if (i2 == 1835365492) {
            m.B();
            String B = m.B();
            if (B != null) {
                eVar.b = new z0.b().T(i4).g0(B).G();
            }
        }
    }

    public static c p(M m) {
        long j;
        m.U(8);
        if (l3.a.c(m.q()) == 0) {
            j = m.J();
            m.V(4);
        } else {
            long A = m.A();
            m.V(8);
            j = A;
        }
        return new c(new q3.a(new R2.a((j - 2082844800) * 1000)), m.J());
    }

    public static float q(M m, int i2) {
        m.U(i2 + 8);
        return m.L() / m.L();
    }

    public static byte[] r(M m, int i2, int i3) {
        int i4 = i2 + 8;
        while (i4 - i2 < i3) {
            m.U(i4);
            int q = m.q();
            if (m.q() == 1886547818) {
                return Arrays.copyOfRange(m.e(), i4, q + i4);
            }
            i4 += q;
        }
        return null;
    }

    public static Pair s(M m, int i2, int i3) {
        Pair g2;
        int f2 = m.f();
        while (f2 - i2 < i3) {
            m.U(f2);
            int q = m.q();
            d3.l.a(q > 0, "childAtomSize must be positive");
            if (m.q() == 1936289382 && (g2 = g(m, f2, q)) != null) {
                return g2;
            }
            f2 += q;
        }
        return null;
    }

    public static p t(M m, int i2, int i3, String str) {
        int i4;
        int i5;
        int i6 = i2 + 8;
        while (true) {
            byte[] bArr = null;
            if (i6 - i2 >= i3) {
                return null;
            }
            m.U(i6);
            int q = m.q();
            if (m.q() == 1952804451) {
                int c2 = l3.a.c(m.q());
                m.V(1);
                if (c2 == 0) {
                    m.V(1);
                    i5 = 0;
                    i4 = 0;
                } else {
                    int H = m.H();
                    i4 = H & 15;
                    i5 = (H & 240) >> 4;
                }
                boolean z = m.H() == 1;
                int H2 = m.H();
                byte[] bArr2 = new byte[16];
                m.l(bArr2, 0, 16);
                if (z && H2 == 0) {
                    int H3 = m.H();
                    bArr = new byte[H3];
                    m.l(bArr, 0, H3);
                }
                return new p(z, str, H2, bArr2, i5, i4, bArr);
            }
            i6 += q;
        }
    }

    public static q3.a u(M m, int i2) {
        m.V(12);
        while (m.f() < i2) {
            int f2 = m.f();
            int q = m.q();
            if (m.q() == 1935766900) {
                if (q < 14) {
                    return null;
                }
                m.V(5);
                int H = m.H();
                if (H != 12 && H != 13) {
                    return null;
                }
                float f3 = H == 12 ? 240.0f : 120.0f;
                m.V(1);
                return new q3.a(new w3.e(f3, m.H()));
            }
            m.U(f2 + q);
        }
        return null;
    }

    /* JADX WARN: Removed duplicated region for block: B:100:0x0433  */
    /* JADX WARN: Removed duplicated region for block: B:103:0x0438  */
    /* JADX WARN: Removed duplicated region for block: B:105:0x043e  */
    /* JADX WARN: Removed duplicated region for block: B:107:0x0444  */
    /* JADX WARN: Removed duplicated region for block: B:109:0x044a  */
    /* JADX WARN: Removed duplicated region for block: B:113:0x045c  */
    /* JADX WARN: Removed duplicated region for block: B:134:0x044d  */
    /* JADX WARN: Removed duplicated region for block: B:135:0x0446  */
    /* JADX WARN: Removed duplicated region for block: B:136:0x0441  */
    /* JADX WARN: Removed duplicated region for block: B:137:0x043b  */
    /* JADX WARN: Removed duplicated region for block: B:138:0x03b4  */
    /* JADX WARN: Removed duplicated region for block: B:147:0x0132  */
    /* JADX WARN: Removed duplicated region for block: B:205:0x0288  */
    /* JADX WARN: Removed duplicated region for block: B:207:0x028b  */
    /* JADX WARN: Removed duplicated region for block: B:208:0x0247  */
    /* JADX WARN: Removed duplicated region for block: B:214:0x00fb  */
    /* JADX WARN: Removed duplicated region for block: B:39:0x0100  */
    /* JADX WARN: Removed duplicated region for block: B:47:0x02af  */
    /* JADX WARN: Removed duplicated region for block: B:49:0x02bf  */
    /* JADX WARN: Removed duplicated region for block: B:74:0x03b2  */
    /* JADX WARN: Removed duplicated region for block: B:78:0x03cc  */
    /* JADX WARN: Removed duplicated region for block: B:97:0x0428 A[EDGE_INSN: B:97:0x0428->B:98:0x0428 BREAK  A[LOOP:2: B:76:0x03c7->B:92:0x0421], SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static l3.r v(l3.o r38, l3.a.a r39, d3.r r40) {
        /*
            Method dump skipped, instructions count: 1310
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: l3.b.v(l3.o, l3.a$a, d3.r):l3.r");
    }

    public static e w(M m, int i2, int i3, String str, V2.m mVar, boolean z) {
        int i4;
        m.U(12);
        int q = m.q();
        e eVar = new e(q);
        for (int i5 = 0; i5 < q; i5++) {
            int f2 = m.f();
            int q2 = m.q();
            d3.l.a(q2 > 0, "childAtomSize must be positive");
            int q3 = m.q();
            if (q3 == 1635148593 || q3 == 1635148595 || q3 == 1701733238 || q3 == 1831958048 || q3 == 1836070006 || q3 == 1752589105 || q3 == 1751479857 || q3 == 1932670515 || q3 == 1211250227 || q3 == 1987063864 || q3 == 1987063865 || q3 == 1635135537 || q3 == 1685479798 || q3 == 1685479729 || q3 == 1685481573 || q3 == 1685481521) {
                i4 = f2;
                D(m, q3, i4, q2, i2, i3, mVar, eVar, i5);
            } else if (q3 == 1836069985 || q3 == 1701733217 || q3 == 1633889587 || q3 == 1700998451 || q3 == 1633889588 || q3 == 1835823201 || q3 == 1685353315 || q3 == 1685353317 || q3 == 1685353320 || q3 == 1685353324 || q3 == 1685353336 || q3 == 1935764850 || q3 == 1935767394 || q3 == 1819304813 || q3 == 1936684916 || q3 == 1953984371 || q3 == 778924082 || q3 == 778924083 || q3 == 1835557169 || q3 == 1835560241 || q3 == 1634492771 || q3 == 1634492791 || q3 == 1970037111 || q3 == 1332770163 || q3 == 1716281667) {
                i4 = f2;
                f(m, q3, f2, q2, i2, str, z, mVar, eVar, i5);
            } else {
                if (q3 == 1414810956 || q3 == 1954034535 || q3 == 2004251764 || q3 == 1937010800 || q3 == 1664495672) {
                    x(m, q3, f2, q2, i2, str, eVar);
                } else if (q3 == 1835365492) {
                    o(m, q3, f2, i2, eVar);
                } else if (q3 == 1667329389) {
                    eVar.b = new z0.b().T(i2).g0("application/x-camera-motion").G();
                }
                i4 = f2;
            }
            m.U(i4 + q2);
        }
        return eVar;
    }

    public static void x(M m, int i2, int i3, int i4, int i5, String str, e eVar) {
        m.U(i3 + 16);
        String str2 = "application/ttml+xml";
        y yVar = null;
        long j = Long.MAX_VALUE;
        if (i2 != 1414810956) {
            if (i2 == 1954034535) {
                int i6 = i4 - 16;
                byte[] bArr = new byte[i6];
                m.l(bArr, 0, i6);
                yVar = y.A(bArr);
                str2 = "application/x-quicktime-tx3g";
            } else if (i2 == 2004251764) {
                str2 = "application/x-mp4-vtt";
            } else if (i2 == 1937010800) {
                j = 0;
            } else {
                if (i2 != 1664495672) {
                    throw new IllegalStateException();
                }
                eVar.d = 1;
                str2 = "application/x-mp4-cea-608";
            }
        }
        eVar.b = new z0.b().T(i5).g0(str2).X(str).k0(j).V(yVar).G();
    }

    public static h y(M m) {
        long j;
        m.U(8);
        int c2 = l3.a.c(m.q());
        m.V(c2 == 0 ? 8 : 16);
        int q = m.q();
        m.V(4);
        int f2 = m.f();
        int i2 = c2 == 0 ? 4 : 8;
        int i3 = 0;
        int i4 = 0;
        while (true) {
            j = -9223372036854775807L;
            if (i4 >= i2) {
                m.V(i2);
                break;
            }
            if (m.e()[f2 + i4] != -1) {
                long J = c2 == 0 ? m.J() : m.M();
                if (J != 0) {
                    j = J;
                }
            } else {
                i4++;
            }
        }
        m.V(16);
        int q2 = m.q();
        int q3 = m.q();
        m.V(4);
        int q4 = m.q();
        int q5 = m.q();
        if (q2 == 0 && q3 == 65536 && q4 == -65536 && q5 == 0) {
            i3 = 90;
        } else if (q2 == 0 && q3 == -65536 && q4 == 65536 && q5 == 0) {
            i3 = 270;
        } else if (q2 == -65536 && q3 == 0 && q4 == 0 && q5 == -65536) {
            i3 = 180;
        }
        return new h(q, j, i3);
    }

    public static o z(a.a aVar, a.b bVar, long j, V2.m mVar, boolean z, boolean z2) {
        a.b bVar2;
        long j2;
        long[] jArr;
        long[] jArr2;
        a.a f2;
        Pair h2;
        a.a aVar2 = (a.a) d4.a.e(aVar.f(1835297121));
        int d2 = d(k(((a.b) d4.a.e(aVar2.g(1751411826))).b));
        if (d2 == -1) {
            return null;
        }
        h y = y(((a.b) d4.a.e(aVar.g(1953196132))).b);
        if (j == -9223372036854775807L) {
            bVar2 = bVar;
            j2 = h.a(y);
        } else {
            bVar2 = bVar;
            j2 = j;
        }
        long j3 = p(bVar2.b).b;
        long c1 = j2 != -9223372036854775807L ? k0.c1(j2, 1000000L, j3) : -9223372036854775807L;
        a.a aVar3 = (a.a) d4.a.e(((a.a) d4.a.e(aVar2.f(1835626086))).f(1937007212));
        Pair m = m(((a.b) d4.a.e(aVar2.g(1835296868))).b);
        a.b g2 = aVar3.g(1937011556);
        if (g2 == null) {
            throw l1.a("Malformed sample table (stbl) missing sample description (stsd)", null);
        }
        e w = w(g2.b, h.b(y), h.c(y), (String) m.second, mVar, z2);
        if (z || (f2 = aVar.f(1701082227)) == null || (h2 = h(f2)) == null) {
            jArr = null;
            jArr2 = null;
        } else {
            long[] jArr3 = (long[]) h2.first;
            jArr2 = (long[]) h2.second;
            jArr = jArr3;
        }
        if (w.b == null) {
            return null;
        }
        return new o(h.b(y), d2, ((Long) m.first).longValue(), j3, c1, w.b, w.d, w.a, w.c, jArr, jArr2);
    }
}
