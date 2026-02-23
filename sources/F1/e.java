package F1;

import d.D;
import java.util.ArrayList;
import java.util.Collection;
import java.util.Collections;
import java.util.Iterator;
import java.util.LinkedHashSet;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import java.util.WeakHashMap;
import java.util.concurrent.Executor;
import java.util.concurrent.locks.ReadWriteLock;
import java.util.concurrent.locks.ReentrantReadWriteLock;
import v1.f;
import z1.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class e implements z1.a, F1.d, F1.j {
    public final z1.h b;
    public final z1.c c;
    public final K1.d d;
    public final ReadWriteLock e;
    public final Set f;
    public final Executor g;
    public final F1.a h;
    public final E1.b i;

    public class a extends z1.e {
        public final /* synthetic */ v1.f d;
        public final /* synthetic */ f.a e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public a(Executor executor, v1.f fVar, f.a aVar) {
            super(executor);
            this.d = fVar;
            this.e = aVar;
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean d() {
            e.this.r(e.D(e.this, this.d, this.e, false, null));
            return Boolean.TRUE;
        }
    }

    public class b extends z1.e {
        public final /* synthetic */ z1.b d;
        public final /* synthetic */ f.b e;

        public class a implements F1.i {
            public a() {
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Set a(F1.j jVar) {
                b bVar = b.this;
                e eVar = e.this;
                bVar.getClass();
                b bVar2 = b.this;
                return e.E(eVar, null, bVar2.d, bVar2.e);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(Executor executor, v1.b bVar, z1.b bVar2, f.b bVar3) {
            super(executor);
            this.d = bVar2;
            this.e = bVar3;
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Set d() {
            return (Set) e.this.n(new a());
        }
    }

    public class c extends z1.e {
        public final /* synthetic */ z1.b d;
        public final /* synthetic */ f.b e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public c(Executor executor, v1.b bVar, z1.b bVar2, f.b bVar3) {
            super(executor);
            this.d = bVar2;
            this.e = bVar3;
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean d() {
            e.this.r(e.E(e.this, null, this.d, this.e));
            return Boolean.TRUE;
        }
    }

    public class d implements F1.i {
        public final /* synthetic */ v1.f a;

        public d(v1.f fVar) {
            this.a = fVar;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Object a(F1.d dVar) {
            String b = z1.c.rootKeyForOperation(this.a).b();
            y1.a aVar = y1.a.b;
            z1.i t = dVar.t(b, aVar);
            if (t == null) {
                return null;
            }
            return this.a.wrapData((f.a) this.a.responseFieldMapper().map(new K1.b(this.a.variables(), t, new H1.a(dVar, this.a.variables(), e.this.a(), aVar, e.y(e.this)), e.F(e.this), F1.h.h)));
        }
    }

    public class e implements F1.i {
        public final /* synthetic */ v1.f a;
        public final /* synthetic */ y1.a b;
        public final /* synthetic */ F1.h c;
        public final /* synthetic */ v1.l d;

        public e(v1.f fVar, y1.a aVar, F1.h hVar, v1.l lVar) {
            this.a = fVar;
            this.b = aVar;
            this.c = hVar;
            this.d = lVar;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public v1.i a(F1.d dVar) {
            z1.i t = dVar.t(z1.c.rootKeyForOperation(this.a).b(), this.b);
            if (t != null) {
                K1.b bVar = new K1.b(this.a.variables(), t, new H1.a(dVar, this.a.variables(), e.this.a(), this.b, e.y(e.this)), e.F(e.this), this.c);
                try {
                    this.c.p(this.a);
                    return v1.i.a(this.a).g(this.a.wrapData((f.a) this.d.map(bVar))).j(true).h(this.c.k()).f();
                } catch (Exception e) {
                    e.G(e.this).d(e, "Failed to read cache response", new Object[0]);
                }
            }
            return v1.i.a(this.a).j(true).f();
        }
    }

    public class f implements F1.i {
        public final /* synthetic */ z1.b a;
        public final /* synthetic */ f.b b;
        public final /* synthetic */ v1.l c;

        public f(z1.b bVar, f.b bVar2, v1.l lVar) {
            this.a = bVar;
            this.b = bVar2;
            this.c = lVar;
        }

        public /* bridge */ /* synthetic */ Object a(Object obj) {
            b((F1.d) obj);
            return null;
        }

        public v1.b b(F1.d dVar) {
            String b = this.a.b();
            y1.a aVar = y1.a.b;
            z1.i t = dVar.t(b, aVar);
            if (t == null) {
                return null;
            }
            D.a(this.c.map(new K1.b(this.b, t, new H1.a(dVar, this.b, e.this.a(), aVar, e.y(e.this)), e.F(e.this), F1.h.h)));
            return null;
        }
    }

    public class g extends F1.h {
        public g() {
        }

        public F1.a j() {
            return e.y(e.this);
        }

        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public z1.b n(v1.k kVar, Map map) {
            return e.x(e.this).fromFieldRecordSet(kVar, map);
        }
    }

    public class h implements F1.i {
        public final /* synthetic */ v1.f a;
        public final /* synthetic */ f.a b;
        public final /* synthetic */ boolean c;
        public final /* synthetic */ UUID d;

        public h(v1.f fVar, f.a aVar, boolean z, UUID uuid) {
            this.a = fVar;
            this.b = aVar;
            this.c = z;
            this.d = uuid;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Set a(F1.j jVar) {
            F1.b bVar = new F1.b(this.a.variables(), e.F(e.this));
            this.b.marshaller().marshal(bVar);
            F1.h j = e.this.j();
            j.p(this.a);
            Collection f = bVar.f(j);
            if (!this.c) {
                return e.z(e.this).e(f, y1.a.b);
            }
            Collection arrayList = new ArrayList();
            Iterator it = f.iterator();
            while (it.hasNext()) {
                arrayList.add(((z1.i) it.next()).i().e(this.d).c());
            }
            return e.z(e.this).j(arrayList);
        }
    }

    public class i implements F1.i {
        public final /* synthetic */ f.b a;
        public final /* synthetic */ z1.b b;

        public i(f.b bVar, v1.b bVar2, z1.b bVar3) {
            this.a = bVar;
            this.b = bVar3;
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public Set a(F1.j jVar) {
            new F1.b(this.a, e.F(e.this));
            throw null;
        }
    }

    public class j extends F1.h {
        public j() {
        }

        public F1.a j() {
            return e.y(e.this);
        }

        /* renamed from: q, reason: merged with bridge method [inline-methods] */
        public z1.b n(v1.k kVar, z1.i iVar) {
            return z1.b.a(iVar.g());
        }
    }

    public class k extends z1.e {

        public class a implements F1.i {
            public a() {
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Boolean a(F1.j jVar) {
                e.z(e.this).b();
                return Boolean.TRUE;
            }
        }

        public k(Executor executor) {
            super(executor);
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean d() {
            return (Boolean) e.this.n(new a());
        }
    }

    public class l extends z1.e {
        public final /* synthetic */ z1.b d;

        public class a implements F1.i {
            public a() {
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Boolean a(F1.j jVar) {
                return Boolean.valueOf(e.z(e.this).h(l.this.d));
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public l(Executor executor, z1.b bVar) {
            super(executor);
            this.d = bVar;
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Boolean d() {
            return (Boolean) e.this.n(new a());
        }
    }

    public class m extends z1.e {
        public final /* synthetic */ List d;

        public class a implements F1.i {
            public a() {
            }

            /* renamed from: b, reason: merged with bridge method [inline-methods] */
            public Integer a(F1.j jVar) {
                Iterator it = m.this.d.iterator();
                int i = 0;
                while (it.hasNext()) {
                    if (e.z(e.this).h((z1.b) it.next())) {
                        i++;
                    }
                }
                return Integer.valueOf(i);
            }
        }

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public m(Executor executor, List list) {
            super(executor);
            this.d = list;
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Integer d() {
            return (Integer) e.this.n(new a());
        }
    }

    public class n extends z1.e {
        public final /* synthetic */ v1.f d;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public n(Executor executor, v1.f fVar) {
            super(executor);
            this.d = fVar;
        }

        public Object d() {
            return e.A(e.this, this.d);
        }
    }

    public class o extends z1.e {
        public final /* synthetic */ v1.f d;
        public final /* synthetic */ v1.l e;
        public final /* synthetic */ F1.h f;
        public final /* synthetic */ y1.a g;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public o(Executor executor, v1.f fVar, v1.l lVar, F1.h hVar, y1.a aVar) {
            super(executor);
            this.d = fVar;
            this.e = lVar;
            this.f = hVar;
            this.g = aVar;
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public v1.i d() {
            return e.B(e.this, this.d, this.e, this.f, this.g);
        }
    }

    public class p extends z1.e {
        public final /* synthetic */ v1.l d;
        public final /* synthetic */ z1.b e;
        public final /* synthetic */ f.b f;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public p(Executor executor, v1.l lVar, z1.b bVar, f.b bVar2) {
            super(executor);
            this.d = lVar;
            this.e = bVar;
            this.f = bVar2;
        }

        public /* bridge */ /* synthetic */ Object d() {
            e();
            return null;
        }

        public v1.b e() {
            e.C(e.this, this.d, this.e, this.f);
            return null;
        }
    }

    public class q extends z1.e {
        public final /* synthetic */ v1.f d;
        public final /* synthetic */ f.a e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public q(Executor executor, v1.f fVar, f.a aVar) {
            super(executor);
            this.d = fVar;
            this.e = aVar;
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public Set d() {
            return e.D(e.this, this.d, this.e, false, null);
        }
    }

    public e(z1.f fVar, z1.c cVar, K1.d dVar, Executor executor, E1.b bVar) {
        x1.g.c(fVar, "cacheStore == null");
        this.b = (z1.h) new z1.h().a(fVar);
        this.c = (z1.c) x1.g.c(cVar, "cacheKeyResolver == null");
        this.d = (K1.d) x1.g.c(dVar, "scalarTypeAdapters == null");
        this.g = (Executor) x1.g.c(executor, "dispatcher == null");
        this.i = (E1.b) x1.g.c(bVar, "logger == null");
        this.e = new ReentrantReadWriteLock();
        this.f = Collections.newSetFromMap(new WeakHashMap());
        this.h = new F1.f();
    }

    public static /* synthetic */ Object A(e eVar, v1.f fVar) {
        return eVar.H(fVar);
    }

    public static /* synthetic */ v1.i B(e eVar, v1.f fVar, v1.l lVar, F1.h hVar, y1.a aVar) {
        return eVar.J(fVar, lVar, hVar, aVar);
    }

    public static /* synthetic */ v1.b C(e eVar, v1.l lVar, z1.b bVar, f.b bVar2) {
        eVar.I(lVar, bVar, bVar2);
        return null;
    }

    public static /* synthetic */ Set D(e eVar, v1.f fVar, f.a aVar, boolean z, UUID uuid) {
        return eVar.L(fVar, aVar, z, uuid);
    }

    public static /* synthetic */ Set E(e eVar, v1.b bVar, z1.b bVar2, f.b bVar3) {
        return eVar.K(bVar, bVar2, bVar3);
    }

    public static /* synthetic */ K1.d F(e eVar) {
        return eVar.d;
    }

    public static /* synthetic */ E1.b G(e eVar) {
        return eVar.i;
    }

    public static /* synthetic */ z1.c x(e eVar) {
        return eVar.c;
    }

    public static /* synthetic */ F1.a y(e eVar) {
        return eVar.h;
    }

    public static /* synthetic */ z1.h z(e eVar) {
        return eVar.b;
    }

    public final Object H(v1.f fVar) {
        return o(new d(fVar));
    }

    public final v1.b I(v1.l lVar, z1.b bVar, f.b bVar2) {
        D.a(o(new f(bVar, bVar2, lVar)));
        return null;
    }

    public final v1.i J(v1.f fVar, v1.l lVar, F1.h hVar, y1.a aVar) {
        return (v1.i) o(new e(fVar, aVar, hVar, lVar));
    }

    public final Set K(v1.b bVar, z1.b bVar2, f.b bVar3) {
        return (Set) n(new i(bVar3, bVar, bVar2));
    }

    public final Set L(v1.f fVar, f.a aVar, boolean z, UUID uuid) {
        return (Set) n(new h(fVar, aVar, z, uuid));
    }

    public z1.c a() {
        return this.c;
    }

    public z1.e b(v1.f fVar, f.a aVar) {
        return new a(this.g, fVar, aVar);
    }

    public z1.e c(v1.b bVar, z1.b bVar2, f.b bVar3) {
        return new c(this.g, bVar, bVar2, bVar3);
    }

    public z1.e d(z1.b bVar) {
        x1.g.c(bVar, "cacheKey == null");
        return new l(this.g, bVar);
    }

    public F1.h e() {
        return new j();
    }

    public z1.e f(v1.l lVar, z1.b bVar, f.b bVar2) {
        x1.g.c(lVar, "responseFieldMapper == null");
        x1.g.c(bVar, "cacheKey == null");
        x1.g.c(bVar2, "variables == null");
        return new p(this.g, lVar, bVar, bVar2);
    }

    public z1.e g(v1.b bVar, z1.b bVar2, f.b bVar3) {
        x1.g.c(bVar, "fragment == null");
        x1.g.c(bVar2, "cacheKey == null");
        x1.g.c(bVar3, "operation == null");
        if (bVar2 != z1.b.b) {
            return new b(this.g, bVar, bVar2, bVar3);
        }
        throw new IllegalArgumentException("undefined cache key");
    }

    public synchronized void h(a.a aVar) {
        this.f.remove(aVar);
    }

    public z1.e i(v1.f fVar, f.a aVar) {
        x1.g.c(fVar, "operation == null");
        x1.g.c(aVar, "operationData == null");
        return new q(this.g, fVar, aVar);
    }

    public F1.h j() {
        return new g();
    }

    public z1.e k(v1.f fVar) {
        x1.g.c(fVar, "operation == null");
        return new n(this.g, fVar);
    }

    public synchronized void l(a.a aVar) {
        this.f.add(aVar);
    }

    public z1.e m(List list) {
        x1.g.c(list, "cacheKey == null");
        return new m(this.g, list);
    }

    public Object n(F1.i iVar) {
        this.e.writeLock().lock();
        try {
            return iVar.a(this);
        } finally {
            this.e.writeLock().unlock();
        }
    }

    public Object o(F1.i iVar) {
        this.e.readLock().lock();
        try {
            return iVar.a(this);
        } finally {
            this.e.readLock().unlock();
        }
    }

    public Collection p(Collection collection, y1.a aVar) {
        return this.b.d((Collection) x1.g.c(collection, "keys == null"), aVar);
    }

    public Set q(Collection collection, y1.a aVar) {
        return this.b.e((Collection) x1.g.c(collection, "recordSet == null"), aVar);
    }

    public void r(Set set) {
        LinkedHashSet linkedHashSet;
        x1.g.c(set, "changedKeys == null");
        if (set.isEmpty()) {
            return;
        }
        synchronized (this) {
            linkedHashSet = new LinkedHashSet(this.f);
        }
        Iterator it = linkedHashSet.iterator();
        while (it.hasNext()) {
            ((a.a) it.next()).a(set);
        }
    }

    public z1.e s() {
        return new k(this.g);
    }

    public z1.i t(String str, y1.a aVar) {
        return this.b.c((String) x1.g.c(str, "key == null"), aVar);
    }

    public z1.f u() {
        return this.b;
    }

    public z1.e v(v1.f fVar, v1.l lVar, F1.h hVar, y1.a aVar) {
        x1.g.c(fVar, "operation == null");
        x1.g.c(hVar, "responseNormalizer == null");
        return new o(this.g, fVar, lVar, hVar, aVar);
    }

    public Set w(z1.i iVar, y1.a aVar) {
        return this.b.f((z1.i) x1.g.c(iVar, "record == null"), aVar);
    }
}
