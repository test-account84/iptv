package E1;

import E1.c;
import com.amazonaws.mobileconnectors.appsync.AppSyncQueryWatcher;
import com.amazonaws.mobileconnectors.appsync.fetcher.AppSyncResponseFetchers;
import java.util.Collections;
import java.util.Set;
import java.util.concurrent.atomic.AtomicReference;
import u1.c;
import z1.a;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class g implements AppSyncQueryWatcher {
    public e a;
    public final z1.a c;
    public final E1.b e;
    public final E1.a f;
    public C1.a b = AppSyncResponseFetchers.CACHE_FIRST;
    public Set d = Collections.emptySet();
    public final a.a g = new a();
    public final AtomicReference h = new AtomicReference(E1.c.IDLE);
    public final AtomicReference i = new AtomicReference();

    public class a implements a.a {
        public a() {
        }

        public void a(Set set) {
            if (x1.g.a(g.a(g.this), set)) {
                return;
            }
            g.this.refetch();
        }
    }

    public class b extends c.a {
        public b() {
        }

        public void onFailure(B1.b bVar) {
            x1.d g = g.g(g.this);
            if (!g.f()) {
                g.d(g.this).b(bVar, "onFailure for operation: %s. No callback present.", g.this.operation().name().name());
                return;
            }
            if (bVar instanceof B1.c) {
                ((c.a) g.e()).onHttpError((B1.c) bVar);
                return;
            }
            if (bVar instanceof B1.e) {
                ((c.a) g.e()).onParseError((B1.e) bVar);
                return;
            }
            boolean z = bVar instanceof B1.d;
            c.a aVar = (c.a) g.e();
            if (z) {
                aVar.onNetworkError((B1.d) bVar);
            } else {
                aVar.onFailure(bVar);
            }
        }

        public void onResponse(v1.i iVar) {
            x1.d c = g.c(g.this);
            if (!c.f()) {
                g.d(g.this).a("onResponse for watched operation: %s. No callback present.", g.this.operation().name().name());
                return;
            }
            g.b(g.this, iVar.c());
            g.f(g.this).l(g.e(g.this));
            ((c.a) c.e()).onResponse(iVar);
        }
    }

    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[E1.c.values().length];
            a = iArr;
            try {
                iArr[E1.c.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[E1.c.IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[E1.c.CANCELED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[E1.c.TERMINATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public g(e eVar, z1.a aVar, E1.b bVar, E1.a aVar2) {
        this.a = eVar;
        this.c = aVar;
        this.e = bVar;
        this.f = aVar2;
    }

    public static /* synthetic */ Set a(g gVar) {
        return gVar.d;
    }

    public static /* synthetic */ Set b(g gVar, Set set) {
        gVar.d = set;
        return set;
    }

    public static /* synthetic */ x1.d c(g gVar) {
        return gVar.k();
    }

    public static /* synthetic */ E1.b d(g gVar) {
        return gVar.e;
    }

    public static /* synthetic */ a.a e(g gVar) {
        return gVar.g;
    }

    public static /* synthetic */ z1.a f(g gVar) {
        return gVar.c;
    }

    public static /* synthetic */ x1.d g(g gVar) {
        return gVar.l();
    }

    private synchronized void h(x1.d dVar) {
        try {
            int i = c.a[((E1.c) this.h.get()).ordinal()];
            if (i != 1) {
                if (i == 2) {
                    this.i.set(dVar.k());
                    this.f.i(this);
                    this.h.set(E1.c.ACTIVE);
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

    private synchronized x1.d l() {
        try {
            int i = c.a[((E1.c) this.h.get()).ordinal()];
            if (i == 1) {
                this.f.o(this);
                this.h.set(E1.c.TERMINATED);
                return x1.d.d(this.i.getAndSet((Object) null));
            }
            if (i != 2) {
                if (i == 3) {
                    return x1.d.d(this.i.getAndSet((Object) null));
                }
                if (i != 4) {
                    throw new IllegalStateException("Unknown state");
                }
            }
            throw new IllegalStateException(c.a.b((E1.c) this.h.get()).a(E1.c.ACTIVE, E1.c.CANCELED));
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized void cancel() {
        AtomicReference atomicReference;
        E1.c cVar;
        try {
            int i = c.a[((E1.c) this.h.get()).ordinal()];
            if (i == 1) {
                try {
                    this.a.cancel();
                    this.c.h(this.g);
                    this.f.o(this);
                    this.i.set((Object) null);
                    atomicReference = this.h;
                    cVar = E1.c.CANCELED;
                } catch (Throwable th) {
                    this.f.o(this);
                    this.i.set((Object) null);
                    this.h.set(E1.c.CANCELED);
                    throw th;
                }
            } else if (i == 2) {
                atomicReference = this.h;
                cVar = E1.c.CANCELED;
            } else if (i != 3 && i != 4) {
                throw new IllegalStateException("Unknown state");
            }
            atomicReference.set(cVar);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public AppSyncQueryWatcher enqueueAndWatch(c.a aVar) {
        try {
            h(x1.d.d(aVar));
            this.a.enqueue(i());
            return this;
        } catch (B1.a e) {
            if (aVar != null) {
                aVar.onCanceledError(e);
            } else {
                this.e.d(e, "Operation: %s was canceled", operation().name().name());
            }
            return this;
        }
    }

    public final c.a i() {
        return new b();
    }

    public boolean isCanceled() {
        return this.h.get() == E1.c.CANCELED;
    }

    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public synchronized g refetchResponseFetcher(C1.a aVar) {
        if (this.h.get() != E1.c.IDLE) {
            throw new IllegalStateException("Already Executed");
        }
        x1.g.c(aVar, "responseFetcher == null");
        this.b = aVar;
        return this;
    }

    public final synchronized x1.d k() {
        try {
            int i = c.a[((E1.c) this.h.get()).ordinal()];
            if (i != 1) {
                if (i != 2) {
                    if (i != 3) {
                        if (i != 4) {
                            throw new IllegalStateException("Unknown state");
                        }
                    }
                }
                throw new IllegalStateException(c.a.b((E1.c) this.h.get()).a(E1.c.ACTIVE, E1.c.CANCELED));
            }
        } catch (Throwable th) {
            throw th;
        }
        return x1.d.d(this.i.get());
    }

    public v1.f operation() {
        return this.a.operation();
    }

    public synchronized void refetch() {
        try {
            int i = c.a[((E1.c) this.h.get()).ordinal()];
            if (i != 1) {
                if (i == 2) {
                    throw new IllegalStateException("Cannot refetch a watcher which has not first called enqueueAndWatch.");
                }
                if (i == 3) {
                    throw new IllegalStateException("Cannot refetch a canceled watcher,");
                }
                if (i == 4) {
                    throw new IllegalStateException("Cannot refetch a watcher which has experienced an error.");
                }
                throw new IllegalStateException("Unknown state");
            }
            this.c.h(this.g);
            this.a.cancel();
            e responseFetcher = this.a.clone().responseFetcher(this.b);
            this.a = responseFetcher;
            responseFetcher.enqueue(i());
        } catch (Throwable th) {
            throw th;
        }
    }
}
