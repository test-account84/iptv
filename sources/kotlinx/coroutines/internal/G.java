package kotlinx.coroutines.internal;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class g {
    public static final y a = new y("UNDEFINED");
    public static final y b = new y("REUSABLE_CLAIMED");

    public static final /* synthetic */ y a() {
        return a;
    }

    /* JADX WARN: Removed duplicated region for block: B:34:0x008f A[Catch: all -> 0x0068, DONT_GENERATE, TryCatch #0 {all -> 0x0068, blocks: (B:14:0x003f, B:16:0x004d, B:18:0x0053, B:20:0x0092, B:26:0x006a, B:28:0x007a, B:32:0x0089, B:34:0x008f, B:38:0x009f, B:40:0x00a8, B:41:0x00a5, B:30:0x0080), top: B:13:0x003f, inners: #1 }] */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final void b(o8.d r6, java.lang.Object r7, w8.l r8) {
        /*
            boolean r0 = r6 instanceof kotlinx.coroutines.internal.f
            if (r0 == 0) goto Lb2
            kotlinx.coroutines.internal.f r6 = (kotlinx.coroutines.internal.f) r6
            java.lang.Object r8 = G8.F.c(r7, r8)
            G8.H r0 = r6.e
            o8.g r1 = r6.getContext()
            boolean r0 = r0.d0(r1)
            r1 = 1
            if (r0 == 0) goto L26
            r6.g = r8
            r6.d = r1
            G8.H r7 = r6.e
            o8.g r8 = r6.getContext()
            r7.c0(r8, r6)
            goto Lb5
        L26:
            G8.U0 r0 = G8.U0.a
            G8.h0 r0 = r0.b()
            boolean r2 = r0.m0()
            if (r2 == 0) goto L3b
            r6.g = r8
            r6.d = r1
            r0.i0(r6)
            goto Lb5
        L3b:
            r0.k0(r1)
            r2 = 0
            o8.g r3 = r6.getContext()     // Catch: java.lang.Throwable -> L68
            G8.x0$b r4 = G8.x0.b0     // Catch: java.lang.Throwable -> L68
            o8.g$b r3 = r3.a(r4)     // Catch: java.lang.Throwable -> L68
            G8.x0 r3 = (G8.x0) r3     // Catch: java.lang.Throwable -> L68
            if (r3 == 0) goto L6a
            boolean r4 = r3.isActive()     // Catch: java.lang.Throwable -> L68
            if (r4 != 0) goto L6a
            java.util.concurrent.CancellationException r7 = r3.h()     // Catch: java.lang.Throwable -> L68
            r6.a(r8, r7)     // Catch: java.lang.Throwable -> L68
            k8.j$a r8 = k8.j.c     // Catch: java.lang.Throwable -> L68
            java.lang.Object r7 = k8.k.a(r7)     // Catch: java.lang.Throwable -> L68
            java.lang.Object r7 = k8.j.b(r7)     // Catch: java.lang.Throwable -> L68
            r6.resumeWith(r7)     // Catch: java.lang.Throwable -> L68
            goto L92
        L68:
            r7 = move-exception
            goto La9
        L6a:
            o8.d r8 = r6.f     // Catch: java.lang.Throwable -> L68
            java.lang.Object r3 = r6.h     // Catch: java.lang.Throwable -> L68
            o8.g r4 = r8.getContext()     // Catch: java.lang.Throwable -> L68
            java.lang.Object r3 = kotlinx.coroutines.internal.C.c(r4, r3)     // Catch: java.lang.Throwable -> L68
            kotlinx.coroutines.internal.y r5 = kotlinx.coroutines.internal.C.a     // Catch: java.lang.Throwable -> L68
            if (r3 == r5) goto L7f
            G8.b1 r8 = G8.G.g(r8, r4, r3)     // Catch: java.lang.Throwable -> L68
            goto L80
        L7f:
            r8 = r2
        L80:
            o8.d r5 = r6.f     // Catch: java.lang.Throwable -> L9c
            r5.resumeWith(r7)     // Catch: java.lang.Throwable -> L9c
            k8.q r7 = k8.q.a     // Catch: java.lang.Throwable -> L9c
            if (r8 == 0) goto L8f
            boolean r7 = r8.P0()     // Catch: java.lang.Throwable -> L68
            if (r7 == 0) goto L92
        L8f:
            kotlinx.coroutines.internal.C.a(r4, r3)     // Catch: java.lang.Throwable -> L68
        L92:
            boolean r7 = r0.p0()     // Catch: java.lang.Throwable -> L68
            if (r7 != 0) goto L92
        L98:
            r0.f0(r1)
            goto Lb5
        L9c:
            r7 = move-exception
            if (r8 == 0) goto La5
            boolean r8 = r8.P0()     // Catch: java.lang.Throwable -> L68
            if (r8 == 0) goto La8
        La5:
            kotlinx.coroutines.internal.C.a(r4, r3)     // Catch: java.lang.Throwable -> L68
        La8:
            throw r7     // Catch: java.lang.Throwable -> L68
        La9:
            r6.g(r7, r2)     // Catch: java.lang.Throwable -> Lad
            goto L98
        Lad:
            r6 = move-exception
            r0.f0(r1)
            throw r6
        Lb2:
            r6.resumeWith(r7)
        Lb5:
            return
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.internal.g.b(o8.d, java.lang.Object, w8.l):void");
    }

    public static /* synthetic */ void c(o8.d dVar, Object obj, w8.l lVar, int i, Object obj2) {
        if ((i & 2) != 0) {
            lVar = null;
        }
        b(dVar, obj, lVar);
    }
}
