package P;

import android.view.Menu;
import android.view.MenuInflater;
import android.view.MenuItem;
import androidx.lifecycle.j;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class v {
    public final Runnable a;
    public final CopyOnWriteArrayList b = new CopyOnWriteArrayList();
    public final Map c = new HashMap();

    public static class a {
        public final androidx.lifecycle.j a;
        public androidx.lifecycle.n b;

        public a(androidx.lifecycle.j jVar, androidx.lifecycle.n nVar) {
            this.a = jVar;
            this.b = nVar;
            jVar.a(nVar);
        }

        public void a() {
            this.a.c(this.b);
            this.b = null;
        }
    }

    public v(Runnable runnable) {
        this.a = runnable;
    }

    public static /* synthetic */ void a(v vVar, j.c cVar, x xVar, androidx.lifecycle.p pVar, j.b bVar) {
        vVar.g(cVar, xVar, pVar, bVar);
    }

    public static /* synthetic */ void b(v vVar, x xVar, androidx.lifecycle.p pVar, j.b bVar) {
        vVar.f(xVar, pVar, bVar);
    }

    public void c(x xVar) {
        this.b.add(xVar);
        this.a.run();
    }

    public void d(x xVar, androidx.lifecycle.p pVar) {
        c(xVar);
        androidx.lifecycle.j lifecycle = pVar.getLifecycle();
        a aVar = (a) this.c.remove(xVar);
        if (aVar != null) {
            aVar.a();
        }
        this.c.put(xVar, new a(lifecycle, new u(this, xVar)));
    }

    public void e(x xVar, androidx.lifecycle.p pVar, j.c cVar) {
        androidx.lifecycle.j lifecycle = pVar.getLifecycle();
        a aVar = (a) this.c.remove(xVar);
        if (aVar != null) {
            aVar.a();
        }
        this.c.put(xVar, new a(lifecycle, new t(this, cVar, xVar)));
    }

    public final /* synthetic */ void f(x xVar, androidx.lifecycle.p pVar, j.b bVar) {
        if (bVar == j.b.ON_DESTROY) {
            l(xVar);
        }
    }

    public final /* synthetic */ void g(j.c cVar, x xVar, androidx.lifecycle.p pVar, j.b bVar) {
        if (bVar == j.b.upTo(cVar)) {
            c(xVar);
            return;
        }
        if (bVar == j.b.ON_DESTROY) {
            l(xVar);
        } else if (bVar == j.b.downFrom(cVar)) {
            this.b.remove(xVar);
            this.a.run();
        }
    }

    public void h(Menu menu, MenuInflater menuInflater) {
        Iterator it = this.b.iterator();
        if (it.hasNext()) {
            d.D.a(it.next());
            throw null;
        }
    }

    public void i(Menu menu) {
        Iterator it = this.b.iterator();
        if (it.hasNext()) {
            d.D.a(it.next());
            throw null;
        }
    }

    public boolean j(MenuItem menuItem) {
        Iterator it = this.b.iterator();
        if (!it.hasNext()) {
            return false;
        }
        d.D.a(it.next());
        throw null;
    }

    public void k(Menu menu) {
        Iterator it = this.b.iterator();
        if (it.hasNext()) {
            d.D.a(it.next());
            throw null;
        }
    }

    public void l(x xVar) {
        this.b.remove(xVar);
        a aVar = (a) this.c.remove(xVar);
        if (aVar != null) {
            aVar.a();
        }
        this.a.run();
    }
}
