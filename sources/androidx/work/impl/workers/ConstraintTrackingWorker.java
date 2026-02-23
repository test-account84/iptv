package androidx.work.impl.workers;

import Q0.k;
import R0.j;
import V0.c;
import V0.d;
import Z0.p;
import android.content.Context;
import android.text.TextUtils;
import androidx.work.ListenableWorker;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import java.util.Collections;
import java.util.List;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class ConstraintTrackingWorker extends ListenableWorker implements c {
    public static final String l = k.f("ConstraintTrkngWrkr");
    public WorkerParameters g;
    public final Object h;
    public volatile boolean i;
    public b1.c j;
    public ListenableWorker k;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            ConstraintTrackingWorker.this.u();
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ y5.b a;

        public b(y5.b bVar) {
            this.a = bVar;
        }

        public void run() {
            synchronized (ConstraintTrackingWorker.this.h) {
                try {
                    if (ConstraintTrackingWorker.this.i) {
                        ConstraintTrackingWorker.this.t();
                    } else {
                        ConstraintTrackingWorker.this.j.r(this.a);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }
    }

    public ConstraintTrackingWorker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
        this.g = workerParameters;
        this.h = new Object();
        this.i = false;
        this.j = b1.c.t();
    }

    public void b(List list) {
        k.c().a(l, String.format("Constraints changed for %s", new Object[]{list}), new Throwable[0]);
        synchronized (this.h) {
            this.i = true;
        }
    }

    public void f(List list) {
    }

    public c1.a h() {
        return j.m(a()).r();
    }

    public boolean j() {
        ListenableWorker listenableWorker = this.k;
        return listenableWorker != null && listenableWorker.j();
    }

    public void m() {
        super.m();
        ListenableWorker listenableWorker = this.k;
        if (listenableWorker == null || listenableWorker.k()) {
            return;
        }
        this.k.q();
    }

    public y5.b p() {
        c().execute(new a());
        return this.j;
    }

    public WorkDatabase r() {
        return j.m(a()).q();
    }

    public void s() {
        this.j.p(ListenableWorker.a.a());
    }

    public void t() {
        this.j.p(ListenableWorker.a.b());
    }

    public void u() {
        String l2 = g().l("androidx.work.impl.workers.ConstraintTrackingWorker.ARGUMENT_CLASS_NAME");
        if (TextUtils.isEmpty(l2)) {
            k.c().b(l, "No worker to delegate to.", new Throwable[0]);
        } else {
            ListenableWorker b2 = i().b(a(), l2, this.g);
            this.k = b2;
            if (b2 != null) {
                p h = r().B().h(e().toString());
                if (h == null) {
                    s();
                    return;
                }
                d dVar = new d(a(), h(), this);
                dVar.d(Collections.singletonList(h));
                if (!dVar.c(e().toString())) {
                    k.c().a(l, String.format("Constraints not met for delegate %s. Requesting retry.", new Object[]{l2}), new Throwable[0]);
                    t();
                    return;
                }
                k.c().a(l, String.format("Constraints met for delegate %s", new Object[]{l2}), new Throwable[0]);
                try {
                    y5.b p = this.k.p();
                    p.addListener(new b(p), c());
                    return;
                } catch (Throwable th) {
                    k c = k.c();
                    String str = l;
                    c.a(str, String.format("Delegated worker %s threw exception in startWork.", new Object[]{l2}), th);
                    synchronized (this.h) {
                        try {
                            if (this.i) {
                                k.c().a(str, "Constraints were unmet, Retrying.", new Throwable[0]);
                                t();
                            } else {
                                s();
                            }
                            return;
                        } finally {
                        }
                    }
                }
            }
            k.c().a(l, "No worker to delegate to.", new Throwable[0]);
        }
        s();
    }
}
