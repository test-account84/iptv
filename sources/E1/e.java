package E1;

import D1.a;
import E1.c;
import com.amazonaws.mobileconnectors.appsync.AppSyncMutationCall;
import com.amazonaws.mobileconnectors.appsync.AppSyncQueryCall;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.Call;
import okhttp3.HttpUrl;
import u1.c;
import v1.l;
import w1.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class e implements AppSyncQueryCall, AppSyncMutationCall {
    public final v1.f a;
    public final HttpUrl b;
    public final Call.Factory c;
    public final b.c d;
    public final i e;
    public final K1.d f;
    public final z1.a g;
    public final y1.a h;
    public final C1.a i;
    public final D1.b j;
    public final Executor k;
    public final E1.b l;
    public final E1.a m;
    public final List n;
    public final List o;
    public final List p;
    public final x1.d q;
    public final boolean r;
    public final AtomicReference s;
    public final AtomicReference t;
    public final x1.d u;
    public L1.b v;

    public class a implements a.a {

        public class a implements x1.b {
            public final /* synthetic */ a.b a;

            public a(a.b bVar) {
                this.a = bVar;
            }

            /* renamed from: a, reason: merged with bridge method [inline-methods] */
            public void apply(c.a aVar) {
                c.b bVar;
                int i = c.b[this.a.ordinal()];
                if (i == 1) {
                    bVar = c.b.FETCH_CACHE;
                } else if (i != 2) {
                    return;
                } else {
                    bVar = c.b.FETCH_NETWORK;
                }
                aVar.onStatusEvent(bVar);
            }
        }

        public a() {
        }

        public void onCompleted() {
            x1.d b = e.b(e.this);
            if (e.this.q.f()) {
                ((E1.d) e.this.q.e()).d();
            }
            if (b.f()) {
                ((c.a) b.e()).onStatusEvent(c.b.COMPLETED);
            } else {
                e eVar = e.this;
                eVar.l.a("onCompleted for operation: %s. No callback present.", eVar.operation().name().name());
            }
        }

        public void onFailure(B1.b bVar) {
            x1.d b = e.b(e.this);
            if (!b.f()) {
                e eVar = e.this;
                eVar.l.b(bVar, "onFailure for operation: %s. No callback present.", eVar.operation().name().name());
                return;
            }
            if (bVar instanceof B1.c) {
                ((c.a) b.e()).onHttpError((B1.c) bVar);
                return;
            }
            if (bVar instanceof B1.e) {
                ((c.a) b.e()).onParseError((B1.e) bVar);
                return;
            }
            boolean z = bVar instanceof B1.d;
            c.a aVar = (c.a) b.e();
            if (z) {
                aVar.onNetworkError((B1.d) bVar);
            } else {
                aVar.onFailure(bVar);
            }
        }

        public void onFetch(a.b bVar) {
            e.a(e.this).b(new a(bVar));
        }

        public void onResponse(a.d dVar) {
            x1.d a2 = e.a(e.this);
            if (a2.f()) {
                ((c.a) a2.e()).onResponse((v1.i) dVar.b.e());
            } else {
                e eVar = e.this;
                eVar.l.a("onResponse for operation: %s. No callback present.", eVar.operation().name().name());
            }
        }
    }

    public class b implements x1.b {
        public b() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void apply(c.a aVar) {
            aVar.onStatusEvent(c.b.SCHEDULED);
        }
    }

    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[a.b.values().length];
            b = iArr;
            try {
                iArr[a.b.CACHE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[a.b.NETWORK.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            int[] iArr2 = new int[E1.c.values().length];
            a = iArr2;
            try {
                iArr2[E1.c.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[E1.c.IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[E1.c.CANCELED.ordinal()] = 3;
            } catch (NoSuchFieldError unused5) {
            }
            try {
                a[E1.c.TERMINATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused6) {
            }
        }
    }

    public e(d dVar) {
        this.s = new AtomicReference(E1.c.IDLE);
        this.t = new AtomicReference();
        v1.f fVar = dVar.a;
        this.a = fVar;
        this.b = dVar.b;
        this.c = dVar.c;
        this.d = dVar.d;
        this.e = dVar.e;
        this.f = dVar.f;
        this.g = dVar.g;
        this.i = dVar.h;
        this.h = dVar.i;
        this.k = dVar.j;
        this.l = dVar.k;
        this.n = dVar.l;
        List list = dVar.m;
        this.o = list;
        List list2 = dVar.n;
        this.p = list2;
        this.m = dVar.o;
        this.v = dVar.r;
        this.q = ((list2.isEmpty() && list.isEmpty()) || dVar.g == null) ? x1.d.a() : x1.d.h(E1.d.b().h(dVar.n).i(list).l(dVar.b).f(dVar.c).j(dVar.e).k(dVar.f).a(dVar.g).e(dVar.j).g(dVar.k).b(dVar.l).d(dVar.o).c());
        this.r = dVar.p;
        this.j = j(fVar);
        this.u = dVar.q;
    }

    public static /* synthetic */ x1.d a(e eVar) {
        return eVar.k();
    }

    public static /* synthetic */ x1.d b(e eVar) {
        return eVar.m();
    }

    private synchronized void c(x1.d dVar) {
        try {
            int i = c.a[((E1.c) this.s.get()).ordinal()];
            if (i != 1) {
                if (i == 2) {
                    this.t.set(dVar.k());
                    this.m.e(this);
                    dVar.b(new b());
                    this.s.set(E1.c.ACTIVE);
                } else {
                    if (i == 3) {
                        throw new B1.a("Call is cancelled.");
                    }
                    if (i != 4) {
                        throw new IllegalStateException("Unknown state");
                    }
                }
            }
            throw new IllegalStateException("Already Executed");
        } catch (Throwable th) {
            throw th;
        }
    }

    public static d d() {
        return new d();
    }

    private a.a i() {
        return new a();
    }

    private synchronized x1.d k() {
        try {
            int i = c.a[((E1.c) this.s.get()).ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new IllegalStateException("Unknown state");
                        }
                    }
                }
                throw new IllegalStateException(c.a.b((E1.c) this.s.get()).a(E1.c.ACTIVE, E1.c.CANCELED));
            }
        } catch (Throwable th) {
            throw th;
        }
        return x1.d.d(this.t.get());
    }

    private synchronized x1.d m() {
        try {
            int i = c.a[((E1.c) this.s.get()).ordinal()];
            if (i == 1) {
                this.m.k(this);
                this.s.set(E1.c.TERMINATED);
                return x1.d.d(this.t.getAndSet((Object) null));
            }
            if (i != 2) {
                if (i == 3) {
                    return x1.d.d(this.t.getAndSet((Object) null));
                }
                if (i != 4) {
                    throw new IllegalStateException("Unknown state");
                }
            }
            throw new IllegalStateException(c.a.b((E1.c) this.s.get()).a(E1.c.ACTIVE, E1.c.CANCELED));
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void cancel() {
        try {
            int i = c.a[((E1.c) this.s.get()).ordinal()];
            if (i == 1) {
                this.s.set(E1.c.CANCELED);
                try {
                    if (this.a instanceof v1.e) {
                        f();
                    }
                    this.j.dispose();
                    if (this.q.f()) {
                        ((E1.d) this.q.e()).c();
                    }
                    this.m.k(this);
                    this.t.set((Object) null);
                } catch (Throwable th) {
                    this.m.k(this);
                    this.t.set((Object) null);
                    throw th;
                }
            } else if (i == 2) {
                this.s.set(E1.c.CANCELED);
            } else if (i != 3 && i != 4) {
                throw new IllegalStateException("Unknown state");
            }
        } catch (Throwable th2) {
            throw th2;
        }
    }

    /* renamed from: e, reason: merged with bridge method [inline-methods] */
    public e cacheHeaders(y1.a aVar) {
        if (this.s.get() == E1.c.IDLE) {
            return n().d((y1.a) x1.g.c(aVar, "cacheHeaders == null")).c();
        }
        throw new IllegalStateException("Already Executed");
    }

    public void enqueue(c.a aVar) {
        try {
            c(x1.d.d(aVar));
            this.j.a(a.c.a(this.a).b(this.h).c(false).e(this.u).a(), this.k, i());
        } catch (B1.a e) {
            if (aVar != null) {
                aVar.onCanceledError(e);
            } else {
                this.l.d(e, "Operation: %s was canceled", operation().name().name());
            }
        }
    }

    public final void f() {
        D1.a aVar;
        v1.e eVar = (v1.e) this.a;
        Iterator it = this.n.iterator();
        while (true) {
            if (!it.hasNext()) {
                aVar = null;
                break;
            } else {
                aVar = (D1.a) it.next();
                if ("AppSyncOfflineMutationInterceptor".equalsIgnoreCase(aVar.getClass().getSimpleName())) {
                    break;
                }
            }
        }
        if (aVar == null) {
            return;
        }
        try {
            aVar.getClass().getMethod("dispose", new Class[]{v1.e.class}).invoke(aVar, new Object[]{eVar});
        } catch (Exception e) {
            this.l.g(e, "unable to invoke dispose method", new Object[0]);
        }
    }

    /* renamed from: g, reason: merged with bridge method [inline-methods] */
    public e clone() {
        return n().c();
    }

    /* renamed from: h, reason: merged with bridge method [inline-methods] */
    public e httpCachePolicy(b.c cVar) {
        if (this.s.get() == E1.c.IDLE) {
            return n().g((b.c) x1.g.c(cVar, "httpCachePolicy == null")).c();
        }
        throw new IllegalStateException("Already Executed");
    }

    public boolean isCanceled() {
        return this.s.get() == E1.c.CANCELED;
    }

    public final D1.b j(v1.f fVar) {
        ArrayList arrayList = new ArrayList();
        b.c cVar = fVar instanceof v1.h ? this.d : null;
        l a2 = this.e.a(fVar);
        arrayList.addAll(this.n);
        arrayList.add(this.i.a(this.l));
        arrayList.add(new I1.a(this.g, a2, this.k, this.l));
        arrayList.add(new I1.b(null, this.g.j(), a2, this.f, this.l));
        arrayList.add(new I1.d(this.v, this.g.j()));
        arrayList.add(new I1.c(this.b, this.c, cVar, false, this.f, this.l, this.r));
        return new I1.e(arrayList);
    }

    /* renamed from: l, reason: merged with bridge method [inline-methods] */
    public e responseFetcher(C1.a aVar) {
        if (this.s.get() == E1.c.IDLE) {
            return n().n((C1.a) x1.g.c(aVar, "responseFetcher == null")).c();
        }
        throw new IllegalStateException("Already Executed");
    }

    public d n() {
        return d().j(this.a).r(this.b).h(this.c).f(null).g(this.d).o(this.e).p(this.f).a(this.g).d(this.h).n(this.i).e(this.k).i(this.l).b(this.n).t(this.m).m(this.o).l(this.p).q(this.r).k(this.u);
    }

    /* renamed from: o, reason: merged with bridge method [inline-methods] */
    public g watcher() {
        return new g(clone(), this.g, this.l, this.m);
    }

    public v1.f operation() {
        return this.a;
    }

    public AppSyncMutationCall refetchQueries(v1.g... gVarArr) {
        if (this.s.get() == E1.c.IDLE) {
            return n().m(Arrays.asList((Object[]) x1.g.c(gVarArr, "operationNames == null"))).c();
        }
        throw new IllegalStateException("Already Executed");
    }

    public /* synthetic */ e(d dVar, a aVar) {
        this(dVar);
    }

    public AppSyncMutationCall refetchQueries(v1.h... hVarArr) {
        if (this.s.get() == E1.c.IDLE) {
            return n().l(Arrays.asList((Object[]) x1.g.c(hVarArr, "queries == null"))).c();
        }
        throw new IllegalStateException("Already Executed");
    }

    public static final class d {
        public v1.f a;
        public HttpUrl b;
        public Call.Factory c;
        public b.c d;
        public i e;
        public K1.d f;
        public z1.a g;
        public C1.a h;
        public y1.a i;
        public Executor j;
        public E1.b k;
        public List l;
        public E1.a o;
        public boolean p;
        public L1.b r;
        public List m = Collections.emptyList();
        public List n = Collections.emptyList();
        public x1.d q = x1.d.a();

        public d a(z1.a aVar) {
            this.g = aVar;
            return this;
        }

        public d b(List list) {
            this.l = list;
            return this;
        }

        public e c() {
            return new e(this, null);
        }

        public d d(y1.a aVar) {
            this.i = aVar;
            return this;
        }

        public d e(Executor executor) {
            this.j = executor;
            return this;
        }

        public d g(b.c cVar) {
            this.d = cVar;
            return this;
        }

        public d h(Call.Factory factory) {
            this.c = factory;
            return this;
        }

        public d i(E1.b bVar) {
            this.k = bVar;
            return this;
        }

        public d j(v1.f fVar) {
            this.a = fVar;
            return this;
        }

        public d k(x1.d dVar) {
            this.q = dVar;
            return this;
        }

        public d l(List list) {
            this.n = list != null ? new ArrayList(list) : Collections.emptyList();
            return this;
        }

        public d m(List list) {
            this.m = list != null ? new ArrayList(list) : Collections.emptyList();
            return this;
        }

        public d n(C1.a aVar) {
            this.h = aVar;
            return this;
        }

        public d o(i iVar) {
            this.e = iVar;
            return this;
        }

        public d p(K1.d dVar) {
            this.f = dVar;
            return this;
        }

        public d q(boolean z) {
            this.p = z;
            return this;
        }

        public d r(HttpUrl httpUrl) {
            this.b = httpUrl;
            return this;
        }

        public d s(L1.b bVar) {
            this.r = bVar;
            return this;
        }

        public d t(E1.a aVar) {
            this.o = aVar;
            return this;
        }

        public d f(w1.a aVar) {
            return this;
        }
    }
}
