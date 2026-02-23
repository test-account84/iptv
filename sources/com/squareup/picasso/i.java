package com.squareup.picasso;

import android.content.BroadcastReceiver;
import android.content.Context;
import android.content.Intent;
import android.content.IntentFilter;
import android.net.ConnectivityManager;
import android.net.NetworkInfo;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import com.squareup.picasso.r;
import java.util.ArrayList;
import java.util.HashSet;
import java.util.Iterator;
import java.util.LinkedHashMap;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class i {
    public final b a;
    public final Context b;
    public final ExecutorService c;
    public final j d;
    public final Map e;
    public final Map f;
    public final Map g;
    public final Set h;
    public final Handler i;
    public final Handler j;
    public final d k;
    public final A l;
    public final List m;
    public final c n;
    public final boolean o;
    public boolean p;

    public static class a extends Handler {
        public final i a;

        public class a implements Runnable {
            public final /* synthetic */ Message a;

            public a(Message message) {
                this.a = message;
            }

            public void run() {
                throw new AssertionError("Unknown handler message received: " + this.a.what);
            }
        }

        public a(Looper looper, i iVar) {
            super(looper);
            this.a = iVar;
        }

        public void handleMessage(Message message) {
            switch (message.what) {
                case 1:
                    this.a.v((com.squareup.picasso.a) message.obj);
                    break;
                case 2:
                    this.a.o((com.squareup.picasso.a) message.obj);
                    break;
                case 3:
                case 8:
                default:
                    t.p.post(new a(message));
                    break;
                case 4:
                    this.a.p((com.squareup.picasso.c) message.obj);
                    break;
                case 5:
                    this.a.u((com.squareup.picasso.c) message.obj);
                    break;
                case 6:
                    this.a.q((com.squareup.picasso.c) message.obj, false);
                    break;
                case 7:
                    this.a.n();
                    break;
                case 9:
                    this.a.r((NetworkInfo) message.obj);
                    break;
                case 10:
                    this.a.m(message.arg1 == 1);
                    break;
                case 11:
                    this.a.s(message.obj);
                    break;
                case 12:
                    this.a.t(message.obj);
                    break;
            }
        }
    }

    public static class b extends HandlerThread {
        public b() {
            super("Picasso-Dispatcher", 10);
        }
    }

    public static class c extends BroadcastReceiver {
        public final i a;

        public c(i iVar) {
            this.a = iVar;
        }

        public void a() {
            IntentFilter intentFilter = new IntentFilter();
            intentFilter.addAction("android.intent.action.AIRPLANE_MODE");
            if (this.a.o) {
                intentFilter.addAction("android.net.conn.CONNECTIVITY_CHANGE");
            }
            this.a.b.registerReceiver(this, intentFilter);
        }

        public void onReceive(Context context, Intent intent) {
            if (intent == null) {
                return;
            }
            String action = intent.getAction();
            if ("android.intent.action.AIRPLANE_MODE".equals(action)) {
                if (intent.hasExtra("state")) {
                    this.a.b(intent.getBooleanExtra("state", false));
                }
            } else if ("android.net.conn.CONNECTIVITY_CHANGE".equals(action)) {
                this.a.f(((ConnectivityManager) G.p(context, "connectivity")).getActiveNetworkInfo());
            }
        }
    }

    public i(Context context, ExecutorService executorService, Handler handler, j jVar, d dVar, A a2) {
        b bVar = new b();
        this.a = bVar;
        bVar.start();
        G.j(bVar.getLooper());
        this.b = context;
        this.c = executorService;
        this.e = new LinkedHashMap();
        this.f = new WeakHashMap();
        this.g = new WeakHashMap();
        this.h = new HashSet();
        this.i = new a(bVar.getLooper(), this);
        this.d = jVar;
        this.j = handler;
        this.k = dVar;
        this.l = a2;
        this.m = new ArrayList(4);
        this.p = G.r(context);
        this.o = G.q(context, "android.permission.ACCESS_NETWORK_STATE");
        c cVar = new c(this);
        this.n = cVar;
        cVar.a();
    }

    public final void a(com.squareup.picasso.c cVar) {
        if (cVar.s()) {
            return;
        }
        this.m.add(cVar);
        if (this.i.hasMessages(7)) {
            return;
        }
        this.i.sendEmptyMessageDelayed(7, 200L);
    }

    public void b(boolean z) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(10, z ? 1 : 0, 0));
    }

    public void c(com.squareup.picasso.a aVar) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(2, aVar));
    }

    public void d(com.squareup.picasso.c cVar) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(4, cVar));
    }

    public void e(com.squareup.picasso.c cVar) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(6, cVar));
    }

    public void f(NetworkInfo networkInfo) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(9, networkInfo));
    }

    public void g(com.squareup.picasso.c cVar) {
        Handler handler = this.i;
        handler.sendMessageDelayed(handler.obtainMessage(5, cVar), 500L);
    }

    public void h(com.squareup.picasso.a aVar) {
        Handler handler = this.i;
        handler.sendMessage(handler.obtainMessage(1, aVar));
    }

    public final void i() {
        if (this.f.isEmpty()) {
            return;
        }
        Iterator it = this.f.values().iterator();
        while (it.hasNext()) {
            com.squareup.picasso.a aVar = (com.squareup.picasso.a) it.next();
            it.remove();
            if (aVar.g().n) {
                G.u("Dispatcher", "replaying", aVar.i().d());
            }
            w(aVar, false);
        }
    }

    public final void j(List list) {
        if (list == null || list.isEmpty() || !((com.squareup.picasso.c) list.get(0)).o().n) {
            return;
        }
        StringBuilder sb = new StringBuilder();
        Iterator it = list.iterator();
        while (it.hasNext()) {
            com.squareup.picasso.c cVar = (com.squareup.picasso.c) it.next();
            if (sb.length() > 0) {
                sb.append(", ");
            }
            sb.append(G.l(cVar));
        }
        G.u("Dispatcher", "delivered", sb.toString());
    }

    public final void k(com.squareup.picasso.a aVar) {
        Object k = aVar.k();
        if (k != null) {
            aVar.k = true;
            this.f.put(k, aVar);
        }
    }

    public final void l(com.squareup.picasso.c cVar) {
        com.squareup.picasso.a h = cVar.h();
        if (h != null) {
            k(h);
        }
        List i = cVar.i();
        if (i != null) {
            int size = i.size();
            for (int i2 = 0; i2 < size; i2++) {
                k((com.squareup.picasso.a) i.get(i2));
            }
        }
    }

    public void m(boolean z) {
        this.p = z;
    }

    public void n() {
        ArrayList arrayList = new ArrayList(this.m);
        this.m.clear();
        Handler handler = this.j;
        handler.sendMessage(handler.obtainMessage(8, arrayList));
        j(arrayList);
    }

    public void o(com.squareup.picasso.a aVar) {
        String d = aVar.d();
        com.squareup.picasso.c cVar = (com.squareup.picasso.c) this.e.get(d);
        if (cVar != null) {
            cVar.f(aVar);
            if (cVar.c()) {
                this.e.remove(d);
                if (aVar.g().n) {
                    G.u("Dispatcher", "canceled", aVar.i().d());
                }
            }
        }
        if (this.h.contains(aVar.j())) {
            this.g.remove(aVar.k());
            if (aVar.g().n) {
                G.v("Dispatcher", "canceled", aVar.i().d(), "because paused request got canceled");
            }
        }
        com.squareup.picasso.a aVar2 = (com.squareup.picasso.a) this.f.remove(aVar.k());
        if (aVar2 == null || !aVar2.g().n) {
            return;
        }
        G.v("Dispatcher", "canceled", aVar2.i().d(), "from replaying");
    }

    public void p(com.squareup.picasso.c cVar) {
        if (p.shouldWriteToMemoryCache(cVar.n())) {
            this.k.b(cVar.l(), cVar.q());
        }
        this.e.remove(cVar.l());
        a(cVar);
        if (cVar.o().n) {
            G.v("Dispatcher", "batched", G.l(cVar), "for completion");
        }
    }

    public void q(com.squareup.picasso.c cVar, boolean z) {
        if (cVar.o().n) {
            String l = G.l(cVar);
            StringBuilder sb = new StringBuilder();
            sb.append("for error");
            sb.append(z ? " (will replay)" : "");
            G.v("Dispatcher", "batched", l, sb.toString());
        }
        this.e.remove(cVar.l());
        a(cVar);
    }

    public void r(NetworkInfo networkInfo) {
        v vVar = this.c;
        if (vVar instanceof v) {
            vVar.a(networkInfo);
        }
        if (networkInfo == null || !networkInfo.isConnected()) {
            return;
        }
        i();
    }

    public void s(Object obj) {
        if (this.h.add(obj)) {
            Iterator it = this.e.values().iterator();
            while (it.hasNext()) {
                com.squareup.picasso.c cVar = (com.squareup.picasso.c) it.next();
                boolean z = cVar.o().n;
                com.squareup.picasso.a h = cVar.h();
                List i = cVar.i();
                boolean z2 = (i == null || i.isEmpty()) ? false : true;
                if (h != null || z2) {
                    if (h != null && h.j().equals(obj)) {
                        cVar.f(h);
                        this.g.put(h.k(), h);
                        if (z) {
                            G.v("Dispatcher", "paused", h.b.d(), "because tag '" + obj + "' was paused");
                        }
                    }
                    if (z2) {
                        for (int size = i.size() - 1; size >= 0; size--) {
                            com.squareup.picasso.a aVar = (com.squareup.picasso.a) i.get(size);
                            if (aVar.j().equals(obj)) {
                                cVar.f(aVar);
                                this.g.put(aVar.k(), aVar);
                                if (z) {
                                    G.v("Dispatcher", "paused", aVar.b.d(), "because tag '" + obj + "' was paused");
                                }
                            }
                        }
                    }
                    if (cVar.c()) {
                        it.remove();
                        if (z) {
                            G.v("Dispatcher", "canceled", G.l(cVar), "all actions paused");
                        }
                    }
                }
            }
        }
    }

    public void t(Object obj) {
        if (this.h.remove(obj)) {
            Iterator it = this.g.values().iterator();
            ArrayList arrayList = null;
            while (it.hasNext()) {
                com.squareup.picasso.a aVar = (com.squareup.picasso.a) it.next();
                if (aVar.j().equals(obj)) {
                    if (arrayList == null) {
                        arrayList = new ArrayList();
                    }
                    arrayList.add(aVar);
                    it.remove();
                }
            }
            if (arrayList != null) {
                Handler handler = this.j;
                handler.sendMessage(handler.obtainMessage(13, arrayList));
            }
        }
    }

    public void u(com.squareup.picasso.c cVar) {
        if (cVar.s()) {
            return;
        }
        boolean z = false;
        if (this.c.isShutdown()) {
            q(cVar, false);
            return;
        }
        NetworkInfo activeNetworkInfo = this.o ? ((ConnectivityManager) G.p(this.b, "connectivity")).getActiveNetworkInfo() : null;
        boolean z2 = activeNetworkInfo != null && activeNetworkInfo.isConnected();
        boolean u = cVar.u(this.p, activeNetworkInfo);
        boolean v = cVar.v();
        if (!u) {
            if (this.o && v) {
                z = true;
            }
            q(cVar, z);
            if (z) {
                l(cVar);
                return;
            }
            return;
        }
        if (this.o && !z2) {
            q(cVar, v);
            if (v) {
                l(cVar);
                return;
            }
            return;
        }
        if (cVar.o().n) {
            G.u("Dispatcher", "retrying", G.l(cVar));
        }
        if (cVar.k() instanceof r.a) {
            cVar.j |= q.NO_CACHE.index;
        }
        cVar.o = this.c.submit(cVar);
    }

    public void v(com.squareup.picasso.a aVar) {
        w(aVar, true);
    }

    public void w(com.squareup.picasso.a aVar, boolean z) {
        if (this.h.contains(aVar.j())) {
            this.g.put(aVar.k(), aVar);
            if (aVar.g().n) {
                G.v("Dispatcher", "paused", aVar.b.d(), "because tag '" + aVar.j() + "' is paused");
                return;
            }
            return;
        }
        com.squareup.picasso.c cVar = (com.squareup.picasso.c) this.e.get(aVar.d());
        if (cVar != null) {
            cVar.b(aVar);
            return;
        }
        if (this.c.isShutdown()) {
            if (aVar.g().n) {
                G.v("Dispatcher", "ignored", aVar.b.d(), "because shut down");
                return;
            }
            return;
        }
        com.squareup.picasso.c g = com.squareup.picasso.c.g(aVar.g(), this, this.k, this.l, aVar);
        g.o = this.c.submit(g);
        this.e.put(aVar.d(), g);
        if (z) {
            this.f.remove(aVar.k());
        }
        if (aVar.g().n) {
            G.u("Dispatcher", "enqueued", aVar.b.d());
        }
    }
}
