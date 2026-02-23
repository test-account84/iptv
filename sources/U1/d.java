package U1;

import U1.i;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.List;
import java.util.Set;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Future;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d implements i.a {
    public static final b q = new b();
    public static final Handler r = new Handler(Looper.getMainLooper(), new c(null));
    public final List a;
    public final b b;
    public final e c;
    public final S1.c d;
    public final ExecutorService e;
    public final ExecutorService f;
    public final boolean g;
    public boolean h;
    public l i;
    public boolean j;
    public Exception k;
    public boolean l;
    public Set m;
    public i n;
    public h o;
    public volatile Future p;

    public static class b {
        public h a(l lVar, boolean z) {
            return new h(lVar, z);
        }
    }

    public static class c implements Handler.Callback {
        public c() {
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (1 != i && 2 != i) {
                return false;
            }
            d dVar = (d) message.obj;
            if (1 == i) {
                d.b(dVar);
            } else {
                d.d(dVar);
            }
            return true;
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public d(S1.c cVar, ExecutorService executorService, ExecutorService executorService2, boolean z, e eVar) {
        this(cVar, executorService, executorService2, z, eVar, q);
    }

    public static /* synthetic */ void b(d dVar) {
        dVar.j();
    }

    public static /* synthetic */ void d(d dVar) {
        dVar.i();
    }

    public void a(Exception exc) {
        this.k = exc;
        r.obtainMessage(2, this).sendToTarget();
    }

    public void c(i iVar) {
        this.p = this.f.submit(iVar);
    }

    public void e(m2.e eVar) {
        q2.h.a();
        if (this.j) {
            eVar.f(this.o);
        } else if (this.l) {
            eVar.a(this.k);
        } else {
            this.a.add(eVar);
        }
    }

    public void f(l lVar) {
        this.i = lVar;
        r.obtainMessage(1, this).sendToTarget();
    }

    public final void g(m2.e eVar) {
        if (this.m == null) {
            this.m = new HashSet();
        }
        this.m.add(eVar);
    }

    public void h() {
        if (this.l || this.j || this.h) {
            return;
        }
        this.n.b();
        Future future = this.p;
        if (future != null) {
            future.cancel(true);
        }
        this.h = true;
        this.c.a(this, this.d);
    }

    public final void i() {
        if (this.h) {
            return;
        }
        if (this.a.isEmpty()) {
            throw new IllegalStateException("Received an exception without any callbacks to notify");
        }
        this.l = true;
        this.c.d(this.d, null);
        for (m2.e eVar : this.a) {
            if (!k(eVar)) {
                eVar.a(this.k);
            }
        }
    }

    public final void j() {
        if (this.h) {
            this.i.b();
            return;
        }
        if (this.a.isEmpty()) {
            throw new IllegalStateException("Received a resource without any callbacks to notify");
        }
        h a2 = this.b.a(this.i, this.g);
        this.o = a2;
        this.j = true;
        a2.a();
        this.c.d(this.d, this.o);
        for (m2.e eVar : this.a) {
            if (!k(eVar)) {
                this.o.a();
                eVar.f(this.o);
            }
        }
        this.o.d();
    }

    public final boolean k(m2.e eVar) {
        Set set = this.m;
        return set != null && set.contains(eVar);
    }

    public void l(m2.e eVar) {
        q2.h.a();
        if (this.j || this.l) {
            g(eVar);
            return;
        }
        this.a.remove(eVar);
        if (this.a.isEmpty()) {
            h();
        }
    }

    public void m(i iVar) {
        this.n = iVar;
        this.p = this.e.submit(iVar);
    }

    public d(S1.c cVar, ExecutorService executorService, ExecutorService executorService2, boolean z, e eVar, b bVar) {
        this.a = new ArrayList();
        this.d = cVar;
        this.e = executorService;
        this.f = executorService2;
        this.g = z;
        this.c = eVar;
        this.b = bVar;
    }
}
