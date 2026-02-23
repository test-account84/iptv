package u1;

import E1.i;
import F1.e;
import K1.d;
import com.amazonaws.mobileconnectors.appsync.AppSyncMutationCall;
import com.amazonaws.mobileconnectors.appsync.AppSyncPrefetch;
import com.amazonaws.mobileconnectors.appsync.AppSyncQueryCall;
import com.amazonaws.mobileconnectors.appsync.AppSyncSubscriptionCall;
import com.amazonaws.mobileconnectors.appsync.fetcher.AppSyncResponseFetchers;
import java.util.ArrayList;
import java.util.Collections;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.concurrent.Executor;
import java.util.concurrent.SynchronousQueue;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.ThreadPoolExecutor;
import java.util.concurrent.TimeUnit;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.OkHttpClient;
import v1.f;
import v1.h;
import v1.s;
import v1.t;
import w1.b;
import x1.g;
import z1.j;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class a implements AppSyncQueryCall.Factory, AppSyncMutationCall.Factory, AppSyncSubscriptionCall.Factory, AppSyncPrefetch.Factory {
    public final HttpUrl a;
    public final Call.Factory b;
    public final z1.a c;
    public final d d;
    public final i e;
    public final Executor f;
    public final b.c g;
    public final C1.a h;
    public final y1.a i;
    public final E1.b j;
    public final E1.a k;
    public final List l;
    public final boolean m;
    public final L1.b n;

    public static class b {
        public Call.Factory a;
        public HttpUrl b;
        public z1.a c;
        public x1.d d;
        public x1.d e;
        public b.c f;
        public C1.a g;
        public y1.a h;
        public final Map i;
        public Executor j;
        public x1.d k;
        public final List l;
        public boolean m;
        public L1.b n;

        public class a implements ThreadFactory {
            public a() {
            }

            public Thread newThread(Runnable runnable) {
                return new Thread(runnable, "Apollo Dispatcher");
            }
        }

        public b() {
            this.c = z1.a.a;
            this.d = x1.d.a();
            this.e = x1.d.a();
            this.f = w1.b.b;
            this.g = AppSyncResponseFetchers.CACHE_FIRST;
            this.h = y1.a.b;
            this.i = new LinkedHashMap();
            this.k = x1.d.a();
            this.l = new ArrayList();
            this.n = new L1.a();
        }

        public b a(D1.a aVar) {
            this.l.add(aVar);
            return this;
        }

        public b b(s sVar, u1.b bVar) {
            this.i.put(sVar, bVar);
            return this;
        }

        public a c() {
            g.c(this.b, "serverUrl is null");
            E1.b bVar = new E1.b(this.k);
            OkHttpClient okHttpClient = this.a;
            if (okHttpClient == null) {
                okHttpClient = new OkHttpClient();
            }
            Executor executor = this.j;
            if (executor == null) {
                executor = f();
            }
            Executor executor2 = executor;
            d dVar = new d(this.i);
            z1.a aVar = this.c;
            x1.d dVar2 = this.d;
            x1.d dVar3 = this.e;
            return new a(this.b, okHttpClient, null, (dVar2.f() && dVar3.f()) ? new e(((z1.g) dVar2.e()).b(j.a()), (z1.c) dVar3.e(), dVar, executor2, bVar) : aVar, dVar, executor2, this.f, this.g, this.h, bVar, this.l, this.m, this.n, null);
        }

        public b d(Call.Factory factory) {
            this.a = (Call.Factory) g.c(factory, "factory == null");
            return this;
        }

        public b e(y1.a aVar) {
            this.h = (y1.a) g.c(aVar, "cacheHeaders == null");
            return this;
        }

        public final Executor f() {
            return new ThreadPoolExecutor(0, Integer.MAX_VALUE, 60L, TimeUnit.SECONDS, new SynchronousQueue(), new a());
        }

        public b g(C1.a aVar) {
            this.g = (C1.a) g.c(aVar, "defaultResponseFetcher == null");
            return this;
        }

        public b h(Executor executor) {
            this.j = (Executor) g.c(executor, "dispatcher == null");
            return this;
        }

        public b i(z1.g gVar, z1.c cVar) {
            this.d = x1.d.d(g.c(gVar, "normalizedCacheFactory == null"));
            this.e = x1.d.d(g.c(cVar, "cacheKeyResolver == null"));
            return this;
        }

        public b j(OkHttpClient okHttpClient) {
            return d((Call.Factory) g.c(okHttpClient, "okHttpClient is null"));
        }

        public b k(String str) {
            this.b = HttpUrl.parse((String) g.c(str, "serverUrl == null"));
            return this;
        }

        public b l(L1.b bVar) {
            this.n = bVar;
            return this;
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public a(HttpUrl httpUrl, Call.Factory factory, w1.a aVar, z1.a aVar2, d dVar, Executor executor, b.c cVar, C1.a aVar3, y1.a aVar4, E1.b bVar, List list, boolean z, L1.b bVar2) {
        this.e = new i();
        this.k = new E1.a();
        this.a = httpUrl;
        this.b = factory;
        this.c = aVar2;
        this.d = dVar;
        this.f = executor;
        this.g = cVar;
        this.h = aVar3;
        this.i = aVar4;
        this.j = bVar;
        this.l = list;
        this.m = z;
        this.n = bVar2;
    }

    public static b b() {
        return new b(null);
    }

    public z1.a a() {
        return this.c;
    }

    public final E1.e c(f fVar) {
        return E1.e.d().j(fVar).r(this.a).h(this.b).f(null).g(this.g).o(this.e).p(this.d).a(this.c).n(this.h).d(this.i).e(this.f).i(this.j).b(this.l).t(this.k).l(Collections.emptyList()).m(Collections.emptyList()).q(this.m).s(this.n).c();
    }

    public AppSyncMutationCall mutate(v1.e eVar) {
        return c(eVar).responseFetcher(AppSyncResponseFetchers.NETWORK_ONLY);
    }

    public AppSyncPrefetch prefetch(f fVar) {
        return new E1.f(fVar, this.a, this.b, this.d, this.f, this.j, this.k, this.m);
    }

    public AppSyncQueryCall query(h hVar) {
        return c(hVar);
    }

    public AppSyncSubscriptionCall subscribe(t tVar) {
        return new E1.h(tVar, this.n, this, this.j, c(tVar));
    }

    public /* synthetic */ a(HttpUrl httpUrl, Call.Factory factory, w1.a aVar, z1.a aVar2, d dVar, Executor executor, b.c cVar, C1.a aVar3, y1.a aVar4, E1.b bVar, List list, boolean z, L1.b bVar2, a aVar5) {
        this(httpUrl, factory, aVar, aVar2, dVar, executor, cVar, aVar3, aVar4, bVar, list, z, bVar2);
    }

    public AppSyncMutationCall mutate(v1.e eVar, f.a aVar) {
        g.c(aVar, "withOptimisticUpdate == null");
        return c(eVar).n().n(AppSyncResponseFetchers.NETWORK_ONLY).k(x1.d.d(aVar)).c();
    }
}
