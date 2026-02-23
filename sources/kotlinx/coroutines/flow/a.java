package kotlinx.coroutines.flow;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract class a implements b {

    public static final class a extends q8.d {
        public Object a;
        public /* synthetic */ Object c;
        public int e;

        public a(o8.d dVar) {
            super(dVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return a.this.b(null, this);
        }
    }

    public abstract Object a(c cVar, o8.d dVar);

    /* JADX WARN: Removed duplicated region for block: B:30:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object b(kotlinx.coroutines.flow.c r6, o8.d r7) {
        /*
            r5 = this;
            boolean r0 = r7 instanceof kotlinx.coroutines.flow.a.a
            if (r0 == 0) goto L13
            r0 = r7
            kotlinx.coroutines.flow.a$a r0 = (kotlinx.coroutines.flow.a.a) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.a$a r0 = new kotlinx.coroutines.flow.a$a
            r0.<init>(r7)
        L18:
            java.lang.Object r7 = r0.c
            java.lang.Object r1 = p8.c.d()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L37
            if (r2 != r3) goto L2f
            java.lang.Object r6 = r0.a
            J8.i r6 = (J8.i) r6
            k8.k.b(r7)     // Catch: java.lang.Throwable -> L2d
            goto L4f
        L2d:
            r7 = move-exception
            goto L59
        L2f:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L37:
            k8.k.b(r7)
            J8.i r7 = new J8.i
            o8.g r2 = r0.getContext()
            r7.<init>(r6, r2)
            r0.a = r7     // Catch: java.lang.Throwable -> L55
            r0.e = r3     // Catch: java.lang.Throwable -> L55
            java.lang.Object r6 = r5.a(r7, r0)     // Catch: java.lang.Throwable -> L55
            if (r6 != r1) goto L4e
            return r1
        L4e:
            r6 = r7
        L4f:
            r6.releaseIntercepted()
            k8.q r6 = k8.q.a
            return r6
        L55:
            r6 = move-exception
            r4 = r7
            r7 = r6
            r6 = r4
        L59:
            r6.releaseIntercepted()
            throw r7
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.a.b(kotlinx.coroutines.flow.c, o8.d):java.lang.Object");
    }
}
