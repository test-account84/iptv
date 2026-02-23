package h1;

import android.os.Handler;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class f implements q {
    public final Executor a;

    public class a implements Executor {
        public final /* synthetic */ Handler a;

        public a(Handler handler) {
            this.a = handler;
        }

        public void execute(Runnable runnable) {
            this.a.post(runnable);
        }
    }

    public static class b implements Runnable {
        public final n a;
        public final p c;
        public final Runnable d;

        public b(n nVar, p pVar, Runnable runnable) {
            this.a = nVar;
            this.c = pVar;
            this.d = runnable;
        }

        public void run() {
            if (this.a.H()) {
                this.a.p("canceled-at-delivery");
                return;
            }
            if (this.c.b()) {
                this.a.l(this.c.a);
            } else {
                this.a.j(this.c.c);
            }
            if (this.c.d) {
                this.a.b("intermediate-response");
            } else {
                this.a.p("done");
            }
            Runnable runnable = this.d;
            if (runnable != null) {
                runnable.run();
            }
        }
    }

    public f(Handler handler) {
        this.a = new a(handler);
    }

    public void a(n nVar, u uVar) {
        nVar.b("post-error");
        this.a.execute(new b(nVar, p.a(uVar), null));
    }

    public void b(n nVar, p pVar) {
        c(nVar, pVar, null);
    }

    public void c(n nVar, p pVar, Runnable runnable) {
        nVar.I();
        nVar.b("post-response");
        this.a.execute(new b(nVar, pVar, runnable));
    }
}
