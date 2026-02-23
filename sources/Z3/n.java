package z3;

import B3.C;
import B3.g0;
import B3.i0;
import B3.z;
import O2.C1;
import O2.E1;
import O2.G1;
import O2.H0;
import O2.Q1;
import O2.V1;
import O2.z0;
import P2.v0;
import Z3.m;
import Z3.s;
import Z3.u;
import android.content.Context;
import android.os.Handler;
import android.os.HandlerThread;
import android.os.Message;
import android.util.SparseIntArray;
import b4.S;
import b4.f;
import b4.o;
import d4.k0;
import java.io.IOException;
import java.lang.reflect.Array;
import java.util.ArrayList;
import java.util.Collections;
import java.util.List;
import s5.c0;
import z3.w;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes3.dex */
public final class n {
    public static final m.d o = m.d.y0.B().z0(true).u0(false).B();
    public final H0.h a;
    public final B3.C b;
    public final Z3.m c;
    public final E1[] d;
    public final SparseIntArray e;
    public final Handler f;
    public final Q1.d g;
    public boolean h;
    public c i;
    public g j;
    public i0[] k;
    public u.a[] l;
    public List[][] m;
    public List[][] n;

    public class a implements e4.A {
        public /* synthetic */ void H(z0 z0Var) {
            e4.p.i(this, z0Var);
        }

        public /* synthetic */ void c(String str) {
            e4.p.e(this, str);
        }

        public /* synthetic */ void d(String str, long j, long j2) {
            e4.p.d(this, str, j, j2);
        }

        public /* synthetic */ void h(U2.e eVar) {
            e4.p.f(this, eVar);
        }

        public /* synthetic */ void j(e4.C c) {
            e4.p.k(this, c);
        }

        public /* synthetic */ void m(Exception exc) {
            e4.p.c(this, exc);
        }

        public /* synthetic */ void p(U2.e eVar) {
            e4.p.g(this, eVar);
        }

        public /* synthetic */ void q(z0 z0Var, U2.h hVar) {
            e4.p.j(this, z0Var, hVar);
        }

        public /* synthetic */ void s(int i, long j) {
            e4.p.a(this, i, j);
        }

        public /* synthetic */ void v(Object obj, long j) {
            e4.p.b(this, obj, j);
        }

        public /* synthetic */ void y(long j, int i) {
            e4.p.h(this, j, i);
        }
    }

    public class b implements Q2.z {
        public /* synthetic */ void C(z0 z0Var) {
            Q2.o.f(this, z0Var);
        }

        public /* synthetic */ void a(boolean z) {
            Q2.o.k(this, z);
        }

        public /* synthetic */ void b(Exception exc) {
            Q2.o.i(this, exc);
        }

        public /* synthetic */ void f(String str) {
            Q2.o.c(this, str);
        }

        public /* synthetic */ void g(String str, long j, long j2) {
            Q2.o.b(this, str, j, j2);
        }

        public /* synthetic */ void i(U2.e eVar) {
            Q2.o.e(this, eVar);
        }

        public /* synthetic */ void l(long j) {
            Q2.o.h(this, j);
        }

        public /* synthetic */ void n(U2.e eVar) {
            Q2.o.d(this, eVar);
        }

        public /* synthetic */ void r(z0 z0Var, U2.h hVar) {
            Q2.o.g(this, z0Var, hVar);
        }

        public /* synthetic */ void w(Exception exc) {
            Q2.o.a(this, exc);
        }

        public /* synthetic */ void x(int i, long j, long j2) {
            Q2.o.j(this, i, j, j2);
        }
    }

    public interface c {
        void a(n nVar, IOException iOException);

        void c(n nVar);
    }

    public static final class e implements b4.f {
        public e() {
        }

        public /* synthetic */ long b() {
            return b4.d.a(this);
        }

        public S d() {
            return null;
        }

        public long e() {
            return 0L;
        }

        public /* synthetic */ e(a aVar) {
            this();
        }

        public void h(f.a aVar) {
        }

        public void g(Handler handler, f.a aVar) {
        }
    }

    public static class f extends IOException {
    }

