package com.google.ads.interactivemedia.v3.internal;

import java.io.IOException;
import java.util.ArrayDeque;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
final class abl implements abn {
    private final byte[] a = new byte[8];
    private final ArrayDeque b = new ArrayDeque();
    private final abt c = new abt();
    private abm d;
    private int e;
    private int f;
    private long g;

    private final long d(zi ziVar, int i) throws IOException {
        ziVar.g(this.a, 0, i);
        long j = 0;
        for (int i2 = 0; i2 < i; i2++) {
            j = (j << 8) | (this.a[i2] & 255);
        }
        return j;
    }

    public final void a(abm abmVar) {
        this.d = abmVar;
    }

    public final void b() {
        this.e = 0;
        this.b.clear();
        this.c.e();
    }

    /* JADX WARN: Removed duplicated region for block: B:41:0x00ae A[LOOP:0: B:2:0x0005->B:41:0x00ae, LOOP_END] */
    /* JADX WARN: Removed duplicated region for block: B:42:0x00b8 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:55:0x00f5 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:58:0x00fe A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:61:0x0121 A[SYNTHETIC] */
    /* JADX WARN: Removed duplicated region for block: B:96:0x01b2 A[SYNTHETIC] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final boolean c(com.google.ads.interactivemedia.v3.internal.zi r14) throws java.io.IOException {
        /*
            Method dump skipped, instructions count: 846
            To view this dump change 'Code comments level' option to 'DEBUG'
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.abl.c(com.google.ads.interactivemedia.v3.internal.zi):boolean");
    }
}
