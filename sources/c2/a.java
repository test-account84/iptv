package C2;

import d.D;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a implements d6.a {
    public static final d6.a a = new a();

    public static final class a implements c6.e {
        public static final a a = new a();
        public static final c6.d b = c6.d.a("window").b(f6.a.b().c(1).a()).a();
        public static final c6.d c = c6.d.a("logSourceMetrics").b(f6.a.b().c(2).a()).a();
        public static final c6.d d = c6.d.a("globalMetrics").b(f6.a.b().c(3).a()).a();
        public static final c6.d e = c6.d.a("appNamespace").b(f6.a.b().c(4).a()).a();

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(F2.a aVar, c6.f fVar) {
            fVar.add(b, aVar.d());
            fVar.add(c, aVar.c());
            fVar.add(d, aVar.b());
            fVar.add(e, aVar.a());
        }
    }

    public static final class b implements c6.e {
        public static final b a = new b();
        public static final c6.d b = c6.d.a("storageMetrics").b(f6.a.b().c(1).a()).a();

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(F2.b bVar, c6.f fVar) {
            fVar.add(b, bVar.a());
        }
    }

    public static final class c implements c6.e {
        public static final c a = new c();
        public static final c6.d b = c6.d.a("eventsDroppedCount").b(f6.a.b().c(1).a()).a();
        public static final c6.d c = c6.d.a("reason").b(f6.a.b().c(3).a()).a();

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(F2.c cVar, c6.f fVar) {
            fVar.add(b, cVar.a());
            fVar.add(c, cVar.b());
        }
    }

    public static final class d implements c6.e {
        public static final d a = new d();
        public static final c6.d b = c6.d.a("logSource").b(f6.a.b().c(1).a()).a();
        public static final c6.d c = c6.d.a("logEventDropped").b(f6.a.b().c(2).a()).a();

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(F2.d dVar, c6.f fVar) {
            fVar.add(b, dVar.b());
            fVar.add(c, dVar.a());
        }
    }

    public static final class e implements c6.e {
        public static final e a = new e();
        public static final c6.d b = c6.d.d("clientMetrics");

        public void a(m mVar, c6.f fVar) {
            throw null;
        }

        public /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) {
            D.a(obj);
            a(null, (c6.f) obj2);
        }
    }

    public static final class f implements c6.e {
        public static final f a = new f();
        public static final c6.d b = c6.d.a("currentCacheSizeBytes").b(f6.a.b().c(1).a()).a();
        public static final c6.d c = c6.d.a("maxCacheSizeBytes").b(f6.a.b().c(2).a()).a();

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(F2.e eVar, c6.f fVar) {
            fVar.add(b, eVar.a());
            fVar.add(c, eVar.b());
        }
    }

    public static final class g implements c6.e {
        public static final g a = new g();
        public static final c6.d b = c6.d.a("startMs").b(f6.a.b().c(1).a()).a();
        public static final c6.d c = c6.d.a("endMs").b(f6.a.b().c(2).a()).a();

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(F2.f fVar, c6.f fVar2) {
            fVar2.add(b, fVar.b());
            fVar2.add(c, fVar.a());
        }
    }

    public void configure(d6.b bVar) {
        bVar.registerEncoder(m.class, e.a);
        bVar.registerEncoder(F2.a.class, a.a);
        bVar.registerEncoder(F2.f.class, g.a);
        bVar.registerEncoder(F2.d.class, d.a);
        bVar.registerEncoder(F2.c.class, c.a);
        bVar.registerEncoder(F2.b.class, b.a);
        bVar.registerEncoder(F2.e.class, f.a);
    }
}
