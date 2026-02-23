package I5;

import j$.util.concurrent.ConcurrentHashMap;
import java.util.ArrayDeque;
import java.util.Collection;
import java.util.HashMap;
import java.util.Iterator;
import java.util.Map;
import java.util.Queue;
import java.util.Set;
import java.util.concurrent.Executor;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class v implements g6.d, g6.c {
    public final Map a = new HashMap();
    public Queue b = new ArrayDeque();
    public final Executor c;

    public v(Executor executor) {
        this.c = executor;
    }

    public static /* synthetic */ void c(Map.Entry entry, g6.a aVar) {
        f(entry, aVar);
    }

    public static /* synthetic */ void f(Map.Entry entry, g6.a aVar) {
        ((g6.b) entry.getKey()).a(aVar);
    }

    public void a(Class cls, g6.b bVar) {
        b(cls, this.c, bVar);
    }

    public synchronized void b(Class cls, Executor executor, g6.b bVar) {
        try {
            E.b(cls);
            E.b(bVar);
            E.b(executor);
            if (!this.a.containsKey(cls)) {
                this.a.put(cls, new ConcurrentHashMap());
            }
            ((ConcurrentHashMap) this.a.get(cls)).put(bVar, executor);
        } catch (Throwable th) {
            throw th;
        }
    }

    public void d() {
        Collection collection;
        synchronized (this) {
            try {
                collection = this.b;
                if (collection != null) {
                    this.b = null;
                } else {
                    collection = null;
                }
            } catch (Throwable th) {
                throw th;
            }
        }
        if (collection != null) {
            Iterator it = collection.iterator();
            while (it.hasNext()) {
                d.D.a(it.next());
                g(null);
            }
        }
    }

    public final synchronized Set e(g6.a aVar) {
        throw null;
    }

    public void g(g6.a aVar) {
        E.b(aVar);
        synchronized (this) {
            try {
                Queue queue = this.b;
                if (queue != null) {
                    queue.add(aVar);
                    return;
                }
                for (Map.Entry entry : e(aVar)) {
                    ((Executor) entry.getValue()).execute(new u(entry, aVar));
                }
            } catch (Throwable th) {
                throw th;
            }
        }
    }
}
