package W1;

import java.util.ArrayDeque;
import java.util.HashMap;
import java.util.Map;
import java.util.Queue;
import java.util.concurrent.locks.Lock;
import java.util.concurrent.locks.ReentrantLock;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public final class c {
    public final Map a = new HashMap();
    public final c b = new c(null);

    public static class b {
        public final Lock a;
        public int b;

        public b() {
            this.a = new ReentrantLock();
        }

        public /* synthetic */ b(a aVar) {
            this();
        }
    }

    public static class c {
        public final Queue a;

        public c() {
            this.a = new ArrayDeque();
        }

        public b a() {
            b bVar;
            synchronized (this.a) {
                bVar = (b) this.a.poll();
            }
            return bVar == null ? new b(null) : bVar;
        }

        public void b(b bVar) {
            synchronized (this.a) {
                try {
                    if (this.a.size() < 10) {
                        this.a.offer(bVar);
                    }
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public /* synthetic */ c(a aVar) {
            this();
        }
    }

    public void a(S1.c cVar) {
        b bVar;
        synchronized (this) {
            try {
                bVar = (b) this.a.get(cVar);
                if (bVar == null) {
                    bVar = this.b.a();
                    this.a.put(cVar, bVar);
                }
                bVar.b++;
            } catch (Throwable th) {
                throw th;
            }
        }
        bVar.a.lock();
    }

    public void b(S1.c cVar) {
        b bVar;
        int i;
        synchronized (this) {
            try {
                bVar = (b) this.a.get(cVar);
                if (bVar != null && (i = bVar.b) > 0) {
                    int i2 = i - 1;
                    bVar.b = i2;
                    if (i2 == 0) {
                        b bVar2 = (b) this.a.remove(cVar);
                        if (!bVar2.equals(bVar)) {
                            throw new IllegalStateException("Removed the wrong lock, expected to remove: " + bVar + ", but actually removed: " + bVar2 + ", key: " + cVar);
                        }
                        this.b.b(bVar2);
                    }
                }
                StringBuilder sb = new StringBuilder();
                sb.append("Cannot release a lock that is not held, key: ");
                sb.append(cVar);
                sb.append(", interestedThreads: ");
                sb.append(bVar == null ? 0 : bVar.b);
                throw new IllegalArgumentException(sb.toString());
            } finally {
            }
        }
        bVar.a.unlock();
    }
}
