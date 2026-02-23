package com.google.ads.interactivemedia.v3.internal;

import java.io.File;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class asq {
    private final apo a;
    private final File b;
    private final File c;
    private final File d;
    private byte[] e;

    public asq(apo apoVar, File file, File file2, File file3) {
        this.a = apoVar;
        this.b = file;
        this.c = file3;
        this.d = file2;
    }

    public final apo a() {
        return this.a;
    }

    public final File b() {
        return this.c;
    }

    public final File c() {
        return this.b;
    }

    public final boolean d() {
        return this.a.b() - (System.currentTimeMillis() / 1000) < 3600;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x002b A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:24:0x002c  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final byte[] e() {
        /*
            r3 = this;
            byte[] r0 = r3.e
            r1 = 0
            if (r0 != 0) goto L27
            java.io.File r0 = r3.d
            java.io.FileInputStream r2 = new java.io.FileInputStream     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L20
            r2.<init>(r0)     // Catch: java.lang.Throwable -> L1b java.io.IOException -> L20
            com.google.ads.interactivemedia.v3.internal.bpb r0 = com.google.ads.interactivemedia.v3.internal.bpb.w(r2)     // Catch: java.lang.Throwable -> L18 java.io.IOException -> L21
            byte[] r0 = r0.B()     // Catch: java.lang.Throwable -> L18 java.io.IOException -> L21
            C4.k.a(r2)
            goto L25
        L18:
            r0 = move-exception
            r1 = r2
            goto L1c
        L1b:
            r0 = move-exception
        L1c:
            C4.k.a(r1)
            throw r0
        L20:
            r2 = r1
        L21:
            C4.k.a(r2)
            r0 = r1
        L25:
            r3.e = r0
        L27:
            byte[] r0 = r3.e
            if (r0 != 0) goto L2c
            return r1
        L2c:
            int r1 = r0.length
            byte[] r0 = java.util.Arrays.copyOf(r0, r1)
            return r0
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.asq.e():byte[]");
    }
}
