package Q5;

import Q5.B;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class a implements d6.a {
    public static final d6.a a = new a();

    public static final class a implements c6.e {
        public static final a a = new a();
        public static final c6.d b = c6.d.d("arch");
        public static final c6.d c = c6.d.d("libraryName");
        public static final c6.d d = c6.d.d("buildId");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B.a.a aVar, c6.f fVar) {
            fVar.add(b, aVar.b());
            fVar.add(c, aVar.d());
            fVar.add(d, aVar.c());
        }
    }

    public static final class b implements c6.e {
        public static final b a = new b();
        public static final c6.d b = c6.d.d("pid");
        public static final c6.d c = c6.d.d("processName");
        public static final c6.d d = c6.d.d("reasonCode");
        public static final c6.d e = c6.d.d("importance");
        public static final c6.d f = c6.d.d("pss");
        public static final c6.d g = c6.d.d("rss");
        public static final c6.d h = c6.d.d("timestamp");
        public static final c6.d i = c6.d.d("traceFile");
        public static final c6.d j = c6.d.d("buildIdMappingForArch");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B.a aVar, c6.f fVar) {
            fVar.add(b, aVar.d());
            fVar.add(c, aVar.e());
            fVar.add(d, aVar.g());
            fVar.add(e, aVar.c());
            fVar.add(f, aVar.f());
            fVar.add(g, aVar.h());
            fVar.add(h, aVar.i());
            fVar.add(i, aVar.j());
            fVar.add(j, aVar.b());
        }
    }

    public static final class c implements c6.e {
        public static final c a = new c();
        public static final c6.d b = c6.d.d("key");
        public static final c6.d c = c6.d.d("value");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B.c cVar, c6.f fVar) {
            fVar.add(b, cVar.b());
            fVar.add(c, cVar.c());
        }
    }

    public static final class d implements c6.e {
        public static final d a = new d();
        public static final c6.d b = c6.d.d("sdkVersion");
        public static final c6.d c = c6.d.d("gmpAppId");
        public static final c6.d d = c6.d.d("platform");
        public static final c6.d e = c6.d.d("installationUuid");
        public static final c6.d f = c6.d.d("firebaseInstallationId");
        public static final c6.d g = c6.d.d("buildVersion");
        public static final c6.d h = c6.d.d("displayVersion");
        public static final c6.d i = c6.d.d("session");
        public static final c6.d j = c6.d.d("ndkPayload");
        public static final c6.d k = c6.d.d("appExitInfo");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B b2, c6.f fVar) {
            fVar.add(b, b2.k());
            fVar.add(c, b2.g());
            fVar.add(d, b2.j());
            fVar.add(e, b2.h());
            fVar.add(f, b2.f());
            fVar.add(g, b2.d());
            fVar.add(h, b2.e());
            fVar.add(i, b2.l());
            fVar.add(j, b2.i());
            fVar.add(k, b2.c());
        }
    }

    public static final class e implements c6.e {
        public static final e a = new e();
        public static final c6.d b = c6.d.d("files");
        public static final c6.d c = c6.d.d("orgId");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B.d dVar, c6.f fVar) {
            fVar.add(b, dVar.b());
            fVar.add(c, dVar.c());
        }
    }

    public static final class f implements c6.e {
        public static final f a = new f();
        public static final c6.d b = c6.d.d("filename");
        public static final c6.d c = c6.d.d("contents");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B.d.b bVar, c6.f fVar) {
            fVar.add(b, bVar.c());
            fVar.add(c, bVar.b());
        }
    }

    public static final class g implements c6.e {
        public static final g a = new g();
        public static final c6.d b = c6.d.d("identifier");
        public static final c6.d c = c6.d.d("version");
        public static final c6.d d = c6.d.d("displayVersion");
        public static final c6.d e = c6.d.d("organization");
        public static final c6.d f = c6.d.d("installationUuid");
        public static final c6.d g = c6.d.d("developmentPlatform");
        public static final c6.d h = c6.d.d("developmentPlatformVersion");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B.e.a aVar, c6.f fVar) {
            fVar.add(b, aVar.e());
            fVar.add(c, aVar.h());
            fVar.add(d, aVar.d());
            c6.d dVar = e;
            aVar.g();
            fVar.add(dVar, (Object) null);
            fVar.add(f, aVar.f());
            fVar.add(g, aVar.b());
            fVar.add(h, aVar.c());
        }
    }

    public static final class h implements c6.e {
        public static final h a = new h();
        public static final c6.d b = c6.d.d("clsId");

        public void a(B.e.a.b bVar, c6.f fVar) {
            throw null;
        }

        public /* bridge */ /* synthetic */ void encode(Object obj, Object obj2) {
            d.D.a(obj);
            a(null, (c6.f) obj2);
        }
    }

    public static final class i implements c6.e {
        public static final i a = new i();
        public static final c6.d b = c6.d.d("arch");
        public static final c6.d c = c6.d.d("model");
        public static final c6.d d = c6.d.d("cores");
        public static final c6.d e = c6.d.d("ram");
        public static final c6.d f = c6.d.d("diskSpace");
        public static final c6.d g = c6.d.d("simulator");
        public static final c6.d h = c6.d.d("state");
        public static final c6.d i = c6.d.d("manufacturer");
        public static final c6.d j = c6.d.d("modelClass");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B.e.c cVar, c6.f fVar) {
            fVar.add(b, cVar.b());
            fVar.add(c, cVar.f());
            fVar.add(d, cVar.c());
            fVar.add(e, cVar.h());
            fVar.add(f, cVar.d());
            fVar.add(g, cVar.j());
            fVar.add(h, cVar.i());
            fVar.add(i, cVar.e());
            fVar.add(j, cVar.g());
        }
    }

    public static final class j implements c6.e {
        public static final j a = new j();
        public static final c6.d b = c6.d.d("generator");
        public static final c6.d c = c6.d.d("identifier");
        public static final c6.d d = c6.d.d("appQualitySessionId");
        public static final c6.d e = c6.d.d("startedAt");
        public static final c6.d f = c6.d.d("endedAt");
        public static final c6.d g = c6.d.d("crashed");
        public static final c6.d h = c6.d.d("app");
        public static final c6.d i = c6.d.d("user");
        public static final c6.d j = c6.d.d("os");
        public static final c6.d k = c6.d.d("device");
        public static final c6.d l = c6.d.d("events");
        public static final c6.d m = c6.d.d("generatorType");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B.e eVar, c6.f fVar) {
            fVar.add(b, eVar.g());
            fVar.add(c, eVar.j());
            fVar.add(d, eVar.c());
            fVar.add(e, eVar.l());
            fVar.add(f, eVar.e());
            fVar.add(g, eVar.n());
            fVar.add(h, eVar.b());
            fVar.add(i, eVar.m());
            fVar.add(j, eVar.k());
            fVar.add(k, eVar.d());
            fVar.add(l, eVar.f());
            fVar.add(m, eVar.h());
        }
    }

    public static final class k implements c6.e {
        public static final k a = new k();
        public static final c6.d b = c6.d.d("execution");
        public static final c6.d c = c6.d.d("customAttributes");
        public static final c6.d d = c6.d.d("internalKeys");
        public static final c6.d e = c6.d.d("background");
        public static final c6.d f = c6.d.d("uiOrientation");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B.e.d.a aVar, c6.f fVar) {
            fVar.add(b, aVar.d());
            fVar.add(c, aVar.c());
            fVar.add(d, aVar.e());
            fVar.add(e, aVar.b());
            fVar.add(f, aVar.f());
        }
    }

    public static final class l implements c6.e {
        public static final l a = new l();
        public static final c6.d b = c6.d.d("baseAddress");
        public static final c6.d c = c6.d.d("size");
        public static final c6.d d = c6.d.d("name");
        public static final c6.d e = c6.d.d("uuid");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B.e.d.a.b.a aVar, c6.f fVar) {
            fVar.add(b, aVar.b());
            fVar.add(c, aVar.d());
            fVar.add(d, aVar.c());
            fVar.add(e, aVar.f());
        }
    }

    public static final class m implements c6.e {
        public static final m a = new m();
        public static final c6.d b = c6.d.d("threads");
        public static final c6.d c = c6.d.d("exception");
        public static final c6.d d = c6.d.d("appExitInfo");
        public static final c6.d e = c6.d.d("signal");
        public static final c6.d f = c6.d.d("binaries");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B.e.d.a.b bVar, c6.f fVar) {
            fVar.add(b, bVar.f());
            fVar.add(c, bVar.d());
            fVar.add(d, bVar.b());
            fVar.add(e, bVar.e());
            fVar.add(f, bVar.c());
        }
    }

    public static final class n implements c6.e {
        public static final n a = new n();
        public static final c6.d b = c6.d.d("type");
        public static final c6.d c = c6.d.d("reason");
        public static final c6.d d = c6.d.d("frames");
        public static final c6.d e = c6.d.d("causedBy");
        public static final c6.d f = c6.d.d("overflowCount");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B.e.d.a.b.c cVar, c6.f fVar) {
            fVar.add(b, cVar.f());
            fVar.add(c, cVar.e());
            fVar.add(d, cVar.c());
            fVar.add(e, cVar.b());
            fVar.add(f, cVar.d());
        }
    }

    public static final class o implements c6.e {
        public static final o a = new o();
        public static final c6.d b = c6.d.d("name");
        public static final c6.d c = c6.d.d("code");
        public static final c6.d d = c6.d.d("address");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B.e.d.a.b.d dVar, c6.f fVar) {
            fVar.add(b, dVar.d());
            fVar.add(c, dVar.c());
            fVar.add(d, dVar.b());
        }
    }

    public static final class p implements c6.e {
        public static final p a = new p();
        public static final c6.d b = c6.d.d("name");
        public static final c6.d c = c6.d.d("importance");
        public static final c6.d d = c6.d.d("frames");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B.e.d.a.b.e eVar, c6.f fVar) {
            fVar.add(b, eVar.d());
            fVar.add(c, eVar.c());
            fVar.add(d, eVar.b());
        }
    }

    public static final class q implements c6.e {
        public static final q a = new q();
        public static final c6.d b = c6.d.d("pc");
        public static final c6.d c = c6.d.d("symbol");
        public static final c6.d d = c6.d.d("file");
        public static final c6.d e = c6.d.d("offset");
        public static final c6.d f = c6.d.d("importance");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B.e.d.a.b.e.b bVar, c6.f fVar) {
            fVar.add(b, bVar.e());
            fVar.add(c, bVar.f());
            fVar.add(d, bVar.b());
            fVar.add(e, bVar.d());
            fVar.add(f, bVar.c());
        }
    }

    public static final class r implements c6.e {
        public static final r a = new r();
        public static final c6.d b = c6.d.d("batteryLevel");
        public static final c6.d c = c6.d.d("batteryVelocity");
        public static final c6.d d = c6.d.d("proximityOn");
        public static final c6.d e = c6.d.d("orientation");
        public static final c6.d f = c6.d.d("ramUsed");
        public static final c6.d g = c6.d.d("diskUsed");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B.e.d.c cVar, c6.f fVar) {
            fVar.add(b, cVar.b());
            fVar.add(c, cVar.c());
            fVar.add(d, cVar.g());
            fVar.add(e, cVar.e());
            fVar.add(f, cVar.f());
            fVar.add(g, cVar.d());
        }
    }

    public static final class s implements c6.e {
        public static final s a = new s();
        public static final c6.d b = c6.d.d("timestamp");
        public static final c6.d c = c6.d.d("type");
        public static final c6.d d = c6.d.d("app");
        public static final c6.d e = c6.d.d("device");
        public static final c6.d f = c6.d.d("log");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B.e.d dVar, c6.f fVar) {
            fVar.add(b, dVar.e());
            fVar.add(c, dVar.f());
            fVar.add(d, dVar.b());
            fVar.add(e, dVar.c());
            fVar.add(f, dVar.d());
        }
    }

    public static final class t implements c6.e {
        public static final t a = new t();
        public static final c6.d b = c6.d.d("content");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B.e.d.d dVar, c6.f fVar) {
            fVar.add(b, dVar.b());
        }
    }

    public static final class u implements c6.e {
        public static final u a = new u();
        public static final c6.d b = c6.d.d("platform");
        public static final c6.d c = c6.d.d("version");
        public static final c6.d d = c6.d.d("buildVersion");
        public static final c6.d e = c6.d.d("jailbroken");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B.e.e eVar, c6.f fVar) {
            fVar.add(b, eVar.c());
            fVar.add(c, eVar.d());
            fVar.add(d, eVar.b());
            fVar.add(e, eVar.e());
        }
    }

    public static final class v implements c6.e {
        public static final v a = new v();
        public static final c6.d b = c6.d.d("identifier");

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void encode(B.e.f fVar, c6.f fVar2) {
            fVar2.add(b, fVar.b());
        }
    }

    public void configure(d6.b bVar) {
        d dVar = d.a;
        bVar.registerEncoder(B.class, dVar);
        bVar.registerEncoder(Q5.b.class, dVar);
        j jVar = j.a;
        bVar.registerEncoder(B.e.class, jVar);
        bVar.registerEncoder(Q5.h.class, jVar);
        g gVar = g.a;
        bVar.registerEncoder(B.e.a.class, gVar);
        bVar.registerEncoder(Q5.i.class, gVar);
        h hVar = h.a;
        bVar.registerEncoder(B.e.a.b.class, hVar);
        bVar.registerEncoder(Q5.j.class, hVar);
        v vVar = v.a;
        bVar.registerEncoder(B.e.f.class, vVar);
        bVar.registerEncoder(w.class, vVar);
        u uVar = u.a;
        bVar.registerEncoder(B.e.e.class, uVar);
        bVar.registerEncoder(Q5.v.class, uVar);
        i iVar = i.a;
        bVar.registerEncoder(B.e.c.class, iVar);
        bVar.registerEncoder(Q5.k.class, iVar);
        s sVar = s.a;
        bVar.registerEncoder(B.e.d.class, sVar);
        bVar.registerEncoder(Q5.l.class, sVar);
        k kVar = k.a;
        bVar.registerEncoder(B.e.d.a.class, kVar);
        bVar.registerEncoder(Q5.m.class, kVar);
        m mVar = m.a;
        bVar.registerEncoder(B.e.d.a.b.class, mVar);
        bVar.registerEncoder(Q5.n.class, mVar);
        p pVar = p.a;
        bVar.registerEncoder(B.e.d.a.b.e.class, pVar);
        bVar.registerEncoder(Q5.r.class, pVar);
        q qVar = q.a;
        bVar.registerEncoder(B.e.d.a.b.e.b.class, qVar);
        bVar.registerEncoder(Q5.s.class, qVar);
        n nVar = n.a;
        bVar.registerEncoder(B.e.d.a.b.c.class, nVar);
        bVar.registerEncoder(Q5.p.class, nVar);
        b bVar2 = b.a;
        bVar.registerEncoder(B.a.class, bVar2);
        bVar.registerEncoder(Q5.c.class, bVar2);
        a aVar = a.a;
        bVar.registerEncoder(B.a.a.class, aVar);
        bVar.registerEncoder(Q5.d.class, aVar);
        o oVar = o.a;
        bVar.registerEncoder(B.e.d.a.b.d.class, oVar);
        bVar.registerEncoder(Q5.q.class, oVar);
        l lVar = l.a;
        bVar.registerEncoder(B.e.d.a.b.a.class, lVar);
        bVar.registerEncoder(Q5.o.class, lVar);
        c cVar = c.a;
        bVar.registerEncoder(B.c.class, cVar);
        bVar.registerEncoder(Q5.e.class, cVar);
        r rVar = r.a;
        bVar.registerEncoder(B.e.d.c.class, rVar);
        bVar.registerEncoder(Q5.t.class, rVar);
        t tVar = t.a;
        bVar.registerEncoder(B.e.d.d.class, tVar);
        bVar.registerEncoder(Q5.u.class, tVar);
        e eVar = e.a;
        bVar.registerEncoder(B.d.class, eVar);
        bVar.registerEncoder(Q5.f.class, eVar);
        f fVar = f.a;
        bVar.registerEncoder(B.d.b.class, fVar);
        bVar.registerEncoder(Q5.g.class, fVar);
    }
}
