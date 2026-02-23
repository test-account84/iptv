package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.Arrays;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class aai implements zh {
    private static final int[] a;
    private static final int[] b;
    private static final byte[] c;
    private static final byte[] d;
    private static final int e;
    private final byte[] f;
    private final int g;
    private boolean h;
    private long i;
    private int j;
    private int k;
    private boolean l;
    private long m;
    private int n;
    private int o;
    private long p;
    private zk q;
    private aae r;
    private aab s;
    private boolean t;

    static {
        aah aahVar = aah.a;
        a = new int[]{13, 14, 16, 18, 20, 21, 27, 32, 6, 7, 6, 6, 1, 1, 1, 1};
        int[] iArr = {18, 24, 33, 37, 41, 47, 51, 59, 61, 6, 1, 1, 1, 1, 1, 1};
        b = iArr;
        c = cq.ad("#!AMR\n");
        d = cq.ad("#!AMR-WB\n");
        e = iArr[8];
    }

    public aai() {
        this(null);
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x0036 A[Catch: EOFException -> 0x0095, TryCatch #0 {EOFException -> 0x0095, blocks: (B:13:0x0007, B:15:0x0018, B:23:0x0036, B:24:0x003f, B:30:0x003b, B:40:0x0061, B:41:0x007e, B:42:0x007f, B:43:0x0094), top: B:12:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:27:0x0047  */
    /* JADX WARN: Removed duplicated region for block: B:29:0x0054  */
    /* JADX WARN: Removed duplicated region for block: B:30:0x003b A[Catch: EOFException -> 0x0095, TryCatch #0 {EOFException -> 0x0095, blocks: (B:13:0x0007, B:15:0x0018, B:23:0x0036, B:24:0x003f, B:30:0x003b, B:40:0x0061, B:41:0x007e, B:42:0x007f, B:43:0x0094), top: B:12:0x0007 }] */
    /* JADX WARN: Removed duplicated region for block: B:31:0x0029  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final int f(com.google.ads.interactivemedia.v3.internal.zi r12) throws java.io.IOException {
        /*
            r11 = this;
            int r0 = r11.k
            r1 = -1
            r2 = 1
            r3 = 0
            if (r0 != 0) goto L96
            r12.h()     // Catch: java.io.EOFException -> L95
            byte[] r0 = r11.f     // Catch: java.io.EOFException -> L95
            r12.f(r0, r3, r2)     // Catch: java.io.EOFException -> L95
            byte[] r0 = r11.f     // Catch: java.io.EOFException -> L95
            r0 = r0[r3]     // Catch: java.io.EOFException -> L95
            r4 = r0 & 131(0x83, float:1.84E-43)
            r5 = 0
            if (r4 > 0) goto L7f
            int r0 = r0 >> 3
            r0 = r0 & 15
            boolean r4 = r11.h     // Catch: java.io.EOFException -> L95
            if (r4 == 0) goto L29
            r6 = 10
            if (r0 < r6) goto L34
            r6 = 13
            if (r0 <= r6) goto L29
            goto L34
        L29:
            if (r4 != 0) goto L5a
            r6 = 12
            if (r0 < r6) goto L34
            r6 = 14
            if (r0 > r6) goto L34
            goto L5a
        L34:
            if (r4 == 0) goto L3b
            int[] r4 = com.google.ads.interactivemedia.v3.internal.aai.b     // Catch: java.io.EOFException -> L95
            r0 = r4[r0]     // Catch: java.io.EOFException -> L95
            goto L3f
        L3b:
            int[] r4 = com.google.ads.interactivemedia.v3.internal.aai.a     // Catch: java.io.EOFException -> L95
            r0 = r4[r0]     // Catch: java.io.EOFException -> L95
        L3f:
            r11.j = r0     // Catch: java.io.EOFException -> L95
            r11.k = r0
            int r4 = r11.n
            if (r4 != r1) goto L52
            long r4 = r12.d()
            r11.m = r4
            int r0 = r11.j
            r11.n = r0
            r4 = r0
        L52:
            if (r4 != r0) goto L96
            int r0 = r11.o
            int r0 = r0 + r2
            r11.o = r0
            goto L96
        L5a:
            java.lang.String r12 = "WB"
            java.lang.String r3 = "NB"
            if (r2 == r4) goto L61
            r12 = r3
        L61:
            java.lang.StringBuilder r2 = new java.lang.StringBuilder     // Catch: java.io.EOFException -> L95
            r2.<init>()     // Catch: java.io.EOFException -> L95
            java.lang.String r3 = "Illegal AMR "
            r2.append(r3)     // Catch: java.io.EOFException -> L95
            r2.append(r12)     // Catch: java.io.EOFException -> L95
            java.lang.String r12 = " frame type "
            r2.append(r12)     // Catch: java.io.EOFException -> L95
            r2.append(r0)     // Catch: java.io.EOFException -> L95
            java.lang.String r12 = r2.toString()     // Catch: java.io.EOFException -> L95
            com.google.ads.interactivemedia.v3.internal.as r12 = com.google.ads.interactivemedia.v3.internal.as.a(r12, r5)     // Catch: java.io.EOFException -> L95
            throw r12     // Catch: java.io.EOFException -> L95
        L7f:
            java.lang.StringBuilder r12 = new java.lang.StringBuilder     // Catch: java.io.EOFException -> L95
            r12.<init>()     // Catch: java.io.EOFException -> L95
            java.lang.String r2 = "Invalid padding bits for frame header "
            r12.append(r2)     // Catch: java.io.EOFException -> L95
            r12.append(r0)     // Catch: java.io.EOFException -> L95
            java.lang.String r12 = r12.toString()     // Catch: java.io.EOFException -> L95
            com.google.ads.interactivemedia.v3.internal.as r12 = com.google.ads.interactivemedia.v3.internal.as.a(r12, r5)     // Catch: java.io.EOFException -> L95
            throw r12     // Catch: java.io.EOFException -> L95
        L95:
            return r1
        L96:
            com.google.ads.interactivemedia.v3.internal.aae r0 = r11.r
            int r4 = r11.k
            int r12 = r0.a(r12, r4, r2)
            if (r12 != r1) goto La1
            return r1
        La1:
            int r0 = r11.k
            int r0 = r0 - r12
            r11.k = r0
            if (r0 <= 0) goto La9
            return r3
        La9:
            com.google.ads.interactivemedia.v3.internal.aae r4 = r11.r
            long r0 = r11.p
            long r5 = r11.i
            long r5 = r5 + r0
            int r8 = r11.j
            r9 = 0
            r10 = 0
            r7 = 1
            r4.f(r5, r7, r8, r9, r10)
            long r0 = r11.i
            r4 = 20000(0x4e20, double:9.8813E-320)
            long r0 = r0 + r4
            r11.i = r0
            return r3
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.aai.f(com.google.ads.interactivemedia.v3.internal.zi):int");
    }

    private static boolean g(zi ziVar, byte[] bArr) throws IOException {
        ziVar.h();
        int length = bArr.length;
        byte[] bArr2 = new byte[length];
        ziVar.f(bArr2, 0, length);
        return Arrays.equals(bArr2, bArr);
    }

    private final boolean h(zi ziVar) throws IOException {
        int length;
        byte[] bArr = c;
        if (g(ziVar, bArr)) {
            this.h = false;
            length = bArr.length;
        } else {
            byte[] bArr2 = d;
            if (!g(ziVar, bArr2)) {
                return false;
            }
            this.h = true;
            length = bArr2.length;
        }
        ziVar.i(length);
        return true;
    }

    public final boolean C(zi ziVar) throws IOException {
        return h(ziVar);
    }

    public final int a(zi ziVar, zy zyVar) throws IOException {
        af.t(this.r);
        int i = cq.a;
        if (ziVar.d() == 0 && !h(ziVar)) {
            throw as.a("Could not find AMR header.", null);
        }
        if (!this.t) {
            this.t = true;
            boolean z = this.h;
            String str = true != z ? "audio/3gpp" : "audio/amr-wb";
            int i2 = true != z ? 8000 : 16000;
            aae aaeVar = this.r;
            r rVar = new r();
            rVar.ae(str);
            rVar.W(e);
            rVar.H(1);
            rVar.af(i2);
            aaeVar.b(rVar.v());
        }
        int f = f(ziVar);
        if (this.l) {
            return f;
        }
        aaa aaaVar = new aaa(-9223372036854775807L);
        this.s = aaaVar;
        this.q.x(aaaVar);
        this.l = true;
        return f;
    }

    public final void b(zk zkVar) {
        this.q = zkVar;
        this.r = zkVar.i(0, 1);
        zkVar.n();
    }

    public final void c() {
    }

    public final void d(long j, long j2) {
        this.i = 0L;
        this.j = 0;
        this.k = 0;
        if (j != 0) {
            aab aabVar = this.s;
            if (aabVar instanceof za) {
                this.p = ((za) aabVar).B(j);
                return;
            }
        }
        this.p = 0L;
    }

    public aai(byte[] bArr) {
        this.g = 0;
        this.f = new byte[1];
        this.n = -1;
    }
}
