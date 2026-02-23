package i7;

import android.content.Context;
import android.util.Log;
import android.view.View;
import java.util.List;
import java.util.concurrent.CopyOnWriteArrayList;
import n4.p;
import n4.r;
import o4.e;
import o4.y;
import org.json.JSONObject;
import p4.i;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes.dex */
public class b {
    public static b l;
    public final Context a;
    public final List b = new CopyOnWriteArrayList();
    public final Object c = new Object();
    public final y d;
    public final i.a e;
    public int f;
    public boolean g;
    public p h;
    public p i;
    public d j;
    public boolean k;

    public class b extends i.a {
        public b() {
        }

        public void d() {
            r l;
            i c = b.c(b.this);
            if (c == null || (l = c.l()) == null) {
                return;
            }
            b.e(b.this, l.Y(l.V()));
            Log.d("QueueDataProvider", "onRemoteMediaPreloadStatusUpdated() with item=" + b.d(b.this));
            if (b.b(b.this) != null) {
                b.b(b.this).a();
            }
        }

        public void e() {
            o();
            if (b.b(b.this) != null) {
                b.b(b.this).a();
            }
            Log.d("QueueDataProvider", "Queue was updated");
        }

        public void g() {
            o();
            if (b.b(b.this) != null) {
                b.b(b.this).a();
            }
        }

        public final void o() {
            List list;
            b bVar;
            boolean z;
            r l;
            i c = b.c(b.this);
            if (c == null || (l = c.l()) == null) {
                list = null;
            } else {
                list = l.a0();
                b.f(b.this, l.b0());
                b.g(b.this, l.Y(l.K()));
            }
            b.h(b.this).clear();
            if (list == null) {
                Log.d("QueueDataProvider", "Queue is cleared");
                return;
            }
            Log.d("QueueDataProvider", "Queue is updated with a list of size: " + list.size());
            if (list.size() > 0) {
                b.h(b.this).addAll(list);
                bVar = b.this;
                z = false;
            } else {
                bVar = b.this;
                z = true;
            }
            b.i(bVar, z);
        }

        public /* synthetic */ b(b bVar, a aVar) {
            this();
        }
    }

    public class c implements y {
        public c() {
        }

        /* renamed from: a, reason: merged with bridge method [inline-methods] */
        public void onSessionEnded(e eVar, int i) {
            b.this.j();
            if (b.b(b.this) != null) {
                b.b(b.this).a();
            }
        }

        /* renamed from: d, reason: merged with bridge method [inline-methods] */
        public void onSessionResumed(e eVar, boolean z) {
            b.a(b.this);
        }

        /* renamed from: g, reason: merged with bridge method [inline-methods] */
        public void onSessionStarted(e eVar, String str) {
            b.a(b.this);
        }

        public /* synthetic */ c(b bVar, a aVar) {
            this();
        }

        /* renamed from: b, reason: merged with bridge method [inline-methods] */
        public void onSessionEnding(e eVar) {
        }

        /* renamed from: h, reason: merged with bridge method [inline-methods] */
        public void onSessionStarting(e eVar) {
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void onSessionResumeFailed(e eVar, int i) {
        }

        /* renamed from: e, reason: merged with bridge method [inline-methods] */
        public void onSessionResuming(e eVar, String str) {
        }

        /* renamed from: f, reason: merged with bridge method [inline-methods] */
        public void onSessionStartFailed(e eVar, int i) {
        }

        /* renamed from: i, reason: merged with bridge method [inline-methods] */
        public void onSessionSuspended(e eVar, int i) {
        }
    }

    public interface d {
        void a();
    }

    public b(Context context) {
        c cVar = new c(this, null);
        this.d = cVar;
        this.e = new b(this, null);
        this.k = true;
        Context applicationContext = context.getApplicationContext();
        this.a = applicationContext;
        this.f = 0;
        this.g = false;
        this.h = null;
        o4.b.e(applicationContext).c().a(cVar, e.class);
        A();
    }

    public static /* synthetic */ void a(b bVar) {
        bVar.A();
    }