    public static final class g implements C.c, z.a, Handler.Callback {
        public final B3.C a;
        public final n c;
        public final b4.b d = new b4.t(true, 65536);
        public final ArrayList e = new ArrayList();
        public final Handler f = k0.A(new o(this));
        public final HandlerThread g;
        public final Handler h;
        public Q1 i;
        public B3.z[] j;
        public boolean k;

        public g(B3.C c, n nVar) {
            this.a = c;
            this.c = nVar;
            HandlerThread handlerThread = new HandlerThread("ExoPlayer:DownloadHelper");
            this.g = handlerThread;
            handlerThread.start();
            Handler w = k0.w(handlerThread.getLooper(), this);
            this.h = w;
            w.sendEmptyMessage(0);
        }

        public static /* synthetic */ boolean a(g gVar, Message message) {
            return gVar.b(message);
        }

        public void J(B3.C c, Q1 q1) {
            B3.z[] zVarArr;
            if (this.i != null) {
                return;
            }
            if (q1.s(0, new Q1.d()).i()) {
                this.f.obtainMessage(1, new f()).sendToTarget();
                return;
            }
            this.i = q1;
            this.j = new B3.z[q1.n()];
            int i = 0;
            while (true) {
                zVarArr = this.j;
                if (i >= zVarArr.length) {
                    break;
                }
                B3.z E = this.a.E(new C.b(q1.r(i)), this.d, 0L);
                this.j[i] = E;
                this.e.add(E);
                i++;
            }
            for (B3.z zVar : zVarArr) {
                zVar.s(this, 0L);
            }
        }

        public final boolean b(Message message) {
            if (this.k) {
                return false;
            }
            int i = message.what;
            if (i == 0) {
                try {
                    n.h(this.c);
                } catch (O2.w e) {
                    this.f.obtainMessage(1, new IOException(e)).sendToTarget();
                }
                return true;
            }
            if (i != 1) {
                return false;
            }
            d();
            n.i(this.c, (IOException) k0.j(message.obj));
            return true;
        }

        /* renamed from: c, reason: merged with bridge method [inline-methods] */
        public void j(B3.z zVar) {
            if (this.e.contains(zVar)) {
                this.h.obtainMessage(2, zVar).sendToTarget();
            }
        }

        public void d() {
            if (this.k) {
                return;
            }
            this.k = true;
            this.h.sendEmptyMessage(3);
        }

        public void e(B3.z zVar) {
            this.e.remove(zVar);
            if (this.e.isEmpty()) {
                this.h.removeMessages(1);
                this.f.sendEmptyMessage(0);
            }
        }

        public boolean handleMessage(Message message) {
            int i = message.what;
            if (i == 0) {
                this.a.a(this, null, v0.b);
                this.h.sendEmptyMessage(1);
                return true;
            }
            int i2 = 0;
            if (i == 1) {
                try {
                    if (this.j == null) {
                        this.a.P();
                    } else {
                        while (i2 < this.e.size()) {
                            ((B3.z) this.e.get(i2)).p();
                            i2++;
                        }
                    }
                    this.h.sendEmptyMessageDelayed(1, 100L);
                } catch (IOException e) {
                    this.f.obtainMessage(1, e).sendToTarget();
                }
                return true;
            }
            if (i == 2) {
                B3.z zVar = (B3.z) message.obj;
                if (this.e.contains(zVar)) {
                    zVar.f(0L);
                }
                return true;
            }
            if (i != 3) {
                return false;
            }
            B3.z[] zVarArr = this.j;
            if (zVarArr != null) {
                int length = zVarArr.length;
                while (i2 < length) {
                    this.a.Y(zVarArr[i2]);
                    i2++;
                }
            }
            this.a.V(this);
            this.h.removeCallbacksAndMessages((Object) null);
            this.g.quit();
            return true;
        }
    }

    public n(H0 h0, B3.C c2, Z3.z zVar, E1[] e1Arr) {
        this.a = (H0.h) d4.a.e(h0.c);
        this.b = c2;
        Z3.m mVar = new Z3.m(zVar, new d.a(null));
        this.c = mVar;
        this.d = e1Arr;
        this.e = new SparseIntArray();
        mVar.e(new h(), new e(null));
        this.f = k0.z();
        this.g = new Q1.d();
    }

