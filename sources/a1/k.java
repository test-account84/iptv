package a1;

import java.util.ArrayDeque;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class k implements Executor {
    public final Executor c;
    public volatile Runnable e;
    public final ArrayDeque a = new ArrayDeque();
    public final Object d = new Object();

    public static class a implements Runnable {
        public final k a;
        public final Runnable c;

        public a(k kVar, Runnable runnable) {
            this.a = kVar;
            this.c = runnable;
        }

        public void run() {
            try {
                this.c.run();
            } finally {
                this.a.b();
            }
        }
    }

    public k(Executor executor) {
        this.c = executor;
    }

    public boolean a() {
        boolean z;
        synchronized (this.d) {
            z = !this.a.isEmpty();
        }
        return z;
    }

    public void b() {
        synchronized (this.d) {
            try {
                Runnable runnable = (Runnable) this.a.poll();
                this.e = runnable;
                if (runnable != null) {
                    this.c.execute(this.e);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void execute(Runnable runnable) {
        synchronized (this.d) {
            try {
                this.a.add(new a(this, runnable));
                if (this.e == null) {
                    b();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
