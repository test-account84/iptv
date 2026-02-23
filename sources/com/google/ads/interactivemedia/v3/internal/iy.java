package com.google.ads.interactivemedia.v3.internal;

import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class iy {
    public static final iy a = new iy(new int[]{2});
    private static final avs b;
    private final int[] c;
    private final int d;

    static {
        new iy(new int[]{2, 5, 6});
        avq avqVar = new avq();
        avqVar.a(5, 6);
        b = avqVar.a(17, 6).a(7, 6).a(18, 6).a(6, 8).a(8, 8).a(14, 8).b();
    }

    public iy(int[] iArr) {
        int[] copyOf = Arrays.copyOf(iArr, iArr.length);
        this.c = copyOf;
        Arrays.sort(copyOf);
        this.d = 8;
    }

    public static /* bridge */ /* synthetic */ avs b() {
        return b;
    }

    /* JADX WARN: Removed duplicated region for block: B:40:0x0082  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final android.util.Pair a(com.google.ads.interactivemedia.v3.internal.s r10) {
        /*
            r9 = this;
            java.lang.String r0 = r10.l
            com.google.ads.interactivemedia.v3.internal.af.s(r0)
            java.lang.String r1 = r10.i
            int r0 = com.google.ads.interactivemedia.v3.internal.ar.a(r0, r1)
            com.google.ads.interactivemedia.v3.internal.avs r1 = com.google.ads.interactivemedia.v3.internal.iy.b
            java.lang.Integer r2 = java.lang.Integer.valueOf(r0)
            boolean r2 = r1.containsKey(r2)
            r3 = 0
            if (r2 != 0) goto L19
            return r3
        L19:
            r2 = 7
            r4 = 8
            r5 = 6
            r6 = 18
            if (r0 != r6) goto L2b
            boolean r0 = r9.c(r6)
            if (r0 != 0) goto L29
            r0 = 6
            goto L34
        L29:
            r0 = 18
        L2b:
            if (r0 != r4) goto L34
            boolean r7 = r9.c(r4)
            if (r7 != 0) goto L34
            r0 = 7
        L34:
            boolean r7 = r9.c(r0)
            if (r7 != 0) goto L3b
            return r3
        L3b:
            int r7 = r10.y
            r8 = -1
            if (r7 == r8) goto L46
            if (r0 != r6) goto L43
            goto L46
        L43:
            if (r7 <= r4) goto L6e
            return r3
        L46:
            int r10 = r10.z
            if (r10 != r8) goto L4d
            r10 = 48000(0xbb80, float:6.7262E-41)
        L4d:
            int r6 = com.google.ads.interactivemedia.v3.internal.cq.a
            r7 = 29
            if (r6 < r7) goto L58
            int r7 = com.google.ads.interactivemedia.v3.internal.ix.a(r0, r10)
            goto L6e
        L58:
            java.lang.Integer r10 = java.lang.Integer.valueOf(r0)
            r6 = 0
            java.lang.Integer r6 = java.lang.Integer.valueOf(r6)
            java.lang.Object r10 = r1.getOrDefault(r10, r6)
            java.lang.Integer r10 = (java.lang.Integer) r10
            com.google.ads.interactivemedia.v3.internal.af.s(r10)
            int r7 = r10.intValue()
        L6e:
            int r10 = com.google.ads.interactivemedia.v3.internal.cq.a
            r1 = 28
            if (r10 > r1) goto L82
            if (r7 != r2) goto L77
            goto L83
        L77:
            r1 = 3
            if (r7 == r1) goto L80
            r1 = 4
            if (r7 == r1) goto L80
            r1 = 5
            if (r7 != r1) goto L82
        L80:
            r4 = 6
            goto L83
        L82:
            r4 = r7
        L83:
            r1 = 26
            if (r10 > r1) goto L95
            java.lang.String r10 = "fugu"
            java.lang.String r1 = com.google.ads.interactivemedia.v3.internal.cq.b
            boolean r10 = r10.equals(r1)
            if (r10 == 0) goto L95
            r10 = 1
            if (r4 != r10) goto L95
            r4 = 2
        L95:
            int r10 = com.google.ads.interactivemedia.v3.internal.cq.f(r4)
            if (r10 != 0) goto L9c
            return r3
        L9c:
            java.lang.Integer r0 = java.lang.Integer.valueOf(r0)
            java.lang.Integer r10 = java.lang.Integer.valueOf(r10)
            android.util.Pair r10 = android.util.Pair.create(r0, r10)
            return r10
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.iy.a(com.google.ads.interactivemedia.v3.internal.s):android.util.Pair");
    }

    public final boolean c(int i) {
        return Arrays.binarySearch(this.c, i) >= 0;
    }

    public final boolean equals(Object obj) {
        if (this == obj) {
            return true;
        }
        return (obj instanceof iy) && Arrays.equals(this.c, ((iy) obj).c);
    }

    public final int hashCode() {
        return (Arrays.hashCode(this.c) * 31) + 8;
    }

    public final String toString() {
        return "AudioCapabilities[maxChannelCount=8, supportedEncodings=" + Arrays.toString(this.c) + "]";
    }
}
