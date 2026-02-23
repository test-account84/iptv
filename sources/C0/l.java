package C0;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class l implements Executor {
    public final Executor a;
    public final ArrayDeque c = new ArrayDeque();
    public Runnable d;

    public class a implements Runnable {
        public final /* synthetic */ Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        public void run() {
            try {
                this.a.run();
            } finally {
                l.this.a();
            }
        }
    }

    public l(Executor executor) {
        this.a = executor;
    }

    public synchronized void a() {
        Runnable runnable = (Runnable) this.c.poll();
        this.d = runnable;
        if (runnable != null) {
            this.a.execute(runnable);
        }
    }

    public synchronized void execute(Runnable runnable) {
        this.c.offer(new a(runnable));
        if (this.d == null) {
            a();
        }
    }
}
