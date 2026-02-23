package k6;

import I5.x;
import android.text.TextUtils;
import com.google.android.gms.common.internal.r;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.TaskCompletionSource;
import com.google.android.gms.tasks.Tasks;
import d.D;
import java.io.IOException;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.Executor;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;
import k6.i;
import m6.d;
import m6.f;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class g implements h {
    public static final Object m = new Object();
    public static final ThreadFactory n = new a();
    public final A5.f a;
    public final m6.c b;
    public final l6.c c;
    public final p d;
    public final x e;
    public final n f;
    public final Object g;
    public final ExecutorService h;
    public final Executor i;
    public String j;
    public Set k;
    public final List l;

    public class a implements ThreadFactory {
        public final AtomicInteger a = new AtomicInteger(1);

        public Thread newThread(Runnable runnable) {
            return new Thread(runnable, String.format("firebase-installations-executor-%d", new Object[]{Integer.valueOf(this.a.getAndIncrement())}));
        }
    }

    public static /* synthetic */ class b {
        public static final /* synthetic */ int[] a;
        public static final /* synthetic */ int[] b;

        static {
            int[] iArr = new int[f.b.values().length];
            b = iArr;
            try {
                iArr[f.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused) {
            }
            try {
                b[f.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused2) {
            }
            try {
                b[f.b.AUTH_ERROR.ordinal()] = 3;
            } catch (NoSuchFieldError unused3) {
            }
            int[] iArr2 = new int[d.b.values().length];
            a = iArr2;
            try {
                iArr2[d.b.OK.ordinal()] = 1;
            } catch (NoSuchFieldError unused4) {
            }
            try {
                a[d.b.BAD_CONFIG.ordinal()] = 2;
            } catch (NoSuchFieldError unused5) {
            }
        }
    }

    public g(A5.f fVar, j6.b bVar, ExecutorService executorService, Executor executor) {
        this(executorService, executor, fVar, new m6.c(fVar.l(), bVar), new l6.c(fVar), p.c(), new x(new c(fVar)), new n());
    }

    public static /* synthetic */ void b(g gVar, boolean z) {
        gVar.x(z);
    }

    public static /* synthetic */ void c(g gVar, boolean z) {
        gVar.v(z);
    }

    public static /* synthetic */ void d(g gVar) {
        gVar.w();
    }

    public static /* synthetic */ l6.b e(A5.f fVar) {
        return y(fVar);
    }

    public static g p() {
        return q(A5.f.m());
    }

    public static g q(A5.f fVar) {
        r.b(fVar != null, "Null is not a valid value of FirebaseApp.");
        return (g) fVar.j(h.class);
    }

    public static /* synthetic */ l6.b y(A5.f fVar) {
        return new l6.b(fVar);
    }

    public final String A(l6.d dVar) {
        if ((!this.a.o().equals("CHIME_ANDROID_SDK") && !this.a.w()) || !dVar.m()) {
            return this.f.a();
        }
        String f = o().f();
        return TextUtils.isEmpty(f) ? this.f.a() : f;
    }

    public final l6.d B(l6.d dVar) {
        m6.d d = this.b.d(l(), dVar.d(), t(), m(), (dVar.d() == null || dVar.d().length() != 11) ? null : o().i());
        int i = b.a[d.e().ordinal()];
        if (i == 1) {
            return dVar.s(d.c(), d.d(), this.d.b(), d.b().c(), d.b().d());
        }
        if (i == 2) {
            return dVar.q("BAD CONFIG");
        }
        throw new i("Firebase Installations Service is unavailable. Please try again later.", i.a.UNAVAILABLE);
    }

    public final void C(Exception exc) {
        synchronized (this.g) {
            try {
                Iterator it = this.l.iterator();
                while (it.hasNext()) {
                    if (((o) it.next()).a(exc)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final void D(l6.d dVar) {
        synchronized (this.g) {
            try {
                Iterator it = this.l.iterator();
                while (it.hasNext()) {
                    if (((o) it.next()).b(dVar)) {
                        it.remove();
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public final synchronized void E(String str) {
        this.j = str;
    }

    public final synchronized void F(l6.d dVar, l6.d dVar2) {
        if (this.k.size() != 0 && !TextUtils.equals(dVar.d(), dVar2.d())) {
            Iterator it = this.k.iterator();
            if (it.hasNext()) {
                D.a(it.next());
                dVar2.d();
                throw null;
            }
        }
    }

    public Task a(boolean z) {
        z();
        Task f = f();
        this.h.execute(new e(this, z));
        return f;
    }

    public final Task f() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        h(new k(this.d, taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public final Task g() {
        TaskCompletionSource taskCompletionSource = new TaskCompletionSource();
        h(new l(taskCompletionSource));
        return taskCompletionSource.getTask();
    }

    public Task getId() {
        z();
        String n2 = n();
        if (n2 != null) {
            return Tasks.forResult(n2);
        }
        Task g = g();
        this.h.execute(new d(this));
        return g;
    }

    public final void h(o oVar) {
        synchronized (this.g) {
            this.l.add(oVar);
        }
    }

    /* renamed from: i, reason: merged with bridge method [inline-methods] */
    public final void v(boolean z) {
        l6.d B;
        i iOException;
        l6.d r = r();
        try {
            if (r.i() || r.l()) {
                B = B(r);
            } else {
                if (!z && !this.d.f(r)) {
                    return;
                }
                B = k(r);
            }
            u(B);
            F(r, B);
            if (B.k()) {
                E(B.d());
            }
            if (B.i()) {
                iOException = new i(i.a.BAD_CONFIG);
            } else {
                if (!B.j()) {
                    D(B);
                    return;
                }
                iOException = new IOException("Installation ID could not be validated with the Firebase servers (maybe it was deleted). Firebase Installations will need to create a new Installation ID and auth token. Please retry your last request.");
            }
            C(iOException);
        } catch (i e) {
            C(e);
        }
    }

    /* renamed from: j, reason: merged with bridge method [inline-methods] */
    public final void x(boolean z) {
        l6.d s = s();
        if (z) {
            s = s.p();
        }
        D(s);
        this.i.execute(new f(this, z));
    }

    public final l6.d k(l6.d dVar) {
        m6.f e = this.b.e(l(), dVar.d(), t(), dVar.f());
        int i = b.b[e.b().ordinal()];
        if (i == 1) {
            return dVar.o(e.c(), e.d(), this.d.b());
        }
        if (i == 2) {
            return dVar.q("BAD CONFIG");
        }
        if (i != 3) {
            throw new i("Firebase Installations Service is unavailable. Please try again later.", i.a.UNAVAILABLE);
        }
        E(null);
        return dVar.r();
    }

    public String l() {
        return this.a.p().b();
    }

    public String m() {
        return this.a.p().c();
    }

    public final synchronized String n() {
        return this.j;
    }

    public final l6.b o() {
        return (l6.b) this.e.get();
    }

    /* JADX WARN: Finally extract failed */
    public final l6.d r() {
        l6.d d;
        synchronized (m) {
            try {
                k6.b a2 = k6.b.a(this.a.l(), "generatefid.lock");
                try {
                    d = this.c.d();
                    if (a2 != null) {
                        a2.b();
                    }
                } catch (Throwable th) {
                    if (a2 != null) {
                        a2.b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return d;
    }

    /* JADX WARN: Finally extract failed */
    public final l6.d s() {
        l6.d d;
        synchronized (m) {
            try {
                k6.b a2 = k6.b.a(this.a.l(), "generatefid.lock");
                try {
                    d = this.c.d();
                    if (d.j()) {
                        d = this.c.b(d.t(A(d)));
                    }
                    if (a2 != null) {
                        a2.b();
                    }
                } catch (Throwable th) {
                    if (a2 != null) {
                        a2.b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
        return d;
    }

    public String t() {
        return this.a.p().e();
    }

    /* JADX WARN: Finally extract failed */
    public final void u(l6.d dVar) {
        synchronized (m) {
            try {
                k6.b a2 = k6.b.a(this.a.l(), "generatefid.lock");
                try {
                    this.c.b(dVar);
                    if (a2 != null) {
                        a2.b();
                    }
                } catch (Throwable th) {
                    if (a2 != null) {
                        a2.b();
                    }
                    throw th;
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public final /* synthetic */ void w() {
        x(false);
    }

    public final void z() {
        r.h(m(), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        r.h(t(), "Please set your Project ID. A valid Firebase Project ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        r.h(l(), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
        r.b(p.h(m()), "Please set your Application ID. A valid Firebase App ID is required to communicate with Firebase server APIs: It identifies your application with Firebase.Please refer to https://firebase.google.com/support/privacy/init-options.");
        r.b(p.g(l()), "Please set a valid API key. A Firebase API key is required to communicate with Firebase server APIs: It authenticates your project with Google.Please refer to https://firebase.google.com/support/privacy/init-options.");
    }

    public g(ExecutorService executorService, Executor executor, A5.f fVar, m6.c cVar, l6.c cVar2, p pVar, x xVar, n nVar) {
        this.g = new Object();
        this.k = new HashSet();
        this.l = new ArrayList();
        this.a = fVar;
        this.b = cVar;
        this.c = cVar2;
        this.d = pVar;
        this.e = xVar;
        this.f = nVar;
        this.h = executorService;
        this.i = executor;
    }
}
