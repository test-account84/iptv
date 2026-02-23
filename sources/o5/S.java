package O5;

import java.lang.Thread;
import java.util.concurrent.atomic.AtomicBoolean;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class s implements Thread.UncaughtExceptionHandler {
    public final a a;
    public final V5.i b;
    public final Thread.UncaughtExceptionHandler c;
    public final L5.a d;
    public final AtomicBoolean e = new AtomicBoolean(false);

    public interface a {
        void a(V5.i iVar, Thread thread, Throwable th);
    }

    public s(a aVar, V5.i iVar, Thread.UncaughtExceptionHandler uncaughtExceptionHandler, L5.a aVar2) {
        this.a = aVar;
        this.b = iVar;
        this.c = uncaughtExceptionHandler;
        this.d = aVar2;
    }

    public boolean a() {
        return this.e.get();
    }

    public final boolean b(Thread thread, Throwable th) {
        if (thread == null) {
            L5.f.f().d("Crashlytics will not record uncaught exception; null thread");
            return false;
        }
        if (th == null) {
            L5.f.f().d("Crashlytics will not record uncaught exception; null throwable");
            return false;
        }
        if (!this.d.b()) {
            return true;
        }
        L5.f.f().b("Crashlytics will not record uncaught exception; native crash exists for session.");
        return false;
    }

    public void uncaughtException(Thread thread, Throwable th) {
        this.e.set(true);
        try {
            try {
                if (b(thread, th)) {
                    this.a.a(this.b, thread, th);
                } else {
                    L5.f.f().b("Uncaught exception will not be recorded by Crashlytics.");
                }
            } catch (Exception e) {
                L5.f.f().e("An error occurred in the uncaught exception handler", e);
            }
            L5.f.f().b("Completed exception processing. Invoking default exception handler.");
            this.c.uncaughtException(thread, th);
            this.e.set(false);
        } catch (Throwable th2) {
            L5.f.f().b("Completed exception processing. Invoking default exception handler.");
            this.c.uncaughtException(thread, th);
            this.e.set(false);
            throw th2;
        }
    }
}
