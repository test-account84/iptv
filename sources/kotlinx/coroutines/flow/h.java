package kotlinx.coroutines.flow;

import k8.q;
import kotlin.jvm.internal.y;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public abstract /* synthetic */ class h {

    public static final class a implements kotlinx.coroutines.flow.b {
        public final /* synthetic */ kotlinx.coroutines.flow.b a;
        public final /* synthetic */ p c;

        public a(kotlinx.coroutines.flow.b bVar, p pVar) {
            this.a = bVar;
            this.c = pVar;
        }

        public Object b(c cVar, o8.d dVar) {
            Object b = this.a.b(new b(new y(), cVar, this.c), dVar);
            return b == p8.c.d() ? b : q.a;
        }
    }

    public static final class b implements c {
        public final /* synthetic */ y a;
        public final /* synthetic */ c c;
        public final /* synthetic */ p d;

        public static final class a extends q8.d {
            public Object a;
            public Object c;
            public /* synthetic */ Object d;
            public int f;

            public a(o8.d dVar) {
                super(dVar);
            }

            public final Object invokeSuspend(Object obj) {
                this.d = obj;
                this.f |= Integer.MIN_VALUE;
                return b.this.a(null, this);
            }
        }

        public b(y yVar, c cVar, p pVar) {
            this.a = yVar;
            this.c = cVar;
            this.d = pVar;
        }

        /* JADX WARN: Removed duplicated region for block: B:20:0x0074  */
        /* JADX WARN: Removed duplicated region for block: B:23:0x008b  */
        /* JADX WARN: Removed duplicated region for block: B:37:0x0013  */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final java.lang.Object a(java.lang.Object r7, o8.d r8) {
            /*
                r6 = this;
                boolean r0 = r8 instanceof kotlinx.coroutines.flow.h.b.a
                if (r0 == 0) goto L13
                r0 = r8
                kotlinx.coroutines.flow.h$b$a r0 = (kotlinx.coroutines.flow.h.b.a) r0
                int r1 = r0.f
                r2 = -2147483648(0xffffffff80000000, float:-0.0)
                r3 = r1 & r2
                if (r3 == 0) goto L13
                int r1 = r1 - r2
                r0.f = r1
                goto L18
            L13:
                kotlinx.coroutines.flow.h$b$a r0 = new kotlinx.coroutines.flow.h$b$a
                r0.<init>(r8)
            L18:
                java.lang.Object r8 = r0.d
                java.lang.Object r1 = p8.c.d()
                int r2 = r0.f
                r3 = 3
                r4 = 2
                r5 = 1
                if (r2 == 0) goto L45
                if (r2 == r5) goto L41
                if (r2 == r4) goto L37
                if (r2 != r3) goto L2f
                k8.k.b(r8)
                goto L88
            L2f:
                java.lang.IllegalStateException r7 = new java.lang.IllegalStateException
                java.lang.String r8 = "call to 'resume' before 'invoke' with coroutine"
                r7.<init>(r8)
                throw r7
            L37:
                java.lang.Object r7 = r0.c
                java.lang.Object r2 = r0.a
                kotlinx.coroutines.flow.h$b r2 = (kotlinx.coroutines.flow.h.b) r2
                k8.k.b(r8)
                goto L6c
            L41:
                k8.k.b(r8)
                goto L59
            L45:
                k8.k.b(r8)
                kotlin.jvm.internal.y r8 = r6.a
                boolean r8 = r8.a
                if (r8 == 0) goto L5c
                kotlinx.coroutines.flow.c r8 = r6.c
                r0.f = r5
                java.lang.Object r7 = r8.a(r7, r0)
                if (r7 != r1) goto L59
                return r1
            L59:
                k8.q r7 = k8.q.a
                return r7
            L5c:
                w8.p r8 = r6.d
                r0.a = r6
                r0.c = r7
                r0.f = r4
                java.lang.Object r8 = r8.invoke(r7, r0)
                if (r8 != r1) goto L6b
                return r1
            L6b:
                r2 = r6
            L6c:
                java.lang.Boolean r8 = (java.lang.Boolean) r8
                boolean r8 = r8.booleanValue()
                if (r8 != 0) goto L8b
                kotlin.jvm.internal.y r8 = r2.a
                r8.a = r5
                kotlinx.coroutines.flow.c r8 = r2.c
                r2 = 0
                r0.a = r2
                r0.c = r2
                r0.f = r3
                java.lang.Object r7 = r8.a(r7, r0)
                if (r7 != r1) goto L88
                return r1
            L88:
                k8.q r7 = k8.q.a
                return r7
            L8b:
                k8.q r7 = k8.q.a
                return r7
            */
            throw new UnsupportedOperationException("Method not decompiled: kotlinx.coroutines.flow.h.b.a(java.lang.Object, o8.d):java.lang.Object");
        }
    }

    public static final kotlinx.coroutines.flow.b a(kotlinx.coroutines.flow.b bVar, p pVar) {
        return new a(bVar, pVar);
    }
}
