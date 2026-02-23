package com.google.ads.interactivemedia.v3.internal;

import android.net.Uri;
import java.io.InputStream;
import java.net.HttpURLConnection;
import java.util.Map;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class dj extends ct implements cy {
    private final int a;
    private final int b;
    private final String c;
    private final dr d;
    private final dr e;
    private dc f;
    private HttpURLConnection g;
    private InputStream h;
    private boolean i;
    private int j;
    private long k;
    private long l;

    @Deprecated
    public dj() {
        this(null, 8000, 8000, null);
    }

    private final void k() {
        HttpURLConnection httpURLConnection = this.g;
        if (httpURLConnection != null) {
            try {
                httpURLConnection.disconnect();
            } catch (Exception e) {
                cd.c("DefaultHttpDataSource", "Unexpected error while disconnecting", e);
            }
            this.g = null;
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x002b  */
    /* JADX WARN: Removed duplicated region for block: B:15:0x002c A[Catch: IOException -> 0x001f, TRY_LEAVE, TryCatch #0 {IOException -> 0x001f, blocks: (B:5:0x0004, B:7:0x000d, B:11:0x0018, B:12:0x0021, B:15:0x002c), top: B:4:0x0004 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final int a(byte[] r7, int r8, int r9) throws com.google.ads.interactivemedia.v3.internal.do {
        /*
            r6 = this;
            if (r9 != 0) goto L4
            r7 = 0
            goto L35
        L4:
            long r0 = r6.k     // Catch: java.io.IOException -> L1f
            r2 = -1
            r4 = -1
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 == 0) goto L21
            long r2 = r6.l     // Catch: java.io.IOException -> L1f
            long r0 = r0 - r2
            r2 = 0
            int r5 = (r0 > r2 ? 1 : (r0 == r2 ? 0 : -1))
            if (r5 != 0) goto L18
        L16:
            r7 = -1
            goto L35
        L18:
            long r2 = (long) r9     // Catch: java.io.IOException -> L1f
            long r0 = java.lang.Math.min(r2, r0)     // Catch: java.io.IOException -> L1f
            int r9 = (int) r0     // Catch: java.io.IOException -> L1f
            goto L21
        L1f:
            r7 = move-exception
            goto L36
        L21:
            java.io.InputStream r0 = r6.h     // Catch: java.io.IOException -> L1f
            int r1 = com.google.ads.interactivemedia.v3.internal.cq.a     // Catch: java.io.IOException -> L1f
            int r7 = r0.read(r7, r8, r9)     // Catch: java.io.IOException -> L1f
            if (r7 != r4) goto L2c
            goto L16
        L2c:
            long r8 = r6.l     // Catch: java.io.IOException -> L1f
            long r0 = (long) r7     // Catch: java.io.IOException -> L1f
            long r8 = r8 + r0
            r6.l = r8     // Catch: java.io.IOException -> L1f
            r6.g(r7)     // Catch: java.io.IOException -> L1f
        L35:
            return r7
        L36:
            com.google.ads.interactivemedia.v3.internal.dc r8 = r6.f
            int r9 = com.google.ads.interactivemedia.v3.internal.cq.a
            r9 = 2
            com.google.ads.interactivemedia.v3.internal.do r7 = com.google.ads.interactivemedia.v3.internal.do.a(r7, r8, r9)
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.dj.a(byte[], int, int):int");
    }

    /* JADX WARN: Removed duplicated region for block: B:81:0x00e8  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final long b(com.google.ads.interactivemedia.v3.internal.dc r15) throws com.google.ads.interactivemedia.v3.internal.do {
        /*
            Method dump skipped, instructions count: 481
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.dj.b(com.google.ads.interactivemedia.v3.internal.dc):long");
    }

    public final Uri c() {
        HttpURLConnection httpURLConnection = this.g;
        if (httpURLConnection == null) {
            return null;
        }
        return Uri.parse(httpURLConnection.getURL().toString());
    }

    /* JADX WARN: Removed duplicated region for block: B:25:0x0053 A[Catch: all -> 0x0032, Exception -> 0x006b, TRY_LEAVE, TryCatch #0 {all -> 0x0032, blocks: (B:3:0x0002, B:5:0x0006, B:8:0x0013, B:10:0x0017, B:16:0x0022, B:18:0x002a, B:21:0x003b, B:23:0x004b, B:25:0x0053, B:32:0x006b, B:35:0x0070, B:36:0x007a, B:38:0x0010), top: B:2:0x0002, inners: #2 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final void d() throws com.google.ads.interactivemedia.v3.internal.do {
        /*
            r10 = this;
            r0 = 0
            r1 = 0
            java.io.InputStream r2 = r10.h     // Catch: java.lang.Throwable -> L32
            if (r2 == 0) goto L7b
            long r3 = r10.k     // Catch: java.lang.Throwable -> L32
            r5 = -1
            int r7 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r7 != 0) goto L10
            r3 = r5
            goto L13
        L10:
            long r7 = r10.l     // Catch: java.lang.Throwable -> L32
            long r3 = r3 - r7
        L13:
            java.net.HttpURLConnection r7 = r10.g     // Catch: java.lang.Throwable -> L32
            if (r7 == 0) goto L6b
            int r8 = com.google.ads.interactivemedia.v3.internal.cq.a     // Catch: java.lang.Throwable -> L32
            r9 = 19
            if (r8 < r9) goto L6b
            r9 = 20
            if (r8 <= r9) goto L22
            goto L6b
        L22:
            java.io.InputStream r7 = r7.getInputStream()     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L6b
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 != 0) goto L34
            int r3 = r7.read()     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L6b
            r4 = -1
            if (r3 == r4) goto L6b
            goto L3b
        L32:
            r2 = move-exception
            goto L8a
        L34:
            r5 = 2048(0x800, double:1.0118E-320)
            int r8 = (r3 > r5 ? 1 : (r3 == r5 ? 0 : -1))
            if (r8 > 0) goto L3b
            goto L6b
        L3b:
            java.lang.Class r3 = r7.getClass()     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L6b
            java.lang.String r3 = r3.getName()     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L6b
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$ChunkedInputStream"
            boolean r4 = r4.equals(r3)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L6b
            if (r4 != 0) goto L53
            java.lang.String r4 = "com.android.okhttp.internal.http.HttpTransport$FixedLengthInputStream"
            boolean r3 = r4.equals(r3)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L6b
            if (r3 == 0) goto L6b
        L53:
            java.lang.Class r3 = r7.getClass()     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L6b
            java.lang.Class r3 = r3.getSuperclass()     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L6b
            com.google.ads.interactivemedia.v3.internal.af.s(r3)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L6b
            java.lang.String r4 = "unexpectedEndOfInput"
            java.lang.reflect.Method r3 = r3.getDeclaredMethod(r4, r1)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L6b
            r4 = 1
            r3.setAccessible(r4)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L6b
            r3.invoke(r7, r1)     // Catch: java.lang.Throwable -> L32 java.lang.Exception -> L6b
        L6b:
            r2.close()     // Catch: java.lang.Throwable -> L32 java.io.IOException -> L6f
            goto L7b
        L6f:
            r2 = move-exception
            com.google.ads.interactivemedia.v3.internal.do r3 = new com.google.ads.interactivemedia.v3.internal.do     // Catch: java.lang.Throwable -> L32
            int r4 = com.google.ads.interactivemedia.v3.internal.cq.a     // Catch: java.lang.Throwable -> L32
            r4 = 2000(0x7d0, float:2.803E-42)
            r5 = 3
            r3.<init>(r2, r4, r5)     // Catch: java.lang.Throwable -> L32
            throw r3     // Catch: java.lang.Throwable -> L32
        L7b:
            r10.h = r1
            r10.k()
            boolean r1 = r10.i
            if (r1 == 0) goto L89
            r10.i = r0
            r10.h()
        L89:
            return
        L8a:
            r10.h = r1
            r10.k()
            boolean r1 = r10.i
            if (r1 == 0) goto L98
            r10.i = r0
            r10.h()
        L98:
            throw r2
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.dj.d():void");
    }

    public final Map e() {
        HttpURLConnection httpURLConnection = this.g;
        return httpURLConnection == null ? avs.d() : new di(httpURLConnection.getHeaderFields());
    }

    private dj(String str, int i, int i2, dr drVar) {
        super(true);
        this.c = str;
        this.a = 8000;
        this.b = 8000;
        this.d = drVar;
        this.e = new dr();
    }

    public /* synthetic */ dj(String str, int i, int i2, dr drVar, byte[] bArr) {
        this(str, 8000, 8000, drVar);
    }
}