    public static /* synthetic */ void a(P3.f fVar) {
        z(fVar);
    }

    public static /* synthetic */ V2.y b(V2.y yVar, H0 h0) {
        return y(yVar, h0);
    }

    public static /* synthetic */ void c(n nVar, IOException iOException) {
        nVar.C(iOException);
    }

    public static /* synthetic */ void d() {
        B();
    }

    public static /* synthetic */ void e(q3.a aVar) {
        A(aVar);
    }

    public static /* synthetic */ void f(n nVar, c cVar) {
        nVar.E(cVar);
    }

    public static /* synthetic */ void g(n nVar) {
        nVar.D();
    }

    public static /* synthetic */ void h(n nVar) {
        nVar.G();
    }

    public static /* synthetic */ void i(n nVar, IOException iOException) {
        nVar.F(iOException);
    }

    public static B3.C n(H0 h0, o.a aVar, V2.y yVar) {
        B3.q qVar = new B3.q(aVar, d3.o.a);
        if (yVar != null) {
            qVar.d(new z3.g(yVar));
        }
        return qVar.b(h0);
    }

    public static n o(H0 h0, Z3.z zVar, G1 g1, o.a aVar, V2.y yVar) {
        boolean x = x((H0.h) d4.a.e(h0.c));
        d4.a.a(x || aVar != null);
        return new n(h0, x ? null : n(h0, (o.a) k0.j(aVar), yVar), zVar, g1 != null ? v(g1) : new E1[0]);
    }

    public static n p(Context context, H0 h0, G1 g1, o.a aVar) {
        return o(h0, q(context), g1, aVar, null);
    }

    public static m.d q(Context context) {
        return m.d.K(context).B().z0(true).u0(false).B();
    }

    public static E1[] v(G1 g1) {
        C1[] a2 = g1.a(k0.z(), new a(), new b(), new j(), new k());
        E1[] e1Arr = new E1[a2.length];
        for (int i = 0; i < a2.length; i++) {
            e1Arr[i] = a2[i].q();
        }
        return e1Arr;
    }

    public static boolean x(H0.h hVar) {
        return k0.y0(hVar.a, hVar.c) == 4;
    }

    public final /* synthetic */ void C(IOException iOException) {
        ((c) d4.a.e(this.i)).a(this, iOException);
    }

    public final /* synthetic */ void D() {
        ((c) d4.a.e(this.i)).c(this);
    }

    public final /* synthetic */ void E(c cVar) {
        cVar.c(this);
    }

    public final void F(IOException iOException) {
        ((Handler) d4.a.e(this.f)).post(new l(this, iOException));
    }

    public final void G() {
        d4.a.e(this.j);
        d4.a.e(this.j.j);
        d4.a.e(this.j.i);
        int length = this.j.j.length;
        int length2 = this.d.length;
        this.m = (List[][]) Array.newInstance(List.class, new int[]{length, length2});
        this.n = (List[][]) Array.newInstance(List.class, new int[]{length, length2});
        for (int i = 0; i < length; i++) {
            for (int i2 = 0; i2 < length2; i2++) {
                this.m[i][i2] = new ArrayList();
                this.n[i][i2] = Collections.unmodifiableList(this.m[i][i2]);
            }
        }
        this.k = new i0[length];
        this.l = new u.a[length];
        for (int i3 = 0; i3 < length; i3++) {
            this.k[i3] = this.j.j[i3].u();
            this.c.i(J(i3).e);
            this.l[i3] = (u.a) d4.a.e(this.c.o());
        }
        K();
        ((Handler) d4.a.e(this.f)).post(new m(this));
    }

    public void H(c cVar) {
        d4.a.g(this.i == null);
        this.i = cVar;
        B3.C c2 = this.b;
        if (c2 != null) {
            this.j = new g(c2, this);
        } else {
            this.f.post(new i(this, cVar));
        }
    }

    public void I() {
        g gVar = this.j;
        if (gVar != null) {
            gVar.d();
        }
        this.c.j();
    }

