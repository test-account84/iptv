package R0;

import R0.k;
import a1.n;
import android.content.Context;
import android.os.PowerManager;
import androidx.work.WorkerParameters;
import androidx.work.impl.WorkDatabase;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.concurrent.ExecutionException;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class d implements b, Y0.a {
    public static final String m = Q0.k.f("Processor");
    public Context c;
    public androidx.work.a d;
    public c1.a e;
    public WorkDatabase f;
    public List i;
    public Map h = new HashMap();
    public Map g = new HashMap();
    public Set j = new HashSet();
    public final List k = new ArrayList();
    public PowerManager.WakeLock a = null;
    public final Object l = new Object();

    public static class a implements Runnable {
        public b a;
        public String c;
        public y5.b d;

        public a(b bVar, String str, y5.b bVar2) {
            this.a = bVar;
            this.c = str;
            this.d = bVar2;
        }

        public void run() {
            boolean z;
            try {
                z = ((Boolean) this.d.get()).booleanValue();
            } catch (InterruptedException | ExecutionException unused) {
                z = true;
            }
            this.a.d(this.c, z);
        }
    }

    public d(Context context, androidx.work.a aVar, c1.a aVar2, WorkDatabase workDatabase, List list) {
        this.c = context;
        this.d = aVar;
        this.e = aVar2;
        this.f = workDatabase;
        this.i = list;
    }

    public static boolean e(String str, k kVar) {
        if (kVar == null) {
            Q0.k.c().a(m, String.format("WorkerWrapper could not be found for %s", new Object[]{str}), new Throwable[0]);
            return false;
        }
        kVar.d();
        Q0.k.c().a(m, String.format("WorkerWrapper interrupted for %s", new Object[]{str}), new Throwable[0]);
        return true;
    }

    public void a(String str) {
        synchronized (this.l) {
            this.g.remove(str);
            m();
        }
    }

    public void b(String str, Q0.e eVar) {
        synchronized (this.l) {
            try {
                Q0.k.c().d(m, String.format("Moving WorkSpec (%s) to the foreground", new Object[]{str}), new Throwable[0]);
                k kVar = (k) this.h.remove(str);
                if (kVar != null) {
                    if (this.a == null) {
                        PowerManager.WakeLock b = n.b(this.c, "ProcessorForegroundLck");
                        this.a = b;
                        b.acquire();
                    }
                    this.g.put(str, kVar);
                    E.b.startForegroundService(this.c, androidx.work.impl.foreground.a.c(this.c, str, eVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void c(b bVar) {
        synchronized (this.l) {
            this.k.add(bVar);
        }
    }

    public void d(String str, boolean z) {
        synchronized (this.l) {
            try {
                this.h.remove(str);
                Q0.k.c().a(m, String.format("%s %s executed; reschedule = %s", new Object[]{getClass().getSimpleName(), str, Boolean.valueOf(z)}), new Throwable[0]);
                Iterator it = this.k.iterator();
                while (it.hasNext()) {
                    ((b) it.next()).d(str, z);
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean f(String str) {
        boolean contains;
        synchronized (this.l) {
            contains = this.j.contains(str);
        }
        return contains;
    }

    public boolean g(String str) {
        boolean z;
        synchronized (this.l) {
            try {
                z = this.h.containsKey(str) || this.g.containsKey(str);
            } finally {
            }
        }
        return z;
    }

    public boolean h(String str) {
        boolean containsKey;
        synchronized (this.l) {
            containsKey = this.g.containsKey(str);
        }
        return containsKey;
    }

    public void i(b bVar) {
        synchronized (this.l) {
            this.k.remove(bVar);
        }
    }

    public boolean j(String str) {
        return k(str, null);
    }

    public boolean k(String str, WorkerParameters.a aVar) {
        synchronized (this.l) {
            try {
                if (g(str)) {
                    Q0.k.c().a(m, String.format("Work %s is already enqueued for processing", new Object[]{str}), new Throwable[0]);
                    return false;
                }
                k a2 = new k.c(this.c, this.d, this.e, this, this.f, str).c(this.i).b(aVar).a();
                y5.b b = a2.b();
                b.addListener(new a(this, str, b), this.e.a());
                this.h.put(str, a2);
                this.e.c().execute(a2);
                Q0.k.c().a(m, String.format("%s: processing %s", new Object[]{getClass().getSimpleName(), str}), new Throwable[0]);
                return true;
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public boolean l(String str) {
        boolean e;
        synchronized (this.l) {
            try {
                Q0.k.c().a(m, String.format("Processor cancelling %s", new Object[]{str}), new Throwable[0]);
                this.j.add(str);
                k kVar = (k) this.g.remove(str);
                boolean z = kVar != null;
                if (kVar == null) {
                    kVar = (k) this.h.remove(str);
                }
                e = e(str, kVar);
                if (z) {
                    m();
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        return e;
    }

    public final void m() {
        synchronized (this.l) {
            try {
                if (!(!this.g.isEmpty())) {
                    try {
                        this.c.startService(androidx.work.impl.foreground.a.e(this.c));
                    } catch (Throwable th) {
                        Q0.k.c().b(m, "Unable to stop foreground service", th);
                    }
                    PowerManager.WakeLock wakeLock = this.a;
                    if (wakeLock != null) {
                        wakeLock.release();
                        this.a = null;
                    }
                }
            } catch (Throwable th2) {
                throw th2;
            }
        }
    }

    public boolean n(String str) {
        boolean e;
        synchronized (this.l) {
            Q0.k.c().a(m, String.format("Processor stopping foreground work %s", new Object[]{str}), new Throwable[0]);
            e = e(str, (k) this.g.remove(str));
        }
        return e;
    }

    public boolean o(String str) {
        boolean e;
        synchronized (this.l) {
            Q0.k.c().a(m, String.format("Processor stopping background work %s", new Object[]{str}), new Throwable[0]);
            e = e(str, (k) this.h.remove(str));
        }
        return e;
    }
}
