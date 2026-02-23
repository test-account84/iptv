package Q2;

import O2.z0;
import java.nio.ByteBuffer;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class b {
    public static final int[] a = {1, 2, 3, 6};
    public static final int[] b = {48000, 44100, 32000};
    public static final int[] c = {24000, 22050, 16000};
    public static final int[] d = {2, 1, 2, 3, 3, 4, 4, 5};
    public static final int[] e = {32, 40, 48, 56, 64, 80, 96, 112, 128, 160, 192, 224, 256, 320, 384, 448, 512, 576, 640};
    public static final int[] f = {69, 87, 104, 121, 139, 174, 208, 243, 278, 348, 417, 487, 557, 696, 835, 975, 1114, 1253, 1393};

    public static final class b {
        public final String a;
        public final int b;
        public final int c;
        public final int d;
        public final int e;
        public final int f;
        public final int g;

        public b(String str, int i, int i2, int i3, int i4, int i5, int i6) {
            this.a = str;
            this.b = i;
            this.d = i2;
            this.c = i3;
            this.e = i4;
            this.f = i5;
            this.g = i6;
        }

        public /* synthetic */ b(String str, int i, int i2, int i3, int i4, int i5, int i6, a aVar) {
            this(str, i, i2, i3, i4, i5, i6);
        }
    }

    public static int a(int i, int i2, int i3) {
        return (i * i2) / (i3 * 32);
    }

    public static int b(ByteBuffer byteBuffer) {
        int position = byteBuffer.position();
        int limit = byteBuffer.limit() - 10;
        for (int i = position; i <= limit; i++) {
            if ((d4.k0.K(byteBuffer, i + 4) & (-2)) == -126718022) {
                return i - position;
            }
        }
        return -1;
    }

    public static int c(int i, int i2) {
        int i3 = i2 / 2;
        if (i < 0) {
            return -1;
        }
        int[] iArr = b;
        if (i >= iArr.length || i2 < 0) {
            return -1;
        }
        int[] iArr2 = f;
        if (i3 >= iArr2.length) {
            return -1;
        }
        int i4 = iArr[i];
        if (i4 == 44100) {
            return (iArr2[i3] + (i2 % 2)) * 2;
        }
        int i5 = e[i3];
        return i4 == 32000 ? i5 * 6 : i5 * 4;
    }

    public static z0 d(d4.M m, String str, String str2, V2.m mVar) {
        d4.L l = new d4.L();
        l.m(m);
        int i = b[l.h(2)];
        l.r(8);
        int i2 = d[l.h(3)];
        if (l.h(1) != 0) {
            i2++;
        }
        int i3 = e[l.h(5)] * 1000;
        l.c();
        m.U(l.d());
        return new z0.b().U(str).g0("audio/ac3").J(i2).h0(i).O(mVar).X(str2).I(i3).b0(i3).G();
    }

    public static int e(ByteBuffer byteBuffer) {
        if (((byteBuffer.get(byteBuffer.position() + 5) & 248) >> 3) > 10) {
            return a[((byteBuffer.get(byteBuffer.position() + 4) & 192) >> 6) != 3 ? (byteBuffer.get(byteBuffer.position() + 4) & 48) >> 4 : 3] * 256;
        }
        return 1536;
    }

    public static b f(d4.L l) {
        String str;
        int i;
        int i2;
        int i3;
        int i4;
        int i5;
        int i6;
        int i7;
        int i8;
        int i9;
        int i10;
        int i11;
        int i12;
        int e2 = l.e();
        l.r(40);
        boolean z = l.h(5) > 10;
        l.p(e2);
        int i13 = -1;
        if (z) {
            l.r(16);
            int h = l.h(2);
            if (h == 0) {
                i13 = 0;
            } else if (h == 1) {
                i13 = 1;
            } else if (h == 2) {
                i13 = 2;
            }
            l.r(3);
            int h2 = (l.h(11) + 1) * 2;
            int h3 = l.h(2);
            if (h3 == 3) {
                i8 = c[l.h(2)];
                i7 = 3;
                i9 = 6;
            } else {
                int h4 = l.h(2);
                int i14 = a[h4];
                i7 = h4;
                i8 = b[h3];
                i9 = i14;
            }
            int i15 = i9 * 256;
            int a2 = a(h2, i8, i9);
            int h5 = l.h(3);
            boolean g = l.g();
            int i16 = d[h5] + (g ? 1 : 0);
            l.r(10);
            if (l.g()) {
                l.r(8);
            }
            if (h5 == 0) {
                l.r(5);
                if (l.g()) {
                    l.r(8);
                }
            }
            if (i13 == 1 && l.g()) {
                l.r(16);
            }
            if (l.g()) {
                if (h5 > 2) {
                    l.r(2);
                }
                if ((h5 & 1) == 0 || h5 <= 2) {
                    i11 = 6;
                } else {
                    i11 = 6;
                    l.r(6);
                }
                if ((h5 & 4) != 0) {
                    l.r(i11);
                }
                if (g && l.g()) {
                    l.r(5);
                }
                if (i13 == 0) {
                    if (l.g()) {
                        i12 = 6;
                        l.r(6);
                    } else {
                        i12 = 6;
                    }
                    if (h5 == 0 && l.g()) {
                        l.r(i12);
                    }
                    if (l.g()) {
                        l.r(i12);
                    }
                    int h6 = l.h(2);
                    if (h6 == 1) {
                        l.r(5);
                    } else if (h6 == 2) {
                        l.r(12);
                    } else if (h6 == 3) {
                        int h7 = l.h(5);
                        if (l.g()) {
                            l.r(5);
                            if (l.g()) {
                                l.r(4);
                            }
                            if (l.g()) {
                                l.r(4);
                            }
                            if (l.g()) {
                                l.r(4);
                            }
                            if (l.g()) {
                                l.r(4);
                            }
                            if (l.g()) {
                                l.r(4);
                            }
                            if (l.g()) {
                                l.r(4);
                            }
                            if (l.g()) {
                                l.r(4);
                            }
                            if (l.g()) {
                                if (l.g()) {
                                    l.r(4);
                                }
                                if (l.g()) {
                                    l.r(4);
                                }
                            }
                        }
                        if (l.g()) {
                            l.r(5);
                            if (l.g()) {
                                l.r(7);
                                if (l.g()) {
                                    l.r(8);
                                }
                            }
                        }
                        l.r((h7 + 2) * 8);
                        l.c();
                    }
                    if (h5 < 2) {
                        if (l.g()) {
                            l.r(14);
                        }
                        if (h5 == 0 && l.g()) {
                            l.r(14);
                        }
                    }
                    if (l.g()) {
                        if (i7 == 0) {
                            l.r(5);
                        } else {
                            for (int i17 = 0; i17 < i9; i17++) {
                                if (l.g()) {
                                    l.r(5);
                                }
                            }
                        }
                    }
                }
            }
            if (l.g()) {
                l.r(5);
                if (h5 == 2) {
                    l.r(4);
                }
                if (h5 >= 6) {
                    l.r(2);
                }
                if (l.g()) {
                    l.r(8);
                }
                if (h5 == 0 && l.g()) {
                    l.r(8);
                }
                if (h3 < 3) {
                    l.q();
                }
            }
            if (i13 == 0 && i7 != 3) {
                l.q();
            }
            if (i13 == 2 && (i7 == 3 || l.g())) {
                i10 = 6;
                l.r(6);
            } else {
                i10 = 6;
            }
            str = (l.g() && l.h(i10) == 1 && l.h(8) == 1) ? "audio/eac3-joc" : "audio/eac3";
            i5 = i13;
            i6 = i15;
            i2 = h2;
            i3 = i8;
            i = a2;
            i4 = i16;
        } else {
            l.r(32);
            int h8 = l.h(2);
            String str2 = h8 == 3 ? null : "audio/ac3";
            int h9 = l.h(6);
            int i18 = e[h9 / 2] * 1000;
            int c2 = c(h8, h9);
            l.r(8);
            int h10 = l.h(3);
            if ((h10 & 1) != 0 && h10 != 1) {
                l.r(2);
            }
            if ((h10 & 4) != 0) {
                l.r(2);
            }
            if (h10 == 2) {
                l.r(2);
            }
            int[] iArr = b;
            str = str2;
            i = i18;
            i2 = c2;
            i3 = h8 < iArr.length ? iArr[h8] : -1;
            i4 = d[h10] + (l.g() ? 1 : 0);
            i5 = -1;
            i6 = 1536;
        }
        return new b(str, i5, i4, i3, i2, i6, i, null);
    }

    public static int g(byte[] bArr) {
        if (bArr.length < 6) {
            return -1;
        }
        if (((bArr[5] & 248) >> 3) > 10) {
            return (((bArr[3] & 255) | ((bArr[2] & 7) << 8)) + 1) * 2;
        }
        byte b2 = bArr[4];
        return c((b2 & 192) >> 6, b2 & 63);
    }

    /* JADX WARN: Removed duplicated region for block: B:18:0x0062  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static O2.z0 h(d4.M r7, java.lang.String r8, java.lang.String r9, V2.m r10) {
        /*
            d4.L r0 = new d4.L
            r0.<init>()
            r0.m(r7)
            r1 = 13
            int r1 = r0.h(r1)
            int r1 = r1 * 1000
            r2 = 3
            r0.r(r2)
            r3 = 2
            int r3 = r0.h(r3)
            int[] r4 = Q2.b.b
            r3 = r4[r3]
            r4 = 10
            r0.r(r4)
            int[] r4 = Q2.b.d
            int r5 = r0.h(r2)
            r4 = r4[r5]
            r5 = 1
            int r6 = r0.h(r5)
            if (r6 == 0) goto L33
            int r4 = r4 + 1
        L33:
            r0.r(r2)
            r2 = 4
            int r2 = r0.h(r2)
            r0.r(r5)
            if (r2 <= 0) goto L4f
            r2 = 6
            r0.s(r2)
            int r2 = r0.h(r5)
            if (r2 == 0) goto L4c
            int r4 = r4 + 2
        L4c:
            r0.r(r5)
        L4f:
            int r2 = r0.b()
            r6 = 7
            if (r2 <= r6) goto L62
            r0.r(r6)
            int r2 = r0.h(r5)
            if (r2 == 0) goto L62
            java.lang.String r2 = "audio/eac3-joc"
            goto L64
        L62:
            java.lang.String r2 = "audio/eac3"
        L64:
            r0.c()
            int r0 = r0.d()
            r7.U(r0)
            O2.z0$b r7 = new O2.z0$b
            r7.<init>()
            O2.z0$b r7 = r7.U(r8)
            O2.z0$b r7 = r7.g0(r2)
            O2.z0$b r7 = r7.J(r4)
            O2.z0$b r7 = r7.h0(r3)
            O2.z0$b r7 = r7.O(r10)
            O2.z0$b r7 = r7.X(r9)
            O2.z0$b r7 = r7.b0(r1)
            O2.z0 r7 = r7.G()
            return r7
        */
        throw new UnsupportedOperationException("Method not decompiled: Q2.b.h(d4.M, java.lang.String, java.lang.String, V2.m):O2.z0");
    }

    public static int i(ByteBuffer byteBuffer, int i) {
        return 40 << ((byteBuffer.get((byteBuffer.position() + i) + ((byteBuffer.get((byteBuffer.position() + i) + 7) & 255) == 187 ? 9 : 8)) >> 4) & 7);
    }

    public static int j(byte[] bArr) {
        if (bArr[4] == -8 && bArr[5] == 114 && bArr[6] == 111) {
            byte b2 = bArr[7];
            if ((b2 & 254) == 186) {
                return 40 << ((bArr[(b2 & 255) == 187 ? '\t' : '\b'] >> 4) & 7);
            }
        }
        return 0;
    }
}