    public static /* synthetic */ d b(b bVar) {
        return bVar.j;
    }

    public static /* synthetic */ i c(b bVar) {
        return bVar.r();
    }

    public static /* synthetic */ p d(b bVar) {
        return bVar.i;
    }

    public static /* synthetic */ p e(b bVar, p pVar) {
        bVar.i = pVar;
        return pVar;
    }

    public static /* synthetic */ int f(b bVar, int i) {
        bVar.f = i;
        return i;
    }

    public static /* synthetic */ p g(b bVar, p pVar) {
        bVar.h = pVar;
        return pVar;
    }

    public static /* synthetic */ List h(b bVar) {
        return bVar.b;
    }

    public static /* synthetic */ boolean i(b bVar, boolean z) {
        bVar.k = z;
        return z;
    }

    public static synchronized b n(Context context) {
        b bVar;
        synchronized (b.class) {
            try {
                if (l == null) {
                    l = new b(context);
                }
                bVar = l;
            } catch (Throwable th) {
                throw th;
            }
        }
        return bVar;
    }

    public final void A() {
        List a0;
        i r = r();
        if (r != null) {
            r.N(this.e);
            r l2 = r.l();
            if (l2 == null || (a0 = l2.a0()) == null || a0.isEmpty()) {
                return;
            }
            this.b.clear();
            this.b.addAll(a0);
            this.f = l2.b0();
            this.h = l2.Y(l2.K());
            this.k = false;
            this.i = l2.Y(l2.V());
        }
    }

    public void j() {
        this.b.clear();
        this.k = true;
        this.h = null;
    }

    public int k() {
        return this.b.size();
    }

    public p l() {
        return this.h;
    }

    public int m() {
        return this.h.K();
    }

    public p o(int i) {
        return (p) this.b.get(i);
    }

    public List p() {
        return this.b;
    }

    public int q(int i) {
        if (this.b.isEmpty()) {
            return -1;
        }
        for (int i2 = 0; i2 < this.b.size(); i2++) {
            if (((p) this.b.get(i2)).K() == i) {
                return i2;
            }
        }
        return -1;
    }

    public final i r() {
        e c2 = o4.b.e(this.a).c().c();
        if (c2 != null && c2.c()) {
            return c2.r();
        }
        Log.w("QueueDataProvider", "Trying to get a RemoteMediaClient when no CastSession is started.");
        return null;
    }

    public p s() {
        Log.d("QueueDataProvider", "[upcoming] getUpcomingItem() returning " + this.i);
        return this.i;
    }

    public boolean t() {
        return this.k;
    }

    public void u(int i, int i2) {
        i r;
        if (i == i2 || (r = r()) == null) {
            return;
        }
        r.I(((p) this.b.get(i)).K(), i2, (JSONObject) null);
        this.b.add(i2, (p) this.b.remove(i));
    }

    public void v(View view, p pVar) {
        i r = r();
        if (r == null) {
            return;
        }
        r.F(pVar.K(), (JSONObject) null);
    }

    public void w(View view, p pVar) {
        i r = r();
        if (r == null) {
            return;
        }
        int q = q(pVar.K());
        int k = k() - q;
        int[] iArr = new int[k];
        for (int i = 0; i < k; i++) {
            iArr[i] = ((p) this.b.get(i + q)).K();
        }
        r.M(iArr, (JSONObject) null);
    }

    public void x() {
        synchronized (this.c) {
            try {
                if (this.b.isEmpty()) {
                    return;
                }
                i r = r();
                if (r == null) {
                    return;
                }
                int[] iArr = new int[this.b.size()];
                for (int i = 0; i < this.b.size(); i++) {
                    iArr[i] = ((p) this.b.get(i)).K();
                }
                r.M(iArr, (JSONObject) null);
                this.b.clear();
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void y(int i) {
        synchronized (this.c) {
            try {
                i r = r();
                if (r == null) {
                    return;
                }
                r.L(((p) this.b.get(i)).K(), (JSONObject) null);
            } catch (Throwable th) {
                throw th;
            }
        }
    }

    public void z(d dVar) {
        this.j = dVar;
    }
}
