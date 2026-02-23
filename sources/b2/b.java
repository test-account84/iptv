package B2;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class b implements d6.a {
    public static final d6.a a = new b();

    public static final class a implements c6.e {
        public static final a a = new a();
        public static final c6.d b = c6.d.d("sdkVersion");
        public static final c6.d c = c6.d.d("model");
        public static final c6.d d = c6.d.d("hardware");
        public static final c6.d e = c6.d.d("device");
        public static final c6.d f = c6.d.d("product");
        public static final c6.d g = c6.d.d("osBuild");
        public static final c6.d h = c6.d.d("manufacturer");
        public static final c6.d i = c6.d.d("fingerprint");
        public static final c6.d j = c6.d.d("locale");
        public static final c6.d k = c6.d.d("country");
        public static final c6.d l = c6.d.d("mccMnc");
        public static final c6.d m = c6.d.d("applicationBuild");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B2.a aVar, c6.f fVar) {
            fVar.add(b, aVar.m());
            fVar.add(c, aVar.j());
            fVar.add(d, aVar.f());
            fVar.add(e, aVar.d());
            fVar.add(f, aVar.l());
            fVar.add(g, aVar.k());
            fVar.add(h, aVar.h());
            fVar.add(i, aVar.e());
            fVar.add(j, aVar.g());
            fVar.add(k, aVar.c());
            fVar.add(l, aVar.i());
            fVar.add(m, aVar.b());
        }
    }

    public static final class b implements c6.e {
        public static final b a = new b();
        public static final c6.d b = c6.d.d("logRequest");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(j jVar, c6.f fVar) {
            fVar.add(b, jVar.c());
        }
    }

    public static final class c implements c6.e {
        public static final c a = new c();
        public static final c6.d b = c6.d.d("clientType");
        public static final c6.d c = c6.d.d("androidClientInfo");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(k kVar, c6.f fVar) {
            fVar.add(b, kVar.c());
            fVar.add(c, kVar.b());
        }
    }

    public static final class d implements c6.e {
        public static final d a = new d();
        public static final c6.d b = c6.d.d("eventTimeMs");
        public static final c6.d c = c6.d.d("eventCode");
        public static final c6.d d = c6.d.d("eventUptimeMs");
        public static final c6.d e = c6.d.d("sourceExtension");
        public static final c6.d f = c6.d.d("sourceExtensionJsonProto3");
        public static final c6.d g = c6.d.d("timezoneOffsetSeconds");
        public static final c6.d h = c6.d.d("networkConnectionInfo");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(l lVar, c6.f fVar) {
            fVar.add(b, lVar.c());
            fVar.add(c, lVar.b());
            fVar.add(d, lVar.d());
            fVar.add(e, lVar.f());
            fVar.add(f, lVar.g());
            fVar.add(g, lVar.h());
            fVar.add(h, lVar.e());
        }
    }

    public static final class e implements c6.e {
        public static final e a = new e();
        public static final c6.d b = c6.d.d("requestTimeMs");
        public static final c6.d c = c6.d.d("requestUptimeMs");
        public static final c6.d d = c6.d.d("clientInfo");
        public static final c6.d e = c6.d.d("logSource");
        public static final c6.d f = c6.d.d("logSourceName");
        public static final c6.d g = c6.d.d("logEvent");
        public static final c6.d h = c6.d.d("qosTier");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(m mVar, c6.f fVar) {
            fVar.add(b, mVar.g());
            fVar.add(c, mVar.h());
            fVar.add(d, mVar.b());
            fVar.add(e, mVar.d());
            fVar.add(f, mVar.e());
            fVar.add(g, mVar.c());
            fVar.add(h, mVar.f());
        }
    }

    public static final class f implements c6.e {
        public static final f a = new f();
        public static final c6.d b = c6.d.d("networkType");
        public static final c6.d c = c6.d.d("mobileSubtype");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(o oVar, c6.f fVar) {
            fVar.add(b, oVar.c());
            fVar.add(c, oVar.b());
        }
    }

    public void configure(d6.b bVar) {
        b bVar2 = b.a;
        bVar.registerEncoder(j.class, bVar2);
        bVar.registerEncoder(B2.d.class, bVar2);
        e eVar = e.a;
        bVar.registerEncoder(m.class, eVar);
        bVar.registerEncoder(g.class, eVar);
        c cVar = c.a;
        bVar.registerEncoder(k.class, cVar);
        bVar.registerEncoder(B2.e.class, cVar);
        a aVar = a.a;
        bVar.registerEncoder(B2.a.class, aVar);
        bVar.registerEncoder(B2.c.class, aVar);
        d dVar = d.a;
        bVar.registerEncoder(l.class, dVar);
        bVar.registerEncoder(B2.f.class, dVar);
        f fVar = f.a;
        bVar.registerEncoder(o.class, fVar);
        bVar.registerEncoder(i.class, fVar);
    }
}
