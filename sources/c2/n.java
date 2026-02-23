package C2;

import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class n implements Executor {
    public final Executor a;

    public static class a implements Runnable {
        public final Runnable a;

        public a(Runnable runnable) {
            this.a = runnable;
        }

        public void run() {
            try {
                this.a.run();
            } catch (Exception e) {
                G2.a.d("Executor", "Background execution failure.", e);
            }
        }
    }

    public n(Executor executor) {
        this.a = executor;
    }

    public void execute(Runnable runnable) {
        this.a.execute(new a(runnable));
    }
}
