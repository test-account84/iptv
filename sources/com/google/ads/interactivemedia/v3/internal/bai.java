package com.google.ads.interactivemedia.v3.internal;

import j$.util.concurrent.ConcurrentHashMap;
import java.security.GeneralSecurityException;
import java.util.concurrent.ConcurrentMap;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class bai {
    private final Class a;
    private baj c;
    private ConcurrentMap b = new ConcurrentHashMap();
    private bfx d = bfx.a;

    public /* synthetic */ bai(Class cls) {
        this.a = cls;
    }

    /* JADX WARN: Removed duplicated region for block: B:23:0x00bc  */
    /* JADX WARN: Removed duplicated region for block: B:25:0x00d0  */
    /* JADX WARN: Removed duplicated region for block: B:31:0x00df A[RETURN] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    private final void e(java.lang.Object r12, com.google.ads.interactivemedia.v3.internal.bhv r13, boolean r14) throws java.security.GeneralSecurityException {
        /*
            r11 = this;
            java.util.concurrent.ConcurrentMap r0 = r11.b
            if (r0 == 0) goto Le8
            int r0 = r13.f()
            int r1 = com.google.ads.interactivemedia.v3.internal.bhs.b
            if (r0 != r1) goto Le0
            java.util.concurrent.ConcurrentMap r0 = r11.b
            int r1 = r13.a()
            java.lang.Integer r1 = java.lang.Integer.valueOf(r1)
            com.google.ads.interactivemedia.v3.internal.bid r2 = r13.d()
            com.google.ads.interactivemedia.v3.internal.bid r3 = com.google.ads.interactivemedia.v3.internal.bid.RAW
            if (r2 != r3) goto L1f
            r1 = 0
        L1f:
            com.google.ads.interactivemedia.v3.internal.bej r2 = com.google.ads.interactivemedia.v3.internal.bej.b()
            com.google.ads.interactivemedia.v3.internal.bhr r3 = r13.b()
            java.lang.String r3 = r3.e()
            com.google.ads.interactivemedia.v3.internal.bhr r4 = r13.b()
            com.google.ads.interactivemedia.v3.internal.bpb r4 = r4.d()
            com.google.ads.interactivemedia.v3.internal.bhr r5 = r13.b()
            com.google.ads.interactivemedia.v3.internal.bhq r5 = r5.a()
            com.google.ads.interactivemedia.v3.internal.bid r6 = r13.d()
            com.google.ads.interactivemedia.v3.internal.beq r1 = com.google.ads.interactivemedia.v3.internal.beq.a(r3, r4, r5, r6, r1)
            com.google.ads.interactivemedia.v3.internal.bap r3 = com.google.ads.interactivemedia.v3.internal.bap.a()
            com.google.ads.interactivemedia.v3.internal.azu r10 = r2.a(r1, r3)
            com.google.ads.interactivemedia.v3.internal.baj r1 = new com.google.ads.interactivemedia.v3.internal.baj
            com.google.ads.interactivemedia.v3.internal.bid r2 = r13.d()
            int r2 = r2.ordinal()
            r3 = 5
            r4 = 1
            if (r2 == r4) goto L85
            r4 = 2
            if (r2 == r4) goto L6f
            r4 = 3
            if (r2 == r4) goto L6b
            r4 = 4
            if (r2 != r4) goto L63
            goto L6f
        L63:
            java.security.GeneralSecurityException r12 = new java.security.GeneralSecurityException
            java.lang.String r13 = "unknown output prefix type"
            r12.<init>(r13)
            throw r12
        L6b:
            byte[] r2 = com.google.ads.interactivemedia.v3.internal.azq.a
        L6d:
            r6 = r2
            goto L8e
        L6f:
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r3)
            r3 = 0
            java.nio.ByteBuffer r2 = r2.put(r3)
        L78:
            int r3 = r13.a()
            java.nio.ByteBuffer r2 = r2.putInt(r3)
            byte[] r2 = r2.array()
            goto L6d
        L85:
            java.nio.ByteBuffer r2 = java.nio.ByteBuffer.allocate(r3)
            java.nio.ByteBuffer r2 = r2.put(r4)
            goto L78
        L8e:
            int r7 = r13.f()
            com.google.ads.interactivemedia.v3.internal.bid r8 = r13.d()
            int r9 = r13.a()
            r4 = r1
            r5 = r12
            r4.<init>(r5, r6, r7, r8, r9, r10)
            java.util.ArrayList r12 = new java.util.ArrayList
            r12.<init>()
            r12.add(r1)
            com.google.ads.interactivemedia.v3.internal.bak r13 = new com.google.ads.interactivemedia.v3.internal.bak
            byte[] r2 = r1.e()
            r13.<init>(r2)
            java.util.List r12 = java.util.Collections.unmodifiableList(r12)
            java.lang.Object r12 = r0.put(r13, r12)
            java.util.List r12 = (java.util.List) r12
            if (r12 == 0) goto Lce
            java.util.ArrayList r2 = new java.util.ArrayList
            r2.<init>()
            r2.addAll(r12)
            r2.add(r1)
            java.util.List r12 = java.util.Collections.unmodifiableList(r2)
            r0.put(r13, r12)
        Lce:
            if (r14 == 0) goto Ldf
            com.google.ads.interactivemedia.v3.internal.baj r12 = r11.c
            if (r12 != 0) goto Ld7
            r11.c = r1
            return
        Ld7:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "you cannot set two primary primitives"
            r12.<init>(r13)
            throw r12
        Ldf:
            return
        Le0:
            java.security.GeneralSecurityException r12 = new java.security.GeneralSecurityException
            java.lang.String r13 = "only ENABLED key is allowed"
            r12.<init>(r13)
            throw r12
        Le8:
            java.lang.IllegalStateException r12 = new java.lang.IllegalStateException
            java.lang.String r13 = "addPrimitive cannot be called after build"
            r12.<init>(r13)
            throw r12
        */
        throw new UnsupportedOperationException("Method not decompiled: com.google.ads.interactivemedia.v3.internal.bai.e(java.lang.Object, com.google.ads.interactivemedia.v3.internal.bhv, boolean):void");
    }

    public final bal a() throws GeneralSecurityException {
        ConcurrentMap concurrentMap = this.b;
        if (concurrentMap == null) {
            throw new IllegalStateException("build cannot be called twice");
        }
        bal balVar = new bal(concurrentMap, this.c, this.d, this.a);
        this.b = null;
        return balVar;
    }

    public final void b(Object obj, bhv bhvVar) throws GeneralSecurityException {
        e(obj, bhvVar, true);
    }

    public final void c(Object obj, bhv bhvVar) throws GeneralSecurityException {
        e(obj, bhvVar, false);
    }

    public final void d(bfx bfxVar) {
        if (this.b == null) {
            throw new IllegalStateException("setAnnotations cannot be called after build");
        }
        this.d = bfxVar;
    }
}
