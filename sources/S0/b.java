package S0;

import Q0.k;
import Q0.t;
import R0.e;
import R0.j;
import V0.c;
import V0.d;
import Z0.p;
import android.content.Context;
import android.os.Build;
import android.text.TextUtils;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Set;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b implements e, c, R0.b {
    public static final String j = k.f("GreedyScheduler");
    public final Context a;
    public final j c;
    public final d d;
    public a f;
    public boolean g;
    public Boolean i;
    public final Set e = new HashSet();
    public final Object h = new Object();

    public b(Context context, androidx.work.a aVar, c1.a aVar2, j jVar) {
        this.a = context;
        this.c = jVar;
        this.d = new d(context, aVar2, this);
        this.f = new a(this, aVar.k());
    }

    public void a(String str) {
        if (this.i == null) {
            g();
        }
        if (!this.i.booleanValue()) {
            k.c().d(j, "Ignoring schedule request in non-main process", new Throwable[0]);
            return;
        }
        h();
        k.c().a(j, String.format("Cancelling work ID %s", new Object[]{str}), new Throwable[0]);
        a aVar = this.f;
        if (aVar != null) {
            aVar.b(str);
        }
        this.c.z(str);
    }

    public void b(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            k.c().a(j, String.format("Constraints not met: Cancelling work ID %s", new Object[]{str}), new Throwable[0]);
            this.c.z(str);
        }
    }

    public boolean c() {
        return false;
    }

    public void d(String str, boolean z) {
        i(str);
    }

    public void e(p... pVarArr) {
        if (this.i == null) {
            g();
        }
        if (!this.i.booleanValue()) {
            k.c().d(j, "Ignoring schedule request in a secondary process", new Throwable[0]);
            return;
        }
        h();
        HashSet hashSet = new HashSet();
        HashSet hashSet2 = new HashSet();
        for (p pVar : pVarArr) {
            long a = pVar.a();
            long currentTimeMillis = System.currentTimeMillis();
            if (pVar.b == t.ENQUEUED) {
                if (currentTimeMillis < a) {
                    a aVar = this.f;
                    if (aVar != null) {
                        aVar.a(pVar);
                    }
                } else if (pVar.b()) {
                    int i = Build.VERSION.SDK_INT;
                    if (i >= 23 && pVar.j.h()) {
                        k.c().a(j, String.format("Ignoring WorkSpec %s, Requires device idle.", new Object[]{pVar}), new Throwable[0]);
                    } else if (i < 24 || !pVar.j.e()) {
                        hashSet.add(pVar);
                        hashSet2.add(pVar.a);
                    } else {
                        k.c().a(j, String.format("Ignoring WorkSpec %s, Requires ContentUri triggers.", new Object[]{pVar}), new Throwable[0]);
                    }
                } else {
                    k.c().a(j, String.format("Starting work for %s", new Object[]{pVar.a}), new Throwable[0]);
                    this.c.w(pVar.a);
                }
            }
        }
        synchronized (this.h) {
            try {
                if (!hashSet.isEmpty()) {
                    k.c().a(j, String.format("Starting tracking for [%s]", new Object[]{TextUtils.join(",", hashSet2)}), new Throwable[0]);
                    this.e.addAll(hashSet);
                    this.d.d(this.e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void f(List list) {
        Iterator it = list.iterator();
        while (it.hasNext()) {
            String str = (String) it.next();
            k.c().a(j, String.format("Constraints met: Scheduling work ID %s", new Object[]{str}), new Throwable[0]);
            this.c.w(str);
        }
    }

    public final void g() {
        this.i = Boolean.valueOf(a1.j.b(this.a, this.c.k()));
    }

    public final void h() {
        if (this.g) {
            return;
        }
        this.c.o().c(this);
        this.g = true;
    }

    public final void i(String str) {
        synchronized (this.h) {
            try {
                Iterator it = this.e.iterator();
                while (true) {
                    if (!it.hasNext()) {
                        break;
                    }
                    p pVar = (p) it.next();
                    if (pVar.a.equals(str)) {
                        k.c().a(j, String.format("Stopping tracking for %s", new Object[]{str}), new Throwable[0]);
                        this.e.remove(pVar);
                        this.d.d(this.e);
                        break;
                    }
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
