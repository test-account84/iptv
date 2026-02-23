package androidx.fragment.app;

import android.content.Context;
import android.os.Bundle;
import android.view.View;
import androidx.fragment.app.m;
import java.util.Iterator;
import java.util.concurrent.CopyOnWriteArrayList;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class l {
    public final CopyOnWriteArrayList a = new CopyOnWriteArrayList();
    public final m b;

    public static final class a {
        public final m.l a;
        public final boolean b;

        public a(m.l lVar, boolean z) {
            this.a = lVar;
            this.b = z;
        }
    }

    public l(m mVar) {
        this.b = mVar;
    }

    public void a(Fragment fragment, Bundle bundle, boolean z) {
        Fragment w0 = this.b.w0();
        if (w0 != null) {
            w0.getParentFragmentManager().v0().a(fragment, bundle, true);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b) {
                aVar.a.a(this.b, fragment, bundle);
            }
        }
    }

    public void b(Fragment fragment, boolean z) {
        Context f = this.b.t0().f();
        Fragment w0 = this.b.w0();
        if (w0 != null) {
            w0.getParentFragmentManager().v0().b(fragment, true);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b) {
                aVar.a.b(this.b, fragment, f);
            }
        }
    }

    public void c(Fragment fragment, Bundle bundle, boolean z) {
        Fragment w0 = this.b.w0();
        if (w0 != null) {
            w0.getParentFragmentManager().v0().c(fragment, bundle, true);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b) {
                aVar.a.c(this.b, fragment, bundle);
            }
        }
    }

    public void d(Fragment fragment, boolean z) {
        Fragment w0 = this.b.w0();
        if (w0 != null) {
            w0.getParentFragmentManager().v0().d(fragment, true);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b) {
                aVar.a.d(this.b, fragment);
            }
        }
    }

    public void e(Fragment fragment, boolean z) {
        Fragment w0 = this.b.w0();
        if (w0 != null) {
            w0.getParentFragmentManager().v0().e(fragment, true);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b) {
                aVar.a.e(this.b, fragment);
            }
        }
    }

    public void f(Fragment fragment, boolean z) {
        Fragment w0 = this.b.w0();
        if (w0 != null) {
            w0.getParentFragmentManager().v0().f(fragment, true);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b) {
                aVar.a.f(this.b, fragment);
            }
        }
    }

    public void g(Fragment fragment, boolean z) {
        Context f = this.b.t0().f();
        Fragment w0 = this.b.w0();
        if (w0 != null) {
            w0.getParentFragmentManager().v0().g(fragment, true);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b) {
                aVar.a.g(this.b, fragment, f);
            }
        }
    }

    public void h(Fragment fragment, Bundle bundle, boolean z) {
        Fragment w0 = this.b.w0();
        if (w0 != null) {
            w0.getParentFragmentManager().v0().h(fragment, bundle, true);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b) {
                aVar.a.h(this.b, fragment, bundle);
            }
        }
    }

    public void i(Fragment fragment, boolean z) {
        Fragment w0 = this.b.w0();
        if (w0 != null) {
            w0.getParentFragmentManager().v0().i(fragment, true);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b) {
                aVar.a.i(this.b, fragment);
            }
        }
    }

    public void j(Fragment fragment, Bundle bundle, boolean z) {
        Fragment w0 = this.b.w0();
        if (w0 != null) {
            w0.getParentFragmentManager().v0().j(fragment, bundle, true);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b) {
                aVar.a.j(this.b, fragment, bundle);
            }
        }
    }

    public void k(Fragment fragment, boolean z) {
        Fragment w0 = this.b.w0();
        if (w0 != null) {
            w0.getParentFragmentManager().v0().k(fragment, true);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b) {
                aVar.a.k(this.b, fragment);
            }
        }
    }

    public void l(Fragment fragment, boolean z) {
        Fragment w0 = this.b.w0();
        if (w0 != null) {
            w0.getParentFragmentManager().v0().l(fragment, true);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b) {
                aVar.a.l(this.b, fragment);
            }
        }
    }

    public void m(Fragment fragment, View view, Bundle bundle, boolean z) {
        Fragment w0 = this.b.w0();
        if (w0 != null) {
            w0.getParentFragmentManager().v0().m(fragment, view, bundle, true);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b) {
                aVar.a.m(this.b, fragment, view, bundle);
            }
        }
    }

    public void n(Fragment fragment, boolean z) {
        Fragment w0 = this.b.w0();
        if (w0 != null) {
            w0.getParentFragmentManager().v0().n(fragment, true);
        }
        Iterator it = this.a.iterator();
        while (it.hasNext()) {
            a aVar = (a) it.next();
            if (!z || aVar.b) {
                aVar.a.n(this.b, fragment);
            }
        }
    }

    public void o(m.l lVar, boolean z) {
        this.a.add(new a(lVar, z));
    }

    public void p(m.l lVar) {
        synchronized (this.a) {
            try {
                int size = this.a.size();
                int i = 0;
                while (true) {
                    if (i >= size) {
                        break;
                    }
                    if (((a) this.a.get(i)).a == lVar) {
                        this.a.remove(i);
                        break;
                    }
                    i++;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
