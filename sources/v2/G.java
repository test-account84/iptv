package V2;

import P2.v0;
import V2.G;
import V2.o;
import V2.w;
import android.media.NotProvisionedException;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Looper;
import android.os.Message;
import android.os.SystemClock;
import android.util.Pair;
import b4.F;
import com.google.android.exoplayer2.decoder.CryptoConfig;
import d4.k0;
import java.io.IOException;
import java.util.Arrays;
import java.util.Collections;
import java.util.HashMap;
import java.util.Iterator;
import java.util.List;
import java.util.Map;
import java.util.UUID;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public class g implements o {
    public final List a;
    public final G b;
    public final a c;
    public final b d;
    public final int e;
    public final boolean f;
    public final boolean g;
    public final HashMap h;
    public final d4.j i;
    public final b4.F j;
    public final v0 k;
    public final O l;
    public final UUID m;
    public final Looper n;
    public final e o;
    public int p;
    public int q;
    public HandlerThread r;
    public c s;
    public CryptoConfig t;
    public o.a u;
    public byte[] v;
    public byte[] w;
    public G.a x;
    public G.d y;

    public interface a {
        void a(g gVar);

        void b(Exception exc, boolean z);

        void c();
    }

    public interface b {
        void a(g gVar, int i);

        void b(g gVar, int i);
    }

    public class c extends Handler {
        public boolean a;

        public c(Looper looper) {
            super(looper);
        }

        public final boolean a(Message message, P p) {
            d dVar = (d) message.obj;
            if (!dVar.b) {
                return false;
            }
            int i = dVar.e + 1;
            dVar.e = i;
            if (i > g.o(g.this).b(3)) {
                return false;
            }
            long c = g.o(g.this).c(new F.c(new B3.u(dVar.a, p.a, p.c, p.d, SystemClock.elapsedRealtime(), SystemClock.elapsedRealtime() - dVar.c, p.e), new B3.x(3), p.getCause() instanceof IOException ? (IOException) p.getCause() : new f(p.getCause()), dVar.e));
            if (c == -9223372036854775807L) {
                return false;
            }
            synchronized (this) {
                try {
                    if (this.a) {
                        return false;
                    }
                    sendMessageDelayed(Message.obtain(message), c);
                    return true;
                } catch (Throwable th) {
                    throw th;
                }
            }
        }

        public void b(int i, Object obj, boolean z) {
            obtainMessage(i, new d(B3.u.a(), z, SystemClock.elapsedRealtime(), obj)).sendToTarget();
        }

        public synchronized void c() {
            removeCallbacksAndMessages((Object) null);
            this.a = true;
        }

        /* JADX WARN: Multi-variable type inference failed */
        public void handleMessage(Message message) {
            Exception exc;
            d dVar = (d) message.obj;
            try {
                int i = message.what;
                if (i == 0) {
                    exc = g.n(g.this).a(g.m(g.this), (G.d) dVar.d);
                } else {
                    if (i != 1) {
                        throw new RuntimeException();
                    }
                    exc = g.n(g.this).b(g.m(g.this), (G.a) dVar.d);
                }
            } catch (Exception e) {
                d4.B.k("DefaultDrmSession", "Key/provisioning request produced an unexpected exception. Not retrying.", e);
                exc = e;
            } catch (P e2) {
                boolean a = a(message, e2);
                exc = e2;
                if (a) {
                    return;
                }
            }
            g.o(g.this).d(dVar.a);
            synchronized (this) {
                try {
                    if (!this.a) {
                        g.p(g.this).obtainMessage(message.what, Pair.create(dVar.d, exc)).sendToTarget();
                    }
                } finally {
                }
            }
        }
    }

    public static final class d {
        public final long a;
        public final boolean b;
        public final long c;
        public final Object d;
        public int e;

        public d(long j, boolean z, long j2, Object obj) {
            this.a = j;
            this.b = z;
            this.c = j2;
            this.d = obj;
        }
    }

    public class e extends Handler {
        public e(Looper looper) {
            super(looper);
        }

        public void handleMessage(Message message) {
            Pair pair = (Pair) message.obj;
            Object obj = pair.first;
            Object obj2 = pair.second;
            int i = message.what;
            if (i == 0) {
                g.k(g.this, obj, obj2);
            } else {
                if (i != 1) {
                    return;
                }
                g.l(g.this, obj, obj2);
            }
        }
    }

    public static final class f extends IOException {
        public f(Throwable th) {
            super(th);
        }
    }

    public g(UUID uuid, G g, a aVar, b bVar, List list, int i, boolean z, boolean z2, byte[] bArr, HashMap hashMap, O o, Looper looper, b4.F f2, v0 v0Var) {
        List unmodifiableList;
        if (i == 1 || i == 3) {
            d4.a.e(bArr);
        }
        this.m = uuid;
        this.c = aVar;
        this.d = bVar;
        this.b = g;
        this.e = i;
        this.f = z;
        this.g = z2;
        if (bArr != null) {
            this.w = bArr;
            unmodifiableList = null;
        } else {
            unmodifiableList = Collections.unmodifiableList((List) d4.a.e(list));
        }
        this.a = unmodifiableList;
        this.h = hashMap;
        this.l = o;
        this.i = new d4.j();
        this.j = f2;
        this.k = v0Var;
        this.p = 2;
        this.n = looper;
        this.o = new e(looper);
    }

    public static /* synthetic */ void i(Exception exc, w.a aVar) {
        v(exc, aVar);
    }

    public static /* synthetic */ void j(int i, w.a aVar) {
        w(i, aVar);
    }

    public static /* synthetic */ void k(g gVar, Object obj, Object obj2) {
        gVar.E(obj, obj2);
    }

    public static /* synthetic */ void l(g gVar, Object obj, Object obj2) {
        gVar.y(obj, obj2);
    }

    public static /* synthetic */ UUID m(g gVar) {
        return gVar.m;
    }

    public static /* synthetic */ O n(g gVar) {
        return gVar.l;
    }

    public static /* synthetic */ b4.F o(g gVar) {
        return gVar.j;
    }

    public static /* synthetic */ e p(g gVar) {
        return gVar.o;
    }

    public static /* synthetic */ void v(Exception exc, w.a aVar) {
        aVar.l(exc);
    }

    public static /* synthetic */ void w(int i, w.a aVar) {
        aVar.k(i);
    }

    public final void A() {
        if (this.e == 0 && this.p == 4) {
            k0.j(this.v);
            r(false);
        }
    }

    public void B(int i) {
        if (i != 2) {
            return;
        }
        A();
    }

    public void C() {
        if (F()) {
            r(true);
        }
    }

    public void D(Exception exc, boolean z) {
        x(exc, z ? 1 : 3);
    }

    public final void E(Object obj, Object obj2) {
        if (obj == this.y) {
            if (this.p == 2 || u()) {
                this.y = null;
                if (obj2 instanceof Exception) {
                    this.c.b((Exception) obj2, false);
                    return;
                }
                try {
                    this.b.g((byte[]) obj2);
                    this.c.c();
                } catch (Exception e2) {
                    this.c.b(e2, true);
                }
            }
        }
    }

    public final boolean F() {
        if (u()) {
            return true;
        }
        try {
            byte[] c2 = this.b.c();
            this.v = c2;
            this.b.e(c2, this.k);
            this.t = this.b.i(this.v);
            this.p = 3;
            q(new V2.b(3));
            d4.a.e(this.v);
            return true;
        } catch (NotProvisionedException unused) {
            this.c.a(this);
            return false;
        } catch (Exception e2) {
            x(e2, 1);
            return false;
        }
    }

    public final void G(byte[] bArr, int i, boolean z) {
        try {
            this.x = this.b.m(bArr, this.a, i, this.h);
            ((c) k0.j(this.s)).b(1, d4.a.e(this.x), z);
        } catch (Exception e2) {
            z(e2, true);
        }
    }

    public void H() {
        this.y = this.b.b();
        ((c) k0.j(this.s)).b(0, d4.a.e(this.y), true);
    }

    public final boolean I() {
        try {
            this.b.f(this.v, this.w);
            return true;
        } catch (Exception e2) {
            x(e2, 1);
            return false;
        }
    }

    public final void J() {
        if (Thread.currentThread() != this.n.getThread()) {
            d4.B.k("DefaultDrmSession", "DefaultDrmSession accessed on the wrong thread.\nCurrent thread: " + Thread.currentThread().getName() + "\nExpected thread: " + this.n.getThread().getName(), new IllegalStateException());
        }
    }

    public final UUID a() {
        J();
        return this.m;
    }

    public boolean b() {
        J();
        return this.f;
    }

    public byte[] c() {
        J();
        return this.w;
    }

    public final CryptoConfig d() {
        J();
        return this.t;
    }

    public Map e() {
        J();
        byte[] bArr = this.v;
        if (bArr == null) {
            return null;
        }
        return this.b.a(bArr);
    }

    public void f(w.a aVar) {
        J();
        int i = this.q;
        if (i <= 0) {
            d4.B.d("DefaultDrmSession", "release() called on a session that's already fully released.");
            return;
        }
        int i2 = i - 1;
        this.q = i2;
        if (i2 == 0) {
            this.p = 0;
            ((e) k0.j(this.o)).removeCallbacksAndMessages((Object) null);
            ((c) k0.j(this.s)).c();
            this.s = null;
            ((HandlerThread) k0.j(this.r)).quit();
            this.r = null;
            this.t = null;
            this.u = null;
            this.x = null;
            this.y = null;
            byte[] bArr = this.v;
            if (bArr != null) {
                this.b.k(bArr);
                this.v = null;
            }
        }
        if (aVar != null) {
            this.i.c(aVar);
            if (this.i.b(aVar) == 0) {
                aVar.m();
            }
        }
        this.d.b(this, this.q);
    }

    public void g(w.a aVar) {
        J();
        if (this.q < 0) {
            d4.B.d("DefaultDrmSession", "Session reference count less than zero: " + this.q);
            this.q = 0;
        }
        if (aVar != null) {
            this.i.a(aVar);
        }
        int i = this.q + 1;
        this.q = i;
        if (i == 1) {
            d4.a.g(this.p == 2);
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DrmRequestHandler");
            this.r = handlerThread;
            handlerThread.start();
            this.s = new c(this.r.getLooper());
            if (F()) {
                r(true);
            }
        } else if (aVar != null && u() && this.i.b(aVar) == 1) {
            aVar.k(this.p);
        }
        this.d.a(this, this.q);
    }

    public final o.a getError() {
        J();
        if (this.p == 1) {
            return this.u;
        }
        return null;
    }

    public final int getState() {
        J();
        return this.p;
    }

    public boolean h(String str) {
        J();
        return this.b.j((byte[]) d4.a.i(this.v), str);
    }

    public final void q(d4.i iVar) {
        Iterator it = this.i.v().iterator();
        while (it.hasNext()) {
            iVar.accept((w.a) it.next());
        }
    }

    public final void r(boolean z) {
        if (this.g) {
            return;
        }
        byte[] bArr = (byte[]) k0.j(this.v);
        int i = this.e;
        if (i == 0 || i == 1) {
            if (this.w == null) {
                G(bArr, 1, z);
                return;
            }
            if (this.p != 4 && !I()) {
                return;
            }
            long s = s();
            if (this.e != 0 || s > 60) {
                if (s <= 0) {
                    x(new N(), 2);
                    return;
                } else {
                    this.p = 4;
                    q(new V2.c());
                    return;
                }
            }
            d4.B.b("DefaultDrmSession", "Offline license has expired or will expire soon. Remaining seconds: " + s);
        } else {
            if (i != 2) {
                if (i != 3) {
                    return;
                }
                d4.a.e(this.w);
                d4.a.e(this.v);
                G(this.w, 3, z);
                return;
            }
            if (this.w != null && !I()) {
                return;
            }
        }
        G(bArr, 2, z);
    }

    public final long s() {
        if (!O2.o.d.equals(this.m)) {
            return Long.MAX_VALUE;
        }
        Pair pair = (Pair) d4.a.e(X.b(this));
        return Math.min(((Long) pair.first).longValue(), ((Long) pair.second).longValue());
    }

    public boolean t(byte[] bArr) {
        J();
        return Arrays.equals(this.v, bArr);
    }

    public final boolean u() {
        int i = this.p;
        return i == 3 || i == 4;
    }

    public final void x(Exception exc, int i) {
        this.u = new o.a(exc, C.a(exc, i));
        d4.B.e("DefaultDrmSession", "DRM session error", exc);
        q(new V2.d(exc));
        if (this.p != 4) {
            this.p = 1;
        }
    }

    public final void y(Object obj, Object obj2) {
        d4.i fVar;
        if (obj == this.x && u()) {
            this.x = null;
            if (obj2 instanceof Exception) {
                z((Exception) obj2, false);
                return;
            }
            try {
                byte[] bArr = (byte[]) obj2;
                if (this.e == 3) {
                    this.b.l((byte[]) k0.j(this.w), bArr);
                    fVar = new V2.e();
                } else {
                    byte[] l = this.b.l(this.v, bArr);
                    int i = this.e;
                    if ((i == 2 || (i == 0 && this.w != null)) && l != null && l.length != 0) {
                        this.w = l;
                    }
                    this.p = 4;
                    fVar = new V2.f();
                }
                q(fVar);
            } catch (Exception e2) {
                z(e2, true);
            }
        }
    }

    public final void z(Exception exc, boolean z) {
        if (exc instanceof NotProvisionedException) {
            this.c.a(this);
        } else {
            x(exc, z ? 1 : 2);
        }
    }
}
