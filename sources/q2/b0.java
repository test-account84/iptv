package Q2;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class b0 {
    public static final String[] a = {"audio/mpeg-L1", "audio/mpeg-L2", "audio/mpeg"};
    public static final int[] b = {44100, 48000, 32000};
    public static final int[] c = {32000, 64000, 96000, 128000, 160000, 192000, 224000, 256000, 288000, 320000, 352000, 384000, 416000, 448000};
    public static final int[] d = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000, 176000, 192000, 224000, 256000};
    public static final int[] e = {32000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000, 384000};
    public static final int[] f = {32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 160000, 192000, 224000, 256000, 320000};
    public static final int[] g = {8000, 16000, 24000, 32000, 40000, 48000, 56000, 64000, 80000, 96000, 112000, 128000, 144000, 160000};

    public static final class a {
        public int a;
        public String b;
        public int c;
        public int d;
        public int e;
        public int f;
        public int g;

        /* JADX WARN: Removed duplicated region for block: B:23:0x0052  */
        /* JADX WARN: Removed duplicated region for block: B:29:0x00a8  */
        /* JADX WARN: Removed duplicated region for block: B:33:0x0070  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public boolean a(int r9) {
            /*
                r8 = this;
                boolean r0 = Q2.b0.a(r9)
                r1 = 0
                if (r0 != 0) goto L8
                return r1
            L8:
                int r0 = r9 >>> 19
                r2 = 3
                r0 = r0 & r2
                r3 = 1
                if (r0 != r3) goto L10
                return r1
            L10:
                int r4 = r9 >>> 17
                r4 = r4 & r2
                if (r4 != 0) goto L16
                return r1
            L16:
                int r5 = r9 >>> 12
                r6 = 15
                r5 = r5 & r6
                if (r5 == 0) goto Lac
                if (r5 != r6) goto L21
                goto Lac
            L21:
                int r6 = r9 >>> 10
                r6 = r6 & r2
                if (r6 != r2) goto L27
                return r1
            L27:
                r8.a = r0
                java.lang.String[] r1 = Q2.b0.b()
                int r7 = 3 - r4
                r1 = r1[r7]
                r8.b = r1
                int[] r1 = Q2.b0.c()
                r1 = r1[r6]
                r8.d = r1
                r6 = 2
                if (r0 != r6) goto L42
                int r1 = r1 / r6
            L3f:
                r8.d = r1
                goto L47
            L42:
                if (r0 != 0) goto L47
                int r1 = r1 / 4
                goto L3f
            L47:
                int r1 = r9 >>> 9
                r1 = r1 & r3
                int r7 = Q2.b0.d(r0, r4)
                r8.g = r7
                if (r4 != r2) goto L70
                if (r0 != r2) goto L5c
                int[] r0 = Q2.b0.e()
                int r5 = r5 - r3
                r0 = r0[r5]
                goto L63
            L5c:
                int[] r0 = Q2.b0.f()
                int r5 = r5 - r3
                r0 = r0[r5]
            L63:
                r8.f = r0
                int r0 = r0 * 12
                int r4 = r8.d
                int r0 = r0 / r4
                int r0 = r0 + r1
                int r0 = r0 * 4
            L6d:
                r8.c = r0
                goto La3
            L70:
                r7 = 144(0x90, float:2.02E-43)
                if (r0 != r2) goto L8e
                if (r4 != r6) goto L7e
                int[] r0 = Q2.b0.g()
                int r5 = r5 - r3
                r0 = r0[r5]
                goto L85
            L7e:
                int[] r0 = Q2.b0.h()
                int r5 = r5 - r3
                r0 = r0[r5]
            L85:
                r8.f = r0
                int r0 = r0 * 144
                int r4 = r8.d
                int r0 = r0 / r4
                int r0 = r0 + r1
                goto L6d
            L8e:
                int[] r0 = Q2.b0.i()
                int r5 = r5 - r3
                r0 = r0[r5]
                r8.f = r0
                if (r4 != r3) goto L9b
                r7 = 72
            L9b:
                int r7 = r7 * r0
                int r0 = r8.d
                int r7 = r7 / r0
                int r7 = r7 + r1
                r8.c = r7
            La3:
                int r9 = r9 >> 6
                r9 = r9 & r2
                if (r9 != r2) goto La9
                r6 = 1
            La9:
                r8.e = r6
                return r3
            Lac:
                return r1
            */
            throw new UnsupportedOperationException("Method not decompiled: Q2.b0.a.a(int):boolean");
        }
    }

    public static /* synthetic */ boolean a(int i) {
        return l(i);
    }

    public static /* synthetic */ String[] b() {
        return a;
    }

    public static /* synthetic */ int[] c() {
        return b;
    }

    public static /* synthetic */ int d(int i, int i2) {
        return k(i, i2);
    }

    public static /* synthetic */ int[] e() {
        return c;
    }

    public static /* synthetic */ int[] f() {
        return d;
    }

    public static /* synthetic */ int[] g() {
        return e;
    }

    public static /* synthetic */ int[] h() {
        return f;
    }

    public static /* synthetic */ int[] i() {
        return g;
    }

    public static int j(int i) {
        int i2;
        int i3;
        int i4;
        int i5;
        if (!l(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0 || (i4 = (i >>> 12) & 15) == 0 || i4 == 15 || (i5 = (i >>> 10) & 3) == 3) {
            return -1;
        }
        int i6 = b[i5];
        if (i2 == 2) {
            i6 /= 2;
        } else if (i2 == 0) {
            i6 /= 4;
        }
        int i7 = (i >>> 9) & 1;
        if (i3 == 3) {
            return ((((i2 == 3 ? c[i4 - 1] : d[i4 - 1]) * 12) / i6) + i7) * 4;
        }
        int i8 = i2 == 3 ? i3 == 2 ? e[i4 - 1] : f[i4 - 1] : g[i4 - 1];
        if (i2 == 3) {
            return ((i8 * 144) / i6) + i7;
        }
        return (((i3 == 1 ? 72 : 144) * i8) / i6) + i7;
    }

    public static int k(int i, int i2) {
        if (i2 == 1) {
            return i == 3 ? 1152 : 576;
        }
        if (i2 == 2) {
            return 1152;
        }
        if (i2 == 3) {
            return 384;
        }
        throw new IllegalArgumentException();
    }

    public static boolean l(int i) {
        return (i & (-2097152)) == -2097152;
    }

    public static int m(int i) {
        int i2;
        int i3;
        if (!l(i) || (i2 = (i >>> 19) & 3) == 1 || (i3 = (i >>> 17) & 3) == 0) {
            return -1;
        }
        int i4 = (i >>> 12) & 15;
        int i5 = (i >>> 10) & 3;
        if (i4 == 0 || i4 == 15 || i5 == 3) {
            return -1;
        }
        return k(i2, i3);
    }
}
