package com.google.android.gms.common.api.internal;

import android.os.Looper;
import android.os.Message;
import android.util.Log;
import android.util.Pair;
import com.google.android.gms.common.annotation.KeepName;
import com.google.android.gms.common.api.GoogleApiClient;
import com.google.android.gms.common.api.Status;
import com.google.android.gms.common.api.f;
import com.google.android.gms.internal.base.zau;
import com.google.errorprone.annotations.ResultIgnorabilityUnspecified;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.concurrent.CountDownLatch;
import java.util.concurrent.TimeUnit;
import java.util.concurrent.atomic.AtomicReference;

@KeepName
/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public abstract class BasePendingResult extends com.google.android.gms.common.api.f {
    static final ThreadLocal zaa = new c1();
    public static final /* synthetic */ int zad = 0;

    @KeepName
    private d1 resultGuardian;
    protected final a zab;
    protected final WeakReference zac;
    private com.google.android.gms.common.api.i zah;
    private com.google.android.gms.common.api.h zaj;
    private Status zak;
    private volatile boolean zal;
    private boolean zam;
    private boolean zan;
    private com.google.android.gms.common.internal.l zao;
    private volatile O0 zap;
    private final Object zae = new Object();
    private final CountDownLatch zaf = new CountDownLatch(1);
    private final ArrayList zag = new ArrayList();
    private final AtomicReference zai = new AtomicReference();
    private boolean zaq = false;

    public static class a extends zau {
        public a(Looper looper) {
            super(looper);
        }

        public final void a(com.google.android.gms.common.api.i iVar, com.google.android.gms.common.api.h hVar) {
            int i = BasePendingResult.zad;
            sendMessage(obtainMessage(1, new Pair((com.google.android.gms.common.api.i) com.google.android.gms.common.internal.r.m(iVar), hVar)));
        }

        public final void handleMessage(Message message) {
            int i = message.what;
            if (i != 1) {
                if (i == 2) {
                    ((BasePendingResult) message.obj).forceFailureUnlessReady(Status.n);
                    return;
                }
                Log.wtf("BasePendingResult", "Don't know how to handle message: " + i, new Exception());
                return;
            }
            Pair pair = (Pair) message.obj;
            com.google.android.gms.common.api.i iVar = (com.google.android.gms.common.api.i) pair.first;
            com.google.android.gms.common.api.h hVar = (com.google.android.gms.common.api.h) pair.second;
            try {
                iVar.a(hVar);
            } catch (RuntimeException e) {
                BasePendingResult.zal(hVar);
                throw e;
            }
        }
    }

    public BasePendingResult(GoogleApiClient googleApiClient) {
        this.zab = new a(googleApiClient != null ? googleApiClient.i() : Looper.getMainLooper());
        this.zac = new WeakReference(googleApiClient);
    }

    public static /* bridge */ /* synthetic */ com.google.android.gms.common.api.h zaj(BasePendingResult basePendingResult) {
        return basePendingResult.zaj;
    }

    public static void zal(com.google.android.gms.common.api.h hVar) {
    }

    public final com.google.android.gms.common.api.h a() {
        com.google.android.gms.common.api.h hVar;
        synchronized (this.zae) {
            com.google.android.gms.common.internal.r.q(!this.zal, "Result has already been consumed.");
            com.google.android.gms.common.internal.r.q(isReady(), "Result is not ready.");
            hVar = this.zaj;
            this.zaj = null;
            this.zah = null;
            this.zal = true;
        }
        P0 p0 = (P0) this.zai.getAndSet((Object) null);
        if (p0 != null) {
            p0.a.a.remove(this);
        }
        return (com.google.android.gms.common.api.h) com.google.android.gms.common.internal.r.m(hVar);
    }

    public final void addStatusListener(f.a aVar) {
        com.google.android.gms.common.internal.r.b(aVar != null, "Callback cannot be null.");
        synchronized (this.zae) {
            try {
                if (isReady()) {
                    aVar.a(this.zak);
                } else {
                    this.zag.add(aVar);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    @ResultIgnorabilityUnspecified
    public final com.google.android.gms.common.api.h await() {
        com.google.android.gms.common.internal.r.l("await must not be called on the UI thread");
        com.google.android.gms.common.internal.r.q(!this.zal, "Result has already been consumed");
        com.google.android.gms.common.internal.r.q(this.zap == null, "Cannot await if then() has been called.");
        try {
            this.zaf.await();
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.l);
        }
        com.google.android.gms.common.internal.r.q(isReady(), "Result is not ready.");
        return a();
    }

    public final void b(com.google.android.gms.common.api.h hVar) {
        this.zaj = hVar;
        this.zak = hVar.getStatus();
        this.zaf.countDown();
        if (this.zam) {
            this.zah = null;
        } else {
            com.google.android.gms.common.api.i iVar = this.zah;
            if (iVar != null) {
                this.zab.removeMessages(2);
                this.zab.a(iVar, a());
            }
        }
        ArrayList arrayList = this.zag;
        int size = arrayList.size();
        for (int i = 0; i < size; i++) {
            ((f.a) arrayList.get(i)).a(this.zak);
        }
        this.zag.clear();
    }

    public void cancel() {
        synchronized (this.zae) {
            try {
                if (!this.zam && !this.zal) {
                    zal(this.zaj);
                    this.zam = true;
                    b(createFailedResult(Status.o));
                }
            } finally {
            }
        }
    }

    public abstract com.google.android.gms.common.api.h createFailedResult(Status status);

    @Deprecated
    public final void forceFailureUnlessReady(Status status) {
        synchronized (this.zae) {
            try {
                if (!isReady()) {
                    setResult(createFailedResult(status));
                    this.zan = true;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final boolean isCanceled() {
        boolean z;
        synchronized (this.zae) {
            z = this.zam;
        }
        return z;
    }

    public final boolean isReady() {
        return this.zaf.getCount() == 0;
    }

    public final void setCancelToken(com.google.android.gms.common.internal.l lVar) {
        synchronized (this.zae) {
        }
    }

    public final void setResult(com.google.android.gms.common.api.h hVar) {
        synchronized (this.zae) {
            try {
                if (this.zan || this.zam) {
                    zal(hVar);
                    return;
                }
                isReady();
                com.google.android.gms.common.internal.r.q(!isReady(), "Results have already been set");
                com.google.android.gms.common.internal.r.q(!this.zal, "Result has already been consumed");
                b(hVar);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void setResultCallback(com.google.android.gms.common.api.i iVar) {
        synchronized (this.zae) {
            try {
                if (iVar == null) {
                    this.zah = null;
                    return;
                }
                boolean z = true;
                com.google.android.gms.common.internal.r.q(!this.zal, "Result has already been consumed.");
                if (this.zap != null) {
                    z = false;
                }
                com.google.android.gms.common.internal.r.q(z, "Cannot set callbacks if then() has been called.");
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.zab.a(iVar, a());
                } else {
                    this.zah = iVar;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final com.google.android.gms.common.api.k then(com.google.android.gms.common.api.j jVar) {
        com.google.android.gms.common.api.k b;
        com.google.android.gms.common.internal.r.q(!this.zal, "Result has already been consumed.");
        synchronized (this.zae) {
            try {
                com.google.android.gms.common.internal.r.q(this.zap == null, "Cannot call then() twice.");
                com.google.android.gms.common.internal.r.q(this.zah == null, "Cannot call then() if callbacks are set.");
                com.google.android.gms.common.internal.r.q(!this.zam, "Cannot call then() if result was canceled.");
                this.zaq = true;
                this.zap = new O0(this.zac);
                b = this.zap.b(jVar);
                if (isReady()) {
                    this.zab.a(this.zap, a());
                } else {
                    this.zah = this.zap;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return b;
    }

    public final void zak() {
        boolean z = true;
        if (!this.zaq && !((Boolean) zaa.get()).booleanValue()) {
            z = false;
        }
        this.zaq = z;
    }

    public final boolean zam() {
        boolean isCanceled;
        synchronized (this.zae) {
            try {
                if (((GoogleApiClient) this.zac.get()) == null || !this.zaq) {
                    cancel();
                }
                isCanceled = isCanceled();
            } catch (Throwable th) {
                throw th;
            }
        }
        return isCanceled;
    }

    public final void zan(P0 p0) {
        this.zai.set(p0);
    }

    @ResultIgnorabilityUnspecified
    public final com.google.android.gms.common.api.h await(long j, TimeUnit timeUnit) {
        if (j > 0) {
            com.google.android.gms.common.internal.r.l("await must not be called on the UI thread when time is greater than zero.");
        }
        com.google.android.gms.common.internal.r.q(!this.zal, "Result has already been consumed.");
        com.google.android.gms.common.internal.r.q(this.zap == null, "Cannot await if then() has been called.");
        try {
            if (!this.zaf.await(j, timeUnit)) {
                forceFailureUnlessReady(Status.n);
            }
        } catch (InterruptedException unused) {
            forceFailureUnlessReady(Status.l);
        }
        com.google.android.gms.common.internal.r.q(isReady(), "Result is not ready.");
        return a();
    }

    public final void setResultCallback(com.google.android.gms.common.api.i iVar, long j, TimeUnit timeUnit) {
        synchronized (this.zae) {
            try {
                if (iVar == null) {
                    this.zah = null;
                    return;
                }
                boolean z = true;
                com.google.android.gms.common.internal.r.q(!this.zal, "Result has already been consumed.");
                if (this.zap != null) {
                    z = false;
                }
                com.google.android.gms.common.internal.r.q(z, "Cannot set callbacks if then() has been called.");
                if (isCanceled()) {
                    return;
                }
                if (isReady()) {
                    this.zab.a(iVar, a());
                } else {
                    this.zah = iVar;
                    a aVar = this.zab;
                    aVar.sendMessageDelayed(aVar.obtainMessage(2, this), timeUnit.toMillis(j));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
