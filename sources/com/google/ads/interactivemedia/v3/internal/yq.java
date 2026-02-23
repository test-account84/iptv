package com.google.ads.interactivemedia.v3.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class yq {
    public static final /* synthetic */ int a = 0;
    private static final int[] b = {2002, 2000, 1920, 1601, 1600, 1001, 1000, 960, 800, 800, 480, 400, 400, 2048};

    /* JADX WARN: Removed duplicated region for block: B:42:0x008a  */
    /* JADX WARN: Removed duplicated region for block: B:43:0x0097  */
    /* JADX WARN: Removed duplicated region for block: B:46:0x0092  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static com.google.ads.interactivemedia.v3.internal.yp a(com.google.ads.interactivemedia.v3.internal.ci r9) {
        /*
            r0 = 16
            int r1 = r9.c(r0)
            int r0 = r9.c(r0)
            r2 = 65535(0xffff, float:9.1834E-41)
            r3 = 4
            if (r0 != r2) goto L18
            r0 = 24
            int r0 = r9.c(r0)
            r2 = 7
            goto L19
        L18:
            r2 = 4
        L19:
            int r0 = r0 + r2
            r2 = 44097(0xac41, float:6.1793E-41)
            if (r1 != r2) goto L21
            int r0 = r0 + 2
        L21:
            r1 = 2
            int r2 = r9.c(r1)
            r4 = 3
            if (r2 != r4) goto L32
        L29:
            r9.c(r1)
            boolean r2 = r9.k()
            if (r2 != 0) goto L29
        L32:
            r2 = 10
            int r2 = r9.c(r2)
            boolean r5 = r9.k()
            if (r5 == 0) goto L47
            int r5 = r9.c(r4)
            if (r5 <= 0) goto L47
            r9.i(r1)
        L47:
            boolean r5 = r9.k()
            r6 = 48000(0xbb80, float:6.7262E-41)
            r7 = 44100(0xac44, float:6.1797E-41)
            r8 = 1
            if (r8 == r5) goto L58
            r5 = 44100(0xac44, float:6.1797E-41)
            goto L5b
        L58:
            r5 = 48000(0xbb80, float:6.7262E-41)
        L5b:
            int r9 = r9.c(r3)
            if (r5 != r7) goto L6a
            r7 = 13
            if (r9 != r7) goto L6a
            int[] r9 = com.google.ads.interactivemedia.v3.internal.yq.b
            r9 = r9[r7]
            goto L9a
        L6a:
            r7 = 0
            if (r5 != r6) goto L99
            r6 = 14
            if (r9 >= r6) goto L99
            int[] r6 = com.google.ads.interactivemedia.v3.internal.yq.b
            r6 = r6[r9]
            int r2 = r2 % 5
            r7 = 8
            if (r2 == r8) goto L92
            r8 = 11
            if (r2 == r1) goto L8d
            if (r2 == r4) goto L92
            if (r2 == r3) goto L84
            goto L97
        L84:
            if (r9 == r4) goto L8a
            if (r9 == r7) goto L8a
            if (r9 != r8) goto L97
        L8a:
            int r9 = r6 + 1
            goto L9a
        L8d:
            if (r9 == r7) goto L8a
            if (r9 != r8) goto L97
            goto L8a
        L92:
            if (r9 == r4) goto L8a
            if (r9 != r7) goto L97
            goto L8a
        L97:
            r9 = r6
            goto L9a
        L99:
            r9 = 0
        L9a:
            com.google.ads.interactivemedia.v3.internal.yp r1 = new com.google.ads.interactivemedia.v3.internal.yp
            r1.<init>(r5, r0, r9)
            return r1
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.yq.a(com.google.ads.interactivemedia.v3.internal.ci):com.google.ads.interactivemedia.v3.internal.yp");
    }

    public static void b(int i, cj cjVar) {
        cjVar.B(7);
        byte[] H = cjVar.H();
        H[0] = -84;
        H[1] = 64;
        H[2] = -1;
        H[3] = -1;
        H[4] = (byte) ((i >> 16) & 255);
        H[5] = (byte) ((i >> 8) & 255);
        H[6] = (byte) (i & 255);
    }
}
