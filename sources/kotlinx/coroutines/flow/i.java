package kotlinx.coroutines.flow;

import kotlin.jvm.internal.B;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract /* synthetic */ class i {

    public static final class a implements c {
        public final /* synthetic */ B a;

        public a(B b) {
            this.a = b;
        }

        public Object a(Object obj, o8.d dVar) {
            this.a.a = obj;
            throw new J8.a(this);
        }
    }

    public static final class b extends q8.d {
        public Object a;
        public Object c;
        public /* synthetic */ Object d;
        public int e;

        public b(o8.d dVar) {
            super(dVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.d = obj;
            this.e |= Integer.MIN_VALUE;
            return d.d(null, this);
        }
    }

    /* JADX WARN: Removed duplicated region for block: B:14:0x0068 A[RETURN] */
    /* JADX WARN: Removed duplicated region for block: B:16:0x0069  */
    /* JADX WARN: Removed duplicated region for block: B:32:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public static final java.lang.Object a(kotlinx.coroutines.flow.b r4, o8.d r5) {
        /*
            boolean r0 = r5 instanceof kotlinx.coroutines.flow.i.b
            if (r0 == 0) goto L13
            r0 = r5
            kotlinx.coroutines.flow.i$b r0 = (kotlinx.coroutines.flow.i.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            kotlinx.coroutines.flow.i$b r0 = new kotlinx.coroutines.flow.i$b
            r0.<init>(r5)
        L18:
            java.lang.Object r5 = r0.d
            java.lang.Object r1 = p8.c.d()
            int r2 = r0.e
            r3 = 1
            if (r2 == 0) goto L3b
            if (r2 != r3) goto L33
            java.lang.Object r4 = r0.c
            kotlinx.coroutines.flow.i$a r4 = (kotlinx.coroutines.flow.i.a) r4
            java.lang.Object r0 = r0.a
            kotlin.jvm.internal.B r0 = (kotlin.jvm.internal.B) r0
            k8.k.b(r5)     // Catch: J8.a -> L31
            goto L62
        L31:
            r5 = move-exception
            goto L5f
        L33:
            java.lang.IllegalStateException r4 = new java.lang.IllegalStateException
            java.lang.String r5 = "call to 'resume' before 'invoke' with coroutine"
            r4.<init>(r5)
            throw r4
        L3b:
            k8.k.b(r5)
            kotlin.jvm.internal.B r5 = new kotlin.jvm.internal.B
            r5.<init>()
            kotlinx.coroutines.internal.y r2 = J8.h.a
            r5.a = r2
            kotlinx.coroutines.flow.i$a r2 = new kotlinx.coroutines.flow.i$a
            r2.<init>(r5)
            r0.a = r5     // Catch: J8.a -> L5b
            r0.c = r2     // Catch: J8.a -> L5b
            r0.e = r3     // Catch: J8.a -> L5b
            java.lang.Object r4 = r4.b(r2, r0)     // Catch: J8.a -> L5b
            if (r4 != r1) goto L59
            return r1
        L59:
            r0 = r5
            goto L62
        L5b:
            r4 = move-exception
            r0 = r5
            r5 = r4
            r4 = r2
        L5f:
            J8.f.a(r5, r4)
        L62:
            java.lang.Object r4 = r0.a
            kotlinx.coroutines.internal.y r5 = J8.h.a
            if (r4 == r5) goto L69
            return r4
        L69:
            java.util.NoSuchElementException r4 = new java.util.NoSuchElementException
            java.lang.String r5 = "Expected at least one element"
            r4.<init>(r5)
            throw r4
        */
        throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.i.a(kotlinx.coroutines.flow.b, o8.d):java.lang.Object");
    }
}
