package z3;

import A3.d;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import b4.o;
import c4.c;
import d4.k0;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.concurrent.CopyOnWriteArraySet;
import java.util.concurrent.Executor;
import z3.A;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class s {
    public static final A3.c q = new A3.c(1);
    public final Context a;
    public final I b;
    public final Handler c;
    public final c d;
    public final d.c e;
    public final CopyOnWriteArraySet f;
    public int g;
    public int h;
    public boolean i;
    public boolean j;
    public int k;
    public int l;
    public int m;
    public boolean n;
    public List o;
    public A3.d p;

    public static final class b {
        public final z3.c a;
        public final boolean b;
        public final List c;
        public final Exception d;

        public b(z3.c cVar, boolean z, List list, Exception exc) {
            this.a = cVar;
            this.b = z;
            this.c = list;
            this.d = exc;
        }
    }

    public static final class c extends Handler {
        public boolean a;
        public final HandlerThread b;
        public final I c;
        public final B d;
        public final Handler e;
        public final ArrayList f;
        public final HashMap g;
        public int h;
        public boolean i;
        public int j;
        public int k;
        public int l;
        public boolean m;

        public c(HandlerThread handlerThread, I i, B b, Handler handler, int i2, int i3, boolean z) {
            super(handlerThread.getLooper());
            this.b = handlerThread;
            this.c = i;
            this.d = b;
            this.e = handler;
            this.j = i2;
            this.k = i3;
            this.i = z;
            this.f = new ArrayList();
            this.g = new HashMap();
        }

        public static /* synthetic */ int a(z3.c cVar, z3.c cVar2) {
            return d(cVar, cVar2);
        }

        public static int d(z3.c cVar, z3.c cVar2) {
            return k0.p(cVar.c, cVar2.c);
        }

        public static z3.c e(z3.c cVar, int i, int i2) {
            return new z3.c(cVar.a, i, cVar.c, System.currentTimeMillis(), cVar.e, i2, 0, cVar.h);
        }

        public final void A(e eVar) {
            if (eVar != null) {
                d4.a.g(!e.b(eVar));
                eVar.f(false);
            }
        }

        public final void B() {
            int i = 0;
            for (int i2 = 0; i2 < this.f.size(); i2++) {
                z3.c cVar = (z3.c) this.f.get(i2);
                e eVar = (e) this.g.get(cVar.a.a);
                int i3 = cVar.b;
                if (i3 == 0) {
                    eVar = y(eVar, cVar);
                } else if (i3 == 1) {
                    A(eVar);
                } else if (i3 == 2) {
                    d4.a.e(eVar);
                    x(eVar, cVar, i);
                } else {
                    if (i3 != 5 && i3 != 7) {
                        throw new IllegalStateException();
                    }
                    z(eVar, cVar);
                }
                if (eVar != null && !e.b(eVar)) {
                    i++;
                }
            }
        }

        public final void C() {
            for (int i = 0; i < this.f.size(); i++) {
                z3.c cVar = (z3.c) this.f.get(i);
                if (cVar.b == 2) {
                    try {
                        this.c.e(cVar);
                    } catch (IOException e) {
                        d4.B.e("DownloadManager", "Failed to update index.", e);
                    }
                }
            }
            sendEmptyMessageDelayed(11, 5000L);
        }

        public final void b(w wVar, int i) {
            z3.c f = f(wVar.a, true);
            long currentTimeMillis = System.currentTimeMillis();
            if (f != null) {
                m(s.n(f, wVar, i, currentTimeMillis));
            } else {
                m(new z3.c(wVar, i != 0 ? 1 : 0, currentTimeMillis, currentTimeMillis, -1L, i, 0));
            }
            B();
        }

        public final boolean c() {
            return !this.i && this.h == 0;
        }

        public final z3.c f(String str, boolean z) {
            int g = g(str);
            if (g != -1) {
                return (z3.c) this.f.get(g);
            }
            if (!z) {
                return null;
            }
            try {
                return this.c.h(str);
            } catch (IOException e) {
                d4.B.e("DownloadManager", "Failed to load download: " + str, e);
                return null;
            }
        }

        public final int g(String str) {
            for (int i = 0; i < this.f.size(); i++) {
                if (((z3.c) this.f.get(i)).a.a.equals(str)) {
                    return i;
                }
            }
            return -1;
        }

        public final void h(int i) {
            this.h = i;
            z3.e eVar = null;
            try {
                try {
                    this.c.g();
                    eVar = this.c.d(0, 1, 2, 5, 7);
                    while (eVar.a0()) {
                        this.f.add(eVar.J());
                    }
                } catch (IOException e) {
                    d4.B.e("DownloadManager", "Failed to load index.", e);
                    this.f.clear();
                }
                this.e.obtainMessage(0, new ArrayList(this.f)).sendToTarget();
                B();
            } finally {
                k0.o(eVar);
            }
        }

        public void handleMessage(Message message) {
            int i = 0;
            switch (message.what) {
                case 0:
                    h(message.arg1);
                    i = 1;
                    this.e.obtainMessage(1, i, this.g.size()).sendToTarget();
                    return;
                case 1:
                    r(message.arg1 != 0);
                    i = 1;
                    this.e.obtainMessage(1, i, this.g.size()).sendToTarget();
                    return;
                case 2:
                    u(message.arg1);
                    i = 1;
                    this.e.obtainMessage(1, i, this.g.size()).sendToTarget();
                    return;
                case 3:
                    v((String) message.obj, message.arg1);
                    i = 1;
                    this.e.obtainMessage(1, i, this.g.size()).sendToTarget();
                    return;
                case 4:
                    s(message.arg1);
                    i = 1;
                    this.e.obtainMessage(1, i, this.g.size()).sendToTarget();
                    return;
                case 5:
                    t(message.arg1);
                    i = 1;
                    this.e.obtainMessage(1, i, this.g.size()).sendToTarget();
                    return;
                case 6:
                    b((w) message.obj, message.arg1);
                    i = 1;
                    this.e.obtainMessage(1, i, this.g.size()).sendToTarget();
                    return;
                case 7:
                    q((String) message.obj);
                    i = 1;
                    this.e.obtainMessage(1, i, this.g.size()).sendToTarget();
                    return;
                case 8:
                    p();
                    i = 1;
                    this.e.obtainMessage(1, i, this.g.size()).sendToTarget();
                    return;
                case 9:
                    l((e) message.obj);
                    this.e.obtainMessage(1, i, this.g.size()).sendToTarget();
                    return;
                case 10:
                    i((e) message.obj, k0.t1(message.arg1, message.arg2));
                    return;
                case 11:
                    C();
                    return;
                case 12:
                    o();
                    return;
                default:
                    throw new IllegalStateException();
            }
        }

        public final void i(e eVar, long j) {
            z3.c cVar = (z3.c) d4.a.e(f(e.c(eVar).a, false));
            if (j == cVar.e || j == -1) {
                return;
            }
            m(new z3.c(cVar.a, cVar.b, cVar.c, System.currentTimeMillis(), j, cVar.f, cVar.g, cVar.h));
        }

        public final void j(z3.c cVar, Exception exc) {
            z3.c cVar2 = new z3.c(cVar.a, exc == null ? 3 : 4, cVar.c, System.currentTimeMillis(), cVar.e, cVar.f, exc == null ? 0 : 1, cVar.h);
            this.f.remove(g(cVar2.a.a));
            try {
                this.c.e(cVar2);
            } catch (IOException e) {
                d4.B.e("DownloadManager", "Failed to update index.", e);
            }
            this.e.obtainMessage(2, new b(cVar2, false, new ArrayList(this.f), exc)).sendToTarget();
        }

        public final void k(z3.c cVar) {
            if (cVar.b == 7) {
                int i = cVar.f;
                n(cVar, i == 0 ? 0 : 1, i);
                B();
            } else {
                this.f.remove(g(cVar.a.a));
                try {
                    this.c.b(cVar.a.a);
                } catch (IOException unused) {
                    d4.B.d("DownloadManager", "Failed to remove from database");
                }
                this.e.obtainMessage(2, new b(cVar, true, new ArrayList(this.f), null)).sendToTarget();
            }
        }

        public final void l(e eVar) {
            String str = e.c(eVar).a;
            this.g.remove(str);
            boolean b = e.b(eVar);
            if (b) {
                this.m = false;
            } else {
                int i = this.l - 1;
                this.l = i;
                if (i == 0) {
                    removeMessages(11);
                }
            }
            if (e.d(eVar)) {
                B();
                return;
            }
            Exception e = e.e(eVar);
            if (e != null) {
                d4.B.e("DownloadManager", "Task failed: " + e.c(eVar) + ", " + b, e);
            }
            z3.c cVar = (z3.c) d4.a.e(f(str, false));
            int i2 = cVar.b;
            if (i2 == 2) {
                d4.a.g(!b);
                j(cVar, e);
            } else {
                if (i2 != 5 && i2 != 7) {
                    throw new IllegalStateException();
                }
                d4.a.g(b);
                k(cVar);
            }
            B();
        }

        /* JADX WARN: Can't wrap try/catch for region: R(10:0|1|(1:24)(1:5)|6|(1:8)(8:18|(1:20)|21|(1:23)|10|11|12|13)|9|10|11|12|13) */
        /* JADX WARN: Code restructure failed: missing block: B:16:0x0052, code lost:
        
            r0 = move-exception;
         */
        /* JADX WARN: Code restructure failed: missing block: B:17:0x0053, code lost:
        
            d4.B.e("DownloadManager", "Failed to update index.", r0);
         */
        /*
            Code decompiled incorrectly, please refer to instructions dump.
            To view partially-correct code enable 'Show inconsistent code' option in preferences
        */
        public final z3.c m(z3.c r9) {
            /*
                r8 = this;
                int r0 = r9.b
                r1 = 3
                r2 = 1
                r3 = 0
                if (r0 == r1) goto Lc
                r1 = 4
                if (r0 == r1) goto Lc
                r0 = 1
                goto Ld
            Lc:
                r0 = 0
            Ld:
                d4.a.g(r0)
                z3.w r0 = r9.a
                java.lang.String r0 = r0.a
                int r0 = r8.g(r0)
                r1 = -1
                if (r0 != r1) goto L2b
                java.util.ArrayList r0 = r8.f
                r0.add(r9)
                java.util.ArrayList r0 = r8.f
                z3.t r1 = new z3.t
                r1.<init>()
            L27:
                java.util.Collections.sort(r0, r1)
                goto L4c
            L2b:
                long r4 = r9.c
                java.util.ArrayList r1 = r8.f
                java.lang.Object r1 = r1.get(r0)
                z3.c r1 = (z3.c) r1
                long r6 = r1.c
                int r1 = (r4 > r6 ? 1 : (r4 == r6 ? 0 : -1))
                if (r1 == 0) goto L3c
                goto L3d
            L3c:
                r2 = 0
            L3d:
                java.util.ArrayList r1 = r8.f
                r1.set(r0, r9)
                if (r2 == 0) goto L4c
                java.util.ArrayList r0 = r8.f
                z3.t r1 = new z3.t
                r1.<init>()
                goto L27
            L4c:
                z3.I r0 = r8.c     // Catch: java.io.IOException -> L52
                r0.e(r9)     // Catch: java.io.IOException -> L52
                goto L5a
            L52:
                r0 = move-exception
                java.lang.String r1 = "DownloadManager"
                java.lang.String r2 = "Failed to update index."
                d4.B.e(r1, r2, r0)
            L5a:
                z3.s$b r0 = new z3.s$b
                java.util.ArrayList r1 = new java.util.ArrayList
                java.util.ArrayList r2 = r8.f
                r1.<init>(r2)
                r2 = 0
                r0.<init>(r9, r3, r1, r2)
                android.os.Handler r1 = r8.e
                r2 = 2
                android.os.Message r0 = r1.obtainMessage(r2, r0)
                r0.sendToTarget()
                return r9
            */
            throw new UnsupportedOperationException("Method not decompiled: z3.s.c.m(z3.c):z3.c");
        }

        public final z3.c n(z3.c cVar, int i, int i2) {
            d4.a.g((i == 3 || i == 4) ? false : true);
            return m(e(cVar, i, i2));
        }

        public final void o() {
            Iterator it = this.g.values().iterator();
            while (it.hasNext()) {
                ((e) it.next()).f(true);
            }
            try {
                this.c.g();
            } catch (IOException e) {
                d4.B.e("DownloadManager", "Failed to update index.", e);
            }
            this.f.clear();
            this.b.quit();
            synchronized (this) {
                this.a = true;
                notifyAll();
            }
        }

        public final void p() {
            ArrayList arrayList = new ArrayList();
            try {
                z3.e d = this.c.d(3, 4);
                while (d.a0()) {
                    try {
                        arrayList.add(d.J());
                    } finally {
                    }
                }
                d.close();
            } catch (IOException unused) {
                d4.B.d("DownloadManager", "Failed to load downloads.");
            }
            for (int i = 0; i < this.f.size(); i++) {
                ArrayList arrayList2 = this.f;
                arrayList2.set(i, e((z3.c) arrayList2.get(i), 5, 0));
            }
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                this.f.add(e((z3.c) arrayList.get(i2), 5, 0));
            }
            Collections.sort(this.f, new t());
            try {
                this.c.f();
            } catch (IOException e) {
                d4.B.e("DownloadManager", "Failed to update index.", e);
            }
            ArrayList arrayList3 = new ArrayList(this.f);
            for (int i3 = 0; i3 < this.f.size(); i3++) {
                this.e.obtainMessage(2, new b((z3.c) this.f.get(i3), false, arrayList3, null)).sendToTarget();
            }
            B();
        }

        public final void q(String str) {
            z3.c f = f(str, true);
            if (f != null) {
                n(f, 5, 0);
                B();
            } else {
                d4.B.d("DownloadManager", "Failed to remove nonexistent download: " + str);
            }
        }

        public final void r(boolean z) {
            this.i = z;
            B();
        }

        public final void s(int i) {
            this.j = i;
            B();
        }

        public final void t(int i) {
            this.k = i;
        }

        public final void u(int i) {
            this.h = i;
            B();
        }

        public final void v(String str, int i) {
            if (str == null) {
                for (int i2 = 0; i2 < this.f.size(); i2++) {
                    w((z3.c) this.f.get(i2), i);
                }
                try {
                    this.c.c(i);
                } catch (IOException e) {
                    d4.B.e("DownloadManager", "Failed to set manual stop reason", e);
                }
            } else {
                z3.c f = f(str, false);
                if (f != null) {
                    w(f, i);
                } else {
                    try {
                        this.c.a(str, i);
                    } catch (IOException e2) {
                        d4.B.e("DownloadManager", "Failed to set manual stop reason: " + str, e2);
                    }
                }
            }
            B();
        }

        public final void w(z3.c cVar, int i) {
            if (i == 0) {
                if (cVar.b == 1) {
                    n(cVar, 0, 0);
                }
            } else if (i != cVar.f) {
                int i2 = cVar.b;
                if (i2 == 0 || i2 == 2) {
                    i2 = 1;
                }
                m(new z3.c(cVar.a, i2, cVar.c, System.currentTimeMillis(), cVar.e, i, 0, cVar.h));
            }
        }

        public final void x(e eVar, z3.c cVar, int i) {
            d4.a.g(!e.b(eVar));
            if (!c() || i >= this.j) {
                n(cVar, 0, 0);
                eVar.f(false);
            }
        }

        public final e y(e eVar, z3.c cVar) {
            if (eVar != null) {
                d4.a.g(!e.b(eVar));
                eVar.f(false);
                return eVar;
            }
            if (!c() || this.l >= this.j) {
                return null;
            }
            z3.c n = n(cVar, 2, 0);
            e eVar2 = new e(n.a, this.d.a(n.a), n.h, false, this.k, this, null);
            this.g.put(n.a.a, eVar2);
            int i = this.l;
            this.l = i + 1;
            if (i == 0) {
                sendEmptyMessageDelayed(11, 5000L);
            }
            eVar2.start();
            return eVar2;
        }

        public final void z(e eVar, z3.c cVar) {
            if (eVar != null) {
                if (e.b(eVar)) {
                    return;
                }
                eVar.f(false);
            } else {
                if (this.m) {
                    return;
                }
                e eVar2 = new e(cVar.a, this.d.a(cVar.a), cVar.h, true, this.k, this, null);
                this.g.put(cVar.a.a, eVar2);
                this.m = true;
                eVar2.start();
            }
        }
    }

    public interface d {
        void a(s sVar, z3.c cVar, Exception exc);

        void b(s sVar, A3.c cVar, int i);

        void c(s sVar);

        void d(s sVar, z3.c cVar);

        void e(s sVar, boolean z);

        void f(s sVar, boolean z);

        void g(s sVar);
    }

    public static class e extends Thread implements A.a {
        public final w a;
        public final A c;
        public final v d;
        public final boolean e;
        public final int f;
        public volatile c g;
        public volatile boolean h;
        public Exception i;
        public long j;

        public e(w wVar, A a, v vVar, boolean z, int i, c cVar) {
            this.a = wVar;
            this.c = a;
            this.d = vVar;
            this.e = z;
            this.f = i;
            this.g = cVar;
            this.j = -1L;
        }

        public static /* synthetic */ boolean b(e eVar) {
            return eVar.e;
        }

        public static /* synthetic */ w c(e eVar) {
            return eVar.a;
        }

        public static /* synthetic */ boolean d(e eVar) {
            return eVar.h;
        }

        public static /* synthetic */ Exception e(e eVar) {
            return eVar.i;
        }

        public static int g(int i) {
            return Math.min((i - 1) * 1000, 5000);
        }

        public void a(long j, long j2, float f) {
            this.d.a = j2;
            this.d.b = f;
            if (j != this.j) {
                this.j = j;
                c cVar = this.g;
                if (cVar != null) {
                    cVar.obtainMessage(10, (int) (j >> 32), (int) j, this).sendToTarget();
                }
            }
        }

        public void f(boolean z) {
            if (z) {
                this.g = null;
            }
            if (this.h) {
                return;
            }
            this.h = true;
            this.c.cancel();
            interrupt();
        }

        public void run() {
            try {
                if (this.e) {
                    this.c.remove();
                } else {
                    long j = -1;
                    int i = 0;
                    while (!this.h) {
                        try {
                            this.c.a(this);
                            break;
                        } catch (IOException e) {
                            if (!this.h) {
                                long j2 = this.d.a;
                                if (j2 != j) {
                                    j = j2;
                                    i = 0;
                                }
                                i++;
                                if (i > this.f) {
                                    throw e;
                                }
                                Thread.sleep(g(i));
                            }
                        }
                    }
                }
            } catch (Exception e2) {
                this.i = e2;
            } catch (InterruptedException unused) {
                Thread.currentThread().interrupt();
            }
            c cVar = this.g;
            if (cVar != null) {
                cVar.obtainMessage(9, this).sendToTarget();
            }
        }

        public /* synthetic */ e(w wVar, A a, v vVar, boolean z, int i, c cVar, a aVar) {
            this(wVar, a, vVar, z, i, cVar);
        }
    }

    public s(Context context, T2.b bVar, c4.a aVar, o.a aVar2, Executor executor) {
        this(context, new z3.a(bVar), new z3.b(new c.c().i(aVar).l(aVar2), executor));
    }

    public static /* synthetic */ boolean a(s sVar, Message message) {
        return sVar.j(message);
    }

    public static /* synthetic */ void b(s sVar, A3.d dVar, int i) {
        sVar.s(dVar, i);
    }

    public static z3.c n(z3.c cVar, w wVar, int i, long j) {
        int i2 = cVar.b;
        return new z3.c(cVar.a.c(wVar), (i2 == 5 || i2 == 7) ? 7 : i != 0 ? 1 : 0, (i2 == 5 || cVar.c()) ? j : cVar.c, j, -1L, i, 0);
    }

    public void A(String str, int i) {
        this.g++;
        this.d.obtainMessage(3, i, 0, str).sendToTarget();
    }

    public final boolean B() {
        boolean z;
        if (this.j || this.m == 0) {
            z = false;
        } else {
            for (int i = 0; i < this.o.size(); i++) {
                if (((z3.c) this.o.get(i)).b == 0) {
                    z = true;
                    break;
                }
            }
            z = false;
        }
        boolean z2 = this.n != z;
        this.n = z;
        return z2;
    }

    public void c(w wVar, int i) {
        this.g++;
        this.d.obtainMessage(6, i, 0, wVar).sendToTarget();
    }

    public void d(d dVar) {
        d4.a.e(dVar);
        this.f.add(dVar);
    }

    public List e() {
        return this.o;
    }

    public p f() {
        return this.b;
    }

    public boolean g() {
        return this.j;
    }

    public int h() {
        return this.m;
    }

    public A3.c i() {
        return this.p.f();
    }

    public final boolean j(Message message) {
        int i = message.what;
        if (i == 0) {
            q((List) message.obj);
        } else if (i == 1) {
            r(message.arg1, message.arg2);
        } else {
            if (i != 2) {
                throw new IllegalStateException();
            }
            p((b) message.obj);
        }
        return true;
    }

    public boolean k() {
        return this.h == 0 && this.g == 0;
    }

    public boolean l() {
        return this.i;
    }

    public boolean m() {
        return this.n;
    }

    public final void o() {
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((d) it.next()).f(this, this.n);
        }
    }

    public final void p(b bVar) {
        this.o = Collections.unmodifiableList(bVar.c);
        z3.c cVar = bVar.a;
        boolean B = B();
        if (bVar.b) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((d) it.next()).d(this, cVar);
            }
        } else {
            Iterator it2 = this.f.iterator();
            while (it2.hasNext()) {
                ((d) it2.next()).a(this, cVar, bVar.d);
            }
        }
        if (B) {
            o();
        }
    }

    public final void q(List list) {
        this.i = true;
        this.o = Collections.unmodifiableList(list);
        boolean B = B();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((d) it.next()).g(this);
        }
        if (B) {
            o();
        }
    }

    public final void r(int i, int i2) {
        this.g -= i;
        this.h = i2;
        if (k()) {
            Iterator it = this.f.iterator();
            while (it.hasNext()) {
                ((d) it.next()).c(this);
            }
        }
    }

    public final void s(A3.d dVar, int i) {
        A3.c f = dVar.f();
        if (this.m != i) {
            this.m = i;
            this.g++;
            this.d.obtainMessage(2, i, 0).sendToTarget();
        }
        boolean B = B();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((d) it.next()).b(this, f, i);
        }
        if (B) {
            o();
        }
    }

    public void t() {
        x(true);
    }

    public void u() {
        this.g++;
        this.d.obtainMessage(8).sendToTarget();
    }

    public void v(String str) {
        this.g++;
        this.d.obtainMessage(7, str).sendToTarget();
    }

    public void w() {
        x(false);
    }

    public final void x(boolean z) {
        if (this.j == z) {
            return;
        }
        this.j = z;
        this.g++;
        this.d.obtainMessage(1, z ? 1 : 0, 0).sendToTarget();
        boolean B = B();
        Iterator it = this.f.iterator();
        while (it.hasNext()) {
            ((d) it.next()).e(this, z);
        }
        if (B) {
            o();
        }
    }

    public void y(int i) {
        d4.a.a(i > 0);
        if (this.k == i) {
            return;
        }
        this.k = i;
        this.g++;
        this.d.obtainMessage(4, i, 0).sendToTarget();
    }

    public void z(A3.c cVar) {
        if (cVar.equals(this.p.f())) {
            return;
        }
        this.p.j();
        A3.d dVar = new A3.d(this.a, this.e, cVar);
        this.p = dVar;
        s(this.p, dVar.i());
    }

    public s(Context context, I i, B b2) {
        this.a = context.getApplicationContext();
        this.b = i;
        this.k = 3;
        this.l = 5;
        this.j = true;
        this.o = Collections.emptyList();
        this.f = new CopyOnWriteArraySet();
        Handler A = k0.A(new q(this));
        this.c = A;
        HandlerThread handlerThread = new HandlerThread("ExoPlayer:DownloadManager");
        handlerThread.start();
        c cVar = new c(handlerThread, i, b2, A, this.k, this.l, this.j);
        this.d = cVar;
        r rVar = new r(this);
        this.e = rVar;
        A3.d dVar = new A3.d(context, rVar, q);
        this.p = dVar;
        int i2 = dVar.i();
        this.m = i2;
        this.g = 1;
        cVar.obtainMessage(0, i2, 0).sendToTarget();
    }
}