    public final Z3.D J(int i) {
        Z3.D k = this.c.k(this.d, this.k[i], new C.b(this.j.i.r(i)), this.j.i);
        for (int i2 = 0; i2 < k.a; i2++) {
            Z3.s sVar = k.c[i2];
            if (sVar != null) {
                List list = this.m[i][i2];
                int i3 = 0;
                while (true) {
                    if (i3 >= list.size()) {
                        list.add(sVar);
                        break;
                    }
                    Z3.s sVar2 = (Z3.s) list.get(i3);
                    if (sVar2.k().equals(sVar.k())) {
                        this.e.clear();
                        for (int i4 = 0; i4 < sVar2.length(); i4++) {
                            this.e.put(sVar2.d(i4), 0);
                        }
                        for (int i5 = 0; i5 < sVar.length(); i5++) {
                            this.e.put(sVar.d(i5), 0);
                        }
                        int[] iArr = new int[this.e.size()];
                        for (int i6 = 0; i6 < this.e.size(); i6++) {
                            iArr[i6] = this.e.keyAt(i6);
                        }
                        list.set(i3, new d(sVar2.k(), iArr));
                    } else {
                        i3++;
                    }
                }
            }
        }
        return k;
    }

    public final void K() {
        this.h = true;
    }

    public void j(int i, Z3.z zVar) {
        try {
            l();
            k(i, zVar);
        } catch (O2.w e2) {
            throw new IllegalStateException(e2);
        }
    }

    public final void k(int i, Z3.z zVar) {
        this.c.m(zVar);
        J(i);
        c0 l = zVar.z.values().l();
        while (l.hasNext()) {
            this.c.m(zVar.B().I((Z3.x) l.next()).B());
            J(i);
        }
    }

    public final void l() {
        d4.a.g(this.h);
    }

    public void m(int i) {
        l();
        for (int i2 = 0; i2 < this.d.length; i2++) {
            this.m[i][i2].clear();
        }
    }

    public w r(String str, byte[] bArr) {
        w.b e2 = new w.b(str, this.a.a).e(this.a.c);
        H0.f fVar = this.a.d;
        w.b c2 = e2.d(fVar != null ? fVar.e() : null).b(this.a.g).c(bArr);
        if (this.b == null) {
            return c2.a();
        }
        l();
        ArrayList arrayList = new ArrayList();
        List arrayList2 = new ArrayList();
        int length = this.m.length;
        for (int i = 0; i < length; i++) {
            arrayList2.clear();
            int length2 = this.m[i].length;
            for (int i2 = 0; i2 < length2; i2++) {
                arrayList2.addAll(this.m[i][i2]);
            }
            arrayList.addAll(this.j.j[i].k(arrayList2));
        }
        return c2.f(arrayList).a();
    }

    public w s(byte[] bArr) {
        return r(this.a.a.toString(), bArr);
    }

    public u.a t(int i) {
        l();
        return this.l[i];
    }

    public int u() {
        if (this.b == null) {
            return 0;
        }
        l();
        return this.k.length;
    }

    public V1 w(int i) {
        l();
        return Z3.A.b(this.l[i], this.n[i]);
    }

    public static /* synthetic */ void B() {
    }

    public static /* synthetic */ void A(q3.a aVar) {
    }

    public static /* synthetic */ void z(P3.f fVar) {
    }

    public static /* synthetic */ V2.y y(V2.y yVar, H0 h0) {
        return yVar;
    }

    public static final class d extends Z3.c {

        public static final class a implements s.b {
            public a() {
            }

            public Z3.s[] a(s.a[] aVarArr, b4.f fVar, C.b bVar, Q1 q1) {
                Z3.s[] sVarArr = new Z3.s[aVarArr.length];
                for (int i = 0; i < aVarArr.length; i++) {
                    s.a aVar = aVarArr[i];
                    sVarArr[i] = aVar == null ? null : new d(aVar.a, aVar.b);
                }
                return sVarArr;
            }

            public /* synthetic */ a(a aVar) {
                this();
            }
        }

        public d(g0 g0Var, int[] iArr) {
            super(g0Var, iArr);
        }

        public int b() {
            return 0;
        }

        public Object g() {
            return null;
        }

        public int q() {
            return 0;
        }

        public void r(long j, long j2, long j3, List list, D3.o[] oVarArr) {
        }
    }
}
