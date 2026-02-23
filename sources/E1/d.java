package E1;

import com.amazonaws.mobileconnectors.appsync.AppSyncQueryWatcher;
import com.amazonaws.mobileconnectors.appsync.fetcher.AppSyncResponseFetchers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicBoolean;
import java.util.concurrent.atomic.AtomicInteger;
import okhttp3.Call;
import okhttp3.HttpUrl;
import u1.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class d {
    public final E1.b a;
    public final List b;
    public List c;
    public E1.a d;
    public final AtomicBoolean e = new AtomicBoolean();

    public class a extends c.a {
        public final /* synthetic */ AtomicInteger a;
        public final /* synthetic */ e b;

        public a(AtomicInteger atomicInteger, c cVar, e eVar) {
            this.a = atomicInteger;
            this.b = eVar;
        }

        public void onFailure(B1.b bVar) {
            if (d.a(d.this) != null) {
                d.a(d.this).d(bVar, "Failed to fetch query: %s", this.b.a);
            }
            this.a.decrementAndGet();
        }

        public void onResponse(v1.i iVar) {
            this.a.decrementAndGet();
        }
    }

    public static final class b {
        public List a;
        public List b;
        public HttpUrl c;
        public Call.Factory d;
        public i e;
        public K1.d f;
        public z1.a g;
        public Executor h;
        public E1.b i;
        public List j;
        public E1.a k;

        public b() {
            this.a = Collections.emptyList();
            this.b = Collections.emptyList();
        }

        public b a(z1.a aVar) {
            this.g = aVar;
            return this;
        }

        public b b(List list) {
            this.j = list;
            return this;
        }

        public d c() {
            return new d(this);
        }

        public b d(E1.a aVar) {
            this.k = aVar;
            return this;
        }

        public b e(Executor executor) {
            this.h = executor;
            return this;
        }

        public b f(Call.Factory factory) {
            this.d = factory;
            return this;
        }

        public b g(E1.b bVar) {
            this.i = bVar;
            return this;
        }

        public b h(List list) {
            if (list == null) {
                list = Collections.emptyList();
            }
            this.a = list;
            return this;
        }

        public b i(List list) {
            if (list == null) {
                list = Collections.emptyList();
            }
            this.b = list;
            return this;
        }

        public b j(i iVar) {
            this.e = iVar;
            return this;
        }

        public b k(K1.d dVar) {
            this.f = dVar;
            return this;
        }

        public b l(HttpUrl httpUrl) {
            this.c = httpUrl;
            return this;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public interface c {
    }

    public d(b bVar) {
        this.a = bVar.i;
        this.b = new ArrayList(bVar.a.size());
        Iterator it = bVar.a.iterator();
        while (it.hasNext()) {
            this.b.add(e.d().j((v1.h) it.next()).r(bVar.c).h(bVar.d).o(bVar.e).p(bVar.f).a(bVar.g).g(w1.b.b).n(AppSyncResponseFetchers.NETWORK_ONLY).d(y1.a.b).i(bVar.i).b(bVar.j).t(bVar.k).e(bVar.h).c());
        }
        this.c = bVar.b;
        this.d = bVar.k;
    }

    public static /* synthetic */ E1.b a(d dVar) {
        return dVar.a;
    }

    public static b b() {
        return new b(null);
    }

    public void c() {
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            ((e) it.next()).cancel();
        }
    }

    public void d() {
        if (!this.e.compareAndSet(false, true)) {
            throw new IllegalStateException("Already Executed");
        }
        f();
        e();
    }

    public final void e() {
        AtomicInteger atomicInteger = new AtomicInteger(this.b.size());
        for (e eVar : this.b) {
            eVar.enqueue(new a(atomicInteger, null, eVar));
        }
    }

    public final void f() {
        try {
            Iterator it = this.c.iterator();
            while (it.hasNext()) {
                Iterator it2 = this.d.b((v1.g) it.next()).iterator();
                while (it2.hasNext()) {
                    ((AppSyncQueryWatcher) it2.next()).refetch();
                }
            }
        } catch (Exception e) {
            this.a.d(e, "Failed to re-fetch query watcher", new Object[0]);
        }
    }
}
