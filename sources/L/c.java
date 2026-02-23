package l;

import android.os.Build;
import android.os.Handler;
import android.os.Looper;
import java.lang.reflect.InvocationTargetException;
import java.util.concurrent.ExecutorService;
import java.util.concurrent.Executors;
import java.util.concurrent.ThreadFactory;
import java.util.concurrent.atomic.AtomicInteger;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class c extends d {
    public final Object a = new Object();
    public final ExecutorService b = Executors.newFixedThreadPool(4, new a());
    public volatile Handler c;

    public class a implements ThreadFactory {
        public final AtomicInteger a = new AtomicInteger(0);

        public a() {
        }

        public Thread newThread(Runnable runnable) {
            Thread thread = new Thread(runnable);
            thread.setName(String.format("arch_disk_io_%d", new Object[]{Integer.valueOf(this.a.getAndIncrement())}));
            return thread;
        }
    }

    public static Handler d(Looper looper) {
        if (Build.VERSION.SDK_INT >= 28) {
            return b.a(looper);
        }
        try {
            return (Handler) Handler.class.getDeclaredConstructor(new Class[]{Looper.class, Handler.Callback.class, Boolean.TYPE}).newInstance(new Object[]{looper, null, Boolean.TRUE});
        } catch (InvocationTargetException unused) {
            return new Handler(looper);
        } catch (IllegalAccessException | InstantiationException | NoSuchMethodException unused2) {
            return new Handler(looper);
        }
    }

    public void a(Runnable runnable) {
        this.b.execute(runnable);
    }

    public boolean b() {
        return Looper.getMainLooper().getThread() == Thread.currentThread();
    }

    public void c(Runnable runnable) {
        if (this.c == null) {
            synchronized (this.a) {
                try {
                    if (this.c == null) {
                        this.c = d(Looper.getMainLooper());
                    }
                } finally {
                }
            }
        }
        this.c.post(runnable);
    }
}
