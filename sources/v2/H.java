package V2;

import O2.z0;
import P2.v0;
import V2.G;
import V2.g;
import V2.m;
import V2.o;
import V2.w;
import V2.y;
import android.media.ResourceBusyException;
import android.os.Handler;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import d4.k0;
import java.util.ArrayList;
import java.util.HashMap;
import java.util.HashSet;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.Set;
import java.util.UUID;
import s5.Z;
import s5.c0;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class h implements y {
    public final UUID c;
    public final G.c d;
    public final O e;
    public final HashMap f;
    public final boolean g;
    public final int[] h;
    public final boolean i;
    public final g j;
    public final b4.F k;
    public final h l;
    public final long m;
    public final List n;
    public final Set o;
    public final Set p;
    public int q;
    public G r;
    public V2.g s;
    public V2.g t;
    public Looper u;
    public Handler v;
    public int w;
    public byte[] x;
    public v0 y;
    public volatile d z;

    public static final class b {
        public boolean d;
        public boolean f;
        public final HashMap a = new HashMap();
        public UUID b = O2.o.d;
        public G.c c = L.d;
        public b4.F g = new b4.A();
        public int[] e = new int[0];
        public long h = 300000;

        public h a(O o) {
            return new h(this.b, this.c, o, this.a, this.d, this.e, this.f, this.g, this.h, null);
        }

        public b b(Map map) {
            this.a.clear();
            if (map != null) {
                this.a.putAll(map);
            }
            return this;
        }

        public b c(boolean z) {
            this.d = z;
            return this;
        }

        public b d(boolean z) {
            this.f = z;
            return this;
        }

        public b e(int... iArr) {
            for (int i : iArr) {
                boolean z = true;
                if (i != 2 && i != 1) {
                    z = false;
                }
                d4.a.a(z);
            }
            this.e = (int[]) iArr.clone();
            return this;
        }

        public b f(UUID uuid, G.c cVar) {
            this.b = (UUID) d4.a.e(uuid);
            this.c = (G.c) d4.a.e(cVar);
            return this;
        }
    }

    public class c implements G.b {
        public c() {
        }

        public void a(G g, byte[] bArr, int i, int i2, byte[] bArr2) {
            ((d) d4.a.e(h.this.z)).obtainMessage(i, bArr).sendToTarget();
        }

        public /* synthetic */ c(h hVar, a aVar) {
            this();
        }
    }

    public class d extends Handler {
        public d(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            byte[] bArr = (byte[]) message.obj;
            if (bArr == null) {
                return;
            }
            for (V2.g gVar : h.l(h.this)) {
                if (gVar.t(bArr)) {
                    gVar.B(message.what);
                    return;
                }
            }
        }
    }

    public static final class e extends Exception {
        public e(UUID uuid) {
            super("Media does not support uuid: " + uuid);
        }

        public /* synthetic */ e(UUID uuid, a aVar) {
            this(uuid);
        }
    }

    public class f implements y.b {
        public final w.a b;
        public o c;
        public boolean d;

        public f(w.a aVar) {
            this.b = aVar;
        }

        public static /* synthetic */ void a(f fVar, z0 z0Var) {
            fVar.d(z0Var);
        }

        public static /* synthetic */ void b(f fVar) {
            fVar.e();
        }

        public void c(z0 z0Var) {
            ((Handler) d4.a.e(h.o(h.this))).post(new i(this, z0Var));
        }

        public final /* synthetic */ void d(z0 z0Var) {
            if (h.p(h.this) == 0 || this.d) {
                return;
            }
            h hVar = h.this;
            this.c = h.k(hVar, (Looper) d4.a.e(h.j(hVar)), this.b, z0Var, false);
            h.i(h.this).add(this);
        }

        public final /* synthetic */ void e() {
            if (this.d) {
                return;
            }
            o oVar = this.c;
            if (oVar != null) {
                oVar.f(this.b);
            }
            h.i(h.this).remove(this);
            this.d = true;
        }

        public void release() {
            k0.Y0((Handler) d4.a.e(h.o(h.this)), new j(this));
        }
    }

    public class g implements g.a {
        public final Set a = new HashSet();
        public V2.g b;

        public g() {
        }

        public void a(V2.g gVar) {
            this.a.add(gVar);
            if (this.b != null) {
                return;
            }
            this.b = gVar;
            gVar.H();
        }

        public void b(Exception exc, boolean z) {
            this.b = null;
            s5.y r = s5.y.r(this.a);
            this.a.clear();
            c0 l = r.l();
            while (l.hasNext()) {
                ((V2.g) l.next()).D(exc, z);
            }
        }

        public void c() {
            this.b = null;
            s5.y r = s5.y.r(this.a);
            this.a.clear();
            c0 l = r.l();
            while (l.hasNext()) {
                ((V2.g) l.next()).C();
            }
        }

        public void d(V2.g gVar) {
            this.a.remove(gVar);
            if (this.b == gVar) {
                this.b = null;
                if (this.a.isEmpty()) {
                    return;
                }
                V2.g gVar2 = (V2.g) this.a.iterator().next();
                this.b = gVar2;
                gVar2.H();
            }
        }
    }

    public class h implements g.b {
        public h() {
        }

        public static /* synthetic */ void c(V2.g gVar) {
            d(gVar);
        }

        public static /* synthetic */ void d(V2.g gVar) {
            gVar.f(null);
        }

        public void a(V2.g gVar, int i) {
            if (h.m(h.this) != -9223372036854775807L) {
                h.n(h.this).remove(gVar);
                ((Handler) d4.a.e(h.o(h.this))).removeCallbacksAndMessages(gVar);
            }
        }

        public void b(V2.g gVar, int i) {
            if (i == 1 && h.p(h.this) > 0 && h.m(h.this) != -9223372036854775807L) {
                h.n(h.this).add(gVar);
                ((Handler) d4.a.e(h.o(h.this))).postAtTime(new k(gVar), gVar, SystemClock.uptimeMillis() + h.m(h.this));
            } else if (i == 0) {
                h.l(h.this).remove(gVar);
                if (h.q(h.this) == gVar) {
                    h.r(h.this, null);
                }
                if (h.e(h.this) == gVar) {
                    h.f(h.this, null);
                }
                h.g(h.this).d(gVar);
                if (h.m(h.this) != -9223372036854775807L) {
                    ((Handler) d4.a.e(h.o(h.this))).removeCallbacksAndMessages(gVar);
                    h.n(h.this).remove(gVar);
                }
            }
            h.h(h.this);
        }

        public /* synthetic */ h(h hVar, a aVar) {
            this();
        }
    }

    public h(UUID uuid, G.c cVar, O o, HashMap hashMap, boolean z, int[] iArr, boolean z2, b4.F f2, long j) {
        d4.a.e(uuid);
        d4.a.b(!O2.o.b.equals(uuid), "Use C.CLEARKEY_UUID instead");
        this.c = uuid;
        this.d = cVar;
        this.e = o;
        this.f = hashMap;
        this.g = z;
        this.h = iArr;
        this.i = z2;
        this.k = f2;
        this.j = new g();
        this.l = new h(this, null);
        this.w = 0;
        this.n = new ArrayList();
        this.o = Z.h();
        this.p = Z.h();
        this.m = j;
    }

    public static /* synthetic */ V2.g e(h hVar) {
        return hVar.t;
    }

    public static /* synthetic */ V2.g f(h hVar, V2.g gVar) {
        hVar.t = gVar;
        return gVar;
    }

    public static /* synthetic */ g g(h hVar) {
        return hVar.j;
    }

    public static /* synthetic */ void h(h hVar) {
        hVar.B();
    }

    public static /* synthetic */ Set i(h hVar) {
        return hVar.o;
    }

    public static /* synthetic */ Looper j(h hVar) {
        return hVar.u;
    }

    public static /* synthetic */ o k(h hVar, Looper looper, w.a aVar, z0 z0Var, boolean z) {
        return hVar.s(looper, aVar, z0Var, z);
    }

    public static /* synthetic */ List l(h hVar) {
        return hVar.n;
    }

    public static /* synthetic */ long m(h hVar) {
        return hVar.m;
    }

    public static /* synthetic */ Set n(h hVar) {
        return hVar.p;
    }

    public static /* synthetic */ Handler o(h hVar) {
        return hVar.v;
    }

    public static /* synthetic */ int p(h hVar) {
        return hVar.q;
    }

    public static /* synthetic */ V2.g q(h hVar) {
        return hVar.s;
    }

    public static /* synthetic */ V2.g r(h hVar, V2.g gVar) {
        hVar.s = gVar;
        return gVar;
    }

    public static boolean t(o oVar) {
        return oVar.getState() == 1 && (k0.a < 19 || (((o.a) d4.a.e(oVar.getError())).getCause() instanceof ResourceBusyException));
    }

    public static List x(m mVar, UUID uuid, boolean z) {
        ArrayList arrayList = new ArrayList(mVar.e);
        for (int i = 0; i < mVar.e; i++) {
            m.b f2 = mVar.f(i);
            if ((f2.e(uuid) || (O2.o.c.equals(uuid) && f2.e(O2.o.b))) && (f2.f != null || z)) {
                arrayList.add(f2);
            }
        }
        return arrayList;
    }

    public final void A(Looper looper) {
        if (this.z == null) {
            this.z = new d(looper);
        }
    }

    public final void B() {
        if (this.r != null && this.q == 0 && this.n.isEmpty() && this.o.isEmpty()) {
            ((G) d4.a.e(this.r)).release();
            this.r = null;
        }
    }

    public final void C() {
        c0 l = s5.C.r(this.p).l();
        while (l.hasNext()) {
            ((o) l.next()).f(null);
        }
    }

    public final void D() {
        c0 l = s5.C.r(this.o).l();
        while (l.hasNext()) {
            ((f) l.next()).release();
        }
    }

    public void E(int i, byte[] bArr) {
        d4.a.g(this.n.isEmpty());
        if (i == 1 || i == 3) {
            d4.a.e(bArr);
        }
        this.w = i;
        this.x = bArr;
    }

    public final void F(o oVar, w.a aVar) {
        oVar.f(aVar);
        if (this.m != -9223372036854775807L) {
            oVar.f(null);
        }
    }

    public final void G(boolean z) {
        if (z && this.u == null) {
            d4.B.k("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed before setPlayer(), possibly on the wrong thread.", new IllegalStateException());
            return;
        }
        if (Thread.currentThread() != ((Looper) d4.a.e(this.u)).getThread()) {
            d4.B.k("DefaultDrmSessionMgr", "DefaultDrmSessionManager accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.u.getThread().getName(), new IllegalStateException());
        }
    }

    public int a(z0 z0Var) {
        G(false);
        int h2 = ((G) d4.a.e(this.r)).h();
        m mVar = z0Var.p;
        if (mVar != null) {
            if (u(mVar)) {
                return h2;
            }
            return 1;
        }
        if (k0.K0(this.h, d4.F.k(z0Var.m)) != -1) {
            return h2;
        }
        return 0;
    }

    public void b(Looper looper, v0 v0Var) {
        y(looper);
        this.y = v0Var;
    }

    public o c(w.a aVar, z0 z0Var) {
        G(false);
        d4.a.g(this.q > 0);
        d4.a.i(this.u);
        return s(this.u, aVar, z0Var, true);
    }

    public y.b d(w.a aVar, z0 z0Var) {
        d4.a.g(this.q > 0);
        d4.a.i(this.u);
        f fVar = new f(aVar);
        fVar.c(z0Var);
        return fVar;
    }

    public final void prepare() {
        G(true);
        int i = this.q;
        this.q = i + 1;
        if (i != 0) {
            return;
        }
        if (this.r == null) {
            G a2 = this.d.a(this.c);
            this.r = a2;
            a2.d(new c(this, null));
        } else if (this.m != -9223372036854775807L) {
            for (int i2 = 0; i2 < this.n.size(); i2++) {
                ((V2.g) this.n.get(i2)).g(null);
            }
        }
    }

    public final void release() {
        G(true);
        int i = this.q - 1;
        this.q = i;
        if (i != 0) {
            return;
        }
        if (this.m != -9223372036854775807L) {
            ArrayList arrayList = new ArrayList(this.n);
            for (int i2 = 0; i2 < arrayList.size(); i2++) {
                ((V2.g) arrayList.get(i2)).f(null);
            }
        }
        D();
        B();
    }

    public final o s(Looper looper, w.a aVar, z0 z0Var, boolean z) {
        List list;
        A(looper);
        m mVar = z0Var.p;
        if (mVar == null) {
            return z(d4.F.k(z0Var.m), z);
        }
        V2.g gVar = null;
        if (this.x == null) {
            list = x((m) d4.a.e(mVar), this.c, false);
            if (list.isEmpty()) {
                e eVar = new e(this.c, null);
                d4.B.e("DefaultDrmSessionMgr", "DRM error", eVar);
                if (aVar != null) {
                    aVar.l(eVar);
                }
                return new E(new o.a(eVar, 6003));
            }
        } else {
            list = null;
        }
        if (this.g) {
            Iterator it = this.n.iterator();
            while (true) {
                if (!it.hasNext()) {
                    break;
                }
                V2.g gVar2 = (V2.g) it.next();
                if (k0.c(gVar2.a, list)) {
                    gVar = gVar2;
                    break;
                }
            }
        } else {
            gVar = this.t;
        }
        if (gVar == null) {
            gVar = w(list, false, aVar, z);
            if (!this.g) {
                this.t = gVar;
            }
            this.n.add(gVar);
        } else {
            gVar.g(aVar);
        }
        return gVar;
    }

    public final boolean u(m mVar) {
        if (this.x != null) {
            return true;
        }
        if (x(mVar, this.c, true).isEmpty()) {
            if (mVar.e != 1 || !mVar.f(0).e(O2.o.b)) {
                return false;
            }
            d4.B.j("DefaultDrmSessionMgr", "DrmInitData only contains common PSSH SchemeData. Assuming support for: " + this.c);
        }
        String str = mVar.d;
        if (str == null || "cenc".equals(str)) {
            return true;
        }
        return "cbcs".equals(str) ? k0.a >= 25 : ("cbc1".equals(str) || "cens".equals(str)) ? false : true;
    }

    public final V2.g v(List list, boolean z, w.a aVar) {
        d4.a.e(this.r);
        V2.g gVar = new V2.g(this.c, this.r, this.j, this.l, list, this.w, this.i | z, z, this.x, this.f, this.e, (Looper) d4.a.e(this.u), this.k, (v0) d4.a.e(this.y));
        gVar.g(aVar);
        if (this.m != -9223372036854775807L) {
            gVar.g(null);
        }
        return gVar;
    }

    public final V2.g w(List list, boolean z, w.a aVar, boolean z2) {
        V2.g v = v(list, z, aVar);
        if (t(v) && !this.p.isEmpty()) {
            C();
            F(v, aVar);
            v = v(list, z, aVar);
        }
        if (!t(v) || !z2 || this.o.isEmpty()) {
            return v;
        }
        D();
        if (!this.p.isEmpty()) {
            C();
        }
        F(v, aVar);
        return v(list, z, aVar);
    }

    public final synchronized void y(Looper looper) {
        try {
            Looper looper2 = this.u;
            if (looper2 == null) {
                this.u = looper;
                this.v = new Handler(looper);
            } else {
                d4.a.g(looper2 == looper);
                d4.a.e(this.v);
            }
        } catch (Throwable th) {
            throw th;
        }
    }

    public final o z(int i, boolean z) {
        G g2 = (G) d4.a.e(this.r);
        if ((g2.h() == 2 && H.d) || k0.K0(this.h, i) == -1 || g2.h() == 1) {
            return null;
        }
        V2.g gVar = this.s;
        if (gVar == null) {
            V2.g w = w(s5.y.z(), true, null, z);
            this.n.add(w);
            this.s = w;
        } else {
            gVar.g(null);
        }
        return this.s;
    }

    public /* synthetic */ h(UUID uuid, G.c cVar, O o, HashMap hashMap, boolean z, int[] iArr, boolean z2, b4.F f2, long j, a aVar) {
        this(uuid, cVar, o, hashMap, z, iArr, z2, f2, j);
    }
}
