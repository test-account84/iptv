package E1;

import com.amazonaws.mobileconnectors.appsync.AppSyncSubscriptionCall;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.Semaphore;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;
import u1.c;
import v1.t;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class h implements AppSyncSubscriptionCall {
    public static Semaphore h = new Semaphore(1, true);
    public static int i = 30;
    public static final String j = h.class.getSimpleName();
    public final E1.b a;
    public final t b;
    public final L1.b c;
    public final AtomicReference d = new AtomicReference(E1.c.IDLE);
    public final u1.a e;
    public final e f;
    public AppSyncSubscriptionCall.Callback g;

    public class a implements Runnable {
        public final /* synthetic */ AppSyncSubscriptionCall.Callback a;

        public class a extends c.a {
            public a() {
            }

            public void onFailure(B1.b bVar) {
                h.h.release();
                h.this.i();
                a.this.a.onFailure(bVar);
            }

            public void onResponse(v1.i iVar) {
                h.h.release();
            }
        }

        public a(AppSyncSubscriptionCall.Callback callback) {
            this.a = callback;
        }

        public void run() {
            AppSyncSubscriptionCall.Callback callback;
            B1.b aVar;
            h.b(h.this, this.a);
            h.d(h.this).addListener(h.c(h.this), this.a);
            int i = c.a[((E1.c) h.e(h.this).get()).ordinal()];
            if (i != 1) {
                if (i == 2) {
                    callback = this.a;
                    aVar = new B1.a("Call is cancelled.");
                } else if (i != 3) {
                    callback = this.a;
                    aVar = new B1.b("Unknown state");
                } else {
                    callback = this.a;
                    aVar = new B1.b("Already Executed");
                }
                callback.onFailure(aVar);
            } else {
                h.e(h.this).set(E1.c.ACTIVE);
            }
            try {
                if (h.h.tryAcquire(h.f(), TimeUnit.SECONDS)) {
                    h.g(h.this).a("Subscription Infrastructure: Acquired subscription Semaphore. Continuing", new Object[0]);
                } else {
                    h.g(h.this).a("Subscription Infrastructure: Did not acquire subscription Semaphore after waiting for [" + h.f() + "] seconds. Will continue", new Object[0]);
                }
            } catch (InterruptedException e) {
                h.g(h.this).d(e, "Subscription Infrastructure:Got exception while waiting to acquire subscription Semaphore. Will continue without waiting", new Object[0]);
            }
            h.g(h.this).a("Subscription Infrastructure: Making request to server to get Subscription Meta Data", new Object[0]);
            h.h(h.this).enqueue(new a());
        }
    }

    public class b implements Runnable {
        public b() {
        }

        public void run() {
            AtomicReference e;
            E1.c cVar;
            synchronized (this) {
                try {
                    int i = c.a[((E1.c) h.e(h.this).get()).ordinal()];
                    if (i == 1) {
                        e = h.e(h.this);
                        cVar = E1.c.CANCELED;
                    } else if (i != 2) {
                        if (i != 3) {
                            throw new IllegalStateException("Unknown state");
                        }
                        try {
                            h.d(h.this).unsubscribe(h.c(h.this));
                            h.d(h.this).removeListener(h.c(h.this), h.a(h.this));
                            if (h.a(h.this) != null) {
                                h.a(h.this).onCompleted();
                                h.b(h.this, null);
                            }
                            e = h.e(h.this);
                            cVar = E1.c.CANCELED;
                        } catch (Throwable th) {
                            h.e(h.this).set(E1.c.CANCELED);
                            throw th;
                        }
                    }
                    e.set(cVar);
                } catch (Throwable th2) {
                    throw th2;
                }
            }
        }
    }

    public static /* synthetic */ class c {
        public static final /* synthetic */ int[] a;

        static {
            int[] iArr = new int[E1.c.values().length];
            a = iArr;
            try {
                iArr[E1.c.IDLE.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                a[E1.c.CANCELED.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                a[E1.c.ACTIVE.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
        }
    }

    public h(t tVar, L1.b bVar, u1.a aVar, E1.b bVar2, e eVar) {
        this.b = tVar;
        this.c = bVar;
        this.e = aVar;
        this.f = eVar;
        this.a = bVar2;
    }

    public static /* synthetic */ AppSyncSubscriptionCall.Callback a(h hVar) {
        return hVar.g;
    }

    public static /* synthetic */ AppSyncSubscriptionCall.Callback b(h hVar, AppSyncSubscriptionCall.Callback callback) {
        hVar.g = callback;
        return callback;
    }

    public static /* synthetic */ t c(h hVar) {
        return hVar.b;
    }

    public static /* synthetic */ L1.b d(h hVar) {
        return hVar.c;
    }

    public static /* synthetic */ AtomicReference e(h hVar) {
        return hVar.d;
    }

    public static /* synthetic */ int f() {
        return i;
    }

    public static /* synthetic */ E1.b g(h hVar) {
        return hVar.a;
    }

    public static /* synthetic */ e h(h hVar) {
        return hVar.f;
    }

    public void cancel() {
        new Thread(new b()).start();
    }

    public AppSyncSubscriptionCall clone() {
        return new h(this.b, this.c, this.e, this.a, this.f.clone());
    }

    public synchronized void execute(AppSyncSubscriptionCall.Callback callback) {
        if (callback != null) {
            new Thread(new a(callback)).start();
            return;
        }
        this.a.f("Subscription Infrastructure: Callback passed into subscription [" + this.b + "] was null. Will not subscribe.", new Object[0]);
    }

    public void i() {
        this.a.a("Trying to report failure to Subscription Manager", new Object[0]);
        try {
            this.c.getClass().getDeclaredMethod("reportConnectionError", (Class[]) null).invoke(this.c, (Object[]) null);
        } catch (NoSuchMethodException e) {
            this.a.a("Exception [" + e + "] trying to call reportConnectionError in subscriptionManager", new Object[0]);
        } catch (InvocationTargetException e2) {
            this.a.a("Exception [" + e2 + "] trying to call reportConnectionError in subscriptionManager", new Object[0]);
        } catch (IllegalAccessException e3) {
            this.a.a("Exception [" + e3 + "] trying to call reportConnectionError in subscriptionManager", new Object[0]);
        }
    }

    public boolean isCanceled() {
        return this.d.get() == E1.c.CANCELED;
    }
}
