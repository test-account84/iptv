package androidx.work;

import android.annotation.SuppressLint;
import android.content.Context;
import androidx.annotation.Keep;
import androidx.work.ListenableWorker;
import b1.c;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class Worker extends ListenableWorker {
    public c g;

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            try {
                Worker.this.g.p(Worker.this.r());
            } catch (Throwable th) {
                Worker.this.g.q(th);
            }
        }
    }

    @Keep
    @SuppressLint({"BanKeepAnnotation"})
    public Worker(Context context, WorkerParameters workerParameters) {
        super(context, workerParameters);
    }

    public final y5.b p() {
        this.g = c.t();
        c().execute(new a());
        return this.g;
    }

    public abstract ListenableWorker.a r();
}
