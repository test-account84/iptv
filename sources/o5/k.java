package O5;

import com.google.android.gms.tasks.Continuation;
import com.google.android.gms.tasks.Task;
import com.google.android.gms.tasks.Tasks;
import java.util.concurrent.Callable;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class k {
    public final Executor a;
    public Task b = Tasks.forResult(null);
    public final Object c = new Object();
    public final ThreadLocal d = new ThreadLocal();

    public class a implements Runnable {
        public a() {
        }

        public void run() {
            k.a(k.this).set(Boolean.TRUE);
        }
    }

    public class b implements Continuation {
        public final /* synthetic */ Callable a;

        public b(Callable callable) {
            this.a = callable;
        }

        public Object then(Task task) {
            return this.a.call();
        }
    }

    public class c implements Continuation {
        public c() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public Void then(Task task) {
            return null;
        }
    }

    public k(Executor executor) {
        this.a = executor;
        executor.execute(new a());
    }

    public static /* synthetic */ ThreadLocal a(k kVar) {
        return kVar.d;
    }

    public void b() {
        if (!e()) {
            throw new IllegalStateException("Not running on background worker thread as intended.");
        }
    }

    public Executor c() {
        return this.a;
    }

    public final Task d(Task task) {
        return task.continueWith(this.a, new c());
    }

    public final boolean e() {
        return Boolean.TRUE.equals(this.d.get());
    }

    public final Continuation f(Callable callable) {
        return new b(callable);
    }

    public Task g(Callable callable) {
        Task continueWith;
        synchronized (this.c) {
            continueWith = this.b.continueWith(this.a, f(callable));
            this.b = d(continueWith);
        }
        return continueWith;
    }

    public Task h(Callable callable) {
        Task continueWithTask;
        synchronized (this.c) {
            continueWithTask = this.b.continueWithTask(this.a, f(callable));
            this.b = d(continueWithTask);
        }
        return continueWithTask;
    }
}
