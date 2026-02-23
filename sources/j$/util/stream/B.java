package j$.util.stream;

import j$.util.Objects;
import j$.util.Spliterator;
import java.util.function.IntFunction;
import java.util.function.Supplier;

/* loaded from: /storage/emulated/0/Android/data/com.apktools.app.decompile/files/decompile_temp/jadx/classes2.dex */
abstract class b implements h {
    private final b a;
    private final b b;
    protected final int c;
    private b d;
    private int e;
    private int f;
    private Spliterator g;
    private boolean h;
    private boolean i;
    private Runnable j;
    private boolean k;

    b(Spliterator spliterator, int i, boolean z) {
        this.b = null;
        this.g = spliterator;
        this.a = this;
        int i2 = e3.g & i;
        this.c = i2;
        this.f = (~(i2 << 1)) & e3.l;
        this.e = 0;
        this.k = z;
    }

    b(b bVar, int i) {
        if (bVar.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        bVar.h = true;
        bVar.d = this;
        this.b = bVar;
        this.c = e3.h & i;
        this.f = e3.i(i, bVar.f);
        b bVar2 = bVar.a;
        this.a = bVar2;
        if (Q()) {
            bVar2.i = true;
        }
        this.e = bVar.e + 1;
    }

    private Spliterator S(int i) {
        int i2;
        int i3;
        b bVar = this.a;
        Spliterator spliterator = bVar.g;
        if (spliterator == null) {
            throw new IllegalStateException("source already consumed or closed");
        }
        bVar.g = null;
        if (bVar.k && bVar.i) {
            b bVar2 = bVar.d;
            int i4 = 1;
            while (bVar != this) {
                int i5 = bVar2.c;
                if (bVar2.Q()) {
                    if (e3.SHORT_CIRCUIT.q(i5)) {
                        i5 &= ~e3.u;
                    }
                    spliterator = bVar2.P(bVar, spliterator);
                    if (spliterator.hasCharacteristics(64)) {
                        i2 = (~e3.t) & i5;
                        i3 = e3.s;
                    } else {
                        i2 = (~e3.s) & i5;
                        i3 = e3.t;
                    }
                    i5 = i2 | i3;
                    i4 = 0;
                }
                bVar2.e = i4;
                bVar2.f = e3.i(i5, bVar.f);
                i4++;
                b bVar3 = bVar2;
                bVar2 = bVar2.d;
                bVar = bVar3;
            }
        }
        if (i != 0) {
            this.f = e3.i(i, this.f);
        }
        return spliterator;
    }

    final void A(Spliterator spliterator, q2 q2Var) {
        Objects.requireNonNull(q2Var);
        if (e3.SHORT_CIRCUIT.q(this.f)) {
            B(spliterator, q2Var);
            return;
        }
        q2Var.m(spliterator.getExactSizeIfKnown());
        spliterator.forEachRemaining(q2Var);
        q2Var.l();
    }

    final boolean B(Spliterator spliterator, q2 q2Var) {
        b bVar = this;
        while (bVar.e > 0) {
            bVar = bVar.b;
        }
        q2Var.m(spliterator.getExactSizeIfKnown());
        boolean H = bVar.H(spliterator, q2Var);
        q2Var.l();
        return H;
    }

    final K0 C(Spliterator spliterator, boolean z, IntFunction intFunction) {
        if (this.a.k) {
            return F(this, spliterator, z, intFunction);
        }
        C0 N = N(G(spliterator), intFunction);
        V(spliterator, N);
        return N.a();
    }

    final Object D(K3 k3) {
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        return this.a.k ? k3.c(this, S(k3.d())) : k3.b(this, S(k3.d()));
    }

    final K0 E(IntFunction intFunction) {
        b bVar;
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        if (!this.a.k || (bVar = this.b) == null || !Q()) {
            return C(S(0), true, intFunction);
        }
        this.e = 0;
        return O(bVar, bVar.S(0), intFunction);
    }

    abstract K0 F(b bVar, Spliterator spliterator, boolean z, IntFunction intFunction);

    final long G(Spliterator spliterator) {
        if (e3.SIZED.q(this.f)) {
            return spliterator.getExactSizeIfKnown();
        }
        return -1L;
    }

    abstract boolean H(Spliterator spliterator, q2 q2Var);

    abstract f3 I();

    final f3 J() {
        b bVar = this;
        while (bVar.e > 0) {
            bVar = bVar.b;
        }
        return bVar.I();
    }

    final int K() {
        return this.f;
    }

    final boolean L() {
        return e3.ORDERED.q(this.f);
    }

    final /* synthetic */ Spliterator M() {
        return S(0);
    }

    abstract C0 N(long j, IntFunction intFunction);

    K0 O(b bVar, Spliterator spliterator, IntFunction intFunction) {
        throw new UnsupportedOperationException("Parallel evaluation is not supported");
    }

    Spliterator P(b bVar, Spliterator spliterator) {
        return O(bVar, spliterator, new q(15)).spliterator();
    }

    abstract boolean Q();

    abstract q2 R(int i, q2 q2Var);

    final Spliterator T() {
        b bVar = this.a;
        if (this != bVar) {
            throw new IllegalStateException();
        }
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        Spliterator spliterator = bVar.g;
        if (spliterator == null) {
            throw new IllegalStateException("source already consumed or closed");
        }
        bVar.g = null;
        return spliterator;
    }

    abstract Spliterator U(b bVar, Supplier supplier, boolean z);

    final q2 V(Spliterator spliterator, q2 q2Var) {
        A(spliterator, W((q2) Objects.requireNonNull(q2Var)));
        return q2Var;
    }

    final q2 W(q2 q2Var) {
        Objects.requireNonNull(q2Var);
        b bVar = this;
        while (bVar.e > 0) {
            b bVar2 = bVar.b;
            q2Var = bVar.R(bVar2.f, q2Var);
            bVar = bVar2;
        }
        return q2Var;
    }

    final Spliterator X(Spliterator spliterator) {
        return this.e == 0 ? spliterator : U(this, new a(spliterator, 6), this.a.k);
    }

    public final void close() {
        this.h = true;
        this.g = null;
        b bVar = this.a;
        Runnable runnable = bVar.j;
        if (runnable != null) {
            bVar.j = null;
            runnable.run();
        }
    }

    public final boolean isParallel() {
        return this.a.k;
    }

    public final h onClose(Runnable runnable) {
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        Objects.requireNonNull(runnable);
        b bVar = this.a;
        Runnable runnable2 = bVar.j;
        if (runnable2 != null) {
            runnable = new J3(runnable2, runnable);
        }
        bVar.j = runnable;
        return this;
    }

    public final h parallel() {
        this.a.k = true;
        return this;
    }

    public final h sequential() {
        this.a.k = false;
        return this;
    }

    public Spliterator spliterator() {
        if (this.h) {
            throw new IllegalStateException("stream has already been operated upon or closed");
        }
        this.h = true;
        b bVar = this.a;
        if (this != bVar) {
            return U(this, new a(this, 0), bVar.k);
        }
        Spliterator spliterator = bVar.g;
        if (spliterator == null) {
            throw new IllegalStateException("source already consumed or closed");
        }
        bVar.g = null;
        return spliterator;
    }
}
