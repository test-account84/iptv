package v6;

import G8.L;
import G8.i;
import b0.d;
import k8.k;
import k8.q;
import q8.l;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class g {
    public static final b c = new b(null);
    public static final d.a d = b0.f.a("firebase_sessions_enabled");
    public static final d.a e = b0.f.b("firebase_sessions_sampling_rate");
    public static final d.a f = b0.f.d("firebase_sessions_restart_timeout");
    public static final d.a g = b0.f.d("firebase_sessions_cache_duration");
    public static final d.a h = b0.f.e("firebase_sessions_cache_updated_time");
    public final Y.f a;
    public e b;

    public static final class a extends l implements p {
        public Object a;
        public int c;

        public a(o8.d dVar) {
            super(2, dVar);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(L l, o8.d dVar) {
            return create(l, dVar).invokeSuspend(q.a);
        }

        public final o8.d create(Object obj, o8.d dVar) {
            return g.this.new a(dVar);
        }

        public final Object invokeSuspend(Object obj) {
            g gVar;
            Object d = p8.c.d();
            int i = this.c;
            if (i == 0) {
                k.b(obj);
                g gVar2 = g.this;
                kotlinx.coroutines.flow.b data = g.a(gVar2).getData();
                this.a = gVar2;
                this.c = 1;
                Object d2 = kotlinx.coroutines.flow.d.d(data, this);
                if (d2 == d) {
                    return d;
                }
                gVar = gVar2;
                obj = d2;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                gVar = (g) this.a;
                k.b(obj);
            }
            g.c(gVar, ((b0.d) obj).d());
            return q.a;
        }
    }

    public static final class b {
        public b() {
        }

        public /* synthetic */ b(kotlin.jvm.internal.g gVar) {
            this();
        }
    }

    public static final class c extends q8.d {
        public /* synthetic */ Object a;
        public int d;

        public c(o8.d dVar) {
            super(dVar);
        }

        public final Object invokeSuspend(Object obj) {
            this.a = obj;
            this.d |= Integer.MIN_VALUE;
            return g.b(g.this, null, null, this);
        }
    }

    public static final class d extends l implements p {
        public int a;
        public /* synthetic */ Object c;
        public final /* synthetic */ Object d;
        public final /* synthetic */ d.a e;
        public final /* synthetic */ g f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public d(Object obj, d.a aVar, g gVar, o8.d dVar) {
            super(2, dVar);
            this.d = obj;
            this.e = aVar;
            this.f = gVar;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(b0.a aVar, o8.d dVar) {
            return create(aVar, dVar).invokeSuspend(q.a);
        }

        public final o8.d create(Object obj, o8.d dVar) {
            d dVar2 = new d(this.d, this.e, this.f, dVar);
            dVar2.c = obj;
            return dVar2;
        }

        public final Object invokeSuspend(Object obj) {
            p8.c.d();
            if (this.a != 0) {
                throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
            }
            k.b(obj);
            b0.a aVar = (b0.a) this.c;
            Object obj2 = this.d;
            if (obj2 != null) {
                aVar.i(this.e, obj2);
            } else {
                aVar.h(this.e);
            }
            g.c(this.f, aVar);
            return q.a;
        }
    }

    public g(Y.f fVar) {
        kotlin.jvm.internal.l.e(fVar, "dataStore");
        this.a = fVar;
        i.f((o8.g) null, new a(null), 1, (Object) null);
    }

    public static final /* synthetic */ Y.f a(g gVar) {
        return gVar.a;
    }

    public static final /* synthetic */ Object b(g gVar, d.a aVar, Object obj, o8.d dVar) {
        return gVar.h(aVar, obj, dVar);
    }

    public static final /* synthetic */ void c(g gVar, b0.d dVar) {
        gVar.l(dVar);
    }

    public final boolean d() {
        e eVar = this.b;
        e eVar2 = null;
        if (eVar == null) {
            kotlin.jvm.internal.l.s("sessionConfigs");
            eVar = null;
        }
        Long b2 = eVar.b();
        e eVar3 = this.b;
        if (eVar3 == null) {
            kotlin.jvm.internal.l.s("sessionConfigs");
        } else {
            eVar2 = eVar3;
        }
        Integer a2 = eVar2.a();
        return b2 == null || a2 == null || (System.currentTimeMillis() - b2.longValue()) / ((long) 1000) >= ((long) a2.intValue());
    }

    public final Integer e() {
        e eVar = this.b;
        if (eVar == null) {
            kotlin.jvm.internal.l.s("sessionConfigs");
            eVar = null;
        }
        return eVar.d();
    }

    public final Double f() {
        e eVar = this.b;
        if (eVar == null) {
            kotlin.jvm.internal.l.s("sessionConfigs");
            eVar = null;
        }
        return eVar.e();
    }

    public final Boolean g() {
        e eVar = this.b;
        if (eVar == null) {
            kotlin.jvm.internal.l.s("sessionConfigs");
            eVar = null;
        }
        return eVar.c();
    }

    /* JADX WARN: Removed duplicated region for block: B:24:0x0013  */
    /*
        Code decompiled incorrectly, please refer to instructions dump.
        To view partially-correct code enable 'Show inconsistent code' option in preferences
    */
    public final java.lang.Object h(b0.d.a r6, java.lang.Object r7, o8.d r8) {
        /*
            r5 = this;
            boolean r0 = r8 instanceof v6.g.c
            if (r0 == 0) goto L13
            r0 = r8
            v6.g$c r0 = (v6.g.c) r0
            int r1 = r0.d
            r2 = -2147483648(0xffffffff80000000, float:-0.0)
            r3 = r1 & r2
            if (r3 == 0) goto L13
            int r1 = r1 - r2
            r0.d = r1
            goto L18
        L13:
            v6.g$c r0 = new v6.g$c
            r0.<init>(r8)
        L18:
            java.lang.Object r8 = r0.a
            java.lang.Object r1 = p8.c.d()
            int r2 = r0.d
            r3 = 1
            if (r2 == 0) goto L33
            if (r2 != r3) goto L2b
            k8.k.b(r8)     // Catch: java.io.IOException -> L29
            goto L5d
        L29:
            r6 = move-exception
            goto L47
        L2b:
            java.lang.IllegalStateException r6 = new java.lang.IllegalStateException
            java.lang.String r7 = "call to 'resume' before 'invoke' with coroutine"
            r6.<init>(r7)
            throw r6
        L33:
            k8.k.b(r8)
            Y.f r8 = r5.a     // Catch: java.io.IOException -> L29
            v6.g$d r2 = new v6.g$d     // Catch: java.io.IOException -> L29
            r4 = 0
            r2.<init>(r7, r6, r5, r4)     // Catch: java.io.IOException -> L29
            r0.d = r3     // Catch: java.io.IOException -> L29
            java.lang.Object r6 = b0.g.a(r8, r2, r0)     // Catch: java.io.IOException -> L29
            if (r6 != r1) goto L5d
            return r1
        L47:
            java.lang.StringBuilder r7 = new java.lang.StringBuilder
            r7.<init>()
            java.lang.String r8 = "Failed to update cache config value: "
            r7.append(r8)
            r7.append(r6)
            java.lang.String r6 = r7.toString()
            java.lang.String r7 = "SettingsCache"
            android.util.Log.w(r7, r6)
        L5d:
            k8.q r6 = k8.q.a
            return r6
        */
        throw new UnsupportedOperationException("Method not decompiled: v6.g.h(b0.d$a, java.lang.Object, o8.d):java.lang.Object");
    }

    public final Object i(Double d2, o8.d dVar) {
        Object h2 = h(e, d2, dVar);
        return h2 == p8.c.d() ? h2 : q.a;
    }

    public final Object j(Integer num, o8.d dVar) {
        Object h2 = h(g, num, dVar);
        return h2 == p8.c.d() ? h2 : q.a;
    }

    public final Object k(Long l, o8.d dVar) {
        Object h2 = h(h, l, dVar);
        return h2 == p8.c.d() ? h2 : q.a;
    }

    public final void l(b0.d dVar) {
        this.b = new e((Boolean) dVar.b(d), (Double) dVar.b(e), (Integer) dVar.b(f), (Integer) dVar.b(g), (Long) dVar.b(h));
    }

    public final Object m(Integer num, o8.d dVar) {
        Object h2 = h(f, num, dVar);
        return h2 == p8.c.d() ? h2 : q.a;
    }

    public final Object n(Boolean bool, o8.d dVar) {
        Object h2 = h(d, bool, dVar);
        return h2 == p8.c.d() ? h2 : q.a;
    }
}
