package androidx.work;

import G8.B0;
import G8.H;
import G8.L;
import G8.M;
import G8.N;
import G8.b0;
import G8.i;
import G8.x0;
import G8.z;
import Q0.j;
import android.content.Context;
import androidx.work.ListenableWorker;
import java.util.concurrent.CancellationException;
import k8.k;
import k8.q;
import o8.d;
import o8.g;
import org.jetbrains.annotations.NotNull;
import q8.l;
import w8.p;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class CoroutineWorker extends ListenableWorker {
    public final z g;
    public final b1.c h;
    public final H i;

    public static final class a implements Runnable {
        public a() {
        }

        public final void run() {
            if (CoroutineWorker.this.v().isCancelled()) {
                x0.a.a(CoroutineWorker.this.w(), (CancellationException) null, 1, (Object) null);
            }
        }
    }

    public static final class b extends l implements p {
        public Object a;
        public int c;
        public final /* synthetic */ j d;
        public final /* synthetic */ CoroutineWorker e;

        /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
        public b(j jVar, CoroutineWorker coroutineWorker, d dVar) {
            super(2, dVar);
            this.d = jVar;
            this.e = coroutineWorker;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(L l, d dVar) {
            return create(l, dVar).invokeSuspend(q.a);
        }

        public final d create(Object obj, d dVar) {
            return new b(this.d, this.e, dVar);
        }

        public final Object invokeSuspend(Object obj) {
            j jVar;
            Object d = p8.c.d();
            int i = this.c;
            if (i == 0) {
                k.b(obj);
                j jVar2 = this.d;
                CoroutineWorker coroutineWorker = this.e;
                this.a = jVar2;
                this.c = 1;
                Object t = coroutineWorker.t(this);
                if (t == d) {
                    return d;
                }
                jVar = jVar2;
                obj = t;
            } else {
                if (i != 1) {
                    throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                }
                jVar = (j) this.a;
                k.b(obj);
            }
            jVar.b(obj);
            return q.a;
        }
    }

    public static final class c extends l implements p {
        public int a;

        public c(d dVar) {
            super(2, dVar);
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public final Object invoke(L l, d dVar) {
            return create(l, dVar).invokeSuspend(q.a);
        }

        public final d create(Object obj, d dVar) {
            return CoroutineWorker.this.new c(dVar);
        }

        public final Object invokeSuspend(Object obj) {
            Object d = p8.c.d();
            int i = this.a;
            try {
                if (i == 0) {
                    k.b(obj);
                    CoroutineWorker coroutineWorker = CoroutineWorker.this;
                    this.a = 1;
                    obj = coroutineWorker.r(this);
                    if (obj == d) {
                        return d;
                    }
                } else {
                    if (i != 1) {
                        throw new IllegalStateException("call to 'resume' before 'invoke' with coroutine");
                    }
                    k.b(obj);
                }
                CoroutineWorker.this.v().p((ListenableWorker.a) obj);
            } catch (Throwable th) {
                CoroutineWorker.this.v().q(th);
            }
            return q.a;
        }
    }

    /* JADX WARN: 'super' call moved to the top of the method (can break code semantics) */
    public CoroutineWorker(@NotNull Context context, @NotNull WorkerParameters workerParameters) {
        super(context, workerParameters);
        kotlin.jvm.internal.l.e(context, "appContext");
        kotlin.jvm.internal.l.e(workerParameters, "params");
        this.g = B0.b((x0) null, 1, (Object) null);
        b1.c t = b1.c.t();
        kotlin.jvm.internal.l.d(t, "create()");
        this.h = t;
        t.addListener(new a(), h().c());
        this.i = b0.a();
    }

    public static /* synthetic */ Object u(CoroutineWorker coroutineWorker, d dVar) {
        throw new IllegalStateException("Not implemented");
    }

    public final y5.b d() {
        z b2 = B0.b((x0) null, 1, (Object) null);
        L a2 = M.a(s().V(b2));
        j jVar = new j(b2, null, 2, null);
        i.d(a2, (g) null, (N) null, new b(jVar, this, null), 3, (Object) null);
        return jVar;
    }

    public final void m() {
        super.m();
        this.h.cancel(false);
    }

    public final y5.b p() {
        i.d(M.a(s().V(this.g)), (g) null, (N) null, new c(null), 3, (Object) null);
        return this.h;
    }

    public abstract Object r(d dVar);

    public H s() {
        return this.i;
    }

    public Object t(d dVar) {
        return u(this, dVar);
    }

    public final b1.c v() {
        return this.h;
    }

    public final z w() {
        return this.g;
    }
}
