package com.squareup.picasso;

import android.content.Context;
import android.graphics.Bitmap;
import android.net.Uri;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.Process;
import android.widget.ImageView;
import com.squareup.picasso.a;
import java.lang.ref.ReferenceQueue;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import java.util.Map;
import java.util.WeakHashMap;
import java.util.concurrent.ExecutorService;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class t {
    public static final Handler p = new a(Looper.getMainLooper());
    public static volatile t q = null;
    public final d a;
    public final g b;
    public final c c;
    public final List d;
    public final Context e;
    public final i f;
    public final com.squareup.picasso.d g;
    public final A h;
    public final Map i;
    public final Map j;
    public final ReferenceQueue k;
    public final Bitmap.Config l;
    public boolean m;
    public volatile boolean n;
    public boolean o;

    public static class a extends Handler {
        public a(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            int i = message.what;
            if (i == 3) {
                com.squareup.picasso.a aVar = (com.squareup.picasso.a) message.obj;
                if (aVar.g().n) {
                    G.v("Main", "canceled", aVar.b.d(), "target got garbage collected");
                }
                t.a(aVar.a, aVar.k());
                return;
            }
            int i2 = 0;
            if (i == 8) {
                List list = (List) message.obj;
                int size = list.size();
                while (i2 < size) {
                    com.squareup.picasso.c cVar = (com.squareup.picasso.c) list.get(i2);
                    cVar.c.e(cVar);
                    i2++;
                }
                return;
            }
            if (i != 13) {
                throw new AssertionError("Unknown handler message received: " + message.what);
            }
            List list2 = (List) message.obj;
            int size2 = list2.size();
            while (i2 < size2) {
                com.squareup.picasso.a aVar2 = (com.squareup.picasso.a) list2.get(i2);
                aVar2.a.n(aVar2);
                i2++;
            }
        }
    }

    public static class b {
        public final Context a;
        public j b;
        public ExecutorService c;
        public com.squareup.picasso.d d;
        public d e;
        public g f;
        public List g;
        public Bitmap.Config h;
        public boolean i;
        public boolean j;

        public b(Context context) {
            if (context == null) {
                throw new IllegalArgumentException("Context must not be null.");
            }
            this.a = context.getApplicationContext();
        }

        public t a() {
            Context context = this.a;
            if (this.b == null) {
                this.b = G.g(context);
            }
            if (this.d == null) {
                this.d = new m(context);
            }
            if (this.c == null) {
                this.c = new v();
            }
            if (this.f == null) {
                this.f = g.a;
            }
            A a = new A(this.d);
            return new t(context, new i(context, this.c, t.p, this.b, this.d, a), this.d, this.e, this.f, this.g, a, this.h, this.i, this.j);
        }

        public b b(j jVar) {
            if (jVar == null) {
                throw new IllegalArgumentException("Downloader must not be null.");
            }
            if (this.b != null) {
                throw new IllegalStateException("Downloader already set.");
            }
            this.b = jVar;
            return this;
        }

        public b c(d dVar) {
            if (dVar == null) {
                throw new IllegalArgumentException("Listener must not be null.");
            }
            if (this.e != null) {
                throw new IllegalStateException("Listener already set.");
            }
            this.e = dVar;
            return this;
        }
    }

    public static class c extends Thread {
        public final ReferenceQueue a;
        public final Handler c;

        public class a implements Runnable {
            public final /* synthetic */ Exception a;

            public a(Exception exc) {
                this.a = exc;
            }

            public void run() {
                throw new RuntimeException(this.a);
            }
        }

        public c(ReferenceQueue referenceQueue, Handler handler) {
            this.a = referenceQueue;
            this.c = handler;
            setDaemon(true);
            setName("Picasso-refQueue");
        }

        public void run() {
            Process.setThreadPriority(10);
            while (true) {
                try {
                    a.a remove = this.a.remove(1000L);
                    Message obtainMessage = this.c.obtainMessage();
                    if (remove != null) {
                        obtainMessage.what = 3;
                        obtainMessage.obj = remove.a;
                        this.c.sendMessage(obtainMessage);
                    } else {
                        obtainMessage.recycle();
                    }
                } catch (InterruptedException unused) {
                    return;
                } catch (Exception e) {
                    this.c.post(new a(e));
                    return;
                }
            }
        }
    }

    public interface d {
        void a(t tVar, Uri uri, Exception exc);
    }

    public enum e {
        MEMORY(-16711936),
        DISK(-16776961),
        NETWORK(-65536);

        final int debugColor;

        e(int i) {
            this.debugColor = i;
        }
    }

    public enum f {
        LOW,
        NORMAL,
        HIGH
    }

    public interface g {
        public static final g a = new a();

        public static class a implements g {
            public w a(w wVar) {
                return wVar;
            }
        }

        w a(w wVar);
    }

    public t(Context context, i iVar, com.squareup.picasso.d dVar, d dVar2, g gVar, List list, A a2, Bitmap.Config config, boolean z, boolean z2) {
        this.e = context;
        this.f = iVar;
        this.g = dVar;
        this.a = dVar2;
        this.b = gVar;
        this.l = config;
        ArrayList arrayList = new ArrayList((list != null ? list.size() : 0) + 7);
        arrayList.add(new z(context));
        if (list != null) {
            arrayList.addAll(list);
        }
        arrayList.add(new com.squareup.picasso.f(context));
        arrayList.add(new o(context));
        arrayList.add(new com.squareup.picasso.g(context));
        arrayList.add(new com.squareup.picasso.b(context));
        arrayList.add(new k(context));
        arrayList.add(new r(iVar.d, a2));
        this.d = Collections.unmodifiableList(arrayList);
        this.h = a2;
        this.i = new WeakHashMap();
        this.j = new WeakHashMap();
        this.m = z;
        this.n = z2;
        ReferenceQueue referenceQueue = new ReferenceQueue();
        this.k = referenceQueue;
        c cVar = new c(referenceQueue, p);
        this.c = cVar;
        cVar.start();
    }

    public static /* synthetic */ void a(t tVar, Object obj) {
        tVar.b(obj);
    }

    public static t q(Context context) {
        if (q == null) {
            synchronized (t.class) {
                try {
                    if (q == null) {
                        q = new b(context).a();
                    }
                } finally {
                }
            }
        }
        return q;
    }

    public final void b(Object obj) {
        G.c();
        com.squareup.picasso.a aVar = (com.squareup.picasso.a) this.i.remove(obj);
        if (aVar != null) {
            aVar.a();
            this.f.c(aVar);
        }
        if (obj instanceof ImageView) {
            h hVar = (h) this.j.remove((ImageView) obj);
            if (hVar != null) {
                hVar.a();
            }
        }
    }

    public void c(ImageView imageView) {
        b(imageView);
    }

    public void d(C c2) {
        b(c2);
    }

    public void e(com.squareup.picasso.c cVar) {
        com.squareup.picasso.a h = cVar.h();
        List i = cVar.i();
        boolean z = (i == null || i.isEmpty()) ? false : true;
        if (h != null || z) {
            Uri uri = cVar.j().d;
            Exception k = cVar.k();
            Bitmap q2 = cVar.q();
            e m = cVar.m();
            if (h != null) {
                g(q2, m, h);
            }
            if (z) {
                int size = i.size();
                for (int i2 = 0; i2 < size; i2++) {
                    g(q2, m, (com.squareup.picasso.a) i.get(i2));
                }
            }
            d dVar = this.a;
            if (dVar == null || k == null) {
                return;
            }
            dVar.a(this, uri, k);
        }
    }

    public void f(ImageView imageView, h hVar) {
        this.j.put(imageView, hVar);
    }

    public final void g(Bitmap bitmap, e eVar, com.squareup.picasso.a aVar) {
        if (aVar.l()) {
            return;
        }
        if (!aVar.m()) {
            this.i.remove(aVar.k());
        }
        if (bitmap == null) {
            aVar.c();
            if (this.n) {
                G.u("Main", "errored", aVar.b.d());
                return;
            }
            return;
        }
        if (eVar == null) {
            throw new AssertionError("LoadedFrom cannot be null.");
        }
        aVar.b(bitmap, eVar);
        if (this.n) {
            G.v("Main", "completed", aVar.b.d(), "from " + eVar);
        }
    }

    public void h(com.squareup.picasso.a aVar) {
        Object k = aVar.k();
        if (k != null && this.i.get(k) != aVar) {
            b(k);
            this.i.put(k, aVar);
        }
        o(aVar);
    }

    public List i() {
        return this.d;
    }

    public x j(int i) {
        if (i != 0) {
            return new x(this, null, i);
        }
        throw new IllegalArgumentException("Resource ID must not be zero.");
    }

    public x k(Uri uri) {
        return new x(this, uri, 0);
    }

    public x l(String str) {
        if (str == null) {
            return new x(this, null, 0);
        }
        if (str.trim().length() != 0) {
            return k(Uri.parse(str));
        }
        throw new IllegalArgumentException("Path must not be empty.");
    }

    public Bitmap m(String str) {
        Bitmap bitmap = this.g.get(str);
        A a2 = this.h;
        if (bitmap != null) {
            a2.d();
        } else {
            a2.e();
        }
        return bitmap;
    }

    public void n(com.squareup.picasso.a aVar) {
        Bitmap m = p.shouldReadFromMemoryCache(aVar.e) ? m(aVar.d()) : null;
        if (m == null) {
            h(aVar);
            if (this.n) {
                G.u("Main", "resumed", aVar.b.d());
                return;
            }
            return;
        }
        e eVar = e.MEMORY;
        g(m, eVar, aVar);
        if (this.n) {
            G.v("Main", "completed", aVar.b.d(), "from " + eVar);
        }
    }

    public void o(com.squareup.picasso.a aVar) {
        this.f.h(aVar);
    }

    public w p(w wVar) {
        w a2 = this.b.a(wVar);
        if (a2 != null) {
            return a2;
        }
        throw new IllegalStateException("Request transformer " + this.b.getClass().getCanonicalName() + " returned null for " + wVar);
    }
}
