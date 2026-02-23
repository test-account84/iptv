package G8;

import G8.x0;
import java.util.concurrent.CancellationException;
import java.util.concurrent.atomic.AtomicIntegerFieldUpdater;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public class o extends Z implements n, q8.e {
    public static final /* synthetic */ AtomicIntegerFieldUpdater h = AtomicIntegerFieldUpdater.newUpdater(o.class, "_decision");
    public static final /* synthetic */ AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(o.class, Object.class, "_state");

    @NotNull
    private volatile /* synthetic */ int _decision;

    @NotNull
    private volatile /* synthetic */ Object _state;
    public final o8.d e;
    public final o8.g f;
    public d0 g;

    public o(o8.d dVar, int i2) {
        super(i2);
        this.e = dVar;
        this.f = dVar.getContext();
        this._decision = 0;
        this._state = d.a;
    }

    private final boolean A() {
        return a0.c(this.d) && ((kotlinx.coroutines.internal.f) this.e).l();
    }

    public static /* synthetic */ void I(o oVar, Object obj, int i2, w8.l lVar, int i3, Object obj2) {
        if (obj2 != null) {
            throw new UnsupportedOperationException("Super calls with default arguments not supported in this target, function: resumeImpl");
        }
        if ((i3 & 4) != 0) {
            lVar = null;
        }
        oVar.H(obj, i2, lVar);
    }

    public final l B(w8.l lVar) {
        return lVar instanceof l ? (l) lVar : new u0(lVar);
    }

    public final void C(w8.l lVar, Object obj) {
        throw new IllegalStateException(("It's prohibited to register multiple handlers, tried to register " + lVar + ", already has " + obj).toString());
    }

    public String D() {
        return "CancellableContinuation";
    }

    public final void E(Throwable th) {
        if (m(th)) {
            return;
        }
        b(th);
        o();
    }

    public final void F() {
        Throwable o;
        o8.d dVar = this.e;
        kotlinx.coroutines.internal.f fVar = dVar instanceof kotlinx.coroutines.internal.f ? (kotlinx.coroutines.internal.f) dVar : null;
        if (fVar == null || (o = fVar.o(this)) == null) {
            return;
        }
        n();
        b(o);
    }

    public final boolean G() {
        Object obj = this._state;
        if ((obj instanceof A) && ((A) obj).d != null) {
            n();
            return false;
        }
        this._decision = 0;
        this._state = d.a;
        return true;
    }

    public final void H(Object obj, int i2, w8.l lVar) {
        Object obj2;
        do {
            obj2 = this._state;
            if (!(obj2 instanceof L0)) {
                if (obj2 instanceof r) {
                    r rVar = (r) obj2;
                    if (rVar.c()) {
                        if (lVar != null) {
                            l(lVar, rVar.a);
                            return;
                        }
                        return;
                    }
                }
                i(obj);
                throw new k8.c();
            }
        } while (!t.b.a(i, this, obj2, J((L0) obj2, obj, i2, lVar, null)));
        o();
        p(i2);
    }

    public final Object J(L0 l0, Object obj, int i2, w8.l lVar, Object obj2) {
        if (obj instanceof B) {
            return obj;
        }
        if (!a0.b(i2) && obj2 == null) {
            return obj;
        }
        if (lVar != null || (((l0 instanceof l) && !(l0 instanceof f)) || obj2 != null)) {
            return new A(obj, l0 instanceof l ? (l) l0 : null, lVar, obj2, null, 16, null);
        }
        return obj;
    }

    public final boolean K() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 1) {
                    return false;
                }
                throw new IllegalStateException("Already resumed".toString());
            }
        } while (!h.compareAndSet(this, 0, 2));
        return true;
    }

    public final kotlinx.coroutines.internal.y L(Object obj, Object obj2, w8.l lVar) {
        Object obj3;
        do {
            obj3 = this._state;
            if (!(obj3 instanceof L0)) {
                if ((obj3 instanceof A) && obj2 != null && ((A) obj3).d == obj2) {
                    return p.a;
                }
                return null;
            }
        } while (!t.b.a(i, this, obj3, J((L0) obj3, obj, this.d, lVar, obj2)));
        o();
        return p.a;
    }

    public final boolean M() {
        do {
            int i2 = this._decision;
            if (i2 != 0) {
                if (i2 == 2) {
                    return false;
                }
                throw new IllegalStateException("Already suspended".toString());
            }
        } while (!h.compareAndSet(this, 0, 1));
        return true;
    }

    public void a(Object obj, Throwable th) {
        while (true) {
            Object obj2 = this._state;
            if (obj2 instanceof L0) {
                throw new IllegalStateException("Not completed".toString());
            }
            if (obj2 instanceof B) {
                return;
            }
            if (obj2 instanceof A) {
                A a = (A) obj2;
                if (!(!a.c())) {
                    throw new IllegalStateException("Must be called at most once".toString());
                }
                if (t.b.a(i, this, obj2, A.b(a, null, null, null, null, th, 15, null))) {
                    a.d(this, th);
                    return;
                }
            } else if (t.b.a(i, this, obj2, new A(obj2, null, null, null, th, 14, null))) {
                return;
            }
        }
    }

    public boolean b(Throwable th) {
        Object obj;
        boolean z;
        do {
            obj = this._state;
            if (!(obj instanceof L0)) {
                return false;
            }
            z = obj instanceof l;
        } while (!t.b.a(i, this, obj, new r(this, th, z)));
        l lVar = z ? (l) obj : null;
        if (lVar != null) {
            j(lVar, th);
        }
        o();
        p(this.d);
        return true;
    }

    public final o8.d c() {
        return this.e;
    }

    public Throwable d(Object obj) {
        Throwable d = super.d(obj);
        if (d != null) {
            return d;
        }
        return null;
    }

    public Object e(Object obj) {
        return obj instanceof A ? ((A) obj).a : obj;
    }

    public Object f(Object obj, Object obj2, w8.l lVar) {
        return L(obj, obj2, lVar);
    }

    public q8.e getCallerFrame() {
        o8.d dVar = this.e;
        if (dVar instanceof q8.e) {
            return (q8.e) dVar;
        }
        return null;
    }

    public o8.g getContext() {
        return this.f;
    }

    public Object h() {
        return s();
    }

    public final Void i(Object obj) {
        throw new IllegalStateException(("Already resumed, but proposed with update " + obj).toString());
    }

    public final void j(l lVar, Throwable th) {
        try {
            lVar.a(th);
        } catch (Throwable th2) {
            K.a(getContext(), new E("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void k(w8.l lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            K.a(getContext(), new E("Exception in invokeOnCancellation handler for " + this, th2));
        }
    }

    public final void l(w8.l lVar, Throwable th) {
        try {
            lVar.invoke(th);
        } catch (Throwable th2) {
            K.a(getContext(), new E("Exception in resume onCancellation handler for " + this, th2));
        }
    }

    public final boolean m(Throwable th) {
        if (A()) {
            return ((kotlinx.coroutines.internal.f) this.e).m(th);
        }
        return false;
    }

    public final void n() {
        d0 d0Var = this.g;
        if (d0Var == null) {
            return;
        }
        d0Var.dispose();
        this.g = K0.a;
    }

    public final void o() {
        if (A()) {
            return;
        }
        n();
    }

    public final void p(int i2) {
        if (K()) {
            return;
        }
        a0.a(this, i2);
    }

    public Throwable q(x0 x0Var) {
        return x0Var.h();
    }

    public final Object r() {
        x0 x0Var;
        boolean A = A();
        if (M()) {
            if (this.g == null) {
                w();
            }
            if (A) {
                F();
            }
            return p8.c.d();
        }
        if (A) {
            F();
        }
        Object s = s();
        if (s instanceof B) {
            throw ((B) s).a;
        }
        if (!a0.b(this.d) || (x0Var = (x0) getContext().a(x0.b0)) == null || x0Var.isActive()) {
            return e(s);
        }
        CancellationException h2 = x0Var.h();
        a(s, h2);
        throw h2;
    }

    public void resumeWith(Object obj) {
        I(this, F.b(obj, this), this.d, null, 4, null);
    }

    public final Object s() {
        return this._state;
    }

    public final String t() {
        Object s = s();
        return s instanceof L0 ? "Active" : s instanceof r ? "Cancelled" : "Completed";
    }

    public String toString() {
        return D() + '(' + P.c(this.e) + "){" + t() + "}@" + P.b(this);
    }

    public void u(Object obj, w8.l lVar) {
        H(obj, this.d, lVar);
    }

    public void v() {
        d0 w = w();
        if (w != null && z()) {
            w.dispose();
            this.g = K0.a;
        }
    }

    public final d0 w() {
        x0 x0Var = (x0) getContext().a(x0.b0);
        if (x0Var == null) {
            return null;
        }
        d0 d = x0.a.d(x0Var, true, false, new s(this), 2, null);
        this.g = d;
        return d;
    }

    public void x(w8.l lVar) {
        l B = B(lVar);
        while (true) {
            Object obj = this._state;
            if (obj instanceof d) {
                if (t.b.a(i, this, obj, B)) {
                    return;
                }
            } else if (obj instanceof l) {
                C(lVar, obj);
            } else {
                if (obj instanceof B) {
                    B b = (B) obj;
                    if (!b.b()) {
                        C(lVar, obj);
                    }
                    if (obj instanceof r) {
                        if (!(obj instanceof B)) {
                            b = null;
                        }
                        k(lVar, b != null ? b.a : null);
                        return;
                    }
                    return;
                }
                if (obj instanceof A) {
                    A a = (A) obj;
                    if (a.b != null) {
                        C(lVar, obj);
                    }
                    if (B instanceof f) {
                        return;
                    }
                    if (a.c()) {
                        k(lVar, a.e);
                        return;
                    } else {
                        if (t.b.a(i, this, obj, A.b(a, null, B, null, null, null, 29, null))) {
                            return;
                        }
                    }
                } else {
                    if (B instanceof f) {
                        return;
                    }
                    if (t.b.a(i, this, obj, new A(obj, B, null, null, null, 28, null))) {
                        return;
                    }
                }
            }
        }
    }

    public void y(Object obj) {
        p(this.d);
    }

    public boolean z() {
        return !(s() instanceof L0);
    }
}
