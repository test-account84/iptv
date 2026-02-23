package R0;

import Z0.p;
import Z0.q;
import Z0.t;
import a1.o;
import android.content.Context;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import androidx.work.impl.background.systemalarm.RescheduleReceiver;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.LinkedList;
import java.util.List;
import java.util.UUID;
import java.util.concurrent.CancellationException;
import java.util.concurrent.ExecutionException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class k implements Runnable {
    public static final String u = Q0.k.f("WorkerWrapper");
    public Context a;
    public String c;
    public List d;
    public WorkerParameters.a e;
    public p f;
    public ListenableWorker g;
    public c1.a h;
    public androidx.work.a j;
    public Y0.a k;
    public WorkDatabase l;
    public q m;
    public Z0.b n;
    public t o;
    public List p;
    public String q;
    public volatile boolean t;
    public ListenableWorker.a i = ListenableWorker.a.a();
    public b1.c r = b1.c.t();
    public y5.b s = null;

    public class a implements Runnable {
        public final /* synthetic */ y5.b a;
        public final /* synthetic */ b1.c c;

        public a(y5.b bVar, b1.c cVar) {
            this.a = bVar;
            this.c = cVar;
        }

        public void run() {
            try {
                this.a.get();
                Q0.k.c().a(k.u, String.format("Starting work for %s", new Object[]{k.this.f.c}), new Throwable[0]);
                k kVar = k.this;
                kVar.s = kVar.g.p();
                this.c.r(k.this.s);
            } catch (Throwable th) {
                this.c.q(th);
            }
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ b1.c a;
        public final /* synthetic */ String c;

        public b(b1.c cVar, String str) {
            this.a = cVar;
            this.c = str;
        }

        public void run() {
            try {
                try {
                    ListenableWorker.a aVar = (ListenableWorker.a) this.a.get();
                    if (aVar == null) {
                        Q0.k.c().b(k.u, String.format("%s returned a null result. Treating it as a failure.", new Object[]{k.this.f.c}), new Throwable[0]);
                    } else {
                        Q0.k.c().a(k.u, String.format("%s returned a %s result.", new Object[]{k.this.f.c, aVar}), new Throwable[0]);
                        k.this.i = aVar;
                    }
                } catch (CancellationException e) {
                    Q0.k.c().d(k.u, String.format("%s was cancelled", new Object[]{this.c}), e);
                } catch (ExecutionException e2) {
                    e = e2;
                    Q0.k.c().b(k.u, String.format("%s failed because it threw an exception/error", new Object[]{this.c}), e);
                } catch (InterruptedException e3) {
                    e = e3;
                    Q0.k.c().b(k.u, String.format("%s failed because it threw an exception/error", new Object[]{this.c}), e);
                }
                k.this.f();
            } catch (Throwable th) {
                k.this.f();
                throw th;
            }
        }
    }

    public static class c {
        public Context a;
        public ListenableWorker b;
        public Y0.a c;
        public c1.a d;
        public androidx.work.a e;
        public WorkDatabase f;
        public String g;
        public List h;
        public WorkerParameters.a i = new WorkerParameters.a();

        public c(Context context, androidx.work.a aVar, c1.a aVar2, Y0.a aVar3, WorkDatabase workDatabase, String str) {
            this.a = context.getApplicationContext();
            this.d = aVar2;
            this.c = aVar3;
            this.e = aVar;
            this.f = workDatabase;
            this.g = str;
        }

        public k a() {
            return new k(this);
        }

        public c b(WorkerParameters.a aVar) {
            if (aVar != null) {
                this.i = aVar;
            }
            return this;
        }

        public c c(List list) {
            this.h = list;
            return this;
        }
    }

    public k(c cVar) {
        this.a = cVar.a;
        this.h = cVar.d;
        this.k = cVar.c;
        this.c = cVar.g;
        this.d = cVar.h;
        this.e = cVar.i;
        this.g = cVar.b;
        this.j = cVar.e;
        WorkDatabase workDatabase = cVar.f;
        this.l = workDatabase;
        this.m = workDatabase.B();
        this.n = this.l.t();
        this.o = this.l.C();
    }

    public final String a(List list) {
        StringBuilder sb = new StringBuilder("Work [ id=");
        sb.append(this.c);
        sb.append(", tags={ ");
        Iterator it = list.iterator();
        boolean z = true;
        while (it.hasNext()) {
            String str = (String) it.next();
            if (z) {
                z = false;
            } else {
                sb.append(", ");
            }
            sb.append(str);
        }
        sb.append(" } ]");
        return sb.toString();
    }

    public y5.b b() {
        return this.r;
    }

    public final void c(ListenableWorker.a aVar) {
        if (aVar instanceof ListenableWorker.a.c) {
            Q0.k.c().d(u, String.format("Worker result SUCCESS for %s", new Object[]{this.q}), new Throwable[0]);
            if (!this.f.d()) {
                m();
                return;
            }
        } else if (aVar instanceof ListenableWorker.a.b) {
            Q0.k.c().d(u, String.format("Worker result RETRY for %s", new Object[]{this.q}), new Throwable[0]);
            g();
            return;
        } else {
            Q0.k.c().d(u, String.format("Worker result FAILURE for %s", new Object[]{this.q}), new Throwable[0]);
            if (!this.f.d()) {
                l();
                return;
            }
        }
        h();
    }

    public void d() {
        boolean z;
        this.t = true;
        n();
        y5.b bVar = this.s;
        if (bVar != null) {
            z = bVar.isDone();
            this.s.cancel(true);
        } else {
            z = false;
        }
        ListenableWorker listenableWorker = this.g;
        if (listenableWorker == null || z) {
            Q0.k.c().a(u, String.format("WorkSpec %s is already done. Not interrupting.", new Object[]{this.f}), new Throwable[0]);
        } else {
            listenableWorker.q();
        }
    }

    public final void e(String str) {
        LinkedList linkedList = new LinkedList();
        linkedList.add(str);
        while (!linkedList.isEmpty()) {
            String str2 = (String) linkedList.remove();
            if (this.m.g(str2) != Q0.t.CANCELLED) {
                this.m.d(Q0.t.FAILED, str2);
            }
            linkedList.addAll(this.n.a(str2));
        }
    }

    public void f() {
        if (!n()) {
            this.l.c();
            try {
                Q0.t g = this.m.g(this.c);
                this.l.A().a(this.c);
                if (g == null) {
                    i(false);
                } else if (g == Q0.t.RUNNING) {
                    c(this.i);
                } else if (!g.isFinished()) {
                    g();
                }
                this.l.r();
                this.l.g();
            } catch (Throwable th) {
                this.l.g();
                throw th;
            }
        }
        List list = this.d;
        if (list != null) {
            Iterator it = list.iterator();
            while (it.hasNext()) {
                ((e) it.next()).a(this.c);
            }
            f.b(this.j, this.l, this.d);
        }
    }

    public final void g() {
        this.l.c();
        try {
            this.m.d(Q0.t.ENQUEUED, this.c);
            this.m.u(this.c, System.currentTimeMillis());
            this.m.m(this.c, -1L);
            this.l.r();
        } finally {
            this.l.g();
            i(true);
        }
    }

    public final void h() {
        this.l.c();
        try {
            this.m.u(this.c, System.currentTimeMillis());
            this.m.d(Q0.t.ENQUEUED, this.c);
            this.m.s(this.c);
            this.m.m(this.c, -1L);
            this.l.r();
        } finally {
            this.l.g();
            i(false);
        }
    }

    public final void i(boolean z) {
        ListenableWorker listenableWorker;
        this.l.c();
        try {
            if (!this.l.B().r()) {
                a1.g.a(this.a, RescheduleReceiver.class, false);
            }
            if (z) {
                this.m.d(Q0.t.ENQUEUED, this.c);
                this.m.m(this.c, -1L);
            }
            if (this.f != null && (listenableWorker = this.g) != null && listenableWorker.j()) {
                this.k.a(this.c);
            }
            this.l.r();
            this.l.g();
            this.r.p(Boolean.valueOf(z));
        } catch (Throwable th) {
            this.l.g();
            throw th;
        }
    }

    public final void j() {
        Q0.t g = this.m.g(this.c);
        if (g == Q0.t.RUNNING) {
            Q0.k.c().a(u, String.format("Status for %s is RUNNING;not doing any work and rescheduling for later execution", new Object[]{this.c}), new Throwable[0]);
            i(true);
        } else {
            Q0.k.c().a(u, String.format("Status for %s is %s; not doing any work", new Object[]{this.c, g}), new Throwable[0]);
            i(false);
        }
    }

    public final void k() {
        androidx.work.b b2;
        if (n()) {
            return;
        }
        this.l.c();
        try {
            p h = this.m.h(this.c);
            this.f = h;
            if (h == null) {
                Q0.k.c().b(u, String.format("Didn't find WorkSpec for id %s", new Object[]{this.c}), new Throwable[0]);
                i(false);
                this.l.r();
                return;
            }
            if (h.b != Q0.t.ENQUEUED) {
                j();
                this.l.r();
                Q0.k.c().a(u, String.format("%s is not in ENQUEUED state. Nothing more to do.", new Object[]{this.f.c}), new Throwable[0]);
                return;
            }
            if (h.d() || this.f.c()) {
                long currentTimeMillis = System.currentTimeMillis();
                p pVar = this.f;
                if (pVar.n != 0 && currentTimeMillis < pVar.a()) {
                    Q0.k.c().a(u, String.format("Delaying execution for %s because it is being executed before schedule.", new Object[]{this.f.c}), new Throwable[0]);
                    i(true);
                    this.l.r();
                    return;
                }
            }
            this.l.r();
            this.l.g();
            if (this.f.d()) {
                b2 = this.f.e;
            } else {
                Q0.h b3 = this.j.f().b(this.f.d);
                if (b3 == null) {
                    Q0.k.c().b(u, String.format("Could not create Input Merger %s", new Object[]{this.f.d}), new Throwable[0]);
                    l();
                    return;
                } else {
                    ArrayList arrayList = new ArrayList();
                    arrayList.add(this.f.e);
                    arrayList.addAll(this.m.j(this.c));
                    b2 = b3.b(arrayList);
                }
            }
            WorkerParameters workerParameters = new WorkerParameters(UUID.fromString(this.c), b2, this.p, this.e, this.f.k, this.j.e(), this.h, this.j.m(), new a1.q(this.l, this.h), new a1.p(this.l, this.k, this.h));
            if (this.g == null) {
                this.g = this.j.m().b(this.a, this.f.c, workerParameters);
            }
            ListenableWorker listenableWorker = this.g;
            if (listenableWorker == null) {
                Q0.k.c().b(u, String.format("Could not create Worker %s", new Object[]{this.f.c}), new Throwable[0]);
                l();
                return;
            }
            if (listenableWorker.l()) {
                Q0.k.c().b(u, String.format("Received an already-used Worker %s; WorkerFactory should return new instances", new Object[]{this.f.c}), new Throwable[0]);
                l();
                return;
            }
            this.g.o();
            if (!o()) {
                j();
                return;
            }
            if (n()) {
                return;
            }
            b1.c t = b1.c.t();
            o oVar = new o(this.a, this.f, this.g, workerParameters.b(), this.h);
            this.h.a().execute(oVar);
            y5.b a2 = oVar.a();
            a2.addListener(new a(a2, t), this.h.a());
            t.addListener(new b(t, this.q), this.h.c());
        } finally {
            this.l.g();
        }
    }

    public void l() {
        this.l.c();
        try {
            e(this.c);
            this.m.p(this.c, ((ListenableWorker.a.a) this.i).e());
            this.l.r();
        } finally {
            this.l.g();
            i(false);
        }
    }

    public final void m() {
        this.l.c();
        try {
            this.m.d(Q0.t.SUCCEEDED, this.c);
            this.m.p(this.c, ((ListenableWorker.a.c) this.i).e());
            long currentTimeMillis = System.currentTimeMillis();
            for (String str : this.n.a(this.c)) {
                if (this.m.g(str) == Q0.t.BLOCKED && this.n.b(str)) {
                    Q0.k.c().d(u, String.format("Setting status to enqueued for %s", new Object[]{str}), new Throwable[0]);
                    this.m.d(Q0.t.ENQUEUED, str);
                    this.m.u(str, currentTimeMillis);
                }
            }
            this.l.r();
            this.l.g();
            i(false);
        } catch (Throwable th) {
            this.l.g();
            i(false);
            throw th;
        }
    }

    public final boolean n() {
        if (!this.t) {
            return false;
        }
        Q0.k.c().a(u, String.format("Work interrupted for %s", new Object[]{this.q}), new Throwable[0]);
        if (this.m.g(this.c) == null) {
            i(false);
        } else {
            i(!r1.isFinished());
        }
        return true;
    }

    public final boolean o() {
        boolean z;
        this.l.c();
        try {
            if (this.m.g(this.c) == Q0.t.ENQUEUED) {
                this.m.d(Q0.t.RUNNING, this.c);
                this.m.t(this.c);
                z = true;
            } else {
                z = false;
            }
            this.l.r();
            this.l.g();
            return z;
        } catch (Throwable th) {
            this.l.g();
            throw th;
        }
    }

    public void run() {
        List a2 = this.o.a(this.c);
        this.p = a2;
        this.q = a(a2);
        k();
    }
}
