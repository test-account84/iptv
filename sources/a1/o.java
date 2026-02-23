package a1;

import android.content.Context;
import androidx.work.ListenableWorker;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class o implements Runnable {
    public static final String h = Q0.k.f("WorkForegroundRunnable");
    public final b1.c a = b1.c.t();
    public final Context c;
    public final Z0.p d;
    public final ListenableWorker e;
    public final Q0.f f;
    public final c1.a g;

    public class a implements Runnable {
        public final /* synthetic */ b1.c a;

        public a(b1.c cVar) {
            this.a = cVar;
        }

        public void run() {
            this.a.r(o.this.e.d());
        }
    }

    public class b implements Runnable {
        public final /* synthetic */ b1.c a;

        public b(b1.c cVar) {
            this.a = cVar;
        }

        public void run() {
            try {
                Q0.e eVar = (Q0.e) this.a.get();
                if (eVar == null) {
                    throw new IllegalStateException(String.format("Worker was marked important (%s) but did not provide ForegroundInfo", new Object[]{o.this.d.c}));
                }
                Q0.k.c().a(o.h, String.format("Updating notification for %s", new Object[]{o.this.d.c}), new Throwable[0]);
                o.this.e.n(true);
                o oVar = o.this;
                oVar.a.r(oVar.f.a(oVar.c, oVar.e.e(), eVar));
            } catch (Throwable th) {
                o.this.a.q(th);
            }
        }
    }

    public o(Context context, Z0.p pVar, ListenableWorker listenableWorker, Q0.f fVar, c1.a aVar) {
        this.c = context;
        this.d = pVar;
        this.e = listenableWorker;
        this.f = fVar;
        this.g = aVar;
    }

    public y5.b a() {
        return this.a;
    }

    public void run() {
        if (!this.d.q || L.a.c()) {
            this.a.p(null);
            return;
        }
        b1.c t = b1.c.t();
        this.g.a().execute(new a(t));
        t.addListener(new b(t), this.g.a());
    }
}
