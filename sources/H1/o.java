package h1;

import android.os.Handler;
import android.os.Looper;
import d.D;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;
import java.util.concurrent.PriorityBlockingQueue;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class o {
    public final AtomicInteger a;
    public final Set b;
    public final PriorityBlockingQueue c;
    public final PriorityBlockingQueue d;
    public final b e;
    public final h f;
    public final q g;
    public final i[] h;
    public c i;
    public final List j;
    public final List k;

    public o(b bVar, h hVar) {
        this(bVar, hVar, 4);
    }

    public n a(n nVar) {
        nVar.Q(this);
        synchronized (this.b) {
            this.b.add(nVar);
        }
        nVar.S(d());
        nVar.b("add-to-queue");
        e(nVar, 0);
        b(nVar);
        return nVar;
    }

    public void b(n nVar) {
        if (nVar.T()) {
            this.c.add(nVar);
        } else {
            f(nVar);
        }
    }

    public void c(n nVar) {
        synchronized (this.b) {
            this.b.remove(nVar);
        }
        synchronized (this.j) {
            Iterator it = this.j.iterator();
            if (it.hasNext()) {
                D.a(it.next());
                throw null;
            }
        }
        e(nVar, 5);
    }

    public int d() {
        return this.a.incrementAndGet();
    }

    public void e(n nVar, int i) {
        synchronized (this.k) {
            try {
                Iterator it = this.k.iterator();
                if (it.hasNext()) {
                    D.a(it.next());
                    throw null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f(n nVar) {
        this.d.add(nVar);
    }

    public void g() {
        h();
        c cVar = new c(this.c, this.d, this.e, this.g);
        this.i = cVar;
        cVar.start();
        for (int i = 0; i < this.h.length; i++) {
            i iVar = new i(this.d, this.f, this.e, this.g);
            this.h[i] = iVar;
            iVar.start();
        }
    }

    public void h() {
        c cVar = this.i;
        if (cVar != null) {
            cVar.d();
        }
        for (i iVar : this.h) {
            if (iVar != null) {
                iVar.e();
            }
        }
    }

    public o(b bVar, h hVar, int i) {
        this(bVar, hVar, i, new f(new Handler(Looper.getMainLooper())));
    }

    public o(b bVar, h hVar, int i, q qVar) {
        this.a = new AtomicInteger();
        this.b = new HashSet();
        this.c = new PriorityBlockingQueue();
        this.d = new PriorityBlockingQueue();
        this.j = new ArrayList();
        this.k = new ArrayList();
        this.e = bVar;
        this.f = hVar;
        this.h = new i[i];
        this.g = qVar;
    }
}
