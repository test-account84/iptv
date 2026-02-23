package kotlinx.coroutines.internal;

import G8.H;
import G8.P;
import G8.U0;
import G8.Z;
import G8.h0;
import java.util.concurrent.atomic.AtomicReferenceFieldUpdater;
import org.jetbrains.annotations.NotNull;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes4.dex */
public final class f extends Z implements q8.e, o8.d {
    public static final /* synthetic */ AtomicReferenceFieldUpdater i = AtomicReferenceFieldUpdater.newUpdater(f.class, Object.class, "_reusableCancellableContinuation");

    @NotNull
    private volatile /* synthetic */ Object _reusableCancellableContinuation;
    public final H e;
    public final o8.d f;
    public Object g;
    public final Object h;

    public f(H h, o8.d dVar) {
        super(-1);
        this.e = h;
        this.f = dVar;
        this.g = g.a();
        this.h = C.b(getContext());
        this._reusableCancellableContinuation = null;
    }

    public void a(Object obj, Throwable th) {
        if (obj instanceof G8.C) {
            ((G8.C) obj).b.invoke(th);
        }
    }

    public q8.e getCallerFrame() {
        o8.d dVar = this.f;
        if (dVar instanceof q8.e) {
            return (q8.e) dVar;
        }
        return null;
    }

    public o8.g getContext() {
        return this.f.getContext();
    }

    public Object h() {
        Object obj = this.g;
        this.g = g.a();
        return obj;
    }

    public final void i() {
        while (this._reusableCancellableContinuation == g.b) {
        }
    }

    public final G8.o j() {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            if (obj == null) {
                this._reusableCancellableContinuation = g.b;
                return null;
            }
            if (obj instanceof G8.o) {
                if (t.b.a(i, this, obj, g.b)) {
                    return (G8.o) obj;
                }
            } else if (obj != g.b && !(obj instanceof Throwable)) {
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        }
    }

    public final G8.o k() {
        Object obj = this._reusableCancellableContinuation;
        if (obj instanceof G8.o) {
            return (G8.o) obj;
        }
        return null;
    }

    public final boolean l() {
        return this._reusableCancellableContinuation != null;
    }

    public final boolean m(Throwable th) {
        while (true) {
            Object obj = this._reusableCancellableContinuation;
            y yVar = g.b;
            if (kotlin.jvm.internal.l.a(obj, yVar)) {
                if (t.b.a(i, this, yVar, th)) {
                    return true;
                }
            } else {
                if (obj instanceof Throwable) {
                    return true;
                }
                if (t.b.a(i, this, obj, (Object) null)) {
                    return false;
                }
            }
        }
    }

    public final void n() {
        i();
        G8.o k = k();
        if (k != null) {
            k.n();
        }
    }

    public final Throwable o(G8.n nVar) {
        y yVar;
        do {
            Object obj = this._reusableCancellableContinuation;
            yVar = g.b;
            if (obj != yVar) {
                if (obj instanceof Throwable) {
                    if (t.b.a(i, this, obj, (Object) null)) {
                        return (Throwable) obj;
                    }
                    throw new IllegalArgumentException("Failed requirement.".toString());
                }
                throw new IllegalStateException(("Inconsistent state " + obj).toString());
            }
        } while (!t.b.a(i, this, yVar, nVar));
        return null;
    }

    public void resumeWith(Object obj) {
        o8.g context = this.f.getContext();
        Object d = G8.F.d(obj, null, 1, null);
        if (this.e.d0(context)) {
            this.g = d;
            this.d = 0;
            this.e.c0(context, this);
            return;
        }
        h0 b = U0.a.b();
        if (b.m0()) {
            this.g = d;
            this.d = 0;
            b.i0(this);
            return;
        }
        b.k0(true);
        try {
            o8.g context2 = getContext();
            Object c = C.c(context2, this.h);
            try {
                this.f.resumeWith(obj);
                k8.q qVar = k8.q.a;
                while (b.p0()) {
                }
            } finally {
                C.a(context2, c);
            }
        } finally {
            try {
            } finally {
            }
        }
    }

    public String toString() {
        return "DispatchedContinuation[" + this.e + ", " + P.c(this.f) + ']';
    }

    public o8.d c() {
        return this;
    }
}
