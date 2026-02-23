package W0;

import Z0.p;
import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class c implements V0.a {
    public final List a = new ArrayList();
    public Object b;
    public X0.d c;
    public a d;

    public interface a {
        void a(List list);

        void b(List list);
    }

    public c(X0.d dVar) {
        this.c = dVar;
    }

    public void a(Object obj) {
        this.b = obj;
        h(this.d, obj);
    }

    public abstract boolean b(p pVar);

    public abstract boolean c(Object obj);

    public boolean d(String str) {
        Object obj = this.b;
        return obj != null && c(obj) && this.a.contains(str);
    }

    public void e(Iterable iterable) {
        this.a.clear();
        Iterator it = iterable.iterator();
        while (it.hasNext()) {
            p pVar = (p) it.next();
            if (b(pVar)) {
                this.a.add(pVar.a);
            }
        }
        if (this.a.isEmpty()) {
            this.c.c(this);
        } else {
            this.c.a(this);
        }
        h(this.d, this.b);
    }

    public void f() {
        if (this.a.isEmpty()) {
            return;
        }
        this.a.clear();
        this.c.c(this);
    }

    public void g(a aVar) {
        if (this.d != aVar) {
            this.d = aVar;
            h(aVar, this.b);
        }
    }

    public final void h(a aVar, Object obj) {
        if (this.a.isEmpty() || aVar == null) {
            return;
        }
        if (obj == null || c(obj)) {
            aVar.b(this.a);
        } else {
            aVar.a(this.a);
        }
    }
}
