package androidx.lifecycle;

import androidx.lifecycle.j;
import java.lang.ref.WeakReference;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.Map;
import m.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class q extends j {
    public m.a b;
    public j.c c;
    public final WeakReference d;
    public int e;
    public boolean f;
    public boolean g;
    public ArrayList h;
    public final boolean i;

    public static class a {
        public j.c a;
        public n b;

        public a(o oVar, j.c cVar) {
            this.b = s.f(oVar);
            this.a = cVar;
        }

        public void a(p pVar, j.b bVar) {
            j.c targetState = bVar.getTargetState();
            this.a = q.k(this.a, targetState);
            this.b.b(pVar, bVar);
            this.a = targetState;
        }
    }

    public q(p pVar) {
        this(pVar, true);
    }

    public static j.c k(j.c cVar, j.c cVar2) {
        return (cVar2 == null || cVar2.compareTo(cVar) >= 0) ? cVar : cVar2;
    }

    public void a(o oVar) {
        p pVar;
        f("addObserver");
        j.c cVar = this.c;
        j.c cVar2 = j.c.DESTROYED;
        if (cVar != cVar2) {
            cVar2 = j.c.INITIALIZED;
        }
        a aVar = new a(oVar, cVar2);
        if (((a) this.b.i(oVar, aVar)) == null && (pVar = (p) this.d.get()) != null) {
            boolean z = this.e != 0 || this.f;
            j.c e = e(oVar);
            this.e++;
            while (aVar.a.compareTo(e) < 0 && this.b.contains(oVar)) {
                n(aVar.a);
                j.b upFrom = j.b.upFrom(aVar.a);
                if (upFrom == null) {
                    throw new IllegalStateException("no event up from " + aVar.a);
                }
                aVar.a(pVar, upFrom);
                m();
                e = e(oVar);
            }
            if (!z) {
                p();
            }
            this.e--;
        }
    }

    public j.c b() {
        return this.c;
    }

    public void c(o oVar) {
        f("removeObserver");
        this.b.j(oVar);
    }

    public final void d(p pVar) {
        Iterator descendingIterator = this.b.descendingIterator();
        while (descendingIterator.hasNext() && !this.g) {
            Map.Entry entry = (Map.Entry) descendingIterator.next();
            a aVar = (a) entry.getValue();
            while (aVar.a.compareTo(this.c) > 0 && !this.g && this.b.contains((o) entry.getKey())) {
                j.b downFrom = j.b.downFrom(aVar.a);
                if (downFrom == null) {
                    throw new IllegalStateException("no event down from " + aVar.a);
                }
                n(downFrom.getTargetState());
                aVar.a(pVar, downFrom);
                m();
            }
        }
    }

    public final j.c e(o oVar) {
        Map.Entry l = this.b.l(oVar);
        j.c cVar = null;
        j.c cVar2 = l != null ? ((a) l.getValue()).a : null;
        if (!this.h.isEmpty()) {
            cVar = (j.c) this.h.get(r0.size() - 1);
        }
        return k(k(this.c, cVar2), cVar);
    }

    public final void f(String str) {
        if (!this.i || l.a.e().b()) {
            return;
        }
        throw new IllegalStateException("Method " + str + " must be called on the main thread");
    }

    public final void g(p pVar) {
        b.d f = this.b.f();
        while (f.hasNext() && !this.g) {
            Map.Entry entry = (Map.Entry) f.next();
            a aVar = (a) entry.getValue();
            while (aVar.a.compareTo(this.c) < 0 && !this.g && this.b.contains((o) entry.getKey())) {
                n(aVar.a);
                j.b upFrom = j.b.upFrom(aVar.a);
                if (upFrom == null) {
                    throw new IllegalStateException("no event up from " + aVar.a);
                }
                aVar.a(pVar, upFrom);
                m();
            }
        }
    }

    public void h(j.b bVar) {
        f("handleLifecycleEvent");
        l(bVar.getTargetState());
    }

    public final boolean i() {
        if (this.b.size() == 0) {
            return true;
        }
        j.c cVar = ((a) this.b.d().getValue()).a;
        j.c cVar2 = ((a) this.b.g().getValue()).a;
        return cVar == cVar2 && this.c == cVar2;
    }

    public void j(j.c cVar) {
        f("markState");
        o(cVar);
    }

    public final void l(j.c cVar) {
        j.c cVar2 = this.c;
        if (cVar2 == cVar) {
            return;
        }
        if (cVar2 == j.c.INITIALIZED && cVar == j.c.DESTROYED) {
            throw new IllegalStateException("no event down from " + this.c);
        }
        this.c = cVar;
        if (this.f || this.e != 0) {
            this.g = true;
            return;
        }
        this.f = true;
        p();
        this.f = false;
        if (this.c == j.c.DESTROYED) {
            this.b = new m.a();
        }
    }

    public final void m() {
        this.h.remove(r0.size() - 1);
    }

    public final void n(j.c cVar) {
        this.h.add(cVar);
    }

    public void o(j.c cVar) {
        f("setCurrentState");
        l(cVar);
    }

    public final void p() {
        p pVar = (p) this.d.get();
        if (pVar == null) {
            throw new IllegalStateException("LifecycleOwner of this LifecycleRegistry is alreadygarbage collected. It is too late to change lifecycle state.");
        }
        while (true) {
            boolean i = i();
            this.g = false;
            if (i) {
                return;
            }
            if (this.c.compareTo(((a) this.b.d().getValue()).a) < 0) {
                d(pVar);
            }
            Map.Entry g = this.b.g();
            if (!this.g && g != null && this.c.compareTo(((a) g.getValue()).a) > 0) {
                g(pVar);
            }
        }
    }

    public q(p pVar, boolean z) {
        this.b = new m.a();
        this.e = 0;
        this.f = false;
        this.g = false;
        this.h = new ArrayList();
        this.d = new WeakReference(pVar);
        this.c = j.c.INITIALIZED;
        this.i = z;
    }
}
