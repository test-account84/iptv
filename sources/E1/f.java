package E1;

import D1.a;
import E1.c;
import com.amazonaws.mobileconnectors.appsync.AppSyncPrefetch;
import java.util.Collections;
import java.util.concurrent.Executor;
import java.util.concurrent.atomic.AtomicReference;
import okhttp3.Call;
import okhttp3.HttpUrl;
import okhttp3.Response;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class f implements AppSyncPrefetch {
    public final v1.f a;
    public final HttpUrl b;
    public final Call.Factory c;
    public final K1.d d;
    public final Executor e;
    public final E1.b f;
    public final E1.a g;
    public final D1.b h;
    public final boolean i;
    public final AtomicReference j = new AtomicReference(c.IDLE);
    public final AtomicReference k = new AtomicReference();

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[c.values().length];
            a = iArr;
            try {
                iArr[c.ACTIVE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[c.IDLE.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[c.CANCELED.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            try {
                a[c.TERMINATED.ordinal()] = 4;
            } catch (NoSuchFieldError unused4) {
            }
        }
    }

    public f(v1.f fVar, HttpUrl httpUrl, Call.Factory factory, K1.d dVar, Executor executor, E1.b bVar, E1.a aVar, boolean z) {
        this.a = fVar;
        this.b = httpUrl;
        this.c = factory;
        this.d = dVar;
        this.e = executor;
        this.f = bVar;
        this.g = aVar;
        this.i = z;
        this.h = new I1.e(Collections.singletonList(new I1.c(httpUrl, factory, w1.b.b, true, dVar, bVar, z)));
    }

    public static /* synthetic */ x1.d a(f fVar) {
        return fVar.d();
    }

    public final synchronized void b(x1.d dVar) {
        try {
            int i = b.a[((c) this.j.get()).ordinal()];
            if (i != 1) {
                if (i == 2) {
                    this.k.set(dVar.k());
                    this.g.g(this);
                    this.j.set(c.ACTIVE);
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

    public final a.a c() {
        return new a();
    }

    public synchronized void cancel() {
        AtomicReference atomicReference;
        c cVar;
        try {
            int i = b.a[((c) this.j.get()).ordinal()];
            if (i == 1) {
                try {
                    this.h.dispose();
                    this.g.m(this);
                    this.k.set((Object) null);
                    atomicReference = this.j;
                    cVar = c.CANCELED;
                } catch (Throwable th) {
                    this.g.m(this);
                    this.k.set((Object) null);
                    this.j.set(c.CANCELED);
                    throw th;
                }
            } else if (i == 2) {
                atomicReference = this.j;
                cVar = c.CANCELED;
            } else if (i != 3 && i != 4) {
                throw new IllegalStateException("Unknown state");
            }
            atomicReference.set(cVar);
        } catch (Throwable th2) {
            throw th2;
        }
    }

    public AppSyncPrefetch clone() {
        return new f(this.a, this.b, this.c, this.d, this.e, this.f, this.g, this.i);
    }

    public final synchronized x1.d d() {
        try {
            int i = b.a[((c) this.j.get()).ordinal()];
            if (i == 1) {
                this.g.m(this);
                this.j.set(c.TERMINATED);
                return x1.d.d(this.k.getAndSet((Object) null));
            }
            if (i != 2) {
                if (i == 3) {
                    return x1.d.d(this.k.getAndSet((Object) null));
                }
                if (i != 4) {
                    throw new IllegalStateException("Unknown state");
                }
            }
            throw new IllegalStateException(c.a.b((c) this.j.get()).a(c.ACTIVE, c.CANCELED));
        } catch (Throwable th) {
            throw th;
        }
    }

    public void enqueue(AppSyncPrefetch.Callback callback) {
        try {
            b(x1.d.d(callback));
            this.h.a(a.c.a(this.a).a(), this.e, c());
        } catch (B1.a e) {
            if (callback != null) {
                callback.onFailure(e);
            } else {
                this.f.d(e, "Operation: %s was canceled", operation().name().name());
            }
        }
    }

    public boolean isCanceled() {
        return this.j.get() == c.CANCELED;
    }

    public v1.f operation() {
        return this.a;
    }

    public class a implements a.a {
        public a() {
        }

        public void onFailure(B1.b bVar) {
            x1.d a = f.a(f.this);
            if (!a.f()) {
                f fVar = f.this;
                fVar.f.d(bVar, "onFailure for prefetch operation: %s. No callback present.", fVar.operation().name().name());
            } else {
                if (bVar instanceof B1.c) {
                    ((AppSyncPrefetch.Callback) a.e()).onHttpError((B1.c) bVar);
                    return;
                }
                boolean z = bVar instanceof B1.d;
                AppSyncPrefetch.Callback callback = (AppSyncPrefetch.Callback) a.e();
                if (z) {
                    callback.onNetworkError((B1.d) bVar);
                } else {
                    callback.onFailure(bVar);
                }
            }
        }

        public void onResponse(a.d dVar) {
            Response response = (Response) dVar.a.e();
            try {
                x1.d a = f.a(f.this);
                if (!a.f()) {
                    f fVar = f.this;
                    fVar.f.a("onResponse for prefetch operation: %s. No callback present.", fVar.operation().name().name());
                } else {
                    if (response.isSuccessful()) {
                        ((AppSyncPrefetch.Callback) a.e()).onSuccess();
                    } else {
                        ((AppSyncPrefetch.Callback) a.e()).onHttpError(new B1.c(response));
                    }
                }
            } finally {
                response.close();
            }
        }

        public void onFetch(a.b bVar) {
        }

        public void onCompleted() {
        }
    }
}
