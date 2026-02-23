package t6;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class c implements d6.a {
    public static final d6.a a = new c();

    public static final class a implements c6.e {
        public static final a a = new a();
        public static final c6.d b = c6.d.d("packageName");
        public static final c6.d c = c6.d.d("versionName");
        public static final c6.d d = c6.d.d("appBuildVersion");
        public static final c6.d e = c6.d.d("deviceManufacturer");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(t6.a aVar, c6.f fVar) {
            fVar.add(b, aVar.c());
            fVar.add(c, aVar.d());
            fVar.add(d, aVar.a());
            fVar.add(e, aVar.b());
        }
    }

    public static final class b implements c6.e {
        public static final b a = new b();
        public static final c6.d b = c6.d.d("appId");
        public static final c6.d c = c6.d.d("deviceModel");
        public static final c6.d d = c6.d.d("sessionSdkVersion");
        public static final c6.d e = c6.d.d("osVersion");
        public static final c6.d f = c6.d.d("logEnvironment");
        public static final c6.d g = c6.d.d("androidAppInfo");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(t6.b bVar, c6.f fVar) {
            fVar.add(b, bVar.b());
            fVar.add(c, bVar.c());
            fVar.add(d, bVar.f());
            fVar.add(e, bVar.e());
            fVar.add(f, bVar.d());
            fVar.add(g, bVar.a());
        }
    }

    public static final class c implements c6.e {
        public static final c a = new c();
        public static final c6.d b = c6.d.d("performance");
        public static final c6.d c = c6.d.d("crashlytics");
        public static final c6.d d = c6.d.d("sessionSamplingRate");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(f fVar, c6.f fVar2) {
            fVar2.add(b, fVar.b());
            fVar2.add(c, fVar.a());
            fVar2.add(d, fVar.c());
        }
    }

    public static final class d implements c6.e {
        public static final d a = new d();
        public static final c6.d b = c6.d.d("eventType");
        public static final c6.d c = c6.d.d("sessionData");
        public static final c6.d d = c6.d.d("applicationInfo");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(r rVar, c6.f fVar) {
            fVar.add(b, rVar.b());
            fVar.add(c, rVar.c());
            fVar.add(d, rVar.a());
        }
    }

    public static final class e implements c6.e {
        public static final e a = new e();
        public static final c6.d b = c6.d.d("sessionId");
        public static final c6.d c = c6.d.d("firstSessionId");
        public static final c6.d d = c6.d.d("sessionIndex");
        public static final c6.d e = c6.d.d("eventTimestampUs");
        public static final c6.d f = c6.d.d("dataCollectionStatus");
        public static final c6.d g = c6.d.d("firebaseInstallationId");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(u uVar, c6.f fVar) {
            fVar.add(b, uVar.e());
            fVar.add(c, uVar.d());
            fVar.add(d, uVar.f());
            fVar.add(e, uVar.b());
            fVar.add(f, uVar.a());
            fVar.add(g, uVar.c());
        }
    }

    public void configure(d6.b bVar) {
        bVar.registerEncoder(r.class, d.a);
        bVar.registerEncoder(u.class, e.a);
        bVar.registerEncoder(f.class, c.a);
        bVar.registerEncoder(t6.b.class, b.a);
        bVar.registerEncoder(t6.a.class, a.a);
    }
}
