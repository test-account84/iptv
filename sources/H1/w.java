package h1;

import h1.b;
import h1.n;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.concurrent.BlockingQueue;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class w implements n.b {
    public final q b;
    public final c d;
    public final BlockingQueue e;
    public final Map a = new HashMap();
    public final o c = null;

    public w(c cVar, BlockingQueue blockingQueue, q qVar) {
        this.b = qVar;
        this.d = cVar;
        this.e = blockingQueue;
    }

    public void a(n nVar, p pVar) {
        List list;
        b.a aVar = pVar.b;
        if (aVar == null || aVar.a()) {
            b(nVar);
            return;
        }
        String t = nVar.t();
        synchronized (this) {
            list = (List) this.a.remove(t);
        }
        if (list != null) {
            if (v.b) {
                v.e("Releasing %d waiting requests for cacheKey=%s.", Integer.valueOf(list.size()), t);
            }
            Iterator it = list.iterator();
            while (it.hasNext()) {
                this.b.b((n) it.next(), pVar);
            }
        }
    }

    public synchronized void b(n nVar) {
        BlockingQueue blockingQueue;
        try {
            String t = nVar.t();
            List list = (List) this.a.remove(t);
            if (list != null && !list.isEmpty()) {
                if (v.b) {
                    v.e("%d waiting requests for cacheKey=%s; resend to network", Integer.valueOf(list.size()), t);
                }
                n nVar2 = (n) list.remove(0);
                this.a.put(t, list);
                nVar2.P(this);
                o oVar = this.c;
                if (oVar != null) {
                    oVar.f(nVar2);
                } else if (this.d != null && (blockingQueue = this.e) != null) {
                    try {
                        blockingQueue.put(nVar2);
                    } catch (InterruptedException e) {
                        v.c("Couldn't add request to queue. %s", e.toString());
                        Thread.currentThread().interrupt();
                        this.d.d();
                    }
                }
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public synchronized boolean c(n nVar) {
        try {
            String t = nVar.t();
            if (!this.a.containsKey(t)) {
                this.a.put(t, (Object) null);
                nVar.P(this);
                if (v.b) {
                    v.b("new request, sending to network %s", t);
                }
                return false;
            }
            ArrayList arrayList = (List) this.a.get(t);
            if (arrayList == null) {
                arrayList = new ArrayList();
            }
            nVar.b("waiting-for-response");
            arrayList.add(nVar);
            this.a.put(t, arrayList);
            if (v.b) {
                v.b("Request for cacheKey=%s is in flight, putting on hold.", t);
            }
            return true;
        } catch (Throwable th) {
            throw th;
        }
    }
}
