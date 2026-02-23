package v6;

import C8.i;
import F8.a;
import G8.L;
import android.content.Context;
import kotlin.jvm.internal.C;
import kotlin.jvm.internal.w;
import w8.l;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class f {
    public static final a c = new a(null);
    public static final y8.a d = a0.a.b("firebase_session_settings", (Z.b) null, (l) null, (L) null, 14, (Object) null);
    public final h a;
    public final h b;

    public static final class a {
        public static final /* synthetic */ i[] a = {C.g(new w(a.class, "dataStore", "getDataStore(Landroid/content/Context;)Landroidx/datastore/core/DataStore;", 0))};

        public a() {
        }

        public static final /* synthetic */ Y.f a(a aVar, Context context) {
            return aVar.b(context);
        }

        public final Y.f b(Context context) {
            return (Y.f) f.a().a(context, a[0]);
        }

        public /* synthetic */ a(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public static final class b extends q8.d {
        public Object a;
        public /* synthetic */ Object c;
        public int e;

        public b(o8.d dVar) {
            super(dVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.c = obj;
            this.e |= Integer.MIN_VALUE;
            return f.this.g(this);
        }
    }

    /* JADX WARN: 'this' call moved to the top of the method (can break code semantics) */
    public f(Context context, o8.g gVar, o8.g gVar2, k6.h hVar, t6.b bVar) {
        this(new v6.b(context), new c(gVar2, hVar, bVar, new d(bVar, gVar, null, 4, null), a.a(c, context)));
        kotlin.jvm.internal.l.e(context, "context");
        kotlin.jvm.internal.l.e(gVar, "blockingDispatcher");
        kotlin.jvm.internal.l.e(gVar2, "backgroundDispatcher");
        kotlin.jvm.internal.l.e(hVar, "firebaseInstallationsApi");
        kotlin.jvm.internal.l.e(bVar, "appInfo");
    }

    public static final /* synthetic */ y8.a a() {
        return d;
    }

    public final double b() {
        Double c2 = this.a.c();
        if (c2 != null) {
            double doubleValue = c2.doubleValue();
            if (e(doubleValue)) {
                return doubleValue;
            }
        }
        Double c3 = this.b.c();
        if (c3 == null) {
            return 1.0d;
        }
        double doubleValue2 = c3.doubleValue();
        if (e(doubleValue2)) {
            return doubleValue2;
        }
        return 1.0d;
    }

    public final long c() {
        F8.a b2 = this.a.b();
        if (b2 != null) {
            long G = b2.G();
            if (f(G)) {
                return G;
            }
        }
        F8.a b3 = this.b.b();
        if (b3 != null) {
            long G2 = b3.G();
            if (f(G2)) {
                return G2;
            }
        }
        a.a aVar = F8.a.c;
        return F8.c.o(30, F8.d.MINUTES);
    }

    public final boolean d() {
        Boolean a2 = this.a.a();
        if (a2 != null) {
            return a2.booleanValue();
        }
        Boolean a3 = this.b.a();
        if (a3 != null) {
            return a3.booleanValue();
        }
        return true;
    }

    public final boolean e(double d2) {
        return 0.0d <= d2 && d2 <= 1.0d;
    }

    public final boolean f(long j) {
        return F8.a.A(j) && F8.a.v(j);
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object g(o8.d r6) {
        /*
            r5 = this;
            boolean r0 = r6 instanceof v6.f.b
            if (r0 == 0) goto L13
            r0 = r6
            v6.f$b r0 = (v6.f.b) r0
            int r1 = r0.e
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.e = r1
            goto L18
        L13:
            v6.f$b r0 = new v6.f$b
            r0.<init>(r6)
        L18:
            java.lang.Object r6 = r0.c
            java.lang.Object r1 = p8.c.d()
            int r2 = r0.e
            r3 = 2
            r4 = 1
            if (r2 == 0) goto L3c
            if (r2 == r4) goto L34
            if (r2 != r3) goto L2c
            k8.k.b(r6)
            goto L5b
        L2c:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r0 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r0)
            throw r6
        L34:
            java.lang.Object r2 = r0.a
            v6.f r2 = (v6.f) r2
            k8.k.b(r6)
            goto L4d
        L3c:
            k8.k.b(r6)
            v6.h r6 = r5.a
            r0.a = r5
            r0.e = r4
            java.lang.Object r6 = r6.d(r0)
            if (r6 != r1) goto L4c
            return r1
        L4c:
            r2 = r5
        L4d:
            v6.h r6 = r2.b
            r2 = 0
            r0.a = r2
            r0.e = r3
            java.lang.Object r6 = r6.d(r0)
            if (r6 != r1) goto L5b
            return r1
        L5b:
            k8.q r6 = k8.q.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: v6.f.g(o8.d):java.lang.Object");
    }

    public f(h hVar, h hVar2) {
        kotlin.jvm.internal.l.e(hVar, "localOverrideSettings");
        kotlin.jvm.internal.l.e(hVar2, "remoteSettings");
        this.a = hVar;
        this.b = hVar2;
    }
}
