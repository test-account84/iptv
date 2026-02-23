package t;

import java.lang.ref.WeakReference;
import java.util.concurrent.Executor;
import java.util.concurrent.TimeUnit;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public abstract class c {

    public static final class a {
        public Object a;
        public d b;
        public t.d c = t.d.u();
        public boolean d;

        public void a() {
            this.a = null;
            this.b = null;
            this.c.q(null);
        }

        public boolean b(Object obj) {
            this.d = true;
            d dVar = this.b;
            boolean z = dVar != null && dVar.b(obj);
            if (z) {
                d();
            }
            return z;
        }

        public boolean c() {
            this.d = true;
            d dVar = this.b;
            boolean z = dVar != null && dVar.a(true);
            if (z) {
                d();
            }
            return z;
        }

        public final void d() {
            this.a = null;
            this.b = null;
            this.c = null;
        }

        public void finalize() {
            t.d dVar;
            d dVar2 = this.b;
            if (dVar2 != null && !dVar2.isDone()) {
                dVar2.c(new b("The completer object was garbage collected - this future would otherwise never complete. The tag was: " + this.a));
            }
            if (this.d || (dVar = this.c) == null) {
                return;
            }
            dVar.q(null);
        }
    }

    public static final class b extends Throwable {
        public b(String str) {
            super(str);
        }

        public synchronized Throwable fillInStackTrace() {
            return this;
        }
    }

    public interface c {
        Object attachCompleter(a aVar);
    }

    public static final class d implements y5.b {
        public final WeakReference a;
        public final t.a c = new a();

        public class a extends t.a {
            public a() {
            }

            public String n() {
                a aVar = (a) d.this.a.get();
                if (aVar == null) {
                    return "Completer object has been garbage collected, future will fail soon";
                }
                return "tag=[" + aVar.a + "]";
            }
        }

        public d(a aVar) {
            this.a = new WeakReference(aVar);
        }

        public boolean a(boolean z) {
            return this.c.cancel(z);
        }

        public void addListener(Runnable runnable, Executor executor) {
            this.c.addListener(runnable, executor);
        }

        public boolean b(Object obj) {
            return this.c.q(obj);
        }

        public boolean c(Throwable th) {
            return this.c.r(th);
        }

        public boolean cancel(boolean z) {
            a aVar = (a) this.a.get();
            boolean cancel = this.c.cancel(z);
            if (cancel && aVar != null) {
                aVar.a();
            }
            return cancel;
        }

        public Object get() {
            return this.c.get();
        }

        public boolean isCancelled() {
            return this.c.isCancelled();
        }

        public boolean isDone() {
            return this.c.isDone();
        }

        public String toString() {
            return this.c.toString();
        }

        public Object get(long j, TimeUnit timeUnit) {
            return this.c.get(j, timeUnit);
        }
    }

    public static y5.b a(c cVar) {
        a aVar = new a();
        d dVar = new d(aVar);
        aVar.b = dVar;
        aVar.a = cVar.getClass();
        try {
            Object attachCompleter = cVar.attachCompleter(aVar);
            if (attachCompleter != null) {
                aVar.a = attachCompleter;
            }
        } catch (Exception e) {
            dVar.c(e);
        }
        return dVar;
    }
}
