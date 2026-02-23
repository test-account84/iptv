package androidx.lifecycle;

import androidx.lifecycle.j;
import java.util.Iterator;
import java.util.Map;
import m.b;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class LiveData {
    public static final Object k = new Object();
    public final Object a = new Object();
    public m.b b = new m.b();
    public int c = 0;
    public boolean d;
    public volatile Object e;
    public volatile Object f;
    public int g;
    public boolean h;
    public boolean i;
    public final Runnable j;

    public class LifecycleBoundObserver extends c implements n {
        public final p f;

        public LifecycleBoundObserver(p pVar, v vVar) {
            super(vVar);
            this.f = pVar;
        }

        public void b(p pVar, j.b bVar) {
            j.c b = this.f.getLifecycle().b();
            if (b == j.c.DESTROYED) {
                LiveData.this.m(this.a);
                return;
            }
            j.c cVar = null;
            while (cVar != b) {
                c(k());
                cVar = b;
                b = this.f.getLifecycle().b();
            }
        }

        public void e() {
            this.f.getLifecycle().c(this);
        }

        public boolean j(p pVar) {
            return this.f == pVar;
        }

        public boolean k() {
            return this.f.getLifecycle().b().isAtLeast(j.c.STARTED);
        }
    }

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            Object obj;
            synchronized (LiveData.this.a) {
                obj = LiveData.this.f;
                LiveData.this.f = LiveData.k;
            }
            LiveData.this.o(obj);
        }
    }

    public class b extends c {
        public b(v vVar) {
            super(vVar);
        }

        public boolean k() {
            return true;
        }
    }

    public abstract class c {
        public final v a;
        public boolean c;
        public int d = -1;

        public c(v vVar) {
            this.a = vVar;
        }

        public void c(boolean z) {
            if (z == this.c) {
                return;
            }
            this.c = z;
            LiveData.this.c(z ? 1 : -1);
            if (this.c) {
                LiveData.this.e(this);
            }
        }

        public void e() {
        }

        public boolean j(p pVar) {
            return false;
        }

        public abstract boolean k();
    }

    public LiveData() {
        Object obj = k;
        this.f = obj;
        this.j = new a();
        this.e = obj;
        this.g = -1;
    }

    public static void b(String str) {
        if (l.a.e().b()) {
            return;
        }
        throw new IllegalStateException("Cannot invoke " + str + " on a background thread");
    }

    public void c(int i) {
        int i2 = this.c;
        this.c = i + i2;
        if (this.d) {
            return;
        }
        this.d = true;
        while (true) {
            try {
                int i3 = this.c;
                if (i2 == i3) {
                    this.d = false;
                    return;
                }
                boolean z = i2 == 0 && i3 > 0;
                boolean z2 = i2 > 0 && i3 == 0;
                if (z) {
                    j();
                } else if (z2) {
                    k();
                }
                i2 = i3;
            } catch (Throwable th) {
                this.d = false;
                throw th;
            }
        }
    }

    public final void d(c cVar) {
        if (cVar.c) {
            if (!cVar.k()) {
                cVar.c(false);
                return;
            }
            int i = cVar.d;
            int i2 = this.g;
            if (i >= i2) {
                return;
            }
            cVar.d = i2;
            cVar.a.a(this.e);
        }
    }

    public void e(c cVar) {
        if (this.h) {
            this.i = true;
            return;
        }
        this.h = true;
        do {
            this.i = false;
            if (cVar != null) {
                d(cVar);
                cVar = null;
            } else {
                b.d f = this.b.f();
                while (f.hasNext()) {
                    d((c) ((Map.Entry) f.next()).getValue());
                    if (this.i) {
                        break;
                    }
                }
            }
        } while (this.i);
        this.h = false;
    }

    public Object f() {
        Object obj = this.e;
        if (obj != k) {
            return obj;
        }
        return null;
    }

    public boolean g() {
        return this.c > 0;
    }

    public void h(p pVar, v vVar) {
        b("observe");
        if (pVar.getLifecycle().b() == j.c.DESTROYED) {
            return;
        }
        LifecycleBoundObserver lifecycleBoundObserver = new LifecycleBoundObserver(pVar, vVar);
        c cVar = (c) this.b.i(vVar, lifecycleBoundObserver);
        if (cVar != null && !cVar.j(pVar)) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVar != null) {
            return;
        }
        pVar.getLifecycle().a(lifecycleBoundObserver);
    }

    public void i(v vVar) {
        b("observeForever");
        b bVar = new b(vVar);
        c cVar = (c) this.b.i(vVar, bVar);
        if (cVar instanceof LifecycleBoundObserver) {
            throw new IllegalArgumentException("Cannot add the same observer with different lifecycles");
        }
        if (cVar != null) {
            return;
        }
        bVar.c(true);
    }

    public void j() {
    }

    public void k() {
    }

    public void l(Object obj) {
        boolean z;
        synchronized (this.a) {
            z = this.f == k;
            this.f = obj;
        }
        if (z) {
            l.a.e().c(this.j);
        }
    }

    public void m(v vVar) {
        b("removeObserver");
        c cVar = (c) this.b.j(vVar);
        if (cVar == null) {
            return;
        }
        cVar.e();
        cVar.c(false);
    }

    public void n(p pVar) {
        b("removeObservers");
        Iterator it = this.b.iterator();
        while (it.hasNext()) {
            Map.Entry entry = (Map.Entry) it.next();
            if (((c) entry.getValue()).j(pVar)) {
                m((v) entry.getKey());
            }
        }
    }

    public void o(Object obj) {
        b("setValue");
        this.g++;
        this.e = obj;
        e(null);
    }
}
